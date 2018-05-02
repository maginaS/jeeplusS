/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfofeatdepartment.web;

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
import com.jeeplus.modules.ironfoemergencyroom.entity.Ironfoemergencyroom;
import com.jeeplus.modules.ironfofeatdepartment.entity.Ironfofeatdepartment;
import com.jeeplus.modules.ironfofeatdepartment.service.IronfofeatdepartmentService;
import com.jeeplus.modules.ironfopopulationf.entity.Ironfopopulationf;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;
import com.jeeplus.modules.tools.utils.EnumUtils;

/**
 * 2.4.1特色科室Controller
 * @author mikesun
 * @version 2018-03-16
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfofeatdepartment/ironfofeatdepartment")
public class IronfofeatdepartmentController extends BaseController {
	
	
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;

	@Autowired
	private IronfofeatdepartmentService ironfofeatdepartmentService;
	
	@ModelAttribute
	public Ironfofeatdepartment get(@RequestParam(required=false) String id) {
		Ironfofeatdepartment entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfofeatdepartmentService.get(id);
		}
		if (entity == null){
			entity = new Ironfofeatdepartment();
		}
		return entity;
	}
	
	/**
	 * 2.4.1特色科室列表页面
	 */
	@RequiresPermissions("ironfofeatdepartment:ironfofeatdepartment:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfofeatdepartment ironfofeatdepartment, HttpServletRequest request, HttpServletResponse response, Model model) {

		Subject subject = SecurityUtils.getSubject();  
		Principal obj = (Principal) subject.getPrincipal();
		System.out.println(obj.getId());
		
		IronfoDocTitle title = null;
		try {
			title = IronfoDocTitle.class.newInstance();
			title.setRemarks(obj.getId());
			List<IronfoDocTitle> docList = ironfoDoc_Title_Service.queryforList(title);
			
			if(docList.size()>0) {
				ironfofeatdepartment = Ironfofeatdepartment.class.newInstance();
				ironfofeatdepartment.setDocid(docList.get(0).getId().toString());
			}else {
				ironfofeatdepartment = Ironfofeatdepartment.class.newInstance();
				title = IronfoDocTitle.class.newInstance();
				title.setTitle_name("乡镇卫生院硬件配置研究调查表");
				title.setRemarks(obj.getId());//备注用来存放登录用户id 将登录人和报表绑定在一起
				ironfoDoc_Title_Service.save(title);
				ironfofeatdepartment.setDocid(title.getId());
			}
			
		}catch(Exception e) {
		}
		
		
		
		Page<Ironfofeatdepartment> page = ironfofeatdepartmentService.findPage(new Page<Ironfofeatdepartment>(request, response), ironfofeatdepartment); 
		model.addAttribute("page", page);
		
		return "modules/ironfofeatdepartment/ironfofeatdepartmentList";
	}

	/**
	 * 查看，增加，编辑2.4.1特色科室表单页面
	 */
	@RequiresPermissions(value={"ironfofeatdepartment:ironfofeatdepartment:view","ironfofeatdepartment:ironfofeatdepartment:add","ironfofeatdepartment:ironfofeatdepartment:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfofeatdepartment ironfofeatdepartment, Model model) {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  

		if(ironfofeatdepartment.getId()!=null&&!"".equals(ironfofeatdepartment.getId())) {
			Ironfofeatdepartment data = ironfofeatdepartmentService.get(ironfofeatdepartment.getId());

			Map<String,Object> datas = new HashMap<String,Object>();
			datas.put("tsks", data.getTsks());
			datas.put("nmzrcs", data.getNmzrcs());
			datas.put("ncyrs", data.getNcyrs());
			datas.put("kssycw", data.getKssycw());
			datas.put("kszyzlys", data.getKszyzlys());
			datas.put("kszchs", data.getKszchs());
			datas.put("doc_id", data.getDocid());
			datas.put("id", data.getId());
			
			
			request.setAttribute("data", datas);
			model.addAttribute("data", datas);
			
		}

			
		
		model.addAttribute("ironfofeatdepartment", ironfofeatdepartment);
		return "modules/ironfofeatdepartment/ironfofeatdepartmentForm";
	}

	/**
	 * 保存2.4.1特色科室
	 */
	@RequiresPermissions(value={"ironfofeatdepartment:ironfofeatdepartment:add","ironfofeatdepartment:ironfofeatdepartment:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfofeatdepartment ironfofeatdepartment, Model model, RedirectAttributes redirectAttributes) throws Exception{

		boolean isnull=false;
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		
		
		
		Subject subject = SecurityUtils.getSubject();  
		Principal obj = (Principal) subject.getPrincipal();
		
		System.out.println(obj.getId());
		
		
		Map<String,Object> map = new  TreeMap<String,Object>();
		String data = request.getParameter("datas");
		String[] datas = data.split(";");
		
		

		String docId = "";
		for(int i=0;i<datas.length;i++) {
				map.put(datas[i].toString().split(":")[0].toString(),datas[i].toString().split(":")[1].toString());
				if("doc_id" == datas[i].toString().trim().split(":")[0].toString().trim() || "doc_id".equals(datas[i].toString().trim().split(":")[0].toString().trim())) {
					docId = datas[i].toString().split(":")[1].toString();
				}
				
		}
		
		
		if(docId.toString().trim() == null || "".equals(docId.toString().trim())||"----".trim()==docId.toString().trim()||"----".trim().equals(docId.toString().trim())) {
 			isnull = false;
 			IronfoDocTitle title =  IronfoDocTitle.class.newInstance();
 			title.setRemarks(obj.getId());
 			
 			List<IronfoDocTitle> docList = ironfoDoc_Title_Service.queryforList(title);
 			docId= docList.get(0).getId().toString();
 			
		}else {
			ironfofeatdepartment.setDocid(docId);
			List<Ironfofeatdepartment> ironfoList = ironfofeatdepartmentService.queryForList(ironfofeatdepartment);
			if(ironfoList.size()>0) {
				isnull = true;
			}else {
				isnull = false;
			}
		}
		
		
		
		
		
		
		
		Ironfofeatdepartment ironfofeatdepartment_data=null;
		
		ironfofeatdepartment_data = Ironfofeatdepartment.class.newInstance();
		ironfofeatdepartment_data.setDocid(docId);
		ironfofeatdepartment_data.setTsks(map.get("tsks").toString());
		ironfofeatdepartment_data.setNmzrcs(map.get("nmzrcs").toString());
		ironfofeatdepartment_data.setNcyrs(map.get("ncyrs").toString());
		ironfofeatdepartment_data.setKssycw(map.get("kssycw").toString());
		ironfofeatdepartment_data.setKszyzlys(map.get("kszyzlys").toString());
		ironfofeatdepartment_data.setKszchs(map.get("kszchs").toString());
		
		if(isnull == false) {
			//保存
			ironfofeatdepartmentService.save(ironfofeatdepartment_data);
			
		}else if(isnull == true) {
			//更新
			ironfofeatdepartment_data.setId(map.get("id").toString());
			ironfofeatdepartmentService.updateIronfo(ironfofeatdepartment_data);
			
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofeatdepartment/ironfofeatdepartment/?repage";
	}
	
	/**
	 * 删除2.4.1特色科室
	 */
	@RequiresPermissions("ironfofeatdepartment:ironfofeatdepartment:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfofeatdepartment ironfofeatdepartment, RedirectAttributes redirectAttributes) {
		ironfofeatdepartmentService.delete(ironfofeatdepartment);
		addMessage(redirectAttributes, "删除2.4.1特色科室成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofeatdepartment/ironfofeatdepartment/?repage";
	}
	
	/**
	 * 批量删除2.4.1特色科室
	 */
	@RequiresPermissions("ironfofeatdepartment:ironfofeatdepartment:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfofeatdepartmentService.delete(ironfofeatdepartmentService.get(id));
		}
		addMessage(redirectAttributes, "删除2.4.1特色科室成功");
		return "redirect:"+Global.getAdminPath()+"/ironfofeatdepartment/ironfofeatdepartment/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfofeatdepartment:ironfofeatdepartment:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfofeatdepartment ironfofeatdepartment, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "2.4.1特色科室"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfofeatdepartment> page = ironfofeatdepartmentService.findPage(new Page<Ironfofeatdepartment>(request, response, -1), ironfofeatdepartment);
    		new ExportExcel("2.4.1特色科室", Ironfofeatdepartment.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出2.4.1特色科室记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofeatdepartment/ironfofeatdepartment/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfofeatdepartment:ironfofeatdepartment:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfofeatdepartment> list = ei.getDataList(Ironfofeatdepartment.class);
			for (Ironfofeatdepartment ironfofeatdepartment : list){
				try{
					ironfofeatdepartmentService.save(ironfofeatdepartment);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条2.4.1特色科室记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条2.4.1特色科室记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入2.4.1特色科室失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofeatdepartment/ironfofeatdepartment/?repage";
    }
	
	/**
	 * 下载导入2.4.1特色科室数据模板
	 */
	@RequiresPermissions("ironfofeatdepartment:ironfofeatdepartment:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "2.4.1特色科室数据导入模板.xlsx";
    		List<Ironfofeatdepartment> list = Lists.newArrayList(); 
    		new ExportExcel("2.4.1特色科室数据", Ironfofeatdepartment.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfofeatdepartment/ironfofeatdepartment/?repage";
    }
	
	
	

}