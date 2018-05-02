/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofiveyjyf.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

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
import com.jeeplus.modules.ironfofivemjzyf.entity.Ironfofivemjzyfkjlx;
import com.jeeplus.modules.ironfofiveyjyf.entity.Ironfofiveyjyf;
import com.jeeplus.modules.ironfofiveyjyf.service.IronfofiveyjyfService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 5.3医技用房Controller
 * @author mikesun
 * @version 2018-04-14
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfofiveyjyf/ironfofiveyjyf")
public class IronfofiveyjyfController extends BaseController {

	@Autowired
	private IronfofiveyjyfService ironfofiveyjyfService;
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	@ModelAttribute
	public Ironfofiveyjyf get(@RequestParam(required=false) String id) {
		Ironfofiveyjyf entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfofiveyjyfService.get(id);
		}
		if (entity == null){
			entity = new Ironfofiveyjyf();
		}
		return entity;
	}
	
	/**
	 * 5.3医技用房列表页面
	 */
	@RequiresPermissions("ironfofiveyjyf:ironfofiveyjyf:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfofiveyjyf ironfofiveyjyf, HttpServletRequest request, HttpServletResponse response, Model model) {
	

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
			Ironfofiveyjyf ironfofiveyjyf_data = null;
			try {
				ironfofiveyjyf_data = Ironfofiveyjyf.class.newInstance();
				ironfofiveyjyf_data.setDoc_id(docList.get(0).getId().toString());
				List<Ironfofiveyjyf> list_data = ironfofiveyjyfService.queryForList(ironfofiveyjyf_data);
				if(list_data.size()>0) {
					for(Ironfofiveyjyf yjyf : list_data) {
						
						datas = new TreeMap<String,Object>();
						datas.put("id",yjyf.getId());
						datas.put("doc_id",docList.get(0).getId().toString());
						datas.put("gndyjzmj",yjyf.getGndyjzmj());
						datas.put("mzxyfyjkyf",yjyf.getMzxyfyjkyf());
						datas.put("mzzyfyjkyf",yjyf.getMzzyfyjkyf());
						datas.put("jzyfyjkyf",yjyf.getJzyfyjkyf());
						datas.put("tsyfyjkyf",yjyf.getTsyfyjkyf());
						datas.put("jyfyjkyf",yjyf.getJyfyjkyf());
						datas.put("ypkyjkyf",yjyf.getYpkyjkyf());
						datas.put("cxsjykyf",yjyf.getCxsjykyf());
						datas.put("hysjykyf",yjyf.getHysjykyf());
						datas.put("xgjspsfskyf",yjyf.getXgjspsfskyf());
						datas.put("xgjkzsfskyf",yjyf.getXgjkzsfskyf());
						datas.put("ctspsfskyf",yjyf.getCtspsfskyf());
						datas.put("ctkzsfskyf",yjyf.getCtkzsfskyf());
						datas.put("dpsfskyf", yjyf.getDpsfskyf());
						datas.put("xdts",yjyf.getXdts());
						datas.put("css",yjyf.getCss());
						datas.put("xksxkyf",yjyf.getXksxkyf());
						datas.put("pxssxkyf",yjyf.getPxssxkyf());
						datas.put("qwqxdgys",yjyf.getQwqxdgys());
						datas.put("jcbzjmjqxdgys",yjyf.getJcbzjmjqxdgys());
						datas.put("wjwpcfqxdgys",yjyf.getWjwpcfqxdgys());
						datas.put("sssssb",yjyf.getSssssb());
						datas.put("cfssb",yjyf.getCfssb());
						datas.put("zbsssb",yjyf.getZbsssb());
						datas.put("dcsssb",yjyf.getDcsssb());
						datas.put("gysssb",yjyf.getGysssb());
						datas.put("xsjssb",yjyf.getXsjssb());
						datas.put("shsxsssb",yjyf.getShsxsssb());
						datas.put("qtqzm",yjyf.getQtqzm());
						
					}
					
				}else {
//					private String doc_id;		// 主表id
//					private String gndyjzmj;		// 功能单元建筑面积
					
					datas = new TreeMap<String,Object>();
					datas.put("id", "");
					datas.put("doc_id", "");
					datas.put("gndyjzmj", "");
					datas.put("mzxyfyjkyf", "0");
					datas.put("mzzyfyjkyf", "0");
					datas.put("jzyfyjkyf", "0");
					datas.put("tsyfyjkyf", "0");
					datas.put("jyfyjkyf", "0");
					datas.put("ypkyjkyf", "0");
					datas.put("cxsjykyf", "0");
					datas.put("hysjykyf", "0");
					datas.put("xgjspsfskyf", "0");
					datas.put("xgjkzsfskyf", "0");
					datas.put("ctspsfskyf", "0");
					datas.put("ctkzsfskyf", "0");
					datas.put("dpsfskyf", "0");
					datas.put("xdts", "0");
					datas.put("css", "0");
					datas.put("xksxkyf", "0");
					datas.put("pxssxkyf", "0");
					datas.put("qwqxdgys", "0");
					datas.put("jcbzjmjqxdgys", "0");
					datas.put("wjwpcfqxdgys", "0");
					datas.put("sssssb", "0");
					datas.put("cfssb", "0");
					datas.put("zbsssb", "0");
					datas.put("dcsssb", "0");
					datas.put("gysssb", "0");
					datas.put("xsjssb", "0");
					datas.put("shsxsssb", "0");
					datas.put("qtqzm", "");
					
				}
				
			} catch (Exception e) {
				
			}
			
		}
		
		
		request.setAttribute("data", datas);
		model.addAttribute("data", datas);
		
		
		return "modules/ironfofiveyjyf/ironfofiveyjyfList";
	}

	/**
	 * 查看，增加，编辑5.3医技用房表单页面
	 */
	@RequiresPermissions(value={"ironfofiveyjyf:ironfofiveyjyf:view","ironfofiveyjyf:ironfofiveyjyf:add","ironfofiveyjyf:ironfofiveyjyf:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfofiveyjyf ironfofiveyjyf, Model model) {
		model.addAttribute("ironfofiveyjyf", ironfofiveyjyf);
		return "modules/ironfofiveyjyf/ironfofiveyjyfForm";
	}

	/**
	 * 保存5.3医技用房
	 */
	@RequiresPermissions(value={"ironfofiveyjyf:ironfofiveyjyf:add","ironfofiveyjyf:ironfofiveyjyf:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfofiveyjyf ironfofiveyjyf, Model model, RedirectAttributes redirectAttributes) throws Exception{
		
		
		

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
			Ironfofiveyjyf ironfofiveyjyf_data = Ironfofiveyjyf.class.newInstance();
			ironfofiveyjyf_data.setDoc_id(docId);
			List<Ironfofiveyjyf> fkjlx_data = ironfofiveyjyfService.queryForList(ironfofiveyjyf_data);
			
			if(fkjlx_data.size()>0) {
				isnull = true;
			}else {
				isnull = false;
			}
			
		}
		
//		private String doc_id;		// 主表id
		
		Ironfofiveyjyf ironfofiveyjyf_datas = Ironfofiveyjyf.class.newInstance();
		ironfofiveyjyf_datas.setDoc_id(docId);
		ironfofiveyjyf_datas.setGndyjzmj(map.get("gndyjzmj").toString());
		ironfofiveyjyf_datas.setMzxyfyjkyf(map.get("mzxyfyjkyf").toString());
		ironfofiveyjyf_datas.setMzzyfyjkyf(map.get("mzzyfyjkyf").toString());
		ironfofiveyjyf_datas.setJzyfyjkyf(map.get("jzyfyjkyf").toString());
		ironfofiveyjyf_datas.setTsyfyjkyf(map.get("tsyfyjkyf").toString());
		ironfofiveyjyf_datas.setJyfyjkyf(map.get("jyfyjkyf").toString());
		ironfofiveyjyf_datas.setYpkyjkyf(map.get("ypkyjkyf").toString());
		ironfofiveyjyf_datas.setCxsjykyf(map.get("cxsjykyf").toString());
		ironfofiveyjyf_datas.setHysjykyf(map.get("hysjykyf").toString());
		ironfofiveyjyf_datas.setXgjspsfskyf(map.get("xgjspsfskyf").toString());
		ironfofiveyjyf_datas.setXgjkzsfskyf(map.get("xgjkzsfskyf").toString());
		ironfofiveyjyf_datas.setCtspsfskyf(map.get("ctspsfskyf").toString());
		ironfofiveyjyf_datas.setCtkzsfskyf(map.get("ctkzsfskyf").toString());
		ironfofiveyjyf_datas.setDpsfskyf(map.get("dpsfskyf").toString());
		ironfofiveyjyf_datas.setXdts(map.get("xdts").toString());
		ironfofiveyjyf_datas.setCss(map.get("css").toString());
		ironfofiveyjyf_datas.setXksxkyf(map.get("xksxkyf").toString());
		ironfofiveyjyf_datas.setPxssxkyf(map.get("pxssxkyf").toString());
		ironfofiveyjyf_datas.setQwqxdgys(map.get("qwqxdgys").toString());
		ironfofiveyjyf_datas.setJcbzjmjqxdgys(map.get("jcbzjmjqxdgys").toString());
		ironfofiveyjyf_datas.setWjwpcfqxdgys(map.get("wjwpcfqxdgys").toString());
		ironfofiveyjyf_datas.setSssssb(map.get("sssssb").toString());
		ironfofiveyjyf_datas.setCfssb(map.get("cfssb").toString());
		ironfofiveyjyf_datas.setZbsssb(map.get("zbsssb").toString());
		ironfofiveyjyf_datas.setDcsssb(map.get("dcsssb").toString());
		ironfofiveyjyf_datas.setGysssb(map.get("gysssb").toString());
		ironfofiveyjyf_datas.setXsjssb(map.get("xsjssb").toString());
		ironfofiveyjyf_datas.setShsxsssb(map.get("shsxsssb").toString());
		ironfofiveyjyf_datas.setQtqzm(qtqzm);
		
		
		if(isnull == true) {
			//更新
			ironfofiveyjyf_datas.setId(id);
			ironfofiveyjyfService.updateironfo(ironfofiveyjyf_datas);
			
		}else if(isnull == false) {
			//保存
			ironfofiveyjyfService.save(ironfofiveyjyf_datas);
			
		}
		
		
		
		
		
		
		
		
		
		return "redirect:"+Global.getAdminPath()+"/ironfofiveyjyf/ironfofiveyjyf/?repage";
	}
	
	/**
	 * 删除5.3医技用房
	 */
	@RequiresPermissions("ironfofiveyjyf:ironfofiveyjyf:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfofiveyjyf ironfofiveyjyf, RedirectAttributes redirectAttributes) {
		ironfofiveyjyfService.delete(ironfofiveyjyf);
		addMessage(redirectAttributes, "删除5.3医技用房成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofiveyjyf/ironfofiveyjyf/?repage";
	}
	
	/**
	 * 批量删除5.3医技用房
	 */
	@RequiresPermissions("ironfofiveyjyf:ironfofiveyjyf:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfofiveyjyfService.delete(ironfofiveyjyfService.get(id));
		}
		addMessage(redirectAttributes, "删除5.3医技用房成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofiveyjyf/ironfofiveyjyf/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfofiveyjyf:ironfofiveyjyf:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfofiveyjyf ironfofiveyjyf, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "5.3医技用房"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfofiveyjyf> page = ironfofiveyjyfService.findPage(new Page<Ironfofiveyjyf>(request, response, -1), ironfofiveyjyf);
    		new ExportExcel("5.3医技用房", Ironfofiveyjyf.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出5.3医技用房记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofiveyjyf/ironfofiveyjyf/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfofiveyjyf:ironfofiveyjyf:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfofiveyjyf> list = ei.getDataList(Ironfofiveyjyf.class);
			for (Ironfofiveyjyf ironfofiveyjyf : list){
				try{
					ironfofiveyjyfService.save(ironfofiveyjyf);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条5.3医技用房记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条5.3医技用房记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入5.3医技用房失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofiveyjyf/ironfofiveyjyf/?repage";
    }
	
	/**
	 * 下载导入5.3医技用房数据模板
	 */
	@RequiresPermissions("ironfofiveyjyf:ironfofiveyjyf:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "5.3医技用房数据导入模板.xlsx";
    		List<Ironfofiveyjyf> list = Lists.newArrayList(); 
    		new ExportExcel("5.3医技用房数据", Ironfofiveyjyf.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofiveyjyf/ironfofiveyjyf/?repage";
    }
	
	
	

}