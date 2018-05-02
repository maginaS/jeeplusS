/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfojbxx.web;

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
import com.jeeplus.modules.ironfojbxx.entity.Ironfojbxx;
import com.jeeplus.modules.ironfojbxx.service.IronfojbxxService;

/**
 * 基本信息Controller
 * @author mikesun
 * @version 2018-04-17
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfojbxx/ironfojbxx")
public class IronfojbxxController extends BaseController {

	@Autowired
	private IronfojbxxService ironfojbxxService;
	
	@ModelAttribute
	public Ironfojbxx get(@RequestParam(required=false) String id) {
		Ironfojbxx entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfojbxxService.get(id);
		}
		if (entity == null){
			entity = new Ironfojbxx();
		}
		return entity;
	}
	
	/**
	 * 基本信息列表页面
	 */
	@RequiresPermissions("ironfojbxx:ironfojbxx:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfojbxx ironfojbxx, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Ironfojbxx> page = ironfojbxxService.findPage(new Page<Ironfojbxx>(request, response), ironfojbxx); 
		model.addAttribute("page", page);
		return "modules/ironfojbxx/ironfojbxxList";
	}

	/**
	 * 查看，增加，编辑基本信息表单页面
	 */
	@RequiresPermissions(value={"ironfojbxx:ironfojbxx:view","ironfojbxx:ironfojbxx:add","ironfojbxx:ironfojbxx:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfojbxx ironfojbxx, Model model) {
		model.addAttribute("ironfojbxx", ironfojbxx);
		return "modules/ironfojbxx/ironfojbxxForm";
	}

	/**
	 * 保存基本信息
	 */
	@RequiresPermissions(value={"ironfojbxx:ironfojbxx:add","ironfojbxx:ironfojbxx:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfojbxx ironfojbxx, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfojbxx)){
			return form(ironfojbxx, model);
		}
		if(!ironfojbxx.getIsNewRecord()){//编辑表单保存
			Ironfojbxx t = ironfojbxxService.get(ironfojbxx.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfojbxx, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfojbxxService.save(t);//保存
		}else{//新增表单保存
			ironfojbxxService.save(ironfojbxx);//保存
		}
		addMessage(redirectAttributes, "保存基本信息成功");
		return "redirect:"+Global.getAdminPath()+"/ironfojbxx/ironfojbxx/?repage";
	}
	
	/**
	 * 删除基本信息
	 */
	@RequiresPermissions("ironfojbxx:ironfojbxx:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfojbxx ironfojbxx, RedirectAttributes redirectAttributes) {
		ironfojbxxService.delete(ironfojbxx);
		addMessage(redirectAttributes, "删除基本信息成功");
		return "redirect:"+Global.getAdminPath()+"/ironfojbxx/ironfojbxx/?repage";
	}
	
	/**
	 * 批量删除基本信息
	 */
	@RequiresPermissions("ironfojbxx:ironfojbxx:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfojbxxService.delete(ironfojbxxService.get(id));
		}
		addMessage(redirectAttributes, "删除基本信息成功");
		return "redirect:"+Global.getAdminPath()+"/ironfojbxx/ironfojbxx/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfojbxx:ironfojbxx:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfojbxx ironfojbxx, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "基本信息"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfojbxx> page = ironfojbxxService.findPage(new Page<Ironfojbxx>(request, response, -1), ironfojbxx);
    		new ExportExcel("基本信息", Ironfojbxx.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出基本信息记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfojbxx/ironfojbxx/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfojbxx:ironfojbxx:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfojbxx> list = ei.getDataList(Ironfojbxx.class);
			for (Ironfojbxx ironfojbxx : list){
				try{
					ironfojbxxService.save(ironfojbxx);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条基本信息记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条基本信息记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入基本信息失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfojbxx/ironfojbxx/?repage";
    }
	
	/**
	 * 下载导入基本信息数据模板
	 */
	@RequiresPermissions("ironfojbxx:ironfojbxx:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "基本信息数据导入模板.xlsx";
    		List<Ironfojbxx> list = Lists.newArrayList(); 
    		new ExportExcel("基本信息数据", Ironfojbxx.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfojbxx/ironfojbxx/?repage";
    }
	
	
	

}