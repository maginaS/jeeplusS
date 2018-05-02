<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>5.6计划生育用房管理</title>
	<meta name="decorator" content="default"/>
</head>
<body class="hideScroll">
		<form id="inputForm" modelAttribute="ironfofivejhsyyf" action="${ctx}/ironfofivejhsyyf/ironfofivejhsyyf/save" method="post" class="form-horizontal">
	<%-- 	<form:hidden path="id"/>
		<sys:message content="${message}"/>	 --%>
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
				
					注：
					<br /> 功能单元建筑面积：该功能单元所有房间和场所的建筑面积之和。
					<br /> 空间类型：乡镇卫生院设置有该类场所就算作有此种类型的空间，不需要名称一致。
					<br />
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
					<td class="width-15 active"><label class="pull-right">功能单元建筑面积（m2）：</label></td>
					<td class="width-35">
						<input path="gndyjzmj" name="gndyjzmj_name_gndyjzmj_jhsyyf"  id="gndyjzmj"  value="${data.gndyjzmj }"  htmlEscape="false"    class="form-control "/>
						<input   type="hidden" name="gndyjzmj_name_gndyjzmj_jhsyyf"  id="docId"  value="${data.doc_id}" htmlEscape="false"    class="form-control "/>
					
					</td>
					
				</tr>
				
				
			</tbody>
		</table>

		<div class="tabs-container">
			<ul class="nav nav-tabs">
				<li class="active"><a data-toggle="tab" href="#tab-1"
					aria-expanded="true">计划生育用房空间类型</a></li>
			</ul>
			<div class="tab-content">
				<div id="tab-1" class="tab-pane active">
					<table id="contentTable"
						class="table table-striped table-bordered table-condensed">
						<thead>

			
				
				<tr>
					<td>
					
					
						<c:if test="${data.zs=='1' }">
							<input type="checkbox" name="jhsyyf_name" path="zs" id="zs" value="zs" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;诊室
						</c:if>
						<c:if test="${data.zs=='0' }">
							<input type="checkbox" name="jhsyyf_name" path="zs" id="zs" value="zs"  style="margin-top: -2px;"/>&nbsp;诊室
						</c:if>
						
					</td>
					<td>
						<c:if test="${data.jcs=='1' }">
							<input type="checkbox" name="jhsyyf_name" path="jcs" id="jcs" value="jcs" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;检查室
						</c:if>
						<c:if test="${data.jcs=='0' }">
							 <input type="checkbox" name="jhsyyf_name"  path="jcs" id="jcs" value="jcs" style="margin-top: -2px;"/>&nbsp;检查室
						</c:if>
					  
					</td>
					
				</tr>
				<tr>
							
					<td>其它（请注明）</td><td><input name="jhsyyf_name_qtqzm" id="jhsyyf_name_qtqzm" value="${data.qtqzm }"  type="text" /></td>
					<input type = "hidden" htmlEscape="false" id="jhsyyf_name_id"   name="jhsyyf_name_id" value="${data.id}"  class="form-control "/>
					
								
				
				</tr>
		 		</thead>
				</table>
				</div>
			</div>

		</div>
	</form>
	
	
	
	
	<div style="text-align:right;">
		<input type="button" value="保存"  style="width:100px;height:50px;margin-right: 20px;" onclick="subuimtinput();"/>
	</div>
	
	
	
	<script type="text/javascript">
	

	function subuimtinput(){
		var checkval="";
		var checkout="";
		
		var data = document.getElementsByName("jhsyyf_name");
	 	var remarks = document.getElementById("jhsyyf_name_qtqzm").value;
		var id= document.getElementById("jhsyyf_name_id").value; 
		var title = document.getElementsByName("gndyjzmj_name_gndyjzmj_jhsyyf");
		var titles="";
		for(var i=0;i<title.length;i++){
			if(title[i].value==null||title[i].value==""){
				titles = titles +title[i].id+": ---- ;";	
			}else{
				titles = titles +title[i].id+":"+title[i].value+";";	
			}
		}
		
		
	
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
		      url:"${ctx}/ironfofivejhsyyf/ironfofivejhsyyf/save",
		      data:{
		    	  titles:titles,
		    	  checkval:checkval,
		    	  checkout:checkout,
		    	  qtqzm:remarks,
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