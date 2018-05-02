<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>2.1年度医疗服务量管理</title>
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

		<form id="inputForm_test"  action="${ctx}/ironfomedicalservices/ironfoMedicalServices/save" method="post" class="form-horizontal">
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
		   <tr>
		 	  <br/>
				 注：<br/>
				 表中各项数据：数据应来源于《全国卫生资源与医疗服务调查制度》卫计统1-2表。<br/>
		   </tr>
				<tr>
					<td class="width-13 active"><label class="pull-right">年份 </label></td>
					<td class="width-13 active"><label class="pull-right">编制床位（张）</label></td>
					<td class="width-13 active"><label class="pull-right">实有床位（张）</label></td>
					<td class="width-13 active"><label class="pull-right">实际开放总床日数（日）</label></td>
					<td class="width-13 active"><label class="pull-right">实际占用总床日数（日）</label></td>
					<td class="width-13 active"><label class="pull-right">观察床数（床）</label></td>
					<td class="width-13 active"><label class="pull-right">总诊疗人次数（人次）</label></td>
					
				</tr>
				<tr>
					<td class="width-13">
						<input path="date" htmlEscape="false" id="date" name="2015" value="2015"  readOnly="true"   class="form-control "/>
					</td>
					<td class="width-13">
						<input path="bzcw" htmlEscape="false" id="bzcw" name="2015"  value="${data.bzcw}"   class="form-control "/>
					</td>
					<td class="width-13">
						<input path="sycw" htmlEscape="false" id="sycw" name="2015"  value="${data.sycw}"   class="form-control "/>
					</td>
				
					<td class="width-13">
						<input path="sjkfzcrs" htmlEscape="false" id="sjkfzcrs" name="2015" value="${data.sjkfzcrs}"    class="form-control "/>
					</td>
					<td class="width-13">
						<input path="sjzyzcrs" htmlEscape="false" id="sjzyzcrs"  name="2015" value="${data.sjzyzcrs}"  class="form-control "/>
					</td>
					<td class="width-13">
						<input path="gccs" htmlEscape="false" id="gccs" name="2015" value="${data.gccs}"  class="form-control "/>
					</td>
					<td class="width-13">
						<input path="zzlrcs" htmlEscape="false" id="zzlrcs"  name="2015" value="${data.zzlrcs}"  class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="id"  name="2015" value="${data.id}"  class="form-control "/>
						<input type = "hidden" htmlEscape="false"  name ="2015" id ="docId" value="${data.doc_id} "  class="form-control "/>
					<!-- type = "hidden" -->
					</td>
					
					
					
				</tr>
				<tr>
					<td class="width-13">
						<input path="date1" htmlEscape="false"  name="2016" id="date1" value="2016"  readOnly="true"  class="form-control "/>
					</td>
					<td class="width-13">
						<input path="bzcw1" htmlEscape="false"  name="2016"  id="bzcw1" value="${data.bzcw1}"  class="form-control "/>
					</td>
					<td class="width-13">
						<input path="sycw1" htmlEscape="false" name="2016"  id="sycw1"  value="${data.sycw1}" class="form-control "/>
					</td>
				
					<td class="width-13">
						<input path="sjkfzcrs1" htmlEscape="false" name="2016" id="sjkfzcrs1"  value="${data.sjkfzcrs1}"  class="form-control "/>
					</td>
					<td class="width-13">
						<input path="sjzyzcrs1" htmlEscape="false"  name="2016" id="sjzyzcrs1"  value="${data.sjzyzcrs1}"  class="form-control "/>
					</td>
					<td class="width-13">
						<input path="gccs1" htmlEscape="false"   name="2016" id="gccs1" value="${data.gccs1}"  class="form-control "/>
					</td>
					<td class="width-13">
						<input path="zzlrcs1" htmlEscape="false"  name="2016"  id="zzlrcs1" value="${data.zzlrcs1}"  class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="id1"  name="2016" value="${data.id1}"  class="form-control "/>
					</td>
					
					
				</tr>
				<tr>
					<td class="width-13">
						<input path="date2" htmlEscape="false"  name="2017" id="date2" value="2017"  readOnly="true"  class="form-control "/>
					</td>
					<td class="width-13">
						<input path="bzcw2" htmlEscape="false" name="2017" id="bzcw2"  value="${data.bzcw2}"  class="form-control "/>
					</td>
					<td class="width-13">
						<input path="sycw2" htmlEscape="false" name="2017" id="sycw2"   value="${data.sycw2}"  class="form-control "/>
					</td>
				
					<td class="width-13">
						<input path="sjkfzcrs2" htmlEscape="false" name="2017"  id="sjkfzcrs2"  value="${data.sjkfzcrs2}"  class="form-control "/>
					</td>
					<td class="width-13">
						<input path="sjzyzcrs2" htmlEscape="false"  name="2017"  id="sjzyzcrs2" value="${data.sjzyzcrs2}" class="form-control "/>
					</td>
					<td class="width-13">
						<input path="gccs2" htmlEscape="false"  name="2017" id="gccs2"  value="${data.gccs2}" class="form-control "/>
					</td>
					<td class="width-13">
						<input path="zzlrcs2" htmlEscape="false"  name="2017"  id="zzlrcs2" value="${data.zzlrcs2}"  class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="id2"  name="2017" value="${data.id2}"  class="form-control "/>
					</td>
					
					
				</tr>
				<tr>
					
					<td class="width-13 active"><label class="pull-right">年份：</label></td>
					<td class="width-13 active"><label class="pull-right">门诊人次数（人次）：</label></td>
					<td class="width-13 active"><label class="pull-right">急诊人次数（人次）：</label></td>
					<td class="width-13 active"><label class="pull-right">其中死亡人数（人）：</label></td>
					<td class="width-13 active"><label class="pull-right">出院人数（人）：</label></td>
					<td class="width-13 active"><label class="pull-right">上级医院向下转诊人次数（人次）：</label></td>
					<td class="width-13 active"><label class="pull-right">向上级医院转诊人次数（人次）：</label></td>
				</tr>
				<tr>

					<td class="width-13">
						<input path="date" htmlEscape="false"  name="2015" id="date"    value="2015"  readOnly="true"   class="form-control "/>
					</td>
					<td class="width-13">
						<input path="mzrcs" htmlEscape="false"   name="2015" id="mzrcs" value="${data.mzrcs}"   class="form-control "/>
					</td>
					<td class="width-13">
						<input path="jzrcs" htmlEscape="false"   name="2015" id="jzrcs" value="${data.jzrcs}"    class="form-control "/>
					</td>
					
					<td class="width-13">
						<input path="qzswrs" htmlEscape="false"   name="2015"  id="qzswrs"  value="${data.qzswrs}" class="form-control "/>
					</td>
					<td class="width-13">
						<input path="cyrs" htmlEscape="false"   name="2015" id="cyrs" value="${data.cyrs}"  class="form-control "/>
					</td>
					
					<td class="width-13">
						<input path="sjyyxxzzrcs" htmlEscape="false"   name="2015" id="sjyyxxzzrcs" value="${data.sjyyxxzzrcs}"   class="form-control "/>
					</td>
					<td class="width-13">
						<input path="xsjyyzzrcs" htmlEscape="false"   name="2015" id="xsjyyzzrcs" value="${data.xsjyyzzrcs}"   class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-13">
						<input path="date1" htmlEscape="false" name="2016" id="date1"  value="2016"  readOnly="true"  class="form-control "/>
					</td>
					<td class="width-13">
						<input path="mzrcs1" htmlEscape="false" name="2016" id="mzrcs1"  value="${data.mzrcs1}"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jzrcs1" htmlEscape="false"  name="2016"  id="jzrcs1" value="${data.jzrcs1}"   class="form-control "/>
					</td>
					
					<td class="width-13">
						<input path="qzswrs1" htmlEscape="false"  name="2016"  id="qzswrs1" value="${data.qzswrs1}"  class="form-control "/>
					</td>
					<td class="width-13">
						<input path="cyrs1" htmlEscape="false"  name="2016" id="cyrs1"  value="${data.cyrs1}"   class="form-control "/>
					</td>
					
					<td class="width-13">
						<input path="sjyyxxzzrcs1" htmlEscape="false"  name="2016" id="sjyyxxzzrcs1" value="${data.sjyyxxzzrcs1}"    class="form-control "/>
					</td>
					<td class="width-13">
						<input path="xsjyyzzrcs1" htmlEscape="false"  name="2016" id="xsjyyzzrcs1" value="${data.xsjyyzzrcs1}"   class="form-control "/>
					</td>
					
					
				</tr>
				<tr>
				
					<td class="width-13">
						<input path="date2" htmlEscape="false"  name="2017" id="date2"  readOnly="true"   value="2017"  class="form-control "/>
					</td>
					<td class="width-13">
						<input path="mzrcs2" htmlEscape="false"  name="2017" id="mzrcs2"  value="${data.mzrcs2}"   class="form-control "/>
					</td>
					<td class="width-13">
						<input path="jzrcs2" htmlEscape="false"   name="2017" id="jzrcs2" value="${data.jzrcs2}"   class="form-control "/>
					</td>
					
					<td class="width-13">
						<input path="qzswrs2" htmlEscape="false"  name="2017" id="qzswrs2"  value="${data.qzswrs2}"   class="form-control "/>
					</td>
					<td class="width-13">
						<input path="cyrs2" htmlEscape="false"  name="2017"  id="cyrs2" value="${data.cyrs2}"  class="form-control "/>
					</td>
					
					<td class="width-13">
						<input path="sjyyxxzzrcs2" htmlEscape="false" name="2017" id="sjyyxxzzrcs2" value="${data.sjyyxxzzrcs2}"    class="form-control "/>
					</td>
					<td class="width-13">
						<input path="xsjyyzzrcs2" htmlEscape="false"  name="2017" id="xsjyyzzrcs2" value="${data.xsjyyzzrcs2}"   class="form-control "/>
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
			      url:"${ctx}/ironfomedicalservices/ironfoMedicalServices/save",
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

 