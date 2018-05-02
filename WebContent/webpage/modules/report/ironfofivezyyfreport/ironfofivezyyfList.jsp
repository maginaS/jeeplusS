<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>5.4住院用房管理</title>
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
		<h5>5.4住院用房列表 </h5>
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
	<form:form id="searchForm" modelAttribute="ironfofivezyyf" action="${ctx}/ironfofivezyyfreport/ironfofivezyyf/" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<div class="form-group">
		 </div>	
		 <td class="width-35" >用户<sys:treeselect id="duser" name="duser.id" value="${ironfofivezyyf.duser.id}" 
		         labelName="duser.name" labelValue="${ironfofivezyyf.duser.name}"
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
			<%-- <shiro:hasPermission name="ironfofivezyyfreport:ironfofivezyyf:add">
				<table:addRow url="${ctx}/ironfofivezyyfreport/ironfofivezyyf/form" title="5.4住院用房"></table:addRow><!-- 增加按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="ironfofivezyyfreport:ironfofivezyyf:edit">
			    <table:editRow url="${ctx}/ironfofivezyyfreport/ironfofivezyyf/form" title="5.4住院用房" id="contentTable"></table:editRow><!-- 编辑按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="ironfofivezyyfreport:ironfofivezyyf:del">
				<table:delRow url="${ctx}/ironfofivezyyfreport/ironfofivezyyf/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="ironfofivezyyfreport:ironfofivezyyf:import">
				<table:importExcel url="${ctx}/ironfofivezyyfreport/ironfofivezyyf/import"></table:importExcel><!-- 导入按钮 -->
			</shiro:hasPermission> --%>
			<shiro:hasPermission name="ironfofivezyyfreport:ironfofivezyyf:export">
	       		<table:exportExcel url="${ctx}/ironfofivezyyfreport/ironfofivezyyf/export"></table:exportExcel><!-- 导出按钮 -->
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
				<th  class="sort-column gndyjzmj">功能单元建筑面积（m2）</th>
				<th  class="sort-column bf">病房</th>
				<th  class="sort-column hsz">护士站</th>
				<th  class="sort-column zlzbs">治疗准备室</th>
				<th  class="sort-column zls">治疗室</th>
				<th  class="sort-column qjs">抢救室</th>
				<th  class="sort-column yhbgs">医护办公室</th>
				<th  class="sort-column zybgs">住院办公室</th>
				<th  class="sort-column zbs">值班室</th>
				<th  class="sort-column ksj">开水间</th>
				<th  class="sort-column wsj">卫生间</th>
				<th  class="sort-column hxj">盥洗间</th>
				<th  class="sort-column lyj">淋浴间</th>
				<th  class="sort-column zzpcs">自助配餐室</th>
				<th  class="sort-column hds">活动室</th>
				<th  class="sort-column brct">病人餐厅</th>
				<th  class="sort-column qtqzm">其它（请注明</th>
				<!-- <th>操作</th> -->
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="ironfofivezyyf">
			<tr>
				<td> <input type="checkbox" id="${ironfofivezyyf.id}" class="i-checks"></td>
				<%-- <td><a  href="#" onclick="openDialogView('查看5.4住院用房', '${ctx}/ironfofivezyyfreport/ironfofivezyyf/form?id=${ironfofivezyyf.id}','800px', '500px')">
					${ironfofivezyyf.remarks}
				</a></td> --%>
				<%-- <td>
					${ironfofivezyyf.doc_id}
				</td> --%>
				<td>
					${ironfofivezyyf.gndyjzmj}
				</td>
				<td>
				<c:if test="${ironfofivezyyf.bf eq '1'}">是</c:if>
            		<c:if test="${ironfofivezyyf.bf eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${v eq '1'}">是</c:if>
            		<c:if test="${ironfofivezyyf.hsz eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofivezyyf.zlzbs eq '1'}">是</c:if>
            		<c:if test="${ironfofivezyyf.zlzbs eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofivezyyf.zls eq '1'}">是</c:if>
            		<c:if test="${ironfofivezyyf.zls eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofivezyyf.qjs eq '1'}">是</c:if>
            		<c:if test="${ironfofivezyyf.qjs eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofivezyyf.yhbgs eq '1'}">是</c:if>
            		<c:if test="${ironfofivezyyf.yhbgs eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofivezyyf.zybgs eq '1'}">是</c:if>
            		<c:if test="${ironfofivezyyf.zybgs eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofivezyyf.zbs eq '1'}">是</c:if>
            		<c:if test="${ironfofivezyyf.zbs eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofivezyyf.ksj eq '1'}">是</c:if>
            		<c:if test="${ironfofivezyyf.ksj eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofivezyyf.wsj eq '1'}">是</c:if>
            		<c:if test="${ironfofivezyyf.wsj eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofivezyyf.hxj eq '1'}">是</c:if>
            		<c:if test="${ironfofivezyyf.hxj eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofivezyyf.lyj eq '1'}">是</c:if>
            		<c:if test="${ironfofivezyyf.lyj eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofivezyyf.zzpcs eq '1'}">是</c:if>
            		<c:if test="${ironfofivezyyf.zzpcs eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofivezyyf.hds eq '1'}">是</c:if>
            		<c:if test="${ironfofivezyyf.hds eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofivezyyf.brct eq '1'}">是</c:if>
            		<c:if test="${ironfofivezyyf.brct eq '0'}">否</c:if>
					
				</td>
				<td>
					${ironfofivezyyf.qtqzm}
				</td>
				<%-- <td>
					<shiro:hasPermission name="ironfofivezyyfreport:ironfofivezyyf:view">
						<a href="#" onclick="openDialogView('查看5.4住院用房', '${ctx}/ironfofivezyyfreport/ironfofivezyyf/form?id=${ironfofivezyyf.id}','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="ironfofivezyyfreport:ironfofivezyyf:edit">
    					<a href="#" onclick="openDialog('修改5.4住院用房', '${ctx}/ironfofivezyyfreport/ironfofivezyyf/form?id=${ironfofivezyyf.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>
    				</shiro:hasPermission>
    				<shiro:hasPermission name="ironfofivezyyfreport:ironfofivezyyf:del">
						<a href="${ctx}/ironfofivezyyfreport/ironfofivezyyf/delete?id=${ironfofivezyyf.id}" onclick="return confirmx('确认要删除该5.4住院用房吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
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