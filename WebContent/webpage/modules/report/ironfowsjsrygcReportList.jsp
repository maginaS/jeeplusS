<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>2.9.2卫生技术人员构成管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
	/* 	$(document).ready(function() {
		}); */
	</script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content">
	<div class="ibox">
	<div class="ibox-title">
		<h5>2.9.2卫生技术人员构成列表 </h5>
		<div class="ibox-tools">
			<a class="collapse-link">
				<i class="fa fa-chevron-up"></i>
			</a>
			<a class="dropdown-toggle" data-toggle="dropdown" href="#">
				<i class="fa fa-wrench"></i>
			</a>
			<ul class="dropdown-menu dropdown-user">
				<li><a href="#">选项1</a>
				</li>
				<li><a href="#">选项2</a>
				</li>
			</ul>
			<a class="close-link">
				<i class="fa fa-times"></i>
			</a>
		</div>
	</div>
    
    <div class="ibox-content">
	<sys:message content="${message}"/>
	
	<!--查询条件-->
	<div class="row">
	<div class="col-sm-12">
	<form:form id="searchForm" modelAttribute="ironfowsjsrygc" action="${ctx}/ironfowsjsrygcreport/ironfowsjsrygc/" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<div class="form-group">
		 </div>	
		 
		 <%-- <td class="width-15 active"><label class="pull-right">用户</label></td>
		         <td class="width-35" >
		         <sys:treeselect id="duser" name="duser.id" value="${ironfowsjsrygc.duser.id}" 
		         labelName="duser.name" labelValue="${ironfowsjsrygc.duser.name}"
					title="用户" url="/sys/user/treeData" extId="${duser.id}" 
					cssClass="form-control m-s" allowClear="true"/></td> --%>
					<td class="width-35" >用户<sys:treeselect id="duser" name="duser.id" value="${ironfowsjsrygc.duser.id}" 
		         labelName="duser.name" labelValue="${ironfowsjsrygc.duser.name}"
					title="用户" url="/sys/user/treeData" extId="${duser.id}" 
					cssClass="form-control m-s" allowClear="false"/></td>
					
	</form:form>
	<br/>
	</div>
	</div>
	
	<!-- 工具栏 -->
	<div class="row">
	<div class="col-sm-12">
		<div class="pull-left">
			<shiro:hasPermission name="ironfowsjsrygcreport:ironfowsjsrygc:add">
				<table:addRow url="${ctx}/ironfowsjsrygcreport/ironfowsjsrygc/form" title="2.7.2卫生技术人员构成"></table:addRow><!-- 增加按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="ironfowsjsrygcreport:ironfowsjsrygc:edit">
			    <table:editRow url="${ctx}/ironfowsjsrygcreport/ironfowsjsrygc/form" title="2.7.2卫生技术人员构成" id="contentTable"></table:editRow><!-- 编辑按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="ironfowsjsrygcreport:ironfowsjsrygc:del">
				<table:delRow url="${ctx}/ironfowsjsrygcreport/ironfowsjsrygc/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="ironfowsjsrygcreport:ironfowsjsrygc:import">
				<table:importExcel url="${ctx}/ironfowsjsrygcreport/ironfowsjsrygc/import"></table:importExcel><!-- 导入按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="ironfowsjsrygcreport:ironfowsjsrygc:export">
	       		<table:exportExcel url="${ctx}/ironfowsjsrygcreport/ironfowsjsrygc/export"></table:exportExcel><!-- 导出按钮 -->
	       	</shiro:hasPermission>
	       <button class="btn btn-white btn-sm " data-toggle="tooltip" data-placement="left" onclick="sortOrRefresh()" title="刷新"><i class="glyphicon glyphicon-repeat"></i> 刷新</button>
		
			</div>
		<div class="pull-right">
			<button  class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="search()" ><i class="fa fa-search"></i> 查询</button>
			<button  class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="reset()" ><i class="fa fa-refresh"></i> 重置</button>
		</div>
	</div>
	</div>
	
	<!-- 表格 -->
	<table id="contentTable" class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable">
		<thead>
			<tr>
				<th> <input type="checkbox" class="i-checks"></th>
				<!-- <th  class="sort-column remarks">备注信息</th> -->
				<th  class="sort-column doc_id">主表id</th>
				<th  class="sort-column date">日期</th>
				<th  class="sort-column zyys">执业医师（人）</th>
				<th  class="sort-column zyysqzggwslb">执业医师其中公共卫生类别（人）</th>
				<th  class="sort-column zyzlys">执业助理医师（人）</th>
				<th  class="sort-column zyzlysqzggwslb">执业助理医师其中公共卫生类别（人）</th>
				<th  class="sort-column zcqkys">注册全科医生（人）</th>
				<th  class="sort-column qdqkyspxhgzdrs">取得全科医生培训合格证的人数（人）</th>
				<th  class="sort-column zchs">注册护士（人）</th>
				<th  class="sort-column zcs">助产士（人）</th>
				<th  class="sort-column yss">药师（士） （人）</th>
				<th  class="sort-column zys">中药师（士） （人）</th>
				<th  class="sort-column jyys">检验医师（士） （人）</th>
				<th  class="sort-column yxys">影像医师（士） （人）</th>
				<th  class="sort-column kfzls">康复治疗师（人）</th>
				<th  class="sort-column qtwsjsry">其他卫生技术人员（人）</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="ironfowsjsrygc">
			<tr>
				<td> <input type="checkbox" id="${ironfowsjsrygc.id}" class="i-checks"></td>
				<td><a  href="#" onclick="openDialogView('查看2.7.2卫生技术人员构成', '${ctx}/ironfowsjsrygcreport/ironfowsjsrygc/form?id=${ironfowsjsrygc.id}','800px', '500px')">
					<%-- ${ironfowsjsrygc.remarks} --%>
				</a></td>
				<td>
					${ironfowsjsrygc.doc_id}
				</td>
				<td>
					${ironfowsjsrygc.date}
				</td>
				<td>
					${ironfowsjsrygc.zyys}
				</td>
				<td>
					${ironfowsjsrygc.zyysqzggwslb}
				</td>
				<td>
					${ironfowsjsrygc.zyzlys}
				</td>
				<td>
					${ironfowsjsrygc.zyzlysqzggwslb}
				</td>
				<td>
					${ironfowsjsrygc.zcqkys}
				</td>
				<td>
					${ironfowsjsrygc.qdqkyspxhgzdrs}
				</td>
				<td>
					${ironfowsjsrygc.zchs}
				</td>
				<td>
					${ironfowsjsrygc.zcs}
				</td>
				<td>
					${ironfowsjsrygc.yss}
				</td>
				<td>
					${ironfowsjsrygc.zys}
				</td>
				<td>
					${ironfowsjsrygc.jyys}
				</td>
				<td>
					${ironfowsjsrygc.yxys}
				</td>
				<td>
					${ironfowsjsrygc.kfzls}
				</td>
				<td>
					${ironfowsjsrygc.qtwsjsry}
				</td>
				<td>
					<shiro:hasPermission name="ironfowsjsrygcreport:ironfowsjsrygc:view">
						<a href="#" onclick="openDialogView('查看2.7.2卫生技术人员构成', '${ctx}/ironfowsjsrygcreport/ironfowsjsrygc/form?id=${ironfowsjsrygc.id}','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="ironfowsjsrygcreport:ironfowsjsrygc:edit">
    					<a href="#" onclick="openDialog('修改2.7.2卫生技术人员构成', '${ctx}/ironfowsjsrygcreport/ironfowsjsrygc/form?id=${ironfowsjsrygc.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>
    				</shiro:hasPermission>
    				<shiro:hasPermission name="ironfowsjsrygcreport:ironfowsjsrygc:del">
						<a href="${ctx}/ironfowsjsrygcreport/ironfowsjsrygc/delete?id=${ironfowsjsrygc.id}" onclick="return confirmx('确认要删除该2.7.2卫生技术人员构成吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
					</shiro:hasPermission>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
		<!-- 分页代码 -->
	<table:page page="${page}"></table:page>
	<br/>
	<br/>
	</div>
	</div>
</div>
</body>
</html>