/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofivejhsyyf.web;

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
import com.jeeplus.modules.ironfofivejhsyyf.entity.Ironfofivejhsyyf;
import com.jeeplus.modules.ironfofivejhsyyf.service.IronfofivejhsyyfService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 5.6计划生育用房Controller
 * @author mikesun
 * @version 2018-04-15
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfofivejhsyyf/ironfofivejhsyyf")
public class IronfofivejhsyyfController extends BaseController {
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	

	@Autowired
	private IronfofivejhsyyfService ironfofivejhsyyfService;
	
	@ModelAttribute
	public Ironfofivejhsyyf get(@RequestParam(required=false) String id) {
		Ironfofivejhsyyf entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfofivejhsyyfService.get(id);
		}
		if (entity == null){
			entity = new Ironfofivejhsyyf();
		}
		return entity;
	}
	
	/**
	 * 5.6计划生育用房列表页面
	 */
	@RequiresPermissions("ironfofivejhsyyf:ironfofivejhsyyf:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfofivejhsyyf ironfofivejhsyyf, HttpServletRequest request, HttpServletResponse response, Model model) {
	
		
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
			Ironfofivejhsyyf ironfofivejhsyyf_data = null;
			try {
				ironfofivejhsyyf_data = Ironfofivejhsyyf.class.newInstance();
				ironfofivejhsyyf_data.setDoc_id(docList.get(0).getId().toString());
				
				List<Ironfofivejhsyyf> list_data = ironfofivejhsyyfService.queryForList(ironfofivejhsyyf_data);

				if(list_data.size()>0) {
					for(Ironfofivejhsyyf jhsyyf :list_data) {
						datas = new TreeMap<String,Object>();
						datas.put("id",jhsyyf.getId());
						datas.put("doc_id",docList.get(0).getId().toString());
						datas.put("gndyjzmj",jhsyyf.getGndyjzmj());
						datas.put("zs",jhsyyf.getZs());
						datas.put("jcs",jhsyyf.getJcs());
						datas.put("qtqzm",jhsyyf.getQtqzm());
						
					}
					
				}else {
					
					datas = new TreeMap<String,Object>();
					datas.put("id", "");
					datas.put("doc_id", "");
					datas.put("gndyjzmj", "");
					datas.put("zs", "0");
					datas.put("jcs", "0");
					datas.put("qtqzm", "");
					
				}
				
			} catch (Exception e) {
			}
			
		}
		
		
		request.setAttribute("data", datas);
		model.addAttribute("data", datas);
		
		return "modules/ironfofivejhsyyf/ironfofivejhsyyfList";
	}

	/**
	 * 查看，增加，编辑5.6计划生育用房表单页面
	 */
	@RequiresPermissions(value={"ironfofivejhsyyf:ironfofivejhsyyf:view","ironfofivejhsyyf:ironfofivejhsyyf:add","ironfofivejhsyyf:ironfofivejhsyyf:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfofivejhsyyf ironfofivejhsyyf, Model model) {
		model.addAttribute("ironfofivejhsyyf", ironfofivejhsyyf);
		return "modules/ironfofivejhsyyf/ironfofivejhsyyfForm";
	}

	/**
	 * 保存5.6计划生育用房
	 */
	@RequiresPermissions(value={"ironfofivejhsyyf:ironfofivejhsyyf:add","ironfofivejhsyyf:ironfofivejhsyyf:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfofivejhsyyf ironfofivejhsyyf, Model model, RedirectAttributes redirectAttributes) throws Exception{
	
		
		
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
			Ironfofivejhsyyf ironfofivejhsyyf_data = Ironfofivejhsyyf.class.newInstance();
			ironfofivejhsyyf_data.setDoc_id(docId);
			List<Ironfofivejhsyyf> fkjlx_data = ironfofivejhsyyfService.queryForList(ironfofivejhsyyf_data);
			
			if(fkjlx_data.size()>0) {
				isnull = true;
			}else {
				isnull = false;
			}
			
		}
		
		
		Ironfofivejhsyyf ironfofivejhsyyf_datas = Ironfofivejhsyyf.class.newInstance();
		ironfofivejhsyyf_datas.setDoc_id(docId);
		ironfofivejhsyyf_datas.setZs(map.get("zs").toString());
		ironfofivejhsyyf_datas.setJcs(map.get("jcs").toString());
		ironfofivejhsyyf_datas.setGndyjzmj(map.get("gndyjzmj").toString());
		ironfofivejhsyyf_datas.setQtqzm(qtqzm);
		
		
		
		if(isnull == true) {
			//更新
			ironfofivejhsyyf_datas.setId(id);
			ironfofivejhsyyfService.updateironfo(ironfofivejhsyyf_datas);
			
		}else if(isnull == false) {
			//保存
			ironfofivejhsyyfService.save(ironfofivejhsyyf_datas);
			
		}
		
		
	
		
		
		
		
		return "redirect:"+Global.getAdminPath()+"/ironfofivejhsyyf/ironfofivejhsyyf/?repage";
	}
	
	/**
	 * 删除5.6计划生育用房
	 */
	@RequiresPermissions("ironfofivejhsyyf:ironfofivejhsyyf:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfofivejhsyyf ironfofivejhsyyf, RedirectAttributes redirectAttributes) {
		ironfofivejhsyyfService.delete(ironfofivejhsyyf);
		addMessage(redirectAttributes, "删除5.6计划生育用房成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivejhsyyf/ironfofivejhsyyf/?repage";
	}
	
	/**
	 * 批量删除5.6计划生育用房
	 */
	@RequiresPermissions("ironfofivejhsyyf:ironfofivejhsyyf:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfofivejhsyyfService.delete(ironfofivejhsyyfService.get(id));
		}
		addMessage(redirectAttributes, "删除5.6计划生育用房成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivejhsyyf/ironfofivejhsyyf/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfofivejhsyyf:ironfofivejhsyyf:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfofivejhsyyf ironfofivejhsyyf, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "5.6计划生育用房"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfofivejhsyyf> page = ironfofivejhsyyfService.findPage(new Page<Ironfofivejhsyyf>(request, response, -1), ironfofivejhsyyf);
    		new ExportExcel("5.6计划生育用房", Ironfofivejhsyyf.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出5.6计划生育用房记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivejhsyyf/ironfofivejhsyyf/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfofivejhsyyf:ironfofivejhsyyf:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfofivejhsyyf> list = ei.getDataList(Ironfofivejhsyyf.class);
			for (Ironfofivejhsyyf ironfofivejhsyyf : list){
				try{
					ironfofivejhsyyfService.save(ironfofivejhsyyf);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条5.6计划生育用房记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条5.6计划生育用房记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入5.6计划生育用房失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivejhsyyf/ironfofivejhsyyf/?repage";
    }
	
	/**
	 * 下载导入5.6计划生育用房数据模板
	 */
	@RequiresPermissions("ironfofivejhsyyf:ironfofivejhsyyf:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "5.6计划生育用房数据导入模板.xlsx";
    		List<Ironfofivejhsyyf> list = Lists.newArrayList(); 
    		new ExportExcel("5.6计划生育用房数据", Ironfofivejhsyyf.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivejhsyyf/ironfofivejhsyyf/?repage";
    }
	
	
	

}