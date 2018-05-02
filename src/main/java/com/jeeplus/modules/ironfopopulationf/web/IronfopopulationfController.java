/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfopopulationf.web;

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
import com.jeeplus.modules.ironfopopulation.entity.Ironfopopulation;
import com.jeeplus.modules.ironfopopulationf.entity.Ironfopopulationf;
import com.jeeplus.modules.ironfopopulationf.service.IronfopopulationfService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 5.1.2建筑分布概况Controller
 * @author mikesun
 * @version 2018-03-22
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfopopulationf/ironfopopulationf")
public class IronfopopulationfController extends BaseController {
	

	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	
	

	@Autowired
	private IronfopopulationfService ironfopopulationfService;
	
	@ModelAttribute
	public Ironfopopulationf get(@RequestParam(required=false) String id) {
		Ironfopopulationf entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfopopulationfService.get(id);
		}
		if (entity == null){
			entity = new Ironfopopulationf();
		}
		return entity;
	}
	
	/**
	 * 5.1.2建筑分布概况列表页面
	 */
	@RequiresPermissions("ironfopopulationf:ironfopopulationf:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfopopulationf ironfopopulationf, HttpServletRequest request, HttpServletResponse response, Model model) {
		Subject subject = SecurityUtils.getSubject();  
		Principal obj = (Principal) subject.getPrincipal();
		System.out.println(obj.getId());
		
		IronfoDocTitle title = null;
//		IronfoDocTitle idt =
		try {
			title = IronfoDocTitle.class.newInstance();
			title.setRemarks(obj.getId());
			List<IronfoDocTitle> docList = ironfoDoc_Title_Service.queryforList(title);
			
			if(docList.size()>0) {
				ironfopopulationf = Ironfopopulationf.class.newInstance();
				ironfopopulationf.setDocid(docList.get(0).getId().toString());
			}else {
				ironfopopulationf = Ironfopopulationf.class.newInstance();
				title = IronfoDocTitle.class.newInstance();
				title.setTitle_name("乡镇卫生院硬件配置研究调查表");
				title.setRemarks(obj.getId());//备注用来存放登录用户id 将登录人和报表绑定在一起
				ironfoDoc_Title_Service.save(title);
				ironfopopulationf.setDocid(title.getId());
			}
				
		} catch (Exception e) {
		}
		
		
		Page<Ironfopopulationf> page = ironfopopulationfService.findPage(new Page<Ironfopopulationf>(request, response), ironfopopulationf); 
		model.addAttribute("page", page);
		return "modules/ironfopopulationf/ironfopopulationfList";
	}

	/**
	 * 查看，增加，编辑5.1.2建筑分布概况表单页面
	 */
	@RequiresPermissions(value={"ironfopopulationf:ironfopopulationf:view","ironfopopulationf:ironfopopulationf:add","ironfopopulationf:ironfopopulationf:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfopopulationf ironfopopulationf, Model model) {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  

		if(ironfopopulationf.getId()!=null&&!"".equals(ironfopopulationf.getId())) {
			
			Ironfopopulationf data = ironfopopulationfService.get(ironfopopulationf.getId());
			
			Map<String,Object> datas = new HashMap<String,Object>();
			datas.put("jzmc", data.getJzmc());
			datas.put("jzgn", data.getJzgn());
			datas.put("dscs", data.getDscs());
			datas.put("dxcs", data.getDxcs());
			datas.put("trsysj", data.getTrsysj());
			datas.put("doc_id", data.getDocid());
			datas.put("id", data.getId());
			
			
			request.setAttribute("data", datas);
			model.addAttribute("data", datas);
			
			
		}
		return "modules/ironfopopulationf/ironfopopulationfForm";
	}

	/**
	 * 保存5.1.2建筑分布概况
	 */
	@RequiresPermissions(value={"ironfopopulationf:ironfopopulationf:add","ironfopopulationf:ironfopopulationf:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfopopulationf ironfopopulationf, Model model, RedirectAttributes redirectAttributes) throws Exception{

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
			ironfopopulationf.setDocid(docId);
			List<Ironfopopulationf> ironfoList = ironfopopulationfService.queryForList(ironfopopulationf);
			if(ironfoList.size()>0) {
				isnull = true;
			}else {
				isnull = false;
			}
		}
		
		
		Ironfopopulationf ironfopopulationf_data = Ironfopopulationf.class.newInstance();
//		private String jzmc;		// 建筑名称
//		private String jzgn;		// 建筑功能
//		private String dscs;		// 地上层数
//		private String dxcs;		// 地下层数
//		private String trsysj;		// 投入使用时间
//		private String doc_id;		// 主表id
		ironfopopulationf_data.setJzmc(map.get("jzmc").toString());
		ironfopopulationf_data.setJzgn(map.get("jzgn").toString());
		ironfopopulationf_data.setDscs(map.get("dscs").toString());
		ironfopopulationf_data.setDxcs(map.get("dxcs").toString());
		ironfopopulationf_data.setTrsysj(map.get("trsysj").toString());
		ironfopopulationf_data.setDocid(docId);
		
		
		if(isnull==false) {
			//保存
			ironfopopulationfService.save(ironfopopulationf_data);
		}else if(isnull==true){
			//更新
			ironfopopulationf_data.setId(map.get("id").toString());
			ironfopopulationfService.updateIronfo(ironfopopulationf_data);
			
		}
		
		return "redirect:"+Global.getAdminPath()+"/ironfopopulationf/ironfopopulationf/?repage";
	}
	
	/**
	 * 删除5.1.2建筑分布概况
	 */
	@RequiresPermissions("ironfopopulationf:ironfopopulationf:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfopopulationf ironfopopulationf, RedirectAttributes redirectAttributes) {
		ironfopopulationfService.delete(ironfopopulationf);
		addMessage(redirectAttributes, "删除5.1.2建筑分布概况成功");
		return "redirect:"+Global.getAdminPath()+"/ironfopopulationf/ironfopopulationf/?repage";
	}
	
	/**
	 * 批量删除5.1.2建筑分布概况
	 */
	@RequiresPermissions("ironfopopulationf:ironfopopulationf:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfopopulationfService.delete(ironfopopulationfService.get(id));
		}
		addMessage(redirectAttributes, "删除5.1.2建筑分布概况成功");
		return "redirect:"+Global.getAdminPath()+"/ironfopopulationf/ironfopopulationf/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfopopulationf:ironfopopulationf:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfopopulationf ironfopopulationf, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "5.1.2建筑分布概况"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfopopulationf> page = ironfopopulationfService.findPage(new Page<Ironfopopulationf>(request, response, -1), ironfopopulationf);
    		new ExportExcel("5.1.2建筑分布概况", Ironfopopulationf.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出5.1.2建筑分布概况记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfopopulationf/ironfopopulationf/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfopopulationf:ironfopopulationf:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfopopulationf> list = ei.getDataList(Ironfopopulationf.class);
			for (Ironfopopulationf ironfopopulationf : list){
				try{
					ironfopopulationfService.save(ironfopopulationf);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条5.1.2建筑分布概况记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条5.1.2建筑分布概况记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入5.1.2建筑分布概况失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfopopulationf/ironfopopulationf/?repage";
    }
	
	/**
	 * 下载导入5.1.2建筑分布概况数据模板
	 */
	@RequiresPermissions("ironfopopulationf:ironfopopulationf:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "5.1.2建筑分布概况数据导入模板.xlsx";
    		List<Ironfopopulationf> list = Lists.newArrayList(); 
    		new ExportExcel("5.1.2建筑分布概况数据", Ironfopopulationf.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfopopulationf/ironfopopulationf/?repage";
    }
	
	
	

}