/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfomedicalservices.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolationException;

import org.apache.http.HttpRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.jeeplus.common.utils.DateUtils;
import com.jeeplus.common.utils.MyBeanUtils;
import com.jeeplus.common.config.Global;
import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.security.shiro.session.SessionDAO;
import com.jeeplus.common.web.BaseController;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.common.utils.excel.ExportExcel;
import com.jeeplus.common.utils.excel.ImportExcel;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.ironfodoctitle.service.IronfoDocTitleService;
import com.jeeplus.modules.ironfomedicalservices.entity.IronfoMedicalServices;
import com.jeeplus.modules.ironfomedicalservices.service.IronfoMedicalServicesService;
import com.jeeplus.modules.sys.entity.User;
import com.jeeplus.modules.sys.security.UsernamePasswordToken;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;
import com.jeeplus.modules.tools.utils.IsEmptyBean;
import com.jeeplus.modules.ironfomedicalservices.dao.IronfoMedicalServicesDao;

//import org.slf4j.LoggerFactory;  

//import ch.qos.logback.classic.Logger;  
  
import com.fasterxml.jackson.core.JsonGenerationException;  
import com.fasterxml.jackson.core.JsonParseException;  
import com.fasterxml.jackson.core.type.TypeReference;  
import com.fasterxml.jackson.databind.JsonMappingException;  
//import com.fasterxml.jackson.databind.ObjectMapper;  
import com.fasterxml.jackson.databind.type.TypeFactory;  

//import com.jeeplus.common.ironfo

/**
 * 2.1年度医疗服务量Controller
 * @author 
 * @version 2018-03-13
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfomedicalservices/ironfoMedicalServices")
public class IronfoMedicalServicesController extends BaseController {

	@Autowired
	private IronfoMedicalServicesService ironfoMedicalServicesService;
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	@Autowired
	private IronfoDocTitleService ironfoDocTitleService;
	
	
	
	
	
	@ModelAttribute
	public IronfoMedicalServices get(@RequestParam(required=false) String id) {
		IronfoMedicalServices entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfoMedicalServicesService.get(id);
		}
		if (entity == null){
			entity = new IronfoMedicalServices();
		}
		return entity;
	}
	
	/**
	 * 2.1年度医疗服务量列表页面
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	@RequiresPermissions("ironfomedicalservices:ironfoMedicalServices:list")
	@RequestMapping(value = {"list", ""})
//	@ResponseBody
	public String list(IronfoMedicalServices ironfoMedicalServices, HttpServletRequest request, HttpServletResponse response, Model model) throws InstantiationException, IllegalAccessException {
		
		

		Subject subject = SecurityUtils.getSubject();  
		Principal obj = (Principal) subject.getPrincipal();
		System.out.println(obj.getId());
		
		
		
		Map<String,Object> datas = new TreeMap<String,Object>();
		IronfoDocTitle title =  IronfoDocTitle.class.newInstance();
		title.setRemarks(obj.getId());
//		title =  ironfoDoc_Title_Service.getDocId(obj.getId());
		List<IronfoDocTitle> docList = ironfoDoc_Title_Service.queryforList(title);
		
		
		
		if(docList.size()>0) {
			ironfoMedicalServices.setDoc_id(docList.get(0).getId().toString());	
			
			List<IronfoMedicalServices> data = ironfoMedicalServicesService.queryForList(ironfoMedicalServices);
			
			for(int i=0;i<data.size();i++) {
//				datas.put("doc_id", data.get(i).getDoc_id());
				if(data.get(i).getDate().toString()=="2015"||"2015".equals(data.get(i).getDate().toString())) {
					datas.put("date", data.get(i).getDate().toString());
					
					
					datas.put("id", data.get(i).getId().toString());
					
					String bzcw = data.get(i).getBzcw().toString().trim();
					
					if("----"==bzcw||"----".equals(bzcw)) {
						datas.put("bzcw","");
					}else {
						datas.put("bzcw",bzcw);
					}
					String sycw = data.get(i).getSycw().toString().trim();
					if("----"==sycw||"----".equals(sycw)) {
						datas.put("sycw","");
					}else {
						datas.put("sycw",sycw);
					}
					String sjkfzcrs = data.get(i).getSjkfzcrs().toString().trim();
					if("----"==sjkfzcrs||"----".equals(sjkfzcrs)) {
						datas.put("sjkfzcrs","");
					}else {
						datas.put("sjkfzcrs",sjkfzcrs);
					}
					String sjzyzcrs = data.get(i).getSjzyzcrs().toString().trim();
					if("----"==sjzyzcrs||"----".equals(sjzyzcrs)) {
						datas.put("sjzyzcrs","");
					}else {
						datas.put("sjzyzcrs",sjzyzcrs);
					}
					String gccs =  data.get(i).getGccs().toString().trim();
					
					if("----"==gccs||"----".equals(gccs)) {
						datas.put("gccs","");
					}else {
						datas.put("gccs",gccs);
					}
					String zzlrcs = data.get(i).getZzlrcs().toString().trim();
					if("----"==zzlrcs||"----".equals(zzlrcs)) {
						datas.put("zzlrcs","");
					}else {
						datas.put("zzlrcs",zzlrcs);
					}
					
					String mzrcs = data.get(i).getMzrcs().toString().trim();
					if("----"==mzrcs||"----".equals(mzrcs)) {
						datas.put("mzrcs","");
					}else {
						datas.put("mzrcs",mzrcs);
					}
					String jzrcs = data.get(i).getJzrcs().toString().trim();
					if("----"==jzrcs||"----".equals(jzrcs)) {
						datas.put("jzrcs","");
					}else {
						datas.put("jzrcs",jzrcs);
					}
					String qzswrs = data.get(i).getQzswrs().toString().trim();
					if("----"==qzswrs||"----".equals(qzswrs)) {
						datas.put("qzswrs","");
					}else {
						datas.put("qzswrs",qzswrs);
					}
					String cyrs = data.get(i).getCyrs().toString().trim();
					if("----"==cyrs||"----".equals(cyrs)) {
						datas.put("cyrs","");
					}else {
						datas.put("cyrs",cyrs);
					}
					String sjyyxxzzrcs = data.get(i).getSjyyxxzzrcs().toString().trim();
					if("----"==sjyyxxzzrcs||"----".equals(sjyyxxzzrcs)) {
						datas.put("sjyyxxzzrcs","");
					}else {
						datas.put("sjyyxxzzrcs",sjyyxxzzrcs);
					}
					String xsjyyzzrcs = data.get(i).getXsjyyzzrcs().toString().trim();
					if("----"==xsjyyzzrcs||"----".equals(sjyyxxzzrcs)) {
						datas.put("xsjyyzzrcs","");
					}else {
						datas.put("xsjyyzzrcs",xsjyyzzrcs);
					}
						
				}else if(data.get(i).getDate().toString()=="2016"||"2016".equals(data.get(i).getDate().toString())) {
					datas.put("date1", data.get(i).getDate().toString());
					datas.put("id1",data.get(i).getId().toString());
					String bzcw1 = data.get(i).getBzcw().toString().trim();
					if("----"==bzcw1||"----".equals(bzcw1)) {
						datas.put("bzcw1","");
					}else {
						datas.put("bzcw1",bzcw1);
					}
//					datas.put("bzcw1", data.get(i).getBzcw().toString());
					
					
					
					String sycw = data.get(i).getSycw().toString().trim();
					if("----"==sycw||"----".equals(sycw)) {
						datas.put("sycw1","");
					}else {
						datas.put("sycw1",sycw);
					}
					String sjkfzcrs = data.get(i).getSjkfzcrs().toString().trim();
					if("----"==sjkfzcrs||"----".equals(sjkfzcrs)) {
						datas.put("sjkfzcrs1","");
					}else {
						datas.put("sjkfzcrs1",sjkfzcrs);
					}
					String sjzyzcrs = data.get(i).getSjzyzcrs().toString().trim();
					if("----"==sjzyzcrs||"----".equals(sjzyzcrs)) {
						datas.put("sjzyzcrs1","");
					}else {
						datas.put("sjzyzcrs1",sjzyzcrs);
					}
					String gccs =  data.get(i).getGccs().toString().trim();
					
					if("----"==gccs||"----".equals(gccs)) {
						datas.put("gccs1","");
					}else {
						datas.put("gccs1",gccs);
					}
					String zzlrcs = data.get(i).getZzlrcs().toString().trim();
					if("----"==zzlrcs||"----".equals(zzlrcs)) {
						datas.put("zzlrcs1","");
					}else {
						datas.put("zzlrcs1",zzlrcs);
					}
					
					String mzrcs = data.get(i).getMzrcs().toString().trim();
					if("----"==mzrcs||"----".equals(mzrcs)) {
						datas.put("mzrcs1","");
					}else {
						datas.put("mzrcs1",mzrcs);
					}
					String jzrcs = data.get(i).getJzrcs().toString().trim();
					if("----"==jzrcs||"----".equals(jzrcs)) {
						datas.put("jzrcs1","");
					}else {
						datas.put("jzrcs1",jzrcs);
					}
					String qzswrs = data.get(i).getQzswrs().toString().trim();
					if("----"==qzswrs||"----".equals(qzswrs)) {
						datas.put("qzswrs1","");
					}else {
						datas.put("qzswrs1",qzswrs);
					}
					String cyrs = data.get(i).getCyrs().toString().trim();
					if("----"==cyrs||"----".equals(cyrs)) {
						datas.put("cyrs1","");
					}else {
						datas.put("cyrs1",cyrs);
					}
					String sjyyxxzzrcs = data.get(i).getSjyyxxzzrcs().toString().trim();
					if("----"==sjyyxxzzrcs||"----".equals(sjyyxxzzrcs)) {
						datas.put("sjyyxxzzrcs1","");
					}else {
						datas.put("sjyyxxzzrcs1",sjyyxxzzrcs);
					}
					String xsjyyzzrcs = data.get(i).getXsjyyzzrcs().toString().trim();
					if("----"==xsjyyzzrcs||"----".equals(sjyyxxzzrcs)) {
						datas.put("xsjyyzzrcs1","");
					}else {
						datas.put("xsjyyzzrcs1",xsjyyzzrcs);
					}
					
					
//					datas.put("sycw1", data.get(i).getSycw().toString());
//					datas.put("sjkfzcrs1", data.get(i).getSjkfzcrs().toString());
//					datas.put("sjzyzcrs1", data.get(i).getSjzyzcrs().toString());
//					datas.put("gccs1", data.get(i).getGccs().toString());
//					datas.put("zzlrcs1", data.get(i).getZzlrcs().toString());
//					datas.put("mzrcs1", data.get(i).getMzrcs().toString());
//					datas.put("jzrcs1", data.get(i).getJzrcs().toString());
//					datas.put("qzswrs1", data.get(i).getQzswrs().toString());
//					datas.put("cyrs1", data.get(i).getCyrs().toString());
//					datas.put("sjyyxxzzrcs1", data.get(i).getSjyyxxzzrcs().toString());
//					datas.put("xsjyyzzrcs1", data.get(i).getXsjyyzzrcs().toString());
				} else if(data.get(i).getDate().toString()=="2017"||"2017".equals(data.get(i).getDate().toString())) {
					datas.put("date2", data.get(i).getDate().toString());
					datas.put("id2",data.get(i).getId().toString());
					String bzcw2 = data.get(i).getBzcw().toString().trim();
					if("----"==bzcw2||"----".equals(bzcw2)) {
						datas.put("bzcw2","");
					}else {
						datas.put("bzcw2",bzcw2);
					}
					
					String sycw = data.get(i).getSycw().toString().trim();
					if("----"==sycw||"----".equals(sycw)) {
						datas.put("sycw2","");
					}else {
						datas.put("sycw2",sycw);
					}
					String sjkfzcrs = data.get(i).getSjkfzcrs().toString().trim();
					if("----"==sjkfzcrs||"----".equals(sjkfzcrs)) {
						datas.put("sjkfzcrs2","");
					}else {
						datas.put("sjkfzcrs2",sjkfzcrs);
					}
					String sjzyzcrs = data.get(i).getSjzyzcrs().toString().trim();
					if("----"==sjzyzcrs||"----".equals(sjzyzcrs)) {
						datas.put("sjzyzcrs2","");
					}else {
						datas.put("sjzyzcrs2",sjzyzcrs);
					}
					String gccs =  data.get(i).getGccs().toString().trim();
					
					if("----"==gccs||"----".equals(gccs)) {
						datas.put("gccs2","");
					}else {
						datas.put("gccs2",gccs);
					}
					String zzlrcs = data.get(i).getZzlrcs().toString().trim();
					if("----"==zzlrcs||"----".equals(zzlrcs)) {
						datas.put("zzlrcs2","");
					}else {
						datas.put("zzlrcs2",zzlrcs);
					}
					
					String mzrcs = data.get(i).getMzrcs().toString().trim();
					if("----"==mzrcs||"----".equals(mzrcs)) {
						datas.put("mzrcs2","");
					}else {
						datas.put("mzrcs2",mzrcs);
					}
					String jzrcs = data.get(i).getJzrcs().toString().trim();
					if("----"==jzrcs||"----".equals(jzrcs)) {
						datas.put("jzrcs2","");
					}else {
						datas.put("jzrcs2",jzrcs);
					}
					String qzswrs = data.get(i).getQzswrs().toString().trim();
					if("----"==qzswrs||"----".equals(qzswrs)) {
						datas.put("qzswrs2","");
					}else {
						datas.put("qzswrs2",qzswrs);
					}
					String cyrs = data.get(i).getCyrs().toString().trim();
					if("----"==cyrs||"----".equals(cyrs)) {
						datas.put("cyrs2","");
					}else {
						datas.put("cyrs2",cyrs);
					}
					String sjyyxxzzrcs = data.get(i).getSjyyxxzzrcs().toString().trim();
					if("----"==sjyyxxzzrcs||"----".equals(sjyyxxzzrcs)) {
						datas.put("sjyyxxzzrcs2","");
					}else {
						datas.put("sjyyxxzzrcs2",sjyyxxzzrcs);
					}
					String xsjyyzzrcs = data.get(i).getXsjyyzzrcs().toString().trim();
					if("----"==xsjyyzzrcs||"----".equals(sjyyxxzzrcs)) {
						datas.put("xsjyyzzrcs2","");
					}else {
						datas.put("xsjyyzzrcs2",xsjyyzzrcs);
					}
					
				}
				
			}
			
			datas.put("doc_id", docList.get(0).getId().toString());
		}else {
			
			datas.put("xsjyyzzrcs2", "");
			datas.put("xsjyyzzrcs1", "");
			datas.put("xsjyyzzrcs", "");
			datas.put("sjyyxxzzrcs2", "");
			datas.put("sjyyxxzzrcs1", "");
			datas.put("sjyyxxzzrcs", "");
			datas.put("date2", "2017");
			datas.put("date1", "2016");
			datas.put("date", "2015");
			datas.put("cyrs2", "");
			datas.put("cyrs1", "");
			datas.put("cyrs", "");
			datas.put("qzswrs2", "");
			datas.put("qzswrs1", "");
			datas.put("qzswrs", "");
			datas.put("jzrcs2", "");
			datas.put("jzrcs1", "");
			datas.put("jzrcs", "");
			datas.put("mzrcs2", "");
			datas.put("mzrcs1", "");
			datas.put("mzrcs", "");
			datas.put("gccs2", "");
			datas.put("gccs1", "");
			datas.put("gccs", "");
			datas.put("sjzyzcrs2", "");
			datas.put("sjzyzcrs1", "");
			datas.put("sjzyzcrs", "");
			datas.put("sjkfzcrs2", "");
			datas.put("sjkfzcrs1", "");
			datas.put("sjkfzcrs", "");
			
			datas.put("sycw2", "");
			datas.put("sycw1", "");
			datas.put("sycw", "");
			datas.put("bzcw2", "");
			datas.put("bzcw1", "");
			datas.put("bzcw", "");
			datas.put("id2", "");
			datas.put("id1", "");
			datas.put("id", "");
			datas.put("doc_id","");
		}
		
		
		
		request.setAttribute("data", datas);
		model.addAttribute("data", datas);
		return "modules/ironfomedicalservices/ironfoMedicalServicesList";
				//"redirect:"+Global.getAdminPath()+"/ironfomedicalservices/ironfoMedicalServices/?repage";
	}

	/**
	 * 查看，增加，编辑2.1年度医疗服务量表单页面
	 */
	@RequiresPermissions(value={"ironfomedicalservices:ironfoMedicalServices:view","ironfomedicalservices:ironfoMedicalServices:add","ironfomedicalservices:ironfoMedicalServices:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfoMedicalServices ironfoMedicalServices, Model model) {
		model.addAttribute("ironfoMedicalServices", ironfoMedicalServices);
		return "modules/ironfomedicalservices/ironfoMedicalServicesForm";
	}

	/**
	 * 保存2.1年度医疗服务量
	 */
	@RequiresPermissions(value={"ironfomedicalservices:ironfoMedicalServices:add","ironfomedicalservices:ironfoMedicalServices:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfoMedicalServices ironfoMedicalServices,Model model, RedirectAttributes redirectAttributes) throws Exception{
		  
		
		boolean isnull=false;
		
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		
		Subject subject = SecurityUtils.getSubject();  
		Principal obj = (Principal) subject.getPrincipal();
		System.out.println("------login_id---------->"+obj.getId());
		
		Map<String,Object> map = new  HashMap<String,Object>();
		String data = request.getParameter("datas");
		String[] ironfoMedicalService = data.split(";");
		String docId = "";
		for(int i=0;i<ironfoMedicalService.length;i++) {
			map.put(ironfoMedicalService[i].toString().split(":")[0].toString(),ironfoMedicalService[i].toString().split(":")[1].toString());
			if("docId" == ironfoMedicalService[i].toString().trim().split(":")[0].toString().trim() || "docId".equals(ironfoMedicalService[i].toString().trim().split(":")[0].toString().trim())) {
				docId = ironfoMedicalService[i].toString().split(":")[1].toString();
			}
		}
		
//		String isnull = map.get("isnull").toString();
 		
		
		if(docId.toString().trim() == null || "".equals(docId.toString().trim())) {
 			isnull = false;
		}else {
			isnull = true;
		}
//		System.out.println("------------map.get(\"isnull\").toString()----------------->"+map.get("isnull").toString());
		/**
		 * 保存2015年的基础数据
		 */
		IronfoMedicalServices infomed_2015 = null;//new IronfoMedicalServices();
		/**
		 * 保存2016年的基础数据
		 */
		
		IronfoMedicalServices infomed_2016 = null;//new IronfoMedicalServices();
		/**
		 * 保存2017年的基础数据
		 */
		IronfoMedicalServices infomed_2017 = null;//  new IronfoMedicalServices();
			if(isnull == false) {
				IronfoDocTitle idt = IronfoDocTitle.class.newInstance();
				idt.setTitle_name("乡镇卫生院硬件配置研究调查表");
				idt.setRemarks(obj.getId());//备注用来存放登录用户id 将登录人和报表绑定在一起
				ironfoDocTitleService.save(idt);
				infomed_2015 = new IronfoMedicalServices();
				infomed_2015.setDate(map.get("date").toString().substring(0,4).toString());
				infomed_2015.setBzcw(map.get("bzcw").toString());
				infomed_2015.setSycw(map.get("sycw").toString());
				infomed_2015.setSjkfzcrs(map.get("sjkfzcrs").toString());
				infomed_2015.setSjzyzcrs(map.get("sjzyzcrs").toString());//2015年实际占用总床日数（日）
				infomed_2015.setGccs(map.get("gccs").toString());//2015年观察床数（床）
				infomed_2015.setZzlrcs(map.get("zzlrcs").toString());//2015 总诊疗人次数（人次）
				infomed_2015.setMzrcs(map.get("mzrcs").toString());//2015门诊人次数（人次）
				infomed_2015.setJzrcs(map.get("jzrcs").toString());//2015急诊人次数（人次）
				infomed_2015.setQzswrs(map.get("qzswrs").toString());//2015其中死亡人数（人）
				infomed_2015.setCyrs(map.get("cyrs").toString());//2015出院人数（人）
				infomed_2015.setSjyyxxzzrcs(map.get("sjyyxxzzrcs").toString());//2015上级医院向下转诊人次数（人次）
				infomed_2015.setXsjyyzzrcs(map.get("xsjyyzzrcs").toString());//向上级医院转诊人次数（人次）
				infomed_2015.setDoc_id(idt.getId());
				ironfoMedicalServicesService.save(infomed_2015);//保存
				
				
				
				infomed_2016 = new IronfoMedicalServices();
				infomed_2016.setDate(map.get("date1").toString().substring(0,4).toString());
				infomed_2016.setBzcw(map.get("bzcw1").toString());
				infomed_2016.setSycw(map.get("sycw1").toString());
				infomed_2016.setSjkfzcrs(map.get("sjkfzcrs1").toString());
				
//				String sjzyzcrs1 = ironfoMedicalServices.getSjzyzcrs1();
				infomed_2016.setSjzyzcrs(map.get("sjzyzcrs1").toString());//2015年实际占用总床日数（日）
				
//				String gccs1 = ironfoMedicalServices.getGccs1();
				infomed_2016.setGccs(map.get("gccs1").toString());//2015年观察床数（床）
				
//				String zzlrcs1 = ironfoMedicalServices.getZzlrcs1();
				infomed_2016.setZzlrcs(map.get("zzlrcs1").toString());//2015 总诊疗人次数（人次）
				
//				String mzrcs1 = ironfoMedicalServices.getMzrcs1();
				infomed_2016.setMzrcs(map.get("mzrcs1").toString());//2015门诊人次数（人次）
				
//				String jzrcs1 = ironfoMedicalServices.getJzrcs1();
				infomed_2016.setJzrcs(map.get("jzrcs1").toString());//2015急诊人次数（人次）
				
//				String Qzswrs1= ironfoMedicalServices.getQzswrs1();
				infomed_2016.setQzswrs(map.get("qzswrs1").toString());//2015其中死亡人数（人）
				
//				String Cyrs1=ironfoMedicalServices.getCyrs1();
				infomed_2016.setCyrs(map.get("cyrs1").toString());//2015出院人数（人）
				
//				String Sjyyxxzzrcs1 = ironfoMedicalServices.getSjyyxxzzrcs1();
				infomed_2016.setSjyyxxzzrcs(map.get("sjyyxxzzrcs1").toString());//2015上级医院向下转诊人次数（人次）
				
//				String Xsjyyzzrcs1 = ironfoMedicalServices.getXsjyyzzrcs1();
				infomed_2016.setXsjyyzzrcs(map.get("xsjyyzzrcs1").toString());//向上级医院转诊人次数（人次）
			
				
				
				
				infomed_2016.setDoc_id(idt.getId());
				ironfoMedicalServicesService.save(infomed_2016);//保存
				
				
				infomed_2017 = new IronfoMedicalServices();

				
				infomed_2017.setDate(map.get("date2").toString().substring(0,4).toString());
//				infomed_2017.setId2(map.get("id2").toString());
				
				
				infomed_2017.setBzcw(map.get("bzcw2").toString());
				infomed_2017.setSycw(map.get("sycw2").toString());
				infomed_2017.setSjkfzcrs(map.get("sjkfzcrs2").toString());
				
				infomed_2017.setSjzyzcrs(map.get("sjzyzcrs2").toString());//2015年实际占用总床日数（日）
				
//				String gccs2 = ironfoMedicalServices.getGccs2();
				infomed_2017.setGccs(map.get("gccs2").toString());//2015年观察床数（床）
				
//				String zzlrcs2 = ironfoMedicalServices.getZzlrcs2();
				infomed_2017.setZzlrcs(map.get("zzlrcs2").toString());//2015 总诊疗人次数（人次）
				
//				String mzrcs2 = ironfoMedicalServices.getMzrcs2();
				infomed_2017.setMzrcs(map.get("mzrcs2").toString());//2015门诊人次数（人次）
				
//				String jzrcs2 = ironfoMedicalServices.getJzrcs2();
				infomed_2017.setJzrcs(map.get("jzrcs2").toString());//2015急诊人次数（人次）
				
//				String Qzswrs2= ironfoMedicalServices.getQzswrs2();
				infomed_2017.setQzswrs(map.get("qzswrs2").toString());//2015其中死亡人数（人）
				
//				String Cyrs2=ironfoMedicalServices.getCyrs2();
				infomed_2017.setCyrs(map.get("cyrs2").toString());//2015出院人数（人）
				
//				String Sjyyxxzzrcs2 = ironfoMedicalServices.getSjyyxxzzrcs2();
				infomed_2017.setSjyyxxzzrcs(map.get("sjyyxxzzrcs2").toString());//2015上级医院向下转诊人次数（人次）
				
//				String Xsjyyzzrcs2 = ironfoMedicalServices.getXsjyyzzrcs2();
				infomed_2017.setXsjyyzzrcs(map.get("xsjyyzzrcs2").toString());//向上级医院转诊人次数（人次）
				
				

				infomed_2017.setDoc_id(idt.getId());
				ironfoMedicalServicesService.save(infomed_2017);//保存
		}else if (isnull == true){
			
			
			/**
			 * 更新
			 */
			
			
			//System.out.println("idt.getId()---->"+idt.getId());
			
			infomed_2015 = new IronfoMedicalServices();
			
			
			infomed_2015.setDate(map.get("date").toString().substring(0,4).toString());
			infomed_2015.setId(map.get("id").toString());
			
//			String Bzcw =  ironfoMedicalServices.getBzcw();//2015年编制床位
			infomed_2015.setBzcw(map.get("bzcw").toString());
//			String sycw = ironfoMedicalServices.getSycw();//2015年实有床位
			
			infomed_2015.setSycw(map.get("sycw").toString());
//			String sjkfzcrs = ironfoMedicalServices.getSjkfzcrs(); //2015年实际开放总床日数（日）
			infomed_2015.setSjkfzcrs(map.get("sjkfzcrs").toString());
			
//			String sjzyzcrs = ironfoMedicalServices.getSjzyzcrs();
			infomed_2015.setSjzyzcrs(map.get("sjzyzcrs").toString());//2015年实际占用总床日数（日）
			
//			String gccs = ironfoMedicalServices.getGccs();
			infomed_2015.setGccs(map.get("gccs").toString());//2015年观察床数（床）
			
//			String zzlrcs = ironfoMedicalServices.getZzlrcs();
			infomed_2015.setZzlrcs(map.get("zzlrcs").toString());//2015 总诊疗人次数（人次）
			
//			String mzrcs = ironfoMedicalServices.getMzrcs();
			infomed_2015.setMzrcs(map.get("mzrcs").toString());//2015门诊人次数（人次）
			
//			String jzrcs = ironfoMedicalServices.getJzrcs();
			infomed_2015.setJzrcs(map.get("jzrcs").toString());//2015急诊人次数（人次）
			
//			String Qzswrs= ironfoMedicalServices.getQzswrs();
			infomed_2015.setQzswrs(map.get("qzswrs").toString());//2015其中死亡人数（人）
			
//			String Cyrs=ironfoMedicalServices.getCyrs();
			infomed_2015.setCyrs(map.get("cyrs").toString());//2015出院人数（人）
			
//			String Sjyyxxzzrcs = ironfoMedicalServices.getSjyyxxzzrcs();
			infomed_2015.setSjyyxxzzrcs(map.get("sjyyxxzzrcs").toString());//2015上级医院向下转诊人次数（人次）
			
//			String Xsjyyzzrcs = ironfoMedicalServices.getXsjyyzzrcs();
			infomed_2015.setXsjyyzzrcs(map.get("xsjyyzzrcs").toString());//向上级医院转诊人次数（人次）
			
			
			infomed_2015.setDoc_id(docId);
			ironfoMedicalServicesService.updateIronfo(infomed_2015);
			
			
			
			

			infomed_2016 = new IronfoMedicalServices();
			
			infomed_2016.setDate(map.get("date1").toString().substring(0,4).toString());
			
//			String Bzcw1 =  ironfoMedicalServices.getBzcw1();//2015年编制床位
			infomed_2016.setBzcw(map.get("bzcw1").toString());
			infomed_2016.setId(map.get("id1").toString());
			
//			String sycw1 = ironfoMedicalServices.getSycw1();//2015年实有床位
			infomed_2016.setSycw(map.get("sycw1").toString());
			
//			String sjkfzcrs1 = ironfoMedicalServices.getSjkfzcrs1(); //2015年实际开放总床日数（日）
			infomed_2016.setSjkfzcrs(map.get("sjkfzcrs1").toString());
			
//			String sjzyzcrs1 = ironfoMedicalServices.getSjzyzcrs1();
			infomed_2016.setSjzyzcrs(map.get("sjzyzcrs1").toString());//2015年实际占用总床日数（日）
			
//			String gccs1 = ironfoMedicalServices.getGccs1();
			infomed_2016.setGccs(map.get("gccs1").toString());//2015年观察床数（床）
			
//			String zzlrcs1 = ironfoMedicalServices.getZzlrcs1();
			infomed_2016.setZzlrcs(map.get("zzlrcs1").toString());//2015 总诊疗人次数（人次）
			
//			String mzrcs1 = ironfoMedicalServices.getMzrcs1();
			infomed_2016.setMzrcs(map.get("mzrcs1").toString());//2015门诊人次数（人次）
			
//			String jzrcs1 = ironfoMedicalServices.getJzrcs1();
			infomed_2016.setJzrcs(map.get("jzrcs1").toString());//2015急诊人次数（人次）
			
//			String Qzswrs1= ironfoMedicalServices.getQzswrs1();
			infomed_2016.setQzswrs(map.get("qzswrs1").toString());//2015其中死亡人数（人）
			
//			String Cyrs1=ironfoMedicalServices.getCyrs1();
			infomed_2016.setCyrs(map.get("cyrs1").toString());//2015出院人数（人）
			
//			String Sjyyxxzzrcs1 = ironfoMedicalServices.getSjyyxxzzrcs1();
			infomed_2016.setSjyyxxzzrcs(map.get("sjyyxxzzrcs1").toString());//2015上级医院向下转诊人次数（人次）
			
//			String Xsjyyzzrcs1 = ironfoMedicalServices.getXsjyyzzrcs1();
			infomed_2016.setXsjyyzzrcs(map.get("xsjyyzzrcs1").toString());//向上级医院转诊人次数（人次）
		
			
			
			
			infomed_2016.setDoc_id(docId);
			ironfoMedicalServicesService.updateIronfo(infomed_2016);
			
			
			
			
			

			infomed_2017 = new IronfoMedicalServices();

			
			infomed_2017.setDate(map.get("date2").toString().substring(0,4).toString());
			infomed_2017.setId(map.get("id2").toString());
			
			
			infomed_2017.setBzcw(map.get("bzcw2").toString());
			infomed_2017.setSycw(map.get("sycw2").toString());
			infomed_2017.setSjkfzcrs(map.get("sjkfzcrs2").toString());
			
			infomed_2017.setSjzyzcrs(map.get("sjzyzcrs2").toString());//2015年实际占用总床日数（日）
			
//			String gccs2 = ironfoMedicalServices.getGccs2();
			infomed_2017.setGccs(map.get("gccs2").toString());//2015年观察床数（床）
			
//			String zzlrcs2 = ironfoMedicalServices.getZzlrcs2();
			infomed_2017.setZzlrcs(map.get("zzlrcs2").toString());//2015 总诊疗人次数（人次）
			
//			String mzrcs2 = ironfoMedicalServices.getMzrcs2();
			infomed_2017.setMzrcs(map.get("mzrcs2").toString());//2015门诊人次数（人次）
			
//			String jzrcs2 = ironfoMedicalServices.getJzrcs2();
			infomed_2017.setJzrcs(map.get("jzrcs2").toString());//2015急诊人次数（人次）
			
//			String Qzswrs2= ironfoMedicalServices.getQzswrs2();
			infomed_2017.setQzswrs(map.get("qzswrs2").toString());//2015其中死亡人数（人）
			
//			String Cyrs2=ironfoMedicalServices.getCyrs2();
			infomed_2017.setCyrs(map.get("cyrs2").toString());//2015出院人数（人）
			
//			String Sjyyxxzzrcs2 = ironfoMedicalServices.getSjyyxxzzrcs2();
			infomed_2017.setSjyyxxzzrcs(map.get("sjyyxxzzrcs2").toString());//2015上级医院向下转诊人次数（人次）
			
//			String Xsjyyzzrcs2 = ironfoMedicalServices.getXsjyyzzrcs2();
			infomed_2017.setXsjyyzzrcs(map.get("xsjyyzzrcs2").toString());//向上级医院转诊人次数（人次）
			
			
			
			infomed_2017.setDoc_id(docId);
			ironfoMedicalServicesService.updateIronfo(infomed_2017);
			
		}
		
		
		
		
		
		request.setAttribute("cccc", ironfoMedicalServices);
		addMessage(redirectAttributes, "保存2.1年度医疗服务量成功");
//		System.out.println(Global.getAdminPath());
		return "redirect:"+Global.getAdminPath()+"/ironfomedicalservices/ironfoMedicalServices/?repage";
	}
	
	
	
	
	
	
	
	/**
	 * 删除2.1年度医疗服务量
	 */
	@RequiresPermissions("ironfomedicalservices:ironfoMedicalServices:del")
	@RequestMapping(value = "delete")
	public String delete(IronfoMedicalServices ironfoMedicalServices, RedirectAttributes redirectAttributes) {
		ironfoMedicalServicesService.delete(ironfoMedicalServices);
		addMessage(redirectAttributes, "删除2.1年度医疗服务量成功");
		return "redirect:"+Global.getAdminPath()+"/ironfomedicalservices/ironfoMedicalServices/?repage";
	}
	
	/**
	 * 批量删除2.1年度医疗服务量
	 */
	@RequiresPermissions("ironfomedicalservices:ironfoMedicalServices:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfoMedicalServicesService.delete(ironfoMedicalServicesService.get(id));
		}
		addMessage(redirectAttributes, "删除2.1年度医疗服务量成功");
		return "redirect:"+Global.getAdminPath()+"/ironfomedicalservices/ironfoMedicalServices/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfomedicalservices:ironfoMedicalServices:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfoMedicalServices ironfoMedicalServices, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "2.1年度医疗服务量"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfoMedicalServices> page = ironfoMedicalServicesService.findPage(new Page<IronfoMedicalServices>(request, response, -1), ironfoMedicalServices);
    		new ExportExcel("2.1年度医疗服务量", IronfoMedicalServices.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出2.1年度医疗服务量记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfomedicalservices/ironfoMedicalServices/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfomedicalservices:ironfoMedicalServices:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfoMedicalServices> list = ei.getDataList(IronfoMedicalServices.class);
			for (IronfoMedicalServices ironfoMedicalServices : list){
				try{
					ironfoMedicalServicesService.save(ironfoMedicalServices);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条2.1年度医疗服务量记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条2.1年度医疗服务量记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入2.1年度医疗服务量失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfomedicalservices/ironfoMedicalServices/?repage";
    }
	
	/**
	 * 下载导入2.1年度医疗服务量数据模板
	 */
	@RequiresPermissions("ironfomedicalservices:ironfoMedicalServices:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "2.1年度医疗服务量数据导入模板.xlsx";
    		List<IronfoMedicalServices> list = Lists.newArrayList(); 
    		new ExportExcel("2.1年度医疗服务量数据", IronfoMedicalServices.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfomedicalservices/ironfoMedicalServices/?repage";
    }
	
	
	public static void main(String[] args) {
//		IronfoMedicalServices s = new IronfoMedicalServices();
//		String json = "{'date':'2015年';'bzcw':'12';'sycw':'12';'sjkfzcrs':'12';'sjzyzcrs':'12';'gccs':'12';'zzlrcs':'12';'date':'2015年';'mzrcs':'12';'jzrcs':'12';'qzswrs':'12';'cyrs':'12';'sjyyxxzzrcs':'12';'xsjyyzzrcs':'12';'date1':'2016年';'bzcw1':'12';'sycw1':'12';'sjkfzcrs1':'12';'sjzyzcrs1':'12';'':'12';'zzlrcs1':'12';'date1':'2016年';'mzrcs1':'12';'jzrcs1':'12';'qzswrs1':'12';'cyrs1':'12';'sjyyxxzzrcs1':'12';'xsjyyzzrcs1':'12';'date2':'2017年';'bzcw2':'12';'sycw2':'12';'sjkfzcrs2':'12';'sjzyzcrs2':'12';'gccs2':'12';'zzlrcs2':'12';'date2':'2017年';'mzrcs2':'12';'jzrcs2':'12';'qzswrs2':'12';'cyrs2':'12';'sjyyxxzzrcs2':'12';'xsjyyzzrcs2':'12';}";
//		IronfoMedicalServicesController c = new IronfoMedicalServicesController();
//		
//		IronfoMedicalServices s = c.deserialize(json,IronfoMedicalServices.class);
//		System.out.println(s.getBzcw());
		
		
		
//		(x==y)?'Y':'N'
		
		
	}
	
	
	
	
//	 private static ObjectMapper objectMapper = new ObjectMapper();  
//	 /** 
//     * 将JSON字符串反序列化为对象 
//     *  
//     * @param object 
//     * @return JSON字符串 
//     */  
//    public static <T> T deserialize(String json, Class<T> clazz) {  
//        Object object = null;  
//        try {  
//            object = objectMapper.readValue(json, TypeFactory.rawClass(clazz));  
//        } catch (JsonParseException e) {  
////            logger.error("JsonParseException when serialize object to json", e);  
//        } catch (JsonMappingException e) {  
////            logger.error("JsonMappingException when serialize object to json", e);  
//        } catch (IOException e) {  
////            logger.error("IOException when serialize object to json", e);  
//        }  
//        return (T) object;  
//    }  
	

}