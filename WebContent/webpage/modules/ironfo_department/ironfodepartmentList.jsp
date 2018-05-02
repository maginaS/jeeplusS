<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>2.4科室设置管理</title>
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
		<h5>科室列表 </h5>
		<div class="ibox-tools">
			
		</div>
	</div>
    
    <div class="ibox-content">
	<sys:message content="${message}"/>
	
	<!--查询条件-->
	<div class="row">
	<div class="col-sm-12">
	<form:form id="searchForm" modelAttribute="ironfodepartment" action="${ctx}/ironfo_department/ironfodepartment/" method="post" class="form-inline">
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
		<!-- <div class="pull-right">
			<button  class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="search()" ><i class="fa fa-search"></i> 查询</button>
			<button  class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="reset()" ><i class="fa fa-refresh"></i> 重置</button>
		</div> -->
	</div>
	</div>
	
	<!-- 表格 -->
	<table id="contentTable" class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable">
		<thead>
			<tr>
			<!-- 	<th> <input type="checkbox" class="i-checks"></th> -->
			<!-- 	<th  class="sort-column remarks">备注信息</th> -->
				<th  class="sort-column zndy">职能单元</th>
			<!-- 	<th  class="sort-column doc_id">主表id</th> -->
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="ironfodepartment">
			<tr>
			<%-- 	<td> <input type="checkbox" id="${ironfodepartment.id}" class="i-checks"></td> --%>
				<td><%-- <a  href="#" onclick="openDialogView('查看2.4科室设置', '${ctx}/ironfo_department/ironfodepartment/form?id=${ironfodepartment.id}','800px', '500px')"> --%>
				
					${ironfodepartment.zndy}
				
				<!-- </a> --></td>
			
				<td>
					<shiro:hasPermission name="ironfo_department:ironfodepartment:edit">
    					<a href="#" onclick="openDialog('填写${ironfodepartment.zndy}设置', '${ctx}/ironfo_department/ironfodepartment/form?id=${ironfodepartment.id}&remark=${ironfodepartment.remarks  }','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i>填写${ironfodepartment.zndy}设置</a>
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