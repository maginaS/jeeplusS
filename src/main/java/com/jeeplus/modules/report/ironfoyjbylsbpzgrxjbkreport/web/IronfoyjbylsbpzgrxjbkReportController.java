/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoyjbylsbpzgrxjbkreport.web;

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
import com.jeeplus.modules.report.ironfoyjbylsbpzgrxjbkreport.entity.IronfoyjbylsbpzgrxjbkReport;
import com.jeeplus.modules.report.ironfoyjbylsbpzgrxjbkreport.service.IronfoyjbylsbpzgrxjbkReportService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 感染性疾病科Controller
 * @author anti_magina
 * @version 2018-04-20
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfoyjbylsbpzgrxjbkreport/ironfoyjbylsbpzgrxjbk")
public class IronfoyjbylsbpzgrxjbkReportController extends BaseController {

	@Autowired
	private IronfoyjbylsbpzgrxjbkReportService ironfoyjbylsbpzgrxjbkService;
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	@ModelAttribute
	public IronfoyjbylsbpzgrxjbkReport get(@RequestParam(required=false) String id) {
		IronfoyjbylsbpzgrxjbkReport entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfoyjbylsbpzgrxjbkService.get(id);
		}
		if (entity == null){
			entity = new IronfoyjbylsbpzgrxjbkReport();
		}
		return entity;
	}
	
	/**
	 * 感染性疾病科列表页面
	 */
	@RequiresPermissions("ironfoyjbylsbpzgrxjbkreport:ironfoyjbylsbpzgrxjbk:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfoyjbylsbpzgrxjbkReport ironfoyjbylsbpzgrxjbk, HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfoyjbylsbpzgrxjbk.getDuser() != null&&ironfoyjbylsbpzgrxjbk.getDuser().toString() != null && ironfoyjbylsbpzgrxjbk.getDuser().toString().trim() != null
					&& !"".equals(ironfoyjbylsbpzgrxjbk.getDuser().toString().trim())
					&& !"null".equals(ironfoyjbylsbpzgrxjbk.getDuser().toString().trim())) {
				userId = ironfoyjbylsbpzgrxjbk.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				
				ironfoyjbylsbpzgrxjbk.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Page<IronfoyjbylsbpzgrxjbkReport> page = ironfoyjbylsbpzgrxjbkService.findPage(new Page<IronfoyjbylsbpzgrxjbkReport>(request, response), ironfoyjbylsbpzgrxjbk); 
		model.addAttribute("page", page);
		return "modules/report/ironfoyjbylsbpzgrxjbkreport/ironfoyjbylsbpzgrxjbkList";
	}

	/**
	 * 查看，增加，编辑感染性疾病科表单页面
	 */
	@RequiresPermissions(value={"ironfoyjbylsbpzgrxjbkreport:ironfoyjbylsbpzgrxjbk:view","ironfoyjbylsbpzgrxjbkreport:ironfoyjbylsbpzgrxjbk:add","ironfoyjbylsbpzgrxjbkreport:ironfoyjbylsbpzgrxjbk:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfoyjbylsbpzgrxjbkReport ironfoyjbylsbpzgrxjbk, Model model) {
		model.addAttribute("ironfoyjbylsbpzgrxjbk", ironfoyjbylsbpzgrxjbk);
		return "report/ironfoyjbylsbpzgrxjbkreport/ironfoyjbylsbpzgrxjbkForm";
	}

	/**
	 * 保存感染性疾病科
	 */
	@RequiresPermissions(value={"ironfoyjbylsbpzgrxjbkreport:ironfoyjbylsbpzgrxjbk:add","ironfoyjbylsbpzgrxjbkreport:ironfoyjbylsbpzgrxjbk:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfoyjbylsbpzgrxjbkReport ironfoyjbylsbpzgrxjbk, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfoyjbylsbpzgrxjbk)){
			return form(ironfoyjbylsbpzgrxjbk, model);
		}
		if(!ironfoyjbylsbpzgrxjbk.getIsNewRecord()){//编辑表单保存
			IronfoyjbylsbpzgrxjbkReport t = ironfoyjbylsbpzgrxjbkService.get(ironfoyjbylsbpzgrxjbk.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfoyjbylsbpzgrxjbk, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfoyjbylsbpzgrxjbkService.save(t);//保存
		}else{//新增表单保存
			ironfoyjbylsbpzgrxjbkService.save(ironfoyjbylsbpzgrxjbk);//保存
		}
		addMessage(redirectAttributes, "保存感染性疾病科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzgrxjbkreport/ironfoyjbylsbpzgrxjbk/?repage";
	}
	
	/**
	 * 删除感染性疾病科
	 */
	@RequiresPermissions("ironfoyjbylsbpzgrxjbkreport:ironfoyjbylsbpzgrxjbk:del")
	@RequestMapping(value = "delete")
	public String delete(IronfoyjbylsbpzgrxjbkReport ironfoyjbylsbpzgrxjbk, RedirectAttributes redirectAttributes) {
		ironfoyjbylsbpzgrxjbkService.delete(ironfoyjbylsbpzgrxjbk);
		addMessage(redirectAttributes, "删除感染性疾病科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzgrxjbkreport/ironfoyjbylsbpzgrxjbk/?repage";
	}
	
	/**
	 * 批量删除感染性疾病科
	 */
	@RequiresPermissions("ironfoyjbylsbpzgrxjbkreport:ironfoyjbylsbpzgrxjbk:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfoyjbylsbpzgrxjbkService.delete(ironfoyjbylsbpzgrxjbkService.get(id));
		}
		addMessage(redirectAttributes, "删除感染性疾病科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzgrxjbkreport/ironfoyjbylsbpzgrxjbk/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfoyjbylsbpzgrxjbkreport:ironfoyjbylsbpzgrxjbk:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfoyjbylsbpzgrxjbkReport ironfoyjbylsbpzgrxjbk, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfoyjbylsbpzgrxjbk.getDuser() != null&&ironfoyjbylsbpzgrxjbk.getDuser().toString() != null && ironfoyjbylsbpzgrxjbk.getDuser().toString().trim() != null
					&& !"".equals(ironfoyjbylsbpzgrxjbk.getDuser().toString().trim())
					&& !"null".equals(ironfoyjbylsbpzgrxjbk.getDuser().toString().trim())) {
				userId = ironfoyjbylsbpzgrxjbk.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if(title != null){
				ironfoyjbylsbpzgrxjbk.setDoc_id(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "感染性疾病科"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfoyjbylsbpzgrxjbkReport> page = ironfoyjbylsbpzgrxjbkService.findPage(new Page<IronfoyjbylsbpzgrxjbkReport>(request, response, -1), ironfoyjbylsbpzgrxjbk);
    		new ExportExcel("感染性疾病科", IronfoyjbylsbpzgrxjbkReport.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出感染性疾病科记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"report/ironfoyjbylsbpzgrxjbkreport/ironfoyjbylsbpzgrxjbk/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfoyjbylsbpzgrxjbkreport:ironfoyjbylsbpzgrxjbk:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfoyjbylsbpzgrxjbkReport> list = ei.getDataList(IronfoyjbylsbpzgrxjbkReport.class);
			for (IronfoyjbylsbpzgrxjbkReport ironfoyjbylsbpzgrxjbk : list){
				try{
					ironfoyjbylsbpzgrxjbkService.save(ironfoyjbylsbpzgrxjbk);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条感染性疾病科记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条感染性疾病科记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入感染性疾病科失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzgrxjbkreport/ironfoyjbylsbpzgrxjbk/?repage";
    }
	
	/**
	 * 下载导入感染性疾病科数据模板
	 */
	@RequiresPermissions("ironfoyjbylsbpzgrxjbkreport:ironfoyjbylsbpzgrxjbk:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "感染性疾病科数据导入模板.xlsx";
    		List<IronfoyjbylsbpzgrxjbkReport> list = Lists.newArrayList(); 
    		new ExportExcel("感染性疾病科数据", IronfoyjbylsbpzgrxjbkReport.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzgrxjbkreport/ironfoyjbylsbpzgrxjbk/?repage";
    }
	
	
	

}