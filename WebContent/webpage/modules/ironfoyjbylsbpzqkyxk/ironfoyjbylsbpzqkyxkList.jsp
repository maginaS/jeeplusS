<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>全科医学科管理</title>
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
		<form id="inputForm" modelAttribute="ironfoyjbylsbpzqkyxk" action="${ctx}/ironfoyjbylsbpzqkyxk/ironfoyjbylsbpzqkyxk/save" method="post" class="form-horizontal">
		<%-- <form:hidden path="id"/> --%>
	<%-- 	<sys:message content="${message}"/>	 --%>
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
						<input path="qkyxk_sbmc" id="qkyxk_sbmc"  name="qkyxfgl_name" readOnly="true" htmlEscape="false" value="其它（请注明）"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="qkyxk_pp" id="qkyxk_pp" value="${data.qkyxk.qkyxk_pp }"  name="qkyxfgl_name"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="qkyxk_xh" id="qkyxk_xh"  value="${data.qkyxk.qkyxk_xh }"   name="qkyxfgl_name"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="qkyxk_sl" id="qkyxk_sl"   value="${data.qkyxk.qkyxk_sl }"    name="qkyxfgl_name"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="qkyxk_sbjg" id="qkyxk_sbjg"    value="${data.qkyxk.qkyxk_sbjg }"   name="qkyxfgl_name"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="qkyxk_trsynf" id="qkyxk_trsynf"    value="${data.qkyxk.qkyxk_trsynf }"   name="qkyxfgl_name"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="qkyxk_id"   name="qkyxfgl_name" value="${data.qkyxk.qkyxk_id}"  class="form-control "/>
 						<input type = "hidden" htmlEscape="false" id="docId"   name="qkyxfgl_name" value="${data.doc_id}"  class="form-control "/>
 						
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
		
		var data = document.getElementsByName("qkyxfgl_name");
	
		var datas="";
		
		
		for(i=0;i<data.length;i++){
			if(data[i].value==null||data[i].value==""){
				datas = datas +data[i].id+": ---- ;";	
			}else{
				datas = datas +data[i].id+":"+data[i].value+";";	
			}
			
			
		}
	 	
		 $.ajax({
		      url:"${ctx}/ironfoyjbylsbpzqkyxk/ironfoyjbylsbpzqkyxk/save",
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