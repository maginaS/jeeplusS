<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>3.5计划生育部医疗设备配置管理</title>
	<meta name="decorator" content="default"/>
	
</head>
<body class="hideScroll">
		<form id="inputForm" modelAttribute="ironfojhsybylsbpz" action="${ctx}/ironfojhsybylsbpz/ironfojhsybylsbpz/save" method="post" class="form-horizontal">
	<%-- 	<form:hidden path="id"/>
		<sys:message content="${message}"/>	 --%>
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				
				<tr>
					注：<br/>
					若同类设备有多台，则依次注明品牌型号、数量、设备价格、投入使用年份。<br/>
					
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">设备名称</label></td>
					
					<td class="width-15 active"><label class="pull-right">品牌</label></td>
					<td class="width-15 active"><label class="pull-right">型号</label></td>
					<td class="width-15 active"><label class="pull-right">数量（台/个）</label></td>
					<td class="width-15 active"><label class="pull-right">设备价格（元）</label></td>
					<td class="width-15 active"><label class="pull-right">投入使用年份</label></td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="jhsybylsbpz_sbmc" readOnly="true"  name="jhsybylsbpz_name" id="lcxyq_sbmc" htmlEscape="false"   value="流产吸引器"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jhsybylsbpz_pp" name="jhsybylsbpz_name" id="lcxyq_pp" value="${data.lcxyq.lcxyq_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jhsybylsbpz_xh"  name="jhsybylsbpz_name" id="lcxyq_xh"  value="${data.lcxyq.lcxyq_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jhsybylsbpz_sl"  name="jhsybylsbpz_name" id="lcxyq_sl"  value="${data.lcxyq.lcxyq_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jhsybylsbpz_sbjg"  name="jhsybylsbpz_name" id="lcxyq_sbjg"  value="${data.lcxyq.lcxyq_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jhsybylsbpz_trsynf"  name="jhsybylsbpz_name" id="lcxyq_trsynf"  value="${data.lcxyq.lcxyq_trsynf }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="lcxyq_id"  name="jhsybylsbpz_name" value="${data.lcxyq.lcxyq_id}"  class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="docId"   name="jhsybylsbpz_name" value="${data.doc_id}"  class="form-control "/>
					
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="jhsybylsbpz_sbmc" readOnly="true"  name="jhsybylsbpz_name" id="ksrlssxt_sbmc" htmlEscape="false"   value="可视人流手术系统"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jhsybylsbpz_pp" name="jhsybylsbpz_name" id="ksrlssxt_pp"  value="${data.ksrlssxt.ksrlssxt_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jhsybylsbpz_xh"  name="jhsybylsbpz_name" id="ksrlssxt_xh"  value="${data.ksrlssxt.ksrlssxt_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jhsybylsbpz_sl"  name="jhsybylsbpz_name" id="ksrlssxt_sl"  value="${data.ksrlssxt.ksrlssxt_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jhsybylsbpz_sbjg"  name="jhsybylsbpz_name" id="ksrlssxt_sbjg"  value="${data.ksrlssxt.ksrlssxt_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jhsybylsbpz_trsynf"  name="jhsybylsbpz_name" id="ksrlssxt_trsynf" value="${data.ksrlssxt.ksrlssxt_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="ksrlssxt_id"  name="jhsybylsbpz_name" value="${data.ksrlssxt.ksrlssxt_id}"  class="form-control "/>
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="jhsybylsbpz_sbmc" readOnly="true"  name="jhsybylsbpz_name" id="fkzlc_sbmc" htmlEscape="false"   value="妇科诊疗床"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jhsybylsbpz_pp" name="jhsybylsbpz_name" id="fkzlc_pp"  value="${data.fkzlc.fkzlc_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jhsybylsbpz_xh"  name="jhsybylsbpz_name" id="fkzlc_xh" value="${data.fkzlc.fkzlc_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jhsybylsbpz_sl"  name="jhsybylsbpz_name" id="fkzlc_sl"  value="${data.fkzlc.fkzlc_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jhsybylsbpz_sbjg"  name="jhsybylsbpz_name" id="fkzlc_sbjg" value="${data.fkzlc.fkzlc_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jhsybylsbpz_trsynf"  name="jhsybylsbpz_name" id="fkzlc_trsynf" value="${data.fkzlc.fkzlc_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="fkzlc_id"  name="jhsybylsbpz_name" value="${data.fkzlc.fkzlc_id}"  class="form-control "/>
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="jhsybylsbpz_sbmc" readOnly="true"  name="jhsybylsbpz_name" id="qtqzm_sbmc" htmlEscape="false"   value="其它（请注明）"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jhsybylsbpz_pp" name="jhsybylsbpz_name" id="qtqzm_pp" value="${data.qtqzm.qtqzm_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15"> 
						<input path="jhsybylsbpz_xh"  name="jhsybylsbpz_name" id="qtqzm_xh" value="${data.qtqzm.qtqzm_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jhsybylsbpz_sl"  name="jhsybylsbpz_name" id="qtqzm_sl" value="${data.qtqzm.qtqzm_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="jhsybylsbpz_sbjg"  name="jhsybylsbpz_name" id="qtqzm_sbjg" value="${data.qtqzm.qtqzm_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="jhsybylsbpz_trsynf"  name="jhsybylsbpz_name" id="qtqzm_trsynf" value="${data.qtqzm.qtqzm_trsynf }" htmlEscape="false"    class="form-control "/>
					<input type = "hidden" htmlEscape="false" id="qtqzm_id"  name="jhsybylsbpz_name" value="${data.qtqzm.qtqzm_id}"  class="form-control "/>
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
		var data = document.getElementsByName("jhsybylsbpz_name");
		var datas="";
		for(i=0;i<data.length;i++){
			if(data[i].value==null||data[i].value==""){
				datas = datas +data[i].id+": ---- ;";	
			}else{
				datas = datas +data[i].id+":"+data[i].value+";";	
			}
			
			
		}
	 	
		 $.ajax({
		      url:"${ctx}/ironfojhsybylsbpz/ironfojhsybylsbpz/save",
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