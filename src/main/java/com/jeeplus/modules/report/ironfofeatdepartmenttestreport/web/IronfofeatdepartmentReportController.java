/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofeatdepartmenttestreport.web;

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
import com.jeeplus.modules.report.ironfofeatdepartmenttestreport.entity.IronfofeatdepartmentReport;
import com.jeeplus.modules.report.ironfofeatdepartmenttestreport.service.IronfofeatdepartmentReportService;
import com.jeeplus.modules.report.ironfopublichealthreport.entity.IronfopublichealthReport;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 2.4.1特色科室Controller
 * @author mao
 * @version 2018-04-20
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfofeatdepartmenttestreport/ironfofeatdepartment")
public class IronfofeatdepartmentReportController extends BaseController {

	@Autowired
	private IronfofeatdepartmentReportService ironfofeatdepartmentService;
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	@ModelAttribute
	public IronfofeatdepartmentReport get(@RequestParam(required=false) String id) {
		IronfofeatdepartmentReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfofeatdepartmentService.get(id);
		}
		if (entity == null){
			entity = new IronfofeatdepartmentReport();
		}
		return entity;
	}
	
	/**
	 * 2.4.1特色科室列表页面
	 */
	@RequiresPermissions("ironfofeatdepartmenttestreport:ironfofeatdepartment:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfofeatdepartmentReport ironfofeatdepartment, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfofeatdepartment.getDuser() != null&&ironfofeatdepartment.getDuser().toString() != null && ironfofeatdepartment.getDuser().toString().trim() != null
					&& !"".equals(ironfofeatdepartment.getDuser().toString().trim())
					&& !"null".equals(ironfofeatdepartment.getDuser().toString().trim())) {
				userId = ironfofeatdepartment.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
				
			}
			System.out.println("userId:-----------" + userId);
			title = ironfoDoc_Title_Service.getDocId(userId);
			ironfofeatdepartment.setDoc_id(title.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}

		Page<IronfofeatdepartmentReport> page = ironfofeatdepartmentService
				.findPage(new Page<IronfofeatdepartmentReport>(request, response), ironfofeatdepartment);
		model.addAttribute("page", page);
		return "modules/report/ironfofeatdepartmentReportList";
	}

	/**
	 * 查看，增加，编辑2.4.1特色科室表单页面
	 */
	@RequiresPermissions(value={"ironfofeatdepartmenttestreport:ironfofeatdepartment:view","ironfofeatdepartmenttestreport:ironfofeatdepartment:add","ironfofeatdepartmenttestreport:ironfofeatdepartment:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfofeatdepartmentReport ironfofeatdepartment, Model model) {
		model.addAttribute("ironfofeatdepartment", ironfofeatdepartment);
		return "report/ironfofeatdepartmenttestreport/ironfofeatdepartmentForm";
	}

	/**
	 * 保存2.4.1特色科室
	 */
	@RequiresPermissions(value={"ironfofeatdepartmenttestreport:ironfofeatdepartment:add","ironfofeatdepartmenttestreport:ironfofeatdepartment:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfofeatdepartmentReport ironfofeatdepartment, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfofeatdepartment)){
			return form(ironfofeatdepartment, model);
		}
		if(!ironfofeatdepartment.getIsNewRecord()){//编辑表单保存
			IronfofeatdepartmentReport t = ironfofeatdepartmentService.get(ironfofeatdepartment.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfofeatdepartment, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfofeatdepartmentService.save(t);//保存
		}else{//新增表单保存
			ironfofeatdepartmentService.save(ironfofeatdepartment);//保存
		}
		addMessage(redirectAttributes, "保存2.4.1特色科室成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofeatdepartmenttestreport/ironfofeatdepartment/?repage";
	}
	
	/**
	 * 删除2.4.1特色科室
	 */
	@RequiresPermissions("ironfofeatdepartmenttestreport:ironfofeatdepartment:del")
	@RequestMapping(value = "delete")
	public String delete(IronfofeatdepartmentReport ironfofeatdepartment, RedirectAttributes redirectAttributes) {
		ironfofeatdepartmentService.delete(ironfofeatdepartment);
		addMessage(redirectAttributes, "删除2.4.1特色科室成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofeatdepartmenttestreport/ironfofeatdepartment/?repage";
	}
	
	/**
	 * 批量删除2.4.1特色科室
	 */
	@RequiresPermissions("ironfofeatdepartmenttestreport:ironfofeatdepartment:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfofeatdepartmentService.delete(ironfofeatdepartmentService.get(id));
		}
		addMessage(redirectAttributes, "删除2.4.1特色科室成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofeatdepartmenttestreport/ironfofeatdepartment/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfofeatdepartmenttestreport:ironfofeatdepartment:export")
    @RequestMapping(value = "export", method=RequestMethod.GET)
    public String exportFile(IronfofeatdepartmentReport ironfofeatdepartment, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		/*try {
            String fileName = "2.4.1特色科室"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfofeatdepartmentReport> page = ironfofeatdepartmentService.findPage(new Page<IronfofeatdepartmentReport>(request, response, -1), ironfofeatdepartment);
    		new ExportExcel("2.4.1特色科室", IronfofeatdepartmentReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出2.4.1特色科室记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofeatdepartmenttestreport/ironfofeatdepartment/?repage";*/
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfofeatdepartment.getDuser() != null && ironfofeatdepartment.getDuser().toString() != null
					&& ironfofeatdepartment.getDuser().toString().trim() != null
					&& !"".equals(ironfofeatdepartment.getDuser().toString().trim())
					&& !"null".equals(ironfofeatdepartment.getDuser().toString().trim())) {
				userId = ironfofeatdepartment.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			ironfofeatdepartment.setDoc_id(title.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "2.4.1特色科室"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfofeatdepartmentReport> page = ironfofeatdepartmentService.findPage(new Page<IronfofeatdepartmentReport>(request, response, -1), ironfofeatdepartment);
    		new ExportExcel("2.4.1特色科室", IronfofeatdepartmentReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出2.4.1特色科室记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfomedicalservicesdatas/ironfoMedicalServices/?repage";
		
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfofeatdepartmenttestreport:ironfofeatdepartment:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfofeatdepartmentReport> list = ei.getDataList(IronfofeatdepartmentReport.class);
			for (IronfofeatdepartmentReport ironfofeatdepartment : list){
				try{
					ironfofeatdepartmentService.save(ironfofeatdepartment);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条2.4.1特色科室记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条2.4.1特色科室记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入2.4.1特色科室失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofeatdepartmenttestreport/ironfofeatdepartment/?repage";
    }
	
	/**
	 * 下载导入2.4.1特色科室数据模板
	 */
	@RequiresPermissions("ironfofeatdepartmenttestreport:ironfofeatdepartment:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "2.4.1特色科室数据导入模板.xlsx";
    		List<IronfofeatdepartmentReport> list = Lists.newArrayList(); 
    		new ExportExcel("2.4.1特色科室数据", IronfofeatdepartmentReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofeatdepartmenttestreport/ironfofeatdepartment/?repage";
    }
	
	
	

}