/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofiveggwsyf.web;

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
import com.jeeplus.modules.ironfofiveggwsyf.service.IronfofiveggwsyfService;
import com.jeeplus.modules.ironfofivezyyf.entity.Ironfofivezyyf;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 5.5公共卫生用房Controller
 * @author mikesun
 * @version 2018-04-15
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfofiveggwsyf/ironfofiveggwsyf")
public class IronfofiveggwsyfController extends BaseController {

	
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	@Autowired
	private IronfofiveggwsyfService ironfofiveggwsyfService;
	
	@ModelAttribute
	public Ironfofiveggwsyf get(@RequestParam(required=false) String id) {
		Ironfofiveggwsyf entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfofiveggwsyfService.get(id);
		}
		if (entity == null){
			entity = new Ironfofiveggwsyf();
		}
		return entity;
	}
	
	/**
	 * 5.5公共卫生用房列表页面
	 */
	@RequiresPermissions("ironfofiveggwsyf:ironfofiveggwsyf:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfofiveggwsyf ironfofiveggwsyf, HttpServletRequest request, HttpServletResponse response, Model model) {
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
			Ironfofiveggwsyf ironfofiveggwsyf_data = null;
			try {
				ironfofiveggwsyf_data = Ironfofiveggwsyf.class.newInstance();
				ironfofiveggwsyf_data.setDoc_id(docList.get(0).getId().toString());
				
				List<Ironfofiveggwsyf> list_data = ironfofiveggwsyfService.queryForList(ironfofiveggwsyf_data);
				
				if(list_data.size()>0) {
					for(Ironfofiveggwsyf ggwsyf : list_data) {
						datas = new TreeMap<String,Object>();
						datas.put("gndyjzmj",ggwsyf.getGndyjzmj());
						datas.put("jkdas",ggwsyf.getJkdas());
						datas.put("jkjys",ggwsyf.getJkjys());
						datas.put("yjqjzdt",ggwsyf.getYjqjzdt());
						datas.put("hzqjzdt",ggwsyf.getHzqjzdt());
						datas.put("jzqjzdt",ggwsyf.getJzqjzdt());
						datas.put("lnqjzdt",ggwsyf.getLnqjzdt());
						datas.put("fnbjsjzdt",ggwsyf.getFnbjsjzdt());
						datas.put("etbjsjzdt",ggwsyf.getEtbjsjzdt());
						datas.put("lnrbjsjzdt",ggwsyf.getLnrbjsjzdt());
						datas.put("ybjcqtjzx",ggwsyf.getYbjcqtjzx());
						datas.put("kqjcqtjzx",ggwsyf.getKqjcqtjzx());
						datas.put("tljcqtjzx",ggwsyf.getTljcqtjzx());
						datas.put("sljcqtjzx",ggwsyf.getSljcqtjzx());
						datas.put("zljcqtjzx",ggwsyf.getZljcqtjzx());
						datas.put("nanwkjcstjzx",ggwsyf.getNanwkjcstjzx());
						datas.put("nvwkjcstjzx",ggwsyf.getNvwkjcstjzx());
						datas.put("qtqzm",ggwsyf.getQtqzm());
						datas.put("doc_id", docList.get(0).getId().toString());
						datas.put("id", ggwsyf.getId());
						
					}
					
				}else {
					datas = new TreeMap<String,Object>();
					datas.put("gndyjzmj", "");
					datas.put("jkdas", "0");
					datas.put("jkjys", "0");
					datas.put("yjqjzdt", "0");
					datas.put("hzqjzdt", "0");
					datas.put("jzqjzdt", "0");
					datas.put("lnqjzdt", "0");
					datas.put("fnbjsjzdt", "0");
					datas.put("etbjsjzdt", "0");
					datas.put("lnrbjsjzdt", "0");
					datas.put("ybjcqtjzx", "0");
					datas.put("kqjcqtjzx", "0");
					datas.put("tljcqtjzx", "0");
					datas.put("sljcqtjzx", "0");
					datas.put("zljcqtjzx", "0");
					datas.put("nanwkjcstjzx", "0");
					datas.put("nvwkjcstjzx", "0");
					datas.put("qtqzm", "");
					datas.put("doc_id", "");
					datas.put("id","");
					
				}
				
			} catch (Exception e) {
				
			}
			
		}
		
		
		request.setAttribute("data", datas);
		model.addAttribute("data", datas);
		
		return "modules/ironfofiveggwsyf/ironfofiveggwsyfList";
	}

	/**
	 * 查看，增加，编辑5.5公共卫生用房表单页面
	 */
	@RequiresPermissions(value={"ironfofiveggwsyf:ironfofiveggwsyf:view","ironfofiveggwsyf:ironfofiveggwsyf:add","ironfofiveggwsyf:ironfofiveggwsyf:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfofiveggwsyf ironfofiveggwsyf, Model model) {
		model.addAttribute("ironfofiveggwsyf", ironfofiveggwsyf);
		return "modules/ironfofiveggwsyf/ironfofiveggwsyfForm";
	}

	/**
	 * 保存5.5公共卫生用房
	 */
	@RequiresPermissions(value={"ironfofiveggwsyf:ironfofiveggwsyf:add","ironfofiveggwsyf:ironfofiveggwsyf:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfofiveggwsyf ironfofiveggwsyf, Model model, RedirectAttributes redirectAttributes) throws Exception{
		
		

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
			Ironfofiveggwsyf ironfofiveggwsyf_data = Ironfofiveggwsyf.class.newInstance();
			ironfofiveggwsyf_data.setDoc_id(docId);
			List<Ironfofiveggwsyf> fkjlx_data = ironfofiveggwsyfService.queryForList(ironfofiveggwsyf_data);
			
			if(fkjlx_data.size()>0) {
				isnull = true;
			}else {
				isnull = false;
			}
			
		}
		
		
		
		
		
		Ironfofiveggwsyf ironfofiveggwsyf_datas = Ironfofiveggwsyf.class.newInstance();
		ironfofiveggwsyf_datas.setGndyjzmj(map.get("gndyjzmj").toString());
		ironfofiveggwsyf_datas.setJkdas(map.get("jkdas").toString());
		ironfofiveggwsyf_datas.setJkjys(map.get("jkjys").toString());
		ironfofiveggwsyf_datas.setYjqjzdt(map.get("yjqjzdt").toString());
		ironfofiveggwsyf_datas.setHzqjzdt(map.get("hzqjzdt").toString());
		ironfofiveggwsyf_datas.setJzqjzdt(map.get("jzqjzdt").toString());
		ironfofiveggwsyf_datas.setLnqjzdt(map.get("lnqjzdt").toString());
		ironfofiveggwsyf_datas.setFnbjsjzdt(map.get("fnbjsjzdt").toString());
		ironfofiveggwsyf_datas.setEtbjsjzdt(map.get("etbjsjzdt").toString());
		ironfofiveggwsyf_datas.setLnrbjsjzdt(map.get("lnrbjsjzdt").toString());
		ironfofiveggwsyf_datas.setYbjcqtjzx(map.get("ybjcqtjzx").toString());
		ironfofiveggwsyf_datas.setKqjcqtjzx(map.get("kqjcqtjzx").toString());
		ironfofiveggwsyf_datas.setTljcqtjzx(map.get("tljcqtjzx").toString());
		ironfofiveggwsyf_datas.setSljcqtjzx(map.get("sljcqtjzx").toString());
		ironfofiveggwsyf_datas.setZljcqtjzx(map.get("zljcqtjzx").toString());
		ironfofiveggwsyf_datas.setNanwkjcstjzx(map.get("nanwkjcstjzx").toString());
		ironfofiveggwsyf_datas.setNvwkjcstjzx(map.get("nvwkjcstjzx").toString());
		ironfofiveggwsyf_datas.setQtqzm(qtqzm);
		ironfofiveggwsyf_datas.setDoc_id(docId);
		
		
		if(isnull == true) {
			//更新
			ironfofiveggwsyf_datas.setId(id);
			ironfofiveggwsyfService.updateironfo(ironfofiveggwsyf_datas);
			
		}else if(isnull == false) {
			//保存
			ironfofiveggwsyfService.save(ironfofiveggwsyf_datas);
			
		}
		
		
		
		
		
		
		return "redirect:"+Global.getAdminPath()+"/ironfofiveggwsyf/ironfofiveggwsyf/?repage";
	}
	
	/**
	 * 删除5.5公共卫生用房
	 */
	@RequiresPermissions("ironfofiveggwsyf:ironfofiveggwsyf:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfofiveggwsyf ironfofiveggwsyf, RedirectAttributes redirectAttributes) {
		ironfofiveggwsyfService.delete(ironfofiveggwsyf);
		addMessage(redirectAttributes, "删除5.5公共卫生用房成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofiveggwsyf/ironfofiveggwsyf/?repage";
	}
	
	/**
	 * 批量删除5.5公共卫生用房
	 */
	@RequiresPermissions("ironfofiveggwsyf:ironfofiveggwsyf:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfofiveggwsyfService.delete(ironfofiveggwsyfService.get(id));
		}
		addMessage(redirectAttributes, "删除5.5公共卫生用房成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofiveggwsyf/ironfofiveggwsyf/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfofiveggwsyf:ironfofiveggwsyf:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfofiveggwsyf ironfofiveggwsyf, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "5.5公共卫生用房"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfofiveggwsyf> page = ironfofiveggwsyfService.findPage(new Page<Ironfofiveggwsyf>(request, response, -1), ironfofiveggwsyf);
    		new ExportExcel("5.5公共卫生用房", Ironfofiveggwsyf.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出5.5公共卫生用房记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofiveggwsyf/ironfofiveggwsyf/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfofiveggwsyf:ironfofiveggwsyf:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfofiveggwsyf> list = ei.getDataList(Ironfofiveggwsyf.class);
			for (Ironfofiveggwsyf ironfofiveggwsyf : list){
				try{
					ironfofiveggwsyfService.save(ironfofiveggwsyf);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条5.5公共卫生用房记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条5.5公共卫生用房记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入5.5公共卫生用房失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofiveggwsyf/ironfofiveggwsyf/?repage";
    }
	
	/**
	 * 下载导入5.5公共卫生用房数据模板
	 */
	@RequiresPermissions("ironfofiveggwsyf:ironfofiveggwsyf:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "5.5公共卫生用房数据导入模板.xlsx";
    		List<Ironfofiveggwsyf> list = Lists.newArrayList(); 
    		new ExportExcel("5.5公共卫生用房数据", Ironfofiveggwsyf.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofiveggwsyf/ironfofiveggwsyf/?repage";
    }
	
	
	

}