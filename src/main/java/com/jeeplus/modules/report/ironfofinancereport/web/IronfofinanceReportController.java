/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofinancereport.web;

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
import com.jeeplus.modules.report.ironfofinancereport.entity.IronfofinanceReport;
import com.jeeplus.modules.report.ironfofinancereport.service.IronfofinanceReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 2.2财务收支Controller
 * @author mao
 * @version 2018-04-19
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfofinancereport/ironfofinance")
public class IronfofinanceReportController extends BaseController {

	@Autowired
	private IronfofinanceReportService ironfofinanceService;
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	@ModelAttribute
	public IronfofinanceReport get(@RequestParam(required=false) String id) {
		IronfofinanceReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfofinanceService.get(id);
		}
		if (entity == null){
			entity = new IronfofinanceReport();
		}
		return entity;
	}
	
	/**
	 * 2.2财务收支列表页面
	 */
	@RequiresPermissions("ironfofinancereport:ironfofinance:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfofinanceReport ironfofinance, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfofinance.getDuser() != null&&ironfofinance.getDuser().toString() != null && ironfofinance.getDuser().toString().trim() != null
					&& !"".equals(ironfofinance.getDuser().toString().trim())
					&& !"null".equals(ironfofinance.getDuser().toString().trim())) {
				userId = ironfofinance.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
				
			}
			System.out.println("userId:-----------" + userId);
			title = ironfoDoc_Title_Service.getDocId(userId);
			ironfofinance.setDoc_id(title.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}

		Page<IronfofinanceReport> page = ironfofinanceService
				.findPage(new Page<IronfofinanceReport>(request, response), ironfofinance);
		model.addAttribute("page", page);
		return "modules/report/ironfofinanceReportList";
	}
	
	

	/**
	 * 查看，增加，编辑2.2财务收支表单页面
	 */
	@RequiresPermissions(value={"ironfofinancereport:ironfofinance:view","ironfofinancereport:ironfofinance:add","ironfofinancereport:ironfofinance:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfofinanceReport ironfofinance, Model model) {
		model.addAttribute("ironfofinance", ironfofinance);
		return "report/ironfofinancereport/ironfofinanceForm";
	}

	/**
	 * 保存2.2财务收支
	 */
	@RequiresPermissions(value={"ironfofinancereport:ironfofinance:add","ironfofinancereport:ironfofinance:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfofinanceReport ironfofinance, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfofinance)){
			return form(ironfofinance, model);
		}
		if(!ironfofinance.getIsNewRecord()){//编辑表单保存
			IronfofinanceReport t = ironfofinanceService.get(ironfofinance.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfofinance, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfofinanceService.save(t);//保存
		}else{//新增表单保存
			ironfofinanceService.save(ironfofinance);//保存
		}
		addMessage(redirectAttributes, "保存2.2财务收支成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofinancereport/ironfofinance/?repage";
	}
	
	/**
	 * 删除2.2财务收支
	 */
	@RequiresPermissions("ironfofinancereport:ironfofinance:del")
	@RequestMapping(value = "delete")
	public String delete(IronfofinanceReport ironfofinance, RedirectAttributes redirectAttributes) {
		ironfofinanceService.delete(ironfofinance);
		addMessage(redirectAttributes, "删除2.2财务收支成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofinancereport/ironfofinance/?repage";
	}
	
	/**
	 * 批量删除2.2财务收支
	 */
	@RequiresPermissions("ironfofinancereport:ironfofinance:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfofinanceService.delete(ironfofinanceService.get(id));
		}
		addMessage(redirectAttributes, "删除2.2财务收支成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofinancereport/ironfofinance/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfofinancereport:ironfofinance:export")
    @RequestMapping(value = "export", method=RequestMethod.GET)
    public String exportFile(IronfofinanceReport ironfofinance, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
	/*	try {
            String fileName = "2.2财务收支"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfofinanceReport> page = ironfofinanceService.findPage(new Page<IronfofinanceReport>(request, response, -1), ironfofinance);
    		new ExportExcel("2.2财务收支", IronfofinanceReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出2.2财务收支记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofinancereport/ironfofinance/?repage";*/
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfofinance.getDuser() != null && ironfofinance.getDuser().toString() != null
					&& ironfofinance.getDuser().toString().trim() != null
					&& !"".equals(ironfofinance.getDuser().toString().trim())
					&& !"null".equals(ironfofinance.getDuser().toString().trim())) {
				userId = ironfofinance.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			ironfofinance.setDoc_id(title.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "2.2财务收支"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfofinanceReport> page = ironfofinanceService.findPage(new Page<IronfofinanceReport>(request, response, -1), ironfofinance);
    		new ExportExcel("2.2财务收支", IronfofinanceReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出2.2财务收支记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfomedicalservicesdatas/ironfoMedicalServices/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfofinancereport:ironfofinance:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfofinanceReport> list = ei.getDataList(IronfofinanceReport.class);
			for (IronfofinanceReport ironfofinance : list){
				try{
					ironfofinanceService.save(ironfofinance);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条2.2财务收支记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条2.2财务收支记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入2.2财务收支失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofinancereport/ironfofinance/?repage";
    }
	
	/**
	 * 下载导入2.2财务收支数据模板
	 */
	@RequiresPermissions("ironfofinancereport:ironfofinance:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "2.2财务收支数据导入模板.xlsx";
    		List<IronfofinanceReport> list = Lists.newArrayList(); 
    		new ExportExcel("2.2财务收支数据", IronfofinanceReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofinancereport/ironfofinance/?repage";
    }
	
	
	

}