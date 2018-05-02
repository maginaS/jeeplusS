/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfobznkekbz.web;

import java.util.ArrayList;
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
import com.jeeplus.modules.ironfobznkekbz.entity.Ironfobznkekbz;
import com.jeeplus.modules.ironfobznkekbz.service.IronfobznkekbzService;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.ironfodoctitle.service.IronfoDocTitleService;
import com.jeeplus.modules.ironfofivedtzydtsb.entity.Ironfofivedtzydtsb;
import com.jeeplus.modules.ironfofiventzyxjzl.entity.Ironfofiventzyxjzl;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

//import scala.util.parsing.json.JSONObject;

import net.sf.json.JSONObject;



/**
 * 2.5内科、儿科病种Controller
 * @author mikesun
 * @version 2018-04-18
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfobznkekbz/ironfobznkekbz")
public class IronfobznkekbzController extends BaseController {
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;

	@Autowired
	private IronfobznkekbzService ironfobznkekbzService;
	
	@ModelAttribute
	public Ironfobznkekbz get(@RequestParam(required=false) String id) {
		Ironfobznkekbz entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfobznkekbzService.get(id);
		}
		if (entity == null){
			entity = new Ironfobznkekbz();
		}
		return entity;
	}
	
	/**
	 * 2.5内科、儿科病种列表页面
	 */
	@RequiresPermissions("ironfobznkekbz:ironfobznkekbz:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfobznkekbz ironfobznkekbz, HttpServletRequest request, HttpServletResponse response, Model model) {

		
		Map<String,Object> datas = null;
		
		Subject subject = SecurityUtils.getSubject();  
		Principal obj = (Principal) subject.getPrincipal();
		System.out.println(obj.getId());
		
		
		IronfoDocTitle title = null;
		try {
			title = IronfoDocTitle.class.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		title.setRemarks(obj.getId());
		List<IronfoDocTitle> docList = ironfoDoc_Title_Service.queryforList(title);
		if(docList.size()>0) {
			Ironfobznkekbz ironfobznkekbz_data=null;
			
			try {
				ironfobznkekbz_data = Ironfobznkekbz.class.newInstance();
				ironfobznkekbz_data.setDoc_id(docList.get(0).getId().toString());
				
				List<Ironfobznkekbz> list_data = ironfobznkekbzService.queryForList(ironfobznkekbz_data);

				if(list_data.size()>0) {
					for(Ironfobznkekbz znekbz : list_data) {
						datas = new TreeMap<String,Object>();
//						objdata = new JSONObject();
						datas.put("doc_id", docList.get(0).getId().toString());
						datas.put("bztype",znekbz.getBztype());
						datas.put("ektjbz",znekbz.getEktjbz());
						datas.put("ekjbbz",znekbz.getEkjbbz());
						datas.put("nktjbz",znekbz.getNktjbz());
						datas.put("nkjbbz",znekbz.getNkjbbz());
						datas.put("nkjbbzText",znekbz.getNkjbbzText());
						datas.put("nktjbzText",znekbz.getNktjbzText());
						datas.put("ekjbbzText",znekbz.getEkjbbzText());
						datas.put("ektjbzText",znekbz.getEktjbzText());
						datas.put("id",znekbz.getId());
						
					}
					
					
				}else {
					datas = new TreeMap<String,Object>();
					datas.put("doc_id", "");
					datas.put("bztype", "");
					datas.put("ektjbz","[]");
					datas.put("ekjbbz", "[]");
					datas.put("nktjbz", "[]");
					datas.put("nkjbbz", "[]");
					datas.put("nkjbbzText", "");
					datas.put("nktjbzText", "");
					datas.put("ekjbbzText", "");
					datas.put("ektjbzText", "");
					datas.put("id","");
				}
				
				
			} catch (Exception e) {
			}
			
		}else {
			datas = new TreeMap<String,Object>();
			datas.put("doc_id", "");
			datas.put("bztype", "");
			datas.put("ektjbz","[]");
			datas.put("ekjbbz", "[]");
			datas.put("nktjbz", "[]");
			datas.put("nkjbbz", "[]");
			datas.put("nkjbbzText", "");
			datas.put("nktjbzText", "");
			datas.put("ekjbbzText", "");
			datas.put("ektjbzText", "");
			datas.put("id","");
		}
		
		request.setAttribute("data", datas);
		model.addAttribute("data", datas);
		
		return "modules/ironfobznkekbz/ironfobznkekbzList";
	}

	/**
	 * 查看，增加，编辑2.5内科、儿科病种表单页面
	 */
	@RequiresPermissions(value={"ironfobznkekbz:ironfobznkekbz:view","ironfobznkekbz:ironfobznkekbz:add","ironfobznkekbz:ironfobznkekbz:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfobznkekbz ironfobznkekbz, Model model) {
		model.addAttribute("ironfobznkekbz", ironfobznkekbz);
		return "modules/ironfobznkekbz/ironfobznkekbzForm";
	}

	/**
	 * 保存2.5内科、儿科病种
	 */
	@RequiresPermissions(value={"ironfobznkekbz:ironfobznkekbz:add","ironfobznkekbz:ironfobznkekbz:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfobznkekbz ironfobznkekbz, Model model, RedirectAttributes redirectAttributes) throws Exception{
	

		boolean isnull=false;
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		
		Map<String,Object> map = new  TreeMap<String,Object>();

		
		

		String docId = request.getParameter("docId");
		String id = request.getParameter("id");
		Object ektjbz_chkval = request.getParameter("jsonektjbz");
		String ektjbz_text = request.getParameter("ektjbz_text");
		Object ekjbbz_chkval = request.getParameter("jsonekjbbz");//ekjbbz_text:
		String ekjbbz_text = request.getParameter("ekjbbz_text");
		Object nkjbbz_chkval = request.getParameter("jsonnkjbbz");//nkjbbz_text
		String nkjbbz_text = request.getParameter("nkjbbz_text");
		Object nktjbz_chkval = request.getParameter("jsonnktjbz");// nktjzbz_text
		String nktjzbz_text = request.getParameter("nktjzbz_text");
		
		Subject subject = SecurityUtils.getSubject();  
		Principal obj = (Principal) subject.getPrincipal();
		
		System.out.println(obj.getId());
		
		

		/**
		 * 附表信息
		 */
		
		if(docId.toString().trim() == null || "".equals(docId.toString().trim())||"----".trim()==docId.toString().trim()||"----".trim().equals(docId.toString().trim())) {
 			isnull = false;
 			IronfoDocTitle title =  IronfoDocTitle.class.newInstance();
 			title.setRemarks(obj.getId());
 			
 			List<IronfoDocTitle> docList = ironfoDoc_Title_Service.queryforList(title);
 			docId= docList.get(0).getId().toString();
 			
		}else {
//			ironfofivemjzyf.setDoc_id(docId);
			Ironfobznkekbz ironfobznkekbz_data = Ironfobznkekbz.class.newInstance();
			ironfobznkekbz_data.setDoc_id(docId);
			List<Ironfobznkekbz> fkjlx_data = ironfobznkekbzService.queryForList(ironfobznkekbz_data);
			
			if(fkjlx_data.size()>0) {
				isnull = true;
			}else {
				isnull = false;
			}
			
		}
		
		
		
		Ironfobznkekbz ironfobznkekbz_datas = Ironfobznkekbz.class.newInstance();
		ironfobznkekbz_datas.setEkjbbz(ekjbbz_chkval.toString());
		ironfobznkekbz_datas.setEktjbz(ektjbz_chkval.toString());
		ironfobznkekbz_datas.setNkjbbz(nkjbbz_chkval.toString());
		ironfobznkekbz_datas.setNktjbz(nktjbz_chkval.toString());
		ironfobznkekbz_datas.setEkjbbzText(ekjbbz_text.toString());
		ironfobznkekbz_datas.setEktjbzText(ektjbz_text.toString());
		ironfobznkekbz_datas.setNkjbbzText(nkjbbz_text.toString());
		ironfobznkekbz_datas.setNktjbzText(nktjzbz_text.toString());
		ironfobznkekbz_datas.setDoc_id(docId);
		
		
		
		if(isnull == true) {
			ironfobznkekbz_datas.setId(id);
			ironfobznkekbzService.updateironfo(ironfobznkekbz_datas);
		}else if(isnull == false){
			ironfobznkekbzService.save(ironfobznkekbz_datas);
			
		}
		
		
		
		
	
		
		
		
		
		
		
		return "redirect:"+Global.getAdminPath()+"/ironfobznkekbz/ironfobznkekbz/?repage";
	}
	
	/**
	 * 删除2.5内科、儿科病种
	 */
	@RequiresPermissions("ironfobznkekbz:ironfobznkekbz:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfobznkekbz ironfobznkekbz, RedirectAttributes redirectAttributes) {
		ironfobznkekbzService.delete(ironfobznkekbz);
		addMessage(redirectAttributes, "删除2.5内科、儿科病种成功");
		return "redirect:"+Global.getAdminPath()+"/ironfobznkekbz/ironfobznkekbz/?repage";
	}
	
	/**
	 * 批量删除2.5内科、儿科病种
	 */
	@RequiresPermissions("ironfobznkekbz:ironfobznkekbz:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfobznkekbzService.delete(ironfobznkekbzService.get(id));
		}
		addMessage(redirectAttributes, "删除2.5内科、儿科病种成功");
		return "redirect:"+Global.getAdminPath()+"/ironfobznkekbz/ironfobznkekbz/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfobznkekbz:ironfobznkekbz:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfobznkekbz ironfobznkekbz, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "2.5内科、儿科病种"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfobznkekbz> page = ironfobznkekbzService.findPage(new Page<Ironfobznkekbz>(request, response, -1), ironfobznkekbz);
    		new ExportExcel("2.5内科、儿科病种", Ironfobznkekbz.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出2.5内科、儿科病种记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfobznkekbz/ironfobznkekbz/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfobznkekbz:ironfobznkekbz:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfobznkekbz> list = ei.getDataList(Ironfobznkekbz.class);
			for (Ironfobznkekbz ironfobznkekbz : list){
				try{
					ironfobznkekbzService.save(ironfobznkekbz);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条2.5内科、儿科病种记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条2.5内科、儿科病种记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入2.5内科、儿科病种失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfobznkekbz/ironfobznkekbz/?repage";
    }
	
	/**
	 * 下载导入2.5内科、儿科病种数据模板
	 */
	@RequiresPermissions("ironfobznkekbz:ironfobznkekbz:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "2.5内科、儿科病种数据导入模板.xlsx";
    		List<Ironfobznkekbz> list = Lists.newArrayList(); 
    		new ExportExcel("2.5内科、儿科病种数据", Ironfobznkekbz.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfobznkekbz/ironfobznkekbz/?repage";
    }
	
	
	

}