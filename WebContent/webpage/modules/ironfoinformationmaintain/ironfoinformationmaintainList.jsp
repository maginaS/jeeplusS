<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>4.4系统维护人员管理</title>
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
		<h5>4.4系统维护人员列表 </h5>
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
	<form:form id="searchForm" modelAttribute="ironfoinformationmaintain" action="${ctx}/ironfoinformationmaintain/ironfoinformationmaintain/" method="post" class="form-inline">
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
			<shiro:hasPermission name="ironfoinformationmaintain:ironfoinformationmaintain:add">
				<table:addRow url="${ctx}/ironfoinformationmaintain/ironfoinformationmaintain/form" title="4.4系统维护人员"></table:addRow><!-- 增加按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="ironfoinformationmaintain:ironfoinformationmaintain:edit">
			    <table:editRow url="${ctx}/ironfoinformationmaintain/ironfoinformationmaintain/form" title="4.4系统维护人员" id="contentTable"></table:editRow><!-- 编辑按钮 -->
			</shiro:hasPermission>
		 	<shiro:hasPermission name="ironfoinformationmaintain:ironfoinformationmaintain:del">
				<table:delRow url="${ctx}/ironfoinformationmaintain/ironfoinformationmaintain/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
			</shiro:hasPermission> 
		
			</div>
	</div>
	</div>
	
	<!-- 表格 -->
	<table id="contentTable" class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable">
		<thead>
			<tr>
				<th> <input type="checkbox" class="i-checks"></th>
				<!-- <th  class="sort-column remarks">备注信息</th>
				<th  class="sort-column doc_id">主表id</th> -->
				<th  class="sort-column maintain_ryzc">人员职称</th>
				<th  class="sort-column maintain_whcd">文化程度</th>
				<th  class="sort-column maintain_sxzy">所学专业</th>
				<th  class="sort-column maintain_xggznx">现岗工作年限</th>
				<th  class="sort-column maintain_rypz">人员配置</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="ironfoinformationmaintain">
			<tr>
				<td> <input type="checkbox" id="${ironfoinformationmaintain.id}" class="i-checks"></td>
				<td><a  href="#" onclick="openDialogView('查看4.4系统维护人员', '${ctx}/ironfoinformationmaintain/ironfoinformationmaintain/form?id=${ironfoinformationmaintain.id}','800px', '500px')">
					${ironfoinformationmaintain.ryzc}
				</a></td>
		
				<td>
					${ironfoinformationmaintain.whcd}
				</td>
				<td>
					${ironfoinformationmaintain.sxzy}
				</td>
				<td>
					${ironfoinformationmaintain.xggznx}
				</td>
				<td>
					${ironfoinformationmaintain.rypz}
				</td>
				<td>
					<shiro:hasPermission name="ironfoinformationmaintain:ironfoinformationmaintain:view">
						<a href="#" onclick="openDialogView('查看4.4系统维护人员', '${ctx}/ironfoinformationmaintain/ironfoinformationmaintain/form?id=${ironfoinformationmaintain.id}','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="ironfoinformationmaintain:ironfoinformationmaintain:edit">
    					<a href="#" onclick="openDialog('修改4.4系统维护人员', '${ctx}/ironfoinformationmaintain/ironfoinformationmaintain/form?id=${ironfoinformationmaintain.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>
    				</shiro:hasPermission>
    				<shiro:hasPermission name="ironfoinformationmaintain:ironfoinformationmaintain:del">
						<a href="${ctx}/ironfoinformationmaintain/ironfoinformationmaintain/delete?id=${ironfoinformationmaintain.id}" onclick="return confirmx('确认要删除该4.4系统维护人员吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
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