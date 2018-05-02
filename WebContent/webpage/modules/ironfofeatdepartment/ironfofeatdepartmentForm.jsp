<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>2.4.1特色科室管理</title>
	<meta name="decorator" content="default"/>
	
</head>
<body class="hideScroll">
		<form id="inputForm" modelAttribute="ironfofeatdepartment" action="${ctx}/ironfofeatdepartment/ironfofeatdepartment/save" method="post" class="form-horizontal">
		<%-- <form:hidden path="id"/>
		<sys:message content="${message}"/>	 --%>
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
					<input type="hidden" name="ironfofeatdepartment_name" id="doc_id" value="${data.doc_id }"/>
					<input type="hidden" name="ironfofeatdepartment_name" id="id" value="${data.id }"/> 
					<td class="width-15 active"><label class="pull-right">特色科室</label></td>
					<td class="width-35">
						<input path="tsks" id="tsks" value="${data.tsks }" name="ironfofeatdepartment_name" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">2017年门诊人次数（人次）</label></td>
					<td class="width-35">
						<input path="nmzrcs" id="nmzrcs" value="${data.nmzrcs }" name="ironfofeatdepartment_name" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					
					<td class="width-15 active"><label class="pull-right">2017年出院人数（人）</label></td>
					<td class="width-35">
						<input path="ncyrs" id="ncyrs" value="${data.ncyrs }" name="ironfofeatdepartment_name" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">科室实有床位(张)</label></td>
					<td class="width-35">
						<input path="kssycw" id="kssycw" value="${data.kssycw }" name="ironfofeatdepartment_name"  htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					
					<td class="width-15 active"><label class="pull-right">科室执业(助理)医师（人）</label></td>
					<td class="width-35">
						<input path="kszyzlys" id="kszyzlys" value="${data.kszyzlys }" name="ironfofeatdepartment_name" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">科室注册护士（人）</label></td>
					<td class="width-35">
						<input path="kszchs" id="kszchs" value="${data.kszchs }" name="ironfofeatdepartment_name"  htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
		 	</tbody>
		</table>
	</form>
	
	
	
	
	<div style="text-align:right;">
		<input type="button" value="保存"  style="width:100px;height:50px;margin-right: 20px;margin-bottom: 20px;" onclick="subuimtinput();"/>
	</div>
	
	
	
	<script type="text/javascript">
	function subuimtinput(){
		
		var data = document.getElementsByName("ironfofeatdepartment_name");
	
		var datas="";
		
		
		for(i=0;i<data.length;i++){
			if(data[i].value==null||data[i].value==""){
				datas = datas +data[i].id+": ---- ;";	
			}else{
				datas = datas +data[i].id+":"+data[i].value+";";	
			}
			
			
		}
	 	
		 $.ajax({
		      url:"${ctx}/ironfofeatdepartment/ironfofeatdepartment/save",
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