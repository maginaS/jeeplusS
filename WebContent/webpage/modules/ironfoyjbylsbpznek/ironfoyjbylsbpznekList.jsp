<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>内（儿）科管理</title>
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
		<form id="inputForm" modelAttribute="ironfoyjbylsbpznek" action="${ctx}/ironfoyjbylsbpznek/ironfoyjbylsbpznek/save" method="post" class="form-horizontal">
		<%-- <form:hidden path="id"/>
		<sys:message content="${message}"/>	 --%>
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				
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
						<input path="nek_sbmc" readOnly="true"  name="nek_name" id="dzzqgxt_sbmc" htmlEscape="false" value="电子支气管系统"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp"  name="nek_name" id="dzzqgxt_pp" value="${data.dzzqgxt.dzzqgxt_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh"  name="nek_name" id="dzzqgxt_xh" value="${data.dzzqgxt.dzzqgxt_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sl"  name="nek_name" id="dzzqgxt_sl" value="${data.dzzqgxt.dzzqgxt_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sbjg"  name="nek_name" id="dzzqgxt_sbjg" value="${data.dzzqgxt.dzzqgxt_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="trsynf"  name="nek_name" id="dzzqgxt_trsynf"  value="${data.dzzqgxt.dzzqgxt_trsynf }" htmlEscape="false"    class="form-control "/>
					    <input type = "hidden" htmlEscape="false" id="dzzqgxt_id"  name="nek_name" value="${data.dzzqgxt.dzzqgxt_id}"  class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="docId"   name="nek_name" value="${data.doc_id}"  class="form-control "/>
					
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="nek_sbmc" readOnly="true"  name="nek_name" id="fgny_sbmc" htmlEscape="false" value="肺功能仪"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp"  name="nek_name" id="fgny_pp" value="${data.fgny.fgny_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh"  name="nek_name" id="fgny_xh" value="${data.fgny.fgny_xh }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sl"  name="nek_name" id="fgny_sl"  value="${data.fgny.fgny_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sbjg"  name="nek_name" id="fgny_sbjg" value="${data.fgny.fgny_sbjg }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="trsynf"  name="nek_name" id="fgny_trsynf"  value="${data.fgny.fgny_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="fgny_id"  name="nek_name" value="${data.fgny.fgny_id}"  class="form-control "/>
					
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="nek_sbmc" readOnly="true"   name="nek_name" id="smhxjhy_sbmc" htmlEscape="false" value="睡眠呼吸监护仪"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp"  name="nek_name" id="smhxjhy_pp" value="${data.smhxjhy.smhxjhy_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh"  name="nek_name" id="smhxjhy_xh" value="${data.smhxjhy.smhxjhy_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sl"  name="nek_name" id="smhxjhy_sl" value="${data.smhxjhy.smhxjhy_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sbjg"  name="nek_name" id="smhxjhy_sbjg" value="${data.smhxjhy.smhxjhy_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="trsynf"  name="nek_name" id="smhxjhy_trsynf" value="${data.smhxjhy.smhxjhy_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="smhxjhy_id"  name="nek_name" value="${data.smhxjhy.smhxjhy_id}"  class="form-control "/>
					
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="nek_sbmc"  readOnly="true"  name="nek_name" id="ychxj_sbmc" htmlEscape="false" value="有创呼吸机"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp"  name="nek_name" id="ychxj_pp" value="${data.ychxj.ychxj_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh"  name="nek_name" id="ychxj_xh"  value="${data.ychxj.ychxj_xh }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sl"  name="nek_name" id="ychxj_sl"  value="${data.ychxj.ychxj_sl }"   htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sbjg"  name="nek_name" id="ychxj_sbjg"  value="${data.ychxj.ychxj_sbjg }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="trsynf"  name="nek_name" id="ychxj_trsynf"  value="${data.ychxj.ychxj_trsynf }"   htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="ychxj_id"  name="nek_name" value="${data.ychxj.ychxj_id}"  class="form-control "/>
					
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="nek_sbmc" readOnly="true"   name="nek_name" id="wchxj_sbmc" htmlEscape="false" value="无创呼吸机"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp"  name="nek_name" id="wchxj_pp"  value="${data.wchxj.wchxj_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh"  name="nek_name" id="wchxj_xh"  value="${data.wchxj.wchxj_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sl"  name="nek_name" id="wchxj_sl"  value="${data.wchxj.wchxj_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sbjg"  name="nek_name" id="wchxj_sbjg"  value="${data.wchxj.wchxj_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="trsynf"  name="nek_name" id="wchxj_trsynf"  value="${data.wchxj.wchxj_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="wchxj_id"  name="nek_name" value="${data.wchxj.wchxj_id}"  class="form-control "/>
					
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="nek_sbmc" readOnly="true"   name="nek_name" id="qwzqgj_sbmc" htmlEscape="false" value="纤维支气管镜"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp"  name="nek_name" id="qwzqgj_pp"  value="${data.qwzqgj.qwzqgj_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh"  name="nek_name" id="qwzqgj_xh" value="${data.qwzqgj.qwzqgj_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sl"  name="nek_name" id="qwzqgj_sl" value="${data.qwzqgj.qwzqgj_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sbjg"  name="nek_name" id="qwzqgj_sbjg" value="${data.qwzqgj.qwzqgj_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="trsynf"  name="nek_name" id="qwzqgj_trsynf" value="${data.qwzqgj.qwzqgj_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="qwzqgj_id"  name="nek_name" value="${data.qwzqgj.qwzqgj_id}"  class="form-control "/>
					
					
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="nek_sbmc"  readOnly="true"  name="nek_name" id="zdptj_sbmc" htmlEscape="false" value="振动排痰机"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp"  name="nek_name" id="zdptj_pp" value="${data.zdptj.zdptj_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh"  name="nek_name" id="zdptj_xh"  value="${data.zdptj.zdptj_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sl"  name="nek_name" id="zdptj_sl"  value="${data.zdptj.zdptj_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sbjg"  name="nek_name" id="zdptj_sbjg" value="${data.zdptj.zdptj_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="trsynf"  name="nek_name" id="zdptj_trsynf" value="${data.zdptj.zdptj_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="zdptj_id"  name="nek_name" value="${data.zdptj.zdptj_id}"  class="form-control "/>
					
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="nek_sbmc" readOnly="true"   name="nek_name" id="hxshzly_sbmc" htmlEscape="false" value="呼吸湿化治疗仪"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp"  name="nek_name" id="hxshzly_pp" value="${data.hxshzly.hxshzly_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh"  name="nek_name" id="hxshzly_xh" value="${data.hxshzly.hxshzly_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sl"  name="nek_name" id="hxshzly_sl" value="${data.hxshzly.hxshzly_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sbjg"  name="nek_name" id="hxshzly_sbjg"  value="${data.hxshzly.hxshzly_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="trsynf"  name="nek_name" id="hxshzly_trsynf" value="${data.hxshzly.hxshzly_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="hxshzly_id"  name="nek_name" value="${data.hxshzly.hxshzly_id}"  class="form-control "/>
				
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="nek_sbmc"  readOnly="true"  name="nek_name" id="whq_sbmc" htmlEscape="false" value="雾化器"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp"  name="nek_name" id="whq_pp" value="${data.whq.whq_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh"  name="nek_name" id="whq_xh"  value="${data.whq.whq_xh }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sl"  name="nek_name" id="whq_sl"  value="${data.whq.whq_sl }"   htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sbjg"  name="nek_name" id="whq_sbjg"  value="${data.whq.whq_sbjg }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="trsynf"  name="nek_name" id="whq_trsynf"  value="${data.whq.whq_trsynf }"   htmlEscape="false"    class="form-control "/>
					    <input type = "hidden" htmlEscape="false" id="whq_id"  name="nek_name" value="${data.whq.whq_id}"  class="form-control "/>
					
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="nek_sbmc" readOnly="true"   name="nek_name" id="xldpljcy_sbmc" htmlEscape="false" value="血流多普勒检测仪"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp"  name="nek_name" id="xldpljcy_pp" value="${data.xldpljcy.xldpljcy_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh"  name="nek_name" id="xldpljcy_xh"  value="${data.xldpljcy.xldpljcy_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sl"  name="nek_name" id="xldpljcy_sl"  value="${data.xldpljcy.xldpljcy_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sbjg"  name="nek_name" id="xldpljcy_sbjg"  value="${data.xldpljcy.xldpljcy_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="trsynf"  name="nek_name" id="xldpljcy_trsynf"  value="${data.xldpljcy.xldpljcy_trsynf }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="xldpljcy_id"  name="nek_name" value="${data.xldpljcy.xldpljcy_id}"  class="form-control "/>
					
					
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="nek_sbmc" readOnly="true"   name="nek_name" id ="ydsb_sbmc" htmlEscape="false" value="胰岛素泵"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp"  name="nek_name" id="ydsb_pp" value="${data.ydsb.ydsb_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh"  name="nek_name" id="ydsb_xh" value="${data.ydsb.ydsb_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sl"  name="nek_name" id="ydsb_sl" value="${data.ydsb.ydsb_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sbjg"  name="nek_name" id="ydsb_sbjg" value="${data.ydsb.ydsb_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="trsynf"  name="nek_name" id="ydsb_trsynf" value="${data.ydsb.ydsb_trsynf }"  htmlEscape="false"    class="form-control "/>
					    <input type = "hidden" htmlEscape="false" id="ydsb_id"  name="nek_name" value="${data.ydsb.ydsb_id}"  class="form-control "/>
					
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="nek_sbmc" readOnly="true"   name="nek_name" id="xtfxy_sbmc" htmlEscape="false" value="血糖分析仪"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp"  name="nek_name" id="xtfxy_pp" value="${data.xtfxy.xtfxy_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh"  name="nek_name" id="xtfxy_xh"   value="${data.xtfxy.xtfxy_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sl"  name="nek_name" id="xtfxy_sl"   value="${data.xtfxy.xtfxy_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sbjg"  name="nek_name" id="xtfxy_sbjg"   value="${data.xtfxy.xtfxy_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="trsynf"  name="nek_name" id="xtfxy_trsynf"   value="${data.xtfxy.xtfxy_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="xtfxy_id"  name="nek_name" value="${data.xtfxy.xtfxy_id}"  class="form-control "/>
					
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="nek_sbmc" readOnly="true"   name="nek_name" id="dznjxt_sbmc" htmlEscape="false" value="电子内镜系统"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp"  name="nek_name" id="dznjxt_pp"  value="${data.dznjxt.dznjxt_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh"  name="nek_name" id="dznjxt_xh"  value="${data.dznjxt.dznjxt_xh }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sl"  name="nek_name" id="dznjxt_sl"  value="${data.dznjxt.dznjxt_sl }"   htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sbjg"  name="nek_name" id="dznjxt_sbjg"  value="${data.dznjxt.dznjxt_sbjg }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="trsynf"  name="nek_name" id="dznjxt_trsynf"  value="${data.dznjxt.dznjxt_trsynf }"   htmlEscape="false"    class="form-control "/>
					    <input type = "hidden" htmlEscape="false" id="dznjxt_id"  name="nek_name" value="${data.dznjxt.dznjxt_id}"  class="form-control "/>
				
				
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="nek_sbmc" readOnly="true"   name="nek_name" id="ydpb_sbmc" htmlEscape="false" value="运动平板"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp"  name="nek_name" id="ydpb_pp" value="${data.ydpb.ydpb_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh"  name="nek_name" id="ydpb_xh" value="${data.ydpb.ydpb_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sl"  name="nek_name" id="ydpb_sl"  value="${data.ydpb.ydpb_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sbjg"  name="nek_name" id="ydpb_sbjg"  value="${data.ydpb.ydpb_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="trsynf"  name="nek_name" id="ydpb_trsynf"  value="${data.ydpb.ydpb_trsynf }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="ydpb_id"  name="nek_name" value="${data.ydpb.ydpb_id}"  class="form-control "/>
					
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="nek_sbmc"  readOnly="true"   name="nek_name" id="dtxdtj_sbmc" htmlEscape="false" value="动态心电图机"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp"  name="nek_name" id="dtxdtj_pp" value="${data.dtxdtj.dtxdtj_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh"  name="nek_name" id="dtxdtj_xh" value="${data.dtxdtj.dtxdtj_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sl"  name="nek_name" id="dtxdtj_sl" value="${data.dtxdtj.dtxdtj_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sbjg"  name="nek_name" id="dtxdtj_sbjg" value="${data.dtxdtj.dtxdtj_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="trsynf"  name="nek_name" id="dtxdtj_trsynf" value="${data.dtxdtj.dtxdtj_trsynf }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="dtxdtj_id"  name="nek_name" value="${data.dtxdtj.dtxdtj_id}"  class="form-control "/>
					
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="nek_sbmc" readOnly="true"   name="nek_name" id="dtxyjcy_sbmc" htmlEscape="false" value="动态血压监测仪"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp"  name="nek_name" id="dtxyjcy_pp" value="${data.dtxyjcy.dtxyjcy_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh"  name="nek_name" id="dtxyjcy_xh"   value="${data.dtxyjcy.dtxyjcy_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sl"  name="nek_name" id="dtxyjcy_sl"  value="${data.dtxyjcy.dtxyjcy_sl }"   htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sbjg"  name="nek_name" id="dtxyjcy_sbjg"  value="${data.dtxyjcy.dtxyjcy_sbjg }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="trsynf"  name="nek_name" id="dtxyjcy_trsynf"   value="${data.dtxyjcy.dtxyjcy_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="dtxyjcy_id"  name="nek_name" value="${data.dtxyjcy.dtxyjcy_id}"  class="form-control "/>
					
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="nek_sbmc" readOnly="true"   name="nek_name" id="ccy_sbmc" htmlEscape="false" value="除颤仪"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp"  name="nek_name" id="ccy_pp" value="${data.ccy.ccy_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh"  name="nek_name" id="ccy_xh" value="${data.ccy.ccy_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sl"  name="nek_name" id="ccy_sl" value="${data.ccy.ccy_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sbjg"  name="nek_name" id="ccy_sbjg" value="${data.ccy.ccy_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="trsynf"  name="nek_name" id="ccy_trsynf"  value="${data.ccy.ccy_trsynf }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="ccy_id"  name="nek_name" value="${data.ccy.ccy_id}"  class="form-control "/>
					
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="nek_sbmc"  readOnly="true"  name="nek_name" id="lsqbq_sbmc" htmlEscape="false" value="临时起搏器"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp"  name="nek_name" id="lsqbq_pp" value="${data.lsqbq.lsqbq_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh"  name="nek_name" id="lsqbq_xh" value="${data.lsqbq.lsqbq_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sl"  name="nek_name" id="lsqbq_sl" value="${data.lsqbq.lsqbq_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sbjg"  name="nek_name" id="lsqbq_sbjg" value="${data.lsqbq.lsqbq_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="trsynf"  name="nek_name" id="lsqbq_trsynf" value="${data.lsqbq.lsqbq_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="lsqbq_id"  name="nek_name" value="${data.lsqbq.lsqbq_id}"  class="form-control "/>
					
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="nek_sbmc" readOnly="true"   name="nek_name" id="spndjcxt_sbmc" htmlEscape="false" value="视频脑电监测系统"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp"  name="nek_name" id="spndjcxt_pp" value="${data.spndjcxt.spndjcxt_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh"  name="nek_name" id="spndjcxt_xh" value="${data.spndjcxt.spndjcxt_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sl"  name="nek_name" id="spndjcxt_sl" value="${data.spndjcxt.spndjcxt_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sbjg"  name="nek_name" id="spndjcxt_sbjg" value="${data.spndjcxt.spndjcxt_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="trsynf"  name="nek_name" id="spndjcxt_trsynf"  value="${data.spndjcxt.spndjcxt_trsynf }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="spndjcxt_id"  name="nek_name" value="${data.spndjcxt.spndjcxt_id}"  class="form-control "/>
				
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="nek_sbmc" readOnly="true"   name="nek_name" id="yfdwy_sbmc" htmlEscape="false" value="诱发电位仪"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp"  name="nek_name" id="yfdwy_pp" value="${data.yfdwy.yfdwy_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh"  name="nek_name" id="yfdwy_xh"  value="${data.yfdwy.yfdwy_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sl"  name="nek_name" id="yfdwy_sl" value="${data.yfdwy.yfdwy_sl }"   htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sbjg"  name="nek_name" id="yfdwy_sbjg"  value="${data.yfdwy.yfdwy_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="trsynf"  name="nek_name" id="yfdwy_trsynf"  value="${data.yfdwy.yfdwy_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="yfdwy_id"  name="nek_name" value="${data.yfdwy.yfdwy_id}"  class="form-control "/>
					
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="nek_sbmc" readOnly="true"   name="nek_name" id="jldpl_sbmc" htmlEscape="false" value="经颅多普勒"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp"  name="nek_name" id="jldpl_pp" value="${data.jldpl.jldpl_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh"  name="nek_name" id="jldpl_xh" value="${data.jldpl.jldpl_xh }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sl"  name="nek_name" id="jldpl_sl" value="${data.jldpl.jldpl_sl }"   htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sbjg"  name="nek_name" id="jldpl_sbjg" value="${data.jldpl.jldpl_sbjg }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="trsynf"  name="nek_name" id="jldpl_trsynf" value="${data.jldpl.jldpl_trsynf }"   htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="jldpl_id"  name="nek_name" value="${data.jldpl.jldpl_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="nek_sbmc" readOnly="true"   name="nek_name" id="xytxj_sbmc" htmlEscape="false" value="血液透析机"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp"  name="nek_name" id="xytxj_pp" value="${data.xytxj.xytxj_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh"  name="nek_name" id="xytxj_xh"  value="${data.xytxj.xytxj_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sl"  name="nek_name" id="xytxj_sl"  value="${data.xytxj.xytxj_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sbjg"  name="nek_name" id="xytxj_sbjg" value="${data.xytxj.xytxj_sbjg }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="trsynf"  name="nek_name" id="xytxj_trsynf" value="${data.xytxj.xytxj_trsynf }"   htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="xytxj_id"  name="nek_name" value="${data.xytxj.xytxj_id}"  class="form-control "/>
					
					</td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="nek_sbmc"  readOnly="true"  name="nek_name" id="xlj_sbmc" htmlEscape="false" value="血滤机"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp"  name="nek_name" id="xlj_pp" value="${data.xlj.xlj_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh"  name="nek_name" id="xlj_xh"  value="${data.xlj.xlj_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sl"  name="nek_name" id="xlj_sl" value="${data.xlj.xlj_sl }"   htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sbjg"  name="nek_name" id="xlj_sbjg" value="${data.xlj.xlj_sbjg }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="trsynf"  name="nek_name" id="xlj_trsynf" value="${data.xlj.xlj_trsynf }"   htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="xlj_id"  name="nek_name" value="${data.xlj.xlj_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="nek_sbmc" readOnly="true"   name="nek_name" id="zdfmtxj_sbmc" htmlEscape="false" value="自动腹膜透析机"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp"  name="nek_name" id="zdfmtxj_pp" value="${data.zdfmtxj.zdfmtxj_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh"  name="nek_name" id="zdfmtxj_xh" value="${data.zdfmtxj.zdfmtxj_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sl"  name="nek_name" id="zdfmtxj_sl" value="${data.zdfmtxj.zdfmtxj_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sbjg"  name="nek_name" id="zdfmtxj_sbjg" value="${data.zdfmtxj.zdfmtxj_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="trsynf"  name="nek_name" id="zdfmtxj_trsynf" value="${data.zdfmtxj.zdfmtxj_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="zdfmtxj_id"  name="nek_name" value="${data.zdfmtxj.zdfmtxj_id}"  class="form-control "/>
					
					</td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="nek_sbmc" readOnly="true"   name="nek_name" id="sclzz_sbmc" htmlEscape="false" value="水处理装置"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp"  name="nek_name" id="sclzz_pp" value="${data.sclzz.sclzz_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh"  name="nek_name" id="sclzz_xh"  value="${data.sclzz.sclzz_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sl"  name="nek_name" id="sclzz_sl" value="${data.sclzz.sclzz_sl }"   htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sbjg"  name="nek_name" id="sclzz_sbjg" value="${data.sclzz.sclzz_sbjg }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="trsynf"  name="nek_name" id="sclzz_trsynf"  value="${data.sclzz.sclzz_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="sclzz_id"  name="nek_name" value="${data.sclzz.sclzz_id}"  class="form-control "/>
					
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="nek_sbmc" readOnly="true"   name="nek_name" id="clc_sbmc" htmlEscape="false" value="层流床"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp"  name="nek_name" id="clc_pp" value="${data.clc.clc_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh"  name="nek_name" id="clc_xh" value="${data.clc.clc_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sl"  name="nek_name" id="clc_sl" value="${data.clc.clc_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sbjg"  name="nek_name" id="clc_sbjg" value="${data.clc.clc_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="trsynf"  name="nek_name" id="clc_trsynf" value="${data.clc.clc_trsynf }"  htmlEscape="false"    class="form-control "/>
					    <input type = "hidden" htmlEscape="false" id="clc_id"  name="nek_name" value="${data.clc.clc_id}"  class="form-control "/>
					
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="nek_sbmc" readOnly="true"   name="nek_name" id="zsb_sbmc" htmlEscape="false" value="注射泵"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp"  name="nek_name" id="zsb_pp"  value="${data.zsb.zsb_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh"  name="nek_name" id="zsb_xh"  value="${data.zsb.zsb_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sl"  name="nek_name" id="zsb_sl"  value="${data.zsb.zsb_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sbjg"  name="nek_name" id="zsb_sbjg"  value="${data.zsb.zsb_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="trsynf"  name="nek_name" id="zsb_trsynf" value="${data.zsb.zsb_trsynf }"  htmlEscape="false"    class="form-control "/>
					    <input type = "hidden" htmlEscape="false" id="zsb_id"  name="nek_name" value="${data.zsb.zsb_id}"  class="form-control "/>
					
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="nek_sbmc" readOnly="true"   name="nek_name" id="syb_sbmc" htmlEscape="false" value="输液泵"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp"  name="nek_name" id="syb_pp" value="${data.syb.syb_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh"  name="nek_name" id="syb_xh"  value="${data.syb.syb_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sl"  name="nek_name" id="syb_sl"  value="${data.syb.syb_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sbjg"  name="nek_name" id="syb_sbjg"  value="${data.syb.syb_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="trsynf"  name="nek_name" id="syb_trsynf"  value="${data.syb.syb_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="syb_id"  name="nek_name" value="${data.syb.syb_id}"  class="form-control "/>
					
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="nek_sbmc" readOnly="true"   name="nek_name" id="nkjqxzz_sbmc" htmlEscape="false" value="内窥镜清洗装置"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp"  name="nek_name" id="nkjqxzz_pp"  value="${data.nkjqxzz.nkjqxzz_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh"  name="nek_name" id="nkjqxzz_xh"  value="${data.nkjqxzz.nkjqxzz_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sl"  name="nek_name" id="nkjqxzz_sl"  value="${data.nkjqxzz.nkjqxzz_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sbjg"  name="nek_name" id="nkjqxzz_sbjg" value="${data.nkjqxzz.nkjqxzz_sbjg }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="trsynf"  name="nek_name" id="nkjqxzz_trsynf"  value="${data.nkjqxzz.nkjqxzz_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="nkjqxzz_id"  name="nek_name" value="${data.nkjqxzz.nkjqxzz_id}"  class="form-control "/>
					
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="nek_sbmc"  readOnly="true"  name="nek_name" id="nkjcgj_sbmc" htmlEscape="false" value="内窥镜吹干机"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp"  name="nek_name" id="nkjcgj_pp" value="${data.nkjcgj.nkjcgj_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh"  name="nek_name" id="nkjcgj_xh" value="${data.nkjcgj.nkjcgj_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sl"  name="nek_name" id="nkjcgj_sl" value="${data.nkjcgj.nkjcgj_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sbjg"  name="nek_name" id="nkjcgj_sbjg" value="${data.nkjcgj.nkjcgj_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="trsynf"  name="nek_name" id="nkjcgj_trsynf" value="${data.nkjcgj.nkjcgj_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="nkjcgj_id"  name="nek_name" value="${data.nkjcgj.nkjcgj_id}"  class="form-control "/>
					
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="nek_sbmc" readOnly="true"   name="nek_name" id="nkjclq_sbmc" htmlEscape="false" value="内窥镜侧漏器"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp"  name="nek_name" id="nkjclq_pp"  value="${data.nkjclq.nkjclq_pp}" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh"  name="nek_name" id="nkjclq_xh" value="${data.nkjclq.nkjclq_xh}" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sl"  name="nek_name" id="nkjclq_sl" value="${data.nkjclq.nkjclq_sl}"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sbjg"  name="nek_name" id="nkjclq_sbjg"  value="${data.nkjclq.nkjclq_sbjg}" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="trsynf"  name="nek_name" id="nkjclq_trsynf" value="${data.nkjclq.nkjclq_trsynf}"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="nkjclq_id"  name="nek_name" value="${data.nkjclq.nkjclq_id}"  class="form-control "/>
					
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="nek_sbmc" readOnly="true"   name="nek_name" id="nkjwjbgk_sbmc" htmlEscape="false" value="内窥镜无菌保管柜"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp"  name="nek_name" id="nkjwjbgk_pp"  value="${data.nkjwjbgk.nkjwjbgk_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh"  name="nek_name" id="nkjwjbgk_xh" value="${data.nkjwjbgk.nkjwjbgk_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sl"  name="nek_name" id="nkjwjbgk_sl"  value="${data.nkjwjbgk.nkjwjbgk_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sbjg"  name="nek_name" id="nkjwjbgk_sbjg" value="${data.nkjwjbgk.nkjwjbgk_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="trsynf"  name="nek_name" id="nkjwjbgk_trsynf" value="${data.nkjwjbgk.nkjwjbgk_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="nkjwjbgk_id"  name="nek_name" value="${data.nkjwjbgk.nkjwjbgk_id}"  class="form-control "/>
					
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="nek_sbmc"  readOnly="true"  name="nek_name" id="yefsqjt_sbmc" htmlEscape="false" value="婴儿辐射抢救台"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp"  name="nek_name" id="yefsqjt_pp" value="${data.yefsqjt.yefsqjt_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh"  name="nek_name" id="yefsqjt_xh"  value="${data.yefsqjt.yefsqjt_xh }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sl"  name="nek_name" id="yefsqjt_sl"  value="${data.yefsqjt.yefsqjt_sl }"   htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sbjg"  name="nek_name" id="yefsqjt_sbjg"  value="${data.yefsqjt.yefsqjt_sbjg }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="trsynf"  name="nek_name" id="yefsqjt_trsynf"  value="${data.yefsqjt.yefsqjt_trsynf }"   htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="yefsqjt_id"  name="nek_name" value="${data.yefsqjt.yefsqjt_id}"  class="form-control "/>
					
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="nek_sbmc" readOnly="true"   name="nek_name" id="xsejphh_sbmc" htmlEscape="false" value="新生儿经皮黄疸"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp"  name="nek_name" id="xsejphh_pp" value="${data.xsejphh.xsejphh_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh"  name="nek_name" id="xsejphh_xh"  value="${data.xsejphh.xsejphh_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sl"  name="nek_name" id="xsejphh_sl"  value="${data.xsejphh.xsejphh_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sbjg"  name="nek_name" id="xsejphh_sbjg"  value="${data.xsejphh.xsejphh_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="trsynf"  name="nek_name" id="xsejphh_trsynf" value="${data.xsejphh.xsejphh_trsynf }"   htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="xsejphh_id"  name="nek_name" value="${data.xsejphh.xsejphh_id}"  class="form-control "/>
					
					
					</td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="nek_sbmc" readOnly="true"   name="nek_name" id="dgnnx_sbmc" htmlEscape="false" value="多功能暖箱"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp"  name="nek_name" id="dgnnx_pp" value="${data.dgnnx.dgnnx_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh"  name="nek_name" id="dgnnx_xh" value="${data.dgnnx.dgnnx_xh }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sl"  name="nek_name" id="dgnnx_sl" value="${data.dgnnx.dgnnx_sl }"   htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sbjg"  name="nek_name" id="dgnnx_sbjg" value="${data.dgnnx.dgnnx_sbjg }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="trsynf"  name="nek_name" id="dgnnx_trsynf" value="${data.dgnnx.dgnnx_trsynf }"   htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="dgnnx_id"  name="nek_name" value="${data.dgnnx.dgnnx_id}"  class="form-control "/>
					
					</td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="nek_sbmc" readOnly="true"   name="nek_name" id="wlhhcly_sbmc" htmlEscape="false" value="微量黄疸测量仪"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp"  name="nek_name" id="wlhhcly_pp" value="${data.wlhhcly.wlhhcly_pp}" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh"  name="nek_name" id="wlhhcly_xh" value="${data.wlhhcly.wlhhcly_xh}"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sl"  name="nek_name" id="wlhhcly_sl"  value="${data.wlhhcly.wlhhcly_sl}" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sbjg"  name="nek_name" id="wlhhcly_sbjg"  value="${data.wlhhcly.wlhhcly_sbjg}" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="trsynf"  name="nek_name" id="wlhhcly_trsynf" value="${data.wlhhcly.wlhhcly_trsynf}" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="wlhhcly_id"  name="nek_name" value="${data.wlhhcly.wlhhcly_id}"  class="form-control "/>
					
					</td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="nek_sbmc" readOnly="true"   name="nek_name" id="qtqzm_sbmc" htmlEscape="false" value="其它（请注明）"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp"  name="nek_name" id="qtqzm_pp" value="${data.qtqzm.qtqzm_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh"  name="nek_name" id="qtqzm_xh" value="${data.qtqzm.qtqzm_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sl"  name="nek_name" id="qtqzm_sl"  value="${data.qtqzm.qtqzm_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sbjg"  name="nek_name" id="qtqzm_sbjg"  value="${data.qtqzm.qtqzm_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
					
						<input path="trsynf"  name="nek_name" id="qtqzm_trsynf" value="${data.qtqzm.qtqzm_trsynf }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="qtqzm_id"  name="nek_name" value="${data.qtqzm.qtqzm_id}"  class="form-control "/>
					
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
		
		var data = document.getElementsByName("nek_name");
	
		var datas="";
		
		
		for(i=0;i<data.length;i++){
			if(data[i].value==null||data[i].value==""){
				datas = datas +data[i].id+": ---- ;";	
			}else{
				datas = datas +data[i].id+":"+data[i].value+";";	
			}
			
			
		}
	 	
		 $.ajax({
		      url:"${ctx}/ironfoyjbylsbpznek/ironfoyjbylsbpznek/save",
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