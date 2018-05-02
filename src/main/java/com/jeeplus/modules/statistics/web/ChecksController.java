/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.statistics.web;

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
import com.jeeplus.modules.statistics.entity.Checks;
import com.jeeplus.modules.statistics.service.ChecksService;

/**
 * 销售统计Controller
 * @author 瞿高青
 * @version 2017-10-17
 */
@Controller
@RequestMapping(value = "${adminPath}/statistics/checks")
public class ChecksController extends BaseController {

	@Autowired
	private ChecksService checksService;
	
	@ModelAttribute
	public Checks get(@RequestParam(required=false) String id) {
		Checks entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = checksService.get(id);
		}
		if (entity == null){
			entity = new Checks();
		}
		return entity;
	}
	
	/**
	 * 销售量列表页面
	 */
	@RequiresPermissions("statistics:checks:list")
	@RequestMapping(value = {"list", ""})
	public String list(Checks checks, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Checks> page = checksService.findPage(new Page<Checks>(request, response), checks); 
		model.addAttribute("page", page);
		
		//折线图列表数据
		//X轴的数据
		List<String> xAxisData= new ArrayList<String>();
		//Y轴的数据
		Map<String,List<Double>> yAxisData = new HashMap<String,List<Double>>();
		
		Map<String,List<Double>> yAxisData2 = new HashMap<String,List<Double>>();
		
		List<Checks> volumeDataList = checksService.findList(checks);
		
		List<Double> volume = new ArrayList<Double>();
		List<Double> money = new ArrayList<Double>();
		
		for(Checks checksTemp:volumeDataList){
			//x轴数据
			xAxisData.add(checksTemp.getOrder_date().toLocaleString());
			//销售量
			volume.add(checksTemp.getCoupon_amount());
			//销售额
			money.add(checksTemp.getCom_amount());
			
		}
		
		//销售量y轴数据
		yAxisData.put("销售量", volume);
		
		//销售额y轴数据
		yAxisData2.put("销售额", money);
		
		request.setAttribute("xAxisData", xAxisData);
		request.setAttribute("yAxisData", yAxisData);
		request.setAttribute("yAxisData2", yAxisData2);
		
		return "modules/statistics/checksList";
	}

	/**
	 * 查看，增加，编辑销售量表单页面
	 */
	@RequiresPermissions(value={"statistics:checks:view","statistics:checks:add","statistics:checks:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Checks checks, Model model) {
		model.addAttribute("checks", checks);
		return "modules/statistics/checksForm";
	}

	/**
	 * 保存销售量
	 */
	@RequiresPermissions(value={"statistics:checks:add","statistics:checks:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Checks checks, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, checks)){
			return form(checks, model);
		}
		if(!checks.getIsNewRecord()){//编辑表单保存
			Checks t = checksService.get(checks.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(checks, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			checksService.save(t);//保存
		}else{//新增表单保存
			checksService.save(checks);//保存
		}
		addMessage(redirectAttributes, "保存销售量成功");
		return "redirect:"+Global.getAdminPath()+"/statistics/checks/?repage";
	}
	
	/**
	 * 删除销售量
	 */
	@RequiresPermissions("statistics:checks:del")
	@RequestMapping(value = "delete")
	public String delete(Checks checks, RedirectAttributes redirectAttributes) {
		checksService.delete(checks);
		addMessage(redirectAttributes, "删除销售量成功");
		return "redirect:"+Global.getAdminPath()+"/statistics/checks/?repage";
	}
	
	/**
	 * 批量删除销售量
	 */
	@RequiresPermissions("statistics:checks:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			checksService.delete(checksService.get(id));
		}
		addMessage(redirectAttributes, "删除销售量成功");
		return "redirect:"+Global.getAdminPath()+"/statistics/checks/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("statistics:checks:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Checks checks, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "销售量"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Checks> page = checksService.findPage(new Page<Checks>(request, response, -1), checks);
    		new ExportExcel("销售量", Checks.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出销售量记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/statistics/checks/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("statistics:checks:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Checks> list = ei.getDataList(Checks.class);
			for (Checks checks : list){
				try{
					checksService.save(checks);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条销售量记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条销售量记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入销售量失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/statistics/checks/?repage";
    }
	
	/**
	 * 下载导入销售量数据模板
	 */
	@RequiresPermissions("statistics:checks:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "销售量数据导入模板.xlsx";
    		List<Checks> list = Lists.newArrayList(); 
    		new ExportExcel("销售量数据", Checks.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/statistics/checks/?repage";
    }
	
	
	

}