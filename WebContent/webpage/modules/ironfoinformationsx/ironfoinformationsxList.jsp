<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>4.2信息化系统功能实现管理</title>
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
		<h5>4.2信息化系统功能实现列表 </h5>
	</div>
    
    <div class="ibox-content">
	<sys:message content="${message}"/>
	
	<!--查询条件-->
	<div class="row">
	<div class="col-sm-12">
	<form:form id="searchForm" modelAttribute="ironfoinformationsx" action="${ctx}/ironfoinformationsx/ironfoinformationsx/" method="post" class="form-inline">
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
			
	</div>
	</div>
	
	<!-- 表格 -->
	<table id="contentTable" class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable">
		<thead>
			<tr>
				<th  class="sort-column xxhxtgndy">信息化系统功能单元</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="ironfoinformationsx">
			<tr>
				<td>
					${ironfoinformationsx.xxhxtgndy}
				</td>
				<td>
					<shiro:hasPermission name="ironfoinformationsx:ironfoinformationsx:edit">
    					<a href="#" onclick="openDialog('填写${ironfoinformationsx.xxhxtgndy}设置', '${ctx}/ironfoinformationsx/ironfoinformationsx/form?id=${ironfoinformationsx.id}&remark=${ironfoinformationsx.remarks  }','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i>填写${ironfoinformationsx.xxhxtgndy}设置</a>
    				</shiro:hasPermission>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	
	<br/>
	<br/>
	</div>
	</div>
</div>
</body>
</html>