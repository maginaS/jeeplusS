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
		<form:form id="inputForm" modelAttribute="ironfopublichealth" action="${ctx}/ironfopublichealth/ironfopublichealth/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>	
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
					
					<td class="width-15 active"><label class="pull-right">日期：</label></td>
					<td class="width-35">
						<form:select path="date" class="form-control ">
							<form:option value="2015" label="2015"/>
							<form:option value="2016" label="2016"/>
							<form:option value="2017" label="2017"/>
							<%-- <form:options items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false"/> --%>
						</form:select>
					</td>
					
					<td class="width-15 active"><label class="pull-right">年末服务(常住)人口数（人）：</label></td>
					<td class="width-35">
						<form:input path="nmfwczrks" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">其中0-6岁儿童数（人）：</label></td>
					<td class="width-35">
						<form:input path="qzldlsets" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">其中0-3岁儿童数（人）：</label></td>
					<td class="width-35">
						<form:input path="qzldssets" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">其中65岁以上人口数（人）：</label></td>
					<td class="width-35">
						<form:input path="qzlswsysrks" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">年末居民健康档案累计建档人数（人）：</label></td>
					<td class="width-35">
						<form:input path="nmjmjkdaljjdrs" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">其中规范化电子建档人数（人）：</label></td>
					<td class="width-35">
						<form:input path="qzgfhdzdars" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">年内接受健康教育人次数（人次）：</label></td>
					<td class="width-35">
						<form:input path="nnjsjkjyrcs" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">年内0-6岁儿童预防接种人次数（人次）：</label></td>
					<td class="width-35">
						<form:input path="nnldlsetyfjzrcs" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">年末0-6岁儿童健康管理人数（人次）：</label></td>
					<td class="width-35">
						<form:input path="nmldlsetjkglrs" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">年末孕产妇健康管理人数（人）：</label></td>
					<td class="width-35">
						<form:input path="nmycfjkglrs" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">年末65岁以上老人健康管理人（人）：</label></td>
					<td class="width-35">
						<form:input path="nmlswsyslrjkglr" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">年末高血压规范管理人数（人）：</label></td>
					<td class="width-35">
						<form:input path="nmgxygfglrs" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">年末糖尿病规范管理人数（人）：</label></td>
					<td class="width-35">
						<form:input path="nmtnbgfglrs" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">年末重性精神障碍患者管理人数（人）：</label></td>
					<td class="width-35">
						<form:input path="nmzxjszahzglrs" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">年末肺结核患者管理人数（人）：</label></td>
					<td class="width-35">
						<form:input path="nmfjhhzglrs" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">年内传染病和突发公共卫生事件报告例数（例）：</label></td>
					<td class="width-35">
						<form:input path="nncrbhtfggwssjbgls" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">年内卫生监督协管信息报告例数（例）：</label></td>
					<td class="width-35">
						<form:input path="nnwsjdxgxxbgls" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">年末0-3岁儿童中医药健康管理人数（人）：</label></td>
					<td class="width-35">
						<form:input path="nmldssetzyyjkglrs" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">年末65岁以上老人中医药健康管理人数（人）：</label></td>
					<td class="width-35">
						<form:input path="nmlswyslrzyyjkglrs" htmlEscape="false"    class="form-control "/>
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