<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>2.4科室设置管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
	
		var validateForm;
		var remark;
		
	
		$(document).ready(function() {
			 var url = location.search;
			
			 remark = url.split("&")[1].split("=")[1];
			 document.getElementById('dep_id').value = url.split("&")[0].split("=")[1];
			if(remark == 1){
				document.getElementById("jhsyb").style.display="block";
			}else if(remark == 2){
				document.getElementById("znglb").style.display="block";
			}else if(remark == 3){
				document.getElementById("mjzb").style.display="block";
			}else if(remark == 4){
				document.getElementById("yjb").style.display="block";
			}else if(remark == 5){
				document.getElementById("ggwsb").style.display="block";
			}else if(remark == 6){
				document.getElementById("zyb").style.display="block";
			}
			
			
		
		});
		
		
		

		
		/**
		*保存按钮
		*
		*/
		function subuimtinput(){
			
			var jhsyb;
			var znglb;
			var mjzb;
			var yjb;
			var ggwsb;
			var zyb;
			var datas="";
			var checkbox="";
			var type="";
			var checkout="";
			var remarks;
			var titles="";
			var id;
			
			
			var title = document.getElementsByName("ggwsbxx_name_name_zndy");
			for(var i=0;i<title.length;i++){
				if(title[i].value==null||title[i].value==""){
					titles = titles +title[i].id+": ---- ;";	
				}else{
					titles = titles +title[i].id+":"+title[i].value+";";	
				}
			}
			
			
			
			
			/* checkbox */
			if(remark == 1){
			    id= document.getElementById("jhsyk_name_id").value; 
				
				remarks = document.getElementById("jhsyk_name_text").value;
				  /*  remarks = document.getElementsByName("jhsyk_name_text").value; */
				var jhsyk_data = document.getElementsByName("jhsyk_name");
				    check_val = [];
				    check_out = [];
				    for(a in jhsyk_data){
				        if(jhsyk_data[a].checked){
				        	  check_val.push(jhsyk_data[a].value);
				        }else{
				        	  check_out.push(jhsyk_data[a].value);
				        }
				        
				        
				    } 
				    jhsyb = check_val;
				    checkbox=checkbox+jhsyb;
				    checkout=checkout+check_out;
				    type = "1";
				    remarks =remarks;
			}else if(remark == 2){
		/* 		remarks = document.getElementsByName("znglb_name_text").value; */
				remarks = document.getElementById("znglb_name_text").value;
			 	id= document.getElementById("znglb_name_id").value; 
				var znglb_data = document.getElementsByName("znglb_name");
			    check_val = [];
			    check_out = [];
			    for(l in znglb_data){
			        if(znglb_data[l].checked){
			        	  check_val.push(znglb_data[l].value);
			        }else{
			        	 check_out.push(znglb_data[l].value);	
			        }
			        	  
			        
			    } 
			    znglb = check_val;
			    checkbox=checkbox+znglb;
			    type = "2";
			    checkout=checkout+check_out;
			    remarks=remarks;
			}else if(remark == 3){
				remarks = document.getElementById("mjzb_name_text").value;
				var mjzb_data = document.getElementsByName("mjzb_name");
				 id= document.getElementById("mjzb_name_id").value;
			    check_val = [];
			    check_out = [];
			    for(b in mjzb_data){
			        if(mjzb_data[b].checked){
			        	  check_val.push(mjzb_data[b].value);
			        }else{
			        	check_out.push(mjzb_data[b].value);
			        }
			        	  	
			        
			    } 
			    mjzb = check_val;
			    checkbox=checkbox+mjzb;
			    type="3";
			    checkout=checkout+check_out;
			    remarks=remarks;
			}else if(remark == 4){
				remarks = document.getElementById("yjb_name_text").value;
				var yjb_data = document.getElementsByName("yjb_name");
				 //id=  $("input#yjb_name_id").val(); 
				 id=  document.getElementById("yjb_name_id").value;
			    check_val = [];
			    check_out = [];
			    for(c in yjb_data){
			        if(yjb_data[c].checked){
			        	  check_val.push(yjb_data[c].value);
			        }else{
			        	 check_out.push(yjb_data[c].value);
			        }
			        	 
			        
			    } 
			    yjb = check_val;
			    checkbox=checkbox+yjb;
			    type="4";
			    checkout=checkout+check_out;
			    remarks=remarks;
			}else if(remark == 6){
				remarks = document.getElementById("zyb_name_text").value;
				var zyb_data = document.getElementsByName("zyb_name");
				 id= document.getElementById("zyb_name_id").value;
			    check_val = [];
			    check_out = [];
			    for(d in zyb_data){
			        if(zyb_data[d].checked){
			            check_val.push(zyb_data[d].value);
			        }else{
			        	check_out.push(zyb_data[d].value);
			        }
			        	
			        
			    }
			    zyb=check_val;
			    checkbox=checkbox+zyb;
			    type="6";
			    checkout=checkout+check_out;
			    remarks=remarks;
			}else if(remark==5){
				remarks = document.getElementById("ggwsbxx_name_text").value;
				var gg_data = document.getElementsByName("ggwsbxx_name");
				id= document.getElementById("ggwsbxx_name_id").value; 
				    check_val = [];
				    check_out = [];
				    for(e in gg_data){
				        if(gg_data[e].checked){
				            check_val.push(gg_data[e].value);
				        }else{
				        	check_out.push(gg_data[e].value);
				        }
				        	
				        
				    }
				    ggwsb=check_val;
				    checkbox=checkbox+ggwsb;
				    type="5";
				    checkout=checkout+check_out;
				    remarks=remarks;
			}
			
			 $.ajax({
			      url:"${ctx}/ironfo_department/ironfodepartment/save",
			      data:{
			    	  titles:titles,
			      	  checkbox:checkbox,
			      	  type:type,
			      	  checkout:checkout,
			      	  remarks:remarks,
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
	<form id="inputForm" modelAttribute="ironfodepartment" action="${ctx}/ironfo_department/ironfodepartment/save" method="post" class="form-horizontal">
	<%-- 	<form:hidden path="id"/>
		<sys:message content="${message}"/>	 --%>
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
					<td class="width-15 active"><label class="pull-right">职能单元</label></td>
					<td class="width-35">
						<input  name="ggwsbxx_name_name_zndy" readOnly="true"  id="zndy"  value="${ironfodepartment.zndy }" htmlEscape="false"    class="form-control "/>
						<input   type="hidden" name="ggwsbxx_name_name_zndy"  id="dep_id"  htmlEscape="false"    class="form-control "/>
					<!--  type="hidden"  --><input   type="hidden" name="ggwsbxx_name_name_zndy" id="docId"  value="${data.doc_id}" htmlEscape="false"    class="form-control "/>
					
					</td>
					<!-- <td class="width-15 active"></td>
		   			<td class="width-35" ></td> -->
				</tr>
		 	</tbody>
		</table>
		
		<div class="tabs-container">
            <ul class="nav nav-tabs">
				<li class="" id="ggwsb" style="display:none"><a data-toggle="tab" href="#tab-1" aria-expanded="false">公共卫生部选项</a>
                </li>
				<li class="" id="jhsyb" style="display:none"><a data-toggle="tab" href="#tab-2" aria-expanded="false">计划生育部选项</a>
                </li>
				<li class="" id="mjzb" style="display:none"><a data-toggle="tab" href="#tab-3" aria-expanded="false">门急诊部选项</a>
                </li>
				<li class="" id="yjb" style="display:none"><a data-toggle="tab" href="#tab-4" aria-expanded="false">医技部选项</a>
                </li>
				<li class="" id="znglb" style="display:none"><a data-toggle="tab" href="#tab-5" aria-expanded="false">职能管理部选项</a>
                </li>
				<li class="" id="zyb" style="display:none"><a data-toggle="tab" href="#tab-6" aria-expanded="false">住院部选项</a>
                </li>
            </ul>
            <div class="tab-content">
				<div id="tab-1" class="tab-pane">
				<table id="contentTable" class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<th class="hide"></th>
						
						<th>预防保健科</th>
						<th>妇女保健科</th>
						<th>儿童保健科</th>
						<th>体检中心</th>
						<th>其它（请注明）</th>
					</tr>
				</thead>
				<tbody id="ironfodepartmentggwsbList">
				
					<tr>
						<th class="hide"></th>
						<th>
							<c:if test="${data.yfbjk=='1'}">
								<input name="ggwsbxx_name" id="yfbjk" value="yfbjk" type="checkbox" checked="checked"/>
							</c:if>
							<c:if test="${data.yfbjk=='0'||data.yfbjk==''||data.yfbjk==null}">
								<input name="ggwsbxx_name" id="yfbjk"  value="yfbjk" type="checkbox"/>
							</c:if>
						
						</th>
						<th>
							<c:if test="${data.fnbjk=='1'}">
								<input name="ggwsbxx_name" id="fnbjk" value="fnbjk" type="checkbox" checked="checked"/>
							</c:if>
							<c:if test="${data.fnbjk=='0'||data.fnbjk==''||data.fnbjk==null}">
								<input name="ggwsbxx_name" id="fnbjk"  value="fnbjk" type="checkbox"/>
							</c:if>
						</th>
						<th>
							<c:if test="${data.etbjk=='1'}">
								<input name="ggwsbxx_name" id="etbjk" value="etbjk" type="checkbox" checked="checked"/>
							</c:if>
							<c:if test="${data.etbjk=='0'||data.etbjk==''||data.etbjk==null}">
								<input name="ggwsbxx_name" id="etbjk"  value="etbjk" type="checkbox"/>
							</c:if>
						
						</th>
						<th>
							<c:if test="${data.tjzx=='1'}">
								<input name="ggwsbxx_name" id="tjzx" value="tjzx" type="checkbox" checked="checked"/>
							</c:if>
							<c:if test="${data.tjzx=='0'||data.tjzx==''||data.tjzx==null}">
								<input name="ggwsbxx_name" id="tjzx"   value="tjzx"  type="checkbox"/>
							</c:if>
						
						</th>
						<th><input name="ggwsbxx_name_text" id="ggwsbxx_name_text" value="${data.tjremark }"   type="text"/></th>
						<input type = "hidden" htmlEscape="false" id="ggwsbxx_name_id"   name="ggwsbxx_name_id" value="${data.id}"  class="form-control "/>
				
				
					</tr>
				
				
				</tbody>
			</table>
			</div>
				<div id="tab-2" class="tab-pane">
 					<table id="contentTable" class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<th class="hide"></th>
						<th>计划生育科</th>
						<th>其它（请注明）</th>
						<th width="10">&nbsp;</th>
					</tr>
				</thead>
				<tbody id="ironfodepartmentjhsybList">
				
					<tr>
						<th class="hide"></th>
						<th>
						
							<c:if test="${data.jhsyk=='1'}">
								<input name="jhsyk_name" id="jhsyk" value="jhsyk" type="checkbox" checked="checked"/>
							</c:if>
							<c:if test="${data.jhsyk=='0'||data.jhsyk==''||data.jhsyk==null}">
								<input name="jhsyk_name" value="jhsyk" id="jhsyk" type="checkbox"/>
							</c:if>
						</th>
						<th><input name="jhsyk_name_text" id="jhsyk_name_text" value="${data.tjremark }"   type="text"/></th>
						<input type = "hidden" htmlEscape="false" id="jhsyk_name_id"   name="jhsyk_name_id" value="${data.id}"  class="form-control "/>
						
						<th width="10">&nbsp;</th>
					</tr>
				
				</tbody>
			</table>
		
			
			</div>
				<div id="tab-3" class="tab-pane">
 <table id="contentTable" class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<!-- <th class="hide"></th> -->
					
						<th>急诊室</th>
						<th>内科</th>
						<th>儿科</th>
						<th>外科</th>
						<th>妇产科</th>
						<th>全科医学科</th>
						<th>中医科</th>
						<th>眼科</th>
						<th>耳鼻喉科</th>
						<th>口腔科</th>
						<th>康复科</th>
						<th>皮肤科</th>
						<th>感染性疾病科</th>
						<th>精神科</th>
						<th>其它（请注明）</th>
						<!-- <th width="10">&nbsp;</th> -->
					</tr>
				</thead>
				<tbody id="ironfodepartmentremarkList">
				
					<tr>
					<!-- 	<th class="hide"></th> -->
							
						<th>
							<c:if test="${data.jzs=='1'}">
								
								<input name="mjzb_name" id="jzs" value="jzs" type="checkbox" checked="checked"/>
							</c:if>
							<c:if test="${data.jzs=='0'||data.jzs==''||data.jzs==null}">
								<input name="mjzb_name" id="jzs" value="jzs" type="checkbox" />
							</c:if>
						</th>
						<th>
							<c:if test="${data.nk=='1'}">
								<!-- <input  name="mjzb_name" id="nk" value="nk" type="checkbox"/> -->
								<input name="mjzb_name" id="nk" value="nk" type="checkbox" checked="checked"/>
							</c:if>
							<c:if test="${data.nk=='0'||data.nk==''||data.nk==null}">
								<input name="mjzb_name" id="nk" value="nk" type="checkbox" />
							</c:if>
						</th>
						<th>
							<c:if test="${data.ek=='1'}">
								<input name="mjzb_name" id="ek" value="ek" type="checkbox" checked="checked"/>
							</c:if>
							<c:if test="${data.ek=='0'||data.ek==''||data.ek==null}">
								<input name="mjzb_name" id="ek" value="ek" type="checkbox" />
							</c:if>
						</th>
						<th>
							<c:if test="${data.wk=='1'}">
								<input name="mjzb_name" id="wk" value="wk" type="checkbox" checked="checked"/>
							</c:if>
							<c:if test="${data.wk=='0'||data.wk==''||data.wk==null}">
								<input  name="mjzb_name" id="wk" value="wk" type="checkbox"/>
							</c:if>
						</th>
						<th>
							<c:if test="${data.fck=='1'}">
								<input name="mjzb_name" id="fck" value="fck" type="checkbox" checked="checked"/>
							</c:if>
							<c:if test="${data.fck=='0'||data.fck==''||data.fck==null}">
								<input  name="mjzb_name" id="fck" value="fck" type="checkbox"/>
							</c:if>
						</th>
						<th>
							<c:if test="${data.qkyxk=='1'}">
								<input name="mjzb_name" id="qkyxk" value="qkyxk" type="checkbox" checked="checked"/>
							</c:if>
							<c:if test="${data.qkyxk=='0'||data.qkyxk==''||data.qkyxk==null}">
								<input  name="mjzb_name" id="qkyxk" value="qkyxk" type="checkbox"/>
							</c:if>
						
						</th>
						<th>
							<c:if test="${data.zyk=='1'}">
								<input name="mjzb_name" id="zyk" value="zyk" type="checkbox" checked="checked"/>
							</c:if>
							<c:if test="${data.zyk=='0'||data.zyk==''||data.zyk==null}">
								<input  name="mjzb_name" id="zyk" value="zyk" type="checkbox"/>
							</c:if>
						</th>
						<th>
							<c:if test="${data.yk=='1'}">
								<input name="mjzb_name" id="yk" value="yk" type="checkbox" checked="checked"/>
							</c:if>
							<c:if test="${data.yk=='0'||data.yk==''||data.yk==null}">
								<input  name="mjzb_name" id="yk" value="yk" type="checkbox"/>
							</c:if>
						</th>
						<th>
							<c:if test="${data.ebhk=='1'}">
								<input name="mjzb_name" id="ebhk" value="ebhk" type="checkbox" checked="checked"/>
							</c:if>
							<c:if test="${data.ebhk=='0'||data.ebhk==''||data.ebhk==null}">
								<input  name="mjzb_name" id="ebhk" value="ebhk" type="checkbox"/>
							</c:if>
						</th>
						<th>
							<c:if test="${data.kqk=='1'}">
								<input name="mjzb_name" id="kqk" value="kqk" type="checkbox" checked="checked"/>
							</c:if>
							<c:if test="${data.kqk=='0'||data.kqk==''||data.kqk==null}">
								<input  name="mjzb_name" id="kqk" value="kqk" type="checkbox"/>
							</c:if>
						</th>
						<th>
							<c:if test="${data.kfk=='1'}">
								<input name="mjzb_name" id="kfk" value="kfk" type="checkbox" checked="checked"/>
							</c:if>
							<c:if test="${data.kfk=='0'||data.kfk==''||data.kfk==null}">
								<input  name="mjzb_name" id="kfk" value="kfk" type="checkbox"/>
							</c:if>
						
						</th>
						<th>
							<c:if test="${data.pfk=='1'}">
								<input name="mjzb_name" id="pfk" value="pfk" type="checkbox" checked="checked"/>
							</c:if>
							<c:if test="${data.pfk=='0'||data.pfk==''||data.pfk==null}">
								<input  name="mjzb_name" id="pfk" value="pfk" type="checkbox"/>
							</c:if>
						</th>
						<th>
							<c:if test="${data.grxjbk=='1'}">
								<input name="mjzb_name" id="grxjbk" value="grxjbk" type="checkbox" checked="checked"/>
							</c:if>
							<c:if test="${data.grxjbk=='0'||data.grxjbk==''||data.grxjbk==null}">
								<input  name="mjzb_name" id="grxjbk" value="grxjbk" type="checkbox"/>
							</c:if>
						</th>
						<th>
							<c:if test="${data.jsk=='1'}">
								<input name="mjzb_name" id="jsk" value="jsk" type="checkbox" checked="checked"/>
							</c:if>
							<c:if test="${data.jsk=='0'||data.jsk==''||data.jsk==null}">
								<input  name="mjzb_name" id="jsk" value="jsk" type="checkbox"/>
							</c:if>
						</th>
						<th><input  name="mjzb_name_text" id="mjzb_name_text" value="${data.zjremark }" type="text"/></th>
						<input type = "hidden" htmlEscape="false" id="mjzb_name_id"   name="mjzb_name_id" value="${data.id}"  class="form-control "/>
						
						<!-- <th width="10">&nbsp;</th> -->
					</tr>
				
				</tbody>
			</table>
			
			
			</div>
				<div id="tab-4" class="tab-pane">
 <table id="contentTable" class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<th class="hide"></th>
						<th>药剂科</th>
						<th>检验科</th>
						<th>放射科</th>
						<th>超声科</th>
						<th>心电图科</th>
						<th>消毒供应室</th>
						<th>手术室</th>
						<th>其它（请注明）</th>
						<th width="10">&nbsp;</th>
					</tr>
				</thead>
				<tbody id="ironfodepartmentyjbList">
				
				<tr>
						<th class="hide"></th>
						
						<th>
							<c:if test="${data.yjk=='1'}">
								<input name="yjb_name" id="yjk" value="yjk" type="checkbox" checked="checked"/>
							</c:if>
							<c:if test="${data.yjk=='0'||data.yjk==''||data.yjk==null}">
								<input name="yjb_name" id="yjk" value="yjk" type="checkbox" />
							</c:if>
						</th>
						<th>
						
							<c:if test="${data.jyk=='1'}">
							<!-- <input name="yjb_name" id="jyk" value="jyk"  type="checkbox"/> -->
								<input name="yjb_name" id="jyk" value="jyk" type="checkbox" checked="checked"/>
							</c:if>
							<c:if test="${data.jyk=='0'||data.jyk==''||data.jyk==null}">
								<input name="yjb_name" id="jyk" value="jyk" type="checkbox" />
							</c:if>
						</th>
						<th>
							<c:if test="${data.fsk=='1'}">
								<input name="yjb_name" id="fsk" value="fsk" type="checkbox" checked="checked"/>
							</c:if>
							<c:if test="${data.fsk=='0'||data.fsk==''||data.fsk==null}">
								<input name="yjb_name" id="fsk" value="fsk" type="checkbox" />
							</c:if>
						</th>
						<th>
							<c:if test="${data.csk=='1'}">
						
								<input name="yjb_name" id="csk" value="csk" type="checkbox" checked="checked"/>
							</c:if>
							<c:if test="${data.csk=='0'||data.csk==''||data.csk==null}">
								<input name="yjb_name" id="csk" value="csk" type="checkbox" />
							</c:if>
						
						</th>
						<th>
							<c:if test="${data.xdtk=='1'}">
								<input name="yjb_name" id="xdtk" value="xdtk" type="checkbox" checked="checked"/>
							</c:if>
							<c:if test="${data.xdtk=='0'||data.xdtk==''||data.xdtk==null}">
								<input name="yjb_name" id="xdtk" value="xdtk" type="checkbox" />
							</c:if>
						</th>
						<th>
							<c:if test="${data.xdgys=='1'}">
								<input name="yjb_name" id="xdgys" value="xdgys" type="checkbox" checked="checked"/>
							</c:if>
							<c:if test="${data.xdgys=='0'||data.xdgys==''||data.xdgys==null}">
								<input name="yjb_name" id="xdgys" value="xdgys" type="checkbox" />
							</c:if>
						</th>
						<th>
							<c:if test="${data.sss=='1'}">
								
								<input name="yjb_name" id="sss" value="sss" type="checkbox" checked="checked"/>
							</c:if>
							<c:if test="${data.sss=='0'||data.sss==''||data.sss==null}">
								<input name="yjb_name" id="sss" value="sss" type="checkbox" />
							</c:if>
						
						</th>
					<!-- 	type = "hidden" -->
						<th><input name="yjb_name_text" id="yjb_name_text" value="${data.tjremark }" type="text"/></th>
						<input  type = "hidden" htmlEscape="false" id="yjb_name_id"   name="yjb_name_id" value="${data.id}"  class="form-control "/>
						
						<th width="10">&nbsp;</th>
					</tr>
				</tbody>
			</table>
		
			
			</div>
				<div id="tab-5" class="tab-pane">
 <table id="contentTable" class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<th class="hide"></th>
						<th>院长办公室</th>
						<th>党建办公室</th>
						<th>医务科</th>
						<th>护理科</th>
						<th>财务科</th>
						<th>档案管理科</th>
						<th>信息中心</th>
						<th>院感科</th>
						<th>医保结算科</th>
						<th>后勤管理科</th>
						<th>其它（请注明）</th>
						<th width="10">&nbsp;</th>
					</tr>
				</thead>
				<tbody id="ironfodepartmentznglbList">
				
					<tr>
						<th class="hide"></th>
						
						<th>
							<c:if test="${data.yzbgs=='1'}">
								<input name="znglb_name" id="yzbgs" value="yzbgs" type="checkbox"  checked="checked"/>
							</c:if>
							<c:if test="${data.yzbgs=='0'||data.yzbgs==''||data.yzbgs==null}">
								<input name="znglb_name" id="yzbgs" value="yzbgs" type="checkbox"  />
							</c:if>
						
						</th>
						<th>
							<c:if test="${data.djbgs=='1'}">
								<input name="znglb_name" id="djbgs" value="djbgs" type="checkbox"  checked="checked"/>
							</c:if>
							<c:if test="${data.djbgs=='0'||data.djbgs==''||data.djbgs==null}">
								<input name="znglb_name" id="djbgs" value="djbgs" type="checkbox"  />
							</c:if>
						
						</th>
						<th>
							<c:if test="${data.ywk=='1'}">
							<!-- 	<input name="znglb_name" id="ywk" value="ywk" type="checkbox"/> -->
								<input name="znglb_name" id="ywk" value="ywk" type="checkbox"  checked="checked"/>
							</c:if>
							<c:if test="${data.ywk=='0'||data.ywk==''||data.ywk==null}">
								<input name="znglb_name" id="ywk" value="ywk" type="checkbox"  />
							</c:if>
						
						</th>
						<th>
							<c:if test="${data.hlk=='1'}">
								<!-- <input name="znglb_name" id="hlk" value="hlk" type="checkbox"/> -->
								<input name="znglb_name" id="hlk" value="hlk" type="checkbox"  checked="checked"/>
							</c:if>
							<c:if test="${data.hlk=='0'||data.hlk==''||data.hlk==null}">
								<input name="znglb_name" id="hlk" value="hlk" type="checkbox"  />
							</c:if>
						
						</th>
						<th>
							<c:if test="${data.cwk=='1'}">
							<!-- 	<input name="znglb_name" id="cwk" value="cwk" type="checkbox"/> -->
								<input name="znglb_name" id="cwk" value="cwk" type="checkbox"  checked="checked"/>
							</c:if>
							<c:if test="${data.cwk=='0'||data.cwk==''||data.cwk==null}">
								<input name="znglb_name" id="cwk" value="cwk" type="checkbox"  />
							</c:if>
						</th>
						<th>
							<c:if test="${data.daglk=='1'}">
								<input name="znglb_name" id="daglk" value="daglk" type="checkbox"  checked="checked"/>
							</c:if>
							<c:if test="${data.daglk=='0'||data.daglk==''||data.daglk==null}">
								<input name="znglb_name" id="daglk" value="daglk" type="checkbox"  />
							</c:if>
						</th>
						<th>
							<c:if test="${data.xxzx=='1'}">
								<!-- <input name="znglb_name" id="xxzx" value="xxzx" type="checkbox"/> -->
								<input name="znglb_name" id="xxzx" value="xxzx" type="checkbox"  checked="checked"/>
							</c:if>
							<c:if test="${data.xxzx=='0'||data.xxzx==''||data.xxzx==null}">
								<input name="znglb_name" id="xxzx" value="xxzx" type="checkbox"  />
							</c:if>
						</th>
						<th>
							<c:if test="${data.ygk=='1'}">
								<!-- <input name="znglb_name" id="ygk" value="ygk" type="checkbox"/> -->
								<input name="znglb_name" id="ygk" value="ygk" type="checkbox"  checked="checked"/>
							</c:if>
							<c:if test="${data.ygk=='0'||data.ygk==''||data.ygk==null}">
								<input name="znglb_name" id="ygk" value="ygk" type="checkbox"  />
							</c:if>
						</th>
						<th>
							<c:if test="${data.ybjsk=='1'}">
								<input name="znglb_name" id="ybjsk" value="ybjsk" type="checkbox"  checked="checked"/>
							</c:if>
							<c:if test="${data.ybjsk=='0'||data.ybjsk==''||data.ybjsk==null}">
								<input name="znglb_name" id="ybjsk" value="ybjsk" type="checkbox"  />
							</c:if>
						</th>
						<th>
							<c:if test="${data.hqglk=='1'}">
								<!-- <input name="znglb_name" id="hqglk" value="hqglk" type="checkbox"/> -->
								<input name="znglb_name" id="hqglk" value="hqglk" type="checkbox"  checked="checked"/>
							</c:if>
							<c:if test="${data.hqglk=='0'||data.hqglk==''||data.hqglk==null}">
								<input name="znglb_name" id="hqglk" value="hqglk" type="checkbox"  />
							</c:if>
						</th>
						<th><input name="znglb_name_text" id="znglb_name_text" value="${data.tj_remarks }" type="text"/></th>
						<input type = "hidden" htmlEscape="false" id="znglb_name_id"   name="znglb_name_id" value="${data.id}"  class="form-control "/>
						
						<th width="10">&nbsp;</th>
					</tr>
				
				</tbody>
			</table>
			
			</div>
				<div id="tab-6" class="tab-pane">
 <table id="contentTable" class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<th class="hide"></th>
						<th>普通病区</th>
						<th>康复病区</th>
						<th>临终关怀科</th>
						<th>其它（请注明）</th>
						<th width="10">&nbsp;</th>
					</tr>
				</thead>
				<tbody id="ironfodepartmentzybList">
					<tr>
						<th class="hide"></th>
						<th>
							<c:if test="${data.ptbq=='1'}">
								<input name="zyb_name" id="ptbq" value="ptbq" type="checkbox"  checked="checked"/>
							</c:if>
							<c:if test="${data.ptbq=='0'||data.ptbq==''||data.ptbq==null}">
								<input name="zyb_name" id="ptbq" value="ptbq" type="checkbox"/>
							</c:if>
						
						</th>
						<th>
							<c:if test="${data.kfbq=='1'}">
								<input name="zyb_name" id="kfbq" value="kfbq" type="checkbox"  checked="checked"/>
							</c:if>
							<c:if test="${data.kfbq=='0'||data.kfbq==''||data.kfbq==null}">
								<input name="zyb_name" id="kfbq" value="kfbq"  type="checkbox"/>
							</c:if>
						
						</th>
						<th>
							<c:if test="${data.lzghk=='1'}">
								<input name="zyb_name" id="lzghk" value="lzghk" type="checkbox"  checked="checked"/>
							</c:if>
							<c:if test="${data.lzghk=='0'||data.lzghk==''||data.lzghk==null}">
								<input name="zyb_name" id="lzghk" value="lzghk"  type="checkbox"/>
							</c:if>
						</th>
						<th><input name="zyb_name_text" id="zyb_name_text" value="${data.tjremarks }"   type="text"/></th>
						<input type = "hidden" htmlEscape="false" id="zyb_name_id"   name="zyb_name_id" value="${data.id}"  class="form-control "/>
						
						<th width="10">&nbsp;</th>
					</tr>
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