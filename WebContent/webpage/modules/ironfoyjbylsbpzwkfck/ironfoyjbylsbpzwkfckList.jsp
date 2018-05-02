<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>外科、妇（产）科管理</title>
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
		<form id="inputForm" modelAttribute="ironfoyjbylsbpzwkfck" action="${ctx}/ironfoyjbylsbpzwkfck/ironfoyjbylsbpzwkfck/save" method="post" class="form-horizontal">
		<%-- <form:hidden path="id"/>
		<sys:message content="${message}"/>	 --%>
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
			<%-- 	<tr>
					<td class="width-15 active"><label class="pull-right">备注信息：</label></td>
					<td class="width-35">
						<form:textarea path="remarks" htmlEscape="false" rows="4"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">主表id：</label></td>
					<td class="width-35">
						<form:input path="wkfck_doc_id" htmlEscape="false"    class="form-control "/>
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
						<input path="wkfck_sbmc" name="wkfck_name" htmlEscape="false" readOnly="true" id="gzzly_sbmc"  value="光子治疗仪"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="wkfck_pp" name="wkfck_name" htmlEscape="false"  id="gzzly_pp" value="${data.gzzly.gzzly_pp }"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="wkfck_xh"  name="wkfck_name" htmlEscape="false"  id="gzzly_xh"  value="${data.gzzly.gzzly_xh }"      class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="wkfck_sl" name="wkfck_name" htmlEscape="false"  id="gzzly_sl"   value="${data.gzzly.gzzly_sl }"     class="form-control "/>
					</td>
					<td class="width-15">
						<input path="wkfck_sbjg" name="wkfck_name" htmlEscape="false"  id="gzzly_sbjg"   value="${data.gzzly.gzzly_sbjg }"     class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="wkfck_trsynf" name="wkfck_name" htmlEscape="false" id="gzzly_trsynf"    value="${data.gzzly.gzzly_trsynf }"     class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="gzzly_id"  name="wkfck_name" value="${data.gzzly.gzzly_id}"  class="form-control "/>
					    <input type = "hidden" htmlEscape="false" id="docId"   name="wkfck_name" value="${data.doc_id}"  class="form-control "/>
					
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="wkfck_sbmc" name="wkfck_name" htmlEscape="false" readOnly="true" id="qcy_sbmc"  value="清创仪"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="wkfck_pp" name="wkfck_name" htmlEscape="false"  id="qcy_pp"  value="${data.qcy.qcy_pp }"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="wkfck_xh" name="wkfck_name" htmlEscape="false"  id="qcy_xh"   value="${data.qcy.qcy_xh }"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="wkfck_sl" name="wkfck_name" htmlEscape="false"  id="qcy_sl"   value="${data.qcy.qcy_sl }"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="wkfck_sbjg" name="wkfck_name" htmlEscape="false" id="qcy_sbjg"   value="${data.qcy.qcy_sbjg }"   class="form-control "/>
					</td>
					
					<td class="width-15"> 
						<input path="wkfck_trsynf" name="wkfck_name" htmlEscape="false" id="qcy_trsynf"  value="${data.qcy.qcy_trsynf }"  class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="qcy_id"  name="wkfck_name" value="${data.qcy.qcy_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="wkfck_sbmc" name="wkfck_name" htmlEscape="false" readOnly="true" id="kqylbzllxt_sbmc"  value="空气压力波治疗系统(预防血栓)"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="wkfck_pp" name="wkfck_name" htmlEscape="false"   id="kqylbzllxt_pp" value="${data.kqylbzllxt.kqylbzllxt_pp }"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="wkfck_xh" htmlEscape="false" name="wkfck_name"   id="kqylbzllxt_xh" value="${data.kqylbzllxt.kqylbzllxt_xh }"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="wkfck_sl" name="wkfck_name" htmlEscape="false"   id="kqylbzllxt_sl" value="${data.kqylbzllxt.kqylbzllxt_sl }"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="wkfck_sbjg" name="wkfck_name" htmlEscape="false"   id="kqylbzllxt_sbjg" value="${data.kqylbzllxt.kqylbzllxt_sbjg }"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="wkfck_trsynf" name="wkfck_name" htmlEscape="false"  id="kqylbzllxt_trsynf" value="${data.kqylbzllxt.kqylbzllxt_trsynf }"   class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="kqylbzllxt_id"  name="wkfck_name" value="${data.kqylbzllxt.kqylbzllxt_id}"  class="form-control "/>
				
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="wkfck_sbmc" name="wkfck_name" htmlEscape="false" readOnly="true" id="twcsssj_sbmc"  value="体外超声碎石机"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="wkfck_pp" name="wkfck_name" htmlEscape="false"  id="twcsssj_pp"  value="${data.twcsssj.twcsssj_pp }"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="wkfck_xh" name="wkfck_name" htmlEscape="false"   id="twcsssj_xh"  value="${data.twcsssj.twcsssj_xh }"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="wkfck_sl" name="wkfck_name" htmlEscape="false"   id="twcsssj_sl"  value="${data.twcsssj.twcsssj_sl }"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="wkfck_sbjg" name="wkfck_name" htmlEscape="false"   id="twcsssj_sbjg"  value="${data.twcsssj.twcsssj_sbjg }"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="wkfck_trsynf" name="wkfck_name" htmlEscape="false"   id="twcsssj_trsynf"  value="${data.twcsssj.twcsssj_trsynf }"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="twcsssj_id"  name="wkfck_name" value="${data.twcsssj.twcsssj_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="wkfck_sbmc" name="wkfck_name" htmlEscape="false" readOnly="true" id="jgssj_sbmc"  value="激光碎石机"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="wkfck_pp" name="wkfck_name" htmlEscape="false" value="${data.jgssj.jgssj_pp }"  id="jgssj_pp"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="wkfck_xh" name="wkfck_name" htmlEscape="false" value="${data.jgssj.jgssj_xh }"    id="jgssj_xh"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="wkfck_sl" name="wkfck_name" htmlEscape="false" value="${data.jgssj.jgssj_sl }"   id="jgssj_sl"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="wkfck_sbjg" name="wkfck_name" htmlEscape="false" value="${data.jgssj.jgssj_sbjg }"    id="jgssj_sbjg"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="wkfck_trsynf" name="wkfck_name" htmlEscape="false" value="${data.jgssj.jgssj_trsynf }"    id="jgssj_trsynf"   class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="jgssj_id"  name="wkfck_name" value="${data.jgssj.jgssj_id}"  class="form-control "/>
				
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="wkfck_sbmc" name="wkfck_name" htmlEscape="false" readOnly="true" id="ndlxfxxt_sbmc"  value="尿动力学分析系统"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="wkfck_pp" name="wkfck_name" htmlEscape="false"  id="ndlxfxxt_pp" value="${data.ndlxfxxt.ndlxfxxt_pp }"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="wkfck_xh" name="wkfck_name" htmlEscape="false"  id="ndlxfxxt_xh"  value="${data.ndlxfxxt.ndlxfxxt_xh }"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="wkfck_sl" name="wkfck_name" htmlEscape="false"   id="ndlxfxxt_sl" value="${data.ndlxfxxt.ndlxfxxt_sl }"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="wkfck_sbjg" name="wkfck_name" htmlEscape="false"  id="ndlxfxxt_sbjg"  value="${data.ndlxfxxt.ndlxfxxt_sbjg }"   class="form-control "/>
					</td>
					
					<td class="width-15"> 
						<input path="wkfck_trsynf" name="wkfck_name" htmlEscape="false" id="ndlxfxxt_trsynf"  value="${data.ndlxfxxt.ndlxfxxt_trsynf }"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="ndlxfxxt_id"  name="wkfck_name" value="${data.ndlxfxxt.ndlxfxxt_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="wkfck_sbmc" name="wkfck_name" htmlEscape="false" readOnly="true" id="pgj_sbmc"  value="膀胱镜"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="wkfck_pp" name="wkfck_name" htmlEscape="false"  id="pgj_pp"  value="${data.pgj.pgj_pp }"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="wkfck_xh" name="wkfck_name" htmlEscape="false" id="pgj_xh"   value="${data.pgj.pgj_xh }"     class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="wkfck_sl" name="wkfck_name" htmlEscape="false"   id="pgj_sl"  value="${data.pgj.pgj_sl }"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="wkfck_sbjg" name="wkfck_name" htmlEscape="false"  id="pgj_sbjg"   value="${data.pgj.pgj_sbjg }"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="wkfck_trsynf" name="wkfck_name" htmlEscape="false"  id="pgj_trsynf"   value="${data.pgj.pgj_trsynf }"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="pgj_id"  name="wkfck_name" value="${data.pgj.pgj_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="wkfck_sbmc" name="wkfck_name" htmlEscape="false" readOnly="true" id="gkdlxt_sbmc"  value="骨科动力系统"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="wkfck_pp" name="wkfck_name" htmlEscape="false"  id="gkdlxt_pp"  value="${data.gkdlxt.gkdlxt_pp }"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="wkfck_xh" name="wkfck_name" htmlEscape="false"  id="gkdlxt_xh"  value="${data.gkdlxt.gkdlxt_xh }"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="wkfck_sl" name="wkfck_name" htmlEscape="false"  id="gkdlxt_sl"   value="${data.gkdlxt.gkdlxt_sl }"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="wkfck_sbjg" name="wkfck_name" htmlEscape="false"  id="gkdlxt_sbjg" value="${data.gkdlxt.gkdlxt_sbjg }"     class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="wkfck_trsynf" name="wkfck_name" htmlEscape="false"  id="gkdlxt_trsynf"  value="${data.gkdlxt.gkdlxt_trsynf }"    class="form-control "/>
					    <input type = "hidden" htmlEscape="false" id="gkdlxt_id"  name="wkfck_name" value="${data.gkdlxt.gkdlxt_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="wkfck_sbmc" name="wkfck_name" htmlEscape="false" readOnly="true" id="dgnqyc_sbmc"  value="多功能牵引床"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="wkfck_pp" name="wkfck_name" htmlEscape="false" id="dgnqyc_pp"  value="${data.dgnqyc.dgnqyc_pp }"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="wkfck_xh" name="wkfck_name" htmlEscape="false" id="dgnqyc_xh"  value="${data.dgnqyc.dgnqyc_xh }"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="wkfck_sl" name="wkfck_name" htmlEscape="false"  id="dgnqyc_sl"  value="${data.dgnqyc.dgnqyc_sl }"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="wkfck_sbjg" name="wkfck_name" htmlEscape="false"  id="dgnqyc_sbjg"  value="${data.dgnqyc.dgnqyc_sbjg }"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="wkfck_trsynf" name="wkfck_name" htmlEscape="false"  id="dgnqyc_trsynf"  value="${data.dgnqyc.dgnqyc_trsynf }"   class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="dgnqyc_id"  name="wkfck_name" value="${data.dgnqyc.dgnqyc_id}"  class="form-control "/>
					
					
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="wkfck_sbmc" name="wkfck_name" htmlEscape="false" readOnly="true" id="gqjxt_sbmc"  value="宫腔镜系统"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="wkfck_pp" name="wkfck_name" htmlEscape="false"  id="gqjxt_pp"  value="${data.gqjxt.gqjxt_pp }"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="wkfck_xh" name="wkfck_name" htmlEscape="false"  id="gqjxt_xh"   value="${data.gqjxt.gqjxt_xh }"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="wkfck_sl" name="wkfck_name" htmlEscape="false" id="gqjxt_sl"   value="${data.gqjxt.gqjxt_sl }"     class="form-control "/>
					</td>
					<td class="width-15">
						<input path="wkfck_sbjg" name="wkfck_name" htmlEscape="false" id="gqjxt_sbjg"    value="${data.gqjxt.gqjxt_sbjg }"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="wkfck_trsynf" name="wkfck_name" htmlEscape="false"  id="gqjxt_trsynf"   value="${data.gqjxt.gqjxt_trsynf }"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="gqjxt_id"  name="wkfck_name" value="${data.gqjxt.gqjxt_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="wkfck_sbmc" name="wkfck_name" htmlEscape="false" readOnly="true" id="bcxbjctct_sbmc"  value="薄层细胞检测TCT"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="wkfck_pp" name="wkfck_name" htmlEscape="false"  id="bcxbjctct_pp"  value="${data.bcxbjctct.bcxbjctct_pp }"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="wkfck_xh" name="wkfck_name" htmlEscape="false"  id="bcxbjctct_xh"  value="${data.bcxbjctct.bcxbjctct_xh }"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="wkfck_sl" name="wkfck_name" htmlEscape="false"  id="bcxbjctct_sl"   value="${data.bcxbjctct.bcxbjctct_sl }" class="form-control "/>
					</td>
					<td class="width-15">
						<input path="wkfck_sbjg" name="wkfck_name" htmlEscape="false"  id="bcxbjctct_sbjg"  value="${data.bcxbjctct.bcxbjctct_sbjg }"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="wkfck_trsynf" name="wkfck_name" htmlEscape="false"  id="bcxbjctct_trsynf" value="${data.bcxbjctct.bcxbjctct_trsynf }"   class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="bcxbjctct_id"  name="wkfck_name" value="${data.bcxbjctct.bcxbjctct_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="wkfck_sbmc" name="wkfck_name" htmlEscape="false" readOnly="true" id="txjhxt_sbmc"  value="胎心监护系统"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="wkfck_pp" name="wkfck_name" htmlEscape="false" id="txjhxt_pp"  value="${data.txjhxt.txjhxt_pp }"    class="form-control "/>
					</td>
					
					<td class="width-15"> 
						<input path="wkfck_xh" name="wkfck_name" htmlEscape="false"   id="txjhxt_xh"  value="${data.txjhxt.txjhxt_xh }"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="wkfck_sl" name="wkfck_name" htmlEscape="false"  id="txjhxt_sl"  value="${data.txjhxt.txjhxt_sl }"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="wkfck_sbjg" name="wkfck_name" htmlEscape="false"  id="txjhxt_sbjg"   value="${data.txjhxt.txjhxt_sbjg }"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="wkfck_trsynf" name="wkfck_name" htmlEscape="false"  id="txjhxt_trsynf"   value="${data.txjhxt.txjhxt_trsynf }"   class="form-control "/>
					    <input type = "hidden" htmlEscape="false" id="txjhxt_id"  name="wkfck_name" value="${data.txjhxt.txjhxt_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="wkfck_sbmc" name="wkfck_name" htmlEscape="false" readOnly="true" id="dzydj_sbmc"  value="电子阴道镜"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="wkfck_pp" name="wkfck_name" htmlEscape="false"  id="dzydj_pp"  value="${data.dzydj.dzydj_pp }"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="wkfck_xh" name="wkfck_name" htmlEscape="false"  id="dzydj_xh"   value="${data.dzydj.dzydj_xh }"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="wkfck_sl" name="wkfck_name" htmlEscape="false"   id="dzydj_sl"  value="${data.dzydj.dzydj_sl }"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="wkfck_sbjg" name="wkfck_name" htmlEscape="false"   id="dzydj_sbjg"  value="${data.dzydj.dzydj_sbjg }"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="wkfck_trsynf" name="wkfck_name" htmlEscape="false"  id="dzydj_trsynf"   value="${data.dzydj.dzydj_trsynf }"   class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="dzydj_id"  name="wkfck_name" value="${data.dzydj.dzydj_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15"> 
						<input path="wkfck_sbmc" name="wkfck_name" htmlEscape="false" readOnly="true" id="fkzlc_sbmc"  value="妇科诊疗床"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="wkfck_pp" name="wkfck_name" htmlEscape="false" id="fkzlc_pp"  value="${data.fkzlc.fkzlc_pp }"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="wkfck_xh" name="wkfck_name" htmlEscape="false"    id="fkzlc_xh" value="${data.fkzlc.fkzlc_xh }"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="wkfck_sl" name="wkfck_name" htmlEscape="false"  id="fkzlc_sl" value="${data.fkzlc.fkzlc_sl }"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="wkfck_sbjg" name="wkfck_name" htmlEscape="false"  id="fkzlc_sbjg"  value="${data.fkzlc.fkzlc_sbjg }"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="wkfck_trsynf" name="wkfck_name" htmlEscape="false"  id="fkzlc_trsynf"  value="${data.fkzlc.fkzlc_trsynf }"   class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="fkzlc_id"  name="wkfck_name" value="${data.fkzlc.fkzlc_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				
				<tr>
					<td class="width-15">
						<input path="wkfck_sbmc" name="wkfck_name" htmlEscape="false" readOnly="true" id="qtqzm_sbmc" value="其它（请注明）"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="wkfck_pp" name="wkfck_name" htmlEscape="false"   id="qtqzm_pp" value="${data.qtqzm.qtqzm_pp }"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="wkfck_xh" name="wkfck_name" htmlEscape="false"  id="qtqzm_xh"   value="${data.qtqzm.qtqzm_xh }"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="wkfck_sl" name="wkfck_name" htmlEscape="false"  id="qtqzm_sl"   value="${data.qtqzm.qtqzm_sl }"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="wkfck_sbjg" name="wkfck_name" htmlEscape="false"   id="qtqzm_sbjg"  value="${data.qtqzm.qtqzm_sbjg }"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="wkfck_trsynf" name="wkfck_name" htmlEscape="false"  id="qtqzm_trsynf"  value="${data.qtqzm.qtqzm_trsynf }"   class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="qtqzm_id"  name="wkfck_name" value="${data.qtqzm.qtqzm_id}"  class="form-control "/>
					
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
		
		var data = document.getElementsByName("wkfck_name");
	
		var datas="";
		
		
		for(i=0;i<data.length;i++){
			if(data[i].value==null||data[i].value==""){
				datas = datas +data[i].id+": ---- ;";	
			}else{
				datas = datas +data[i].id+":"+data[i].value+";";	
			}
			
			
		}
	 	
		 $.ajax({
		      url:"${ctx}/ironfoyjbylsbpzwkfck/ironfoyjbylsbpzwkfck/save",
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