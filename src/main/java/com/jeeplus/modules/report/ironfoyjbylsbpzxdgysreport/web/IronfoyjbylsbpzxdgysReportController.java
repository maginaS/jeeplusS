/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoyjbylsbpzxdgysreport.web;

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
import com.jeeplus.modules.report.ironfoyjbylsbpzxdgysreport.entity.IronfoyjbylsbpzxdgysReport;
import com.jeeplus.modules.report.ironfoyjbylsbpzxdgysreport.service.IronfoyjbylsbpzxdgysReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 消毒供应室Controller
 * @author anti_magina
 * @version 2018-04-20
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfoyjbylsbpzxdgysreport/ironfoyjbylsbpzxdgys")
public class IronfoyjbylsbpzxdgysReportController extends BaseController {

	@Autowired
	private IronfoyjbylsbpzxdgysReportService ironfoyjbylsbpzxdgysService;

	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	@ModelAttribute
	public IronfoyjbylsbpzxdgysReport get(@RequestParam(required=false) String id) {
		IronfoyjbylsbpzxdgysReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfoyjbylsbpzxdgysService.get(id);
		}
		if (entity == null){
			entity = new IronfoyjbylsbpzxdgysReport();
		}
		return entity;
	}
	
	/**
	 * 消毒供应室列表页面
	 */
	@RequiresPermissions("ironfoyjbylsbpzxdgysreport:ironfoyjbylsbpzxdgys:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfoyjbylsbpzxdgysReport ironfoyjbylsbpzxdgys, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfoyjbylsbpzxdgys.getDuser() != null&&ironfoyjbylsbpzxdgys.getDuser().toString() != null && ironfoyjbylsbpzxdgys.getDuser().toString().trim() != null
					&& !"".equals(ironfoyjbylsbpzxdgys.getDuser().toString().trim())
					&& !"null".equals(ironfoyjbylsbpzxdgys.getDuser().toString().trim())) {
				userId = ironfoyjbylsbpzxdgys.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				
				ironfoyjbylsbpzxdgys.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Page<IronfoyjbylsbpzxdgysReport> page = ironfoyjbylsbpzxdgysService.findPage(new Page<IronfoyjbylsbpzxdgysReport>(request, response), ironfoyjbylsbpzxdgys); 
		model.addAttribute("page", page);
		return "modules/report/ironfoyjbylsbpzxdgysreport/ironfoyjbylsbpzxdgysList";
	}

	/**
	 * 查看，增加，编辑消毒供应室表单页面
	 */
	@RequiresPermissions(value={"ironfoyjbylsbpzxdgysreport:ironfoyjbylsbpzxdgys:view","ironfoyjbylsbpzxdgysreport:ironfoyjbylsbpzxdgys:add","ironfoyjbylsbpzxdgysreport:ironfoyjbylsbpzxdgys:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfoyjbylsbpzxdgysReport ironfoyjbylsbpzxdgys, Model model) {
		model.addAttribute("ironfoyjbylsbpzxdgys", ironfoyjbylsbpzxdgys);
		return "report/ironfoyjbylsbpzxdgysreport/ironfoyjbylsbpzxdgysForm";
	}

	/**
	 * 保存消毒供应室
	 */
	@RequiresPermissions(value={"ironfoyjbylsbpzxdgysreport:ironfoyjbylsbpzxdgys:add","ironfoyjbylsbpzxdgysreport:ironfoyjbylsbpzxdgys:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfoyjbylsbpzxdgysReport ironfoyjbylsbpzxdgys, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfoyjbylsbpzxdgys)){
			return form(ironfoyjbylsbpzxdgys, model);
		}
		if(!ironfoyjbylsbpzxdgys.getIsNewRecord()){//编辑表单保存
			IronfoyjbylsbpzxdgysReport t = ironfoyjbylsbpzxdgysService.get(ironfoyjbylsbpzxdgys.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfoyjbylsbpzxdgys, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfoyjbylsbpzxdgysService.save(t);//保存
		}else{//新增表单保存
			ironfoyjbylsbpzxdgysService.save(ironfoyjbylsbpzxdgys);//保存
		}
		addMessage(redirectAttributes, "保存消毒供应室成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzxdgysreport/ironfoyjbylsbpzxdgys/?repage";
	}
	
	/**
	 * 删除消毒供应室
	 */
	@RequiresPermissions("ironfoyjbylsbpzxdgysreport:ironfoyjbylsbpzxdgys:del")
	@RequestMapping(value = "delete")
	public String delete(IronfoyjbylsbpzxdgysReport ironfoyjbylsbpzxdgys, RedirectAttributes redirectAttributes) {
		ironfoyjbylsbpzxdgysService.delete(ironfoyjbylsbpzxdgys);
		addMessage(redirectAttributes, "删除消毒供应室成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzxdgysreport/ironfoyjbylsbpzxdgys/?repage";
	}
	
	/**
	 * 批量删除消毒供应室
	 */
	@RequiresPermissions("ironfoyjbylsbpzxdgysreport:ironfoyjbylsbpzxdgys:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfoyjbylsbpzxdgysService.delete(ironfoyjbylsbpzxdgysService.get(id));
		}
		addMessage(redirectAttributes, "删除消毒供应室成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzxdgysreport/ironfoyjbylsbpzxdgys/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfoyjbylsbpzxdgysreport:ironfoyjbylsbpzxdgys:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfoyjbylsbpzxdgysReport ironfoyjbylsbpzxdgys, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfoyjbylsbpzxdgys.getDuser() != null&&ironfoyjbylsbpzxdgys.getDuser().toString() != null && ironfoyjbylsbpzxdgys.getDuser().toString().trim() != null
					&& !"".equals(ironfoyjbylsbpzxdgys.getDuser().toString().trim())
					&& !"null".equals(ironfoyjbylsbpzxdgys.getDuser().toString().trim())) {
				userId = ironfoyjbylsbpzxdgys.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfoyjbylsbpzxdgys.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "消毒供应室"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfoyjbylsbpzxdgysReport> page = ironfoyjbylsbpzxdgysService.findPage(new Page<IronfoyjbylsbpzxdgysReport>(request, response, -1), ironfoyjbylsbpzxdgys);
    		new ExportExcel("消毒供应室", IronfoyjbylsbpzxdgysReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出消毒供应室记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"report/ironfoyjbylsbpzxdgysreport/ironfoyjbylsbpzxdgys/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfoyjbylsbpzxdgysreport:ironfoyjbylsbpzxdgys:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfoyjbylsbpzxdgysReport> list = ei.getDataList(IronfoyjbylsbpzxdgysReport.class);
			for (IronfoyjbylsbpzxdgysReport ironfoyjbylsbpzxdgys : list){
				try{
					ironfoyjbylsbpzxdgysService.save(ironfoyjbylsbpzxdgys);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条消毒供应室记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条消毒供应室记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入消毒供应室失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzxdgysreport/ironfoyjbylsbpzxdgys/?repage";
    }
	
	/**
	 * 下载导入消毒供应室数据模板
	 */
	@RequiresPermissions("ironfoyjbylsbpzxdgysreport:ironfoyjbylsbpzxdgys:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "消毒供应室数据导入模板.xlsx";
    		List<IronfoyjbylsbpzxdgysReport> list = Lists.newArrayList(); 
    		new ExportExcel("消毒供应室数据", IronfoyjbylsbpzxdgysReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzxdgysreport/ironfoyjbylsbpzxdgys/?repage";
    }
	
	
	

}