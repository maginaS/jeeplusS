/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoyjbylsbpzqkyxkreport.web;

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
import com.jeeplus.modules.report.ironfoyjbylsbpzqkyxkreport.entity.IronfoyjbylsbpzqkyxkReport;
import com.jeeplus.modules.report.ironfoyjbylsbpzqkyxkreport.service.IronfoyjbylsbpzqkyxkReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 全科医学科Controller
 * @author anti_magina
 * @version 2018-04-19
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfoyjbylsbpzqkyxkreport/ironfoyjbylsbpzqkyxk")
public class IronfoyjbylsbpzqkyxkReportController extends BaseController {

	@Autowired
	private IronfoyjbylsbpzqkyxkReportService ironfoyjbylsbpzqkyxkService;
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	@ModelAttribute
	public IronfoyjbylsbpzqkyxkReport get(@RequestParam(required=false) String id) {
		IronfoyjbylsbpzqkyxkReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfoyjbylsbpzqkyxkService.get(id);
		}
		if (entity == null){
			entity = new IronfoyjbylsbpzqkyxkReport();
		}
		return entity;
	}
	
	/**
	 * 全科医学科列表页面
	 */
	@RequiresPermissions("ironfoyjbylsbpzqkyxkreport:ironfoyjbylsbpzqkyxk:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfoyjbylsbpzqkyxkReport ironfoyjbylsbpzqkyxk, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfoyjbylsbpzqkyxk.getDuser() != null&&ironfoyjbylsbpzqkyxk.getDuser().toString() != null && ironfoyjbylsbpzqkyxk.getDuser().toString().trim() != null
					&& !"".equals(ironfoyjbylsbpzqkyxk.getDuser().toString().trim())
					&& !"null".equals(ironfoyjbylsbpzqkyxk.getDuser().toString().trim())) {
				userId = ironfoyjbylsbpzqkyxk.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
				
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
			ironfoyjbylsbpzqkyxk.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Page<IronfoyjbylsbpzqkyxkReport> page = ironfoyjbylsbpzqkyxkService.findPage(new Page<IronfoyjbylsbpzqkyxkReport>(request, response), ironfoyjbylsbpzqkyxk); 
		model.addAttribute("page", page);
		return "modules/report/ironfoyjbylsbpzqkyxkreport/ironfoyjbylsbpzqkyxkList";
	}

	/**
	 * 查看，增加，编辑全科医学科表单页面
	 */
	@RequiresPermissions(value={"ironfoyjbylsbpzqkyxkreport:ironfoyjbylsbpzqkyxk:view","ironfoyjbylsbpzqkyxkreport:ironfoyjbylsbpzqkyxk:add","ironfoyjbylsbpzqkyxkreport:ironfoyjbylsbpzqkyxk:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfoyjbylsbpzqkyxkReport ironfoyjbylsbpzqkyxk, Model model) {
		model.addAttribute("ironfoyjbylsbpzqkyxk", ironfoyjbylsbpzqkyxk);
		return "report/ironfoyjbylsbpzqkyxkreport/ironfoyjbylsbpzqkyxkForm";
	}

	/**
	 * 保存全科医学科
	 */
	@RequiresPermissions(value={"ironfoyjbylsbpzqkyxkreport:ironfoyjbylsbpzqkyxk:add","ironfoyjbylsbpzqkyxkreport:ironfoyjbylsbpzqkyxk:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfoyjbylsbpzqkyxkReport ironfoyjbylsbpzqkyxk, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfoyjbylsbpzqkyxk)){
			return form(ironfoyjbylsbpzqkyxk, model);
		}
		if(!ironfoyjbylsbpzqkyxk.getIsNewRecord()){//编辑表单保存
			IronfoyjbylsbpzqkyxkReport t = ironfoyjbylsbpzqkyxkService.get(ironfoyjbylsbpzqkyxk.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfoyjbylsbpzqkyxk, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfoyjbylsbpzqkyxkService.save(t);//保存
		}else{//新增表单保存
			ironfoyjbylsbpzqkyxkService.save(ironfoyjbylsbpzqkyxk);//保存
		}
		addMessage(redirectAttributes, "保存全科医学科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzqkyxkreport/ironfoyjbylsbpzqkyxk/?repage";
	}
	
	/**
	 * 删除全科医学科
	 */
	@RequiresPermissions("ironfoyjbylsbpzqkyxkreport:ironfoyjbylsbpzqkyxk:del")
	@RequestMapping(value = "delete")
	public String delete(IronfoyjbylsbpzqkyxkReport ironfoyjbylsbpzqkyxk, RedirectAttributes redirectAttributes) {
		ironfoyjbylsbpzqkyxkService.delete(ironfoyjbylsbpzqkyxk);
		addMessage(redirectAttributes, "删除全科医学科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzqkyxkreport/ironfoyjbylsbpzqkyxk/?repage";
	}
	
	/**
	 * 批量删除全科医学科
	 */
	@RequiresPermissions("ironfoyjbylsbpzqkyxkreport:ironfoyjbylsbpzqkyxk:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfoyjbylsbpzqkyxkService.delete(ironfoyjbylsbpzqkyxkService.get(id));
		}
		addMessage(redirectAttributes, "删除全科医学科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzqkyxkreport/ironfoyjbylsbpzqkyxk/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfoyjbylsbpzqkyxkreport:ironfoyjbylsbpzqkyxk:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfoyjbylsbpzqkyxkReport ironfoyjbylsbpzqkyxk, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfoyjbylsbpzqkyxk.getDuser() != null&&ironfoyjbylsbpzqkyxk.getDuser().toString() != null && ironfoyjbylsbpzqkyxk.getDuser().toString().trim() != null
					&& !"".equals(ironfoyjbylsbpzqkyxk.getDuser().toString().trim())
					&& !"null".equals(ironfoyjbylsbpzqkyxk.getDuser().toString().trim())) {
				userId = ironfoyjbylsbpzqkyxk.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
				
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
			ironfoyjbylsbpzqkyxk.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "全科医学科"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfoyjbylsbpzqkyxkReport> page = ironfoyjbylsbpzqkyxkService.findPage(new Page<IronfoyjbylsbpzqkyxkReport>(request, response, -1), ironfoyjbylsbpzqkyxk);
    		new ExportExcel("全科医学科", IronfoyjbylsbpzqkyxkReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出全科医学科记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"report/ironfoyjbylsbpzqkyxkreport/ironfoyjbylsbpzqkyxk/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfoyjbylsbpzqkyxkreport:ironfoyjbylsbpzqkyxk:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfoyjbylsbpzqkyxkReport> list = ei.getDataList(IronfoyjbylsbpzqkyxkReport.class);
			for (IronfoyjbylsbpzqkyxkReport ironfoyjbylsbpzqkyxk : list){
				try{
					ironfoyjbylsbpzqkyxkService.save(ironfoyjbylsbpzqkyxk);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条全科医学科记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条全科医学科记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入全科医学科失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzqkyxkreport/ironfoyjbylsbpzqkyxk/?repage";
    }
	
	/**
	 * 下载导入全科医学科数据模板
	 */
	@RequiresPermissions("ironfoyjbylsbpzqkyxkreport:ironfoyjbylsbpzqkyxk:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "全科医学科数据导入模板.xlsx";
    		List<IronfoyjbylsbpzqkyxkReport> list = Lists.newArrayList(); 
    		new ExportExcel("全科医学科数据", IronfoyjbylsbpzqkyxkReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzqkyxkreport/ironfoyjbylsbpzqkyxk/?repage";
    }
	
	
	

}