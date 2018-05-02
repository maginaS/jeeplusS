<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>角色管理管理</title>
	<meta name="decorator" content="default"/>
	<style>
        #div1{
        width:250px;
        height:450px;
        float:left;}
        #div1 h3 {
        width:50%;
        float:left;}
        #div2{
        width: 750px;
        height: 150px;
        float:right;}
        #div3{
        width: 750px;
        height: 300px;
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
		
		function check() {
			var allcheck = document.getElementById('checkall');
			var othercheck = document.getElementsByName('checkbox2');
			for(var i=0; i<othercheck.length; i++) {
				if(allcheck.checked) {
					othercheck[i].checked = true;
				}
				else {
					othercheck[i].checked = false;
				}
			}
		}
		
	</script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content">
	
	<div class="iboxx">
	<div class="iboxx-title">
	    <h2>角色管理</h2>
	</div>
	</div>
	
	<div class="ibox">
	<div class="ibox-title" id="div1">
	  <div>
		<h3>角色列表 </h3>
		<h3><a  href="#" name="sysrole:sysRole:add" onclick="openDialog('查看角色管理', '${ctx}/sysrole/sysRole/form','800px', '500px')">添加列表</a></h3>
		<br />
		<br />
		</div>
		<div id="div4">
		<c:forEach items="${page.list}" var="sysRole">
		  <ul>
		    <li><a href="#" style="font-size:18px">${sysRole.name}</a></li>
		  </ul>
		</c:forEach>
		</div>
	</div>
    
    <div class="ibox-title" id = "div2">
    
    <div class="ibox-content">
	<sys:message content="${message}"/>
	
	<!--查询条件-->
	<div class="row">
	<div class="col-sm-12">
	<form:form id="searchForm" modelAttribute="sysRole" action="${ctx}/sysrole/sysRole/" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<div class="form-group">
		      <form:input path="name" value="${sysRole.name}" id="sname" type="hidden" htmlEscape="false" maxlength="64"  class=" form-control input-sm"/>
		 </div>	
	</form:form>
	<br/>
	</div>
	</div>
	
	<!-- 表格 -->
	<table id="contentTable" class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable">
            <tbody>
             <c:forEach items="${page.list}" var="sysRole"> 
              <tr>
                <td><strong>角色名称</strong></td>
                <td>${sysRole.name}</td>
                <td><strong>角色描述</strong></td>
                <td>${sysRole.explain}</td>
              </tr> 
              <tr>
                <td><strong>角色上级</strong></td>
                <td><select>
                      <c:forEach items = "${page.list}" var="sysRole">
                          <option value="${sysRole.type}">${sysRole.type}</option>
                      </c:forEach>
                </select></td>
              </tr>
              </c:forEach>
            </tbody>
	</table>
	
	</div>
	</div>
	
	<div class="ibox-title" id="div3">
	  <table>
	    <form action="" method="get">
	      <c:forEach var = "x" begin = "1" end = "3" varStatus = "status">
	        <input type="checkbox" id="checkall" name="checkbox" value="checkbox" style="font-size:20px; margin-left:10%" onclick="check()" />栏目${status.index}<br />
	        <c:forEach items = "${page.list}" var = "sysRole">
	          <input type="checkbox" name="checkbox2" value="${sysRole.feature.name}" style="margin-left:10%" />${sysRole.feature.name}
	        </c:forEach>
            <br />
          </c:forEach>
	    </form>
	  </table>  
	</div>
	
	</div>
</div>
</body>
</html>