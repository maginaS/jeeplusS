<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>5.4手术室管理</title>
	<meta name="decorator" content="default"/>
	
</head>
<body class="hideScroll">
		<form id="inputForm" modelAttribute="ironfofivesssgl" action="${ctx}/ironfofivesssgl/ironfofivesssgl/save" method="post" class="form-horizontal">

		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
			
				<tr>
					<td class="width-15 active"><label class="pull-right"></label></td>
					<td class="width-17 active"><label class="pull-right">Ⅰ级洁净手术室（间）</label></td>
					<td class="width-17 active"><label class="pull-right">Ⅱ级洁净手术室（间）</label></td>
					<td class="width-17 active"><label class="pull-right">Ⅲ级洁净手术室（间）</label></td>
					<td class="width-17 active"><label class="pull-right">Ⅳ级洁净手术室（间）</label></td>
					<td class="width-17 active"><label class="pull-right">一般手术室（间）</label></td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input  htmlEscape="false"  value="手术室数量" readonly="readonly"   class="form-control "/>
					</td>
					
					<td class="width-17">
						<input path="Ajjjsss" htmlEscape="false"  name="sssgl_name"  id="Ajjjsss" value="${data.datas.Ajjjsss }" class="form-control "/>
					</td>
					<td class="width-17">
						<input path="Bjjjsss" htmlEscape="false"   name="sssgl_name"  id="Bjjjsss"  value="${data.datas.Bjjjsss }"   class="form-control "/>
					</td>
					<td class="width-17">
						<input path="Cjjjsss" htmlEscape="false"   name="sssgl_name"  id="Cjjjsss"  value="${data.datas.Cjjjsss }"   class="form-control "/>
					</td>
					<td class="width-17">
						<input path="Djjjsss" htmlEscape="false"   name="sssgl_name" id="Djjjsss"   value="${data.datas.Djjjsss }"   class="form-control "/>
					</td>
					<td class="width-17">
						<input path="Fjjjsss" htmlEscape="false"   name="sssgl_name" id="Fjjjsss"   value="${data.datas.Fjjjsss }"   class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="id"  name="sssgl_name" value="${data.datas.id}"  class="form-control "/>
						<input type = "hidden" htmlEscape="false"  name ="sssgl_name" id ="docId" value="${data.datas.doc_id} "  class="form-control "/>
					
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
		
		/* var isnull = true; */
		var data = document.getElementsByName("sssgl_name");
	   
	
		var datas="";
		
		
		for(i=0;i<data.length;i++){
			if(data[i].value==null||data[i].value==""){
				datas = datas +data[i].id+": ---- ;";	
			}else{
				datas = datas +data[i].id+":"+data[i].value+";";	
			}
			
			
		}
	 	
		 $.ajax({
		      url:"${ctx}/ironfofivesssgl/ironfofivesssgl/save",
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