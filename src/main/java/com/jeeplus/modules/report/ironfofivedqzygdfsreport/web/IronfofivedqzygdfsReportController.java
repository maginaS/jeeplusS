/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofivedqzygdfsreport.web;

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
import com.jeeplus.modules.report.ironfofivedqzygdfsreport.entity.IronfofivedqzygdfsReport;
import com.jeeplus.modules.report.ironfofivedqzygdfsreport.service.IronfofivedqzygdfsReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 供电方式Controller
 * @author anti_magina
 * @version 2018-04-23
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfofivedqzygdfsreport/ironfofivedqzygdfs")
public class IronfofivedqzygdfsReportController extends BaseController {

	@Autowired
	private IronfofivedqzygdfsReportService ironfofivedqzygdfsService;

	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	@ModelAttribute
	public IronfofivedqzygdfsReport get(@RequestParam(required=false) String id) {
		IronfofivedqzygdfsReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfofivedqzygdfsService.get(id);
		}
		if (entity == null){
			entity = new IronfofivedqzygdfsReport();
		}
		return entity;
	}
	
	/**
	 * 供电方式列表页面
	 */
	@RequiresPermissions("ironfofivedqzygdfsreport:ironfofivedqzygdfs:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfofivedqzygdfsReport ironfofivedqzygdfs, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfofivedqzygdfs.getDuser() != null&&ironfofivedqzygdfs.getDuser().toString() != null && ironfofivedqzygdfs.getDuser().toString().trim() != null
					&& !"".equals(ironfofivedqzygdfs.getDuser().toString().trim())
					&& !"null".equals(ironfofivedqzygdfs.getDuser().toString().trim())) {
				userId = ironfofivedqzygdfs.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfofivedqzygdfs.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Page<IronfofivedqzygdfsReport> page = ironfofivedqzygdfsService.findPage(new Page<IronfofivedqzygdfsReport>(request, response), ironfofivedqzygdfs); 
		model.addAttribute("page", page);
		return "modules/report/ironfofivedqzygdfsreport/ironfofivedqzygdfsList";
	}

	/**
	 * 查看，增加，编辑供电方式表单页面
	 */
	@RequiresPermissions(value={"ironfofivedqzygdfsreport:ironfofivedqzygdfs:view","ironfofivedqzygdfsreport:ironfofivedqzygdfs:add","ironfofivedqzygdfsreport:ironfofivedqzygdfs:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfofivedqzygdfsReport ironfofivedqzygdfs, Model model) {
		model.addAttribute("ironfofivedqzygdfs", ironfofivedqzygdfs);
		return "report/ironfofivedqzygdfsreport/ironfofivedqzygdfsForm";
	}

	/**
	 * 保存供电方式
	 */
	@RequiresPermissions(value={"ironfofivedqzygdfsreport:ironfofivedqzygdfs:add","ironfofivedqzygdfsreport:ironfofivedqzygdfs:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfofivedqzygdfsReport ironfofivedqzygdfs, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfofivedqzygdfs)){
			return form(ironfofivedqzygdfs, model);
		}
		if(!ironfofivedqzygdfs.getIsNewRecord()){//编辑表单保存
			IronfofivedqzygdfsReport t = ironfofivedqzygdfsService.get(ironfofivedqzygdfs.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfofivedqzygdfs, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfofivedqzygdfsService.save(t);//保存
		}else{//新增表单保存
			ironfofivedqzygdfsService.save(ironfofivedqzygdfs);//保存
		}
		addMessage(redirectAttributes, "保存供电方式成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivedqzygdfsreport/ironfofivedqzygdfs/?repage";
	}
	
	/**
	 * 删除供电方式
	 */
	@RequiresPermissions("ironfofivedqzygdfsreport:ironfofivedqzygdfs:del")
	@RequestMapping(value = "delete")
	public String delete(IronfofivedqzygdfsReport ironfofivedqzygdfs, RedirectAttributes redirectAttributes) {
		ironfofivedqzygdfsService.delete(ironfofivedqzygdfs);
		addMessage(redirectAttributes, "删除供电方式成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivedqzygdfsreport/ironfofivedqzygdfs/?repage";
	}
	
	/**
	 * 批量删除供电方式
	 */
	@RequiresPermissions("ironfofivedqzygdfsreport:ironfofivedqzygdfs:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfofivedqzygdfsService.delete(ironfofivedqzygdfsService.get(id));
		}
		addMessage(redirectAttributes, "删除供电方式成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivedqzygdfsreport/ironfofivedqzygdfs/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfofivedqzygdfsreport:ironfofivedqzygdfs:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfofivedqzygdfsReport ironfofivedqzygdfs, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfofivedqzygdfs.getDuser() != null&&ironfofivedqzygdfs.getDuser().toString() != null && ironfofivedqzygdfs.getDuser().toString().trim() != null
					&& !"".equals(ironfofivedqzygdfs.getDuser().toString().trim())
					&& !"null".equals(ironfofivedqzygdfs.getDuser().toString().trim())) {
				userId = ironfofivedqzygdfs.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfofivedqzygdfs.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "供电方式"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfofivedqzygdfsReport> page = ironfofivedqzygdfsService.findPage(new Page<IronfofivedqzygdfsReport>(request, response, -1), ironfofivedqzygdfs);
    		new ExportExcel("供电方式", IronfofivedqzygdfsReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出供电方式记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/report/ironfofivedqzygdfsreport/ironfofivedqzygdfs/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfofivedqzygdfsreport:ironfofivedqzygdfs:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfofivedqzygdfsReport> list = ei.getDataList(IronfofivedqzygdfsReport.class);
			for (IronfofivedqzygdfsReport ironfofivedqzygdfs : list){
				try{
					ironfofivedqzygdfsService.save(ironfofivedqzygdfs);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条供电方式记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条供电方式记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入供电方式失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivedqzygdfsreport/ironfofivedqzygdfs/?repage";
    }
	
	/**
	 * 下载导入供电方式数据模板
	 */
	@RequiresPermissions("ironfofivedqzygdfsreport:ironfofivedqzygdfs:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "供电方式数据导入模板.xlsx";
    		List<IronfofivedqzygdfsReport> list = Lists.newArrayList(); 
    		new ExportExcel("供电方式数据", IronfofivedqzygdfsReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivedqzygdfsreport/ironfofivedqzygdfs/?repage";
    }
	
	
	

}