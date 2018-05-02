/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofivezgshyf.web;

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
import com.jeeplus.modules.ironfofiveggwsyf.entity.Ironfofiveggwsyf;
import com.jeeplus.modules.ironfofivezgshyf.entity.Ironfofivezgshyf;
import com.jeeplus.modules.ironfofivezgshyf.service.IronfofivezgshyfService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 5.8职工生活用房Controller
 * @author mikesun
 * @version 2018-04-15
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfofivezgshyf/ironfofivezgshyf")
public class IronfofivezgshyfController extends BaseController {

	@Autowired
	private IronfofivezgshyfService ironfofivezgshyfService;
	
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	@ModelAttribute
	public Ironfofivezgshyf get(@RequestParam(required=false) String id) {
		Ironfofivezgshyf entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfofivezgshyfService.get(id);
		}
		if (entity == null){
			entity = new Ironfofivezgshyf();
		}
		return entity;
	}
	
	/**
	 * 5.8职工生活用房列表页面
	 */
	@RequiresPermissions("ironfofivezgshyf:ironfofivezgshyf:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfofivezgshyf ironfofivezgshyf, HttpServletRequest request, HttpServletResponse response, Model model) {
		
		
		
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
			Ironfofivezgshyf ironfofivezgshyf_data = null;
			try {
				
				ironfofivezgshyf_data = Ironfofivezgshyf.class.newInstance();
				
				
				ironfofivezgshyf_data.setDoc_id(docList.get(0).getId().toString());
				
				List<Ironfofivezgshyf> list_data = ironfofivezgshyfService.queryForList(ironfofivezgshyf_data);
				
				if(list_data.size()>0) {
					for(Ironfofivezgshyf zgshyf : list_data) {
						datas = new TreeMap<String,Object>();
						datas.put("id",zgshyf.getId());
						datas.put("doc_id",docList.get(0).getId().toString());
						datas.put("gndyjzmj",zgshyf.getGndyjzmj());
						datas.put("zgss",zgshyf.getZgss());
						datas.put("wsj",zgshyf.getWsj());
						datas.put("hxj",zgshyf.getHxj());
						datas.put("lyj",zgshyf.getLyj());
						datas.put("zyst",zgshyf.getZyst());
						datas.put("qtqzm",zgshyf.getQtqzm());
						
					}
					
				}else {
					datas = new TreeMap<String,Object>();
					datas.put("id", "");
					datas.put("doc_id", "");
					datas.put("gndyjzmj", "");
					datas.put("zgss", "0");
					datas.put("wsj", "0");
					datas.put("hxj", "0");
					datas.put("lyj", "0");
					datas.put("zyst", "0");
					datas.put("qtqzm", "");
				}
				
				
			} catch (Exception e) {
				
			}
			
		}
		
		
		
		request.setAttribute("data", datas);
		model.addAttribute("data", datas);
		
		return "modules/ironfofivezgshyf/ironfofivezgshyfList";
	}

	/**
	 * 查看，增加，编辑5.8职工生活用房表单页面
	 */
	@RequiresPermissions(value={"ironfofivezgshyf:ironfofivezgshyf:view","ironfofivezgshyf:ironfofivezgshyf:add","ironfofivezgshyf:ironfofivezgshyf:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfofivezgshyf ironfofivezgshyf, Model model) {
		model.addAttribute("ironfofivezgshyf", ironfofivezgshyf);
		return "modules/ironfofivezgshyf/ironfofivezgshyfForm";
	}

	/**
	 * 保存5.8职工生活用房
	 */
	@RequiresPermissions(value={"ironfofivezgshyf:ironfofivezgshyf:add","ironfofivezgshyf:ironfofivezgshyf:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfofivezgshyf ironfofivezgshyf, Model model, RedirectAttributes redirectAttributes) throws Exception{
		


		boolean isnull=false;
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		
		

		Subject subject = SecurityUtils.getSubject();  
		Principal obj = (Principal) subject.getPrincipal();
		
		System.out.println(obj.getId());
		
		Map<String,Object> map = new  TreeMap<String,Object>();
		String data = request.getParameter("titles");
		String checkbox = request.getParameter("checkval");
//		String type = request.getParameter("type");
		String checkout = request.getParameter("checkout");
		String qtqzm = request.getParameter("qtqzm");
		String id = request.getParameter("id");
		
		
		
		String[] datas = data.split(";");
		
		System.out.println("------------->"+datas[datas.length-1]);
		/**
		 * 主表信息
		 */
		String docId = "";
		for(int i=0;i<datas.length;i++) {
			map.put(datas[i].toString().split(":")[0].toString(), datas[i].toString().split(":")[1].toString());
			if("docId" == datas[i].toString().trim().split(":")[0].toString().trim() || "docId".equals(datas[i].toString().trim().split(":")[0].toString().trim())) {
				docId = datas[i].toString().split(":")[1].toString();
			}
		}
		
		
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
			Ironfofivezgshyf ironfofivezgshyf_data = Ironfofivezgshyf.class.newInstance();
			ironfofivezgshyf_data.setDoc_id(docId);
			List<Ironfofivezgshyf> fkjlx_data = ironfofivezgshyfService.queryForList(ironfofivezgshyf_data);
			
			if(fkjlx_data.size()>0) {
				isnull = true;
			}else {
				isnull = false;
			}
			
		}
		
		Ironfofivezgshyf ironfofivezgshyf_datas = Ironfofivezgshyf.class.newInstance();
		ironfofivezgshyf_datas.setDoc_id(docId);
		ironfofivezgshyf_datas.setGndyjzmj(map.get("gndyjzmj").toString());
		ironfofivezgshyf_datas.setZgss(map.get("zgss").toString());
		ironfofivezgshyf_datas.setWsj(map.get("wsj").toString());
		ironfofivezgshyf_datas.setHxj(map.get("hxj").toString());
		ironfofivezgshyf_datas.setLyj(map.get("lyj").toString());
		ironfofivezgshyf_datas.setZyst(map.get("zyst").toString());
		ironfofivezgshyf_datas.setQtqzm(qtqzm);
		
		
		
		
		if(isnull == true) {
			//更新
			ironfofivezgshyf_datas.setId(id);
			ironfofivezgshyfService.updateironfo(ironfofivezgshyf_datas);
			
		}else if(isnull == false) {
			//保存
			ironfofivezgshyfService.save(ironfofivezgshyf_datas);
			
		}
		
		
		
		return "redirect:"+Global.getAdminPath()+"/ironfofivezgshyf/ironfofivezgshyf/?repage";
	}
	
	/**
	 * 删除5.8职工生活用房
	 */
	@RequiresPermissions("ironfofivezgshyf:ironfofivezgshyf:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfofivezgshyf ironfofivezgshyf, RedirectAttributes redirectAttributes) {
		ironfofivezgshyfService.delete(ironfofivezgshyf);
		addMessage(redirectAttributes, "删除5.8职工生活用房成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivezgshyf/ironfofivezgshyf/?repage";
	}
	
	/**
	 * 批量删除5.8职工生活用房
	 */
	@RequiresPermissions("ironfofivezgshyf:ironfofivezgshyf:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfofivezgshyfService.delete(ironfofivezgshyfService.get(id));
		}
		addMessage(redirectAttributes, "删除5.8职工生活用房成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivezgshyf/ironfofivezgshyf/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfofivezgshyf:ironfofivezgshyf:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfofivezgshyf ironfofivezgshyf, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "5.8职工生活用房"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfofivezgshyf> page = ironfofivezgshyfService.findPage(new Page<Ironfofivezgshyf>(request, response, -1), ironfofivezgshyf);
    		new ExportExcel("5.8职工生活用房", Ironfofivezgshyf.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出5.8职工生活用房记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivezgshyf/ironfofivezgshyf/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfofivezgshyf:ironfofivezgshyf:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfofivezgshyf> list = ei.getDataList(Ironfofivezgshyf.class);
			for (Ironfofivezgshyf ironfofivezgshyf : list){
				try{
					ironfofivezgshyfService.save(ironfofivezgshyf);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条5.8职工生活用房记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条5.8职工生活用房记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入5.8职工生活用房失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivezgshyf/ironfofivezgshyf/?repage";
    }
	
	/**
	 * 下载导入5.8职工生活用房数据模板
	 */
	@RequiresPermissions("ironfofivezgshyf:ironfofivezgshyf:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "5.8职工生活用房数据导入模板.xlsx";
    		List<Ironfofivezgshyf> list = Lists.newArrayList(); 
    		new ExportExcel("5.8职工生活用房数据", Ironfofivezgshyf.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivezgshyf/ironfofivezgshyf/?repage";
    }
	
	
	

}