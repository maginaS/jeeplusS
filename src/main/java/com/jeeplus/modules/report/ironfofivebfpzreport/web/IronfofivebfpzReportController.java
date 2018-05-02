/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofivebfpzreport.web;

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
import com.jeeplus.modules.report.ironfofivebfpzreport.entity.IronfofivebfpzReport;
import com.jeeplus.modules.report.ironfofivebfpzreport.service.IronfofivebfpzReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 5.3病房Controller
 * @author anti_magina
 * @version 2018-04-23
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfofivebfpzreport/ironfofivebfpz")
public class IronfofivebfpzReportController extends BaseController {

	@Autowired
	private IronfofivebfpzReportService ironfofivebfpzService;
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	@ModelAttribute
	public IronfofivebfpzReport get(@RequestParam(required=false) String id) {
		IronfofivebfpzReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfofivebfpzService.get(id);
		}
		if (entity == null){
			entity = new IronfofivebfpzReport();
		}
		return entity;
	}
	
	/**
	 * 5.3病房列表页面
	 */
	@RequiresPermissions("ironfofivebfpzreport:ironfofivebfpz:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfofivebfpzReport ironfofivebfpz, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfofivebfpz.getDuser() != null&&ironfofivebfpz.getDuser().toString() != null && ironfofivebfpz.getDuser().toString().trim() != null
					&& !"".equals(ironfofivebfpz.getDuser().toString().trim())
					&& !"null".equals(ironfofivebfpz.getDuser().toString().trim())) {
				userId = ironfofivebfpz.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfofivebfpz.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Page<IronfofivebfpzReport> page = ironfofivebfpzService.findPage(new Page<IronfofivebfpzReport>(request, response), ironfofivebfpz); 
		model.addAttribute("page", page);
		return "modules/report/ironfofivebfpzreport/ironfofivebfpzList";
	}

	/**
	 * 查看，增加，编辑5.3病房表单页面
	 */
	@RequiresPermissions(value={"ironfofivebfpzreport:ironfofivebfpz:view","ironfofivebfpzreport:ironfofivebfpz:add","ironfofivebfpzreport:ironfofivebfpz:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfofivebfpzReport ironfofivebfpz, Model model) {
		model.addAttribute("ironfofivebfpz", ironfofivebfpz);
		return "report/ironfofivebfpzreport/ironfofivebfpzForm";
	}

	/**
	 * 保存5.3病房
	 */
	@RequiresPermissions(value={"ironfofivebfpzreport:ironfofivebfpz:add","ironfofivebfpzreport:ironfofivebfpz:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfofivebfpzReport ironfofivebfpz, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfofivebfpz)){
			return form(ironfofivebfpz, model);
		}
		if(!ironfofivebfpz.getIsNewRecord()){//编辑表单保存
			IronfofivebfpzReport t = ironfofivebfpzService.get(ironfofivebfpz.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfofivebfpz, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfofivebfpzService.save(t);//保存
		}else{//新增表单保存
			ironfofivebfpzService.save(ironfofivebfpz);//保存
		}
		addMessage(redirectAttributes, "保存5.3病房成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivebfpzreport/ironfofivebfpz/?repage";
	}
	
	/**
	 * 删除5.3病房
	 */
	@RequiresPermissions("ironfofivebfpzreport:ironfofivebfpz:del")
	@RequestMapping(value = "delete")
	public String delete(IronfofivebfpzReport ironfofivebfpz, RedirectAttributes redirectAttributes) {
		ironfofivebfpzService.delete(ironfofivebfpz);
		addMessage(redirectAttributes, "删除5.3病房成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivebfpzreport/ironfofivebfpz/?repage";
	}
	
	/**
	 * 批量删除5.3病房
	 */
	@RequiresPermissions("ironfofivebfpzreport:ironfofivebfpz:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfofivebfpzService.delete(ironfofivebfpzService.get(id));
		}
		addMessage(redirectAttributes, "删除5.3病房成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivebfpzreport/ironfofivebfpz/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfofivebfpzreport:ironfofivebfpz:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfofivebfpzReport ironfofivebfpz, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfofivebfpz.getDuser() != null&&ironfofivebfpz.getDuser().toString() != null && ironfofivebfpz.getDuser().toString().trim() != null
					&& !"".equals(ironfofivebfpz.getDuser().toString().trim())
					&& !"null".equals(ironfofivebfpz.getDuser().toString().trim())) {
				userId = ironfofivebfpz.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfofivebfpz.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "5.3病房"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfofivebfpzReport> page = ironfofivebfpzService.findPage(new Page<IronfofivebfpzReport>(request, response, -1), ironfofivebfpz);
    		new ExportExcel("5.3病房", IronfofivebfpzReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出5.3病房记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/report/ironfofivebfpzreport/ironfofivebfpz/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfofivebfpzreport:ironfofivebfpz:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfofivebfpzReport> list = ei.getDataList(IronfofivebfpzReport.class);
			for (IronfofivebfpzReport ironfofivebfpz : list){
				try{
					ironfofivebfpzService.save(ironfofivebfpz);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条5.3病房记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条5.3病房记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入5.3病房失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivebfpzreport/ironfofivebfpz/?repage";
    }
	
	/**
	 * 下载导入5.3病房数据模板
	 */
	@RequiresPermissions("ironfofivebfpzreport:ironfofivebfpz:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "5.3病房数据导入模板.xlsx";
    		List<IronfofivebfpzReport> list = Lists.newArrayList(); 
    		new ExportExcel("5.3病房数据", IronfofivebfpzReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivebfpzreport/ironfofivebfpz/?repage";
    }
	
	
	

}