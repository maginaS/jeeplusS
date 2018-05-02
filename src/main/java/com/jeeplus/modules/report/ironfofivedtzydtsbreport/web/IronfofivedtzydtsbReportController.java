/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfofivedtzydtsbreport.web;

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
import com.jeeplus.modules.report.ironfofivedtzydtsbreport.entity.IronfofivedtzydtsbReport;
import com.jeeplus.modules.report.ironfofivedtzydtsbreport.service.IronfofivedtzydtsbReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 电梯设备Controller
 * @author anti_magina
 * @version 2018-04-23
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfofivedtzydtsbreport/ironfofivedtzydtsb")
public class IronfofivedtzydtsbReportController extends BaseController {

	@Autowired
	private IronfofivedtzydtsbReportService ironfofivedtzydtsbService;

	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	@ModelAttribute
	public IronfofivedtzydtsbReport get(@RequestParam(required=false) String id) {
		IronfofivedtzydtsbReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfofivedtzydtsbService.get(id);
		}
		if (entity == null){
			entity = new IronfofivedtzydtsbReport();
		}
		return entity;
	}
	
	/**
	 * 电梯设备列表页面
	 */
	@RequiresPermissions("ironfofivedtzydtsbreport:ironfofivedtzydtsb:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfofivedtzydtsbReport ironfofivedtzydtsb, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfofivedtzydtsb.getDuser() != null&&ironfofivedtzydtsb.getDuser().toString() != null && ironfofivedtzydtsb.getDuser().toString().trim() != null
					&& !"".equals(ironfofivedtzydtsb.getDuser().toString().trim())
					&& !"null".equals(ironfofivedtzydtsb.getDuser().toString().trim())) {
				userId = ironfofivedtzydtsb.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfofivedtzydtsb.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Page<IronfofivedtzydtsbReport> page = ironfofivedtzydtsbService.findPage(new Page<IronfofivedtzydtsbReport>(request, response), ironfofivedtzydtsb); 
		model.addAttribute("page", page);
		return "modules/report/ironfofivedtzydtsbreport/ironfofivedtzydtsbList";
	}

	/**
	 * 查看，增加，编辑电梯设备表单页面
	 */
	@RequiresPermissions(value={"ironfofivedtzydtsbreport:ironfofivedtzydtsb:view","ironfofivedtzydtsbreport:ironfofivedtzydtsb:add","ironfofivedtzydtsbreport:ironfofivedtzydtsb:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfofivedtzydtsbReport ironfofivedtzydtsb, Model model) {
		model.addAttribute("ironfofivedtzydtsb", ironfofivedtzydtsb);
		return "report/ironfofivedtzydtsbreport/ironfofivedtzydtsbForm";
	}

	/**
	 * 保存电梯设备
	 */
	@RequiresPermissions(value={"ironfofivedtzydtsbreport:ironfofivedtzydtsb:add","ironfofivedtzydtsbreport:ironfofivedtzydtsb:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfofivedtzydtsbReport ironfofivedtzydtsb, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfofivedtzydtsb)){
			return form(ironfofivedtzydtsb, model);
		}
		if(!ironfofivedtzydtsb.getIsNewRecord()){//编辑表单保存
			IronfofivedtzydtsbReport t = ironfofivedtzydtsbService.get(ironfofivedtzydtsb.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfofivedtzydtsb, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfofivedtzydtsbService.save(t);//保存
		}else{//新增表单保存
			ironfofivedtzydtsbService.save(ironfofivedtzydtsb);//保存
		}
		addMessage(redirectAttributes, "保存电梯设备成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivedtzydtsbreport/ironfofivedtzydtsb/?repage";
	}
	
	/**
	 * 删除电梯设备
	 */
	@RequiresPermissions("ironfofivedtzydtsbreport:ironfofivedtzydtsb:del")
	@RequestMapping(value = "delete")
	public String delete(IronfofivedtzydtsbReport ironfofivedtzydtsb, RedirectAttributes redirectAttributes) {
		ironfofivedtzydtsbService.delete(ironfofivedtzydtsb);
		addMessage(redirectAttributes, "删除电梯设备成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivedtzydtsbreport/ironfofivedtzydtsb/?repage";
	}
	
	/**
	 * 批量删除电梯设备
	 */
	@RequiresPermissions("ironfofivedtzydtsbreport:ironfofivedtzydtsb:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfofivedtzydtsbService.delete(ironfofivedtzydtsbService.get(id));
		}
		addMessage(redirectAttributes, "删除电梯设备成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivedtzydtsbreport/ironfofivedtzydtsb/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfofivedtzydtsbreport:ironfofivedtzydtsb:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfofivedtzydtsbReport ironfofivedtzydtsb, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfofivedtzydtsb.getDuser() != null&&ironfofivedtzydtsb.getDuser().toString() != null && ironfofivedtzydtsb.getDuser().toString().trim() != null
					&& !"".equals(ironfofivedtzydtsb.getDuser().toString().trim())
					&& !"null".equals(ironfofivedtzydtsb.getDuser().toString().trim())) {
				userId = ironfofivedtzydtsb.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfofivedtzydtsb.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "电梯设备"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfofivedtzydtsbReport> page = ironfofivedtzydtsbService.findPage(new Page<IronfofivedtzydtsbReport>(request, response, -1), ironfofivedtzydtsb);
    		new ExportExcel("电梯设备", IronfofivedtzydtsbReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出电梯设备记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/report/ironfofivedtzydtsbreport/ironfofivedtzydtsb/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfofivedtzydtsbreport:ironfofivedtzydtsb:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfofivedtzydtsbReport> list = ei.getDataList(IronfofivedtzydtsbReport.class);
			for (IronfofivedtzydtsbReport ironfofivedtzydtsb : list){
				try{
					ironfofivedtzydtsbService.save(ironfofivedtzydtsb);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条电梯设备记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条电梯设备记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入电梯设备失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivedtzydtsbreport/ironfofivedtzydtsb/?repage";
    }
	
	/**
	 * 下载导入电梯设备数据模板
	 */
	@RequiresPermissions("ironfofivedtzydtsbreport:ironfofivedtzydtsb:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "电梯设备数据导入模板.xlsx";
    		List<IronfofivedtzydtsbReport> list = Lists.newArrayList(); 
    		new ExportExcel("电梯设备数据", IronfofivedtzydtsbReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivedtzydtsbreport/ironfofivedtzydtsb/?repage";
    }
	
	
	

}