/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofiveswcd.web;

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
import com.jeeplus.modules.ironfofiveswcd.entity.Ironfofiveswcd;
import com.jeeplus.modules.ironfofiveswcd.service.IronfofiveswcdService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 5.9室外场地Controller
 * @author mikesun
 * @version 2018-04-15
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfofiveswcd/ironfofiveswcd")
public class IronfofiveswcdController extends BaseController {
	
	
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;

	@Autowired
	private IronfofiveswcdService ironfofiveswcdService;
	
	@ModelAttribute
	public Ironfofiveswcd get(@RequestParam(required=false) String id) {
		Ironfofiveswcd entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfofiveswcdService.get(id);
		}
		if (entity == null){
			entity = new Ironfofiveswcd();
		}
		return entity;
	}
	
	/**
	 * 5.9室外场地列表页面
	 */
	@RequiresPermissions("ironfofiveswcd:ironfofiveswcd:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfofiveswcd ironfofiveswcd, HttpServletRequest request, HttpServletResponse response, Model model) {
	
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
			
			Ironfofiveswcd ironfofiveswcd_data = null;
			try {
				ironfofiveswcd_data = Ironfofiveswcd.class.newInstance();
				ironfofiveswcd_data.setDoc_id(docList.get(0).getId().toString());
				
				List<Ironfofiveswcd> list_data = ironfofiveswcdService.queryForList(ironfofiveswcd_data);
				
				if(list_data.size()>0) {
					for(Ironfofiveswcd swcd : list_data) {
						datas = new TreeMap<String,Object>();
						datas.put("doc_id",docList.get(0).getId().toString());
						datas.put("yhdl",swcd.getYhdl());
						datas.put("ld",swcd.getLd());
						datas.put("swtcc",swcd.getSwtcc());
						datas.put("qtqzm",swcd.getQtqzm());
						datas.put("id",swcd.getId());
						
					}
					
				}else {
					
//					private String doc_id;		// 主表id
//					private String yhdl;		// 硬化道路
//					private String ld;		// 绿地
//					private String swtcc;		// 室外停车场
//					private String qtqzm;		// 其它（请注明）
					
					datas = new TreeMap<String,Object>();
					datas.put("doc_id", "");
					datas.put("yhdl", "0");
					datas.put("ld", "0");
					datas.put("swtcc", "0");
					datas.put("qtqzm", "");
					datas.put("id", "");
				}
				
					
			} catch (Exception e) {
				
			}
			
		}
		
		
		
		request.setAttribute("data", datas);
		model.addAttribute("data", datas);
		
		
		return "modules/ironfofiveswcd/ironfofiveswcdList";
	}

	/**
	 * 查看，增加，编辑5.9室外场地表单页面
	 */
	@RequiresPermissions(value={"ironfofiveswcd:ironfofiveswcd:view","ironfofiveswcd:ironfofiveswcd:add","ironfofiveswcd:ironfofiveswcd:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfofiveswcd ironfofiveswcd, Model model) {
		model.addAttribute("ironfofiveswcd", ironfofiveswcd);
		return "modules/ironfofiveswcd/ironfofiveswcdForm";
	}

	/**
	 * 保存5.9室外场地
	 */
	@RequiresPermissions(value={"ironfofiveswcd:ironfofiveswcd:add","ironfofiveswcd:ironfofiveswcd:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfofiveswcd ironfofiveswcd, Model model, RedirectAttributes redirectAttributes) throws Exception{
	


		boolean isnull=false;
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		
		

		Subject subject = SecurityUtils.getSubject();  
		Principal obj = (Principal) subject.getPrincipal();
		
		System.out.println(obj.getId());
		
		Map<String,Object> map = new  TreeMap<String,Object>();
		String docId = request.getParameter("docId");
		String checkbox = request.getParameter("checkval");
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
			Ironfofiveswcd ironfofiveswcd_data = Ironfofiveswcd.class.newInstance();
			ironfofiveswcd_data.setDoc_id(docId);
			List<Ironfofiveswcd> fkjlx_data = ironfofiveswcdService.queryForList(ironfofiveswcd_data);
			
			if(fkjlx_data.size()>0) {
				isnull = true;
			}else {
				isnull = false;
			}
			
		}
		
//		
		
		Ironfofiveswcd ironfofiveswcd_datas = Ironfofiveswcd.class.newInstance();
		ironfofiveswcd_datas.setDoc_id(docId);
		ironfofiveswcd_datas.setYhdl(map.get("yhdl").toString());
		ironfofiveswcd_datas.setLd(map.get("ld").toString());
		ironfofiveswcd_datas.setSwtcc(map.get("swtcc").toString());
		ironfofiveswcd_datas.setQtqzm(qtqzm);
		
		
		

		if(isnull == true) {
			//更新
			ironfofiveswcd_datas.setId(id);
			ironfofiveswcdService.updateironfo(ironfofiveswcd_datas);
			
		}else if(isnull == false) {
			//保存
			ironfofiveswcdService.save(ironfofiveswcd_datas);
			
		}
		
		
		return "redirect:"+Global.getAdminPath()+"/ironfofiveswcd/ironfofiveswcd/?repage";
	}
	
	/**
	 * 删除5.9室外场地
	 */
	@RequiresPermissions("ironfofiveswcd:ironfofiveswcd:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfofiveswcd ironfofiveswcd, RedirectAttributes redirectAttributes) {
		ironfofiveswcdService.delete(ironfofiveswcd);
		addMessage(redirectAttributes, "删除5.9室外场地成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofiveswcd/ironfofiveswcd/?repage";
	}
	
	/**
	 * 批量删除5.9室外场地
	 */
	@RequiresPermissions("ironfofiveswcd:ironfofiveswcd:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfofiveswcdService.delete(ironfofiveswcdService.get(id));
		}
		addMessage(redirectAttributes, "删除5.9室外场地成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofiveswcd/ironfofiveswcd/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfofiveswcd:ironfofiveswcd:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfofiveswcd ironfofiveswcd, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "5.9室外场地"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfofiveswcd> page = ironfofiveswcdService.findPage(new Page<Ironfofiveswcd>(request, response, -1), ironfofiveswcd);
    		new ExportExcel("5.9室外场地", Ironfofiveswcd.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出5.9室外场地记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofiveswcd/ironfofiveswcd/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfofiveswcd:ironfofiveswcd:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfofiveswcd> list = ei.getDataList(Ironfofiveswcd.class);
			for (Ironfofiveswcd ironfofiveswcd : list){
				try{
					ironfofiveswcdService.save(ironfofiveswcd);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条5.9室外场地记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条5.9室外场地记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入5.9室外场地失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofiveswcd/ironfofiveswcd/?repage";
    }
	
	/**
	 * 下载导入5.9室外场地数据模板
	 */
	@RequiresPermissions("ironfofiveswcd:ironfofiveswcd:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "5.9室外场地数据导入模板.xlsx";
    		List<Ironfofiveswcd> list = Lists.newArrayList(); 
    		new ExportExcel("5.9室外场地数据", Ironfofiveswcd.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofiveswcd/ironfofiveswcd/?repage";
    }
	
	
	

}