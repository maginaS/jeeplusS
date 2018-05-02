<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>手术室管理</title>
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
		<formid="inputForm" modelAttribute="ironfoyjbylsbpzsss" action="${ctx}/ironfoyjbylsbpzsss/ironfoyjbylsbpzsss/save" method="post" class="form-horizontal">
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
						<input path="sss_sbmc" htmlEscape="false" name="shsgl_name" readOnly="true" id="cxbxxj_sbmc"  value="C型臂X线机"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sss_pp" htmlEscape="false"    name="shsgl_name" id="cxbxxj_pp" value="${data.cxbxxj.cxbxxj_pp }"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_xh" htmlEscape="false"   name="shsgl_name"  id="cxbxxj_xh" value="${data.cxbxxj.cxbxxj_xh }"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_sl" htmlEscape="false"  name="shsgl_name"  id="cxbxxj_sl"  value="${data.cxbxxj.cxbxxj_sl }"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sss_sbjg" htmlEscape="false"   name="shsgl_name"  id="cxbxxj_sbjg" value="${data.cxbxxj.cxbxxj_sbjg }"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_trsynf" htmlEscape="false"    name="shsgl_name"  id="cxbxxj_trsynf" value="${data.cxbxxj.cxbxxj_trsynf }" class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="cxbxxj_id"  name="shsgl_name" value="${data.cxbxxj.cxbxxj_id}"  class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="docId"   name="shsgl_name" value="${data.doc_id}"  class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="sss_sbmc" htmlEscape="false" id="fqjxt_sbmc" readOnly="true" name="shsgl_name"  value="腹腔镜系统"   class="form-control "/>
					</td>
					<td class="width-15"> 
						<input path="sss_pp" htmlEscape="false"  id="fqjxt_pp" value="${data.fqjxt.fqjxt_pp }" name="shsgl_name"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_xh" htmlEscape="false"  id="fqjxt_xh"  value="${data.fqjxt.fqjxt_xh }"   name="shsgl_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_sl" htmlEscape="false" id="fqjxt_sl"   value="${data.fqjxt.fqjxt_sl }"  name="shsgl_name"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sss_sbjg" htmlEscape="false"   id="fqjxt_sbjg" value="${data.fqjxt.fqjxt_sbjg }"  name="shsgl_name"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_trsynf" htmlEscape="false" id="fqjxt_trsynf"  value="${data.fqjxt.fqjxt_trsynf }"   name="shsgl_name"   class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="fqjxt_id"  name="shsgl_name" value="${data.fqjxt.fqjxt_id}"  class="form-control "/>
					
					</td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="sss_sbmc" htmlEscape="false" id="gqjxt_sbmc" readOnly="true"  name="shsgl_name" value="宫腔镜系统"   class="form-control "/>
					</td>
					<td class="width-15"> 
						<input path="sss_pp" htmlEscape="false"  id="gqjxt_pp"  value="${data.gqjxt.gqjxt_pp }"  name="shsgl_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_xh" htmlEscape="false"  id="gqjxt_xh"   value="${data.gqjxt.gqjxt_xh }" name="shsgl_name"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_sl" htmlEscape="false"   id="gqjxt_sl"  value="${data.gqjxt.gqjxt_sl }"  name="shsgl_name"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sss_sbjg" htmlEscape="false" id="gqjxt_sbjg"  value="${data.gqjxt.gqjxt_sbjg }"  name="shsgl_name"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_trsynf" htmlEscape="false"  id="gqjxt_trsynf"  value="${data.gqjxt.gqjxt_trsynf }"   name="shsgl_name"  class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="gqjxt_id"  name="shsgl_name" value="${data.gqjxt.gqjxt_id}"  class="form-control "/>
				
					</td>
					
				</tr>
				
				<tr>
					<td class="width-15">
						<input path="sss_sbmc" htmlEscape="false"  id="csd_sbmc" readOnly="true" name="shsgl_name"  value="超声刀"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sss_pp" htmlEscape="false" id="csd_pp" value="${data.csd.csd_pp }" name="shsgl_name"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_xh" htmlEscape="false"  id="csd_xh"  value="${data.csd.csd_xh }" name="shsgl_name"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_sl" htmlEscape="false"   id="csd_sl" value="${data.csd.csd_sl }"  name="shsgl_name"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sss_sbjg" htmlEscape="false"  id="csd_sbjg"  value="${data.csd.csd_sbjg }" name="shsgl_name"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_trsynf" htmlEscape="false" id="csd_trsynf"  value="${data.csd.csd_trsynf }" name="shsgl_name"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="csd_id"  name="shsgl_name" value="${data.csd.csd_id}"  class="form-control "/>
					
					</td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="sss_sbmc" htmlEscape="false" id="ssxwj_sbmc" readOnly="true" name="shsgl_name"  value="手术显微镜"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sss_pp" htmlEscape="false"   id="ssxwj_pp" value="${data.ssxwj.ssxwj_pp }" name="shsgl_name"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_xh" htmlEscape="false"  id="ssxwj_xh"   value="${data.ssxwj.ssxwj_xh }"  name="shsgl_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_sl" htmlEscape="false"  id="ssxwj_sl"  value="${data.ssxwj.ssxwj_sl }"   name="shsgl_name"  class="form-control "/>
					</td>
					<td class="width-15"> 
						<input path="sss_sbjg" htmlEscape="false"  id="ssxwj_sbjg"   value="${data.ssxwj.ssxwj_sbjg }"  name="shsgl_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_trsynf" htmlEscape="false" id="ssxwj_trsynf"  value="${data.ssxwj.ssxwj_trsynf }"  name="shsgl_name"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="ssxwj_id"  name="shsgl_name" value="${data.ssxwj.ssxwj_id}"  class="form-control "/>
					
					</td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="sss_sbmc" htmlEscape="false"  id="xqfxy_sbmc" readOnly="true"  name="shsgl_name" value="血气分析仪"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sss_pp" htmlEscape="false"     id="xqfxy_pp"  value="${data.xqfxy.xqfxy_pp }"  name="shsgl_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_xh" htmlEscape="false"   id="xqfxy_xh"  value="${data.xqfxy.xqfxy_xh }"     name="shsgl_name"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_sl" htmlEscape="false"    id="xqfxy_sl"  value="${data.xqfxy.xqfxy_sl }"    name="shsgl_name"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sss_sbjg" htmlEscape="false"    id="xqfxy_sbjg"   value="${data.xqfxy.xqfxy_sbjg }"    name="shsgl_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_trsynf" htmlEscape="false"    id="xqfxy_trsynf"   value="${data.xqfxy.xqfxy_trsynf }"    name="shsgl_name"  class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="xqfxy_id"  name="shsgl_name" value="${data.xqfxy.xqfxy_id}"  class="form-control "/>
					
					</td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="sss_sbmc" htmlEscape="false" id="csbzdy_sbmc" readOnly="true" name="shsgl_name"  value="超声波诊断仪"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sss_pp" htmlEscape="false"  id="csbzdy_pp" value="${data.csbzdy.csbzdy_pp }"  name="shsgl_name"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_xh" htmlEscape="false" id="csbzdy_xh"  value="${data.csbzdy.csbzdy_xh }"  name="shsgl_name"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_sl" htmlEscape="false"  id="csbzdy_sl"  value="${data.csbzdy.csbzdy_sl }"  name="shsgl_name"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sss_sbjg" htmlEscape="false"  id="csbzdy_sbjg" value="${data.csbzdy.csbzdy_sbjg }"  name="shsgl_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_trsynf" htmlEscape="false"  id="csbzdy_trsynf" value="${data.csbzdy.csbzdy_trsynf }"   name="shsgl_name"  class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="csbzdy_id"  name="shsgl_name" value="${data.csbzdy.csbzdy_id}"  class="form-control "/>
					
					</td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="sss_sbmc" htmlEscape="false"  id="kshj_sbmc" readOnly="true" name="shsgl_name"  value="可视喉镜"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sss_pp" htmlEscape="false"  id="kshj_pp"  value="${data.kshj.kshj_pp }" name="shsgl_name"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_xh" htmlEscape="false"  id="kshj_xh" value="${data.kshj.kshj_xh }"   name="shsgl_name"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_sl" htmlEscape="false"  id="kshj_sl" value="${data.kshj.kshj_sl }"   name="shsgl_name"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sss_sbjg" htmlEscape="false" id="kshj_sbjg"  value="${data.kshj.kshj_sbjg }"   name="shsgl_name"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_trsynf" htmlEscape="false"   id="kshj_trsynf" value="${data.kshj.kshj_trsynf }"  name="shsgl_name"   class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="kshj_id"  name="shsgl_name" value="${data.kshj.kshj_id}"  class="form-control "/>
					
					</td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="sss_sbmc" htmlEscape="false" id="dcsjhy_sbmc" readOnly="true"  name="shsgl_name"  value="多参数监护仪"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sss_pp" htmlEscape="false"  id="dcsjhy_pp"  value="${data.dcsjhy.dcsjhy_pp }"  name="shsgl_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_xh" htmlEscape="false"  id="dcsjhy_xh"   value="${data.dcsjhy.dcsjhy_xh }" name="shsgl_name"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_sl" htmlEscape="false"  id="dcsjhy_sl"  value="${data.dcsjhy.dcsjhy_sl }"  name="shsgl_name"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sss_sbjg" htmlEscape="false"    id="dcsjhy_sbjg"   value="${data.dcsjhy.dcsjhy_sbjg }" name="shsgl_name" class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_trsynf" htmlEscape="false"  id="dcsjhy_trsynf"  value="${data.dcsjhy.dcsjhy_trsynf }"  name="shsgl_name"  class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="dcsjhy_id"  name="shsgl_name" value="${data.dcsjhy.dcsjhy_id}"  class="form-control "/>
					
					</td> 
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="sss_sbmc" htmlEscape="false" id="ssdt_sbmc" readOnly="true"  name="shsgl_name"  value="手术吊塔"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sss_pp" htmlEscape="false"  id="ssdt_pp"  value="${data.ssdt.ssdt_pp }"   name="shsgl_name"   class="form-control "/>
					</td>
					
					<td class="width-15"> 
						<input path="sss_xh" htmlEscape="false"   id="ssdt_xh"   value="${data.ssdt.ssdt_xh }"    name="shsgl_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_sl" htmlEscape="false"   id="ssdt_sl"    value="${data.ssdt.ssdt_sl }"   name="shsgl_name"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sss_sbjg" htmlEscape="false"   id="ssdt_sbjg"   value="${data.ssdt.ssdt_sbjg }"   name="shsgl_name"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_trsynf" htmlEscape="false"   id="ssdt_trsynf"   value="${data.ssdt.ssdt_trsynf }"   name="shsgl_name"   class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="ssdt_id"  name="shsgl_name" value="${data.ssdt.ssdt_id}"  class="form-control "/>
					
					</td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="sss_sbmc" htmlEscape="false"  name="shsgl_name" readOnly="true" id="zhssc_sbmc"  value="综合手术床"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sss_pp" htmlEscape="false"   name="shsgl_name" id="zhssc_pp"  value="${data.zhssc.zhssc_pp}"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_xh" htmlEscape="false"   name="shsgl_name"  id="zhssc_xh"  value="${data.zhssc.zhssc_xh}"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_sl" htmlEscape="false"   name="shsgl_name"  id="zhssc_sl" value="${data.zhssc.zhssc_sl}"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sss_sbjg" htmlEscape="false"   name="shsgl_name" id="zhssc_sbjg" value="${data.zhssc.zhssc_sbjg}"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_trsynf" htmlEscape="false"  name="shsgl_name"  id="zhssc_trsynf"  value="${data.zhssc.zhssc_trsynf}"   class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="zhssc_id"  name="shsgl_name" value="${data.zhssc.zhssc_id}"  class="form-control "/>
					
					</td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="sss_sbmc" htmlEscape="false"  name="shsgl_name" readOnly="true" id="wyd_sbmc"  value="无影灯"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sss_pp" htmlEscape="false"   name="shsgl_name"   id="wyd_pp" value="${data.wyd.wyd_pp }"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_xh" htmlEscape="false"   name="shsgl_name" id="wyd_xh"   value="${data.wyd.wyd_xh }"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_sl" htmlEscape="false"   name="shsgl_name"  id="wyd_sl" value="${data.wyd.wyd_sl }"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sss_sbjg" htmlEscape="false"  name="shsgl_name"   id="wyd_sbjg"  value="${data.wyd.wyd_sbjg }"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_trsynf" htmlEscape="false"    name="shsgl_name"  id="wyd_trsynf"  value="${data.wyd.wyd_trsynf }" class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="wyd_id"  name="shsgl_name" value="${data.wyd.wyd_id}"  class="form-control "/>
					
					</td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="sss_sbmc" htmlEscape="false" id="gpdd_sbmc" readOnly="true"  name="shsgl_name"  value="高频电刀"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sss_pp" htmlEscape="false"   id="gpdd_pp" value="${data.gpdd.gpdd_pp }"  name="shsgl_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_xh" htmlEscape="false"  id="gpdd_xh"  value="${data.gpdd.gpdd_xh }"  name="shsgl_name"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_sl" htmlEscape="false"  id="gpdd_sl" value="${data.gpdd.gpdd_sl }"   name="shsgl_name"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sss_sbjg" htmlEscape="false"  id="gpdd_sbjg" value="${data.gpdd.gpdd_sbjg }"   name="shsgl_name"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_trsynf" htmlEscape="false"  id="gpdd_trsynf"  value="${data.gpdd.gpdd_trsynf }"  name="shsgl_name"   class="form-control "/>
					    <input type = "hidden" htmlEscape="false" id="gpdd_id"  name="shsgl_name" value="${data.gpdd.gpdd_id}"  class="form-control "/>
					
					</td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="sss_sbmc" htmlEscape="false" id="yzhxj_sbmc" readOnly="true"  name="shsgl_name" value="转运呼吸机"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sss_pp" htmlEscape="false"  id="yzhxj_pp" value="${data.yzhxj.yzhxj_pp }"  name="shsgl_name"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_xh" htmlEscape="false"  id="yzhxj_xh"  value="${data.yzhxj.yzhxj_xh }"  name="shsgl_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_sl" htmlEscape="false"  id="yzhxj_sl" value="${data.yzhxj.yzhxj_sl }"   name="shsgl_name"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sss_sbjg" htmlEscape="false"  id="yzhxj_sbjg" value="${data.yzhxj.yzhxj_sbjg }"   name="shsgl_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_trsynf" htmlEscape="false"  id="yzhxj_trsynf"  value="${data.yzhxj.yzhxj_trsynf }"  name="shsgl_name"  class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="yzhxj_id"  name="shsgl_name" value="${data.yzhxj.yzhxj_id}"  class="form-control "/>
				
					</td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="sss_sbmc" htmlEscape="false" id="ccy_sbmc" readOnly="true"  name="shsgl_name" value="除颤仪"   class="form-control "/>
					</td>
					<td class="width-15"> 
						<input path="sss_pp" htmlEscape="false"    id="ccy_pp" value="${data.ccy.ccy_pp }"  name="shsgl_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_xh" htmlEscape="false"  id="ccy_xh"  value="${data.ccy.ccy_xh }"  name="shsgl_name"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_sl" htmlEscape="false"  id="ccy_sl"  value="${data.ccy.ccy_sl }"   name="shsgl_name"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sss_sbjg" htmlEscape="false"   id="ccy_sbjg" value="${data.ccy.ccy_sbjg }"  name="shsgl_name"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_trsynf" htmlEscape="false"  id="ccy_trsynf" value="${data.ccy.ccy_trsynf }"   name="shsgl_name"   class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="ccy_id"  name="shsgl_name" value="${data.ccy.ccy_id}"  class="form-control "/>
					
					</td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="sss_sbmc" htmlEscape="false" id="ssdjc_sbmc" readOnly="true"  name="shsgl_name" value="手术对接车"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sss_pp" htmlEscape="false"  id="ssdjc_pp" value="${data.ssdjc.ssdjc_pp }"  name="shsgl_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_xh" htmlEscape="false"  id="ssdjc_xh" value="${data.ssdjc.ssdjc_xh }"   name="shsgl_name" name="shsgl_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_sl" htmlEscape="false"  id="ssdjc_sl" value="${data.ssdjc.ssdjc_sl }"  name="shsgl_name"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sss_sbjg" htmlEscape="false"  id="ssdjc_sbjg" value="${data.ssdjc.ssdjc_sbjg }"   name="shsgl_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_trsynf" htmlEscape="false"  id="ssdjc_trsynf" value="${data.ssdjc.ssdjc_trsynf }"  name="shsgl_name"   class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="ssdjc_id"  name="shsgl_name" value="${data.ssdjc.ssdjc_id}"  class="form-control "/>
					
					
					</td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="sss_sbmc" htmlEscape="false" id="cc_sbmc"  readOnly="true" name="shsgl_name"  value="产床"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sss_pp" htmlEscape="false"  id="cc_pp"  value="${data.cc.cc_pp }"   name="shsgl_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_xh" htmlEscape="false"   id="cc_xh"  value="${data.cc.cc_xh }"    name="shsgl_name"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_sl" htmlEscape="false"   id="cc_sl"   value="${data.cc.cc_sl }"    name="shsgl_name"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sss_sbjg" htmlEscape="false"  id="cc_sbjg"   value="${data.cc.cc_sbjg }"    name="shsgl_name"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_trsynf" htmlEscape="false"   id="cc_trsynf"  value="${data.cc.cc_trsynf }"    name="shsgl_name"   class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="cc_id"  name="shsgl_name" value="${data.cc.cc_id}"  class="form-control "/>
					
					</td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="sss_sbmc" htmlEscape="false" id="mzsdjcy_sbmc"  readOnly="true" name="shsgl_name" value="麻醉深度检测仪"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sss_pp" htmlEscape="false" id="mzsdjcy_pp"  value="${data.mzsdjcy.mzsdjcy_pp }"  name="shsgl_name"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_xh" htmlEscape="false" id="mzsdjcy_xh"   value="${data.mzsdjcy.mzsdjcy_xh }"    name="shsgl_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_sl" htmlEscape="false" id="mzsdjcy_sl"  value="${data.mzsdjcy.mzsdjcy_sl }"    name="shsgl_name"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sss_sbjg" htmlEscape="false"  id="mzsdjcy_sbjg"  value="${data.mzsdjcy.mzsdjcy_sbjg }"    name="shsgl_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_trsynf" htmlEscape="false"  id="mzsdjcy_trsynf" value="${data.mzsdjcy.mzsdjcy_trsynf }"    name="shsgl_name"   class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="mzsdjcy_id"  name="shsgl_name" value="${data.mzsdjcy.mzsdjcy_id}"  class="form-control "/>
					
					</td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="sss_sbmc" htmlEscape="false" id="hxmzj_sbmc" readOnly="true"  name="shsgl_name" value="呼吸麻醉机"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sss_pp" htmlEscape="false" id="hxmzj_pp" value="${data.hxmzj.hxmzj_pp}"  name="shsgl_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_xh" htmlEscape="false"  id="hxmzj_xh"  value="${data.hxmzj.hxmzj_xh}" name="shsgl_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_sl" htmlEscape="false" id="hxmzj_sl" value="${data.hxmzj.hxmzj_sl}"  name="shsgl_name"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sss_sbjg" htmlEscape="false" id="hxmzj_sbjg"  value="${data.hxmzj.hxmzj_sbjg}"  name="shsgl_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_trsynf" htmlEscape="false"  id="hxmzj_trsynf"  value="${data.hxmzj.hxmzj_trsynf}" name="shsgl_name"  class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="hxmzj_id"  name="shsgl_name" value="${data.hxmzj.hxmzj_id}"  class="form-control "/>
					
					</td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="sss_sbmc" htmlEscape="false" id="mzbb_sbmc" readOnly="true"  name="shsgl_name" value="麻醉靶泵"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sss_pp" htmlEscape="false"  id="mzbb_pp" value="${data.mzbb.mzbb_pp }"  name="shsgl_name"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_xh" htmlEscape="false"  id="mzbb_xh" value="${data.mzbb.mzbb_xh }"   name="shsgl_name"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_sl" htmlEscape="false"   id="mzbb_sl"  value="${data.mzbb.mzbb_sl }"  name="shsgl_name"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sss_sbjg" htmlEscape="false"   id="mzbb_sbjg"  value="${data.mzbb.mzbb_sbjg }"  name="shsgl_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_trsynf" htmlEscape="false"  id="mzbb_trsynf"  value="${data.mzbb.mzbb_trsynf }"  name="shsgl_name"  class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="mzbb_id"  name="shsgl_name" value="${data.mzbb.mzbb_id}"  class="form-control "/>
					
					</td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="sss_sbmc" htmlEscape="false"  id="qtqzm_sbmc" readOnly="true"  name="shsgl_name"  value="其它（请注明）"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sss_pp" htmlEscape="false"  id="qtqzm_pp" value="${data.qtqzm.qtqzm_pp }"  name="shsgl_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_xh" htmlEscape="false"  id="qtqzm_xh" value="${data.qtqzm.qtqzm_xh }" name="shsgl_name"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_sl" htmlEscape="false"   id="qtqzm_sl" value="${data.qtqzm.qtqzm_sl }"  name="shsgl_name"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sss_sbjg" htmlEscape="false"  id="qtqzm_sbjg"  value="${data.qtqzm.qtqzm_sbjg }"  name="shsgl_name"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sss_trsynf" htmlEscape="false"  id="qtqzm_trsynf" value="${data.qtqzm.qtqzm_trsynf }" name="shsgl_name"  class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="qtqzm_id"  name="shsgl_name" value="${data.qtqzm.qtqzm_id}"  class="form-control "/>
					
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
		
		var data = document.getElementsByName("shsgl_name");
	
		var datas="";
		
		
		for(i=0;i<data.length;i++){
			if(data[i].value==null||data[i].value==""){
				datas = datas +data[i].id+": ---- ;";	
			}else{
				datas = datas +data[i].id+":"+data[i].value+";";	
			}
			
			
		}
	 	
		 $.ajax({
		      url:"${ctx}/ironfoyjbylsbpzsss/ironfoyjbylsbpzsss/save",
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