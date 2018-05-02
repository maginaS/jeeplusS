<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>4.2信息化系统功能实现管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		var validateForm;
		function doSubmit(){//回调函数，在编辑和保存动作时，供openDialog调用提交表单。
		  if(validateForm.form()){
			  $("#inputForm").submit();
			  return true;
		  }
	
		  return false;
		}
		
		var remark;
		
		
		 $(document).ready(function() {
			 
			 
			 var url = location.search;
				 remark = url.split("&")[1].split("=")[1];
				 
				 
				 document.getElementById('se_id').value = url.split("&")[0].split("=")[1];

					if(remark == 1){
						document.getElementById("jgjk").style.display="block";
					}else if(remark == 2){
						document.getElementById("jbylfw").style.display="block";
					}else if(remark == 3){
						document.getElementById("jkxxfw").style.display="block";
					}else if(remark == 4){
						document.getElementById("jbggwsfw").style.display="block";
					}else if(remark == 5){
						document.getElementById("jgyygl").style.display="block";
					}else if(remark == 6){
						document.getElementById("jkdagl").style.display="block";
					}
					
				 
			 
			 
			/* validateForm = $("#inputForm").validate({
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
			}); */
			
		}); 
		 
		 
		 /**
			*保存按钮
			*
			*/
			function subuimtinput(){
				
				var jgjk;//1
				var jbylfw;//2
				var jkxxfw;//3
				var jbggwsfw;//4
				var jgyygl;//5
				var jkdagl;//6
				
				var datas="";
				var checkbox="";
				var type="";
				var checkout="";
				var remarks;
				var titles="";
				var id;
				
				
				var title = document.getElementsByName("xxhxtgndy_name");
				for(var i=0;i<title.length;i++){
					if(title[i].value==null||title[i].value==""){
						titles = titles +title[i].id+": ---- ;";	
					}else{
						titles = titles +title[i].id+":"+title[i].value+";";	
					}
				}
				
				
				
				
				/* checkbox */
				if(remark == 1){
				    id= document.getElementById("jgjk_name_id").value; 
					
					var jgjk_data = document.getElementsByName("jgjk_name");
					    check_val = [];
					    check_out = [];
					    for(a in jgjk_data){
					        if(jgjk_data[a].checked){
					        	  check_val.push(jgjk_data[a].value);
					        }else{
					        	  check_out.push(jgjk_data[a].value);
					        }
					        
					        
					    } 
					    jgjk = check_val;
					    checkbox=checkbox+jgjk;
					    checkout=checkout+check_out;
					    type = "1";
					   
				}else if(remark == 2){
			
				 	id= document.getElementById("jbylfw_name_id").value; 
					var jbylfw_data = document.getElementsByName("jbylfw_name");
				    check_val = [];
				    check_out = [];
				    for(l in jbylfw_data){
				        if(jbylfw_data[l].checked){
				        	  check_val.push(jbylfw_data[l].value);
				        }else{
				        	 check_out.push(jbylfw_data[l].value);	
				        }
				        	  
				        
				    } 
				    jbylfw = check_val;
				    checkbox=checkbox+jbylfw;
				    type = "2";
				    checkout=checkout+check_out;
				  
				}else if(remark == 3){
					var jkxxfw_data = document.getElementsByName("jkxxfw_name");
					 id= document.getElementById("jkxxfw_name_id").value;
				    check_val = [];
				    check_out = [];
				    for(b in jkxxfw_data){
				        if(jkxxfw_data[b].checked){
				        	  check_val.push(jkxxfw_data[b].value);
				        }else{
				        	check_out.push(jkxxfw_data[b].value);
				        }
				        	  	
				        
				    } 
				    jkxxfw = check_val;
				    checkbox=checkbox+jkxxfw;
				    type="3";
				    checkout=checkout+check_out;
				   
				}else if(remark == 4){
					var jbggwsfw_data = document.getElementsByName("jbggwsfw_name");
					 //id=  $("input#yjb_name_id").val(); 
					 id=  document.getElementById("jbggwsfw_name_id").value;
				    check_val = [];
				    check_out = [];
				    for(c in jbggwsfw_data){
				        if(jbggwsfw_data[c].checked){
				        	  check_val.push(jbggwsfw_data[c].value);
				        }else{
				        	 check_out.push(jbggwsfw_data[c].value);
				        }
				        	 
				        
				    } 
				    jbggwsfw = check_val;
				    checkbox=checkbox+jbggwsfw;
				    type="4";
				    checkout=checkout+check_out;
				   
				}else if(remark == 6){
					var jkdagl_data = document.getElementsByName("jkdagl_name");
					 id= document.getElementById("jkdagl_name_id").value;
				    check_val = [];
				    check_out = [];
				    for(d in jkdagl_data){
				        if(jkdagl_data[d].checked){
				            check_val.push(jkdagl_data[d].value);
				        }else{
				        	check_out.push(jkdagl_data[d].value);
				        }
				        	
				        
				    }
				    jkdagl=check_val;
				    checkbox=checkbox+jkdagl;
				    type="6";
				    checkout=checkout+check_out;
				   
				}else if(remark==5){
					var jgyygl_data = document.getElementsByName("jgyygl_name");
					id= document.getElementById("jgyygl_name_id").value; 
					    check_val = [];
					    check_out = [];
					    for(e in jgyygl_data){
					        if(jgyygl_data[e].checked){
					            check_val.push(jgyygl_data[e].value);
					        }else{
					        	check_out.push(jgyygl_data[e].value);
					        }
					        	
					        
					    }
					    jgyygl=check_val;
					    checkbox=checkbox+jgyygl;
					    type="5";
					    checkout=checkout+check_out;
					   
				}
				
				 $.ajax({
				      url:"${ctx}/ironfoinformationsx/ironfoinformationsx/save",
				      data:{
				    	  titles:titles,
				      	  checkbox:checkbox,
				      	  type:type,
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
</head>
<body class="hideScroll">
	<form id="inputForm" modelAttribute="ironfoinformationsx" action="${ctx}/ironfoinformationsx/ironfoinformationsx/save" method="post" class="form-horizontal">
	<%-- 	<form:hidden path="id"/>
		<sys:message content="${message}"/>	 --%>
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
			
				<tr>
					<td class="width-15 active"><label class="pull-right">信息化系统功能单元</label></td>
					<td class="width-35">
						<input path="xxhxtgndy" readOnly="true" name="xxhxtgndy_name"  value="${ironfoinformationsx.xxhxtgndy}"  htmlEscape="false"    class="form-control "/>
						<input   type="hidden" name="xxhxtgndy_name"  id="se_id"  htmlEscape="false"    class="form-control "/>
						<input   type="hidden" name="xxhxtgndy_name" id="docId"  value="${data.doc_id}" htmlEscape="false"    class="form-control "/>
					
					</td>
					<td class="width-15 active"></td>
		   			<td class="width-35" ></td>
		  		</tr>
		 	</tbody>
		</table>
		
		<div class="tabs-container">
            <ul class="nav nav-tabs">
				<li class="" style="display:none" id="jbggwsfw"><a data-toggle="tab" href="#tab-1" aria-expanded="true">基本公共卫生服务选项</a>
                </li>
				<li class="" style="display:none" id="jbylfw"><a data-toggle="tab" href="#tab-2" aria-expanded="false">基本医疗服务选项</a>
                </li>
				<li class="" style="display:none" id="jgjk"><a data-toggle="tab" href="#tab-3" aria-expanded="false">监管接口选项</a>
                </li>
				<li class="" style="display:none" id="jgyygl"><a data-toggle="tab" href="#tab-4" aria-expanded="false">机构运营管理选项</a>
                </li>
				<li class="" style="display:none" id="jkdagl"><a data-toggle="tab" href="#tab-5" aria-expanded="false">健康档案管理选项</a>
                </li>
				<li class="" style="display:none" id="jkxxfw"><a data-toggle="tab" href="#tab-6" aria-expanded="false">健康信息服务选项</a>
                </li>
            </ul>
            <div class="tab-content">
				<div id="tab-1" class="tab-pane">
<!-- 			<a class="btn btn-white btn-sm" onclick="addRow('#ironfoinformationsxjbggwsfwList', ironfoinformationsxjbggwsfwRowIdx, ironfoinformationsxjbggwsfwTpl);ironfoinformationsxjbggwsfwRowIdx = ironfoinformationsxjbggwsfwRowIdx + 1;" title="新增"><i class="fa fa-plus"></i> 新增</a>
 -->			<table id="contentTable" class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						
						<th>健康教育服务</th>
						<th>预防接种服务</th>
						<th>儿童健康管理服务</th>
						<th>孕产妇健康管理服务</th>
						<th>老年人健康管理服务</th>
						<th>高血压患者健康管理服务</th>
						<th>2型糖尿病患者健康管理服务</th>
						<th>严重精神障碍患者健康管理服务</th>
						<th>肺结核患者健康管理服务</th>
						<th>老年人中医药健康管理服务</th>
						<th>儿童中医药健康管理服务</th>
						<th>传染病及突发公共卫生事件管理服务</th>
						<th>卫生计生监督协管服务</th>
						<th>计划生育技术服务</th>
						<th>慢性病检测服务</th>
						
					</tr>
				</thead>
				<tbody id="">
				
					<tr>
					
							<%-- <c:if test="${data.yfbjk=='1'}">
								<input name="ggwsbxx_name" id="yfbjk" value="yfbjk" type="checkbox" checked="checked"/>
							</c:if>
							<c:if test="${data.yfbjk=='0'}">
								<input name="ggwsbxx_name" id="yfbjk"  value="yfbjk" type="checkbox"/>
							</c:if> --%>
							
						<th>
							 <c:if test="${data.jkjyfw=='1'}">
							 	<input name="jbggwsfw_name" id="jkjyfw" value="jkjyfw" type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.jkjyfw=='0'}">
								<input name="jbggwsfw_name" id="jkjyfw" value="jkjyfw" type="checkbox" />
							</c:if>
						</th>
						<th>
						 <c:if test="${data.yfjzfw=='1'}">
						
								<input name="jbggwsfw_name" id="yfjzfw"  value="yfjzfw" type="checkbox" checked="checked"/>
							</c:if>
							<c:if test="${data.yfjzfw=='0'}">
								<input name="jbggwsfw_name" id="yfjzfw"  value="yfjzfw" type="checkbox" />
							</c:if>
						</th><!-- 预防接种服务 -->
						<th>
							<c:if test="${data.etjkglfw=='1'}">
								<input name="jbggwsfw_name" id="etjkglfw" value="etjkglfw" type="checkbox"  checked="checked"/>
							</c:if>
							<c:if test="${data.etjkglfw=='0'}">
								<input name="jbggwsfw_name" id="etjkglfw" value="etjkglfw" type="checkbox" />
							</c:if>
						<!-- 儿童健康管理服务 -->
						</th>
						<th>
							<c:if test="${data.ycfjkglfw=='1'}">
								<input name="jbggwsfw_name" id="ycfjkglfw" value="ycfjkglfw" type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.ycfjkglfw=='0'}">
								<input name="jbggwsfw_name" id="ycfjkglfw" value="ycfjkglfw" type="checkbox" />
							</c:if>
						<!-- 孕产妇健康管理服务 --></th>
						<th>
							<c:if test="${data.lnrjkglfw=='1'}">
								<input name="jbggwsfw_name" id="lnrjkglfw" value="lnrjkglfw" type="checkbox" checked="checked"/>
							</c:if>
							<c:if test="${data.lnrjkglfw=='0'}">
								<input name="jbggwsfw_name" id="lnrjkglfw" value="lnrjkglfw" type="checkbox" />
							</c:if>
						<!-- 老年人健康管理服务 --></th>
						<th>
							<c:if test="${data.gxyhzjkglfw=='1'}">
								<input name="jbggwsfw_name" id="gxyhzjkglfw" value="gxyhzjkglfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.gxyhzjkglfw=='0'}">
								<input name="jbggwsfw_name" id="gxyhzjkglfw" value="gxyhzjkglfw"  type="checkbox" />
							</c:if>
						<!-- 高血压患者健康管理服务 --></th>
						<th>
							<c:if test="${data.extnbhzjkglfw=='1'}">
								<input name="jbggwsfw_name" id="extnbhzjkglfw" value="extnbhzjkglfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.extnbhzjkglfw=='0'}">
								<input name="jbggwsfw_name" id="extnbhzjkglfw" value="extnbhzjkglfw" type="checkbox" />
							</c:if>
						<!-- 2型糖尿病患者健康管理服务 --></th>
						<th>
						
							<c:if test="${data.yzjszahzjkglfw=='1'}">
								<input name="jbggwsfw_name" id="yzjszahzjkglfw" value="yzjszahzjkglfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.yzjszahzjkglfw=='0'}">
									<input name="jbggwsfw_name" id="yzjszahzjkglfw" value="yzjszahzjkglfw"  type="checkbox" />
							</c:if><!-- 严重精神障碍患者健康管理服务 --></th>
						<th>
							<c:if test="${data.fjhhzjkglfw=='1'}">
								<input name="jbggwsfw_name" id="fjhhzjkglfw" value="fjhhzjkglfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.fjhhzjkglfw=='0'}">
									<input name="jbggwsfw_name" id="fjhhzjkglfw" value="fjhhzjkglfw"  type="checkbox" />
							</c:if>
						<!-- 肺结核患者健康管理服务 --></th>
						<th>
							<c:if test="${data.lnrzyyjkglfw=='1'}">
								<input name="jbggwsfw_name" id="lnrzyyjkglfw" value="lnrzyyjkglfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.lnrzyyjkglfw=='0'}">
									<input name="jbggwsfw_name" id="lnrzyyjkglfw" value="lnrzyyjkglfw" type="checkbox" />
							</c:if>
						<!-- 老年人中医药健康管理服务 --></th>
						<th>
							<c:if test="${data.etzyyjkglfw=='1'}">
								<input name="jbggwsfw_name" id="etzyyjkglfw" value="etzyyjkglfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.etzyyjkglfw=='0'}">
									<input name="jbggwsfw_name" id="etzyyjkglfw" value="etzyyjkglfw" type="checkbox" />
							</c:if>
						<!-- 儿童中医药健康管理服务 --></th>
						<th>
							<c:if test="${data.crbjtfggwssjglfw=='1'}">
								<input name="jbggwsfw_name" id="crbjtfggwssjglfw" value="crbjtfggwssjglfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.crbjtfggwssjglfw=='0'}">
									<input name="jbggwsfw_name" id="crbjtfggwssjglfw" value="crbjtfggwssjglfw"  type="checkbox" />
							</c:if>
						<!-- 传染病及突发公共卫生事件管理服务 --></th>
						<th>
							<c:if test="${data.wsjsjdxgfw=='1'}">
								<input name="jbggwsfw_name" id="wsjsjdxgfw" value="wsjsjdxgfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.wsjsjdxgfw=='0'}">
								<input name="jbggwsfw_name" id="wsjsjdxgfw" value="wsjsjdxgfw" type="checkbox" />
							</c:if>
						<!-- 卫生计生监督协管服务 --></th>
						<th>
						<c:if test="${data.jhsyjsfw=='1'}">
								<input name="jbggwsfw_name" id="jhsyjsfw" value="jhsyjsfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.jhsyjsfw=='0'}">
								<input name="jbggwsfw_name" id="jhsyjsfw" value="jhsyjsfw"  type="checkbox" />
							</c:if>
						<!-- 计划生育技术服务 --></th>
						<th>
							<c:if test="${data.mxbjcfw=='1'}">
								<input name="jbggwsfw_name" id="mxbjcfw" value="mxbjcfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.mxbjcfw=='0'}">
								<input name="jbggwsfw_name" id="mxbjcfw" value="mxbjcfw" type="checkbox" />
							</c:if>
						<!-- 慢性病检测服务 --></th>
						<!-- <th width="10">&nbsp;</th> -->
						
						<input type = "hidden" htmlEscape="false" id="jbggwsfw_name_id"   name="jbggwsfw_name_id" value="${data.id}"  class="form-control "/>
						
					</tr>
				
				</tbody>
			</table>
		
			</div>
				<div id="tab-2" class="tab-pane">
<!-- 			<a class="btn btn-white btn-sm" onclick="addRow('#ironfoinformationsxjbylfwList', ironfoinformationsxjbylfwRowIdx, ironfoinformationsxjbylfwTpl);ironfoinformationsxjbylfwRowIdx = ironfoinformationsxjbylfwRowIdx + 1;" title="新增"><i class="fa fa-plus"></i> 新增</a>
 -->			<table id="contentTable" class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
					
						<th>全科诊疗服务</th>
						<th>住院管理服务</th>
						<th>家庭病床与护理服务</th>
						<th>健康体检服务</th>
						<th>检验和检查服务</th>
						<th>远程双向转诊服务</th>
						<th>远程会诊服务</th>
						<th>远程预约服务</th>
						<th>远程影像诊断服务</th>
						<th>远程心电诊断服务</th>
						<th>远程医学教育服务</th>
						<th>远程重症监护服务</th>
						<th>远程手术示教服务</th>
						<th>手术麻醉管理服务</th>
						<th>中央监护服务</th>
						<!-- <th class="hide"></th> -->
						<!-- <th>备注信息</th>
						<th>主表id</th>
						<th>4.2信息化系统功能实现表id</th> -->
						
						<!-- <th width="10">&nbsp;</th> -->
					</tr>
				</thead>
				<tbody id="">
					<tr>
						<th>
							<c:if test="${data.qkzlfw=='1'}">
								<input name="jbylfw_name" id="qkzlfw" value="qkzlfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.qkzlfw=='0'}">
								<input  name="jbylfw_name" id="qkzlfw" value="qkzlfw" type="checkbox" />
							</c:if>
						
						<!-- 全科诊疗服务 --></th>
						<th>
							<c:if test="${data.zyglfw=='1'}">
								<input name="jbylfw_name" id="zyglfw" value="zyglfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.zyglfw=='0'}">
								<input  name="jbylfw_name" id="zyglfw" value="zyglfw" type="checkbox" />
							</c:if>
						<!-- 住院管理服务 --></th>
						<th>
							<c:if test="${data.jtbcyhlfw=='1'}">
								<input name="jbylfw_name" id="jtbcyhlfw" value="jtbcyhlfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.jtbcyhlfw=='0'}">
								<input  name="jbylfw_name" id="jtbcyhlfw" value="jtbcyhlfw" type="checkbox" />
							</c:if>
						<!-- 家庭病床与护理服务 --></th>
						<th>
							<c:if test="${data.jktyfw=='1'}">
								<input name="jbylfw_name" id="jktyfw" value="jktyfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.jktjfw=='0'}">
								<input  name="jbylfw_name" id="jktyfw" value="jktyfw" type="checkbox" />
							</c:if>
						<!-- 健康体检服务 --></th>
						<th>
							<c:if test="${data.jyhjcfw=='1'}">
								<input name="jbylfw_name" id="jyhjcfw" value="jyhjcfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.jyhjcfw=='0'}">
								<input  name="jbylfw_name" id="jyhjcfw" value="jyhjcfw" type="checkbox" />
							</c:if>
						<!-- 检验和检查服务 --></th>
						<th>
							<c:if test="${data.ycsxzzfw=='1'}">
								<input name="jbylfw_name" id="ycsxzzfw" value="ycsxzzfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.ycsxzzfw=='0'}">
								<input  name="jbylfw_name" id="ycsxzzfw" value="ycsxzzfw" type="checkbox" />
							</c:if>
						<!-- 远程双向转诊服务 --></th>
						<th>
							<c:if test="${data.ychzfw=='1'}">
								<input name="jbylfw_name" id="ychzfw" value="ychzfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.ychzfw=='0'}">
								<input  name="jbylfw_name" id="ychzfw" value="ychzfw" type="checkbox" />
							</c:if>
						<!-- 远程会诊服务 --></th>
						<th>
							<c:if test="${data.ycyyfw=='1'}">
								<input name="jbylfw_name" id="ycyyfw" value="ycyyfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.ycyyfw=='0'}">
								<input  name="jbylfw_name" id="ycyyfw" value="ycyyfw" type="checkbox" />
							</c:if>
						<!-- 远程预约服务 --></th>
						<th>
							<c:if test="${data.ycyxzdfw=='1'}">
								<input name="jbylfw_name" id="ycyxzdfw" value="ycyxzdfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.ycyxzdfw=='0'}">
								<input  name="jbylfw_name" id="ycyxzdfw" value="ycyxzdfw" type="checkbox" />
							</c:if>
						<!-- 远程影像诊断服务 --></th>
						<th>
							<c:if test="${data.ycxdzdfw=='1'}">
								<input name="jbylfw_name" id="ycxdzdfw" value="ycxdzdfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.ycxdzdfw=='0'}">
								<input  name="jbylfw_name" id="ycxdzdfw" value="ycxdzdfw" type="checkbox" />
							</c:if>
						<!-- 远程心电诊断服务 --></th>
						<th>
							<c:if test="${data.ycyxjyfw=='1'}">
								<input name="jbylfw_name" id="ycyxjyfw" value="ycyxjyfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.ycyxjyfw=='0'}">
								<input  name="jbylfw_name" id="ycyxjyfw" value="ycyxjyfw" type="checkbox" />
							</c:if>
						
						<!-- 远程医学教育服务 --></th>
						<th>
						<c:if test="${data.yczzjhfw=='1'}">
								<input name="jbylfw_name" id="yczzjhfw" value="yczzjhfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.yczzjhfw=='0'}">
								<input  name="jbylfw_name" id="yczzjhfw" value="yczzjhfw" type="checkbox" />
							</c:if><!-- 远程重症监护服务 --></th>
						<th>
						
							<c:if test="${data.ycsssjfw=='1'}">
								<input name="jbylfw_name" id="ycsssjfw" value="ycsssjfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.ycsssjfw=='0'}">
								<input  name="jbylfw_name" id="ycsssjfw" value="ycsssjfw" type="checkbox" />
							</c:if>
						<!-- 远程手术示教服务 --></th>
						<th>
							<c:if test="${data.ssmzglfw=='1'}">
								<input name="jbylfw_name" id="ssmzglfw" value="ssmzglfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.ssmzglfw=='0'}">
								<input  name="jbylfw_name" id="ssmzglfw" value="ssmzglfw" type="checkbox" />
							</c:if>
						
						<!-- 手术麻醉管理服务 --></th>
						<th>
							<c:if test="${data.zyjhfw=='1'}">
								<input name="jbylfw_name" id="zyjhfw" value="zyjhfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.zyjhfw=='0'}">
								<input  name="jbylfw_name" id="zyjhfw" value="zyjhfw" type="checkbox" />
							</c:if>
						<!-- 中央监护服务 --></th>
						
						<input type = "hidden" htmlEscape="false" id="jbylfw_name_id"   name="jbylfw_name_id" value="${data.id}"  class="form-control "/>
						
					</tr>
					
				</tbody>
			</table>
			
			</div>
				<div id="tab-3" class="tab-pane">
<!-- 			<a class="btn btn-white btn-sm" onclick="addRow('#ironfoinformationsxjgjkList', ironfoinformationsxjgjkRowIdx, ironfoinformationsxjgjkTpl);ironfoinformationsxjgjkRowIdx = ironfoinformationsxjgjkRowIdx + 1;" title="新增"><i class="fa fa-plus"></i> 新增</a>
 -->			<table id="contentTable" class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						
						<th>基本公共卫生服务监管接口</th>
						<th>基本医疗服务监管接口</th>
						<th>基本药物监管接口</th>
						<th>新农合补偿监管接口</th>
					
					</tr>
				</thead>
				<tbody id="">
					<tr>
						
						
						<th>
							<c:if test="${data.jbggwsfwjgjk=='1'}">
								<input name="jgjk_name" id="jbggwsfwjgjk" value="jbggwsfwjgjk"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.jbggwsfwjgjk=='0'}">
								<input name="jgjk_name" id="jbggwsfwjgjk" value="jbggwsfwjgjk" type="checkbox" />
							</c:if>
						
						<!-- 基本公共卫生服务监管接口 --></th>
						<th>
							<c:if test="${data.jbylfwjgjk=='1'}">
								<input name="jgjk_name" id="jbylfwjgjk" value="jbylfwjgjk"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.jbylfwjgjk=='0'}">
								<input name="jgjk_name" id="jbylfwjgjk" value="jbylfwjgjk" type="checkbox" />
							</c:if>
						<!-- 基本医疗服务监管接口 --></th>
						<th>
							<c:if test="${data.jbywjgjk=='1'}">
								<input name="jgjk_name" id="jbywjgjk" value="jbywjgjk"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.jbywjgjk=='0'}">
								<input name="jgjk_name" id="jbywjgjk" value="jbywjgjk" type="checkbox" />
							</c:if>
						<!-- 基本药物监管接口 --></th>
						<th>
							<c:if test="${data.xnhbcjgjk=='1'}">
								<input name="jgjk_name" id="xnhbcjgjk" value="xnhbcjgjk"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.xnhbcjgjk=='0'}">
								<input name="jgjk_name" id="xnhbcjgjk" value="xnhbcjgjk" type="checkbox" />
							</c:if>
						<!-- 新农合补偿监管接口 --></th>
						
							<input type = "hidden" htmlEscape="false" id="jgjk_name_id"   name="jgjk_name_id" value="${data.id}"  class="form-control "/>
						
						
					</tr>
				</tbody>
			</table>
			
			
			</div>
				<div id="tab-4" class="tab-pane">
<!-- 			<a class="btn btn-white btn-sm" onclick="addRow('#ironfoinformationsxjgyyglList', ironfoinformationsxjgyyglRowIdx, ironfoinformationsxjgyyglTpl);ironfoinformationsxjgyyglRowIdx = ironfoinformationsxjgyyglRowIdx + 1;" title="新增"><i class="fa fa-plus"></i> 新增</a>
 -->			<table id="contentTable" class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						
						<th>基本药物管理服务</th>
						<th>药房管理服务</th>
						<th>药库管理服务</th>
						<th>物资管理服务</th>
						<th>设备管理服务</th>
						<th>财务管理服务</th>
						<th>个人绩效考核服务</th>
						<th>机构绩效考核服务</th>
						<th>统计分析与综合查询服务</th>
						<th>院感管理服务</th>
						<th>医疗废物管理服务</th>
						<th>消毒供应管理服务</th>
						
					</tr>
				</thead>
				<tbody id="">
					<tr>
						
						<th>
							<c:if test="${data.jbywglfw=='1'}">
								<input name="jgyygl_name" id="jbywglfw" value="jbywglfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.jbywglfw=='0'}">
								<input name="jgyygl_name" id="jbywglfw" value="jbywglfw" type="checkbox" />
							</c:if>
						<!-- 基本药物管理服务 --></th>
						<th>
							<c:if test="${data.yfglfw=='1'}">
								<input name="jgyygl_name" id="yfglfw" value="yfglfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.yfglfw=='0'}">
								<input name="jgyygl_name" id="yfglfw" value="yfglfw" type="checkbox" />
							</c:if>
						<!-- 药房管理服务 --></th>
						<th>
							<c:if test="${data.ykglfw=='1'}">
								<input name="jgyygl_name" id="ykglfw" value="ykglfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.ykglfw=='0'}">
								<input name="jgyygl_name" id="ykglfw" value="ykglfw" type="checkbox" />
							</c:if>
						<!-- 药库管理服务 --></th>
						<th>
							<c:if test="${data.wzglfw=='1'}">
								<input name="jgyygl_name" id="wzglfw" value="wzglfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.wzglfw=='0'}">
								<input name="jgyygl_name" id="wzglfw" value="wzglfw" type="checkbox" />
							</c:if>
						<!-- 物资管理服务 --></th>
						<th>
							<c:if test="${data.sbglfw=='1'}">
								<input name="jgyygl_name" id="sbglfw" value="sbglfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.sbglfw=='0'}">
								<input name="jgyygl_name" id="sbglfw" value="sbglfw" type="checkbox" />
							</c:if>
						<!-- 设备管理服务 --></th>
						<th>
							<c:if test="${data.cwglfw=='1'}">
								<input name="jgyygl_name" id="cwglfw" value="cwglfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.cwglfw=='0'}">
								<input name="jgyygl_name" id="cwglfw" value="cwglfw" type="checkbox" />
							</c:if>
						<!-- 财务管理服务 --></th>
						<th>
							<c:if test="${data.grxxkhfw=='1'}">
								<input name="jgyygl_name" id="grxxkhfw" value="grxxkhfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.grxxkhfw=='0'}">
								<input name="jgyygl_name" id="grxxkhfw" value ="grxxkhfw" type="checkbox" />
							</c:if>
						<!-- 个人绩效考核服务 --></th>
						<th>
							<c:if test="${data.jgxykhfw=='1'}">
								<input name="jgyygl_name" id="jgxykhfw" value="jgxykhfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.jgxykhfw=='0'}">
								<input name="jgyygl_name" id="jgxykhfw" value="jgxykhfw" type="checkbox" />
							</c:if>
						<!-- 机构绩效考核服务 --></th>
						<th>
							<c:if test="${data.tjfxyzhcxfw=='1'}">
								<input name="jgyygl_name" id="tjfxyzhcxfw" value="tjfxyzhcxfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.tjfxyzhcxfw=='0'}">
								<input name="jgyygl_name" id="tjfxyzhcxfw" value="tjfxyzhcxfw" type="checkbox" />
							</c:if>
						<!-- 统计分析与综合查询服务 --></th>
						<th>
							<c:if test="${data.ygglfw=='1'}">
								<input name="jgyygl_name" id="ygglfw" value="ygglfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.ygglfw=='0'}">
								<input name="jgyygl_name" id="ygglfw" value="ygglfw" type="checkbox" />
							</c:if>
						<!-- 院感管理服务 --></th>
						<th>
							<c:if test="${data.ylfwglfw=='1'}">
								<input name="jgyygl_name" id="ylfwglfw" value="ylfwglfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.ylfwglfw=='0'}">
								<input name="jgyygl_name" id="ylfwglfw" value="ylfwglfw" type="checkbox" />
							</c:if>
						<!-- 医疗废物管理服务 --></th>
						<th>
							<c:if test="${data.xdgyglfw=='1'}">
								<input name="jgyygl_name" id="xdgyglfw" value="xdgyglfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.xdgyglfw=='0'}">
								<input name="jgyygl_name" id="xdgyglfw" value="xdgyglfw" type="checkbox" />
							</c:if>
						<!-- 消毒供应管理服务 --></th>
						
						<input type = "hidden" htmlEscape="false" id="jgyygl_name_id"   name="jgyygl_name_id" value="${data.id}"  class="form-control "/>
						
					</tr>
				</tbody>
			</table>
			
			</div>
				<div id="tab-5" class="tab-pane">
<!-- 			<a class="btn btn-white btn-sm" onclick="addRow('#ironfoinformationsxjkdaglList', ironfoinformationsxjkdaglRowIdx, ironfoinformationsxjkdaglTpl);ironfoinformationsxjkdaglRowIdx = ironfoinformationsxjkdaglRowIdx + 1;" title="新增"><i class="fa fa-plus"></i> 新增</a>
 -->			<table id="contentTable" class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						
						<!-- <th>备注信息</th>
						<th>4.2信息化系统功能实现表id</th> -->
						<th>居民健康档案管理服务</th>
						<th>居民健康卡管理服务</th>
						<th>家庭健康档案管理服务</th>
						<!-- <th>主表id</th> -->
						
					</tr>
				</thead>
				<tbody id="">
					<tr>
						<th>
						
							<c:if test="${data.jmjkdaglfw=='1'}">
								<input name="jkdagl_name" id="jmjkdaglfw" value="jmjkdaglfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.jmjkdaglfw=='0'}">
								<input name="jkdagl_name" id="jmjkdaglfw" value="jmjkdaglfw" type="checkbox" />
							</c:if>
						</th>
						<th>
							<c:if test="${data.jmjkkglfw=='1'}">
								<input name="jkdagl_name" id="jmjkkglfw" value="jmjkkglfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.jmjkkglfw=='0'}">
								<input name="jkdagl_name" id="jmjkkglfw" value="jmjkkglfw" type="checkbox" />
							</c:if>
						</th>
						<th>
							<c:if test="${data.jtjkdaglfw=='1'}">
								<input name="jkdagl_name" id="jtjkdaglfw" value="jtjkdaglfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.jtjkdaglfw=='0'}">
								<input name="jkdagl_name" id="jtjkdaglfw" value="jtjkdaglfw" type="checkbox" />
							</c:if>
							<input type = "hidden" htmlEscape="false" id="jkdagl_name_id"   name="jkdagl_name_id" value="${data.id}"  class="form-control "/>
							
						</th>
					</tr>
				</tbody>
			</table>
		
			
			</div>
				<div id="tab-6" class="tab-pane">
<!-- 			<a class="btn btn-white btn-sm" onclick="addRow('#ironfoinformationsxjkxxfwList', ironfoinformationsxjkxxfwRowIdx, ironfoinformationsxjkxxfwTpl);ironfoinformationsxjkxxfwRowIdx = ironfoinformationsxjkxxfwRowIdx + 1;" title="新增"><i class="fa fa-plus"></i> 新增</a>
 -->			<table id="contentTable" class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<!-- <th class="hide"></th> -->
					<!-- 	<th>备注信息</th>
						<th>主表id</th>
						<th> 4.2信息化系统功能实现id</th> -->
						<th>健康档案查询服务</th>
						<th>健康信息发布管理服务</th>
						<th>网上预约和提醒服务</th>
						<th>健康教育信息服务</th>
						<!-- <th width="10">&nbsp;</th> -->
					</tr>
				</thead>
				<tbody id="">
					<tr>
						<!-- <th class="hide"></th> -->
					<!-- 	<th>备注信息</th>
						<th>主表id</th>
						<th> 4.2信息化系统功能实现id</th> -->
						<th>
						
							<c:if test="${data.jkdacxfw=='1'}">
								<input name="jkxxfw_name" id="jkdacxfw" value="jkdacxfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.jkdacxfw=='0'}">
								<input name="jkxxfw_name" id="jkdacxfw" value="jkdacxfw" type="checkbox" />
							</c:if>
						<!-- 健康档案查询服务 --></th>
						<th>
							<c:if test="${data.jkxxfbglfw=='1'}">
								<input name="jkxxfw_name" id="jkxxfbglfw" value="jkxxfbglfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.jkxxfbglfw=='0'}">
								<input  name="jkxxfw_name" id="jkxxfbglfw" value="jkxxfbglfw" type="checkbox" />
							</c:if>
						<!-- 健康信息发布管理服务 --></th>
						<th>
							<c:if test="${data.wsyyhtxfw=='1'}">
								<input name="jkxxfw_name" id="wsyyhtxfw" value="wsyyhtxfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.wsyyhtxfw=='0'}">
								<input  name="jkxxfw_name" id="wsyyhtxfw" value="wsyyhtxfw" type="checkbox" />
							</c:if>
						<!-- 网上预约和提醒服务 --></th>
						<th>
						
							<c:if test="${data.jkjyxxfw=='1'}">
								<input name="jkxxfw_name" id="jkjyxxfw" value="jkjyxxfw"  type="checkbox" checked="checked" />
							</c:if>
							<c:if test="${data.jkjyxxfw=='0'}">
								<input  name="jkxxfw_name" id="jkjyxxfw" value="jkjyxxfw" type="checkbox" />
							</c:if>
						<!-- 健康教育信息服务 --></th>
						<!-- <th width="10">&nbsp;</th> -->
					</tr>
					<input type = "hidden" htmlEscape="false" id="jkxxfw_name_id"   name="jkxxfw_name_id" value="${data.id}"  class="form-control "/>
					
				</tbody>
			</table>
			</div>
		</div>
		</div>
	</form>
	
	
	<div style="text-align:right;">
		<input type="button" value="保存"  style="width:100px;height:50px;" onclick="subuimtinput();"/>
	</div>
	
</body>
</html>