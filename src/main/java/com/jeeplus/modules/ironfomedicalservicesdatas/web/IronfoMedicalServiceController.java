/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfomedicalservicesdatas.web;

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
import com.jeeplus.modules.ironfomedicalservices.entity.IronfoMedicalServices;
import com.jeeplus.modules.ironfomedicalservices.service.IronfoMedicalServicesService;
import com.jeeplus.modules.ironfomedicalservicesdatas.entity.IronfoMedicalService;
import com.jeeplus.modules.ironfomedicalservicesdatas.service.IronfoMedicalServiceService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 2.1年度医疗服务量Controller
 * @author mikesun
 * @version 2018-04-11
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfomedicalservicesdatas/ironfoMedicalServices")
public class IronfoMedicalServiceController extends BaseController {

	@Autowired
	private IronfoMedicalServiceService ironfoMedicalServiceService;
	
	
	/*@Autowired
	private IronfoMedicalServicesService ironfoMedicalServicesService;*/
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	
	
	@ModelAttribute
	public IronfoMedicalService get(@RequestParam(required=false) String id) {
		IronfoMedicalService entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfoMedicalServiceService.get(id);
		}
		if (entity == null){
			entity = new IronfoMedicalService();
		}
		return entity;
	}
	
	/**
	 * 2.1年度医疗服务量列表页面
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	@RequiresPermissions("ironfomedicalservicesdatas:ironfoMedicalServices:list")
	@RequestMapping(value = {"list", ""})
	public String list(IronfoMedicalService ironfoMedicalServices, HttpServletRequest request,
			HttpServletResponse response, Model model) throws InstantiationException, IllegalAccessException {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfoMedicalServices.getDuser() != null&&ironfoMedicalServices.getDuser().toString() != null && ironfoMedicalServices.getDuser().toString().trim() != null
					&& !"".equals(ironfoMedicalServices.getDuser().toString().trim())
					&& !"null".equals(ironfoMedicalServices.getDuser().toString().trim())) {
				userId = ironfoMedicalServices.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
				
			}
			System.out.println("userId:-----------" + userId);
			title = ironfoDoc_Title_Service.getDocId(userId);
			ironfoMedicalServices.setDoc_id(title.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}

		Page<IronfoMedicalService> page = ironfoMedicalServiceService
				.findPage(new Page<IronfoMedicalService>(request, response), ironfoMedicalServices);
		model.addAttribute("page", page);
	
		
		
		//			String userId = (String)request.getParameter("userId");
//			System.out.println("------------->"+userId);
//			if(userId != null){
//				IronfoDocTitle title =  IronfoDocTitle.class.newInstance();
//				title.setRemarks(userId);
//				
//				System.out.println("111111asasdadasd11111");
//				Page<IronfoMedicalService> page = ironfoMedicalServiceService.findPage(new Page<IronfoMedicalService>(request, response), ironfoMedicalServices); 
//				model.addAttribute("page", page);
//			}
			
			//return "modules/ironfomedicalservicesdatas/ironfoMedicalServicesList";
//
//
//		Subject subject = SecurityUtils.getSubject();  
//		Principal obj = (Principal) subject.getPrincipal();
//		System.out.println(obj.getId());
//		
//		
//		
//		Map<String,Object> datas = new TreeMap<String,Object>();
//		IronfoDocTitle title =  IronfoDocTitle.class.newInstance();
//		title.setRemarks(obj.getId());
////		title =  ironfoDoc_Title_Service.getDocId(obj.getId());
//		List<IronfoDocTitle> docList = ironfoDoc_Title_Service.queryforList(title);
//		
//		
//		
//		if(docList.size()>0) {
//			ironfoMedicalServices.setDoc_id(docList.get(0).getId().toString());	
//			
//			List<IronfoMedicalServices> data = ironfoMedicalServicesService.queryForList(ironfoMedicalServices);
//			
//			for(int i=0;i<data.size();i++) {
////				datas.put("doc_id", data.get(i).getDoc_id());
//				if(data.get(i).getDate().toString()=="2015"||"2015".equals(data.get(i).getDate().toString())) {
//					datas.put("date", data.get(i).getDate().toString());
//					
//					
//					datas.put("id", data.get(i).getId().toString());
//					
//					String bzcw = data.get(i).getBzcw().toString().trim();
//					
//					if("----"==bzcw||"----".equals(bzcw)) {
//						datas.put("bzcw","");
//					}else {
//						datas.put("bzcw",bzcw);
//					}
//					String sycw = data.get(i).getSycw().toString().trim();
//					if("----"==sycw||"----".equals(sycw)) {
//						datas.put("sycw","");
//					}else {
//						datas.put("sycw",sycw);
//					}
//					String sjkfzcrs = data.get(i).getSjkfzcrs().toString().trim();
//					if("----"==sjkfzcrs||"----".equals(sjkfzcrs)) {
//						datas.put("sjkfzcrs","");
//					}else {
//						datas.put("sjkfzcrs",sjkfzcrs);
//					}
//					String sjzyzcrs = data.get(i).getSjzyzcrs().toString().trim();
//					if("----"==sjzyzcrs||"----".equals(sjzyzcrs)) {
//						datas.put("sjzyzcrs","");
//					}else {
//						datas.put("sjzyzcrs",sjzyzcrs);
//					}
//					String gccs =  data.get(i).getGccs().toString().trim();
//					
//					if("----"==gccs||"----".equals(gccs)) {
//						datas.put("gccs","");
//					}else {
//						datas.put("gccs",gccs);
//					}
//					String zzlrcs = data.get(i).getZzlrcs().toString().trim();
//					if("----"==zzlrcs||"----".equals(zzlrcs)) {
//						datas.put("zzlrcs","");
//					}else {
//						datas.put("zzlrcs",zzlrcs);
//					}
//					
//					String mzrcs = data.get(i).getMzrcs().toString().trim();
//					if("----"==mzrcs||"----".equals(mzrcs)) {
//						datas.put("mzrcs","");
//					}else {
//						datas.put("mzrcs",mzrcs);
//					}
//					String jzrcs = data.get(i).getJzrcs().toString().trim();
//					if("----"==jzrcs||"----".equals(jzrcs)) {
//						datas.put("jzrcs","");
//					}else {
//						datas.put("jzrcs",jzrcs);
//					}
//					String qzswrs = data.get(i).getQzswrs().toString().trim();
//					if("----"==qzswrs||"----".equals(qzswrs)) {
//						datas.put("qzswrs","");
//					}else {
//						datas.put("qzswrs",qzswrs);
//					}
//					String cyrs = data.get(i).getCyrs().toString().trim();
//					if("----"==cyrs||"----".equals(cyrs)) {
//						datas.put("cyrs","");
//					}else {
//						datas.put("cyrs",cyrs);
//					}
//					String sjyyxxzzrcs = data.get(i).getSjyyxxzzrcs().toString().trim();
//					if("----"==sjyyxxzzrcs||"----".equals(sjyyxxzzrcs)) {
//						datas.put("sjyyxxzzrcs","");
//					}else {
//						datas.put("sjyyxxzzrcs",sjyyxxzzrcs);
//					}
//					String xsjyyzzrcs = data.get(i).getXsjyyzzrcs().toString().trim();
//					if("----"==xsjyyzzrcs||"----".equals(sjyyxxzzrcs)) {
//						datas.put("xsjyyzzrcs","");
//					}else {
//						datas.put("xsjyyzzrcs",xsjyyzzrcs);
//					}
//						
//				}else if(data.get(i).getDate().toString()=="2016"||"2016".equals(data.get(i).getDate().toString())) {
//					datas.put("date1", data.get(i).getDate().toString());
//					datas.put("id1",data.get(i).getId().toString());
//					String bzcw1 = data.get(i).getBzcw().toString().trim();
//					if("----"==bzcw1||"----".equals(bzcw1)) {
//						datas.put("bzcw1","");
//					}else {
//						datas.put("bzcw1",bzcw1);
//					}
////					datas.put("bzcw1", data.get(i).getBzcw().toString());
//					
//					
//					
//					String sycw = data.get(i).getSycw().toString().trim();
//					if("----"==sycw||"----".equals(sycw)) {
//						datas.put("sycw1","");
//					}else {
//						datas.put("sycw1",sycw);
//					}
//					String sjkfzcrs = data.get(i).getSjkfzcrs().toString().trim();
//					if("----"==sjkfzcrs||"----".equals(sjkfzcrs)) {
//						datas.put("sjkfzcrs1","");
//					}else {
//						datas.put("sjkfzcrs1",sjkfzcrs);
//					}
//					String sjzyzcrs = data.get(i).getSjzyzcrs().toString().trim();
//					if("----"==sjzyzcrs||"----".equals(sjzyzcrs)) {
//						datas.put("sjzyzcrs1","");
//					}else {
//						datas.put("sjzyzcrs1",sjzyzcrs);
//					}
//					String gccs =  data.get(i).getGccs().toString().trim();
//					
//					if("----"==gccs||"----".equals(gccs)) {
//						datas.put("gccs1","");
//					}else {
//						datas.put("gccs1",gccs);
//					}
//					String zzlrcs = data.get(i).getZzlrcs().toString().trim();
//					if("----"==zzlrcs||"----".equals(zzlrcs)) {
//						datas.put("zzlrcs1","");
//					}else {
//						datas.put("zzlrcs1",zzlrcs);
//					}
//					
//					String mzrcs = data.get(i).getMzrcs().toString().trim();
//					if("----"==mzrcs||"----".equals(mzrcs)) {
//						datas.put("mzrcs1","");
//					}else {
//						datas.put("mzrcs1",mzrcs);
//					}
//					String jzrcs = data.get(i).getJzrcs().toString().trim();
//					if("----"==jzrcs||"----".equals(jzrcs)) {
//						datas.put("jzrcs1","");
//					}else {
//						datas.put("jzrcs1",jzrcs);
//					}
//					String qzswrs = data.get(i).getQzswrs().toString().trim();
//					if("----"==qzswrs||"----".equals(qzswrs)) {
//						datas.put("qzswrs1","");
//					}else {
//						datas.put("qzswrs1",qzswrs);
//					}
//					String cyrs = data.get(i).getCyrs().toString().trim();
//					if("----"==cyrs||"----".equals(cyrs)) {
//						datas.put("cyrs1","");
//					}else {
//						datas.put("cyrs1",cyrs);
//					}
//					String sjyyxxzzrcs = data.get(i).getSjyyxxzzrcs().toString().trim();
//					if("----"==sjyyxxzzrcs||"----".equals(sjyyxxzzrcs)) {
//						datas.put("sjyyxxzzrcs1","");
//					}else {
//						datas.put("sjyyxxzzrcs1",sjyyxxzzrcs);
//					}
//					String xsjyyzzrcs = data.get(i).getXsjyyzzrcs().toString().trim();
//					if("----"==xsjyyzzrcs||"----".equals(sjyyxxzzrcs)) {
//						datas.put("xsjyyzzrcs1","");
//					}else {
//						datas.put("xsjyyzzrcs1",xsjyyzzrcs);
//					}
//					
//					
////					datas.put("sycw1", data.get(i).getSycw().toString());
////					datas.put("sjkfzcrs1", data.get(i).getSjkfzcrs().toString());
////					datas.put("sjzyzcrs1", data.get(i).getSjzyzcrs().toString());
////					datas.put("gccs1", data.get(i).getGccs().toString());
////					datas.put("zzlrcs1", data.get(i).getZzlrcs().toString());
////					datas.put("mzrcs1", data.get(i).getMzrcs().toString());
////					datas.put("jzrcs1", data.get(i).getJzrcs().toString());
////					datas.put("qzswrs1", data.get(i).getQzswrs().toString());
////					datas.put("cyrs1", data.get(i).getCyrs().toString());
////					datas.put("sjyyxxzzrcs1", data.get(i).getSjyyxxzzrcs().toString());
////					datas.put("xsjyyzzrcs1", data.get(i).getXsjyyzzrcs().toString());
//				} else if(data.get(i).getDate().toString()=="2017"||"2017".equals(data.get(i).getDate().toString())) {
//					datas.put("date2", data.get(i).getDate().toString());
//					datas.put("id2",data.get(i).getId().toString());
//					String bzcw2 = data.get(i).getBzcw().toString().trim();
//					if("----"==bzcw2||"----".equals(bzcw2)) {
//						datas.put("bzcw2","");
//					}else {
//						datas.put("bzcw2",bzcw2);
//					}
//					
//					String sycw = data.get(i).getSycw().toString().trim();
//					if("----"==sycw||"----".equals(sycw)) {
//						datas.put("sycw2","");
//					}else {
//						datas.put("sycw2",sycw);
//					}
//					String sjkfzcrs = data.get(i).getSjkfzcrs().toString().trim();
//					if("----"==sjkfzcrs||"----".equals(sjkfzcrs)) {
//						datas.put("sjkfzcrs2","");
//					}else {
//						datas.put("sjkfzcrs2",sjkfzcrs);
//					}
//					String sjzyzcrs = data.get(i).getSjzyzcrs().toString().trim();
//					if("----"==sjzyzcrs||"----".equals(sjzyzcrs)) {
//						datas.put("sjzyzcrs2","");
//					}else {
//						datas.put("sjzyzcrs2",sjzyzcrs);
//					}
//					String gccs =  data.get(i).getGccs().toString().trim();
//					
//					if("----"==gccs||"----".equals(gccs)) {
//						datas.put("gccs2","");
//					}else {
//						datas.put("gccs2",gccs);
//					}
//					String zzlrcs = data.get(i).getZzlrcs().toString().trim();
//					if("----"==zzlrcs||"----".equals(zzlrcs)) {
//						datas.put("zzlrcs2","");
//					}else {
//						datas.put("zzlrcs2",zzlrcs);
//					}
//					
//					String mzrcs = data.get(i).getMzrcs().toString().trim();
//					if("----"==mzrcs||"----".equals(mzrcs)) {
//						datas.put("mzrcs2","");
//					}else {
//						datas.put("mzrcs2",mzrcs);
//					}
//					String jzrcs = data.get(i).getJzrcs().toString().trim();
//					if("----"==jzrcs||"----".equals(jzrcs)) {
//						datas.put("jzrcs2","");
//					}else {
//						datas.put("jzrcs2",jzrcs);
//					}
//					String qzswrs = data.get(i).getQzswrs().toString().trim();
//					if("----"==qzswrs||"----".equals(qzswrs)) {
//						datas.put("qzswrs2","");
//					}else {
//						datas.put("qzswrs2",qzswrs);
//					}
//					String cyrs = data.get(i).getCyrs().toString().trim();
//					if("----"==cyrs||"----".equals(cyrs)) {
//						datas.put("cyrs2","");
//					}else {
//						datas.put("cyrs2",cyrs);
//					}
//					String sjyyxxzzrcs = data.get(i).getSjyyxxzzrcs().toString().trim();
//					if("----"==sjyyxxzzrcs||"----".equals(sjyyxxzzrcs)) {
//						datas.put("sjyyxxzzrcs2","");
//					}else {
//						datas.put("sjyyxxzzrcs2",sjyyxxzzrcs);
//					}
//					String xsjyyzzrcs = data.get(i).getXsjyyzzrcs().toString().trim();
//					if("----"==xsjyyzzrcs||"----".equals(sjyyxxzzrcs)) {
//						datas.put("xsjyyzzrcs2","");
//					}else {
//						datas.put("xsjyyzzrcs2",xsjyyzzrcs);
//					}
//					
//				}
//				
//			}
//			
//			datas.put("doc_id", docList.get(0).getId().toString());
//		}else {
//			
//			datas.put("xsjyyzzrcs2", "");
//			datas.put("xsjyyzzrcs1", "");
//			datas.put("xsjyyzzrcs", "");
//			datas.put("sjyyxxzzrcs2", "");
//			datas.put("sjyyxxzzrcs1", "");
//			datas.put("sjyyxxzzrcs", "");
//			datas.put("date2", "2017");
//			datas.put("date1", "2016");
//			datas.put("date", "2015");
//			datas.put("cyrs2", "");
//			datas.put("cyrs1", "");
//			datas.put("cyrs", "");
//			datas.put("qzswrs2", "");
//			datas.put("qzswrs1", "");
//			datas.put("qzswrs", "");
//			datas.put("jzrcs2", "");
//			datas.put("jzrcs1", "");
//			datas.put("jzrcs", "");
//			datas.put("mzrcs2", "");
//			datas.put("mzrcs1", "");
//			datas.put("mzrcs", "");
//			datas.put("gccs2", "");
//			datas.put("gccs1", "");
//			datas.put("gccs", "");
//			datas.put("sjzyzcrs2", "");
//			datas.put("sjzyzcrs1", "");
//			datas.put("sjzyzcrs", "");
//			datas.put("sjkfzcrs2", "");
//			datas.put("sjkfzcrs1", "");
//			datas.put("sjkfzcrs", "");
//			
//			datas.put("sycw2", "");
//			datas.put("sycw1", "");
//			datas.put("sycw", "");
//			datas.put("bzcw2", "");
//			datas.put("bzcw1", "");
//			datas.put("bzcw", "");
//			datas.put("id2", "");
//			datas.put("id1", "");
//			datas.put("id", "");
//			datas.put("doc_id","");
//		}
//		
//		
//		
//		
		
//Page<IronfoMedicalService> page = ironfoMedicalServicesService.findPage(new Page<IronfoMedicalService>(request, response), ironfoMedicalServices); 
//		model.addAttribute("page", page);
		return "modules/ironfomedicalservicesdatas/ironfoMedicalServicesList";
	}

	/**
	 * 查看，增加，编辑2.1年度医疗服务量表单页面
	 */
	@RequiresPermissions(value={"ironfomedicalservicesdatas:ironfoMedicalServices:view","ironfomedicalservicesdatas:ironfoMedicalServices:add","ironfomedicalservicesdatas:ironfoMedicalServices:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfoMedicalService ironfoMedicalServices, Model model) {
		model.addAttribute("ironfoMedicalServices", ironfoMedicalServices);
		return "modules/ironfomedicalservicesdatas/ironfoMedicalServicesForm";
	}

	/**
	 * 保存2.1年度医疗服务量
	 */
	@RequiresPermissions(value={"ironfomedicalservicesdatas:ironfoMedicalServices:add","ironfomedicalservicesdatas:ironfoMedicalServices:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfoMedicalService ironfoMedicalServices, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, ironfoMedicalServices)){
			return form(ironfoMedicalServices, model);
		}
		if(!ironfoMedicalServices.getIsNewRecord()){//编辑表单保存
			IronfoMedicalService t = ironfoMedicalServiceService.get(ironfoMedicalServices.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfoMedicalServices, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfoMedicalServiceService.save(t);//保存
		}else{//新增表单保存
			ironfoMedicalServiceService.save(ironfoMedicalServices);//保存
		}
		addMessage(redirectAttributes, "保存2.1年度医疗服务量成功");
		return "redirect:"+Global.getAdminPath()+"/ironfomedicalservicesdatas/ironfoMedicalServices/?repage";
	}
	
	/**
	 * 删除2.1年度医疗服务量
	 */
	@RequiresPermissions("ironfomedicalservicesdatas:ironfoMedicalServices:del")
	@RequestMapping(value = "delete")
	public String delete(IronfoMedicalService ironfoMedicalServices, RedirectAttributes redirectAttributes) {
		ironfoMedicalServiceService.delete(ironfoMedicalServices);
		addMessage(redirectAttributes, "删除2.1年度医疗服务量成功");
		return "redirect:"+Global.getAdminPath()+"/ironfomedicalservicesdatas/ironfoMedicalServices/?repage";
	}
	
	/**
	 * 批量删除2.1年度医疗服务量
	 */
	@RequiresPermissions("ironfomedicalservicesdatas:ironfoMedicalServices:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfoMedicalServiceService.delete(ironfoMedicalServiceService.get(id));
		}
		addMessage(redirectAttributes, "删除2.1年度医疗服务量成功");
		return "redirect:"+Global.getAdminPath()+"/ironfomedicalservicesdatas/ironfoMedicalServices/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfomedicalservicesdatas:ironfoMedicalServices:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(IronfoMedicalService ironfoMedicalServices, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfoMedicalServices.getDuser() != null && ironfoMedicalServices.getDuser().toString() != null
					&& ironfoMedicalServices.getDuser().toString().trim() != null
					&& !"".equals(ironfoMedicalServices.getDuser().toString().trim())
					&& !"null".equals(ironfoMedicalServices.getDuser().toString().trim())) {
				userId = ironfoMedicalServices.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			ironfoMedicalServices.setDoc_id(title.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            String fileName = "2.1年度医疗服务量"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<IronfoMedicalService> page = ironfoMedicalServiceService.findPage(new Page<IronfoMedicalService>(request, response, -1), ironfoMedicalServices);
    		new ExportExcel("2.1年度医疗服务量", IronfoMedicalService.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出2.1年度医疗服务量记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfomedicalservicesdatas/ironfoMedicalServices/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfomedicalservicesdatas:ironfoMedicalServices:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfoMedicalService> list = ei.getDataList(IronfoMedicalService.class);
			for (IronfoMedicalService ironfoMedicalServices : list){
				try{
					ironfoMedicalServiceService.save(ironfoMedicalServices);
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
		return "redirect:"+Global.getAdminPath()+"/ironfomedicalservicesdatas/ironfoMedicalServices/?repage";
    }
	
	/**
	 * 下载导入2.1年度医疗服务量数据模板
	 */
	@RequiresPermissions("ironfomedicalservicesdatas:ironfoMedicalServices:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "2.1年度医疗服务量数据导入模板.xlsx";
    		List<IronfoMedicalService> list = Lists.newArrayList(); 
    		new ExportExcel("2.1年度医疗服务量数据", IronfoMedicalService.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfomedicalservicesdatas/ironfoMedicalServices/?repage";
    }
	
	
	

}