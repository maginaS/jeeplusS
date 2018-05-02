/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfopopulationfreport.web;

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
import com.jeeplus.modules.report.ironfopopulationfreport.entity.IronfopopulationfReport;
import com.jeeplus.modules.report.ironfopopulationfreport.service.IronfopopulationfReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 5.1.2建筑分布概况Controller
 * @author anti_magina
 * @version 2018-04-23
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfopopulationfreport/ironfopopulationf")
public class IronfopopulationfReportController extends BaseController {

	@Autowired
	private IronfopopulationfReportService ironfopopulationfService;
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	@ModelAttribute
	public IronfopopulationfReport get(@RequestParam(required=false) String id) {
		IronfopopulationfReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfopopulationfService.get(id);
		}
		if (entity == null){
			entity = new IronfopopulationfReport();
		}
		return entity;
	}
	
	/**
	 * 5.1.2建筑分布概况列表页面
	 */
	@RequiresPermissions("ironfopopulationfreport:ironfopopulationf:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfopopulationfReport ironfopopulationf, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfopopulationf.getDuser() != null&&ironfopopulationf.getDuser().toString() != null && ironfopopulationf.getDuser().toString().trim() != null
					&& !"".equals(ironfopopulationf.getDuser().toString().trim())
					&& !"null".equals(ironfopopulationf.getDuser().toString().trim())) {
				userId = ironfopopulationf.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfopopulationf.setDocid(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Page<IronfopopulationfReport> page = ironfopopulationfService.findPage(new Page<IronfopopulationfReport>(request, response), ironfopopulationf); 
		model.addAttribute("page", page);
		return "modules/report/ironfopopulationfreport/ironfopopulationfList";
	}

	/**
	 * 查看，增加，编辑5.1.2建筑分布概况表单页面
	 */
	@RequiresPermissions(value={"ironfopopulationfreport:ironfopopulationf:view","ironfopopulationfreport:ironfopopulationf:add","ironfopopulationfreport:ironfopopulationf:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfopopulationfReport ironfopopulationf, Model model) {
		model.addAttribute("ironfopopulationf", ironfopopulationf);
		return "report/ironfopopulationfreport/ironfopopulationfForm";
	}

	/**
	 * 保存5.1.2建筑分布概况
	 */
	@RequiresPermissions(value={"ironfopopulationfreport:ironfopopulationf:add","ironfopopulationfreport:ironfopopulationf:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfopopulationfReport ironfopopulationf, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfopopulationf)){
			return form(ironfopopulationf, model);
		}
		if(!ironfopopulationf.getIsNewRecord()){//编辑表单保存
			IronfopopulationfReport t = ironfopopulationfService.get(ironfopopulationf.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfopopulationf, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfopopulationfService.save(t);//保存
		}else{//新增表单保存
			ironfopopulationfService.save(ironfopopulationf);//保存
		}
		addMessage(redirectAttributes, "保存5.1.2建筑分布概况成功");
		return "redirect:"+Global.getAdminPath()+"/ironfopopulationfreport/ironfopopulationf/?repage";
	}
	
	/**
	 * 删除5.1.2建筑分布概况
	 */
	@RequiresPermissions("ironfopopulationfreport:ironfopopulationf:del")
	@RequestMapping(value = "delete")
	public String delete(IronfopopulationfReport ironfopopulationf, RedirectAttributes redirectAttributes) {
		ironfopopulationfService.delete(ironfopopulationf);
		addMessage(redirectAttributes, "删除5.1.2建筑分布概况成功");
		return "redirect:"+Global.getAdminPath()+"/ironfopopulationfreport/ironfopopulationf/?repage";
	}
	
	/**
	 * 批量删除5.1.2建筑分布概况
	 */
	@RequiresPermissions("ironfopopulationfreport:ironfopopulationf:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfopopulationfService.delete(ironfopopulationfService.get(id));
		}
		addMessage(redirectAttributes, "删除5.1.2建筑分布概况成功");
		return "redirect:"+Global.getAdminPath()+"/ironfopopulationfreport/ironfopopulationf/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfopopulationfreport:ironfopopulationf:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfopopulationfReport ironfopopulationf, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfopopulationf.getDuser() != null&&ironfopopulationf.getDuser().toString() != null && ironfopopulationf.getDuser().toString().trim() != null
					&& !"".equals(ironfopopulationf.getDuser().toString().trim())
					&& !"null".equals(ironfopopulationf.getDuser().toString().trim())) {
				userId = ironfopopulationf.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfopopulationf.setDocid(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "5.1.2建筑分布概况"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfopopulationfReport> page = ironfopopulationfService.findPage(new Page<IronfopopulationfReport>(request, response, -1), ironfopopulationf);
    		new ExportExcel("5.1.2建筑分布概况", IronfopopulationfReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出5.1.2建筑分布概况记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"report/ironfopopulationfreport/ironfopopulationf/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfopopulationfreport:ironfopopulationf:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfopopulationfReport> list = ei.getDataList(IronfopopulationfReport.class);
			for (IronfopopulationfReport ironfopopulationf : list){
				try{
					ironfopopulationfService.save(ironfopopulationf);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条5.1.2建筑分布概况记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条5.1.2建筑分布概况记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入5.1.2建筑分布概况失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfopopulationfreport/ironfopopulationf/?repage";
    }
	
	/**
	 * 下载导入5.1.2建筑分布概况数据模板
	 */
	@RequiresPermissions("ironfopopulationfreport:ironfopopulationf:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "5.1.2建筑分布概况数据导入模板.xlsx";
    		List<IronfopopulationfReport> list = Lists.newArrayList(); 
    		new ExportExcel("5.1.2建筑分布概况数据", IronfopopulationfReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfopopulationfreport/ironfopopulationf/?repage";
    }
	
	
	

}