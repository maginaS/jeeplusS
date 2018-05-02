/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofiveznglyfreport.web;

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
import com.jeeplus.modules.report.ironfofiveznglyfreport.entity.IronfofiveznglyfReport;
import com.jeeplus.modules.report.ironfofiveznglyfreport.service.IronfofiveznglyfReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 5.7职能管理用房Controller
 * @author anti_magina
 * @version 2018-04-23
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfofiveznglyfreport/ironfofiveznglyf")
public class IronfofiveznglyfReportController extends BaseController {

	@Autowired
	private IronfofiveznglyfReportService ironfofiveznglyfService;
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	@ModelAttribute
	public IronfofiveznglyfReport get(@RequestParam(required=false) String id) {
		IronfofiveznglyfReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfofiveznglyfService.get(id);
		}
		if (entity == null){
			entity = new IronfofiveznglyfReport();
		}
		return entity;
	}
	
	/**
	 * 5.7职能管理用房列表页面
	 */
	@RequiresPermissions("ironfofiveznglyfreport:ironfofiveznglyf:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfofiveznglyfReport ironfofiveznglyf, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfofiveznglyf.getDuser() != null&&ironfofiveznglyf.getDuser().toString() != null && ironfofiveznglyf.getDuser().toString().trim() != null
					&& !"".equals(ironfofiveznglyf.getDuser().toString().trim())
					&& !"null".equals(ironfofiveznglyf.getDuser().toString().trim())) {
				userId = ironfofiveznglyf.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfofiveznglyf.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Page<IronfofiveznglyfReport> page = ironfofiveznglyfService.findPage(new Page<IronfofiveznglyfReport>(request, response), ironfofiveznglyf); 
		model.addAttribute("page", page);
		return "modules/report/ironfofiveznglyfreport/ironfofiveznglyfList";
	}

	/**
	 * 查看，增加，编辑5.7职能管理用房表单页面
	 */
	@RequiresPermissions(value={"ironfofiveznglyfreport:ironfofiveznglyf:view","ironfofiveznglyfreport:ironfofiveznglyf:add","ironfofiveznglyfreport:ironfofiveznglyf:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfofiveznglyfReport ironfofiveznglyf, Model model) {
		model.addAttribute("ironfofiveznglyf", ironfofiveznglyf);
		return "report/ironfofiveznglyfreport/ironfofiveznglyfForm";
	}

	/**
	 * 保存5.7职能管理用房
	 */
	@RequiresPermissions(value={"ironfofiveznglyfreport:ironfofiveznglyf:add","ironfofiveznglyfreport:ironfofiveznglyf:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfofiveznglyfReport ironfofiveznglyf, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfofiveznglyf)){
			return form(ironfofiveznglyf, model);
		}
		if(!ironfofiveznglyf.getIsNewRecord()){//编辑表单保存
			IronfofiveznglyfReport t = ironfofiveznglyfService.get(ironfofiveznglyf.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfofiveznglyf, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfofiveznglyfService.save(t);//保存
		}else{//新增表单保存
			ironfofiveznglyfService.save(ironfofiveznglyf);//保存
		}
		addMessage(redirectAttributes, "保存5.7职能管理用房成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofiveznglyfreport/ironfofiveznglyf/?repage";
	}
	
	/**
	 * 删除5.7职能管理用房
	 */
	@RequiresPermissions("ironfofiveznglyfreport:ironfofiveznglyf:del")
	@RequestMapping(value = "delete")
	public String delete(IronfofiveznglyfReport ironfofiveznglyf, RedirectAttributes redirectAttributes) {
		ironfofiveznglyfService.delete(ironfofiveznglyf);
		addMessage(redirectAttributes, "删除5.7职能管理用房成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofiveznglyfreport/ironfofiveznglyf/?repage";
	}
	
	/**
	 * 批量删除5.7职能管理用房
	 */
	@RequiresPermissions("ironfofiveznglyfreport:ironfofiveznglyf:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfofiveznglyfService.delete(ironfofiveznglyfService.get(id));
		}
		addMessage(redirectAttributes, "删除5.7职能管理用房成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofiveznglyfreport/ironfofiveznglyf/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfofiveznglyfreport:ironfofiveznglyf:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfofiveznglyfReport ironfofiveznglyf, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfofiveznglyf.getDuser() != null&&ironfofiveznglyf.getDuser().toString() != null && ironfofiveznglyf.getDuser().toString().trim() != null
					&& !"".equals(ironfofiveznglyf.getDuser().toString().trim())
					&& !"null".equals(ironfofiveznglyf.getDuser().toString().trim())) {
				userId = ironfofiveznglyf.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfofiveznglyf.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "5.7职能管理用房"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfofiveznglyfReport> page = ironfofiveznglyfService.findPage(new Page<IronfofiveznglyfReport>(request, response, -1), ironfofiveznglyf);
    		new ExportExcel("5.7职能管理用房", IronfofiveznglyfReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出5.7职能管理用房记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/report/ironfofiveznglyfreport/ironfofiveznglyf/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfofiveznglyfreport:ironfofiveznglyf:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfofiveznglyfReport> list = ei.getDataList(IronfofiveznglyfReport.class);
			for (IronfofiveznglyfReport ironfofiveznglyf : list){
				try{
					ironfofiveznglyfService.save(ironfofiveznglyf);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条5.7职能管理用房记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条5.7职能管理用房记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入5.7职能管理用房失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofiveznglyfreport/ironfofiveznglyf/?repage";
    }
	
	/**
	 * 下载导入5.7职能管理用房数据模板
	 */
	@RequiresPermissions("ironfofiveznglyfreport:ironfofiveznglyf:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "5.7职能管理用房数据导入模板.xlsx";
    		List<IronfofiveznglyfReport> list = Lists.newArrayList(); 
    		new ExportExcel("5.7职能管理用房数据", IronfofiveznglyfReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofiveznglyfreport/ironfofiveznglyf/?repage";
    }
	
	
	

}