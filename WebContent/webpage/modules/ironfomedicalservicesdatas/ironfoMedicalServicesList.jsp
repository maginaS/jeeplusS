<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>2.1年度医疗服务量管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		
		
		
	

		/* function searchOrQuery() {

			var userId = document.getElementById("loginId").value;
			$.ajax({
						url : "${ctx}/ironfomedicalservicesdatas/ironfoMedicalServices",
						data : {
							userId : userId
						},
						type : "post",
						success : function(data) {
							//console.log("---------data----------->"+data);
							alert("11111111111");
						}
					});
		} */
	</script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content">
	<div class="ibox">
	<div class="ibox-title">
		<h5>2.1年度医疗服务量列表 </h5>
		
	</div>
    
    <div class="ibox-content">
	<sys:message content="${message}"/>
	
	<!--查询条件-->
	<div class="row">
	<div class="col-sm-12">
	<form:form id="searchForm" modelAttribute="ironfoMedicalServices" action="${ctx}/ironfomedicalservicesdatas/ironfoMedicalServices/" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		
		
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<div class="form-group">
		 </div>	
		<!-- <div id="select">
		
		</div> -->
		<td class="width-35" >用户<sys:treeselect id="duser" name="duser.id" value="${ironfoMedicalServices.duser.id}" 
		         labelName="duser.name" labelValue="${ironfoMedicalServices.duser.name}"
					title="用户" url="/sys/user/treeData" extId="${duser.id}" 
					cssClass="form-control m-s" allowClear="false"/></td>
		        
		 </div>	
				
	</form:form>
	<br/>
	</div>
	</div>
	
	<!-- 工具栏 -->
	<div class="row">
	<div class="col-sm-12">
		<div class="pull-left">
			
			<%-- <shiro:hasPermission name="ironfomedicalservicesdatas:ironfoMedicalServices:import">
				<table:importExcel url="${ctx}/ironfomedicalservicesdatas/ironfoMedicalServices/import"></table:importExcel><!-- 导入按钮 -->
			</shiro:hasPermission> --%>
			<shiro:hasPermission name="ironfomedicalservicesdatas:ironfoMedicalServices:export">
	       		<table:exportExcel url="${ctx}/ironfomedicalservicesdatas/ironfoMedicalServices/export"></table:exportExcel><!-- 导出按钮 -->
	       	</shiro:hasPermission>
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
				<!-- <th  class="sort-column remarks">备注信息</th>
				<th  class="sort-column doc_id">基本资料及医院情况表的id</th> -->
				<!-- <th  class="sort-column date">用户</th> -->
				<th  class="sort-column date">时间</th>
				<th  class="sort-column bzcw">编制床位（张）</th>
				<th  class="sort-column sycw">实有床位（张）</th>
				<th  class="sort-column sjkfzcrs">实际开放总床日数（日）</th>
				<th  class="sort-column sjzyzcrs">实际占用总床日数（日）</th>
				<th  class="sort-column gccs">观察床数（床）</th>
				<th  class="sort-column zzlrcs">总诊疗人次数（人次）</th>
				<th  class="sort-column mzrcs">门诊人次数（人次）</th>
				<th  class="sort-column jzrcs">急诊人次数（人次）</th>
				<th  class="sort-column qzswrs">其中死亡人数（人）</th>
				<th  class="sort-column cyrs">出院人数（人）</th>
				<th  class="sort-column sjyyxxzzrcs">上级医院向下转诊人次数（人次）</th>
				<th  class="sort-column xsjyyzzrcs">向上级医院转诊人次数（人次）</th>
				<!-- <th>操作</th> -->
			</tr>
		</thead>
		<tbody>
				
		<c:forEach items="${page.list}" var="ironfoMedicalServices">
			<tr>
				<%-- <td><input type="text" id="" value="${page.list }" class="i-checks"></td> --%>
				<td> <input type="checkbox" id="${ironfoMedicalServices.id}" class="i-checks"></td>
				<%-- <td>
					${ironfoMedicalServices.date}
				</td> --%>
				<td>
					${ironfoMedicalServices.date}
				</td>
				<td>
					${ironfoMedicalServices.bzcw}
				</td>
				<td>
					${ironfoMedicalServices.sycw}
				</td>
				<td>
					${ironfoMedicalServices.sjkfzcrs}
				</td>
				<td>
					${ironfoMedicalServices.sjzyzcrs}
				</td>
				<td>
					${ironfoMedicalServices.gccs}
				</td>
				<td>
					${ironfoMedicalServices.zzlrcs}
				</td>
				<td>
					${ironfoMedicalServices.mzrcs}
				</td>
				<td>
					${ironfoMedicalServices.jzrcs}
				</td>
				<td>
					${ironfoMedicalServices.qzswrs}
				</td>
				<td>
					${ironfoMedicalServices.cyrs}
				</td>
				<td>
					${ironfoMedicalServices.sjyyxxzzrcs}
				</td>
				<td>
					${ironfoMedicalServices.xsjyyzzrcs}
				</td>
				<%-- <td>
					<shiro:hasPermission name="ironfomedicalservicesdatas:ironfoMedicalServices:view">
						<a href="#" onclick="openDialogView('查看2.1年度医疗服务量', '${ctx}/ironfomedicalservicesdatas/ironfoMedicalServices/form?id=${ironfoMedicalServices.id}','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="ironfomedicalservicesdatas:ironfoMedicalServices:edit">
    					<a href="#" onclick="openDialog('修改2.1年度医疗服务量', '${ctx}/ironfomedicalservicesdatas/ironfoMedicalServices/form?id=${ironfoMedicalServices.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>
    				</shiro:hasPermission>
    				<shiro:hasPermission name="ironfomedicalservicesdatas:ironfoMedicalServices:del">
						<a href="${ctx}/ironfomedicalservicesdatas/ironfoMedicalServices/delete?id=${ironfoMedicalServices.id}" onclick="return confirmx('确认要删除该2.1年度医疗服务量吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
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