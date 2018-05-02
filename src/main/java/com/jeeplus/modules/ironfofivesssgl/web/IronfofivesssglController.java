/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofivesssgl.web;

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
import com.jeeplus.modules.ironfofivebfpz.entity.Ironfofivebfpz;
import com.jeeplus.modules.ironfofivesssgl.entity.Ironfofivesssgl;
import com.jeeplus.modules.ironfofivesssgl.service.IronfofivesssglService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 5.4手术室Controller
 * @author mikesun
 * @version 2018-04-08
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfofivesssgl/ironfofivesssgl")
public class IronfofivesssglController extends BaseController {
	
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	

	@Autowired
	private IronfofivesssglService ironfofivesssglService;
	
	@ModelAttribute
	public Ironfofivesssgl get(@RequestParam(required=false) String id) {
		Ironfofivesssgl entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfofivesssglService.get(id);
		}
		if (entity == null){
			entity = new Ironfofivesssgl();
		}
		return entity;
	}
	
	/**
	 * 5.4手术室列表页面
	 */
	@RequiresPermissions("ironfofivesssgl:ironfofivesssgl:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfofivesssgl ironfofivesssgl, HttpServletRequest request, HttpServletResponse response, Model model) {
	
		
		Subject subject = SecurityUtils.getSubject();  
		Principal obj = (Principal) subject.getPrincipal();
		System.out.println(obj.getId());
		
		
		Map<String,Object> listData = new HashMap<String,Object>();
		Map<String,Object> datas = new TreeMap<String,Object>();
		IronfoDocTitle title = null;
		try {
			title = IronfoDocTitle.class.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		title.setRemarks(obj.getId());
//		title =  ironfoDoc_Title_Service.getDocId(obj.getId());
		List<IronfoDocTitle> docList = ironfoDoc_Title_Service.queryforList(title);
		if(docList.size()>0) {
			ironfofivesssgl.setDoc_id(docList.get(0).getId().toString());
			List<Ironfofivesssgl> data = ironfofivesssglService.queryForList(ironfofivesssgl);
			
			datas.put("doc_id", docList.get(0).getId().toString());
			
			for(Ironfofivesssgl ce : data) {
				
				if("----".trim()==ce.getId().trim()||"----".trim().equals(ce.getId().trim())) {
					datas.put("id", "");
				}else{
					datas.put("id", ce.getId());
				}
				
				
				if("----".trim()==ce.getAjjjsss().trim()||"----".trim().equals(ce.getAjjjsss().trim())) {
					datas.put("Ajjjsss", "");
				}else {
					datas.put("Ajjjsss", ce.getAjjjsss());
				}
				
				if("----".trim()==ce.getBjjjsss().trim()||"----".trim().equals(ce.getBjjjsss().trim())) {
					datas.put("Bjjjsss", "");
				}else {
					datas.put("Bjjjsss", ce.getBjjjsss());

				}
				
				if("----".trim()==ce.getCjjjsss().trim()||"----".trim().equals(ce.getCjjjsss().trim())) {
					datas.put("Cjjjsss", "");
				}else {
					datas.put("Cjjjsss", ce.getCjjjsss());

				}
				
				
				
				if("----".trim()==ce.getDjjjsss().trim()||"----".trim().equals(ce.getDjjjsss().trim())) {
					datas.put("Djjjsss", "");
				}else {
					datas.put("Djjjsss", ce.getDjjjsss());

				}
				
				if("----".trim()==ce.getFjjjsss().trim()||"----".trim().equals(ce.getFjjjsss().trim())) {
					datas.put("Fjjjsss", "");
				}else {
					datas.put("Fjjjsss", ce.getFjjjsss());

				}
				
				
				listData.put("datas", datas);
				
				
			}
			
		}else {
			datas = new TreeMap<String,Object>();
			datas.put("id", "");
			datas.put("Ajjjsss", "");
			datas.put("Bjjjsss", "");
			datas.put("Cjjjsss", "");
			datas.put("Djjjsss", "");
			datas.put("Fjjjsss", "");
			listData.put("datas", datas);
			
		}
		
		request.setAttribute("data", listData);
		model.addAttribute("data", listData);
		
		return "modules/ironfofivesssgl/ironfofivesssglList";
	}

	/**
	 * 查看，增加，编辑5.4手术室表单页面
	 */
	@RequiresPermissions(value={"ironfofivesssgl:ironfofivesssgl:view","ironfofivesssgl:ironfofivesssgl:add","ironfofivesssgl:ironfofivesssgl:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfofivesssgl ironfofivesssgl, Model model) {
		model.addAttribute("ironfofivesssgl", ironfofivesssgl);
		return "modules/ironfofivesssgl/ironfofivesssglForm";
	}

	/**
	 * 保存5.4手术室
	 */
	@RequiresPermissions(value={"ironfofivesssgl:ironfofivesssgl:add","ironfofivesssgl:ironfofivesssgl:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfofivesssgl ironfofivesssgl, Model model, RedirectAttributes redirectAttributes) throws Exception{
		
		boolean isnull=false;
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		
		
		
		Subject subject = SecurityUtils.getSubject();  
		Principal obj = (Principal) subject.getPrincipal();
		
		System.out.println(obj.getId());
		
		
		Map<String,Object> map = new  TreeMap<String,Object>();
		String data = request.getParameter("datas");
		String[] datas = data.split(";");
		
		
		String docId = "";
		for(int i=0;i<datas.length;i++) {
//			if("sbmc".trim()==ironfoemergencyrooms[i].toString().split(":")[0].toString().trim()||"sbmc".trim().equals(ironfoemergencyrooms[i].toString().split(":")[0].toString().trim())) {
//				map.put(ironfoemergencyrooms[i].toString().split(":")[0].toString().trim(), ironfoemergencyrooms[i].toString().split(":")[0].toString().trim().split("=")[0].toString());
//			}else {
				map.put(datas[i].toString().split(":")[0].toString(),datas[i].toString().split(":")[1].toString());
				if("docId" == datas[i].toString().trim().split(":")[0].toString().trim() || "docId".equals(datas[i].toString().trim().split(":")[0].toString().trim())) {
					docId = datas[i].toString().split(":")[1].toString();
				}
				
//			}
			
		}
		
		
		if(docId.toString().trim() == null || "".equals(docId.toString().trim())||docId.toString().trim()=="----".trim()||"----".trim().equals(docId.toString().trim())) {
 			isnull = false;
 			IronfoDocTitle title =  IronfoDocTitle.class.newInstance();
 			title.setRemarks(obj.getId());
 			
 			List<IronfoDocTitle> docList = ironfoDoc_Title_Service.queryforList(title);
 			docId= docList.get(0).getId().toString();
 			
		}else {
			
			ironfofivesssgl.setDoc_id(docId);
			List<Ironfofivesssgl> ironfoList = ironfofivesssglService.queryForList(ironfofivesssgl);
			if(ironfoList.size()>0) {
				isnull = true;
			}else {
				isnull = false;
			}
			
		}
		
		Ironfofivesssgl ironfofivesssgl_data = Ironfofivesssgl.class.newInstance();
		ironfofivesssgl_data.setAjjjsss(map.get("Ajjjsss").toString());
		ironfofivesssgl_data.setBjjjsss(map.get("Bjjjsss").toString());
		ironfofivesssgl_data.setCjjjsss(map.get("Cjjjsss").toString());
		ironfofivesssgl_data.setDjjjsss(map.get("Djjjsss").toString());
		ironfofivesssgl_data.setFjjjsss(map.get("Fjjjsss").toString());
		ironfofivesssgl_data.setDoc_id(docId);
		
		
		
		
		if(isnull == false) {
			//保存
			ironfofivesssglService.save(ironfofivesssgl_data);
		}else if(isnull == true) {
			//更新
			ironfofivesssgl_data.setId(map.get("id").toString());
			ironfofivesssglService.updateIronfo(ironfofivesssgl_data);
			
			
		}
		
		
		
		
		return "redirect:"+Global.getAdminPath()+"/ironfofivesssgl/ironfofivesssgl/?repage";
	}
	
	/**
	 * 删除5.4手术室
	 */
	@RequiresPermissions("ironfofivesssgl:ironfofivesssgl:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfofivesssgl ironfofivesssgl, RedirectAttributes redirectAttributes) {
		ironfofivesssglService.delete(ironfofivesssgl);
		addMessage(redirectAttributes, "删除5.4手术室成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivesssgl/ironfofivesssgl/?repage";
	}
	
	/**
	 * 批量删除5.4手术室
	 */
	@RequiresPermissions("ironfofivesssgl:ironfofivesssgl:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfofivesssglService.delete(ironfofivesssglService.get(id));
		}
		addMessage(redirectAttributes, "删除5.4手术室成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivesssgl/ironfofivesssgl/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfofivesssgl:ironfofivesssgl:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfofivesssgl ironfofivesssgl, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "5.4手术室"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfofivesssgl> page = ironfofivesssglService.findPage(new Page<Ironfofivesssgl>(request, response, -1), ironfofivesssgl);
    		new ExportExcel("5.4手术室", Ironfofivesssgl.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出5.4手术室记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivesssgl/ironfofivesssgl/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfofivesssgl:ironfofivesssgl:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfofivesssgl> list = ei.getDataList(Ironfofivesssgl.class);
			for (Ironfofivesssgl ironfofivesssgl : list){
				try{
					ironfofivesssglService.save(ironfofivesssgl);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条5.4手术室记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条5.4手术室记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入5.4手术室失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivesssgl/ironfofivesssgl/?repage";
    }
	
	/**
	 * 下载导入5.4手术室数据模板
	 */
	@RequiresPermissions("ironfofivesssgl:ironfofivesssgl:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "5.4手术室数据导入模板.xlsx";
    		List<Ironfofivesssgl> list = Lists.newArrayList(); 
    		new ExportExcel("5.4手术室数据", Ironfofivesssgl.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivesssgl/ironfofivesssgl/?repage";
    }
	
	
	

}