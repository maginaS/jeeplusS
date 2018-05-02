<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>2.3基本公共卫生服务管理</title>
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
	</script>
</head>
<body class="hideScroll">
		<form id="inputForm_ifonfopublichealth" modelAttribute="ironfopublichealth" action="${ctx}/ironfopublichealth/ironfopublichealth/save" method="post" class="form-horizontal">
		<%-- <form:hidden path="id"/>
		<sys:message content="${message}"/>	 --%>
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
		   		<tr>
			
					注：<br/>
					表中各项数据：数据应来源于《全国卫生资源与医疗服务调查制度》卫计统1-2表。<br/>
					
				</tr>
		   
				<tr>
					<%-- <td class="width-15 active"><label class="pull-right">备注信息：</label></td>
					<td class="width-35">
						<form:textarea path="remarks" htmlEscape="false" rows="4"    class="form-control "/>
					</td> --%>
					
					<td class="width-10 active"><label class="pull-right">年份</label></td>
					
					<td class="width-10 active"><label class="pull-right">年末服务(常住)人口数（人）</label></td>
					<td class="width-10 active"><label class="pull-right">其中0-6岁儿童数（人）</label></td>
					<td class="width-10 active"><label class="pull-right">其中0-3岁儿童数（人）</label></td>
					<td class="width-10 active"><label class="pull-right">其中65岁以上人口数（人）</label></td>
					<td class="width-10 active"><label class="pull-right">年末居民健康档案累计建档人数（人）</label></td>
					<td class="width-10 active"><label class="pull-right">其中规范化电子建档人数（人）</label></td>
					<td class="width-10 active"><label class="pull-right">年内接受健康教育人次数（人次）</label></td>
				</tr>
				<tr>
					<td class="width-10">
						<input path="date" htmlEscape="false"  value="2015" readOnly="true" name = "2015" id="date"  class="form-control "/>
					</td>
					<td class="width-10">
						<input path="nmfwczrks" htmlEscape="false" name ="2015" id="nmfwczrks"  value="${data.nmfwczrks }" class="form-control "/>
					</td>
				
					<td class="width-10">
						<input path="qzldlsets" htmlEscape="false"   name ="2015" id="qzldlsets"   value="${data.qzldlsets }"  class="form-control "/>
					</td>
					
					<td class="width-10">
						<input path="qzldssets" htmlEscape="false"   name ="2015" id="qzldssets"  value="${data.qzldssets }"  class="form-control "/>
					</td>
					<td class="width-10">
						<input path="qzlswsysrks" htmlEscape="false"  name ="2015" id="qzlswsysrks"   value="${data.qzlswsysrks }"  class="form-control "/>
					</td>
					
					<td class="width-10">
						<input path="nmjmjkdaljjdrs" htmlEscape="false"   name ="2015" id="nmjmjkdaljjdrs"  value="${data.nmjmjkdaljjdrs }"  class="form-control "/>
					</td>
						<td class="width-10">
						<input path="qzgfhdzdars" htmlEscape="false"   name ="2015" id="qzgfhdzdars"  value="${data.qzgfhdzdars }"  class="form-control "/>
					</td>
					
					<td class="width-10">
						<input path="nnjsjkjyrcs" htmlEscape="false"   name ="2015" id="nnjsjkjyrcs"  value="${data.nnjsjkjyrcs }"  class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-10">
						<input path="date" htmlEscape="false"  value="2016" readOnly="true" name="2016" id="date1"    class="form-control "/>
					</td>
					<td class="width-10">
						<input path="nmfwczrks" htmlEscape="false" value="${data.nmfwczrks1 }"  name="2016" id="nmfwczrks1"   class="form-control "/>
					</td>
				
					<td class="width-10">
						<input path="qzldlsets" htmlEscape="false"  value="${data.qzldlsets1 }"  name="2016" id="qzldlsets1"  class="form-control "/>
					</td>
					
					<td class="width-10">
						<input path="qzldssets" htmlEscape="false"  value="${data.qzldssets1 }"  name="2016" id="qzldssets1"  class="form-control "/>
					</td>
					<td class="width-10">
						<input path="qzlswsysrks" htmlEscape="false" value="${data.qzlswsysrks1 }"   name="2016" id="qzlswsysrks1"  class="form-control "/>
					</td>
					
					<td class="width-10">
						<input path="nmjmjkdaljjdrs" htmlEscape="false"  value="${data.nmjmjkdaljjdrs1 }"  name="2016" id="nmjmjkdaljjdrs1"  class="form-control "/>
					</td>
						<td class="width-10">
						<input path="qzgfhdzdars" htmlEscape="false" value="${data.qzgfhdzdars1 }"   name="2016" id="qzgfhdzdars1"  class="form-control "/>
					</td>
					
					<td class="width-10">
						<input path="nnjsjkjyrcs" htmlEscape="false"  value="${data.nnjsjkjyrcs1 }"  name="2016" id="nnjsjkjyrcs1"   class="form-control "/>
					</td>
				
					
					
				</tr>
				<tr>
					<td class="width-10">
						<input path="date" htmlEscape="false"  value="2017" readOnly="true" name="2017" id="date2" class="form-control "/>
					</td>
					<td class="width-10">
						<input path="nmfwczrks" htmlEscape="false" name="2017" id="nmfwczrks2"  value="${data.nmfwczrks2 }"     class="form-control "/>
					</td>
				
					<td class="width-10">
						<input path="qzldlsets" htmlEscape="false"  name="2017" id="qzldlsets2"  value="${data.qzldlsets2 }"    class="form-control "/>
					</td>
					
					<td class="width-10">
						<input path="qzldssets" htmlEscape="false"   name="2017" id="qzldssets2" value="${data.qzldssets2 }"   class="form-control "/>
					</td>
					<td class="width-10">
						<input path="qzlswsysrks" htmlEscape="false"  name="2017" id="qzlswsysrks2"  value="${data.qzlswsysrks2 }"   class="form-control "/>
					</td>
					
					<td class="width-10">
						<input path="nmjmjkdaljjdrs" htmlEscape="false"  name="2017" id="nmjmjkdaljjdrs2" value="${data.nmjmjkdaljjdrs2 }"   class="form-control "/>
					</td>
					<td class="width-10">
						<input path="qzgfhdzdars" htmlEscape="false"  name="2017" id="qzgfhdzdars2" value="${data.qzgfhdzdars2 }"   class="form-control "/>
					</td>
					
					<td class="width-10">
						<input path="nnjsjkjyrcs" htmlEscape="false"  name="2017" id="nnjsjkjyrcs2" value="${data.nnjsjkjyrcs2 }"    class="form-control "/>
					</td>
					
				
				</tr>
				<tr>
					<td class="width-10 active"><label class="pull-right">年份：</label></td>
					<td class="width-10 active"><label class="pull-right">年内0-6岁儿童预防接种人次数（人次）：</label></td>
					<td class="width-10 active"><label class="pull-right">年末0-6岁儿童健康管理人数（人次）：</label></td>
					<td class="width-10 active"><label class="pull-right">年末孕产妇健康管理人数（人）：</label></td>
					<td class="width-10 active"><label class="pull-right">年末65岁以上老人健康管理人（人）：</label></td>
					<td class="width-10 active"><label class="pull-right">年末高血压规范管理人数（人）：</label></td>
					<td class="width-10 active"><label class="pull-right">年末糖尿病规范管理人数（人）：</label></td>
					<td class="width-10 active"><label class="pull-right">年末重性精神障碍患者管理人数（人）：</label></td>
				</tr>
				<tr>
					<td class="width-10">
						<input path="date" htmlEscape="false"  value="2015" readOnly="true" name="2015" id = "date"  class="form-control "/>
					</td>
					<td class="width-10">
						<input path="nnldlsetyfjzrcs" htmlEscape="false" name="2015" id = "nnldlsetyfjzrcs" value="${data.nnldlsetyfjzrcs }"   class="form-control "/>
					</td>
					<td class="width-10">
						<input path="nmldlsetjkglrs" htmlEscape="false"  name="2015" id = "nmldlsetjkglrs"  value="${data.nmldlsetjkglrs }"  class="form-control "/>
					</td>
					
					<td class="width-10">
						<input path="nmycfjkglrs" htmlEscape="false" name="2015" id = "nmycfjkglrs"  value="${data.nmycfjkglrs }"   class="form-control "/>
					</td>
					
					<td class="width-10">
						<input path="nmlswsyslrjkglr" htmlEscape="false" name="2015" id = "nmlswsyslrjkglr"  value="${data.nmlswsyslrjkglr }"   class="form-control "/>
					</td>
					<td class="width-10">
						<input path="nmgxygfglrs" htmlEscape="false"  name="2015" id = "nmgxygfglrs" value="${data.nmgxygfglrs }"   class="form-control "/>
					</td>
					
					<td class="width-10">
						<input path="nmtnbgfglrs" htmlEscape="false"  name="2015" id = "nmtnbgfglrs"  value="${data.nmtnbgfglrs }"  class="form-control "/>
					</td>
					<td class="width-10">
						<input path="nmzxjszahzglrs" htmlEscape="false"  name="2015" id = "nmzxjszahzglrs" value="${data.nmzxjszahzglrs }"  class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-10">
						<input path="date" htmlEscape="false"  value="2016" readOnly="true" name="2016" id="date1"  class="form-control "/>
					</td>
					<td class="width-10">
						<input path="nnldlsetyfjzrcs" htmlEscape="false" name="2016" id="nnldlsetyfjzrcs1"   value="${data.nnldlsetyfjzrcs1 }"  class="form-control "/>
					</td>
					<td class="width-10">
						<input path="nmldlsetjkglrs" htmlEscape="false"  name="2016" id="nmldlsetjkglrs1"  value="${data.nmldlsetjkglrs1 }"  class="form-control "/>
					</td>
					
					<td class="width-10">
						<input path="nmycfjkglrs" htmlEscape="false" name="2016" id="nmycfjkglrs1" value="${data.nmycfjkglrs1 }"   class="form-control "/>
					</td>
					
					<td class="width-10">
						<input path="nmlswsyslrjkglr" htmlEscape="false" name="2016" id="nmlswsyslrjkglr1"  value="${data.nmlswsyslrjkglr1 }"  class="form-control "/>
					</td>
					<td class="width-10">
						<input path="nmgxygfglrs" htmlEscape="false"  name="2016" id="nmgxygfglrs1"  value="${data.nmgxygfglrs1 }" class="form-control "/>
					</td>
					
					<td class="width-10">
						<input path="nmtnbgfglrs" htmlEscape="false"  name="2016" id="nmtnbgfglrs1"  value="${data.nmtnbgfglrs1 }" class="form-control "/>
					</td>
					<td class="width-10">
						<input path="nmzxjszahzglrs" htmlEscape="false"  name="2016" id="nmzxjszahzglrs1" value="${data.nmzxjszahzglrs1 }"  class="form-control "/>
					</td>
				
					
				</tr>
				<tr>
				
					<td class="width-10">
						<input path="date" htmlEscape="false"  value="2017" readOnly="true" name="2017" id="date2" class="form-control "/>
					</td>
					<td class="width-10">
						<input path="nnldlsetyfjzrcs" htmlEscape="false" name="2017" id="nnldlsetyfjzrcs2"   value="${data.nnldlsetyfjzrcs2 }"  class="form-control "/>
					</td>
					<td class="width-10">
						<input path="nmldlsetjkglrs" htmlEscape="false"  name="2017" id="nmldlsetjkglrs2"   value="${data.nmldlsetjkglrs2 }" class="form-control "/>
					</td>
					
					<td class="width-10">
						<input path="nmycfjkglrs" htmlEscape="false"  name="2017" id="nmycfjkglrs2"  value="${data.nmycfjkglrs2 }" class="form-control "/>
					</td>
					
					<td class="width-10">
						<input path="nmlswsyslrjkglr" htmlEscape="false" name="2017" id="nmlswsyslrjkglr2"   value="${data.nmlswsyslrjkglr2 }" class="form-control "/>
					</td>
					<td class="width-10">
						<input path="nmgxygfglrs" htmlEscape="false"  name="2017" id="nmgxygfglrs2"  value="${data.nmgxygfglrs2 }" class="form-control "/>
					</td>
					
					<td class="width-10">
						<input path="nmtnbgfglrs" htmlEscape="false"  name="2017" id="nmtnbgfglrs2"  value="${data.nmtnbgfglrs2 }" class="form-control "/>
					</td>
					<td class="width-10">
						<input path="nmzxjszahzglrs" htmlEscape="false"  name="2017" id="nmzxjszahzglrs2"  value="${data.nmzxjszahzglrs2 }" class="form-control "/>
					</td>
				
				
				
				</tr>
				<tr>
					
					
					<td class="width-10 active"><label class="pull-right">年份：</label></td>
					<td class="width-10 active"><label class="pull-right">年末肺结核患者管理人数（人）：</label></td>
					
					<td class="width-10 active"><label class="pull-right">年内传染病和突发公共卫生事件报告例数（例）：</label></td>
					<td class="width-10 active"><label class="pull-right">年内卫生监督协管信息报告例数（例）：</label></td>
					<td class="width-10 active"><label class="pull-right">年末0-3岁儿童中医药健康管理人数（人）：</label></td>
					<td class="width-10 active"><label class="pull-right">年末65岁以上老人中医药健康管理人数（人）：</label></td>
				</tr>
				<tr>
					<td class="width-10">
						<input path="date" htmlEscape="false"  value="2015"  readOnly="true"  name="2015" id="date" class="form-control "/>
					</td>
					<td class="width-10">
						<input path="nmfjhhzglrs" htmlEscape="false"   name="2015" id="nmfjhhzglrs"  value="${data.nmfjhhzglrs }"    class="form-control "/>
					</td>
				
					<td class="width-10">
						<input path="nncrbhtfggwssjbgls" htmlEscape="false"    name="2015" id="nncrbhtfggwssjbgls"  value="${data.nncrbhtfggwssjbgls }"    class="form-control "/>
					</td>
					
					<td class="width-10">
						<input path="nnwsjdxgxxbgls" htmlEscape="false"   name="2015" id="nnwsjdxgxxbgls"  value="${data.nnwsjdxgxxbgls }"    class="form-control "/>
					</td>
						<td class="width-10">
						<input path="nmldssetzyyjkglrs" htmlEscape="false"   name="2015" id="nmldssetzyyjkglrs" value="${data.nmldssetzyyjkglrs }"   class="form-control "/>
					</td>
					
					<td class="width-10">
						<input path="nmlswyslrzyyjkglrs" htmlEscape="false"  name="2015" id="nmlswyslrzyyjkglrs" value="${data.nmlswyslrzyyjkglrs }"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="id"  name="2015" value="${data.id}"  class="form-control "/>
						<input type = "hidden" htmlEscape="false"  name ="2015" id ="docId" value="${data.doc_id} "  class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-10">
						<input path="date" htmlEscape="false"  value="2016"  readOnly="true"  name="2016" id="date1" class="form-control "/>
					</td>
					<td class="width-10">
						<input path="nmfjhhzglrs" htmlEscape="false" name="2016" id="nmfjhhzglrs1"  value="${data.nmfjhhzglrs1 }"    class="form-control "/>
					</td>
				
					<td class="width-10">
						<input path="nncrbhtfggwssjbgls" htmlEscape="false" name="2016" id="nncrbhtfggwssjbgls1"  value="${data.nncrbhtfggwssjbgls1 }"     class="form-control "/>
					</td>
					
					<td class="width-10">
						<input path="nnwsjdxgxxbgls" htmlEscape="false"  name="2016" id="nnwsjdxgxxbgls1"  value="${data.nnwsjdxgxxbgls1 }"   class="form-control "/>
					</td>
						<td class="width-10">
						<input path="nmldssetzyyjkglrs" htmlEscape="false" name="2016" id="nmldssetzyyjkglrs1"  value="${data.nmldssetzyyjkglrs1 }"     class="form-control "/>
					</td>
					
					<td class="width-10">
						<input path="nmlswyslrzyyjkglrs" htmlEscape="false"  name="2016" id="nmlswyslrzyyjkglrs1"  value="${data.nmlswyslrzyyjkglrs1 }"   class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="id1"  name="2016" value="${data.id1}"  class="form-control "/>
					
					</td>
					
				
				</tr>
				<tr>
					<td class="width-10">
						<input path="date" htmlEscape="false"  value="2017"  readOnly="true"  name="2017" id="date2"  class="form-control "/>
					</td>
					<td class="width-10">
						<input path="nmfjhhzglrs" htmlEscape="false" name="2017" id="nmfjhhzglrs2"   value="${data.nmfjhhzglrs2 }"    class="form-control "/>
					</td>
				
					<td class="width-10">
						<input path="nncrbhtfggwssjbgls" htmlEscape="false" name="2017" id="nncrbhtfggwssjbgls2"   value="${data.nncrbhtfggwssjbgls2 }"    class="form-control "/>
					</td>
					
					<td class="width-10">
						<input path="nnwsjdxgxxbgls" htmlEscape="false"  name="2017" id="nnwsjdxgxxbgls2"   value="${data.nnwsjdxgxxbgls2 }"   class="form-control "/>
					</td>
						<td class="width-10">
						<input path="nmldssetzyyjkglrs" htmlEscape="false"  name="2017" id="nmldssetzyyjkglrs2"   value="${data.nmldssetzyyjkglrs2 }"   class="form-control "/>
					</td>
					
					<td class="width-10">
						<input type = "hidden" htmlEscape="false" id="id2"  name="2017" value="${data.id2}"  class="form-control "/>
						<input path="nmlswyslrzyyjkglrs" htmlEscape="false"  name="2017" id="nmlswyslrzyyjkglrs2"    value="${data.nmlswyslrzyyjkglrs2 }"  class="form-control "/>
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
		      url:"${ctx}/ironfopublichealth/ironfopublichealth/save",
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