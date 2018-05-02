/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.statistics.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
import com.jeeplus.modules.statistics.entity.Member;
import com.jeeplus.modules.statistics.service.MemberService;

/**
 * 会员统计Controller
 * @author 瞿高青
 * @version 2017-10-17
 */
@Controller
@RequestMapping(value = "${adminPath}/statistics/member")
public class MemberController extends BaseController {

	@Autowired
	private MemberService memberService;
	
	@ModelAttribute
	public Member get(@RequestParam(required=false) String id) {
		Member entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = memberService.get(id);
		}
		if (entity == null){
			entity = new Member();
		}
		return entity;
	}
	
	/**
	 * 会员统计列表页面
	 */
	@RequiresPermissions("statistics:member:list")
	@RequestMapping(value = {"list", ""})
	public String list(Member member, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Member> page = memberService.findPage(new Page<Member>(request, response), member); 
		model.addAttribute("page", page);
		return "modules/statistics/memberList";
	}

	/**
	 * 查看，增加，编辑会员统计表单页面
	 */
	@RequiresPermissions(value={"statistics:member:view","statistics:member:add","statistics:member:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Member member, Model model) {
		model.addAttribute("member", member);
		return "modules/statistics/memberForm";
	}

	/**
	 * 保存会员统计
	 */
	@RequiresPermissions(value={"statistics:member:add","statistics:member:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(Member member, Model model, RedirectAttributes redirectAttributes) throws Exception{
		if (!beanValidator(model, member)){
			return form(member, model);
		}
		if(!member.getIsNewRecord()){//编辑表单保存
			Member t = memberService.get(member.getId());//从数据库取出记录的值
			MyBeanUtils.copyBeanNotNull2Bean(member, t);//将编辑表单中的非NULL值覆盖数据库记录中的值
			memberService.save(t);//保存
		}else{//新增表单保存
			memberService.save(member);//保存
		}
		addMessage(redirectAttributes, "保存会员统计成功");
		return "redirect:"+Global.getAdminPath()+"/statistics/member/?repage";
	}
	
	/**
	 * 删除会员统计
	 */
	@RequiresPermissions("statistics:member:del")
	@RequestMapping(value = "delete")
	public String delete(Member member, RedirectAttributes redirectAttributes) {
		memberService.delete(member);
		addMessage(redirectAttributes, "删除会员统计成功");
		return "redirect:"+Global.getAdminPath()+"/statistics/member/?repage";
	}
	
	/**
	 * 批量删除会员统计
	 */
	@RequiresPermissions("statistics:member:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			memberService.delete(memberService.get(id));
		}
		addMessage(redirectAttributes, "删除会员统计成功");
		return "redirect:"+Global.getAdminPath()+"/statistics/member/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("statistics:member:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Member member, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "会员统计"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Member> page = memberService.findPage(new Page<Member>(request, response, -1), member);
    		new ExportExcel("会员统计", Member.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出会员统计记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/statistics/member/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("statistics:member:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Member> list = ei.getDataList(Member.class);
			for (Member member : list){
				try{
					memberService.save(member);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条会员统计记录。");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条会员统计记录"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入会员统计失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/statistics/member/?repage";
    }
	
	/**
	 * 下载导入会员统计数据模板
	 */
	@RequiresPermissions("statistics:member:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "会员统计数据导入模板.xlsx";
    		List<Member> list = Lists.newArrayList(); 
    		new ExportExcel("会员统计数据", Member.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/statistics/member/?repage";
    }
	
	
	

}