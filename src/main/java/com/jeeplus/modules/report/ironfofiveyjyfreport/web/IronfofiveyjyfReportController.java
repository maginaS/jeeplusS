/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofiveyjyfreport.web;

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
import com.jeeplus.modules.report.ironfofiveyjyfreport.entity.IronfofiveyjyfReport;
import com.jeeplus.modules.report.ironfofiveyjyfreport.service.IronfofiveyjyfReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 5.3医技用房Controller
 * @author anti_magina
 * @version 2018-04-23
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfofiveyjyfreport/ironfofiveyjyf")
public class IronfofiveyjyfReportController extends BaseController {

	@Autowired
	private IronfofiveyjyfReportService ironfofiveyjyfService;
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	@ModelAttribute
	public IronfofiveyjyfReport get(@RequestParam(required=false) String id) {
		IronfofiveyjyfReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfofiveyjyfService.get(id);
		}
		if (entity == null){
			entity = new IronfofiveyjyfReport();
		}
		return entity;
	}
	
	/**
	 * 5.3医技用房列表页面
	 */
	@RequiresPermissions("ironfofiveyjyfreport:ironfofiveyjyf:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfofiveyjyfReport ironfofiveyjyf, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfofiveyjyf.getDuser() != null&&ironfofiveyjyf.getDuser().toString() != null && ironfofiveyjyf.getDuser().toString().trim() != null
					&& !"".equals(ironfofiveyjyf.getDuser().toString().trim())
					&& !"null".equals(ironfofiveyjyf.getDuser().toString().trim())) {
				userId = ironfofiveyjyf.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfofiveyjyf.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Page<IronfofiveyjyfReport> page = ironfofiveyjyfService.findPage(new Page<IronfofiveyjyfReport>(request, response), ironfofiveyjyf); 
		model.addAttribute("page", page);
		return "modules/report/ironfofiveyjyfreport/ironfofiveyjyfList";
	}

	/**
	 * 查看，增加，编辑5.3医技用房表单页面
	 */
	@RequiresPermissions(value={"ironfofiveyjyfreport:ironfofiveyjyf:view","ironfofiveyjyfreport:ironfofiveyjyf:add","ironfofiveyjyfreport:ironfofiveyjyf:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfofiveyjyfReport ironfofiveyjyf, Model model) {
		model.addAttribute("ironfofiveyjyf", ironfofiveyjyf);
		return "report/ironfofiveyjyfreport/ironfofiveyjyfForm";
	}

	/**
	 * 保存5.3医技用房
	 */
	@RequiresPermissions(value={"ironfofiveyjyfreport:ironfofiveyjyf:add","ironfofiveyjyfreport:ironfofiveyjyf:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfofiveyjyfReport ironfofiveyjyf, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfofiveyjyf)){
			return form(ironfofiveyjyf, model);
		}
		if(!ironfofiveyjyf.getIsNewRecord()){//编辑表单保存
			IronfofiveyjyfReport t = ironfofiveyjyfService.get(ironfofiveyjyf.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfofiveyjyf, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfofiveyjyfService.save(t);//保存
		}else{//新增表单保存
			ironfofiveyjyfService.save(ironfofiveyjyf);//保存
		}
		addMessage(redirectAttributes, "保存5.3医技用房成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofiveyjyfreport/ironfofiveyjyf/?repage";
	}
	
	/**
	 * 删除5.3医技用房
	 */
	@RequiresPermissions("ironfofiveyjyfreport:ironfofiveyjyf:del")
	@RequestMapping(value = "delete")
	public String delete(IronfofiveyjyfReport ironfofiveyjyf, RedirectAttributes redirectAttributes) {
		ironfofiveyjyfService.delete(ironfofiveyjyf);
		addMessage(redirectAttributes, "删除5.3医技用房成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofiveyjyfreport/ironfofiveyjyf/?repage";
	}
	
	/**
	 * 批量删除5.3医技用房
	 */
	@RequiresPermissions("ironfofiveyjyfreport:ironfofiveyjyf:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfofiveyjyfService.delete(ironfofiveyjyfService.get(id));
		}
		addMessage(redirectAttributes, "删除5.3医技用房成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofiveyjyfreport/ironfofiveyjyf/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfofiveyjyfreport:ironfofiveyjyf:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfofiveyjyfReport ironfofiveyjyf, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfofiveyjyf.getDuser() != null&&ironfofiveyjyf.getDuser().toString() != null && ironfofiveyjyf.getDuser().toString().trim() != null
					&& !"".equals(ironfofiveyjyf.getDuser().toString().trim())
					&& !"null".equals(ironfofiveyjyf.getDuser().toString().trim())) {
				userId = ironfofiveyjyf.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfofiveyjyf.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "5.3医技用房"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfofiveyjyfReport> page = ironfofiveyjyfService.findPage(new Page<IronfofiveyjyfReport>(request, response, -1), ironfofiveyjyf);
    		new ExportExcel("5.3医技用房", IronfofiveyjyfReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出5.3医技用房记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"report/ironfofiveyjyfreport/ironfofiveyjyf/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfofiveyjyfreport:ironfofiveyjyf:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfofiveyjyfReport> list = ei.getDataList(IronfofiveyjyfReport.class);
			for (IronfofiveyjyfReport ironfofiveyjyf : list){
				try{
					ironfofiveyjyfService.save(ironfofiveyjyf);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条5.3医技用房记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条5.3医技用房记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入5.3医技用房失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofiveyjyfreport/ironfofiveyjyf/?repage";
    }
	
	/**
	 * 下载导入5.3医技用房数据模板
	 */
	@RequiresPermissions("ironfofiveyjyfreport:ironfofiveyjyf:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "5.3医技用房数据导入模板.xlsx";
    		List<IronfofiveyjyfReport> list = Lists.newArrayList(); 
    		new ExportExcel("5.3医技用房数据", IronfofiveyjyfReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofiveyjyfreport/ironfofiveyjyf/?repage";
    }
	
	
	

}