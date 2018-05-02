/**
 * 
 */
package com.jeeplus.modules.webapi;


import java.util.HashMap;
import java.util.Map;

//import org.apache.shiro.authz.annotation.Logical;
//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeeplus.modules.ironfoconemp.service.IronfoconempService;
import com.jeeplus.modules.ironfodoctitle.entity.IronfoDocTitle;
import com.jeeplus.modules.ironfodoctitle.service.IronfoDocTitleService;
import com.jeeplus.modules.ironfofivebfpz.service.IronfofivebfpzService;
import com.jeeplus.modules.ironfojbxx.entity.Ironfojbxx;
import com.jeeplus.modules.ironfojbxx.service.IronfojbxxService;
import com.jeeplus.modules.ironfomedicalservicesdatas.entity.IronfoMedicalService;
import com.jeeplus.modules.ironfomedicalservicesdatas.service.IronfoMedicalServiceService;
import com.jeeplus.modules.ironfopopulation.service.IronfopopulationService;

/**
 * @author MikeSun
 *
 */


@Controller
@RequestMapping(value = "${adminPath}/ironfowebapi/ironfowebapi")
public class WebapiController {
	
	@Autowired
	private IronfojbxxService jbxx;
	
	@Autowired
	private IronfoDocTitleService ironfoDoc_Title_Service;
	@Autowired
	private IronfoMedicalServiceService ironfoMedicalServiceService;
	@Autowired
	private IronfoconempService ironfoconempService;
	@Autowired
	private IronfofivebfpzService ironfofivebfpzService;
	@Autowired
	private IronfopopulationService ironfopopulationService;
	/**
	 * 一次性传输字段接口
	 * @param UnitId
	 * @param Timestamp
	 * @param Nonce 
	 * anther mikesun
	 * @param A0201 填写人
	 * @return
	 */
	
	@RequestMapping(value = "saveinformation",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> saveInformation(Map<String,String> data,String mac
			//水印
			) {
		
		Map<String, Object> restMap = new HashMap<String, Object>();
		
		try {
			if (validateMac(mac,data.get("aemp").toString().trim(),
					data.get("atel").toString().trim(),
					data.get("adate").toString().trim(),
					data.get("aappr").toString().trim(),
					data.get("aapprtel").toString().trim(),
					data.get("aappremail").toString().trim(),
					data.get("bhos").toString().trim(),
					data.get("bhosaddr").toString().trim(),
					data.get("bcen").toString().trim(),
					data.get("unitID").toString().trim(),
					data.get("updateTime").toString().trim())) {
				
				
				Ironfojbxx jb = Ironfojbxx.class.newInstance();
				jb.setaappr(data.get("aappr").toString().trim());
				jb.setatel(data.get("atel").toString().trim());
				jb.setadate(data.get("adate").toString().trim());
				jb.setaemp(data.get("aemp").toString().trim());
				jb.setaapprtel(data.get("aapprtel").toString().trim());
				jb.setaappremail(data.get("aappremail").toString().trim());
				jb.setbhos(data.get("bhos").toString().trim());
				jb.setbhosaddr(data.get("bhosaddr").toString().trim());
				jb.setbcen(data.get("bcen").toString().trim());
				jb.setDocId(data.get("unitID").toString().trim());
				jbxx.save(jb);
				
				restMap.put("res_no", "00");
				restMap.put("msg", "保存成功");
				
			}else {
				restMap.put("res_no", "99");
				restMap.put("msg", "保存失败");
				
				
			}
		}catch(Exception e) {
			System.out.println("ee"+e);
			restMap.put("res_no", "98");
			restMap.put("msg", "校验失败");
			
		}
		return restMap;
		
	}
	
	
	
	
	/**
	 * 实时互传接口
	 * @param data
	 * @param mac
	 * @return
	 */
	
	@RequestMapping(value = "saveorupdateinformation",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> saveOrupdateInformation(Map<String,String> data,String mac){
		
		
		Map<String, Object> restMap = new HashMap<String, Object>();
		
		try {
			if (validateMac(mac,
					data.get("aemp").toString().trim(),//服务人口数
					//年度医疗服务量
					data.get("bzcw").toString().trim(),//编制床位
					data.get("sycw").toString().trim(),//实有床位
					data.get("sjkfzcrs").toString().trim(),//实际开放总床日数
					data.get("sjzyzcrs").toString().trim(),//实际占用总床日数
					data.get("zzlrcs").toString().trim(),//总诊疗人次数
					data.get("mzrcs").toString().trim(),//门诊人次数 
					data.get("jzrcs").toString().trim(),//急诊人次数
					data.get("cyrs").toString().trim(),//出院人数
					//职工构成
					data.get("nmjmjkdajdrs").toString().trim(),//年末居民健康档案建档人数
					data.get("zgzgs").toString().trim(),//在岗职工数
					data.get("wsjsry").toString().trim(),//卫生技术人员
					data.get("qtjsry").toString().trim(),//其他技术人员
					data.get("glry").toString().trim(),//管理人员
					data.get("gqjnry").toString().trim(),//工勤技能人员
					//5.房屋建筑配备
					//5.1建筑概况
					data.get("zyyfjzmj").toString().trim(),//住院用房建筑面积
					//5.9病房
					data.get("dcbfsl").toString().trim(),//单床病房数量
					data.get("ecbfsl").toString().trim(),//2床病房数量
					data.get("scbfsl").toString().trim(),//3床病房数量
					data.get("icbfsl").toString().trim(),//4床病房数量
					data.get("wcbfsl").toString().trim(),//5床病房数量
					data.get("lcbfsl").toString().trim(),//6床病房数量
					//5.1建筑概况
					data.get("yjyfjzmj").toString().trim(),//医技用房建筑面积
					data.get("ggwsyfjzmj").toString().trim(),//公共卫生用房建筑面积
					data.get("zgshyfjzmj").toString().trim(),//职工生活用房建筑面积
					//id
					data.get("unitID").toString().trim(),//UnitID
					data.get("updateTime").toString().trim()//UpdateTime
					)) {
				//字段保存到数据库
				//if(no)insert else(exist) update 
				saveByUnitID(data.get("unitID").toString().trim());
				
				restMap.put("res_no", "00");
				restMap.put("msg", "保存成功");
				
				
			}else {
				restMap.put("res_no", "99");
				restMap.put("msg", "保存失败");
			}
			
		}catch(Exception e) {
			System.out.println("ee"+e);
			restMap.put("res_no", "98");
			restMap.put("msg", "校验失败");
			
		}
		
		return restMap;
	}
	
	/**
	 * 框架自带识别新数据.判定是update还是save
	 * @param id
	 */
	public void saveByUnitID(String id){
		IronfoDocTitle ironfoDocTitle = ironfoDoc_Title_Service.getDocId(id);
		if(ironfoDocTitle == null || ironfoDocTitle.getId() == null)return;
		String  doc_id  = ironfoDocTitle.getId();
		IronfoMedicalService ironfoMedicalService = ironfoMedicalServiceService.get(doc_id);
		//框架自带识别新数据.判定是update还是save---需要修改每个关系表的xml的get方法为getDoc_id();
		ironfoMedicalServiceService.save(ironfoMedicalService);
		ironfoconempService.save(ironfoconempService.get(doc_id));
		ironfofivebfpzService.save(ironfofivebfpzService.get(doc_id));
		ironfopopulationService.save(ironfopopulationService.get(doc_id));
	}
	
	
	
	
	
	
	
	/**
	 * 校验请求
	 * @param mac 水印
	 */
	private boolean validateMac(String mac,Object... macParam) {
		
		//水印参数
		String macParamStr="";
		for(int i=0;i<macParam.length;i++) {
			//if(macParam[i] != null && !"".equalsIgnoreCase(macParam[i].toString())) 
				macParamStr+=macParam[i];
			
		}
//		logger.info(macParamStr);
		
		//System.out.println("水印---------------------->"+macParamStr);
		//3、校验水印是否一致
		//生成水印
		String generatedMac = "";
		if(mac.indexOf("_") != -1) {
			generatedMac = MD5Util.getMd5(macParamStr,mac.substring(mac.indexOf("_")+1, mac.length()));
		} else {
			generatedMac = MD5Util.getMd5(macParamStr,"utf8");
		}
		
		if(mac.indexOf("_") != -1) {
			mac = mac.substring(0, mac.indexOf("_"));
		}
		
//		logger.info("请求的水印:"+mac);
//		logger.info("参数的水印:"+generatedMac);
		//对比水印是否一致
		if(generatedMac.equalsIgnoreCase(mac)) {
			System.out.println("水印校验成功");
//			logger.error("水印校验成功");
			return true;
		} else {
			System.out.println("水印校验不通过");
//			logger.error("水印校验不通过");
			return false;
		}
	}
}
