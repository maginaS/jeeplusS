<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>组织管理管理</title>
	<meta name="decorator" content="default"/>
	<style>
        #div1{
        width:250px;
        height:650px;
        float:left;}
        #div2{
        width: 750px;
        height: 400px;
        float:right;}
        #div3{
        width: 750px;
        height: 350px;
		float:right;}
    </style>
	<script type="text/javascript">
		$(document).ready(function() {
		});
		
		window.onload=function(){
            var oto1=document.getElementById('div4');
            var oto2=oto1.getElementsByTagName('a');
            for(var i=0;i<oto2.length;i++){
                    oto2[i].index=i;
                    oto2[i].onclick=function(){
                            document.getElementById('sname').value=oto2[this.index].innerHTML;
                            search();
                            
                            }
                    }
            }
	</script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content">
	
	<div class="iboxx">
	<div class="iboxx-title">
	    <h2>组织管理</h2>
	</div>
	</div>
	
	<div class="ibox">
	<div class="ibox-title" id = "div1">
	
	<h2>组织列表 </h2>
		<div class="ibox-tools">
		<div class="row">
	<div class="col-sm-12">
		<div class="pull-left">
				<a href="#" name="organization:organization:add" onclick="openDialog('增加组织', '${ctx}/organization/organization/form','800px', '500px')" style="font-size:20px" >添加</a>
			</div>
	</div>
	</div>
		</div>
		<br />
		<div id="div4">
		      <c:forEach items="${page.list}" var="organization">   
			  <ul>
			    <li><a href = "#" style="font-size:22px">${organization.name}</a></li>
			  </ul>
			  </c:forEach>
	    </div>
	</div>
	
	<div class="ibox-title" id = "div2">
		<h2>组织详情 </h2>
    
    <div class="ibox-content">
	<sys:message content="${message}"/>
	
	<!--查询条件-->
	<div class="row">
	<div class="col-sm-12">
	<form:form id="searchForm" modelAttribute="organization" action="${ctx}/organization/organization/" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<div class="form-group">
		      <form:input path="name" value="${organization.name}" id="sname" type="hidden" htmlEscape="false" maxlength="64"  class=" form-control input-sm"/>
		 </div>	
	</form:form>
	<br/>
	</div>
	</div>
	</div>
	
	
	<!-- 表格 -->
	<table id="contentTable" class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable">
            <tbody>
             <c:forEach items="${page.list}" var="organization"> 
              <tr>
                <td><strong>组织名称</strong></td>
                <td>${organization.name}</td>
                <td><strong>组织详情</strong></td>
                <td>${organization.explain}</td>
              </tr> 
              <tr>
                <td><strong>上级组织</strong></td>
                <td><select>
                  <c:forEach items="${page.list}" var = "organization">
                    <option value="${organization.parent_id}">${organization.parent_id}
                  </c:forEach>
                </select></td>
              </tr>
              </c:forEach>
            </tbody>
	</table>
	
	</div>
	</div>
	
	<div class="ibox-title" id="div3">
	<h2>成员列表</h2>
	<table id="contentTable" class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable">
		<thead>
			<tr>
				<th  class="sort-column tuser.name">名字</th>
				<th class="sort-column tuser.user_type">角色</th>
				<th  class="sort-column phone">手机号</th>
				<th  class="sort-column email">邮箱</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="organization">
			<tr>
				<td>
					${organization.tuser.name}
				<td>
				    <c:if test="${organization.tuser.userType =='1'}">
				        <i>管理员</i>
				    </c:if>
				    <c:if test="${organization.tuser.userType =='2'}">
				        <i>超级管理员</i>
				    </c:if>
				    <c:if test="${organization.tuser.userType =='3'}">
				        <i>人事</i>
				    </c:if>
				</td>
				<td>
					${organization.tuser.phone}
				</td>
				<td>
					${organization.tuser.email}
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	</div>
	
</div>
</body>
</html>