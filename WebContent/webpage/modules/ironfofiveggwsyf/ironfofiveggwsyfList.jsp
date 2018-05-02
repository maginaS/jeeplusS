<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
<title>5.5公共卫生用房管理</title>
<meta name="decorator" content="default" />

</head>
<body class="hideScroll">
	<form id="inputForm" modelAttribute="ironfofiveggwsyf"
		action="${ctx}/ironfofiveggwsyf/ironfofiveggwsyf/save" method="post"
		class="form-horizontal">
		<%-- <form:hidden path="id"/>
		<sys:message content="${message}"/>	 --%>
		<table
			class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
			<tbody>


				<tr>


					注：
					<br /> 功能单元建筑面积：该功能单元所有房间和场所的建筑面积之和。
					<br /> 空间类型：乡镇卫生院设置有该类场所就算作有此种类型的空间，不需要名称一致。
					<br />

				</tr>
				<tr>
					<%-- <td class="width-15 active"><label class="pull-right">备注信息：</label></td>
					<td class="width-35">
						<form:textarea path="remarks" htmlEscape="false" rows="4"    class="form-control "/>
					</td> --%>
					<td class="width-15 active"><label class="pull-right">功能单元建筑面积（m2）：</label></td>
					<td class="width-35">
					<input   name="gndyjzmj_name_gndyjzmj_ggwsyf"  id="gndyjzmj" value="${data.gndyjzmj }"   htmlEscape="false" class="form-control " /></td>
					<input   type="hidden" name="gndyjzmj_name_gndyjzmj_ggwsyf"  id="docId"  value="${data.doc_id}" htmlEscape="false"    class="form-control "/>
				
				</tr>

			</tbody>
		</table>

		<div class="tabs-container">
			<ul class="nav nav-tabs">
				<li class="active"><a data-toggle="tab" href="#tab-1"
					aria-expanded="true">公共卫生用房空间类型</a></li>
			</ul>


			<div class="tab-content">
				<div id="tab-1" class="tab-pane active">
					<table id="contentTable"
						class="table table-striped table-bordered table-condensed">
						<thead>





							<tr>
								<td>
									<c:if test="${data.jkdas=='1' }">
										<input type="checkbox" name="ggwsyfgl_name" path="jkdas" id="jkdas" value="jkdas" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;健康档案室
									</c:if>
									<c:if test="${data.jkdas=='0' }">
										<input type="checkbox" name="ggwsyfgl_name" id="jkdas" value="jkdas" path="jkdas" style="margin-top: -2px;" />&nbsp;健康档案室
									</c:if>
								
								</td>
								<td>
									<c:if test="${data.jkjys=='1' }">
										<input type="checkbox" name="ggwsyfgl_name" path="jkjys" id="jkjys" value="jkjys" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;健康档案室
									</c:if>
									<c:if test="${data.jkjys=='0' }">
										<input type="checkbox" name="ggwsyfgl_name" id="jkjys" value="jkjys" path="jkjys" style="margin-top: -2px;"  />&nbsp;健康教育室
									</c:if>
								
								</td>
							
								<td>
									<c:if test="${data.yjqjzdt=='1' }">
										<input type="checkbox" name="ggwsyfgl_name" path="yjqjzdt" id="yjqjzdt" value="yjqjzdt" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;预检区-接种大厅
									</c:if>
									<c:if test="${data.yjqjzdt=='0' }">
										<input type="checkbox" name="ggwsyfgl_name" id="yjqjzdt" value="yjqjzdt" path="yjqjzdt" style="margin-top: -2px;"  />&nbsp;预检区-接种大厅
									</c:if>
								
								</td>
								<td>
								<c:if test="${data.hzqjzdt=='1' }">
										<input type="checkbox" name="ggwsyfgl_name" path="hzqjzdt" id="hzqjzdt" value="hzqjzdt" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;候种区-接种大厅
									</c:if>
									<c:if test="${data.hzqjzdt=='0' }">
										<input type="checkbox" name="ggwsyfgl_name" id="hzqjzdt" value="hzqjzdt" path="hzqjzdt" style="margin-top: -2px;"  />&nbsp;候种区-接种大厅
									</c:if>
								
								</td>
							
								<td>
								
								<c:if test="${data.jzqjzdt=='1' }">
										<input type="checkbox" name="ggwsyfgl_name" path="jzqjzdt" id="jzqjzdt" value="jzqjzdt" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;接种区-接种大厅
									</c:if>
									<c:if test="${data.jzqjzdt=='0' }">
										<input type="checkbox" name="ggwsyfgl_name" id="jzqjzdt" value="jzqjzdt" path="jzqjzdt" style="margin-top: -2px;"  />&nbsp;接种区-接种大厅
									</c:if>
								
								</td>
								<td>
								
								<c:if test="${data.lnqjzdt=='1' }">
										<input type="checkbox" name="ggwsyfgl_name" path="lnqjzdt" id="lnqjzdt" value="lnqjzdt" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;冷凝区-接种大厅
									</c:if>
									<c:if test="${data.lnqjzdt=='0' }">
										<input type="checkbox" name="ggwsyfgl_name" id="lnqjzdt" value="lnqjzdt" path="lnqjzdt"  style="margin-top: -2px;"  />&nbsp;冷凝区-接种大厅
									</c:if>
								
								</td>
							
								<td>
								
								<c:if test="${data.fnbjsjzdt=='1' }">
										<input type="checkbox" name="ggwsyfgl_name" path="fnbjsjzdt" id="fnbjsjzdt" value="fnbjsjzdt" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;妇女保健室-接种大厅
									</c:if>
									<c:if test="${data.fnbjsjzdt=='0' }">
										<input type="checkbox" name="ggwsyfgl_name" id="fnbjsjzdt" value="fnbjsjzdt" path="fnbjsjzdt"  style="margin-top: -2px;" />&nbsp;妇女保健室-接种大厅
									</c:if>
								
								</td>
							</tr>
							<tr>
								<td>
								<c:if test="${data.etbjsjzdt=='1' }">
										<input type="checkbox" name="ggwsyfgl_name" path="etbjsjzdt" id="etbjsjzdt" value="etbjsjzdt" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;儿童保健室-接种大厅
									</c:if>
									<c:if test="${data.etbjsjzdt=='0' }">
										<input type="checkbox" name="ggwsyfgl_name" id="etbjsjzdt" value="etbjsjzdt" path="etbjsjzdt"  style="margin-top: -2px;"  />&nbsp;儿童保健室-接种大厅
									</c:if>
								
								</td>
							
								<td>
									<c:if test="${data.lnrbjsjzdt=='1' }">
										<input type="checkbox" name="ggwsyfgl_name" path="lnrbjsjzdt" id="lnrbjsjzdt" value="lnrbjsjzdt" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;老年人保健室-接种大厅
									</c:if>
									<c:if test="${data.lnrbjsjzdt=='0' }">
										<input type="checkbox" name="ggwsyfgl_name" id="lnrbjsjzdt" value="lnrbjsjzdt" path="lnrbjsjzdt" style="margin-top: -2px;"  />&nbsp;老年人保健室-接种大厅
									</c:if>
								
								</td>
								<td>
								
									<c:if test="${data.ybjcqtjzx=='1' }">
										<input type="checkbox" name="ggwsyfgl_name" path="ybjcqtjzx" id="ybjcqtjzx" value="ybjcqtjzx" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;一般检查区-体检中心
									</c:if>
									<c:if test="${data.ybjcqtjzx=='0' }">
										<input type="checkbox" name="ggwsyfgl_name" id="ybjcqtjzx" value="ybjcqtjzx" path="ybjcqtjzx"  style="margin-top: -2px;"  />&nbsp;一般检查区-体检中心
									</c:if>
								
								</td>
							
								<td>
								<c:if test="${data.kqjcqtjzx=='1' }">
										<input type="checkbox" name="ggwsyfgl_name" path="kqjcqtjzx" id="kqjcqtjzx" value="kqjcqtjzx" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;口腔检查区-体检中心
									</c:if>
									<c:if test="${data.kqjcqtjzx=='0' }">
										<input type="checkbox" name="ggwsyfgl_name" id="kqjcqtjzx" value="kqjcqtjzx" path="kqjcqtjzx"  style="margin-top: -2px;" />&nbsp;口腔检查区-体检中心
									</c:if>
								
								</td>
								<td>
								<c:if test="${data.tljcqtjzx=='1' }">
										<input type="checkbox" name="ggwsyfgl_name" path="tljcqtjzx" id="tljcqtjzx" value="tljcqtjzx" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;听力检查区-体检中心
									</c:if>
									<c:if test="${data.tljcqtjzx=='0' }">
									<input type="checkbox" name="ggwsyfgl_name" id="tljcqtjzx" value="tljcqtjzx" path="tljcqtjzx" style="margin-top: -2px;"  />&nbsp;听力检查区-体检中心
									</c:if>
								
								</td>
							
								<td>
									<c:if test="${data.sljcqtjzx=='1' }">
										<input type="checkbox" name="ggwsyfgl_name" path="sljcqtjzx" id="sljcqtjzx" value="sljcqtjzx" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;视力检查区-体检中心
									</c:if>
									<c:if test="${data.sljcqtjzx=='0' }">
										<input type="checkbox" name="ggwsyfgl_name" id="sljcqtjzx" value="sljcqtjzx" path="sljcqtjzx" style="margin-top: -2px;"  />&nbsp;视力检查区-体检中心
									</c:if>
								
								</td>
								<td>
									<c:if test="${data.zljcqtjzx=='1' }">
										<input type="checkbox" name="ggwsyfgl_name" path="zljcqtjzx" id="zljcqtjzx" value="zljcqtjzx" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;智力检查区-体检中心
									</c:if>
									<c:if test="${data.zljcqtjzx=='0' }">
										<input type="checkbox" name="ggwsyfgl_name" id="zljcqtjzx" value="zljcqtjzx" path="zljcqtjzx"  style="margin-top: -2px;" />&nbsp;智力检查区-体检中心
									</c:if>
								
								</td>
							</tr>
							<tr>
								<td>
									<c:if test="${data.nanwkjcstjzx=='1' }">
										<input type="checkbox" name="ggwsyfgl_name" path="nanwkjcstjzx" id="nanwkjcstjzx" value="nanwkjcstjzx" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;男外科检查室-体检中心
									</c:if>
									<c:if test="${data.nanwkjcstjzx=='0' }">
										<input type="checkbox" name="ggwsyfgl_name" id="nanwkjcstjzx" value="nanwkjcstjzx" path="nwkjcstjzx" style="margin-top: -2px;"  />&nbsp;男外科检查室-体检中心
									</c:if>
								
								</td>
								<td>
									<c:if test="${data.nvwkjcstjzx=='1' }">
										<input type="checkbox" name="ggwsyfgl_name" path="nvwkjcstjzx" id="nvwkjcstjzx" value="nvwkjcstjzx" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;女外科检查室-体检中心
									</c:if>
									<c:if test="${data.nvwkjcstjzx=='0' }">
									<input type="checkbox" name="ggwsyfgl_name" id="nvwkjcstjzx" value="nvwkjcstjzx" path="nvwkjcstjzx" style="margin-top: -2px;"  />&nbsp;女外科检查室-体检中心
									</c:if>
								
								</td>
							</tr>
							<tr>
							
							
										
							<td>其它（请注明）</td><td><input name="ggwsyfgl_name_qtqzm" id="ggwsyfgl_name_qtqzm" value="${data.qtqzm }"  type="text" /></td>
							<input type = "hidden" htmlEscape="false" id="ggwsyfgl_name_id"   name="ggwsyfgl_name_id" value="${data.id}"  class="form-control "/>
					
								
							
							
							</tr>
						</thead>
					</table>
				</div>
			</div>

		</div>
	</form>
	
	
	
	<div style="text-align:right;">
		<input type="button" value="保存"  style="width:100px;height:50px;margin-right: 20px;" onclick="subuimtinput();"/>
	</div>
	
	
	
	<script type="text/javascript">
	

	function subuimtinput(){
		var checkval="";
		var checkout="";
		
		var data = document.getElementsByName("ggwsyfgl_name");
	 	var remarks = document.getElementById("ggwsyfgl_name_qtqzm").value;
		var id= document.getElementById("ggwsyfgl_name_id").value; 
		var title = document.getElementsByName("gndyjzmj_name_gndyjzmj_ggwsyf");
		var titles="";
		for(var i=0;i<title.length;i++){
			if(title[i].value==null||title[i].value==""){
				titles = titles +title[i].id+": ---- ;";	
			}else{
				titles = titles +title[i].id+":"+title[i].value+";";	
			}
		}
		
		
	
	    check_val = [];
	    check_out = [];
	    for(a in data){
	        if(data[a].checked){
	        	  check_val.push(data[a].value);
	        }else{
	        	  check_out.push(data[a].value);
	        }  
	    } 
	    
	    checkval=checkval+check_val;
	    checkout=checkout+check_out;
		 $.ajax({
		      url:"${ctx}/ironfofiveggwsyf/ironfofiveggwsyf/save",
		      data:{
		    	  titles:titles,
		    	  checkval:checkval,
		    	  checkout:checkout,
		    	  qtqzm:remarks,
		    	  id:id
		    	     },
		      type:"post",
		      
		      success:function(data){
		    	   alert("保存成功"); 
		    	   location.reload();
		      }
		    });
	}
	</script>
	
	
</body>
</html>