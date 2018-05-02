/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfoyjbylsbpzwkfck.web;

import java.lang.reflect.Method;
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
import com.jeeplus.modules.ironfoyjbylsbpzkqk.entity.Ironfoyjbylsbpzkqk;
import com.jeeplus.modules.ironfoyjbylsbpzwkfck.entity.Ironfoyjbylsbpzwkfck;
import com.jeeplus.modules.ironfoyjbylsbpzwkfck.service.IronfoyjbylsbpzwkfckService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;
import com.jeeplus.modules.tools.utils.EnumUtils;
import com.jeeplus.modules.tools.utils.GetSetMethod;
import com.jeeplus.modules.tools.utils.EnumUtils.IRONFOKQK;
import com.jeeplus.modules.tools.utils.EnumUtils.IRONFOWKFCK;

/**
 * 外科、妇（产）科Controller
 * @author mikesun
 * @version 2018-03-22
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfoyjbylsbpzwkfck/ironfoyjbylsbpzwkfck")
public class IronfoyjbylsbpzwkfckController extends BaseController {

	
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;


	@Autowired
	private IronfoyjbylsbpzwkfckService ironfoyjbylsbpzwkfckService;
	
	@ModelAttribute
	public Ironfoyjbylsbpzwkfck get(@RequestParam(required=false) String id) {
		Ironfoyjbylsbpzwkfck entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfoyjbylsbpzwkfckService.get(id);
		}
		if (entity == null){
			entity = new Ironfoyjbylsbpzwkfck();
		}
		return entity;
	}
	
	/**
	 * 外科、妇（产）科列表页面
	 */
	@RequiresPermissions("ironfoyjbylsbpzwkfck:ironfoyjbylsbpzwkfck:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfoyjbylsbpzwkfck ironfoyjbylsbpzwkfck, HttpServletRequest request, HttpServletResponse response, Model model) {
		
		Subject subject = SecurityUtils.getSubject();  
		Principal obj = (Principal) subject.getPrincipal();
		System.out.println(obj.getId());
		
		
		
		
		
		Map<String,Object> listData = new HashMap<String,Object>();
//		List<Object> listData = new ArrayList<Object>();
		Map<String,Object> datas = null;
		
		IronfoDocTitle title =null;
		try {
			title = IronfoDocTitle.class.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		title.setRemarks(obj.getId());
		List<IronfoDocTitle> docList = ironfoDoc_Title_Service.queryforList(title);
		if(docList.size()>0) {
			

			ironfoyjbylsbpzwkfck.setDoc_id(docList.get(0).getId().toString());
			List<Ironfoyjbylsbpzwkfck> data = ironfoyjbylsbpzwkfckService.queryForList(ironfoyjbylsbpzwkfck);
		
			listData.put("doc_id", docList.get(0).getId().toString());
			for(Ironfoyjbylsbpzwkfck room :data) {
				
				datas = new TreeMap<String,Object>();
//				datas.put("doc_id", data.get(0).getDoc_id());
				if("----".trim()==room.getId().trim()||"----".trim().equals(room.getId().trim())) {
					datas.put(EnumUtils.IRONFOWKFCK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_id", "");
				}else{
					datas.put(EnumUtils.IRONFOWKFCK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_id", room.getId());
				}
				
				if("----".trim()==room.getPp().trim()||"----".trim().equals(room.getPp().trim())) {
					datas.put(EnumUtils.IRONFOWKFCK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_pp", "");
				}else {
					datas.put(EnumUtils.IRONFOWKFCK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_pp", room.getPp());
				}
				
				if("----".trim()==room.getSbjg().trim()||"----".trim().equals(room.getSbjg().trim())) {
					datas.put(EnumUtils.IRONFOWKFCK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sbjg", "");
				}else {
					datas.put(EnumUtils.IRONFOWKFCK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sbjg", room.getSbjg());

				}
				
				if("----".trim() == room.getSl().trim()||"----".trim().equals(room.getSl().trim())) {
					datas.put(EnumUtils.IRONFOWKFCK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sl", "");
				}else {
					datas.put(EnumUtils.IRONFOWKFCK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_sl", room.getSl());

				}
				
				if("----".trim()==room.getXh().trim()||"----".trim().equals(room.getXh().trim())) {
					datas.put(EnumUtils.IRONFOWKFCK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_xh", "");
				}else {
					datas.put(EnumUtils.IRONFOWKFCK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_xh", room.getXh());
				}
				
				if("----".trim()==room.getTrsynf().trim()||"----".trim().equals(room.getTrsynf().trim())) {
					datas.put(EnumUtils.IRONFOWKFCK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_trsynf", "");
				}else {
					datas.put(EnumUtils.IRONFOWKFCK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase()+"_trsynf", room.getTrsynf());
				}
				
				listData.put(EnumUtils.IRONFOWKFCK.getEnumbyname(room.getSbmc().toString().trim()).toString().toLowerCase(), datas);
				
			}
			
			
			
			
			
			
		}else {
			
			
			for(IRONFOWKFCK jz :EnumUtils.IRONFOWKFCK.values()) {
				datas = new TreeMap<String,Object>();
				datas.put(jz.toString().toLowerCase()+"_id", "");
				datas.put(jz.toString().toLowerCase()+"_sbmc", "");
				datas.put(jz.toString().toLowerCase()+"_pp", "");
				datas.put(jz.toString().toLowerCase()+"_xh", "");
				datas.put(jz.toString().toLowerCase()+"_sl", "");
				datas.put(jz.toString().toLowerCase()+"_sbjg", "");
				datas.put(jz.toString().toLowerCase()+"_trsynf", "");
//				listData.add(datas);
				listData.put(jz.toString().toLowerCase(), datas);
			}
			
		}
		
		
		
		
		
		
		
		
		request.setAttribute("data", listData);
		model.addAttribute("data", listData);
		
		
		return "modules/ironfoyjbylsbpzwkfck/ironfoyjbylsbpzwkfckList";
	}

	/**
	 * 查看，增加，编辑外科、妇（产）科表单页面
	 */
	@RequiresPermissions(value={"ironfoyjbylsbpzwkfck:ironfoyjbylsbpzwkfck:view","ironfoyjbylsbpzwkfck:ironfoyjbylsbpzwkfck:add","ironfoyjbylsbpzwkfck:ironfoyjbylsbpzwkfck:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfoyjbylsbpzwkfck ironfoyjbylsbpzwkfck, Model model) {
		model.addAttribute("ironfoyjbylsbpzwkfck", ironfoyjbylsbpzwkfck);
		return "modules/ironfoyjbylsbpzwkfck/ironfoyjbylsbpzwkfckForm";
	}

	/**
	 * 保存外科、妇（产）科
	 */
	@RequiresPermissions(value={"ironfoyjbylsbpzwkfck:ironfoyjbylsbpzwkfck:add","ironfoyjbylsbpzwkfck:ironfoyjbylsbpzwkfck:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfoyjbylsbpzwkfck ironfoyjbylsbpzwkfck, Model model, RedirectAttributes redirectAttributes) throws Exception{
		 String[] SBMC = new String[] {"gzzly",
				 "qcy","kqylbzllxt","twcsssj","jgssj",
				 "ndlxfxxt","pgj","gkdlxt","dgnqyc","gqjxt",
				 "bcxbjctct","txjhxt","dzydj","fkzlc","qtqzm"};
		 
			boolean isnull=false;
			HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
			
			
			
			Subject subject = SecurityUtils.getSubject();  
			Principal obj = (Principal) subject.getPrincipal();
			
			System.out.println(obj.getId());
			
			Map<String,Object> map = new  TreeMap<String,Object>();
			String data = request.getParameter("datas");
			String[] ironfoyjbylsbpzwkfcks = data.split(";");
			
			
			String docId = "";
			for(int i=0;i<ironfoyjbylsbpzwkfcks.length;i++) {
//				if("sbmc".trim()==ironfoemergencyrooms[i].toString().split(":")[0].toString().trim()||"sbmc".trim().equals(ironfoemergencyrooms[i].toString().split(":")[0].toString().trim())) {
//					map.put(ironfoemergencyrooms[i].toString().split(":")[0].toString().trim(), ironfoemergencyrooms[i].toString().split(":")[0].toString().trim().split("=")[0].toString());
//				}else {
					map.put(ironfoyjbylsbpzwkfcks[i].toString().split(":")[0].toString(),ironfoyjbylsbpzwkfcks[i].toString().split(":")[1].toString());
					if("docId" == ironfoyjbylsbpzwkfcks[i].toString().trim().split(":")[0].toString().trim() || "docId".equals(ironfoyjbylsbpzwkfcks[i].toString().trim().split(":")[0].toString().trim())) {
						docId = ironfoyjbylsbpzwkfcks[i].toString().split(":")[1].toString();
					}
					
//				}
				
			}
			
			
			if(docId.toString().trim() == null || "".equals(docId.toString().trim())) {
	 			isnull = false;
	 			IronfoDocTitle title =  IronfoDocTitle.class.newInstance();
	 			title.setRemarks(obj.getId());
	 			
	 			List<IronfoDocTitle> docList = ironfoDoc_Title_Service.queryforList(title);
	 			docId= docList.get(0).getId().toString();
	 			
			}else {
				
				ironfoyjbylsbpzwkfck.setDoc_id(docId);
				List<Ironfoyjbylsbpzwkfck> ironfoList = ironfoyjbylsbpzwkfckService.queryForList(ironfoyjbylsbpzwkfck);
				if(ironfoList.size()>0) {
					isnull = true;
				}else {
					isnull = false;
				}
				
			}
			
		 
		 
			Ironfoyjbylsbpzwkfck ironfoyjbylsbpzwkfck_data = null;
			
			if(isnull == false) {
				//更新
				int i=1;
				ironfoyjbylsbpzwkfck_data = new Ironfoyjbylsbpzwkfck();
				for(int j=0;j<SBMC.length;j++) {
					
					for(Map.Entry<String, Object> entry :map.entrySet()) {
						if(SBMC[j].toString().trim() == entry.getKey().toString().trim().split("_")[0].toString().trim()||SBMC[j].toString().trim().equals(entry.getKey().toString().trim().split("_")[0].toString().trim())) {
							if("id".trim()==entry.getKey().toString().trim().split("_")[1].toString().trim()||"id".trim().equals(entry.getKey().toString().trim().split("_")[1].toString().trim())) {
								
							}else {
								
									Method m = GetSetMethod.getSetMethod(Ironfoyjbylsbpzwkfck.class,entry.getKey().toString().trim().split("_")[1].toString());
									m.invoke(ironfoyjbylsbpzwkfck_data, new Object[]{entry.getValue()} );
									i++;
									if(i==7) {
										ironfoyjbylsbpzwkfck_data.setDoc_id(docId); 
										ironfoyjbylsbpzwkfckService.save(ironfoyjbylsbpzwkfck_data);//保存
										i = 1;
										ironfoyjbylsbpzwkfck_data = new Ironfoyjbylsbpzwkfck();
								}	
							}	
						}	
					}	
				}	
				
				
			}else if(isnull == true){
				
				
				//更新
				int i=1;
				ironfoyjbylsbpzwkfck_data = new Ironfoyjbylsbpzwkfck();
				for(int j=0;j<SBMC.length;j++) {
					
					for(Map.Entry<String, Object> entry :map.entrySet()) {
						if(SBMC[j].toString().trim() == entry.getKey().toString().trim().split("_")[0].toString().trim()||SBMC[j].toString().trim().equals(entry.getKey().toString().trim().split("_")[0].toString().trim())) {
							if("id".trim()==entry.getKey().toString().trim().split("_")[1].toString().trim()||"id".trim().equals(entry.getKey().toString().trim().split("_")[1].toString().trim())) {
								ironfoyjbylsbpzwkfck_data.setId(entry.getValue().toString());
							}else {
								
									Method m = GetSetMethod.getSetMethod(Ironfoyjbylsbpzwkfck.class,entry.getKey().toString().trim().split("_")[1].toString());
									m.invoke(ironfoyjbylsbpzwkfck_data, new Object[]{entry.getValue()} );
									i++;
									if(i==7) {
										ironfoyjbylsbpzwkfck_data.setDoc_id(docId); 
										ironfoyjbylsbpzwkfckService.updateIronfo(ironfoyjbylsbpzwkfck_data);//保存
										i = 1;
										ironfoyjbylsbpzwkfck_data = new Ironfoyjbylsbpzwkfck();
								}	
							}	
						}	
					}	
				}	
					
				
			}
		
		
		
		//		if (!beanValidator(model, ironfoyjbylsbpzwkfck)){
//			return form(ironfoyjbylsbpzwkfck, model);
//		}
//		if(!ironfoyjbylsbpzwkfck.getIsNewRecord()){//编辑表单保存
//			Ironfoyjbylsbpzwkfck t = ironfoyjbylsbpzwkfckService.get(ironfoyjbylsbpzwkfck.getId());//从数据库取出记录的值
//			MyBeanUtils.copyBeanNotNull2Bean(ironfoyjbylsbpzwkfck, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
//			ironfoyjbylsbpzwkfckService.save(t);//保存
//		}else{//新增表单保存
//			ironfoyjbylsbpzwkfckService.save(ironfoyjbylsbpzwkfck);//保存
//		}
		addMessage(redirectAttributes, "保存外科、妇（产）科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzwkfck/ironfoyjbylsbpzwkfck/?repage";
	}
	
	/**
	 * 删除外科、妇（产）科
	 */
	@RequiresPermissions("ironfoyjbylsbpzwkfck:ironfoyjbylsbpzwkfck:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfoyjbylsbpzwkfck ironfoyjbylsbpzwkfck, RedirectAttributes redirectAttributes) {
		ironfoyjbylsbpzwkfckService.delete(ironfoyjbylsbpzwkfck);
		addMessage(redirectAttributes, "删除外科、妇（产）科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzwkfck/ironfoyjbylsbpzwkfck/?repage";
	}
	
	/**
	 * 批量删除外科、妇（产）科
	 */
	@RequiresPermissions("ironfoyjbylsbpzwkfck:ironfoyjbylsbpzwkfck:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfoyjbylsbpzwkfckService.delete(ironfoyjbylsbpzwkfckService.get(id));
		}
		addMessage(redirectAttributes, "删除外科、妇（产）科成功");
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzwkfck/ironfoyjbylsbpzwkfck/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfoyjbylsbpzwkfck:ironfoyjbylsbpzwkfck:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfoyjbylsbpzwkfck ironfoyjbylsbpzwkfck, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "外科、妇（产）科"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfoyjbylsbpzwkfck> page = ironfoyjbylsbpzwkfckService.findPage(new Page<Ironfoyjbylsbpzwkfck>(request, response, -1), ironfoyjbylsbpzwkfck);
    		new ExportExcel("外科、妇（产）科", Ironfoyjbylsbpzwkfck.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出外科、妇（产）科记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzwkfck/ironfoyjbylsbpzwkfck/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfoyjbylsbpzwkfck:ironfoyjbylsbpzwkfck:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfoyjbylsbpzwkfck> list = ei.getDataList(Ironfoyjbylsbpzwkfck.class);
			for (Ironfoyjbylsbpzwkfck ironfoyjbylsbpzwkfck : list){
				try{
					ironfoyjbylsbpzwkfckService.save(ironfoyjbylsbpzwkfck);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条外科、妇（产）科记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条外科、妇（产）科记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入外科、妇（产）科失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzwkfck/ironfoyjbylsbpzwkfck/?repage";
    }
	
	/**
	 * 下载导入外科、妇（产）科数据模板
	 */
	@RequiresPermissions("ironfoyjbylsbpzwkfck:ironfoyjbylsbpzwkfck:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "外科、妇（产）科数据导入模板.xlsx";
    		List<Ironfoyjbylsbpzwkfck> list = Lists.newArrayList(); 
    		new ExportExcel("外科、妇（产）科数据", Ironfoyjbylsbpzwkfck.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfoyjbylsbpzwkfck/ironfoyjbylsbpzwkfck/?repage";
    }
	
	
	

}