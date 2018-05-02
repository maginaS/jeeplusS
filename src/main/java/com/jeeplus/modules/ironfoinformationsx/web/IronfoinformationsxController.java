/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoinformationsx.web;

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
import com.jeeplus.modules.ironfo_department.entity.Ironfodepartmentggwsb;
import com.jeeplus.modules.ironfo_department.entity.Ironfodepartmentjhsyb;
import com.jeeplus.modules.ironfo_department.entity.Ironfodepartmentremark;
import com.jeeplus.modules.ironfo_department.entity.Ironfodepartmentyjb;
import com.jeeplus.modules.ironfo_department.entity.Ironfodepartmentznglb;
import com.jeeplus.modules.ironfo_department.entity.Ironfodepartmentzyb;
import com.jeeplus.modules.ironfo_department.web.IronfodepartmentController;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.ironfodoctitle.service.IronfoDocTitleService;
import com.jeeplus.modules.ironfoinformationsx.entity.Ironfoinformationsx;
import com.jeeplus.modules.ironfoinformationsx.entity.Ironfoinformationsxjbggwsfw;
import com.jeeplus.modules.ironfoinformationsx.entity.Ironfoinformationsxjbylfw;
import com.jeeplus.modules.ironfoinformationsx.entity.Ironfoinformationsxjgjk;
import com.jeeplus.modules.ironfoinformationsx.entity.Ironfoinformationsxjgyygl;
import com.jeeplus.modules.ironfoinformationsx.entity.Ironfoinformationsxjkdagl;
import com.jeeplus.modules.ironfoinformationsx.entity.Ironfoinformationsxjkxxfw;
import com.jeeplus.modules.ironfoinformationsx.service.IronfoinformationsxService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 4.2信息化系统功能实现Controller
 * @author mikesun
 * @version 2018-04-08
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfoinformationsx/ironfoinformationsx")
public class IronfoinformationsxController extends BaseController {
	
	

	
	public static String JGJK="1";
	public static String JBYLFW="2";
	public static String JKXXFW="3";
	public static String JBGGWSFW="4";
	public static String JGYYGL="5";
	public static String JKDAGL="6";
	
	

	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	

	@Autowired
	private IronfoinformationsxService ironfoinformationsxService;
	
	@ModelAttribute
	public Ironfoinformationsx get(@RequestParam(required=false) String id) {
		Ironfoinformationsx entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfoinformationsxService.get(id);
		}
		if (entity == null){
			entity = new Ironfoinformationsx();
		}
		return entity;
	}
	
	/**
	 * 4.2信息化系统功能实现列表页面
	 */
	@RequiresPermissions("ironfoinformationsx:ironfoinformationsx:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfoinformationsx ironfoinformationsx, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Ironfoinformationsx> page = ironfoinformationsxService.findPage(new Page<Ironfoinformationsx>(request, response), ironfoinformationsx); 
		model.addAttribute("page", page);
		return "modules/ironfoinformationsx/ironfoinformationsxList";
	}

	/**
	 * 查看，增加，编辑4.2信息化系统功能实现表单页面
	 */
	@RequiresPermissions(value={"ironfoinformationsx:ironfoinformationsx:view","ironfoinformationsx:ironfoinformationsx:add","ironfoinformationsx:ironfoinformationsx:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfoinformationsx ironfoinformationsx, Model model) {

		boolean isnull=false;
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		String type = request.getParameter("remark");
		
		
		
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
			
			Ironfoinformationsxjbylfw jbylfw=null;
			Ironfoinformationsxjbggwsfw jbggwsfw = null;
			Ironfoinformationsxjgjk jgjk = null;
			Ironfoinformationsxjgyygl jgyygl = null;
			Ironfoinformationsxjkdagl jkdagl = null;
			Ironfoinformationsxjkxxfw jkxxfw = null;
			
			try {
				if(type.trim()==IronfoinformationsxController.JGJK||type.trim().equals(IronfoinformationsxController.JGJK)) {
					jgjk = Ironfoinformationsxjgjk.class.newInstance();
					jgjk.setDoc_id(docList.get(0).getId().toString());
					List<Ironfoinformationsxjgjk> list_data = ironfoinformationsxService.queryForjgjk(jgjk);
					if(list_data.size()>0) {
						for(Ironfoinformationsxjgjk j :list_data) {
							datas = new TreeMap<String,Object>();
							datas.put("doc_id", docList.get(0).getId().toString());
							datas.put("se_id", j.getSe_id());
							datas.put("jbggwsfwjgjk", j.getJbggwsfwjgjk());
							datas.put("jbylfwjgjk", j.getJbylfwjgjk());
							datas.put("jbywjgjk", j.getJbywjgjk());
							datas.put("xnhbcjgjk", j.getXnhbcjgjk());
							datas.put("id", j.getId());
						}
					}else {
						datas = new TreeMap<String,Object>();
						
						datas.put("doc_id", "");
						datas.put("se_id", "");
						datas.put("jbggwsfwjgjk", "0");
						datas.put("jbylfwjgjk", "0");
						datas.put("jbywjgjk","0");
						datas.put("xnhbcjgjk", "0");
						datas.put("id", "");
						
					}
					
					
				}else if(type.trim() == IronfoinformationsxController.JBYLFW||type.trim().equals(IronfoinformationsxController.JBYLFW)) {
					jbylfw = Ironfoinformationsxjbylfw.class.newInstance();
					jbylfw.setDoc_id(docList.get(0).getId().toString());
					List<Ironfoinformationsxjbylfw> list_data = ironfoinformationsxService.queryForjbylfw(jbylfw);
					if(list_data.size()>0) {
						for(Ironfoinformationsxjbylfw j :list_data) {
							datas = new TreeMap<String,Object>();
							datas.put("doc_id", docList.get(0).getId().toString());
							datas.put("se_id", j.getSe_id());
							datas.put("qkzlfw", j.getQkzlfw());
							datas.put("zyglfw", j.getZyglfw());
							datas.put("jtbcyhlfw", j.getJtbcyhlfw());
							datas.put("jktyfw", j.getJktyfw());
							datas.put("jyhjcfw", j.getJyhjcfw());
							datas.put("ycsxzzfw", j.getYcsxzzfw());
							datas.put("ychzfw", j.getYchzfw());
							datas.put("ycyyfw", j.getYcyyfw());
							datas.put("ycyxzdfw", j.getYcyxzdfw());
							datas.put("ycxdzdfw", j.getYcxdzdfw());
							datas.put("ycyxjyfw", j.getYcyxjyfw());
							datas.put("yczzjhfw", j.getYczzjhfw());
							datas.put("ycsssjfw", j.getYcsssjfw());
							datas.put("ssmzglfw", j.getSsmzglfw());
							datas.put("zyjhfw", j.getZyjhfw());
							datas.put("id", j.getId());
							
						}
						
					}else {
						datas = new TreeMap<String,Object>();
						datas.put("doc_id", "");
						datas.put("se_id", "");
						datas.put("qkzlfw", "0");
						datas.put("zyglfw", "0");
						datas.put("jtbcyhlfw", "0");
						datas.put("jktyfw", "0");
						datas.put("jyhjcfw", "0");
						datas.put("ycsxzzfw", "0");
						datas.put("ychzfw", "0");
						datas.put("ycyyfw", "0");
						datas.put("ycyxzdfw", "0");
						datas.put("ycxdzdfw", "0");
						datas.put("ycyxjyfw", "0");
						datas.put("yczzjhfw", "0");
						datas.put("ycsssjfw", "0");
						datas.put("ssmzglfw", "0");
						datas.put("zyjhfw", "0");
						datas.put("id", "");
						
					}
					
					
				}else if(type.trim()==IronfoinformationsxController.JKXXFW||type.trim().equals(IronfoinformationsxController.JKXXFW)) {
					jkxxfw = Ironfoinformationsxjkxxfw.class.newInstance();
					jkxxfw.setDoc_id(docList.get(0).getId().toString());
					List<Ironfoinformationsxjkxxfw> list_data = ironfoinformationsxService.queryForGgwsb(jkxxfw);
					if(list_data.size()>0) {
						for(Ironfoinformationsxjkxxfw j :list_data) {
							datas = new TreeMap<String,Object>();
							datas.put("doc_id",  docList.get(0).getId().toString());
							datas.put("se_id", j.getSe_id());
							datas.put("jkdacxfw", j.getJkdacxfw());
							datas.put("jkxxfbglfw", j.getJkxxfbglfw());
							datas.put("wsyyhtxfw", j.getWsyyhtxfw());
							datas.put("jkjyxxfw", j.getJkjyxxfw());
							datas.put("id", j.getId());
							
							
						}
						
					}else {
						datas = new TreeMap<String,Object>();
						datas.put("doc_id",  "");
						datas.put("se_id", "");
						datas.put("jkdacxfw", "0");
						datas.put("jkxxfbglfw", "0");
						datas.put("wsyyhtxfw", "0");
						datas.put("jkjyxxfw", "0");
						datas.put("id", "");
						
						
					}
					
				}else if(type.trim()==IronfoinformationsxController.JBGGWSFW||type.trim().equals(IronfoinformationsxController.JBGGWSFW)) {
					jbggwsfw = Ironfoinformationsxjbggwsfw.class.newInstance();
					jbggwsfw.setDoc_id(docList.get(0).getId().toString());
					List<Ironfoinformationsxjbggwsfw> list_data = ironfoinformationsxService.queryForjbggwsfw(jbggwsfw);
					if(list_data.size()>0) {
						for(Ironfoinformationsxjbggwsfw j :list_data) {
							datas = new TreeMap<String,Object>(); 
							datas.put("doc_id",  docList.get(0).getId().toString());
							datas.put("se_id", j.getSe_id());
							datas.put("jkjyfw", j.getJkjyfw());
							datas.put("yfjzfw", j.getYfjzfw());
							datas.put("etjkglfw", j.getEtjkglfw());
							datas.put("ycfjkglfw", j.getYcfjkglfw());
							datas.put("lnrjkglfw", j.getLnrjkglfw());
							datas.put("gxyhzjkglfw", j.getGxyhzjkglfw());
							datas.put("extnbhzjkglfw", j.getExtnbhzjkglfw());
							datas.put("yzjszahzjkglfw", j.getYzjszahzjkglfw());
							datas.put("fjhhzjkglfw", j.getFjhhzjkglfw());
							datas.put("lnrzyyjkglfw", j.getLnrzyyjkglfw());
							datas.put("etzyyjkglfw", j.getEtzyyjkglfw());
							datas.put("crbjtfggwssjglfw", j.getCrbjtfggwssjglfw());
							datas.put("wsjsjdxgfw", j.getWsjsjdxgfw());
							datas.put("jhsyjsfw", j.getJhsyjsfw());
							datas.put("mxbjcfw", j.getMxbjcfw());
							datas.put("id", j.getId());
							
							
						}
						
					}else {
						datas = new TreeMap<String,Object>(); 
						datas.put("doc_id", "");
						datas.put("se_id", "");
						datas.put("jkjyfw","0");
						datas.put("yfjzfw", "0");
						datas.put("etjkglfw", "0");
						datas.put("ycfjkglfw", "0");
						datas.put("lnrjkglfw", "0");
						datas.put("gxyhzjkglfw", "0");
						datas.put("extnbhzjkglfw", "0");
						datas.put("yzjszahzjkglfw", "0");
						datas.put("fjhhzjkglfw", "0");
						datas.put("lnrzyyjkglfw", "0");
						datas.put("etzyyjkglfw", "0");
						datas.put("crbjtfggwssjglfw", "0");
						datas.put("wsjsjdxgfw", "0");
						datas.put("jhsyjsfw", "0");
						datas.put("mxbjcfw", "0");
						datas.put("id", "");
						
					}
					
				}else if(type.trim()==IronfoinformationsxController.JGYYGL||type.trim().equals(IronfoinformationsxController.JGYYGL)) {
					jgyygl = Ironfoinformationsxjgyygl.class.newInstance();
					jgyygl.setDoc_id(docList.get(0).getId().toString());
					List<Ironfoinformationsxjgyygl> list_data=ironfoinformationsxService.queryForjgyygl(jgyygl);
					if(list_data.size()>0) {
						for(Ironfoinformationsxjgyygl j : list_data) {
							datas = new TreeMap<String,Object>(); 
							datas.put("doc_id", docList.get(0).getId().toString());
							datas.put("se_id", j.getSe_id());
							datas.put("jbywglfw", j.getJbywglfw());
							datas.put("yfglfw", j.getYfglfw());
							datas.put("ykglfw", j.getYkglfw());
							datas.put("wzglfw", j.getWzglfw());
							datas.put("sbglfw", j.getSbglfw());
							datas.put("cwglfw", j.getCwglfw());
							datas.put("grxxkhfw", j.getGrxxkhfw());
							datas.put("jgxykhfw", j.getJgxykhfw());
							datas.put("tjfxyzhcxfw", j.getTjfxyzhcxfw());
							datas.put("ygglfw", j.getYgglfw());
							datas.put("ylfwglfw", j.getYlfwglfw());
							datas.put("xdgyglfw", j.getXdgyglfw());
							datas.put("id", j.getId());
//							private String ylfwglfw;		// 医疗废物管理服务
//							private String xdgyglfw;		// 消毒供应管理服务
							
						}
						
					}else {
						datas = new TreeMap<String,Object>(); 
						datas.put("doc_id", "");
						datas.put("se_id", "");
						datas.put("jbywglfw", "0");
						datas.put("yfglfw", "0");
						datas.put("ykglfw", "0");
						datas.put("wzglfw", "0");
						datas.put("sbglfw", "0");
						datas.put("cwglfw", "0");
						datas.put("grxxkhfw", "0");
						datas.put("jgxykhfw", "0");
						datas.put("tjfxyzhcxfw", "0");
						datas.put("ygglfw", "0");
						datas.put("ylfwglfw", "0");
						datas.put("xdgyglfw", "0");
						datas.put("id", "");
						
					}
					
					
				}else if(type.trim()==IronfoinformationsxController.JKDAGL||type.trim().equals(IronfoinformationsxController.JKDAGL)) {
					jkdagl = Ironfoinformationsxjkdagl.class.newInstance();
					jkdagl.setDoc_id(docList.get(0).getId().toString());
					List<Ironfoinformationsxjkdagl> list_data = ironfoinformationsxService.queryForjkdagl(jkdagl);
					if(list_data.size()>0) {
						for(Ironfoinformationsxjkdagl j : list_data) {
//							private String sx_id;		// 4.2信息化系统功能实现表id
//							private String jmjkdaglfw;		// 居民健康档案管理服务
//							private String jmjkkglfw;		// 居民健康卡管理服务
//							private String jtjkdaglfw;		// 家庭健康档案管理服务
//							private String doc_id;		// 主表id
							datas = new TreeMap<String,Object>(); 
							datas.put("sx_id", j.getSx_id());
							datas.put("jmjkdaglfw", j.getJmjkdaglfw());
							datas.put("jmjkkglfw", j.getJmjkkglfw());
							datas.put("jtjkdaglfw", j.getJtjkdaglfw());
							datas.put("doc_id", docList.get(0).getId().toString());
							datas.put("id", j.getId());
							
						}
						
					}else {
						datas = new TreeMap<String,Object>(); 
						datas.put("sx_id", "");
						datas.put("jmjkdaglfw","0");
						datas.put("jmjkkglfw", "0");
						datas.put("jtjkdaglfw", "0");
						datas.put("doc_id", "");
						datas.put("id", "");
						
					}
					
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			
			
			
			
		}
		
		request.setAttribute("data", datas);
		model.addAttribute("data", datas);
		
		
		//		model.addAttribute("ironfoinformationsx", ironfoinformationsx);
		return "modules/ironfoinformationsx/ironfoinformationsxForm";
	}

	/**
	 * 保存4.2信息化系统功能实现
	 */
	@RequiresPermissions(value={"ironfoinformationsx:ironfoinformationsx:add","ironfoinformationsx:ironfoinformationsx:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfoinformationsx ironfoinformationsx, Model model, RedirectAttributes redirectAttributes) throws Exception{

		boolean isnull=false;
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		
		
		
		Subject subject = SecurityUtils.getSubject();  
		Principal obj = (Principal) subject.getPrincipal();
		
		System.out.println(obj.getId());
		
		
		Map<String,Object> map = new  TreeMap<String,Object>();
		String data = request.getParameter("titles");
		String checkbox = request.getParameter("checkbox");
		String type = request.getParameter("type");
		String checkout = request.getParameter("checkout");
		/*String remarks = request.getParameter("remarks");*/
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
			
			
			
			/**
			 * 获取type值
			 */
			if(type.trim()==IronfoinformationsxController.JGJK||type.trim().equals(IronfoinformationsxController.JGJK)) {
				
				Ironfoinformationsxjgjk b = Ironfoinformationsxjgjk.class.newInstance();
				 b.setDoc_id(docId);
				List<Ironfoinformationsxjgjk> jk_data  = ironfoinformationsxService.queryForjgjk(b);
					
				if(jk_data.size()>0) {
					isnull = true;
				}else {
					isnull = false;
				}
			}else if(type.trim()==IronfoinformationsxController.JBYLFW||type.trim().equals(IronfoinformationsxController.JBYLFW)) {
				/**
				 * 
				 */
				Ironfoinformationsxjbylfw b = Ironfoinformationsxjbylfw.class.newInstance();
				b.setDoc_id(docId);
				List<Ironfoinformationsxjbylfw> jk_data = ironfoinformationsxService.queryForjbylfw(b);
				if(jk_data.size()>0) {
					isnull = true;
				}else {
					isnull = false;
				}
			}else if(type.trim()==IronfoinformationsxController.JBGGWSFW||type.trim().equals(IronfoinformationsxController.JBGGWSFW)) {
				/**
				 * 
				 */
				Ironfoinformationsxjbggwsfw jbggwsfw = Ironfoinformationsxjbggwsfw.class.newInstance();
				jbggwsfw.setDoc_id(docId);
				List<Ironfoinformationsxjbggwsfw> jb_data = ironfoinformationsxService.queryForjbggwsfw(jbggwsfw);
				if(jb_data.size()>0) {
					isnull = true;
				}else {
					isnull = false;
				}
				
			}else if(type.trim()==IronfoinformationsxController.JGYYGL||type.trim().equals(IronfoinformationsxController.JGYYGL)){
				/**
				 * 
				 */
				Ironfoinformationsxjgyygl yjb = Ironfoinformationsxjgyygl.class.newInstance();
				yjb.setDoc_id(docId);
				List<Ironfoinformationsxjgyygl> yjb_data= ironfoinformationsxService.queryForjgyygl(yjb);
				if(yjb_data.size()>0) {
					isnull = true;
				}else {
					isnull = false;
				}
			}else if(type.trim()==IronfoinformationsxController.JKXXFW||type.trim().equals(IronfoinformationsxController.JKXXFW)) {
				/**
				 * 
				 */
				Ironfoinformationsxjkxxfw jkxx = Ironfoinformationsxjkxxfw.class.newInstance();
				jkxx.setDoc_id(docId);
				List<Ironfoinformationsxjkxxfw> jk_data=ironfoinformationsxService.queryForGgwsb(jkxx);
				if(jk_data.size()>0) {
					isnull = true;
				}else {
					isnull = false;
				}
				
			}else if(type.trim()==IronfoinformationsxController.JKDAGL||type.trim().equals(IronfoinformationsxController.JKDAGL)) {
				/**
				 * 
				 */
				Ironfoinformationsxjkdagl zyb = Ironfoinformationsxjkdagl.class.newInstance();
				zyb.setDoc_id(docId);
				List<Ironfoinformationsxjkdagl> zyb_data = ironfoinformationsxService.queryForjkdagl(zyb);
				if(zyb_data.size()>0) {
					isnull = true;
				}else {
					isnull = false;
				}
			}	
		}
		
		
		
		
		if(type.trim()==IronfoinformationsxController.JGJK||type.trim().equals(IronfoinformationsxController.JGJK)) {
			
			Ironfoinformationsxjgjk b = Ironfoinformationsxjgjk.class.newInstance();
			b.setDoc_id(docId);
			b.setSe_id(map.get("se_id").toString());
			b.setJbggwsfwjgjk(map.get("jbggwsfwjgjk").toString());
			b.setJbylfwjgjk(map.get("jbylfwjgjk").toString());
			b.setJbywjgjk(map.get("jbywjgjk").toString());
			b.setXnhbcjgjk(map.get("xnhbcjgjk").toString());
				
			if(isnull == true) {
				b.setId(id);
				ironfoinformationsxService.updatejgjk(b);
//				;
			}else if(isnull == false){
				b.setId(UUID.randomUUID().toString().replaceAll("-", ""));
				ironfoinformationsxService.savejgjk(b);
//				;
			}
		}else if(type.trim()==IronfoinformationsxController.JBYLFW||type.trim().equals(IronfoinformationsxController.JBYLFW)) {
			/**
			 * 
			 */
			Ironfoinformationsxjbylfw b = Ironfoinformationsxjbylfw.class.newInstance();
			b.setSe_id(map.get("se_id").toString());
			b.setDoc_id(docId);
			b.setQkzlfw(map.get("qkzlfw").toString());
			b.setZyjhfw(map.get("zyjhfw").toString());
			b.setSsmzglfw(map.get("ssmzglfw").toString());
			b.setYcsssjfw(map.get("ycsssjfw").toString());
			b.setYczzjhfw(map.get("yczzjhfw").toString());
			b.setYcyxjyfw(map.get("ycyxjyfw").toString());
			b.setYcxdzdfw(map.get("ycxdzdfw").toString());
			b.setYcyxzdfw(map.get("ycyxzdfw").toString());
			b.setYcyyfw(map.get("ycyyfw").toString());
			b.setYchzfw(map.get("ychzfw").toString());
			b.setYcsxzzfw(map.get("ycsxzzfw").toString());
			b.setJyhjcfw(map.get("jyhjcfw").toString());
			/*b.setJktyfw(map.get("jktyfw").toString());*/
			b.setJtbcyhlfw(map.get("jtbcyhlfw").toString());
			b.setZyglfw(map.get("zyglfw").toString());

			if(isnull == true) {
				b.setId(id);
				ironfoinformationsxService.updatejbylfw(b);
			}else if(isnull == false){
				b.setId(UUID.randomUUID().toString().replaceAll("-", ""));
				ironfoinformationsxService.savejbylfw(b);
			}
			
			

		}else if(type.trim()==IronfoinformationsxController.JBGGWSFW||type.trim().equals(IronfoinformationsxController.JBGGWSFW)) {
			
			Ironfoinformationsxjbggwsfw jbggwsfw = Ironfoinformationsxjbggwsfw.class.newInstance();
			jbggwsfw.setDoc_id(docId);
			jbggwsfw.setSe_id(map.get("se_id").toString());
			jbggwsfw.setJkjyfw(map.get("jkjyfw").toString());
			jbggwsfw.setYfjzfw(map.get("yfjzfw").toString());
			jbggwsfw.setEtjkglfw(map.get("etjkglfw").toString());
			jbggwsfw.setYcfjkglfw(map.get("ycfjkglfw").toString());
			jbggwsfw.setLnrjkglfw(map.get("lnrjkglfw").toString());
			jbggwsfw.setMxbjcfw(map.get("mxbjcfw").toString());
			jbggwsfw.setJhsyjsfw(map.get("jhsyjsfw").toString());
			jbggwsfw.setWsjsjdxgfw(map.get("wsjsjdxgfw").toString());
			jbggwsfw.setCrbjtfggwssjglfw(map.get("crbjtfggwssjglfw").toString());
			jbggwsfw.setEtzyyjkglfw(map.get("etzyyjkglfw").toString());
			jbggwsfw.setLnrzyyjkglfw(map.get("lnrzyyjkglfw").toString());
			jbggwsfw.setFjhhzjkglfw(map.get("fjhhzjkglfw").toString());
			jbggwsfw.setYzjszahzjkglfw(map.get("yzjszahzjkglfw").toString());
			jbggwsfw.setExtnbhzjkglfw(map.get("extnbhzjkglfw").toString());
			jbggwsfw.setGxyhzjkglfw(map.get("gxyhzjkglfw").toString());
			
			if(isnull == true) {
				jbggwsfw.setId(id);
				ironfoinformationsxService.updatejbggwsfw(jbggwsfw);
			}else if(isnull == false){
				jbggwsfw.setId(UUID.randomUUID().toString().replaceAll("-", ""));
				ironfoinformationsxService.savejbggwsfw(jbggwsfw);
			}
			
			
			
			
		}else if(type.trim()==IronfoinformationsxController.JGYYGL||type.trim().equals(IronfoinformationsxController.JGYYGL)){
			/**
			 * 
			 */
			Ironfoinformationsxjgyygl yjb = Ironfoinformationsxjgyygl.class.newInstance();
			yjb.setDoc_id(docId);
			yjb.setSe_id(map.get("se_id").toString());
			yjb.setJbywglfw(map.get("jbywglfw").toString());
			yjb.setYfglfw(map.get("yfglfw").toString());
			yjb.setYkglfw(map.get("ykglfw").toString());
			yjb.setWzglfw(map.get("wzglfw").toString());
			yjb.setSbglfw(map.get("sbglfw").toString());
			yjb.setCwglfw(map.get("cwglfw").toString());
			yjb.setGrxxkhfw(map.get("grxxkhfw").toString());
			yjb.setJgxykhfw(map.get("jgxykhfw").toString());
			yjb.setTjfxyzhcxfw(map.get("tjfxyzhcxfw").toString());
			yjb.setYgglfw(map.get("ygglfw").toString());
			yjb.setYlfwglfw(map.get("ylfwglfw").toString());
			yjb.setXdgyglfw(map.get("xdgyglfw").toString());
			
			
			if(isnull == true) {
				yjb.setId(id);
				ironfoinformationsxService.updatejgyygl(yjb);
			}else if(isnull == false){
				yjb.setId(UUID.randomUUID().toString().replaceAll("-", ""));
				ironfoinformationsxService.savejgyygl(yjb);
			}
			
		}else if(type.trim()==IronfoinformationsxController.JKXXFW||type.trim().equals(IronfoinformationsxController.JKXXFW)) {
			/**
			 * 
			 */
			Ironfoinformationsxjkxxfw jkxx = Ironfoinformationsxjkxxfw.class.newInstance();
			jkxx.setDoc_id(docId);
			jkxx.setSe_id(map.get("se_id").toString());
			jkxx.setJkdacxfw(map.get("jkdacxfw").toString());
			jkxx.setJkxxfbglfw(map.get("jkxxfbglfw").toString());
			jkxx.setWsyyhtxfw(map.get("wsyyhtxfw").toString());
			jkxx.setJkjyxxfw(map.get("jkjyxxfw").toString());
			
			if(isnull == true) {
				jkxx.setId(id);
				ironfoinformationsxService.updatejkxxfw(jkxx);
			}else if(isnull == false){
				jkxx.setId(UUID.randomUUID().toString().replaceAll("-", ""));
				ironfoinformationsxService.savejkxxfw(jkxx);
			}
			
			
		}else if(type.trim()==IronfoinformationsxController.JKDAGL||type.trim().equals(IronfoinformationsxController.JKDAGL)) {
			Ironfoinformationsxjkdagl zyb = Ironfoinformationsxjkdagl.class.newInstance();
			zyb.setDoc_id(docId);
			zyb.setSx_id(map.get("se_id").toString());
			zyb.setJmjkdaglfw(map.get("jmjkdaglfw").toString());
			zyb.setJmjkkglfw(map.get("jmjkkglfw").toString());
			zyb.setJtjkdaglfw(map.get("jtjkdaglfw").toString());
			
			

			if(isnull == true) {
				zyb.setId(id);
				ironfoinformationsxService.updatejkdagl(zyb);
			}else if(isnull == false){
				zyb.setId(UUID.randomUUID().toString().replaceAll("-", ""));
				ironfoinformationsxService.savejkdagl(zyb);
			}
			
		}	
		
		

		
		
		
		
		//		if (!beanValidator(model, ironfoinformationsx)){
//			return form(ironfoinformationsx, model);
//		}
//		if(!ironfoinformationsx.getIsNewRecord()){//编辑表单保存
//			Ironfoinformationsx t = ironfoinformationsxService.get(ironfoinformationsx.getId());//从数据库取出记录的值
//			MyBeanUtils.copyBeanNotNull2Bean(ironfoinformationsx, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
//			ironfoinformationsxService.save(t);//保存
//		}else{//新增表单保存
//			ironfoinformationsxService.save(ironfoinformationsx);//保存
//		}
//		addMessage(redirectAttributes, "保存4.2信息化系统功能实现成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoinformationsx/ironfoinformationsx/?repage";
	}
	
	/**
	 * 删除4.2信息化系统功能实现
	 */
	@RequiresPermissions("ironfoinformationsx:ironfoinformationsx:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfoinformationsx ironfoinformationsx, RedirectAttributes redirectAttributes) {
		ironfoinformationsxService.delete(ironfoinformationsx);
		addMessage(redirectAttributes, "删除4.2信息化系统功能实现成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoinformationsx/ironfoinformationsx/?repage";
	}
	
	/**
	 * 批量删除4.2信息化系统功能实现
	 */
	@RequiresPermissions("ironfoinformationsx:ironfoinformationsx:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfoinformationsxService.delete(ironfoinformationsxService.get(id));
		}
		addMessage(redirectAttributes, "删除4.2信息化系统功能实现成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoinformationsx/ironfoinformationsx/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfoinformationsx:ironfoinformationsx:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfoinformationsx ironfoinformationsx, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "4.2信息化系统功能实现"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfoinformationsx> page = ironfoinformationsxService.findPage(new Page<Ironfoinformationsx>(request, response, -1), ironfoinformationsx);
    		new ExportExcel("4.2信息化系统功能实现", Ironfoinformationsx.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出4.2信息化系统功能实现记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoinformationsx/ironfoinformationsx/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfoinformationsx:ironfoinformationsx:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfoinformationsx> list = ei.getDataList(Ironfoinformationsx.class);
			for (Ironfoinformationsx ironfoinformationsx : list){
				try{
					ironfoinformationsxService.save(ironfoinformationsx);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条4.2信息化系统功能实现记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条4.2信息化系统功能实现记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入4.2信息化系统功能实现失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoinformationsx/ironfoinformationsx/?repage";
    }
	
	/**
	 * 下载导入4.2信息化系统功能实现数据模板
	 */
	@RequiresPermissions("ironfoinformationsx:ironfoinformationsx:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "4.2信息化系统功能实现数据导入模板.xlsx";
    		List<Ironfoinformationsx> list = Lists.newArrayList(); 
    		new ExportExcel("4.2信息化系统功能实现数据", Ironfoinformationsx.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoinformationsx/ironfoinformationsx/?repage";
    }
	
	
	

}