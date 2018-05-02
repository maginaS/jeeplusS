/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoyjbylsbpzyjkreport.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.jeeplus.common.config.Global;
import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.utils.DateUtils;
import com.jeeplus.common.utils.MyBeanUtils;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.common.utils.excel.ExportExcel;
import com.jeeplus.common.utils.excel.ImportExcel;
import com.jeeplus.common.web.BaseController;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.ironfodoctitle.service.IronfoDocTitleService;
import com.jeeplus.modules.report.ironfoyjbylsbpzyjkreport.entity.Ironfo_yjbylsbpz_yjkReport;
import com.jeeplus.modules.report.ironfoyjbylsbpzyjkreport.service.Ironfo_yjbylsbpz_yjkReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 *  药剂科Controller
 * @author anti_magina
 * @version 2018-04-20
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfoyjbylsbpzyjkreport/ironfo_yjbylsbpz_yjk")
public class Ironfo_yjbylsbpz_yjkReportController extends BaseController {

	@Autowired
	private Ironfo_yjbylsbpz_yjkReportService ironfo_yjbylsbpz_yjkService;
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	@ModelAttribute
	public Ironfo_yjbylsbpz_yjkReport get(@RequestParam(required=false) String id) {
		Ironfo_yjbylsbpz_yjkReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfo_yjbylsbpz_yjkService.get(id);
		}
		if (entity == null){
			entity = new Ironfo_yjbylsbpz_yjkReport();
		}
		return entity;
	}
	
	/**
	 *  药剂科列表页面
	 */
	@RequiresPermissions("ironfoyjbylsbpzyjkreport:ironfo_yjbylsbpz_yjk:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfo_yjbylsbpz_yjkReport ironfo_yjbylsbpz_yjk, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfo_yjbylsbpz_yjk.getDuser() != null&&ironfo_yjbylsbpz_yjk.getDuser().toString() != null && ironfo_yjbylsbpz_yjk.getDuser().toString().trim() != null
					&& !"".equals(ironfo_yjbylsbpz_yjk.getDuser().toString().trim())
					&& !"null".equals(ironfo_yjbylsbpz_yjk.getDuser().toString().trim())) {
				userId = ironfo_yjbylsbpz_yjk.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				
				ironfo_yjbylsbpz_yjk.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Page<Ironfo_yjbylsbpz_yjkReport> page = ironfo_yjbylsbpz_yjkService.findPage(new Page<Ironfo_yjbylsbpz_yjkReport>(request, response), ironfo_yjbylsbpz_yjk); 
		model.addAttribute("page", page);
		return "modules/report/ironfoyjbylsbpzyjkreport/ironfo_yjbylsbpz_yjkList";
	}

	/**
	 * 查看，增加，编辑 药剂科表单页面
	 */
	@RequiresPermissions(value={"ironfoyjbylsbpzyjkreport:ironfo_yjbylsbpz_yjk:view","ironfoyjbylsbpzyjkreport:ironfo_yjbylsbpz_yjk:add","ironfoyjbylsbpzyjkreport:ironfo_yjbylsbpz_yjk:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfo_yjbylsbpz_yjkReport ironfo_yjbylsbpz_yjk, Model model) {
		model.addAttribute("ironfo_yjbylsbpz_yjk", ironfo_yjbylsbpz_yjk);
		return "report/ironfoyjbylsbpzyjkreport/ironfo_yjbylsbpz_yjkForm";
	}

	/**
	 * 保存 药剂科
	 */
	@RequiresPermissions(value={"ironfoyjbylsbpzyjkreport:ironfo_yjbylsbpz_yjk:add","ironfoyjbylsbpzyjkreport:ironfo_yjbylsbpz_yjk:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfo_yjbylsbpz_yjkReport ironfo_yjbylsbpz_yjk, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfo_yjbylsbpz_yjk)){
			return form(ironfo_yjbylsbpz_yjk, model);
		}
		if(!ironfo_yjbylsbpz_yjk.getIsNewRecord()){//编辑表单保存
			Ironfo_yjbylsbpz_yjkReport t = ironfo_yjbylsbpz_yjkService.get(ironfo_yjbylsbpz_yjk.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfo_yjbylsbpz_yjk, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfo_yjbylsbpz_yjkService.save(t);//保存
		}else{//新增表单保存
			ironfo_yjbylsbpz_yjkService.save(ironfo_yjbylsbpz_yjk);//保存
		}
		addMessage(redirectAttributes, "保存 药剂科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzyjkreport/ironfo_yjbylsbpz_yjk/?repage";
	}
	
	/**
	 * 删除 药剂科
	 */
	@RequiresPermissions("ironfoyjbylsbpzyjkreport:ironfo_yjbylsbpz_yjk:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfo_yjbylsbpz_yjkReport ironfo_yjbylsbpz_yjk, RedirectAttributes redirectAttributes) {
		ironfo_yjbylsbpz_yjkService.delete(ironfo_yjbylsbpz_yjk);
		addMessage(redirectAttributes, "删除 药剂科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzyjkreport/ironfo_yjbylsbpz_yjk/?repage";
	}
	
	/**
	 * 批量删除 药剂科
	 */
	@RequiresPermissions("ironfoyjbylsbpzyjkreport:ironfo_yjbylsbpz_yjk:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfo_yjbylsbpz_yjkService.delete(ironfo_yjbylsbpz_yjkService.get(id));
		}
		addMessage(redirectAttributes, "删除 药剂科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzyjkreport/ironfo_yjbylsbpz_yjk/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfoyjbylsbpzyjkreport:ironfo_yjbylsbpz_yjk:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfo_yjbylsbpz_yjkReport ironfo_yjbylsbpz_yjk, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfo_yjbylsbpz_yjk.getDuser() != null&&ironfo_yjbylsbpz_yjk.getDuser().toString() != null && ironfo_yjbylsbpz_yjk.getDuser().toString().trim() != null
					&& !"".equals(ironfo_yjbylsbpz_yjk.getDuser().toString().trim())
					&& !"null".equals(ironfo_yjbylsbpz_yjk.getDuser().toString().trim())) {
				userId = ironfo_yjbylsbpz_yjk.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfo_yjbylsbpz_yjk.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = " 药剂科"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfo_yjbylsbpz_yjkReport> page = ironfo_yjbylsbpz_yjkService.findPage(new Page<Ironfo_yjbylsbpz_yjkReport>(request, response, -1), ironfo_yjbylsbpz_yjk);
    		new ExportExcel(" 药剂科", Ironfo_yjbylsbpz_yjkReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出 药剂科记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzyjkreport/ironfo_yjbylsbpz_yjk/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfoyjbylsbpzyjkreport:ironfo_yjbylsbpz_yjk:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfo_yjbylsbpz_yjkReport> list = ei.getDataList(Ironfo_yjbylsbpz_yjkReport.class);
			for (Ironfo_yjbylsbpz_yjkReport ironfo_yjbylsbpz_yjk : list){
				try{
					ironfo_yjbylsbpz_yjkService.save(ironfo_yjbylsbpz_yjk);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条 药剂科记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条 药剂科记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入 药剂科失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzyjkreport/ironfo_yjbylsbpz_yjk/?repage";
    }
	
	/**
	 * 下载导入 药剂科数据模板
	 */
	@RequiresPermissions("ironfoyjbylsbpzyjkreport:ironfo_yjbylsbpz_yjk:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = " 药剂科数据导入模板.xlsx";
    		List<Ironfo_yjbylsbpz_yjkReport> list = Lists.newArrayList(); 
    		new ExportExcel(" 药剂科数据", Ironfo_yjbylsbpz_yjkReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzyjkreport/ironfo_yjbylsbpz_yjk/?repage";
    }
	
	
	

}