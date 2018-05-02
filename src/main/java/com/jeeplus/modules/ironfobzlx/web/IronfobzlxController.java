/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfobzlx.web;

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
import com.jeeplus.modules.ironfobzlx.entity.Ironfobzlx;
import com.jeeplus.modules.ironfobzlx.service.IronfobzlxService;

/**
 * ironfobzlxController
 * @author mikesun
 * @version 2018-03-19
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfobzlx/ironfobzlx")
public class IronfobzlxController extends BaseController {

	@Autowired
	private IronfobzlxService ironfobzlxService;
	
	@ModelAttribute
	public Ironfobzlx get(@RequestParam(required=false) String id) {
		Ironfobzlx entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfobzlxService.get(id);
		}
		if (entity == null){
			entity = new Ironfobzlx();
		}
		return entity;
	}
	
	/**
	 * ironfobzlx列表页面
	 */
	@RequiresPermissions("ironfobzlx:ironfobzlx:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfobzlx ironfobzlx, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Ironfobzlx> page = ironfobzlxService.findPage(new Page<Ironfobzlx>(request, response), ironfobzlx); 
		model.addAttribute("page", page);
		return "modules/ironfobzlx/ironfobzlxList";
	}

	/**
	 * 查看，增加，编辑ironfobzlx表单页面
	 */
	@RequiresPermissions(value={"ironfobzlx:ironfobzlx:view","ironfobzlx:ironfobzlx:add","ironfobzlx:ironfobzlx:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfobzlx ironfobzlx, Model model) {
		model.addAttribute("ironfobzlx", ironfobzlx);
		return "modules/ironfobzlx/ironfobzlxForm";
	}

	/**
	 * 保存ironfobzlx
	 */
	@RequiresPermissions(value={"ironfobzlx:ironfobzlx:add","ironfobzlx:ironfobzlx:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfobzlx ironfobzlx, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfobzlx)){
			return form(ironfobzlx, model);
		}
		if(!ironfobzlx.getIsNewRecord()){//编辑表单保存
			Ironfobzlx t = ironfobzlxService.get(ironfobzlx.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfobzlx, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfobzlxService.save(t);//保存
		}else{//新增表单保存
			ironfobzlxService.save(ironfobzlx);//保存
		}
		addMessage(redirectAttributes, "保存ironfobzlx成功");
		return "redirect:"+Global.getAdminPath()+"/ironfobzlx/ironfobzlx/?repage";
	}
	
	/**
	 * 删除ironfobzlx
	 */
	@RequiresPermissions("ironfobzlx:ironfobzlx:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfobzlx ironfobzlx, RedirectAttributes redirectAttributes) {
		ironfobzlxService.delete(ironfobzlx);
		addMessage(redirectAttributes, "删除ironfobzlx成功");
		return "redirect:"+Global.getAdminPath()+"/ironfobzlx/ironfobzlx/?repage";
	}
	
	/**
	 * 批量删除ironfobzlx
	 */
	@RequiresPermissions("ironfobzlx:ironfobzlx:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfobzlxService.delete(ironfobzlxService.get(id));
		}
		addMessage(redirectAttributes, "删除ironfobzlx成功");
		return "redirect:"+Global.getAdminPath()+"/ironfobzlx/ironfobzlx/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfobzlx:ironfobzlx:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfobzlx ironfobzlx, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "ironfobzlx"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfobzlx> page = ironfobzlxService.findPage(new Page<Ironfobzlx>(request, response, -1), ironfobzlx);
    		new ExportExcel("ironfobzlx", Ironfobzlx.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出ironfobzlx记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfobzlx/ironfobzlx/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfobzlx:ironfobzlx:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfobzlx> list = ei.getDataList(Ironfobzlx.class);
			for (Ironfobzlx ironfobzlx : list){
				try{
					ironfobzlxService.save(ironfobzlx);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条ironfobzlx记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条ironfobzlx记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入ironfobzlx失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfobzlx/ironfobzlx/?repage";
    }
	
	/**
	 * 下载导入ironfobzlx数据模板
	 */
	@RequiresPermissions("ironfobzlx:ironfobzlx:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "ironfobzlx数据导入模板.xlsx";
    		List<Ironfobzlx> list = Lists.newArrayList(); 
    		new ExportExcel("ironfobzlx数据", Ironfobzlx.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfobzlx/ironfobzlx/?repage";
    }
	
	
	

}