/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfo_departmentreport.web;

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
import com.jeeplus.modules.report.ironfo_departmentreport.entity.IronfodepartmentReport;
import com.jeeplus.modules.report.ironfo_departmentreport.service.IronfodepartmentReportService;
import com.jeeplus.modules.report.ironfopublichealthreport.entity.IronfopublichealthReport;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 2.4科室设置Controller
 * @author mao
 * @version 2018-04-20
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfo_departmentreport/ironfodepartment")
public class IronfodepartmentReportController extends BaseController {

	@Autowired
	private IronfodepartmentReportService ironfodepartmentService;
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	@ModelAttribute
	public IronfodepartmentReport get(@RequestParam(required=false) String id) {
		IronfodepartmentReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfodepartmentService.get(id);
		}
		if (entity == null){
			entity = new IronfodepartmentReport();
		}
		return entity;
	}
	
	/**
	 * 2.4科室设置列表页面
	 */
	@RequiresPermissions("ironfo_departmentreport:ironfodepartment:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfodepartmentReport ironfodepartment, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfodepartment.getDuser() != null&&ironfodepartment.getDuser().toString() != null && ironfodepartment.getDuser().toString().trim() != null
					&& !"".equals(ironfodepartment.getDuser().toString().trim())
					&& !"null".equals(ironfodepartment.getDuser().toString().trim())) {
				userId = ironfodepartment.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
				
			}
			System.out.println("userId:-----------" + userId);
			title = ironfoDoc_Title_Service.getDocId(userId);
			ironfodepartment.setDoc_id(title.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}

		Page<IronfodepartmentReport> page = ironfodepartmentService
				.findPage(new Page<IronfodepartmentReport>(request, response), ironfodepartment);
		model.addAttribute("page", page);
		return "modules/report/ironfodepartmentReportList";
	}

	/**
	 * 查看，增加，编辑2.4科室设置表单页面
	 */
	@RequiresPermissions(value={"ironfo_departmentreport:ironfodepartment:view","ironfo_departmentreport:ironfodepartment:add","ironfo_departmentreport:ironfodepartment:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfodepartmentReport ironfodepartment, Model model) {
		model.addAttribute("ironfodepartment", ironfodepartment);
		return "report/ironfo_departmentreport/ironfodepartmentForm";
	}

	/**
	 * 保存2.4科室设置
	 */
	@RequiresPermissions(value={"ironfo_departmentreport:ironfodepartment:add","ironfo_departmentreport:ironfodepartment:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfodepartmentReport ironfodepartment, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfodepartment)){
			return form(ironfodepartment, model);
		}
		if(!ironfodepartment.getIsNewRecord()){//编辑表单保存
			IronfodepartmentReport t = ironfodepartmentService.get(ironfodepartment.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfodepartment, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfodepartmentService.save(t);//保存
		}else{//新增表单保存
			ironfodepartmentService.save(ironfodepartment);//保存
		}
		addMessage(redirectAttributes, "保存2.4科室设置成功");
		return "redirect:"+Global.getAdminPath()+"/ironfo_departmentreport/ironfodepartment/?repage";
	}
	
	/**
	 * 删除2.4科室设置
	 */
	@RequiresPermissions("ironfo_departmentreport:ironfodepartment:del")
	@RequestMapping(value = "delete")
	public String delete(IronfodepartmentReport ironfodepartment, RedirectAttributes redirectAttributes) {
		ironfodepartmentService.delete(ironfodepartment);
		addMessage(redirectAttributes, "删除2.4科室设置成功");
		return "redirect:"+Global.getAdminPath()+"/ironfo_departmentreport/ironfodepartment/?repage";
	}
	
	/**
	 * 批量删除2.4科室设置
	 */
	@RequiresPermissions("ironfo_departmentreport:ironfodepartment:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfodepartmentService.delete(ironfodepartmentService.get(id));
		}
		addMessage(redirectAttributes, "删除2.4科室设置成功");
		return "redirect:"+Global.getAdminPath()+"/ironfo_departmentreport/ironfodepartment/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfo_departmentreport:ironfodepartment:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfodepartmentReport ironfodepartment, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		/*try {
            String fileName = "2.4科室设置"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfodepartmentReport> page = ironfodepartmentService.findPage(new Page<IronfodepartmentReport>(request, response, -1), ironfodepartment);
    		new ExportExcel("2.4科室设置", IronfodepartmentReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出2.4科室设置记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfo_departmentreport/ironfodepartment/?repage";*/
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfodepartment.getDuser() != null && ironfodepartment.getDuser().toString() != null
					&& ironfodepartment.getDuser().toString().trim() != null
					&& !"".equals(ironfodepartment.getDuser().toString().trim())
					&& !"null".equals(ironfodepartment.getDuser().toString().trim())) {
				userId = ironfodepartment.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			ironfodepartment.setDoc_id(title.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "2.4科室设置"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfodepartmentReport> page = ironfodepartmentService.findPage(new Page<IronfodepartmentReport>(request, response, -1), ironfodepartment);
    		new ExportExcel("2.4科室设置", IronfodepartmentReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出2.4科室设置失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfomedicalservicesdatas/ironfoMedicalServices/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfo_departmentreport:ironfodepartment:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfodepartmentReport> list = ei.getDataList(IronfodepartmentReport.class);
			for (IronfodepartmentReport ironfodepartment : list){
				try{
					ironfodepartmentService.save(ironfodepartment);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条2.4科室设置记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条2.4科室设置记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入2.4科室设置失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfo_departmentreport/ironfodepartment/?repage";
    }
	
	/**
	 * 下载导入2.4科室设置数据模板
	 */
	@RequiresPermissions("ironfo_departmentreport:ironfodepartment:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "2.4科室设置数据导入模板.xlsx";
    		List<IronfodepartmentReport> list = Lists.newArrayList(); 
    		new ExportExcel("2.4科室设置数据", IronfodepartmentReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfo_departmentreport/ironfodepartment/?repage";
    }
	
	
	

}