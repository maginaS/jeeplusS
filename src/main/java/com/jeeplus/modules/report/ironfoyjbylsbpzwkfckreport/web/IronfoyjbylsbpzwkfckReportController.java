/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoyjbylsbpzwkfckreport.web;

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
import com.jeeplus.modules.report.ironfoyjbylsbpzwkfckreport.entity.IronfoyjbylsbpzwkfckReport;
import com.jeeplus.modules.report.ironfoyjbylsbpzwkfckreport.service.IronfoyjbylsbpzwkfckReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 外科、妇（产）科Controller
 * @author anti_magina
 * @version 2018-04-20
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfoyjbylsbpzwkfckreport/ironfoyjbylsbpzwkfck")
public class IronfoyjbylsbpzwkfckReportController extends BaseController {

	@Autowired
	private IronfoyjbylsbpzwkfckReportService ironfoyjbylsbpzwkfckService;
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	@ModelAttribute
	public IronfoyjbylsbpzwkfckReport get(@RequestParam(required=false) String id) {
		IronfoyjbylsbpzwkfckReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfoyjbylsbpzwkfckService.get(id);
		}
		if (entity == null){
			entity = new IronfoyjbylsbpzwkfckReport();
		}
		return entity;
	}
	
	/**
	 * 外科、妇（产）科列表页面
	 */
	@RequiresPermissions("ironfoyjbylsbpzwkfckreport:ironfoyjbylsbpzwkfck:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfoyjbylsbpzwkfckReport ironfoyjbylsbpzwkfck, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfoyjbylsbpzwkfck.getDuser() != null&&ironfoyjbylsbpzwkfck.getDuser().toString() != null && ironfoyjbylsbpzwkfck.getDuser().toString().trim() != null
					&& !"".equals(ironfoyjbylsbpzwkfck.getDuser().toString().trim())
					&& !"null".equals(ironfoyjbylsbpzwkfck.getDuser().toString().trim())) {
				userId = ironfoyjbylsbpzwkfck.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfoyjbylsbpzwkfck.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Page<IronfoyjbylsbpzwkfckReport> page = ironfoyjbylsbpzwkfckService.findPage(new Page<IronfoyjbylsbpzwkfckReport>(request, response), ironfoyjbylsbpzwkfck); 
		model.addAttribute("page", page);
		return "modules/report/ironfoyjbylsbpzwkfckreport/ironfoyjbylsbpzwkfckList";
	}

	/**
	 * 查看，增加，编辑外科、妇（产）科表单页面
	 */
	@RequiresPermissions(value={"ironfoyjbylsbpzwkfckreport:ironfoyjbylsbpzwkfck:view","ironfoyjbylsbpzwkfckreport:ironfoyjbylsbpzwkfck:add","ironfoyjbylsbpzwkfckreport:ironfoyjbylsbpzwkfck:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfoyjbylsbpzwkfckReport ironfoyjbylsbpzwkfck, Model model) {
		model.addAttribute("ironfoyjbylsbpzwkfck", ironfoyjbylsbpzwkfck);
		return "report/ironfoyjbylsbpzwkfckreport/ironfoyjbylsbpzwkfckForm";
	}

	/**
	 * 保存外科、妇（产）科
	 */
	@RequiresPermissions(value={"ironfoyjbylsbpzwkfckreport:ironfoyjbylsbpzwkfck:add","ironfoyjbylsbpzwkfckreport:ironfoyjbylsbpzwkfck:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfoyjbylsbpzwkfckReport ironfoyjbylsbpzwkfck, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfoyjbylsbpzwkfck)){
			return form(ironfoyjbylsbpzwkfck, model);
		}
		if(!ironfoyjbylsbpzwkfck.getIsNewRecord()){//编辑表单保存
			IronfoyjbylsbpzwkfckReport t = ironfoyjbylsbpzwkfckService.get(ironfoyjbylsbpzwkfck.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfoyjbylsbpzwkfck, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfoyjbylsbpzwkfckService.save(t);//保存
		}else{//新增表单保存
			ironfoyjbylsbpzwkfckService.save(ironfoyjbylsbpzwkfck);//保存
		}
		addMessage(redirectAttributes, "保存外科、妇（产）科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzwkfckreport/ironfoyjbylsbpzwkfck/?repage";
	}
	
	/**
	 * 删除外科、妇（产）科
	 */
	@RequiresPermissions("ironfoyjbylsbpzwkfckreport:ironfoyjbylsbpzwkfck:del")
	@RequestMapping(value = "delete")
	public String delete(IronfoyjbylsbpzwkfckReport ironfoyjbylsbpzwkfck, RedirectAttributes redirectAttributes) {
		ironfoyjbylsbpzwkfckService.delete(ironfoyjbylsbpzwkfck);
		addMessage(redirectAttributes, "删除外科、妇（产）科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzwkfckreport/ironfoyjbylsbpzwkfck/?repage";
	}
	
	/**
	 * 批量删除外科、妇（产）科
	 */
	@RequiresPermissions("ironfoyjbylsbpzwkfckreport:ironfoyjbylsbpzwkfck:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfoyjbylsbpzwkfckService.delete(ironfoyjbylsbpzwkfckService.get(id));
		}
		addMessage(redirectAttributes, "删除外科、妇（产）科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzwkfckreport/ironfoyjbylsbpzwkfck/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfoyjbylsbpzwkfckreport:ironfoyjbylsbpzwkfck:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfoyjbylsbpzwkfckReport ironfoyjbylsbpzwkfck, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfoyjbylsbpzwkfck.getDuser() != null&&ironfoyjbylsbpzwkfck.getDuser().toString() != null && ironfoyjbylsbpzwkfck.getDuser().toString().trim() != null
					&& !"".equals(ironfoyjbylsbpzwkfck.getDuser().toString().trim())
					&& !"null".equals(ironfoyjbylsbpzwkfck.getDuser().toString().trim())) {
				userId = ironfoyjbylsbpzwkfck.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				
				ironfoyjbylsbpzwkfck.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "外科、妇（产）科"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfoyjbylsbpzwkfckReport> page = ironfoyjbylsbpzwkfckService.findPage(new Page<IronfoyjbylsbpzwkfckReport>(request, response, -1), ironfoyjbylsbpzwkfck);
    		new ExportExcel("外科、妇（产）科", IronfoyjbylsbpzwkfckReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出外科、妇（产）科记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"report/ironfoyjbylsbpzwkfckreport/ironfoyjbylsbpzwkfck/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfoyjbylsbpzwkfckreport:ironfoyjbylsbpzwkfck:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfoyjbylsbpzwkfckReport> list = ei.getDataList(IronfoyjbylsbpzwkfckReport.class);
			for (IronfoyjbylsbpzwkfckReport ironfoyjbylsbpzwkfck : list){
				try{
					ironfoyjbylsbpzwkfckService.save(ironfoyjbylsbpzwkfck);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条外科、妇（产）科记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条外科、妇（产）科记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入外科、妇（产）科失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzwkfckreport/ironfoyjbylsbpzwkfck/?repage";
    }
	
	/**
	 * 下载导入外科、妇（产）科数据模板
	 */
	@RequiresPermissions("ironfoyjbylsbpzwkfckreport:ironfoyjbylsbpzwkfck:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "外科、妇（产）科数据导入模板.xlsx";
    		List<IronfoyjbylsbpzwkfckReport> list = Lists.newArrayList(); 
    		new ExportExcel("外科、妇（产）科数据", IronfoyjbylsbpzwkfckReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzwkfckreport/ironfoyjbylsbpzwkfck/?repage";
    }
	
	
	

}