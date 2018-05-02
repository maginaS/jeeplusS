/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfopublichealth.web;

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
import com.jeeplus.modules.ironfopublichealth.entity.Ironfopublichealth;
import com.jeeplus.modules.ironfopublichealth.service.IronfopublichealthService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 2.3基本公共卫生服务Controller
 * @author mikesun
 * @version 2018-03-16
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfopublichealth/ironfopublichealth")
public class IronfopublichealthController extends BaseController {

	@Autowired
	private IronfopublichealthService ironfopublichealthService;
	
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	@ModelAttribute
	public Ironfopublichealth get(@RequestParam(required=false) String id) {
		Ironfopublichealth entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfopublichealthService.get(id);
		}
		if (entity == null){
			entity = new Ironfopublichealth();
		}
		return entity;
	}
	
	/**
	 * 2.3基本公共卫生服务列表页面
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	@RequiresPermissions("ironfopublichealth:ironfopublichealth:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfopublichealth ironfopublichealth, HttpServletRequest request, HttpServletResponse response, Model model) throws InstantiationException, IllegalAccessException {
		
		
		Subject subject = SecurityUtils.getSubject();  
		Principal obj = (Principal) subject.getPrincipal();
		System.out.println(obj.getId());
		
		
		Map<String,Object> datas = new TreeMap<String,Object>();
		IronfoDocTitle title =  IronfoDocTitle.class.newInstance();
		title.setRemarks(obj.getId());
//		title =  ironfoDoc_Title_Service.getDocId(obj.getId());
		List<IronfoDocTitle> docList = ironfoDoc_Title_Service.queryforList(title);
		
		
		if(docList.size()>0) {
			
			ironfopublichealth.setDoc_id(docList.get(0).getId().toString());
			List<Ironfopublichealth> data = ironfopublichealthService.queryForList(ironfopublichealth);
			
			
			datas.put("doc_id", docList.get(0).getId().toString());
			
			for(int i = 0; i<data.size();i++) {
				if(data.get(i).getDate().toString()=="2015"||"2015".equals(data.get(i).getDate().toString())) {
					
					datas.put("date", data.get(i).getDate().toString());
					datas.put("id", data.get(i).getId().toString());
					String nmfwczrks = data.get(i).getNmfwczrks().toString();
					if("----"==nmfwczrks.trim()||"----".equals(nmfwczrks.trim())) {
						datas.put("nmfwczrks","");
					}else {
						datas.put("nmfwczrks",nmfwczrks);
					}
					String qzldlsets = data.get(i).getQzldlsets().toString();
					if("----"==qzldlsets.trim()||"----".equals(qzldlsets.trim())) {
						datas.put("qzldlsets","");
					}else {
						datas.put("qzldlsets",qzldlsets);
					}
					String qzldssets = data.get(i).getQzldssets().toString();
					if("----"==qzldssets.trim()||"----".equals(qzldssets.trim())) {
						datas.put("qzldssets","");
					}else {
						datas.put("qzldssets",qzldssets);
					}
					String qzlswsysrks = data.get(i).getQzlswsysrks().toString();
					if("----"==qzlswsysrks.trim()||"----".equals(qzlswsysrks.trim())) {
						datas.put("qzlswsysrks","");
					}else {
						datas.put("qzlswsysrks",qzlswsysrks);
					}
					String nmjmjkdaljjdrs = data.get(i).getNmjmjkdaljjdrs().toString();
					if("----"==nmjmjkdaljjdrs.trim()||"----".equals(nmjmjkdaljjdrs.trim())) {
						datas.put("nmjmjkdaljjdrs","");
					}else {
						datas.put("nmjmjkdaljjdrs",nmjmjkdaljjdrs);
					}
					String qzgfhdzdars = data.get(i).getQzgfhdzdars().toString();
					if("----"==qzgfhdzdars.trim()||"----".equals(qzgfhdzdars.trim())) {
						datas.put("qzgfhdzdars","");
					}else {
						datas.put("qzgfhdzdars",qzgfhdzdars);
					}
					 String nnjsjkjyrcs = data.get(i).getNnjsjkjyrcs().toString();		// 年内接受健康教育人次数（人次） 
					 if("----"==nnjsjkjyrcs.trim()||"----".equals(nnjsjkjyrcs.trim())) {
							datas.put("nnjsjkjyrcs","");
						}else {
							datas.put("nnjsjkjyrcs",nnjsjkjyrcs);
						}
					 String nnldlsetyfjzrcs = data.get(i).getNnldlsetyfjzrcs().toString();		// 年内0-6岁儿童预防接种人次数（人次）     
					 if("----"==nnldlsetyfjzrcs.trim()||"----".equals(nnldlsetyfjzrcs.trim())) {
							datas.put("nnldlsetyfjzrcs","");
						}else {
							datas.put("nnldlsetyfjzrcs",nnldlsetyfjzrcs);
						}
					 String nmldlsetjkglrs = data.get(i).getNmldlsetjkglrs().toString();		// 年末0-6岁儿童健康管理人数（人次）         
					 if("----"==nmldlsetjkglrs.trim()||"----".equals(nmldlsetjkglrs.trim())) {
							datas.put("nmldlsetjkglrs","");
						}else {
							datas.put("nmldlsetjkglrs",nmldlsetjkglrs);
						}
					 String nmycfjkglrs=data.get(i).getNmycfjkglrs().toString();		// 年末孕产妇健康管理人数（人）                
					 if("----"==nmycfjkglrs.trim()||"----".equals(nmycfjkglrs.trim())) {
							datas.put("nmycfjkglrs","");
						}else {
							datas.put("nmycfjkglrs",nmycfjkglrs);
						}
					 String nmlswsyslrjkglr=data.get(i).getNmlswsyslrjkglr().toString();		// 年末65岁以上老人健康管理人（人）        
					 if("----"==nmlswsyslrjkglr.trim()||"----".equals(nmlswsyslrjkglr.trim())) {
							datas.put("nmlswsyslrjkglr","");
						}else {
							datas.put("nmlswsyslrjkglr",nmlswsyslrjkglr);
						}
					 String nmgxygfglrs = data.get(i).getNmgxygfglrs();		// 年末高血压规范管理人数（人）                
					 if("----"==nmgxygfglrs.trim()||"----".equals(nmgxygfglrs.trim())) {
							datas.put("nmgxygfglrs","");
						}else {
							datas.put("nmgxygfglrs",nmgxygfglrs);
						}
					 String nmtnbgfglrs = data.get(i).getNmtnbgfglrs().toString();		// 年末糖尿病规范管理人数（人）                
					 if("----"==nmtnbgfglrs.trim()||"----".equals(nmtnbgfglrs.trim())) {
							datas.put("nmtnbgfglrs","");
						}else {
							datas.put("nmtnbgfglrs",nmtnbgfglrs);
						}
					 String nmzxjszahzglrs = data.get(i).getNmzxjszahzglrs().toString();		// 年末重性精神障碍患者管理人数（人）        
					 if("----"==nmzxjszahzglrs.trim()||"----".equals(nmzxjszahzglrs.trim())) {
							datas.put("nmzxjszahzglrs","");
						}else {
							datas.put("nmzxjszahzglrs",nmzxjszahzglrs);
						}
					 String nmfjhhzglrs = data.get(i).getNmfjhhzglrs().toString();		// 年末肺结核患者管理人数（人）                
					 if("----"==nmfjhhzglrs.trim()||"----".equals(nmfjhhzglrs.trim())) {
							datas.put("nmfjhhzglrs","");
						}else {
							datas.put("nmfjhhzglrs",nmfjhhzglrs);
						}
					 String nncrbhtfggwssjbgls = data.get(i).getNncrbhtfggwssjbgls().toString();		// 年内传染病和突发公共卫生事件报告例数（
					 if("----"==nncrbhtfggwssjbgls.trim()||"----".equals(nncrbhtfggwssjbgls.trim())) {
							datas.put("nncrbhtfggwssjbgls","");
						}else {
							datas.put("nncrbhtfggwssjbgls",nncrbhtfggwssjbgls);
						}
					 String nnwsjdxgxxbgls = data.get(i).getNnwsjdxgxxbgls().toString();		// 年内卫生监督协管信息报告例数（例）        
					 if("----"==nnwsjdxgxxbgls.trim()||"----".equals(nnwsjdxgxxbgls.trim())) {
							datas.put("nnwsjdxgxxbgls","");
						}else {
							datas.put("nnwsjdxgxxbgls",nnwsjdxgxxbgls);
						}
					 String nmldssetzyyjkglrs = data.get(i).getNmldssetzyyjkglrs().toString();		// 年末0-3岁儿童中医药健康管理人数（人） 
					 if("----"==nmldssetzyyjkglrs.trim()||"----".equals(nmldssetzyyjkglrs.trim())) {
							datas.put("nmldssetzyyjkglrs","");
						}else {
							datas.put("nmldssetzyyjkglrs",nmldssetzyyjkglrs);
						}
					 String nmlswyslrzyyjkglrs = data.get(i).getNmlswyslrzyyjkglrs();		// 年末65岁以上老人中医药健康管理人数（人

					 if("----"==nmlswyslrzyyjkglrs.trim()||"----".equals(nmlswyslrzyyjkglrs.trim())) {
							datas.put("nmlswyslrzyyjkglrs","");
						}else {
							datas.put("nmlswyslrzyyjkglrs",nmlswyslrzyyjkglrs);
						}
					
					
					
				}else if(data.get(i).getDate().toString()=="2016"||"2016".equals(data.get(i).getDate().toString())) {
					
					datas.put("date1", data.get(i).getDate().toString());
					datas.put("id1", data.get(i).getId().toString());
					
					
					String nmfwczrks = data.get(i).getNmfwczrks().toString();
					if("----"==nmfwczrks.trim()||"----".equals(nmfwczrks.trim())) {
						datas.put("nmfwczrks1","");
					}else {
						datas.put("nmfwczrks1",nmfwczrks);
					}
					String qzldlsets = data.get(i).getQzldlsets().toString();
					if("----"==qzldlsets.trim()||"----".equals(qzldlsets.trim())) {
						datas.put("qzldlsets1","");
					}else {
						datas.put("qzldlsets1",qzldlsets);
					}
					String qzldssets = data.get(i).getQzldssets().toString();
					if("----"==qzldssets.trim()||"----".equals(qzldssets.trim())) {
						datas.put("qzldssets1","");
					}else {
						datas.put("qzldssets1",qzldssets);
					}
					String qzlswsysrks = data.get(i).getQzlswsysrks().toString();
					if("----"==qzlswsysrks.trim()||"----".equals(qzlswsysrks.trim())) {
						datas.put("qzlswsysrks1","");
					}else {
						datas.put("qzlswsysrks1",qzlswsysrks);
					}
					String nmjmjkdaljjdrs = data.get(i).getNmjmjkdaljjdrs().toString();
					if("----"==nmjmjkdaljjdrs.trim()||"----".equals(nmjmjkdaljjdrs.trim())) {
						datas.put("nmjmjkdaljjdrs1","");
					}else {
						datas.put("nmjmjkdaljjdrs1",nmjmjkdaljjdrs);
					}
					String qzgfhdzdars = data.get(i).getQzgfhdzdars().toString();
					if("----"==qzgfhdzdars.trim()||"----".equals(qzgfhdzdars.trim())) {
						datas.put("qzgfhdzdars1","");
					}else {
						datas.put("qzgfhdzdars1",qzgfhdzdars);
					}
					 String nnjsjkjyrcs = data.get(i).getNnjsjkjyrcs().toString();		// 年内接受健康教育人次数（人次） 
					 if("----"==nnjsjkjyrcs.trim()||"----".equals(nnjsjkjyrcs.trim())) {
							datas.put("nnjsjkjyrcs1","");
						}else {
							datas.put("nnjsjkjyrcs1",nnjsjkjyrcs);
						}
					 String nnldlsetyfjzrcs = data.get(i).getNnldlsetyfjzrcs().toString();		// 年内0-6岁儿童预防接种人次数（人次）     
					 if("----"==nnldlsetyfjzrcs.trim()||"----".equals(nnldlsetyfjzrcs.trim())) {
							datas.put("nnldlsetyfjzrcs1","");
						}else {
							datas.put("nnldlsetyfjzrcs1",nnldlsetyfjzrcs);
						}
					 String nmldlsetjkglrs = data.get(i).getNmldlsetjkglrs().toString();		// 年末0-6岁儿童健康管理人数（人次）         
					 if("----"==nmldlsetjkglrs.trim()||"----".equals(nmldlsetjkglrs.trim())) {
							datas.put("nmldlsetjkglrs1","");
						}else {
							datas.put("nmldlsetjkglrs1",nmldlsetjkglrs);
						}
					 String nmycfjkglrs=data.get(i).getNmycfjkglrs().toString();		// 年末孕产妇健康管理人数（人）                
					 if("----"==nmycfjkglrs.trim()||"----".equals(nmycfjkglrs.trim())) {
							datas.put("nmycfjkglrs1","");
						}else {
							datas.put("nmycfjkglrs1",nmycfjkglrs);
						}
					 String nmlswsyslrjkglr=data.get(i).getNmlswsyslrjkglr().toString();		// 年末65岁以上老人健康管理人（人）        
					 if("----"==nmlswsyslrjkglr.trim()||"----".equals(nmlswsyslrjkglr.trim())) {
							datas.put("nmlswsyslrjkglr1","");
						}else {
							datas.put("nmlswsyslrjkglr1",nmlswsyslrjkglr);
						}
					 String nmgxygfglrs = data.get(i).getNmgxygfglrs();		// 年末高血压规范管理人数（人）                
					 if("----"==nmgxygfglrs.trim()||"----".equals(nmgxygfglrs.trim())) {
							datas.put("nmgxygfglrs1","");
						}else {
							datas.put("nmgxygfglrs1",nmgxygfglrs);
						}
					 String nmtnbgfglrs = data.get(i).getNmtnbgfglrs().toString();		// 年末糖尿病规范管理人数（人）                
					 if("----"==nmtnbgfglrs.trim()||"----".equals(nmtnbgfglrs.trim())) {
							datas.put("nmtnbgfglrs1","");
						}else {
							datas.put("nmtnbgfglrs1",nmtnbgfglrs);
						}
					 String nmzxjszahzglrs = data.get(i).getNmzxjszahzglrs().toString();		// 年末重性精神障碍患者管理人数（人）        
					 if("----"==nmzxjszahzglrs.trim()||"----".equals(nmzxjszahzglrs.trim())) {
							datas.put("nmzxjszahzglrs1","");
						}else {
							datas.put("nmzxjszahzglrs1",nmzxjszahzglrs);
						}
					 String nmfjhhzglrs = data.get(i).getNmfjhhzglrs().toString();		// 年末肺结核患者管理人数（人）                
					 if("----"==nmfjhhzglrs.trim()||"----".equals(nmfjhhzglrs.trim())) {
							datas.put("nmfjhhzglrs1","");
						}else {
							datas.put("nmfjhhzglrs1",nmfjhhzglrs);
						}
					 String nncrbhtfggwssjbgls = data.get(i).getNncrbhtfggwssjbgls().toString();		// 年内传染病和突发公共卫生事件报告例数（
					 if("----"==nncrbhtfggwssjbgls.trim()||"----".equals(nncrbhtfggwssjbgls.trim())) {
							datas.put("nncrbhtfggwssjbgls1","");
						}else {
							datas.put("nncrbhtfggwssjbgls1",nncrbhtfggwssjbgls);
						}
					 String nnwsjdxgxxbgls = data.get(i).getNnwsjdxgxxbgls().toString();		// 年内卫生监督协管信息报告例数（例）        
					 if("----"==nnwsjdxgxxbgls.trim()||"----".equals(nnwsjdxgxxbgls.trim())) {
							datas.put("nnwsjdxgxxbgls1","");
						}else {
							datas.put("nnwsjdxgxxbgls1",nnwsjdxgxxbgls);
						}
					 String nmldssetzyyjkglrs = data.get(i).getNmldssetzyyjkglrs().toString();		// 年末0-3岁儿童中医药健康管理人数（人） 
					 if("----"==nmldssetzyyjkglrs.trim()||"----".equals(nmldssetzyyjkglrs.trim())) {
							datas.put("nmldssetzyyjkglrs1","");
						}else {
							datas.put("nmldssetzyyjkglrs1",nmldssetzyyjkglrs);
						}
					 String nmlswyslrzyyjkglrs = data.get(i).getNmlswyslrzyyjkglrs();		// 年末65岁以上老人中医药健康管理人数（人

					 if("----"==nmlswyslrzyyjkglrs.trim()||"----".equals(nmlswyslrzyyjkglrs.trim())) {
							datas.put("nmlswyslrzyyjkglrs1","");
						}else {
							datas.put("nmlswyslrzyyjkglrs1",nmlswyslrzyyjkglrs);
						}
					
					
					
					
					
					
				}else if(data.get(i).getDate().toString()=="2017"||"2017".equals(data.get(i).getDate().toString())) {
					

					datas.put("date2", data.get(i).getDate().toString());
					datas.put("id2", data.get(i).getId().toString());
					
					
					String nmfwczrks = data.get(i).getNmfwczrks().toString();
					if("----"==nmfwczrks.trim()||"----".equals(nmfwczrks.trim())) {
						datas.put("nmfwczrks2","");
					}else {
						datas.put("nmfwczrks2",nmfwczrks);
					}
					String qzldlsets = data.get(i).getQzldlsets().toString();
					if("----"==qzldlsets.trim()||"----".equals(qzldlsets.trim())) {
						datas.put("qzldlsets2","");
					}else {
						datas.put("qzldlsets2",qzldlsets);
					}
					String qzldssets = data.get(i).getQzldssets().toString();
					if("----"==qzldssets.trim()||"----".equals(qzldssets.trim())) {
						datas.put("qzldssets2","");
					}else {
						datas.put("qzldssets2",qzldssets);
					}
					String qzlswsysrks = data.get(i).getQzlswsysrks().toString();
					if("----"==qzlswsysrks.trim()||"----".equals(qzlswsysrks.trim())) {
						datas.put("qzlswsysrks2","");
					}else {
						datas.put("qzlswsysrks2",qzlswsysrks);
					}
					String nmjmjkdaljjdrs = data.get(i).getNmjmjkdaljjdrs().toString();
					if("----"==nmjmjkdaljjdrs.trim()||"----".equals(nmjmjkdaljjdrs.trim())) {
						datas.put("nmjmjkdaljjdrs2","");
					}else {
						datas.put("nmjmjkdaljjdrs2",nmjmjkdaljjdrs);
					}
					String qzgfhdzdars = data.get(i).getQzgfhdzdars().toString();
					if("----"==qzgfhdzdars.trim()||"----".equals(qzgfhdzdars.trim())) {
						datas.put("qzgfhdzdars2","");
					}else {
						datas.put("qzgfhdzdars2",qzgfhdzdars);
					}
					 String nnjsjkjyrcs = data.get(i).getNnjsjkjyrcs().toString();		// 年内接受健康教育人次数（人次） 
					 if("----"==nnjsjkjyrcs.trim()||"----".equals(nnjsjkjyrcs.trim())) {
							datas.put("nnjsjkjyrcs2","");
						}else {
							datas.put("nnjsjkjyrcs2",nnjsjkjyrcs);
						}
					 String nnldlsetyfjzrcs = data.get(i).getNnldlsetyfjzrcs().toString();		// 年内0-6岁儿童预防接种人次数（人次）     
					 if("----"==nnldlsetyfjzrcs.trim()||"----".equals(nnldlsetyfjzrcs.trim())) {
							datas.put("nnldlsetyfjzrcs2","");
						}else {
							datas.put("nnldlsetyfjzrcs2",nnldlsetyfjzrcs);
						}
					 String nmldlsetjkglrs = data.get(i).getNmldlsetjkglrs().toString();		// 年末0-6岁儿童健康管理人数（人次）         
					 if("----"==nmldlsetjkglrs.trim()||"----".equals(nmldlsetjkglrs.trim())) {
							datas.put("nmldlsetjkglrs2","");
						}else {
							datas.put("nmldlsetjkglrs2",nmldlsetjkglrs);
						}
					 String nmycfjkglrs=data.get(i).getNmycfjkglrs().toString();		// 年末孕产妇健康管理人数（人）                
					 if("----"==nmycfjkglrs.trim()||"----".equals(nmycfjkglrs.trim())) {
							datas.put("nmycfjkglrs2","");
						}else {
							datas.put("nmycfjkglrs2",nmycfjkglrs);
						}
					 String nmlswsyslrjkglr=data.get(i).getNmlswsyslrjkglr().toString();		// 年末65岁以上老人健康管理人（人）        
					 if("----"==nmlswsyslrjkglr.trim()||"----".equals(nmlswsyslrjkglr.trim())) {
							datas.put("nmlswsyslrjkglr2","");
						}else {
							datas.put("nmlswsyslrjkglr2",nmlswsyslrjkglr);
						}
					 String nmgxygfglrs = data.get(i).getNmgxygfglrs();		// 年末高血压规范管理人数（人）                
					 if("----"==nmgxygfglrs.trim()||"----".equals(nmgxygfglrs.trim())) {
							datas.put("nmgxygfglrs2","");
						}else {
							datas.put("nmgxygfglrs2",nmgxygfglrs);
						}
					 String nmtnbgfglrs = data.get(i).getNmtnbgfglrs().toString();		// 年末糖尿病规范管理人数（人）                
					 if("----"==nmtnbgfglrs.trim()||"----".equals(nmtnbgfglrs.trim())) {
							datas.put("nmtnbgfglrs2","");
						}else {
							datas.put("nmtnbgfglrs2",nmtnbgfglrs);
						}
					 String nmzxjszahzglrs = data.get(i).getNmzxjszahzglrs().toString();		// 年末重性精神障碍患者管理人数（人）        
					 if("----"==nmzxjszahzglrs.trim()||"----".equals(nmzxjszahzglrs.trim())) {
							datas.put("nmzxjszahzglrs2","");
						}else {
							datas.put("nmzxjszahzglrs2",nmzxjszahzglrs);
						}
					 String nmfjhhzglrs = data.get(i).getNmfjhhzglrs().toString();		// 年末肺结核患者管理人数（人）                
					 if("----"==nmfjhhzglrs.trim()||"----".equals(nmfjhhzglrs.trim())) {
							datas.put("nmfjhhzglrs2","");
						}else {
							datas.put("nmfjhhzglrs2",nmfjhhzglrs);
						}
					 String nncrbhtfggwssjbgls = data.get(i).getNncrbhtfggwssjbgls().toString();		// 年内传染病和突发公共卫生事件报告例数（
					 if("----"==nncrbhtfggwssjbgls.trim()||"----".equals(nncrbhtfggwssjbgls.trim())) {
							datas.put("nncrbhtfggwssjbgls2","");
						}else {
							datas.put("nncrbhtfggwssjbgls2",nncrbhtfggwssjbgls);
						}
					 String nnwsjdxgxxbgls = data.get(i).getNnwsjdxgxxbgls().toString();		// 年内卫生监督协管信息报告例数（例）        
					 if("----"==nnwsjdxgxxbgls.trim()||"----".equals(nnwsjdxgxxbgls.trim())) {
							datas.put("nnwsjdxgxxbgls2","");
						}else {
							datas.put("nnwsjdxgxxbgls2",nnwsjdxgxxbgls);
						}
					 String nmldssetzyyjkglrs = data.get(i).getNmldssetzyyjkglrs().toString();		// 年末0-3岁儿童中医药健康管理人数（人） 
					 if("----"==nmldssetzyyjkglrs.trim()||"----".equals(nmldssetzyyjkglrs.trim())) {
							datas.put("nmldssetzyyjkglrs2","");
						}else {
							datas.put("nmldssetzyyjkglrs2",nmldssetzyyjkglrs);
						}
					 String nmlswyslrzyyjkglrs = data.get(i).getNmlswyslrzyyjkglrs();		// 年末65岁以上老人中医药健康管理人数（人

					 if("----"==nmlswyslrzyyjkglrs.trim()||"----".equals(nmlswyslrzyyjkglrs.trim())) {
							datas.put("nmlswyslrzyyjkglrs2","");
						}else {
							datas.put("nmlswyslrzyyjkglrs2",nmlswyslrzyyjkglrs);
						}
					
					
					
					
					
				}


					
				
			}
			
			
		}else {
			datas.put("id", "");
			datas.put("nmfwczrks", "");
			datas.put("qzldlsets", "");
			datas.put("qzldssets", "");
			datas.put("qzlswsysrks", "");
			datas.put("nmjmjkdaljjdrs", "");
			datas.put("qzgfhdzdars", "");
			datas.put("nnjsjkjyrcs", "");
			datas.put("nnldlsetyfjzrcs", "");
			datas.put("nmldlsetjkglrs", "");
			datas.put("nmycfjkglrs", "");
			datas.put("nmlswsyslrjkglr", "");
			datas.put("nmgxygfglrs", "");
			datas.put("nmtnbgfglrs", "");
			datas.put("nmzxjszahzglrs", "");
			datas.put("nmfjhhzglrs", "");
			datas.put("nncrbhtfggwssjbgls", "");
			datas.put("nnwsjdxgxxbgls", "");
			datas.put("nmldssetzyyjkglrs", "");
			datas.put("nmlswyslrzyyjkglrs", "");
			datas.put("date", "");
			datas.put("doc_id", "");
			
			datas.put("id1", "");
			datas.put("nmfwczrks1", "");
			datas.put("qzldlsets1", "");
			datas.put("qzldssets1", "");
			datas.put("qzlswsysrks1", "");
			datas.put("nmjmjkdaljjdrs1", "");
			datas.put("qzgfhdzdars1", "");
			datas.put("nnjsjkjyrcs1", "");
			datas.put("nnldlsetyfjzrcs1", "");
			datas.put("nmldlsetjkglrs1", "");
			datas.put("nmycfjkglrs1", "");
			datas.put("nmlswsyslrjkglr1", "");
			datas.put("nmgxygfglrs1", "");
			datas.put("nmtnbgfglrs1", "");
			datas.put("nmzxjszahzglrs1", "");
			datas.put("nmfjhhzglrs1", "");
			datas.put("nncrbhtfggwssjbgls1", "");
			datas.put("nnwsjdxgxxbgls1", "");
			datas.put("nmldssetzyyjkglrs1", "");
			datas.put("nmlswyslrzyyjkglrs1", "");
			datas.put("date1", "");
			
			datas.put("id2", "");
			datas.put("nmfwczrks2", "");
			datas.put("qzldlsets2", "");
			datas.put("qzldssets2", "");
			datas.put("qzlswsysrks2", "");
			datas.put("nmjmjkdaljjdrs2", "");
			datas.put("qzgfhdzdars2", "");
			datas.put("nnjsjkjyrcs2", "");
			datas.put("nnldlsetyfjzrcs2", "");
			datas.put("nmldlsetjkglrs2", "");
			datas.put("nmycfjkglrs2", "");
			datas.put("nmlswsyslrjkglr2", "");
			datas.put("nmgxygfglrs2", "");
			datas.put("nmtnbgfglrs2", "");
			datas.put("nmzxjszahzglrs2", "");
			datas.put("nmfjhhzglrs2", "");
			datas.put("nncrbhtfggwssjbgls2", "");
			datas.put("nnwsjdxgxxbgls2", "");
			datas.put("nmldssetzyyjkglrs2", "");
			datas.put("nmlswyslrzyyjkglrs2", "");
			datas.put("date2", "");
			
			
			
			
		}
		
		
		
		
		request.setAttribute("data", datas);
		model.addAttribute("data", datas);
//		Page<Ironfopublichealth> page = ironfopublichealthService.findPage(new Page<Ironfopublichealth>(request, response), ironfopublichealth); 
//		model.addAttribute("page", page);
		return "modules/ironfopublichealth/ironfopublichealthList";
	}

	/**
	 * 查看，增加，编辑2.3基本公共卫生服务表单页面
	 */
	@RequiresPermissions(value={"ironfopublichealth:ironfopublichealth:view","ironfopublichealth:ironfopublichealth:add","ironfopublichealth:ironfopublichealth:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfopublichealth ironfopublichealth, Model model) {
		model.addAttribute("ironfopublichealth", ironfopublichealth);
		return "modules/ironfopublichealth/ironfopublichealthForm";
	}

	/**
	 * 保存2.3基本公共卫生服务
	 */
	@RequiresPermissions(value={"ironfopublichealth:ironfopublichealth:add","ironfopublichealth:ironfopublichealth:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfopublichealth ironfopublichealth, Model model, RedirectAttributes redirectAttributes) throws Exception{
		boolean isnull=false;
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		
		
		
		Subject subject = SecurityUtils.getSubject();  
		Principal obj = (Principal) subject.getPrincipal();
		
		
		
		System.out.println(obj.getId());
		
		Map<String,Object> map = new  HashMap<String,Object>();
		String data = request.getParameter("datas");
		String[] ironfopublichealths = data.split(";");
		
		
		String docId = "";
		for(int i=0;i<ironfopublichealths.length;i++) {
			map.put(ironfopublichealths[i].toString().split(":")[0].toString(),ironfopublichealths[i].toString().split(":")[1].toString());
			if("docId" == ironfopublichealths[i].toString().trim().split(":")[0].toString().trim() || "docId".equals(ironfopublichealths[i].toString().trim().split(":")[0].toString().trim())) {
				docId = ironfopublichealths[i].toString().split(":")[1].toString();
			}
		}
		
		
		if(docId.toString().trim() == null || "".equals(docId.toString().trim())) {
			
			
 			isnull = false;
 			
 			IronfoDocTitle title =  IronfoDocTitle.class.newInstance();
 			title.setRemarks(obj.getId());
 			
 			List<IronfoDocTitle> docList = ironfoDoc_Title_Service.queryforList(title);
 			docId= docList.get(0).getId().toString();
 			
		}else {
			
			
			ironfopublichealth.setDoc_id(docId);
			List<Ironfopublichealth> ironfoList = ironfopublichealthService.queryForList(ironfopublichealth);
			if(ironfoList.size()>0) {
				isnull = true;
			}else {
				isnull = false;
				
			}
			
			
			
		}
		
		
		
		Ironfopublichealth ironfopublichealth_2015 = null;
		Ironfopublichealth ironfopublichealth_2016 = null;
		Ironfopublichealth ironfopublichealth_2017 = null;
		
		if(isnull == false) {
			ironfopublichealth_2015 = new Ironfopublichealth();
			ironfopublichealth_2015.setDate(map.get("date").toString());
			ironfopublichealth_2015.setNmlswyslrzyyjkglrs(map.get("nmlswyslrzyyjkglrs").toString());
			ironfopublichealth_2015.setNmldssetzyyjkglrs(map.get("nmldssetzyyjkglrs").toString());
			ironfopublichealth_2015.setNnwsjdxgxxbgls(map.get("nnwsjdxgxxbgls").toString());
			ironfopublichealth_2015.setNncrbhtfggwssjbgls(map.get("nncrbhtfggwssjbgls").toString());
			ironfopublichealth_2015.setNmfjhhzglrs(map.get("nmfjhhzglrs").toString());
			ironfopublichealth_2015.setNmzxjszahzglrs(map.get("nmzxjszahzglrs").toString());
			ironfopublichealth_2015.setNmtnbgfglrs(map.get("nmtnbgfglrs").toString());
			ironfopublichealth_2015.setNmgxygfglrs(map.get("nmgxygfglrs").toString());
			ironfopublichealth_2015.setNmlswsyslrjkglr(map.get("nmlswsyslrjkglr").toString());
			ironfopublichealth_2015.setNmycfjkglrs(map.get("nmycfjkglrs").toString());
			ironfopublichealth_2015.setNmldlsetjkglrs(map.get("nmldlsetjkglrs").toString());
			ironfopublichealth_2015.setNnldlsetyfjzrcs(map.get("nnldlsetyfjzrcs").toString());
			ironfopublichealth_2015.setNnjsjkjyrcs(map.get("nnjsjkjyrcs").toString());
			ironfopublichealth_2015.setQzgfhdzdars(map.get("qzgfhdzdars").toString());
			ironfopublichealth_2015.setNmjmjkdaljjdrs(map.get("nmjmjkdaljjdrs").toString());
			ironfopublichealth_2015.setQzlswsysrks(map.get("qzlswsysrks").toString());
			ironfopublichealth_2015.setQzldssets(map.get("qzldssets").toString());
			ironfopublichealth_2015.setQzldlsets(map.get("qzldlsets").toString());
			ironfopublichealth_2015.setNmfwczrks(map.get("nmfwczrks").toString());
			ironfopublichealth_2015.setDoc_id(docId);
			ironfopublichealthService.save(ironfopublichealth_2015);
			
			ironfopublichealth_2016 = new Ironfopublichealth();
			ironfopublichealth_2016.setDate(map.get("date1").toString());
			ironfopublichealth_2016.setNmlswyslrzyyjkglrs(map.get("nmlswyslrzyyjkglrs1").toString());
			ironfopublichealth_2016.setNmldssetzyyjkglrs(map.get("nmldssetzyyjkglrs1").toString());
			ironfopublichealth_2016.setNnwsjdxgxxbgls(map.get("nnwsjdxgxxbgls1").toString());
			ironfopublichealth_2016.setNncrbhtfggwssjbgls(map.get("nncrbhtfggwssjbgls1").toString());
			ironfopublichealth_2016.setNmfjhhzglrs(map.get("nmfjhhzglrs1").toString());
			ironfopublichealth_2016.setNmzxjszahzglrs(map.get("nmzxjszahzglrs1").toString());
			ironfopublichealth_2016.setNmtnbgfglrs(map.get("nmtnbgfglrs1").toString());
			ironfopublichealth_2016.setNmgxygfglrs(map.get("nmgxygfglrs").toString());
			ironfopublichealth_2016.setNmlswsyslrjkglr(map.get("nmlswsyslrjkglr1").toString());
			ironfopublichealth_2016.setNmycfjkglrs(map.get("nmycfjkglrs1").toString());
			ironfopublichealth_2016.setNmldlsetjkglrs(map.get("nmldlsetjkglrs1").toString());
			ironfopublichealth_2016.setNnldlsetyfjzrcs(map.get("nnldlsetyfjzrcs1").toString());
			ironfopublichealth_2016.setNnjsjkjyrcs(map.get("nnjsjkjyrcs1").toString());
			ironfopublichealth_2016.setQzgfhdzdars(map.get("qzgfhdzdars1").toString());
			ironfopublichealth_2016.setNmjmjkdaljjdrs(map.get("nmjmjkdaljjdrs1").toString());
			ironfopublichealth_2016.setQzlswsysrks(map.get("qzlswsysrks1").toString());
			ironfopublichealth_2016.setQzldssets(map.get("qzldssets1").toString());
			ironfopublichealth_2016.setQzldlsets(map.get("qzldlsets1").toString());
			ironfopublichealth_2016.setNmfwczrks(map.get("nmfwczrks1").toString());
			ironfopublichealth_2016.setDoc_id(docId);
			ironfopublichealthService.save(ironfopublichealth_2016);
			
			ironfopublichealth_2017 = new Ironfopublichealth();
			ironfopublichealth_2017.setDate(map.get("date2").toString());
			ironfopublichealth_2017.setNmlswyslrzyyjkglrs(map.get("nmlswyslrzyyjkglrs2").toString());
			ironfopublichealth_2017.setNmldssetzyyjkglrs(map.get("nmldssetzyyjkglrs2").toString());
			ironfopublichealth_2017.setNnwsjdxgxxbgls(map.get("nnwsjdxgxxbgls2").toString());
			ironfopublichealth_2017.setNncrbhtfggwssjbgls(map.get("nncrbhtfggwssjbgls2").toString());
			ironfopublichealth_2017.setNmfjhhzglrs(map.get("nmfjhhzglrs2").toString());
			ironfopublichealth_2017.setNmzxjszahzglrs(map.get("nmzxjszahzglrs2").toString());
			ironfopublichealth_2017.setNmtnbgfglrs(map.get("nmtnbgfglrs2").toString());
			ironfopublichealth_2017.setNmgxygfglrs(map.get("nmgxygfglrs2").toString());
			ironfopublichealth_2017.setNmlswsyslrjkglr(map.get("nmlswsyslrjkglr2").toString());
			ironfopublichealth_2017.setNmycfjkglrs(map.get("nmycfjkglrs2").toString());
			ironfopublichealth_2017.setNmldlsetjkglrs(map.get("nmldlsetjkglrs2").toString());
			ironfopublichealth_2017.setNnldlsetyfjzrcs(map.get("nnldlsetyfjzrcs2").toString());
			ironfopublichealth_2017.setNnjsjkjyrcs(map.get("nnjsjkjyrcs2").toString());
			ironfopublichealth_2017.setQzgfhdzdars(map.get("qzgfhdzdars2").toString());
			ironfopublichealth_2017.setNmjmjkdaljjdrs(map.get("nmjmjkdaljjdrs2").toString());
			ironfopublichealth_2017.setQzlswsysrks(map.get("qzlswsysrks2").toString());
			ironfopublichealth_2017.setQzldssets(map.get("qzldssets2").toString());
			ironfopublichealth_2017.setQzldlsets(map.get("qzldlsets2").toString());
			ironfopublichealth_2017.setNmfwczrks(map.get("nmfwczrks2").toString());
			ironfopublichealth_2017.setDoc_id(docId);
			ironfopublichealthService.save(ironfopublichealth_2017);
			
		}else if(isnull == true) {
			
			ironfopublichealth_2015 = new Ironfopublichealth();
			ironfopublichealth_2015.setDate(map.get("date").toString());
			ironfopublichealth_2015.setNmlswyslrzyyjkglrs(map.get("nmlswyslrzyyjkglrs").toString());
			ironfopublichealth_2015.setNmldssetzyyjkglrs(map.get("nmldssetzyyjkglrs").toString());
			ironfopublichealth_2015.setNnwsjdxgxxbgls(map.get("nnwsjdxgxxbgls").toString());
			ironfopublichealth_2015.setNncrbhtfggwssjbgls(map.get("nncrbhtfggwssjbgls").toString());
			ironfopublichealth_2015.setNmfjhhzglrs(map.get("nmfjhhzglrs").toString());
			ironfopublichealth_2015.setNmzxjszahzglrs(map.get("nmzxjszahzglrs").toString());
			ironfopublichealth_2015.setNmtnbgfglrs(map.get("nmtnbgfglrs").toString());
			ironfopublichealth_2015.setNmgxygfglrs(map.get("nmgxygfglrs").toString());
			ironfopublichealth_2015.setNmlswsyslrjkglr(map.get("nmlswsyslrjkglr").toString());
			ironfopublichealth_2015.setNmycfjkglrs(map.get("nmycfjkglrs").toString());
			ironfopublichealth_2015.setNmldlsetjkglrs(map.get("nmldlsetjkglrs").toString());
			ironfopublichealth_2015.setNnldlsetyfjzrcs(map.get("nnldlsetyfjzrcs").toString());
			ironfopublichealth_2015.setNnjsjkjyrcs(map.get("nnjsjkjyrcs").toString());
			ironfopublichealth_2015.setQzgfhdzdars(map.get("qzgfhdzdars").toString());
			ironfopublichealth_2015.setNmjmjkdaljjdrs(map.get("nmjmjkdaljjdrs").toString());
			ironfopublichealth_2015.setQzlswsysrks(map.get("qzlswsysrks").toString());
			ironfopublichealth_2015.setQzldssets(map.get("qzldssets").toString());
			ironfopublichealth_2015.setQzldlsets(map.get("qzldlsets").toString());
			ironfopublichealth_2015.setNmfwczrks(map.get("nmfwczrks").toString());
			ironfopublichealth_2015.setId(map.get("id").toString());
			ironfopublichealth_2015.setDoc_id(docId);
			ironfopublichealthService.updateIronfo(ironfopublichealth_2015);
			
			ironfopublichealth_2016 = new Ironfopublichealth();
			ironfopublichealth_2016.setDate(map.get("date1").toString());
			ironfopublichealth_2016.setNmlswyslrzyyjkglrs(map.get("nmlswyslrzyyjkglrs1").toString());
			ironfopublichealth_2016.setNmldssetzyyjkglrs(map.get("nmldssetzyyjkglrs1").toString());
			ironfopublichealth_2016.setNnwsjdxgxxbgls(map.get("nnwsjdxgxxbgls1").toString());
			ironfopublichealth_2016.setNncrbhtfggwssjbgls(map.get("nncrbhtfggwssjbgls1").toString());
			ironfopublichealth_2016.setNmfjhhzglrs(map.get("nmfjhhzglrs1").toString());
			ironfopublichealth_2016.setNmzxjszahzglrs(map.get("nmzxjszahzglrs1").toString());
			ironfopublichealth_2016.setNmtnbgfglrs(map.get("nmtnbgfglrs1").toString());
			ironfopublichealth_2016.setNmgxygfglrs(map.get("nmgxygfglrs").toString());
			ironfopublichealth_2016.setNmlswsyslrjkglr(map.get("nmlswsyslrjkglr1").toString());
			ironfopublichealth_2016.setNmycfjkglrs(map.get("nmycfjkglrs1").toString());
			ironfopublichealth_2016.setNmldlsetjkglrs(map.get("nmldlsetjkglrs1").toString());
			ironfopublichealth_2016.setNnldlsetyfjzrcs(map.get("nnldlsetyfjzrcs1").toString());
			ironfopublichealth_2016.setNnjsjkjyrcs(map.get("nnjsjkjyrcs1").toString());
			ironfopublichealth_2016.setQzgfhdzdars(map.get("qzgfhdzdars1").toString());
			ironfopublichealth_2016.setNmjmjkdaljjdrs(map.get("nmjmjkdaljjdrs1").toString());
			ironfopublichealth_2016.setQzlswsysrks(map.get("qzlswsysrks1").toString());
			ironfopublichealth_2016.setQzldssets(map.get("qzldssets1").toString());
			ironfopublichealth_2016.setQzldlsets(map.get("qzldlsets1").toString());
			ironfopublichealth_2016.setNmfwczrks(map.get("nmfwczrks1").toString());
			ironfopublichealth_2016.setId(map.get("id1").toString());
			ironfopublichealth_2016.setDoc_id(docId);
			ironfopublichealthService.updateIronfo(ironfopublichealth_2016);
			
			ironfopublichealth_2017 = new Ironfopublichealth();
			ironfopublichealth_2017.setDate(map.get("date2").toString());
			ironfopublichealth_2017.setNmlswyslrzyyjkglrs(map.get("nmlswyslrzyyjkglrs2").toString());
			ironfopublichealth_2017.setNmldssetzyyjkglrs(map.get("nmldssetzyyjkglrs2").toString());
			ironfopublichealth_2017.setNnwsjdxgxxbgls(map.get("nnwsjdxgxxbgls2").toString());
			ironfopublichealth_2017.setNncrbhtfggwssjbgls(map.get("nncrbhtfggwssjbgls2").toString());
			ironfopublichealth_2017.setNmfjhhzglrs(map.get("nmfjhhzglrs2").toString());
			ironfopublichealth_2017.setNmzxjszahzglrs(map.get("nmzxjszahzglrs2").toString());
			ironfopublichealth_2017.setNmtnbgfglrs(map.get("nmtnbgfglrs2").toString());
			ironfopublichealth_2017.setNmgxygfglrs(map.get("nmgxygfglrs2").toString());
			ironfopublichealth_2017.setNmlswsyslrjkglr(map.get("nmlswsyslrjkglr2").toString());
			ironfopublichealth_2017.setNmycfjkglrs(map.get("nmycfjkglrs2").toString());
			ironfopublichealth_2017.setNmldlsetjkglrs(map.get("nmldlsetjkglrs2").toString());
			ironfopublichealth_2017.setNnldlsetyfjzrcs(map.get("nnldlsetyfjzrcs2").toString());
			ironfopublichealth_2017.setNnjsjkjyrcs(map.get("nnjsjkjyrcs2").toString());
			ironfopublichealth_2017.setQzgfhdzdars(map.get("qzgfhdzdars2").toString());
			ironfopublichealth_2017.setNmjmjkdaljjdrs(map.get("nmjmjkdaljjdrs2").toString());
			ironfopublichealth_2017.setQzlswsysrks(map.get("qzlswsysrks2").toString());
			ironfopublichealth_2017.setQzldssets(map.get("qzldssets2").toString());
			ironfopublichealth_2017.setQzldlsets(map.get("qzldlsets2").toString());
			ironfopublichealth_2017.setNmfwczrks(map.get("nmfwczrks2").toString());
			ironfopublichealth_2017.setId(map.get("id2").toString());
			ironfopublichealth_2017.setDoc_id(docId);
			ironfopublichealthService.updateIronfo(ironfopublichealth_2017);
			
			
		}
		
		
		//		if (!beanValidator(model, ironfopublichealth)){
//			return form(ironfopublichealth, model);
//		}
//		if(!ironfopublichealth.getIsNewRecord()){//编辑表单保存
//			Ironfopublichealth t = ironfopublichealthService.get(ironfopublichealth.getId());//从数据库取出记录的值
//			MyBeanUtils.copyBeanNotNull2Bean(ironfopublichealth, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
//			ironfopublichealthService.save(t);//保存
//		}else{//新增表单保存
//			ironfopublichealthService.save(ironfopublichealth);//保存
//		}
//		addMessage(redirectAttributes, "保存2.3基本公共卫生服务成功");
		addMessage(redirectAttributes, "保存2.2财务收支成功");
		return "redirect:"+Global.getAdminPath()+"/ironfopublichealth/ironfopublichealth/?repage";
	}
	
	/**
	 * 删除2.3基本公共卫生服务
	 */
	@RequiresPermissions("ironfopublichealth:ironfopublichealth:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfopublichealth ironfopublichealth, RedirectAttributes redirectAttributes) {
		ironfopublichealthService.delete(ironfopublichealth);
		addMessage(redirectAttributes, "删除2.3基本公共卫生服务成功");
		return "redirect:"+Global.getAdminPath()+"/ironfopublichealth/ironfopublichealth/?repage";
	}
	
	/**
	 * 批量删除2.3基本公共卫生服务
	 */
	@RequiresPermissions("ironfopublichealth:ironfopublichealth:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfopublichealthService.delete(ironfopublichealthService.get(id));
		}
		addMessage(redirectAttributes, "删除2.3基本公共卫生服务成功");
		return "redirect:"+Global.getAdminPath()+"/ironfopublichealth/ironfopublichealth/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfopublichealth:ironfopublichealth:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfopublichealth ironfopublichealth, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "2.3基本公共卫生服务"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfopublichealth> page = ironfopublichealthService.findPage(new Page<Ironfopublichealth>(request, response, -1), ironfopublichealth);
    		new ExportExcel("2.3基本公共卫生服务", Ironfopublichealth.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出2.3基本公共卫生服务记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfopublichealth/ironfopublichealth/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfopublichealth:ironfopublichealth:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfopublichealth> list = ei.getDataList(Ironfopublichealth.class);
			for (Ironfopublichealth ironfopublichealth : list){
				try{
					ironfopublichealthService.save(ironfopublichealth);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条2.3基本公共卫生服务记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条2.3基本公共卫生服务记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入2.3基本公共卫生服务失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfopublichealth/ironfopublichealth/?repage";
    }
	
	/**
	 * 下载导入2.3基本公共卫生服务数据模板
	 */
	@RequiresPermissions("ironfopublichealth:ironfopublichealth:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "2.3基本公共卫生服务数据导入模板.xlsx";
    		List<Ironfopublichealth> list = Lists.newArrayList(); 
    		new ExportExcel("2.3基本公共卫生服务数据", Ironfopublichealth.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfopublichealth/ironfopublichealth/?repage";
    }
	
	
	

}