/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofivemjzyfreport.web;

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
import com.jeeplus.modules.report.ironfofivemjzyfreport.entity.IronfofivemjzyfReport;
import com.jeeplus.modules.report.ironfofivemjzyfreport.service.IronfofivemjzyfReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 5.2门急诊用房Controller
 * @author anti_magina
 * @version 2018-04-23
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfofivemjzyfreport/ironfofivemjzyf")
public class IronfofivemjzyfReportController extends BaseController {

	@Autowired
	private IronfofivemjzyfReportService ironfofivemjzyfService;
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	@ModelAttribute
	public IronfofivemjzyfReport get(@RequestParam(required=false) String id) {
		IronfofivemjzyfReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfofivemjzyfService.get(id);
		}
		if (entity == null){
			entity = new IronfofivemjzyfReport();
		}
		return entity;
	}
	
	/**
	 * 5.2门急诊用房列表页面
	 */
	@RequiresPermissions("ironfofivemjzyfreport:ironfofivemjzyf:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfofivemjzyfReport ironfofivemjzyf, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfofivemjzyf.getDuser() != null&&ironfofivemjzyf.getDuser().toString() != null && ironfofivemjzyf.getDuser().toString().trim() != null
					&& !"".equals(ironfofivemjzyf.getDuser().toString().trim())
					&& !"null".equals(ironfofivemjzyf.getDuser().toString().trim())) {
				userId = ironfofivemjzyf.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfofivemjzyf.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Page<IronfofivemjzyfReport> page = ironfofivemjzyfService.findPage(new Page<IronfofivemjzyfReport>(request, response), ironfofivemjzyf); 
		model.addAttribute("page", page);
		return "modules/report/ironfofivemjzyfreport/ironfofivemjzyfList";
	}

	/**
	 * 查看，增加，编辑5.2门急诊用房表单页面
	 */
	@RequiresPermissions(value={"ironfofivemjzyfreport:ironfofivemjzyf:view","ironfofivemjzyfreport:ironfofivemjzyf:add","ironfofivemjzyfreport:ironfofivemjzyf:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfofivemjzyfReport ironfofivemjzyf, Model model) {
		model.addAttribute("ironfofivemjzyf", ironfofivemjzyf);
		return "report/ironfofivemjzyfreport/ironfofivemjzyfForm";
	}

	/**
	 * 保存5.2门急诊用房
	 */
	@RequiresPermissions(value={"ironfofivemjzyfreport:ironfofivemjzyf:add","ironfofivemjzyfreport:ironfofivemjzyf:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfofivemjzyfReport ironfofivemjzyf, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfofivemjzyf)){
			return form(ironfofivemjzyf, model);
		}
		if(!ironfofivemjzyf.getIsNewRecord()){//编辑表单保存
			IronfofivemjzyfReport t = ironfofivemjzyfService.get(ironfofivemjzyf.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfofivemjzyf, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfofivemjzyfService.save(t);//保存
		}else{//新增表单保存
			ironfofivemjzyfService.save(ironfofivemjzyf);//保存
		}
		addMessage(redirectAttributes, "保存5.2门急诊用房成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivemjzyfreport/ironfofivemjzyf/?repage";
	}
	
	/**
	 * 删除5.2门急诊用房
	 */
	@RequiresPermissions("ironfofivemjzyfreport:ironfofivemjzyf:del")
	@RequestMapping(value = "delete")
	public String delete(IronfofivemjzyfReport ironfofivemjzyf, RedirectAttributes redirectAttributes) {
		ironfofivemjzyfService.delete(ironfofivemjzyf);
		addMessage(redirectAttributes, "删除5.2门急诊用房成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivemjzyfreport/ironfofivemjzyf/?repage";
	}
	
	/**
	 * 批量删除5.2门急诊用房
	 */
	@RequiresPermissions("ironfofivemjzyfreport:ironfofivemjzyf:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfofivemjzyfService.delete(ironfofivemjzyfService.get(id));
		}
		addMessage(redirectAttributes, "删除5.2门急诊用房成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivemjzyfreport/ironfofivemjzyf/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfofivemjzyfreport:ironfofivemjzyf:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfofivemjzyfReport ironfofivemjzyf, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfofivemjzyf.getDuser() != null&&ironfofivemjzyf.getDuser().toString() != null && ironfofivemjzyf.getDuser().toString().trim() != null
					&& !"".equals(ironfofivemjzyf.getDuser().toString().trim())
					&& !"null".equals(ironfofivemjzyf.getDuser().toString().trim())) {
				userId = ironfofivemjzyf.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfofivemjzyf.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "5.2门急诊用房"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfofivemjzyfReport> page = ironfofivemjzyfService.findPage(new Page<IronfofivemjzyfReport>(request, response, -1), ironfofivemjzyf);
    		new ExportExcel("5.2门急诊用房", IronfofivemjzyfReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出5.2门急诊用房记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/report/ironfofivemjzyfreport/ironfofivemjzyf/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfofivemjzyfreport:ironfofivemjzyf:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfofivemjzyfReport> list = ei.getDataList(IronfofivemjzyfReport.class);
			for (IronfofivemjzyfReport ironfofivemjzyf : list){
				try{
					ironfofivemjzyfService.save(ironfofivemjzyf);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条5.2门急诊用房记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条5.2门急诊用房记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入5.2门急诊用房失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivemjzyfreport/ironfofivemjzyf/?repage";
    }
	
	/**
	 * 下载导入5.2门急诊用房数据模板
	 */
	@RequiresPermissions("ironfofivemjzyfreport:ironfofivemjzyf:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "5.2门急诊用房数据导入模板.xlsx";
    		List<IronfofivemjzyfReport> list = Lists.newArrayList(); 
    		new ExportExcel("5.2门急诊用房数据", IronfofivemjzyfReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivemjzyfreport/ironfofivemjzyf/?repage";
    }
	
	
	

}