/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfobzwkfck.web;

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
import com.jeeplus.modules.ironfobzwkfck.entity.Ironfobzwkfck;
import com.jeeplus.modules.ironfobzwkfck.service.IronfobzwkfckService;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.ironfodoctitle.service.IronfoDocTitleService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 2.6外科、妇（产）科病种	Controller
 * @author mikesun
 * @version 2018-04-21
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfobzwkfck/ironfobzwkfck")
public class IronfobzwkfckController extends BaseController {
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;


	@Autowired
	private IronfobzwkfckService ironfobzwkfckService;
	
	@ModelAttribute
	public Ironfobzwkfck get(@RequestParam(required=false) String id) {
		Ironfobzwkfck entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfobzwkfckService.get(id);
		}
		if (entity == null){
			entity = new Ironfobzwkfck();
		}
		return entity;
	}
	
	/**
	 * 2.6外科、妇（产）科病种	列表页面
	 */
	@RequiresPermissions("ironfobzwkfck:ironfobzwkfck:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfobzwkfck ironfobzwkfck, HttpServletRequest request, HttpServletResponse response, Model model) {
	
		
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
			
			Ironfobzwkfck ironfobzwkfck_data = null;
			try {
				ironfobzwkfck_data = Ironfobzwkfck.class.newInstance();
				ironfobzwkfck_data.setDoc_id(docList.get(0).getId().toString());
				
				List<Ironfobzwkfck> list_data = ironfobzwkfckService.queryForList(ironfobzwkfck_data);

				if(list_data.size()>0) {
					for(Ironfobzwkfck ironfo : list_data) {
						datas = new TreeMap<String,Object>();
						datas.put("doc_id", docList.get(0).getId().toString());
						datas.put("wkfckjbbz",ironfo.getWkfckjbbz());
						datas.put("wkfcktjbz",ironfo.getWkfcktjbz());
						datas.put("wkfckjbbztext",ironfo.getWkfckjbbztext());
						datas.put("wkfcktjbztext",ironfo.getWkfcktjbztext());
						datas.put("id",ironfo.getId());
						
					}
					
				}else {
					
					datas = new TreeMap<String,Object>();
					datas.put("doc_id","");
					datas.put("wkfckjbbz","[]");
					datas.put("wkfcktjbz","[]");
					datas.put("wkfckjbbztext","");
					datas.put("wkfcktjbztext","");
					datas.put("id","");
					
					
				}
				
			} catch (Exception e) {
			}
			
		}else {
			
			datas = new TreeMap<String,Object>();
			datas.put("doc_id","");
			datas.put("wkfckjbbz","[]");
			datas.put("wkfcktjbz","[]");
			datas.put("wkfckjbbztext","");
			datas.put("wkfcktjbztext","");
			datas.put("id","");
			
		}
		request.setAttribute("data", datas);
		model.addAttribute("data", datas);
		return "modules/ironfobzwkfck/ironfobzwkfckList";
	}

	/**
	 * 查看，增加，编辑2.6外科、妇（产）科病种	表单页面
	 */
	@RequiresPermissions(value={"ironfobzwkfck:ironfobzwkfck:view","ironfobzwkfck:ironfobzwkfck:add","ironfobzwkfck:ironfobzwkfck:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfobzwkfck ironfobzwkfck, Model model) {
		model.addAttribute("ironfobzwkfck", ironfobzwkfck);
		return "modules/ironfobzwkfck/ironfobzwkfckForm";
	}

	/**
	 * 保存2.6外科、妇（产）科病种	
	 */
	@RequiresPermissions(value={"ironfobzwkfck:ironfobzwkfck:add","ironfobzwkfck:ironfobzwkfck:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfobzwkfck ironfobzwkfck, Model model, RedirectAttributes redirectAttributes) throws Exception{
		
		boolean isnull=false;
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		
		Map<String,Object> map = new  TreeMap<String,Object>();
		String docId = request.getParameter("docId");
		String id = request.getParameter("id");
		
		Object wkfcktjbz_chkval = request.getParameter("jsonektjbz");
		String wkfcktjbz_text = request.getParameter("wkfcktjbz_text");
		Object wkfckjbbz_chkval = request.getParameter("jsonekjbbz");//ekjbbz_text:
		String wkfckjbbz_text = request.getParameter("wkfckjbbz_text");
		
		
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
			Ironfobzwkfck ironfobzwkfck_data = Ironfobzwkfck.class.newInstance();
			ironfobzwkfck_data.setDoc_id(docId);
			List<Ironfobzwkfck> list_data = ironfobzwkfckService.queryForList(ironfobzwkfck_data);
			
			if(list_data.size()>0) {
				isnull = true;
			}else {
				isnull = false;
			}
			
		}
		
		Ironfobzwkfck ironfobzwkfck_datas = Ironfobzwkfck.class.newInstance();
		ironfobzwkfck_datas.setDoc_id(docId);
		ironfobzwkfck_datas.setWkfckjbbz(wkfckjbbz_chkval.toString());
		ironfobzwkfck_datas.setWkfcktjbz(wkfcktjbz_chkval.toString());
		ironfobzwkfck_datas.setWkfckjbbztext(wkfckjbbz_text.toString());
		ironfobzwkfck_datas.setWkfcktjbztext(wkfcktjbz_text.toString());
		
		
		if(isnull == true) {
			ironfobzwkfck_datas.setId(id);
			ironfobzwkfckService.updateironfo(ironfobzwkfck_datas);
		}else if(isnull == false){
			ironfobzwkfckService.save(ironfobzwkfck_datas);
			
		}
		
		
		
		
		
		return "redirect:"+Global.getAdminPath()+"/ironfobzwkfck/ironfobzwkfck/?repage";
	}
	
	/**
	 * 删除2.6外科、妇（产）科病种	
	 */
	@RequiresPermissions("ironfobzwkfck:ironfobzwkfck:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfobzwkfck ironfobzwkfck, RedirectAttributes redirectAttributes) {
		ironfobzwkfckService.delete(ironfobzwkfck);
		addMessage(redirectAttributes, "删除2.6外科、妇（产）科病种	成功");
		return "redirect:"+Global.getAdminPath()+"/ironfobzwkfck/ironfobzwkfck/?repage";
	}
	
	/**
	 * 批量删除2.6外科、妇（产）科病种	
	 */
	@RequiresPermissions("ironfobzwkfck:ironfobzwkfck:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfobzwkfckService.delete(ironfobzwkfckService.get(id));
		}
		addMessage(redirectAttributes, "删除2.6外科、妇（产）科病种	成功");
		return "redirect:"+Global.getAdminPath()+"/ironfobzwkfck/ironfobzwkfck/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfobzwkfck:ironfobzwkfck:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfobzwkfck ironfobzwkfck, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "2.6外科、妇（产）科病种	"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfobzwkfck> page = ironfobzwkfckService.findPage(new Page<Ironfobzwkfck>(request, response, -1), ironfobzwkfck);
    		new ExportExcel("2.6外科、妇（产）科病种	", Ironfobzwkfck.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出2.6外科、妇（产）科病种	记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfobzwkfck/ironfobzwkfck/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfobzwkfck:ironfobzwkfck:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfobzwkfck> list = ei.getDataList(Ironfobzwkfck.class);
			for (Ironfobzwkfck ironfobzwkfck : list){
				try{
					ironfobzwkfckService.save(ironfobzwkfck);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条2.6外科、妇（产）科病种	记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条2.6外科、妇（产）科病种	记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入2.6外科、妇（产）科病种	失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfobzwkfck/ironfobzwkfck/?repage";
    }
	
	/**
	 * 下载导入2.6外科、妇（产）科病种	数据模板
	 */
	@RequiresPermissions("ironfobzwkfck:ironfobzwkfck:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "2.6外科、妇（产）科病种	数据导入模板.xlsx";
    		List<Ironfobzwkfck> list = Lists.newArrayList(); 
    		new ExportExcel("2.6外科、妇（产）科病种	数据", Ironfobzwkfck.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfobzwkfck/ironfobzwkfck/?repage";
    }
	
	
	

}