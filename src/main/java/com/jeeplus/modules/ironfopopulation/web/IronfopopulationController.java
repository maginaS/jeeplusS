/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfopopulation.web;

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
import com.jeeplus.modules.ironfo_yjbylsbpz_pfk.entity.Ironfo_yjbylsbpz_pfk;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.ironfodoctitle.service.IronfoDocTitleService;
import com.jeeplus.modules.ironfopopulation.entity.Ironfopopulation;
import com.jeeplus.modules.ironfopopulation.service.IronfopopulationService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;
import com.jeeplus.modules.tools.utils.EnumUtils;

/**
 * 5.1.1建筑总体概况Controller
 * @author mikesun
 * @version 2018-03-22
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfopopulation/ironfopopulation")
public class IronfopopulationController extends BaseController {

	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	
	@Autowired
	private IronfopopulationService ironfopopulationService;
	
	@ModelAttribute
	public Ironfopopulation get(@RequestParam(required=false) String id) {
		Ironfopopulation entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfopopulationService.get(id);
		}
		if (entity == null){
			entity = new Ironfopopulation();
		}
		return entity;
	}
	
	/**
	 * 5.1.1建筑总体概况列表页面
	 */
	@RequiresPermissions("ironfopopulation:ironfopopulation:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfopopulation ironfopopulation, HttpServletRequest request, HttpServletResponse response, Model model) {
		
		
		Subject subject = SecurityUtils.getSubject();  
		Principal obj = (Principal) subject.getPrincipal();
		System.out.println(obj.getId());
		
		
		
		
		
		Map<String,Object> listData = new HashMap<String,Object>();
//		List<Object> listData = new ArrayList<Object>();
		Map<String,Object> datas = null;
		
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
		List<IronfoDocTitle> docList = ironfoDoc_Title_Service.queryforList(title);
		if(docList.size()>0) {
			
			ironfopopulation.setDoc_id(docList.get(0).getId().toString());
			List<Ironfopopulation> data = ironfopopulationService.queryForList(ironfopopulation);
			
			if(data.size()>0) {
				
				
				
				listData.put("doc_id", docList.get(0).getId().toString());
				
				
				for(Ironfopopulation n : data ) {
					
					datas = new TreeMap<String, Object>();
					
					if("----".trim()==n.getId().toString().trim()||"----".trim().equals(n.getId().toString().trim())) {
						datas.put("id", "");
					}else{
						datas.put("id",n.getId().toString());
					}
					
					
					
					if("----".trim()==n.getDtjzsl().toString().trim()||"----".trim().equals(n.getDtjzsl().toString().trim())) {
						datas.put("dtjzsl", "");
					}else{
						datas.put("dtjzsl",n.getDtjzsl().toString());
					}
					
					
					
					if("----".trim()==n.getDxjzmj().toString().trim()||"----".trim().equals(n.getDxjzmj().toString().trim())) {
						datas.put("dxjzmj", "");
					}else{
						datas.put("dxjzmj",n.getDxjzmj().toString());
					}
					
					
					if("----".trim()==n.getJzgd().toString().trim()||"----".trim().equals(n.getJzgd().toString().trim())) {
						datas.put("jzgd", "");
					}else{
						datas.put("jzgd",n.getJzgd().toString());
					}
					
					
					if("----".trim()==n.getZjzmj().toString().trim()||"----".trim().equals(n.getZjzmj().toString().trim())) {
						datas.put("zjzmj", "");
					}else{
						datas.put("zjzmj",data.get(0).getZjzmj().toString());
					}
					
					
				}
				
				
				listData.put("datas", datas);
				
				
			}else {
				
				datas = new TreeMap<String,Object>();
				datas.put("id", "");
				datas.put("dtjzsl", "");
				datas.put("dxjzmj", "");
				datas.put("jzgd", "");
				datas.put("zjzmj", "");
				listData.put("datas", datas);
				
				
				
			}
			
			
		}else {
			
			datas = new TreeMap<String,Object>();
			datas.put("id", "");
			datas.put("dtjzsl", "");
			datas.put("dxjzmj", "");
			datas.put("jzgd", "");
			datas.put("zjzmj", "");
			listData.put("datas", datas);
			
			
		}
		
		request.setAttribute("data", listData);
		model.addAttribute("data", listData);
		return "modules/ironfopopulation/ironfopopulationList";
	}

	/**
	 * 查看，增加，编辑5.1.1建筑总体概况表单页面
	 */
	@RequiresPermissions(value={"ironfopopulation:ironfopopulation:view","ironfopopulation:ironfopopulation:add","ironfopopulation:ironfopopulation:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfopopulation ironfopopulation, Model model) {
		model.addAttribute("ironfopopulation", ironfopopulation);
		return "modules/ironfopopulation/ironfopopulationForm";
	}

	/**
	 * 保存5.1.1建筑总体概况
	 */
	@RequiresPermissions(value={"ironfopopulation:ironfopopulation:add","ironfopopulation:ironfopopulation:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfopopulation ironfopopulation, Model model, RedirectAttributes redirectAttributes) throws Exception{
		
		
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
				map.put(datas[i].toString().split(":")[0].toString(),datas[i].toString().split(":")[1].toString());
				if("docId" == datas[i].toString().trim().split(":")[0].toString().trim() || "docId".equals(datas[i].toString().trim().split(":")[0].toString().trim())) {
					docId = datas[i].toString().split(":")[1].toString();
				}
		}
		
		
		if(docId.toString().trim() == null || "".equals(docId.toString().trim())||"----".trim()==docId.toString().trim()||"----".trim().equals(docId.toString().trim())) {
 			isnull = false;
 			IronfoDocTitle title =  IronfoDocTitle.class.newInstance();
 			title.setRemarks(obj.getId());
 			
 			List<IronfoDocTitle> docList = ironfoDoc_Title_Service.queryforList(title);
 			docId= docList.get(0).getId().toString();
 			
		}else {
			ironfopopulation.setDoc_id(docId);
			List<Ironfopopulation> ironfoList = ironfopopulationService.queryForList(ironfopopulation);
			if(ironfoList.size()>0) {
				isnull = true;
			}else {
				isnull = false;
			}
		}
		
		
		Ironfopopulation ironfopopulation_data=null;
		ironfopopulation_data = Ironfopopulation.class.newInstance();
		ironfopopulation_data.setDtjzsl(map.get("dtjzsl").toString());
		ironfopopulation_data.setDxjzmj(map.get("dxjzmj").toString());
		ironfopopulation_data.setJzgd(map.get("jzgd").toString());
		ironfopopulation_data.setZjzmj(map.get("zjzmj").toString());
		ironfopopulation_data.setDoc_id(docId.toString());
		if(isnull==false) {
			//保存
			ironfopopulationService.save(ironfopopulation_data);
		}else if(isnull==true){
			//更新
			ironfopopulation_data.setId(map.get("id").toString());
			ironfopopulationService.updateIronfo(ironfopopulation_data);
			
		}
		
	
		
		
		
		return "redirect:"+Global.getAdminPath()+"/ironfopopulation/ironfopopulation/?repage";
	}
	
	/**
	 * 删除5.1.1建筑总体概况
	 */
	@RequiresPermissions("ironfopopulation:ironfopopulation:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfopopulation ironfopopulation, RedirectAttributes redirectAttributes) {
		ironfopopulationService.delete(ironfopopulation);
		addMessage(redirectAttributes, "删除5.1.1建筑总体概况成功");
		return "redirect:"+Global.getAdminPath()+"/ironfopopulation/ironfopopulation/?repage";
	}
	
	/**
	 * 批量删除5.1.1建筑总体概况
	 */
	@RequiresPermissions("ironfopopulation:ironfopopulation:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfopopulationService.delete(ironfopopulationService.get(id));
		}
		addMessage(redirectAttributes, "删除5.1.1建筑总体概况成功");
		return "redirect:"+Global.getAdminPath()+"/ironfopopulation/ironfopopulation/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfopopulation:ironfopopulation:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfopopulation ironfopopulation, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "5.1.1建筑总体概况"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfopopulation> page = ironfopopulationService.findPage(new Page<Ironfopopulation>(request, response, -1), ironfopopulation);
    		new ExportExcel("5.1.1建筑总体概况", Ironfopopulation.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出5.1.1建筑总体概况记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfopopulation/ironfopopulation/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfopopulation:ironfopopulation:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfopopulation> list = ei.getDataList(Ironfopopulation.class);
			for (Ironfopopulation ironfopopulation : list){
				try{
					ironfopopulationService.save(ironfopopulation);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条5.1.1建筑总体概况记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条5.1.1建筑总体概况记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入5.1.1建筑总体概况失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfopopulation/ironfopopulation/?repage";
    }
	
	/**
	 * 下载导入5.1.1建筑总体概况数据模板
	 */
	@RequiresPermissions("ironfopopulation:ironfopopulation:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "5.1.1建筑总体概况数据导入模板.xlsx";
    		List<Ironfopopulation> list = Lists.newArrayList(); 
    		new ExportExcel("5.1.1建筑总体概况数据", Ironfopopulation.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfopopulation/ironfopopulation/?repage";
    }
	
	
	

}