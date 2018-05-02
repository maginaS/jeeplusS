<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>数据库备份管理</title>
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
		<h5>数据库备份列表 </h5>
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
	<form:form id="searchForm" modelAttribute="backup" action="${ctx}/sysrole/backup/" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<div class="form-group">
		 </div>	
	</form:form>
	<br/>
	</div>
	</div>
	
	<!-- 工具栏 -->
	<div class="row">
	<div class="col-sm-12">
		<div class="pull-left">
			<shiro:hasPermission name="sysrole:backup:add">
				<table:addRow url="${ctx}/sysrole/backup/form" title="数据库备份"></table:addRow><!-- 增加按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="sysrole:backup:edit">
			    <table:editRow url="${ctx}/sysrole/backup/form" title="数据库备份" id="contentTable"></table:editRow><!-- 编辑按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="sysrole:backup:del">
				<table:delRow url="${ctx}/sysrole/backup/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="sysrole:backup:import">
				<table:importExcel url="${ctx}/sysrole/backup/import"></table:importExcel><!-- 导入按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="sysrole:backup:export">
	       		<table:exportExcel url="${ctx}/sysrole/backup/export"></table:exportExcel><!-- 导出按钮 -->
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
				<th  class="sort-column date">备份时间</th>
				<th  class="sort-column dataName">库名</th>
				<th  class="sort-column path">文件地址</th>
				<th  class="sort-column size">文件大小</th>
				<th  class="sort-column status">状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="backup">
			<tr>
				<td> <input type="checkbox" id="${backup.id}" class="i-checks"></td>
				<td><a  href="#" onclick="openDialogView('查看数据库备份', '${ctx}/sysrole/backup/form?id=${backup.id}','800px', '500px')">
					<fmt:formatDate value="${backup.date}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<td>
					${backup.dataName}
				</td>
				<td>
					${backup.path}
				</td>
				<td>
				    <a href="${ctx}/sysrole/backup/form?id=${backup.id}">
				    <c:if test="${backup.status =='2'}">
				        <i>${backup.size}G</i>
				    </c:if>
				</td>
				<td>
				    <a href="${ctx}/sysrole/backup/form?id=${backup.id}">
			            <c:if test="${backup.status =='0'}">
			                <i class=" i-checks"> 未备份</i> 
			            </c:if>
                        <c:if test="${backup.status =='1'}">
                            <i class="i-checks "> 备份中</i>
			            </c:if>
			            <c:if test="${backup.status =='2'}">
                            <i class="i-checks "> 备份成功</i>
			            </c:if>
	                </a>
				</td>
				<td>
					<shiro:hasPermission name="sysrole:backup:view">
						<a href="#" onclick="openDialogView('还原数据库备份', '${ctx}/sysrole/backup/delete?id=${backup.id}','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 还原</a>
    				</shiro:hasPermission>
    				<shiro:hasPermission name="sysrole:backup:del">
						<a href="${ctx}/sysrole/backup/import?id=${backup.id}" onclick="return confirmx('确认要导出该数据库备份吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 导出</a>
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