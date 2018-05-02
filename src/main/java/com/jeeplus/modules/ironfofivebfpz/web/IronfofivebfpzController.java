/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofivebfpz.web;

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
import com.jeeplus.modules.ironfofivebfpz.entity.Ironfofivebfpz;
import com.jeeplus.modules.ironfofivebfpz.service.IronfofivebfpzService;
import com.jeeplus.modules.ironfoinformationhardware.entity.Ironfoinformationhardware;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 5.3病房Controller
 * @author mikesun
 * @version 2018-04-08
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfofivebfpz/ironfofivebfpz")
public class IronfofivebfpzController extends BaseController {

	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	@Autowired
	private IronfofivebfpzService ironfofivebfpzService;
	
	@ModelAttribute
	public Ironfofivebfpz get(@RequestParam(required=false) String id) {
		Ironfofivebfpz entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfofivebfpzService.get(id);
		}
		if (entity == null){
			entity = new Ironfofivebfpz();
		}
		return entity;
	}
	
	/**
	 * 5.3病房列表页面
	 */
	@RequiresPermissions("ironfofivebfpz:ironfofivebfpz:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfofivebfpz ironfofivebfpz, HttpServletRequest request, HttpServletResponse response, Model model) {

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
			ironfofivebfpz.setDoc_id(docList.get(0).getId().toString());
			List<Ironfofivebfpz> data = ironfofivebfpzService.queryForList(ironfofivebfpz);
			
			
			datas.put("doc_id", docList.get(0).getId().toString());
			
			for(Ironfofivebfpz ce : data) {
				
				if("----".trim()==ce.getId().trim()||"----".trim().equals(ce.getId().trim())) {
					datas.put("id", "");
				}else{
					datas.put("id", ce.getId());
				}
				
				
				if("----".trim()==ce.getDcj().trim()||"----".trim().equals(ce.getDcj().trim())) {
					datas.put("dcj", "");
				}else {
					datas.put("dcj", ce.getDcj());
				}
				
				if("----".trim()==ce.getEcj().trim()||"----".trim().equals(ce.getEcj().trim())) {
					datas.put("ecj", "");
				}else {
					datas.put("ecj", ce.getEcj());

				}
				
				if("----".trim()==ce.getScj().trim()||"----".trim().equals(ce.getScj().trim())) {
					datas.put("scj", "");
				}else {
					datas.put("scj", ce.getScj());

				}
				
				if("----".trim()==ce.getFourcj().trim()||"----".trim().equals(ce.getFourcj().trim())) {
					datas.put("fourcj", "");
				}else {
					datas.put("fourcj", ce.getFourcj());

				}
				
				if("----".trim()==ce.getWcj().trim()||"----".trim().equals(ce.getWcj().trim())) {
					datas.put("wcj", "");
				}else {
					datas.put("wcj", ce.getWcj());

				}
				
				if("----".trim()==ce.getLcj().trim()||"----".trim().equals(ce.getLcj().trim())) {
					datas.put("lcj", "");
				}else {
					datas.put("lcj", ce.getLcj());

				}
				
				if("----".trim()==ce.getLcysj().trim()||"----".trim().equals(ce.getLcysj().trim())) {
					datas.put("lcysj", "");
				}else {
					datas.put("lcysj", ce.getLcysj());

				}
				
				if("----".trim()==ce.getViptj().trim()||"----".trim().equals(ce.getViptj().trim())) {
					datas.put("viptj", "");
				}else {
					datas.put("viptj", ce.getViptj());

				}
				
				if("----".trim()==ce.getLzghbfj().trim()||"----".trim().equals(ce.getLzghbfj().trim())) {
					datas.put("lzghbfj", "");
				}else {
					datas.put("lzghbfj", ce.getLzghbfj());

				}
				
				if("----".trim()==ce.getIcuj().trim()||"----".trim().equals(ce.getIcuj().trim())) {
					datas.put("icuj", "");
				}else {
					datas.put("icuj", ce.getIcuj());

				}
				
				if("----".trim()==ce.getNicuj().trim()||"----".trim().equals(ce.getNicuj().trim())) {
					datas.put("nicuj", "");
				}else {
					datas.put("nicuj", ce.getNicuj());

				}
				if("----".trim()==ce.getHszzyzxfwjl().trim()||"----".trim().equals(ce.getHszzyzxfwjl().trim())) {
					datas.put("hszzyzxfwjl", "");
				}else {
					datas.put("hszzyzxfwjl", ce.getHszzyzxfwjl());

				}
				
				
				
				listData.put("datas", datas);
		
				
				
			}
			
			
			
		}else {
			datas = new TreeMap<String,Object>();
			datas.put("id", "");
			datas.put("hszzyzxfwjl", "");
			datas.put("nicuj", "");
			datas.put("icuj", "");
			datas.put("lzghbfj", "");
			datas.put("viptj", "");
			datas.put("lcysj", "");
			datas.put("lcj", "");
			datas.put("wcj", "");
			datas.put("fourcj", "");
			datas.put("scj", "");
			datas.put("ecj", "");
			datas.put("dcj", "");
			listData.put("datas", datas);
		}
		
		
		
		request.setAttribute("data", listData);
		model.addAttribute("data", listData);
		return "modules/ironfofivebfpz/ironfofivebfpzList";
	}

	/**
	 * 查看，增加，编辑5.3病房表单页面
	 */
	@RequiresPermissions(value={"ironfofivebfpz:ironfofivebfpz:view","ironfofivebfpz:ironfofivebfpz:add","ironfofivebfpz:ironfofivebfpz:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfofivebfpz ironfofivebfpz, Model model) {
		model.addAttribute("ironfofivebfpz", ironfofivebfpz);
		return "modules/ironfofivebfpz/ironfofivebfpzForm";
	}

	/**
	 * 保存5.3病房
	 */
	@RequiresPermissions(value={"ironfofivebfpz:ironfofivebfpz:add","ironfofivebfpz:ironfofivebfpz:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfofivebfpz ironfofivebfpz, Model model, RedirectAttributes redirectAttributes) throws Exception{
	
		
		
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
			
			ironfofivebfpz.setDoc_id(docId);
			List<Ironfofivebfpz> ironfoList = ironfofivebfpzService.queryForList(ironfofivebfpz);
			if(ironfoList.size()>0) {
				isnull = true;
			}else {
				isnull = false;
			}
			
		}
		
		Ironfofivebfpz ironfofivebfpz_data = Ironfofivebfpz.class.newInstance();
		ironfofivebfpz_data.setDcj(map.get("dcj").toString());
		ironfofivebfpz_data.setEcj(map.get("ecj").toString());
		ironfofivebfpz_data.setScj(map.get("scj").toString());
		ironfofivebfpz_data.setFourcj(map.get("fourcj").toString());
		ironfofivebfpz_data.setWcj(map.get("wcj").toString());
		ironfofivebfpz_data.setLcj(map.get("lcj").toString());
		ironfofivebfpz_data.setLcysj(map.get("lcysj").toString());
		ironfofivebfpz_data.setViptj(map.get("viptj").toString());
		ironfofivebfpz_data.setLzghbfj(map.get("lzghbfj").toString());
		ironfofivebfpz_data.setIcuj(map.get("icuj").toString());
		ironfofivebfpz_data.setNicuj(map.get("nicuj").toString());
		ironfofivebfpz_data.setHszzyzxfwjl(map.get("hszzyzxfwjl").toString());
		ironfofivebfpz_data.setDoc_id(docId);
		if(isnull == false) {
			//保存
			ironfofivebfpzService.save(ironfofivebfpz_data);
		}else if(isnull == true) {
			//更新
			ironfofivebfpz_data.setId(map.get("id").toString());
			ironfofivebfpzService.updateIronfo(ironfofivebfpz_data);
			
			
		}
		
		
		
		
		
		
		
		return "redirect:"+Global.getAdminPath()+"/ironfofivebfpz/ironfofivebfpz/?repage";
	}
	
	/**
	 * 删除5.3病房
	 */
	@RequiresPermissions("ironfofivebfpz:ironfofivebfpz:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfofivebfpz ironfofivebfpz, RedirectAttributes redirectAttributes) {
		ironfofivebfpzService.delete(ironfofivebfpz);
		addMessage(redirectAttributes, "删除5.3病房成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivebfpz/ironfofivebfpz/?repage";
	}
	
	/**
	 * 批量删除5.3病房
	 */
	@RequiresPermissions("ironfofivebfpz:ironfofivebfpz:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfofivebfpzService.delete(ironfofivebfpzService.get(id));
		}
		addMessage(redirectAttributes, "删除5.3病房成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivebfpz/ironfofivebfpz/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfofivebfpz:ironfofivebfpz:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfofivebfpz ironfofivebfpz, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "5.3病房"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfofivebfpz> page = ironfofivebfpzService.findPage(new Page<Ironfofivebfpz>(request, response, -1), ironfofivebfpz);
    		new ExportExcel("5.3病房", Ironfofivebfpz.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出5.3病房记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivebfpz/ironfofivebfpz/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfofivebfpz:ironfofivebfpz:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfofivebfpz> list = ei.getDataList(Ironfofivebfpz.class);
			for (Ironfofivebfpz ironfofivebfpz : list){
				try{
					ironfofivebfpzService.save(ironfofivebfpz);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条5.3病房记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条5.3病房记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入5.3病房失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivebfpz/ironfofivebfpz/?repage";
    }
	
	/**
	 * 下载导入5.3病房数据模板
	 */
	@RequiresPermissions("ironfofivebfpz:ironfofivebfpz:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "5.3病房数据导入模板.xlsx";
    		List<Ironfofivebfpz> list = Lists.newArrayList(); 
    		new ExportExcel("5.3病房数据", Ironfofivebfpz.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivebfpz/ironfofivebfpz/?repage";
    }
	
	
	

}