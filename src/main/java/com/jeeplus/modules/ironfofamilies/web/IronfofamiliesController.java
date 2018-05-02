/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofamilies.web;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.jeeplus.common.utils.DateUtils;
import com.jeeplus.common.utils.MyBeanUtils;
import com.jeeplus.common.config.Global;
import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.web.BaseController;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.common.utils.excel.ExportExcel;
import com.jeeplus.common.utils.excel.ImportExcel;
import com.jeeplus.modules.ironfobzlx.entity.Ironfobzlx;
import com.jeeplus.modules.ironfofamilies.entity.Ironfofamilies;
import com.jeeplus.modules.ironfofamilies.service.IronfofamiliesService;
import com.jeeplus.modules.tools.utils.JBZL;

import net.sf.json.JSONObject;

/**
 * 2.5病种Controller
 * @author mikesun
 * @version 2018-03-19
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfofamilies/ironfofamilies")
public class IronfofamiliesController extends BaseController {
	
	

	@Autowired
	private IronfofamiliesService ironfofamiliesService;
	
	@ModelAttribute
	public Ironfofamilies get(@RequestParam(required=false) String id) {
		Ironfofamilies entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfofamiliesService.get(id);
		}
		if (entity == null){
			entity = new Ironfofamilies();
		}
		return entity;
	}
	
//	@RequiresPermissions("ironfofamilies:ironfofamilies:query")
	@RequestMapping(value ="query")
	@ResponseBody
	public Map<String,Object> query(Ironfobzlx bzlx, HttpServletRequest request, HttpServletResponse response, Model model,String type,String bztype){
		
//		if(bztype.contains(",")) {
//			bztype.split(",");
//		}
		
//		bzlx.setBztype(String.valueOf(JBZL.getjbzlEnumbyindex(Integer.parseInt(bztype))));
		
		Map<String,Object> data = new HashMap<String,Object>();
		
//		String ccc = "";
		
		
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		
		Map<String,Object> datas = ironfofamiliesService.query(bzlx,bzlx.getType(),bztype);
		
		if(datas.size()>0) {
			
			data.put("success", "查询成功");
			data.put("code", "10001");
			data.put("data",datas);
			
			
		}else {
			
			data.put("success", "暂无数据");
			data.put("code",  "10002");
			data.put("data", "");
			
		}
		
		return data;
	}
	
	/**
	 * 2.5病种列表页面
	 */
	@RequiresPermissions("ironfofamilies:ironfofamilies:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfofamilies ironfofamilies, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Ironfofamilies> page = ironfofamiliesService.findPage(new Page<Ironfofamilies>(request, response), ironfofamilies); 
		model.addAttribute("page", page);
		return "modules/ironfofamilies/ironfofamiliesList";
	}

	/**
	 * 查看，增加，编辑2.5病种表单页面
	 */
	@RequiresPermissions(value={"ironfofamilies:ironfofamilies:view","ironfofamilies:ironfofamilies:add","ironfofamilies:ironfofamilies:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfofamilies ironfofamilies, Model model) {
		model.addAttribute("ironfofamilies", ironfofamilies);
		return "modules/ironfofamilies/ironfofamiliesForm";
	}

	/**
	 * 保存2.5病种
	 */
	@RequiresPermissions(value={"ironfofamilies:ironfofamilies:add","ironfofamilies:ironfofamilies:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfofamilies ironfofamilies, Model model, RedirectAttributes redirectAttributes) throws Exception{
	
		
		
		
		
		return "redirect:"+Global.getAdminPath()+"/ironfofamilies/ironfofamilies/?repage";
	}
	
	/**
	 * 删除2.5病种
	 */
	@RequiresPermissions("ironfofamilies:ironfofamilies:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfofamilies ironfofamilies, RedirectAttributes redirectAttributes) {
		ironfofamiliesService.delete(ironfofamilies);
		addMessage(redirectAttributes, "删除2.5病种成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofamilies/ironfofamilies/?repage";
	}
	
	/**
	 * 批量删除2.5病种
	 */
	@RequiresPermissions("ironfofamilies:ironfofamilies:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfofamiliesService.delete(ironfofamiliesService.get(id));
		}
		addMessage(redirectAttributes, "删除2.5病种成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofamilies/ironfofamilies/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfofamilies:ironfofamilies:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfofamilies ironfofamilies, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "2.5病种"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfofamilies> page = ironfofamiliesService.findPage(new Page<Ironfofamilies>(request, response, -1), ironfofamilies);
    		new ExportExcel("2.5病种", Ironfofamilies.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出2.5病种记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofamilies/ironfofamilies/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfofamilies:ironfofamilies:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfofamilies> list = ei.getDataList(Ironfofamilies.class);
			for (Ironfofamilies ironfofamilies : list){
				try{
					ironfofamiliesService.save(ironfofamilies);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条2.5病种记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条2.5病种记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入2.5病种失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofamilies/ironfofamilies/?repage";
    }
	
	/**
	 * 下载导入2.5病种数据模板
	 */
	@RequiresPermissions("ironfofamilies:ironfofamilies:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "2.5病种数据导入模板.xlsx";
    		List<Ironfofamilies> list = Lists.newArrayList(); 
    		new ExportExcel("2.5病种数据", Ironfofamilies.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofamilies/ironfofamilies/?repage";
    }
	
	
	

}