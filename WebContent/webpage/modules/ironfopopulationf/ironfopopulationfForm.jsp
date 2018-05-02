<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>5.1.2建筑分布概况管理</title>
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
		<form id="inputForm" modelAttribute="ironfopopulationf" action="${ctx}/ironfopopulationf/ironfopopulationf/save" method="post" class="form-horizontal">
		<%-- <form:hidden path="id"/>
		<sys:message content="${message}"/>	 --%>
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
					
					<td class="width-15 active"><label class="pull-right">建筑名称：</label></td>
					<td class="width-35">
						<input path="jzmc" htmlEscape="false" value="${data.jzmc }" name="jzfbgk_name"  id="jzmc"   class="form-control "/>
					</td>
					<td class="width-15 active"></td>
		   			<td class="width-35" ></td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">建筑功能：</label></td>
					<td class="width-35">
						<input path="jzgn" id="jzgn"   value="${data.jzgn }" htmlEscape="false"  name="jzfbgk_name"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">地上层数：</label></td>
					<td class="width-35">
						<input path="dscs" id="dscs"  value="${data.dscs }"  htmlEscape="false"   name="jzfbgk_name"   class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">地下层数：</label></td>
					<td class="width-35">
						<input path="dxcs" id="dxcs"   value="${data.dxcs }" htmlEscape="false"   name="jzfbgk_name"   class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">投入使用时间：</label></td>
					<td class="width-35">
						<input path="trsysj" id="trsysj"  value="${data.trsysj }"  htmlEscape="false" name="jzfbgk_name"    class="form-control "/>
						<input  type = "hidden"  path="doc_id" id="doc_id"  value="${data.doc_id }"  htmlEscape="false" name="jzfbgk_name"    class="form-control "/>
						<input  type = "hidden"  path="id" id="id"   value="${data.id }" htmlEscape="false" name="jzfbgk_name"    class="form-control "/>
					
					
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
		
		var data = document.getElementsByName("jzfbgk_name");
	
		var datas="";
		
		
		for(i=0;i<data.length;i++){
			if(data[i].value==null||data[i].value==""){
				datas = datas +data[i].id+": ---- ;";	
			}else{
				datas = datas +data[i].id+":"+data[i].value+";";	
			}
			
			
		}
	 	
		 $.ajax({
		      url:"${ctx}/ironfopopulationf/ironfopopulationf/save",
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