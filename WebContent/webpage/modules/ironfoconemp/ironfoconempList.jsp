<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>2.7.1职工构成管理</title>
	<meta name="decorator" content="default"/>
	
</head>
<body class="hideScroll">
		<form id="inputForm" modelAttribute="ironfoconemp" action="${ctx}/ironfoconemp/ironfoconemp/save" method="post" class="form-horizontal">
		<%-- <form:hidden path="id"/>
		<sys:message content="${message}"/>	 --%>
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
				注：<BR/>
				卫生技术人员：包括执业医师、执业助理医师、注册护士数、药师（士）、检验技师（士）、影像技师（士）、卫生监督员和见习医（药、护、技）师（士）等卫生专业人员。不包括从事管理工作的卫生技术人员（如院长、副院长、党委书记等）。<BR/>
				其他技术人员：指从事医疗器械修配、卫生宣传、科研、教学等技术工作的非卫生专业人员。<BR/>
				管理人员：指担负领导职责或管理任务的工作人员。包括从事医疗保健、疾病控制、卫生监督、医学科研与教学业务管理工作的人员；主要从事党政、人事、财务、信息、安全保卫等行政管理工作的人员。<BR/>
				工勤技能人员：指承担技能操作和维护、后勤保障服务等职责的工作人员。工勤技能人员分为技术工和普通工。技术工包括护理员（工）、药剂员（工）、检验员、收费员、挂号员等，但不包含实验员、技术员、研究实习员（计入其他技术人员），也不包括经济员、会计员和统计员等（计入管理人员）。<BR/>
				表中各项数据：数据应来源于《全国卫生资源与医疗服务调查制度》卫计统1-2表。<BR/>
				
				
					
					
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">年份</label></td>
					<td class="width-17 active"><label class="pull-right">在岗职工数（人）</label></td>
					<td class="width-17 active"><label class="pull-right">卫生技术人员（人）</label></td>
					<td class="width-17 active"><label class="pull-right">其他技术人员（人）</label></td>
					<td class="width-17 active"><label class="pull-right">管理人员（人）</label></td>
					<td class="width-17 active"><label class="pull-right">工勤技能人员（人）</label></td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="date" htmlEscape="false"   readOnly="true"   value="2015"  name="2015" id ="date" class="form-control "/>
					</td>
					<td class="width-17">
						<input path="zzzgs" htmlEscape="false"   name="2015" id ="zzzgs" value="${data.zzzgs }"   class="form-control "/>
					</td>
					
					<td class="width-17">
						<input path="wsjsry" htmlEscape="false"  name="2015" id ="wsjsry" value="${data.wsjsry }"      class="form-control "/>
					</td>
					
					<td class="width-17">
						<input path="qtjsry" htmlEscape="false"   name="2015" id ="qtjsry" value="${data.qtjsry }"     class="form-control "/>
					</td>
					<td class="width-17">
						<input path="glry" htmlEscape="false"   name="2015" id ="glry" value="${data.glry }"     class="form-control "/>
					</td>
					
					<td class="width-17">
						<input path="gqjnry" htmlEscape="false"    name="2015" id ="gqjnry" value="${data.gqjnry }"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="id"  name="2015" value="${data.id}"  class="form-control "/>
						<input type = "hidden" htmlEscape="false"  name ="2015" id ="docId" value="${data.doc_id} "  class="form-control "/>
					
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="date" htmlEscape="false"  readOnly="true"    value="2016"  name="2016" id="date1" class="form-control "/>
					</td>
					<td class="width-17">
						<input path="zzzgs" htmlEscape="false"   name="2016" id="zzzgs1"  value="${ data.zzzgs1 }"   class="form-control "/>
					</td>
					
					<td class="width-17">
						<input path="wsjsry" htmlEscape="false" name="2016" id="wsjsry1"  value="${ data.wsjsry1 }"      class="form-control "/>
					</td>
					
					<td class="width-17">
						<input path="qtjsry" htmlEscape="false"  name="2016" id="qtjsry1"  value="${ data.qtjsry1 }"     class="form-control "/>
					</td>
					<td class="width-17">
						<input path="glry" htmlEscape="false"   name="2016" id="glry1"  value="${ data.glry1 }"    class="form-control "/>
					</td>
					
					<td class="width-17">
						<input path="gqjnry" htmlEscape="false" name="2016" id="gqjnry1"  value="${ data.gqjnry1 }"      class="form-control "/>
					    <input type = "hidden" htmlEscape="false" id="id1"  name="2016" value="${data.id1}"  class="form-control "/>
				
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="date" htmlEscape="false"  readOnly="true"    value="2017"  name="2016" id="date2" class="form-control "/>
					</td>
					<td class="width-17">
						<input path="zzzgs" htmlEscape="false"  name="2017" id="zzzgs2"  value="${ data.zzzgs2 }"   class="form-control "/>
					</td>
					
					<td class="width-17">
						<input path="wsjsry" htmlEscape="false"  name="2017" id="wsjsry2"  value="${ data.wsjsry2 }"     class="form-control "/>
					</td>
					
					<td class="width-17">
						<input path="qtjsry" htmlEscape="false" name="2017" id="qtjsry2"  value="${ data.qtjsry2 }"      class="form-control "/>
					</td>
					<td class="width-17">
						<input path="glry" htmlEscape="false" name="2017" id="glry2"  value="${ data.glry2 }"      class="form-control "/>
					</td>
					
					<td class="width-17">
						<input path="gqjnry" htmlEscape="false"  name="2017" id="gqjnry2"  value="${ data.gqjnry2 }"     class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="id2"  name="2017" value="${data.id2}"  class="form-control "/>
					
					</td>
					
					
				</tr>
		 	</tbody>
		</table>
	</form>
	
		<div style="text-align:right;">
			<input type="button" value="保存" style="width:100px;height:50px;margin-right: 20px;"  onclick="subuimtinput();"/>
		</div>
		
		
		<script type="text/javascript">
	function subuimtinput(){
		
		var isnull = true;
		var data_2015 = document.getElementsByName("2015");
	    var data_2016 = document.getElementsByName("2016");
		var data_2017 = document.getElementsByName("2017"); 
	
		var datas="";
		
		
		for(i=0;i<data_2015.length;i++){
			if(data_2015[i].value==null||data_2015[i].value==""){
				datas = datas +data_2015[i].id+": ---- ;";	
			}else{
				datas = datas +data_2015[i].id+":"+data_2015[i].value+";";	
			}
			
			
		}
	 	for(i=0;i<data_2016.length;i++){
	 		if(data_2016[i].value==null||data_2016[i].value==""){
	 			datas = datas+data_2016[i].id+": ---- ;";
	 		}else{
	 			datas = datas+data_2016[i].id+":"+data_2016[i].value+";";
	 		}
	 		
		}
		for(i=0;i <data_2017.length;i++){
			if(data_2017[i].value==null||data_2017[i].value==""){
				datas = datas+data_2017[i].id+": ---- ;";
			}else{
				datas = datas+data_2017[i].id+":"+data_2017[i].value+";";
			}
			
		}
		 $.ajax({
		      url:"${ctx}/ironfoconemp/ironfoconemp/save",
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