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
import com.jeeplus.modules.sysrole.entity.FeatureList;
import com.jeeplus.modules.sysrole.service.FeatureListService;

/**
 * 角色管理Controller
 * @author 瞿高青
 * @version 2017-11-02
 */
@Controller
@RequestMapping(value = "${adminPath}/sysrole/featureList")
public class FeatureListController extends BaseController {

	@Autowired
	private FeatureListService featureListService;
	
	@ModelAttribute
	public FeatureList get(@RequestParam(required=false) String id) {
		FeatureList entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = featureListService.get(id);
		}
		if (entity == null){
			entity = new FeatureList();
		}
		return entity;
	}
	
	/**
	 * 角色管理列表页面
	 */
	@RequiresPermissions("sysrole:featureList:list")
	@RequestMapping(value = {"list", ""})
	public String list(FeatureList featureList, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<FeatureList> page = featureListService.findPage(new Page<FeatureList>(request, response), featureList); 
		model.addAttribute("page", page);
		return "modules/sysrole/featureListList";
	}

	/**
	 * 查看，增加，编辑角色管理表单页面
	 */
	@RequiresPermissions(value={"sysrole:featureList:view","sysrole:featureList:add","sysrole:featureList:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(FeatureList featureList, Model model) {
		model.addAttribute("featureList", featureList);
		return "modules/sysrole/featureListForm";
	}

	/**
	 * 保存角色管理
	 */
	@RequiresPermissions(value={"sysrole:featureList:add","sysrole:featureList:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(FeatureList featureList, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, featureList)){
			return form(featureList, model);
		}
		if(!featureList.getIsNewRecord()){//编辑表单保存
			FeatureList t = featureListService.get(featureList.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(featureList, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			featureListService.save(t);//保存
		}else{//新增表单保存
			featureListService.save(featureList);//保存
		}
		addMessage(redirectAttributes, "保存角色管理成功");
		return "redirect:"+Global.getAdminPath()+"/sysrole/featureList/?repage";
	}
	
	/**
	 * 删除角色管理
	 */
	@RequiresPermissions("sysrole:featureList:del")
	@RequestMapping(value = "delete")
	public String delete(FeatureList featureList, RedirectAttributes redirectAttributes) {
		featureListService.delete(featureList);
		addMessage(redirectAttributes, "删除角色管理成功");
		return "redirect:"+Global.getAdminPath()+"/sysrole/featureList/?repage";
	}
	
	/**
	 * 批量删除角色管理
	 */
	@RequiresPermissions("sysrole:featureList:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			featureListService.delete(featureListService.get(id));
		}
		addMessage(redirectAttributes, "删除角色管理成功");
		return "redirect:"+Global.getAdminPath()+"/sysrole/featureList/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("sysrole:featureList:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(FeatureList featureList, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "角色管理"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<FeatureList> page = featureListService.findPage(new Page<FeatureList>(request, response, -1), featureList);
    		new ExportExcel("角色管理", FeatureList.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出角色管理记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/sysrole/featureList/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("sysrole:featureList:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<FeatureList> list = ei.getDataList(FeatureList.class);
			for (FeatureList featureList : list){
				try{
					featureListService.save(featureList);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条角色管理记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条角色管理记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入角色管理失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/sysrole/featureList/?repage";
    }
	
	/**
	 * 下载导入角色管理数据模板
	 */
	@RequiresPermissions("sysrole:featureList:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "角色管理数据导入模板.xlsx";
    		List<FeatureList> list = Lists.newArrayList(); 
    		new ExportExcel("角色管理数据", FeatureList.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/sysrole/featureList/?repage";
    }
	
	
	

}