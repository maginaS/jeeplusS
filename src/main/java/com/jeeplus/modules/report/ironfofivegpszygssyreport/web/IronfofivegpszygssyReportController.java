/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofivegpszygssyreport.web;

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
import com.jeeplus.modules.ironfofivegpszygssy.entity.Ironfofivegpszygssy;
import com.jeeplus.modules.report.ironfofivegpszygssyreport.entity.IronfofivegpszygssyReport;
import com.jeeplus.modules.report.ironfofivegpszygssyreport.service.IronfofivegpszygssyReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 给水水源Controller
 * @author anti_magina
 * @version 2018-04-23
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfofivegpszygssyreport/ironfofivegpszygssy")
public class IronfofivegpszygssyReportController extends BaseController {

	@Autowired
	private IronfofivegpszygssyReportService ironfofivegpszygssyService;
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	@ModelAttribute
	public IronfofivegpszygssyReport get(@RequestParam(required=false) String id) {
		IronfofivegpszygssyReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfofivegpszygssyService.get(id);
		}
		if (entity == null){
			entity = new IronfofivegpszygssyReport();
		}
		return entity;
	}
	
	/**
	 * 给水水源列表页面
	 */
	@RequiresPermissions("ironfofivegpszygssyreport:ironfofivegpszygssy:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfofivegpszygssyReport ironfofivegpszygssy, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfofivegpszygssy.getDuser() != null&&ironfofivegpszygssy.getDuser().toString() != null && ironfofivegpszygssy.getDuser().toString().trim() != null
					&& !"".equals(ironfofivegpszygssy.getDuser().toString().trim())
					&& !"null".equals(ironfofivegpszygssy.getDuser().toString().trim())) {
				userId = ironfofivegpszygssy.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfofivegpszygssy.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Page<IronfofivegpszygssyReport> page = ironfofivegpszygssyService.findPage(new Page<IronfofivegpszygssyReport>(request, response), ironfofivegpszygssy); 
		model.addAttribute("page", page);
		return "modules/report/ironfofivegpszygssyreport/ironfofivegpszygssyList";
	}

	/**
	 * 查看，增加，编辑给水水源表单页面
	 */
	@RequiresPermissions(value={"ironfofivegpszygssyreport:ironfofivegpszygssy:view","ironfofivegpszygssyreport:ironfofivegpszygssy:add","ironfofivegpszygssyreport:ironfofivegpszygssy:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfofivegpszygssyReport ironfofivegpszygssy, Model model) {
		model.addAttribute("ironfofivegpszygssy", ironfofivegpszygssy);
		return "report/ironfofivegpszygssyreport/ironfofivegpszygssyForm";
	}

	/**
	 * 保存给水水源
	 */
	@RequiresPermissions(value={"ironfofivegpszygssyreport:ironfofivegpszygssy:add","ironfofivegpszygssyreport:ironfofivegpszygssy:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfofivegpszygssyReport ironfofivegpszygssy, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfofivegpszygssy)){
			return form(ironfofivegpszygssy, model);
		}
		if(!ironfofivegpszygssy.getIsNewRecord()){//编辑表单保存
			IronfofivegpszygssyReport t = ironfofivegpszygssyService.get(ironfofivegpszygssy.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfofivegpszygssy, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfofivegpszygssyService.save(t);//保存
		}else{//新增表单保存
			ironfofivegpszygssyService.save(ironfofivegpszygssy);//保存
		}
		addMessage(redirectAttributes, "保存给水水源成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivegpszygssyreport/ironfofivegpszygssy/?repage";
	}
	
	/**
	 * 删除给水水源
	 */
	@RequiresPermissions("ironfofivegpszygssyreport:ironfofivegpszygssy:del")
	@RequestMapping(value = "delete")
	public String delete(IronfofivegpszygssyReport ironfofivegpszygssy, RedirectAttributes redirectAttributes) {
		ironfofivegpszygssyService.delete(ironfofivegpszygssy);
		addMessage(redirectAttributes, "删除给水水源成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivegpszygssyreport/ironfofivegpszygssy/?repage";
	}
	
	/**
	 * 批量删除给水水源
	 */
	@RequiresPermissions("ironfofivegpszygssyreport:ironfofivegpszygssy:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfofivegpszygssyService.delete(ironfofivegpszygssyService.get(id));
		}
		addMessage(redirectAttributes, "删除给水水源成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivegpszygssyreport/ironfofivegpszygssy/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfofivegpszygssyreport:ironfofivegpszygssy:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfofivegpszygssyReport ironfofivegpszygssy, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfofivegpszygssy.getDuser() != null&&ironfofivegpszygssy.getDuser().toString() != null && ironfofivegpszygssy.getDuser().toString().trim() != null
					&& !"".equals(ironfofivegpszygssy.getDuser().toString().trim())
					&& !"null".equals(ironfofivegpszygssy.getDuser().toString().trim())) {
				userId = ironfofivegpszygssy.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfofivegpszygssy.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "给水水源"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfofivegpszygssyReport> page = ironfofivegpszygssyService.findPage(new Page<IronfofivegpszygssyReport>(request, response, -1), ironfofivegpszygssy);
    		ExportExcel exls = new ExportExcel("给水水源", IronfofivegpszygssyReport.class);
//    		List<IronfofivegpszygssyReport> list1 = page.getList();
//            List<String> headerList = exls.getHeaderList();
//            for (String header : headerList) {
//            	for(IronfofivegpszygssyReport iron :list1){
//            		header += iron.get
//            	}
//				header.
//			}
            exls.setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出给水水源记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/report/ironfofivegpszygssyreport/ironfofivegpszygssy/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfofivegpszygssyreport:ironfofivegpszygssy:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfofivegpszygssyReport> list = ei.getDataList(IronfofivegpszygssyReport.class);
			for (IronfofivegpszygssyReport ironfofivegpszygssy : list){
				try{
					ironfofivegpszygssyService.save(ironfofivegpszygssy);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条给水水源记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条给水水源记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入给水水源失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivegpszygssyreport/ironfofivegpszygssy/?repage";
    }
	
	/**
	 * 下载导入给水水源数据模板
	 */
	@RequiresPermissions("ironfofivegpszygssyreport:ironfofivegpszygssy:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "给水水源数据导入模板.xlsx";
    		List<IronfofivegpszygssyReport> list = Lists.newArrayList(); 
    		new ExportExcel("给水水源数据", IronfofivegpszygssyReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivegpszygssyreport/ironfofivegpszygssy/?repage";
    }
	
	
	

}