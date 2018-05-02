<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>5.7职能管理用房管理</title>
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
		<h5>5.7职能管理用房列表 </h5>
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
	<form:form id="searchForm" modelAttribute="ironfofiveznglyf" action="${ctx}/ironfofiveznglyfreport/ironfofiveznglyf/" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<div class="form-group">
		 </div>	
		 <td class="width-35" >用户<sys:treeselect id="duser" name="duser.id" value="${ironfofiveznglyf.duser.id}" 
		         labelName="duser.name" labelValue="${ironfofiveznglyf.duser.name}"
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
			<%-- <shiro:hasPermission name="ironfofiveznglyfreport:ironfofiveznglyf:add">
				<table:addRow url="${ctx}/ironfofiveznglyfreport/ironfofiveznglyf/form" title="5.7职能管理用房"></table:addRow><!-- 增加按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="ironfofiveznglyfreport:ironfofiveznglyf:edit">
			    <table:editRow url="${ctx}/ironfofiveznglyfreport/ironfofiveznglyf/form" title="5.7职能管理用房" id="contentTable"></table:editRow><!-- 编辑按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="ironfofiveznglyfreport:ironfofiveznglyf:del">
				<table:delRow url="${ctx}/ironfofiveznglyfreport/ironfofiveznglyf/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="ironfofiveznglyfreport:ironfofiveznglyf:import">
				<table:importExcel url="${ctx}/ironfofiveznglyfreport/ironfofiveznglyf/import"></table:importExcel><!-- 导入按钮 -->
			</shiro:hasPermission> --%>
			<shiro:hasPermission name="ironfofiveznglyfreport:ironfofiveznglyf:export">
	       		<table:exportExcel url="${ctx}/ironfofiveznglyfreport/ironfofiveznglyf/export"></table:exportExcel><!-- 导出按钮 -->
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
				<th  class="sort-column yzbgs">院长办公室</th>
				<th  class="sort-column djbgs">党建办公室</th>
				<th  class="sort-column ywkbgs">医务科办公室</th>
				<th  class="sort-column hlkbgs">护理科办公室</th>
				<th  class="sort-column cwkbgs">财务科办公室</th>
				<th  class="sort-column daglkbgs">病案管理科办公室</th>
				<th  class="sort-column xxzx">信息中心</th>
				<th  class="sort-column ygkbgs">院感科办公室</th>
				<th  class="sort-column ybjskbgs">医保结算科办公室</th>
				<th  class="sort-column hqglkbgs">后勤管理科办公室</th>
				<th  class="sort-column dgnhys">多功能会议室</th>
				<th  class="sort-column xyf">洗衣房</th>
				<th  class="sort-column yycf">营养厨房</th>
				<th  class="sort-column ylljzcjljzcj">医疗垃圾暂存间-垃圾暂存间</th>
				<th  class="sort-column shljzcjljzcj">生活垃圾暂存间-垃圾暂存间</th>
				<th  class="sort-column tpj">太平间</th>
				<th  class="sort-column bpdsbpdyf">变配电室-变配电用房</th>
				<th  class="sort-column bpdzbsbpdyf">变配电值班室-变配电用房</th>
				<th  class="sort-column cyfdjfcyfdyf">柴油发电机房-柴油发电用房</th>
				<th  class="sort-column ykcyfdyf">油库-柴油发电用房</th>
				<th  class="sort-column dtjf">电梯机房</th>
				<th  class="sort-column glfglyf">锅炉房-锅炉用房</th>
				<th  class="sort-column glkzsglyf">锅炉控制室-锅炉用房</th>
				<th  class="sort-column rqbjglyf">燃气表间-锅炉用房</th>
				<th  class="sort-column lsjf">冷水机房</th>
				<th  class="sort-column ktjf">空调机房</th>
				<th  class="sort-column tfjf">通风机房</th>
				<th  class="sort-column gsbf">给水泵房</th>
				<th  class="sort-column xfbf">消防泵房</th>
				<th  class="sort-column bjzs">报警阀室</th>
				<th  class="sort-column xfsxj">消防水箱间</th>
				<th  class="sort-column xfkzs">消防控制室</th>
				<th  class="sort-column afjks">安防监控室</th>
				<th  class="sort-column txwljf">通信网络机房</th>
				<th  class="sort-column xxhxtjf">信息化系统机房</th>
				<th  class="sort-column mws">门卫室</th>
				<th  class="sort-column sntcc">室内停车场</th>
				<th  class="sort-column qtqzm">其它（请注明）</th>
				<!-- <th>操作</th> -->
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="ironfofiveznglyf">
			<tr>
				<td> <input type="checkbox" id="${ironfofiveznglyf.id}" class="i-checks"></td>
				<%-- <td><a  href="#" onclick="openDialogView('查看5.7职能管理用房', '${ctx}/ironfofiveznglyfreport/ironfofiveznglyf/form?id=${ironfofiveznglyf.id}','800px', '500px')">
					${ironfofiveznglyf.remarks}
				</a></td> --%>
				<%-- <td>
					${ironfofiveznglyf.doc_id}
				</td> --%>
				<td>
					${ironfofiveznglyf.gndyjzmj}
				</td>
				<td>
				<c:if test="${ironfofiveznglyf.yzbgs eq '1'}">是</c:if>
            		<c:if test="${ironfofiveznglyf.yzbgs eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveznglyf.djbgs eq '1'}">是</c:if>
            		<c:if test="${ironfofiveznglyf.djbgs eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveznglyf.ywkbgs eq '1'}">是</c:if>
            		<c:if test="${ironfofiveznglyf.ywkbgs eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveznglyf.hlkbgs eq '1'}">是</c:if>
            		<c:if test="${ironfofiveznglyf.hlkbgs eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveznglyf.cwkbgs eq '1'}">是</c:if>
            		<c:if test="${ironfofiveznglyf.cwkbgs eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveznglyf.daglkbgs eq '1'}">是</c:if>
            		<c:if test="${ironfofiveznglyf.daglkbgs eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveznglyf.xxzx eq '1'}">是</c:if>
            		<c:if test="${ironfofiveznglyf.xxzx eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveznglyf.ygkbgs eq '1'}">是</c:if>
            		<c:if test="${ironfofiveznglyf.ygkbgs eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveznglyf.ybjskbgs eq '1'}">是</c:if>
            		<c:if test="${ironfofiveznglyf.ybjskbgs eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveznglyf.hqglkbgs eq '1'}">是</c:if>
            		<c:if test="${ironfofiveznglyf.hqglkbgs eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveznglyf.dgnhys eq '1'}">是</c:if>
            		<c:if test="${ironfofiveznglyf.dgnhys eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveznglyf.xyf eq '1'}">是</c:if>
            		<c:if test="${ironfofiveznglyf.xyf eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveznglyf.yycf eq '1'}">是</c:if>
            		<c:if test="${ironfofiveznglyf.yycf eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveznglyf.ylljzcjljzcj eq '1'}">是</c:if>
            		<c:if test="${ironfofiveznglyf.ylljzcjljzcj eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveznglyf.shljzcjljzcj eq '1'}">是</c:if>
            		<c:if test="${ironfofiveznglyf.shljzcjljzcj eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveznglyf.tpj eq '1'}">是</c:if>
            		<c:if test="${ironfofiveznglyf.tpj eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveznglyf.bpdsbpdyf eq '1'}">是</c:if>
            		<c:if test="${ironfofiveznglyf.bpdsbpdyf eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveznglyf.bpdzbsbpdyf eq '1'}">是</c:if>
            		<c:if test="${ironfofiveznglyf.bpdzbsbpdyf eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveznglyf.cyfdjfcyfdyf eq '1'}">是</c:if>
            		<c:if test="${ironfofiveznglyf.cyfdjfcyfdyf eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveznglyf.ykcyfdyf eq '1'}">是</c:if>
            		<c:if test="${ironfofiveznglyf.ykcyfdyf eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveznglyf.dtjf eq '1'}">是</c:if>
            		<c:if test="${ironfofiveznglyf.dtjf eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveznglyf.glfglyf eq '1'}">是</c:if>
            		<c:if test="${ironfofiveznglyf.glfglyf eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveznglyf.glkzsglyf eq '1'}">是</c:if>
            		<c:if test="${ironfofiveznglyf.glkzsglyf eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveznglyf.rqbjglyf eq '1'}">是</c:if>
            		<c:if test="${ironfofiveznglyf.rqbjglyf eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveznglyf.lsjf eq '1'}">是</c:if>
            		<c:if test="${ironfofiveznglyf.lsjf eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveznglyf.ktjf eq '1'}">是</c:if>
            		<c:if test="${ironfofiveznglyf.ktjf eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveznglyf.tfjf eq '1'}">是</c:if>
            		<c:if test="${ironfofiveznglyf.tfjf eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveznglyf.gsbf eq '1'}">是</c:if>
            		<c:if test="${ironfofiveznglyf.gsbf eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveznglyf.xfbf eq '1'}">是</c:if>
            		<c:if test="${ironfofiveznglyf.xfbf eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveznglyf.bjzs eq '1'}">是</c:if>
            		<c:if test="${ironfofiveznglyf.bjzs eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveznglyf.xfsxj eq '1'}">是</c:if>
            		<c:if test="${ironfofiveznglyf.xfsxj eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveznglyf.xfkzs eq '1'}">是</c:if>
            		<c:if test="${ironfofiveznglyf.xfkzs eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveznglyf.afjks eq '1'}">是</c:if>
            		<c:if test="${ironfofiveznglyf.afjks eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveznglyf.txwljf eq '1'}">是</c:if>
            		<c:if test="${ironfofiveznglyf.txwljf eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveznglyf.xxhxtjf eq '1'}">是</c:if>
            		<c:if test="${ironfofiveznglyf.xxhxtjf eq '0'}">否</c:if>
					
				</td>
				
				<td>
				<c:if test="${ironfofiveznglyf.mws eq '1'}">是</c:if>
            		<c:if test="${ironfofiveznglyf.mws eq '0'}">否</c:if>
					
				</td>
				<td>
				<c:if test="${ironfofiveznglyf.sntcc eq '1'}">是</c:if>
            		<c:if test="${ironfofiveznglyf.sntcc eq '0'}">否</c:if>
					
				</td>
				<td>
					${ironfofiveznglyf.qtqzm}
				</td>
				<%-- <td>
					<shiro:hasPermission name="ironfofiveznglyfreport:ironfofiveznglyf:view">
						<a href="#" onclick="openDialogView('查看5.7职能管理用房', '${ctx}/ironfofiveznglyfreport/ironfofiveznglyf/form?id=${ironfofiveznglyf.id}','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="ironfofiveznglyfreport:ironfofiveznglyf:edit">
    					<a href="#" onclick="openDialog('修改5.7职能管理用房', '${ctx}/ironfofiveznglyfreport/ironfofiveznglyf/form?id=${ironfofiveznglyf.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>
    				</shiro:hasPermission>
    				<shiro:hasPermission name="ironfofiveznglyfreport:ironfofiveznglyf:del">
						<a href="${ctx}/ironfofiveznglyfreport/ironfofiveznglyf/delete?id=${ironfofiveznglyf.id}" onclick="return confirmx('确认要删除该5.7职能管理用房吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
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