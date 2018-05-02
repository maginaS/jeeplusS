/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfopublichealthreport.web;

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
import com.jeeplus.modules.report.ironfofinancereport.entity.IronfofinanceReport;
import com.jeeplus.modules.report.ironfopublichealthreport.entity.IronfopublichealthReport;
import com.jeeplus.modules.report.ironfopublichealthreport.service.IronfopublichealthReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 2.3基本公共卫生服务Controller
 * @author mao
 * @version 2018-04-20
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfopublichealthreport/ironfopublichealth")
public class IronfopublichealthReportController extends BaseController {

	@Autowired
	private IronfopublichealthReportService ironfopublichealthService;
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	@ModelAttribute
	public IronfopublichealthReport get(@RequestParam(required=false) String id) {
		IronfopublichealthReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfopublichealthService.get(id);
		}
		if (entity == null){
			entity = new IronfopublichealthReport();
		}
		return entity;
	}
	
	/**
	 * 2.3基本公共卫生服务列表页面
	 */
	@RequiresPermissions("ironfopublichealthreport:ironfopublichealth:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfopublichealthReport ironfopublichealth, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfopublichealth.getDuser() != null&&ironfopublichealth.getDuser().toString() != null && ironfopublichealth.getDuser().toString().trim() != null
					&& !"".equals(ironfopublichealth.getDuser().toString().trim())
					&& !"null".equals(ironfopublichealth.getDuser().toString().trim())) {
				userId = ironfopublichealth.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
				
			}
			System.out.println("userId:-----------" + userId);
			title = ironfoDoc_Title_Service.getDocId(userId);
			ironfopublichealth.setDoc_id(title.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}

		Page<IronfopublichealthReport> page = ironfopublichealthService
				.findPage(new Page<IronfopublichealthReport>(request, response), ironfopublichealth);
		model.addAttribute("page", page);
		return "modules/report/ironfopublichealthReportList";
	}

	/**
	 * 查看，增加，编辑2.3基本公共卫生服务表单页面
	 */
	@RequiresPermissions(value={"ironfopublichealthreport:ironfopublichealth:view","ironfopublichealthreport:ironfopublichealth:add","ironfopublichealthreport:ironfopublichealth:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfopublichealthReport ironfopublichealth, Model model) {
		model.addAttribute("ironfopublichealth", ironfopublichealth);
		return "report/ironfopublichealthreport/ironfopublichealthForm";
	}

	/**
	 * 保存2.3基本公共卫生服务
	 */
	@RequiresPermissions(value={"ironfopublichealthreport:ironfopublichealth:add","ironfopublichealthreport:ironfopublichealth:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfopublichealthReport ironfopublichealth, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfopublichealth)){
			return form(ironfopublichealth, model);
		}
		if(!ironfopublichealth.getIsNewRecord()){//编辑表单保存
			IronfopublichealthReport t = ironfopublichealthService.get(ironfopublichealth.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfopublichealth, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfopublichealthService.save(t);//保存
		}else{//新增表单保存
			ironfopublichealthService.save(ironfopublichealth);//保存
		}
		addMessage(redirectAttributes, "保存2.3基本公共卫生服务成功");
		return "redirect:"+Global.getAdminPath()+"/ironfopublichealthreport/ironfopublichealth/?repage";
	}
	
	/**
	 * 删除2.3基本公共卫生服务
	 */
	@RequiresPermissions("ironfopublichealthreport:ironfopublichealth:del")
	@RequestMapping(value = "delete")
	public String delete(IronfopublichealthReport ironfopublichealth, RedirectAttributes redirectAttributes) {
		ironfopublichealthService.delete(ironfopublichealth);
		addMessage(redirectAttributes, "删除2.3基本公共卫生服务成功");
		return "redirect:"+Global.getAdminPath()+"/ironfopublichealthreport/ironfopublichealth/?repage";
	}
	
	/**
	 * 批量删除2.3基本公共卫生服务
	 */
	@RequiresPermissions("ironfopublichealthreport:ironfopublichealth:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfopublichealthService.delete(ironfopublichealthService.get(id));
		}
		addMessage(redirectAttributes, "删除2.3基本公共卫生服务成功");
		return "redirect:"+Global.getAdminPath()+"/ironfopublichealthreport/ironfopublichealth/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfopublichealthreport:ironfopublichealth:export")
    @RequestMapping(value = "export", method=RequestMethod.GET)
    public String exportFile(IronfopublichealthReport ironfopublichealth, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		/*try {
            String fileName = "2.3基本公共卫生服务"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfopublichealthReport> page = ironfopublichealthService.findPage(new Page<IronfopublichealthReport>(request, response, -1), ironfopublichealth);
    		new ExportExcel("2.3基本公共卫生服务", IronfopublichealthReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出2.3基本公共卫生服务记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfopublichealthreport/ironfopublichealth/?repage";*/
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfopublichealth.getDuser() != null && ironfopublichealth.getDuser().toString() != null
					&& ironfopublichealth.getDuser().toString().trim() != null
					&& !"".equals(ironfopublichealth.getDuser().toString().trim())
					&& !"null".equals(ironfopublichealth.getDuser().toString().trim())) {
				userId = ironfopublichealth.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			ironfopublichealth.setDoc_id(title.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "2.3基本公共卫生服务"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfopublichealthReport> page = ironfopublichealthService.findPage(new Page<IronfopublichealthReport>(request, response, -1), ironfopublichealth);
    		new ExportExcel("2.3基本公共卫生服务", IronfopublichealthReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出2.3基本公共卫生服务记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfomedicalservicesdatas/ironfoMedicalServices/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfopublichealthreport:ironfopublichealth:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfopublichealthReport> list = ei.getDataList(IronfopublichealthReport.class);
			for (IronfopublichealthReport ironfopublichealth : list){
				try{
					ironfopublichealthService.save(ironfopublichealth);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条2.3基本公共卫生服务记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条2.3基本公共卫生服务记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入2.3基本公共卫生服务失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfopublichealthreport/ironfopublichealth/?repage";
    }
	
	/**
	 * 下载导入2.3基本公共卫生服务数据模板
	 */
	@RequiresPermissions("ironfopublichealthreport:ironfopublichealth:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "2.3基本公共卫生服务数据导入模板.xlsx";
    		List<IronfopublichealthReport> list = Lists.newArrayList(); 
    		new ExportExcel("2.3基本公共卫生服务数据", IronfopublichealthReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfopublichealthreport/ironfopublichealth/?repage";
    }
	
	
	

}