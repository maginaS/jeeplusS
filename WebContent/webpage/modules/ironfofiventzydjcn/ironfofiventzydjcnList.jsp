<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>冬季采暖管理</title>
	<meta name="decorator" content="default"/>
	
</head>
<body class="hideScroll">
		<form id="inputForm" modelAttribute="ironfofiventzydjcn" action="${ctx}/ironfofiventzydjcn/ironfofiventzydjcn/save" method="post" class="form-horizontal">
	<%-- 	<form:hidden path="id"/>
		<sys:message content="${message}"/>	 --%>
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
				<%-- 	<td class="width-15 active"><label class="pull-right">备注信息：</label></td>
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
						<c:if test="${data.zykt=='1' }">
							<input type="checkbox" name="entzydjcn_name" path="zykt" id="zykt" value="zykt" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;中央空调
						</c:if>
						<c:if test="${data.zykt=='0' }">
							<input type="checkbox" name="entzydjcn_name" id="zykt" value="zykt" path="zykt" style="margin-top: -2px;"/>&nbsp;中央空调
						</c:if>
						
					</td>
					<td>
					
						<c:if test="${data.ftkt=='1' }">
								<input type="checkbox" name="entzydjcn_name" path="ftkt" id="ftkt" value="ftkt" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;分体空调
						</c:if>
						<c:if test="${data.ftkt=='0' }">
							<input type="checkbox" name="entzydjcn_name" id="ftkt" value="ftkt" path="ftkt" style="margin-top: -2px;"/>&nbsp;分体空调
						</c:if>
						
					</td>
			
					<td>
						<c:if test="${data.glcn=='1' }">
								<input type="checkbox" name="entzydjcn_name" path="glcn" id="glcn" value="glcn" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;锅炉采暖
						</c:if>
						<c:if test="${data.glcn=='0' }">
							<input type="checkbox" name="entzydjcn_name" id="glcn" value="glcn" path="glcn" style="margin-top: -2px;"/>&nbsp;锅炉采暖
						</c:if>
						
					</td>
					<td>
						<c:if test="${data.dzq=='1' }">
								<input type="checkbox" name="entzydjcn_name" path="dzq" id="dzq" value="dzq" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;电暖气
						</c:if>
						<c:if test="${data.dzq=='0' }">
							<input type="checkbox" name="entzydjcn_name" id="dzq"  value="dzq" path="dzq" style="margin-top: -2px;"/>&nbsp;电暖气
						</c:if>
						
					</td>
				
					<td>
						<c:if test="${data.szrl=='1' }">
								<input type="checkbox" name="entzydjcn_name" path="szrl" id="szrl" value="szrl" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;市政热力
						</c:if>
						<c:if test="${data.szrl=='0' }">
							<input type="checkbox" name="entzydjcn_name" id="szrl" value="szrl" path="szrl" style="margin-top: -2px;"/>&nbsp;市政热力
						</c:if>
						
							
					<input type = "hidden" htmlEscape="false" id="entzydjcn_name_id"   name="entzydjcn_name_id" value="${data.id}"  class="form-control "/>
					<input   type="hidden" name="entzydjcn_name_docId"  id="entzydjcn_name_docId"  value="${data.doc_id}" htmlEscape="false"    class="form-control "/>
						
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
		
		var data = document.getElementsByName("entzydjcn_name");
	 	var docId = document.getElementById("entzydjcn_name_docId").value;
		var id= document.getElementById("entzydjcn_name_id").value; 
		
		
		
		
	
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
		      url:"${ctx}/ironfofiventzydjcn/ironfofiventzydjcn/save",
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