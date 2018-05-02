/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoyjbylsbpzkqkreport.web;

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
import com.jeeplus.modules.report.ironfoyjbylsbpzkqkreport.entity.IronfoyjbylsbpzkqkReport;
import com.jeeplus.modules.report.ironfoyjbylsbpzkqkreport.service.IronfoyjbylsbpzkqkReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 口腔科Controller
 * @author anti_magina
 * @version 2018-04-20
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfoyjbylsbpzkqkreport/ironfoyjbylsbpzkqk")
public class IronfoyjbylsbpzkqkReportController extends BaseController {

	@Autowired
	private IronfoyjbylsbpzkqkReportService ironfoyjbylsbpzkqkService;
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	@ModelAttribute
	public IronfoyjbylsbpzkqkReport get(@RequestParam(required=false) String id) {
		IronfoyjbylsbpzkqkReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfoyjbylsbpzkqkService.get(id);
		}
		if (entity == null){
			entity = new IronfoyjbylsbpzkqkReport();
		}
		return entity;
	}
	
	/**
	 * 口腔科列表页面
	 */
	@RequiresPermissions("ironfoyjbylsbpzkqkreport:ironfoyjbylsbpzkqk:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfoyjbylsbpzkqkReport ironfoyjbylsbpzkqk, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfoyjbylsbpzkqk.getDuser() != null&&ironfoyjbylsbpzkqk.getDuser().toString() != null && ironfoyjbylsbpzkqk.getDuser().toString().trim() != null
					&& !"".equals(ironfoyjbylsbpzkqk.getDuser().toString().trim())
					&& !"null".equals(ironfoyjbylsbpzkqk.getDuser().toString().trim())) {
				userId = ironfoyjbylsbpzkqk.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				
				ironfoyjbylsbpzkqk.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Page<IronfoyjbylsbpzkqkReport> page = ironfoyjbylsbpzkqkService.findPage(new Page<IronfoyjbylsbpzkqkReport>(request, response), ironfoyjbylsbpzkqk); 
		model.addAttribute("page", page);
		return "modules/report/ironfoyjbylsbpzkqkreport/ironfoyjbylsbpzkqkList";
	}

	/**
	 * 查看，增加，编辑口腔科表单页面
	 */
	@RequiresPermissions(value={"ironfoyjbylsbpzkqkreport:ironfoyjbylsbpzkqk:view","ironfoyjbylsbpzkqkreport:ironfoyjbylsbpzkqk:add","ironfoyjbylsbpzkqkreport:ironfoyjbylsbpzkqk:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfoyjbylsbpzkqkReport ironfoyjbylsbpzkqk, Model model) {
		model.addAttribute("ironfoyjbylsbpzkqk", ironfoyjbylsbpzkqk);
		return "report/ironfoyjbylsbpzkqkreport/ironfoyjbylsbpzkqkForm";
	}

	/**
	 * 保存口腔科
	 */
	@RequiresPermissions(value={"ironfoyjbylsbpzkqkreport:ironfoyjbylsbpzkqk:add","ironfoyjbylsbpzkqkreport:ironfoyjbylsbpzkqk:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfoyjbylsbpzkqkReport ironfoyjbylsbpzkqk, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfoyjbylsbpzkqk)){
			return form(ironfoyjbylsbpzkqk, model);
		}
		if(!ironfoyjbylsbpzkqk.getIsNewRecord()){//编辑表单保存
			IronfoyjbylsbpzkqkReport t = ironfoyjbylsbpzkqkService.get(ironfoyjbylsbpzkqk.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfoyjbylsbpzkqk, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfoyjbylsbpzkqkService.save(t);//保存
		}else{//新增表单保存
			ironfoyjbylsbpzkqkService.save(ironfoyjbylsbpzkqk);//保存
		}
		addMessage(redirectAttributes, "保存口腔科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzkqkreport/ironfoyjbylsbpzkqk/?repage";
	}
	
	/**
	 * 删除口腔科
	 */
	@RequiresPermissions("ironfoyjbylsbpzkqkreport:ironfoyjbylsbpzkqk:del")
	@RequestMapping(value = "delete")
	public String delete(IronfoyjbylsbpzkqkReport ironfoyjbylsbpzkqk, RedirectAttributes redirectAttributes) {
		ironfoyjbylsbpzkqkService.delete(ironfoyjbylsbpzkqk);
		addMessage(redirectAttributes, "删除口腔科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzkqkreport/ironfoyjbylsbpzkqk/?repage";
	}
	
	/**
	 * 批量删除口腔科
	 */
	@RequiresPermissions("ironfoyjbylsbpzkqkreport:ironfoyjbylsbpzkqk:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfoyjbylsbpzkqkService.delete(ironfoyjbylsbpzkqkService.get(id));
		}
		addMessage(redirectAttributes, "删除口腔科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzkqkreport/ironfoyjbylsbpzkqk/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfoyjbylsbpzkqkreport:ironfoyjbylsbpzkqk:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfoyjbylsbpzkqkReport ironfoyjbylsbpzkqk, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfoyjbylsbpzkqk.getDuser() != null&&ironfoyjbylsbpzkqk.getDuser().toString() != null && ironfoyjbylsbpzkqk.getDuser().toString().trim() != null
					&& !"".equals(ironfoyjbylsbpzkqk.getDuser().toString().trim())
					&& !"null".equals(ironfoyjbylsbpzkqk.getDuser().toString().trim())) {
				userId = ironfoyjbylsbpzkqk.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				
				ironfoyjbylsbpzkqk.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "口腔科"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfoyjbylsbpzkqkReport> page = ironfoyjbylsbpzkqkService.findPage(new Page<IronfoyjbylsbpzkqkReport>(request, response, -1), ironfoyjbylsbpzkqk);
    		new ExportExcel("口腔科", IronfoyjbylsbpzkqkReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出口腔科记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"report/ironfoyjbylsbpzkqkreport/ironfoyjbylsbpzkqk/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfoyjbylsbpzkqkreport:ironfoyjbylsbpzkqk:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfoyjbylsbpzkqkReport> list = ei.getDataList(IronfoyjbylsbpzkqkReport.class);
			for (IronfoyjbylsbpzkqkReport ironfoyjbylsbpzkqk : list){
				try{
					ironfoyjbylsbpzkqkService.save(ironfoyjbylsbpzkqk);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条口腔科记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条口腔科记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入口腔科失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzkqkreport/ironfoyjbylsbpzkqk/?repage";
    }
	
	/**
	 * 下载导入口腔科数据模板
	 */
	@RequiresPermissions("ironfoyjbylsbpzkqkreport:ironfoyjbylsbpzkqk:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "口腔科数据导入模板.xlsx";
    		List<IronfoyjbylsbpzkqkReport> list = Lists.newArrayList(); 
    		new ExportExcel("口腔科数据", IronfoyjbylsbpzkqkReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzkqkreport/ironfoyjbylsbpzkqk/?repage";
    }
	
	
	

}