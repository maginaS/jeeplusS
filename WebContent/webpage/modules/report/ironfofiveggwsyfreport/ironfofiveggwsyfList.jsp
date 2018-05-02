<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>5.5公共卫生用房管理</title>
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
		<h5>5.5公共卫生用房列表 </h5>
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
	<form:form id="searchForm" modelAttribute="ironfofiveggwsyf" action="${ctx}/ironfofiveggwsyfreport/ironfofiveggwsyf/" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<div class="form-group">
		 </div>
		 	<td class="width-35" >用户<sys:treeselect id="duser" name="duser.id" value="${ironfofiveggwsyf.duser.id}" 
		         labelName="duser.name" labelValue="${ironfofiveggwsyf.duser.name}"
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
			<%-- <shiro:hasPermission name="ironfofiveggwsyfreport:ironfofiveggwsyf:add">
				<table:addRow url="${ctx}/ironfofiveggwsyfreport/ironfofiveggwsyf/form" title="5.5公共卫生用房"></table:addRow><!-- 增加按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="ironfofiveggwsyfreport:ironfofiveggwsyf:edit">
			    <table:editRow url="${ctx}/ironfofiveggwsyfreport/ironfofiveggwsyf/form" title="5.5公共卫生用房" id="contentTable"></table:editRow><!-- 编辑按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="ironfofiveggwsyfreport:ironfofiveggwsyf:del">
				<table:delRow url="${ctx}/ironfofiveggwsyfreport/ironfofiveggwsyf/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="ironfofiveggwsyfreport:ironfofiveggwsyf:import">
				<table:importExcel url="${ctx}/ironfofiveggwsyfreport/ironfofiveggwsyf/import"></table:importExcel><!-- 导入按钮 -->
			</shiro:hasPermission> --%>
			<shiro:hasPermission name="ironfofiveggwsyfreport:ironfofiveggwsyf:export">
	       		<table:exportExcel url="${ctx}/ironfofiveggwsyfreport/ironfofiveggwsyf/export"></table:exportExcel><!-- 导出按钮 -->
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
				<th  class="sort-column gndyjzmj">功能单元建筑面积（m2）</th>
				<th  class="sort-column jkdas">健康档案室</th>
				<th  class="sort-column jkjys">健康教育室</th>
				<th  class="sort-column yjqjzdt">预检区-接种大厅</th>
				<th  class="sort-column hzqjzdt">候种区-接种大厅</th>
				<th  class="sort-column jzqjzdt">接种区-接种大厅</th>
				<th  class="sort-column lnqjzdt">冷凝区-接种大厅</th>
				<th  class="sort-column fnbjsjzdt">妇女保健室-接种大厅</th>
				<th  class="sort-column etbjsjzdt">儿童保健室-接种大厅</th>
				<th  class="sort-column lnrbjsjzdt">老年人保健室-接种大厅</th>
				<th  class="sort-column ybjcqtjzx">一般检查区-体检中心</th>
				<th  class="sort-column kqjcqtjzx">口腔检查区-体检中心</th>
				<th  class="sort-column tljcqtjzx">听力检查区-体检中心</th>
				<th  class="sort-column sljcqtjzx">视力检查区-体检中心</th>
				<th  class="sort-column zljcqtjzx">智力检查区-体检中心</th>
				<th  class="sort-column nwkjcstjzx">男外科检查室-体检中心</th>
				<th  class="sort-column nwkjcstjzx">女外科检查室-体检中心</th>
				<th  class="sort-column qtqzm">其它（请注明）</th>
				<!-- <th  class="sort-column doc_id">主表id</th> -->
				<!-- <th>操作</th> -->
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="ironfofiveggwsyf">
			<tr>
				<td> <input type="checkbox" id="${ironfofiveggwsyf.id}" class="i-checks"></td>
				<%-- <td><a  href="#" onclick="openDialogView('查看5.5公共卫生用房', '${ctx}/ironfofiveggwsyfreport/ironfofiveggwsyf/form?id=${ironfofiveggwsyf.id}','800px', '500px')">
					${ironfofiveggwsyf.remarks}
				</a></td> --%>
				<td>
				
					${ironfofiveggwsyf.gndyjzmj}
				</td>
				<td>
				<c:if test="${ironfofiveggwsyf.jkdas eq '1'}">是</c:if>
            		<c:if test="${ironfofiveggwsyf.jkdas eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveggwsyf.jkjys eq '1'}">是</c:if>
            		<c:if test="${ironfofiveggwsyf.jkjys eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveggwsyf.yjqjzdt eq '1'}">是</c:if>
            		<c:if test="${ironfofiveggwsyf.yjqjzdt eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveggwsyf.hzqjzdt eq '1'}">是</c:if>
            		<c:if test="${ironfofiveggwsyf.hzqjzdt eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveggwsyf.jzqjzdt eq '1'}">是</c:if>
            		<c:if test="${ironfofiveggwsyf.jzqjzdt eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveggwsyf.lnqjzdt eq '1'}">是</c:if>
            		<c:if test="${ironfofiveggwsyf.lnqjzdt eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveggwsyf.fnbjsjzdt eq '1'}">是</c:if>
            		<c:if test="${ironfofiveggwsyf.fnbjsjzdt eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveggwsyf.etbjsjzdt eq '1'}">是</c:if>
            		<c:if test="${ironfofiveggwsyf.etbjsjzdt eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveggwsyf.lnrbjsjzdt eq '1'}">是</c:if>
            		<c:if test="${ironfofiveggwsyf.lnrbjsjzdt eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveggwsyf.ybjcqtjzx eq '1'}">是</c:if>
            		<c:if test="${ironfofiveggwsyf.ybjcqtjzx eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveggwsyf.kqjcqtjzx eq '1'}">是</c:if>
            		<c:if test="${ironfofiveggwsyf.kqjcqtjzx eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveggwsyf.tljcqtjzx eq '1'}">是</c:if>
            		<c:if test="${ironfofiveggwsyf.tljcqtjzx eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveggwsyf.sljcqtjzx eq '1'}">是</c:if>
            		<c:if test="${ironfofiveggwsyf.sljcqtjzx eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveggwsyf.zljcqtjzx eq '1'}">是</c:if>
            		<c:if test="${ironfofiveggwsyf.zljcqtjzx eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveggwsyf.nanwkjcstjzx eq '1'}">是</c:if>
            		<c:if test="${ironfofiveggwsyf.nanwkjcstjzx eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveggwsyf.nvwkjcstjzx eq '1'}">是</c:if>
            		<c:if test="${ironfofiveggwsyf.nvwkjcstjzx eq '0'}">否</c:if>
					
				</td>
				<td>
					${ironfofiveggwsyf.qtqzm}
				</td>
				<%-- <td>
					${ironfofiveggwsyf.doc_id}
				</td>
				<td>
					<shiro:hasPermission name="ironfofiveggwsyfreport:ironfofiveggwsyf:view">
						<a href="#" onclick="openDialogView('查看5.5公共卫生用房', '${ctx}/ironfofiveggwsyfreport/ironfofiveggwsyf/form?id=${ironfofiveggwsyf.id}','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="ironfofiveggwsyfreport:ironfofiveggwsyf:edit">
    					<a href="#" onclick="openDialog('修改5.5公共卫生用房', '${ctx}/ironfofiveggwsyfreport/ironfofiveggwsyf/form?id=${ironfofiveggwsyf.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>
    				</shiro:hasPermission>
    				<shiro:hasPermission name="ironfofiveggwsyfreport:ironfofiveggwsyf:del">
						<a href="${ctx}/ironfofiveggwsyfreport/ironfofiveggwsyf/delete?id=${ironfofiveggwsyf.id}" onclick="return confirmx('确认要删除该5.5公共卫生用房吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
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