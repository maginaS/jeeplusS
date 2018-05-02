/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoyjbylsbpzjykreport.web;

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
import com.jeeplus.modules.report.ironfoyjbylsbpzjykreport.entity.IronfoyjbylsbpzjykReport;
import com.jeeplus.modules.report.ironfoyjbylsbpzjykreport.service.IronfoyjbylsbpzjykReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 检验科Controller
 * @author anti_magina
 * @version 2018-04-20
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfoyjbylsbpzjykreport/ironfoyjbylsbpzjyk")
public class IronfoyjbylsbpzjykReportController extends BaseController {

	@Autowired
	private IronfoyjbylsbpzjykReportService ironfoyjbylsbpzjykService;
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	@ModelAttribute
	public IronfoyjbylsbpzjykReport get(@RequestParam(required=false) String id) {
		IronfoyjbylsbpzjykReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfoyjbylsbpzjykService.get(id);
		}
		if (entity == null){
			entity = new IronfoyjbylsbpzjykReport();
		}
		return entity;
	}
	
	/**
	 * 检验科列表页面
	 */
	@RequiresPermissions("ironfoyjbylsbpzjykreport:ironfoyjbylsbpzjyk:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfoyjbylsbpzjykReport ironfoyjbylsbpzjyk, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfoyjbylsbpzjyk.getDuser() != null&&ironfoyjbylsbpzjyk.getDuser().toString() != null && ironfoyjbylsbpzjyk.getDuser().toString().trim() != null
					&& !"".equals(ironfoyjbylsbpzjyk.getDuser().toString().trim())
					&& !"null".equals(ironfoyjbylsbpzjyk.getDuser().toString().trim())) {
				userId = ironfoyjbylsbpzjyk.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				
				ironfoyjbylsbpzjyk.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Page<IronfoyjbylsbpzjykReport> page = ironfoyjbylsbpzjykService.findPage(new Page<IronfoyjbylsbpzjykReport>(request, response), ironfoyjbylsbpzjyk); 
		model.addAttribute("page", page);
		return "modules/report/ironfoyjbylsbpzjykreport/ironfoyjbylsbpzjykList";
	}

	/**
	 * 查看，增加，编辑检验科表单页面
	 */
	@RequiresPermissions(value={"ironfoyjbylsbpzjykreport:ironfoyjbylsbpzjyk:view","ironfoyjbylsbpzjykreport:ironfoyjbylsbpzjyk:add","ironfoyjbylsbpzjykreport:ironfoyjbylsbpzjyk:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfoyjbylsbpzjykReport ironfoyjbylsbpzjyk, Model model) {
		model.addAttribute("ironfoyjbylsbpzjyk", ironfoyjbylsbpzjyk);
		return "report/ironfoyjbylsbpzjykreport/ironfoyjbylsbpzjykForm";
	}

	/**
	 * 保存检验科
	 */
	@RequiresPermissions(value={"ironfoyjbylsbpzjykreport:ironfoyjbylsbpzjyk:add","ironfoyjbylsbpzjykreport:ironfoyjbylsbpzjyk:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfoyjbylsbpzjykReport ironfoyjbylsbpzjyk, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfoyjbylsbpzjyk)){
			return form(ironfoyjbylsbpzjyk, model);
		}
		if(!ironfoyjbylsbpzjyk.getIsNewRecord()){//编辑表单保存
			IronfoyjbylsbpzjykReport t = ironfoyjbylsbpzjykService.get(ironfoyjbylsbpzjyk.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfoyjbylsbpzjyk, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfoyjbylsbpzjykService.save(t);//保存
		}else{//新增表单保存
			ironfoyjbylsbpzjykService.save(ironfoyjbylsbpzjyk);//保存
		}
		addMessage(redirectAttributes, "保存检验科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzjykreport/ironfoyjbylsbpzjyk/?repage";
	}
	
	/**
	 * 删除检验科
	 */
	@RequiresPermissions("ironfoyjbylsbpzjykreport:ironfoyjbylsbpzjyk:del")
	@RequestMapping(value = "delete")
	public String delete(IronfoyjbylsbpzjykReport ironfoyjbylsbpzjyk, RedirectAttributes redirectAttributes) {
		ironfoyjbylsbpzjykService.delete(ironfoyjbylsbpzjyk);
		addMessage(redirectAttributes, "删除检验科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzjykreport/ironfoyjbylsbpzjyk/?repage";
	}
	
	/**
	 * 批量删除检验科
	 */
	@RequiresPermissions("ironfoyjbylsbpzjykreport:ironfoyjbylsbpzjyk:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfoyjbylsbpzjykService.delete(ironfoyjbylsbpzjykService.get(id));
		}
		addMessage(redirectAttributes, "删除检验科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzjykreport/ironfoyjbylsbpzjyk/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfoyjbylsbpzjykreport:ironfoyjbylsbpzjyk:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfoyjbylsbpzjykReport ironfoyjbylsbpzjyk, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfoyjbylsbpzjyk.getDuser() != null&&ironfoyjbylsbpzjyk.getDuser().toString() != null && ironfoyjbylsbpzjyk.getDuser().toString().trim() != null
					&& !"".equals(ironfoyjbylsbpzjyk.getDuser().toString().trim())
					&& !"null".equals(ironfoyjbylsbpzjyk.getDuser().toString().trim())) {
				userId = ironfoyjbylsbpzjyk.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				
				ironfoyjbylsbpzjyk.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "检验科"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfoyjbylsbpzjykReport> page = ironfoyjbylsbpzjykService.findPage(new Page<IronfoyjbylsbpzjykReport>(request, response, -1), ironfoyjbylsbpzjyk);
    		new ExportExcel("检验科", IronfoyjbylsbpzjykReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出检验科记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"report/ironfoyjbylsbpzjykreport/ironfoyjbylsbpzjyk/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfoyjbylsbpzjykreport:ironfoyjbylsbpzjyk:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfoyjbylsbpzjykReport> list = ei.getDataList(IronfoyjbylsbpzjykReport.class);
			for (IronfoyjbylsbpzjykReport ironfoyjbylsbpzjyk : list){
				try{
					ironfoyjbylsbpzjykService.save(ironfoyjbylsbpzjyk);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条检验科记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条检验科记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入检验科失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzjykreport/ironfoyjbylsbpzjyk/?repage";
    }
	
	/**
	 * 下载导入检验科数据模板
	 */
	@RequiresPermissions("ironfoyjbylsbpzjykreport:ironfoyjbylsbpzjyk:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "检验科数据导入模板.xlsx";
    		List<IronfoyjbylsbpzjykReport> list = Lists.newArrayList(); 
    		new ExportExcel("检验科数据", IronfoyjbylsbpzjykReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzjykreport/ironfoyjbylsbpzjyk/?repage";
    }
	
	
	

}