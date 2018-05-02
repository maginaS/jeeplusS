/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfozybreport.web;

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
import com.jeeplus.modules.report.ironfozybreport.entity.IronfozybReport;
import com.jeeplus.modules.report.ironfozybreport.service.IronfozybReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 3.3住院部医疗设备配置Controller
 * @author anti_magina
 * @version 2018-04-19
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfozybreport/ironfozyb")
public class IronfozybReportController extends BaseController {

	@Autowired
	private IronfozybReportService ironfozybService;
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	@ModelAttribute
	public IronfozybReport get(@RequestParam(required=false) String id) {
		IronfozybReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfozybService.get(id);
		}
		if (entity == null){
			entity = new IronfozybReport();
		}
		return entity;
	}
	
	/**
	 * 3.3住院部医疗设备配置列表页面
	 */
	@RequiresPermissions("ironfozybreport:ironfozyb:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfozybReport ironfozyb, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfozyb.getDuser() != null&&ironfozyb.getDuser().toString() != null && ironfozyb.getDuser().toString().trim() != null
					&& !"".equals(ironfozyb.getDuser().toString().trim())
					&& !"null".equals(ironfozyb.getDuser().toString().trim())) {
				userId = ironfozyb.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
				
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
			ironfozyb.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Page<IronfozybReport> page = ironfozybService.findPage(new Page<IronfozybReport>(request, response), ironfozyb); 
		model.addAttribute("page", page);
		return "modules/report/ironfozybreport/ironfozybList";
	}

	/**
	 * 查看，增加，编辑3.3住院部医疗设备配置表单页面
	 */
	@RequiresPermissions(value={"ironfozybreport:ironfozyb:view","ironfozybreport:ironfozyb:add","ironfozybreport:ironfozyb:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfozybReport ironfozyb, Model model) {
		model.addAttribute("ironfozyb", ironfozyb);
		return "report/ironfozybreport/ironfozybForm";
	}

	/**
	 * 保存3.3住院部医疗设备配置
	 */
	@RequiresPermissions(value={"ironfozybreport:ironfozyb:add","ironfozybreport:ironfozyb:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfozybReport ironfozyb, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfozyb)){
			return form(ironfozyb, model);
		}
		if(!ironfozyb.getIsNewRecord()){//编辑表单保存
			IronfozybReport t = ironfozybService.get(ironfozyb.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfozyb, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfozybService.save(t);//保存
		}else{//新增表单保存
			ironfozybService.save(ironfozyb);//保存
		}
		addMessage(redirectAttributes, "保存3.3住院部医疗设备配置成功");
		return "redirect:"+Global.getAdminPath()+"/ironfozybreport/ironfozyb/?repage";
	}
	
	/**
	 * 删除3.3住院部医疗设备配置
	 */
	@RequiresPermissions("ironfozybreport:ironfozyb:del")
	@RequestMapping(value = "delete")
	public String delete(IronfozybReport ironfozyb, RedirectAttributes redirectAttributes) {
		ironfozybService.delete(ironfozyb);
		addMessage(redirectAttributes, "删除3.3住院部医疗设备配置成功");
		return "redirect:"+Global.getAdminPath()+"/ironfozybreport/ironfozyb/?repage";
	}
	
	/**
	 * 批量删除3.3住院部医疗设备配置
	 */
	@RequiresPermissions("ironfozybreport:ironfozyb:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfozybService.delete(ironfozybService.get(id));
		}
		addMessage(redirectAttributes, "删除3.3住院部医疗设备配置成功");
		return "redirect:"+Global.getAdminPath()+"/ironfozybreport/ironfozyb/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfozybreport:ironfozyb:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfozybReport ironfozyb, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfozyb.getDuser() != null&&ironfozyb.getDuser().toString() != null && ironfozyb.getDuser().toString().trim() != null
					&& !"".equals(ironfozyb.getDuser().toString().trim())
					&& !"null".equals(ironfozyb.getDuser().toString().trim())) {
				userId = ironfozyb.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
				
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
			ironfozyb.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "3.3住院部医疗设备配置"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfozybReport> page = ironfozybService.findPage(new Page<IronfozybReport>(request, response, -1), ironfozyb);
    		new ExportExcel("3.3住院部医疗设备配置", IronfozybReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出3.3住院部医疗设备配置记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/report/ironfozybreport/ironfozyb/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfozybreport:ironfozyb:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfozybReport> list = ei.getDataList(IronfozybReport.class);
			for (IronfozybReport ironfozyb : list){
				try{
					ironfozybService.save(ironfozyb);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条3.3住院部医疗设备配置记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条3.3住院部医疗设备配置记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入3.3住院部医疗设备配置失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfozybreport/ironfozyb/?repage";
    }
	
	/**
	 * 下载导入3.3住院部医疗设备配置数据模板
	 */
	@RequiresPermissions("ironfozybreport:ironfozyb:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "3.3住院部医疗设备配置数据导入模板.xlsx";
    		List<IronfozybReport> list = Lists.newArrayList(); 
    		new ExportExcel("3.3住院部医疗设备配置数据", IronfozybReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfozybreport/ironfozyb/?repage";
    }
	
	
	

}