/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofivezyyfreport.web;

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
import com.jeeplus.modules.report.ironfofivezyyfreport.entity.IronfofivezyyfReport;
import com.jeeplus.modules.report.ironfofivezyyfreport.service.IronfofivezyyfReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 5.4住院用房Controller
 * @author anti_magina
 * @version 2018-04-23
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfofivezyyfreport/ironfofivezyyf")
public class IronfofivezyyfReportController extends BaseController {

	@Autowired
	private IronfofivezyyfReportService ironfofivezyyfService;
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	@ModelAttribute
	public IronfofivezyyfReport get(@RequestParam(required=false) String id) {
		IronfofivezyyfReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfofivezyyfService.get(id);
		}
		if (entity == null){
			entity = new IronfofivezyyfReport();
		}
		return entity;
	}
	
	/**
	 * 5.4住院用房列表页面
	 */
	@RequiresPermissions("ironfofivezyyfreport:ironfofivezyyf:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfofivezyyfReport ironfofivezyyf, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfofivezyyf.getDuser() != null&&ironfofivezyyf.getDuser().toString() != null && ironfofivezyyf.getDuser().toString().trim() != null
					&& !"".equals(ironfofivezyyf.getDuser().toString().trim())
					&& !"null".equals(ironfofivezyyf.getDuser().toString().trim())) {
				userId = ironfofivezyyf.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfofivezyyf.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Page<IronfofivezyyfReport> page = ironfofivezyyfService.findPage(new Page<IronfofivezyyfReport>(request, response), ironfofivezyyf); 
		model.addAttribute("page", page);
		return "modules/report/ironfofivezyyfreport/ironfofivezyyfList";
	}

	/**
	 * 查看，增加，编辑5.4住院用房表单页面
	 */
	@RequiresPermissions(value={"ironfofivezyyfreport:ironfofivezyyf:view","ironfofivezyyfreport:ironfofivezyyf:add","ironfofivezyyfreport:ironfofivezyyf:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfofivezyyfReport ironfofivezyyf, Model model) {
		model.addAttribute("ironfofivezyyf", ironfofivezyyf);
		return "report/ironfofivezyyfreport/ironfofivezyyfForm";
	}

	/**
	 * 保存5.4住院用房
	 */
	@RequiresPermissions(value={"ironfofivezyyfreport:ironfofivezyyf:add","ironfofivezyyfreport:ironfofivezyyf:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfofivezyyfReport ironfofivezyyf, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfofivezyyf)){
			return form(ironfofivezyyf, model);
		}
		if(!ironfofivezyyf.getIsNewRecord()){//编辑表单保存
			IronfofivezyyfReport t = ironfofivezyyfService.get(ironfofivezyyf.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfofivezyyf, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfofivezyyfService.save(t);//保存
		}else{//新增表单保存
			ironfofivezyyfService.save(ironfofivezyyf);//保存
		}
		addMessage(redirectAttributes, "保存5.4住院用房成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivezyyfreport/ironfofivezyyf/?repage";
	}
	
	/**
	 * 删除5.4住院用房
	 */
	@RequiresPermissions("ironfofivezyyfreport:ironfofivezyyf:del")
	@RequestMapping(value = "delete")
	public String delete(IronfofivezyyfReport ironfofivezyyf, RedirectAttributes redirectAttributes) {
		ironfofivezyyfService.delete(ironfofivezyyf);
		addMessage(redirectAttributes, "删除5.4住院用房成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivezyyfreport/ironfofivezyyf/?repage";
	}
	
	/**
	 * 批量删除5.4住院用房
	 */
	@RequiresPermissions("ironfofivezyyfreport:ironfofivezyyf:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfofivezyyfService.delete(ironfofivezyyfService.get(id));
		}
		addMessage(redirectAttributes, "删除5.4住院用房成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivezyyfreport/ironfofivezyyf/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfofivezyyfreport:ironfofivezyyf:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfofivezyyfReport ironfofivezyyf, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfofivezyyf.getDuser() != null&&ironfofivezyyf.getDuser().toString() != null && ironfofivezyyf.getDuser().toString().trim() != null
					&& !"".equals(ironfofivezyyf.getDuser().toString().trim())
					&& !"null".equals(ironfofivezyyf.getDuser().toString().trim())) {
				userId = ironfofivezyyf.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfofivezyyf.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "5.4住院用房"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfofivezyyfReport> page = ironfofivezyyfService.findPage(new Page<IronfofivezyyfReport>(request, response, -1), ironfofivezyyf);
    		new ExportExcel("5.4住院用房", IronfofivezyyfReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出5.4住院用房记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"report/ironfofivezyyfreport/ironfofivezyyf/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfofivezyyfreport:ironfofivezyyf:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfofivezyyfReport> list = ei.getDataList(IronfofivezyyfReport.class);
			for (IronfofivezyyfReport ironfofivezyyf : list){
				try{
					ironfofivezyyfService.save(ironfofivezyyf);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条5.4住院用房记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条5.4住院用房记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入5.4住院用房失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivezyyfreport/ironfofivezyyf/?repage";
    }
	
	/**
	 * 下载导入5.4住院用房数据模板
	 */
	@RequiresPermissions("ironfofivezyyfreport:ironfofivezyyf:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "5.4住院用房数据导入模板.xlsx";
    		List<IronfofivezyyfReport> list = Lists.newArrayList(); 
    		new ExportExcel("5.4住院用房数据", IronfofivezyyfReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivezyyfreport/ironfofivezyyf/?repage";
    }
	
	
	

}