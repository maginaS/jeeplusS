/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofivesssglreport.web;

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
import com.jeeplus.modules.report.ironfofivesssglreport.entity.IronfofivesssglReport;
import com.jeeplus.modules.report.ironfofivesssglreport.service.IronfofivesssglReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 5.11手术室Controller
 * @author anti_magina
 * @version 2018-04-23
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfofivesssglreport/ironfofivesssgl")
public class IronfofivesssglReportController extends BaseController {

	@Autowired
	private IronfofivesssglReportService ironfofivesssglService;
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	@ModelAttribute
	public IronfofivesssglReport get(@RequestParam(required=false) String id) {
		IronfofivesssglReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfofivesssglService.get(id);
		}
		if (entity == null){
			entity = new IronfofivesssglReport();
		}
		return entity;
	}
	
	/**
	 * 5.11手术室列表页面
	 */
	@RequiresPermissions("ironfofivesssglreport:ironfofivesssgl:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfofivesssglReport ironfofivesssgl, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfofivesssgl.getDuser() != null&&ironfofivesssgl.getDuser().toString() != null && ironfofivesssgl.getDuser().toString().trim() != null
					&& !"".equals(ironfofivesssgl.getDuser().toString().trim())
					&& !"null".equals(ironfofivesssgl.getDuser().toString().trim())) {
				userId = ironfofivesssgl.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfofivesssgl.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Page<IronfofivesssglReport> page = ironfofivesssglService.findPage(new Page<IronfofivesssglReport>(request, response), ironfofivesssgl); 
		model.addAttribute("page", page);
		return "modules/report/ironfofivesssglreport/ironfofivesssglList";
	}

	/**
	 * 查看，增加，编辑5.11手术室表单页面
	 */
	@RequiresPermissions(value={"ironfofivesssglreport:ironfofivesssgl:view","ironfofivesssglreport:ironfofivesssgl:add","ironfofivesssglreport:ironfofivesssgl:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfofivesssglReport ironfofivesssgl, Model model) {
		model.addAttribute("ironfofivesssgl", ironfofivesssgl);
		return "report/ironfofivesssglreport/ironfofivesssglForm";
	}

	/**
	 * 保存5.11手术室
	 */
	@RequiresPermissions(value={"ironfofivesssglreport:ironfofivesssgl:add","ironfofivesssglreport:ironfofivesssgl:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfofivesssglReport ironfofivesssgl, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfofivesssgl)){
			return form(ironfofivesssgl, model);
		}
		if(!ironfofivesssgl.getIsNewRecord()){//编辑表单保存
			IronfofivesssglReport t = ironfofivesssglService.get(ironfofivesssgl.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfofivesssgl, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfofivesssglService.save(t);//保存
		}else{//新增表单保存
			ironfofivesssglService.save(ironfofivesssgl);//保存
		}
		addMessage(redirectAttributes, "保存5.11手术室成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivesssglreport/ironfofivesssgl/?repage";
	}
	
	/**
	 * 删除5.11手术室
	 */
	@RequiresPermissions("ironfofivesssglreport:ironfofivesssgl:del")
	@RequestMapping(value = "delete")
	public String delete(IronfofivesssglReport ironfofivesssgl, RedirectAttributes redirectAttributes) {
		ironfofivesssglService.delete(ironfofivesssgl);
		addMessage(redirectAttributes, "删除5.11手术室成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivesssglreport/ironfofivesssgl/?repage";
	}
	
	/**
	 * 批量删除5.11手术室
	 */
	@RequiresPermissions("ironfofivesssglreport:ironfofivesssgl:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfofivesssglService.delete(ironfofivesssglService.get(id));
		}
		addMessage(redirectAttributes, "删除5.11手术室成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivesssglreport/ironfofivesssgl/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfofivesssglreport:ironfofivesssgl:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfofivesssglReport ironfofivesssgl, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfofivesssgl.getDuser() != null&&ironfofivesssgl.getDuser().toString() != null && ironfofivesssgl.getDuser().toString().trim() != null
					&& !"".equals(ironfofivesssgl.getDuser().toString().trim())
					&& !"null".equals(ironfofivesssgl.getDuser().toString().trim())) {
				userId = ironfofivesssgl.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfofivesssgl.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "5.11手术室"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfofivesssglReport> page = ironfofivesssglService.findPage(new Page<IronfofivesssglReport>(request, response, -1), ironfofivesssgl);
    		new ExportExcel("5.11手术室", IronfofivesssglReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出5.11手术室记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/report/ironfofivesssglreport/ironfofivesssgl/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfofivesssglreport:ironfofivesssgl:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfofivesssglReport> list = ei.getDataList(IronfofivesssglReport.class);
			for (IronfofivesssglReport ironfofivesssgl : list){
				try{
					ironfofivesssglService.save(ironfofivesssgl);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条5.11手术室记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条5.11手术室记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入5.11手术室失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivesssglreport/ironfofivesssgl/?repage";
    }
	
	/**
	 * 下载导入5.11手术室数据模板
	 */
	@RequiresPermissions("ironfofivesssglreport:ironfofivesssgl:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "5.11手术室数据导入模板.xlsx";
    		List<IronfofivesssglReport> list = Lists.newArrayList(); 
    		new ExportExcel("5.11手术室数据", IronfofivesssglReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivesssglreport/ironfofivesssgl/?repage";
    }
	
	
	

}