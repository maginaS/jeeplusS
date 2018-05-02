/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.report.ironfoyjbylsbpzzykreport.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
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
import com.jeeplus.common.config.Global;
import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.utils.DateUtils;
import com.jeeplus.common.utils.MyBeanUtils;
import com.jeeplus.common.utils.StringUtils;
import com.jeeplus.common.utils.excel.ExportExcel;
import com.jeeplus.common.utils.excel.ImportExcel;
import com.jeeplus.common.web.BaseController;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.ironfodoctitle.service.IronfoDocTitleService;
import com.jeeplus.modules.ironfoyjbylsbpzzyk.entity.Ironfoyjbylsbpzzyk;
import com.jeeplus.modules.ironfoyjbylsbpzzyk.service.IronfoyjbylsbpzzykService;
import com.jeeplus.modules.report.ironfoyjbylsbpzzykreport.entity.IronfoyjbylsbpzzykReport;
import com.jeeplus.modules.report.ironfoyjbylsbpzzykreport.service.IronfoyjbylsbpzzykReportService;
import com.jeeplus.modules.sys.dao.UserDao;
import com.jeeplus.modules.sys.entity.User;
import com.jeeplus.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 中医科Controller
 * 
 * @author anti_magina
 * @version 2018-04-20
 */
@Controller
@RequestMapping(value = "${adminPath}/ironfoyjbylsbpzzykreport/ironfoyjbylsbpzzyk")
public class IronfoyjbylsbpzzykReportController extends BaseController {

	// private IronfoDocTitl

	@Autowired
	private IronfoyjbylsbpzzykReportService ironfoyjbylsbpzzykService;
	@Autowired
	private IronfoyjbylsbpzzykService ironfoyjbylsbpzzyk_Service;
	@Autowired
	private UserDao userDao;

	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;

	@ModelAttribute
	public IronfoyjbylsbpzzykReport get(@RequestParam(required = false) String id) {
		IronfoyjbylsbpzzykReport entity = null;
		if (StringUtils.isNotBlank(id)) {
			entity = ironfoyjbylsbpzzykService.get(id);
		}
		if (entity == null) {
			entity = new IronfoyjbylsbpzzykReport();
		}
		return entity;
	}

	/**
	 * 中医科列表页面
	 */
	@RequiresPermissions("ironfoyjbylsbpzzykreport:ironfoyjbylsbpzzyk:list")
	@RequestMapping(value = { "list", "" })
	public String list(IronfoyjbylsbpzzykReport ironfoyjbylsbpzzyk, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		String userId = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			if (ironfoyjbylsbpzzyk.getDuser() != null && ironfoyjbylsbpzzyk.getDuser().toString() != null
					&& ironfoyjbylsbpzzyk.getDuser().toString().trim() != null
					&& !"".equals(ironfoyjbylsbpzzyk.getDuser().toString().trim())
					&& !"null".equals(ironfoyjbylsbpzzyk.getDuser().toString().trim())) {
				userId = ironfoyjbylsbpzzyk.getDuser().getId();
				title.setRemarks(userId);
			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			title = ironfoDoc_Title_Service.getDocId(userId);
			if (title != null) {

				ironfoyjbylsbpzzyk.setDocId(title.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Page<IronfoyjbylsbpzzykReport> page = ironfoyjbylsbpzzykService
				.findPage(new Page<IronfoyjbylsbpzzykReport>(request, response), ironfoyjbylsbpzzyk);
		model.addAttribute("page", page);
		return "modules/report/ironfoyjbylsbpzzykreport/ironfoyjbylsbpzzykList";
	}

	/**
	 * 查看，增加，编辑中医科表单页面
	 */
	@RequiresPermissions(value = { "ironfoyjbylsbpzzykreport:ironfoyjbylsbpzzyk:view",
			"ironfoyjbylsbpzzykreport:ironfoyjbylsbpzzyk:add",
			"ironfoyjbylsbpzzykreport:ironfoyjbylsbpzzyk:edit" }, logical = Logical.OR)
	@RequestMapping(value = "form")
	public String form(IronfoyjbylsbpzzykReport ironfoyjbylsbpzzyk, Model model) {
		model.addAttribute("ironfoyjbylsbpzzyk", ironfoyjbylsbpzzyk);
		return "report/ironfoyjbylsbpzzykreport/ironfoyjbylsbpzzykForm";
	}

	/**
	 * 保存中医科
	 */
	@RequiresPermissions(value = { "ironfoyjbylsbpzzykreport:ironfoyjbylsbpzzyk:add",
			"ironfoyjbylsbpzzykreport:ironfoyjbylsbpzzyk:edit" }, logical = Logical.OR)
	@RequestMapping(value = "save")
	public String save(IronfoyjbylsbpzzykReport ironfoyjbylsbpzzyk, Model model, RedirectAttributes redirectAttributes)
			throws Exception {
		if (!beanValidator(model, ironfoyjbylsbpzzyk)) {
			return form(ironfoyjbylsbpzzyk, model);
		}
		if (!ironfoyjbylsbpzzyk.getIsNewRecord()) {// 编辑表单保存
			IronfoyjbylsbpzzykReport t = ironfoyjbylsbpzzykService.get(ironfoyjbylsbpzzyk.getId());// 从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(ironfoyjbylsbpzzyk, t);// 将编辑表单中的非NULL值覆盖数据库记录中的值
			ironfoyjbylsbpzzykService.save(t);// 保存
		} else {// 新增表单保存
			ironfoyjbylsbpzzykService.save(ironfoyjbylsbpzzyk);// 保存
		}
		addMessage(redirectAttributes, "保存中医科成功");
		return "redirect:" + Global.getAdminPath() + "/ironfoyjbylsbpzzykreport/ironfoyjbylsbpzzyk/?repage";
	}

	/**
	 * 删除中医科
	 */
	@RequiresPermissions("ironfoyjbylsbpzzykreport:ironfoyjbylsbpzzyk:del")
	@RequestMapping(value = "delete")
	public String delete(IronfoyjbylsbpzzykReport ironfoyjbylsbpzzyk, RedirectAttributes redirectAttributes) {
		ironfoyjbylsbpzzykService.delete(ironfoyjbylsbpzzyk);
		addMessage(redirectAttributes, "删除中医科成功");
		return "redirect:" + Global.getAdminPath() + "/ironfoyjbylsbpzzykreport/ironfoyjbylsbpzzyk/?repage";
	}

	/**
	 * 批量删除中医科
	 */
	@RequiresPermissions("ironfoyjbylsbpzzykreport:ironfoyjbylsbpzzyk:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] = ids.split(",");
		for (String id : idArray) {
			ironfoyjbylsbpzzykService.delete(ironfoyjbylsbpzzykService.get(id));
		}
		addMessage(redirectAttributes, "删除中医科成功");
		return "redirect:" + Global.getAdminPath() + "/ironfoyjbylsbpzzykreport/ironfoyjbylsbpzzyk/?repage";
	}

	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("ironfoyjbylsbpzzykreport:ironfoyjbylsbpzzyk:export")
	@RequestMapping(value = "export", method = RequestMethod.POST)
	public String exportFile(IronfoyjbylsbpzzykReport ironfoyjbylsbpzzyk, HttpServletRequest request,
			HttpServletResponse response, RedirectAttributes redirectAttributes) {
		// 查找出所有用户
		List<User> userList = userDao.findUserData(ironfoyjbylsbpzzyk.getDuser());
		List<IronfoyjbylsbpzzykReport> pageList = new ArrayList<IronfoyjbylsbpzzykReport>();
		//List<Ironfoyjbylsbpzzyk> page_List = new ArrayList<Ironfoyjbylsbpzzyk>();
		Ironfoyjbylsbpzzyk ironfoyjbylsbpzzyk_data = null;
		List<String> str = null;
		String title_id = null;
		List<Ironfoyjbylsbpzzyk> datas = null;
		try {
			Boolean flag =false;
			for (User user : userList) {
				String userId = user.getId();
				IronfoDocTitle title = ironfoDoc_Title_Service.getDocId(userId);

				IronfoyjbylsbpzzykReport ironfoyjbylsbpzzyk1 = new IronfoyjbylsbpzzykReport();
				
				if (title != null) {
					title_id = title.getId();
					ironfoyjbylsbpzzyk1.setDocId(title_id);
					//获取所有数据list
					List<IronfoyjbylsbpzzykReport> list=ironfoyjbylsbpzzykService.findList(ironfoyjbylsbpzzyk1);
					if(list!=null && list.size()>0){
						list.get(0).setDuser(user);
					}
					pageList.addAll(ironfoyjbylsbpzzykService.findList(ironfoyjbylsbpzzyk1));
					//获取存在数据的用户下面的list
					ironfoyjbylsbpzzyk_data = Ironfoyjbylsbpzzyk.class.newInstance();
					ironfoyjbylsbpzzyk_data.setDocId(title_id);
					if(datas == null&&flag == false){
						datas = ironfoyjbylsbpzzyk_Service.queryForList(ironfoyjbylsbpzzyk_data);
						flag = true;
						//page_List.addAll(datas);
					}
				}
			}

			String fileName = "中医科" + DateUtils.getDate("yyyyMMddHHmmss") + ".xlsx";
			ironfoyjbylsbpzzyk_data = Ironfoyjbylsbpzzyk.class.newInstance();
			int strSize = 0;
				if (datas.size() > 0) {
					str = new ArrayList<String>();
					for (int i = 0; i < datas.size(); i++) {
						str.add(datas.get(i).getSbmc());
					}
					strSize = 7 * str.size();
					//strSize=5;
				}else{
					//用户此报表都不存在数据
					return null;
				}

//			}

			new ExportExcel("中医科", IronfoyjbylsbpzzykReport.class, str).setDataList(pageList, strSize)
					.write(response, fileName).dispose();

			System.out.println("------111111--------------->");

			// return null;
		} catch (Exception e) {
			System.out.println("eee---->" + e);

			// addMessage(redirectAttributes, "导出中医科记录失败！失败信息："+e.getMessage());
		}
		return "redirect:" + Global.getAdminPath() + "/report/ironfoyjbylsbpzzykreport/ironfoyjbylsbpzzyk/?repage";
	}

	/**
	 * 导出excel文件
	 */
	// @RequiresPermissions("ironfoyjbylsbpzzykreport:ironfoyjbylsbpzzyk:export")
	// @RequestMapping(value = "export", method=RequestMethod.POST)
	public String exportFile1(IronfoyjbylsbpzzykReport ironfoyjbylsbpzzyk, HttpServletRequest request,
			HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String userId = null;
		Ironfoyjbylsbpzzyk ironfoyjbylsbpzzyk_data = null;
		try {
			IronfoDocTitle title = IronfoDocTitle.class.newInstance();
			// User user = User.class.
			// List<Map<String,Map<String,Map<String,Object>>>> map_list
			// =List.class.newInstance();
			List<IronfoDocTitle> title_list = List.class.newInstance();
			Map<String, Object> map_data = new TreeMap<String, Object>();
			List<User> u_list = userDao.findUserData(User.class.newInstance());

			if (u_list.size() > 0) {

				int i = 1;
				for (User uid : u_list) {

					IronfoDocTitle title_data = ironfoDoc_Title_Service.getDocId(uid.getId());
					// title_list.addAll(c)
					map_data.put("title_" + i, title_data);
					i++;
				}

			} else {
				Subject subject = SecurityUtils.getSubject();
				Principal obj = (Principal) subject.getPrincipal();
				userId = (String) obj.getId();
			}
			// if (ironfoyjbylsbpzzyk.getDuser() !=
			// null&&ironfoyjbylsbpzzyk.getDuser().toString() != null &&
			// ironfoyjbylsbpzzyk.getDuser().toString().trim() != null
			// && !"".equals(ironfoyjbylsbpzzyk.getDuser().toString().trim())
			// &&
			// !"null".equals(ironfoyjbylsbpzzyk.getDuser().toString().trim()))
			// {
			// userId = ironfoyjbylsbpzzyk.getDuser().getId();
			// title.setRemarks(userId);
			// } else {
			// Subject subject = SecurityUtils.getSubject();
			// Principal obj = (Principal) subject.getPrincipal();
			// userId = (String) obj.getId();
			// }
			// title = ironfoDoc_Title_Service.getDocId(userId);
			// if(title != null){
			////
			// ironfoyjbylsbpzzyk_data = Ironfoyjbylsbpzzyk.class.newInstance();
			// ironfoyjbylsbpzzyk_data.setDoc_id(title.getId());
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {

			String fileName = "中医科" + DateUtils.getDate("yyyyMMddHHmmss") + ".xlsx";
			Page<IronfoyjbylsbpzzykReport> page = ironfoyjbylsbpzzykService
					.findPage(new Page<IronfoyjbylsbpzzykReport>(request, response, -1), ironfoyjbylsbpzzyk);

			// Page<Ironfoyjbylsbpzzyk> page =
			// ironfoyjbylsbpzzyk_Service.findPage(new
			// Page<Ironfoyjbylsbpzzyk>(request, response, -1),
			// ironfoyjbylsbpzzyk_data);

			List<Ironfoyjbylsbpzzyk> datas = ironfoyjbylsbpzzyk_Service.queryForList(ironfoyjbylsbpzzyk_data);
			// List<IronfoyjbylsbpzzykReport> datas = page.getList();

			List<String> str = new ArrayList<String>();
			for (int i = 0; i < datas.size(); i++) {
				str.add( datas.get(i).getSbmc());
			}

			new ExportExcel("中医科", IronfoyjbylsbpzzykReport.class, str).setDataList(page.getList())
					.write(response, fileName).dispose();
			// return null;
		} catch (Exception e) {
			e.printStackTrace();
			addMessage(redirectAttributes, "导出中医科记录失败！失败信息：" + e.getMessage());
		}
		return "redirect:" + Global.getAdminPath() + "/report/ironfoyjbylsbpzzykreport/ironfoyjbylsbpzzyk/?repage";
	}

	/**
	 * 导入Excel数据
	 * 
	 */
	@RequiresPermissions("ironfoyjbylsbpzzykreport:ironfoyjbylsbpzzyk:import")
	@RequestMapping(value = "import", method = RequestMethod.POST)
	public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<IronfoyjbylsbpzzykReport> list = ei.getDataList(IronfoyjbylsbpzzykReport.class);
			for (IronfoyjbylsbpzzykReport ironfoyjbylsbpzzyk : list) {
				try {
					ironfoyjbylsbpzzykService.save(ironfoyjbylsbpzzyk);
					successNum++;
				} catch (ConstraintViolationException ex) {
					failureNum++;
				} catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum > 0) {
				failureMsg.insert(0, "，失败 " + failureNum + " 条中医科记录。");
			}
			addMessage(redirectAttributes, "已成功导入 " + successNum + " 条中医科记录" + failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入中医科失败！失败信息：" + e.getMessage());
		}
		return "redirect:" + Global.getAdminPath() + "/report/ironfoyjbylsbpzzykreport/ironfoyjbylsbpzzyk/?repage";
	}

	/**
	 * 下载导入中医科数据模板
	 */
	@RequiresPermissions("ironfoyjbylsbpzzykreport:ironfoyjbylsbpzzyk:import")
	@RequestMapping(value = "import/template")
	public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
			String fileName = "中医科数据导入模板.xlsx";
			List<IronfoyjbylsbpzzykReport> list = Lists.newArrayList();
			new ExportExcel("中医科数据", IronfoyjbylsbpzzykReport.class, 1).setDataList(list).write(response, fileName)
					.dispose();
			return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息：" + e.getMessage());
		}
		return "redirect:" + Global.getAdminPath() + "/ironfoyjbylsbpzzykreport/ironfoyjbylsbpzzyk/?repage";
	}

}