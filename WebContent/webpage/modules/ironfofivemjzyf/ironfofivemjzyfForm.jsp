<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>5.2门急诊用房管理</title>
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
	<form:form id="inputForm" modelAttribute="ironfofivemjzyf" action="${ctx}/ironfofivemjzyf/ironfofivemjzyf/save" method="post" class="form-horizontal">
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
					<td class="width-15 active"><label class="pull-right">功能单元建筑面积（m2）：</label></td>
					<td class="width-35">
						<form:input path="gndyjzmj" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"></td>
		   			<td class="width-35" ></td>
		  		</tr>
		 	</tbody>
		</table>
		
		<div class="tabs-container">
            <ul class="nav nav-tabs">
				<li class="active"><a data-toggle="tab" href="#tab-1" aria-expanded="true">门急诊用房空间类型：</a>
                </li>
            </ul>
            <div class="tab-content">
				<div id="tab-1" class="tab-pane active">
			<a class="btn btn-white btn-sm" onclick="addRow('#ironfofivemjzyfkjlxList', ironfofivemjzyfkjlxRowIdx, ironfofivemjzyfkjlxTpl);ironfofivemjzyfkjlxRowIdx = ironfofivemjzyfkjlxRowIdx + 1;" title="新增"><i class="fa fa-plus"></i> 新增</a>
			<table id="contentTable" class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<th class="hide"></th>
						<th>备注信息</th>
						<th>5.2门急诊用房id</th>
						<th>挂号收费室</th>
						<th>服务中心</th>
						<th>分诊台</th>
						<th>候诊区</th>
						<th>全科医疗科诊室</th>
						<th>普通内科诊室-内科用房</th>
						<th>肠道及发热门诊室-内科用房</th>
						<th>普通外科诊室-外科用房</th>
						<th>骨科诊室-外科用房</th>
						<th>妇产科诊室-妇产科用房</th>
						<th>检查室-妇产科用房</th>
						<th>儿科诊室</th>
						<th>中医科诊室-中医科用房</th>
						<th>中医治疗室-中医科用房</th>
						<th>口腔科诊室-口腔科用房</th>
						<th>口腔治疗室-口腔科用房</th>
						<th>技工室-口腔科用房</th>
						<th>眼科诊室</th>
						<th>耳鼻喉科诊室</th>
						<th>皮肤科诊室</th>
						<th>感染性疾病科诊室-感染性疾病科用房</th>
						<th>隔离室-感染性疾病科用房</th>
						<th>康复科诊室-康复科用房</th>
						<th>西医理疗室-康复科用房</th>
						<th>运动治疗室-康复科用房</th>
						<th>言语治疗室-康复科用房</th>
						<th>护士站-输液用房</th>
						<th>治疗准备室-输液用房</th>
						<th>注射室-输液用房</th>
						<th>输液室-输液用房</th>
						<th>注射观察室-输液用房</th>
						<th>急诊科诊室-急诊科用房</th>
						<th>抢救室-急诊科用房</th>
						<th>留观室-急诊科用房</th>
						<th>医生值班室-急诊科用房</th>
						<th>其它（请注明）</th>
						<th>主表id</th>
						<th width="10">&nbsp;</th>
					</tr>
				</thead>
				<tbody id="ironfofivemjzyfkjlxList">
				</tbody>
			</table>
			<script type="text/template" id="ironfofivemjzyfkjlxTpl">//<!--
				<tr id="ironfofivemjzyfkjlxList{{idx}}">
					<td class="hide">
						<input id="ironfofivemjzyfkjlxList{{idx}}_id" name="ironfofivemjzyfkjlxList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
						<input id="ironfofivemjzyfkjlxList{{idx}}_delFlag" name="ironfofivemjzyfkjlxList[{{idx}}].delFlag" type="hidden" value="0"/>
					</td>
					
					<td>
						<textarea id="ironfofivemjzyfkjlxList{{idx}}_remarks" name="ironfofivemjzyfkjlxList[{{idx}}].remarks" rows="4"    class="form-control ">{{row.remarks}}</textarea>
					</td>
					
					
					<td>
						<input id="ironfofivemjzyfkjlxList{{idx}}_mjzyfId" name="ironfofivemjzyfkjlxList[{{idx}}].mjzyfId" type="text" value="{{row.mjzyfId}}"    class="form-control "/>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfofivemjzyfkjlxList{{idx}}_ghsfs${dictStatus.index}" name="ironfofivemjzyfkjlxList[{{idx}}].ghsfs" type="radio" class="i-checks" value="${dict.value}" data-value="{{row.ghsfs}}"><label for="ironfofivemjzyfkjlxList{{idx}}_ghsfs${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfofivemjzyfkjlxList{{idx}}_ghsfs${dictStatus.index}" name="ironfofivemjzyfkjlxList[{{idx}}].ghsfs" type="radio" class="i-checks" value="${dict.value}" data-value="{{row.ghsfs}}"><label for="ironfofivemjzyfkjlxList{{idx}}_ghsfs${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfofivemjzyfkjlxList{{idx}}_fzt${dictStatus.index}" name="ironfofivemjzyfkjlxList[{{idx}}].fzt" type="radio" class="i-checks" value="${dict.value}" data-value="{{row.fzt}}"><label for="ironfofivemjzyfkjlxList{{idx}}_fzt${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfofivemjzyfkjlxList{{idx}}_hzq${dictStatus.index}" name="ironfofivemjzyfkjlxList[{{idx}}].hzq" type="radio" class="i-checks" value="${dict.value}" data-value="{{row.hzq}}"><label for="ironfofivemjzyfkjlxList{{idx}}_hzq${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfofivemjzyfkjlxList{{idx}}_qkylkzs${dictStatus.index}" name="ironfofivemjzyfkjlxList[{{idx}}].qkylkzs" type="radio" class="i-checks" value="${dict.value}" data-value="{{row.qkylkzs}}"><label for="ironfofivemjzyfkjlxList{{idx}}_qkylkzs${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfofivemjzyfkjlxList{{idx}}_ptnkzsnkyf${dictStatus.index}" name="ironfofivemjzyfkjlxList[{{idx}}].ptnkzsnkyf" type="radio" class="i-checks" value="${dict.value}" data-value="{{row.ptnkzsnkyf}}"><label for="ironfofivemjzyfkjlxList{{idx}}_ptnkzsnkyf${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfofivemjzyfkjlxList{{idx}}_cdjfrmzsnkyf${dictStatus.index}" name="ironfofivemjzyfkjlxList[{{idx}}].cdjfrmzsnkyf" type="radio" class="i-checks" value="${dict.value}" data-value="{{row.cdjfrmzsnkyf}}"><label for="ironfofivemjzyfkjlxList{{idx}}_cdjfrmzsnkyf${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfofivemjzyfkjlxList{{idx}}_ptwkzswkyf${dictStatus.index}" name="ironfofivemjzyfkjlxList[{{idx}}].ptwkzswkyf" type="radio" class="i-checks" value="${dict.value}" data-value="{{row.ptwkzswkyf}}"><label for="ironfofivemjzyfkjlxList{{idx}}_ptwkzswkyf${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfofivemjzyfkjlxList{{idx}}_gkzswkyf${dictStatus.index}" name="ironfofivemjzyfkjlxList[{{idx}}].gkzswkyf" type="radio" class="i-checks" value="${dict.value}" data-value="{{row.gkzswkyf}}"><label for="ironfofivemjzyfkjlxList{{idx}}_gkzswkyf${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfofivemjzyfkjlxList{{idx}}_fckzsfckyf${dictStatus.index}" name="ironfofivemjzyfkjlxList[{{idx}}].fckzsfckyf" type="radio" class="i-checks" value="${dict.value}" data-value="{{row.fckzsfckyf}}"><label for="ironfofivemjzyfkjlxList{{idx}}_fckzsfckyf${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfofivemjzyfkjlxList{{idx}}_jcsfckyf${dictStatus.index}" name="ironfofivemjzyfkjlxList[{{idx}}].jcsfckyf" type="radio" class="i-checks" value="${dict.value}" data-value="{{row.jcsfckyf}}"><label for="ironfofivemjzyfkjlxList{{idx}}_jcsfckyf${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfofivemjzyfkjlxList{{idx}}_ekzs${dictStatus.index}" name="ironfofivemjzyfkjlxList[{{idx}}].ekzs" type="radio" class="i-checks" value="${dict.value}" data-value="{{row.ekzs}}"><label for="ironfofivemjzyfkjlxList{{idx}}_ekzs${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfofivemjzyfkjlxList{{idx}}_zykzszykyf${dictStatus.index}" name="ironfofivemjzyfkjlxList[{{idx}}].zykzszykyf" type="radio" class="i-checks" value="${dict.value}" data-value="{{row.zykzszykyf}}"><label for="ironfofivemjzyfkjlxList{{idx}}_zykzszykyf${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfofivemjzyfkjlxList{{idx}}_zyzlszykyf${dictStatus.index}" name="ironfofivemjzyfkjlxList[{{idx}}].zyzlszykyf" type="radio" class="i-checks" value="${dict.value}" data-value="{{row.zyzlszykyf}}"><label for="ironfofivemjzyfkjlxList{{idx}}_zyzlszykyf${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfofivemjzyfkjlxList{{idx}}_kqkzskqkyf${dictStatus.index}" name="ironfofivemjzyfkjlxList[{{idx}}].kqkzskqkyf" type="radio" class="i-checks" value="${dict.value}" data-value="{{row.kqkzskqkyf}}"><label for="ironfofivemjzyfkjlxList{{idx}}_kqkzskqkyf${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfofivemjzyfkjlxList{{idx}}_kqzlskqkyf${dictStatus.index}" name="ironfofivemjzyfkjlxList[{{idx}}].kqzlskqkyf" type="radio" class="i-checks" value="${dict.value}" data-value="{{row.kqzlskqkyf}}"><label for="ironfofivemjzyfkjlxList{{idx}}_kqzlskqkyf${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfofivemjzyfkjlxList{{idx}}_jgskqkyf${dictStatus.index}" name="ironfofivemjzyfkjlxList[{{idx}}].jgskqkyf" type="radio" class="i-checks" value="${dict.value}" data-value="{{row.jgskqkyf}}"><label for="ironfofivemjzyfkjlxList{{idx}}_jgskqkyf${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfofivemjzyfkjlxList{{idx}}_ykzs${dictStatus.index}" name="ironfofivemjzyfkjlxList[{{idx}}].ykzs" type="radio" class="i-checks" value="${dict.value}" data-value="{{row.ykzs}}"><label for="ironfofivemjzyfkjlxList{{idx}}_ykzs${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfofivemjzyfkjlxList{{idx}}_ebhkzs${dictStatus.index}" name="ironfofivemjzyfkjlxList[{{idx}}].ebhkzs" type="radio" class="i-checks" value="${dict.value}" data-value="{{row.ebhkzs}}"><label for="ironfofivemjzyfkjlxList{{idx}}_ebhkzs${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfofivemjzyfkjlxList{{idx}}_pfkzs${dictStatus.index}" name="ironfofivemjzyfkjlxList[{{idx}}].pfkzs" type="radio" class="i-checks" value="${dict.value}" data-value="{{row.pfkzs}}"><label for="ironfofivemjzyfkjlxList{{idx}}_pfkzs${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfofivemjzyfkjlxList{{idx}}_grxjbkzsgrxjbkyf${dictStatus.index}" name="ironfofivemjzyfkjlxList[{{idx}}].grxjbkzsgrxjbkyf" type="radio" class="i-checks" value="${dict.value}" data-value="{{row.grxjbkzsgrxjbkyf}}"><label for="ironfofivemjzyfkjlxList{{idx}}_grxjbkzsgrxjbkyf${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfofivemjzyfkjlxList{{idx}}_glsgrxjbkyf${dictStatus.index}" name="ironfofivemjzyfkjlxList[{{idx}}].glsgrxjbkyf" type="radio" class="i-checks" value="${dict.value}" data-value="{{row.glsgrxjbkyf}}"><label for="ironfofivemjzyfkjlxList{{idx}}_glsgrxjbkyf${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfofivemjzyfkjlxList{{idx}}_kfkzskfkyf${dictStatus.index}" name="ironfofivemjzyfkjlxList[{{idx}}].kfkzskfkyf" type="radio" class="i-checks" value="${dict.value}" data-value="{{row.kfkzskfkyf}}"><label for="ironfofivemjzyfkjlxList{{idx}}_kfkzskfkyf${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfofivemjzyfkjlxList{{idx}}_xyllskfkyf${dictStatus.index}" name="ironfofivemjzyfkjlxList[{{idx}}].xyllskfkyf" type="radio" class="i-checks" value="${dict.value}" data-value="{{row.xyllskfkyf}}"><label for="ironfofivemjzyfkjlxList{{idx}}_xyllskfkyf${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfofivemjzyfkjlxList{{idx}}_ydzlskfkyf${dictStatus.index}" name="ironfofivemjzyfkjlxList[{{idx}}].ydzlskfkyf" type="radio" class="i-checks" value="${dict.value}" data-value="{{row.ydzlskfkyf}}"><label for="ironfofivemjzyfkjlxList{{idx}}_ydzlskfkyf${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfofivemjzyfkjlxList{{idx}}_yyzlskfkyf${dictStatus.index}" name="ironfofivemjzyfkjlxList[{{idx}}].yyzlskfkyf" type="radio" class="i-checks" value="${dict.value}" data-value="{{row.yyzlskfkyf}}"><label for="ironfofivemjzyfkjlxList{{idx}}_yyzlskfkyf${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfofivemjzyfkjlxList{{idx}}_hszsyyf${dictStatus.index}" name="ironfofivemjzyfkjlxList[{{idx}}].hszsyyf" type="radio" class="i-checks" value="${dict.value}" data-value="{{row.hszsyyf}}"><label for="ironfofivemjzyfkjlxList{{idx}}_hszsyyf${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfofivemjzyfkjlxList{{idx}}_zlzbssyyf${dictStatus.index}" name="ironfofivemjzyfkjlxList[{{idx}}].zlzbssyyf" type="radio" class="i-checks" value="${dict.value}" data-value="{{row.zlzbssyyf}}"><label for="ironfofivemjzyfkjlxList{{idx}}_zlzbssyyf${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfofivemjzyfkjlxList{{idx}}_zsssyyf${dictStatus.index}" name="ironfofivemjzyfkjlxList[{{idx}}].zsssyyf" type="radio" class="i-checks" value="${dict.value}" data-value="{{row.zsssyyf}}"><label for="ironfofivemjzyfkjlxList{{idx}}_zsssyyf${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfofivemjzyfkjlxList{{idx}}_syssyyf${dictStatus.index}" name="ironfofivemjzyfkjlxList[{{idx}}].syssyyf" type="radio" class="i-checks" value="${dict.value}" data-value="{{row.syssyyf}}"><label for="ironfofivemjzyfkjlxList{{idx}}_syssyyf${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfofivemjzyfkjlxList{{idx}}_zsgcssyyf${dictStatus.index}" name="ironfofivemjzyfkjlxList[{{idx}}].zsgcssyyf" type="radio" class="i-checks" value="${dict.value}" data-value="{{row.zsgcssyyf}}"><label for="ironfofivemjzyfkjlxList{{idx}}_zsgcssyyf${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfofivemjzyfkjlxList{{idx}}_jzkzsjzkyf${dictStatus.index}" name="ironfofivemjzyfkjlxList[{{idx}}].jzkzsjzkyf" type="radio" class="i-checks" value="${dict.value}" data-value="{{row.jzkzsjzkyf}}"><label for="ironfofivemjzyfkjlxList{{idx}}_jzkzsjzkyf${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfofivemjzyfkjlxList{{idx}}_qjsjzkyf${dictStatus.index}" name="ironfofivemjzyfkjlxList[{{idx}}].qjsjzkyf" type="radio" class="i-checks" value="${dict.value}" data-value="{{row.qjsjzkyf}}"><label for="ironfofivemjzyfkjlxList{{idx}}_qjsjzkyf${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfofivemjzyfkjlxList{{idx}}_lgsjzkyf${dictStatus.index}" name="ironfofivemjzyfkjlxList[{{idx}}].lgsjzkyf" type="radio" class="i-checks" value="${dict.value}" data-value="{{row.lgsjzkyf}}"><label for="ironfofivemjzyfkjlxList{{idx}}_lgsjzkyf${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<c:forEach items="${fns:getDictList('')}" var="dict" varStatus="dictStatus">
							<span><input id="ironfofivemjzyfkjlxList{{idx}}_yszbsjzkyf${dictStatus.index}" name="ironfofivemjzyfkjlxList[{{idx}}].yszbsjzkyf" type="radio" class="i-checks" value="${dict.value}" data-value="{{row.yszbsjzkyf}}"><label for="ironfofivemjzyfkjlxList{{idx}}_yszbsjzkyf${dictStatus.index}">${dict.label}</label></span>
						</c:forEach>
					</td>
					
					
					<td>
						<input id="ironfofivemjzyfkjlxList{{idx}}_qtqzm" name="ironfofivemjzyfkjlxList[{{idx}}].qtqzm" type="text" value="{{row.qtqzm}}"    class="form-control "/>
					</td>
					
					
					<td>
						<input id="ironfofivemjzyfkjlxList{{idx}}_doc_id" name="ironfofivemjzyfkjlxList[{{idx}}].doc_id" type="text" value="{{row.doc_id}}"    class="form-control "/>
					</td>
					
					<td class="text-center" width="10">
						{{#delBtn}}<span class="close" onclick="delRow(this, '#ironfofivemjzyfkjlxList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
					</td>
				</tr>//-->
			</script>
			<script type="text/javascript">
				var ironfofivemjzyfkjlxRowIdx = 0, ironfofivemjzyfkjlxTpl = $("#ironfofivemjzyfkjlxTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
				$(document).ready(function() {
					var data = ${fns:toJson(ironfofivemjzyf.ironfofivemjzyfkjlxList)};
					for (var i=0; i<data.length; i++){
						addRow('#ironfofivemjzyfkjlxList', ironfofivemjzyfkjlxRowIdx, ironfofivemjzyfkjlxTpl, data[i]);
						ironfofivemjzyfkjlxRowIdx = ironfofivemjzyfkjlxRowIdx + 1;
					}
				});
			</script>
			</div>
		</div>
		</div>
	</form:form>
</body>
</html>