/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfowsjsrygcreport.web;

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
import com.jeeplus.modules.report.ironfowsjsrygcreport.entity.IronfowsjsrygcReport;
import com.jeeplus.modules.report.ironfowsjsrygcreport.service.IronfowsjsrygcReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 2.9.2卫生技术人员构成Controller
 * @author mao
 * @version 2018-04-20
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfowsjsrygcreport/ironfowsjsrygc")
public class IronfowsjsrygcReportController extends BaseController {

	@Autowired
	private IronfowsjsrygcReportService ironfowsjsrygcService;
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	@ModelAttribute
	public IronfowsjsrygcReport get(@RequestParam(required=false) String id) {
		IronfowsjsrygcReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfowsjsrygcService.get(id);
		}
		if (entity == null){
			entity = new IronfowsjsrygcReport();
		}
		return entity;
	}
	
	/**
	 * 2.7.2卫生技术人员构成列表页面
	 */
	@RequiresPermissions("ironfowsjsrygcreport:ironfowsjsrygc:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfowsjsrygcReport ironfowsjsrygc, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfowsjsrygc.getDuser() != null&&ironfowsjsrygc.getDuser().toString() != null && ironfowsjsrygc.getDuser().toString().trim() != null
					&& !"".equals(ironfowsjsrygc.getDuser().toString().trim())
					&& !"null".equals(ironfowsjsrygc.getDuser().toString().trim())) {
				userId = ironfowsjsrygc.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
				
			}
			System.out.println("userId:-----------" + userId);
			title = ironfoDoc_Title_Service.getDocId(userId);
			ironfowsjsrygc.setDoc_id(title.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}

		Page<IronfowsjsrygcReport> page = ironfowsjsrygcService
				.findPage(new Page<IronfowsjsrygcReport>(request, response), ironfowsjsrygc);
		model.addAttribute("page", page);
		return "modules/report/ironfowsjsrygcReportList";
	}

	/**
	 * 查看，增加，编辑2.7.2卫生技术人员构成表单页面
	 */
	@RequiresPermissions(value={"ironfowsjsrygcreport:ironfowsjsrygc:view","ironfowsjsrygcreport:ironfowsjsrygc:add","ironfowsjsrygcreport:ironfowsjsrygc:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfowsjsrygcReport ironfowsjsrygc, Model model) {
		model.addAttribute("ironfowsjsrygc", ironfowsjsrygc);
		return "report/ironfowsjsrygcreport/ironfowsjsrygcForm";
	}

	/**
	 * 保存2.7.2卫生技术人员构成
	 */
	@RequiresPermissions(value={"ironfowsjsrygcreport:ironfowsjsrygc:add","ironfowsjsrygcreport:ironfowsjsrygc:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfowsjsrygcReport ironfowsjsrygc, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfowsjsrygc)){
			return form(ironfowsjsrygc, model);
		}
		if(!ironfowsjsrygc.getIsNewRecord()){//编辑表单保存
			IronfowsjsrygcReport t = ironfowsjsrygcService.get(ironfowsjsrygc.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfowsjsrygc, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfowsjsrygcService.save(t);//保存
		}else{//新增表单保存
			ironfowsjsrygcService.save(ironfowsjsrygc);//保存
		}
		addMessage(redirectAttributes, "保存2.7.2卫生技术人员构成成功");
		return "redirect:"+Global.getAdminPath()+"/ironfowsjsrygcreport/ironfowsjsrygc/?repage";
	}
	
	/**
	 * 删除2.7.2卫生技术人员构成
	 */
	@RequiresPermissions("ironfowsjsrygcreport:ironfowsjsrygc:del")
	@RequestMapping(value = "delete")
	public String delete(IronfowsjsrygcReport ironfowsjsrygc, RedirectAttributes redirectAttributes) {
		ironfowsjsrygcService.delete(ironfowsjsrygc);
		addMessage(redirectAttributes, "删除2.7.2卫生技术人员构成成功");
		return "redirect:"+Global.getAdminPath()+"/ironfowsjsrygcreport/ironfowsjsrygc/?repage";
	}
	
	/**
	 * 批量删除2.7.2卫生技术人员构成
	 */
	@RequiresPermissions("ironfowsjsrygcreport:ironfowsjsrygc:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfowsjsrygcService.delete(ironfowsjsrygcService.get(id));
		}
		addMessage(redirectAttributes, "删除2.7.2卫生技术人员构成成功");
		return "redirect:"+Global.getAdminPath()+"/ironfowsjsrygcreport/ironfowsjsrygc/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfowsjsrygcreport:ironfowsjsrygc:export")
    @RequestMapping(value = "export", method=RequestMethod.GET)
    public String exportFile(IronfowsjsrygcReport ironfowsjsrygc, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		/*try {
            String fileName = "2.7.2卫生技术人员构成"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfowsjsrygcReport> page = ironfowsjsrygcService.findPage(new Page<IronfowsjsrygcReport>(request, response, -1), ironfowsjsrygc);
    		new ExportExcel("2.7.2卫生技术人员构成", IronfowsjsrygcReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出2.7.2卫生技术人员构成记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfowsjsrygcreport/ironfowsjsrygc/?repage";*/
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfowsjsrygc.getDuser() != null && ironfowsjsrygc.getDuser().toString() != null
					&& ironfowsjsrygc.getDuser().toString().trim() != null
					&& !"".equals(ironfowsjsrygc.getDuser().toString().trim())
					&& !"null".equals(ironfowsjsrygc.getDuser().toString().trim())) {
				userId = ironfowsjsrygc.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			ironfowsjsrygc.setDoc_id(title.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "2.9.2卫生技术人员构成"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfowsjsrygcReport> page = ironfowsjsrygcService.findPage(new Page<IronfowsjsrygcReport>(request, response, -1), ironfowsjsrygc);
    		new ExportExcel("2.9.2卫生技术人员构成", IronfowsjsrygcReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出2.9.2卫生技术人员构成记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfomedicalservicesdatas/ironfoMedicalServices/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfowsjsrygcreport:ironfowsjsrygc:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfowsjsrygcReport> list = ei.getDataList(IronfowsjsrygcReport.class);
			for (IronfowsjsrygcReport ironfowsjsrygc : list){
				try{
					ironfowsjsrygcService.save(ironfowsjsrygc);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条2.7.2卫生技术人员构成记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条2.7.2卫生技术人员构成记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入2.7.2卫生技术人员构成失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfowsjsrygcreport/ironfowsjsrygc/?repage";
    }
	
	/**
	 * 下载导入2.7.2卫生技术人员构成数据模板
	 */
	@RequiresPermissions("ironfowsjsrygcreport:ironfowsjsrygc:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "2.7.2卫生技术人员构成数据导入模板.xlsx";
    		List<IronfowsjsrygcReport> list = Lists.newArrayList(); 
    		new ExportExcel("2.7.2卫生技术人员构成数据", IronfowsjsrygcReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfowsjsrygcreport/ironfowsjsrygc/?repage";
    }
	
	
	

}