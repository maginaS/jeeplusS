/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofivedtzydtsb.web;

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
import com.jeeplus.modules.ironfofivedtzydtsb.entity.Ironfofivedtzydtsb;
import com.jeeplus.modules.ironfofivedtzydtsb.service.IronfofivedtzydtsbService;
import com.jeeplus.modules.ironfofiventzyxjzl.entity.Ironfofiventzyxjzl;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 电梯设备Controller
 * @author mikesun
 * @version 2018-04-17
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfofivedtzydtsb/ironfofivedtzydtsb")
public class IronfofivedtzydtsbController extends BaseController {

	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;

	
	
	@Autowired
	private IronfofivedtzydtsbService ironfofivedtzydtsbService;
	
	@ModelAttribute
	public Ironfofivedtzydtsb get(@RequestParam(required=false) String id) {
		Ironfofivedtzydtsb entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfofivedtzydtsbService.get(id);
		}
		if (entity == null){
			entity = new Ironfofivedtzydtsb();
		}
		return entity;
	}
	
	/**
	 * 电梯设备列表页面
	 */
	@RequiresPermissions("ironfofivedtzydtsb:ironfofivedtzydtsb:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfofivedtzydtsb ironfofivedtzydtsb, HttpServletRequest request, HttpServletResponse response, Model model) {
	

		Map<String,Object> listData = new HashMap<String,Object>();
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
			Ironfofivedtzydtsb ironfofivedtzydtsb_data = null;
			try {
				ironfofivedtzydtsb_data = Ironfofivedtzydtsb.class.newInstance();
				ironfofivedtzydtsb_data.setDoc_id(docList.get(0).getId().toString());
				
				
				List<Ironfofivedtzydtsb> list_data = ironfofivedtzydtsbService.queryForList(ironfofivedtzydtsb_data);
				if(list_data.size()>0) {
					for(Ironfofivedtzydtsb dtsb : list_data) {
						datas = new TreeMap<String,Object>();
						datas.put("czdt",dtsb.getCzdt());
						datas.put("zdft",dtsb.getZdft());
						datas.put("bcdt",dtsb.getBcdt());
						datas.put("doc_id",docList.get(0).getId().toString());
						datas.put("id",dtsb.getId());
						
					}
					
				}else {

					
					datas = new TreeMap<String,Object>();
					datas.put("czdt", "0");
					datas.put("zdft", "0");
					datas.put("bcdt", "0");
					datas.put("doc_id", "");
					datas.put("id", "");
					
				}

				
				
			} catch (Exception e) {
			}
			
		}
		

		request.setAttribute("dataList", datas);
		model.addAttribute("dataList", datas);
		
		
		return "modules/ironfofivedtzydtsb/ironfofivedtzydtsbList";
	}

	/**
	 * 查看，增加，编辑电梯设备表单页面
	 */
	@RequiresPermissions(value={"ironfofivedtzydtsb:ironfofivedtzydtsb:view","ironfofivedtzydtsb:ironfofivedtzydtsb:add","ironfofivedtzydtsb:ironfofivedtzydtsb:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfofivedtzydtsb ironfofivedtzydtsb, Model model) {
		model.addAttribute("ironfofivedtzydtsb", ironfofivedtzydtsb);
		return "modules/ironfofivedtzydtsb/ironfofivedtzydtsbForm";
	}

	/**
	 * 保存电梯设备
	 */
	@RequiresPermissions(value={"ironfofivedtzydtsb:ironfofivedtzydtsb:add","ironfofivedtzydtsb:ironfofivedtzydtsb:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfofivedtzydtsb ironfofivedtzydtsb, Model model, RedirectAttributes redirectAttributes) throws Exception{
	


		boolean isnull=false;
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		
		

		Subject subject = SecurityUtils.getSubject();  
		Principal obj = (Principal) subject.getPrincipal();
		
		System.out.println(obj.getId());
		
		Map<String,Object> map = new  TreeMap<String,Object>();
		String docId = request.getParameter("docId");
		String checkbox = request.getParameter("checkval");
//		String type = request.getParameter("type");
		String checkout = request.getParameter("checkout");
		String qtqzm = request.getParameter("qtqzm");
		String id = request.getParameter("id");
		
		
		
//		String[] datas = data.split(";");
		
//		System.out.println("------------->"+datas[datas.length-1]);
		/**
		 * 主表信息
		 */
//		String docId = "";
//		for(int i=0;i<datas.length;i++) {
//			map.put(datas[i].toString().split(":")[0].toString(), datas[i].toString().split(":")[1].toString());
//			if("docId" == datas[i].toString().trim().split(":")[0].toString().trim() || "docId".equals(datas[i].toString().trim().split(":")[0].toString().trim())) {
//				docId = datas[i].toString().split(":")[1].toString();
//			}
//		}
		
		
		if(checkbox.length()>0) {
			if(checkbox.indexOf(",")!=-1) {
				for(int j =0;j<checkbox.split(",").length;j++) {
					map.put(checkbox.split(",")[j], "1");
				}
			}else {
				 map.put(checkbox, "1");
			}
		}
		
		if(checkout.length()>0) {
			if(checkout.contains(",")) {
				for(int j =0;j<checkout.split(",").length;j++) {
					map.put(checkout.split(",")[j], "0");
				}	
			}else {
				map.put(checkout, "0");
			}
			
		}
		
		
		
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
			Ironfofivedtzydtsb ironfofivedtzydtsb_data = Ironfofivedtzydtsb.class.newInstance();
			ironfofivedtzydtsb_data.setDoc_id(docId);
			List<Ironfofivedtzydtsb> fkjlx_data = ironfofivedtzydtsbService.queryForList(ironfofivedtzydtsb_data);
			
			if(fkjlx_data.size()>0) {
				isnull = true;
			}else {
				isnull = false;
			}
			
		}
		
		Ironfofivedtzydtsb ironfofivedtzydtsb_datas = Ironfofivedtzydtsb.class.newInstance();
		ironfofivedtzydtsb_datas.setDoc_id(docId);
		ironfofivedtzydtsb_datas.setCzdt(map.get("czdt").toString());
		ironfofivedtzydtsb_datas.setZdft(map.get("zdft").toString());
		ironfofivedtzydtsb_datas.setBcdt(map.get("bcdt").toString());
		
		

		if(isnull == true) {
			//更新
			ironfofivedtzydtsb_datas.setId(id);
			ironfofivedtzydtsbService.updateironfo(ironfofivedtzydtsb_datas);
			
		}else if(isnull == false) {
			//保存
			ironfofivedtzydtsbService.save(ironfofivedtzydtsb_datas);
			
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivedtzydtsb/ironfofivedtzydtsb/?repage";
	}
	
	/**
	 * 删除电梯设备
	 */
	@RequiresPermissions("ironfofivedtzydtsb:ironfofivedtzydtsb:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfofivedtzydtsb ironfofivedtzydtsb, RedirectAttributes redirectAttributes) {
		ironfofivedtzydtsbService.delete(ironfofivedtzydtsb);
		addMessage(redirectAttributes, "删除电梯设备成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivedtzydtsb/ironfofivedtzydtsb/?repage";
	}
	
	/**
	 * 批量删除电梯设备
	 */
	@RequiresPermissions("ironfofivedtzydtsb:ironfofivedtzydtsb:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfofivedtzydtsbService.delete(ironfofivedtzydtsbService.get(id));
		}
		addMessage(redirectAttributes, "删除电梯设备成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivedtzydtsb/ironfofivedtzydtsb/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfofivedtzydtsb:ironfofivedtzydtsb:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfofivedtzydtsb ironfofivedtzydtsb, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "电梯设备"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfofivedtzydtsb> page = ironfofivedtzydtsbService.findPage(new Page<Ironfofivedtzydtsb>(request, response, -1), ironfofivedtzydtsb);
    		new ExportExcel("电梯设备", Ironfofivedtzydtsb.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出电梯设备记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivedtzydtsb/ironfofivedtzydtsb/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfofivedtzydtsb:ironfofivedtzydtsb:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfofivedtzydtsb> list = ei.getDataList(Ironfofivedtzydtsb.class);
			for (Ironfofivedtzydtsb ironfofivedtzydtsb : list){
				try{
					ironfofivedtzydtsbService.save(ironfofivedtzydtsb);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条电梯设备记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条电梯设备记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入电梯设备失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivedtzydtsb/ironfofivedtzydtsb/?repage";
    }
	
	/**
	 * 下载导入电梯设备数据模板
	 */
	@RequiresPermissions("ironfofivedtzydtsb:ironfofivedtzydtsb:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "电梯设备数据导入模板.xlsx";
    		List<Ironfofivedtzydtsb> list = Lists.newArrayList(); 
    		new ExportExcel("电梯设备数据", Ironfofivedtzydtsb.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivedtzydtsb/ironfofivedtzydtsb/?repage";
    }
	
	
	

}