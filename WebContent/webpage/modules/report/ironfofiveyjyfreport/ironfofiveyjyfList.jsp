<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>5.3医技用房管理</title>
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
		<h5>5.3医技用房列表 </h5>
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
	<form:form id="searchForm" modelAttribute="ironfofiveyjyf" action="${ctx}/ironfofiveyjyfreport/ironfofiveyjyf/" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<div class="form-group">
		 </div>
		 <td class="width-35" >用户<sys:treeselect id="duser" name="duser.id" value="${ironfofiveyjyf.duser.id}" 
		         labelName="duser.name" labelValue="${ironfofiveyjyf.duser.name}"
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
			<%-- <shiro:hasPermission name="ironfofiveyjyfreport:ironfofiveyjyf:add">
				<table:addRow url="${ctx}/ironfofiveyjyfreport/ironfofiveyjyf/form" title="5.3医技用房"></table:addRow><!-- 增加按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="ironfofiveyjyfreport:ironfofiveyjyf:edit">
			    <table:editRow url="${ctx}/ironfofiveyjyfreport/ironfofiveyjyf/form" title="5.3医技用房" id="contentTable"></table:editRow><!-- 编辑按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="ironfofiveyjyfreport:ironfofiveyjyf:del">
				<table:delRow url="${ctx}/ironfofiveyjyfreport/ironfofiveyjyf/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="ironfofiveyjyfreport:ironfofiveyjyf:import">
				<table:importExcel url="${ctx}/ironfofiveyjyfreport/ironfofiveyjyf/import"></table:importExcel><!-- 导入按钮 -->
			</shiro:hasPermission> --%>
			<shiro:hasPermission name="ironfofiveyjyfreport:ironfofiveyjyf:export">
	       		<table:exportExcel url="${ctx}/ironfofiveyjyfreport/ironfofiveyjyf/export"></table:exportExcel><!-- 导出按钮 -->
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
				<th  class="sort-column gndyjzmj">功能单元建筑面积</th>
				<th  class="sort-column mzxyfyjkyf">门诊西药房-药剂科用房</th>
				<th  class="sort-column mzzyfyjkyf">门诊中药房-药剂科用房</th>
				<th  class="sort-column jzyfyjkyf">急诊药房-药剂科用房</th>
				<th  class="sort-column tsyfyjkyf">特殊药房-药剂科用房</th>
				<th  class="sort-column jyfyjkyf">煎药房-药剂科用房</th>
				<th  class="sort-column ypkyjkyf">药品库-药剂科用房</th>
				<th  class="sort-column cxsjykyf">采血室-检验科用房</th>
				<th  class="sort-column hysjykyf">化验室-检验科用房</th>
				<th  class="sort-column xgjspsfskyf">X光机摄片室-放射科用房</th>
				<th  class="sort-column xgjkzsfskyf">X光机控制室-放射科用房</th>
				<th  class="sort-column ctspsfskyf">CT摄片室-放射科用房</th>
				<th  class="sort-column ctkzsfskyf">CT控制室-放射科用房</th>
				<th  class="sort-column dpsfskyf">读片室-放射科用房</th>
				<th  class="sort-column xdts">心电图室</th>
				<th  class="sort-column css">超声室</th>
				<th  class="sort-column xksxkyf">血库-输血科用房</th>
				<th  class="sort-column pxssxkyf">配血室-输血科用房</th>
				<th  class="sort-column qwqxdgys">去污区-消毒供应室</th>
				<th  class="sort-column jcbzjmjqxdgys">检查包装及灭菌区-消毒供应室</th>
				<th  class="sort-column wjwpcfqxdgys">无菌物品存放区-消毒供应室</th>
				<th  class="sort-column sssssb">手术室-手术部</th>
				<th  class="sort-column cfssb">产房-手术部</th>
				<th  class="sort-column zbsssb">准备室-手术部</th>
				<th  class="sort-column dcsssb">待产室-手术部</th>
				<th  class="sort-column gysssb">更衣间-手术部</th>
				<th  class="sort-column xsjssb">洗手间-手术部</th>
				<th  class="sort-column shsxsssb">术后苏醒室-手术部</th>
				<th  class="sort-column qtqzm">其它（请注明）</th>
				<!-- <th>操作</th> -->
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="ironfofiveyjyf">
			<tr>
				<td> <input type="checkbox" id="${ironfofiveyjyf.id}" class="i-checks"></td>
				<%-- <td><a  href="#" onclick="openDialogView('查看5.3医技用房', '${ctx}/ironfofiveyjyfreport/ironfofiveyjyf/form?id=${ironfofiveyjyf.id}','800px', '500px')">
					${ironfofiveyjyf.remarks}
				</a></td> --%>
				<%-- <td>
					${ironfofiveyjyf.doc_id}
				</td> --%>
				<td>
					${ironfofiveyjyf.gndyjzmj}
				</td>
				<td>
					
					${ironfofiveyjyf.mzxyfyjkyfName}
				</td>
				<td>
					<c:if test="${ironfofiveyjyf.mzzyfyjkyf eq '1'}">是</c:if>
            		<c:if test="${ironfofiveyjyf.mzzyfyjkyf eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveyjyf.jzyfyjkyf eq '1'}">是</c:if>
            		<c:if test="${ironfofiveyjyf.jzyfyjkyf eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveyjyf.tsyfyjkyf eq '1'}">是</c:if>
            		<c:if test="${ironfofiveyjyf.tsyfyjkyf eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveyjyf.jyfyjkyf eq '1'}">是</c:if>
            		<c:if test="${ironfofiveyjyf.jyfyjkyf eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveyjyf.ypkyjkyf eq '1'}">是</c:if>
            		<c:if test="${ironfofiveyjyf.ypkyjkyf eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveyjyf.cxsjykyf eq '1'}">是</c:if>
            		<c:if test="${ironfofiveyjyf.cxsjykyf eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveyjyf.hysjykyf eq '1'}">是</c:if>
            		<c:if test="${ironfofiveyjyf.hysjykyf eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveyjyf.xgjspsfskyf eq '1'}">是</c:if>
            		<c:if test="${ironfofiveyjyf.xgjspsfskyf eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveyjyf.xgjkzsfskyf eq '1'}">是</c:if>
            		<c:if test="${ironfofiveyjyf.xgjkzsfskyf eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveyjyf.ctspsfskyf eq '1'}">是</c:if>
            		<c:if test="${ironfofiveyjyf.ctspsfskyf eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveyjyf.ctkzsfskyf eq '1'}">是</c:if>
            		<c:if test="${ironfofiveyjyf.ctkzsfskyf eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveyjyf.dpsfskyf eq '1'}">是</c:if>
            		<c:if test="${ironfofiveyjyf.dpsfskyf eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveyjyf.xdts eq '1'}">是</c:if>
            		<c:if test="${ironfofiveyjyf.xdts eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveyjyf.css eq '1'}">是</c:if>
            		<c:if test="${ironfofiveyjyf.css eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveyjyf.xksxkyf eq '1'}">是</c:if>
            		<c:if test="${ironfofiveyjyf.xksxkyf eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveyjyf.pxssxkyf eq '1'}">是</c:if>
            		<c:if test="${ironfofiveyjyf.pxssxkyf eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveyjyf.qwqxdgys eq '1'}">是</c:if>
            		<c:if test="${ironfofiveyjyf.qwqxdgys eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveyjyf.jcbzjmjqxdgys eq '1'}">是</c:if>
            		<c:if test="${ironfofiveyjyf.jcbzjmjqxdgys eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveyjyf.wjwpcfqxdgys eq '1'}">是</c:if>
            		<c:if test="${ironfofiveyjyf.wjwpcfqxdgys eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveyjyf.sssssb eq '1'}">是</c:if>
            		<c:if test="${ironfofiveyjyf.sssssb eq '0'}">否</c:if>
					
				</td>
				<td><c:if test="${ironfofiveyjyf.cfssb eq '1'}">是</c:if>
            		<c:if test="${ironfofiveyjyf.cfssb eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveyjyf.zbsssb eq '1'}">是</c:if>
            		<c:if test="${ironfofiveyjyf.zbsssb eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveyjyf.dcsssb eq '1'}">是</c:if>
            		<c:if test="${ironfofiveyjyf.dcsssb eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveyjyf.gysssb eq '1'}">是</c:if>
            		<c:if test="${ironfofiveyjyf.gysssb eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveyjyf.xsjssb eq '1'}">是</c:if>
            		<c:if test="${ironfofiveyjyf.xsjssb eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveyjyf.shsxsssb eq '1'}">是</c:if>
            		<c:if test="${ironfofiveyjyf.shsxsssb eq '0'}">否</c:if>
					
				</td>
				<td>
					${ironfofiveyjyf.qtqzm}
				</td>
				<%-- <td>
					<shiro:hasPermission name="ironfofiveyjyfreport:ironfofiveyjyf:view">
						<a href="#" onclick="openDialogView('查看5.3医技用房', '${ctx}/ironfofiveyjyfreport/ironfofiveyjyf/form?id=${ironfofiveyjyf.id}','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="ironfofiveyjyfreport:ironfofiveyjyf:edit">
    					<a href="#" onclick="openDialog('修改5.3医技用房', '${ctx}/ironfofiveyjyfreport/ironfofiveyjyf/form?id=${ironfofiveyjyf.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>
    				</shiro:hasPermission>
    				<shiro:hasPermission name="ironfofiveyjyfreport:ironfofiveyjyf:del">
						<a href="${ctx}/ironfofiveyjyfreport/ironfofiveyjyf/delete?id=${ironfofiveyjyf.id}" onclick="return confirmx('确认要删除该5.3医技用房吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
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