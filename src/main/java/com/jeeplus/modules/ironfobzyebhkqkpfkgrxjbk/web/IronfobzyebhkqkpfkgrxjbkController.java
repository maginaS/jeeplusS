/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.ironfobzyebhkqkpfkgrxjbk.web;

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
import com.jeeplus.modules.ironfobzwkfck.entity.Ironfobzwkfck;
import com.jeeplus.modules.ironfobzyebhkqkpfkgrxjbk.entity.Ironfobzyebhkqkpfkgrxjbk;
import com.jeeplus.modules.ironfobzyebhkqkpfkgrxjbk.service.IronfobzyebhkqkpfkgrxjbkService;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.ironfodoctitle.service.IronfoDocTitleService;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 2.7其它临床科室病种Controller
 * @author mikesun
 * @version 2018-04-21
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfobzyebhkqkpfkgrxjbk/ironfobzyebhkqkpfkgrxjbk")
public class IronfobzyebhkqkpfkgrxjbkController extends BaseController {
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;


	@Autowired
	private IronfobzyebhkqkpfkgrxjbkService ironfobzyebhkqkpfkgrxjbkService;
	
	@ModelAttribute
	public Ironfobzyebhkqkpfkgrxjbk get(@RequestParam(required=false) String id) {
		Ironfobzyebhkqkpfkgrxjbk entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ironfobzyebhkqkpfkgrxjbkService.get(id);
		}
		if (entity == null){
			entity = new Ironfobzyebhkqkpfkgrxjbk();
		}
		return entity;
	}
	
	/**
	 * 2.7其它临床科室病种列表页面
	 */
	@RequiresPermissions("ironfobzyebhkqkpfkgrxjbk:ironfobzyebhkqkpfkgrxjbk:list")
	@RequestMapping(value = {"list", ""})
	public String list(Ironfobzyebhkqkpfkgrxjbk ironfobzyebhkqkpfkgrxjbk, HttpServletRequest request, HttpServletResponse response, Model model) {
	
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
			Ironfobzyebhkqkpfkgrxjbk ironfobzyebhkqkpfkgrxjbk_data = null;
			
			try {
				ironfobzyebhkqkpfkgrxjbk_data = Ironfobzyebhkqkpfkgrxjbk.class.newInstance();
				ironfobzyebhkqkpfkgrxjbk_data.setDoc_id(docList.get(0).getId().toString());
				
				
				List<Ironfobzyebhkqkpfkgrxjbk> list_data = ironfobzyebhkqkpfkgrxjbkService.queryForList(ironfobzyebhkqkpfkgrxjbk_data);

				
				if(list_data.size()>0) {
					
					for(Ironfobzyebhkqkpfkgrxjbk k : list_data) {
						datas = new TreeMap<String,Object>();
						datas.put("doc_id",docList.get(0).getId().toString());
						datas.put("yebhjbbz",k.getYebhjbbz());
						datas.put("yebhtjbz",k.getYebhtjbz());
						
						datas.put("kqkjbbz",k.getKqkjbbz());
						datas.put("kqktjbz",k.getKqktjbz());
						
						datas.put("pfkjbbz",k.getPfkjbbz());
						datas.put("pfktjbz",k.getPfktjbz());
						
						datas.put("grxjbkjbbz",k.getGrxjbkjbbz());
						datas.put("grxjbktjbz",k.getGrxjbktjbz());
						
						datas.put("grxjbktext",k.getGrxjbktext());
						datas.put("pfktext",k.getPfktext());
						datas.put("yebhtext",k.getYebhtext());
						datas.put("kqktext",k.getKqktext());
						//grxjbktjbztext--pfktjbztext--kqktjbztext--yebhtjbztext
						datas.put("grxjbktjbztext",k.getGrxjbktjbztext());
						datas.put("pfktjbztext",k.getPfktjbztext());
						datas.put("kqktjbztext",k.getKqktjbztext());
						datas.put("yebhtjbztext",k.getYebhtjbztext());
						
						datas.put("id",k.getId());
						
					}
					
				}else {
					datas = new TreeMap<String,Object>();
					datas.put("doc_id","");
					datas.put("yebhjbbz","[]");
					datas.put("yebhtjbz","[]");
					datas.put("kqkjbbz","[]");
					datas.put("kqktjbz","[]");
					datas.put("pfkjbbz","[]");
					datas.put("pfktjbz","[]");
					datas.put("grxjbkjbbz","[]");
					datas.put("grxjbktjbz","[]");
					datas.put("grxjbktext","");
					datas.put("pfktext","");
					datas.put("yebhtext","");
					datas.put("kqktext","");
					datas.put("id","");
					
				}
				
				
				
				
			} catch (Exception e) {
			}
			
		}else {
			datas = new TreeMap<String,Object>();
			datas.put("doc_id","");
			datas.put("yebhjbbz","[]");
			datas.put("yebhtjbz","[]");
			datas.put("kqkjbbz","[]");
			datas.put("kqktjbz","[]");
			datas.put("pfkjbbz","[]");
			datas.put("pfktjbz","[]");
			datas.put("grxjbkjbbz","[]");
			datas.put("grxjbktjbz","[]");
			datas.put("grxjbktext","");
			datas.put("pfktext","");
			datas.put("yebhtext","");
			datas.put("kqktext","");
			
			
			datas.put("grxjbktjbztext","");
			datas.put("yebhtjbztext","");
			datas.put("kqktjbztext","");
			datas.put("pfktjbztext","");
			
			datas.put("id","");
			
			
			
		}
		
		request.setAttribute("data", datas);
		model.addAttribute("data", datas);
		
		
		return "modules/ironfobzyebhkqkpfkgrxjbk/ironfobzyebhkqkpfkgrxjbkList";
	}

	/**
	 * 查看，增加，编辑2.7其它临床科室病种表单页面
	 */
	@RequiresPermissions(value={"ironfobzyebhkqkpfkgrxjbk:ironfobzyebhkqkpfkgrxjbk:view","ironfobzyebhkqkpfkgrxjbk:ironfobzyebhkqkpfkgrxjbk:add","ironfobzyebhkqkpfkgrxjbk:ironfobzyebhkqkpfkgrxjbk:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Ironfobzyebhkqkpfkgrxjbk ironfobzyebhkqkpfkgrxjbk, Model model) {
		model.addAttribute("ironfobzyebhkqkpfkgrxjbk", ironfobzyebhkqkpfkgrxjbk);
		return "modules/ironfobzyebhkqkpfkgrxjbk/ironfobzyebhkqkpfkgrxjbkForm";
	}

	/**
	 * 保存2.7其它临床科室病种
	 */
	@RequiresPermissions(value={"ironfobzyebhkqkpfkgrxjbk:ironfobzyebhkqkpfkgrxjbk:add","ironfobzyebhkqkpfkgrxjbk:ironfobzyebhkqkpfkgrxjbk:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Ironfobzyebhkqkpfkgrxjbk ironfobzyebhkqkpfkgrxjbk, Model model, RedirectAttributes redirectAttributes) throws Exception{
		

		boolean isnull=false;
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		
		Map<String,Object> map = new  TreeMap<String,Object>();
		String docId = request.getParameter("docId");
		String id = request.getParameter("id");
		
		Object yebhtjbz_data = request.getParameter("yebhtjbz_data");
		String yebyhktjbz_text = request.getParameter("yebyhktjbz_text");
		
		Object yebhtjbbz_data = request.getParameter("yebhtjbbz_data");
		String yebyhkjbbz_text = request.getParameter("yebyhkjbbz_text");
		
		Object kqkjbbz_data = request.getParameter("kqkjbbz_data");
		String kqkjbbz_text = request.getParameter("kqkjbbz_text");
		
		Object kqktjbz_data = request.getParameter("kqktjbz_data");
		String kqktjbz_text = request.getParameter("kqktjbz_text");
//   	  //皮肤科基本病种
//   	  pfkjbbz_data:pfkjbbz_data,
//   	  pfkjbbz_text:pfkjbbz_text,
		Object pfkjbbz_data = request.getParameter("pfkjbbz_data");
		String pfkjbbz_text = request.getParameter("pfkjbbz_text");
//   	  //皮肤科推荐病种
//   	  pfktjbz_data:pfktjbz_data,
//   	  pfktjbz_text:pfktjbz_text,
		
		Object pfktjbz_data = request.getParameter("pfktjbz_data");
		String pfktjbz_text = request.getParameter("pfktjbz_text");
//   	  //感染性疾病科基本病种
//   	  grxjbkjbbz_data:grxjbkjbbz_data,
//   	  grxjbkjbbz_text:grxjbkjbbz_text,
		Object grxjbkjbbz_data = request.getParameter("grxjbkjbbz_data");
		String grxjbkjbbz_text = request.getParameter("grxjbkjbbz_text");
//   	  //感染性疾病科推荐病种
//   	  grxjbktjbz_data:grxjbktjbz_data,
//   	  grxjbktjbz_text:grxjbktjbz_text,
		Object grxjbktjbz_data = request.getParameter("grxjbktjbz_data");
		String grxjbktjbz_text = request.getParameter("grxjbktjbz_text");
		
		
		Subject subject = SecurityUtils.getSubject();  
		Principal obj = (Principal) subject.getPrincipal();
		
		System.out.println(obj.getId());

		
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
			Ironfobzyebhkqkpfkgrxjbk ironfobzyebhkqkpfkgrxjbk_data = Ironfobzyebhkqkpfkgrxjbk.class.newInstance();
			ironfobzyebhkqkpfkgrxjbk_data.setDoc_id(docId);
			List<Ironfobzyebhkqkpfkgrxjbk> list_data = ironfobzyebhkqkpfkgrxjbkService.queryForList(ironfobzyebhkqkpfkgrxjbk_data);
			
			if(list_data.size()>0) {
				isnull = true;
			}else {
				isnull = false;
			}
			
		}
		
		
//		private String doc_id;		// 主表id
//		private String yebhjbbz;		// 眼耳鼻喉基本病种
//		private String yebhtjbz;		// 眼耳鼻喉推荐病种
		
		Ironfobzyebhkqkpfkgrxjbk ironfobzyebhkqkpfkgrxjbk_datas = Ironfobzyebhkqkpfkgrxjbk.class.newInstance();
		ironfobzyebhkqkpfkgrxjbk_datas.setDoc_id(docId);
		ironfobzyebhkqkpfkgrxjbk_datas.setGrxjbktjbztext(grxjbktjbz_text);
		ironfobzyebhkqkpfkgrxjbk_datas.setGrxjbktext(grxjbkjbbz_text.toString());
		ironfobzyebhkqkpfkgrxjbk_datas.setGrxjbktjbz(grxjbktjbz_data.toString());
		ironfobzyebhkqkpfkgrxjbk_datas.setGrxjbkjbbz(grxjbkjbbz_data.toString());
		ironfobzyebhkqkpfkgrxjbk_datas.setPfktjbztext(pfktjbz_text.toString());
		ironfobzyebhkqkpfkgrxjbk_datas.setPfktext(pfkjbbz_text.toString());
		ironfobzyebhkqkpfkgrxjbk_datas.setPfktjbz(pfktjbz_data.toString());
		ironfobzyebhkqkpfkgrxjbk_datas.setPfkjbbz(pfkjbbz_data.toString());
		ironfobzyebhkqkpfkgrxjbk_datas.setKqktjbztext(kqktjbz_text.toString());
		ironfobzyebhkqkpfkgrxjbk_datas.setKqktext(kqkjbbz_text.toString());
		ironfobzyebhkqkpfkgrxjbk_datas.setKqkjbbz(kqkjbbz_data.toString());
		ironfobzyebhkqkpfkgrxjbk_datas.setKqktjbz(kqktjbz_data.toString());
		ironfobzyebhkqkpfkgrxjbk_datas.setYebhtjbztext(yebyhktjbz_text.toString());
		ironfobzyebhkqkpfkgrxjbk_datas.setYebhtext(yebyhkjbbz_text.toString());
		ironfobzyebhkqkpfkgrxjbk_datas.setYebhjbbz(yebhtjbbz_data.toString());
		ironfobzyebhkqkpfkgrxjbk_datas.setYebhtjbz(yebhtjbz_data.toString());
		
		
		if(isnull == true) {
			ironfobzyebhkqkpfkgrxjbk_datas.setId(id);
			ironfobzyebhkqkpfkgrxjbkService.updateironfo(ironfobzyebhkqkpfkgrxjbk_datas);
		}else if(isnull == false){
			ironfobzyebhkqkpfkgrxjbkService.save(ironfobzyebhkqkpfkgrxjbk_datas);
			
		}
		return "redirect:"+Global.getAdminPath()+"/ironfobzyebhkqkpfkgrxjbk/ironfobzyebhkqkpfkgrxjbk/?repage";
	}
	
	/**
	 * 删除2.7其它临床科室病种
	 */
	@RequiresPermissions("ironfobzyebhkqkpfkgrxjbk:ironfobzyebhkqkpfkgrxjbk:del")
	@RequestMapping(value = "delete")
	public String delete(Ironfobzyebhkqkpfkgrxjbk ironfobzyebhkqkpfkgrxjbk, RedirectAttributes redirectAttributes) {
		ironfobzyebhkqkpfkgrxjbkService.delete(ironfobzyebhkqkpfkgrxjbk);
		addMessage(redirectAttributes, "删除2.7其它临床科室病种成功");
		return "redirect:"+Global.getAdminPath()+"/ironfobzyebhkqkpfkgrxjbk/ironfobzyebhkqkpfkgrxjbk/?repage";
	}
	
	/**
	 * 批量删除2.7其它临床科室病种
	 */
	@RequiresPermissions("ironfobzyebhkqkpfkgrxjbk:ironfobzyebhkqkpfkgrxjbk:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			ironfobzyebhkqkpfkgrxjbkService.delete(ironfobzyebhkqkpfkgrxjbkService.get(id));
		}
		addMessage(redirectAttributes, "删除2.7其它临床科室病种成功");
		return "redirect:"+Global.getAdminPath()+"/ironfobzyebhkqkpfkgrxjbk/ironfobzyebhkqkpfkgrxjbk/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfobzyebhkqkpfkgrxjbk:ironfobzyebhkqkpfkgrxjbk:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Ironfobzyebhkqkpfkgrxjbk ironfobzyebhkqkpfkgrxjbk, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "2.7其它临床科室病种"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Ironfobzyebhkqkpfkgrxjbk> page = ironfobzyebhkqkpfkgrxjbkService.findPage(new Page<Ironfobzyebhkqkpfkgrxjbk>(request, response, -1), ironfobzyebhkqkpfkgrxjbk);
    		new ExportExcel("2.7其它临床科室病种", Ironfobzyebhkqkpfkgrxjbk.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出2.7其它临床科室病种记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfobzyebhkqkpfkgrxjbk/ironfobzyebhkqkpfkgrxjbk/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("ironfobzyebhkqkpfkgrxjbk:ironfobzyebhkqkpfkgrxjbk:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Ironfobzyebhkqkpfkgrxjbk> list = ei.getDataList(Ironfobzyebhkqkpfkgrxjbk.class);
			for (Ironfobzyebhkqkpfkgrxjbk ironfobzyebhkqkpfkgrxjbk : list){
				try{
					ironfobzyebhkqkpfkgrxjbkService.save(ironfobzyebhkqkpfkgrxjbk);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条2.7其它临床科室病种记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条2.7其它临床科室病种记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入2.7其它临床科室病种失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfobzyebhkqkpfkgrxjbk/ironfobzyebhkqkpfkgrxjbk/?repage";
    }
	
	/**
	 * 下载导入2.7其它临床科室病种数据模板
	 */
	@RequiresPermissions("ironfobzyebhkqkpfkgrxjbk:ironfobzyebhkqkpfkgrxjbk:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "2.7其它临床科室病种数据导入模板.xlsx";
    		List<Ironfobzyebhkqkpfkgrxjbk> list = Lists.newArrayList(); 
    		new ExportExcel("2.7其它临床科室病种数据", Ironfobzyebhkqkpfkgrxjbk.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/ironfobzyebhkqkpfkgrxjbk/ironfobzyebhkqkpfkgrxjbk/?repage";
    }
	
	
	

}