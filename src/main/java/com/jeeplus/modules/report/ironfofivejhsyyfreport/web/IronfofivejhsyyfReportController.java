/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofivejhsyyfreport.web;

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
import com.jeeplus.modules.report.ironfofivejhsyyfreport.entity.IronfofivejhsyyfReport;
import com.jeeplus.modules.report.ironfofivejhsyyfreport.service.IronfofivejhsyyfReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 5.6计划生育用房Controller
 * @author anti_magina
 * @version 2018-04-23
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfofivejhsyyfreport/ironfofivejhsyyf")
public class IronfofivejhsyyfReportController extends BaseController {

	@Autowired
	private IronfofivejhsyyfReportService ironfofivejhsyyfService;
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	@ModelAttribute
	public IronfofivejhsyyfReport get(@RequestParam(required=false) String id) {
		IronfofivejhsyyfReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfofivejhsyyfService.get(id);
		}
		if (entity == null){
			entity = new IronfofivejhsyyfReport();
		}
		return entity;
	}
	
	/**
	 * 5.6计划生育用房列表页面
	 */
	@RequiresPermissions("ironfofivejhsyyfreport:ironfofivejhsyyf:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfofivejhsyyfReport ironfofivejhsyyf, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfofivejhsyyf.getDuser() != null&&ironfofivejhsyyf.getDuser().toString() != null && ironfofivejhsyyf.getDuser().toString().trim() != null
					&& !"".equals(ironfofivejhsyyf.getDuser().toString().trim())
					&& !"null".equals(ironfofivejhsyyf.getDuser().toString().trim())) {
				userId = ironfofivejhsyyf.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfofivejhsyyf.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Page<IronfofivejhsyyfReport> page = ironfofivejhsyyfService.findPage(new Page<IronfofivejhsyyfReport>(request, response), ironfofivejhsyyf); 
		model.addAttribute("page", page);
		return "modules/report/ironfofivejhsyyfreport/ironfofivejhsyyfList";
	}

	/**
	 * 查看，增加，编辑5.6计划生育用房表单页面
	 */
	@RequiresPermissions(value={"ironfofivejhsyyfreport:ironfofivejhsyyf:view","ironfofivejhsyyfreport:ironfofivejhsyyf:add","ironfofivejhsyyfreport:ironfofivejhsyyf:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfofivejhsyyfReport ironfofivejhsyyf, Model model) {
		model.addAttribute("ironfofivejhsyyf", ironfofivejhsyyf);
		return "report/ironfofivejhsyyfreport/ironfofivejhsyyfForm";
	}

	/**
	 * 保存5.6计划生育用房
	 */
	@RequiresPermissions(value={"ironfofivejhsyyfreport:ironfofivejhsyyf:add","ironfofivejhsyyfreport:ironfofivejhsyyf:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfofivejhsyyfReport ironfofivejhsyyf, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfofivejhsyyf)){
			return form(ironfofivejhsyyf, model);
		}
		if(!ironfofivejhsyyf.getIsNewRecord()){//编辑表单保存
			IronfofivejhsyyfReport t = ironfofivejhsyyfService.get(ironfofivejhsyyf.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfofivejhsyyf, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfofivejhsyyfService.save(t);//保存
		}else{//新增表单保存
			ironfofivejhsyyfService.save(ironfofivejhsyyf);//保存
		}
		addMessage(redirectAttributes, "保存5.6计划生育用房成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivejhsyyfreport/ironfofivejhsyyf/?repage";
	}
	
	/**
	 * 删除5.6计划生育用房
	 */
	@RequiresPermissions("ironfofivejhsyyfreport:ironfofivejhsyyf:del")
	@RequestMapping(value = "delete")
	public String delete(IronfofivejhsyyfReport ironfofivejhsyyf, RedirectAttributes redirectAttributes) {
		ironfofivejhsyyfService.delete(ironfofivejhsyyf);
		addMessage(redirectAttributes, "删除5.6计划生育用房成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivejhsyyfreport/ironfofivejhsyyf/?repage";
	}
	
	/**
	 * 批量删除5.6计划生育用房
	 */
	@RequiresPermissions("ironfofivejhsyyfreport:ironfofivejhsyyf:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfofivejhsyyfService.delete(ironfofivejhsyyfService.get(id));
		}
		addMessage(redirectAttributes, "删除5.6计划生育用房成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivejhsyyfreport/ironfofivejhsyyf/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfofivejhsyyfreport:ironfofivejhsyyf:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfofivejhsyyfReport ironfofivejhsyyf, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfofivejhsyyf.getDuser() != null&&ironfofivejhsyyf.getDuser().toString() != null && ironfofivejhsyyf.getDuser().toString().trim() != null
					&& !"".equals(ironfofivejhsyyf.getDuser().toString().trim())
					&& !"null".equals(ironfofivejhsyyf.getDuser().toString().trim())) {
				userId = ironfofivejhsyyf.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfofivejhsyyf.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "5.6计划生育用房"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfofivejhsyyfReport> page = ironfofivejhsyyfService.findPage(new Page<IronfofivejhsyyfReport>(request, response, -1), ironfofivejhsyyf);
    		new ExportExcel("5.6计划生育用房", IronfofivejhsyyfReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出5.6计划生育用房记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/report/ironfofivejhsyyfreport/ironfofivejhsyyf/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfofivejhsyyfreport:ironfofivejhsyyf:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfofivejhsyyfReport> list = ei.getDataList(IronfofivejhsyyfReport.class);
			for (IronfofivejhsyyfReport ironfofivejhsyyf : list){
				try{
					ironfofivejhsyyfService.save(ironfofivejhsyyf);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条5.6计划生育用房记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条5.6计划生育用房记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入5.6计划生育用房失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivejhsyyfreport/ironfofivejhsyyf/?repage";
    }
	
	/**
	 * 下载导入5.6计划生育用房数据模板
	 */
	@RequiresPermissions("ironfofivejhsyyfreport:ironfofivejhsyyf:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "5.6计划生育用房数据导入模板.xlsx";
    		List<IronfofivejhsyyfReport> list = Lists.newArrayList(); 
    		new ExportExcel("5.6计划生育用房数据", IronfofivejhsyyfReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivejhsyyfreport/ironfofivejhsyyf/?repage";
    }
	
	
	

}