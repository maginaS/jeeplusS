/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofivezyyf.web;

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
import com.jeeplus.modules.ironfofiveyjyf.entity.Ironfofiveyjyf;
import com.jeeplus.modules.ironfofivezyyf.entity.Ironfofivezyyf;
import com.jeeplus.modules.ironfofivezyyf.service.IronfofivezyyfService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 5.4住院用房Controller
 * @author mikesun
 * @version 2018-04-14
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfofivezyyf/ironfofivezyyf")
public class IronfofivezyyfController extends BaseController {
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;

	@Autowired
	private IronfofivezyyfService ironfofivezyyfService;
	
	@ModelAttribute
	public Ironfofivezyyf get(@RequestParam(required=false) String id) {
		Ironfofivezyyf entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfofivezyyfService.get(id);
		}
		if (entity == null){
			entity = new Ironfofivezyyf();
		}
		return entity;
	}
	
	/**
	 * 5.4住院用房列表页面
	 */
	@RequiresPermissions("ironfofivezyyf:ironfofivezyyf:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfofivezyyf ironfofivezyyf, HttpServletRequest request, HttpServletResponse response, Model model) {

		
		
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
			
			Ironfofivezyyf ironfofivezyyf_data = null;
			
			try {
				ironfofivezyyf_data = Ironfofivezyyf.class.newInstance();
				ironfofivezyyf_data.setDoc_id(docList.get(0).getId().toString());
				List<Ironfofivezyyf> list_data = ironfofivezyyfService.queryForList(ironfofivezyyf_data);
				if(list_data.size()>0) {
					
					for(Ironfofivezyyf zyyf :list_data) {

						datas = new TreeMap<String,Object>();
						datas.put("id",zyyf.getId());
						datas.put("doc_id",docList.get(0).getId().toString());
						datas.put("gndyjzmj",zyyf.getGndyjzmj());
						datas.put("bf",zyyf.getBf());
						datas.put("hsz",zyyf.getHsz());
						datas.put("zlzbs",zyyf.getZlzbs());
						datas.put("zls",zyyf.getZls());
						datas.put("qjs",zyyf.getQjs());
						datas.put("yhbgs",zyyf.getYhbgs());
						datas.put("zybgs",zyyf.getZybgs());
						datas.put("zbs",zyyf.getZbs());
						datas.put("ksj",zyyf.getKsj());
						datas.put("wsj",zyyf.getWsj());
						datas.put("hxj",zyyf.getHxj());
						datas.put("lyj",zyyf.getLyj());
						datas.put("zzpcs",zyyf.getZzpcs());
						datas.put("hds",zyyf.getHds());
						datas.put("brct",zyyf.getBrct());
						datas.put("qtqzm",zyyf.getQtqzm());
						
					}
					
				}else {
					
					datas = new TreeMap<String,Object>();
					datas.put("id", "");
					datas.put("doc_id", "");
					datas.put("gndyjzmj", "");
					datas.put("bf", "0");
					datas.put("hsz", "0");
					datas.put("zlzbs", "0");
					datas.put("zls", "0");
					datas.put("qjs", "0");
					datas.put("yhbgs", "0");
					datas.put("zybgs", "0");
					datas.put("zbs", "0");
					datas.put("ksj", "0");
					datas.put("wsj", "0");
					datas.put("hxj", "0");
					datas.put("lyj", "0");
					datas.put("zzpcs", "0");
					datas.put("hds", "0");
					datas.put("brct", "0");
					datas.put("qtqzm", "");
					
				}
				
			}catch (Exception e) {
				
			}
		}
		
		
		request.setAttribute("data", datas);
		model.addAttribute("data", datas);
		
		
		
		return "modules/ironfofivezyyf/ironfofivezyyfList";
	}

	/**
	 * 查看，增加，编辑5.4住院用房表单页面
	 */
	@RequiresPermissions(value={"ironfofivezyyf:ironfofivezyyf:view","ironfofivezyyf:ironfofivezyyf:add","ironfofivezyyf:ironfofivezyyf:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfofivezyyf ironfofivezyyf, Model model) {
		model.addAttribute("ironfofivezyyf", ironfofivezyyf);
		return "modules/ironfofivezyyf/ironfofivezyyfForm";
	}

	/**
	 * 保存5.4住院用房
	 */
	@RequiresPermissions(value={"ironfofivezyyf:ironfofivezyyf:add","ironfofivezyyf:ironfofivezyyf:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfofivezyyf ironfofivezyyf, Model model, RedirectAttributes redirectAttributes) throws Exception{
		
		
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
			Ironfofivezyyf ironfofivezyyf_data = Ironfofivezyyf.class.newInstance();
			ironfofivezyyf_data.setDoc_id(docId);
			List<Ironfofivezyyf> fkjlx_data = ironfofivezyyfService.queryForList(ironfofivezyyf_data);
			
			if(fkjlx_data.size()>0) {
				isnull = true;
			}else {
				isnull = false;
			}
			
		}
		
		
		Ironfofivezyyf ironfofivezyyf_datas = Ironfofivezyyf.class.newInstance();
		ironfofivezyyf_datas.setDoc_id(docId);
		ironfofivezyyf_datas.setGndyjzmj(map.get("gndyjzmj").toString());
		ironfofivezyyf_datas.setBf(map.get("bf").toString());
		ironfofivezyyf_datas.setHsz(map.get("hsz").toString());
		ironfofivezyyf_datas.setZlzbs(map.get("zlzbs").toString());
		ironfofivezyyf_datas.setZls(map.get("zls").toString());
		ironfofivezyyf_datas.setQjs(map.get("qjs").toString());
		ironfofivezyyf_datas.setYhbgs(map.get("yhbgs").toString());
		ironfofivezyyf_datas.setZybgs(map.get("zybgs").toString());
		ironfofivezyyf_datas.setZbs(map.get("zbs").toString());
		ironfofivezyyf_datas.setKsj(map.get("ksj").toString());
		ironfofivezyyf_datas.setWsj(map.get("wsj").toString());
		ironfofivezyyf_datas.setHxj(map.get("hxj").toString());
		ironfofivezyyf_datas.setLyj(map.get("lyj").toString());
		ironfofivezyyf_datas.setZzpcs(map.get("zzpcs").toString());
		ironfofivezyyf_datas.setHds(map.get("hds").toString());
		ironfofivezyyf_datas.setBrct(map.get("brct").toString());
		ironfofivezyyf_datas.setQtqzm(qtqzm);
		
		
		
		if(isnull == true) {
			//更新
			ironfofivezyyf_datas.setId(id);
			ironfofivezyyfService.updateironfo(ironfofivezyyf_datas);
			
		}else if(isnull == false) {
			//保存
			ironfofivezyyfService.save(ironfofivezyyf_datas);
			
		}
		
		
		
		
		
		
		
		return "redirect:"+Global.getAdminPath()+"/ironfofivezyyf/ironfofivezyyf/?repage";
	}
	
	/**
	 * 删除5.4住院用房
	 */
	@RequiresPermissions("ironfofivezyyf:ironfofivezyyf:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfofivezyyf ironfofivezyyf, RedirectAttributes redirectAttributes) {
		ironfofivezyyfService.delete(ironfofivezyyf);
		addMessage(redirectAttributes, "删除5.4住院用房成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivezyyf/ironfofivezyyf/?repage";
	}
	
	/**
	 * 批量删除5.4住院用房
	 */
	@RequiresPermissions("ironfofivezyyf:ironfofivezyyf:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfofivezyyfService.delete(ironfofivezyyfService.get(id));
		}
		addMessage(redirectAttributes, "删除5.4住院用房成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivezyyf/ironfofivezyyf/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfofivezyyf:ironfofivezyyf:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfofivezyyf ironfofivezyyf, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "5.4住院用房"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfofivezyyf> page = ironfofivezyyfService.findPage(new Page<Ironfofivezyyf>(request, response, -1), ironfofivezyyf);
    		new ExportExcel("5.4住院用房", Ironfofivezyyf.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出5.4住院用房记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivezyyf/ironfofivezyyf/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfofivezyyf:ironfofivezyyf:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfofivezyyf> list = ei.getDataList(Ironfofivezyyf.class);
			for (Ironfofivezyyf ironfofivezyyf : list){
				try{
					ironfofivezyyfService.save(ironfofivezyyf);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条5.4住院用房记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条5.4住院用房记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入5.4住院用房失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivezyyf/ironfofivezyyf/?repage";
    }
	
	/**
	 * 下载导入5.4住院用房数据模板
	 */
	@RequiresPermissions("ironfofivezyyf:ironfofivezyyf:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "5.4住院用房数据导入模板.xlsx";
    		List<Ironfofivezyyf> list = Lists.newArrayList(); 
    		new ExportExcel("5.4住院用房数据", Ironfofivezyyf.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivezyyf/ironfofivezyyf/?repage";
    }
	
	
	

}