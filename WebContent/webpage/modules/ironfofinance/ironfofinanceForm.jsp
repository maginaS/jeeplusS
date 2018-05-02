<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>2.2财务收支管理</title>
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
		<form:form id="inputForm" modelAttribute="ironfofinance" action="${ctx}/ironfofinance/ironfofinance/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>	
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
		   
		   <tr>
		   
		  	 注：<br/>
			表中各项数据：数据应来源于《全国卫生资源与医疗服务调查制度》卫计统1-2表。<br/>
		   	</tr>
				<tr>
				
					<td class="width-15 active"><label class="pull-right">时间：</label></td>
					<td class="width-35">
						<form:input path="date" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">医疗收入 （千元）：</label></td>
					<td class="width-35">
						<form:input path="ylsr" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">药品收入 （千元）：</label></td>
					<td class="width-35">
						<form:input path="ypsr" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">财政补助收入 （千元）：</label></td>
					<td class="width-35">
						<form:input path="sfbtsr" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">上级补助收入 （千元）：</label></td>
					<td class="width-35">
						<form:input path="sjbzsr" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">其它收入 （千元）：</label></td>
					<td class="width-35">
						<form:input path="qtsr" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">总支出 （千元）：</label></td>
					<td class="width-35">
						<form:input path="zzc" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">医疗支出 （千元）：</label></td>
					<td class="width-35">
						<form:input path="ylzc" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					
					<%-- <td class="width-15 active"><label class="pull-right">主表id：</label></td>
					<td class="width-35">
						<form:input path="doc_id" htmlEscape="false"    class="form-control "/>
					</td> --%>
				</tr>
		 	</tbody>
		</table>
	</form:form>
</body>
</html>