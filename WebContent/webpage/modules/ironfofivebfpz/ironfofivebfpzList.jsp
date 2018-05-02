<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>5.3病房管理</title>
	<meta name="decorator" content="default"/>
</head>
<body class="hideScroll">
		<form id="inputForm" modelAttribute="ironfofivebfpz" action="${ctx}/ironfofivebfpz/ironfofivebfpz/save" method="post" class="form-horizontal">
	<%-- 	<form:hidden path="id"/>
		<sys:message content="${message}"/>	 --%>
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
					<%-- <td class="width-15 active"><label class="pull-right">备注信息：</label></td>
					<td class="width-35">
						<form:textarea path="remarks" htmlEscape="false" rows="4"    class="form-control "/>
					</td> --%>
					<%-- <td class="width-15 active"><label class="pull-right">主表id：</label></td>
					<td class="width-35">
						<form:input path="doc_id" htmlEscape="false"    class="form-control "/>
					</td> --%>
				</tr>
				<tr>
					<td class="width-16 active"><label class="pull-right"></label></td>
					<td class="width-14 active"><label class="pull-right">单床（间）</label></td>
					<td class="width-14 active"><label class="pull-right">2床（间）</label></td>
					<td class="width-14 active"><label class="pull-right">3床（间）</label></td>
					<td class="width-14 active"><label class="pull-right">4床（间）</label></td>
					<td class="width-14 active"><label class="pull-right">5床（间）</label></td>
					<td class="width-14 active"><label class="pull-right">6床（间）</label></td>
					
				</tr>
				<tr>
					<td class="width-16">
						<input path="dcj" htmlEscape="false" value="病房数量"  readonly="readonly"  class="form-control "/>
					</td>
					<td class="width-14">
						<input path="dcj" htmlEscape="false"  name="bfgl_name" id="dcj" value="${data.datas.dcj }"   class="form-control "/>
					</td>
					<td class="width-14">
						<input path="ecj" htmlEscape="false"  name="bfgl_name"  id="ecj"  value="${data.datas.ecj }"   class="form-control "/>
					</td>
					
					<td class="width-14">
						<input path="scj" htmlEscape="false"  name="bfgl_name"   id="scj"  value="${data.datas.scj }"   class="form-control "/>
					</td>
					
					<td class="width-14">
						<input path="fourcj" htmlEscape="false"  name="bfgl_name"  id="fourcj"  value="${data.datas.fourcj }"    class="form-control "/>
					</td>
					<td class="width-14">
						<input path="wcj" htmlEscape="false"   name="bfgl_name"   id="wcj" value="${data.datas.wcj }"   class="form-control "/>
					</td>
					
					<td class="width-14"> 
						<input path="lcj" htmlEscape="false"    name="bfgl_name"  id="lcj"  value="${data.datas.lcj }"  class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="id"  name="bfgl_name" value="${data.datas.id}"  class="form-control "/>
						<input type = "hidden" htmlEscape="false"  name ="bfgl_name" id ="docId" value="${data.datas.doc_id} "  class="form-control "/>
					
					</td>
				</tr>
				<tr>
					
					
				</tr>
				<tr>
					<td class="width-16 active"><label class="pull-right"></label></td>
					<td class="width-14 active"><label class="pull-right">6床以上（间）</label></td>
					<td class="width-14 active"><label class="pull-right">VIP套间(间)</label></td>
					<td class="width-14 active"><label class="pull-right">临终关怀病房（间）</label></td>
					<td class="width-14 active"><label class="pull-right">ICU(间)</label></td>
					<td class="width-14 active"><label class="pull-right">NICU(间)</label></td>
					<td class="width-14 active"><label class="pull-right">护士站最远直线服务距离（m）</label></td>
					
				</tr>
				<tr>
					
					<td class="width-16">
						<input path="lcysj" htmlEscape="false"   value="病房数量" readonly="readonly"   class="form-control "/>
					</td>
					<td class="width-14">
						<input path="lcysj" htmlEscape="false"  name="bfgl_name"  id="lcysj" value="${data.datas.lcysj }"  class="form-control "/>
					</td>
					<td class="width-14">
						<input path="viptj" htmlEscape="false"   name="bfgl_name"  id="viptj"   value="${data.datas.viptj }"   class="form-control "/>
					</td>
					<td class="width-14">
						<input path="lzghbfj" htmlEscape="false"   name="bfgl_name"   id="lzghbfj"   value="${data.datas.lzghbfj }"  class="form-control "/>
					</td>
					<td class="width-14">
						<input path="icuj" htmlEscape="false"    name="bfgl_name"  id="icuj" value="${data.datas.icuj }"    class="form-control "/>
					</td>
					<td class="width-14">
						<input path="nicuj" htmlEscape="false"    name="bfgl_name"   id="nicuj" value="${data.datas.nicuj }"   class="form-control "/>
					</td>
					<td class="width-14">
						<input path="hszzyzxfwjl" htmlEscape="false"   name="bfgl_name"  value="${data.datas.hszzyzxfwjl }"  id="hszzyzxfwjl"    class="form-control "/>
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
		
		var isnull = true;
		var data = document.getElementsByName("bfgl_name");
	   
	
		var datas="";
		
		
		for(i=0;i<data.length;i++){
			if(data[i].value==null||data[i].value==""){
				datas = datas +data[i].id+": ---- ;";	
			}else{
				datas = datas +data[i].id+":"+data[i].value+";";	
			}
			
			
		}
	 	
		 $.ajax({
		      url:"${ctx}/ironfofivebfpz/ironfofivebfpz/save",
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