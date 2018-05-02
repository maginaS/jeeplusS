<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>2.2财务收支管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
	
		/* $(document).ready(function() {
		}); */
		
		
		
		
		
	</script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content">
	<div class="ibox">
	<div class="ibox-title">
		<h5>2.2财务收支列表 </h5>
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
	<form:form id="searchForm" modelAttribute="ironfofinance" action="${ctx}/ironfofinancereport/ironfofinance/" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<div class="form-group">
		 </div>	
		 
		 
		
		  	<%-- <td class="width-15 active"><label class="pull-right">用户</label></td>
		         <td class="width-35" >
		         <sys:treeselect id="duser" name="duser.id" value="${ironfofinance.duser.id}" 
		         labelName="duser.name" labelValue="${ironfofinance.duser.name}"
					title="用户" url="/sys/user/treeData" extId="${duser.id}" 
					cssClass="form-control m-s" allowClear="true"/></td> --%>
					
					<td class="width-35" >用户<sys:treeselect id="duser" name="duser.id" value="${ironfofinance.duser.id}" 
		         labelName="duser.name" labelValue="${ironfofinance.duser.name}"
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
			<shiro:hasPermission name="ironfofinancereport:ironfofinance:add">
				<table:addRow url="${ctx}/ironfofinancereport/ironfofinance/form" title="2.2财务收支"></table:addRow><!-- 增加按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="ironfofinancereport:ironfofinance:edit">
			    <table:editRow url="${ctx}/ironfofinancereport/ironfofinance/form" title="2.2财务收支" id="contentTable"></table:editRow><!-- 编辑按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="ironfofinancereport:ironfofinance:del">
				<table:delRow url="${ctx}/ironfofinancereport/ironfofinance/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="ironfofinancereport:ironfofinance:import">
				<table:importExcel url="${ctx}/ironfofinancereport/ironfofinance/import"></table:importExcel><!-- 导入按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="ironfofinancereport:ironfofinance:export">
	       		<table:exportExcel url="${ctx}/ironfofinancereport/ironfofinance/export"></table:exportExcel><!-- 导出按钮 -->
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
				<th  class="sort-column ylsr">医疗收入 （千元）</th>
				<th  class="sort-column ypsr">药品收入 （千元）</th>
				<th  class="sort-column sfbtsr">财政补助收入 （千元）</th>
				<th  class="sort-column sjbzsr">上级补助收入 （千元）</th>
				<th  class="sort-column qtsr">其它收入 （千元）</th>
				<th  class="sort-column zzc">总支出 （千元）</th>
				<th  class="sort-column ylzc">医疗支出 （千元）</th>
				<th  class="sort-column date">时间</th>
				<!-- <th  class="sort-column doc_id">主表id</th> -->
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="ironfofinance">
			<tr>
				<td> <input type="checkbox" id="${ironfofinance.id}" class="i-checks"></td>
			<!-- 	<td></td> -->
				<td>
					<a  href="#" onclick="openDialogView('查看2.2财务收支', '${ctx}/ironfofinancereport/ironfofinance/form?id=${ironfofinance.id}','800px', '500px')">
						${ironfofinance.ylsr}
					</a>
						
				</td>
				<td>
					${ironfofinance.ypsr}
				</td>
				<td>
					${ironfofinance.sfbtsr}
				</td>
				<td>
					${ironfofinance.sjbzsr}
				</td>
				<td>
					${ironfofinance.qtsr}
				</td>
				<td>
					${ironfofinance.zzc}
				</td>
				<td>
					${ironfofinance.ylzc}
				</td>
				<td>
					${ironfofinance.date}
				</td>
				<%-- <td>
					${ironfofinance.doc_id}
				</td> --%>
				<td>
					<shiro:hasPermission name="ironfofinancereport:ironfofinance:view">
						<a href="#" onclick="openDialogView('查看2.2财务收支', '${ctx}/ironfofinancereport/ironfofinance/form?id=${ironfofinance.id}','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="ironfofinancereport:ironfofinance:edit">
    					<a href="#" onclick="openDialog('修改2.2财务收支', '${ctx}/ironfofinancereport/ironfofinance/form?id=${ironfofinance.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>
    				</shiro:hasPermission>
    				<shiro:hasPermission name="ironfofinancereport:ironfofinance:del">
						<a href="${ctx}/ironfofinancereport/ironfofinance/delete?id=${ironfofinance.id}" onclick="return confirmx('确认要删除该2.2财务收支吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
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