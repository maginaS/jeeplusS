/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofiveggwsyfreport.web;

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
import com.jeeplus.modules.report.ironfofiveggwsyfreport.entity.IronfofiveggwsyfReport;
import com.jeeplus.modules.report.ironfofiveggwsyfreport.service.IronfofiveggwsyfReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 5.5公共卫生用房Controller
 * @author anti_magina
 * @version 2018-04-23
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfofiveggwsyfreport/ironfofiveggwsyf")
public class IronfofiveggwsyfReportController extends BaseController {

	@Autowired
	private IronfofiveggwsyfReportService ironfofiveggwsyfService;
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	@ModelAttribute
	public IronfofiveggwsyfReport get(@RequestParam(required=false) String id) {
		IronfofiveggwsyfReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfofiveggwsyfService.get(id);
		}
		if (entity == null){
			entity = new IronfofiveggwsyfReport();
		}
		return entity;
	}
	
	/**
	 * 5.5公共卫生用房列表页面
	 */
	@RequiresPermissions("ironfofiveggwsyfreport:ironfofiveggwsyf:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfofiveggwsyfReport ironfofiveggwsyf, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfofiveggwsyf.getDuser() != null&&ironfofiveggwsyf.getDuser().toString() != null && ironfofiveggwsyf.getDuser().toString().trim() != null
					&& !"".equals(ironfofiveggwsyf.getDuser().toString().trim())
					&& !"null".equals(ironfofiveggwsyf.getDuser().toString().trim())) {
				userId = ironfofiveggwsyf.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfofiveggwsyf.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Page<IronfofiveggwsyfReport> page = ironfofiveggwsyfService.findPage(new Page<IronfofiveggwsyfReport>(request, response), ironfofiveggwsyf); 
		model.addAttribute("page", page);
		return "modules/report/ironfofiveggwsyfreport/ironfofiveggwsyfList";
	}

	/**
	 * 查看，增加，编辑5.5公共卫生用房表单页面
	 */
	@RequiresPermissions(value={"ironfofiveggwsyfreport:ironfofiveggwsyf:view","ironfofiveggwsyfreport:ironfofiveggwsyf:add","ironfofiveggwsyfreport:ironfofiveggwsyf:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfofiveggwsyfReport ironfofiveggwsyf, Model model) {
		model.addAttribute("ironfofiveggwsyf", ironfofiveggwsyf);
		return "report/ironfofiveggwsyfreport/ironfofiveggwsyfForm";
	}

	/**
	 * 保存5.5公共卫生用房
	 */
	@RequiresPermissions(value={"ironfofiveggwsyfreport:ironfofiveggwsyf:add","ironfofiveggwsyfreport:ironfofiveggwsyf:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfofiveggwsyfReport ironfofiveggwsyf, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfofiveggwsyf)){
			return form(ironfofiveggwsyf, model);
		}
		if(!ironfofiveggwsyf.getIsNewRecord()){//编辑表单保存
			IronfofiveggwsyfReport t = ironfofiveggwsyfService.get(ironfofiveggwsyf.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfofiveggwsyf, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfofiveggwsyfService.save(t);//保存
		}else{//新增表单保存
			ironfofiveggwsyfService.save(ironfofiveggwsyf);//保存
		}
		addMessage(redirectAttributes, "保存5.5公共卫生用房成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofiveggwsyfreport/ironfofiveggwsyf/?repage";
	}
	
	/**
	 * 删除5.5公共卫生用房
	 */
	@RequiresPermissions("ironfofiveggwsyfreport:ironfofiveggwsyf:del")
	@RequestMapping(value = "delete")
	public String delete(IronfofiveggwsyfReport ironfofiveggwsyf, RedirectAttributes redirectAttributes) {
		ironfofiveggwsyfService.delete(ironfofiveggwsyf);
		addMessage(redirectAttributes, "删除5.5公共卫生用房成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofiveggwsyfreport/ironfofiveggwsyf/?repage";
	}
	
	/**
	 * 批量删除5.5公共卫生用房
	 */
	@RequiresPermissions("ironfofiveggwsyfreport:ironfofiveggwsyf:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfofiveggwsyfService.delete(ironfofiveggwsyfService.get(id));
		}
		addMessage(redirectAttributes, "删除5.5公共卫生用房成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofiveggwsyfreport/ironfofiveggwsyf/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfofiveggwsyfreport:ironfofiveggwsyf:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfofiveggwsyfReport ironfofiveggwsyf, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfofiveggwsyf.getDuser() != null&&ironfofiveggwsyf.getDuser().toString() != null && ironfofiveggwsyf.getDuser().toString().trim() != null
					&& !"".equals(ironfofiveggwsyf.getDuser().toString().trim())
					&& !"null".equals(ironfofiveggwsyf.getDuser().toString().trim())) {
				userId = ironfofiveggwsyf.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfofiveggwsyf.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "5.5公共卫生用房"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfofiveggwsyfReport> page = ironfofiveggwsyfService.findPage(new Page<IronfofiveggwsyfReport>(request, response, -1), ironfofiveggwsyf);
    		new ExportExcel("5.5公共卫生用房", IronfofiveggwsyfReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出5.5公共卫生用房记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"report/ironfofiveggwsyfreport/ironfofiveggwsyf/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfofiveggwsyfreport:ironfofiveggwsyf:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfofiveggwsyfReport> list = ei.getDataList(IronfofiveggwsyfReport.class);
			for (IronfofiveggwsyfReport ironfofiveggwsyf : list){
				try{
					ironfofiveggwsyfService.save(ironfofiveggwsyf);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条5.5公共卫生用房记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条5.5公共卫生用房记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入5.5公共卫生用房失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofiveggwsyfreport/ironfofiveggwsyf/?repage";
    }
	
	/**
	 * 下载导入5.5公共卫生用房数据模板
	 */
	@RequiresPermissions("ironfofiveggwsyfreport:ironfofiveggwsyf:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "5.5公共卫生用房数据导入模板.xlsx";
    		List<IronfofiveggwsyfReport> list = Lists.newArrayList(); 
    		new ExportExcel("5.5公共卫生用房数据", IronfofiveggwsyfReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofiveggwsyfreport/ironfofiveggwsyf/?repage";
    }
	
	
	

}