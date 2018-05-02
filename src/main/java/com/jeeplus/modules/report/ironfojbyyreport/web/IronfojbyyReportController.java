/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfojbyyreport.web;

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
import com.jeeplus.modules.report.ironfojbyyreport.entity.IronfojbyyReport;
import com.jeeplus.modules.report.ironfojbyyreport.service.IronfojbyyReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 2.6基本用药Controller
 * @author mao
 * @version 2018-04-20
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfojbyyreport/ironfojbyy")
public class IronfojbyyReportController extends BaseController {

	@Autowired
	private IronfojbyyReportService ironfojbyyService;
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	@ModelAttribute
	public IronfojbyyReport get(@RequestParam(required=false) String id) {
		IronfojbyyReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfojbyyService.get(id);
		}
		if (entity == null){
			entity = new IronfojbyyReport();
		}
		return entity;
	}
	
	/**
	 * 2.6基本用药列表页面
	 */
	@RequiresPermissions("ironfojbyyreport:ironfojbyy:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfojbyyReport ironfojbyy, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfojbyy.getDuser() != null&&ironfojbyy.getDuser().toString() != null && ironfojbyy.getDuser().toString().trim() != null
					&& !"".equals(ironfojbyy.getDuser().toString().trim())
					&& !"null".equals(ironfojbyy.getDuser().toString().trim())) {
				userId = ironfojbyy.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
				
			}
			System.out.println("userId:-----------" + userId);
			title = ironfoDoc_Title_Service.getDocId(userId);
			ironfojbyy.setDoc_id(title.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}

		Page<IronfojbyyReport> page = ironfojbyyService
				.findPage(new Page<IronfojbyyReport>(request, response), ironfojbyy);
		model.addAttribute("page", page);
		return "modules/report/ironfojbyyReportList";
	}

	/**
	 * 查看，增加，编辑2.6基本用药表单页面
	 */
	@RequiresPermissions(value={"ironfojbyyreport:ironfojbyy:view","ironfojbyyreport:ironfojbyy:add","ironfojbyyreport:ironfojbyy:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfojbyyReport ironfojbyy, Model model) {
		model.addAttribute("ironfojbyy", ironfojbyy);
		return "report/ironfojbyyreport/ironfojbyyForm";
	}

	/**
	 * 保存2.6基本用药
	 */
	@RequiresPermissions(value={"ironfojbyyreport:ironfojbyy:add","ironfojbyyreport:ironfojbyy:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfojbyyReport ironfojbyy, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfojbyy)){
			return form(ironfojbyy, model);
		}
		if(!ironfojbyy.getIsNewRecord()){//编辑表单保存
			IronfojbyyReport t = ironfojbyyService.get(ironfojbyy.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfojbyy, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfojbyyService.save(t);//保存
		}else{//新增表单保存
			ironfojbyyService.save(ironfojbyy);//保存
		}
		addMessage(redirectAttributes, "保存2.6基本用药成功");
		return "redirect:"+Global.getAdminPath()+"/ironfojbyyreport/ironfojbyy/?repage";
	}
	
	/**
	 * 删除2.6基本用药
	 */
	@RequiresPermissions("ironfojbyyreport:ironfojbyy:del")
	@RequestMapping(value = "delete")
	public String delete(IronfojbyyReport ironfojbyy, RedirectAttributes redirectAttributes) {
		ironfojbyyService.delete(ironfojbyy);
		addMessage(redirectAttributes, "删除2.6基本用药成功");
		return "redirect:"+Global.getAdminPath()+"/ironfojbyyreport/ironfojbyy/?repage";
	}
	
	/**
	 * 批量删除2.6基本用药
	 */
	@RequiresPermissions("ironfojbyyreport:ironfojbyy:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfojbyyService.delete(ironfojbyyService.get(id));
		}
		addMessage(redirectAttributes, "删除2.6基本用药成功");
		return "redirect:"+Global.getAdminPath()+"/ironfojbyyreport/ironfojbyy/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfojbyyreport:ironfojbyy:export")
    @RequestMapping(value = "export", method=RequestMethod.GET)
    public String exportFile(IronfojbyyReport ironfojbyy, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		/*try {
            String fileName = "2.6基本用药"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfojbyyReport> page = ironfojbyyService.findPage(new Page<IronfojbyyReport>(request, response, -1), ironfojbyy);
    		new ExportExcel("2.6基本用药", IronfojbyyReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出2.6基本用药记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfojbyyreport/ironfojbyy/?repage";*/
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfojbyy.getDuser() != null && ironfojbyy.getDuser().toString() != null
					&& ironfojbyy.getDuser().toString().trim() != null
					&& !"".equals(ironfojbyy.getDuser().toString().trim())
					&& !"null".equals(ironfojbyy.getDuser().toString().trim())) {
				userId = ironfojbyy.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			ironfojbyy.setDoc_id(title.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "2.6基本用药"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfojbyyReport> page = ironfojbyyService.findPage(new Page<IronfojbyyReport>(request, response, -1), ironfojbyy);
    		new ExportExcel("2.6基本用药", IronfojbyyReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出2.6基本用药记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfomedicalservicesdatas/ironfoMedicalServices/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfojbyyreport:ironfojbyy:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfojbyyReport> list = ei.getDataList(IronfojbyyReport.class);
			for (IronfojbyyReport ironfojbyy : list){
				try{
					ironfojbyyService.save(ironfojbyy);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条2.6基本用药记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条2.6基本用药记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入2.6基本用药失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfojbyyreport/ironfojbyy/?repage";
    }
	
	/**
	 * 下载导入2.6基本用药数据模板
	 */
	@RequiresPermissions("ironfojbyyreport:ironfojbyy:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "2.6基本用药数据导入模板.xlsx";
    		List<IronfojbyyReport> list = Lists.newArrayList(); 
    		new ExportExcel("2.6基本用药数据", IronfojbyyReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfojbyyreport/ironfojbyy/?repage";
    }
	
	
	

}