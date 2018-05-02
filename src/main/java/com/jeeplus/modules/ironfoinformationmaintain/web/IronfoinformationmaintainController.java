/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoinformationmaintain.web;

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
import com.jeeplus.modules.ironfoinformationmaintain.entity.Ironfoinformationmaintain;
import com.jeeplus.modules.ironfoinformationmaintain.service.IronfoinformationmaintainService;

/**
 * 4.4系统维护人员Controller
 * @author mikesun
 * @version 2018-03-22
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfoinformationmaintain/ironfoinformationmaintain")
public class IronfoinformationmaintainController extends BaseController {

	@Autowired
	private IronfoinformationmaintainService ironfoinformationmaintainService;
	
	@ModelAttribute
	public Ironfoinformationmaintain get(@RequestParam(required=false) String id) {
		Ironfoinformationmaintain entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfoinformationmaintainService.get(id);
		}
		if (entity == null){
			entity = new Ironfoinformationmaintain();
		}
		return entity;
	}
	
	/**
	 * 4.4系统维护人员列表页面
	 */
	@RequiresPermissions("ironfoinformationmaintain:ironfoinformationmaintain:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfoinformationmaintain ironfoinformationmaintain, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Ironfoinformationmaintain> page = ironfoinformationmaintainService.findPage(new Page<Ironfoinformationmaintain>(request, response), ironfoinformationmaintain); 
		model.addAttribute("page", page);
		return "modules/ironfoinformationmaintain/ironfoinformationmaintainList";
	}

	/**
	 * 查看，增加，编辑4.4系统维护人员表单页面
	 */
	@RequiresPermissions(value={"ironfoinformationmaintain:ironfoinformationmaintain:view","ironfoinformationmaintain:ironfoinformationmaintain:add","ironfoinformationmaintain:ironfoinformationmaintain:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfoinformationmaintain ironfoinformationmaintain, Model model) {
		model.addAttribute("ironfoinformationmaintain", ironfoinformationmaintain);
		return "modules/ironfoinformationmaintain/ironfoinformationmaintainForm";
	}

	/**
	 * 保存4.4系统维护人员
	 */
	@RequiresPermissions(value={"ironfoinformationmaintain:ironfoinformationmaintain:add","ironfoinformationmaintain:ironfoinformationmaintain:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfoinformationmaintain ironfoinformationmaintain, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfoinformationmaintain)){
			return form(ironfoinformationmaintain, model);
		}
		if(!ironfoinformationmaintain.getIsNewRecord()){//编辑表单保存
			Ironfoinformationmaintain t = ironfoinformationmaintainService.get(ironfoinformationmaintain.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfoinformationmaintain, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfoinformationmaintainService.save(t);//保存
		}else{//新增表单保存
			ironfoinformationmaintainService.save(ironfoinformationmaintain);//保存
		}
		addMessage(redirectAttributes, "保存4.4系统维护人员成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoinformationmaintain/ironfoinformationmaintain/?repage";
	}
	
	/**
	 * 删除4.4系统维护人员
	 */
	@RequiresPermissions("ironfoinformationmaintain:ironfoinformationmaintain:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfoinformationmaintain ironfoinformationmaintain, RedirectAttributes redirectAttributes) {
		ironfoinformationmaintainService.delete(ironfoinformationmaintain);
		addMessage(redirectAttributes, "删除4.4系统维护人员成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoinformationmaintain/ironfoinformationmaintain/?repage";
	}
	
	/**
	 * 批量删除4.4系统维护人员
	 */
	@RequiresPermissions("ironfoinformationmaintain:ironfoinformationmaintain:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfoinformationmaintainService.delete(ironfoinformationmaintainService.get(id));
		}
		addMessage(redirectAttributes, "删除4.4系统维护人员成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoinformationmaintain/ironfoinformationmaintain/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfoinformationmaintain:ironfoinformationmaintain:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfoinformationmaintain ironfoinformationmaintain, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "4.4系统维护人员"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfoinformationmaintain> page = ironfoinformationmaintainService.findPage(new Page<Ironfoinformationmaintain>(request, response, -1), ironfoinformationmaintain);
    		new ExportExcel("4.4系统维护人员", Ironfoinformationmaintain.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出4.4系统维护人员记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoinformationmaintain/ironfoinformationmaintain/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfoinformationmaintain:ironfoinformationmaintain:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfoinformationmaintain> list = ei.getDataList(Ironfoinformationmaintain.class);
			for (Ironfoinformationmaintain ironfoinformationmaintain : list){
				try{
					ironfoinformationmaintainService.save(ironfoinformationmaintain);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条4.4系统维护人员记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条4.4系统维护人员记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入4.4系统维护人员失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoinformationmaintain/ironfoinformationmaintain/?repage";
    }
	
	/**
	 * 下载导入4.4系统维护人员数据模板
	 */
	@RequiresPermissions("ironfoinformationmaintain:ironfoinformationmaintain:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "4.4系统维护人员数据导入模板.xlsx";
    		List<Ironfoinformationmaintain> list = Lists.newArrayList(); 
    		new ExportExcel("4.4系统维护人员数据", Ironfoinformationmaintain.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoinformationmaintain/ironfoinformationmaintain/?repage";
    }
	
	
	

}