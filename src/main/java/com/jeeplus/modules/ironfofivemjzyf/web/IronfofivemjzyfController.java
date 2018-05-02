/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofivemjzyf.web;

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
import com.jeeplus.modules.ironfofivemjzyf.entity.Ironfofivemjzyf;
import com.jeeplus.modules.ironfofivemjzyf.entity.Ironfofivemjzyfkjlx;
import com.jeeplus.modules.ironfofivemjzyf.service.IronfofivemjzyfService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 5.2门急诊用房Controller
 * @author mikesun
 * @version 2018-04-13
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfofivemjzyf/ironfofivemjzyf")
public class IronfofivemjzyfController extends BaseController {

	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	@Autowired
	private IronfofivemjzyfService ironfofivemjzyfService;
	
	@ModelAttribute
	public Ironfofivemjzyf get(@RequestParam(required=false) String id) {
		Ironfofivemjzyf entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfofivemjzyfService.get(id);
		}
		if (entity == null){
			entity = new Ironfofivemjzyf();
		}
		return entity;
	}
	
	/**
	 * 5.2门急诊用房列表页面
	 */
	@RequiresPermissions("ironfofivemjzyf:ironfofivemjzyf:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfofivemjzyf ironfofivemjzyf, HttpServletRequest request, HttpServletResponse response, Model model) {

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
			Ironfofivemjzyfkjlx kjlx = null;
			
			try {
				kjlx = Ironfofivemjzyfkjlx.class.newInstance();
				kjlx.setDoc_id(docList.get(0).getId().toString());
				List<Ironfofivemjzyfkjlx> list_data = ironfofivemjzyfService.queryForList(kjlx);
				if(list_data.size()>0) {
					for(Ironfofivemjzyfkjlx fjlx :list_data) {
						datas = new TreeMap<String,Object>();
						
						datas.put("doc_id", docList.get(0).getId().toString());
						datas.put("gkzswkyf", fjlx.getGkzswkyf());
						datas.put("ptwkzswkyf", fjlx.getPtwkzswkyf());
						datas.put("cdjfrmzsnkyf",fjlx.getCdjfrmzsnkyf());
						datas.put("ptnkzsnkyf",fjlx.getPtnkzsnkyf());
						datas.put("qkylkzs",fjlx.getQkylkzs());
						datas.put("hzq",fjlx.getHzq());
						datas.put("fzt",fjlx.getFzt());
						datas.put("jgskqkyf",fjlx.getJgskqkyf());
						datas.put("ykzs",fjlx.getYkzs());
						datas.put("fwzx",fjlx.getFwzx());
						datas.put("pfkzs",fjlx.getPfkzs());
						datas.put("grxjbkzsgrxjbkyf",fjlx.getGrxjbkzsgrxjbkyf());
						datas.put("glsgrxjbkyf", fjlx.getGlsgrxjbkyf());
						datas.put("id", fjlx.getId());
//						datas.put("qtqzm", fjlx.getQtqzm());
						
						
						
						datas.put("fckzsfckyf",fjlx.getFckzsfckyf());
						datas.put("jcsfckyf",fjlx.getJcsfckyf());
						datas.put("ekzs", fjlx.getEkzs());
						datas.put("zykzszykyf",fjlx.getZykzszykyf());
						datas.put("zyzlszykyf",fjlx.getZyzlszykyf());
						datas.put("kqkzskqkyf",fjlx.getKqkzskqkyf());
						datas.put("kqzlskqkyf",fjlx.getKqzlskqkyf());
						datas.put("jgskqkyf",fjlx.getJgskqkyf());
						datas.put("ykzs",fjlx.getYkzs());
						datas.put("ebhkzs",fjlx.getEbhkzs());
						datas.put("pfkzs",fjlx.getPfkzs());
						datas.put("grxjbkzsgrxjbkyf",fjlx.getGrxjbkzsgrxjbkyf());
						datas.put("glsgrxjbkyf",fjlx.getGlsgrxjbkyf());
						
						datas.put("ghsfs",fjlx.getGhsfs());
						datas.put("qtqzm",fjlx.getQtqzm());
						datas.put("yszbsjzkyf",fjlx.getYszbsjzkyf());
						datas.put("lgsjzkyf",fjlx.getLgsjzkyf());
						datas.put("qjsjzkyf",fjlx.getQjsjzkyf());
						datas.put("jzkzsjzkyf",fjlx.getJzkzsjzkyf());
						datas.put("zsgcssyyf",fjlx.getZsgcssyyf());
						datas.put("syssyyf",fjlx.getSyssyyf());
						datas.put("zsssyyf",fjlx.getZsssyyf());
						datas.put("zlzbssyyf",fjlx.getZlzbssyyf());
						datas.put("hszsyyf",fjlx.getHszsyyf());
						datas.put("yyzlskfkyf",fjlx.getYyzlskfkyf());
						datas.put("ydzlskfkyf",fjlx.getYdzlskfkyf());
						datas.put("xyllskfkyf",fjlx.getXyllskfkyf());
						datas.put("kfkzskfkyf",fjlx.getKfkzskfkyf());
						datas.put("gndyjzmj",fjlx.getGndyjzmj());
						
					}
					
				}else {
					datas = new TreeMap<String,Object>();
					datas.put("doc_id", "");
					datas.put("gkzswkyf", "0");
					datas.put("ptwkzswkyf", "0");
					datas.put("cdjfrmzsnkyf", "0");
					datas.put("ptnkzsnkyf", "0");
					datas.put("qkylkzs", "0");
					datas.put("hzq", "0");
					datas.put("fzt", "0");
					datas.put("jgskqkyf", "0");
					datas.put("ykzs", "0");
					datas.put("fwzx", "0");
					datas.put("pfkzs", "0");
					datas.put("grxjbkzsgrxjbkyf", "0");
					datas.put("glsgrxjbkyf", "0");
					datas.put("id", "");
					
					datas.put("fckzsfckyf", "0");
					datas.put("jcsfckyf", "0");
					datas.put("ekzs", "0");
					datas.put("zykzszykyf", "0");
					datas.put("zyzlszykyf", "0");
					datas.put("kqkzskqkyf", "0");
					datas.put("kqzlskqkyf", "0");
					datas.put("jgskqkyf", "0");
					datas.put("ykzs", "0");
					datas.put("ebhkzs", "0");
					datas.put("pfkzs", "0");
					datas.put("grxjbkzsgrxjbkyf", "0");
					datas.put("glsgrxjbkyf", "0");
					
					datas.put("ghsfs", "0");
					datas.put("qtqzm", "");
					datas.put("yszbsjzkyf", "0");
					datas.put("lgsjzkyf", "0");
					datas.put("qjsjzkyf", "0");
					datas.put("jzkzsjzkyf", "0");
					datas.put("zsgcssyyf", "0");
					datas.put("syssyyf", "0");
					datas.put("zsssyyf", "0");
					datas.put("zlzbssyyf", "0");
					datas.put("hszsyyf", "0");
					datas.put("yyzlskfkyf", "0");
					datas.put("ydzlskfkyf", "0");
					datas.put("xyllskfkyf", "0");
					datas.put("kfkzskfkyf", "0");
					datas.put("gndyjzmj", "");
					
				}
			} catch (Exception e) {
			
			}
			
		}
		
		
		request.setAttribute("data", datas);
		model.addAttribute("data", datas);
		
		return "modules/ironfofivemjzyf/ironfofivemjzyfList";
	}

	/**
	 * 查看，增加，编辑5.2门急诊用房表单页面
	 */
	@RequiresPermissions(value={"ironfofivemjzyf:ironfofivemjzyf:view","ironfofivemjzyf:ironfofivemjzyf:add","ironfofivemjzyf:ironfofivemjzyf:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfofivemjzyf ironfofivemjzyf, Model model) {
		model.addAttribute("ironfofivemjzyf", ironfofivemjzyf);
		return "modules/ironfofivemjzyf/ironfofivemjzyfForm";
	}

	/**
	 * 保存5.2门急诊用房
	 */
	@RequiresPermissions(value={"ironfofivemjzyf:ironfofivemjzyf:add","ironfofivemjzyf:ironfofivemjzyf:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfofivemjzyf ironfofivemjzyf, Model model, RedirectAttributes redirectAttributes) throws Exception{



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
			Ironfofivemjzyfkjlx ironfofivemjzyfkjlx = Ironfofivemjzyfkjlx.class.newInstance();
			ironfofivemjzyfkjlx.setDoc_id(docId);
			List<Ironfofivemjzyfkjlx> fkjlx_data = ironfofivemjzyfService.queryForList(ironfofivemjzyfkjlx);
			
			if(fkjlx_data.size()>0) {
				isnull = true;
			}else {
				isnull = false;
			}
			
		}
		
		
		Ironfofivemjzyfkjlx ironfofivemjzyfkjlx_data = Ironfofivemjzyfkjlx.class.newInstance();
		ironfofivemjzyfkjlx_data.setMjzyfId(map.get("mjzyfid").toString());
		ironfofivemjzyfkjlx_data.setGhsfs(map.get("ghsfs").toString());
		ironfofivemjzyfkjlx_data.setFwzx(map.get("fwzx").toString());
		ironfofivemjzyfkjlx_data.setFzt(map.get("fzt").toString());
		ironfofivemjzyfkjlx_data.setHzq(map.get("hzq").toString());
		ironfofivemjzyfkjlx_data.setQkylkzs(map.get("qkylkzs").toString());
		ironfofivemjzyfkjlx_data.setPtnkzsnkyf(map.get("ptnkzsnkyf").toString());
		ironfofivemjzyfkjlx_data.setCdjfrmzsnkyf(map.get("cdjfrmzsnkyf").toString());
		ironfofivemjzyfkjlx_data.setPtwkzswkyf(map.get("ptwkzswkyf").toString());
		ironfofivemjzyfkjlx_data.setGkzswkyf(map.get("gkzswkyf").toString());
		ironfofivemjzyfkjlx_data.setFckzsfckyf(map.get("fckzsfckyf").toString());
		ironfofivemjzyfkjlx_data.setJcsfckyf(map.get("jcsfckyf").toString());
		ironfofivemjzyfkjlx_data.setEkzs(map.get("ekzs").toString());
		ironfofivemjzyfkjlx_data.setZykzszykyf(map.get("zykzszykyf").toString());
		ironfofivemjzyfkjlx_data.setZyzlszykyf(map.get("zyzlszykyf").toString());
		ironfofivemjzyfkjlx_data.setKqkzskqkyf(map.get("kqkzskqkyf").toString());
		ironfofivemjzyfkjlx_data.setKqzlskqkyf(map.get("kqzlskqkyf").toString());
		ironfofivemjzyfkjlx_data.setJgskqkyf(map.get("jgskqkyf").toString());
		ironfofivemjzyfkjlx_data.setYkzs(map.get("ykzs").toString());
		ironfofivemjzyfkjlx_data.setEbhkzs(map.get("ebhkzs").toString());
		ironfofivemjzyfkjlx_data.setPfkzs(map.get("pfkzs").toString());
		ironfofivemjzyfkjlx_data.setGrxjbkzsgrxjbkyf(map.get("grxjbkzsgrxjbkyf").toString());
		ironfofivemjzyfkjlx_data.setGlsgrxjbkyf(map.get("glsgrxjbkyf").toString());
		ironfofivemjzyfkjlx_data.setKfkzskfkyf(map.get("kfkzskfkyf").toString());
		ironfofivemjzyfkjlx_data.setXyllskfkyf(map.get("xyllskfkyf").toString());
		ironfofivemjzyfkjlx_data.setYdzlskfkyf(map.get("ydzlskfkyf").toString());
		ironfofivemjzyfkjlx_data.setYyzlskfkyf(map.get("yyzlskfkyf").toString());
		ironfofivemjzyfkjlx_data.setHszsyyf(map.get("hszsyyf").toString());
		ironfofivemjzyfkjlx_data.setZlzbssyyf(map.get("zlzbssyyf").toString());
		ironfofivemjzyfkjlx_data.setZsssyyf(map.get("zsssyyf").toString());
		ironfofivemjzyfkjlx_data.setSyssyyf(map.get("syssyyf").toString());
		ironfofivemjzyfkjlx_data.setZsgcssyyf(map.get("zsgcssyyf").toString());
		ironfofivemjzyfkjlx_data.setJzkzsjzkyf(map.get("jzkzsjzkyf").toString());
		ironfofivemjzyfkjlx_data.setQjsjzkyf(map.get("qjsjzkyf").toString());
		ironfofivemjzyfkjlx_data.setLgsjzkyf(map.get("lgsjzkyf").toString());
		ironfofivemjzyfkjlx_data.setYszbsjzkyf(map.get("yszbsjzkyf").toString());
//		ironfofivemjzyfkjlx_data.setQtqzm(map.get("qtqzm").toString());
		ironfofivemjzyfkjlx_data.setQtqzm(qtqzm);
		ironfofivemjzyfkjlx_data.setDoc_id(docId);
		ironfofivemjzyfkjlx_data.setGndyjzmj(map.get("gndyjzmj").toString());
		
		if(isnull == true) {
			//更新
			ironfofivemjzyfkjlx_data.setId(id);
			ironfofivemjzyfService.updateironfo(ironfofivemjzyfkjlx_data);
			
		}else if(isnull == false) {
			//保存
			ironfofivemjzyfkjlx_data.setId(UUID.randomUUID().toString().replaceAll("-", ""));
			ironfofivemjzyfService.saveironfo(ironfofivemjzyfkjlx_data);
			
		}
		
		
		
		
		return "redirect:"+Global.getAdminPath()+"/ironfofivemjzyf/ironfofivemjzyf/?repage";
	}
	
	/**
	 * 删除5.2门急诊用房
	 */
	@RequiresPermissions("ironfofivemjzyf:ironfofivemjzyf:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfofivemjzyf ironfofivemjzyf, RedirectAttributes redirectAttributes) {
		ironfofivemjzyfService.delete(ironfofivemjzyf);
		addMessage(redirectAttributes, "删除5.2门急诊用房成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivemjzyf/ironfofivemjzyf/?repage";
	}
	
	/**
	 * 批量删除5.2门急诊用房
	 */
	@RequiresPermissions("ironfofivemjzyf:ironfofivemjzyf:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfofivemjzyfService.delete(ironfofivemjzyfService.get(id));
		}
		addMessage(redirectAttributes, "删除5.2门急诊用房成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivemjzyf/ironfofivemjzyf/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfofivemjzyf:ironfofivemjzyf:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfofivemjzyf ironfofivemjzyf, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "5.2门急诊用房"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfofivemjzyf> page = ironfofivemjzyfService.findPage(new Page<Ironfofivemjzyf>(request, response, -1), ironfofivemjzyf);
    		new ExportExcel("5.2门急诊用房", Ironfofivemjzyf.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出5.2门急诊用房记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivemjzyf/ironfofivemjzyf/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfofivemjzyf:ironfofivemjzyf:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfofivemjzyf> list = ei.getDataList(Ironfofivemjzyf.class);
			for (Ironfofivemjzyf ironfofivemjzyf : list){
				try{
					ironfofivemjzyfService.save(ironfofivemjzyf);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条5.2门急诊用房记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条5.2门急诊用房记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入5.2门急诊用房失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivemjzyf/ironfofivemjzyf/?repage";
    }
	
	/**
	 * 下载导入5.2门急诊用房数据模板
	 */
	@RequiresPermissions("ironfofivemjzyf:ironfofivemjzyf:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "5.2门急诊用房数据导入模板.xlsx";
    		List<Ironfofivemjzyf> list = Lists.newArrayList(); 
    		new ExportExcel("5.2门急诊用房数据", Ironfofivemjzyf.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivemjzyf/ironfofivemjzyf/?repage";
    }
	
	
	

}