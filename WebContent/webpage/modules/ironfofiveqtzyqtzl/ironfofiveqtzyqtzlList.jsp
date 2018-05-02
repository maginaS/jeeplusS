<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>气体种类管理</title>
	<meta name="decorator" content="default"/>
	
</head>
<body class="hideScroll">
		<form id="inputForm" modelAttribute="ironfofiveqtzyqtzl" action="${ctx}/ironfofiveqtzyqtzl/ironfofiveqtzyqtzl/save" method="post" class="form-horizontal">
	<%-- 	<form:hidden path="id"/>
		<sys:message content="${message}"/>	 --%>
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
			
				</tr>
				<tr>
					<td>
					<c:if test="${data.yq=='1' }">
							<input type="checkbox" name="qtzlgl_name" path="yq" id="yq" value="yq" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;氧气
						</c:if>
						<c:if test="${data.yq=='0' }">
							<input type="checkbox" name="qtzlgl_name" id="yq" value="yq"  path="yq" style="margin-top: -2px;"/>&nbsp;氧气
						</c:if>
					</td>
					<td>
						<c:if test="${data.xq=='1' }">
							<input type="checkbox" name="qtzlgl_name" path="xq" id="xq" value="xq" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;笑气
						</c:if>
						<c:if test="${data.xq=='0' }">
							<input type="checkbox"  name="qtzlgl_name" id="xq" value="xq"  path="xq" style="margin-top: -2px;"/>&nbsp;笑气
						</c:if>
					</td>
			
					<td>
						<c:if test="${data.dq=='1' }">
							<input type="checkbox" name="qtzlgl_name" path="dq" id="dq" value="dq" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;氮气
						</c:if>
						<c:if test="${data.dq=='0' }">
							<input type="checkbox"  name="qtzlgl_name" id="dq" value="dq"  path="dq" style="margin-top: -2px;"/>&nbsp;氮气
						</c:if>
					</td>
					<td>
						<c:if test="${data.eyht=='1' }">
							<input type="checkbox" name="qtzlgl_name" path="eyht" id="eyht" value="eyht" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;二氧化碳
						</c:if>
						<c:if test="${data.eyht=='0' }">
							<input type="checkbox"  name="qtzlgl_name" id="eyht" value="eyht"  path="eyht" style="margin-top: -2px;"/>&nbsp;二氧化碳
						</c:if>
					</td>
				
					<td>
						<c:if test="${data.yskq=='1' }">
							<input type="checkbox" name="qtzlgl_name" path="yskq" id="yskq" value="yskq" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;压缩空气
						</c:if>
						<c:if test="${data.yskq=='0' }">
							<input type="checkbox"  name="qtzlgl_name"  id="yskq" value="yskq" path="yskq" style="margin-top: -2px;"/>&nbsp;压缩空气
						</c:if>
					</td>
					<td>
						<c:if test="${data.fyxy=='1' }">
							<input type="checkbox" name="qtzlgl_name" path="fyxy" id="fyxy" value="fyxy" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;负压吸引
						</c:if>
						<c:if test="${data.fyxy=='0' }">
							<input type="checkbox"  name="qtzlgl_name"  id="fyxy"  value="fyxy" path="fyxy" style="margin-top: -2px;"/>&nbsp;负压吸引
						</c:if>
						
						<input type = "hidden" htmlEscape="false" id="qtzlgl_name_id"   name="qtzlgl_name_id" value="${data.id}"  class="form-control "/>
						<input   type="hidden" name="qtzlgl_name_docId"  id="qtzlgl_name_docId"  value="${data.doc_id}" htmlEscape="false"    class="form-control "/>
						
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
		
		var data = document.getElementsByName("qtzlgl_name");
	 	var docId = document.getElementById("qtzlgl_name_docId").value;
		var id= document.getElementById("qtzlgl_name_id").value; 
		
		
		
		
	
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
		      url:"${ctx}/ironfofiveqtzyqtzl/ironfofiveqtzyqtzl/save",
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