/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofiveznglyf.web;

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
import com.jeeplus.modules.ironfofiveznglyf.entity.Ironfofiveznglyf;
import com.jeeplus.modules.ironfofiveznglyf.service.IronfofiveznglyfService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 5.7职能管理用房Controller
 * @author mikesun
 * @version 2018-04-15
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfofiveznglyf/ironfofiveznglyf")
public class IronfofiveznglyfController extends BaseController {

	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	
	@Autowired
	private IronfofiveznglyfService ironfofiveznglyfService;
	
	@ModelAttribute
	public Ironfofiveznglyf get(@RequestParam(required=false) String id) {
		Ironfofiveznglyf entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfofiveznglyfService.get(id);
		}
		if (entity == null){
			entity = new Ironfofiveznglyf();
		}
		return entity;
	}
	
	/**
	 * 5.7职能管理用房列表页面
	 */
	@RequiresPermissions("ironfofiveznglyf:ironfofiveznglyf:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfofiveznglyf ironfofiveznglyf, HttpServletRequest request, HttpServletResponse response, Model model) {
	
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
			Ironfofiveznglyf ironfofiveznglyf_data = null;
			
			try {
				ironfofiveznglyf_data = Ironfofiveznglyf.class.newInstance();
				
				ironfofiveznglyf_data.setDoc_id(docList.get(0).getId().toString());
				
				List<Ironfofiveznglyf> list_data = ironfofiveznglyfService.queryForList(ironfofiveznglyf_data);
				
				if(list_data.size()>0) {
					for(Ironfofiveznglyf znglyf:list_data) {
						datas = new TreeMap<String,Object>();
						datas.put("id",znglyf.getId());
						datas.put("doc_id",docList.get(0).getId().toString());
						datas.put("gndyjzmj",znglyf.getGndyjzmj());
						datas.put("yzbgs",znglyf.getYzbgs());
						datas.put("djbgs",znglyf.getDjbgs());
						datas.put("ywkbgs",znglyf.getYwkbgs());
						datas.put("hlkbgs",znglyf.getHlkbgs());
						datas.put("cwkbgs",znglyf.getCwkbgs());
						datas.put("daglkbgs",znglyf.getDaglkbgs());
						datas.put("xxzx",znglyf.getXxzx());
						datas.put("ygkbgs",znglyf.getYgkbgs());
						datas.put("ybjskbgs",znglyf.getYbjskbgs());
						datas.put("hqglkbgs",znglyf.getHqglkbgs());
						datas.put("dgnhys",znglyf.getDgnhys());
						datas.put("xyf",znglyf.getXyf());
						datas.put("yycf",znglyf.getYycf());
						datas.put("ylljzcjljzcj",znglyf.getYlljzcjljzcj());
						datas.put("shljzcjljzcj",znglyf.getShljzcjljzcj());
						datas.put("tpj",znglyf.getTpj());
						datas.put("bpdsbpdyf",znglyf.getBpdsbpdyf());
						datas.put("bpdzbsbpdyf",znglyf.getBpdzbsbpdyf());
						datas.put("cyfdjfcyfdyf",znglyf.getCyfdjfcyfdyf());
						datas.put("ykcyfdyf", znglyf.getYkcyfdyf());
						datas.put("dtjf",znglyf.getDtjf());
						datas.put("glfglyf",znglyf.getGlfglyf());
						datas.put("glkzsglyf",znglyf.getGlkzsglyf());
						datas.put("rqbjglyf",znglyf.getRqbjglyf());
						datas.put("lsjf",znglyf.getLsjf());
						datas.put("ktjf",znglyf.getKtjf());
						datas.put("tfjf",znglyf.getTfjf());
						datas.put("gsbf",znglyf.getGsbf());
						datas.put("xfbf",znglyf.getXfbf());
						datas.put("bjzs",znglyf.getBjzs());
						datas.put("xfsxj",znglyf.getXfsxj());
						datas.put("xfkzs",znglyf.getXfkzs());
						datas.put("afjks",znglyf.getAfjks());
						datas.put("txwljf",znglyf.getTxwljf());
						datas.put("xxhxtjf",znglyf.getXxhxtjf());
						datas.put("mws",znglyf.getMws());
						datas.put("sntcc",znglyf.getSntcc());
						datas.put("qtqzm",znglyf.getQtqzm());
						
					}
					
				}else {
					datas = new TreeMap<String,Object>();
					datas.put("id", "");
					datas.put("doc_id", "");
					datas.put("gndyjzmj", "");
					datas.put("yzbgs", "0");
					datas.put("djbgs", "0");
					datas.put("ywkbgs", "0");
					datas.put("hlkbgs", "0");
					datas.put("cwkbgs", "0");
					datas.put("daglkbgs", "0");
					datas.put("xxzx", "0");
					datas.put("ygkbgs", "0");
					datas.put("ybjskbgs", "0");
					datas.put("hqglkbgs", "0");
					datas.put("dgnhys", "0");
					datas.put("xyf", "0");
					datas.put("yycf", "0");
					datas.put("ylljzcjljzcj", "0");
					datas.put("shljzcjljzcj", "0");
					datas.put("tpj", "0");
					datas.put("bpdsbpdyf", "0");
					datas.put("bpdzbsbpdyf", "0");
					datas.put("cyfdjfcyfdyf", "0");
					datas.put("ykcyfdyf", "0");
					datas.put("dtjf", "0");
					datas.put("glfglyf", "0");
					datas.put("glkzsglyf", "0");
					datas.put("rqbjglyf", "0");
					datas.put("lsjf", "0");
					datas.put("ktjf", "0");
					datas.put("tfjf", "0");
					datas.put("gsbf", "0");
					datas.put("xfbf", "0");
					datas.put("bjzs", "0");
					datas.put("xfsxj", "0");
					datas.put("xfkzs", "0");
					datas.put("afjks", "0");
					datas.put("txwljf", "0");
					datas.put("xxhxtjf", "0");
					datas.put("mws", "0");
					datas.put("sntcc", "0");
					datas.put("qtqzm", "");
					
				}
			} catch (Exception e) {
			}
			
		}
		
		
		
		
		request.setAttribute("data", datas);
		model.addAttribute("data", datas);
		return "modules/ironfofiveznglyf/ironfofiveznglyfList";
	}

	/**
	 * 查看，增加，编辑5.7职能管理用房表单页面
	 */
	@RequiresPermissions(value={"ironfofiveznglyf:ironfofiveznglyf:view","ironfofiveznglyf:ironfofiveznglyf:add","ironfofiveznglyf:ironfofiveznglyf:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfofiveznglyf ironfofiveznglyf, Model model) {
		model.addAttribute("ironfofiveznglyf", ironfofiveznglyf);
		return "modules/ironfofiveznglyf/ironfofiveznglyfForm";
	}

	/**
	 * 保存5.7职能管理用房
	 */
	@RequiresPermissions(value={"ironfofiveznglyf:ironfofiveznglyf:add","ironfofiveznglyf:ironfofiveznglyf:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfofiveznglyf ironfofiveznglyf, Model model, RedirectAttributes redirectAttributes) throws Exception{
		
		
		
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
			Ironfofiveznglyf ironfofiveznglyf_data = Ironfofiveznglyf.class.newInstance();
			ironfofiveznglyf_data.setDoc_id(docId);
			List<Ironfofiveznglyf> fkjlx_data = ironfofiveznglyfService.queryForList(ironfofiveznglyf_data);
			
			if(fkjlx_data.size()>0) {
				isnull = true;
			}else {
				isnull = false;
			}
			
		}
		
		Ironfofiveznglyf ironfofiveznglyf_datas = Ironfofiveznglyf.class.newInstance();
		ironfofiveznglyf_datas.setDoc_id(docId);
		ironfofiveznglyf_datas.setGndyjzmj(map.get("gndyjzmj").toString());
		ironfofiveznglyf_datas.setYzbgs(map.get("yzbgs").toString());
		ironfofiveznglyf_datas.setDjbgs(map.get("djbgs").toString());
		ironfofiveznglyf_datas.setYwkbgs(map.get("ywkbgs").toString());
		ironfofiveznglyf_datas.setHlkbgs(map.get("hlkbgs").toString());
		ironfofiveznglyf_datas.setCwkbgs(map.get("cwkbgs").toString());
		ironfofiveznglyf_datas.setDaglkbgs(map.get("daglkbgs").toString());
		ironfofiveznglyf_datas.setXxzx(map.get("xxzx").toString());
		ironfofiveznglyf_datas.setYgkbgs(map.get("ygkbgs").toString());
		ironfofiveznglyf_datas.setYbjskbgs(map.get("ybjskbgs").toString());
		ironfofiveznglyf_datas.setHqglkbgs(map.get("hqglkbgs").toString());
		ironfofiveznglyf_datas.setDgnhys(map.get("dgnhys").toString());
		ironfofiveznglyf_datas.setXyf(map.get("xyf").toString());
		ironfofiveznglyf_datas.setYycf(map.get("yycf").toString());
		ironfofiveznglyf_datas.setYlljzcjljzcj(map.get("ylljzcjljzcj").toString());
		ironfofiveznglyf_datas.setShljzcjljzcj(map.get("shljzcjljzcj").toString());
		ironfofiveznglyf_datas.setTpj(map.get("tpj").toString());
		ironfofiveznglyf_datas.setBpdsbpdyf(map.get("bpdsbpdyf").toString());
		ironfofiveznglyf_datas.setBpdzbsbpdyf(map.get("bpdzbsbpdyf").toString());
		ironfofiveznglyf_datas.setCyfdjfcyfdyf(map.get("cyfdjfcyfdyf").toString());
		ironfofiveznglyf_datas.setYkcyfdyf(map.get("ykcyfdyf").toString());
		ironfofiveznglyf_datas.setDtjf(map.get("dtjf").toString());
		ironfofiveznglyf_datas.setGlfglyf(map.get("glfglyf").toString());
		ironfofiveznglyf_datas.setGlkzsglyf(map.get("glkzsglyf").toString());
		ironfofiveznglyf_datas.setRqbjglyf(map.get("rqbjglyf").toString());
		ironfofiveznglyf_datas.setLsjf(map.get("lsjf").toString());
		ironfofiveznglyf_datas.setKtjf(map.get("ktjf").toString());
		ironfofiveznglyf_datas.setTfjf(map.get("tfjf").toString());
		ironfofiveznglyf_datas.setGsbf(map.get("gsbf").toString());
		ironfofiveznglyf_datas.setXfbf(map.get("xfbf").toString());
		ironfofiveznglyf_datas.setBjzs(map.get("bjzs").toString());
		ironfofiveznglyf_datas.setXfsxj(map.get("xfsxj").toString());
		ironfofiveznglyf_datas.setXfkzs(map.get("xfkzs").toString());
		ironfofiveznglyf_datas.setAfjks(map.get("afjks").toString());
		ironfofiveznglyf_datas.setTxwljf(map.get("txwljf").toString());
		ironfofiveznglyf_datas.setXxhxtjf(map.get("xxhxtjf").toString());
		ironfofiveznglyf_datas.setMws(map.get("mws").toString());
		ironfofiveznglyf_datas.setSntcc(map.get("sntcc").toString());
		ironfofiveznglyf_datas.setQtqzm(qtqzm);
		
		
		if(isnull == true) {
			//更新
			ironfofiveznglyf_datas.setId(id);
			ironfofiveznglyfService.updateironfo(ironfofiveznglyf_datas);
			
		}else if(isnull == false) {
			//保存
			ironfofiveznglyfService.save(ironfofiveznglyf_datas);
			
		}
		
		
		
		
		
		return "redirect:"+Global.getAdminPath()+"/ironfofiveznglyf/ironfofiveznglyf/?repage";
	}
	
	/**
	 * 删除5.7职能管理用房
	 */
	@RequiresPermissions("ironfofiveznglyf:ironfofiveznglyf:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfofiveznglyf ironfofiveznglyf, RedirectAttributes redirectAttributes) {
		ironfofiveznglyfService.delete(ironfofiveznglyf);
		addMessage(redirectAttributes, "删除5.7职能管理用房成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofiveznglyf/ironfofiveznglyf/?repage";
	}
	
	/**
	 * 批量删除5.7职能管理用房
	 */
	@RequiresPermissions("ironfofiveznglyf:ironfofiveznglyf:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfofiveznglyfService.delete(ironfofiveznglyfService.get(id));
		}
		addMessage(redirectAttributes, "删除5.7职能管理用房成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofiveznglyf/ironfofiveznglyf/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfofiveznglyf:ironfofiveznglyf:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfofiveznglyf ironfofiveznglyf, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "5.7职能管理用房"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfofiveznglyf> page = ironfofiveznglyfService.findPage(new Page<Ironfofiveznglyf>(request, response, -1), ironfofiveznglyf);
    		new ExportExcel("5.7职能管理用房", Ironfofiveznglyf.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出5.7职能管理用房记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofiveznglyf/ironfofiveznglyf/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfofiveznglyf:ironfofiveznglyf:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfofiveznglyf> list = ei.getDataList(Ironfofiveznglyf.class);
			for (Ironfofiveznglyf ironfofiveznglyf : list){
				try{
					ironfofiveznglyfService.save(ironfofiveznglyf);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条5.7职能管理用房记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条5.7职能管理用房记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入5.7职能管理用房失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofiveznglyf/ironfofiveznglyf/?repage";
    }
	
	/**
	 * 下载导入5.7职能管理用房数据模板
	 */
	@RequiresPermissions("ironfofiveznglyf:ironfofiveznglyf:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "5.7职能管理用房数据导入模板.xlsx";
    		List<Ironfofiveznglyf> list = Lists.newArrayList(); 
    		new ExportExcel("5.7职能管理用房数据", Ironfofiveznglyf.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofiveznglyf/ironfofiveznglyf/?repage";
    }
	
	
	

}