/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfodoctitle.web;

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
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.ironfodoctitle.service.IronfoDocTitleService;

/**
 * 1.1乡镇卫生院基本概况Controller
 * @author mikesun
 * @version 2018-03-15
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfodoctitle/ironfoDocTitle")
public class IronfoDocTitleController extends BaseController {

	@Autowired
	private IronfoDocTitleService ironfoDocTitleService;
	
	@ModelAttribute
	public IronfoDocTitle get(@RequestParam(required=false) String id) {
		IronfoDocTitle entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfoDocTitleService.get(id);
		}
		if (entity == null){
			entity = new IronfoDocTitle();
		}
		return entity;
	}
	
	/**
	 * 1.1乡镇卫生院基本概况列表页面
	 */
	@RequiresPermissions("ironfodoctitle:ironfoDocTitle:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfoDocTitle ironfoDocTitle, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<IronfoDocTitle> page = ironfoDocTitleService.findPage(new Page<IronfoDocTitle>(request, response), ironfoDocTitle); 
		model.addAttribute("page", page);
		return "modules/ironfodoctitle/ironfoDocTitleList";
	}

	/**
	 * 查看，增加，编辑1.1乡镇卫生院基本概况表单页面
	 */
	@RequiresPermissions(value={"ironfodoctitle:ironfoDocTitle:view","ironfodoctitle:ironfoDocTitle:add","ironfodoctitle:ironfoDocTitle:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfoDocTitle ironfoDocTitle, Model model) {
		model.addAttribute("ironfoDocTitle", ironfoDocTitle);
		return "modules/ironfodoctitle/ironfoDocTitleForm";
	}

	/**
	 * 保存1.1乡镇卫生院基本概况
	 */
	@RequiresPermissions(value={"ironfodoctitle:ironfoDocTitle:add","ironfodoctitle:ironfoDocTitle:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfoDocTitle ironfoDocTitle, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfoDocTitle)){
			return form(ironfoDocTitle, model);
		}
		if(!ironfoDocTitle.getIsNewRecord()){//编辑表单保存
			IronfoDocTitle t = ironfoDocTitleService.get(ironfoDocTitle.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfoDocTitle, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfoDocTitleService.save(t);//保存
		}else{//新增表单保存
			ironfoDocTitleService.save(ironfoDocTitle);//保存
		}
		addMessage(redirectAttributes, "保存1.1乡镇卫生院基本概况成功");
		return "redirect:"+Global.getAdminPath()+"/ironfodoctitle/ironfoDocTitle/?repage";
	}
	
	/**
	 * 删除1.1乡镇卫生院基本概况
	 */
	@RequiresPermissions("ironfodoctitle:ironfoDocTitle:del")
	@RequestMapping(value = "delete")
	public String delete(IronfoDocTitle ironfoDocTitle, RedirectAttributes redirectAttributes) {
		ironfoDocTitleService.delete(ironfoDocTitle);
		addMessage(redirectAttributes, "删除1.1乡镇卫生院基本概况成功");
		return "redirect:"+Global.getAdminPath()+"/ironfodoctitle/ironfoDocTitle/?repage";
	}
	
	/**
	 * 批量删除1.1乡镇卫生院基本概况
	 */
	@RequiresPermissions("ironfodoctitle:ironfoDocTitle:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfoDocTitleService.delete(ironfoDocTitleService.get(id));
		}
		addMessage(redirectAttributes, "删除1.1乡镇卫生院基本概况成功");
		return "redirect:"+Global.getAdminPath()+"/ironfodoctitle/ironfoDocTitle/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfodoctitle:ironfoDocTitle:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfoDocTitle ironfoDocTitle, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "1.1乡镇卫生院基本概况"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfoDocTitle> page = ironfoDocTitleService.findPage(new Page<IronfoDocTitle>(request, response, -1), ironfoDocTitle);
    		new ExportExcel("1.1乡镇卫生院基本概况", IronfoDocTitle.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出1.1乡镇卫生院基本概况记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfodoctitle/ironfoDocTitle/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfodoctitle:ironfoDocTitle:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfoDocTitle> list = ei.getDataList(IronfoDocTitle.class);
			for (IronfoDocTitle ironfoDocTitle : list){
				try{
					ironfoDocTitleService.save(ironfoDocTitle);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条1.1乡镇卫生院基本概况记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条1.1乡镇卫生院基本概况记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入1.1乡镇卫生院基本概况失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfodoctitle/ironfoDocTitle/?repage";
    }
	
	/**
	 * 下载导入1.1乡镇卫生院基本概况数据模板
	 */
	@RequiresPermissions("ironfodoctitle:ironfoDocTitle:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "1.1乡镇卫生院基本概况数据导入模板.xlsx";
    		List<IronfoDocTitle> list = Lists.newArrayList(); 
    		new ExportExcel("1.1乡镇卫生院基本概况数据", IronfoDocTitle.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfodoctitle/ironfoDocTitle/?repage";
    }
	
	
	

}