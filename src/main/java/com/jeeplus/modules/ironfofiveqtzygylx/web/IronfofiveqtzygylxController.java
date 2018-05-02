/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofiveqtzygylx.web;

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
import com.jeeplus.modules.ironfofiventzyxjzl.entity.Ironfofiventzyxjzl;
import com.jeeplus.modules.ironfofiveqtzygylx.entity.Ironfofiveqtzygylx;
import com.jeeplus.modules.ironfofiveqtzygylx.service.IronfofiveqtzygylxService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 供应类型Controller
 * @author mikesun
 * @version 2018-04-17
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfofiveqtzygylx/ironfofiveqtzygylx")
public class IronfofiveqtzygylxController extends BaseController {

	
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;

	
	
	@Autowired
	private IronfofiveqtzygylxService ironfofiveqtzygylxService;
	
	@ModelAttribute
	public Ironfofiveqtzygylx get(@RequestParam(required=false) String id) {
		Ironfofiveqtzygylx entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfofiveqtzygylxService.get(id);
		}
		if (entity == null){
			entity = new Ironfofiveqtzygylx();
		}
		return entity;
	}
	
	/**
	 * 供应类型列表页面
	 */
	@RequiresPermissions("ironfofiveqtzygylx:ironfofiveqtzygylx:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfofiveqtzygylx ironfofiveqtzygylx, HttpServletRequest request, HttpServletResponse response, Model model) {
	
		

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
			
			Ironfofiveqtzygylx ironfofiveqtzygylx_data = null;

			
			try {
				ironfofiveqtzygylx_data = Ironfofiveqtzygylx.class.newInstance();
				ironfofiveqtzygylx_data.setDoc_id(docList.get(0).getId().toString());
				
				List<Ironfofiveqtzygylx> list_data = ironfofiveqtzygylxService.queryForList(ironfofiveqtzygylx_data);
				
				if(list_data.size()>0) {
					for(Ironfofiveqtzygylx gylx : list_data) {
						datas = new TreeMap<String,Object>();
						datas.put("zygy",gylx.getZygy());
						datas.put("qpzq",gylx.getQpzq());
						datas.put("doc_id", docList.get(0).getId().toString());
						datas.put("id",gylx.getId());
						
					}
					
				}else {
					
//					private String doc_id;		// 主表id
//					private String zygy;		// 中央供应
//					private String qpzq;		// 气瓶自取
					
					datas = new TreeMap<String,Object>();
					datas.put("zygy", "0");
					datas.put("qpzq", "0");
					datas.put("doc_id", "");
					datas.put("id", "");
					
					
				}

				
				
			} catch (Exception e) {
			}
		}
		
		

		request.setAttribute("data", datas);
		model.addAttribute("data", datas);
		
		
		
		return "modules/ironfofiveqtzygylx/ironfofiveqtzygylxList";
	}

	/**
	 * 查看，增加，编辑供应类型表单页面
	 */
	@RequiresPermissions(value={"ironfofiveqtzygylx:ironfofiveqtzygylx:view","ironfofiveqtzygylx:ironfofiveqtzygylx:add","ironfofiveqtzygylx:ironfofiveqtzygylx:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfofiveqtzygylx ironfofiveqtzygylx, Model model) {
		model.addAttribute("ironfofiveqtzygylx", ironfofiveqtzygylx);
		return "modules/ironfofiveqtzygylx/ironfofiveqtzygylxForm";
	}

	/**
	 * 保存供应类型
	 */
	@RequiresPermissions(value={"ironfofiveqtzygylx:ironfofiveqtzygylx:add","ironfofiveqtzygylx:ironfofiveqtzygylx:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfofiveqtzygylx ironfofiveqtzygylx, Model model, RedirectAttributes redirectAttributes) throws Exception{


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
			Ironfofiveqtzygylx ironfofiveqtzygylx_data = Ironfofiveqtzygylx.class.newInstance();
			ironfofiveqtzygylx_data.setDoc_id(docId);
			List<Ironfofiveqtzygylx> fkjlx_data = ironfofiveqtzygylxService.queryForList(ironfofiveqtzygylx_data);
			
			if(fkjlx_data.size()>0) {
				isnull = true;
			}else {
				isnull = false;
			}
			
		}
		
		
		Ironfofiveqtzygylx ironfofiveqtzygylx_datas = Ironfofiveqtzygylx.class.newInstance();
		ironfofiveqtzygylx_datas.setDoc_id(docId);
		ironfofiveqtzygylx_datas.setZygy(map.get("zygy").toString());
		ironfofiveqtzygylx_datas.setQpzq(map.get("qpzq").toString());
		
		

		if(isnull == true) {
			//更新
			ironfofiveqtzygylx_datas.setId(id);
			ironfofiveqtzygylxService.updateironfo(ironfofiveqtzygylx_datas);
			
		}else if(isnull == false) {
			//保存
			ironfofiveqtzygylxService.save(ironfofiveqtzygylx_datas);
			
		}
		
		
		
		
		
		
		
		
		return "redirect:"+Global.getAdminPath()+"/ironfofiveqtzygylx/ironfofiveqtzygylx/?repage";
	}
	
	/**
	 * 删除供应类型
	 */
	@RequiresPermissions("ironfofiveqtzygylx:ironfofiveqtzygylx:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfofiveqtzygylx ironfofiveqtzygylx, RedirectAttributes redirectAttributes) {
		ironfofiveqtzygylxService.delete(ironfofiveqtzygylx);
		addMessage(redirectAttributes, "删除供应类型成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofiveqtzygylx/ironfofiveqtzygylx/?repage";
	}
	
	/**
	 * 批量删除供应类型
	 */
	@RequiresPermissions("ironfofiveqtzygylx:ironfofiveqtzygylx:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfofiveqtzygylxService.delete(ironfofiveqtzygylxService.get(id));
		}
		addMessage(redirectAttributes, "删除供应类型成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofiveqtzygylx/ironfofiveqtzygylx/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfofiveqtzygylx:ironfofiveqtzygylx:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfofiveqtzygylx ironfofiveqtzygylx, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "供应类型"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfofiveqtzygylx> page = ironfofiveqtzygylxService.findPage(new Page<Ironfofiveqtzygylx>(request, response, -1), ironfofiveqtzygylx);
    		new ExportExcel("供应类型", Ironfofiveqtzygylx.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出供应类型记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofiveqtzygylx/ironfofiveqtzygylx/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfofiveqtzygylx:ironfofiveqtzygylx:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfofiveqtzygylx> list = ei.getDataList(Ironfofiveqtzygylx.class);
			for (Ironfofiveqtzygylx ironfofiveqtzygylx : list){
				try{
					ironfofiveqtzygylxService.save(ironfofiveqtzygylx);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条供应类型记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条供应类型记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入供应类型失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofiveqtzygylx/ironfofiveqtzygylx/?repage";
    }
	
	/**
	 * 下载导入供应类型数据模板
	 */
	@RequiresPermissions("ironfofiveqtzygylx:ironfofiveqtzygylx:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "供应类型数据导入模板.xlsx";
    		List<Ironfofiveqtzygylx> list = Lists.newArrayList(); 
    		new ExportExcel("供应类型数据", Ironfofiveqtzygylx.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofiveqtzygylx/ironfofiveqtzygylx/?repage";
    }
	
	
	

}