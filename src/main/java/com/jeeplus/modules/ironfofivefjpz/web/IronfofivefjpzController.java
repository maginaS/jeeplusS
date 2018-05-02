/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofivefjpz.web;

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
import com.jeeplus.modules.ironfofivefjpz.entity.Ironfofivefjpz;
import com.jeeplus.modules.ironfofivefjpz.service.IronfofivefjpzService;

/**
 * 5.2房间配置Controller
 * @author mikesun
 * @version 2018-03-23
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfofivefjpz/ironfofivefjpz")
public class IronfofivefjpzController extends BaseController {

	@Autowired
	private IronfofivefjpzService ironfofivefjpzService;
	
	@ModelAttribute
	public Ironfofivefjpz get(@RequestParam(required=false) String id) {
		Ironfofivefjpz entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfofivefjpzService.get(id);
		}
		if (entity == null){
			entity = new Ironfofivefjpz();
		}
		return entity;
	}
	
	/**
	 * 5.2房间配置列表页面
	 */
	@RequiresPermissions("ironfofivefjpz:ironfofivefjpz:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfofivefjpz ironfofivefjpz, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Ironfofivefjpz> page = ironfofivefjpzService.findPage(new Page<Ironfofivefjpz>(request, response), ironfofivefjpz); 
		model.addAttribute("page", page);
		return "modules/ironfofivefjpz/ironfofivefjpzList";
	}

	/**
	 * 查看，增加，编辑5.2房间配置表单页面
	 */
	@RequiresPermissions(value={"ironfofivefjpz:ironfofivefjpz:view","ironfofivefjpz:ironfofivefjpz:add","ironfofivefjpz:ironfofivefjpz:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfofivefjpz ironfofivefjpz, Model model) {
		model.addAttribute("ironfofivefjpz", ironfofivefjpz);
		return "modules/ironfofivefjpz/ironfofivefjpzForm";
	}

	/**
	 * 保存5.2房间配置
	 */
	@RequiresPermissions(value={"ironfofivefjpz:ironfofivefjpz:add","ironfofivefjpz:ironfofivefjpz:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfofivefjpz ironfofivefjpz, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfofivefjpz)){
			return form(ironfofivefjpz, model);
		}
		if(!ironfofivefjpz.getIsNewRecord()){//编辑表单保存
			Ironfofivefjpz t = ironfofivefjpzService.get(ironfofivefjpz.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfofivefjpz, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfofivefjpzService.save(t);//保存
		}else{//新增表单保存
			ironfofivefjpzService.save(ironfofivefjpz);//保存
		}
		addMessage(redirectAttributes, "保存5.2房间配置成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivefjpz/ironfofivefjpz/?repage";
	}
	
	/**
	 * 删除5.2房间配置
	 */
	@RequiresPermissions("ironfofivefjpz:ironfofivefjpz:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfofivefjpz ironfofivefjpz, RedirectAttributes redirectAttributes) {
		ironfofivefjpzService.delete(ironfofivefjpz);
		addMessage(redirectAttributes, "删除5.2房间配置成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivefjpz/ironfofivefjpz/?repage";
	}
	
	/**
	 * 批量删除5.2房间配置
	 */
	@RequiresPermissions("ironfofivefjpz:ironfofivefjpz:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfofivefjpzService.delete(ironfofivefjpzService.get(id));
		}
		addMessage(redirectAttributes, "删除5.2房间配置成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivefjpz/ironfofivefjpz/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfofivefjpz:ironfofivefjpz:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfofivefjpz ironfofivefjpz, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "5.2房间配置"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfofivefjpz> page = ironfofivefjpzService.findPage(new Page<Ironfofivefjpz>(request, response, -1), ironfofivefjpz);
    		new ExportExcel("5.2房间配置", Ironfofivefjpz.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出5.2房间配置记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivefjpz/ironfofivefjpz/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfofivefjpz:ironfofivefjpz:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfofivefjpz> list = ei.getDataList(Ironfofivefjpz.class);
			for (Ironfofivefjpz ironfofivefjpz : list){
				try{
					ironfofivefjpzService.save(ironfofivefjpz);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条5.2房间配置记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条5.2房间配置记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入5.2房间配置失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivefjpz/ironfofivefjpz/?repage";
    }
	
	/**
	 * 下载导入5.2房间配置数据模板
	 */
	@RequiresPermissions("ironfofivefjpz:ironfofivefjpz:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "5.2房间配置数据导入模板.xlsx";
    		List<Ironfofivefjpz> list = Lists.newArrayList(); 
    		new ExportExcel("5.2房间配置数据", Ironfofivefjpz.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivefjpz/ironfofivefjpz/?repage";
    }
	
	
	

}