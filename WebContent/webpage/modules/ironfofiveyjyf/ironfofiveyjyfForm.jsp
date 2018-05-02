<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>5.3医技用房管理</title>
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
		<form:form id="inputForm" modelAttribute="ironfofiveyjyf" action="${ctx}/ironfofiveyjyf/ironfofiveyjyf/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>	
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
					<td class="width-15 active"><label class="pull-right">备注信息：</label></td>
					<td class="width-35">
						<form:textarea path="remarks" htmlEscape="false" rows="4"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">主表id：</label></td>
					<td class="width-35">
						<form:input path="doc_id" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">功能单元建筑面积：</label></td>
					<td class="width-35">
						<form:input path="gndyjzmj" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">门诊西药房-药剂科用房：</label></td>
					<td class="width-35">
						<form:radiobuttons path="mzxyfyjkyf" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">门诊中药房-药剂科用房：</label></td>
					<td class="width-35">
						<form:radiobuttons path="mzzyfyjkyf" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
					<td class="width-15 active"><label class="pull-right">急诊药房-药剂科用房：</label></td>
					<td class="width-35">
						<form:radiobuttons path="jzyfyjkyf" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">特殊药房-药剂科用房：</label></td>
					<td class="width-35">
						<form:radiobuttons path="tsyfyjkyf" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
					<td class="width-15 active"><label class="pull-right">煎药房-药剂科用房：</label></td>
					<td class="width-35">
						<form:radiobuttons path="jyfyjkyf" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">药品库-药剂科用房：</label></td>
					<td class="width-35">
						<form:radiobuttons path="ypkyjkyf" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
					<td class="width-15 active"><label class="pull-right">采血室-检验科用房：</label></td>
					<td class="width-35">
						<form:radiobuttons path="cxsjykyf" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">化验室-检验科用房：</label></td>
					<td class="width-35">
						<form:radiobuttons path="hysjykyf" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
					<td class="width-15 active"><label class="pull-right">X光机摄片室-放射科用房：</label></td>
					<td class="width-35">
						<form:radiobuttons path="xgjspsfskyf" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">X光机控制室-放射科用房：</label></td>
					<td class="width-35">
						<form:radiobuttons path="xgjkzsfskyf" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
					<td class="width-15 active"><label class="pull-right">CT摄片室-放射科用房：</label></td>
					<td class="width-35">
						<form:radiobuttons path="ctspsfskyf" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">CT控制室-放射科用房：</label></td>
					<td class="width-35">
						<form:radiobuttons path="ctkzsfskyf" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
					<td class="width-15 active"><label class="pull-right">读片室-放射科用房：</label></td>
					<td class="width-35">
						<form:radiobuttons path="dpsfskyf" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">心电图室：</label></td>
					<td class="width-35">
						<form:radiobuttons path="xdts" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
					<td class="width-15 active"><label class="pull-right">超声室：</label></td>
					<td class="width-35">
						<form:radiobuttons path="css" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">血库-输血科用房：</label></td>
					<td class="width-35">
						<form:radiobuttons path="xksxkyf" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
					<td class="width-15 active"><label class="pull-right">配血室-输血科用房：</label></td>
					<td class="width-35">
						<form:radiobuttons path="pxssxkyf" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">去污区-消毒供应室：</label></td>
					<td class="width-35">
						<form:radiobuttons path="qwqxdgys" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
					<td class="width-15 active"><label class="pull-right">检查包装及灭菌区-消毒供应室：</label></td>
					<td class="width-35">
						<form:radiobuttons path="jcbzjmjqxdgys" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">无菌物品存放区-消毒供应室：</label></td>
					<td class="width-35">
						<form:radiobuttons path="wjwpcfqxdgys" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
					<td class="width-15 active"><label class="pull-right">手术室-手术部：</label></td>
					<td class="width-35">
						<form:radiobuttons path="sssssb" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">产房-手术部：</label></td>
					<td class="width-35">
						<form:radiobuttons path="cfssb" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
					<td class="width-15 active"><label class="pull-right">准备室-手术部：</label></td>
					<td class="width-35">
						<form:radiobuttons path="zbsssb" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">待产室-手术部：</label></td>
					<td class="width-35">
						<form:radiobuttons path="dcsssb" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
					<td class="width-15 active"><label class="pull-right">更衣间-手术部：</label></td>
					<td class="width-35">
						<form:radiobuttons path="gysssb" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">洗手间-手术部：</label></td>
					<td class="width-35">
						<form:radiobuttons path="xsjssb" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
					<td class="width-15 active"><label class="pull-right">术后苏醒室-手术部：</label></td>
					<td class="width-35">
						<form:radiobuttons path="shsxsssb" items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false" class="i-checks "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">其它（请注明）：</label></td>
					<td class="width-35">
						<form:input path="qtqzm" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"></td>
		   			<td class="width-35" ></td>
		  		</tr>
		 	</tbody>
		</table>
	</form:form>
</body>
</html>