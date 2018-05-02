<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>放射科、超声科、心电图科管理</title>
	<meta name="decorator" content="default"/>
	
</head>
<body class="hideScroll">
		<form id="inputForm" modelAttribute="ironfoyjbylsbpzfskcskxdtk" action="${ctx}/ironfoyjbylsbpzfskcskxdtk/ironfoyjbylsbpzfskcskxdtk/save" method="post" class="form-horizontal">
	<%-- 	<form:hidden path="id"/>
		<sys:message content="${message}"/>	 --%>
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<%-- <tr>
					<td class="width-15 active"><label class="pull-right">备注信息：</label></td>
					<td class="width-35">
						<form:textarea path="remarks" htmlEscape="false" rows="4"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">主表id：</label></td>
					<td class="width-35">
						<form:input path="doc_id" htmlEscape="false"    class="form-control "/>
					</td>
				</tr> --%>
				<tr>
					<td class="width-15 active"><label class="pull-right">设备名称</label></td>
					
					<td class="width-15 active"><label class="pull-right">品牌</label></td>
					<td class="width-15 active"><label class="pull-right">型号</label></td>
					<td class="width-15 active"><label class="pull-right">数量（台/个）</label></td>
					<td class="width-15 active"><label class="pull-right">设备价格（元）</label></td>
					<td class="width-15 active"><label class="pull-right">投入使用年份</label></td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="fskcskxdtk_sbmc" name="fskcskxdtk_name" readOnly="true"  htmlEscape="false" id="xdtj_sbmc"  value="心电图机"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="fskcskxdtk_pp" name="fskcskxdtk_name" htmlEscape="false"  id="xdtj_pp"  value="${data.xdtj.xdtj_pp }"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_xh" name="fskcskxdtk_name" htmlEscape="false" id="xdtj_xh"   value="${data.xdtj.xdtj_xh }"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_sl" name="fskcskxdtk_name" htmlEscape="false"  id="xdtj_sl"  value="${data.xdtj.xdtj_sl }"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="fskcskxdtk_sbjg" name="fskcskxdtk_name" htmlEscape="false"   id="xdtj_sbjg"   value="${data.xdtj.xdtj_sbjg }"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_trsynf" name="fskcskxdtk_name" htmlEscape="false"   id="xdtj_trsynf"   value="${data.xdtj.xdtj_trsynf }"  class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="xdtj_id"  name="fskcskxdtk_name" value="${data.xdtj.xdtj_id}"  class="form-control "/>
						 <input type = "hidden" htmlEscape="false" id="docId"   name="fskcskxdtk_name" value="${data.doc_id}"  class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="fskcskxdtk_sbmc" readOnly="true"  name="fskcskxdtk_name" htmlEscape="false" id="dtxdtj_sbmc"  value="动态心电图机"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="fskcskxdtk_pp" name="fskcskxdtk_name" htmlEscape="false"  id="dtxdtj_pp"  value="${data.dtxdtj.dtxdtj_pp }" class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_xh" name="fskcskxdtk_name" htmlEscape="false"  id="dtxdtj_xh" value="${data.dtxdtj.dtxdtj_xh }"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_sl" name="fskcskxdtk_name" htmlEscape="false"   id="dtxdtj_sl" value="${data.dtxdtj.dtxdtj_sl }"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="fskcskxdtk_sbjg" name="fskcskxdtk_name" htmlEscape="false"   id="dtxdtj_sbjg" value="${data.dtxdtj.dtxdtj_sbjg }"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_trsynf" name="fskcskxdtk_name" htmlEscape="false"   id="dtxdtj_trsynf" value="${data.dtxdtj.dtxdtj_trsynf }"   class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="dtxdtj_id"  name="fskcskxdtk_name" value="${data.dtxdtj.dtxdtj_id}"  class="form-control "/>
				
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="fskcskxdtk_sbmc" readOnly="true"  name="fskcskxdtk_name"  id="hbcsbzdy_sbmc" htmlEscape="false"  value="黑白超声波诊断仪"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="fskcskxdtk_pp" name="fskcskxdtk_name" value="${data.hbcsbzdy.hbcsbzdy_pp }"  id="hbcsbzdy_pp"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_xh" name="fskcskxdtk_name" value="${data.hbcsbzdy.hbcsbzdy_xh }"  id="hbcsbzdy_xh"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_sl" name="fskcskxdtk_name" value="${data.hbcsbzdy.hbcsbzdy_sl }"  id="hbcsbzdy_sl"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="fskcskxdtk_sbjg" name="fskcskxdtk_name" value="${data.hbcsbzdy.hbcsbzdy_sbjg }"  id="hbcsbzdy_sbjg"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_trsynf" name="fskcskxdtk_name" value="${data.hbcsbzdy.hbcsbzdy_trsynf }"  id="hbcsbzdy_trsynf"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="hbcsbzdy_id"  name="fskcskxdtk_name" value="${data.hbcsbzdy.hbcsbzdy_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="fskcskxdtk_sbmc" readOnly="true"  name="fskcskxdtk_name" id="tscscsbzdy_sbmc" htmlEscape="false"  value="台式彩色超声波诊断仪"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="fskcskxdtk_pp" name="fskcskxdtk_name" value="${data.tscscsbzdy.tscscsbzdy_pp }" id="tscscsbzdy_pp" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_xh" name="fskcskxdtk_name"  value="${data.tscscsbzdy.tscscsbzdy_xh }"  id="tscscsbzdy_xh" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_sl" name="fskcskxdtk_name"  value="${data.tscscsbzdy.tscscsbzdy_sl }"  id="tscscsbzdy_sl" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="fskcskxdtk_sbjg" name="fskcskxdtk_name"  value="${data.tscscsbzdy.tscscsbzdy_sbjg }"  id="tscscsbzdy_sbjg" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_trsynf" name="fskcskxdtk_name"  value="${data.tscscsbzdy.tscscsbzdy_trsynf }"  id="tscscsbzdy_trsynf" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="tscscsbzdy_id"  name="fskcskxdtk_name" value="${data.tscscsbzdy.tscscsbzdy_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				
				<tr>
					<td class="width-15">
						<input path="fskcskxdtk_sbmc" readOnly="true"  name="fskcskxdtk_name" id="bxcscsbzdy_sbmc" htmlEscape="false"  value="便携彩色超声波诊断仪"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="fskcskxdtk_pp" name="fskcskxdtk_name"  value="${data.bxcscsbzdy.bxcscsbzdy_pp }"  id="bxcscsbzdy_pp"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_xh" name="fskcskxdtk_name"  value="${data.bxcscsbzdy.bxcscsbzdy_xh }"  id="bxcscsbzdy_xh"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_sl" name="fskcskxdtk_name"  value="${data.bxcscsbzdy.bxcscsbzdy_sl }"  id="bxcscsbzdy_sl"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="fskcskxdtk_sbjg" name="fskcskxdtk_name"  value="${data.bxcscsbzdy.bxcscsbzdy_sbjg }"  id="bxcscsbzdy_sbjg"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_trsynf" name="fskcskxdtk_name" value="${data.bxcscsbzdy.bxcscsbzdy_trsynf }"  id="bxcscsbzdy_trsynf"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="bxcscsbzdy_id"  name="fskcskxdtk_name" value="${data.bxcscsbzdy.bxcscsbzdy_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="fskcskxdtk_sbmc" readOnly="true"  name="fskcskxdtk_name" id="hcgzcxsbmri_sbmc" htmlEscape="false"  value="核磁共振成像设备MRI"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="fskcskxdtk_pp" name="fskcskxdtk_name" value="${data.hcgzcxsbmri.hcgzcxsbmri_pp }" id="hcgzcxsbmri_pp" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_xh" name="fskcskxdtk_name" value="${data.hcgzcxsbmri.hcgzcxsbmri_xh }"  id="hcgzcxsbmri_xh" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_sl" name="fskcskxdtk_name" value="${data.hcgzcxsbmri.hcgzcxsbmri_sl }"  id="hcgzcxsbmri_sl" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="fskcskxdtk_sbjg" name="fskcskxdtk_name" value="${data.hcgzcxsbmri.hcgzcxsbmri_sbjg }"  id="hcgzcxsbmri_sbjg" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_trsynf" name="fskcskxdtk_name" value="${data.hcgzcxsbmri.hcgzcxsbmri_trsynf }"  id="hcgzcxsbmri_trsynf" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="hcgzcxsbmri_id"  name="fskcskxdtk_name" value="${data.hcgzcxsbmri.hcgzcxsbmri_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				
				<tr>
					<td class="width-15"> 
						<input path="fskcskxdtk_sbmc" readOnly="true"  name="fskcskxdtk_name" id="szjyxgzyjdsa_sbmc" htmlEscape="false"  value="数字减影血管造影机DSA"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="fskcskxdtk_pp" name="fskcskxdtk_name" id="szjyxgzyjdsa_pp" value="${data.szjyxgzyjdsa.szjyxgzyjdsa_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_xh" name="fskcskxdtk_name" id="szjyxgzyjdsa_xh" value="${data.szjyxgzyjdsa.szjyxgzyjdsa_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_sl" name="fskcskxdtk_name" id="szjyxgzyjdsa_sl" value="${data.szjyxgzyjdsa.szjyxgzyjdsa_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="fskcskxdtk_sbjg" name="fskcskxdtk_name" id="szjyxgzyjdsa_sbjg" value="${data.szjyxgzyjdsa.szjyxgzyjdsa_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_trsynf" name="fskcskxdtk_name" id="szjyxgzyjdsa_trsynf" value="${data.szjyxgzyjdsa.szjyxgzyjdsa_trsynf }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="szjyxgzyjdsa_id"  name="fskcskxdtk_name" value="${data.szjyxgzyjdsa.szjyxgzyjdsa_id}"  class="form-control "/>
				
					</td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="fskcskxdtk_sbmc" readOnly="true"  name="fskcskxdtk_name" id="xsxjsjtcsysbct_sbmc" htmlEscape="false"   value="X射线计算机体层摄影设备CT"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="fskcskxdtk_pp" name="fskcskxdtk_name"  value="${data.xsxjsjtcsysbct.xsxjsjtcsysbct_pp }" id="xsxjsjtcsysbct_pp" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_xh" name="fskcskxdtk_name"  value="${data.xsxjsjtcsysbct.xsxjsjtcsysbct_xh }" id="xsxjsjtcsysbct_xh" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_sl" name="fskcskxdtk_name"  value="${data.xsxjsjtcsysbct.xsxjsjtcsysbct_sl }" id="xsxjsjtcsysbct_sl" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="fskcskxdtk_sbjg" name="fskcskxdtk_name"  value="${data.xsxjsjtcsysbct.xsxjsjtcsysbct_sbjg }"  id="xsxjsjtcsysbct_sbjg" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_trsynf" name="fskcskxdtk_name" value="${data.xsxjsjtcsysbct.xsxjsjtcsysbct_trsynf }" id="xsxjsjtcsysbct_trsynf" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="xsxjsjtcsysbct_id"  name="fskcskxdtk_name" value="${data.xsxjsjtcsysbct.xsxjsjtcsysbct_id}"  class="form-control "/>
				
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="fskcskxdtk_sbmc" readOnly="true"  name="fskcskxdtk_name" id="jsjxsxjcr_sbmc" htmlEscape="false"  value="计算机X射线机CR"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="fskcskxdtk_pp" name="fskcskxdtk_name" id="jsjxsxjcr_pp" value="${data.jsjxsxjcr.jsjxsxjcr_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_xh" name="fskcskxdtk_name" id="jsjxsxjcr_xh" value="${data.jsjxsxjcr.jsjxsxjcr_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_sl" name="fskcskxdtk_name" id="jsjxsxjcr_sl" value="${data.jsjxsxjcr.jsjxsxjcr_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="fskcskxdtk_sbjg" name="fskcskxdtk_name" id="jsjxsxjcr_sbjg" value="${data.jsjxsxjcr.jsjxsxjcr_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_trsynf" name="fskcskxdtk_name" id="jsjxsxjcr_trsynf" value="${data.jsjxsxjcr.jsjxsxjcr_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="jsjxsxjcr_id"  name="fskcskxdtk_name" value="${data.jsjxsxjcr.jsjxsxjcr_id}"  class="form-control "/>
				
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="fskcskxdtk_sbmc" readOnly="true"  name="fskcskxdtk_name" id="szhxsxjdr_sbmc" htmlEscape="false"  value="数字化X射线机DR"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="fskcskxdtk_pp" name="fskcskxdtk_name" value="${data.szhxsxjdr.szhxsxjdr_pp }" id="szhxsxjdr_pp" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_xh" name="fskcskxdtk_name" value="${data.szhxsxjdr.szhxsxjdr_xh }" id="szhxsxjdr_xh" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_sl" name="fskcskxdtk_name" value="${data.szhxsxjdr.szhxsxjdr_sl }" id="szhxsxjdr_sl" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="fskcskxdtk_sbjg" name="fskcskxdtk_name" value="${data.szhxsxjdr.szhxsxjdr_sbjg }" id="szhxsxjdr_sbjg" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_trsynf" name="fskcskxdtk_name" value="${data.szhxsxjdr.szhxsxjdr_trsynf }" id="szhxsxjdr_trsynf" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="szhxsxjdr_id"  name="fskcskxdtk_name" value="${data.szhxsxjdr.szhxsxjdr_id}"  class="form-control "/>
					</td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="fskcskxdtk_sbmc" readOnly="true"  name="fskcskxdtk_name" id="cwxsxj_sbmc" htmlEscape="false"  value="胃肠 X射线机"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="fskcskxdtk_pp" name="fskcskxdtk_name" id="cwxsxj_pp" value="${data.cwxsxj.cwxsxj_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_xh" name="fskcskxdtk_name" id="cwxsxj_xh" value="${data.cwxsxj.cwxsxj_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_sl" name="fskcskxdtk_name" id="cwxsxj_sl" value="${data.cwxsxj.cwxsxj_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="fskcskxdtk_sbjg" name="fskcskxdtk_name" id="cwxsxj_sbjg" value="${data.cwxsxj.cwxsxj_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_trsynf" name="fskcskxdtk_name" id="cwxsxj_trsynf" value="${data.cwxsxj.cwxsxj_trsynf }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="cwxsxj_id"  name="fskcskxdtk_name" value="${data.cwxsxj.cwxsxj_id}"  class="form-control "/>
					</td>
				</tr>	
					
				
				<tr>
					<td class="width-15">
						<input path="fskcskxdtk_sbmc" readOnly="true"  name="fskcskxdtk_name" id="mnxsxj_sbmc" htmlEscape="false"  value="泌尿X射线机"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="fskcskxdtk_pp" name="fskcskxdtk_name" id="mnxsxj_pp" value="${data.mnxsxj.mnxsxj_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_xh" name="fskcskxdtk_name" id="mnxsxj_xh" value="${data.mnxsxj.mnxsxj_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_sl" name="fskcskxdtk_name" id="mnxsxj_sl" value="${data.mnxsxj.mnxsxj_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="fskcskxdtk_sbjg" name="fskcskxdtk_name" id="mnxsxj_sbjg" value="${data.mnxsxj.mnxsxj_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_trsynf" name="fskcskxdtk_name" id="mnxsxj_trsynf" value="${data.mnxsxj.mnxsxj_trsynf }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="mnxsxj_id"  name="fskcskxdtk_name" value="${data.mnxsxj.mnxsxj_id}"  class="form-control "/>
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="fskcskxdtk_sbmc" readOnly="true"  name="fskcskxdtk_name" id="rxxsxj_sbmc" htmlEscape="false"  value="乳腺X射线机"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="fskcskxdtk_pp" name="fskcskxdtk_name" id="rxxsxj_pp" value="${data.rxxsxj.rxxsxj_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_xh" name="fskcskxdtk_name" id="rxxsxj_xh" value="${data.rxxsxj.rxxsxj_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_sl" name="fskcskxdtk_name" id="rxxsxj_sl" value="${data.rxxsxj.rxxsxj_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="fskcskxdtk_sbjg" name="fskcskxdtk_name" id="rxxsxj_sbjg" value="${data.rxxsxj.rxxsxj_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_trsynf" name="fskcskxdtk_name" id="rxxsxj_trsynf" value="${data.rxxsxj.rxxsxj_trsynf }" htmlEscape="false"    class="form-control "/>
					<input type = "hidden" htmlEscape="false" id="rxxsxj_id"  name="fskcskxdtk_name" value="${data.rxxsxj.rxxsxj_id}"  class="form-control "/>
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="fskcskxdtk_sbmc" readOnly="true"  name="fskcskxdtk_name" id="xxgmdy_sbmc" htmlEscape="false"  value="X线骨密度仪"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="fskcskxdtk_pp" name="fskcskxdtk_name" value="${data.xxgmdy.xxgmdy_pp }" id="xxgmdy_pp" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_xh" name="fskcskxdtk_name" value="${data.xxgmdy.xxgmdy_xh }"  id="xxgmdy_xh" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_sl" name="fskcskxdtk_name" value="${data.xxgmdy.xxgmdy_sl }"  id="xxgmdy_sl" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="fskcskxdtk_sbjg" name="fskcskxdtk_name" value="${data.xxgmdy.xxgmdy_sbjg }"  id="xxgmdy_sbjg" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_trsynf" name="fskcskxdtk_name" value="${data.xxgmdy.xxgmdy_trsynf }"  id="xxgmdy_trsynf" htmlEscape="false"    class="form-control "/>
					<input type = "hidden" htmlEscape="false" id="xxgmdy_id"  name="fskcskxdtk_name" value="${data.xxgmdy.xxgmdy_id}"  class="form-control "/>
					</td>
					
					
				</tr>
				
				<tr>
					<td class="width-15">
						<input path="fskcskxdtk_sbmc" readOnly="true"  name="fskcskxdtk_name" id="ydxsxj_sbmc" htmlEscape="false"  value="移动X射线机"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="fskcskxdtk_pp" name="fskcskxdtk_name" value="${data.ydxsxj.ydxsxj_pp }" id="ydxsxj_pp" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_xh" name="fskcskxdtk_name" value="${data.ydxsxj.ydxsxj_xh }" id="ydxsxj_xh" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_sl" name="fskcskxdtk_name" value="${data.ydxsxj.ydxsxj_sl }" id="ydxsxj_sl" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="fskcskxdtk_sbjg" name="fskcskxdtk_name" value="${data.ydxsxj.ydxsxj_sbjg }" id="ydxsxj_sbjg" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_trsynf" name="fskcskxdtk_name" value="${data.ydxsxj.ydxsxj_trsynf }" id="ydxsxj_trsynf" htmlEscape="false"    class="form-control "/>
					<input type = "hidden" htmlEscape="false" id="ydxsxj_id"  name="fskcskxdtk_name" value="${data.ydxsxj.ydxsxj_id}"  class="form-control "/>
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="fskcskxdtk_sbmc" readOnly="true"  name="fskcskxdtk_name" id="qtqzm_sbmc" htmlEscape="false"  value="其它（请注明）"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="fskcskxdtk_pp" name="fskcskxdtk_name" value="${data.qtqzm.qtqzm_pp }" id="qtqzm_pp" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_xh" name="fskcskxdtk_name" value="${data.qtqzm.qtqzm_xh }"  id="qtqzm_xh" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="fskcskxdtk_sl" name="fskcskxdtk_name" value="${data.qtqzm.qtqzm_sl }"  id="qtqzm_sl" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="fskcskxdtk_sbjg" name="fskcskxdtk_name" value="${data.qtqzm.qtqzm_sbjg }"  id="qtqzm_sbjg" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
					
						<input path="fskcskxdtk_trsynf" name="fskcskxdtk_name" value="${data.qtqzm.qtqzm_trsynf }"  id="qtqzm_trsynf" htmlEscape="false"    class="form-control "/>
					<input type = "hidden" htmlEscape="false" id="qtqzm_id"  name="fskcskxdtk_name" value="${data.qtqzm.qtqzm_id}"  class="form-control "/>
					</td>
					
					
				</tr>
		 	</tbody>
		</table>
	</form>
	
	
	
	
	
	<div style="text-align:right;">
		<input type="button" value="保存"  style="width:100px;height:50px;margin-right: 20px;" onclick="subuimtinput();"/>
	</div>
	
	
	
	<script type="text/javascript">
	function subuimtinput(){
		
		var data = document.getElementsByName("fskcskxdtk_name");
	
		var datas="";
		
		
		for(i=0;i<data.length;i++){
			if(data[i].value==null||data[i].value==""){
				datas = datas +data[i].id+": ---- ;";	
			}else{
				datas = datas +data[i].id+":"+data[i].value+";";	
			}
			
			
		}
	 	
		 $.ajax({
		      url:"${ctx}/ironfoyjbylsbpzfskcskxdtk/ironfoyjbylsbpzfskcskxdtk/save",
		      data:{
		    	  datas:datas
		    	     },
		      type:"post",
		      
		      success:function(data){
		    	   alert("保存成功"); 
		    	   location.reload();
		      }
		    });
	}
	</script>
	
	
	
</body>
</html>