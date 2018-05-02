<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>5.9室外场地管理</title>
	<meta name="decorator" content="default"/>
</head>
<body class="hideScroll">
		<form id="inputForm" modelAttribute="ironfofiveswcd" action="${ctx}/ironfofiveswcd/ironfofiveswcd/save" method="post" class="form-horizontal">
	<%-- 	<form:hidden path="id"/>
		<sys:message content="${message}"/>	 --%>
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
					注：<br/>
					空间类型：乡镇卫生院设置有该类场所就算作有此种类型的空间，不需要名称一致。
					
					<%-- <td class="width-15 active"><label class="pull-right">备注信息：</label></td>
					<td class="width-35">
						<form:textarea path="remarks" htmlEscape="false" rows="4"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">主表id：</label></td>
					<td class="width-35">
						<form:input path="doc_id" htmlEscape="false"    class="form-control "/>
					</td> --%>
				</tr>
				
				
			</tbody>
		</table>
				
		<div class="tabs-container">
			<ul class="nav nav-tabs">
				<li class="active"><a data-toggle="tab" href="#tab-1"
					aria-expanded="true">室外场地空间类型</a></li>
			</ul>


			<div class="tab-content">
				<div id="tab-1" class="tab-pane active">
					<table id="contentTable"
						class="table table-striped table-bordered table-condensed">
						<thead>

				
				
				
				<tr>
					<td>
					
						<c:if test="${data.yhdl=='1' }">
							<input type="checkbox" name="swcd_name" path="yhdl" id="yhdl" value="yhdl" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;硬化道路
						</c:if>
						<c:if test="${data.yhdl=='0' }">
							<input type="checkbox" name="swcd_name" path="yhdl" id="yhdl" value="yhdl" style="margin-top: -2px;"/>&nbsp;硬化道路
						</c:if>
						
					</td>
					<td>
					
						<c:if test="${data.ld=='1' }">
							<input type="checkbox" name="swcd_name" path="ld" id="ld" value="ld" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;绿地
						</c:if>
						<c:if test="${data.ld=='0' }">
							<input type="checkbox" name="swcd_name" path="ld" id="ld" value="ld" style="margin-top: -2px;"/>&nbsp;绿地
						</c:if>
						
					</td>
				
					<td>
					
						<c:if test="${data.swtcc=='1' }">
							<input type="checkbox" name="swcd_name" path="swtcc" id="swtcc" value="swtcc" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;室外停车场
						</c:if>
						<c:if test="${data.swtcc=='0' }">
							<input type="checkbox" name="swcd_name" path="swtcc" id="swtcc" value="swtcc" style="margin-top: -2px;"/>&nbsp;室外停车场
						</c:if>
							
					</td>
					
				</tr>
				<tr>
					
										
							<td>其它（请注明）</td><td><input name="swcd_name_qtqzm" id="swcd_name_qtqzm" value="${data.qtqzm }"  type="text" /></td>
							<input type = "hidden" htmlEscape="false" id="swcd_name_id"   name="swcd_name_id" value="${data.id}"  class="form-control "/>
							<input   type="hidden" name="swcd_name_docid"  id="swcd_name_docid"  value="${data.doc_id}" htmlEscape="false"    class="form-control "/>
					
								
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
		
		var data = document.getElementsByName("swcd_name");
	 	var remarks = document.getElementById("swcd_name_qtqzm").value;
		var docId = document.getElementById("swcd_name_docid").value;
		var id= document.getElementById("swcd_name_id").value; 
	/* 	var title = document.getElementsByName("gndyjzmj_name_gndyjzmj_ggwsyf"); */
		/* var titles="";
		for(var i=0;i<title.length;i++){
			if(title[i].value==null||title[i].value==""){
				titles = titles +title[i].id+": ---- ;";	
			}else{
				titles = titles +title[i].id+":"+title[i].value+";";	
			}
		}
		 */
		
	
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
		      url:"${ctx}/ironfofiveswcd/ironfofiveswcd/save",
		      data:{
		    	  docId:docId,
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