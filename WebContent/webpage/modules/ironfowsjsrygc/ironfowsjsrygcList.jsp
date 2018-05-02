<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>2.7.2卫生技术人员构成管理</title>
	<meta name="decorator" content="default"/>
</head>
<body class="hideScroll">
		<form id="inputForm" modelAttribute="ironfowsjsrygc" action="${ctx}/ironfowsjsrygc/ironfowsjsrygc/save" method="post" class="form-horizontal">
<%-- 		<form:hidden path="id"/>
		<sys:message content="${message}"/>	 --%>
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
				
				注：<br/>
				表中各项数据：数据应来源于《全国卫生资源与医疗服务调查制度》卫计统1-2表。<br/>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">年份</label></td>
					<td class="width-17 active"><label class="pull-right">执业医师（人）</label></td>
					<td class="width-17 active"><label class="pull-right">执业医师其中公共卫生类别（人）</label></td>
					<td class="width-17 active"><label class="pull-right">执业助理医师（人）</label></td>
					<td class="width-17 active"><label class="pull-right">执业助理医师其中公共卫生类别（人）</label></td>
					<td class="width-17 active"><label class="pull-right">注册全科医生（人）</label></td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="date" htmlEscape="false" name="2015" id="date"  value="2015"  readOnly="true"   class="form-control "/>
					</td>
					<td class="width-17">
						<input path="zyys" htmlEscape="false"  name="2015" id="zyys"  value="${data.zyys }"    class="form-control "/>
					</td>
					
					<td class="width-17">
						<input path="zyysqzggwslb" name="2015" id="zyysqzggwslb"  value="${data.zyysqzggwslb }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-17">
						<input path="zyzlys"  name="2015" id="zyzlys"  value="${data.zyzlys }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-17">
						<input path="zyzlysqzggwslb"  name="2015" id="zyzlysqzggwslb"  value="${data.zyzlysqzggwslb }"  htmlEscape="false"    class="form-control "/>
					</td>
				
					<td class="width-17">
						<input path="zcqkys"  name="2015" id="zcqkys"  value="${data.zcqkys }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="id"  name="2015" value="${data.id}"  class="form-control "/>
						<input type = "hidden" htmlEscape="false"  name ="2015" id ="docId" value="${data.doc_id} "  class="form-control "/>
					
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="date" htmlEscape="false" name="2016" id="date1"    value="2016"  readOnly="true"   class="form-control "/>
					</td>
					<td class="width-17">
						<input path="zyys"  name="2016" id="zyys1"  value="${data.zyys1 }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-17">
						<input path="zyysqzggwslb"  name="2016" id="zyysqzggwslb1"  value="${data.zyysqzggwslb1 }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-17">
						<input path="zyzlys"  name="2016" id="zyzlys1"  value="${data.zyzlys1 }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-17">
						<input path="zyzlysqzggwslb" name="2016" id="zyzlysqzggwslb1"  value="${data.zyzlysqzggwslb1 }"   htmlEscape="false"    class="form-control "/>
					</td>
				
					<td class="width-17">
						<input path="zcqkys" name="2016" id="zcqkys1"  value="${data.zcqkys1 }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="id1"  name="2016" value="${data.id1}"  class="form-control "/>
					
					</td>
				
				
					
					
				</tr>
				
				<tr>
					<td class="width-15">
						<input path="date" htmlEscape="false" name="2017" id="date2" value="2017"   readOnly="true"  class="form-control "/>
					</td>
					<td class="width-17">
						<input path="zyys"  name="2017" id="zyys2"  value="${data.zyys2 }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-17">
						<input path="zyysqzggwslb"  name="2017" id="zyysqzggwslb2"  value="${data.zyysqzggwslb2 }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-17">
						<input path="zyzlys"  name="2017" id="zyzlys2"  value="${data.zyzlys2 }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-17">
						<input path="zyzlysqzggwslb"  name="2017" id="zyzlysqzggwslb2"  value="${data.zyzlysqzggwslb2 }"  htmlEscape="false"    class="form-control "/>
					</td>
				
					<td class="width-17">
						<input path="zcqkys"  name="2017" id="zcqkys2"  value="${data.zcqkys2 }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="id2"  name="2017" value="${data.id2}"  class="form-control "/>
					
					</td>
				
				</tr>
				
				<tr>
					<td class="width-15 active"><label class="pull-right">年份：</label></td>
					<td class="width-17 active"><label class="pull-right">取得全科医生培训合格证的人数（人）：</label></td>
					<td class="width-17 active"><label class="pull-right">注册护士（人）：</label></td>
					<td class="width-17 active"><label class="pull-right">助产士（人）：</label></td>
					<td class="width-17 active"><label class="pull-right">药师（士） （人）：</label></td>
					<td class="width-17 active"><label class="pull-right">中药师（士） （人）：</label></td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="date" htmlEscape="false"  value="2015" name="2015" id="date"   readOnly="true"  class="form-control "/>
					</td>
				
					<td class="width-17">
						<input path="qdqkyspxhgzdrs" name="2015" id="qdqkyspxhgzdrs" value="${data.qdqkyspxhgzdrs }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-17">
						<input path="zchs" name="2015" id="zchs" value="${data.zchs }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-17">
						<input path="zcs" name="2015" id="zcs" value="${data.zcs }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-17">
						<input path="yss" name="2015" id="yss" value="${data.yss }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-17">
						<input path="zys" name="2015" id="zys" value="${data.zys }"  htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="date" htmlEscape="false" name="2016" id="date1"  value="2016"   readOnly="true"  class="form-control "/>
					</td>
				
					<td class="width-17">
						<input path="qdqkyspxhgzdrs" name="2016" id="qdqkyspxhgzdrs1" value="${data.qdqkyspxhgzdrs1 }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-17">
						<input path="zchs" name="2016" id="zchs1" value="${data.zchs1 }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-17">
						<input path="zcs" name="2016" id="zcs1" value="${data.zcs1 }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-17">
						<input path="yss" name="2016" id="yss1" value="${data.yss1 }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-17">
						<input path="zys" name="2016" id="zys1" value="${data.zys1 }"  htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="date" htmlEscape="false" name="2017" id="date2"  value="2017"  readOnly="true"   class="form-control "/>
					</td>
				
					<td class="width-17">
						<input path="qdqkyspxhgzdrs" name="2017" id="qdqkyspxhgzdrs2" value="${data.qdqkyspxhgzdrs2 }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-17">
						<input path="zchs" name="2017" id="zchs2" value="${data.zchs2 }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-17">
						<input path="zcs" name="2017" id="zcs2" value="${data.zcs2 }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-17">
						<input path="yss" name="2017" id="yss2" value="${data.yss2 }"   htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-17">
						<input path="zys" name="2017" id="zys2" value="${data.zys2 }"   htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					
					
					<td class="width-15 active"><label class="pull-right">年份：</label></td>
					<td class="width-17 active"><label class="pull-right">检验医师（士） （人）：</label></td>
					<td class="width-17 active"><label class="pull-right">影像医师（士） （人）：</label></td>
					<td class="width-17 active"><label class="pull-right">康复治疗师（人）：</label></td>
					<td class="width-17 active"><label class="pull-right">其他卫生技术人员（人）：</label></td>
					<td class="width-17 active"></td>
				
				</tr>
				<tr>
					
					<td class="width-15">
						<input path="date" name="2015" id="date" htmlEscape="false"  value="2015"  readOnly="true"   class="form-control "/>
					</td>
					<td class="width-17">
						<input path="jyys" name="2015" id="jyys" value="${data.jyys }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-17">
						<input path="yxys" name="2015" id="yxys" value="${data.yxys }"  htmlEscape="false"    class="form-control "/>
					</td>
				
					<td class="width-17">
						<input path="kfzls" name="2015" id="kfzls" value="${data.kfzls }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-17">
						<input path="qtwsjsry" name="2015" id="qtwsjsry" value="${data.qtwsjsry }"  htmlEscape="false"    class="form-control "/>
					</td>
				
		   			<td class="width-17" ></td>
				</tr>
				
				<tr>
					
					<td class="width-15">
						<input path="date" name="2016" id="date1" htmlEscape="false"  value="2016"  readOnly="true"   class="form-control "/>
					</td>
					<td class="width-17">
						<input path="jyys" name="2016" id="jyys1" value="${data.jyys1 }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-17">
						<input path="yxys" name="2016" id="yxys1" value="${data.yxys1 }"  htmlEscape="false"    class="form-control "/>
					</td>
				
					<td class="width-17">
						<input path="kfzls" name="2016" id="kfzls1" value="${data.kfzls1 }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-17">
						<input path="qtwsjsry" name="2016" id="qtwsjsry1" value="${data.qtwsjsry1 }"  htmlEscape="false"    class="form-control "/>
					</td>
				
		   			<td class="width-17" ></td>
				</tr>
				<tr>
					
					<td class="width-15">
						<input path="date" name="2017" id="date2"   htmlEscape="false"  value="2017"   readOnly="true"  class="form-control "/>
					</td>
					<td class="width-17">
						<input path="jyys" name="2017" id="jyys2" value="${data.jyys2 }"    htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-17">
						<input path="yxys" name="2017" id="yxys2" value="${data.yxys2 }"    htmlEscape="false"    class="form-control "/>
					</td>
				
					<td class="width-17">
						<input path="kfzls" name="2017" id="kfzls2" value="${data.kfzls2 }"    htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-17">
						<input path="qtwsjsry" name="2017" id="qtwsjsry2" value="${data.qtwsjsry2 }"    htmlEscape="false"    class="form-control "/>
					</td>
				
		   			<td class="width-17" ></td>
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
			      url:"${ctx}/ironfowsjsrygc/ironfowsjsrygc/save",
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