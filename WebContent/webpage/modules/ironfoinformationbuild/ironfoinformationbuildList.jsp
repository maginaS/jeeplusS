<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>4.1信息化系统建设情况管理</title>
	<meta name="decorator" content="default"/>
	
</head>
<body class="hideScroll">
		<form id="inputForm" modelAttribute="ironfoinformationbuild" action="${ctx}/ironfoinformationbuild/ironfoinformationbuild/save" method="post" class="form-horizontal">
		<%-- <form:hidden path="id"/>
		<sys:message content="${message}"/>	 --%>
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				 <tr>
					 注：<br/>
					系统部署方式：①云端部署②本地化部署<br/>
					系统功能实现: 按照4.2信息化系统功能实现中所示的功能填报<br/>
			
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">软件名称</label></td>
					
					<td class="width-15 active"><label class="pull-right">厂商名称</label></td>
					<td class="width-15 active"><label class="pull-right">软件造价（元）</label></td>
					<td class="width-15 active"><label class="pull-right">投入使用时间</label></td>
					<td class="width-15 active"><label class="pull-right">系统部署方式</label></td>
					<td class="width-15 active"><label class="pull-right">系统功能实现</label></td>
				
				</tr>
				<tr>
					<td class="width-15">
					<!-- value="医院信息系统HIS"  -->
						<input path="build_rjmc" readOnly="true"  name="xxhxtjs_name" id="yyxxxthis_rjmc" htmlEscape="false"  value="乡镇卫生院信息管理系统"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="build_csmc" name="xxhxtjs_name" id="yyxxxthis_csmc" value="${data.yyxxxthis.yyxxxthis_csmc }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="build_rjzj" name="xxhxtjs_name" id="yyxxxthis_rjzj" value="${data.yyxxxthis.yyxxxthis_rjzj }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="build_trsysj" name="xxhxtjs_name" id="yyxxxthis_trsysj" value="${data.yyxxxthis.yyxxxthis_trsysj }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="build_xtbsfs" name="xxhxtjs_name" id="yyxxxthis_xtbsfs" value="${data.yyxxxthis.yyxxxthis_xtbsfs }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="build_xtgnsx" name="xxhxtjs_name" id="yyxxxthis_xtgnsx" value="${data.yyxxxthis.yyxxxthis_xtgnsx }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="yyxxxthis_id"  name="xxhxtjs_name" value="${data.yyxxxthis.yyxxxthis_id}"  class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="docId"   name="xxhxtjs_name" value="${data.doc_id}"  class="form-control "/>
					
					</td>
				</tr>
				<tr>
					
					<td class="width-15">
				<!-- 	临床信息系统CIS -->
						<input path="build_rjmc" readOnly="true"  name="xxhxtjs_name" id="lcxxxtcis_rjmc" htmlEscape="false"  value="基本公共卫生信息管理系统"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="build_csmc" name="xxhxtjs_name" id="lcxxxtcis_csmc" value="${data.lcxxxtcis.lcxxxtcis_csmc }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="build_rjzj" name="xxhxtjs_name" id="lcxxxtcis_rjzj" value="${data.lcxxxtcis.lcxxxtcis_rjzj }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="build_trsysj" name="xxhxtjs_name" id="lcxxxtcis_trsysj" value="${data.lcxxxtcis.lcxxxtcis_trsysj }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="build_xtbsfs" name="xxhxtjs_name" id="lcxxxtcis_xtbsfs" value="${data.lcxxxtcis.lcxxxtcis_xtbsfs }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="build_xtgnsx" name="xxhxtjs_name" id="lcxxxtcis_xtgnsx" value="${data.lcxxxtcis.lcxxxtcis_xtgnsx }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="lcxxxtcis_id"  name="xxhxtjs_name" value="${data.lcxxxtcis.lcxxxtcis_id}"  class="form-control "/>
					
					</td>
					
				</tr>
				
				<tr>
					
					<td class="width-15">
					<!-- 电子病历系统EMR -->
						<input path="build_rjmc" readOnly="true"  name="xxhxtjs_name" id="dzblxtemr_rjmc" htmlEscape="false"  value="基本医疗信息管理系统"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="build_csmc" name="xxhxtjs_name" id="dzblxtemr_csmc" value="${data.dzblxtemr.dzblxtemr_csmc }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="build_rjzj" name="xxhxtjs_name" id="dzblxtemr_rjzj" value="${data.dzblxtemr.dzblxtemr_rjzj }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="build_trsysj" name="xxhxtjs_name" id="dzblxtemr_trsysj" value="${data.dzblxtemr.dzblxtemr_trsysj }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="build_xtbsfs" name="xxhxtjs_name" id="dzblxtemr_xtbsfs" value="${data.dzblxtemr.dzblxtemr_xtbsfs }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="build_xtgnsx" name="xxhxtjs_name" id="dzblxtemr_xtgnsx" value="${data.dzblxtemr.dzblxtemr_xtgnsx }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="dzblxtemr_id"  name="xxhxtjs_name" value="${data.dzblxtemr.dzblxtemr_id}"  class="form-control "/>
				
					</td>
					
				</tr>
				<tr>
					
					<td class="width-15">
					<!-- 电子健康档案系统EHR -->
						<input path="build_rjmc" readOnly="true"  name="xxhxtjs_name" id="dzjkdaxtehr_rjmc" htmlEscape="false"  value="远程医疗信息系统"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="build_csmc" name="xxhxtjs_name"  id="dzjkdaxtehr_csmc" value="${data.dzjkdaxtehr.dzjkdaxtehr_csmc }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="build_rjzj" name="xxhxtjs_name"  id="dzjkdaxtehr_rjzj" value="${data.dzjkdaxtehr.dzjkdaxtehr_rjzj }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="build_trsysj" name="xxhxtjs_name"  id="dzjkdaxtehr_trsysj" value="${data.dzjkdaxtehr.dzjkdaxtehr_trsysj }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="build_xtbsfs" name="xxhxtjs_name"  id="dzjkdaxtehr_xtbsfs" value="${data.dzjkdaxtehr.dzjkdaxtehr_xtbsfs }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="build_xtgnsx" name="xxhxtjs_name"  id="dzjkdaxtehr_xtgnsx" value="${data.dzjkdaxtehr.dzjkdaxtehr_xtgnsx }" htmlEscape="false"    class="form-control "/>
					<input type = "hidden" htmlEscape="false" id="dzjkdaxtehr_id"  name="xxhxtjs_name" value="${data.dzjkdaxtehr.dzjkdaxtehr_id}"  class="form-control "/>
				
					</td>
					
				</tr>
				<%-- <tr>
					
					<td class="width-15">
						<input path="build_rjmc" readOnly="true"  name="xxhxtjs_name" id="sysxxxtlis_rjmc" htmlEscape="false"  value="实验室信息系统LIS"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="build_csmc" name="xxhxtjs_name"  id="sysxxxtlis_csmc" value="${data.sysxxxtlis.sysxxxtlis_csmc }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="build_rjzj" name="xxhxtjs_name"  id="sysxxxtlis_rjzj" value="${data.sysxxxtlis.sysxxxtlis_rjzj }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="build_trsysj" name="xxhxtjs_name"  id="sysxxxtlis_trsysj" value="${data.sysxxxtlis.sysxxxtlis_trsysj }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="build_xtbsfs" name="xxhxtjs_name"  id="sysxxxtlis_xtbsfs" value="${data.sysxxxtlis.sysxxxtlis_xtbsfs }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="build_xtgnsx" name="xxhxtjs_name"  id="sysxxxtlis_xtgnsx" value="${data.sysxxxtlis.sysxxxtlis_xtgnsx }" htmlEscape="false"    class="form-control "/>
					<input type = "hidden" htmlEscape="false" id="sysxxxtlis_id"  name="xxhxtjs_name" value="${data.sysxxxtlis.sysxxxtlis_id}"  class="form-control "/>
				
					</td>
					
				</tr>
				<tr>
					
					<td class="width-15">
						<input path="build_rjmc" readOnly="true"  name="xxhxtjs_name" id="yxyxcdytxxtpscs_rjmc" htmlEscape="false"  value="医学影像存档与通讯系统PACS"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="build_csmc" name="xxhxtjs_name" value="${data.yxyxcdytxxtpscs.yxyxcdytxxtpscs_csmc }"  id="yxyxcdytxxtpscs_csmc" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="build_rjzj" name="xxhxtjs_name" value="${data.yxyxcdytxxtpscs.yxyxcdytxxtpscs_rjzj }"   id="yxyxcdytxxtpscs_rjzj" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="build_trsysj" name="xxhxtjs_name" value="${data.yxyxcdytxxtpscs.yxyxcdytxxtpscs_trsysj }"   id="yxyxcdytxxtpscs_trsysj" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="build_xtbsfs" name="xxhxtjs_name" value="${data.yxyxcdytxxtpscs.yxyxcdytxxtpscs_xtbsfs }"   id="yxyxcdytxxtpscs_xtbsfs" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="build_xtgnsx" name="xxhxtjs_name" value="${data.yxyxcdytxxtpscs.yxyxcdytxxtpscs_xtgnsx }"   id="yxyxcdytxxtpscs_xtgnsx" htmlEscape="false"    class="form-control "/>
					<input type = "hidden" htmlEscape="false" id="yxyxcdytxxtpscs_id"  name="xxhxtjs_name" value="${data.yxyxcdytxxtpscs.yxyxcdytxxtpscs_id}"  class="form-control "/>
				
					</td>
					
				</tr>
				<tr>
					
					<td class="width-15">
						<input path="build_rjmc" readOnly="true"  name="xxhxtjs_name" id="ycylxttis_rjmc" htmlEscape="false"  value="远程医疗系统TIS"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="build_csmc" name="xxhxtjs_name" id="ycylxttis_csmc" value="${data.ycylxttis.ycylxttis_csmc }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="build_rjzj" name="xxhxtjs_name" id="ycylxttis_rjzj" value="${data.ycylxttis.ycylxttis_rjzj }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="build_trsysj" name="xxhxtjs_name" id="ycylxttis_trsysj" value="${data.ycylxttis.ycylxttis_trsysj }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="build_xtbsfs" name="xxhxtjs_name" id="ycylxttis_xtbsfs"  value="${data.ycylxttis.ycylxttis_xtbsfs }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="build_xtgnsx" name="xxhxtjs_name" id="ycylxttis_xtgnsx"  value="${data.ycylxttis.ycylxttis_xtgnsx }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="ycylxttis_id"  name="xxhxtjs_name" value="${data.ycylxttis.ycylxttis_id}"  class="form-control "/>
				
					</td>
					
				</tr> --%>
				<tr>
					
					<td class="width-15">
						<input path="build_rjmc" readOnly="true"  name="xxhxtjs_name" id="qtqzm_rjmc" htmlEscape="false"  value="其它（请注明）"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="build_csmc" name="xxhxtjs_name" id="qtqzm_csmc" value="${data.qtqzm.qtqzm_csmc }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="build_rjzj" name="xxhxtjs_name" id="qtqzm_rjzj"  value="${data.qtqzm.qtqzm_rjzj }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="build_trsysj" name="xxhxtjs_name" id="qtqzm_trsysj"  value="${data.qtqzm.qtqzm_trsysj }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="build_xtbsfs" name="xxhxtjs_name" id="qtqzm_xtbsfs"  value="${data.qtqzm.qtqzm_xtbsfs }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="build_xtgnsx" name="xxhxtjs_name" id="qtqzm_xtgnsx"  value="${data.qtqzm.qtqzm_xtgnsx }"  htmlEscape="false"    class="form-control "/>
					<input type = "hidden" htmlEscape="false" id="qtqzm_id"  name="xxhxtjs_name" value="${data.qtqzm.qtqzm_id}"  class="form-control "/>
				
					</td>
					
				</tr>
		 	</tbody>
		</table>
	</form>
	
	
	
	<div style="text-align:right;">
		<input type="button" value="保存"  style="width:100px;height:50px;margin-right: 20px;" onclick="subuimtinput();"/>
	</div>
	
	
	
	<script type="text/javascript">
	function subuimtinput(){
		
		var data = document.getElementsByName("xxhxtjs_name");
	
		var datas="";
		
		
		for(i=0;i<data.length;i++){
			if(data[i].value==null||data[i].value==""){
				datas = datas +data[i].id+": ---- ;";	
			}else{
				datas = datas +data[i].id+":"+data[i].value+";";	
			}
			
			
		}
	 	
		 $.ajax({
		      url:"${ctx}/ironfoinformationbuild/ironfoinformationbuild/save",
		      data:{
		    	  datas:datas
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