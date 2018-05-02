/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofivezgshyfreport.web;

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
import com.jeeplus.modules.report.ironfofivezgshyfreport.entity.IronfofivezgshyfReport;
import com.jeeplus.modules.report.ironfofivezgshyfreport.service.IronfofivezgshyfReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 5.8职工生活用房Controller
 * @author anti_magina
 * @version 2018-04-23
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfofivezgshyfreport/ironfofivezgshyf")
public class IronfofivezgshyfReportController extends BaseController {

	@Autowired
	private IronfofivezgshyfReportService ironfofivezgshyfService;
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	@ModelAttribute
	public IronfofivezgshyfReport get(@RequestParam(required=false) String id) {
		IronfofivezgshyfReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfofivezgshyfService.get(id);
		}
		if (entity == null){
			entity = new IronfofivezgshyfReport();
		}
		return entity;
	}
	
	/**
	 * 5.8职工生活用房列表页面
	 */
	@RequiresPermissions("ironfofivezgshyfreport:ironfofivezgshyf:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfofivezgshyfReport ironfofivezgshyf, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfofivezgshyf.getDuser() != null&&ironfofivezgshyf.getDuser().toString() != null && ironfofivezgshyf.getDuser().toString().trim() != null
					&& !"".equals(ironfofivezgshyf.getDuser().toString().trim())
					&& !"null".equals(ironfofivezgshyf.getDuser().toString().trim())) {
				userId = ironfofivezgshyf.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfofivezgshyf.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Page<IronfofivezgshyfReport> page = ironfofivezgshyfService.findPage(new Page<IronfofivezgshyfReport>(request, response), ironfofivezgshyf); 
		model.addAttribute("page", page);
		return "modules/report/ironfofivezgshyfreport/ironfofivezgshyfList";
	}

	/**
	 * 查看，增加，编辑5.8职工生活用房表单页面
	 */
	@RequiresPermissions(value={"ironfofivezgshyfreport:ironfofivezgshyf:view","ironfofivezgshyfreport:ironfofivezgshyf:add","ironfofivezgshyfreport:ironfofivezgshyf:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfofivezgshyfReport ironfofivezgshyf, Model model) {
		model.addAttribute("ironfofivezgshyf", ironfofivezgshyf);
		return "report/ironfofivezgshyfreport/ironfofivezgshyfForm";
	}

	/**
	 * 保存5.8职工生活用房
	 */
	@RequiresPermissions(value={"ironfofivezgshyfreport:ironfofivezgshyf:add","ironfofivezgshyfreport:ironfofivezgshyf:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfofivezgshyfReport ironfofivezgshyf, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfofivezgshyf)){
			return form(ironfofivezgshyf, model);
		}
		if(!ironfofivezgshyf.getIsNewRecord()){//编辑表单保存
			IronfofivezgshyfReport t = ironfofivezgshyfService.get(ironfofivezgshyf.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfofivezgshyf, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfofivezgshyfService.save(t);//保存
		}else{//新增表单保存
			ironfofivezgshyfService.save(ironfofivezgshyf);//保存
		}
		addMessage(redirectAttributes, "保存5.8职工生活用房成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivezgshyfreport/ironfofivezgshyf/?repage";
	}
	
	/**
	 * 删除5.8职工生活用房
	 */
	@RequiresPermissions("ironfofivezgshyfreport:ironfofivezgshyf:del")
	@RequestMapping(value = "delete")
	public String delete(IronfofivezgshyfReport ironfofivezgshyf, RedirectAttributes redirectAttributes) {
		ironfofivezgshyfService.delete(ironfofivezgshyf);
		addMessage(redirectAttributes, "删除5.8职工生活用房成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivezgshyfreport/ironfofivezgshyf/?repage";
	}
	
	/**
	 * 批量删除5.8职工生活用房
	 */
	@RequiresPermissions("ironfofivezgshyfreport:ironfofivezgshyf:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfofivezgshyfService.delete(ironfofivezgshyfService.get(id));
		}
		addMessage(redirectAttributes, "删除5.8职工生活用房成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivezgshyfreport/ironfofivezgshyf/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfofivezgshyfreport:ironfofivezgshyf:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfofivezgshyfReport ironfofivezgshyf, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfofivezgshyf.getDuser() != null&&ironfofivezgshyf.getDuser().toString() != null && ironfofivezgshyf.getDuser().toString().trim() != null
					&& !"".equals(ironfofivezgshyf.getDuser().toString().trim())
					&& !"null".equals(ironfofivezgshyf.getDuser().toString().trim())) {
				userId = ironfofivezgshyf.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfofivezgshyf.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "5.8职工生活用房"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfofivezgshyfReport> page = ironfofivezgshyfService.findPage(new Page<IronfofivezgshyfReport>(request, response, -1), ironfofivezgshyf);
    		new ExportExcel("5.8职工生活用房", IronfofivezgshyfReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出5.8职工生活用房记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/report/ironfofivezgshyfreport/ironfofivezgshyf/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfofivezgshyfreport:ironfofivezgshyf:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfofivezgshyfReport> list = ei.getDataList(IronfofivezgshyfReport.class);
			for (IronfofivezgshyfReport ironfofivezgshyf : list){
				try{
					ironfofivezgshyfService.save(ironfofivezgshyf);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条5.8职工生活用房记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条5.8职工生活用房记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入5.8职工生活用房失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivezgshyfreport/ironfofivezgshyf/?repage";
    }
	
	/**
	 * 下载导入5.8职工生活用房数据模板
	 */
	@RequiresPermissions("ironfofivezgshyfreport:ironfofivezgshyf:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "5.8职工生活用房数据导入模板.xlsx";
    		List<IronfofivezgshyfReport> list = Lists.newArrayList(); 
    		new ExportExcel("5.8职工生活用房数据", IronfofivezgshyfReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivezgshyfreport/ironfofivezgshyf/?repage";
    }
	
	
	

}