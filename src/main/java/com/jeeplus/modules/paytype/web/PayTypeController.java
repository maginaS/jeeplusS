/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.paytype.web;

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
import com.jeeplus.modules.paytype.entity.PayType;
import com.jeeplus.modules.paytype.service.PayTypeService;

/**
 * 支付方式Controller
 * @author 瞿高青
 * @version 2017-11-08
 */
@Controller
@RequestMapping(value = "${adminPath}/paytype/payType")
public class PayTypeController extends BaseController {

	@Autowired
	private PayTypeService payTypeService;
	
	@ModelAttribute
	public PayType get(@RequestParam(required=false) String id) {
		PayType entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = payTypeService.get(id);
		}
		if (entity == null){
			entity = new PayType();
		}
		return entity;
	}
	
	/**
	 * 支付方式列表页面
	 */
	@RequiresPermissions("paytype:payType:list")
	@RequestMapping(value = {"list", ""})
	public String list(PayType payType, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<PayType> page = payTypeService.findPage(new Page<PayType>(request, response), payType); 
		model.addAttribute("page", page);
		return "modules/paytype/payTypeList";
	}

	/**
	 * 查看，增加，编辑支付方式表单页面
	 */
	@RequiresPermissions(value={"paytype:payType:view","paytype:payType:add","paytype:payType:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(PayType payType, Model model) {
		model.addAttribute("payType", payType);
		return "modules/paytype/payTypeForm";
	}

	/**
	 * 保存支付方式
	 */
	@RequiresPermissions(value={"paytype:payType:add","paytype:payType:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(PayType payType, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, payType)){
			return form(payType, model);
		}
		if(!payType.getIsNewRecord()){//编辑表单保存
			PayType t = payTypeService.get(payType.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(payType, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			payTypeService.save(t);//保存
		}else{//新增表单保存
			payTypeService.save(payType);//保存
		}
		addMessage(redirectAttributes, "保存支付方式成功");
		return "redirect:"+Global.getAdminPath()+"/paytype/payType/?repage";
	}
	
	/**
	 * 删除支付方式
	 */
	@RequiresPermissions("paytype:payType:del")
	@RequestMapping(value = "delete")
	public String delete(PayType payType, RedirectAttributes redirectAttributes) {
		payTypeService.delete(payType);
		addMessage(redirectAttributes, "删除支付方式成功");
		return "redirect:"+Global.getAdminPath()+"/paytype/payType/?repage";
	}
	
	/**
	 * 批量删除支付方式
	 */
	@RequiresPermissions("paytype:payType:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			payTypeService.delete(payTypeService.get(id));
		}
		addMessage(redirectAttributes, "删除支付方式成功");
		return "redirect:"+Global.getAdminPath()+"/paytype/payType/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("paytype:payType:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(PayType payType, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "支付方式"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<PayType> page = payTypeService.findPage(new Page<PayType>(request, response, -1), payType);
    		new ExportExcel("支付方式", PayType.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出支付方式记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/paytype/payType/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("paytype:payType:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<PayType> list = ei.getDataList(PayType.class);
			for (PayType payType : list){
				try{
					payTypeService.save(payType);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条支付方式记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条支付方式记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入支付方式失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/paytype/payType/?repage";
    }
	
	/**
	 * 下载导入支付方式数据模板
	 */
	@RequiresPermissions("paytype:payType:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "支付方式数据导入模板.xlsx";
    		List<PayType> list = Lists.newArrayList(); 
    		new ExportExcel("支付方式数据", PayType.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/paytype/payType/?repage";
    }
	
	
	

}