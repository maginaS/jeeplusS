<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>放射科、超声科、心电图科管理</title>
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
		<h5>放射科、超声科、心电图科列表 </h5>
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
	<form:form id="searchForm" modelAttribute="ironfoyjbylsbpzfskcskxdtk" action="${ctx}/ironfoyjbylsbpzfskcskreport/ironfoyjbylsbpzfskcskxdtk/" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<div class="form-group">
		 </div>
		
		         <td class="width-35" >用户<sys:treeselect id="duser" name="duser.id" value="${ironfoyjbylsbpzfskcskxdtk.duser.id}" 
		         labelName="duser.name" labelValue="${ironfoyjbylsbpzfskcskxdtk.duser.name}"
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
			<%-- <shiro:hasPermission name="ironfoyjbylsbpzfskcskreport:ironfoyjbylsbpzfskcskxdtk:add">
				<table:addRow url="${ctx}/ironfoyjbylsbpzfskcskreport/ironfoyjbylsbpzfskcskxdtk/form" title="放射科、超声科、心电图科"></table:addRow><!-- 增加按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="ironfoyjbylsbpzfskcskreport:ironfoyjbylsbpzfskcskxdtk:edit">
			    <table:editRow url="${ctx}/ironfoyjbylsbpzfskcskreport/ironfoyjbylsbpzfskcskxdtk/form" title="放射科、超声科、心电图科" id="contentTable"></table:editRow><!-- 编辑按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="ironfoyjbylsbpzfskcskreport:ironfoyjbylsbpzfskcskxdtk:del">
				<table:delRow url="${ctx}/ironfoyjbylsbpzfskcskreport/ironfoyjbylsbpzfskcskxdtk/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="ironfoyjbylsbpzfskcskreport:ironfoyjbylsbpzfskcskxdtk:import">
				<table:importExcel url="${ctx}/ironfoyjbylsbpzfskcskreport/ironfoyjbylsbpzfskcskxdtk/import"></table:importExcel><!-- 导入按钮 -->
			</shiro:hasPermission> --%>
			<shiro:hasPermission name="ironfoyjbylsbpzfskcskreport:ironfoyjbylsbpzfskcskxdtk:export">
	       		<table:exportExcel url="${ctx}/ironfoyjbylsbpzfskcskreport/ironfoyjbylsbpzfskcskxdtk/export"></table:exportExcel><!-- 导出按钮 -->
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
				
				<th  class="sort-column doc_id">主表id</th> -->
				<!-- <th  class="sort-column doc_id">用户</th> -->
				<th  class="sort-column fskcskxdtk_sbmc">设备名称</th>
				<th  class="sort-column fskcskxdtk_pp">品牌</th>
				<th  class="sort-column fskcskxdtk_xh">型号</th>
				<th  class="sort-column fskcskxdtk_sl">数量（台/个）</th>
				<th  class="sort-column fskcskxdtk_sbjg">设备价格（元）</th>
				<th  class="sort-column fskcskxdtk_trsynf">投入使用年份</th>
				<!-- <th  class="sort-column remarks">备注信息</th> -->
				<!-- <th>操作</th> -->
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="ironfoyjbylsbpzfskcskxdtk">
			<tr>
				<td> <input type="checkbox" id="${ironfoyjbylsbpzfskcskxdtk.id}" class="i-checks"></td>
				<%-- 
				<td>
					${ironfoyjbylsbpzfskcskxdtk.doc_id}
				</td> --%>
				<%-- <td>
					${ironfoyjbylsbpzfskcskxdtk.duser.name}
				</td> --%>
				<td>
					${ironfoyjbylsbpzfskcskxdtk.sbmc}
				</td>
				<td>
					${ironfoyjbylsbpzfskcskxdtk.pp}
				</td>
				<td>
					${ironfoyjbylsbpzfskcskxdtk.xh}
				</td>
				<td>
					${ironfoyjbylsbpzfskcskxdtk.sl}
				</td>
				<td>
					${ironfoyjbylsbpzfskcskxdtk.sbjg}
				</td>
				<td>
					${ironfoyjbylsbpzfskcskxdtk.trsynf}
				</td>
				<%-- <td><a  href="#" onclick="openDialogView('查看放射科、超声科、心电图科', '${ctx}/ironfoyjbylsbpzfskcskreport/ironfoyjbylsbpzfskcskxdtk/form?id=${ironfoyjbylsbpzfskcskxdtk.id}','800px', '500px')">
					${ironfoyjbylsbpzfskcskxdtk.remarks}
				</a></td> --%>
				<%-- <td>
					<shiro:hasPermission name="ironfoyjbylsbpzfskcskreport:ironfoyjbylsbpzfskcskxdtk:view">
						<a href="#" onclick="openDialogView('查看放射科、超声科、心电图科', '${ctx}/ironfoyjbylsbpzfskcskreport/ironfoyjbylsbpzfskcskxdtk/form?id=${ironfoyjbylsbpzfskcskxdtk.id}','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="ironfoyjbylsbpzfskcskreport:ironfoyjbylsbpzfskcskxdtk:edit">
    					<a href="#" onclick="openDialog('修改放射科、超声科、心电图科', '${ctx}/ironfoyjbylsbpzfskcskreport/ironfoyjbylsbpzfskcskxdtk/form?id=${ironfoyjbylsbpzfskcskxdtk.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>
    				</shiro:hasPermission>
    				<shiro:hasPermission name="ironfoyjbylsbpzfskcskreport:ironfoyjbylsbpzfskcskxdtk:del">
						<a href="${ctx}/ironfoyjbylsbpzfskcskreport/ironfoyjbylsbpzfskcskxdtk/delete?id=${ironfoyjbylsbpzfskcskxdtk.id}" onclick="return confirmx('确认要删除该放射科、超声科、心电图科吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
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