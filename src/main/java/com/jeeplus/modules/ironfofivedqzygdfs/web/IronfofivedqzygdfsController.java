/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofivedqzygdfs.web;

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
import com.jeeplus.modules.ironfofivedqzygdfs.entity.Ironfofivedqzygdfs;
import com.jeeplus.modules.ironfofivedqzygdfs.service.IronfofivedqzygdfsService;
import com.jeeplus.modules.ironfofiveggwsyf.entity.Ironfofiveggwsyf;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 供电方式Controller
 * @author mikesun
 * @version 2018-04-15
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfofivedqzygdfs/ironfofivedqzygdfs")
public class IronfofivedqzygdfsController extends BaseController {
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;

	@Autowired
	private IronfofivedqzygdfsService ironfofivedqzygdfsService;
	
	@ModelAttribute
	public Ironfofivedqzygdfs get(@RequestParam(required=false) String id) {
		Ironfofivedqzygdfs entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfofivedqzygdfsService.get(id);
		}
		if (entity == null){
			entity = new Ironfofivedqzygdfs();
		}
		return entity;
	}
	
	/**
	 * 供电方式列表页面
	 */
	@RequiresPermissions("ironfofivedqzygdfs:ironfofivedqzygdfs:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfofivedqzygdfs ironfofivedqzygdfs, HttpServletRequest request, HttpServletResponse response, Model model) {
	
		
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
			Ironfofivedqzygdfs ironfofivedqzygdfs_data = null;
			try {
				ironfofivedqzygdfs_data = Ironfofivedqzygdfs.class.newInstance();
				ironfofivedqzygdfs_data.setDoc_id(docList.get(0).getId().toString());
				
				List<Ironfofivedqzygdfs> list_data = ironfofivedqzygdfsService.queryForList(ironfofivedqzygdfs_data);
				
				if(list_data.size()>0) {
					for(Ironfofivedqzygdfs gdfs :list_data) {
						datas = new TreeMap<String,Object>();
						datas.put("doc_id", docList.get(0).getId().toString());
						datas.put("dwdl",gdfs.getDwdl());
						datas.put("dwsl",gdfs.getDwsl());
						datas.put("ryfdj",gdfs.getRyfdj());
						datas.put("upszz",gdfs.getUpszz());
						datas.put("id",gdfs.getId());
						
					}
					
				}else {
					datas = new TreeMap<String,Object>();
					datas.put("doc_id", "");
					datas.put("dwdl", "0");
					datas.put("dwsl", "0");
					datas.put("ryfdj", "0");
					datas.put("upszz", "0");
					datas.put("id", "");
					
				}
				
				
			} catch (Exception e) {
			}
			
		}
		
		
		
		request.setAttribute("data", datas);
		model.addAttribute("data", datas);
		
		return "modules/ironfofivedqzygdfs/ironfofivedqzygdfsList";
	}

	/**
	 * 查看，增加，编辑供电方式表单页面
	 */
	@RequiresPermissions(value={"ironfofivedqzygdfs:ironfofivedqzygdfs:view","ironfofivedqzygdfs:ironfofivedqzygdfs:add","ironfofivedqzygdfs:ironfofivedqzygdfs:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfofivedqzygdfs ironfofivedqzygdfs, Model model) {
		model.addAttribute("ironfofivedqzygdfs", ironfofivedqzygdfs);
		return "modules/ironfofivedqzygdfs/ironfofivedqzygdfsForm";
	}

	/**
	 * 保存供电方式
	 */
	@RequiresPermissions(value={"ironfofivedqzygdfs:ironfofivedqzygdfs:add","ironfofivedqzygdfs:ironfofivedqzygdfs:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfofivedqzygdfs ironfofivedqzygdfs, Model model, RedirectAttributes redirectAttributes) throws Exception{
	
		
		
		

		boolean isnull=false;
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		
		

		Subject subject = SecurityUtils.getSubject();  
		Principal obj = (Principal) subject.getPrincipal();
		
		System.out.println(obj.getId());
		
		Map<String,Object> map = new  TreeMap<String,Object>();
		String docId = request.getParameter("docId");
		String checkbox = request.getParameter("checkval");
//		String type = request.getParameter("type");
		String checkout = request.getParameter("checkout");
		String qtqzm = request.getParameter("qtqzm");
		String id = request.getParameter("id");
		
		
		
//		String[] datas = data.split(";");
		
//		System.out.println("------------->"+datas[datas.length-1]);
		/**
		 * 主表信息
		 */
//		String docId = "";
//		for(int i=0;i<datas.length;i++) {
//			map.put(datas[i].toString().split(":")[0].toString(), datas[i].toString().split(":")[1].toString());
//			if("docId" == datas[i].toString().trim().split(":")[0].toString().trim() || "docId".equals(datas[i].toString().trim().split(":")[0].toString().trim())) {
//				docId = datas[i].toString().split(":")[1].toString();
//			}
//		}
		
		
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
			Ironfofivedqzygdfs ironfofivedqzygdfs_data = Ironfofivedqzygdfs.class.newInstance();
			ironfofivedqzygdfs_data.setDoc_id(docId);
			List<Ironfofivedqzygdfs> fkjlx_data = ironfofivedqzygdfsService.queryForList(ironfofivedqzygdfs_data);
			
			if(fkjlx_data.size()>0) {
				isnull = true;
			}else {
				isnull = false;
			}
			
		}
		
		
		
		Ironfofivedqzygdfs ironfofivedqzygdfs_datas = Ironfofivedqzygdfs.class.newInstance();
		ironfofivedqzygdfs_datas.setDoc_id(docId);
		ironfofivedqzygdfs_datas.setDwdl(map.get("dwdl").toString());
		ironfofivedqzygdfs_datas.setDwsl(map.get("dwsl").toString());
		ironfofivedqzygdfs_datas.setRyfdj(map.get("ryfdj").toString());
		ironfofivedqzygdfs_datas.setUpszz(map.get("upszz").toString());
		
		

		

		if(isnull == true) {
			//更新
			ironfofivedqzygdfs_datas.setId(id);
			ironfofivedqzygdfsService.updateironfo(ironfofivedqzygdfs_datas);
			
		}else if(isnull == false) {
			//保存
			ironfofivedqzygdfsService.save(ironfofivedqzygdfs_datas);
			
		}
		
		
		
		
		
		
		
		
		
		
		
		return "redirect:"+Global.getAdminPath()+"/ironfofivedqzygdfs/ironfofivedqzygdfs/?repage";
	}
	
	/**
	 * 删除供电方式
	 */
	@RequiresPermissions("ironfofivedqzygdfs:ironfofivedqzygdfs:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfofivedqzygdfs ironfofivedqzygdfs, RedirectAttributes redirectAttributes) {
		ironfofivedqzygdfsService.delete(ironfofivedqzygdfs);
		addMessage(redirectAttributes, "删除供电方式成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivedqzygdfs/ironfofivedqzygdfs/?repage";
	}
	
	/**
	 * 批量删除供电方式
	 */
	@RequiresPermissions("ironfofivedqzygdfs:ironfofivedqzygdfs:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfofivedqzygdfsService.delete(ironfofivedqzygdfsService.get(id));
		}
		addMessage(redirectAttributes, "删除供电方式成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofivedqzygdfs/ironfofivedqzygdfs/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfofivedqzygdfs:ironfofivedqzygdfs:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfofivedqzygdfs ironfofivedqzygdfs, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "供电方式"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfofivedqzygdfs> page = ironfofivedqzygdfsService.findPage(new Page<Ironfofivedqzygdfs>(request, response, -1), ironfofivedqzygdfs);
    		new ExportExcel("供电方式", Ironfofivedqzygdfs.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出供电方式记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivedqzygdfs/ironfofivedqzygdfs/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfofivedqzygdfs:ironfofivedqzygdfs:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfofivedqzygdfs> list = ei.getDataList(Ironfofivedqzygdfs.class);
			for (Ironfofivedqzygdfs ironfofivedqzygdfs : list){
				try{
					ironfofivedqzygdfsService.save(ironfofivedqzygdfs);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条供电方式记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条供电方式记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入供电方式失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivedqzygdfs/ironfofivedqzygdfs/?repage";
    }
	
	/**
	 * 下载导入供电方式数据模板
	 */
	@RequiresPermissions("ironfofivedqzygdfs:ironfofivedqzygdfs:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "供电方式数据导入模板.xlsx";
    		List<Ironfofivedqzygdfs> list = Lists.newArrayList(); 
    		new ExportExcel("供电方式数据", Ironfofivedqzygdfs.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofivedqzygdfs/ironfofivedqzygdfs/?repage";
    }
	
	
	

}