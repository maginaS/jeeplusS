/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoinformationhardware.web;

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
import com.jeeplus.modules.ironfoinformationexperience.entity.Ironfoinformationexperience;
import com.jeeplus.modules.ironfoinformationhardware.entity.Ironfoinformationhardware;
import com.jeeplus.modules.ironfoinformationhardware.service.IronfoinformationhardwareService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 4.5信息化系统配套硬件Controller
 * @author mikesun
 * @version 2018-03-22
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfoinformationhardware/ironfoinformationhardware")
public class IronfoinformationhardwareController extends BaseController {

	

	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	
	@Autowired
	private IronfoinformationhardwareService ironfoinformationhardwareService;
	
	@ModelAttribute
	public Ironfoinformationhardware get(@RequestParam(required=false) String id) {
		Ironfoinformationhardware entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfoinformationhardwareService.get(id);
		}
		if (entity == null){
			entity = new Ironfoinformationhardware();
		}
		return entity;
	}
	
	/**
	 * 4.5信息化系统配套硬件列表页面
	 */
	@RequiresPermissions("ironfoinformationhardware:ironfoinformationhardware:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfoinformationhardware ironfoinformationhardware, HttpServletRequest request, HttpServletResponse response, Model model) {


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
			ironfoinformationhardware.setDoc_id(docList.get(0).getId().toString());
			List<Ironfoinformationhardware> data = ironfoinformationhardwareService.queryForList(ironfoinformationhardware);
			listData.put("doc_id", docList.get(0).getId().toString());
			for(Ironfoinformationhardware ce : data) {
				datas = new TreeMap<String,Object>();
				
				
				if("----".trim()==ce.getId().trim()||"----".trim().equals(ce.getId().trim())) {
					datas.put("id", "");
				}else{
					datas.put("id", ce.getId());
				}
				
				if("----".trim()==ce.getFwq().trim()||"----".trim().equals(ce.getFwq().trim())) {
					datas.put("fwq", "");
				}else {
					datas.put("fwq", ce.getFwq());
				}
				
				if("----".trim()==ce.getXtjfmj().trim()||"----".trim().equals(ce.getXtjfmj().trim())) {
					datas.put("xtjfmj", "");
				}else {
					datas.put("xtjfmj", ce.getXtjfmj());

				}
				
				if("----".trim() == ce.getXxxtjf().trim()||"----".trim().equals(ce.getXxxtjf().trim())) {
					datas.put("xxxtjf", "1");
				}else {
					datas.put("xxxtjf", ce.getXxxtjf());

				}
				
				listData.put("datas", datas);

				
			}
			
		}else {
			datas = new TreeMap<String,Object>();
			datas.put("id", "");
			datas.put("xxxtjf", "");
			datas.put("xtjfmj", "");
			datas.put("fwq", "");
			listData.put("datas", datas);
			
		}
		
		
		request.setAttribute("data", listData);
		model.addAttribute("data", listData);
		
		
		return "modules/ironfoinformationhardware/ironfoinformationhardwareList";
	}

	/**
	 * 查看，增加，编辑4.5信息化系统配套硬件表单页面
	 */
	@RequiresPermissions(value={"ironfoinformationhardware:ironfoinformationhardware:view","ironfoinformationhardware:ironfoinformationhardware:add","ironfoinformationhardware:ironfoinformationhardware:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfoinformationhardware ironfoinformationhardware, Model model) {
		model.addAttribute("ironfoinformationhardware", ironfoinformationhardware);
		return "modules/ironfoinformationhardware/ironfoinformationhardwareForm";
	}

	/**
	 * 保存4.5信息化系统配套硬件
	 */
	@RequiresPermissions(value={"ironfoinformationhardware:ironfoinformationhardware:add","ironfoinformationhardware:ironfoinformationhardware:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfoinformationhardware ironfoinformationhardware, Model model, RedirectAttributes redirectAttributes) throws Exception{
	
		
		boolean isnull=false;
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		
		
		
		Subject subject = SecurityUtils.getSubject();  
		Principal obj = (Principal) subject.getPrincipal();
		
		System.out.println(obj.getId());
		
		
		Map<String,Object> map = new  TreeMap<String,Object>();
		String data = request.getParameter("datas");
		String docId = request.getParameter("docId");
		String id = request.getParameter("id");
		String[] ironfoinformationexperiences = data.split(";");
		
		
//		String docId = "";
		for(int i=0;i<ironfoinformationexperiences.length;i++) {
//			if("sbmc".trim()==ironfoemergencyrooms[i].toString().split(":")[0].toString().trim()||"sbmc".trim().equals(ironfoemergencyrooms[i].toString().split(":")[0].toString().trim())) {
//				map.put(ironfoemergencyrooms[i].toString().split(":")[0].toString().trim(), ironfoemergencyrooms[i].toString().split(":")[0].toString().trim().split("=")[0].toString());
//			}else {
				map.put(ironfoinformationexperiences[i].toString().split(":")[0].toString(),ironfoinformationexperiences[i].toString().split(":")[1].toString());
				if("docId" == ironfoinformationexperiences[i].toString().trim().split(":")[0].toString().trim() || "docId".equals(ironfoinformationexperiences[i].toString().trim().split(":")[0].toString().trim())) {
					docId = ironfoinformationexperiences[i].toString().split(":")[1].toString();
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
			
			ironfoinformationhardware.setDoc_id(docId);
			List<Ironfoinformationhardware> ironfoList = ironfoinformationhardwareService.queryForList(ironfoinformationhardware);
			if(ironfoList.size()>0) {
				isnull = true;
			}else {
				isnull = false;
			}
			
		}
		
		
		Ironfoinformationhardware ironfoinformationhardware_data = Ironfoinformationhardware.class.newInstance();
		ironfoinformationhardware_data.setDoc_id(docId);
		ironfoinformationhardware_data.setXtjfmj(map.get("xtjfmj").toString());
		ironfoinformationhardware_data.setXxxtjf(map.get("xxxtjf").toString());
		ironfoinformationhardware_data.setFwq(map.get("fwq").toString());
		
		
		if(isnull == false) {
			
			//保存
			ironfoinformationhardwareService.save(ironfoinformationhardware_data);
		}else if(isnull == true) {
			
			//更新
			ironfoinformationhardware_data.setId(id);
			ironfoinformationhardwareService.updateIronfo(ironfoinformationhardware_data);
			
		}
		
		
		
		
		return "redirect:"+Global.getAdminPath()+"/ironfoinformationhardware/ironfoinformationhardware/?repage";
	}
	
	/**
	 * 删除4.5信息化系统配套硬件
	 */
	@RequiresPermissions("ironfoinformationhardware:ironfoinformationhardware:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfoinformationhardware ironfoinformationhardware, RedirectAttributes redirectAttributes) {
		ironfoinformationhardwareService.delete(ironfoinformationhardware);
		addMessage(redirectAttributes, "删除4.5信息化系统配套硬件成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoinformationhardware/ironfoinformationhardware/?repage";
	}
	
	/**
	 * 批量删除4.5信息化系统配套硬件
	 */
	@RequiresPermissions("ironfoinformationhardware:ironfoinformationhardware:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfoinformationhardwareService.delete(ironfoinformationhardwareService.get(id));
		}
		addMessage(redirectAttributes, "删除4.5信息化系统配套硬件成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoinformationhardware/ironfoinformationhardware/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfoinformationhardware:ironfoinformationhardware:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfoinformationhardware ironfoinformationhardware, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "4.5信息化系统配套硬件"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfoinformationhardware> page = ironfoinformationhardwareService.findPage(new Page<Ironfoinformationhardware>(request, response, -1), ironfoinformationhardware);
    		new ExportExcel("4.5信息化系统配套硬件", Ironfoinformationhardware.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出4.5信息化系统配套硬件记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoinformationhardware/ironfoinformationhardware/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfoinformationhardware:ironfoinformationhardware:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfoinformationhardware> list = ei.getDataList(Ironfoinformationhardware.class);
			for (Ironfoinformationhardware ironfoinformationhardware : list){
				try{
					ironfoinformationhardwareService.save(ironfoinformationhardware);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条4.5信息化系统配套硬件记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条4.5信息化系统配套硬件记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入4.5信息化系统配套硬件失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoinformationhardware/ironfoinformationhardware/?repage";
    }
	
	/**
	 * 下载导入4.5信息化系统配套硬件数据模板
	 */
	@RequiresPermissions("ironfoinformationhardware:ironfoinformationhardware:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "4.5信息化系统配套硬件数据导入模板.xlsx";
    		List<Ironfoinformationhardware> list = Lists.newArrayList(); 
    		new ExportExcel("4.5信息化系统配套硬件数据", Ironfoinformationhardware.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoinformationhardware/ironfoinformationhardware/?repage";
    }
	
	
	

}