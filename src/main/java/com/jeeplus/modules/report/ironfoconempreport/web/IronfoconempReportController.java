/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoconempreport.web;

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
import com.jeeplus.modules.report.ironfoconempreport.entity.IronfoconempReport;
import com.jeeplus.modules.report.ironfoconempreport.service.IronfoconempReportService;
import com.jeeplus.modules.report.ironfofinancereport.entity.IronfofinanceReport;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 2.9.1职工构成Controller
 * @author mao
 * @version 2018-04-20
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfoconempreport/ironfoconemp")
public class IronfoconempReportController extends BaseController {

	@Autowired
	private IronfoconempReportService ironfoconempService;
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	@ModelAttribute
	public IronfoconempReport get(@RequestParam(required=false) String id) {
		IronfoconempReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfoconempService.get(id);
		}
		if (entity == null){
			entity = new IronfoconempReport();
		}
		return entity;
	}
	
	/**
	 * 2.9.1职工构成列表页面
	 */
	@RequiresPermissions("ironfoconempreport:ironfoconemp:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfoconempReport ironfoconemp, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfoconemp.getDuser() != null&&ironfoconemp.getDuser().toString() != null && ironfoconemp.getDuser().toString().trim() != null
					&& !"".equals(ironfoconemp.getDuser().toString().trim())
					&& !"null".equals(ironfoconemp.getDuser().toString().trim())) {
				userId = ironfoconemp.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
				
			}
			System.out.println("userId:-----------" + userId);
			title = ironfoDoc_Title_Service.getDocId(userId);
			ironfoconemp.setDoc_id(title.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}

		Page<IronfoconempReport> page = ironfoconempService
				.findPage(new Page<IronfoconempReport>(request, response), ironfoconemp);
		model.addAttribute("page", page);
		return "modules/report/ironfoconempReportList";
	}

	
	/**
	 * 查看，增加，编辑2.7.1职工构成表单页面
	 */
	@RequiresPermissions(value={"ironfoconempreport:ironfoconemp:view","ironfoconempreport:ironfoconemp:add","ironfoconempreport:ironfoconemp:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfoconempReport ironfoconemp, Model model) {
		model.addAttribute("ironfoconemp", ironfoconemp);
		return "report/ironfoconempreport/ironfoconempForm";
	}

	/**
	 * 保存2.7.1职工构成
	 */
	@RequiresPermissions(value={"ironfoconempreport:ironfoconemp:add","ironfoconempreport:ironfoconemp:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfoconempReport ironfoconemp, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfoconemp)){
			return form(ironfoconemp, model);
		}
		if(!ironfoconemp.getIsNewRecord()){//编辑表单保存
			IronfoconempReport t = ironfoconempService.get(ironfoconemp.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfoconemp, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfoconempService.save(t);//保存
		}else{//新增表单保存
			ironfoconempService.save(ironfoconemp);//保存
		}
		addMessage(redirectAttributes, "保存2.7.1职工构成成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoconempreport/ironfoconemp/?repage";
	}
	
	/**
	 * 删除2.7.1职工构成
	 */
	@RequiresPermissions("ironfoconempreport:ironfoconemp:del")
	@RequestMapping(value = "delete")
	public String delete(IronfoconempReport ironfoconemp, RedirectAttributes redirectAttributes) {
		ironfoconempService.delete(ironfoconemp);
		addMessage(redirectAttributes, "删除2.7.1职工构成成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoconempreport/ironfoconemp/?repage";
	}
	
	/**
	 * 批量删除2.7.1职工构成
	 */
	@RequiresPermissions("ironfoconempreport:ironfoconemp:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfoconempService.delete(ironfoconempService.get(id));
		}
		addMessage(redirectAttributes, "删除2.7.1职工构成成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoconempreport/ironfoconemp/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfoconempreport:ironfoconemp:export")
    @RequestMapping(value = "export", method=RequestMethod.GET)
    public String exportFile(IronfoconempReport ironfoconemp, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		/*try {
            String fileName = "2.7.1职工构成"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfoconempReport> page = ironfoconempService.findPage(new Page<IronfoconempReport>(request, response, -1), ironfoconemp);
    		new ExportExcel("2.7.1职工构成", IronfoconempReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出2.7.1职工构成记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoconempreport/ironfoconemp/?repage";*/
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfoconemp.getDuser() != null && ironfoconemp.getDuser().toString() != null
					&& ironfoconemp.getDuser().toString().trim() != null
					&& !"".equals(ironfoconemp.getDuser().toString().trim())
					&& !"null".equals(ironfoconemp.getDuser().toString().trim())) {
				userId = ironfoconemp.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			ironfoconemp.setDoc_id(title.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "2.9.1职工构成"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfoconempReport> page = ironfoconempService.findPage(new Page<IronfoconempReport>(request, response, -1), ironfoconemp);
    		new ExportExcel("2.9.1职工构成", IronfoconempReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出2.9.1职工构成记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfomedicalservicesdatas/ironfoMedicalServices/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfoconempreport:ironfoconemp:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfoconempReport> list = ei.getDataList(IronfoconempReport.class);
			for (IronfoconempReport ironfoconemp : list){
				try{
					ironfoconempService.save(ironfoconemp);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条2.7.1职工构成记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条2.7.1职工构成记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入2.7.1职工构成失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoconempreport/ironfoconemp/?repage";
    }
	
	/**
	 * 下载导入2.7.1职工构成数据模板
	 */
	@RequiresPermissions("ironfoconempreport:ironfoconemp:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "2.7.1职工构成数据导入模板.xlsx";
    		List<IronfoconempReport> list = Lists.newArrayList(); 
    		new ExportExcel("2.7.1职工构成数据", IronfoconempReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoconempreport/ironfoconemp/?repage";
    }
	
	
	

}