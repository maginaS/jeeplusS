/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoyjbylsbpzsssreport.web;

import java.util.ArrayList;
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
import com.jeeplus.modules.report.ironfoyjbylsbpzsssreport.entity.IronfoyjbylsbpzsssForExcelReport;
import com.jeeplus.modules.report.ironfoyjbylsbpzsssreport.entity.IronfoyjbylsbpzsssReport;
import com.jeeplus.modules.report.ironfoyjbylsbpzsssreport.service.IronfoyjbylsbpzsssReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 手术室Controller
 * @author anti_magina
 * @version 2018-04-20
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfoyjbylsbpzsssreport/ironfoyjbylsbpzsss")
public class IronfoyjbylsbpzsssReportController extends BaseController {

	@Autowired
	private IronfoyjbylsbpzsssReportService ironfoyjbylsbpzsssService;
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	@ModelAttribute
	public IronfoyjbylsbpzsssReport get(@RequestParam(required=false) String id) {
		IronfoyjbylsbpzsssReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfoyjbylsbpzsssService.get(id);
		}
		if (entity == null){
			entity = new IronfoyjbylsbpzsssReport();
		}
		return entity;
	}
	
	/**
	 * 手术室列表页面
	 */
	@RequiresPermissions("ironfoyjbylsbpzsssreport:ironfoyjbylsbpzsss:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfoyjbylsbpzsssReport ironfoyjbylsbpzsss, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfoyjbylsbpzsss.getDuser() != null&&ironfoyjbylsbpzsss.getDuser().toString() != null && ironfoyjbylsbpzsss.getDuser().toString().trim() != null
					&& !"".equals(ironfoyjbylsbpzsss.getDuser().toString().trim())
					&& !"null".equals(ironfoyjbylsbpzsss.getDuser().toString().trim())) {
				userId = ironfoyjbylsbpzsss.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				
				ironfoyjbylsbpzsss.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Page<IronfoyjbylsbpzsssReport> page = ironfoyjbylsbpzsssService.findPage(new Page<IronfoyjbylsbpzsssReport>(request, response), ironfoyjbylsbpzsss); 
		model.addAttribute("page", page);
		return "modules/report/ironfoyjbylsbpzsssreport/ironfoyjbylsbpzsssList";
	}

	/**
	 * 查看，增加，编辑手术室表单页面
	 */
	@RequiresPermissions(value={"ironfoyjbylsbpzsssreport:ironfoyjbylsbpzsss:view","ironfoyjbylsbpzsssreport:ironfoyjbylsbpzsss:add","ironfoyjbylsbpzsssreport:ironfoyjbylsbpzsss:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfoyjbylsbpzsssReport ironfoyjbylsbpzsss, Model model) {
		model.addAttribute("ironfoyjbylsbpzsss", ironfoyjbylsbpzsss);
		return "report/ironfoyjbylsbpzsssreport/ironfoyjbylsbpzsssForm";
	}

	/**
	 * 保存手术室
	 */
	@RequiresPermissions(value={"ironfoyjbylsbpzsssreport:ironfoyjbylsbpzsss:add","ironfoyjbylsbpzsssreport:ironfoyjbylsbpzsss:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfoyjbylsbpzsssReport ironfoyjbylsbpzsss, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfoyjbylsbpzsss)){
			return form(ironfoyjbylsbpzsss, model);
		}
		if(!ironfoyjbylsbpzsss.getIsNewRecord()){//编辑表单保存
			IronfoyjbylsbpzsssReport t = ironfoyjbylsbpzsssService.get(ironfoyjbylsbpzsss.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfoyjbylsbpzsss, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfoyjbylsbpzsssService.save(t);//保存
		}else{//新增表单保存
			ironfoyjbylsbpzsssService.save(ironfoyjbylsbpzsss);//保存
		}
		addMessage(redirectAttributes, "保存手术室成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzsssreport/ironfoyjbylsbpzsss/?repage";
	}
	
	/**
	 * 删除手术室
	 */
	@RequiresPermissions("ironfoyjbylsbpzsssreport:ironfoyjbylsbpzsss:del")
	@RequestMapping(value = "delete")
	public String delete(IronfoyjbylsbpzsssReport ironfoyjbylsbpzsss, RedirectAttributes redirectAttributes) {
		ironfoyjbylsbpzsssService.delete(ironfoyjbylsbpzsss);
		addMessage(redirectAttributes, "删除手术室成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzsssreport/ironfoyjbylsbpzsss/?repage";
	}
	
	/**
	 * 批量删除手术室
	 */
	@RequiresPermissions("ironfoyjbylsbpzsssreport:ironfoyjbylsbpzsss:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfoyjbylsbpzsssService.delete(ironfoyjbylsbpzsssService.get(id));
		}
		addMessage(redirectAttributes, "删除手术室成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzsssreport/ironfoyjbylsbpzsss/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfoyjbylsbpzsssreport:ironfoyjbylsbpzsss:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfoyjbylsbpzsssReport ironfoyjbylsbpzsss, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfoyjbylsbpzsss.getDuser() != null&&ironfoyjbylsbpzsss.getDuser().toString() != null && ironfoyjbylsbpzsss.getDuser().toString().trim() != null
					&& !"".equals(ironfoyjbylsbpzsss.getDuser().toString().trim())
					&& !"null".equals(ironfoyjbylsbpzsss.getDuser().toString().trim())) {
				userId = ironfoyjbylsbpzsss.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfoyjbylsbpzsss.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "手术室"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfoyjbylsbpzsssReport> page = ironfoyjbylsbpzsssService.findPage(new Page<IronfoyjbylsbpzsssReport>(request, response, -1), ironfoyjbylsbpzsss);
            List<IronfoyjbylsbpzsssReport> ironfoyjbylsbpzsssReports = page.getList();
            List<IronfoyjbylsbpzsssForExcelReport> lists = new ArrayList<IronfoyjbylsbpzsssForExcelReport>();
            //xiebuchulaile 
//            for(IronfoyjbylsbpzsssReport ironfoyjbylsbpzsssReport : ironfoyjbylsbpzsssReports){
//            	IronfoyjbylsbpzsssForExcelReport o = new IronfoyjbylsbpzsssForExcelReport();
//            	o.getSbmc().
//            	o.setSbmc(ironfoyjbylsbpzsss + ironfoyjbylsbpzsss.getSbmc());
//            }
    		new ExportExcel("手术室", IronfoyjbylsbpzsssReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出手术室记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"report/ironfoyjbylsbpzsssreport/ironfoyjbylsbpzsss/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfoyjbylsbpzsssreport:ironfoyjbylsbpzsss:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfoyjbylsbpzsssReport> list = ei.getDataList(IronfoyjbylsbpzsssReport.class);
			for (IronfoyjbylsbpzsssReport ironfoyjbylsbpzsss : list){
				try{
					ironfoyjbylsbpzsssService.save(ironfoyjbylsbpzsss);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条手术室记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条手术室记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入手术室失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzsssreport/ironfoyjbylsbpzsss/?repage";
    }
	
	/**
	 * 下载导入手术室数据模板
	 */
	@RequiresPermissions("ironfoyjbylsbpzsssreport:ironfoyjbylsbpzsss:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "手术室数据导入模板.xlsx";
    		List<IronfoyjbylsbpzsssReport> list = Lists.newArrayList(); 
    		new ExportExcel("手术室数据", IronfoyjbylsbpzsssReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzsssreport/ironfoyjbylsbpzsss/?repage";
    }
	
	
	

}