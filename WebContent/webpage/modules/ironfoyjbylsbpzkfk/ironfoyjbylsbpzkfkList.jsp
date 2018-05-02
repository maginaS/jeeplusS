
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>康复科管理</title>
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
		<form id="inputForm" modelAttribute="ironfoyjbylsbpzkfk" action="${ctx}/ironfoyjbylsbpzkfk/ironfoyjbylsbpzkfk/save" method="post" class="form-horizontal">
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
						<input path="kfk_sbmc" name="kfkgl_name" id="gnwdnzly_sbmc" readOnly="true" htmlEscape="false"  value="光能微电脑治疗仪"  class="form-control "/>
					</td>
					<td class="width-15"> 
						<input path="kfk_pp" name="kfkgl_name" id="gnwdnzly_pp" value="${data.gnwdnzly.gnwdnzly_pp }" htmlEscape="false"    class="form-control "/>
					</td>
				
					<td class="width-15">
						<input path="kfk_xh" name="kfkgl_name" id="gnwdnzly_xh" value="${data.gnwdnzly.gnwdnzly_xh }" id="gnwdnzly_sbmc" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kfk_sl" name="kfkgl_name" id="gnwdnzly_sl" value="${data.gnwdnzly.gnwdnzly_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kfk_sbjg" name="kfkgl_name" id="gnwdnzly_sbjg" value="${data.gnwdnzly.gnwdnzly_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kfk_trsynf" name="kfkgl_name" id="gnwdnzly_trsynf" value="${data.gnwdnzly.gnwdnzly_trsynf }" htmlEscape="false"    class="form-control "/>
					
						<input type = "hidden" htmlEscape="false" id="gnwdnzly_id"  name="kfkgl_name" value="${data.gnwdnzly.gnwdnzly_id}"  class="form-control "/>
					    <input type = "hidden" htmlEscape="false" id="docId"   name="kfkgl_name" value="${data.doc_id}"  class="form-control "/>
					
					
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="kfk_sbmc" name="kfkgl_name" id="hwzly_sbmc" readOnly="true" htmlEscape="false"  value="红外治疗仪"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kfk_pp" name="kfkgl_name" id="hwzly_pp" value="${data.hwzly.hwzly_pp }" htmlEscape="false"    class="form-control "/>
					</td>
				
					<td class="width-15">
						<input path="kfk_xh" name="kfkgl_name" id="hwzly_xh" value="${data.hwzly.hwzly_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kfk_sl" name="kfkgl_name" id="hwzly_sl" value="${data.hwzly.hwzly_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kfk_sbjg" name="kfkgl_name" id="hwzly_sbjg" value="${data.hwzly.hwzly_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kfk_trsynf" name="kfkgl_name" id="hwzly_trsynf" value="${data.hwzly.hwzly_trsynf }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="hwzly_id"  name="kfkgl_name" value="${data.hwzly.hwzly_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="kfk_sbmc" name="kfkgl_name" id="sjxtkfzlgzz_sbmc" readOnly="true" htmlEscape="false"  value="神经系统康复治疗工作站"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kfk_pp" name="kfkgl_name" id="sjxtkfzlgzz_pp" value="${data.sjxtkfzlgzz.sjxtkfzlgzz_pp }" htmlEscape="false"    class="form-control "/>
					</td>
				
					<td class="width-15">
						<input path="kfk_xh" name="kfkgl_name"  id="sjxtkfzlgzz_xh" value="${data.sjxtkfzlgzz.sjxtkfzlgzz_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kfk_sl" name="kfkgl_name" id="sjxtkfzlgzz_sl" value="${data.sjxtkfzlgzz.sjxtkfzlgzz_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kfk_sbjg" name="kfkgl_name" id="sjxtkfzlgzz_sbjg" value="${data.sjxtkfzlgzz.sjxtkfzlgzz_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kfk_trsynf" name="kfkgl_name" id="sjxtkfzlgzz_trsynf" value="${data.sjxtkfzlgzz.sjxtkfzlgzz_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="sjxtkfzlgzz_id"  name="kfkgl_name" value="${data.sjxtkfzlgzz.sjxtkfzlgzz_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="kfk_sbmc" name="kfkgl_name" id="mcczly_sbmc" readOnly="true" htmlEscape="false"  value="脉冲磁治疗仪"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kfk_pp" name="kfkgl_name"  id="mcczly_pp"  value="${data.mcczly.mcczly_pp }" htmlEscape="false"    class="form-control "/>
					</td>
				
					<td class="width-15">
						<input path="kfk_xh" name="kfkgl_name"  id="mcczly_xh"  value="${data.mcczly.mcczly_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kfk_sl" name="kfkgl_name"  id="mcczly_sl" value="${data.mcczly.mcczly_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kfk_sbjg" name="kfkgl_name"  id="mcczly_sbjg" value="${data.mcczly.mcczly_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kfk_trsynf" name="kfkgl_name"  id="mcczly_trsynf" value="${data.mcczly.mcczly_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="mcczly_id"  name="kfkgl_name" value="${data.mcczly.mcczly_id}"  class="form-control "/>
					
					
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="kfk_sbmc" name="kfkgl_name" id="ddqlc_sbmc" readOnly="true" htmlEscape="false"  value="电动起立床"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kfk_pp"  name="kfkgl_name" id="ddqlc_pp" value="${data.ddqlc.ddqlc_pp }" htmlEscape="false"    class="form-control "/>
					</td>
				
					<td class="width-15">
						<input path="kfk_xh" name="kfkgl_name" id="ddqlc_xh" value="${data.ddqlc.ddqlc_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kfk_sl" name="kfkgl_name" id="ddqlc_sl" value="${data.ddqlc.ddqlc_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kfk_sbjg" name="kfkgl_name" id="ddqlc_sbjg" value="${data.ddqlc.ddqlc_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kfk_trsynf" name="kfkgl_name" id="ddqlc_trsynf" value="${data.ddqlc.ddqlc_trsynf }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="ddqlc_id"  name="kfkgl_name" value="${data.ddqlc.ddqlc_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="kfk_sbmc" name="kfkgl_name" id="qlc_sbmc" readOnly="true" htmlEscape="false"  value="站立床"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kfk_pp" name="kfkgl_name" id="qlc_pp" value="${data.qlc.qlc_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
				
					<td class="width-15"> 
						<input path="kfk_xh" name="kfkgl_name" id="qlc_xh" value="${data.qlc.qlc_xh }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kfk_sl" name="kfkgl_name" id="qlc_sl"  value="${data.qlc.qlc_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kfk_sbjg" name="kfkgl_name" id="qlc_sbjg" value="${data.qlc.qlc_sbjg }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kfk_trsynf" name="kfkgl_name" id="qlc_trsynf" value="${data.qlc.qlc_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="qlc_id"  name="kfkgl_name" value="${data.qlc.qlc_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
					<tr>
					<td class="width-15">
						<input path="kfk_sbmc" name="kfkgl_name" id="ddqyc_sbmc" readOnly="true" htmlEscape="false"  value="电动牵引床"  class="form-control "/>
					</td>
					<td class="width-15"> 
						<input path="kfk_pp"  name="kfkgl_name" id="ddqyc_pp" value="${data.ddqyc.ddqyc_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
				
					<td class="width-15">
						<input path="kfk_xh" name="kfkgl_name" id="ddqyc_xh" value="${data.ddqyc.ddqyc_xh }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kfk_sl" name="kfkgl_name" id="ddqyc_sl"  value="${data.ddqyc.ddqyc_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15"> 
						<input path="kfk_sbjg" name="kfkgl_name" id="ddqyc_sbjg"  value="${data.ddqyc.ddqyc_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kfk_trsynf" name="kfkgl_name" id="ddqyc_trsynf" value="${data.ddqyc.ddqyc_trsynf }"   htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="ddqyc_id"  name="kfkgl_name" value="${data.ddqyc.ddqyc_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
					<tr>
					<td class="width-15">
						<input path="kfk_sbmc" name="kfkgl_name" htmlEscape="false" readOnly="true" id="csbzly_sbmc"  value="超声波治疗仪"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kfk_pp" name="kfkgl_name" htmlEscape="false"  id="csbzly_pp" value="${data.csbzly.csbzly_pp }"  class="form-control "/>
					</td>
				
					<td class="width-15">
						<input path="kfk_xh" name="kfkgl_name" htmlEscape="false" id="csbzly_xh"  value="${data.csbzly.csbzly_xh }"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kfk_sl" name="kfkgl_name" htmlEscape="false"  id="csbzly_sl"  value="${data.csbzly.csbzly_sl }"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kfk_sbjg" name="kfkgl_name" htmlEscape="false"  id="csbzly_sbjg"  value="${data.csbzly.csbzly_sbjg }"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kfk_trsynf" name="kfkgl_name" htmlEscape="false" id="csbzly_trsynf" value="${data.csbzly.csbzly_trsynf }"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="csbzly_id"  name="kfkgl_name" value="${data.csbzly.csbzly_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="kfk_sbmc" name="kfkgl_name" id="nxhzhzlj_sbmc" readOnly="true" htmlEscape="false"  value="脑循环综合治疗机"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kfk_pp" name="kfkgl_name" id="nxhzhzlj_pp" htmlEscape="false"  value="${ data.nxhzhzlj.nxhzhzlj_pp}"  class="form-control "/>
					</td>
				
					<td class="width-15">
						<input path="kfk_xh" name="kfkgl_name" id="nxhzhzlj_xh" htmlEscape="false"  value="${ data.nxhzhzlj.nxhzhzlj_xh}"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kfk_sl" htmlEscape="false" name="kfkgl_name"  id="nxhzhzlj_sl" value="${ data.nxhzhzlj.nxhzhzlj_sl}"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kfk_sbjg" name="kfkgl_name" id="nxhzhzlj_sbjg" htmlEscape="false"   value="${ data.nxhzhzlj.nxhzhzlj_sbjg}"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kfk_trsynf" name="kfkgl_name" id="nxhzhzlj_trsynf" htmlEscape="false"  value="${ data.nxhzhzlj.nxhzhzlj_trsynf}"   class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="nxhzhzlj_id"  name="kfkgl_name" value="${data.nxhzhzlj.nxhzhzlj_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="kfk_sbmc" name="kfkgl_name" htmlEscape="false" readOnly="true" id="kqylbzlxt_sbmc"  value="空气压力波治疗系统(水肿治疗)"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kfk_pp" name="kfkgl_name" htmlEscape="false" id="kqylbzlxt_pp"  value="${data.kqylbzlxt.kqylbzlxt_pp }"  class="form-control "/>
					</td>
				
					<td class="width-15">
						<input path="kfk_xh" name="kfkgl_name" htmlEscape="false"  id="kqylbzlxt_xh"  value="${data.kqylbzlxt.kqylbzlxt_xh }"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kfk_sl"  name="kfkgl_name" htmlEscape="false" id="kqylbzlxt_sl"  value="${data.kqylbzlxt.kqylbzlxt_sl }"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kfk_sbjg" name="kfkgl_name" htmlEscape="false"  id="kqylbzlxt_sbjg" value="${data.kqylbzlxt.kqylbzlxt_sbjg }"   class="form-control "/>
					</td>
					
					<td class="width-15"> 
						<input path="kfk_trsynf" name="kfkgl_name" htmlEscape="false"  id="kqylbzlxt_trsynf" value="${data.kqylbzlxt.kqylbzlxt_trsynf }"   class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="kqylbzlxt_id"  name="kfkgl_name" value="${data.kqylbzlxt.kqylbzlxt_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="kfk_sbmc" name="kfkgl_name" htmlEscape="false" readOnly="true" id="dnzpzly_sbmc"  value="电脑中频治疗仪"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kfk_pp" name="kfkgl_name" htmlEscape="false"  id="dnzpzly_pp"  value="${data.dnzpzly.dnzpzly_pp }"  class="form-control "/>
					</td>
				
					<td class="width-15">
						<input path="kfk_xh" name="kfkgl_name" htmlEscape="false"  id="dnzpzly_xh"   value="${data.dnzpzly.dnzpzly_xh }"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kfk_sl" name="kfkgl_name" htmlEscape="false"  id="dnzpzly_sl"   value="${data.dnzpzly.dnzpzly_sl }"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kfk_sbjg" name="kfkgl_name" htmlEscape="false"  id="dnzpzly_sbjg"   value="${data.dnzpzly.dnzpzly_sbjg }"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kfk_trsynf" name="kfkgl_name" htmlEscape="false"  id="dnzpzly_trsynf"   value="${data.dnzpzly.dnzpzly_trsynf }"   class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="dnzpzly_id"  name="kfkgl_name" value="${data.dnzpzly.dnzpzly_id}"  class="form-control "/>
				
				
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="kfk_sbmc" name="kfkgl_name" htmlEscape="false" readOnly="true" id="dpzly_sbmc"  value="低频治疗仪"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kfk_pp" name="kfkgl_name" htmlEscape="false" id="dpzly_pp" value="${data.dpzly.dpzly_pp }"  class="form-control "/>
					</td>
				
					<td class="width-15">
						<input path="kfk_xh" name="kfkgl_name" htmlEscape="false" id="dpzly_xh" value="${data.dpzly.dpzly_xh }"   class="form-control "/>
					</td>
					
					<td class="width-15"> 
						<input path="kfk_sl"  name="kfkgl_name" htmlEscape="false"  id="dpzly_sl"  value="${data.dpzly.dpzly_sl }"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kfk_sbjg" name="kfkgl_name" htmlEscape="false"  id="dpzly_sbjg" value="${data.dpzly.dpzly_sbjg }"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kfk_trsynf" name="kfkgl_name" htmlEscape="false" id="dpzly_trsynf"  value="${data.dpzly.dpzly_trsynf }"  class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="dpzly_id"  name="kfkgl_name" value="${data.dpzly.dpzly_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="kfk_sbmc" name="kfkgl_name" id="llzyxwbj_sbmc" readOnly="true" htmlEscape="false"  value="理疗专用型微波机"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kfk_pp" name="kfkgl_name"  id="llzyxwbj_pp" value="${data.llzyxwbj.llzyxwbj_pp }" htmlEscape="false"    class="form-control "/>
					</td>
				
					<td class="width-15">
						<input path="kfk_xh" name="kfkgl_name"  id="llzyxwbj_xh"  value="${data.llzyxwbj.llzyxwbj_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kfk_sl" name="kfkgl_name"  id="llzyxwbj_sl"  value="${data.llzyxwbj.llzyxwbj_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kfk_sbjg" name="kfkgl_name"  id="llzyxwbj_sbjg"  value="${data.llzyxwbj.llzyxwbj_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kfk_trsynf" name="kfkgl_name"  id="llzyxwbj_trsynf"  value="${data.llzyxwbj.llzyxwbj_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="llzyxwbj_id"  name="kfkgl_name" value="${data.llzyxwbj.llzyxwbj_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
					<tr>
					<td class="width-15"> 
						<input path="kfk_sbmc" name="kfkgl_name" htmlEscape="false"  readOnly="true" id="gyyc_sbmc" value="高压氧仓"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kfk_pp" name="kfkgl_name" htmlEscape="false" id="gyyc_pp"  value="${data.gyyc.gyyc_pp }"  class="form-control "/>
					</td>
				
					<td class="width-15">
						<input path="kfk_xh" name="kfkgl_name" htmlEscape="false"  id="gyyc_xh"  value="${data.gyyc.gyyc_xh }"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kfk_sl" name="kfkgl_name" htmlEscape="false"  id="gyyc_sl"   value="${data.gyyc.gyyc_sl }" class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kfk_sbjg" name="kfkgl_name" htmlEscape="false" id="gyyc_sbjg"   value="${data.gyyc.gyyc_sbjg }"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kfk_trsynf" name="kfkgl_name" htmlEscape="false" id="gyyc_trsynf"  value="${data.gyyc.gyyc_trsynf }"   class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="gyyc_id"  name="kfkgl_name" value="${data.gyyc.gyyc_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
					<tr>
					<td class="width-15">
						<input path="kfk_sbmc" name="kfkgl_name" htmlEscape="false" readOnly="true" id="phxlxt_sbmc"  value="平衡训练系统"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kfk_pp" name="kfkgl_name" htmlEscape="false" id="phxlxt_pp"  value="${data.phxlxt.phxlxt_pp }"   class="form-control "/>
					</td>
				
					<td class="width-15">
						<input path="kfk_xh" name="kfkgl_name" htmlEscape="false" id="phxlxt_xh" value="${data.phxlxt.phxlxt_xh }"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kfk_sl" name="kfkgl_name" htmlEscape="false"  id="phxlxt_sl" value="${data.phxlxt.phxlxt_sl }"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kfk_sbjg" name="kfkgl_name" htmlEscape="false"  id="phxlxt_sbjg" value="${data.phxlxt.phxlxt_sbjg }"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kfk_trsynf" name="kfkgl_name" htmlEscape="false" id="phxlxt_trsynf"  value="${data.phxlxt.phxlxt_trsynf }"   class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="phxlxt_id"  name="kfkgl_name" value="${data.phxlxt.phxlxt_id}"  class="form-control "/>
				
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="kfk_sbmc" name="kfkgl_name" id="qjjhsb_sbmc" readOnly="true" htmlEscape="false"  value="情景交互设备"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kfk_pp" name="kfkgl_name" id="qjjhsb_pp" value="${data.qjjhsb.qjjhsb_pp }" htmlEscape="false"    class="form-control "/>
					</td>
				
					<td class="width-15">
						<input path="kfk_xh" name="kfkgl_name" id="qjjhsb_xh" value="${data.qjjhsb.qjjhsb_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kfk_sl" name="kfkgl_name" id="qjjhsb_sl" value="${data.qjjhsb.qjjhsb_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kfk_sbjg" name="kfkgl_name" id="qjjhsb_sbjg" value="${data.qjjhsb.qjjhsb_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td> 
					
					<td class="width-15">
						<input path="kfk_trsynf" name="kfkgl_name" id="qjjhsb_trsynf" value="${data.qjjhsb.qjjhsb_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="qjjhsb_id"  name="kfkgl_name" value="${data.qjjhsb.qjjhsb_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="kfk_sbmc" name="kfkgl_name" id="qtqzm_sbmc" readOnly="true" htmlEscape="false"  value="其它（请注明）"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kfk_pp" name="kfkgl_name" id="qtqzm_pp" value="${data.qtqzm.qtqzm_pp }" htmlEscape="false"    class="form-control "/>
					</td>
				
					<td class="width-15">
						<input path="kfk_xh" name="kfkgl_name" id="qtqzm_xh" value="${data.qtqzm.qtqzm_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kfk_sl" name="kfkgl_name" id="qtqzm_sl" value="${data.qtqzm.qtqzm_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="kfk_sbjg" name="kfkgl_name" id="qtqzm_sbjg" value="${data.qtqzm.qtqzm_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="kfk_trsynf" name="kfkgl_name" id="qtqzm_trsynf" value="${data.qtqzm.qtqzm_trsynf }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="qtqzm_id"  name="kfkgl_name" value="${data.qtqzm.qtqzm_id}"  class="form-control "/>
					
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
		
		var data = document.getElementsByName("kfkgl_name");
	
		var datas="";
		
		
		for(i=0;i<data.length;i++){
			if(data[i].value==null||data[i].value==""){
				datas = datas +data[i].id+": ---- ;";	
			}else{
				datas = datas +data[i].id+":"+data[i].value+";";	
			}
			
			
		}
	 	
		 $.ajax({
		      url:"${ctx}/ironfoyjbylsbpzkfk/ironfoyjbylsbpzkfk/save",
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