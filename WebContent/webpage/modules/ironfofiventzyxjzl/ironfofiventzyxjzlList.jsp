<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>夏季制冷管理</title>
	<meta name="decorator" content="default"/>
<!-- 	<script type="text/javascript">
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
	</script> -->
</head>
<body class="hideScroll">
		<form id="inputForm" modelAttribute="ironfofiventzyxjzl" action="${ctx}/ironfofiventzyxjzl/ironfofiventzyxjzl/save" method="post" class="form-horizontal">
	
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
				
				</tr>
				<tr>
					<td>
						<c:if test="${data.zykt=='1' }">
							<input type="checkbox" name="xjzlgl_name" path="zykt" id="zykt" value="zykt" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;中央空调
						</c:if>
						<c:if test="${data.zykt=='0' }">
							<input type="checkbox" path="zykt" name="xjzlgl_name" id="zykt" value="zykt" style="margin-top: -2px;"/>&nbsp;中央空调
						</c:if>
					</td>
					<td>
					
						<c:if test="${data.ftkt=='1' }">
							<input type="checkbox" name="xjzlgl_name" path="ftkt" id="ftkt" value="ftkt" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;分体空调
						</c:if>
						<c:if test="${data.ftkt=='0' }">
							<input type="checkbox" path="ftkt" name="xjzlgl_name" id="ftkt" value="ftkt" style="margin-top: -2px;"/>&nbsp;分体空调
						</c:if>
						
						
								
						<input type = "hidden" htmlEscape="false" id="xjzlgl_name_id"   name="xjzlgl_name_id" value="${data.id}"  class="form-control "/>
						<input   type="hidden" name="xjzlgl_name_docId"  id="xjzlgl_name_docId"  value="${data.doc_id}" htmlEscape="false"    class="form-control "/>
						
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
		var checkval="";
		var checkout="";
		
		var data = document.getElementsByName("xjzlgl_name");
	 	var docId = document.getElementById("xjzlgl_name_docId").value;
		var id= document.getElementById("xjzlgl_name_id").value; 
		
		
		
		
	
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
		      url:"${ctx}/ironfofiventzyxjzl/ironfofiventzyxjzl/save",
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