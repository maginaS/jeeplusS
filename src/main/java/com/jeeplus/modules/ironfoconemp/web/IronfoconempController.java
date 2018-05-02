/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoconemp.web;

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
import com.jeeplus.modules.ironfoconemp.entity.Ironfoconemp;
import com.jeeplus.modules.ironfoconemp.service.IronfoconempService;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.ironfodoctitle.service.IronfoDocTitleService;
import com.jeeplus.modules.ironfofinance.entity.Ironfofinance;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 2.7.1职工构成Controller
 * @author mikesun
 * @version 2018-03-21
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfoconemp/ironfoconemp")
public class IronfoconempController extends BaseController {

	@Autowired
	private IronfoconempService ironfoconempService;
	

	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	
	@ModelAttribute
	public Ironfoconemp get(@RequestParam(required=false) String id) {
		Ironfoconemp entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfoconempService.get(id);
		}
		if (entity == null){
			entity = new Ironfoconemp();
		}
		return entity;
	}
	
	/**
	 * 2.7.1职工构成列表页面
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	@RequiresPermissions("ironfoconemp:ironfoconemp:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfoconemp ironfoconemp, HttpServletRequest request, HttpServletResponse response, Model model) throws InstantiationException, IllegalAccessException {

		Subject subject = SecurityUtils.getSubject();  
		Principal obj = (Principal) subject.getPrincipal();
		System.out.println(obj.getId());
		
		
		Map<String,Object> datas = new TreeMap<String,Object>();
		IronfoDocTitle title =  IronfoDocTitle.class.newInstance();
		title.setRemarks(obj.getId());
//		title =  ironfoDoc_Title_Service.getDocId(obj.getId());
		List<IronfoDocTitle> docList = ironfoDoc_Title_Service.queryforList(title);
		
		if(docList.size()>0) {
			ironfoconemp.setDoc_id(docList.get(0).getId().toString());
			List<Ironfoconemp> data = ironfoconempService.queryForList(ironfoconemp);
			
			datas.put("doc_id", docList.get(0).getId().toString());
			
			for(int i = 0; i<data.size();i++) {
				if(data.get(i).getDate().toString()=="2015"||"2015".equals(data.get(i).getDate().toString())) {
					datas.put("date", data.get(i).getDate().toString());
					datas.put("id", data.get(i).getId().toString());
					
//					String date ;		// 时间         
					String zzzgs = data.get(i).getZzzgs().toString();		// 在岗职工数（人
					
					if("----"==zzzgs.trim()||"----".equals(zzzgs.trim())) {
						datas.put("zzzgs","");
					}else {
						datas.put("zzzgs",zzzgs);
					}
					String wsjsry = data.get(i).getWsjsry().toString();		// 卫生技术人员
					
					if("----"==wsjsry.trim()||"----".equals(wsjsry.trim())) {
						datas.put("wsjsry","");
					}else {
						datas.put("wsjsry",wsjsry);
					}
					String qtjsry = data.get(i).getQtjsry().toString();		// 其他技术人员
					if("----"==qtjsry.trim()||"----".equals(qtjsry.trim())) {
						datas.put("qtjsry","");
					}else {
						datas.put("qtjsry",qtjsry);
					}
					String glry = data.get(i).getGlry().toString();		// 管理人员（人）
					if("----"==glry.trim()||"----".equals(glry.trim())) {
						datas.put("glry","");
					}else {
						datas.put("glry",glry);
					}
					String gqjnry = data.get(i).getGqjnry().toString();		// 工勤技能人员
					if("----"==gqjnry.trim()||"----".equals(gqjnry.trim())) {
						datas.put("gqjnry","");
					}else {
						datas.put("gqjnry",gqjnry);
					}

					
					
					
					
					
				}else if(data.get(i).getDate().toString()=="2016"||"2016".equals(data.get(i).getDate().toString())) {
					datas.put("date1", data.get(i).getDate().toString());
					datas.put("id1", data.get(i).getId().toString());
					
					
					
					String zzzgs = data.get(i).getZzzgs().toString();		// 在岗职工数（人
					
					if("----"==zzzgs.trim()||"----".equals(zzzgs.trim())) {
						datas.put("zzzgs1","");
					}else {
						datas.put("zzzgs1",zzzgs);
					}
					String wsjsry = data.get(i).getWsjsry().toString();		// 卫生技术人员
					
					if("----"==wsjsry.trim()||"----".equals(wsjsry.trim())) {
						datas.put("wsjsry1","");
					}else {
						datas.put("wsjsry1",wsjsry);
					}
					String qtjsry = data.get(i).getQtjsry().toString();		// 其他技术人员
					if("----"==qtjsry.trim()||"----".equals(qtjsry.trim())) {
						datas.put("qtjsry1","");
					}else {
						datas.put("qtjsry1",qtjsry);
					}
					String glry = data.get(i).getGlry().toString();		// 管理人员（人）
					if("----"==glry.trim()||"----".equals(glry.trim())) {
						datas.put("glry1","");
					}else {
						datas.put("glry1",glry);
					}
					String gqjnry = data.get(i).getGqjnry().toString();		// 工勤技能人员
					if("----"==gqjnry.trim()||"----".equals(gqjnry.trim())) {
						datas.put("gqjnry1","");
					}else {
						datas.put("gqjnry1",gqjnry);
					}
					
					
					

				} else if(data.get(i).getDate().toString()=="2017"||"2017".equals(data.get(i).getDate().toString())) {
					datas.put("date2", data.get(i).getDate().toString());
					datas.put("id2", data.get(i).getId().toString());
					
					
					
					String zzzgs = data.get(i).getZzzgs().toString();		// 在岗职工数（人
					
					if("----"==zzzgs.trim()||"----".equals(zzzgs.trim())) {
						datas.put("zzzgs2","");
					}else {
						datas.put("zzzgs2",zzzgs);
					}
					String wsjsry = data.get(i).getWsjsry().toString();		// 卫生技术人员
					
					if("----"==wsjsry.trim()||"----".equals(wsjsry.trim())) {
						datas.put("wsjsry2","");
					}else {
						datas.put("wsjsry2",wsjsry);
					}
					String qtjsry = data.get(i).getQtjsry().toString();		// 其他技术人员
					if("----"==qtjsry.trim()||"----".equals(qtjsry.trim())) {
						datas.put("qtjsry2","");
					}else {
						datas.put("qtjsry2",qtjsry);
					}
					String glry = data.get(i).getGlry().toString();		// 管理人员（人）
					if("----"==glry.trim()||"----".equals(glry.trim())) {
						datas.put("glry2","");
					}else {
						datas.put("glry2",glry);
					}
					String gqjnry = data.get(i).getGqjnry().toString();		// 工勤技能人员
					if("----"==gqjnry.trim()||"----".equals(gqjnry.trim())) {
						datas.put("gqjnry2","");
					}else {
						datas.put("gqjnry2",gqjnry);
					}
					
					
				}

					
				
			}
			
			
		}else {
			datas.put("zzzgs","");
			datas.put("gqjnry2","");
			datas.put("glry2","");
			datas.put("qtjsry2","");
			datas.put("wsjsry2","");
			datas.put("zzzgs2","");
			datas.put("gqjnry1","");
			datas.put("glry1","");
			datas.put("qtjsry1","");
			datas.put("wsjsry1","");
			datas.put("zzzgs1","");
			datas.put("id2", "");
			datas.put("id1", "");
			datas.put("gqjnry","");
			datas.put("glry","");
			datas.put("qtjsry","");
			datas.put("wsjsry","");
			datas.put("zzzgs","");
			datas.put("id", "");
			
		}
		
		request.setAttribute("data", datas);
		model.addAttribute("data", datas);
		
		//		Page<Ironfoconemp> page = ironfoconempService.findPage(new Page<Ironfoconemp>(request, response), ironfoconemp); 
//		model.addAttribute("page", page);
		return "modules/ironfoconemp/ironfoconempList";
	}

	/**
	 * 查看，增加，编辑2.7.1职工构成表单页面
	 */
	@RequiresPermissions(value={"ironfoconemp:ironfoconemp:view","ironfoconemp:ironfoconemp:add","ironfoconemp:ironfoconemp:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfoconemp ironfoconemp, Model model) {
		model.addAttribute("ironfoconemp", ironfoconemp);
		return "modules/ironfoconemp/ironfoconempForm";
	}

	/**
	 * 保存2.7.1职工构成
	 */
	@RequiresPermissions(value={"ironfoconemp:ironfoconemp:add","ironfoconemp:ironfoconemp:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfoconemp ironfoconemp, Model model, RedirectAttributes redirectAttributes) throws Exception{

		
		
		boolean isnull=false;
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		
		
		
		Subject subject = SecurityUtils.getSubject();  
		Principal obj = (Principal) subject.getPrincipal();
		
		System.out.println(obj.getId());
		
		Map<String,Object> map = new  HashMap<String,Object>();
		String data = request.getParameter("datas");
		String[] ironfoconemps = data.split(";");
		
		
		String docId = "";
		for(int i=0;i<ironfoconemps.length;i++) {
			map.put(ironfoconemps[i].toString().split(":")[0].toString(),ironfoconemps[i].toString().split(":")[1].toString());
			if("docId" == ironfoconemps[i].toString().trim().split(":")[0].toString().trim() || "docId".equals(ironfoconemps[i].toString().trim().split(":")[0].toString().trim())) {
				docId = ironfoconemps[i].toString().split(":")[1].toString();
			}
		}
		
		
		if(docId.toString().trim() == null || "".equals(docId.toString().trim())) {
			
			
 			isnull = false;
 			
 			IronfoDocTitle title =  IronfoDocTitle.class.newInstance();
 			title.setRemarks(obj.getId());
 			
 			List<IronfoDocTitle> docList = ironfoDoc_Title_Service.queryforList(title);
 			docId= docList.get(0).getId().toString();
 			
		}else {
			
			ironfoconemp.setDoc_id(docId);
			List<Ironfoconemp> ironfoList = ironfoconempService.queryForList(ironfoconemp);
			if(ironfoList.size()>0) {
				isnull = true;
			}else {
				isnull = false;
			}
			
		}
		
		
		Ironfoconemp ironfoconemp_2015 = null;
		Ironfoconemp ironfoconemp_2016 = null;
		Ironfoconemp ironfoconemp_2017 = null;
		
		
		if(isnull == false) {
			ironfoconemp_2015 = new Ironfoconemp();
			ironfoconemp_2015.setDate(map.get("date").toString());
			ironfoconemp_2015.setZzzgs(map.get("zzzgs").toString());
			ironfoconemp_2015.setWsjsry(map.get("wsjsry").toString());
			ironfoconemp_2015.setQtjsry(map.get("qtjsry").toString());
			ironfoconemp_2015.setGlry(map.get("glry").toString());
			ironfoconemp_2015.setGqjnry(map.get("gqjnry").toString());
			ironfoconemp_2015.setDoc_id(docId);
			ironfoconempService.save(ironfoconemp_2015);
			
			ironfoconemp_2016 = new Ironfoconemp();
			ironfoconemp_2016.setDate(map.get("date1").toString());
			ironfoconemp_2016.setZzzgs(map.get("zzzgs1").toString());
			ironfoconemp_2016.setWsjsry(map.get("wsjsry1").toString());
			ironfoconemp_2016.setQtjsry(map.get("qtjsry1").toString());
			ironfoconemp_2016.setGlry(map.get("glry1").toString());
			ironfoconemp_2016.setGqjnry(map.get("gqjnry1").toString());
			ironfoconemp_2016.setDoc_id(docId);
			ironfoconempService.save(ironfoconemp_2016);
			
			ironfoconemp_2017 = new Ironfoconemp();
			ironfoconemp_2017.setDate(map.get("date2").toString());
			ironfoconemp_2017.setZzzgs(map.get("zzzgs2").toString());
			ironfoconemp_2017.setWsjsry(map.get("wsjsry2").toString());
			ironfoconemp_2017.setQtjsry(map.get("qtjsry2").toString());
			ironfoconemp_2017.setGlry(map.get("glry2").toString());
			ironfoconemp_2017.setGqjnry(map.get("gqjnry2").toString());
			ironfoconemp_2017.setDoc_id(docId);
			ironfoconempService.save(ironfoconemp_2017);
			
		}else if(isnull == true) {
			
			
			ironfoconemp_2015 = new Ironfoconemp();
			ironfoconemp_2015.setDate(map.get("date").toString());
			ironfoconemp_2015.setZzzgs(map.get("zzzgs").toString());
			ironfoconemp_2015.setWsjsry(map.get("wsjsry").toString());
			ironfoconemp_2015.setQtjsry(map.get("qtjsry").toString());
			ironfoconemp_2015.setGlry(map.get("glry").toString());
			ironfoconemp_2015.setGqjnry(map.get("gqjnry").toString());
			ironfoconemp_2015.setDoc_id(docId);
			ironfoconemp_2015.setId(map.get("id").toString());
			ironfoconempService.save(ironfoconemp_2015);
			
			ironfoconemp_2016 = new Ironfoconemp();
			ironfoconemp_2016.setDate(map.get("date1").toString());
			ironfoconemp_2016.setZzzgs(map.get("zzzgs1").toString());
			ironfoconemp_2016.setWsjsry(map.get("wsjsry1").toString());
			ironfoconemp_2016.setQtjsry(map.get("qtjsry1").toString());
			ironfoconemp_2016.setGlry(map.get("glry1").toString());
			ironfoconemp_2016.setGqjnry(map.get("gqjnry1").toString());
			ironfoconemp_2016.setDoc_id(docId);
			ironfoconemp_2016.setId(map.get("id1").toString());
			ironfoconempService.save(ironfoconemp_2016);
			
			ironfoconemp_2017 = new Ironfoconemp();
			ironfoconemp_2017.setDate(map.get("date2").toString());
			ironfoconemp_2017.setZzzgs(map.get("zzzgs2").toString());
			ironfoconemp_2017.setWsjsry(map.get("wsjsry2").toString());
			ironfoconemp_2017.setQtjsry(map.get("qtjsry2").toString());
			ironfoconemp_2017.setGlry(map.get("glry2").toString());
			ironfoconemp_2017.setGqjnry(map.get("gqjnry2").toString());
			ironfoconemp_2017.setDoc_id(docId);
			ironfoconemp_2017.setId(map.get("id2").toString());
			ironfoconempService.save(ironfoconemp_2017);
			
		}
		addMessage(redirectAttributes, "保存2.7.1职工构成成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoconemp/ironfoconemp/?repage";
	}
	
	/**
	 * 删除2.7.1职工构成
	 */
	@RequiresPermissions("ironfoconemp:ironfoconemp:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfoconemp ironfoconemp, RedirectAttributes redirectAttributes) {
		ironfoconempService.delete(ironfoconemp);
		addMessage(redirectAttributes, "删除2.7.1职工构成成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoconemp/ironfoconemp/?repage";
	}
	
	/**
	 * 批量删除2.7.1职工构成
	 */
	@RequiresPermissions("ironfoconemp:ironfoconemp:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfoconempService.delete(ironfoconempService.get(id));
		}
		addMessage(redirectAttributes, "删除2.7.1职工构成成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoconemp/ironfoconemp/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfoconemp:ironfoconemp:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfoconemp ironfoconemp, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "2.7.1职工构成"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfoconemp> page = ironfoconempService.findPage(new Page<Ironfoconemp>(request, response, -1), ironfoconemp);
    		new ExportExcel("2.7.1职工构成", Ironfoconemp.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出2.7.1职工构成记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoconemp/ironfoconemp/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfoconemp:ironfoconemp:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfoconemp> list = ei.getDataList(Ironfoconemp.class);
			for (Ironfoconemp ironfoconemp : list){
				try{
					ironfoconempService.save(ironfoconemp);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条2.7.1职工构成记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条2.7.1职工构成记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入2.7.1职工构成失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoconemp/ironfoconemp/?repage";
    }
	
	/**
	 * 下载导入2.7.1职工构成数据模板
	 */
	@RequiresPermissions("ironfoconemp:ironfoconemp:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "2.7.1职工构成数据导入模板.xlsx";
    		List<Ironfoconemp> list = Lists.newArrayList(); 
    		new ExportExcel("2.7.1职工构成数据", Ironfoconemp.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoconemp/ironfoconemp/?repage";
    }
	
	
	

}