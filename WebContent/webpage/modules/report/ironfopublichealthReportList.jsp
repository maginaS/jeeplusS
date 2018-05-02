<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>2.3基本公共卫生服务管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
	/* 	$(document).ready(function() {
		}); */
	</script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content">
	<div class="ibox">
	<div class="ibox-title">
		<h5>2.3基本公共卫生服务列表 </h5>
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
	<form:form id="searchForm" modelAttribute="ironfopublichealth" action="${ctx}/ironfopublichealthreport/ironfopublichealth/" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<div class="form-group">
		 </div>	
		 
		 <%-- <td class="width-15 active"><label class="pull-right">用户</label></td>
		         <td class="width-35" >
		         <sys:treeselect id="duser" name="duser.id" value="${ironfopublichealth.duser.id}" 
		         labelName="duser.name" labelValue="${ironfopublichealth.duser.name}"
					title="用户" url="/sys/user/treeData" extId="${duser.id}" 
					cssClass="form-control m-s" allowClear="true"/></td> --%>
					
					<td class="width-35" >用户<sys:treeselect id="duser" name="duser.id" value="${ironfopublichealth.duser.id}" 
		         labelName="duser.name" labelValue="${ironfopublichealth.duser.name}"
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
			<shiro:hasPermission name="ironfopublichealthreport:ironfopublichealth:add">
				<table:addRow url="${ctx}/ironfopublichealthreport/ironfopublichealth/form" title="2.3基本公共卫生服务"></table:addRow><!-- 增加按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="ironfopublichealthreport:ironfopublichealth:edit">
			    <table:editRow url="${ctx}/ironfopublichealthreport/ironfopublichealth/form" title="2.3基本公共卫生服务" id="contentTable"></table:editRow><!-- 编辑按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="ironfopublichealthreport:ironfopublichealth:del">
				<table:delRow url="${ctx}/ironfopublichealthreport/ironfopublichealth/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="ironfopublichealthreport:ironfopublichealth:import">
				<table:importExcel url="${ctx}/ironfopublichealthreport/ironfopublichealth/import"></table:importExcel><!-- 导入按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="ironfopublichealthreport:ironfopublichealth:export">
	       		<table:exportExcel url="${ctx}/ironfopublichealthreport/ironfopublichealth/export"></table:exportExcel><!-- 导出按钮 -->
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
				<!-- <th  class="sort-column id">用户信息</th> -->
				<th  class="sort-column nmfwczrks">年末服务(常住)人口数（人）</th>
				<th  class="sort-column qzldlsets">其中0-6岁儿童数（人）</th>
				<th  class="sort-column qzldssets">其中0-3岁儿童数（人）</th>
				<th  class="sort-column qzlswsysrks">其中65岁以上人口数（人）</th>
				<th  class="sort-column nmjmjkdaljjdrs">年末居民健康档案累计建档人数（人）</th>
				<th  class="sort-column qzgfhdzdars">其中规范化电子建档人数（人）</th>
				<th  class="sort-column nnjsjkjyrcs">年内接受健康教育人次数（人次）</th>
				<th  class="sort-column nnldlsetyfjzrcs">年内0-6岁儿童预防接种人次数（人次）</th>
				<th  class="sort-column nmldlsetjkglrs">年末0-6岁儿童健康管理人数（人次）</th>
				<th  class="sort-column nmycfjkglrs">年末孕产妇健康管理人数（人）</th>
				<th  class="sort-column nmlswsyslrjkglr">年末65岁以上老人健康管理人（人）</th>
				<th  class="sort-column nmgxygfglrs">年末高血压规范管理人数（人）</th>
				<th  class="sort-column nmtnbgfglrs">年末糖尿病规范管理人数（人）</th>
				<th  class="sort-column nmzxjszahzglrs">年末重性精神障碍患者管理人数（人）</th>
				<th  class="sort-column nmfjhhzglrs">年末肺结核患者管理人数（人）</th>
				<th  class="sort-column nncrbhtfggwssjbgls">年内传染病和突发公共卫生事件报告例数（例）</th>
				<th  class="sort-column nnwsjdxgxxbgls">年内卫生监督协管信息报告例数（例）</th>
				<th  class="sort-column nmldssetzyyjkglrs">年末0-3岁儿童中医药健康管理人数（人）</th>
				<th  class="sort-column nmlswyslrzyyjkglrs">年末65岁以上老人中医药健康管理人数（人）</th>
				<th  class="sort-column date">时间</th>
				<!-- <th  class="sort-column doc_id">主表id</th> -->
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="ironfopublichealth">
			<tr>
				<td> <input type="checkbox" id="${ironfopublichealth.id}" class="i-checks"></td>
				<td><a  href="#" onclick="openDialogView('查看2.3基本公共卫生服务', '${ctx}/ironfopublichealthreport/ironfopublichealth/form?id=${ironfopublichealth.id}','800px', '500px')">
					<%-- ${ironfopublichealth.id} --%>
				</a></td>
				<td>
					${ironfopublichealth.nmfwczrks}
				</td>
				<td>
					${ironfopublichealth.qzldlsets}
				</td>
				<td>
					${ironfopublichealth.qzldssets}
				</td>
				<td>
					${ironfopublichealth.qzlswsysrks}
				</td>
				<td>
					${ironfopublichealth.nmjmjkdaljjdrs}
				</td>
				<td>
					${ironfopublichealth.qzgfhdzdars}
				</td>
				<td>
					${ironfopublichealth.nnjsjkjyrcs}
				</td>
				<td>
					${ironfopublichealth.nnldlsetyfjzrcs}
				</td>
				<td>
					${ironfopublichealth.nmldlsetjkglrs}
				</td>
				<td>
					${ironfopublichealth.nmycfjkglrs}
				</td>
				<td>
					${ironfopublichealth.nmlswsyslrjkglr}
				</td>
				<td>
					${ironfopublichealth.nmgxygfglrs}
				</td>
				<td>
					${ironfopublichealth.nmtnbgfglrs}
				</td>
				<td>
					${ironfopublichealth.nmzxjszahzglrs}
				</td>
				<td>
					${ironfopublichealth.nmfjhhzglrs}
				</td>
				<td>
					${ironfopublichealth.nncrbhtfggwssjbgls}
				</td>
				<td>
					${ironfopublichealth.nnwsjdxgxxbgls}
				</td>
				<td>
					${ironfopublichealth.nmldssetzyyjkglrs}
				</td>
				<td>
					${ironfopublichealth.nmlswyslrzyyjkglrs}
				</td>
				<td>
					${fns:getDictLabel(ironfopublichealth.date, '', '')}
				</td>
			<%-- 	<td>
					${ironfopublichealth.doc_id}
				</td> --%>
				<td>
					<shiro:hasPermission name="ironfopublichealthreport:ironfopublichealth:view">
						<a href="#" onclick="openDialogView('查看2.3基本公共卫生服务', '${ctx}/ironfopublichealthreport/ironfopublichealth/form?id=${ironfopublichealth.id}','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="ironfopublichealthreport:ironfopublichealth:edit">
    					<a href="#" onclick="openDialog('修改2.3基本公共卫生服务', '${ctx}/ironfopublichealthreport/ironfopublichealth/form?id=${ironfopublichealth.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>
    				</shiro:hasPermission>
    				<shiro:hasPermission name="ironfopublichealthreport:ironfopublichealth:del">
						<a href="${ctx}/ironfopublichealthreport/ironfopublichealth/delete?id=${ironfopublichealth.id}" onclick="return confirmx('确认要删除该2.3基本公共卫生服务吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
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