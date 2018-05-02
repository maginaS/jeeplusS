<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>口腔科管理</title>
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
		<form id="inputForm" modelAttribute="ironfoyjbylsbpzkqk" action="${ctx}/ironfoyjbylsbpzkqk/ironfoyjbylsbpzkqk/save" method="post" class="form-horizontal">
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
						<input path="kqk_sbmc" name="kqkname" id="zxsct_sbmc"  readOnly="true" htmlEscape="false"  value="锥形束CT"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kqk_pp" name="kqkname" id="zxsct_pp" value="${data.zxsct.zxsct_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_xh" name="kqkname"  id="zxsct_xh" value="${data.zxsct.zxsct_xh }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_sl" name="kqkname"  id="zxsct_sl" value="${data.zxsct.zxsct_sl }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_sbjg" name="kqkname" id="zxsct_sbjg" value="${data.zxsct.zxsct_sbjg }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_trsynf" name="kqkname" id="zxsct_trsynf" value="${data.zxsct.zxsct_trsynf }"   htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="zxsct_id"  name="kqkname" value="${data.zxsct.zxsct_id}"  class="form-control "/>
					    <input type = "hidden" htmlEscape="false" id="docId"   name="kqkname" value="${data.doc_id}"  class="form-control "/>
					
					</td>
				</tr>
				<tr>
				
					<td class="width-15">
						<input path="kqk_sbmc" name="kqkname" id="ypcxxt_sbmc" readOnly="true" htmlEscape="false"  value="牙片成像系统"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kqk_pp" name="kqkname" id="ypcxxt_pp" value="${data.ypcxxt.ypcxxt_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_xh" name="kqkname" id="ypcxxt_xh"  value="${data.ypcxxt.ypcxxt_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_sl" name="kqkname" id="ypcxxt_sl"  value="${data.ypcxxt.ypcxxt_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_sbjg" name="kqkname" id="ypcxxt_sbjg"  value="${data.ypcxxt.ypcxxt_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_trsynf" name="kqkname" id="ypcxxt_trsynf"  value="${data.ypcxxt.ypcxxt_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="ypcxxt_id"  name="kqkname" value="${data.ypcxxt.ypcxxt_id}"  class="form-control "/>
					
					</td>
					
				</tr>
					<tr>
				
					<td class="width-15">
						<input path="kqk_sbmc" name="kqkname" id="kqnkjxt_sbmc" readOnly="true" htmlEscape="false"  value="口腔内窥镜系统"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kqk_pp" name="kqkname" id="kqnkjxt_pp" value="${data.kqnkjxt.kqnkjxt_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_xh" name="kqkname" id="kqnkjxt_xh" value="${data.kqnkjxt.kqnkjxt_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_sl " name="kqkname" id="kqnkjxt_sl" value="${data.kqnkjxt.kqnkjxt_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_sbjg" name="kqkname" id="kqnkjxt_sbjg" value="${data.kqnkjxt.kqnkjxt_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_trsynf" name="kqkname" id="kqnkjxt_trsynf" value="${data.kqnkjxt.kqnkjxt_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="kqnkjxt_id"  name="kqkname" value="${data.kqnkjxt.kqnkjxt_id}"  class="form-control "/>
					
					</td>
					
				</tr>
				<tr>
				
					<td class="width-15">
						<input path="kqk_sbmc" name="kqkname" id="ykzhzlt_sbmc" readOnly="true" htmlEscape="false"  value="牙科综合治疗台"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kqk_pp" name="kqkname" id="ykzhzlt_pp" value="${data.ykzhzlt.ykzhzlt_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_xh" name="kqkname" id="ykzhzlt_xh"  value="${data.ykzhzlt.ykzhzlt_xh }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_sl" name="kqkname" id="ykzhzlt_sl"  value="${data.ykzhzlt.ykzhzlt_sl }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_sbjg" name="kqkname" id="ykzhzlt_sbjg"   value="${data.ykzhzlt.ykzhzlt_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_trsynf" name="kqkname" id="ykzhzlt_trsynf"   value="${data.ykzhzlt.ykzhzlt_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="ykzhzlt_id"  name="kqkname" value="${data.ykzhzlt.ykzhzlt_id}"  class="form-control "/>
					
					</td>
					
				</tr>
				
				<tr>
				
					<td class="width-15">
						<input path="kqk_sbmc" name="kqkname" id="ntggybxt_sbmc" readOnly="true" htmlEscape="false"  value="镍钛根管预备系统"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kqk_pp" name="kqkname" id="ntggybxt_pp" value="${data.ntggybxt.ntggybxt_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_xh" name="kqkname" id="ntggybxt_xh"  value="${data.ntggybxt.ntggybxt_xh }"    htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_sl" name="kqkname" id="ntggybxt_sl"  value="${data.ntggybxt.ntggybxt_sl }"    htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_sbjg" name="kqkname" id="ntggybxt_sbjg"  value="${data.ntggybxt.ntggybxt_sbjg }"    htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_trsynf" name="kqkname" id="ntggybxt_trsynf"   value="${data.ntggybxt.ntggybxt_trsynf }"   htmlEscape="false"    class="form-control "/>
					   <input type = "hidden" htmlEscape="false" id="ntggybxt_id"  name="kqkname" value="${data.ntggybxt.ntggybxt_id}"  class="form-control "/>
					
					</td>
					
				</tr>
				<tr>
				
					<td class="width-15">
						<input path="kqk_sbmc" name="kqkname" id="ryjggxt_sbmc" readOnly="true" htmlEscape="false"  value="热牙胶根管系统"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kqk_pp" name="kqkname" id="ryjggxt_pp" value="${data.ryjggxt.ryjggxt_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_xh" name="kqkname" id="ryjggxt_xh"  value="${data.ryjggxt.ryjggxt_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_sl" name="kqkname" id="ryjggxt_sl"  value="${data.ryjggxt.ryjggxt_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_sbjg" name="kqkname" id="ryjggxt_sbjg"  value="${data.ryjggxt.ryjggxt_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_trsynf" name="kqkname" id="ryjggxt_trsynf"  value="${data.ryjggxt.ryjggxt_trsynf }"  htmlEscape="false"    class="form-control "/>
					   <input type = "hidden" htmlEscape="false" id="ryjggxt_id"  name="kqkname" value="${data.ryjggxt.ryjggxt_id}"  class="form-control "/>
					
					</td>
					
				</tr>
				
				
				
				
				
				
				<tr>
				
					<td class="width-15">
						<input path="kqk_sbmc" name="kqkname" htmlEscape="false" readOnly="true"  id="bjym_sbmc"  value="拌机印模"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kqk_pp" name="kqkname" htmlEscape="false"  id="bjym_pp"  value="${data.bjym.bjym_pp }"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_xh" name="kqkname" htmlEscape="false"  id="bjym_xh"  value="${data.bjym.bjym_xh }"      class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_sl" name="kqkname" htmlEscape="false"  id="bjym_sl"  value="${data.bjym.bjym_sl }"      class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_sbjg" name="kqkname" htmlEscape="false"  id="bjym_sbjg"  value="${data.bjym.bjym_sbjg }"      class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_trsynf" name="kqkname" htmlEscape="false" id="bjym_trsynf"   value="${data.bjym.bjym_trsynf }"      class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="bjym_id"  name="kqkname" value="${data.bjym.bjym_id}"  class="form-control "/>
					
					</td>
					
				</tr>
				<tr>
				
					<td class="width-15">
						<input path="kqk_sbmc" name="kqkname" htmlEscape="false" readOnly="true" id="kqszymy_sbmc"  value="口腔数字印模仪"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kqk_pp" name="kqkname" htmlEscape="false" id="kqszymy_pp"  value="${data.kqszymy.kqszymy_pp }"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_xh" name="kqkname" htmlEscape="false"  id="kqszymy_xh"  value="${data.kqszymy.kqszymy_xh }"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_sl" name="kqkname" htmlEscape="false"   id="kqszymy_sl" value="${data.kqszymy.kqszymy_sl }" class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_sbjg" name="kqkname" htmlEscape="false"   id="kqszymy_sbjg"  value="${data.kqszymy.kqszymy_sbjg }" class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_trsynf" name="kqkname" htmlEscape="false"  id="kqszymy_trsynf"  value="${data.kqszymy.kqszymy_trsynf }"  class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="kqszymy_id"  name="kqkname" value="${data.kqszymy.kqszymy_id}"  class="form-control "/>
					
					</td>
					
				</tr>
				<tr>
				
					<td class="width-15">
						<input path="kqk_sbmc" name="kqkname" htmlEscape="false" readOnly="true" id="yksj_sbmc" value="牙科手机"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kqk_pp" name="kqkname" htmlEscape="false" value="${data.yksj.yksj_pp }"  id="yksj_pp"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_xh" name="kqkname" htmlEscape="false" id="yksj_xh"  value="${data.yksj.yksj_xh }"     class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_sl" name="kqkname" htmlEscape="false"  id="yksj_sl"   value="${data.yksj.yksj_sl }"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_sbjg" name="kqkname" htmlEscape="false"  id="yksj_sbjg"  value="${data.yksj.yksj_sbjg }"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_trsynf" name="kqkname" htmlEscape="false"  id="yksj_trsynf"  value="${data.yksj.yksj_trsynf }"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="yksj_id"  name="kqkname" value="${data.yksj.yksj_id}"  class="form-control "/>
					
					</td>
					
				</tr>
				<tr>
				
					<td class="width-15">
						<input path="kqk_sbmc" name="kqkname" htmlEscape="false" readOnly="true" id="sjqxzyj_sbmc"  value="手机清洗注油机"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kqk_pp" id="sjqxzyj_pp" value="${data.sjqxzyj.sjqxzyj_pp }" name="kqkname" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_xh" id="sjqxzyj_xh" value="${data.sjqxzyj.sjqxzyj_xh }"  name="kqkname" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_sl" id="sjqxzyj_sl"  value="${data.sjqxzyj.sjqxzyj_sl }" name="kqkname" name="kqkname" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_sbjg" id="sjqxzyj_sbjg" value="${data.sjqxzyj.sjqxzyj_sbjg }"  name="kqkname" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_trsynf" id="sjqxzyj_trsynf" value="${data.sjqxzyj.sjqxzyj_trsynf }"  name="kqkname" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="sjqxzyj_id"  name="kqkname" value="${data.sjqxzyj.sjqxzyj_id}"  class="form-control "/>
					
					</td>
					
				</tr>
				<tr>
				
					<td class="width-15"> 
						<input path="kqk_sbmc" name="kqkname" htmlEscape="false" readOnly="true" id="psjyj_sbmc"  value="喷沙洁牙机"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kqk_pp" id="psjyj_pp" value="${data.psjyj.psjyj_pp }"  name="kqkname" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_xh" id="psjyj_xh"  value="${data.psjyj.psjyj_xh }" name="kqkname" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_sl" id="psjyj_sl" value="${data.psjyj.psjyj_sl }"  name="kqkname" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_sbjg" id="psjyj_sbjg" value="${data.psjyj.psjyj_sbjg }"  name="kqkname" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_trsynf" id="psjyj_trsynf" value="${data.psjyj.psjyj_trsynf }"  name="kqkname" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="psjyj_id"  name="kqkname" value="${data.psjyj.psjyj_id}"  class="form-control "/>
					
					
					</td>
					
				</tr>
				<tr>
				
					<td class="width-15">
						<input path="kqk_sbmc" name="kqkname" id="kqymj_sbmc" readOnly="true" htmlEscape="false"  value="口腔压膜机"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kqk_pp" name="kqkname" id="kqymj_pp"  value="${data.kqymj.kqymj_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_xh" name="kqkname" id="kqymj_xh" value="${data.kqymj.kqymj_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_sl" name="kqkname" id="kqymj_sl"  value="${data.kqymj.kqymj_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_sbjg" name="kqkname" id="kqymj_sbjg" value="${data.kqymj.kqymj_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_trsynf" name="kqkname" id="kqymj_trsynf"  value="${data.kqymj.kqymj_trsynf }" htmlEscape="false"    class="form-control "/>
					
						<input type = "hidden" htmlEscape="false" id="kqymj_id"  name="kqkname" value="${data.kqymj.kqymj_id}"  class="form-control "/>
					
					</td>
					
				</tr>
				<tr>
				
					<td class="width-15">
						<input path="kqk_sbmc" name="kqkname" id="jgdmj_sbmc" readOnly="true" htmlEscape="false"  value="技工打磨机"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kqk_pp" name="kqkname"  id="jgdmj_pp" value="${data.jgdmj.jgdmj_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_xh" name="kqkname"  id="jgdmj_xh" value="${data.jgdmj.jgdmj_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_sl" name="kqkname"  id="jgdmj_sl" value="${data.jgdmj.jgdmj_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_sbjg" name="kqkname"  id="jgdmj_sbjg" value="${data.jgdmj.jgdmj_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_trsynf" name="kqkname"  id="jgdmj_trsynf" value="${data.jgdmj.jgdmj_trsynf }"  htmlEscape="false"    class="form-control "/>
					    <input type = "hidden" htmlEscape="false" id="jgdmj_id"  name="kqkname" value="${data.jgdmj.jgdmj_id}"  class="form-control "/>
					
					</td>
					
				</tr>
				<tr>
				
					<td class="width-15">
						<input path="kqk_sbmc" id="jgt_sbmc" name="kqkname" readOnly="true" htmlEscape="false"  value="技工台"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kqk_pp" id="jgt_pp" value="${data.jgt.jgt_pp }" name="kqkname" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_xh" id="jgt_xh"  value="${data.jgt.jgt_xh }"   name="kqkname" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_sl" id="jgt_sl"  value="${data.jgt.jgt_sl }"   name="kqkname" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_sbjg" id="jgt_sbjg"  value="${data.jgt.jgt_sbjg }"   name="kqkname" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_trsynf" id="jgt_trsynf"   value="${data.jgt.jgt_trsynf }"  name="kqkname" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="jgt_id"  name="kqkname" value="${data.jgt.jgt_id}"  class="form-control "/>
					
					</td>
					
				</tr>
				
				<tr>
				
					<td class="width-15">
						<input path="kqk_sbmc" name="kqkname" id="qtqzm_sbmc" readOnly="true" htmlEscape="false"  value="其它（请注明）"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kqk_pp" name="kqkname" id="qtqzm_pp" value="${data.qtqzm.qtqzm_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_xh" name="kqkname" id="qtqzm_xh" value="${data.qtqzm.qtqzm_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_sl" name="kqkname" id="qtqzm_sl" value="${data.qtqzm.qtqzm_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_sbjg" name="kqkname" id="qtqzm_sbjg" value="${data.qtqzm.qtqzm_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kqk_trsynf" name="kqkname" id="qtqzm_trsynf" value="${data.qtqzm.qtqzm_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="qtqzm_id"  name="kqkname" value="${data.qtqzm.qtqzm_id}"  class="form-control "/>
					
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
		
		var data = document.getElementsByName("kqkname");
	
		var datas="";
		
		
		for(i=0;i<data.length;i++){
			if(data[i].value==null||data[i].value==""){
				datas = datas +data[i].id+": ---- ;";	
			}else{
				datas = datas +data[i].id+":"+data[i].value+";";	
			}
			
			
		}
	 	
		 $.ajax({
		      url:"${ctx}/ironfoyjbylsbpzkqk/ironfoyjbylsbpzkqk/save",
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