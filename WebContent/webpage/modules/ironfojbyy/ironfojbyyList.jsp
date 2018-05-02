<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>2.6基本用药管理</title>
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
		<form id="inputForm" modelAttribute="ironfojbyy" action="${ctx}/ironfojbyy/ironfojbyy/save" method="post" class="form-horizontal">
	<%-- 	<form:hidden path="id"/>
		<sys:message content="${message}"/>	 --%>
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				
				<tr>
					<td class="width-35 active"><label class="pull-right">基本用药品种数（种）</label></td>
					<td class="width-65">
						<input path="jbyypzs" htmlEscape="false"  name="jbyypzs" id="jbyypzs" value="${data.jbyypzs }"  class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="id"  name="jbyypzs" value="${data.id}"  class="form-control "/>
						<input type = "hidden" htmlEscape="false"  name ="jbyypzs" id ="docId" value="${data.doc_id} "  class="form-control "/>
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
		var data_2015 = document.getElementsByName("jbyypzs");
	
		var datas="";
		
		
		for(i=0;i<data_2015.length;i++){
			if(data_2015[i].value==null||data_2015[i].value==""){
				datas = datas +data_2015[i].id+": ---- ;";	
			}else{
				datas = datas +data_2015[i].id+":"+data_2015[i].value+";";	
			}
			
			
		}
	 /* 	for(i=0;i<data_2016.length;i++){
	 		if(data_2016[i].value==null||data_2016[i].value==""){
	 			datas = datas+data_2016[i].id+": ---- ;";
	 		}else{
	 			datas = datas+data_2016[i].id+":"+data_2016[i].value+";";
	 		}
	 		
		} */
		/* for(i=0;i <data_2017.length;i++){
			if(data_2017[i].value==null||data_2017[i].value==""){
				datas = datas+data_2017[i].id+": ---- ;";
			}else{
				datas = datas+data_2017[i].id+":"+data_2017[i].value+";";
			}
			
		} */
		 $.ajax({
		      url:"${ctx}/ironfojbyy/ironfojbyy/save",
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