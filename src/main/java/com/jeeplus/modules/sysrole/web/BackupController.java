/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.sysrole.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
import com.jeeplus.modules.sysrole.entity.Backup;
import com.jeeplus.modules.sysrole.service.BackupService;

/**
 * 数据库管理Controller
 * @author 瞿高青
 * @version 2017-10-18
 */
@Controller
@RequestMapping(value = "${adminPath}/sysrole/backup")
public class BackupController extends BaseController {

	@Autowired
	private BackupService backupService;
	
	@ModelAttribute
	public Backup get(@RequestParam(required=false) String id) {
		Backup entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = backupService.get(id);
		}
		if (entity == null){
			entity = new Backup();
		}
		return entity;
	}
	
	/**
	 * 数据库备份列表页面
	 */
	@RequiresPermissions("sysrole:backup:list")
	@RequestMapping(value = {"list", ""})
	public String list(Backup backup, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Backup> page = backupService.findPage(new Page<Backup>(request, response), backup); 
		model.addAttribute("page", page);
		return "modules/sysrole/backupList";
	}

	/**
	 * 查看，增加，编辑数据库备份表单页面
	 */
	@RequiresPermissions(value={"sysrole:backup:view","sysrole:backup:add","sysrole:backup:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Backup backup, Model model) {
		model.addAttribute("backup", backup);
		return "modules/sysrole/backupForm";
	}

	/**
	 * 保存数据库备份
	 */
	@RequiresPermissions(value={"sysrole:backup:add","sysrole:backup:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Backup backup, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, backup)){
			return form(backup, model);
		}
		if(!backup.getIsNewRecord()){//编辑表单保存
			Backup t = backupService.get(backup.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(backup, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			backupService.save(t);//保存
		}else{//新增表单保存
			backupService.save(backup);//保存
		}
		addMessage(redirectAttributes, "保存数据库备份成功");
		return "redirect:"+Global.getAdminPath()+"/sysrole/backup/?repage";
	}
	
	/**
	 * 删除数据库备份
	 */
	@RequiresPermissions("sysrole:backup:del")
	@RequestMapping(value = "delete")
	public String delete(Backup backup, RedirectAttributes redirectAttributes) {
		backupService.delete(backup);
		addMessage(redirectAttributes, "删除数据库备份成功");
		return "redirect:"+Global.getAdminPath()+"/sysrole/backup/?repage";
	}
	
	/**
	 * 批量删除数据库备份
	 */
	@RequiresPermissions("sysrole:backup:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			backupService.delete(backupService.get(id));
		}
		addMessage(redirectAttributes, "删除数据库备份成功");
		return "redirect:"+Global.getAdminPath()+"/sysrole/backup/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("sysrole:backup:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Backup backup, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "数据库备份"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Backup> page = backupService.findPage(new Page<Backup>(request, response, -1), backup);
    		new ExportExcel("数据库备份", Backup.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出数据库备份记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/sysrole/backup/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("sysrole:backup:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Backup> list = ei.getDataList(Backup.class);
			for (Backup backup : list){
				try{
					backupService.save(backup);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条数据库备份记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条数据库备份记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入数据库备份失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/sysrole/backup/?repage";
    }
	
	/**
	 * 下载导入数据库备份数据模板
	 */
	@RequiresPermissions("sysrole:backup:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "数据库备份数据导入模板.xlsx";
    		List<Backup> list = Lists.newArrayList(); 
    		new ExportExcel("数据库备份数据", Backup.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/sysrole/backup/?repage";
    }
	
	
	

}