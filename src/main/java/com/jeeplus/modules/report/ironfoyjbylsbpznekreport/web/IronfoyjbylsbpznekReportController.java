/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoyjbylsbpznekreport.web;

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
import com.jeeplus.modules.report.ironfoyjbylsbpznekreport.entity.IronfoyjbylsbpznekReport;
import com.jeeplus.modules.report.ironfoyjbylsbpznekreport.service.IronfoyjbylsbpznekReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 内（儿）科Controller
 * @author anti_magina
 * @version 2018-04-20
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfoyjbylsbpznekreport/ironfoyjbylsbpznek")
public class IronfoyjbylsbpznekReportController extends BaseController {

	@Autowired
	private IronfoyjbylsbpznekReportService ironfoyjbylsbpznekService;
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	@ModelAttribute
	public IronfoyjbylsbpznekReport get(@RequestParam(required=false) String id) {
		IronfoyjbylsbpznekReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfoyjbylsbpznekService.get(id);
		}
		if (entity == null){
			entity = new IronfoyjbylsbpznekReport();
		}
		return entity;
	}
	
	/**
	 * 内（儿）科列表页面
	 */
	@RequiresPermissions("ironfoyjbylsbpznekreport:ironfoyjbylsbpznek:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfoyjbylsbpznekReport ironfoyjbylsbpznek, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfoyjbylsbpznek.getDuser() != null&&ironfoyjbylsbpznek.getDuser().toString() != null && ironfoyjbylsbpznek.getDuser().toString().trim() != null
					&& !"".equals(ironfoyjbylsbpznek.getDuser().toString().trim())
					&& !"null".equals(ironfoyjbylsbpznek.getDuser().toString().trim())) {
				userId = ironfoyjbylsbpznek.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				
				ironfoyjbylsbpznek.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Page<IronfoyjbylsbpznekReport> page = ironfoyjbylsbpznekService.findPage(new Page<IronfoyjbylsbpznekReport>(request, response), ironfoyjbylsbpznek); 
		model.addAttribute("page", page);
		return "modules/report/ironfoyjbylsbpznekreport/ironfoyjbylsbpznekList";
	}

	/**
	 * 查看，增加，编辑内（儿）科表单页面
	 */
	@RequiresPermissions(value={"ironfoyjbylsbpznekreport:ironfoyjbylsbpznek:view","ironfoyjbylsbpznekreport:ironfoyjbylsbpznek:add","ironfoyjbylsbpznekreport:ironfoyjbylsbpznek:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfoyjbylsbpznekReport ironfoyjbylsbpznek, Model model) {
		model.addAttribute("ironfoyjbylsbpznek", ironfoyjbylsbpznek);
		return "report/ironfoyjbylsbpznekreport/ironfoyjbylsbpznekForm";
	}

	/**
	 * 保存内（儿）科
	 */
	@RequiresPermissions(value={"ironfoyjbylsbpznekreport:ironfoyjbylsbpznek:add","ironfoyjbylsbpznekreport:ironfoyjbylsbpznek:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfoyjbylsbpznekReport ironfoyjbylsbpznek, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfoyjbylsbpznek)){
			return form(ironfoyjbylsbpznek, model);
		}
		if(!ironfoyjbylsbpznek.getIsNewRecord()){//编辑表单保存
			IronfoyjbylsbpznekReport t = ironfoyjbylsbpznekService.get(ironfoyjbylsbpznek.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfoyjbylsbpznek, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfoyjbylsbpznekService.save(t);//保存
		}else{//新增表单保存
			ironfoyjbylsbpznekService.save(ironfoyjbylsbpznek);//保存
		}
		addMessage(redirectAttributes, "保存内（儿）科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpznekreport/ironfoyjbylsbpznek/?repage";
	}
	
	/**
	 * 删除内（儿）科
	 */
	@RequiresPermissions("ironfoyjbylsbpznekreport:ironfoyjbylsbpznek:del")
	@RequestMapping(value = "delete")
	public String delete(IronfoyjbylsbpznekReport ironfoyjbylsbpznek, RedirectAttributes redirectAttributes) {
		ironfoyjbylsbpznekService.delete(ironfoyjbylsbpznek);
		addMessage(redirectAttributes, "删除内（儿）科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpznekreport/ironfoyjbylsbpznek/?repage";
	}
	
	/**
	 * 批量删除内（儿）科
	 */
	@RequiresPermissions("ironfoyjbylsbpznekreport:ironfoyjbylsbpznek:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfoyjbylsbpznekService.delete(ironfoyjbylsbpznekService.get(id));
		}
		addMessage(redirectAttributes, "删除内（儿）科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpznekreport/ironfoyjbylsbpznek/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfoyjbylsbpznekreport:ironfoyjbylsbpznek:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfoyjbylsbpznekReport ironfoyjbylsbpznek, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfoyjbylsbpznek.getDuser() != null&&ironfoyjbylsbpznek.getDuser().toString() != null && ironfoyjbylsbpznek.getDuser().toString().trim() != null
					&& !"".equals(ironfoyjbylsbpznek.getDuser().toString().trim())
					&& !"null".equals(ironfoyjbylsbpznek.getDuser().toString().trim())) {
				userId = ironfoyjbylsbpznek.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfoyjbylsbpznek.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "内（儿）科"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfoyjbylsbpznekReport> page = ironfoyjbylsbpznekService.findPage(new Page<IronfoyjbylsbpznekReport>(request, response, -1), ironfoyjbylsbpznek);
    		new ExportExcel("内（儿）科", IronfoyjbylsbpznekReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出内（儿）科记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpznekreport/ironfoyjbylsbpznek/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfoyjbylsbpznekreport:ironfoyjbylsbpznek:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfoyjbylsbpznekReport> list = ei.getDataList(IronfoyjbylsbpznekReport.class);
			for (IronfoyjbylsbpznekReport ironfoyjbylsbpznek : list){
				try{
					ironfoyjbylsbpznekService.save(ironfoyjbylsbpznek);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条内（儿）科记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条内（儿）科记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入内（儿）科失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpznekreport/ironfoyjbylsbpznek/?repage";
    }
	
	/**
	 * 下载导入内（儿）科数据模板
	 */
	@RequiresPermissions("ironfoyjbylsbpznekreport:ironfoyjbylsbpznek:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "内（儿）科数据导入模板.xlsx";
    		List<IronfoyjbylsbpznekReport> list = Lists.newArrayList(); 
    		new ExportExcel("内（儿）科数据", IronfoyjbylsbpznekReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpznekreport/ironfoyjbylsbpznek/?repage";
    }
	
	
	

}