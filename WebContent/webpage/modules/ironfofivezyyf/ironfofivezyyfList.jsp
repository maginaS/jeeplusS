<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>5.4住院用房管理</title>
	<meta name="decorator" content="default"/>
	
</head>
<body class="hideScroll">
		<form id="inputForm" modelAttribute="ironfofivezyyf" action="${ctx}/ironfofivezyyf/ironfofivezyyf/save" method="post" class="form-horizontal">
	<%-- 	<form:hidden path="id"/>
		<sys:message content="${message}"/>	 --%>
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
		   
		   
		  		  <tr>
				
				
					注：<br/>
					功能单元建筑面积：该功能单元所有房间和场所的建筑面积之和。<br/>
					空间类型：乡镇卫生院设置有该类场所就算作有此种类型的空间，不需要名称一致。<br/>
					
				</tr> 
		   
				
				<tr>
					<td class="width-15 active"><label class="pull-right">功能单元建筑面积（m2）：</label></td>
					<td class="width-35">
						<input path="gndyjzmj" name="gndyjzmj_name_gndyjzmj_zyyf" htmlEscape="false"  id="gndyjzmj" value="${data.gndyjzmj }"     class="form-control "/>
						<input   type="hidden" name="gndyjzmj_name_gndyjzmj_zyyf"  id="docId"  value="${data.doc_id}" htmlEscape="false"    class="form-control "/>
						
					</td>
					
				</tr>
				
		 	</tbody>
		</table>
		
		<div class="tabs-container">
	            <ul class="nav nav-tabs">
					<li class="active"><a data-toggle="tab" href="#tab-1" aria-expanded="true">住院空间类型</a>
	                </li>
	            </ul>
		
		 <div class="tab-content">
					<div id="tab-1" class="tab-pane active">
	 					<table id="contentTable" class="table table-striped table-bordered table-condensed">
							<thead>
							
							
							<tr>
				
								<td>
								
									<c:if test="${data.bf=='1' }">
										<input type="checkbox" name="zyyf_name" path="bf" id="bf" value="bf" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;病房
									</c:if>
									<c:if test="${data.bf=='0' }">
										<input type="checkbox" name="zyyf_name" id="bf" value="bf" path="bf"  htmlEscape="false" style="margin-top: -2px;"/>&nbsp;病房
									</c:if>
									
								</td>
								<td>
								
									<c:if test="${data.hsz=='1' }">
										<input type="checkbox" name="zyyf_name" path="hsz" id="hsz" value="hsz" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;护士站
									</c:if>
									<c:if test="${data.hsz=='0' }">
										<input type="checkbox"  name="zyyf_name" id="hsz" value="hsz"  path="hsz" htmlEscape="false" style="margin-top: -2px;"/>&nbsp;护士站
									</c:if>
									
								</td>
								<td>
									<c:if test="${data.zlzbs=='1' }">
										<input type="checkbox" name="zyyf_name" path="zlzbs" id="zlzbs" value="zlzbs" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;治疗准备室
									</c:if>
									<c:if test="${data.zlzbs=='0' }">
										<input type="checkbox" name="zyyf_name" id="zlzbs" value="zlzbs"  path="zlzbs" htmlEscape="false" style="margin-top: -2px;"/>&nbsp;治疗准备室
									</c:if>
									
								</td>
							
								<td>
								
									<c:if test="${data.zls=='1' }">
										<input type="checkbox" name="zyyf_name" path="zls" id="zls" value="zls" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;治疗室
									</c:if>
									<c:if test="${data.zls=='0' }">
										<input type="checkbox"  name="zyyf_name" id="zls" value="zls"  path="zls"  htmlEscape="false" style="margin-top: -2px;"/>&nbsp;治疗室
									</c:if>
									
								</td>
								<td>
								
									<c:if test="${data.qjs=='1' }">
										<input type="checkbox" name="zyyf_name" path="qjs" id="qjs" value="qjs" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;抢救室
									</c:if>
									<c:if test="${data.qjs=='0' }">
										<input type="checkbox"  name="zyyf_name" id="qjs" value="qjs"  path="qjs"  htmlEscape="false" style="margin-top: -2px;"/>&nbsp;抢救室
									</c:if>
									
								</td>
							
								<td>
									<c:if test="${data.yhbgs=='1' }">
										<input type="checkbox" name="zyyf_name" path="yhbgs" id="yhbgs" value="yhbgs" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;医护办公室
									</c:if>
									<c:if test="${data.yhbgs=='0' }">
										<input type="checkbox"  name="zyyf_name" id="yhbgs" value="yhbgs" path="yhbgs"  htmlEscape="false" style="margin-top: -2px;"/>&nbsp;医护办公室
									</c:if>
									
								</td>
								<td>
								
									<c:if test="${data.zybgs=='1' }">
										<input type="checkbox" name="zyyf_name" path="zybgs" id="zybgs" value="zybgs" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;住院办公室
									</c:if>
									<c:if test="${data.zybgs=='0' }">
										<input type="checkbox"  name="zyyf_name" id="zybgs" value="zybgs"  path="zybgs"  htmlEscape="false" style="margin-top: -2px;"/>&nbsp;住院办公室
									</c:if>
									
								</td>
							
								<td>
								
									<c:if test="${data.zbs=='1' }">
										<input type="checkbox" name="zyyf_name" path="zbs" id="zbs" value="zbs" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;值班室
									</c:if>
									<c:if test="${data.zbs=='0' }">
										<input type="checkbox"  name="zyyf_name" id="zbs" value="zbs"  path="zbs"  htmlEscape="false" style="margin-top: -2px;"/>&nbsp;值班室
									</c:if>
									
								</td>
							</tr>
							<tr>
								<td>
									<c:if test="${data.ksj=='1' }">
										<input type="checkbox" name="zyyf_name" path="ksj" id="ksj" value="ksj" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;开水间
									</c:if>
									<c:if test="${data.ksj=='0' }">
										<input type="checkbox"  name="zyyf_name" id="ksj" value="ksj"  path="ksj"  htmlEscape="false" style="margin-top: -2px;"/>&nbsp;开水间
									</c:if>
									
								</td>
						
								<td>
									 <c:if test="${data.wsj=='1' }">
										<input type="checkbox" name="zyyf_name" path="wsj" id="wsj" value="wsj" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;卫生间
									</c:if>
									<c:if test="${data.wsj=='0' }">
										<input type="checkbox"  name="zyyf_name" id="wsj" value="wsj"  path="wsj"  htmlEscape="false" style="margin-top: -2px;"/>&nbsp;卫生间
									</c:if>
									
								</td>
								<td>
								 	<c:if test="${data.hxj=='1' }">
										<input type="checkbox" name="zyyf_name" path="hxj" id="hxj" value="hxj" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;盥洗间
									</c:if>
									<c:if test="${data.hxj=='0' }">
										<input type="checkbox"  name="zyyf_name"  id="hxj" value="hxj" path="hxj"  htmlEscape="false" style="margin-top: -2px;"/>&nbsp;盥洗间
									</c:if>
									
								</td>
							
								<td>
									<c:if test="${data.lyj=='1' }">
										<input type="checkbox" name="zyyf_name" path="lyj" id="lyj" value="lyj" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;淋浴间
									</c:if>
									<c:if test="${data.lyj=='0' }">
										<input type="checkbox"  name="zyyf_name" id="lyj" value="lyj" path="lyj"  htmlEscape="false" style="margin-top: -2px;"/>&nbsp;淋浴间
									</c:if>
									
								</td>
								<td>
									<c:if test="${data.zzpcs=='1' }">
										<input type="checkbox" name="zyyf_name" path="zzpcs" id="zzpcs" value="zzpcs" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;自助配餐室
									</c:if>
									<c:if test="${data.zzpcs=='0' }">
										<input type="checkbox"  name="zyyf_name" id="zzpcs" value="zzpcs"  path="zzpcs"  htmlEscape="false" style="margin-top: -2px;"/>&nbsp;自助配餐室
									</c:if>
									
								</td>
							
								<td>
								
									<c:if test="${data.hds=='1' }">
										<input type="checkbox" name="zyyf_name" path="hds" id="hds" value="hds" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;活动室
									</c:if>
									<c:if test="${data.hds=='0' }">
										<input type="checkbox"  name="zyyf_name" id="hds" value="hds"  path="hds"  htmlEscape="false" style="margin-top: -2px;"/>&nbsp;活动室
									</c:if>
									
								</td>
								<td>
									<c:if test="${data.brct=='1' }">
										<input type="checkbox" name="zyyf_name" path="brct" id="brct" value="brct" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;病人餐厅
									</c:if>
									<c:if test="${data.brct=='0' }">
										<input type="checkbox"  name="zyyf_name" id="brct" value="brct" path="brct"  htmlEscape="false" style="margin-top: -2px;"/>&nbsp;病人餐厅
									</c:if>
									
								</td>
							</tr>
							<tr>
							
						
										
							<td>其它（请注明）</td><td><input name="zyyf_name_qtqzm" id="zyyf_name_qtqzm" value="${data.qtqzm }"  type="text" /></td>
							<input type = "hidden" htmlEscape="false" id="zyyf_name_id"   name="zyyf_name_id" value="${data.id}"  class="form-control "/>
					
								
								<!-- <td class="width-15 active"><label class="pull-right">其它（请注明：</label></td>
								<td class="width-35">
									<input path="qtqzm" htmlEscape="false"    class="form-control "/>
								</td>
								<td class="width-15 active"></td>
					   			<td class="width-35" ></td> -->
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
		
		var data = document.getElementsByName("zyyf_name");
	 	var remarks = document.getElementById("zyyf_name_qtqzm").value;
		var id= document.getElementById("zyyf_name_id").value; 
		var title = document.getElementsByName("gndyjzmj_name_gndyjzmj_zyyf");
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
		      url:"${ctx}/ironfofivezyyf/ironfofivezyyf/save",
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