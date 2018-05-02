<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>4.3信息化系统使用体验管理</title>
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
		<h5>4.3信息化系统使用体验列表 </h5>
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
	<form:form id="searchForm" modelAttribute="ironfoinformationexperience" action="${ctx}/ironfoinforexperiencereport/ironfoinformationexperience/" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<div class="form-group">
		 </div>	
		 <td class="width-35" >用户<sys:treeselect id="duser" name="duser.id" value="${ironfoinformationexperience.duser.id}" 
		         labelName="duser.name" labelValue="${ironfoinformationexperience.duser.name}"
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
			<%-- <shiro:hasPermission name="ironfoinforexperiencereport:ironfoinformationexperience:add">
				<table:addRow url="${ctx}/ironfoinforexperiencereport/ironfoinformationexperience/form" title="4.3信息化系统使用体验"></table:addRow><!-- 增加按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="ironfoinforexperiencereport:ironfoinformationexperience:edit">
			    <table:editRow url="${ctx}/ironfoinforexperiencereport/ironfoinformationexperience/form" title="4.3信息化系统使用体验" id="contentTable"></table:editRow><!-- 编辑按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="ironfoinforexperiencereport:ironfoinformationexperience:del">
				<table:delRow url="${ctx}/ironfoinforexperiencereport/ironfoinformationexperience/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="ironfoinforexperiencereport:ironfoinformationexperience:import">
				<table:importExcel url="${ctx}/ironfoinforexperiencereport/ironfoinformationexperience/import"></table:importExcel><!-- 导入按钮 -->
			</shiro:hasPermission> --%>
			<shiro:hasPermission name="ironfoinforexperiencereport:ironfoinformationexperience:export">
	       		<table:exportExcel url="${ctx}/ironfoinforexperiencereport/ironfoinformationexperience/export"></table:exportExcel><!-- 导出按钮 -->
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
				<th  class="sort-column experience_bjxty">便捷性体验</th>
				<th  class="sort-column experience_gnxty">功能性体验</th>
				<th  class="sort-column experience_ggxty">观感性体验</th>
				<!-- <th>操作</th> -->
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="ironfoinformationexperience">
			<tr>
				<td> <input type="checkbox" id="${ironfoinformationexperience.id}" class="i-checks"></td>
				<%-- <td><a  href="#" onclick="openDialogView('查看4.3信息化系统使用体验', '${ctx}/ironfoinforexperiencereport/ironfoinformationexperience/form?id=${ironfoinformationexperience.id}','800px', '500px')">
					${ironfoinformationexperience.remarks}
				</a></td> --%>
				<%-- <td>
					${ironfoinformationexperience.doc_id}
				</td> --%>
				<td>
				<c:choose>
						<c:when test="${ironfoinformationexperience.bjxty eq '1'}">良好</c:when>
						<c:when test="${ironfoinformationexperience.bjxty eq '2'}">好</c:when>
						<c:when test="${ironfoinformationexperience.bjxty eq '3'}">一般</c:when>
						<c:when test="${ironfoinformationexperience.bjxty eq '4'}">差</c:when>
						<c:when test="${ironfoinformationexperience.bjxty eq '5'}">很差</c:when>
						<c:otherwise></c:otherwise>
					</c:choose>
					
				</td>
				<td>
				<c:choose>
						<c:when test="${ironfoinformationexperience.gnxty eq '1'}">良好</c:when>
						<c:when test="${ironfoinformationexperience.gnxty eq '2'}">好</c:when>
						<c:when test="${ironfoinformationexperience.gnxty eq '3'}">一般</c:when>
						<c:when test="${ironfoinformationexperience.gnxty eq '4'}">差</c:when>
						<c:when test="${ironfoinformationexperience.gnxty eq '5'}">很差</c:when>
						<c:otherwise></c:otherwise>
					</c:choose>
					
				</td>
				<td>
				
				<c:choose>
						<c:when test="${ironfoinformationexperience.ggxty eq '1'}">良好</c:when>
						<c:when test="${ironfoinformationexperience.ggxty eq '2'}">好</c:when>
						<c:when test="${ironfoinformationexperience.ggxty eq '3'}">一般</c:when>
						<c:when test="${ironfoinformationexperience.ggxty eq '4'}">差</c:when>
						<c:when test="${ironfoinformationexperience.ggxty eq '5'}">很差</c:when>
						<c:otherwise></c:otherwise>
					</c:choose>
					
				</td>
				<%-- <td>
					<shiro:hasPermission name="ironfoinforexperiencereport:ironfoinformationexperience:view">
						<a href="#" onclick="openDialogView('查看4.3信息化系统使用体验', '${ctx}/ironfoinforexperiencereport/ironfoinformationexperience/form?id=${ironfoinformationexperience.id}','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="ironfoinforexperiencereport:ironfoinformationexperience:edit">
    					<a href="#" onclick="openDialog('修改4.3信息化系统使用体验', '${ctx}/ironfoinforexperiencereport/ironfoinformationexperience/form?id=${ironfoinformationexperience.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>
    				</shiro:hasPermission>
    				<shiro:hasPermission name="ironfoinforexperiencereport:ironfoinformationexperience:del">
						<a href="${ctx}/ironfoinforexperiencereport/ironfoinformationexperience/delete?id=${ironfoinformationexperience.id}" onclick="return confirmx('确认要删除该4.3信息化系统使用体验吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
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