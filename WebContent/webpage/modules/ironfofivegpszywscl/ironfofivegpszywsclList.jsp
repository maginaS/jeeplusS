<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>污水处理管理</title>
	<meta name="decorator" content="default"/>
	
</head>
<body class="hideScroll">
		<form id="inputForm" modelAttribute="ironfofivegpszywscl" action="${ctx}/ironfofivegpszywscl/ironfofivegpszywscl/save" method="post" class="form-horizontal">
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
					
						<c:if test="${data.wffl=='1' }">
							<input type="checkbox" name="gpszywscl_name" path="wffl" id="wffl" value="wffl" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;污废分流
						</c:if>
						<c:if test="${data.wffl=='0' }">
							<input type="checkbox" name="gpszywscl_name"  id="wffl" value="wffl" path="wffl" tyle="margin-top: -2px;"/>&nbsp;污废分流
						</c:if>
						
					</td>
					<td>
						<c:if test="${data.hfc=='1' }">
							<input type="checkbox" name="gpszywscl_name" path="hfc" id="hfc" value="hfc" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;化粪池
						</c:if>
						<c:if test="${data.hfc=='0' }">
							<input type="checkbox" name="gpszywscl_name" id="hfc" value="hfc"  path="hfc" tyle="margin-top: -2px;"/>&nbsp;化粪池
						</c:if>
						
					</td>
				</tr>
				<tr>
					<td>
				
						<c:if test="${data.clz=='1' }">
							<input type="checkbox" name="gpszywscl_name" path="clz" id="clz" value="clz" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;处理站
						</c:if>
						<c:if test="${data.clz=='0' }">
							<input type="checkbox" name="gpszywscl_name" id="clz" value="clz" path="clz" tyle="margin-top: -2px;"/>&nbsp;处理站
						</c:if>
						
					</td>
					<td>
						<c:if test="${data.szjc=='1' }">
							<input type="checkbox" name="gpszywscl_name" path="szjc" id="szjc" value="szjc" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;水质监测
						</c:if>
						<c:if test="${data.szjc=='0' }">
							<input type="checkbox" name="gpszywscl_name" id="szjc" value="szjc" path="szjc" tyle="margin-top: -2px;"/>&nbsp;水质监测
						</c:if>
						
						
					<input type = "hidden" htmlEscape="false" id="gpszywscl_name_id"   name="gpszywscl_name_id" value="${data.id}"  class="form-control "/>
					<input   type="hidden" name="gpszywscl_name_docId"  id="gpszywscl_name_docId"  value="${data.doc_id}" htmlEscape="false"    class="form-control "/>
						
						
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
		
		var data = document.getElementsByName("gpszywscl_name");
	 	var docId = document.getElementById("gpszywscl_name_docId").value;
		var id= document.getElementById("gpszywscl_name_id").value; 
		
		
		
		
	
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
		      url:"${ctx}/ironfofivegpszywscl/ironfofivegpszywscl/save",
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