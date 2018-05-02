/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfowsjsrygc.web;

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
import com.jeeplus.modules.ironfofinance.entity.Ironfofinance;
import com.jeeplus.modules.ironfowsjsrygc.entity.Ironfowsjsrygc;
import com.jeeplus.modules.ironfowsjsrygc.service.IronfowsjsrygcService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

import oracle.sql.DATE;

/**
 * 2.7.2卫生技术人员构成Controller
 * @author mikesun
 * @version 2018-03-21
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfowsjsrygc/ironfowsjsrygc")
public class IronfowsjsrygcController extends BaseController {

	@Autowired
	private IronfowsjsrygcService ironfowsjsrygcService;
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	@ModelAttribute
	public Ironfowsjsrygc get(@RequestParam(required=false) String id) {
		Ironfowsjsrygc entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfowsjsrygcService.get(id);
		}
		if (entity == null){
			entity = new Ironfowsjsrygc();
		}
		return entity;
	}
	
	/**
	 * 2.7.2卫生技术人员构成列表页面
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	@RequiresPermissions("ironfowsjsrygc:ironfowsjsrygc:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfowsjsrygc ironfowsjsrygc, HttpServletRequest request, HttpServletResponse response, Model model) throws InstantiationException, IllegalAccessException {
		Subject subject = SecurityUtils.getSubject();  
		Principal obj = (Principal) subject.getPrincipal();
		System.out.println(obj.getId());
		
		
		Map<String,Object> datas = new TreeMap<String,Object>();
		IronfoDocTitle title =  IronfoDocTitle.class.newInstance();
		title.setRemarks(obj.getId());
//		title =  ironfoDoc_Title_Service.getDocId(obj.getId());
		List<IronfoDocTitle> docList = ironfoDoc_Title_Service.queryforList(title);
		
		
		if(docList.size()>0) {
			
			ironfowsjsrygc.setDoc_id(docList.get(0).getId().toString());
			List<Ironfowsjsrygc> data = ironfowsjsrygcService.queryForList(ironfowsjsrygc);
			
			
			
			datas.put("doc_id", docList.get(0).getId().toString());
			
			for(int i = 0; i<data.size();i++) {
				
				if(data.get(i).getDate().toString()=="2015"||"2015".equals(data.get(i).getDate().toString())) {

					datas.put("date", data.get(i).getDate().toString());
					datas.put("id", data.get(i).getId().toString());
					
					 String zyys = data.get(i).getZyys().toString();	// 执业医师（人）         
					 if("----"==zyys.trim()||"----".equals(zyys.trim())) {
							datas.put("zyys","");
						}else {
							datas.put("zyys",zyys);
						}
					 String zyysqzggwslb = data.get(i).getZyysqzggwslb().toString();		// 执业医师其中公共卫生类别（人
					 if("----"==zyysqzggwslb.trim()||"----".equals(zyysqzggwslb.trim())) {
							datas.put("zyysqzggwslb","");
						}else {
							datas.put("zyysqzggwslb",zyysqzggwslb);
						}
					 String zyzlys =data.get(i).getZyzlys().toString();		// 执业助理医师（人）                
					 if("----"==zyzlys.trim()||"----".equals(zyzlys.trim())) {
							datas.put("zyzlys","");
						}else {
							datas.put("zyzlys",zyzlys);
						}
					 String zyzlysqzggwslb = data.get(i).getZyzlysqzggwslb().toString();		// 执业助理医师其中公共卫生类
					 if("----"==zyzlysqzggwslb.trim()||"----".equals(zyzlysqzggwslb.trim())) {
							datas.put("zyzlysqzggwslb","");
						}else {
							datas.put("zyzlysqzggwslb",zyzlysqzggwslb);
						}
					 String zcqkys = data.get(i).getZcqkys().toString();		// 注册全科医生（人）                
					 if("----"==zcqkys.trim()||"----".equals(zcqkys.trim())) {
							datas.put("zcqkys","");
						}else {
							datas.put("zcqkys",zcqkys);
						}
					 String qdqkyspxhgzdrs = data.get(i).getQdqkyspxhgzdrs().toString();		// 取得全科医生培训合格证的人
					 if("----"==qdqkyspxhgzdrs.trim()||"----".equals(qdqkyspxhgzdrs.trim())) {
							datas.put("qdqkyspxhgzdrs","");
						}else {
							datas.put("qdqkyspxhgzdrs",qdqkyspxhgzdrs);
						}
					 String zchs = data.get(i).getZchs().toString();		// 注册护士（人）                      
					 if("----"==zchs.trim()||"----".equals(zchs.trim())) {
							datas.put("zchs","");
						}else {
							datas.put("zchs",zchs);
						}
					 String zcs = data.get(i).getZcs().toString();		// 助产士（人）                        
					 if("----"==zcs.trim()||"----".equals(zcs.trim())) {
							datas.put("zcs","");
						}else {
							datas.put("zcs",zcs);
						}
					 String yss = data.get(i).getYss().toString();		// 药师（士） （人）                   
					 if("----"==yss.trim()||"----".equals(yss.trim())) {
							datas.put("yss","");
						}else {
							datas.put("yss",yss);
						}
					 String zys = data.get(i).getZys().toString();		// 中药师（士） （人）                 
					 if("----"==zys.trim()||"----".equals(zys.trim())) {
							datas.put("zys","");
						}else {
							datas.put("zys",zys);
						}
					 String jyys = data.get(i).getJyys().toString();		// 检验医师（士） （人）               
					 if("----"==jyys.trim()||"----".equals(jyys.trim())) {
							datas.put("jyys","");
						}else {
							datas.put("jyys",jyys);
						}
					 String yxys = data.get(i).getYxys().toString();		// 影像医师（士） （人）               
					 if("----"==yxys.trim()||"----".equals(yxys.trim())) {
							datas.put("yxys","");
						}else {
							datas.put("yxys",yxys);
						}
					 String kfzls = data.get(i).getKfzls().toString();		// 康复治疗师（人）                  
					 if("----"==kfzls.trim()||"----".equals(kfzls.trim())) {
							datas.put("kfzls","");
						}else {
							datas.put("kfzls",kfzls);
						}
					 String qtwsjsry =data.get(i).getQtwsjsry().toString();		// 其他卫生技术人员（人）          

					 if("----"==qtwsjsry.trim()||"----".equals(qtwsjsry.trim())) {
							datas.put("qtwsjsry","");
						}else {
							datas.put("qtwsjsry",qtwsjsry);
						}
					
					
					
					
					
				}else if(data.get(i).getDate().toString()=="2016"||"2016".equals(data.get(i).getDate().toString())) {
					datas.put("date1", data.get(i).getDate().toString());
					datas.put("id1", data.get(i).getId().toString());
					
					
					
					 String zyys = data.get(i).getZyys().toString();	// 执业医师（人）         
					 if("----"==zyys.trim()||"----".equals(zyys.trim())) {
							datas.put("zyys1","");
						}else {
							datas.put("zyys1",zyys);
						}
					 String zyysqzggwslb = data.get(i).getZyysqzggwslb().toString();		// 执业医师其中公共卫生类别（人
					 if("----"==zyysqzggwslb.trim()||"----".equals(zyysqzggwslb.trim())) {
							datas.put("zyysqzggwslb1","");
						}else {
							datas.put("zyysqzggwslb1",zyysqzggwslb);
						}
					 String zyzlys =data.get(i).getZyzlys().toString();		// 执业助理医师（人）                
					 if("----"==zyzlys.trim()||"----".equals(zyzlys.trim())) {
							datas.put("zyzlys1","");
						}else {
							datas.put("zyzlys1",zyzlys);
						}
					 String zyzlysqzggwslb = data.get(i).getZyzlysqzggwslb().toString();		// 执业助理医师其中公共卫生类
					 if("----"==zyzlysqzggwslb.trim()||"----".equals(zyzlysqzggwslb.trim())) {
							datas.put("zyzlysqzggwslb1","");
						}else {
							datas.put("zyzlysqzggwslb1",zyzlysqzggwslb);
						}
					 String zcqkys = data.get(i).getZcqkys().toString();		// 注册全科医生（人）                
					 if("----"==zcqkys.trim()||"----".equals(zcqkys.trim())) {
							datas.put("zcqkys1","");
						}else {
							datas.put("zcqkys1",zcqkys);
						}
					 String qdqkyspxhgzdrs = data.get(i).getQdqkyspxhgzdrs().toString();		// 取得全科医生培训合格证的人
					 if("----"==qdqkyspxhgzdrs.trim()||"----".equals(qdqkyspxhgzdrs.trim())) {
							datas.put("qdqkyspxhgzdrs1","");
						}else {
							datas.put("qdqkyspxhgzdrs1",qdqkyspxhgzdrs);
						}
					 String zchs = data.get(i).getZchs().toString();		// 注册护士（人）                      
					 if("----"==zchs.trim()||"----".equals(zchs.trim())) {
							datas.put("zchs1","");
						}else {
							datas.put("zchs1",zchs);
						}
					 String zcs = data.get(i).getZcs().toString();		// 助产士（人）                        
					 if("----"==zcs.trim()||"----".equals(zcs.trim())) {
							datas.put("zcs1","");
						}else {
							datas.put("zcs1",zcs);
						}
					 String yss = data.get(i).getYss().toString();		// 药师（士） （人）                   
					 if("----"==yss.trim()||"----".equals(yss.trim())) {
							datas.put("yss1","");
						}else {
							datas.put("yss1",yss);
						}
					 String zys = data.get(i).getZys().toString();		// 中药师（士） （人）                 
					 if("----"==zys.trim()||"----".equals(zys.trim())) {
							datas.put("zys1","");
						}else {
							datas.put("zys1",zys);
						}
					 String jyys = data.get(i).getJyys().toString();		// 检验医师（士） （人）               
					 if("----"==jyys.trim()||"----".equals(jyys.trim())) {
							datas.put("jyys1","");
						}else {
							datas.put("jyys1",jyys);
						}
					 String yxys = data.get(i).getYxys().toString();		// 影像医师（士） （人）               
					 if("----"==yxys.trim()||"----".equals(yxys.trim())) {
							datas.put("yxys1","");
						}else {
							datas.put("yxys1",yxys);
						}
					 String kfzls = data.get(i).getKfzls().toString();		// 康复治疗师（人）                  
					 if("----"==kfzls.trim()||"----".equals(kfzls.trim())) {
							datas.put("kfzls1","");
						}else {
							datas.put("kfzls1",kfzls);
						}
					 String qtwsjsry =data.get(i).getQtwsjsry().toString();		// 其他卫生技术人员（人）          

					 if("----"==qtwsjsry.trim()||"----".equals(qtwsjsry.trim())) {
							datas.put("qtwsjsry1","");
						}else {
							datas.put("qtwsjsry1",qtwsjsry);
						}
					
					
					
					
					
				} else if(data.get(i).getDate().toString()=="2017"||"2017".equals(data.get(i).getDate().toString())) {
					
					datas.put("date2", data.get(i).getDate().toString());
					datas.put("id2", data.get(i).getId().toString());
					
					
					 String zyys = data.get(i).getZyys().toString();	// 执业医师（人）         
					 if("----"==zyys.trim()||"----".equals(zyys.trim())) {
							datas.put("zyys2","");
						}else {
							datas.put("zyys2",zyys);
						}
					 String zyysqzggwslb = data.get(i).getZyysqzggwslb().toString();		// 执业医师其中公共卫生类别（人
					 if("----"==zyysqzggwslb.trim()||"----".equals(zyysqzggwslb.trim())) {
							datas.put("zyysqzggwslb2","");
						}else {
							datas.put("zyysqzggwslb2",zyysqzggwslb);
						}
					 String zyzlys =data.get(i).getZyzlys().toString();		// 执业助理医师（人）                
					 if("----"==zyzlys.trim()||"----".equals(zyzlys.trim())) {
							datas.put("zyzlys2","");
						}else {
							datas.put("zyzlys2",zyzlys);
						}
					 String zyzlysqzggwslb = data.get(i).getZyzlysqzggwslb().toString();		// 执业助理医师其中公共卫生类
					 if("----"==zyzlysqzggwslb.trim()||"----".equals(zyzlysqzggwslb.trim())) {
							datas.put("zyzlysqzggwslb2","");
						}else {
							datas.put("zyzlysqzggwslb2",zyzlysqzggwslb);
						}
					 String zcqkys = data.get(i).getZcqkys().toString();		// 注册全科医生（人）                
					 if("----"==zcqkys.trim()||"----".equals(zcqkys.trim())) {
							datas.put("zcqkys2","");
						}else {
							datas.put("zcqkys2",zcqkys);
						}
					 String qdqkyspxhgzdrs = data.get(i).getQdqkyspxhgzdrs().toString();		// 取得全科医生培训合格证的人
					 if("----"==qdqkyspxhgzdrs.trim()||"----".equals(qdqkyspxhgzdrs.trim())) {
							datas.put("qdqkyspxhgzdrs2","");
						}else {
							datas.put("qdqkyspxhgzdrs2",qdqkyspxhgzdrs);
						}
					 String zchs = data.get(i).getZchs().toString();		// 注册护士（人）                      
					 if("----"==zchs.trim()||"----".equals(zchs.trim())) {
							datas.put("zchs2","");
						}else {
							datas.put("zchs2",zchs);
						}
					 String zcs = data.get(i).getZcs().toString();		// 助产士（人）                        
					 if("----"==zcs.trim()||"----".equals(zcs.trim())) {
							datas.put("zcs2","");
						}else {
							datas.put("zcs2",zcs);
						}
					 String yss = data.get(i).getYss().toString();		// 药师（士） （人）                   
					 if("----"==yss.trim()||"----".equals(yss.trim())) {
							datas.put("yss2","");
						}else {
							datas.put("yss2",yss);
						}
					 String zys = data.get(i).getZys().toString();		// 中药师（士） （人）                 
					 if("----"==zys.trim()||"----".equals(zys.trim())) {
							datas.put("zys2","");
						}else {
							datas.put("zys2",zys);
						}
					 String jyys = data.get(i).getJyys().toString();		// 检验医师（士） （人）               
					 if("----"==jyys.trim()||"----".equals(jyys.trim())) {
							datas.put("jyys2","");
						}else {
							datas.put("jyys2",jyys);
						}
					 String yxys = data.get(i).getYxys().toString();		// 影像医师（士） （人）               
					 if("----"==yxys.trim()||"----".equals(yxys.trim())) {
							datas.put("yxys2","");
						}else {
							datas.put("yxys2",yxys);
						}
					 String kfzls = data.get(i).getKfzls().toString();		// 康复治疗师（人）                  
					 if("----"==kfzls.trim()||"----".equals(kfzls.trim())) {
							datas.put("kfzls2","");
						}else {
							datas.put("kfzls2",kfzls);
						}
					 String qtwsjsry =data.get(i).getQtwsjsry().toString();		// 其他卫生技术人员（人）          

					 if("----"==qtwsjsry.trim()||"----".equals(qtwsjsry.trim())) {
							datas.put("qtwsjsry2","");
						}else {
							datas.put("qtwsjsry2",qtwsjsry);
						}
					
					
				}

				
			}
			
		}else {
			datas.put("date", "");
			datas.put("zyys", "");
			datas.put("zyysqzggwslb", "");
			datas.put("zcqkys", "");
			datas.put("zyzlys", "");
			datas.put("zyzlysqzggwslb", "");
			datas.put("qdqkyspxhgzdrs", "");
			datas.put("zchs", "");
			datas.put("zcs", "");
			datas.put("yss", "");
			datas.put("zys", "");
			datas.put("jyys", "");
			datas.put("yxys", "");
			datas.put("kfzls", "");
			datas.put("qtwsjsry", "");
			
			
			datas.put("date1", "");
			datas.put("zyys1", "");
			datas.put("zyysqzggwslb1", "");
			datas.put("zcqkys1", "");
			datas.put("zyzlys1", "");
			datas.put("zyzlysqzggwslb1", "");
			datas.put("qdqkyspxhgzdrs1", "");
			datas.put("zchs1", "");
			datas.put("zcs1", "");
			datas.put("yss1", "");
			datas.put("zys1", "");
			datas.put("jyys1", "");
			datas.put("yxys1", "");
			datas.put("kfzls1", "");
			datas.put("qtwsjsry1", "");
			
			
			datas.put("date2", "");
			datas.put("zyys2", "");
			datas.put("zyysqzggwslb2", "");
			datas.put("zcqkys2", "");
			datas.put("zyzlys2", "");
			datas.put("zyzlysqzggwslb2", "");
			datas.put("qdqkyspxhgzdrs2", "");
			datas.put("zchs2", "");
			datas.put("zcs2", "");
			datas.put("yss2", "");
			datas.put("zys2", "");
			datas.put("jyys2", "");
			datas.put("yxys2", "");
			datas.put("kfzls2", "");
			datas.put("qtwsjsry2", "");
			
		}
		
		
		
		
		
		
		request.setAttribute("data", datas);
		model.addAttribute("data", datas);
		
		//		Page<Ironfowsjsrygc> page = ironfowsjsrygcService.findPage(new Page<Ironfowsjsrygc>(request, response), ironfowsjsrygc); 
//		model.addAttribute("page", page);
		return "modules/ironfowsjsrygc/ironfowsjsrygcList";
	}

	/**
	 * 查看，增加，编辑2.7.2卫生技术人员构成表单页面
	 */
	@RequiresPermissions(value={"ironfowsjsrygc:ironfowsjsrygc:view","ironfowsjsrygc:ironfowsjsrygc:add","ironfowsjsrygc:ironfowsjsrygc:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfowsjsrygc ironfowsjsrygc, Model model) {
		model.addAttribute("ironfowsjsrygc", ironfowsjsrygc);
		return "modules/ironfowsjsrygc/ironfowsjsrygcForm";
	}

	/**
	 * 保存2.7.2卫生技术人员构成
	 */
	@RequiresPermissions(value={"ironfowsjsrygc:ironfowsjsrygc:add","ironfowsjsrygc:ironfowsjsrygc:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfowsjsrygc ironfowsjsrygc, Model model, RedirectAttributes redirectAttributes) throws Exception{

		boolean isnull=false;
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		
		
		
		Subject subject = SecurityUtils.getSubject();  
		Principal obj = (Principal) subject.getPrincipal();
		
		System.out.println(obj.getId());
		
		Map<String,Object> map = new  HashMap<String,Object>();
		String data = request.getParameter("datas");
		String[] ironfowsjsrygcs = data.split(";");
		
		
		
		String docId = "";
		for(int i=0;i<ironfowsjsrygcs.length;i++) {
			map.put(ironfowsjsrygcs[i].toString().split(":")[0].toString(),ironfowsjsrygcs[i].toString().split(":")[1].toString());
			if("docId" == ironfowsjsrygcs[i].toString().trim().split(":")[0].toString().trim() || "docId".equals(ironfowsjsrygcs[i].toString().trim().split(":")[0].toString().trim())) {
				docId = ironfowsjsrygcs[i].toString().split(":")[1].toString();
			}
		}
		
		
		
		if(docId.toString().trim() == null || "".equals(docId.toString().trim())) {
			
			
 			isnull = false;
 			
 			IronfoDocTitle title =  IronfoDocTitle.class.newInstance();
 			title.setRemarks(obj.getId());
 			
 			List<IronfoDocTitle> docList = ironfoDoc_Title_Service.queryforList(title);
 			docId= docList.get(0).getId().toString();
 			
		}else {
			
			ironfowsjsrygc.setDoc_id(docId);
			List<Ironfowsjsrygc> ironfoList = ironfowsjsrygcService.queryForList(ironfowsjsrygc);
			if(ironfoList.size()>0) {
				isnull = true;
			}else {
				isnull = false;
			}
			
		}
		
		
		
		Ironfowsjsrygc ironfowsjsrygc_2015= null;
		Ironfowsjsrygc ironfowsjsrygc_2016= null;
		Ironfowsjsrygc ironfowsjsrygc_2017= null;
		
		if(isnull == false) {
			
			ironfowsjsrygc_2015 = new Ironfowsjsrygc();
			ironfowsjsrygc_2015.setDate(map.get("date").toString());
			ironfowsjsrygc_2015.setQtwsjsry(map.get("qtwsjsry").toString());
			ironfowsjsrygc_2015.setKfzls(map.get("kfzls").toString());
			ironfowsjsrygc_2015.setYxys(map.get("yxys").toString());
			ironfowsjsrygc_2015.setJyys(map.get("jyys").toString());
			ironfowsjsrygc_2015.setZys(map.get("zys").toString());
			ironfowsjsrygc_2015.setYss(map.get("yss").toString());
			ironfowsjsrygc_2015.setZcs(map.get("zcs").toString());
			ironfowsjsrygc_2015.setZchs(map.get("zchs").toString());
			ironfowsjsrygc_2015.setQdqkyspxhgzdrs(map.get("qdqkyspxhgzdrs").toString());
			ironfowsjsrygc_2015.setZcqkys(map.get("zcqkys").toString());
			ironfowsjsrygc_2015.setZyzlysqzggwslb(map.get("zyzlysqzggwslb").toString());
			ironfowsjsrygc_2015.setZyzlys(map.get("zyzlys").toString());
			ironfowsjsrygc_2015.setZyysqzggwslb(map.get("zyysqzggwslb").toString());
			ironfowsjsrygc_2015.setZyys(map.get("zyys").toString());
			ironfowsjsrygc_2015.setDoc_id(docId);
			ironfowsjsrygcService.save(ironfowsjsrygc_2015);
			
			ironfowsjsrygc_2016 = new Ironfowsjsrygc();
			ironfowsjsrygc_2016.setDate(map.get("date1").toString());
			ironfowsjsrygc_2016.setQtwsjsry(map.get("qtwsjsry1").toString());
			ironfowsjsrygc_2016.setKfzls(map.get("kfzls1").toString());
			ironfowsjsrygc_2016.setYxys(map.get("yxys1").toString());
			ironfowsjsrygc_2016.setJyys(map.get("jyys1").toString());
			ironfowsjsrygc_2016.setZys(map.get("zys1").toString());
			ironfowsjsrygc_2016.setYss(map.get("yss1").toString());
			ironfowsjsrygc_2016.setZcs(map.get("zcs1").toString());
			ironfowsjsrygc_2016.setZchs(map.get("zchs1").toString());
			ironfowsjsrygc_2016.setQdqkyspxhgzdrs(map.get("qdqkyspxhgzdrs1").toString());
			ironfowsjsrygc_2016.setZcqkys(map.get("zcqkys1").toString());
			ironfowsjsrygc_2016.setZyzlysqzggwslb(map.get("zyzlysqzggwslb1").toString());
			ironfowsjsrygc_2016.setZyzlys(map.get("zyzlys1").toString());
			ironfowsjsrygc_2016.setZyysqzggwslb(map.get("zyysqzggwslb1").toString());
			ironfowsjsrygc_2016.setZyys(map.get("zyys1").toString());
			ironfowsjsrygc_2016.setDoc_id(docId);
			ironfowsjsrygcService.save(ironfowsjsrygc_2016);
			
			ironfowsjsrygc_2017 = new Ironfowsjsrygc();
			ironfowsjsrygc_2017.setDate(map.get("date2").toString());
			ironfowsjsrygc_2017.setQtwsjsry(map.get("qtwsjsry2").toString());
			ironfowsjsrygc_2017.setKfzls(map.get("kfzls2").toString());
			ironfowsjsrygc_2017.setYxys(map.get("yxys2").toString());
			ironfowsjsrygc_2017.setJyys(map.get("jyys2").toString());
			ironfowsjsrygc_2017.setZys(map.get("zys2").toString());
			ironfowsjsrygc_2017.setYss(map.get("yss2").toString());
			ironfowsjsrygc_2017.setZcs(map.get("zcs2").toString());
			ironfowsjsrygc_2017.setZchs(map.get("zchs2").toString());
			ironfowsjsrygc_2017.setQdqkyspxhgzdrs(map.get("qdqkyspxhgzdrs2").toString());
			ironfowsjsrygc_2017.setZcqkys(map.get("zcqkys2").toString());
			ironfowsjsrygc_2017.setZyzlysqzggwslb(map.get("zyzlysqzggwslb2").toString());
			ironfowsjsrygc_2017.setZyzlys(map.get("zyzlys2").toString());
			ironfowsjsrygc_2017.setZyysqzggwslb(map.get("zyysqzggwslb2").toString());
			ironfowsjsrygc_2017.setZyys(map.get("zyys2").toString());
			ironfowsjsrygc_2017.setDoc_id(docId);
			ironfowsjsrygcService.save(ironfowsjsrygc_2017);
			
			
			
		}else if(isnull == true) {
			
			
			ironfowsjsrygc_2015 = new Ironfowsjsrygc();
			ironfowsjsrygc_2015.setDate(map.get("date").toString());
			ironfowsjsrygc_2015.setQtwsjsry(map.get("qtwsjsry").toString());
			ironfowsjsrygc_2015.setKfzls(map.get("kfzls").toString());
			ironfowsjsrygc_2015.setYxys(map.get("yxys").toString());
			ironfowsjsrygc_2015.setJyys(map.get("jyys").toString());
			ironfowsjsrygc_2015.setZys(map.get("zys").toString());
			ironfowsjsrygc_2015.setYss(map.get("yss").toString());
			ironfowsjsrygc_2015.setZcs(map.get("zcs").toString());
			ironfowsjsrygc_2015.setZchs(map.get("zchs").toString());
			ironfowsjsrygc_2015.setQdqkyspxhgzdrs(map.get("qdqkyspxhgzdrs").toString());
			ironfowsjsrygc_2015.setZcqkys(map.get("zcqkys").toString());
			ironfowsjsrygc_2015.setZyzlysqzggwslb(map.get("zyzlysqzggwslb").toString());
			ironfowsjsrygc_2015.setZyzlys(map.get("zyzlys").toString());
			ironfowsjsrygc_2015.setZyysqzggwslb(map.get("zyysqzggwslb").toString());
			ironfowsjsrygc_2015.setZyys(map.get("zyys").toString());
			ironfowsjsrygc_2015.setId(map.get("id").toString());
			ironfowsjsrygc_2015.setDoc_id(docId);
			ironfowsjsrygcService.updateIronfo(ironfowsjsrygc_2015);
			
			ironfowsjsrygc_2016 = new Ironfowsjsrygc();
			ironfowsjsrygc_2016.setDate(map.get("date1").toString());
			ironfowsjsrygc_2016.setQtwsjsry(map.get("qtwsjsry1").toString());
			ironfowsjsrygc_2016.setKfzls(map.get("kfzls1").toString());
			ironfowsjsrygc_2016.setYxys(map.get("yxys1").toString());
			ironfowsjsrygc_2016.setJyys(map.get("jyys1").toString());
			ironfowsjsrygc_2016.setZys(map.get("zys1").toString());
			ironfowsjsrygc_2016.setYss(map.get("yss1").toString());
			ironfowsjsrygc_2016.setZcs(map.get("zcs1").toString());
			ironfowsjsrygc_2016.setZchs(map.get("zchs1").toString());
			ironfowsjsrygc_2016.setQdqkyspxhgzdrs(map.get("qdqkyspxhgzdrs1").toString());
			ironfowsjsrygc_2016.setZcqkys(map.get("zcqkys1").toString());
			ironfowsjsrygc_2016.setZyzlysqzggwslb(map.get("zyzlysqzggwslb1").toString());
			ironfowsjsrygc_2016.setZyzlys(map.get("zyzlys1").toString());
			ironfowsjsrygc_2016.setZyysqzggwslb(map.get("zyysqzggwslb1").toString());
			ironfowsjsrygc_2016.setZyys(map.get("zyys1").toString());
			ironfowsjsrygc_2016.setId(map.get("id1").toString());
			ironfowsjsrygc_2016.setDoc_id(docId);
			ironfowsjsrygcService.updateIronfo(ironfowsjsrygc_2016);
			
			ironfowsjsrygc_2017 = new Ironfowsjsrygc();
			ironfowsjsrygc_2017.setDate(map.get("date2").toString());
			ironfowsjsrygc_2017.setQtwsjsry(map.get("qtwsjsry2").toString());
			ironfowsjsrygc_2017.setKfzls(map.get("kfzls2").toString());
			ironfowsjsrygc_2017.setYxys(map.get("yxys2").toString());
			ironfowsjsrygc_2017.setJyys(map.get("jyys2").toString());
			ironfowsjsrygc_2017.setZys(map.get("zys2").toString());
			ironfowsjsrygc_2017.setYss(map.get("yss2").toString());
			ironfowsjsrygc_2017.setZcs(map.get("zcs2").toString());
			ironfowsjsrygc_2017.setZchs(map.get("zchs2").toString());
			ironfowsjsrygc_2017.setQdqkyspxhgzdrs(map.get("qdqkyspxhgzdrs2").toString());
			ironfowsjsrygc_2017.setZcqkys(map.get("zcqkys2").toString());
			ironfowsjsrygc_2017.setZyzlysqzggwslb(map.get("zyzlysqzggwslb2").toString());
			ironfowsjsrygc_2017.setZyzlys(map.get("zyzlys2").toString());
			ironfowsjsrygc_2017.setZyysqzggwslb(map.get("zyysqzggwslb2").toString());
			ironfowsjsrygc_2017.setZyys(map.get("zyys2").toString());
			ironfowsjsrygc_2017.setId(map.get("id2").toString());
			ironfowsjsrygc_2017.setDoc_id(docId);
			ironfowsjsrygcService.updateIronfo(ironfowsjsrygc_2017);
			
			
		}
		
		
		
		
		
		
		
		
		
		//		if (!beanValidator(model, ironfowsjsrygc)){
//			return form(ironfowsjsrygc, model);
//		}
//		if(!ironfowsjsrygc.getIsNewRecord()){//编辑表单保存
//			Ironfowsjsrygc t = ironfowsjsrygcService.get(ironfowsjsrygc.getId());//从数据库取出记录的值
//			MyBeanUtils.copyBeanNotNull2Bean(ironfowsjsrygc, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
//			ironfowsjsrygcService.save(t);//保存
//		}else{//新增表单保存
//			ironfowsjsrygcService.save(ironfowsjsrygc);//保存
//		}
		addMessage(redirectAttributes, "保存2.7.2卫生技术人员构成成功");
		return "redirect:"+Global.getAdminPath()+"/ironfowsjsrygc/ironfowsjsrygc/?repage";
	}
	
	/**
	 * 删除2.7.2卫生技术人员构成
	 */
	@RequiresPermissions("ironfowsjsrygc:ironfowsjsrygc:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfowsjsrygc ironfowsjsrygc, RedirectAttributes redirectAttributes) {
		ironfowsjsrygcService.delete(ironfowsjsrygc);
		addMessage(redirectAttributes, "删除2.7.2卫生技术人员构成成功");
		return "redirect:"+Global.getAdminPath()+"/ironfowsjsrygc/ironfowsjsrygc/?repage";
	}
	
	/**
	 * 批量删除2.7.2卫生技术人员构成
	 */
	@RequiresPermissions("ironfowsjsrygc:ironfowsjsrygc:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfowsjsrygcService.delete(ironfowsjsrygcService.get(id));
		}
		addMessage(redirectAttributes, "删除2.7.2卫生技术人员构成成功");
		return "redirect:"+Global.getAdminPath()+"/ironfowsjsrygc/ironfowsjsrygc/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfowsjsrygc:ironfowsjsrygc:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfowsjsrygc ironfowsjsrygc, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "2.7.2卫生技术人员构成"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfowsjsrygc> page = ironfowsjsrygcService.findPage(new Page<Ironfowsjsrygc>(request, response, -1), ironfowsjsrygc);
    		new ExportExcel("2.7.2卫生技术人员构成", Ironfowsjsrygc.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出2.7.2卫生技术人员构成记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfowsjsrygc/ironfowsjsrygc/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfowsjsrygc:ironfowsjsrygc:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfowsjsrygc> list = ei.getDataList(Ironfowsjsrygc.class);
			for (Ironfowsjsrygc ironfowsjsrygc : list){
				try{
					ironfowsjsrygcService.save(ironfowsjsrygc);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条2.7.2卫生技术人员构成记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条2.7.2卫生技术人员构成记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入2.7.2卫生技术人员构成失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfowsjsrygc/ironfowsjsrygc/?repage";
    }
	
	/**
	 * 下载导入2.7.2卫生技术人员构成数据模板
	 */
	@RequiresPermissions("ironfowsjsrygc:ironfowsjsrygc:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "2.7.2卫生技术人员构成数据导入模板.xlsx";
    		List<Ironfowsjsrygc> list = Lists.newArrayList(); 
    		new ExportExcel("2.7.2卫生技术人员构成数据", Ironfowsjsrygc.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfowsjsrygc/ironfowsjsrygc/?repage";
    }
	
	
	

}