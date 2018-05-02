<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>供电方式管理</title>
	<meta name="decorator" content="default"/>
<!-- 	<script type="text/javascript">
		var validateForm;
		function doSubmit(){//回调函数，在编辑和保存动作时，供openDialog调用提交表单。
		  if(validateForm.form()){
			  $("#inputForm").submit();
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
		<form id="inputForm" modelAttribute="ironfofivedqzygdfs" action="${ctx}/ironfofivedqzygdfs/ironfofivedqzygdfs/save" method="post" class="form-horizontal">
	<%-- 	<form:hidden path="id"/>
		<sys:message content="${message}"/>	 --%>
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
					<%-- <td class="width-15 active"><label class="pull-right">备注信息：</label></td>
					<td class="width-35">
						<form:textarea path="remarks" htmlEscape="false" rows="4"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">主表：</label></td>
					<td class="width-35">
						<form:input path="doc_id" htmlEscape="false"    class="form-control "/>
					</td> --%>
				</tr>
				<tr>
					<td>
						<c:if test="${data.dwdl=='1' }">
							<input type="checkbox" name="gdfs_name" path="dwdl" id="dwdl" value="dwdl" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;电网单路
						</c:if>
						<c:if test="${data.dwdl=='0' }">
							<input type="checkbox" name="gdfs_name" path="dwdl" id="dwdl" value="dwdl" style="margin-top: -2px;"/>&nbsp;电网单路
						</c:if>
							
					</td>
					<td>
						<c:if test="${data.dwsl=='1' }">
							<input type="checkbox" name="gdfs_name" path="dwsl" id="dwsl" value="dwsl" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;电网双路
						</c:if>
						<c:if test="${data.dwsl=='0' }">
							<input type="checkbox"  name="gdfs_name" id="dwsl" value="dwsl" path="dwsl" style="margin-top: -2px;"/>&nbsp;电网双路
						</c:if>
							
					</td>
			
					<td>
						<c:if test="${data.ryfdj=='1' }">
							<input type="checkbox" name="gdfs_name" path="ryfdj" id="ryfdj" value="ryfdj" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;燃油发电机
						</c:if>
						<c:if test="${data.ryfdj=='0' }">
							<input type="checkbox"  name="gdfs_name" id="ryfdj" value="ryfdj" path="ryfdj" style="margin-top: -2px;"/>&nbsp;燃油发电机
						</c:if>
							
					</td>
					<td>
						<c:if test="${data.upszz=='1' }">
							<input type="checkbox" name="gdfs_name" path="upszz" id="upszz" value="upszz" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;UPS装置
						</c:if>
						<c:if test="${data.upszz=='0' }">
							<input type="checkbox"  name="gdfs_name" id="upszz" value="upszz" path="upszz" style="margin-top: -2px;"/>&nbsp;UPS装置
						</c:if>
						
						<input type = "hidden" htmlEscape="false" id="gdfs_name_id"   name="gdfs_name_id" value="${data.id}"  class="form-control "/>
						<input   type="hidden" name="gdfs_name_docId"  id="gdfs_name_docId"  value="${data.doc_id}" htmlEscape="false"    class="form-control "/>
						
						
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
		
		var data = document.getElementsByName("gdfs_name");
	 	var docId = document.getElementById("gdfs_name_docId").value;
		var id= document.getElementById("gdfs_name_id").value; 
		
		
		
		
	
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
		      url:"${ctx}/ironfofivedqzygdfs/ironfofivedqzygdfs/save",
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