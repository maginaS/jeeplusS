<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>5.1.1建筑总体概况管理</title>
	<meta name="decorator" content="default"/>
	
</head>
<body class="hideScroll">
		<form id="inputForm" modelAttribute="ironfopopulation" action="${ctx}/ironfopopulation/ironfopopulation/save" method="post" class="form-horizontal">
	<%-- 	<form:hidden path="id"/>
		<sys:message content="${message}"/>	 --%>
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				
				<tr>
					<td class="width-15 active"><label class="pull-right">总建筑面积（m2）</label></td>
					<td class="width-15 active"><label class="pull-right">地下建筑面积（m2）</label></td>
					<td class="width-15 active"><label class="pull-right">单体建筑数量（栋）</label></td>
					<td class="width-15 active"><label class="pull-right">建筑高度24m以上的单体建筑数量（m）</label></td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="population_zjzmj" name="jzztgkgl_name" id="zjzmj" value="${data.datas.zjzmj }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="population_dxjzmj" name="jzztgkgl_name" id="dxjzmj" value="${data.datas.dxjzmj }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="population_dtjzsl" name="jzztgkgl_name" id="dtjzsl" value="${data.datas.dtjzsl }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="population_jzgd" name="jzztgkgl_name" id="jzgd" value="${data.datas.jzgd }"  htmlEscape="false"    class="form-control "/>
					
						<input type = "hidden" htmlEscape="false" id="id"   name="jzztgkgl_name" value="${data.datas.id}"  class="form-control "/>
 						<input type = "hidden" htmlEscape="false" id="docId"   name="jzztgkgl_name" value="${data.doc_id}"  class="form-control "/>
					
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
		
		var data = document.getElementsByName("jzztgkgl_name");
	
		var datas="";
		
		
		for(i=0;i<data.length;i++){
			if(data[i].value==null||data[i].value==""){
				datas = datas +data[i].id+": ---- ;";	
			}else{
				datas = datas +data[i].id+":"+data[i].value+";";	
			}
			
			
		}
	 	
		 $.ajax({
		      url:"${ctx}/ironfopopulation/ironfopopulation/save",
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