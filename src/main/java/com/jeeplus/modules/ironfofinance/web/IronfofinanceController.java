/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofinance.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
import com.jeeplus.modules.ironfofinance.service.IronfofinanceService;
import com.jeeplus.modules.ironfomedicalservices.entity.IronfoMedicalServices;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 2.2财务收支Controller
 * @author mikesun
 * @version 2018-03-16
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfofinance/ironfofinance")
public class IronfofinanceController extends BaseController {

	@Autowired
	private IronfofinanceService ironfofinanceService;
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	@ModelAttribute
	public Ironfofinance get(@RequestParam(required=false) String id) {
		Ironfofinance entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfofinanceService.get(id);
		}
		if (entity == null){
			entity = new Ironfofinance();
		}
		return entity;
	}
	
	/**
	 * 2.2财务收支列表页面
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	@RequiresPermissions("ironfofinance:ironfofinance:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfofinance ironfofinance, HttpServletRequest request, HttpServletResponse response, Model model) throws InstantiationException, IllegalAccessException {
		
		
		
		Subject subject = SecurityUtils.getSubject();  
		Principal obj = (Principal) subject.getPrincipal();
		System.out.println(obj.getId());
		
		
		Map<String,Object> datas = new TreeMap<String,Object>();
		IronfoDocTitle title =  IronfoDocTitle.class.newInstance();
		title.setRemarks(obj.getId());
//		title =  ironfoDoc_Title_Service.getDocId(obj.getId());
		List<IronfoDocTitle> docList = ironfoDoc_Title_Service.queryforList(title);
		
		
		
		if(docList.size()>0) {
			ironfofinance.setDoc_id(docList.get(0).getId().toString());
			List<Ironfofinance> data = ironfofinanceService.queryForList(ironfofinance);
			
			
			datas.put("doc_id", docList.get(0).getId().toString());
			for(int i = 0; i<data.size();i++) {
				if(data.get(i).getDate().toString()=="2015"||"2015".equals(data.get(i).getDate().toString())) {
					
					
					datas.put("date", data.get(i).getDate().toString());
					datas.put("id", data.get(i).getId().toString());
					
					String ylsr = data.get(i).getYlsr().toString().trim();
					if("----"==ylsr.trim()||"----".equals(ylsr.trim())) {
						datas.put("ylsr","");
					}else {
						datas.put("ylsr",ylsr);
					}
					String ypsr = data.get(i).getYpsr().toString().trim();
					if("----"==ypsr.trim()||"----".equals(ypsr.trim())) {
						datas.put("ypsr","");
					}else {
						datas.put("ypsr",ypsr);
					}
					String sfbtsr = data.get(i).getSfbtsr().toString().trim();
					if("----"==sfbtsr.trim()||"----".equals(sfbtsr.trim())) {
						datas.put("sfbtsr","");
					}else {
						datas.put("sfbtsr",sfbtsr);
					}
					String sjbzsr = data.get(i).getSjbzsr().toString().trim();
					if("----"==sjbzsr.trim()||"----".equals(sjbzsr.trim())) {
						datas.put("sjbzsr","");
					}else {
						datas.put("sjbzsr",sjbzsr);
					}
					
					String qtsr = data.get(i).getQtsr().toString().trim();
					
					if("----"==qtsr.trim()||"----".equals(qtsr.trim())) {
						datas.put("qtsr","");
					}else {
						datas.put("qtsr",qtsr);
					}
					
					String zzc = data.get(i).getZzc().toString().trim();
					if("----"==zzc.trim()||"----".equals(zzc.trim())) {
						datas.put("zzc","");
					}else {
						datas.put("zzc",zzc);
					}
					
					String ylzc = data.get(i).getYlzc().toString().trim();
					if("----"==ylzc.trim()||"----".equals(ylzc.trim())) {
						datas.put("ylzc","");
					}else {
						datas.put("ylzc",ylzc);
					}
					
				}else if(data.get(i).getDate().toString()=="2016"||"2016".equals(data.get(i).getDate().toString())) {


					
					datas.put("date1", data.get(i).getDate().toString());
					datas.put("id1", data.get(i).getId().toString());
					
					String ylsr = data.get(i).getYlsr().toString().trim();
					if("----"==ylsr.trim()||"----".equals(ylsr.trim())) {
						datas.put("ylsr1","");
					}else {
						datas.put("ylsr1",ylsr);
					}
					String ypsr = data.get(i).getYpsr().toString().trim();
					if("----"==ypsr.trim()||"----".equals(ypsr.trim())) {
					
						datas.put("ypsr1","");
					}else {
						datas.put("ypsr1",ypsr);
					}
					String sfbtsr = data.get(i).getSfbtsr().toString().trim();
					if("----"==sfbtsr.trim()||"----".equals(sfbtsr.trim())) {
						datas.put("sfbtsr1","");
					}else {
						datas.put("sfbtsr1",sfbtsr);
					}
					String sjbzsr = data.get(i).getSjbzsr().toString().trim();
					if("----"==sjbzsr.trim()||"----".equals(sjbzsr.trim())) {
						datas.put("sjbzsr1","");
					}else {
						datas.put("sjbzsr1",sjbzsr);
					}
					
					String qtsr = data.get(i).getQtsr().toString().trim();
					
					if("----"==qtsr.trim()||"----".equals(qtsr.trim())) {
						datas.put("qtsr1","");
					}else {
						datas.put("qtsr1",qtsr);
					}
					
					String zzc = data.get(i).getZzc().toString().trim();
					if("----"==zzc.trim()||"----".equals(zzc.trim())) {
						datas.put("zzc1","");
					}else {
						datas.put("zzc1",zzc);
					}
					
					String ylzc = data.get(i).getYlzc().toString().trim();
					if("----"==ylzc.trim()||"----".equals(ylzc.trim())) {
						datas.put("ylzc1","");
					}else {
						datas.put("ylzc1",ylzc);
					}
				} else if(data.get(i).getDate().toString()=="2017"||"2017".equals(data.get(i).getDate().toString())) {
					
					
					

					datas.put("date2", data.get(i).getDate().toString());
					datas.put("id2", data.get(i).getId().toString());
					
					String ylsr = data.get(i).getYlsr().toString().trim();
					if("----"==ylsr.trim()||"----".equals(ylsr.trim())) {
						datas.put("ylsr2","");
					}else {
						datas.put("ylsr2",ylsr);
					}
					String ypsr = data.get(i).getYpsr().toString().trim();
					if("----"==ypsr.trim()||"----".equals(ypsr.trim())) {
						datas.put("ypsr2","");
					}else {
						datas.put("ypsr2",ypsr);
					}
					String sfbtsr = data.get(i).getSfbtsr().toString().trim();
					if("----"==sfbtsr.trim()||"----".equals(sfbtsr.trim())) {
						datas.put("sfbtsr2","");
					}else {
						datas.put("sfbtsr2",sfbtsr);
					}
					String sjbzsr = data.get(i).getSjbzsr().toString().trim();
					if("----"==sjbzsr.trim()||"----".equals(sjbzsr.trim())) {
						datas.put("sjbzsr2","");
					}else {
						datas.put("sjbzsr2",sjbzsr);
					}
					
					String qtsr = data.get(i).getQtsr().toString().trim();
					
					if("----"==qtsr.trim()||"----".equals(qtsr.trim())) {
						datas.put("qtsr2","");
					}else {
						datas.put("qtsr2",qtsr);
					}
					
					String zzc = data.get(i).getZzc().toString().trim();
					if("----"==zzc.trim()||"----".equals(zzc.trim())) {
						datas.put("zzc2","");
					}else {
						datas.put("zzc2",zzc);
					}
					
					String ylzc = data.get(i).getYlzc().toString().trim();
					if("----"==ylzc.trim()||"----".equals(ylzc.trim())) {
						datas.put("ylzc2","");
					}else {
						datas.put("ylzc2",ylzc);
					}
					
					
				}


				
				
			}
			

			
		}else {
//		
			
			datas.put("id","");
			datas.put("ylsr","");
			datas.put("ypsr","");
			datas.put("sfbtsr","");
			datas.put("sjbzsr","");
			datas.put("qtsr","");
			datas.put("zzc","");
			datas.put("ylzc","");
			datas.put("date","");
			
			datas.put("id1","");
			datas.put("date1","");
			datas.put("ylzc1","");
			datas.put("zzc1","");
			datas.put("qtsr1","");
			datas.put("sjbzsr1","");
			datas.put("sfbtsr1","");
			datas.put("ypsr1","");
			datas.put("ylsr1","");
			
			datas.put("doc_id","");
			datas.put("ylzc2","");
			datas.put("zzc2","");
			datas.put("qtsr2","");
			datas.put("sjbzsr2","");
			datas.put("sfbtsr2","");
			datas.put("ypsr2","");
			datas.put("date2", "");
			datas.put("id2","");
			
			
			
		}
		request.setAttribute("data", datas);
		model.addAttribute("data", datas);
		
		return "modules/ironfofinance/ironfofinanceList";
	}

	/**
	 * 查看，增加，编辑2.2财务收支表单页面
	 */
	@RequiresPermissions(value={"ironfofinance:ironfofinance:view","ironfofinance:ironfofinance:add","ironfofinance:ironfofinance:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfofinance ironfofinance, Model model) {
		model.addAttribute("ironfofinance", ironfofinance);
		return "modules/ironfofinance/ironfofinanceForm";
	}

	/**
	 * 保存2.2财务收支
	 */
	@RequiresPermissions(value={"ironfofinance:ironfofinance:add","ironfofinance:ironfofinance:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfofinance ironfofinance, Model model, RedirectAttributes redirectAttributes) throws Exception{

		
		
		boolean isnull=false;
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		
		
		
		Subject subject = SecurityUtils.getSubject();  
		Principal obj = (Principal) subject.getPrincipal();
		
		System.out.println(obj.getId());
		
		Map<String,Object> map = new  HashMap<String,Object>();
		String data = request.getParameter("datas");
		String[] ironfofinances = data.split(";");
		
		
		String docId = "";
		for(int i=0;i<ironfofinances.length;i++) {
			map.put(ironfofinances[i].toString().split(":")[0].toString(),ironfofinances[i].toString().split(":")[1].toString());
			if("docId" == ironfofinances[i].toString().trim().split(":")[0].toString().trim() || "docId".equals(ironfofinances[i].toString().trim().split(":")[0].toString().trim())) {
				docId = ironfofinances[i].toString().split(":")[1].toString();
			}
		}
		
		
		if(docId.toString().trim() == null || "".equals(docId.toString().trim())) {
			
			
 			isnull = false;
 			
 			IronfoDocTitle title =  IronfoDocTitle.class.newInstance();
 			title.setRemarks(obj.getId());
 			
 			List<IronfoDocTitle> docList = ironfoDoc_Title_Service.queryforList(title);
 			docId= docList.get(0).getId().toString();
 			
		}else {
			
			ironfofinance.setDoc_id(docId);
			List<Ironfofinance> ironfoList = ironfofinanceService.queryForList(ironfofinance);
			if(ironfoList.size()>0) {
				isnull = true;
			}else {
				isnull = false;
			}
			
		}
		
		Ironfofinance ironfofinance_2015 = null;
		Ironfofinance ironfofinance_2016 = null;
		Ironfofinance ironfofinance_2017 = null;
		
		
		if(isnull == false) {
			//2015
			ironfofinance_2015 = new Ironfofinance();
			ironfofinance_2015.setDate(map.get("date").toString());
			ironfofinance_2015.setYlsr(map.get("ylsr").toString());
			ironfofinance_2015.setYpsr(map.get("ypsr").toString());
			ironfofinance_2015.setSfbtsr(map.get("sfbtsr").toString());
			ironfofinance_2015.setSjbzsr(map.get("sjbzsr").toString());
			ironfofinance_2015.setQtsr(map.get("qtsr").toString());
			ironfofinance_2015.setZzc(map.get("zzc").toString());
			ironfofinance_2015.setYlzc(map.get("ylzc").toString());
			ironfofinance_2015.setDoc_id(docId);
			
			ironfofinanceService.save(ironfofinance_2015);
			//2016
			ironfofinance_2016 =  new Ironfofinance();
			ironfofinance_2016.setDate(map.get("date1").toString());
			ironfofinance_2016.setYlsr(map.get("ylsr1").toString());
			ironfofinance_2016.setYpsr(map.get("ypsr1").toString());
			ironfofinance_2016.setSfbtsr(map.get("sfbtsr1").toString());
			ironfofinance_2016.setSjbzsr(map.get("sjbzsr1").toString());
			ironfofinance_2016.setQtsr(map.get("qtsr1").toString());
			ironfofinance_2016.setZzc(map.get("zzc1").toString());
			ironfofinance_2016.setYlzc(map.get("ylzc1").toString());
			ironfofinance_2016.setDoc_id(docId);
			
			ironfofinanceService.save(ironfofinance_2016);
			
			//2017
			ironfofinance_2017 = new Ironfofinance();
			ironfofinance_2017 =  new Ironfofinance();
			ironfofinance_2017.setDate(map.get("date2").toString());
			ironfofinance_2017.setYlsr(map.get("ylsr2").toString());
			ironfofinance_2017.setYpsr(map.get("ypsr2").toString());
			ironfofinance_2017.setSfbtsr(map.get("sfbtsr2").toString());
			ironfofinance_2017.setSjbzsr(map.get("sjbzsr2").toString());
			ironfofinance_2017.setQtsr(map.get("qtsr2").toString());
			ironfofinance_2017.setZzc(map.get("zzc2").toString());
			ironfofinance_2017.setYlzc(map.get("ylzc2").toString());
			ironfofinance_2017.setDoc_id(docId);
			ironfofinanceService.save(ironfofinance_2017);
		}else if(isnull == true){
			
			ironfofinance_2015 = new Ironfofinance();
			ironfofinance_2015.setDate(map.get("date").toString());
			ironfofinance_2015.setYlsr(map.get("ylsr").toString());
			ironfofinance_2015.setYpsr(map.get("ypsr").toString());
			ironfofinance_2015.setSfbtsr(map.get("sfbtsr").toString());
			ironfofinance_2015.setSjbzsr(map.get("sjbzsr").toString());
			ironfofinance_2015.setQtsr(map.get("qtsr").toString());
			ironfofinance_2015.setZzc(map.get("zzc").toString());
			ironfofinance_2015.setYlzc(map.get("ylzc").toString());
			ironfofinance_2015.setDoc_id(docId);
			ironfofinance_2015.setId(map.get("id").toString());
			ironfofinanceService.updateIronfo(ironfofinance_2015);
			
			ironfofinance_2016 =  new Ironfofinance();
			ironfofinance_2016.setDate(map.get("date1").toString());
			ironfofinance_2016.setYlsr(map.get("ylsr1").toString());
			ironfofinance_2016.setYpsr(map.get("ypsr1").toString());
			ironfofinance_2016.setSfbtsr(map.get("sfbtsr1").toString());
			ironfofinance_2016.setSjbzsr(map.get("sjbzsr1").toString());
			ironfofinance_2016.setQtsr(map.get("qtsr1").toString());
			ironfofinance_2016.setZzc(map.get("zzc1").toString());
			ironfofinance_2016.setYlzc(map.get("ylzc1").toString());
			ironfofinance_2016.setDoc_id(docId);
			ironfofinance_2016.setId(map.get("id1").toString());
			ironfofinanceService.updateIronfo(ironfofinance_2016);
			//2017
			ironfofinance_2017 = new Ironfofinance();
			ironfofinance_2017.setDate(map.get("date2").toString());
			ironfofinance_2017.setYlsr(map.get("ylsr2").toString());
			ironfofinance_2017.setYpsr(map.get("ypsr2").toString());
			ironfofinance_2017.setSfbtsr(map.get("sfbtsr2").toString());
			ironfofinance_2017.setSjbzsr(map.get("sjbzsr2").toString());
			ironfofinance_2017.setQtsr(map.get("qtsr2").toString());
			ironfofinance_2017.setZzc(map.get("zzc2").toString());
			ironfofinance_2017.setYlzc(map.get("ylzc2").toString());
			ironfofinance_2017.setDoc_id(docId);
			ironfofinance_2017.setId(map.get("id2").toString());
			ironfofinanceService.updateIronfo(ironfofinance_2017);
			
			
			
		}

		addMessage(redirectAttributes, "保存2.2财务收支成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofinance/ironfofinance/?repage";
	}
	
	/**
	 * 删除2.2财务收支
	 */
	@RequiresPermissions("ironfofinance:ironfofinance:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfofinance ironfofinance, RedirectAttributes redirectAttributes) {
		ironfofinanceService.delete(ironfofinance);
		addMessage(redirectAttributes, "删除2.2财务收支成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofinance/ironfofinance/?repage";
	}
	
	/**
	 * 批量删除2.2财务收支
	 */
	@RequiresPermissions("ironfofinance:ironfofinance:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfofinanceService.delete(ironfofinanceService.get(id));
		}
		addMessage(redirectAttributes, "删除2.2财务收支成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofinance/ironfofinance/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfofinance:ironfofinance:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfofinance ironfofinance, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "2.2财务收支"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfofinance> page = ironfofinanceService.findPage(new Page<Ironfofinance>(request, response, -1), ironfofinance);
    		new ExportExcel("2.2财务收支", Ironfofinance.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出2.2财务收支记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofinance/ironfofinance/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfofinance:ironfofinance:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfofinance> list = ei.getDataList(Ironfofinance.class);
			for (Ironfofinance ironfofinance : list){
				try{
					ironfofinanceService.save(ironfofinance);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条2.2财务收支记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条2.2财务收支记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入2.2财务收支失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofinance/ironfofinance/?repage";
    }
	
	/**
	 * 下载导入2.2财务收支数据模板
	 */
	@RequiresPermissions("ironfofinance:ironfofinance:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "2.2财务收支数据导入模板.xlsx";
    		List<Ironfofinance> list = Lists.newArrayList(); 
    		new ExportExcel("2.2财务收支数据", Ironfofinance.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofinance/ironfofinance/?repage";
    }
	
	
	

}