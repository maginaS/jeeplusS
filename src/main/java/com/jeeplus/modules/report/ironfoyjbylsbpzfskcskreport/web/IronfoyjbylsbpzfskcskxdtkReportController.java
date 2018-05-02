/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoyjbylsbpzfskcskreport.web;

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
import com.jeeplus.common.config.Global;
import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.utils.DateUtils;
import com.jeeplus.common.utils.MyBeanUtils;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.common.utils.excel.ExportExcel;
import com.jeeplus.common.utils.excel.ImportExcel;
import com.jeeplus.common.web.BaseController;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.ironfodoctitle.service.IronfoDocTitleService;
import com.jeeplus.modules.ironfoyjbylsbpzfskcskxdtk.entity.Ironfoyjbylsbpzfskcskxdtk;
import com.jeeplus.modules.ironfoyjbylsbpzfskcskxdtk.service.IronfoyjbylsbpzfskcskxdtkService;
import com.jeeplus.modules.report.ironfoyjbylsbpzfskcskreport.entity.IronfoyjbylsbpzfskcskxdtkReport;
import com.jeeplus.modules.report.ironfoyjbylsbpzfskcskreport.service.IronfoyjbylsbpzfskcskxdtkReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 放射科、超声科、心电图科Controller
 * @author anti_magina
 * @version 2018-04-20
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfoyjbylsbpzfskcskreport/ironfoyjbylsbpzfskcskxdtk")
public class IronfoyjbylsbpzfskcskxdtkReportController extends BaseController {

	@Autowired
	private IronfoyjbylsbpzfskcskxdtkReportService ironfoyjbylsbpzfskcskxdtkReportService;
	@Autowired
	private IronfoyjbylsbpzfskcskxdtkService ironfoyjbylsbpzfskcskxdtkService;
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	@ModelAttribute
	public IronfoyjbylsbpzfskcskxdtkReport get(@RequestParam(required=false) String id) {
		IronfoyjbylsbpzfskcskxdtkReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfoyjbylsbpzfskcskxdtkReportService.get(id);
		}
		if (entity == null){
			entity = new IronfoyjbylsbpzfskcskxdtkReport();
		}
		return entity;
	}
	
	/**
	 * 放射科、超声科、心电图科列表页面
	 */
	@RequiresPermissions("ironfoyjbylsbpzfskcskreport:ironfoyjbylsbpzfskcskxdtk:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfoyjbylsbpzfskcskxdtkReport ironfoyjbylsbpzfskcskxdtk, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfoyjbylsbpzfskcskxdtk.getDuser() != null&&ironfoyjbylsbpzfskcskxdtk.getDuser().toString() != null && ironfoyjbylsbpzfskcskxdtk.getDuser().toString().trim() != null
					&& !"".equals(ironfoyjbylsbpzfskcskxdtk.getDuser().toString().trim())
					&& !"null".equals(ironfoyjbylsbpzfskcskxdtk.getDuser().toString().trim())) {
				userId = ironfoyjbylsbpzfskcskxdtk.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			//根据title表如果没字段,就默认查当前用户下的信息
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				
				ironfoyjbylsbpzfskcskxdtk.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Page<IronfoyjbylsbpzfskcskxdtkReport> page = ironfoyjbylsbpzfskcskxdtkReportService.findPage(new Page<IronfoyjbylsbpzfskcskxdtkReport>(request, response), ironfoyjbylsbpzfskcskxdtk);
		model.addAttribute("page", page);
		return "modules/report/ironfoyjbylsbpzfskcskreport/ironfoyjbylsbpzfskcskxdtkList";
	}

	/**
	 * 查看，增加，编辑放射科、超声科、心电图科表单页面
	 */
	@RequiresPermissions(value={"ironfoyjbylsbpzfskcskreport:ironfoyjbylsbpzfskcskxdtk:view","ironfoyjbylsbpzfskcskreport:ironfoyjbylsbpzfskcskxdtk:add","ironfoyjbylsbpzfskcskreport:ironfoyjbylsbpzfskcskxdtk:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfoyjbylsbpzfskcskxdtkReport ironfoyjbylsbpzfskcskxdtk, Model model) {
		model.addAttribute("ironfoyjbylsbpzfskcskxdtk", ironfoyjbylsbpzfskcskxdtk);
		return "report/ironfoyjbylsbpzfskcskreport/ironfoyjbylsbpzfskcskxdtkForm";
	}

	/**
	 * 保存放射科、超声科、心电图科
	 */
	@RequiresPermissions(value={"ironfoyjbylsbpzfskcskreport:ironfoyjbylsbpzfskcskxdtk:add","ironfoyjbylsbpzfskcskreport:ironfoyjbylsbpzfskcskxdtk:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfoyjbylsbpzfskcskxdtkReport ironfoyjbylsbpzfskcskxdtk, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfoyjbylsbpzfskcskxdtk)){
			return form(ironfoyjbylsbpzfskcskxdtk, model);
		}
		if(!ironfoyjbylsbpzfskcskxdtk.getIsNewRecord()){//编辑表单保存
			IronfoyjbylsbpzfskcskxdtkReport t = ironfoyjbylsbpzfskcskxdtkReportService.get(ironfoyjbylsbpzfskcskxdtk.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfoyjbylsbpzfskcskxdtk, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfoyjbylsbpzfskcskxdtkReportService.save(t);//保存
		}else{//新增表单保存
			ironfoyjbylsbpzfskcskxdtkReportService.save(ironfoyjbylsbpzfskcskxdtk);//保存
		}
		addMessage(redirectAttributes, "保存放射科、超声科、心电图科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzfskcskreport/ironfoyjbylsbpzfskcskxdtk/?repage";
	}
	
	/**
	 * 删除放射科、超声科、心电图科
	 */
	@RequiresPermissions("ironfoyjbylsbpzfskcskreport:ironfoyjbylsbpzfskcskxdtk:del")
	@RequestMapping(value = "delete")
	public String delete(IronfoyjbylsbpzfskcskxdtkReport ironfoyjbylsbpzfskcskxdtk, RedirectAttributes redirectAttributes) {
		ironfoyjbylsbpzfskcskxdtkReportService.delete(ironfoyjbylsbpzfskcskxdtk);
		addMessage(redirectAttributes, "删除放射科、超声科、心电图科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzfskcskreport/ironfoyjbylsbpzfskcskxdtk/?repage";
	}
	
	/**
	 * 批量删除放射科、超声科、心电图科
	 */
	@RequiresPermissions("ironfoyjbylsbpzfskcskreport:ironfoyjbylsbpzfskcskxdtk:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfoyjbylsbpzfskcskxdtkReportService.delete(ironfoyjbylsbpzfskcskxdtkReportService.get(id));
		}
		addMessage(redirectAttributes, "删除放射科、超声科、心电图科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzfskcskreport/ironfoyjbylsbpzfskcskxdtk/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfoyjbylsbpzfskcskreport:ironfoyjbylsbpzfskcskxdtk:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfoyjbylsbpzfskcskxdtkReport ironfoyjbylsbpzfskcskxdtk, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfoyjbylsbpzfskcskxdtk.getDuser() != null&&ironfoyjbylsbpzfskcskxdtk.getDuser().toString() != null && ironfoyjbylsbpzfskcskxdtk.getDuser().toString().trim() != null
					&& !"".equals(ironfoyjbylsbpzfskcskxdtk.getDuser().toString().trim())
					&& !"null".equals(ironfoyjbylsbpzfskcskxdtk.getDuser().toString().trim())) {
				userId = ironfoyjbylsbpzfskcskxdtk.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			//根据title表如果没字段,就默认查当前用户下的信息
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				
				ironfoyjbylsbpzfskcskxdtk.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "放射科、超声科、心电图科"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfoyjbylsbpzfskcskxdtkReport> page = ironfoyjbylsbpzfskcskxdtkReportService.findPage(new Page<IronfoyjbylsbpzfskcskxdtkReport>(request, response, -1), ironfoyjbylsbpzfskcskxdtk);
    		new ExportExcel("放射科、超声科、心电图科", IronfoyjbylsbpzfskcskxdtkReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出放射科、超声科、心电图科记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzfskcskreport/ironfoyjbylsbpzfskcskxdtk/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfoyjbylsbpzfskcskreport:ironfoyjbylsbpzfskcskxdtk:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfoyjbylsbpzfskcskxdtkReport> list = ei.getDataList(IronfoyjbylsbpzfskcskxdtkReport.class);
			for (IronfoyjbylsbpzfskcskxdtkReport ironfoyjbylsbpzfskcskxdtk : list){
				try{
					ironfoyjbylsbpzfskcskxdtkReportService.save(ironfoyjbylsbpzfskcskxdtk);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条放射科、超声科、心电图科记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条放射科、超声科、心电图科记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入放射科、超声科、心电图科失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzfskcskreport/ironfoyjbylsbpzfskcskxdtk/?repage";
    }
	
	/**
	 * 下载导入放射科、超声科、心电图科数据模板
	 */
	@RequiresPermissions("ironfoyjbylsbpzfskcskreport:ironfoyjbylsbpzfskcskxdtk:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "放射科、超声科、心电图科数据导入模板.xlsx";
    		List<IronfoyjbylsbpzfskcskxdtkReport> list = Lists.newArrayList(); 
    		new ExportExcel("放射科、超声科、心电图科数据", IronfoyjbylsbpzfskcskxdtkReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzfskcskreport/ironfoyjbylsbpzfskcskxdtk/?repage";
    }
	
	
	

}