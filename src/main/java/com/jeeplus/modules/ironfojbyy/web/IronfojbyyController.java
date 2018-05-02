/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfojbyy.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
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
import com.jeeplus.modules.ironfofinance.entity.Ironfofinance;
import com.jeeplus.modules.ironfojbyy.entity.Ironfojbyy;
import com.jeeplus.modules.ironfojbyy.service.IronfojbyyService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 2.6基本用药Controller
 * @author mikesun
 * @version 2018-03-21
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfojbyy/ironfojbyy")
public class IronfojbyyController extends BaseController {

	
	
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	@Autowired
	private IronfojbyyService ironfojbyyService;
	
	@ModelAttribute
	public Ironfojbyy get(@RequestParam(required=false) String id) {
		Ironfojbyy entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfojbyyService.get(id);
		}
		if (entity == null){
			entity = new Ironfojbyy();
		}
		return entity;
	}
	
	/**
	 * 2.6基本用药列表页面
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	@RequiresPermissions("ironfojbyy:ironfojbyy:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfojbyy ironfojbyy, HttpServletRequest request, HttpServletResponse response, Model model) throws InstantiationException, IllegalAccessException {

		
		

		Subject subject = SecurityUtils.getSubject();  
		Principal obj = (Principal) subject.getPrincipal();
		System.out.println(obj.getId());
		
		
		Map<String,Object> datas = new TreeMap<String,Object>();
		IronfoDocTitle title =  IronfoDocTitle.class.newInstance();
		title.setRemarks(obj.getId());
		
		List<IronfoDocTitle> docList = ironfoDoc_Title_Service.queryforList(title);
		
		if(docList.size()>0) {
			ironfojbyy.setDoc_id(docList.get(0).getId().toString());
			List<Ironfojbyy> data =  ironfojbyyService.queryForList(ironfojbyy);
			
			datas.put("doc_id", docList.get(0).getId().toString());
			for(int i = 0; i<data.size();i++) {
				datas.put("jbyypzs", data.get(i).getJbyypzs().toString());
				datas.put("id", data.get(i).getId().toString());
			}
			
			
		}else {
			datas.put("jbyypzs", "");
			datas.put("id", "");
		}
		
		
		
		
		request.setAttribute("data", datas);
		model.addAttribute("data", datas);
		return "modules/ironfojbyy/ironfojbyyList";
	}

	/**
	 * 查看，增加，编辑2.6基本用药表单页面
	 */
	@RequiresPermissions(value={"ironfojbyy:ironfojbyy:view","ironfojbyy:ironfojbyy:add","ironfojbyy:ironfojbyy:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfojbyy ironfojbyy, Model model) {
		model.addAttribute("ironfojbyy", ironfojbyy);
		return "modules/ironfojbyy/ironfojbyyForm";
	}

	/**
	 * 保存2.6基本用药
	 */
	@RequiresPermissions(value={"ironfojbyy:ironfojbyy:add","ironfojbyy:ironfojbyy:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfojbyy ironfojbyy, Model model, RedirectAttributes redirectAttributes) throws Exception{
		boolean isnull=false;
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		
		
		Subject subject = SecurityUtils.getSubject();  
		Principal obj = (Principal) subject.getPrincipal();
		
		System.out.println(obj.getId());
		
		Map<String,Object> map = new  HashMap<String,Object>();
		String data = request.getParameter("datas");
		String[] ironfojbyys = data.split(";");
		
		String docId = "";
		for(int i=0;i<ironfojbyys.length;i++) {
			map.put(ironfojbyys[i].toString().split(":")[0].toString(),ironfojbyys[i].toString().split(":")[1].toString());
			if("docId" == ironfojbyys[i].toString().trim().split(":")[0].toString().trim() || "docId".equals(ironfojbyys[i].toString().trim().split(":")[0].toString().trim())) {
				docId = ironfojbyys[i].toString().split(":")[1].toString();
			}
		}
		
		
		if(docId.toString().trim() == null || "".equals(docId.toString().trim())) {
			
			
 			isnull = false;
 			
 			IronfoDocTitle title =  IronfoDocTitle.class.newInstance();
 			title.setRemarks(obj.getId());
 			
 			List<IronfoDocTitle> docList = ironfoDoc_Title_Service.queryforList(title);
 			docId= docList.get(0).getId().toString();
 			
		}else {
			
			ironfojbyy.setDoc_id(docId);
			List<Ironfojbyy> ironfoList = ironfojbyyService.queryForList(ironfojbyy);
			if(ironfoList.size()>0) {
				isnull = true;
			}else {
				isnull = false;
			}
			
		}
		
		
		Ironfojbyy ironfojbyy_save_or_update =null;
		
		if(isnull == false) {
			ironfojbyy_save_or_update = new Ironfojbyy();
			ironfojbyy_save_or_update.setJbyypzs(map.get("jbyypzs").toString());
			ironfojbyy_save_or_update.setDoc_id(docId);
			ironfojbyyService.save(ironfojbyy_save_or_update);
		}else if(isnull == true) {
			ironfojbyy_save_or_update = new Ironfojbyy(); 
			ironfojbyy_save_or_update.setJbyypzs(map.get("jbyypzs").toString());
			ironfojbyy_save_or_update.setId(map.get("id").toString());
			ironfojbyy_save_or_update.setDoc_id(docId);
			ironfojbyyService.updateIronfo(ironfojbyy_save_or_update);
		}
		addMessage(redirectAttributes, "保存2.6基本用药成功");
		return "redirect:"+Global.getAdminPath()+"/ironfojbyy/ironfojbyy/?repage";
	}
	
	/**
	 * 删除2.6基本用药
	 */
	@RequiresPermissions("ironfojbyy:ironfojbyy:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfojbyy ironfojbyy, RedirectAttributes redirectAttributes) {
		ironfojbyyService.delete(ironfojbyy);
		addMessage(redirectAttributes, "删除2.6基本用药成功");
		return "redirect:"+Global.getAdminPath()+"/ironfojbyy/ironfojbyy/?repage";
	}
	
	/**
	 * 批量删除2.6基本用药
	 */
	@RequiresPermissions("ironfojbyy:ironfojbyy:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfojbyyService.delete(ironfojbyyService.get(id));
		}
		addMessage(redirectAttributes, "删除2.6基本用药成功");
		return "redirect:"+Global.getAdminPath()+"/ironfojbyy/ironfojbyy/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfojbyy:ironfojbyy:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfojbyy ironfojbyy, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "2.6基本用药"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfojbyy> page = ironfojbyyService.findPage(new Page<Ironfojbyy>(request, response, -1), ironfojbyy);
    		new ExportExcel("2.6基本用药", Ironfojbyy.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出2.6基本用药记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfojbyy/ironfojbyy/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfojbyy:ironfojbyy:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfojbyy> list = ei.getDataList(Ironfojbyy.class);
			for (Ironfojbyy ironfojbyy : list){
				try{
					ironfojbyyService.save(ironfojbyy);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条2.6基本用药记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条2.6基本用药记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入2.6基本用药失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfojbyy/ironfojbyy/?repage";
    }
	
	/**
	 * 下载导入2.6基本用药数据模板
	 */
	@RequiresPermissions("ironfojbyy:ironfojbyy:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "2.6基本用药数据导入模板.xlsx";
    		List<Ironfojbyy> list = Lists.newArrayList(); 
    		new ExportExcel("2.6基本用药数据", Ironfojbyy.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfojbyy/ironfojbyy/?repage";
    }
	
	
	

}