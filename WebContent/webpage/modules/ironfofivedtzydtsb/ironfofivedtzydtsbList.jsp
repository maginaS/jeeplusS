<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>电梯设备管理</title>
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
		<form id="inputForm" modelAttribute="ironfofivedtzydtsb" action="${ctx}/ironfofivedtzydtsb/ironfofivedtzydtsb/save" method="post" class="form-horizontal">
	<%-- 	<form:hidden path="id"/>
		<sys:message content="${message}"/>	 --%>
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
					<%-- <td class="width-15 active"><label class="pull-right">备注信息：</label></td>
					<td class="width-35">
						<form:textarea path="remarks" htmlEscape="false" rows="4"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">主表id：</label></td>
					<td class="width-35">
						<form:input path="doc_id" htmlEscape="false"    class="form-control "/>
					</td> --%>
				</tr>
				<tr>
					<td>
						<c:if test="${data.czdt=='1' }">
							<input type="checkbox" name="dtsbgl_name" path="czdt" id="czdt" value="czdt" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;垂直电梯
						</c:if>
						<c:if test="${data.czdt=='0' }">
							<input type="checkbox" name ="dtsbgl_name" id="czdt" value="czdt" path="czdt" style="margin-top: -2px;"/>&nbsp;垂直电梯
						</c:if>
					</td>
					<td>
						<c:if test="${data.zdft=='1' }">
							<input type="checkbox" name="dtsbgl_name" path="zdft" id="zdft" value="zdft" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;自动扶梯
						</c:if>
						<c:if test="${data.zdft=='0' }">
							<input type="checkbox" name ="dtsbgl_name" id="zdft" value="zdft" path="zdft" style="margin-top: -2px;"/>&nbsp;自动扶梯
						</c:if>
					</td>
				
					<td>
						<c:if test="${data.bcdt=='1' }">
							<input type="checkbox" name="dtsbgl_name" path="bcdt" id="bcdt" value="bcdt" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;病床电梯
						</c:if>
						<c:if test="${data.bcdt=='0' }">
							<input type="checkbox" name ="dtsbgl_name" id="bcdt" value="bcdt" path="bcdt" style="margin-top: -2px;"/>&nbsp;病床电梯
						</c:if>
					</td>
						<input type = "hidden" htmlEscape="false" id="dtsbgl_name_id"   name="dtsbgl_name_id" value="${data.id}"  class="form-control "/>
						<input   type="hidden" name="dtsbgl_name_docId"  id="dtsbgl_name_docId"  value="${data.doc_id}" htmlEscape="false"    class="form-control "/>
						
					
		  		</tr>
		 	</tbody>
		</table>
	</form>
	
	
	
	<div style="text-align:right;">
		<input type="button" value="保存"  style="width:100px;height:50px;margin-right: 20px;" onclick="subuimtinput();"/>
	</div>
	
	
	
	<script type="text/javascript">
	

	function subuimtinput(){
		var checkval="";
		var checkout="";
		
		var data = document.getElementsByName("dtsbgl_name");
	 	var docId = document.getElementById("dtsbgl_name_docId").value;
		var id= document.getElementById("dtsbgl_name_id").value; 
		
		
		
		
	
	    check_val = [];
	    check_out = [];
	    for(a in data){
	        if(data[a].checked){
	        	  check_val.push(data[a].value);
	        }else{
	        	  check_out.push(data[a].value);
	        }  
	    } 
	    
	    checkval=checkval+check_val;
	    checkout=checkout+check_out;
		 $.ajax({
		      url:"${ctx}/ironfofivedtzydtsb/ironfofivedtzydtsb/save",
		      data:{
		    	  docId:docId,
		    	  checkval:checkval,
		    	  checkout:checkout,
		    	  id:id
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