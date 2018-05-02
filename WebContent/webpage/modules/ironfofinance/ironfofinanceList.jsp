<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>2.2财务收支管理</title>
	<meta name="decorator" content="default"/>
</head>
<body class="hideScroll">
		<form id="inputForm_finance" modelAttribute="ironfofinance" action="${ctx}/ironfofinance/ironfofinance/save" method="post" class="form-horizontal">
<%-- 		<form:hidden path="id"/> --%>
	<%-- 	<sys:message content="${message}"/>	 --%>
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
		   
		   <tr>
		   
		  	 注：<br/>
			表中各项数据：数据应来源于《全国卫生资源与医疗服务调查制度》卫计统1-2表。<br/>
		   	</tr>
		   	
		   	<tr>
		 	 	
		    </tr> 
				<tr>
				
					<td class="width-12 active"><label class="pull-right">年份</label></td>
					<td class="width-12 active"><label class="pull-right">医疗收入 （千元）</label></td>
					<td class="width-12 active"><label class="pull-right">药品收入 （千元）</label></td>
					<td class="width-12 active"><label class="pull-right">财政补助收入 （千元）</label></td>
					<td class="width-12 active"><label class="pull-right">上级补助收入 （千元）</label></td>
					<td class="width-12 active"><label class="pull-right">其它收入 （千元）</label></td>
					<td class="width-12 active"><label class="pull-right">总支出 （千元）</label></td>
					<td class="width-12 active"><label class="pull-right">医疗支出 （千元）</label></td>
					
				</tr>
				<tr>
					<td class="width-12">
						<input path="date" id="date" readOnly="true"  htmlEscape="false"  value="2015"  name="2015" class="form-control "/>
					</td>
					<td class="width-12">
						<input path="ylsr" id="ylsr" htmlEscape="false"   name="2015" value="${data.ylsr }" class="form-control "/>
					</td>
					
					<td class="width-12">
						<input path="ypsr" id="ypsr" htmlEscape="false"  name="2015" value="${data.ypsr }"   class="form-control "/>
					</td>
					
					<td class="width-12">
						<input path="sfbtsr" id="sfbtsr" htmlEscape="false"  name="2015" value="${data.sfbtsr }"    class="form-control "/>
					</td>
					<td class="width-12">
						<input path="sjbzsr" id="sjbzsr" htmlEscape="false"  name="2015" value="${data.sjbzsr }"    class="form-control "/>
					</td>
					
					<td class="width-12">
						<input path="qtsr" id="qtsr" htmlEscape="false"  name="2015"  value="${data.qtsr }"   class="form-control "/>
					</td>
					<td class="width-12">
						<input path="zzc" id="zzc" htmlEscape="false"  name="2015"  value="${data.zzc }"   class="form-control "/>
					</td>
					
					<td class="width-12">
						<input path="ylzc" id="ylzc" htmlEscape="false"   name="2015"  value="${data.ylzc }"   class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="id"  name="2015" value="${data.id}"  class="form-control "/>
						<input type = "hidden" htmlEscape="false"  name ="2015" id ="docId" value="${data.doc_id} "  class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-12">
						<input path="date"  id="date1" readOnly="true"  htmlEscape="false"  value="2016"   name="2016"  class="form-control "/>
					</td>
					<td class="width-12">
						<input path="ylsr"  id="ylsr1" htmlEscape="false"  name="2016"  value="${data.ylsr1 }"   class="form-control "/>
					</td>
					
					<td class="width-12">
						<input path="ypsr"  id="ypsr1" htmlEscape="false"   name="2016" value="${data.ypsr1 }"   class="form-control "/>
					</td>
					
					<td class="width-12">
						<input path="sfbtsr"  id="sfbtsr1" htmlEscape="false"  name="2016" value="${data.sfbtsr1 }"    class="form-control "/>
					</td>
					<td class="width-12">
						<input path="sjbzsr"  id="sjbzsr1" htmlEscape="false"  name="2016" value="${data.sjbzsr1 }"    class="form-control "/>
					</td>
					
					<td class="width-12"> 
						<input path="qtsr"  id="qtsr1" htmlEscape="false"  name="2016" value="${data.qtsr1 }"   class="form-control "/>
					</td>
					<td class="width-12">
						<input path="zzc"  id="zzc1" htmlEscape="false"   name="2016"  value="${data.zzc1 }"  class="form-control "/>
					</td>
					
					<td class="width-12">
						<input path="ylzc"  id="ylzc1" htmlEscape="false"  name="2016"  value="${data.ylzc1 }"   class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="id1"  name="2016" value="${data.id1}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
					<td class="width-12">
						<input path="date" id="date2" readOnly="true"  htmlEscape="false"  value="2017"  name ="2017"  class="form-control "/>
					</td>
					<td class="width-12">
						<input path="ylsr" id="ylsr2" htmlEscape="false" name ="2017" id    value="${data.ylsr2 }"   class="form-control "/>
					</td>
					
					<td class="width-12">
						<input path="ypsr" id="ypsr2" htmlEscape="false"  name ="2017"   value="${data.ypsr2 }"   class="form-control "/>
					</td>
					
					<td class="width-12">
						<input path="sfbtsr" id="sfbtsr2" htmlEscape="false"  name ="2017"   value="${data.sfbtsr2 }"   class="form-control "/>
					</td>
					<td class="width-12">
						<input path="sjbzsr" id="sjbzsr2" htmlEscape="false"   name ="2017"   value="${data.sjbzsr2 }"  class="form-control "/>
					</td>
					
					<td class="width-12">
						<input path="qtsr" id="qtsr2" htmlEscape="false"  name ="2017"   value="${data.qtsr2 }"  class="form-control "/>
					</td>
					<td class="width-12">
						<input path="zzc" id="zzc2" htmlEscape="false"   name ="2017"  value="${data.zzc2 }"  class="form-control "/>
					</td>
					
					<td class="width-12">
						<input path="ylzc" id="ylzc2" htmlEscape="false"  name ="2017"   value="${data.ylzc2 }"  class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="id2"  name="2017" value="${data.id2}"  class="form-control "/>
					
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
		      url:"${ctx}/ironfofinance/ironfofinance/save",
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