/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoyjbylsbpzykebyhkreport.web;

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
import com.jeeplus.modules.report.ironfoyjbylsbpzykebyhkreport.entity.IronfoyjbylsbpzykebyhkReport;
import com.jeeplus.modules.report.ironfoyjbylsbpzykebyhkreport.service.IronfoyjbylsbpzykebyhkReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 眼科、耳鼻咽喉科Controller
 * @author anti_magina
 * @version 2018-04-20
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfoyjbylsbpzykebyhkreport/ironfoyjbylsbpzykebyhk")
public class IronfoyjbylsbpzykebyhkReportController extends BaseController {

	@Autowired
	private IronfoyjbylsbpzykebyhkReportService ironfoyjbylsbpzykebyhkService;

	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	@ModelAttribute
	public IronfoyjbylsbpzykebyhkReport get(@RequestParam(required=false) String id) {
		IronfoyjbylsbpzykebyhkReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfoyjbylsbpzykebyhkService.get(id);
		}
		if (entity == null){
			entity = new IronfoyjbylsbpzykebyhkReport();
		}
		return entity;
	}
	
	/**
	 * 眼科、耳鼻咽喉科列表页面
	 */
	@RequiresPermissions("ironfoyjbylsbpzykebyhkreport:ironfoyjbylsbpzykebyhk:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfoyjbylsbpzykebyhkReport ironfoyjbylsbpzykebyhk, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfoyjbylsbpzykebyhk.getDuser() != null&&ironfoyjbylsbpzykebyhk.getDuser().toString() != null && ironfoyjbylsbpzykebyhk.getDuser().toString().trim() != null
					&& !"".equals(ironfoyjbylsbpzykebyhk.getDuser().toString().trim())
					&& !"null".equals(ironfoyjbylsbpzykebyhk.getDuser().toString().trim())) {
				userId = ironfoyjbylsbpzykebyhk.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				
				ironfoyjbylsbpzykebyhk.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Page<IronfoyjbylsbpzykebyhkReport> page = ironfoyjbylsbpzykebyhkService.findPage(new Page<IronfoyjbylsbpzykebyhkReport>(request, response), ironfoyjbylsbpzykebyhk); 
		model.addAttribute("page", page);
		return "modules/report/ironfoyjbylsbpzykebyhkreport/ironfoyjbylsbpzykebyhkList";
	}

	/**
	 * 查看，增加，编辑眼科、耳鼻咽喉科表单页面
	 */
	@RequiresPermissions(value={"ironfoyjbylsbpzykebyhkreport:ironfoyjbylsbpzykebyhk:view","ironfoyjbylsbpzykebyhkreport:ironfoyjbylsbpzykebyhk:add","ironfoyjbylsbpzykebyhkreport:ironfoyjbylsbpzykebyhk:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfoyjbylsbpzykebyhkReport ironfoyjbylsbpzykebyhk, Model model) {
		model.addAttribute("ironfoyjbylsbpzykebyhk", ironfoyjbylsbpzykebyhk);
		return "report/ironfoyjbylsbpzykebyhkreport/ironfoyjbylsbpzykebyhkForm";
	}

	/**
	 * 保存眼科、耳鼻咽喉科
	 */
	@RequiresPermissions(value={"ironfoyjbylsbpzykebyhkreport:ironfoyjbylsbpzykebyhk:add","ironfoyjbylsbpzykebyhkreport:ironfoyjbylsbpzykebyhk:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfoyjbylsbpzykebyhkReport ironfoyjbylsbpzykebyhk, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfoyjbylsbpzykebyhk)){
			return form(ironfoyjbylsbpzykebyhk, model);
		}
		if(!ironfoyjbylsbpzykebyhk.getIsNewRecord()){//编辑表单保存
			IronfoyjbylsbpzykebyhkReport t = ironfoyjbylsbpzykebyhkService.get(ironfoyjbylsbpzykebyhk.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfoyjbylsbpzykebyhk, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfoyjbylsbpzykebyhkService.save(t);//保存
		}else{//新增表单保存
			ironfoyjbylsbpzykebyhkService.save(ironfoyjbylsbpzykebyhk);//保存
		}
		addMessage(redirectAttributes, "保存眼科、耳鼻咽喉科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzykebyhkreport/ironfoyjbylsbpzykebyhk/?repage";
	}
	
	/**
	 * 删除眼科、耳鼻咽喉科
	 */
	@RequiresPermissions("ironfoyjbylsbpzykebyhkreport:ironfoyjbylsbpzykebyhk:del")
	@RequestMapping(value = "delete")
	public String delete(IronfoyjbylsbpzykebyhkReport ironfoyjbylsbpzykebyhk, RedirectAttributes redirectAttributes) {
		ironfoyjbylsbpzykebyhkService.delete(ironfoyjbylsbpzykebyhk);
		addMessage(redirectAttributes, "删除眼科、耳鼻咽喉科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzykebyhkreport/ironfoyjbylsbpzykebyhk/?repage";
	}
	
	/**
	 * 批量删除眼科、耳鼻咽喉科
	 */
	@RequiresPermissions("ironfoyjbylsbpzykebyhkreport:ironfoyjbylsbpzykebyhk:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfoyjbylsbpzykebyhkService.delete(ironfoyjbylsbpzykebyhkService.get(id));
		}
		addMessage(redirectAttributes, "删除眼科、耳鼻咽喉科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzykebyhkreport/ironfoyjbylsbpzykebyhk/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfoyjbylsbpzykebyhkreport:ironfoyjbylsbpzykebyhk:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfoyjbylsbpzykebyhkReport ironfoyjbylsbpzykebyhk, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfoyjbylsbpzykebyhk.getDuser() != null&&ironfoyjbylsbpzykebyhk.getDuser().toString() != null && ironfoyjbylsbpzykebyhk.getDuser().toString().trim() != null
					&& !"".equals(ironfoyjbylsbpzykebyhk.getDuser().toString().trim())
					&& !"null".equals(ironfoyjbylsbpzykebyhk.getDuser().toString().trim())) {
				userId = ironfoyjbylsbpzykebyhk.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				
				ironfoyjbylsbpzykebyhk.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "眼科、耳鼻咽喉科"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfoyjbylsbpzykebyhkReport> page = ironfoyjbylsbpzykebyhkService.findPage(new Page<IronfoyjbylsbpzykebyhkReport>(request, response, -1), ironfoyjbylsbpzykebyhk);
    		new ExportExcel("眼科、耳鼻咽喉科", IronfoyjbylsbpzykebyhkReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出眼科、耳鼻咽喉科记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzykebyhkreport/ironfoyjbylsbpzykebyhk/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfoyjbylsbpzykebyhkreport:ironfoyjbylsbpzykebyhk:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfoyjbylsbpzykebyhkReport> list = ei.getDataList(IronfoyjbylsbpzykebyhkReport.class);
			for (IronfoyjbylsbpzykebyhkReport ironfoyjbylsbpzykebyhk : list){
				try{
					ironfoyjbylsbpzykebyhkService.save(ironfoyjbylsbpzykebyhk);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条眼科、耳鼻咽喉科记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条眼科、耳鼻咽喉科记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入眼科、耳鼻咽喉科失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzykebyhkreport/ironfoyjbylsbpzykebyhk/?repage";
    }
	
	/**
	 * 下载导入眼科、耳鼻咽喉科数据模板
	 */
	@RequiresPermissions("ironfoyjbylsbpzykebyhkreport:ironfoyjbylsbpzykebyhk:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "眼科、耳鼻咽喉科数据导入模板.xlsx";
    		List<IronfoyjbylsbpzykebyhkReport> list = Lists.newArrayList(); 
    		new ExportExcel("眼科、耳鼻咽喉科数据", IronfoyjbylsbpzykebyhkReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzykebyhkreport/ironfoyjbylsbpzykebyhk/?repage";
    }
	
	
	

}