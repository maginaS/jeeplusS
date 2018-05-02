<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>2.4科室设置管理</title>
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
	<form:form id="inputForm" modelAttribute="ironfodepartment" action="${ctx}/ironfo_departmentreport/ironfodepartment/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>	
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
					<td class="width-15 active"><label class="pull-right">备注信息：</label></td>
					<td class="width-35">
						<form:textarea path="remarks" htmlEscape="false" rows="4"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">职能单元：</label></td>
					<td class="width-35">
						<form:input path="zndy" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">主表id：</label></td>
					<td class="width-35">
						<form:input path="doc_id" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"></td>
		   			<td class="width-35" ></td>
		  		</tr>
		 	</tbody>
		</table>
		
		<div class="tabs-container">
            <ul class="nav nav-tabs">
				<li class="active"><a data-toggle="tab" href="#tab-1" aria-expanded="true">公共卫生部：</a>
                </li>
				<li class=""><a data-toggle="tab" href="#tab-2" aria-expanded="false">计划生育部：</a>
                </li>
				<li class=""><a data-toggle="tab" href="#tab-3" aria-expanded="false">设置科室附表：</a>
                </li>
				<li class=""><a data-toggle="tab" href="#tab-4" aria-expanded="false">医技部：</a>
                </li>
				<li class=""><a data-toggle="tab" href="#tab-5" aria-expanded="false">职能管理部：</a>
                </li>
				<li class=""><a data-toggle="tab" href="#tab-6" aria-expanded="false">住院部：</a>
                </li>
            </ul>
            <div class="tab-content">
				<div id="tab-1" class="tab-pane active">
			<a class="btn btn-white btn-sm" onclick="addRow('#ironfodepartmentggwsbList', ironfodepartmentggwsbRowIdx, ironfodepartmentggwsbTpl);ironfodepartmentggwsbRowIdx = ironfodepartmentggwsbRowIdx + 1;" title="新增"><i class="fa fa-plus"></i> 新增</a>
			<table id="contentTable" class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<th class="hide"></th>
						<th>备注信息</th>
						<th>预防保健科</th>
						<th>妇女保健科</th>
						<th>儿童保健科</th>
						<th>体检中心</th>
						<th>添加</th>
						<th>主表id</th>
						<th width="10">&nbsp;</th>
					</tr>
				</thead>
				<tbody id="ironfodepartmentggwsbList">
				</tbody>
			</table>
			<script type="text/template" id="ironfodepartmentggwsbTpl">//<!--
				<tr id="ironfodepartmentggwsbList{{idx}}">
					<td class="hide">
						<input id="ironfodepartmentggwsbList{{idx}}_id" name="ironfodepartmentggwsbList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
						<input id="ironfodepartmentggwsbList{{idx}}_delFlag" name="ironfodepartmentggwsbList[{{idx}}].delFlag" type="hidden" value="0"/>
					</td>
					
					<td>
						<textarea id="ironfodepartmentggwsbList{{idx}}_remarks" name="ironfodepartmentggwsbList[{{idx}}].remarks" rows="4"    class="form-control ">{{row.remarks}}</textarea>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfodepartmentggwsbList{{idx}}_yfbjk${dictStatus.index}" name="ironfodepartmentggwsbList[{{idx}}].yfbjk" type="radio" class="i-checks" value="${dict.value}" data-value="{{row.yfbjk}}"><label for="ironfodepartmentggwsbList{{idx}}_yfbjk${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfodepartmentggwsbList{{idx}}_fnbjk${dictStatus.index}" name="ironfodepartmentggwsbList[{{idx}}].fnbjk" type="radio" class="i-checks" value="${dict.value}" data-value="{{row.fnbjk}}"><label for="ironfodepartmentggwsbList{{idx}}_fnbjk${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfodepartmentggwsbList{{idx}}_etbjk${dictStatus.index}" name="ironfodepartmentggwsbList[{{idx}}].etbjk" type="radio" class="i-checks" value="${dict.value}" data-value="{{row.etbjk}}"><label for="ironfodepartmentggwsbList{{idx}}_etbjk${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfodepartmentggwsbList{{idx}}_tjzx${dictStatus.index}" name="ironfodepartmentggwsbList[{{idx}}].tjzx" type="radio" class="i-checks" value="${dict.value}" data-value="{{row.tjzx}}"><label for="ironfodepartmentggwsbList{{idx}}_tjzx${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<input id="ironfodepartmentggwsbList{{idx}}_tj_remark" name="ironfodepartmentggwsbList[{{idx}}].tj_remark" type="text" value="{{row.tj_remark}}"    class="form-control "/>
					</td>
					
					
					<td>
						<input id="ironfodepartmentggwsbList{{idx}}_dep_id" name="ironfodepartmentggwsbList[{{idx}}].dep_id" type="text" value="{{row.dep_id}}"    class="form-control "/>
					</td>
					
					<td class="text-center" width="10">
						{{#delBtn}}<span class="close" onclick="delRow(this, '#ironfodepartmentggwsbList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
					</td>
				</tr>//-->
			</script>
			<script type="text/javascript">
				var ironfodepartmentggwsbRowIdx = 0, ironfodepartmentggwsbTpl = $("#ironfodepartmentggwsbTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
				$(document).ready(function() {
					var data = ${fns:toJson(ironfodepartment.ironfodepartmentggwsbList)};
					for (var i=0; i<data.length; i++){
						addRow('#ironfodepartmentggwsbList', ironfodepartmentggwsbRowIdx, ironfodepartmentggwsbTpl, data[i]);
						ironfodepartmentggwsbRowIdx = ironfodepartmentggwsbRowIdx + 1;
					}
				});
			</script>
			</div>
				<div id="tab-2" class="tab-pane">
			<a class="btn btn-white btn-sm" onclick="addRow('#ironfodepartmentjhsybList', ironfodepartmentjhsybRowIdx, ironfodepartmentjhsybTpl);ironfodepartmentjhsybRowIdx = ironfodepartmentjhsybRowIdx + 1;" title="新增"><i class="fa fa-plus"></i> 新增</a>
			<table id="contentTable" class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<th class="hide"></th>
						<th>备注信息</th>
						<th>计划生育科</th>
						<th>添加</th>
						<th>主表id</th>
						<th width="10">&nbsp;</th>
					</tr>
				</thead>
				<tbody id="ironfodepartmentjhsybList">
				</tbody>
			</table>
			<script type="text/template" id="ironfodepartmentjhsybTpl">//<!--
				<tr id="ironfodepartmentjhsybList{{idx}}">
					<td class="hide">
						<input id="ironfodepartmentjhsybList{{idx}}_id" name="ironfodepartmentjhsybList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
						<input id="ironfodepartmentjhsybList{{idx}}_delFlag" name="ironfodepartmentjhsybList[{{idx}}].delFlag" type="hidden" value="0"/>
					</td>
					
					<td>
						<textarea id="ironfodepartmentjhsybList{{idx}}_remarks" name="ironfodepartmentjhsybList[{{idx}}].remarks" rows="4"    class="form-control ">{{row.remarks}}</textarea>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfodepartmentjhsybList{{idx}}_jhsyk${dictStatus.index}" name="ironfodepartmentjhsybList[{{idx}}].jhsyk" type="checkbox" class="i-checks" value="${dict.value}" data-value="{{row.jhsyk}}"><label for="ironfodepartmentjhsybList{{idx}}_jhsyk${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<input id="ironfodepartmentjhsybList{{idx}}_tj_remark" name="ironfodepartmentjhsybList[{{idx}}].tj_remark" type="text" value="{{row.tj_remark}}"    class="form-control "/>
					</td>
					
					
					<td>
						<input id="ironfodepartmentjhsybList{{idx}}_dep_id" name="ironfodepartmentjhsybList[{{idx}}].dep_id" type="text" value="{{row.dep_id}}"    class="form-control "/>
					</td>
					
					<td class="text-center" width="10">
						{{#delBtn}}<span class="close" onclick="delRow(this, '#ironfodepartmentjhsybList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
					</td>
				</tr>//-->
			</script>
			<script type="text/javascript">
				var ironfodepartmentjhsybRowIdx = 0, ironfodepartmentjhsybTpl = $("#ironfodepartmentjhsybTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
				$(document).ready(function() {
					var data = ${fns:toJson(ironfodepartment.ironfodepartmentjhsybList)};
					for (var i=0; i<data.length; i++){
						addRow('#ironfodepartmentjhsybList', ironfodepartmentjhsybRowIdx, ironfodepartmentjhsybTpl, data[i]);
						ironfodepartmentjhsybRowIdx = ironfodepartmentjhsybRowIdx + 1;
					}
				});
			</script>
			</div>
				<div id="tab-3" class="tab-pane">
			<a class="btn btn-white btn-sm" onclick="addRow('#ironfodepartmentremarkList', ironfodepartmentremarkRowIdx, ironfodepartmentremarkTpl);ironfodepartmentremarkRowIdx = ironfodepartmentremarkRowIdx + 1;" title="新增"><i class="fa fa-plus"></i> 新增</a>
			<table id="contentTable" class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<th class="hide"></th>
						<th>备注信息</th>
						<th>主表id</th>
						<th>急诊室</th>
						<th>内科</th>
						<th>儿科</th>
						<th>外科</th>
						<th>妇产科</th>
						<th>全科医学科</th>
						<th>中医科</th>
						<th>眼科</th>
						<th>耳鼻喉科</th>
						<th>口腔科</th>
						<th>康复科</th>
						<th>皮肤科</th>
						<th>感染性疾病科</th>
						<th>精神科</th>
						<th>增加科室</th>
						<th width="10">&nbsp;</th>
					</tr>
				</thead>
				<tbody id="ironfodepartmentremarkList">
				</tbody>
			</table>
			<script type="text/template" id="ironfodepartmentremarkTpl">//<!--
				<tr id="ironfodepartmentremarkList{{idx}}">
					<td class="hide">
						<input id="ironfodepartmentremarkList{{idx}}_id" name="ironfodepartmentremarkList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
						<input id="ironfodepartmentremarkList{{idx}}_delFlag" name="ironfodepartmentremarkList[{{idx}}].delFlag" type="hidden" value="0"/>
					</td>
					
					<td>
						<textarea id="ironfodepartmentremarkList{{idx}}_remarks" name="ironfodepartmentremarkList[{{idx}}].remarks" rows="4"    class="form-control ">{{row.remarks}}</textarea>
					</td>
					
					
					<td>
						<input id="ironfodepartmentremarkList{{idx}}_dep_id" name="ironfodepartmentremarkList[{{idx}}].dep_id" type="text" value="{{row.dep_id}}"    class="form-control "/>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfodepartmentremarkList{{idx}}_jzs${dictStatus.index}" name="ironfodepartmentremarkList[{{idx}}].jzs" type="checkbox" class="i-checks" value="${dict.value}" data-value="{{row.jzs}}"><label for="ironfodepartmentremarkList{{idx}}_jzs${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfodepartmentremarkList{{idx}}_nk${dictStatus.index}" name="ironfodepartmentremarkList[{{idx}}].nk" type="checkbox" class="i-checks" value="${dict.value}" data-value="{{row.nk}}"><label for="ironfodepartmentremarkList{{idx}}_nk${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfodepartmentremarkList{{idx}}_ek${dictStatus.index}" name="ironfodepartmentremarkList[{{idx}}].ek" type="checkbox" class="i-checks" value="${dict.value}" data-value="{{row.ek}}"><label for="ironfodepartmentremarkList{{idx}}_ek${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfodepartmentremarkList{{idx}}_wk${dictStatus.index}" name="ironfodepartmentremarkList[{{idx}}].wk" type="checkbox" class="i-checks" value="${dict.value}" data-value="{{row.wk}}"><label for="ironfodepartmentremarkList{{idx}}_wk${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfodepartmentremarkList{{idx}}_fck${dictStatus.index}" name="ironfodepartmentremarkList[{{idx}}].fck" type="checkbox" class="i-checks" value="${dict.value}" data-value="{{row.fck}}"><label for="ironfodepartmentremarkList{{idx}}_fck${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfodepartmentremarkList{{idx}}_qkyxk${dictStatus.index}" name="ironfodepartmentremarkList[{{idx}}].qkyxk" type="checkbox" class="i-checks" value="${dict.value}" data-value="{{row.qkyxk}}"><label for="ironfodepartmentremarkList{{idx}}_qkyxk${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfodepartmentremarkList{{idx}}_zyk${dictStatus.index}" name="ironfodepartmentremarkList[{{idx}}].zyk" type="checkbox" class="i-checks" value="${dict.value}" data-value="{{row.zyk}}"><label for="ironfodepartmentremarkList{{idx}}_zyk${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfodepartmentremarkList{{idx}}_yk${dictStatus.index}" name="ironfodepartmentremarkList[{{idx}}].yk" type="checkbox" class="i-checks" value="${dict.value}" data-value="{{row.yk}}"><label for="ironfodepartmentremarkList{{idx}}_yk${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfodepartmentremarkList{{idx}}_ebhk${dictStatus.index}" name="ironfodepartmentremarkList[{{idx}}].ebhk" type="checkbox" class="i-checks" value="${dict.value}" data-value="{{row.ebhk}}"><label for="ironfodepartmentremarkList{{idx}}_ebhk${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfodepartmentremarkList{{idx}}_kqk${dictStatus.index}" name="ironfodepartmentremarkList[{{idx}}].kqk" type="checkbox" class="i-checks" value="${dict.value}" data-value="{{row.kqk}}"><label for="ironfodepartmentremarkList{{idx}}_kqk${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfodepartmentremarkList{{idx}}_kfk${dictStatus.index}" name="ironfodepartmentremarkList[{{idx}}].kfk" type="checkbox" class="i-checks" value="${dict.value}" data-value="{{row.kfk}}"><label for="ironfodepartmentremarkList{{idx}}_kfk${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfodepartmentremarkList{{idx}}_pfk${dictStatus.index}" name="ironfodepartmentremarkList[{{idx}}].pfk" type="checkbox" class="i-checks" value="${dict.value}" data-value="{{row.pfk}}"><label for="ironfodepartmentremarkList{{idx}}_pfk${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfodepartmentremarkList{{idx}}_grxjbk${dictStatus.index}" name="ironfodepartmentremarkList[{{idx}}].grxjbk" type="checkbox" class="i-checks" value="${dict.value}" data-value="{{row.grxjbk}}"><label for="ironfodepartmentremarkList{{idx}}_grxjbk${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfodepartmentremarkList{{idx}}_jsk${dictStatus.index}" name="ironfodepartmentremarkList[{{idx}}].jsk" type="checkbox" class="i-checks" value="${dict.value}" data-value="{{row.jsk}}"><label for="ironfodepartmentremarkList{{idx}}_jsk${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfodepartmentremarkList{{idx}}_zjremark${dictStatus.index}" name="ironfodepartmentremarkList[{{idx}}].zjremark" type="checkbox" class="i-checks" value="${dict.value}" data-value="{{row.zjremark}}"><label for="ironfodepartmentremarkList{{idx}}_zjremark${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					<td class="text-center" width="10">
						{{#delBtn}}<span class="close" onclick="delRow(this, '#ironfodepartmentremarkList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
					</td>
				</tr>//-->
			</script>
			<script type="text/javascript">
				var ironfodepartmentremarkRowIdx = 0, ironfodepartmentremarkTpl = $("#ironfodepartmentremarkTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
				$(document).ready(function() {
					var data = ${fns:toJson(ironfodepartment.ironfodepartmentremarkList)};
					for (var i=0; i<data.length; i++){
						addRow('#ironfodepartmentremarkList', ironfodepartmentremarkRowIdx, ironfodepartmentremarkTpl, data[i]);
						ironfodepartmentremarkRowIdx = ironfodepartmentremarkRowIdx + 1;
					}
				});
			</script>
			</div>
				<div id="tab-4" class="tab-pane">
			<a class="btn btn-white btn-sm" onclick="addRow('#ironfodepartmentyjbList', ironfodepartmentyjbRowIdx, ironfodepartmentyjbTpl);ironfodepartmentyjbRowIdx = ironfodepartmentyjbRowIdx + 1;" title="新增"><i class="fa fa-plus"></i> 新增</a>
			<table id="contentTable" class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<th class="hide"></th>
						<th>备注信息</th>
						<th>主表id</th>
						<th>药剂科</th>
						<th>检验科</th>
						<th>放射科</th>
						<th>超声科</th>
						<th>心电图科</th>
						<th>消毒供应室</th>
						<th>手术室</th>
						<th>添加科室</th>
						<th width="10">&nbsp;</th>
					</tr>
				</thead>
				<tbody id="ironfodepartmentyjbList">
				</tbody>
			</table>
			<script type="text/template" id="ironfodepartmentyjbTpl">//<!--
				<tr id="ironfodepartmentyjbList{{idx}}">
					<td class="hide">
						<input id="ironfodepartmentyjbList{{idx}}_id" name="ironfodepartmentyjbList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
						<input id="ironfodepartmentyjbList{{idx}}_delFlag" name="ironfodepartmentyjbList[{{idx}}].delFlag" type="hidden" value="0"/>
					</td>
					
					<td>
						<textarea id="ironfodepartmentyjbList{{idx}}_remarks" name="ironfodepartmentyjbList[{{idx}}].remarks" rows="4"    class="form-control ">{{row.remarks}}</textarea>
					</td>
					
					
					<td>
						<input id="ironfodepartmentyjbList{{idx}}_dep_id" name="ironfodepartmentyjbList[{{idx}}].dep_id" type="text" value="{{row.dep_id}}"    class="form-control "/>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfodepartmentyjbList{{idx}}_yjk${dictStatus.index}" name="ironfodepartmentyjbList[{{idx}}].yjk" type="checkbox" class="i-checks" value="${dict.value}" data-value="{{row.yjk}}"><label for="ironfodepartmentyjbList{{idx}}_yjk${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfodepartmentyjbList{{idx}}_jyk${dictStatus.index}" name="ironfodepartmentyjbList[{{idx}}].jyk" type="checkbox" class="i-checks" value="${dict.value}" data-value="{{row.jyk}}"><label for="ironfodepartmentyjbList{{idx}}_jyk${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfodepartmentyjbList{{idx}}_fsk${dictStatus.index}" name="ironfodepartmentyjbList[{{idx}}].fsk" type="checkbox" class="i-checks" value="${dict.value}" data-value="{{row.fsk}}"><label for="ironfodepartmentyjbList{{idx}}_fsk${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfodepartmentyjbList{{idx}}_csk${dictStatus.index}" name="ironfodepartmentyjbList[{{idx}}].csk" type="checkbox" class="i-checks" value="${dict.value}" data-value="{{row.csk}}"><label for="ironfodepartmentyjbList{{idx}}_csk${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfodepartmentyjbList{{idx}}_xdtk${dictStatus.index}" name="ironfodepartmentyjbList[{{idx}}].xdtk" type="checkbox" class="i-checks" value="${dict.value}" data-value="{{row.xdtk}}"><label for="ironfodepartmentyjbList{{idx}}_xdtk${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfodepartmentyjbList{{idx}}_xdgys${dictStatus.index}" name="ironfodepartmentyjbList[{{idx}}].xdgys" type="checkbox" class="i-checks" value="${dict.value}" data-value="{{row.xdgys}}"><label for="ironfodepartmentyjbList{{idx}}_xdgys${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfodepartmentyjbList{{idx}}_sss${dictStatus.index}" name="ironfodepartmentyjbList[{{idx}}].sss" type="checkbox" class="i-checks" value="${dict.value}" data-value="{{row.sss}}"><label for="ironfodepartmentyjbList{{idx}}_sss${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfodepartmentyjbList{{idx}}_tjremark${dictStatus.index}" name="ironfodepartmentyjbList[{{idx}}].tjremark" type="checkbox" class="i-checks" value="${dict.value}" data-value="{{row.tjremark}}"><label for="ironfodepartmentyjbList{{idx}}_tjremark${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					<td class="text-center" width="10">
						{{#delBtn}}<span class="close" onclick="delRow(this, '#ironfodepartmentyjbList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
					</td>
				</tr>//-->
			</script>
			<script type="text/javascript">
				var ironfodepartmentyjbRowIdx = 0, ironfodepartmentyjbTpl = $("#ironfodepartmentyjbTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
				$(document).ready(function() {
					var data = ${fns:toJson(ironfodepartment.ironfodepartmentyjbList)};
					for (var i=0; i<data.length; i++){
						addRow('#ironfodepartmentyjbList', ironfodepartmentyjbRowIdx, ironfodepartmentyjbTpl, data[i]);
						ironfodepartmentyjbRowIdx = ironfodepartmentyjbRowIdx + 1;
					}
				});
			</script>
			</div>
				<div id="tab-5" class="tab-pane">
			<a class="btn btn-white btn-sm" onclick="addRow('#ironfodepartmentznglbList', ironfodepartmentznglbRowIdx, ironfodepartmentznglbTpl);ironfodepartmentznglbRowIdx = ironfodepartmentznglbRowIdx + 1;" title="新增"><i class="fa fa-plus"></i> 新增</a>
			<table id="contentTable" class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<th class="hide"></th>
						<th>备注信息</th>
						<th>院长办公室</th>
						<th>党建办公室</th>
						<th>医务科</th>
						<th>护理科</th>
						<th>财务科</th>
						<th>档案管理科</th>
						<th>信息中心</th>
						<th>院感科</th>
						<th>医保结算科</th>
						<th>后勤管理科</th>
						<th>添加</th>
						<th>主表id</th>
						<th width="10">&nbsp;</th>
					</tr>
				</thead>
				<tbody id="ironfodepartmentznglbList">
				</tbody>
			</table>
			<script type="text/template" id="ironfodepartmentznglbTpl">//<!--
				<tr id="ironfodepartmentznglbList{{idx}}">
					<td class="hide">
						<input id="ironfodepartmentznglbList{{idx}}_id" name="ironfodepartmentznglbList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
						<input id="ironfodepartmentznglbList{{idx}}_delFlag" name="ironfodepartmentznglbList[{{idx}}].delFlag" type="hidden" value="0"/>
					</td>
					
					<td>
						<textarea id="ironfodepartmentznglbList{{idx}}_remarks" name="ironfodepartmentznglbList[{{idx}}].remarks" rows="4"    class="form-control ">{{row.remarks}}</textarea>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfodepartmentznglbList{{idx}}_yzbgs${dictStatus.index}" name="ironfodepartmentznglbList[{{idx}}].yzbgs" type="checkbox" class="i-checks" value="${dict.value}" data-value="{{row.yzbgs}}"><label for="ironfodepartmentznglbList{{idx}}_yzbgs${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfodepartmentznglbList{{idx}}_djbgs${dictStatus.index}" name="ironfodepartmentznglbList[{{idx}}].djbgs" type="checkbox" class="i-checks" value="${dict.value}" data-value="{{row.djbgs}}"><label for="ironfodepartmentznglbList{{idx}}_djbgs${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfodepartmentznglbList{{idx}}_ywk${dictStatus.index}" name="ironfodepartmentznglbList[{{idx}}].ywk" type="checkbox" class="i-checks" value="${dict.value}" data-value="{{row.ywk}}"><label for="ironfodepartmentznglbList{{idx}}_ywk${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfodepartmentznglbList{{idx}}_hlk${dictStatus.index}" name="ironfodepartmentznglbList[{{idx}}].hlk" type="checkbox" class="i-checks" value="${dict.value}" data-value="{{row.hlk}}"><label for="ironfodepartmentznglbList{{idx}}_hlk${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfodepartmentznglbList{{idx}}_cwk${dictStatus.index}" name="ironfodepartmentznglbList[{{idx}}].cwk" type="checkbox" class="i-checks" value="${dict.value}" data-value="{{row.cwk}}"><label for="ironfodepartmentznglbList{{idx}}_cwk${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfodepartmentznglbList{{idx}}_daglk${dictStatus.index}" name="ironfodepartmentznglbList[{{idx}}].daglk" type="checkbox" class="i-checks" value="${dict.value}" data-value="{{row.daglk}}"><label for="ironfodepartmentznglbList{{idx}}_daglk${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfodepartmentznglbList{{idx}}_xxzx${dictStatus.index}" name="ironfodepartmentznglbList[{{idx}}].xxzx" type="checkbox" class="i-checks" value="${dict.value}" data-value="{{row.xxzx}}"><label for="ironfodepartmentznglbList{{idx}}_xxzx${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfodepartmentznglbList{{idx}}_ygk${dictStatus.index}" name="ironfodepartmentznglbList[{{idx}}].ygk" type="checkbox" class="i-checks" value="${dict.value}" data-value="{{row.ygk}}"><label for="ironfodepartmentznglbList{{idx}}_ygk${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfodepartmentznglbList{{idx}}_ybjsk${dictStatus.index}" name="ironfodepartmentznglbList[{{idx}}].ybjsk" type="checkbox" class="i-checks" value="${dict.value}" data-value="{{row.ybjsk}}"><label for="ironfodepartmentznglbList{{idx}}_ybjsk${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfodepartmentznglbList{{idx}}_hqglk${dictStatus.index}" name="ironfodepartmentznglbList[{{idx}}].hqglk" type="checkbox" class="i-checks" value="${dict.value}" data-value="{{row.hqglk}}"><label for="ironfodepartmentznglbList{{idx}}_hqglk${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfodepartmentznglbList{{idx}}_tj_remarks${dictStatus.index}" name="ironfodepartmentznglbList[{{idx}}].tj_remarks" type="checkbox" class="i-checks" value="${dict.value}" data-value="{{row.tj_remarks}}"><label for="ironfodepartmentznglbList{{idx}}_tj_remarks${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfodepartmentznglbList{{idx}}_dep_id${dictStatus.index}" name="ironfodepartmentznglbList[{{idx}}].dep_id" type="checkbox" class="i-checks" value="${dict.value}" data-value="{{row.dep_id}}"><label for="ironfodepartmentznglbList{{idx}}_dep_id${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					<td class="text-center" width="10">
						{{#delBtn}}<span class="close" onclick="delRow(this, '#ironfodepartmentznglbList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
					</td>
				</tr>//-->
			</script>
			<script type="text/javascript">
				var ironfodepartmentznglbRowIdx = 0, ironfodepartmentznglbTpl = $("#ironfodepartmentznglbTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
				$(document).ready(function() {
					var data = ${fns:toJson(ironfodepartment.ironfodepartmentznglbList)};
					for (var i=0; i<data.length; i++){
						addRow('#ironfodepartmentznglbList', ironfodepartmentznglbRowIdx, ironfodepartmentznglbTpl, data[i]);
						ironfodepartmentznglbRowIdx = ironfodepartmentznglbRowIdx + 1;
					}
				});
			</script>
			</div>
				<div id="tab-6" class="tab-pane">
			<a class="btn btn-white btn-sm" onclick="addRow('#ironfodepartmentzybList', ironfodepartmentzybRowIdx, ironfodepartmentzybTpl);ironfodepartmentzybRowIdx = ironfodepartmentzybRowIdx + 1;" title="新增"><i class="fa fa-plus"></i> 新增</a>
			<table id="contentTable" class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<th class="hide"></th>
						<th>备注信息</th>
						<th>普通病区</th>
						<th>康复病区</th>
						<th>临终关怀科</th>
						<th>添加</th>
						<th>主表id</th>
						<th width="10">&nbsp;</th>
					</tr>
				</thead>
				<tbody id="ironfodepartmentzybList">
				</tbody>
			</table>
			<script type="text/template" id="ironfodepartmentzybTpl">//<!--
				<tr id="ironfodepartmentzybList{{idx}}">
					<td class="hide">
						<input id="ironfodepartmentzybList{{idx}}_id" name="ironfodepartmentzybList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
						<input id="ironfodepartmentzybList{{idx}}_delFlag" name="ironfodepartmentzybList[{{idx}}].delFlag" type="hidden" value="0"/>
					</td>
					
					<td>
						<textarea id="ironfodepartmentzybList{{idx}}_remarks" name="ironfodepartmentzybList[{{idx}}].remarks" rows="4"    class="form-control ">{{row.remarks}}</textarea>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfodepartmentzybList{{idx}}_ptbq${dictStatus.index}" name="ironfodepartmentzybList[{{idx}}].ptbq" type="checkbox" class="i-checks" value="${dict.value}" data-value="{{row.ptbq}}"><label for="ironfodepartmentzybList{{idx}}_ptbq${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfodepartmentzybList{{idx}}_kfbq${dictStatus.index}" name="ironfodepartmentzybList[{{idx}}].kfbq" type="checkbox" class="i-checks" value="${dict.value}" data-value="{{row.kfbq}}"><label for="ironfodepartmentzybList{{idx}}_kfbq${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfodepartmentzybList{{idx}}_lzghk${dictStatus.index}" name="ironfodepartmentzybList[{{idx}}].lzghk" type="checkbox" class="i-checks" value="${dict.value}" data-value="{{row.lzghk}}"><label for="ironfodepartmentzybList{{idx}}_lzghk${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<input id="ironfodepartmentzybList{{idx}}_tj_remarks" name="ironfodepartmentzybList[{{idx}}].tj_remarks" type="text" value="{{row.tj_remarks}}"    class="form-control "/>
					</td>
					
					
					<td>
						<input id="ironfodepartmentzybList{{idx}}_dep_id" name="ironfodepartmentzybList[{{idx}}].dep_id" type="text" value="{{row.dep_id}}"    class="form-control "/>
					</td>
					
					<td class="text-center" width="10">
						{{#delBtn}}<span class="close" onclick="delRow(this, '#ironfodepartmentzybList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
					</td>
				</tr>//-->
			</script>
			<script type="text/javascript">
				var ironfodepartmentzybRowIdx = 0, ironfodepartmentzybTpl = $("#ironfodepartmentzybTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
				$(document).ready(function() {
					var data = ${fns:toJson(ironfodepartment.ironfodepartmentzybList)};
					for (var i=0; i<data.length; i++){
						addRow('#ironfodepartmentzybList', ironfodepartmentzybRowIdx, ironfodepartmentzybTpl, data[i]);
						ironfodepartmentzybRowIdx = ironfodepartmentzybRowIdx + 1;
					}
				});
			</script>
			</div>
		</div>
		</div>
	</form:form>
</body>
</html>