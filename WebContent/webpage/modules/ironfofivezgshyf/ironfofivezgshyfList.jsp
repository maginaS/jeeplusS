<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>5.8职工生活用房管理</title>
	<meta name="decorator" content="default"/>
	
</head>
<body class="hideScroll">
		<form id="inputForm" modelAttribute="ironfofivezgshyf" action="${ctx}/ironfofivezgshyf/ironfofivezgshyf/save" method="post" class="form-horizontal">
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
					<td class="width-15 active"><label class="pull-right">功能单元建筑面积（m2）</label></td>
					<td class="width-35">
						<!-- <input path="gndyjzmj" htmlEscape="false"    class="form-control "/> -->
						<input   name="gndyjzmj_name_gndyjzmj_zgshyf"  id="gndyjzmj" value="${data.gndyjzmj }"   htmlEscape="false" class="form-control " /></td>
					<input   type="hidden" name="gndyjzmj_name_gndyjzmj_zgshyf"  id="docId"  value="${data.doc_id}" htmlEscape="false"    class="form-control "/>
				
					</td>
					
				</tr>
				
				
				
			</tbody>
		</table>

		<div class="tabs-container">
			<ul class="nav nav-tabs">
				<li class="active"><a data-toggle="tab" href="#tab-1"
					aria-expanded="true">职工生活用房空间类型</a></li>
			</ul>


			<div class="tab-content">
				<div id="tab-1" class="tab-pane active">
					<table id="contentTable"
						class="table table-striped table-bordered table-condensed">
						<thead>

				
				
				
				<tr>
					<td style="width: 20%;">
						<c:if test="${data.zgss=='1' }">
							<input type="checkbox" name="zgshyf_name" path="zgss" id="zgss" value="zgss" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;职工宿舍
						</c:if>
						<c:if test="${data.zgss=='0' }">
							<input type="checkbox" name="zgshyf_name" id="zgss" value="zgss" path="zgss"  style="margin-top: -2px;"/>&nbsp;职工宿舍
						</c:if>
						
					</td>
					<td style="width: 20%;">
					
						<c:if test="${data.wsj=='1' }">
							<input type="checkbox" name="zgshyf_name" path="wsj" id="wsj" value="wsj" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;卫生间
						</c:if>
						<c:if test="${data.wsj=='0' }">
							<input type="checkbox" name="zgshyf_name" id="wsj" value="wsj" path="wsj"  style="margin-top: -2px;"/>&nbsp;卫生间
						</c:if>
						
					</td>
					<td style="width: 20%;">
						<c:if test="${data.hxj=='1' }">
							<input type="checkbox" name="zgshyf_name" path="hxj" id="hxj" value="hxj" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;盥洗间
						</c:if>
						<c:if test="${data.hxj=='0' }">
							<input type="checkbox" name="zgshyf_name" id="hxj" value="hxj"  path="hxj"  style="margin-top: -2px;"/>&nbsp;盥洗间
						</c:if>
						
					</td>
				
					<td style="width: 20%;">
						<c:if test="${data.lyj=='1' }">
							<input type="checkbox" name="zgshyf_name" path="lyj" id="lyj" value="lyj" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;淋浴间
						</c:if>
						<c:if test="${data.lyj=='0' }">
							<input type="checkbox" name="zgshyf_name" id="lyj" value="lyj" path="lyj"  style="margin-top: -2px;"/>&nbsp;淋浴间
						</c:if>
						
					</td>
					<td style="width: 20%;">
						<c:if test="${data.zyst=='1' }">
							<input type="checkbox" name="zgshyf_name" path="zyst" id="zyst" value="zyst" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;自饮食堂
						</c:if>
						<c:if test="${data.zyst=='0' }">
							<input type="checkbox" name="zgshyf_name" id="zyst" value="zyst" path="zyst"  style="margin-top: -2px;"/>&nbsp;自饮食堂
						</c:if>
						
					</td>
				</tr>
				<tr>
								
							<td style="width: 20%;">其它（请注明）</td><td><input name="zgshyf_name_qtqzm" id="zgshyf_name_qtqzm" value="${data.qtqzm }"  type="text" /></td>
							<input type = "hidden" htmlEscape="false" id="zgshyf_name_id"   name="zgshyf_name_id" value="${data.id}"  class="form-control "/>
					
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
		
		var data = document.getElementsByName("zgshyf_name");
	 	var remarks = document.getElementById("zgshyf_name_qtqzm").value;
		var id= document.getElementById("zgshyf_name_id").value; 
		var title = document.getElementsByName("gndyjzmj_name_gndyjzmj_zgshyf");
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
		      url:"${ctx}/ironfofivezgshyf/ironfofivezgshyf/save",
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