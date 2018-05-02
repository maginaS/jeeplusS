<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>冬季采暖管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
		});
	</script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content">
	<div class="ibox">
	<div class="ibox-title">
		<h5>冬季采暖列表 </h5>
		<!-- <div class="ibox-tools">
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
		</div> -->
	</div>
    
    <div class="ibox-content">
	<sys:message content="${message}"/>
	
	<!--查询条件-->
	<div class="row">
	<div class="col-sm-12">
	<form:form id="searchForm" modelAttribute="ironfofiventzydjcn" action="${ctx}/ironfofiventzydjcnreport/ironfofiventzydjcn/" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<div class="form-group">
		 </div>
		 <td class="width-35" >用户<sys:treeselect id="duser" name="duser.id" value="${ironfofiventzydjcn.duser.id}" 
		         labelName="duser.name" labelValue="${ironfofiventzydjcn.duser.name}"
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
			<%-- <shiro:hasPermission name="ironfofiventzydjcnreport:ironfofiventzydjcn:add">
				<table:addRow url="${ctx}/ironfofiventzydjcnreport/ironfofiventzydjcn/form" title="冬季采暖"></table:addRow><!-- 增加按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="ironfofiventzydjcnreport:ironfofiventzydjcn:edit">
			    <table:editRow url="${ctx}/ironfofiventzydjcnreport/ironfofiventzydjcn/form" title="冬季采暖" id="contentTable"></table:editRow><!-- 编辑按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="ironfofiventzydjcnreport:ironfofiventzydjcn:del">
				<table:delRow url="${ctx}/ironfofiventzydjcnreport/ironfofiventzydjcn/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="ironfofiventzydjcnreport:ironfofiventzydjcn:import">
				<table:importExcel url="${ctx}/ironfofiventzydjcnreport/ironfofiventzydjcn/import"></table:importExcel><!-- 导入按钮 -->
			</shiro:hasPermission> --%>
			<shiro:hasPermission name="ironfofiventzydjcnreport:ironfofiventzydjcn:export">
	       		<table:exportExcel url="${ctx}/ironfofiventzydjcnreport/ironfofiventzydjcn/export"></table:exportExcel><!-- 导出按钮 -->
	       	</shiro:hasPermission>
	       <!-- <button class="btn btn-white btn-sm " data-toggle="tooltip" data-placement="left" onclick="sortOrRefresh()" title="刷新"><i class="glyphicon glyphicon-repeat"></i> 刷新</button> -->
		
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
				<!-- <th  class="sort-column doc_id">主表id</th> -->
				<th  class="sort-column zykt">中央空调</th>
				<th  class="sort-column ftkt">分体空调</th>
				<th  class="sort-column glcn">锅炉采暖</th>
				<th  class="sort-column dzq">电暖气</th>
				<th  class="sort-column szrl">市政热力</th>
				<!-- <th>操作</th> -->
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="ironfofiventzydjcn">
			<tr>
				<td> <input type="checkbox" id="${ironfofiventzydjcn.id}" class="i-checks"></td>
				<%-- <td><a  href="#" onclick="openDialogView('查看冬季采暖', '${ctx}/ironfofiventzydjcnreport/ironfofiventzydjcn/form?id=${ironfofiventzydjcn.id}','800px', '500px')">
					${ironfofiventzydjcn.remarks}
				</a></td> --%>
				<%-- <td>
					${ironfofiventzydjcn.doc_id}
				</td> --%>
				<td>
				<c:if test="${ironfofiventzydjcn.zykt eq '1'}">是</c:if>
            		<c:if test="${ironfofiventzydjcn.zykt eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiventzydjcn.ftkt eq '1'}">是</c:if>
            		<c:if test="${ironfofiventzydjcn.ftkt eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiventzydjcn.glcn eq '1'}">是</c:if>
            		<c:if test="${ironfofiventzydjcn.glcn eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiventzydjcn.dzq eq '1'}">是</c:if>
            		<c:if test="${ironfofiventzydjcn.dzq eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiventzydjcn.szrl eq '1'}">是</c:if>
            		<c:if test="${ironfofiventzydjcn.szrl eq '0'}">否</c:if>
					
				</td>
				<%-- <td>
					<shiro:hasPermission name="ironfofiventzydjcnreport:ironfofiventzydjcn:view">
						<a href="#" onclick="openDialogView('查看冬季采暖', '${ctx}/ironfofiventzydjcnreport/ironfofiventzydjcn/form?id=${ironfofiventzydjcn.id}','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="ironfofiventzydjcnreport:ironfofiventzydjcn:edit">
    					<a href="#" onclick="openDialog('修改冬季采暖', '${ctx}/ironfofiventzydjcnreport/ironfofiventzydjcn/form?id=${ironfofiventzydjcn.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>
    				</shiro:hasPermission>
    				<shiro:hasPermission name="ironfofiventzydjcnreport:ironfofiventzydjcn:del">
						<a href="${ctx}/ironfofiventzydjcnreport/ironfofiventzydjcn/delete?id=${ironfofiventzydjcn.id}" onclick="return confirmx('确认要删除该冬季采暖吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
					</shiro:hasPermission>
				</td> --%>
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