<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>5.2房间配置管理</title>
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
		function addRow(list, idx, tpl, row){
			$(list).append(Mustache.render(tpl, {
				idx: idx, delBtn: true, row: row
			}));
			$(list+idx).find("select").each(function(){
				$(this).val($(this).attr("data-value"));
			});
			$(list+idx).find("input[type='checkbox'], input[type='radio']").each(function(){
				var ss = $(this).attr("data-value").split(',');
				for (var i=0; i<ss.length; i++){
					if($(this).val() == ss[i]){
						$(this).attr("checked","checked");
					}
				}
			});
		}
		
		
		function findfjpz(){
			
			 var url = location.search;
			 var remark = url.split("&")[1].split("=")[1];
			 if(){
				 
			 }
			 
			
			/* alert("111"); */
		}
		function delRow(obj, prefix){
			var id = $(prefix+"_id");
			var delFlag = $(prefix+"_delFlag");
			if (id.val() == ""){
				$(obj).parent().parent().remove();
			}else if(delFlag.val() == "0"){
				delFlag.val("1");
				$(obj).html("&divide;").attr("title", "撤销删除");
				$(obj).parent().parent().addClass("error");
			}else if(delFlag.val() == "1"){
				delFlag.val("0");
				$(obj).html("&times;").attr("title", "删除");
				$(obj).parent().parent().removeClass("error");
			}
		}
	</script>
</head>
<body class="hideScroll">
	<form:form id="inputForm" modelAttribute="ironfofivefjpz" action="${ctx}/ironfofivefjpz/ironfofivefjpz/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>	
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<%-- <tr>
					<td class="width-15 active"><label class="pull-right">备注信息：</label></td>
					<td class="width-35">
						<form:textarea path="remarks" htmlEscape="false" rows="4"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">主表id：</label></td>
					<td class="width-35">
						<form:input path="doc_id" htmlEscape="false"    class="form-control "/>
					</td>
				</tr> --%>
				<tr>
					<td class="width-15 active"><label class="pull-right">功能单元：</label></td>
					<td class="width-35">
						<form:input path="fjpz_gndy" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">功能单元建筑面积（m2）：</label></td>
					<td class="width-35">
						<form:input path="fjpz_gndyjzmj" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<%-- <tr>
					<td class="width-15 active"><label class="pull-right">添加：</label></td>
					<td class="width-35">
						<form:input path="fjpz_remark" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"></td>
		   			<td class="width-35" ></td>
		  		</tr> --%>
		 	</tbody>
		</table>
		
		<div class="tabs-container">
            <ul class="nav nav-tabs">
				<li class="active"><a data-toggle="tab" href="#tab-1" aria-expanded="true" onclick="findfjpz();">5.2房间配置_空间类型附表：</a>
                </li>
            </ul>
            <div class="tab-content">
			<div id="tab-1" class="tab-pane active">
 			<table id="contentTable" class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<th class="hide"></th>
						<!-- <th>备注信息</th>
						<th>配置表id</th> -->
						<th>空间类型</th>
						<th width="10">&nbsp;</th>
					</tr>
				</thead>
				<tbody id="ironfofivefjlxList">
					
				</tbody>
			</table>
		<!-- 	<script type="text/template" id="ironfofivefjlxTpl"> -->//<!--
				<tr id="ironfofivefjlxList{{idx}}">
					<td class="hide">
						<input id="ironfofivefjlxList{{idx}}_id" name="ironfofivefjlxList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
						<input id="ironfofivefjlxList{{idx}}_delFlag" name="ironfofivefjlxList[{{idx}}].delFlag" type="hidden" value="0"/>
					</td>
					
					<td>
						<textarea id="ironfofivefjlxList{{idx}}_remarks" name="ironfofivefjlxList[{{idx}}].remarks" rows="4"    class="form-control ">{{row.remarks}}</textarea>
					</td>
					
					
					<td>
						<input id="ironfofivefjlxList{{idx}}_fjpz_id" name="ironfofivefjlxList[{{idx}}].fjpz_id" type="text" value="{{row.fjpz_id}}"    class="form-control "/>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfofivefjlxList{{idx}}_kjlx${dictStatus.index}" name="ironfofivefjlxList[{{idx}}].kjlx" type="checkbox" class="i-checks" value="${dict.value}" data-value="{{row.kjlx}}"><label for="ironfofivefjlxList{{idx}}_kjlx${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					<td class="text-center" width="10">
						{{#delBtn}}<span class="close" onclick="delRow(this, '#ironfofivefjlxList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
					</td>
				</tr>//-->
		<!-- 	</script> -->
		<!-- 	<script type="text/javascript">
				var ironfofivefjlxRowIdx = 0, ironfofivefjlxTpl = $("#ironfofivefjlxTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
				$(document).ready(function() {
					var data = ${fns:toJson(ironfofivefjpz.ironfofivefjlxList)};
					for (var i=0; i<data.length; i++){
						addRow('#ironfofivefjlxList', ironfofivefjlxRowIdx, ironfofivefjlxTpl, data[i]);
						ironfofivefjlxRowIdx = ironfofivefjlxRowIdx + 1;
					}
				});
			</script> -->
			</div>
		</div>
		</div>
	</form:form>
</body>
</html>