<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>供应类型管理</title>
	<meta name="decorator" content="default"/>
	
</head>
<body class="hideScroll">
		<form id="inputForm" modelAttribute="ironfofiveqtzygylx" action="${ctx}/ironfofiveqtzygylx/ironfofiveqtzygylx/save" method="post" class="form-horizontal">
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
					
						<c:if test="${data.zygy=='1' }">
							<input type="checkbox" name="gylxgl_name" path="zygy" id="zygy" value="zygy" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;中央供应
						</c:if>
						<c:if test="${data.zygy=='0' }">
							<input type="checkbox" path="zygy" id="zygy" value="zygy" name="gylxgl_name" style="margin-top: -2px;"/>&nbsp;中央供应
						</c:if>
						
					</td>
					<td>
						<c:if test="${data.qpzq=='1' }">
							<input type="checkbox" name="gylxgl_name" path="qpzq" id="qpzq" value="qpzq" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;气瓶自取
						</c:if>
						<c:if test="${data.qpzq=='0' }">
							<input type="checkbox" path="qpzq" id="qpzq" value="qpzq" name="gylxgl_name" style="margin-top: -2px;"/>&nbsp;气瓶自取
						</c:if>
					</td>
							
						<input type = "hidden" htmlEscape="false" id="gylxgl_name_id"   name="gylxgl_name_id" value="${data.id}"  class="form-control "/>
						<input   type="hidden" name="gylxgl_name_docId"  id="gylxgl_name_docId"  value="${data.doc_id}" htmlEscape="false"    class="form-control "/>
						
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
		
		var data = document.getElementsByName("gylxgl_name");
	 	var docId = document.getElementById("gylxgl_name_docId").value;
		var id= document.getElementById("gylxgl_name_id").value; 
		
		
		
		
	
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
		      url:"${ctx}/ironfofiveqtzygylx/ironfofiveqtzygylx/save",
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