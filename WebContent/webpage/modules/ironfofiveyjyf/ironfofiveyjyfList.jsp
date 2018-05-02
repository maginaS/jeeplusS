<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>5.3医技用房管理</title>
	<meta name="decorator" content="default"/>
	<!-- <script type="text/javascript">
		var validateForm;
		function doSubmit(){//回调函数，在编辑和保存动作时，供openDialog调用提交表单。
		  if(validateForm.form()){
			  $("#inputForm").submit();
			  return true;
		  }
	
		  return false;
		}
		$(document).ready(function() {
			validateForm = $("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
			
		});
	</script> -->
</head>
<body class="hideScroll">
		<form id="inputForm" modelAttribute="ironfofiveyjyf" action="${ctx}/ironfofiveyjyf/ironfofiveyjyf/save" method="post" class="form-horizontal">
		<%-- <form:hidden path="id"/>
		<sys:message content="${message}"/>	 --%>
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
		   
		  		 <tr>
				
				
					注：<br/>
					功能单元建筑面积：该功能单元所有房间和场所的建筑面积之和。<br/>
					空间类型：乡镇卫生院设置有该类场所就算作有此种类型的空间，不需要名称一致。<br/>
					
				</tr> 
				
				<tr>
					<td class="width-15 active"><label class="pull-right">功能单元建筑面积</label></td>
					<td class="width-35">
						<input path="gndyjzmj" name="gndyjzmj_name_gndyjzmj_yjyf" id="gndyjzmj" value="${data.gndyjzmj }" htmlEscape="false"    class="form-control "/>
					    <input   type="hidden" name="gndyjzmj_name_gndyjzmj_yjyf"  id="docId"  value="${data.doc_id}" htmlEscape="false"    class="form-control "/>
						
					</td>
					
					<td class="width-15 "></td>
					<td class="width-35">
						
					</td>
				</tr>
			
		 	</tbody>
		</table>
		
			<div class="tabs-container">
	            <ul class="nav nav-tabs">
					<li class="active"><a data-toggle="tab" href="#tab-1" aria-expanded="true">医技用房空间类型</a>
	                </li>
	            </ul>
	            
	             <div class="tab-content">
					<div id="tab-1" class="tab-pane active">
	 					<table id="contentTable" class="table table-striped table-bordered table-condensed">
							<thead>
							
								<tr>
				
										<td>
											<c:if test="${data.mzxyfyjkyf=='1' }">
												<input type="checkbox" name="yjyf_name" path="mzxyfyjkyf" id="mzxyfyjkyf" value="mzxyfyjkyf" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;门诊西药房-药剂科用房
											</c:if>
											<c:if test="${data.mzxyfyjkyf=='0' }">
												<input type="checkbox" name="yjyf_name" path="mzxyfyjkyf" id="mzxyfyjkyf" value="mzxyfyjkyf" htmlEscape="false" style="margin-top: -2px;"/>&nbsp;门诊西药房-药剂科用房
											</c:if>
										</td>
										<td>
											<c:if test="${data.mzzyfyjkyf=='1' }">
												<input type="checkbox" name="yjyf_name" path="mzxyfyjkyf" id="mzzyfyjkyf" value="mzzyfyjkyf" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;门诊中药房-药剂科用房
											</c:if>
											<c:if test="${data.mzzyfyjkyf=='0' }">
												<input type="checkbox" name="yjyf_name" path="mzzyfyjkyf" id="mzzyfyjkyf" value="mzzyfyjkyf" htmlEscape="false" style="margin-top: -2px;"/>&nbsp;门诊中药房-药剂科用房
											</c:if>
											
										</td>
										<td>
											<c:if test="${data.jzyfyjkyf=='1' }">
												<input type="checkbox" name="yjyf_name" path="mzxyfyjkyf" id="jzyfyjkyf" value="jzyfyjkyf" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;急诊药房-药剂科用房
											</c:if>
											<c:if test="${data.jzyfyjkyf=='0' }">
												<input type="checkbox" name="yjyf_name" path="jzyfyjkyf" id="jzyfyjkyf" value="jzyfyjkyf"  htmlEscape="false" style="margin-top: -2px;"/>&nbsp;急诊药房-药剂科用房
											</c:if>
										
											
										</td>
										<td>
											<c:if test="${data.tsyfyjkyf=='1' }">
												<input type="checkbox" name="yjyf_name" path="tsyfyjkyf" id="tsyfyjkyf" value="jzyfyjkyf" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;特殊药房-药剂科用房
											</c:if>
											<c:if test="${data.tsyfyjkyf=='0' }">
												<input type="checkbox" name="yjyf_name" path="tsyfyjkyf" id="tsyfyjkyf" value="tsyfyjkyf" htmlEscape="false" style="margin-top: -2px;"/>&nbsp;特殊药房-药剂科用房
											</c:if>
											
										</td>
										<td>
										
											<c:if test="${data.jyfyjkyf=='1' }">
												<input type="checkbox" name="yjyf_name" path="tsyfyjkyf" id="jyfyjkyf" value="jyfyjkyf" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;煎药房-药剂科用房
											</c:if>
											<c:if test="${data.jyfyjkyf=='0' }">
												<input type="checkbox" name="yjyf_name" path="jyfyjkyf" id="jyfyjkyf" value="jyfyjkyf" htmlEscape="false" style="margin-top: -2px;"/>&nbsp;煎药房-药剂科用房
											</c:if>
											
										</td>
										<td>
										
											<c:if test="${data.ypkyjkyf=='1' }">
												<input type="checkbox" name="yjyf_name" path="tsyfyjkyf" id="ypkyjkyf" value="ypkyjkyf" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;药品库-药剂科用房
											</c:if>
											<c:if test="${data.ypkyjkyf=='0' }">
												<input type="checkbox" name="yjyf_name" path="ypkyjkyf" id="ypkyjkyf" value="ypkyjkyf" htmlEscape="false" style="margin-top: -2px;"/>&nbsp;药品库-药剂科用房
											</c:if>
											
										</td>
										<td>
										
											<c:if test="${data.cxsjykyf=='1' }">
												<input type="checkbox" name="yjyf_name" path="tsyfyjkyf" id="cxsjykyf" value="cxsjykyf" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;采血室-检验科用房
											</c:if>
											<c:if test="${data.cxsjykyf=='0' }">
												<input type="checkbox" name="yjyf_name" path="cxsjykyf" id="cxsjykyf" value="cxsjykyf" htmlEscape="false" style="margin-top: -2px;"/>&nbsp;采血室-检验科用房
											</c:if>
											
										</td>
									</tr>
									
						
									<tr>
										<td>
											<c:if test="${data.hysjykyf=='1' }">
												<input type="checkbox" name="yjyf_name" path="tsyfyjkyf" id="hysjykyf" value="hysjykyf" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;化验室-检验科用房
											</c:if>
											<c:if test="${data.hysjykyf=='0' }">
												<input type="checkbox" name="yjyf_name" path="hysjykyf" id="hysjykyf" value="hysjykyf" htmlEscape="false" style="margin-top: -2px;"/>&nbsp;化验室-检验科用房
											</c:if>
										
											
										</td>
										<td>
										
											<c:if test="${data.xgjspsfskyf=='1' }">
												<input type="checkbox" name="yjyf_name" path="tsyfyjkyf" id="xgjspsfskyf" value="xgjspsfskyf" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;X光机摄片室-放射科用房
											</c:if>
											<c:if test="${data.xgjspsfskyf=='0' }">
												<input type="checkbox" name="yjyf_name" path="xgjspsfskyf" id="xgjspsfskyf" value="xgjspsfskyf" htmlEscape="false" style="margin-top: -2px;"/>&nbsp;X光机摄片室-放射科用房
											</c:if>
											
										</td>
										<td>
											<c:if test="${data.xgjkzsfskyf=='1' }">
												<input type="checkbox" name="yjyf_name" path="tsyfyjkyf" id="xgjkzsfskyf" value="xgjkzsfskyf" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;X光机控制室-放射科用房
											</c:if>
											<c:if test="${data.xgjkzsfskyf=='0' }">
												<input type="checkbox" name="yjyf_name" path="xgjkzsfskyf" id="xgjkzsfskyf" value="xgjkzsfskyf" htmlEscape="false" style="margin-top: -2px;"/>&nbsp;X光机控制室-放射科用房
											</c:if>
											
										</td>
										<td>
											<c:if test="${data.ctspsfskyf=='1' }">
												<input type="checkbox" name="yjyf_name" path="tsyfyjkyf" id="ctspsfskyf" value="ctspsfskyf" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;CT摄片室-放射科用房
											</c:if>
											<c:if test="${data.ctspsfskyf=='0' }">
												<input type="checkbox" name="yjyf_name" path="ctspsfskyf" id="ctspsfskyf" value="ctspsfskyf" htmlEscape="false" style="margin-top: -2px;"/>&nbsp;CT摄片室-放射科用房
											</c:if>
										
											
										</td>
										<td>
										
											<c:if test="${data.ctkzsfskyf=='1' }">
												<input type="checkbox" name="yjyf_name" path="tsyfyjkyf" id="ctkzsfskyf" value="ctkzsfskyf" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;CT控制室-放射科用房
											</c:if>
											<c:if test="${data.ctkzsfskyf=='0' }">
												<input type="checkbox" name="yjyf_name" path="ctkzsfskyf" id="ctkzsfskyf" value="ctkzsfskyf" htmlEscape="false" style="margin-top: -2px;"/>&nbsp;CT控制室-放射科用房
											</c:if>
											
										</td>
										<td>
										
											<c:if test="${data.dpsfskyf=='1' }">
												<input type="checkbox" name="yjyf_name" path="tsyfyjkyf" id="dpsfskyf" value="dpsfskyf" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;读片室-放射科用房
											</c:if>
											<c:if test="${data.dpsfskyf=='0' }">
												<input type="checkbox" name="yjyf_name" path="dpsfskyf" id="dpsfskyf" value="dpsfskyf" htmlEscape="false" style="margin-top: -2px;"/>&nbsp;读片室-放射科用房
											</c:if>
											
										</td>
										<td>
										
											<c:if test="${data.xdts=='1' }">
												<input type="checkbox" name="yjyf_name" path="tsyfyjkyf" id="xdts" value="xdts" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;心电图室
											</c:if>
											<c:if test="${data.xdts=='0' }">
												<input type="checkbox" name="yjyf_name" path="xdts" id="xdts" value="xdts" htmlEscape="false" style="margin-top: -2px;"/>&nbsp;心电图室
											</c:if>
											
										</td>
									</tr>
								
									<tr>
										
										<td>
										
										
											<c:if test="${data.css=='1' }">
												<input type="checkbox" name="yjyf_name" path="tsyfyjkyf" id="css" value="css" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;超声室
											</c:if>
											<c:if test="${data.css=='0' }">
												<input type="checkbox" name="yjyf_name" path="css" id="css" value="css" htmlEscape="false" style="margin-top: -2px;"/>&nbsp;超声室
											</c:if>
											
										</td>
										<td>
										
											<c:if test="${data.xksxkyf=='1' }">
												<input type="checkbox" name="yjyf_name" path="tsyfyjkyf" id="xksxkyf" value="xksxkyf" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;血库-输血科用房
											</c:if>
											<c:if test="${data.xksxkyf=='0' }">
												<input type="checkbox" name="yjyf_name" path="xksxkyf" id="xksxkyf" value="xksxkyf" htmlEscape="false" style="margin-top: -2px;"/>&nbsp;血库-输血科用房
											</c:if>
											
										</td>
										<td>
										
											<c:if test="${data.pxssxkyf=='1' }">
												<input type="checkbox" name="yjyf_name" path="tsyfyjkyf" id="pxssxkyf" value="pxssxkyf" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;配血室-输血科用房
											</c:if>
											<c:if test="${data.pxssxkyf=='0' }">
												<input type="checkbox" name="yjyf_name" path="pxssxkyf" id="pxssxkyf" value="pxssxkyf" htmlEscape="false" style="margin-top: -2px;"/>&nbsp;配血室-输血科用房
											</c:if>
											
										</td>
										<td>
										
											<c:if test="${data.qwqxdgys=='1' }">
												<input type="checkbox" name="yjyf_name" path="tsyfyjkyf" id="qwqxdgys" value="qwqxdgys" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;去污区-消毒供应室
											</c:if>
											<c:if test="${data.qwqxdgys=='0' }">
												<input type="checkbox" name="yjyf_name" path="qwqxdgys" id="qwqxdgys" value="qwqxdgys" htmlEscape="false" style="margin-top: -2px;"/>&nbsp;去污区-消毒供应室
											</c:if>
											
										</td>
										<td>
										
											<c:if test="${data.jcbzjmjqxdgys=='1' }">
												<input type="checkbox" name="yjyf_name" path="tsyfyjkyf" id="jcbzjmjqxdgys" value="jcbzjmjqxdgys" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;检查包装及灭菌区-消毒供应室
											</c:if>
											<c:if test="${data.jcbzjmjqxdgys=='0' }">
												<input type="checkbox" name="yjyf_name" path="jcbzjmjqxdgys" id="jcbzjmjqxdgys" value="jcbzjmjqxdgys" htmlEscape="false" style="margin-top: -2px;"/>&nbsp;检查包装及灭菌区-消毒供应室
											</c:if>
											
										</td>
										<td>
										
											<c:if test="${data.wjwpcfqxdgys=='1' }">
												<input type="checkbox" name="yjyf_name" path="tsyfyjkyf" id="wjwpcfqxdgys" value="wjwpcfqxdgys" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;无菌物品存放区-消毒供应室
											</c:if>
											<c:if test="${data.wjwpcfqxdgys=='0' }">
												<input type="checkbox" name="yjyf_name" path="wjwpcfqxdgys" id="wjwpcfqxdgys" value="wjwpcfqxdgys" htmlEscape="false" style="margin-top: -2px;"/>&nbsp;无菌物品存放区-消毒供应室
											</c:if>
											
										</td>
										<td>
											<c:if test="${data.sssssb=='1' }">
												<input type="checkbox" name="yjyf_name" path="tsyfyjkyf" id="sssssb" value="sssssb" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;手术室-手术部
											</c:if>
											<c:if test="${data.sssssb=='0' }">
												<input type="checkbox" name="yjyf_name" path="sssssb" id="sssssb" value="sssssb" htmlEscape="false" style="margin-top: -2px;"/>&nbsp;手术室-手术部
											</c:if>
											
										</td>
									</tr>
									
									<tr>
										<td>
										
											<c:if test="${data.cfssb=='1' }">
												<input type="checkbox" name="yjyf_name" path="tsyfyjkyf" id="cfssb" value="cfssb" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;产房-手术部
											</c:if>
											<c:if test="${data.cfssb=='0' }">
												<input type="checkbox" name="yjyf_name" path="cfssb" id="cfssb" value="cfssb" htmlEscape="false" style="margin-top: -2px;"/>&nbsp;产房-手术部
											</c:if>
											
										</td>
										<td>
										
											<c:if test="${data.zbsssb=='1' }">
												<input type="checkbox" name="yjyf_name" path="tsyfyjkyf" id="zbsssb" value="zbsssb" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;准备室-手术部
											</c:if>
											<c:if test="${data.zbsssb=='0' }">
												<input type="checkbox" name="yjyf_name" path="zbsssb" id="zbsssb" value="zbsssb" htmlEscape="false" style="margin-top: -2px;"/>&nbsp;准备室-手术部
											</c:if>
											
										</td>
										<td>
										
											<c:if test="${data.dcsssb=='1' }">
												<input type="checkbox" name="yjyf_name" path="dcsssb" id="dcsssb" value="dcsssb" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;待产室-手术部
											</c:if>
											<c:if test="${data.dcsssb=='0' }">
												<input type="checkbox" name="yjyf_name" path="dcsssb" id="dcsssb" value="dcsssb" htmlEscape="false" style="margin-top: -2px;"/>&nbsp;待产室-手术部
											</c:if>
											
										</td>
										<td>
										
											<c:if test="${data.gysssb=='1' }">
												<input type="checkbox" name="yjyf_name" path="dcsssb" id="gysssb" value="gysssb" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;更衣间-手术部
											</c:if>
											<c:if test="${data.gysssb=='0' }">
												<input type="checkbox" name="yjyf_name" path="gysssb" id="gysssb" value="gysssb" htmlEscape="false" style="margin-top: -2px;"/>&nbsp;更衣间-手术部
											</c:if>
											
										</td>
										<td>
										
											<c:if test="${data.xsjssb=='1' }">
												<input type="checkbox" name="yjyf_name" path="dcsssb" id="xsjssb" value="xsjssb" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;洗手间-手术部
											</c:if>
											<c:if test="${data.xsjssb=='0' }">
												<input type="checkbox" name="yjyf_name" path="xsjssb" id="xsjssb" value="xsjssb" htmlEscape="false" style="margin-top: -2px;"/>&nbsp;洗手间-手术部
											</c:if>
											
										</td>
										<td>
										
											<c:if test="${data.shsxsssb=='1' }">
												<input type="checkbox" name="yjyf_name" path="dcsssb" id="shsxsssb" value="shsxsssb" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;术后苏醒室-手术部
											</c:if>
											<c:if test="${data.shsxsssb=='0' }">
												<input type="checkbox" name="yjyf_name" path="shsxsssb" id="shsxsssb" value="shsxsssb" htmlEscape="false" style="margin-top: -2px;"/>&nbsp;术后苏醒室-手术部
											</c:if>
											
										</td>
									</tr>
									 <tr>
										
										<td>其它（请注明）</td><td><input name="yjyf_name_qtqzm" id="yjyf_name_qtqzm" value="${data.qtqzm }"  type="text" /></td>
										<input type = "hidden" htmlEscape="false" id="yjyf_name_id"   name="yjyf_name_id" value="${data.id}"  class="form-control "/>
					
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
		
		var data = document.getElementsByName("yjyf_name");
	 	var remarks = document.getElementById("yjyf_name_qtqzm").value;
		var id= document.getElementById("yjyf_name_id").value; 
		var title = document.getElementsByName("gndyjzmj_name_gndyjzmj_yjyf");
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
		      url:"${ctx}/ironfofiveyjyf/ironfofiveyjyf/save",
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