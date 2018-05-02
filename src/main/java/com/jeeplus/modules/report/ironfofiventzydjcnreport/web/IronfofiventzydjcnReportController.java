/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofiventzydjcnreport.web;

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
import com.jeeplus.modules.report.ironfofiventzydjcnreport.entity.IronfofiventzydjcnReport;
import com.jeeplus.modules.report.ironfofiventzydjcnreport.service.IronfofiventzydjcnReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 冬季采暖Controller
 * @author anti_magina
 * @version 2018-04-23
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfofiventzydjcnreport/ironfofiventzydjcn")
public class IronfofiventzydjcnReportController extends BaseController {

	@Autowired
	private IronfofiventzydjcnReportService ironfofiventzydjcnService;
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	@ModelAttribute
	public IronfofiventzydjcnReport get(@RequestParam(required=false) String id) {
		IronfofiventzydjcnReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfofiventzydjcnService.get(id);
		}
		if (entity == null){
			entity = new IronfofiventzydjcnReport();
		}
		return entity;
	}
	
	/**
	 * 冬季采暖列表页面
	 */
	@RequiresPermissions("ironfofiventzydjcnreport:ironfofiventzydjcn:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfofiventzydjcnReport ironfofiventzydjcn, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfofiventzydjcn.getDuser() != null&&ironfofiventzydjcn.getDuser().toString() != null && ironfofiventzydjcn.getDuser().toString().trim() != null
					&& !"".equals(ironfofiventzydjcn.getDuser().toString().trim())
					&& !"null".equals(ironfofiventzydjcn.getDuser().toString().trim())) {
				userId = ironfofiventzydjcn.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfofiventzydjcn.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Page<IronfofiventzydjcnReport> page = ironfofiventzydjcnService.findPage(new Page<IronfofiventzydjcnReport>(request, response), ironfofiventzydjcn); 
		model.addAttribute("page", page);
		return "modules/report/ironfofiventzydjcnreport/ironfofiventzydjcnList";
	}

	/**
	 * 查看，增加，编辑冬季采暖表单页面
	 */
	@RequiresPermissions(value={"ironfofiventzydjcnreport:ironfofiventzydjcn:view","ironfofiventzydjcnreport:ironfofiventzydjcn:add","ironfofiventzydjcnreport:ironfofiventzydjcn:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfofiventzydjcnReport ironfofiventzydjcn, Model model) {
		model.addAttribute("ironfofiventzydjcn", ironfofiventzydjcn);
		return "report/ironfofiventzydjcnreport/ironfofiventzydjcnForm";
	}

	/**
	 * 保存冬季采暖
	 */
	@RequiresPermissions(value={"ironfofiventzydjcnreport:ironfofiventzydjcn:add","ironfofiventzydjcnreport:ironfofiventzydjcn:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfofiventzydjcnReport ironfofiventzydjcn, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfofiventzydjcn)){
			return form(ironfofiventzydjcn, model);
		}
		if(!ironfofiventzydjcn.getIsNewRecord()){//编辑表单保存
			IronfofiventzydjcnReport t = ironfofiventzydjcnService.get(ironfofiventzydjcn.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfofiventzydjcn, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfofiventzydjcnService.save(t);//保存
		}else{//新增表单保存
			ironfofiventzydjcnService.save(ironfofiventzydjcn);//保存
		}
		addMessage(redirectAttributes, "保存冬季采暖成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofiventzydjcnreport/ironfofiventzydjcn/?repage";
	}
	
	/**
	 * 删除冬季采暖
	 */
	@RequiresPermissions("ironfofiventzydjcnreport:ironfofiventzydjcn:del")
	@RequestMapping(value = "delete")
	public String delete(IronfofiventzydjcnReport ironfofiventzydjcn, RedirectAttributes redirectAttributes) {
		ironfofiventzydjcnService.delete(ironfofiventzydjcn);
		addMessage(redirectAttributes, "删除冬季采暖成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofiventzydjcnreport/ironfofiventzydjcn/?repage";
	}
	
	/**
	 * 批量删除冬季采暖
	 */
	@RequiresPermissions("ironfofiventzydjcnreport:ironfofiventzydjcn:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfofiventzydjcnService.delete(ironfofiventzydjcnService.get(id));
		}
		addMessage(redirectAttributes, "删除冬季采暖成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofiventzydjcnreport/ironfofiventzydjcn/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfofiventzydjcnreport:ironfofiventzydjcn:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfofiventzydjcnReport ironfofiventzydjcn, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfofiventzydjcn.getDuser() != null&&ironfofiventzydjcn.getDuser().toString() != null && ironfofiventzydjcn.getDuser().toString().trim() != null
					&& !"".equals(ironfofiventzydjcn.getDuser().toString().trim())
					&& !"null".equals(ironfofiventzydjcn.getDuser().toString().trim())) {
				userId = ironfofiventzydjcn.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfofiventzydjcn.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "冬季采暖"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfofiventzydjcnReport> page = ironfofiventzydjcnService.findPage(new Page<IronfofiventzydjcnReport>(request, response, -1), ironfofiventzydjcn);
    		new ExportExcel("冬季采暖", IronfofiventzydjcnReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出冬季采暖记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/report/ironfofiventzydjcnreport/ironfofiventzydjcn/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfofiventzydjcnreport:ironfofiventzydjcn:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfofiventzydjcnReport> list = ei.getDataList(IronfofiventzydjcnReport.class);
			for (IronfofiventzydjcnReport ironfofiventzydjcn : list){
				try{
					ironfofiventzydjcnService.save(ironfofiventzydjcn);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条冬季采暖记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条冬季采暖记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入冬季采暖失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofiventzydjcnreport/ironfofiventzydjcn/?repage";
    }
	
	/**
	 * 下载导入冬季采暖数据模板
	 */
	@RequiresPermissions("ironfofiventzydjcnreport:ironfofiventzydjcn:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "冬季采暖数据导入模板.xlsx";
    		List<IronfofiventzydjcnReport> list = Lists.newArrayList(); 
    		new ExportExcel("冬季采暖数据", IronfofiventzydjcnReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofiventzydjcnreport/ironfofiventzydjcn/?repage";
    }
	
	
	

}