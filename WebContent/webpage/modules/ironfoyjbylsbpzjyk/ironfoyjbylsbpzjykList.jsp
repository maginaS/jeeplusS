<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>检验科管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		var validateForm;
		function doSubmit(){//回调函数，在编辑和保存动作时，供openDialog调用提交表单。
		  if(validateForm.form()){
			  $("#inputForm").submit();
			  return true;
		  }
	
		  return false;
		}
		$(document).ready(function() {
			validateForm = $("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
			
		});
	</script>
</head>
<body class="hideScroll">
		<form id="inputForm" modelAttribute="ironfoyjbylsbpzjyk" action="${ctx}/ironfoyjbylsbpzjyk/ironfoyjbylsbpzjyk/save" method="post" class="form-horizontal">
		<%-- <form:hidden path="id"/>
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
						<input path="jyk_sbmc" name="jykgl_name" htmlEscape="false"  readOnly="true" id="qzdshfxy_sbmc" value="全自动生化分析仪"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_pp" name="jykgl_name" htmlEscape="false" id="qzdshfxy_pp"  value="${data.qzdshfxy.qzdshfxy_pp }"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_xh" name="jykgl_name" htmlEscape="false"  id="qzdshfxy_xh"  value="${data.qzdshfxy.qzdshfxy_xh }"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_sl"  name="jykgl_name" htmlEscape="false"  id="qzdshfxy_sl"  value="${data.qzdshfxy.qzdshfxy_sl }"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_sbjg" name="jykgl_name" htmlEscape="false"  id="qzdshfxy_sbjg" value="${data.qzdshfxy.qzdshfxy_sbjg }"     class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_trsynf" name="jykgl_name" htmlEscape="false" id="qzdshfxy_trsynf" value="${data.qzdshfxy.qzdshfxy_trsynf }"     class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="qzdshfxy_id"  name="jykgl_name" value="${data.qzdshfxy.qzdshfxy_id}"  class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="docId"   name="jykgl_name" value="${data.doc_id}"  class="form-control "/>
					
					
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="jyk_sbmc" name="jykgl_name" htmlEscape="false" readOnly="true" id="hxfgmyfxy_sbmc"  value="化学发光免疫分析仪"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_pp" name="jykgl_name" htmlEscape="false"  id="hxfgmyfxy_pp"  value="${data.hxfgmyfxy.hxfgmyfxy_pp }"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_xh" name="jykgl_name" htmlEscape="false"   id="hxfgmyfxy_xh"  value="${data.hxfgmyfxy.hxfgmyfxy_xh }"   class="form-control "/>
					</td>
					
					<td class="width-15"> 
						<input path="jyk_sl"  name="jykgl_name" htmlEscape="false"  id="hxfgmyfxy_sl"   value="${data.hxfgmyfxy.hxfgmyfxy_sl }"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_sbjg" name="jykgl_name" htmlEscape="false"  id="hxfgmyfxy_sbjg"  value="${data.hxfgmyfxy.hxfgmyfxy_sbjg }"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_trsynf" name="jykgl_name" htmlEscape="false" id="hxfgmyfxy_trsynf" value="${data.hxfgmyfxy.hxfgmyfxy_trsynf }"     class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="hxfgmyfxy_id"  name="jykgl_name" value="${data.hxfgmyfxy.hxfgmyfxy_id}"  class="form-control "/>
					</td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="jyk_sbmc" name="jykgl_name" htmlEscape="false" readOnly="true" id="lsxby_sbmc"  value="流式细胞仪"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_pp" name="jykgl_name" htmlEscape="false"  id="lsxby_pp"  value="${data.lsxby.lsxby_pp }"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_xh" name="jykgl_name" htmlEscape="false"  id="lsxby_xh"    value="${data.lsxby.lsxby_xh }"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_sl"  name="jykgl_name" htmlEscape="false"   id="lsxby_sl"   value="${data.lsxby.lsxby_sl }"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_sbjg" name="jykgl_name" htmlEscape="false"   id="lsxby_sbjg"    value="${data.lsxby.lsxby_sbjg }"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_trsynf" name="jykgl_name" htmlEscape="false"  id="lsxby_trsynf"   value="${data.lsxby.lsxby_trsynf }"     class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="lsxby_id"  name="jykgl_name" value="${data.lsxby.lsxby_id}"  class="form-control "/>
					</td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="jyk_sbmc" name="jykgl_name" htmlEscape="false" readOnly="true" id="xxbfxy_sbmc"  value="血细胞分析仪"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_pp" name="jykgl_name" htmlEscape="false"   id="xxbfxy_pp"   value="${data.xxbfxy.xxbfxy_pp}"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_xh" name="jykgl_name" htmlEscape="false"   id="xxbfxy_xh"  value="${data.xxbfxy.xxbfxy_xh}"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_sl"  name="jykgl_name" htmlEscape="false"   id="xxbfxy_sl"   value="${data.xxbfxy.xxbfxy_sl}"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_sbjg" name="jykgl_name" htmlEscape="false"   id="xxbfxy_sbjg"  value="${data.xxbfxy.xxbfxy_sbjg}"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_trsynf" name="jykgl_name" htmlEscape="false"   id="xxbfxy_trsynf"  value="${data.xxbfxy.xxbfxy_trsynf}"   class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="xxbfxy_id"  name="jykgl_name" value="${data.xxbfxy.xxbfxy_id}"  class="form-control "/>
					</td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="jyk_sbmc" name="jykgl_name" htmlEscape="false" readOnly="true" id="xyfxy_sbmc" value="血凝分析仪"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_pp" name="jykgl_name" htmlEscape="false"  id="xyfxy_pp" value="${data.xyfxy.xyfxy_pp}"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_xh" name="jykgl_name" htmlEscape="false"   id="xyfxy_xh"  value="${data.xyfxy.xyfxy_xh}"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_sl"  name="jykgl_name" htmlEscape="false"   id="xyfxy_sl"   value="${data.xyfxy.xyfxy_sl}" class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_sbjg" name="jykgl_name" htmlEscape="false"    id="xyfxy_sbjg"  value="${data.xyfxy.xyfxy_sbjg}" class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_trsynf" name="jykgl_name" htmlEscape="false"   id="xyfxy_trsynf" value="${data.xyfxy.xyfxy_trsynf}"  class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="xyfxy_id"  name="jykgl_name" value="${data.xyfxy.xyfxy_id}"  class="form-control "/>
					</td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="jyk_sbmc" name="jykgl_name" htmlEscape="false" readOnly="true" id="xqfxy_sbmc"  value="血气分析仪"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_pp" name="jykgl_name" htmlEscape="false"  id="xqfxy_pp"  value="${data.xqfxy.xqfxy_pp }"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_xh" name="jykgl_name" htmlEscape="false" id="xqfxy_xh"    value="${data.xqfxy.xqfxy_xh }"      class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_sl"  name="jykgl_name" htmlEscape="false"  id="xqfxy_sl"    value="${data.xqfxy.xqfxy_sl }"     class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_sbjg" name="jykgl_name" htmlEscape="false" id="xqfxy_sbjg"   value="${data.xqfxy.xqfxy_sbjg }"       class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_trsynf" name="jykgl_name" htmlEscape="false" id="xqfxy_trsynf"   value="${data.xqfxy.xqfxy_trsynf }"       class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="xqfxy_id"  name="jykgl_name" value="${data.xqfxy.xqfxy_id}"  class="form-control "/>
					</td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="jyk_sbmc" name="jykgl_name" htmlEscape="false" readOnly="true" id="xxjdy_sbmc"  value="血型鉴定仪"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_pp" name="jykgl_name" htmlEscape="false"  id="xxjdy_pp"  value="${data.xxjdy.xxjdy_pp}"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_xh" name="jykgl_name" htmlEscape="false" id="xxjdy_xh"   value="${data.xxjdy.xxjdy_xh}"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_sl"  name="jykgl_name" htmlEscape="false"  id="xxjdy_sl"  value="${data.xxjdy.xxjdy_sl}"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_sbjg" name="jykgl_name" htmlEscape="false"  id="xxjdy_sbjg"  value="${data.xxjdy.xxjdy_sbjg}"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_trsynf" name="jykgl_name" htmlEscape="false"  id="xxjdy_trsynf"  value="${data.xxjdy.xxjdy_trsynf}"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="xxjdy_id"  name="jykgl_name" value="${data.xxjdy.xxjdy_id}"  class="form-control "/>
					</td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="jyk_sbmc" name="jykgl_name" htmlEscape="false" readOnly="true" id="gsldlxj_sbmc"  value="高速冷冻离心机"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_pp" name="jykgl_name" htmlEscape="false"  id="gsldlxj_pp"    value="${data.gsldlxj.gsldlxj_pp}"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_xh" name="jykgl_name" htmlEscape="false"  id="gsldlxj_xh" value="${data.gsldlxj.gsldlxj_xh}"     class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_sl"  name="jykgl_name" htmlEscape="false"   id="gsldlxj_sl"  value="${data.gsldlxj.gsldlxj_sl}"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_sbjg" name="jykgl_name" htmlEscape="false"   id="gsldlxj_sbjg"  value="${data.gsldlxj.gsldlxj_sbjg}"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_trsynf" name="jykgl_name" htmlEscape="false"   id="gsldlxj_trsynf"  value="${data.gsldlxj.gsldlxj_trsynf}"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="gsldlxj_id"  name="jykgl_name" value="${data.gsldlxj.gsldlxj_id}"  class="form-control "/>
					</td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="jyk_sbmc" name="jykgl_name" htmlEscape="false" readOnly="true" id="ymjdxpyy_sbmc"  value="药敏鉴定血培养仪"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_pp" name="jykgl_name" htmlEscape="false" id="ymjdxpyy_pp" value="${data.ymjdxpyy.ymjdxpyy_pp }"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_xh" name="jykgl_name" htmlEscape="false"  id="ymjdxpyy_xh" value="${data.ymjdxpyy.ymjdxpyy_xh }"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_sl"  name="jykgl_name" htmlEscape="false"  id="ymjdxpyy_sl"  value="${data.ymjdxpyy.ymjdxpyy_sl }"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_sbjg" name="jykgl_name" htmlEscape="false"   id="ymjdxpyy_sbjg"  value="${data.ymjdxpyy.ymjdxpyy_sbjg }"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_trsynf" name="jykgl_name" htmlEscape="false"  id="ymjdxpyy_trsynf"  value="${data.ymjdxpyy.ymjdxpyy_trsynf }"   class="form-control "/>
					<input type = "hidden" htmlEscape="false" id="ymjdxpyy_id"  name="jykgl_name" value="${data.ymjdxpyy.ymjdxpyy_id}"  class="form-control "/>
					</td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="jyk_sbmc" name="jykgl_name" htmlEscape="false" readOnly="true" id="nczfxy_sbmc"  value="尿沉渣分析仪"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_pp" name="jykgl_name" htmlEscape="false"  id="nczfxy_pp" value="${data.nczfxy.nczfxy_pp }"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_xh" name="jykgl_name" htmlEscape="false"  id="nczfxy_xh" value="${data.nczfxy.nczfxy_xh }"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_sl"  name="jykgl_name" htmlEscape="false"  id="nczfxy_sl"  value="${data.nczfxy.nczfxy_sl }"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_sbjg" name="jykgl_name" htmlEscape="false"  id="nczfxy_sbjg"  value="${data.nczfxy.nczfxy_sbjg }"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_trsynf" name="jykgl_name" htmlEscape="false"  id="nczfxy_trsynf"  value="${data.nczfxy.nczfxy_trsynf }"   class="form-control "/>
					<input type = "hidden" htmlEscape="false" id="nczfxy_id"  name="jykgl_name" value="${data.nczfxy.nczfxy_id}"  class="form-control "/>
					</td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="jyk_sbmc" name="jykgl_name" id="pcry_sbmc" readOnly="true" htmlEscape="false"  value="PCR仪"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_pp" name="jykgl_name"  id="pcry_pp" value="${data.pcry.pcry_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_xh" name="jykgl_name"  id="pcry_xh" value="${data.pcry.pcry_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_sl"  name="jykgl_name"   id="pcry_sl" value="${data.pcry.pcry_sl }"  id="pcry_sbmc"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_sbjg" name="jykgl_name"  id="pcry_sbjg" value="${data.pcry.pcry_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_trsynf" name="jykgl_name"  id="pcry_trsynf" value="${data.pcry.pcry_trsynf }"  htmlEscape="false"    class="form-control "/>
					<input type = "hidden" htmlEscape="false" id="pcry_id"  name="jykgl_name" value="${data.pcry.pcry_id}"  class="form-control "/>
					</td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="jyk_sbmc" name="jykgl_name" id="eyhtpyx_sbmc" readOnly="true" htmlEscape="false"  value="二氧化碳培养箱"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_pp" name="jykgl_name" id="eyhtpyx_pp" value="${data.eyhtpyx.eyhtpyx_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_xh" name="jykgl_name" id="eyhtpyx_xh" value="${data.eyhtpyx.eyhtpyx_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_sl"  name="jykgl_name" id="eyhtpyx_sl" value="${data.eyhtpyx.eyhtpyx_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_sbjg" name="jykgl_name" id="eyhtpyx_sbjg" value="${data.eyhtpyx.eyhtpyx_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_trsynf" name="jykgl_name" id="eyhtpyx_trsynf" value="${data.eyhtpyx.eyhtpyx_trsynf }" htmlEscape="false"    class="form-control "/>
					<input type = "hidden" htmlEscape="false" id="eyhtpyx_id"  name="jykgl_name" value="${data.eyhtpyx.eyhtpyx_id}"  class="form-control "/>
					</td>
					
				</tr>
				
				
				
				
				
				
				
				<tr>
					<td class="width-15">
						<input path="jyk_sbmc" name="jykgl_name" htmlEscape="false" readOnly="true" id="mbfxy_sbmc"  value="酶标分析仪"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_pp" name="jykgl_name" htmlEscape="false"  id="mbfxy_pp"  value="${data.mbfxy.mbfxy_pp }"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_xh" name="jykgl_name" htmlEscape="false"   id="mbfxy_xh"  value="${data.mbfxy.mbfxy_xh }"   class="form-control "/>
					</td>
					
					<td class="width-15"> 
						<input path="jyk_sl"  name="jykgl_name" htmlEscape="false"  id="mbfxy_sl"   value="${data.mbfxy.mbfxy_sl }"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_sbjg" name="jykgl_name" htmlEscape="false" id="mbfxy_sbjg"   value="${data.mbfxy.mbfxy_sbjg }"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_trsynf" name="jykgl_name" htmlEscape="false" id="mbfxy_trsynf"    value="${data.mbfxy.mbfxy_trsynf }"   class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="mbfxy_id"  name="jykgl_name" value="${data.mbfxy.mbfxy_id}"  class="form-control "/>
				
				
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="jyk_sbmc" name="jykgl_name" id="xbj_sbmc" readOnly="true" htmlEscape="false"  value="洗板机"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_pp" name="jykgl_name" id="xbj_pp" value="${data.xbj.xbj_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_xh" name="jykgl_name" id="xbj_xh" value="${data.xbj.xbj_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_sl"  name="jykgl_name" id="xbj_sl" value="${data.xbj.xbj_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_sbjg" name="jykgl_name" id="xbj_sbjg" value="${data.xbj.xbj_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_trsynf" name="jykgl_name" id="xbj_trsynf" value="${data.xbj.xbj_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="xbj_id"  name="jykgl_name" value="${data.xbj.xbj_id}"  class="form-control "/>
					
					</td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="jyk_sbmc" name="jykgl_name" id="cmcfydbfxy_sbmc" readOnly="true" htmlEscape="false"  value="超敏C反应蛋白分析仪"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_pp" name="jykgl_name"  id="cmcfydbfxy_pp" value="${data.cmcfydbfxy.cmcfydbfxy_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_xh" name="jykgl_name"  id="cmcfydbfxy_xh" value="${data.cmcfydbfxy.cmcfydbfxy_xh }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_sl"  name="jykgl_name"  id="cmcfydbfxy_sl" value="${data.cmcfydbfxy.cmcfydbfxy_sl }"   htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_sbjg" name="jykgl_name"   id="cmcfydbfxy_sbjg" value="${data.cmcfydbfxy.cmcfydbfxy_sbjg }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_trsynf" name="jykgl_name"  id="cmcfydbfxy_trsynf"  value="${data.cmcfydbfxy.cmcfydbfxy_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="cmcfydbfxy_id"  name="jykgl_name" value="${data.cmcfydbfxy.cmcfydbfxy_id}"  class="form-control "/>
					
					
					</td>
					
				</tr>
				
				<tr>
					<td class="width-15">
						<input path="jyk_sbmc" name="jykgl_name" id="thxhdbfxy_sbmc" readOnly="true" htmlEscape="false"  value="糖化血红蛋白分析仪"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_pp" name="jykgl_name" id="thxhdbfxy_pp" value="${data.thxhdbfxy.thxhdbfxy_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_xh" name="jykgl_name" id="thxhdbfxy_xh" value="${data.thxhdbfxy.thxhdbfxy_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_sl"  name="jykgl_name" id="thxhdbfxy_sl" value="${data.thxhdbfxy.thxhdbfxy_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_sbjg" name="jykgl_name" id="thxhdbfxy_sbjg" value="${data.thxhdbfxy.thxhdbfxy_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_trsynf" name="jykgl_name" id="thxhdbfxy_trsynf" value="${data.thxhdbfxy.thxhdbfxy_trsynf }"  htmlEscape="false"    class="form-control "/>
				
						<input type = "hidden" htmlEscape="false" id="thxhdbfxy_id"  name="jykgl_name" value="${data.thxhdbfxy.thxhdbfxy_id}"  class="form-control "/>
				
					</td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="jyk_sbmc"  name="jykgl_name" id="dwbx_sbmc" readOnly="true" htmlEscape="false"  value="低温冰箱"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_pp" name="jykgl_name" id="dwbx_pp" value="${data.dwbx.dwbx_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_xh" name="jykgl_name" id="dwbx_xh" value="${data.dwbx.dwbx_xh }"    htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_sl"  name="jykgl_name" id="dwbx_sl" value="${data.dwbx.dwbx_sl }"    htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_sbjg" name="jykgl_name" id="dwbx_sbjg" value="${data.dwbx.dwbx_sbjg }"    htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_trsynf" name="jykgl_name" id="dwbx_trsynf" value="${data.dwbx.dwbx_trsynf }"    htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="dwbx_id"  name="jykgl_name" value="${data.dwbx.dwbx_id}"  class="form-control "/>
					
					</td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="jyk_sbmc" name="jykgl_name" id="nyfxy_sbmc" readOnly="true" htmlEscape="false"  value="尿液分析仪"  class="form-control "/>
					</td>
				<td class="width-15">
						<input path="jyk_pp" name="jykgl_name" id="nyfxy_pp" value="${data.nyfxy.nyfxy_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_xh" name="jykgl_name" id="nyfxy_xh" value="${data.nyfxy.nyfxy_xh }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_sl"  name="jykgl_name" id="nyfxy_sl" value="${data.nyfxy.nyfxy_sl }"   htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_sbjg" name="jykgl_name" id="nyfxy_sbjg" value="${data.nyfxy.nyfxy_sbjg }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_trsynf" name="jykgl_name" id="nyfxy_trsynf"  value="${data.nyfxy.nyfxy_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="nyfxy_id"  name="jykgl_name" value="${data.nyfxy.nyfxy_id}"  class="form-control "/>
				
					</td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="jyk_sbmc" name="jykgl_name" id="swxwj_sbmc" readOnly="true" htmlEscape="false"  value="生物显微镜"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_pp" name="jykgl_name" id="swxwj_pp" value="${data.swxwj.swxwj_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_xh" name="jykgl_name" id="swxwj_xh" value="${data.swxwj.swxwj_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_sl"  name="jykgl_name" id="swxwj_sl" value="${data.swxwj.swxwj_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_sbjg" name="jykgl_name" id="swxwj_sbjg" value="${data.swxwj.swxwj_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_trsynf" name="jykgl_name" id="swxwj_trsynf" value="${data.swxwj.swxwj_trsynf }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="swxwj_id"  name="jykgl_name" value="${data.swxwj.swxwj_id}"  class="form-control "/>
			
					</td>
					
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="jyk_sbmc" name="jykgl_name" id="swaqg_sbmc" readOnly="true" htmlEscape="false"  value="生物安全柜"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_pp" name="jykgl_name" id="swaqg_pp" value="${data.swaqg.swaqg_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_xh" name="jykgl_name" id="swaqg_xh" value="${data.swaqg.swaqg_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_sl"  name="jykgl_name" id="swaqg_sl" value="${data.swaqg.swaqg_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_sbjg" name="jykgl_name" id="swaqg_sbjg" value="${data.swaqg.swaqg_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_trsynf" name="jykgl_name" id="swaqg_trsynf"  value="${data.swaqg.swaqg_trsynf }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="swaqg_id"  name="jykgl_name" value="${data.swaqg.swaqg_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="jyk_sbmc" name="jykgl_name" id="styz_sbmc" readOnly="true" htmlEscape="false"  value="渗透压计"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_pp" name="jykgl_name" id="styz_pp" value="${data.styz.styz_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_xh" name="jykgl_name" id="styz_xh" value="${data.styz.styz_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_sl" name="jykgl_name" id="styz_sl" value="${data.styz.styz_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_sbjg" name="jykgl_name" id="styz_sbjg" value="${data.styz.styz_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_trsynf" name="jykgl_name" id="styz_trsynf" value="${data.styz.styz_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="styz_id"  name="jykgl_name" value="${data.styz.styz_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15"> 
						<input path="jyk_sbmc" name="jykgl_name" id="lxj_sbmc" readOnly="true"  htmlEscape="false"  value="离心机"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_pp" name="jykgl_name" id="lxj_pp" value="${data.lxj.lxj_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_xh" name="jykgl_name" id="lxj_xh"  value="${data.lxj.lxj_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_sl" name="jykgl_name" id="lxj_sl"  value="${data.lxj.lxj_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_sbjg" name="jykgl_name" id="lxj_sbjg" value="${data.lxj.lxj_sbjg }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_trsynf" name="jykgl_name" id="lxj_trsynf"  value="${data.lxj.lxj_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="lxj_id"  name="jykgl_name" value="${data.lxj.lxj_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="jyk_sbmc" name="jykgl_name" id="xkbx_sbmc" readOnly="true" htmlEscape="false"  value="血库冰箱"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_pp" name="jykgl_name" id="xkbx_pp" value="${data.xkbx.xkbx_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_xh" name="jykgl_name" id="xkbx_xh" value="${data.xkbx.xkbx_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_sl" name="jykgl_name" id="xkbx_sl" value="${data.xkbx.xkbx_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_sbjg" name="jykgl_name" id="xkbx_sbjg" value="${data.xkbx.xkbx_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_trsynf" name="jykgl_name" id="xkbx_trsynf" value="${data.xkbx.xkbx_trsynf }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="xkbx_id"  name="jykgl_name" value="${data.xkbx.xkbx_id}"  class="form-control "/>
				
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="jyk_sbmc" name="jykgl_name" id="ztxyhsxt_sbmc" readOnly="true" htmlEscape="false"  value="自体血液回输系统"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_pp" name="jykgl_name" id="ztxyhsxt_pp" value="${data.ztxyhsxt.ztxyhsxt_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_xh" name="jykgl_name" id="ztxyhsxt_xh"  value="${data.ztxyhsxt.ztxyhsxt_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_sl" name="jykgl_name" id="ztxyhsxt_sl" value="${data.ztxyhsxt.ztxyhsxt_sl }"   htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_sbjg" name="jykgl_name" id="ztxyhsxt_sbjg" value="${data.ztxyhsxt.ztxyhsxt_sbjg }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_trsynf" name="jykgl_name" id="ztxyhsxt_trsynf" value="${data.ztxyhsxt.ztxyhsxt_trsynf }"   htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="ztxyhsxt_id"  name="jykgl_name" value="${data.ztxyhsxt.ztxyhsxt_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="jyk_sbmc" name="jykgl_name" id="xyfzy_sbmc" readOnly="true" htmlEscape="false"  value="血液辐照仪"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_pp" name="jykgl_name"  id="xyfzy_pp" value="${data.xyfzy.xyfzy_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_xh" name="jykgl_name"  id="xyfzy_xh" value="${data.xyfzy.xyfzy_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_sl" name="jykgl_name"  id="xyfzy_sl" value="${data.xyfzy.xyfzy_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_sbjg" name="jykgl_name"  id="xyfzy_sbjg" value="${data.xyfzy.xyfzy_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_trsynf" name="jykgl_name"  id="xyfzy_trsynf"  value="${data.xyfzy.xyfzy_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="xyfzy_id"  name="jykgl_name" value="${data.xyfzy.xyfzy_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="jyk_sbmc" id="bdmhsb_sbmc" name="jykgl_name" readOnly="true" htmlEscape="false"  value="病毒灭活设备"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_pp" id="bdmhsb_pp" value="${data.bdmhsb.bdmhsb_pp }" name="jykgl_name" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_xh" id="bdmhsb_xh" value="${data.bdmhsb.bdmhsb_xh }" name="jykgl_name" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_sl" id="bdmhsb_sl" value="${data.bdmhsb.bdmhsb_sl }" name="jykgl_name" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_sbjg" id="bdmhsb_sbjg" value="${data.bdmhsb.bdmhsb_sbjg }" name="jykgl_name" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_trsynf" id="bdmhsb_trsynf" value="${data.bdmhsb.bdmhsb_trsynf }" name="jykgl_name" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="bdmhsb_id"  name="jykgl_name" value="${data.bdmhsb.bdmhsb_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="jyk_sbmc" id="xyrhx_sbmc"  name="jykgl_name" readOnly="true" htmlEscape="false"  value="血液融化箱"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_pp" id="xyrhx_pp" value="${data.xyrhx.xyrhx_pp }"  name="jykgl_name"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_xh" id="xyrhx_xh" value="${data.xyrhx.xyrhx_xh }" name="jykgl_name" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_sl" id="xyrhx_sl" value="${data.xyrhx.xyrhx_sl }" name="jykgl_name" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_sbjg" id="xyrhx_sbjg" value="${data.xyrhx.xyrhx_sbjg }" name="jykgl_name" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_trsynf" id="xyrhx_trsynf" value="${data.xyrhx.xyrhx_trsynf }" name="jykgl_name" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="xyrhx_id"  name="jykgl_name" value="${data.xyrhx.xyrhx_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				
				<tr>
					<td class="width-15">
						<input path="jyk_sbmc" name="jykgl_name" id="qtqzm_sbmc" readOnly="true" htmlEscape="false"  value="其它（请注明）"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_pp" name="jykgl_name" id="qtqzm_pp" value="${data.qtqzm.qtqzm_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_xh" name="jykgl_name" id="qtqzm_xh" value="${data.qtqzm.qtqzm_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_sl" name="jykgl_name" id="qtqzm_sl" value="${data.qtqzm.qtqzm_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jyk_sbjg" name="jykgl_name" id="qtqzm_sbjg" value="${data.qtqzm.qtqzm_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jyk_trsynf" name="jykgl_name" id="qtqzm_trsynf" value="${data.qtqzm.qtqzm_trsynf }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="qtqzm_id"  name="jykgl_name" value="${data.qtqzm.qtqzm_id}"  class="form-control "/>
					
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
		
		var data = document.getElementsByName("jykgl_name");
	
		var datas="";
		
		
		for(i=0;i<data.length;i++){
			if(data[i].value==null||data[i].value==""){
				datas = datas +data[i].id+": ---- ;";	
			}else{
				datas = datas +data[i].id+":"+data[i].value+";";	
			}
			
			
		}
	 	
		 $.ajax({
		      url:"${ctx}/ironfoyjbylsbpzjyk/ironfoyjbylsbpzjyk/save",
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