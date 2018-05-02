/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfo_yjbylsbpz_pfk_report.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
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
import com.jeeplus.modules.report.ironfo_yjbylsbpz_pfk_report.entity.Ironfo_yjbylsbpz_pfk_Report;
import com.jeeplus.modules.report.ironfo_yjbylsbpz_pfk_report.service.Ironfo_yjbylsbpz_pfk_ReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 皮肤科Controller
 * @author anti_magina
 * @version 2018-04-20
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfo_yjbylsbpz_pfk_report/ironfo_yjbylsbpz_pfk")
public class Ironfo_yjbylsbpz_pfk_ReportController extends BaseController {

	@Autowired
	private Ironfo_yjbylsbpz_pfk_ReportService ironfo_yjbylsbpz_pfkService;
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	@ModelAttribute
	public Ironfo_yjbylsbpz_pfk_Report get(@RequestParam(required=false) String id) {
		Ironfo_yjbylsbpz_pfk_Report entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfo_yjbylsbpz_pfkService.get(id);
		}
		if (entity == null){
			entity = new Ironfo_yjbylsbpz_pfk_Report();
		}
		return entity;
	}
	
	/**
	 * 皮肤科列表页面
	 */
	@RequiresPermissions("ironfo_yjbylsbpz_pfk_report:ironfo_yjbylsbpz_pfk:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfo_yjbylsbpz_pfk_Report ironfo_yjbylsbpz_pfk, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfo_yjbylsbpz_pfk.getDuser() != null&&ironfo_yjbylsbpz_pfk.getDuser().toString() != null && ironfo_yjbylsbpz_pfk.getDuser().toString().trim() != null
					&& !"".equals(ironfo_yjbylsbpz_pfk.getDuser().toString().trim())
					&& !"null".equals(ironfo_yjbylsbpz_pfk.getDuser().toString().trim())) {
				userId = ironfo_yjbylsbpz_pfk.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfo_yjbylsbpz_pfk.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Page<Ironfo_yjbylsbpz_pfk_Report> page = ironfo_yjbylsbpz_pfkService.findPage(new Page<Ironfo_yjbylsbpz_pfk_Report>(request, response), ironfo_yjbylsbpz_pfk); 
		model.addAttribute("page", page);
		return "modules/report/ironfo_yjbylsbpz_pfk_report/ironfo_yjbylsbpz_pfkList";
	}

	/**
	 * 查看，增加，编辑皮肤科表单页面
	 */
	@RequiresPermissions(value={"ironfo_yjbylsbpz_pfk_report:ironfo_yjbylsbpz_pfk:view","ironfo_yjbylsbpz_pfk_report:ironfo_yjbylsbpz_pfk:add","ironfo_yjbylsbpz_pfk_report:ironfo_yjbylsbpz_pfk:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfo_yjbylsbpz_pfk_Report ironfo_yjbylsbpz_pfk, Model model) {
		model.addAttribute("ironfo_yjbylsbpz_pfk", ironfo_yjbylsbpz_pfk);
		return "report/ironfo_yjbylsbpz_pfk_report/ironfo_yjbylsbpz_pfkForm";
	}

	/**
	 * 保存皮肤科
	 */
	@RequiresPermissions(value={"ironfo_yjbylsbpz_pfk_report:ironfo_yjbylsbpz_pfk:add","ironfo_yjbylsbpz_pfk_report:ironfo_yjbylsbpz_pfk:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfo_yjbylsbpz_pfk_Report ironfo_yjbylsbpz_pfk, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfo_yjbylsbpz_pfk)){
			return form(ironfo_yjbylsbpz_pfk, model);
		}
		if(!ironfo_yjbylsbpz_pfk.getIsNewRecord()){//编辑表单保存
			Ironfo_yjbylsbpz_pfk_Report t = ironfo_yjbylsbpz_pfkService.get(ironfo_yjbylsbpz_pfk.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfo_yjbylsbpz_pfk, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfo_yjbylsbpz_pfkService.save(t);//保存
		}else{//新增表单保存
			ironfo_yjbylsbpz_pfkService.save(ironfo_yjbylsbpz_pfk);//保存
		}
		addMessage(redirectAttributes, "保存皮肤科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfo_yjbylsbpz_pfk_report/ironfo_yjbylsbpz_pfk/?repage";
	}
	
	/**
	 * 删除皮肤科
	 */
	@RequiresPermissions("ironfo_yjbylsbpz_pfk_report:ironfo_yjbylsbpz_pfk:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfo_yjbylsbpz_pfk_Report ironfo_yjbylsbpz_pfk, RedirectAttributes redirectAttributes) {
		ironfo_yjbylsbpz_pfkService.delete(ironfo_yjbylsbpz_pfk);
		addMessage(redirectAttributes, "删除皮肤科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfo_yjbylsbpz_pfk_report/ironfo_yjbylsbpz_pfk/?repage";
	}
	
	/**
	 * 批量删除皮肤科
	 */
	@RequiresPermissions("ironfo_yjbylsbpz_pfk_report:ironfo_yjbylsbpz_pfk:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfo_yjbylsbpz_pfkService.delete(ironfo_yjbylsbpz_pfkService.get(id));
		}
		addMessage(redirectAttributes, "删除皮肤科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfo_yjbylsbpz_pfk_report/ironfo_yjbylsbpz_pfk/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfo_yjbylsbpz_pfk_report:ironfo_yjbylsbpz_pfk:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfo_yjbylsbpz_pfk_Report ironfo_yjbylsbpz_pfk, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfo_yjbylsbpz_pfk.getDuser() != null&&ironfo_yjbylsbpz_pfk.getDuser().toString() != null && ironfo_yjbylsbpz_pfk.getDuser().toString().trim() != null
					&& !"".equals(ironfo_yjbylsbpz_pfk.getDuser().toString().trim())
					&& !"null".equals(ironfo_yjbylsbpz_pfk.getDuser().toString().trim())) {
				userId = ironfo_yjbylsbpz_pfk.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
				
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfo_yjbylsbpz_pfk.setDoc_id(title.getId());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "皮肤科"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfo_yjbylsbpz_pfk_Report> page = ironfo_yjbylsbpz_pfkService.findPage(new Page<Ironfo_yjbylsbpz_pfk_Report>(request, response, -1), ironfo_yjbylsbpz_pfk);
    		new ExportExcel("皮肤科", Ironfo_yjbylsbpz_pfk_Report.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出皮肤科记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"report/ironfo_yjbylsbpz_pfk_report/ironfo_yjbylsbpz_pfk/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfo_yjbylsbpz_pfk_report:ironfo_yjbylsbpz_pfk:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfo_yjbylsbpz_pfk_Report> list = ei.getDataList(Ironfo_yjbylsbpz_pfk_Report.class);
			for (Ironfo_yjbylsbpz_pfk_Report ironfo_yjbylsbpz_pfk : list){
				try{
					ironfo_yjbylsbpz_pfkService.save(ironfo_yjbylsbpz_pfk);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条皮肤科记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条皮肤科记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入皮肤科失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfo_yjbylsbpz_pfk_report/ironfo_yjbylsbpz_pfk/?repage";
    }
	
	/**
	 * 下载导入皮肤科数据模板
	 */
	@RequiresPermissions("ironfo_yjbylsbpz_pfk_report:ironfo_yjbylsbpz_pfk:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "皮肤科数据导入模板.xlsx";
    		List<Ironfo_yjbylsbpz_pfk_Report> list = Lists.newArrayList(); 
    		new ExportExcel("皮肤科数据", Ironfo_yjbylsbpz_pfk_Report.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfo_yjbylsbpz_pfk_report/ironfo_yjbylsbpz_pfk/?repage";
    }
	
	
	

}