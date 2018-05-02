<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>4.5信息化系统配套硬件管理</title>
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
		<h5>4.5信息化系统配套硬件列表 </h5>
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
	<form:form id="searchForm" modelAttribute="ironfoinformationhardware" action="${ctx}/ironfoinforhardwarereport/ironfoinformationhardware/" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<div class="form-group">
		 </div>
		 <td class="width-35" >用户<sys:treeselect id="duser" name="duser.id" value="${ironfoinformationhardware.duser.id}" 
		         labelName="duser.name" labelValue="${ironfoinformationhardware.duser.name}"
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
			<%-- <shiro:hasPermission name="ironfoinforhardwarereport:ironfoinformationhardware:add">
				<table:addRow url="${ctx}/ironfoinforhardwarereport/ironfoinformationhardware/form" title="4.5信息化系统配套硬件"></table:addRow><!-- 增加按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="ironfoinforhardwarereport:ironfoinformationhardware:edit">
			    <table:editRow url="${ctx}/ironfoinforhardwarereport/ironfoinformationhardware/form" title="4.5信息化系统配套硬件" id="contentTable"></table:editRow><!-- 编辑按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="ironfoinforhardwarereport:ironfoinformationhardware:del">
				<table:delRow url="${ctx}/ironfoinforhardwarereport/ironfoinformationhardware/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="ironfoinforhardwarereport:ironfoinformationhardware:import">
				<table:importExcel url="${ctx}/ironfoinforhardwarereport/ironfoinformationhardware/import"></table:importExcel><!-- 导入按钮 -->
			</shiro:hasPermission> --%>
			<shiro:hasPermission name="ironfoinforhardwarereport:ironfoinformationhardware:export">
	       		<table:exportExcel url="${ctx}/ironfoinforhardwarereport/ironfoinformationhardware/export"></table:exportExcel><!-- 导出按钮 -->
	       	</shiro:hasPermission>
	      <!--  <button class="btn btn-white btn-sm " data-toggle="tooltip" data-placement="left" onclick="sortOrRefresh()" title="刷新"><i class="glyphicon glyphicon-repeat"></i> 刷新</button> -->
		
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
				<th  class="sort-column hardware_xxxtjf">信息系统机房</th>
				<th  class="sort-column hardware_xtjfmj">信息系统机房面积（m2）</th>
				<th  class="sort-column hardware_fwq">服务器（台）</th>
				<!-- <th>操作</th> -->
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="ironfoinformationhardware">
			<tr>
				<td> <input type="checkbox" id="${ironfoinformationhardware.id}" class="i-checks"></td>
				<%-- <td><a  href="#" onclick="openDialogView('查看4.5信息化系统配套硬件', '${ctx}/ironfoinforhardwarereport/ironfoinformationhardware/form?id=${ironfoinformationhardware.id}','800px', '500px')">
					${ironfoinformationhardware.remarks}
				</a></td> --%>
				<%-- <td>
					${ironfoinformationhardware.doc_id}
				</td> --%>
				<td>
					<c:if test="${ironfoinformationhardware.xxxtjf eq '1'}">是</c:if>
            		<c:if test="${ironfoinformationhardware.xxxtjf eq '2'}">无</c:if>
				</td>
				<td>
					${ironfoinformationhardware.xtjfmj}
				</td>
				<!-- <td>
					asdasd123123
				</td> -->
				<td>
					${ironfoinformationhardware.fwq}
				</td>
				<%-- <td>
					<shiro:hasPermission name="ironfoinforhardwarereport:ironfoinformationhardware:view">
						<a href="#" onclick="openDialogView('查看4.5信息化系统配套硬件', '${ctx}/ironfoinforhardwarereport/ironfoinformationhardware/form?id=${ironfoinformationhardware.id}','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="ironfoinforhardwarereport:ironfoinformationhardware:edit">
    					<a href="#" onclick="openDialog('修改4.5信息化系统配套硬件', '${ctx}/ironfoinforhardwarereport/ironfoinformationhardware/form?id=${ironfoinformationhardware.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>
    				</shiro:hasPermission>
    				<shiro:hasPermission name="ironfoinforhardwarereport:ironfoinformationhardware:del">
						<a href="${ctx}/ironfoinforhardwarereport/ironfoinformationhardware/delete?id=${ironfoinformationhardware.id}" onclick="return confirmx('确认要删除该4.5信息化系统配套硬件吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
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