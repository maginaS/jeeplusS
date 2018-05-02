/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofiventzyxjzlreport.web;

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
import com.jeeplus.modules.report.ironfofiventzyxjzlreport.entity.IronfofiventzyxjzlReport;
import com.jeeplus.modules.report.ironfofiventzyxjzlreport.service.IronfofiventzyxjzlReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 夏季制冷Controller
 * @author anti_magina
 * @version 2018-04-23
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfofiventzyxjzlreport/ironfofiventzyxjzl")
public class IronfofiventzyxjzlReportController extends BaseController {

	@Autowired
	private IronfofiventzyxjzlReportService ironfofiventzyxjzlService;
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	@ModelAttribute
	public IronfofiventzyxjzlReport get(@RequestParam(required=false) String id) {
		IronfofiventzyxjzlReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfofiventzyxjzlService.get(id);
		}
		if (entity == null){
			entity = new IronfofiventzyxjzlReport();
		}
		return entity;
	}
	
	/**
	 * 夏季制冷列表页面
	 */
	@RequiresPermissions("ironfofiventzyxjzlreport:ironfofiventzyxjzl:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfofiventzyxjzlReport ironfofiventzyxjzl, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfofiventzyxjzl.getDuser() != null&&ironfofiventzyxjzl.getDuser().toString() != null && ironfofiventzyxjzl.getDuser().toString().trim() != null
					&& !"".equals(ironfofiventzyxjzl.getDuser().toString().trim())
					&& !"null".equals(ironfofiventzyxjzl.getDuser().toString().trim())) {
				userId = ironfofiventzyxjzl.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfofiventzyxjzl.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Page<IronfofiventzyxjzlReport> page = ironfofiventzyxjzlService.findPage(new Page<IronfofiventzyxjzlReport>(request, response), ironfofiventzyxjzl); 
		model.addAttribute("page", page);
		return "modules/report/ironfofiventzyxjzlreport/ironfofiventzyxjzlList";
	}

	/**
	 * 查看，增加，编辑夏季制冷表单页面
	 */
	@RequiresPermissions(value={"ironfofiventzyxjzlreport:ironfofiventzyxjzl:view","ironfofiventzyxjzlreport:ironfofiventzyxjzl:add","ironfofiventzyxjzlreport:ironfofiventzyxjzl:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfofiventzyxjzlReport ironfofiventzyxjzl, Model model) {
		model.addAttribute("ironfofiventzyxjzl", ironfofiventzyxjzl);
		return "report/ironfofiventzyxjzlreport/ironfofiventzyxjzlForm";
	}

	/**
	 * 保存夏季制冷
	 */
	@RequiresPermissions(value={"ironfofiventzyxjzlreport:ironfofiventzyxjzl:add","ironfofiventzyxjzlreport:ironfofiventzyxjzl:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfofiventzyxjzlReport ironfofiventzyxjzl, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfofiventzyxjzl)){
			return form(ironfofiventzyxjzl, model);
		}
		if(!ironfofiventzyxjzl.getIsNewRecord()){//编辑表单保存
			IronfofiventzyxjzlReport t = ironfofiventzyxjzlService.get(ironfofiventzyxjzl.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfofiventzyxjzl, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfofiventzyxjzlService.save(t);//保存
		}else{//新增表单保存
			ironfofiventzyxjzlService.save(ironfofiventzyxjzl);//保存
		}
		addMessage(redirectAttributes, "保存夏季制冷成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofiventzyxjzlreport/ironfofiventzyxjzl/?repage";
	}
	
	/**
	 * 删除夏季制冷
	 */
	@RequiresPermissions("ironfofiventzyxjzlreport:ironfofiventzyxjzl:del")
	@RequestMapping(value = "delete")
	public String delete(IronfofiventzyxjzlReport ironfofiventzyxjzl, RedirectAttributes redirectAttributes) {
		ironfofiventzyxjzlService.delete(ironfofiventzyxjzl);
		addMessage(redirectAttributes, "删除夏季制冷成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofiventzyxjzlreport/ironfofiventzyxjzl/?repage";
	}
	
	/**
	 * 批量删除夏季制冷
	 */
	@RequiresPermissions("ironfofiventzyxjzlreport:ironfofiventzyxjzl:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfofiventzyxjzlService.delete(ironfofiventzyxjzlService.get(id));
		}
		addMessage(redirectAttributes, "删除夏季制冷成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofiventzyxjzlreport/ironfofiventzyxjzl/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfofiventzyxjzlreport:ironfofiventzyxjzl:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfofiventzyxjzlReport ironfofiventzyxjzl, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfofiventzyxjzl.getDuser() != null&&ironfofiventzyxjzl.getDuser().toString() != null && ironfofiventzyxjzl.getDuser().toString().trim() != null
					&& !"".equals(ironfofiventzyxjzl.getDuser().toString().trim())
					&& !"null".equals(ironfofiventzyxjzl.getDuser().toString().trim())) {
				userId = ironfofiventzyxjzl.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfofiventzyxjzl.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "夏季制冷"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfofiventzyxjzlReport> page = ironfofiventzyxjzlService.findPage(new Page<IronfofiventzyxjzlReport>(request, response, -1), ironfofiventzyxjzl);
    		new ExportExcel("夏季制冷", IronfofiventzyxjzlReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出夏季制冷记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/report/ironfofiventzyxjzlreport/ironfofiventzyxjzl/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfofiventzyxjzlreport:ironfofiventzyxjzl:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfofiventzyxjzlReport> list = ei.getDataList(IronfofiventzyxjzlReport.class);
			for (IronfofiventzyxjzlReport ironfofiventzyxjzl : list){
				try{
					ironfofiventzyxjzlService.save(ironfofiventzyxjzl);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条夏季制冷记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条夏季制冷记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入夏季制冷失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofiventzyxjzlreport/ironfofiventzyxjzl/?repage";
    }
	
	/**
	 * 下载导入夏季制冷数据模板
	 */
	@RequiresPermissions("ironfofiventzyxjzlreport:ironfofiventzyxjzl:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "夏季制冷数据导入模板.xlsx";
    		List<IronfofiventzyxjzlReport> list = Lists.newArrayList(); 
    		new ExportExcel("夏季制冷数据", IronfofiventzyxjzlReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofiventzyxjzlreport/ironfofiventzyxjzl/?repage";
    }
	
	
	

}