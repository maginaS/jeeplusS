/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoyjbylsbpzkfkreport.web;

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
import com.jeeplus.common.utils.DateUtils;
import com.jeeplus.common.utils.MyBeanUtils;
import com.jeeplus.common.config.Global;
import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.web.BaseController;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.common.utils.excel.ExportExcel;
import com.jeeplus.common.utils.excel.ImportExcel;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.ironfodoctitle.service.IronfoDocTitleService;
import com.jeeplus.modules.report.ironfoyjbylsbpzkfkreport.entity.IronfoyjbylsbpzkfkReport;
import com.jeeplus.modules.report.ironfoyjbylsbpzkfkreport.service.IronfoyjbylsbpzkfkReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 康复科Controller
 * @author anti_magina
 * @version 2018-04-20
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfoyjbylsbpzkfkreport/ironfoyjbylsbpzkfk")
public class IronfoyjbylsbpzkfkReportController extends BaseController {

	@Autowired
	private IronfoyjbylsbpzkfkReportService ironfoyjbylsbpzkfkService;

	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	@ModelAttribute
	public IronfoyjbylsbpzkfkReport get(@RequestParam(required=false) String id) {
		IronfoyjbylsbpzkfkReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfoyjbylsbpzkfkService.get(id);
		}
		if (entity == null){
			entity = new IronfoyjbylsbpzkfkReport();
		}
		return entity;
	}
	
	/**
	 * 康复科列表页面
	 */
	@RequiresPermissions("ironfoyjbylsbpzkfkreport:ironfoyjbylsbpzkfk:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfoyjbylsbpzkfkReport ironfoyjbylsbpzkfk, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfoyjbylsbpzkfk.getDuser() != null&&ironfoyjbylsbpzkfk.getDuser().toString() != null && ironfoyjbylsbpzkfk.getDuser().toString().trim() != null
					&& !"".equals(ironfoyjbylsbpzkfk.getDuser().toString().trim())
					&& !"null".equals(ironfoyjbylsbpzkfk.getDuser().toString().trim())) {
				userId = ironfoyjbylsbpzkfk.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				
				ironfoyjbylsbpzkfk.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Page<IronfoyjbylsbpzkfkReport> page = ironfoyjbylsbpzkfkService.findPage(new Page<IronfoyjbylsbpzkfkReport>(request, response), ironfoyjbylsbpzkfk); 
		model.addAttribute("page", page);
		return "modules/report/ironfoyjbylsbpzkfkreport/ironfoyjbylsbpzkfkList";
	}

	/**
	 * 查看，增加，编辑康复科表单页面
	 */
	@RequiresPermissions(value={"ironfoyjbylsbpzkfkreport:ironfoyjbylsbpzkfk:view","ironfoyjbylsbpzkfkreport:ironfoyjbylsbpzkfk:add","ironfoyjbylsbpzkfkreport:ironfoyjbylsbpzkfk:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfoyjbylsbpzkfkReport ironfoyjbylsbpzkfk, Model model) {
		model.addAttribute("ironfoyjbylsbpzkfk", ironfoyjbylsbpzkfk);
		return "report/ironfoyjbylsbpzkfkreport/ironfoyjbylsbpzkfkForm";
	}

	/**
	 * 保存康复科
	 */
	@RequiresPermissions(value={"ironfoyjbylsbpzkfkreport:ironfoyjbylsbpzkfk:add","ironfoyjbylsbpzkfkreport:ironfoyjbylsbpzkfk:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfoyjbylsbpzkfkReport ironfoyjbylsbpzkfk, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfoyjbylsbpzkfk)){
			return form(ironfoyjbylsbpzkfk, model);
		}
		if(!ironfoyjbylsbpzkfk.getIsNewRecord()){//编辑表单保存
			IronfoyjbylsbpzkfkReport t = ironfoyjbylsbpzkfkService.get(ironfoyjbylsbpzkfk.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfoyjbylsbpzkfk, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfoyjbylsbpzkfkService.save(t);//保存
		}else{//新增表单保存
			ironfoyjbylsbpzkfkService.save(ironfoyjbylsbpzkfk);//保存
		}
		addMessage(redirectAttributes, "保存康复科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzkfkreport/ironfoyjbylsbpzkfk/?repage";
	}
	
	/**
	 * 删除康复科
	 */
	@RequiresPermissions("ironfoyjbylsbpzkfkreport:ironfoyjbylsbpzkfk:del")
	@RequestMapping(value = "delete")
	public String delete(IronfoyjbylsbpzkfkReport ironfoyjbylsbpzkfk, RedirectAttributes redirectAttributes) {
		ironfoyjbylsbpzkfkService.delete(ironfoyjbylsbpzkfk);
		addMessage(redirectAttributes, "删除康复科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzkfkreport/ironfoyjbylsbpzkfk/?repage";
	}
	
	/**
	 * 批量删除康复科
	 */
	@RequiresPermissions("ironfoyjbylsbpzkfkreport:ironfoyjbylsbpzkfk:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfoyjbylsbpzkfkService.delete(ironfoyjbylsbpzkfkService.get(id));
		}
		addMessage(redirectAttributes, "删除康复科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzkfkreport/ironfoyjbylsbpzkfk/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfoyjbylsbpzkfkreport:ironfoyjbylsbpzkfk:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfoyjbylsbpzkfkReport ironfoyjbylsbpzkfk, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfoyjbylsbpzkfk.getDuser() != null&&ironfoyjbylsbpzkfk.getDuser().toString() != null && ironfoyjbylsbpzkfk.getDuser().toString().trim() != null
					&& !"".equals(ironfoyjbylsbpzkfk.getDuser().toString().trim())
					&& !"null".equals(ironfoyjbylsbpzkfk.getDuser().toString().trim())) {
				userId = ironfoyjbylsbpzkfk.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfoyjbylsbpzkfk.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "康复科"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfoyjbylsbpzkfkReport> page = ironfoyjbylsbpzkfkService.findPage(new Page<IronfoyjbylsbpzkfkReport>(request, response, -1), ironfoyjbylsbpzkfk);
    		new ExportExcel("康复科", IronfoyjbylsbpzkfkReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出康复科记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"report/ironfoyjbylsbpzkfkreport/ironfoyjbylsbpzkfk/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfoyjbylsbpzkfkreport:ironfoyjbylsbpzkfk:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfoyjbylsbpzkfkReport> list = ei.getDataList(IronfoyjbylsbpzkfkReport.class);
			for (IronfoyjbylsbpzkfkReport ironfoyjbylsbpzkfk : list){
				try{
					ironfoyjbylsbpzkfkService.save(ironfoyjbylsbpzkfk);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条康复科记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条康复科记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入康复科失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzkfkreport/ironfoyjbylsbpzkfk/?repage";
    }
	
	/**
	 * 下载导入康复科数据模板
	 */
	@RequiresPermissions("ironfoyjbylsbpzkfkreport:ironfoyjbylsbpzkfk:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "康复科数据导入模板.xlsx";
    		List<IronfoyjbylsbpzkfkReport> list = Lists.newArrayList(); 
    		new ExportExcel("康复科数据", IronfoyjbylsbpzkfkReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzkfkreport/ironfoyjbylsbpzkfk/?repage";
    }
	
	
	

}