/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoinformationsxreport.web;

import java.util.ArrayList;
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
import com.jeeplus.modules.ironfoinformationsx.dao.IronfoinformationsxjbggwsfwDao;
import com.jeeplus.modules.ironfoinformationsx.entity.Ironfoinformationsx;
import com.jeeplus.modules.ironfoinformationsx.service.IronfoinformationsxService;
import com.jeeplus.modules.ironfoyjbylsbpzzyk.entity.Ironfoyjbylsbpzzyk;
import com.jeeplus.modules.report.ironfoinformationsxreport.dao.IronfoinformationsxjbggwsfwReportDao;
import com.jeeplus.modules.report.ironfoinformationsxreport.entity.IronfoinformationsxReport;
import com.jeeplus.modules.report.ironfoinformationsxreport.entity.IronfoinformationsxjbggwsfwReport;
import com.jeeplus.modules.report.ironfoinformationsxreport.entity.IronfoinformationsxjbylfwReport;
import com.jeeplus.modules.report.ironfoinformationsxreport.entity.IronfoinformationsxjgjkReport;
import com.jeeplus.modules.report.ironfoinformationsxreport.entity.IronfoinformationsxjgyyglReport;
import com.jeeplus.modules.report.ironfoinformationsxreport.entity.IronfoinformationsxjkdaglReport;
import com.jeeplus.modules.report.ironfoinformationsxreport.entity.IronfoinformationsxjkxxfwReport;
import com.jeeplus.modules.report.ironfoinformationsxreport.service.IronfoinformationsxReportService;
import com.jeeplus.modules.sys.entity.User;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 4.2信息化系统功能实现Controller
 * @author anti_magina
 * @version 2018-04-24
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfoinformationsxreport/ironfoinformationsx")
public class IronfoinformationsxReportController extends BaseController {

	@Autowired
	private IronfoinformationsxReportService ironfoinformationsxService;
	@Autowired
	private IronfoinformationsxService ironfoinformationsx_Service;
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	@Autowired
	private IronfoinformationsxjbggwsfwReportDao ironfoinformationsxjbggwsfwDao;
	@ModelAttribute
	public IronfoinformationsxReport get(@RequestParam(required=false) String id) {
		IronfoinformationsxReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfoinformationsxService.get(id);
		}
		if (entity == null){
			entity = new IronfoinformationsxReport();
		}
		return entity;
	}
	
	/**
	 * 4.2信息化系统功能实现列表页面
	 */
	@RequiresPermissions("ironfoinformationsxreport:ironfoinformationsx:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfoinformationsxReport ironfoinformationsx, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		Ironfoinformationsx ironfoinformationsx_noReport =null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			ironfoinformationsx_noReport = Ironfoinformationsx.class.newInstance();
//			if (ironfoinformationsx.getDuser() != null&&ironfoinformationsx.getDuser().toString() != null && ironfoinformationsx.getDuser().toString().trim() != null
//					&& !"".equals(ironfoinformationsx.getDuser().toString().trim())
//					&& !"null".equals(ironfoinformationsx.getDuser().toString().trim())) {
//				userId = ironfoinformationsx.getDuser().getId();
//				title.setRemarks(userId);
//			} else {
//				Subject subject = SecurityUtils.getSubject();
//				Principal obj = (Principal) subject.getPrincipal();
//				userId = (String) obj.getId();
//				
//			}
			//System.out.println("userId:-----------" + userId);
			Subject subject = SecurityUtils.getSubject();
			Principal obj = (Principal) subject.getPrincipal();
			userId = (String) obj.getId();
			//title = ironfoDoc_Title_Service.getDocId(userId);
			
			//ironfoinformationsx_noReport.setDoc_id(title.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Ironfoinformationsx> ironfoinformationsxList = ironfoinformationsx_Service.findList(ironfoinformationsx_noReport);
		String doc_id = ironfoinformationsx_noReport.getDoc_id();
//		IronfoinformationsxjbggwsfwReport ironfoinformationsxjbggwsfw = null;
//		try {
//			ironfoinformationsxjbggwsfw = IronfoinformationsxjbggwsfwReport.class.newInstance();
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		ironfoinformationsxjbggwsfw.setDoc_id(doc_id);
		for (Ironfoinformationsx ironfoinformationsxReport : ironfoinformationsxList) {
			if(ironfoinformationsxReport.getRemarks().equals("4")){
				List<IronfoinformationsxjbggwsfwReport> ironfoinformationsxjbggwsfwList = ironfoinformationsx.getIronfoinformationsxjbggwsfwList();
				if(ironfoinformationsxjbggwsfwList == null ||ironfoinformationsxjbggwsfwList.size() == 0){
					ironfoinformationsxjbggwsfwList = new ArrayList<IronfoinformationsxjbggwsfwReport>();
					ironfoinformationsxjbggwsfwList.add(new IronfoinformationsxjbggwsfwReport());
				}
				ironfoinformationsxjbggwsfwList.get(0).setDoc_id(doc_id);
				ironfoinformationsxjbggwsfwList.get(0).setSe_id(ironfoinformationsxReport.getId());
				ironfoinformationsx.setIronfoinformationsxjbggwsfwList(ironfoinformationsxjbggwsfwList);
			}
			if(ironfoinformationsxReport.getRemarks().equals("1")){
				List<IronfoinformationsxjgjkReport> ironfoinformationsxjbggwsfwList = ironfoinformationsx.getIronfoinformationsxjgjkList();
				if(ironfoinformationsxjbggwsfwList == null ||ironfoinformationsxjbggwsfwList.size() == 0){
					ironfoinformationsxjbggwsfwList = new ArrayList<IronfoinformationsxjgjkReport>();
					ironfoinformationsxjbggwsfwList.add(new IronfoinformationsxjgjkReport());
				}
				ironfoinformationsxjbggwsfwList.get(0).setDoc_id(doc_id);
				ironfoinformationsxjbggwsfwList.get(0).setSe_id(ironfoinformationsxReport.getId());
				ironfoinformationsx.setIronfoinformationsxjgjkList(ironfoinformationsxjbggwsfwList);
			}
			if(ironfoinformationsxReport.getRemarks().equals("2")){
				List<IronfoinformationsxjbylfwReport> ironfoinformationsxjbggwsfwList = ironfoinformationsx.getIronfoinformationsxjbylfwList();
				if(ironfoinformationsxjbggwsfwList == null ||ironfoinformationsxjbggwsfwList.size() == 0){
					ironfoinformationsxjbggwsfwList = new ArrayList<IronfoinformationsxjbylfwReport>();
					ironfoinformationsxjbggwsfwList.add(new IronfoinformationsxjbylfwReport());
				}
				ironfoinformationsxjbggwsfwList.get(0).setDoc_id(doc_id);
				ironfoinformationsxjbggwsfwList.get(0).setSe_id(ironfoinformationsxReport.getId());
				ironfoinformationsx.setIronfoinformationsxjbylfwList(ironfoinformationsxjbggwsfwList);
			}
			if(ironfoinformationsxReport.getRemarks().equals("3")){
				List<IronfoinformationsxjkxxfwReport> ironfoinformationsxjbggwsfwList = ironfoinformationsx.getIronfoinformationsxjkxxfwList();
				if(ironfoinformationsxjbggwsfwList == null ||ironfoinformationsxjbggwsfwList.size() == 0){
					ironfoinformationsxjbggwsfwList = new ArrayList<IronfoinformationsxjkxxfwReport>();
					ironfoinformationsxjbggwsfwList.add(new IronfoinformationsxjkxxfwReport());
				}
				ironfoinformationsxjbggwsfwList.get(0).setDoc_id(doc_id);
				ironfoinformationsxjbggwsfwList.get(0).setSe_id(ironfoinformationsxReport.getId());
				ironfoinformationsx.setIronfoinformationsxjkxxfwList(ironfoinformationsxjbggwsfwList);
			}
			if(ironfoinformationsxReport.getRemarks().equals("5")){
				List<IronfoinformationsxjgyyglReport> ironfoinformationsxjbggwsfwList = ironfoinformationsx.getIronfoinformationsxjgyyglList();
				if(ironfoinformationsxjbggwsfwList == null ||ironfoinformationsxjbggwsfwList.size() == 0){
					ironfoinformationsxjbggwsfwList = new ArrayList<IronfoinformationsxjgyyglReport>();
					ironfoinformationsxjbggwsfwList.add(new IronfoinformationsxjgyyglReport());
				}
				ironfoinformationsxjbggwsfwList.get(0).setDoc_id(doc_id);
				ironfoinformationsxjbggwsfwList.get(0).setSe_id(ironfoinformationsxReport.getId());
				ironfoinformationsx.setIronfoinformationsxjgyyglList(ironfoinformationsxjbggwsfwList);
			}
			if(ironfoinformationsxReport.getRemarks().equals("6")){
				List<IronfoinformationsxjkdaglReport> ironfoinformationsxjbggwsfwList = ironfoinformationsx.getIronfoinformationsxjkdaglList();
				if(ironfoinformationsxjbggwsfwList == null ||ironfoinformationsxjbggwsfwList.size() == 0){
					ironfoinformationsxjbggwsfwList = new ArrayList<IronfoinformationsxjkdaglReport>();
					ironfoinformationsxjbggwsfwList.add(new IronfoinformationsxjkdaglReport());
				}
				ironfoinformationsxjbggwsfwList.get(0).setDoc_id(doc_id);
				ironfoinformationsxjbggwsfwList.get(0).setSx_id(ironfoinformationsxReport.getId());
				ironfoinformationsx.setIronfoinformationsxjkdaglList(ironfoinformationsxjbggwsfwList);
			}
		}
		Page<IronfoinformationsxReport> page = ironfoinformationsxService.findPage(new Page<IronfoinformationsxReport>(request, response), ironfoinformationsx); 
		model.addAttribute("page", page);
		return "modules/report/ironfoinformationsxreport/ironfoinformationsxList";
	}

	/**
	 * 查看，增加，编辑4.2信息化系统功能实现表单页面
	 */
	@RequiresPermissions(value={"ironfoinformationsxreport:ironfoinformationsx:view","ironfoinformationsxreport:ironfoinformationsx:add","ironfoinformationsxreport:ironfoinformationsx:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfoinformationsxReport ironfoinformationsx, Model model) {
		model.addAttribute("ironfoinformationsx", ironfoinformationsx);
		return "report/ironfoinformationsxreport/ironfoinformationsxForm";
	}

	/**
	 * 保存4.2信息化系统功能实现
	 */
	@RequiresPermissions(value={"ironfoinformationsxreport:ironfoinformationsx:add","ironfoinformationsxreport:ironfoinformationsx:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfoinformationsxReport ironfoinformationsx, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfoinformationsx)){
			return form(ironfoinformationsx, model);
		}
		if(!ironfoinformationsx.getIsNewRecord()){//编辑表单保存
			IronfoinformationsxReport t = ironfoinformationsxService.get(ironfoinformationsx.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfoinformationsx, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfoinformationsxService.save(t);//保存
		}else{//新增表单保存
			ironfoinformationsxService.save(ironfoinformationsx);//保存
		}
		addMessage(redirectAttributes, "保存4.2信息化系统功能实现成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoinformationsxreport/ironfoinformationsx/?repage";
	}
	
	/**
	 * 删除4.2信息化系统功能实现
	 */
	@RequiresPermissions("ironfoinformationsxreport:ironfoinformationsx:del")
	@RequestMapping(value = "delete")
	public String delete(IronfoinformationsxReport ironfoinformationsx, RedirectAttributes redirectAttributes) {
		ironfoinformationsxService.delete(ironfoinformationsx);
		addMessage(redirectAttributes, "删除4.2信息化系统功能实现成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoinformationsxreport/ironfoinformationsx/?repage";
	}
	
	/**
	 * 批量删除4.2信息化系统功能实现
	 */
	@RequiresPermissions("ironfoinformationsxreport:ironfoinformationsx:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfoinformationsxService.delete(ironfoinformationsxService.get(id));
		}
		addMessage(redirectAttributes, "删除4.2信息化系统功能实现成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoinformationsxreport/ironfoinformationsx/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfoinformationsxreport:ironfoinformationsx:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfoinformationsxReport ironfoinformationsx, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "4.2信息化系统功能实现"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfoinformationsxReport> page = ironfoinformationsxService.findPage(new Page<IronfoinformationsxReport>(request, response, -1), ironfoinformationsx);
    		new ExportExcel("4.2信息化系统功能实现", IronfoinformationsxReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出4.2信息化系统功能实现记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoinformationsxreport/ironfoinformationsx/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfoinformationsxreport:ironfoinformationsx:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfoinformationsxReport> list = ei.getDataList(IronfoinformationsxReport.class);
			for (IronfoinformationsxReport ironfoinformationsx : list){
				try{
					ironfoinformationsxService.save(ironfoinformationsx);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条4.2信息化系统功能实现记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条4.2信息化系统功能实现记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入4.2信息化系统功能实现失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoinformationsxreport/ironfoinformationsx/?repage";
    }
	
	/**
	 * 下载导入4.2信息化系统功能实现数据模板
	 */
	@RequiresPermissions("ironfoinformationsxreport:ironfoinformationsx:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "4.2信息化系统功能实现数据导入模板.xlsx";
    		List<IronfoinformationsxReport> list = Lists.newArrayList(); 
    		new ExportExcel("4.2信息化系统功能实现数据", IronfoinformationsxReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoinformationsxreport/ironfoinformationsx/?repage";
    }
	
	
	

}