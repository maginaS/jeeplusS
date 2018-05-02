/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoqtkspzreport.web;

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
import com.jeeplus.modules.report.ironfoqtkspzreport.entity.IronfoqtkspzReport;
import com.jeeplus.modules.report.ironfoqtkspzreport.service.IronfoqtkspzReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 3.6其他科室医疗设备配置Controller
 * @author anti_magina
 * @version 2018-04-19
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfoqtkspzreport/ironfoqtkspz")
public class IronfoqtkspzReportController extends BaseController {

	@Autowired
	private IronfoqtkspzReportService ironfoqtkspzService;
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	@ModelAttribute
	public IronfoqtkspzReport get(@RequestParam(required=false) String id) {
		IronfoqtkspzReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfoqtkspzService.get(id);
		}
		if (entity == null){
			entity = new IronfoqtkspzReport();
		}
		return entity;
	}
	
	/**
	 * 3.6其他科室医疗设备配置列表页面
	 */
	@RequiresPermissions("ironfoqtkspzreport:ironfoqtkspz:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfoqtkspzReport ironfoqtkspz, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfoqtkspz.getDuser() != null&&ironfoqtkspz.getDuser().toString() != null && ironfoqtkspz.getDuser().toString().trim() != null
					&& !"".equals(ironfoqtkspz.getDuser().toString().trim())
					&& !"null".equals(ironfoqtkspz.getDuser().toString().trim())) {
				userId = ironfoqtkspz.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
				
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
			ironfoqtkspz.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Page<IronfoqtkspzReport> page = ironfoqtkspzService.findPage(new Page<IronfoqtkspzReport>(request, response), ironfoqtkspz); 
		model.addAttribute("page", page);
		return "modules/report/ironfoqtkspzreport/ironfoqtkspzList";
	}

	/**
	 * 查看，增加，编辑3.6其他科室医疗设备配置表单页面
	 */
	@RequiresPermissions(value={"ironfoqtkspzreport:ironfoqtkspz:view","ironfoqtkspzreport:ironfoqtkspz:add","ironfoqtkspzreport:ironfoqtkspz:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfoqtkspzReport ironfoqtkspz, Model model) {
		model.addAttribute("ironfoqtkspz", ironfoqtkspz);
		return "report/ironfoqtkspzreport/ironfoqtkspzForm";
	}

	/**
	 * 保存3.6其他科室医疗设备配置
	 */
	@RequiresPermissions(value={"ironfoqtkspzreport:ironfoqtkspz:add","ironfoqtkspzreport:ironfoqtkspz:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfoqtkspzReport ironfoqtkspz, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfoqtkspz)){
			return form(ironfoqtkspz, model);
		}
		if(!ironfoqtkspz.getIsNewRecord()){//编辑表单保存
			IronfoqtkspzReport t = ironfoqtkspzService.get(ironfoqtkspz.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfoqtkspz, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfoqtkspzService.save(t);//保存
		}else{//新增表单保存
			ironfoqtkspzService.save(ironfoqtkspz);//保存
		}
		addMessage(redirectAttributes, "保存3.6其他科室医疗设备配置成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoqtkspzreport/ironfoqtkspz/?repage";
	}
	
	/**
	 * 删除3.6其他科室医疗设备配置
	 */
	@RequiresPermissions("ironfoqtkspzreport:ironfoqtkspz:del")
	@RequestMapping(value = "delete")
	public String delete(IronfoqtkspzReport ironfoqtkspz, RedirectAttributes redirectAttributes) {
		ironfoqtkspzService.delete(ironfoqtkspz);
		addMessage(redirectAttributes, "删除3.6其他科室医疗设备配置成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoqtkspzreport/ironfoqtkspz/?repage";
	}
	
	/**
	 * 批量删除3.6其他科室医疗设备配置
	 */
	@RequiresPermissions("ironfoqtkspzreport:ironfoqtkspz:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfoqtkspzService.delete(ironfoqtkspzService.get(id));
		}
		addMessage(redirectAttributes, "删除3.6其他科室医疗设备配置成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoqtkspzreport/ironfoqtkspz/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfoqtkspzreport:ironfoqtkspz:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfoqtkspzReport ironfoqtkspz, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfoqtkspz.getDuser() != null&&ironfoqtkspz.getDuser().toString() != null && ironfoqtkspz.getDuser().toString().trim() != null
					&& !"".equals(ironfoqtkspz.getDuser().toString().trim())
					&& !"null".equals(ironfoqtkspz.getDuser().toString().trim())) {
				userId = ironfoqtkspz.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
				
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
			ironfoqtkspz.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "3.6其他科室医疗设备配置"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfoqtkspzReport> page = ironfoqtkspzService.findPage(new Page<IronfoqtkspzReport>(request, response, -1), ironfoqtkspz);
    		new ExportExcel("3.6其他科室医疗设备配置", IronfoqtkspzReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出3.6其他科室医疗设备配置记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"report/ironfoqtkspzreport/ironfoqtkspz/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfoqtkspzreport:ironfoqtkspz:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfoqtkspzReport> list = ei.getDataList(IronfoqtkspzReport.class);
			for (IronfoqtkspzReport ironfoqtkspz : list){
				try{
					ironfoqtkspzService.save(ironfoqtkspz);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条3.6其他科室医疗设备配置记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条3.6其他科室医疗设备配置记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入3.6其他科室医疗设备配置失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoqtkspzreport/ironfoqtkspz/?repage";
    }
	
	/**
	 * 下载导入3.6其他科室医疗设备配置数据模板
	 */
	@RequiresPermissions("ironfoqtkspzreport:ironfoqtkspz:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "3.6其他科室医疗设备配置数据导入模板.xlsx";
    		List<IronfoqtkspzReport> list = Lists.newArrayList(); 
    		new ExportExcel("3.6其他科室医疗设备配置数据", IronfoqtkspzReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoqtkspzreport/ironfoqtkspz/?repage";
    }
	
	
	

}