/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.organization.web;

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
import com.jeeplus.modules.organization.entity.Organization;
import com.jeeplus.modules.organization.service.OrganizationService;

/**
 * 组织管理Controller
 * @author 瞿高青
 * @version 2017-10-30
 */
@Controller
@RequestMapping(value = "${adminPath}/organization/organization")
public class OrganizationController extends BaseController {

	@Autowired
	private OrganizationService organizationService;
	
	@ModelAttribute
	public Organization get(@RequestParam(required=false) String id) {
		Organization entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = organizationService.get(id);
		}
		if (entity == null){
			entity = new Organization();
		}
		return entity;
	}
	
	/**
	 * 组织管理列表页面
	 */
	@RequiresPermissions("organization:organization:list")
	@RequestMapping(value = {"list", ""})
	public String list(Organization organization, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Organization> page = organizationService.findPage(new Page<Organization>(request, response), organization); 
		model.addAttribute("page", page);
		return "modules/organization/organizationList";
	}

	/**
	 * 查看，增加，编辑组织管理表单页面
	 */
	@RequiresPermissions(value={"organization:organization:view","organization:organization:add","organization:organization:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Organization organization, Model model) {
		model.addAttribute("organization", organization);
		return "modules/organization/organizationForm";
	}

	/**
	 * 保存组织管理
	 */
	@RequiresPermissions(value={"organization:organization:add","organization:organization:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Organization organization, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, organization)){
			return form(organization, model);
		}
		if(!organization.getIsNewRecord()){//编辑表单保存
			Organization t = organizationService.get(organization.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(organization, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			organizationService.save(t);//保存
		}else{//新增表单保存
			organizationService.save(organization);//保存
		}
		addMessage(redirectAttributes, "保存组织管理成功");
		return "redirect:"+Global.getAdminPath()+"/organization/organization/?repage";
	}
	
	/**
	 * 删除组织管理
	 */
	@RequiresPermissions("organization:organization:del")
	@RequestMapping(value = "delete")
	public String delete(Organization organization, RedirectAttributes redirectAttributes) {
		organizationService.delete(organization);
		addMessage(redirectAttributes, "删除组织管理成功");
		return "redirect:"+Global.getAdminPath()+"/organization/organization/?repage";
	}
	
	/**
	 * 批量删除组织管理
	 */
	@RequiresPermissions("organization:organization:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			organizationService.delete(organizationService.get(id));
		}
		addMessage(redirectAttributes, "删除组织管理成功");
		return "redirect:"+Global.getAdminPath()+"/organization/organization/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("organization:organization:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Organization organization, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "组织管理"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Organization> page = organizationService.findPage(new Page<Organization>(request, response, -1), organization);
    		new ExportExcel("组织管理", Organization.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出组织管理记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/organization/organization/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("organization:organization:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Organization> list = ei.getDataList(Organization.class);
			for (Organization organization : list){
				try{
					organizationService.save(organization);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条组织管理记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条组织管理记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入组织管理失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/organization/organization/?repage";
    }
	
	/**
	 * 下载导入组织管理数据模板
	 */
	@RequiresPermissions("organization:organization:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "组织管理数据导入模板.xlsx";
    		List<Organization> list = Lists.newArrayList(); 
    		new ExportExcel("组织管理数据", Organization.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/organization/organization/?repage";
    }
	
	
	

}