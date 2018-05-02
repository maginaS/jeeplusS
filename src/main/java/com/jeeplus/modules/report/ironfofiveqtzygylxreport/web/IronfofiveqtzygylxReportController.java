/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofiveqtzygylxreport.web;

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
import com.jeeplus.modules.report.ironfofiveqtzygylxreport.entity.IronfofiveqtzygylxReport;
import com.jeeplus.modules.report.ironfofiveqtzygylxreport.service.IronfofiveqtzygylxReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 供应类型Controller
 * @author anti_magina
 * @version 2018-04-23
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfofiveqtzygylxreport/ironfofiveqtzygylx")
public class IronfofiveqtzygylxReportController extends BaseController {

	@Autowired
	private IronfofiveqtzygylxReportService ironfofiveqtzygylxService;
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	@ModelAttribute
	public IronfofiveqtzygylxReport get(@RequestParam(required=false) String id) {
		IronfofiveqtzygylxReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfofiveqtzygylxService.get(id);
		}
		if (entity == null){
			entity = new IronfofiveqtzygylxReport();
		}
		return entity;
	}
	
	/**
	 * 供应类型列表页面
	 */
	@RequiresPermissions("ironfofiveqtzygylxreport:ironfofiveqtzygylx:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfofiveqtzygylxReport ironfofiveqtzygylx, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfofiveqtzygylx.getDuser() != null&&ironfofiveqtzygylx.getDuser().toString() != null && ironfofiveqtzygylx.getDuser().toString().trim() != null
					&& !"".equals(ironfofiveqtzygylx.getDuser().toString().trim())
					&& !"null".equals(ironfofiveqtzygylx.getDuser().toString().trim())) {
				userId = ironfofiveqtzygylx.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfofiveqtzygylx.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Page<IronfofiveqtzygylxReport> page = ironfofiveqtzygylxService.findPage(new Page<IronfofiveqtzygylxReport>(request, response), ironfofiveqtzygylx); 
		model.addAttribute("page", page);
		return "modules/report/ironfofiveqtzygylxreport/ironfofiveqtzygylxList";
	}

	/**
	 * 查看，增加，编辑供应类型表单页面
	 */
	@RequiresPermissions(value={"ironfofiveqtzygylxreport:ironfofiveqtzygylx:view","ironfofiveqtzygylxreport:ironfofiveqtzygylx:add","ironfofiveqtzygylxreport:ironfofiveqtzygylx:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfofiveqtzygylxReport ironfofiveqtzygylx, Model model) {
		model.addAttribute("ironfofiveqtzygylx", ironfofiveqtzygylx);
		return "report/ironfofiveqtzygylxreport/ironfofiveqtzygylxForm";
	}

	/**
	 * 保存供应类型
	 */
	@RequiresPermissions(value={"ironfofiveqtzygylxreport:ironfofiveqtzygylx:add","ironfofiveqtzygylxreport:ironfofiveqtzygylx:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfofiveqtzygylxReport ironfofiveqtzygylx, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfofiveqtzygylx)){
			return form(ironfofiveqtzygylx, model);
		}
		if(!ironfofiveqtzygylx.getIsNewRecord()){//编辑表单保存
			IronfofiveqtzygylxReport t = ironfofiveqtzygylxService.get(ironfofiveqtzygylx.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfofiveqtzygylx, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfofiveqtzygylxService.save(t);//保存
		}else{//新增表单保存
			ironfofiveqtzygylxService.save(ironfofiveqtzygylx);//保存
		}
		addMessage(redirectAttributes, "保存供应类型成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofiveqtzygylxreport/ironfofiveqtzygylx/?repage";
	}
	
	/**
	 * 删除供应类型
	 */
	@RequiresPermissions("ironfofiveqtzygylxreport:ironfofiveqtzygylx:del")
	@RequestMapping(value = "delete")
	public String delete(IronfofiveqtzygylxReport ironfofiveqtzygylx, RedirectAttributes redirectAttributes) {
		ironfofiveqtzygylxService.delete(ironfofiveqtzygylx);
		addMessage(redirectAttributes, "删除供应类型成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofiveqtzygylxreport/ironfofiveqtzygylx/?repage";
	}
	
	/**
	 * 批量删除供应类型
	 */
	@RequiresPermissions("ironfofiveqtzygylxreport:ironfofiveqtzygylx:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfofiveqtzygylxService.delete(ironfofiveqtzygylxService.get(id));
		}
		addMessage(redirectAttributes, "删除供应类型成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofiveqtzygylxreport/ironfofiveqtzygylx/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfofiveqtzygylxreport:ironfofiveqtzygylx:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfofiveqtzygylxReport ironfofiveqtzygylx, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfofiveqtzygylx.getDuser() != null&&ironfofiveqtzygylx.getDuser().toString() != null && ironfofiveqtzygylx.getDuser().toString().trim() != null
					&& !"".equals(ironfofiveqtzygylx.getDuser().toString().trim())
					&& !"null".equals(ironfofiveqtzygylx.getDuser().toString().trim())) {
				userId = ironfofiveqtzygylx.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfofiveqtzygylx.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "供应类型"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfofiveqtzygylxReport> page = ironfofiveqtzygylxService.findPage(new Page<IronfofiveqtzygylxReport>(request, response, -1), ironfofiveqtzygylx);
    		new ExportExcel("供应类型", IronfofiveqtzygylxReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出供应类型记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/report/ironfofiveqtzygylxreport/ironfofiveqtzygylx/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfofiveqtzygylxreport:ironfofiveqtzygylx:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfofiveqtzygylxReport> list = ei.getDataList(IronfofiveqtzygylxReport.class);
			for (IronfofiveqtzygylxReport ironfofiveqtzygylx : list){
				try{
					ironfofiveqtzygylxService.save(ironfofiveqtzygylx);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条供应类型记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条供应类型记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入供应类型失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofiveqtzygylxreport/ironfofiveqtzygylx/?repage";
    }
	
	/**
	 * 下载导入供应类型数据模板
	 */
	@RequiresPermissions("ironfofiveqtzygylxreport:ironfofiveqtzygylx:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "供应类型数据导入模板.xlsx";
    		List<IronfofiveqtzygylxReport> list = Lists.newArrayList(); 
    		new ExportExcel("供应类型数据", IronfofiveqtzygylxReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofiveqtzygylxreport/ironfofiveqtzygylx/?repage";
    }
	
	
	

}