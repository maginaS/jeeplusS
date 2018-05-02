<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>3.3住院部医疗设备配置管理</title>
	<meta name="decorator" content="default"/>
</head>
<body class="hideScroll">
		<form id="inputForm" modelAttribute="ironfozyb" action="${ctx}/ironfozyb/ironfozyb/save" method="post" class="form-horizontal">
		<%-- <form:hidden path="id"/>
		<sys:message content="${message}"/>	 --%>
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
		   
		   		<tr>
					注：<br/>
					若同类设备有多台，则依次注明品牌型号、数量、设备价格、投入使用年份。<br/>
					
				</tr>
				
				<tr>
					<td class="width-15 active"><label class="pull-right">设备名称：</label></td>
					<!-- 
					<td class="width-15 active"><label class="pull-right">是否配置：</label></td>
				 -->
					<td class="width-15 active"><label class="pull-right">品牌：</label></td>
					<td class="width-15 active"><label class="pull-right">型号：</label></td>
					<td class="width-15 active"><label class="pull-right">数量（台/个）：</label></td>
					<td class="width-15 active"><label class="pull-right">设备价格（元）：</label></td>
					<td class="width-15 active"><label class="pull-right">投入使用年份：</label></td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="zyb_sbmc" readOnly="true"  name="zybsbgl_name" id="xdtj_sbmc"  htmlEscape="false"   value="心电图机"  class="form-control "/>
					</td>
					
				<%-- 	<td class="width-15">
					        <select class="width-15">
					        	<option>是</option>
					        	<option>否</option>
					        </select>
						<input path="zyb_" name="zybsbgl_name" id="xdtj_sbjg" value="${data.xdtj.xdtj_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td> --%>
					
					<td class="width-15">
						<input path="zyb_pp" name="zybsbgl_name" id="xdtj_pp" value="${data.xdtj.xdtj_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyb_xh" name="zybsbgl_name" id="xdtj_xh" value="${data.xdtj.xdtj_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyb_sl" name="zybsbgl_name" id="xdtj_sl" value="${data.xdtj.xdtj_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="zyb_sbjg" name="zybsbgl_name" id="xdtj_sbjg" value="${data.xdtj.xdtj_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyb_trsynf" name="zybsbgl_name" id="xdtj_trsynf" value="${data.xdtj.xdtj_trsynf }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="xdtj_id"  name="zybsbgl_name" value="${data.xdtj.xdtj_id}"  class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="zyb_sbmc" readOnly="true"  name="zybsbgl_name" id="dtxyjcy_sbmc" htmlEscape="false"   value="动态血压监测仪"  class="form-control "/>
					
					</td>
					
					
					<%-- 	<td class="width-15">
					        <select class="width-15">
					        	<option>是</option>
					        	<option>否</option>
					        </select>
						<input path="zyb_" name="zybsbgl_name" id="xdtj_sbjg" value="${data.xdtj.xdtj_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td> --%>
					
					
					
					<td class="width-15">
						<input path="zyb_pp" name="zybsbgl_name" id="dtxyjcy_pp" value="${data.dtxyjcy.dtxyjcy_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyb_xh" name="zybsbgl_name" id="dtxyjcy_xh"  value="${data.dtxyjcy.dtxyjcy_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyb_sl" name="zybsbgl_name" id="dtxyjcy_sl"  value="${data.dtxyjcy.dtxyjcy_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="zyb_sbjg" name="zybsbgl_name" id="dtxyjcy_sbjg"  value="${data.dtxyjcy.dtxyjcy_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyb_trsynf" name="zybsbgl_name" id="dtxyjcy_trsynf"  value="${data.dtxyjcy.dtxyjcy_trsynf }" htmlEscape="false"    class="form-control "/>
					<input type = "hidden" htmlEscape="false" id="dtxyjcy_id"  name="zybsbgl_name" value="${data.dtxyjcy.dtxyjcy_id}"  class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="zyb_sbmc" readOnly="true"  name="zybsbgl_name" id="dtxdtj_sbmc" htmlEscape="false"   value="动态心电图机"  class="form-control "/>
					</td>
					
					
				<%-- 		<td class="width-15">
					        <select class="width-15">
					        	<option>是</option>
					        	<option>否</option>
					        </select>
						<input path="zyb_" name="zybsbgl_name" id="xdtj_sbjg" value="${data.xdtj.xdtj_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td> --%>
					
					
					<td class="width-15">
						<input path="zyb_pp" name="zybsbgl_name"  id="dtxdtj_pp" value="${data.dtxdtj.dtxdtj_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyb_xh" name="zybsbgl_name"  id="dtxdtj_xh" value="${data.dtxdtj.dtxdtj_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyb_sl" name="zybsbgl_name"  id="dtxdtj_sl"  value="${data.dtxdtj.dtxdtj_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="zyb_sbjg" name="zybsbgl_name"  id="dtxdtj_sbjg" value="${data.dtxdtj.dtxdtj_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyb_trsynf" name="zybsbgl_name"  id="dtxdtj_trsynf" value="${data.dtxdtj.dtxdtj_trsynf }"  htmlEscape="false"    class="form-control "/>
					
					<input type = "hidden" htmlEscape="false" id="dtxdtj_id"  name="zybsbgl_name" value="${data.dtxdtj.dtxdtj_id}"  class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="zyb_sbmc" readOnly="true"  name="zybsbgl_name" id="dtxtjcxt_sbmc" htmlEscape="false"   value="动态血糖监测系统"  class="form-control "/>
					</td>
					
					
				<%-- 	
						<td class="width-15">
					        <select class="width-15">
					        	<option>是</option>
					        	<option>否</option>
					        </select>
						<input path="zyb_" name="zybsbgl_name" id="xdtj_sbjg" value="${data.xdtj.xdtj_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td> --%>
					
					
					<td class="width-15">
						<input path="zyb_pp" name="zybsbgl_name" id="dtxtjcxt_pp" value="${data.dtxtjcxt.dtxtjcxt_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyb_xh" name="zybsbgl_name" id="dtxtjcxt_xh" value="${data.dtxtjcxt.dtxtjcxt_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyb_sl" name="zybsbgl_name" id="dtxtjcxt_sl" value="${data.dtxtjcxt.dtxtjcxt_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="zyb_sbjg" name="zybsbgl_name" id="dtxtjcxt_sbjg" value="${data.dtxtjcxt.dtxtjcxt_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyb_trsynf" name="zybsbgl_name" id="dtxtjcxt_trsynf" value="${data.dtxtjcxt.dtxtjcxt_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="dtxtjcxt_id"  name="zybsbgl_name" value="${data.dtxtjcxt.dtxtjcxt_id}"  class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="zyb_sbmc" readOnly="true"  name="zybsbgl_name" htmlEscape="false" id="zyjhxt_sbmc"   value="中央监护系统"  class="form-control "/>
					</td>
					
					
					<%-- 
						<td class="width-15">
					        <select class="width-15">
					        	<option>是</option>
					        	<option>否</option>
					        </select>
						<input path="zyb_" name="zybsbgl_name" id="xdtj_sbjg" value="${data.xdtj.xdtj_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td> --%>
					
					
					<td class="width-15">
						<input path="zyb_pp" name="zybsbgl_name" htmlEscape="false" id="zyjhxt_pp"  value="${data.zyjhxt.zyjhxt_pp }"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyb_xh" name="zybsbgl_name" htmlEscape="false"  id="zyjhxt_xh"   value="${data.zyjhxt.zyjhxt_xh }"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyb_sl" name="zybsbgl_name" htmlEscape="false"   id="zyjhxt_sl"  value="${data.zyjhxt.zyjhxt_sl }"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="zyb_sbjg" name="zybsbgl_name" htmlEscape="false"  id="zyjhxt_sbjg"   value="${data.zyjhxt.zyjhxt_sbjg }"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyb_trsynf" name="zybsbgl_name" htmlEscape="false"  id="zyjhxt_trsynf"   value="${data.zyjhxt.zyjhxt_trsynf }"  class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="zyjhxt_id"  name="zybsbgl_name" value="${data.zyjhxt.zyjhxt_id}"  class="form-control "/>
					</td>
				</tr>
				
				
				<tr>
					<td class="width-15">
						<input path="zyb_sbmc" readOnly="true"  name="zybsbgl_name" id="dcsjhy_sbmc" htmlEscape="false"   value="多参数监护仪"  class="form-control "/>
					</td>
					
					
					<%-- 	<td class="width-15">
					        <select class="width-15">
					        	<option>是</option>
					        	<option>否</option>
					        </select>
						<input path="zyb_" name="zybsbgl_name" id="xdtj_sbjg" value="${data.xdtj.xdtj_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td> --%>
					
					
					
					
					<td class="width-15">
						<input path="zyb_pp" name="zybsbgl_name" id="dcsjhy_pp" value="${data.dcsjhy.dcsjhy_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyb_xh" name="zybsbgl_name" id="dcsjhy_xh" value="${data.dcsjhy.dcsjhy_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyb_sl" name="zybsbgl_name" id="dcsjhy_sl" value="${data.dcsjhy.dcsjhy_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="zyb_sbjg" name="zybsbgl_name" id="dcsjhy_sbjg" value="${data.dcsjhy.dcsjhy_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyb_trsynf" name="zybsbgl_name" id="dcsjhy_trsynf" value="${data.dcsjhy.dcsjhy_trsynf }"  htmlEscape="false"    class="form-control "/>
					<input type = "hidden" htmlEscape="false" id="dcsjhy_id"  name="zybsbgl_name" value="${data.dcsjhy.dcsjhy_id}"  class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="zyb_sbmc" readOnly="true"  name="zybsbgl_name" id="bfch_sbmc" htmlEscape="false"   value="病房传呼"  class="form-control "/>
					</td>
					
					<%-- 
						<td class="width-15">
					        <select class="width-15">
					        	<option>是</option>
					        	<option>否</option>
					        </select>
						<input path="zyb_" name="zybsbgl_name" id="xdtj_sbjg" value="${data.xdtj.xdtj_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td> --%>
					
					
					
					<td class="width-15">
						<input path="zyb_pp" name="zybsbgl_name" id="bfch_pp" value="${data.bfch.bfch_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyb_xh" name="zybsbgl_name" id="bfch_xh"  value="${data.bfch.bfch_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyb_sl" name="zybsbgl_name" id="bfch_sl"  value="${data.bfch.bfch_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="zyb_sbjg" name="zybsbgl_name" id="bfch_sbjg"  value="${data.bfch.bfch_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyb_trsynf" name="zybsbgl_name" id="bfch_trsynf"  value="${data.bfch.bfch_trsynf }"  htmlEscape="false"    class="form-control "/>
					<input type = "hidden" htmlEscape="false" id="bfch_id"  name="zybsbgl_name" value="${data.bfch.bfch_id}"  class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="zyb_sbmc" readOnly="true"  name="zybsbgl_name" id="ccy_sbmc" htmlEscape="false"   value="除颤仪"  class="form-control "/>
					</td>
					
					
					
				<%-- 		<td class="width-15">
					        <select class="width-15">
					        	<option>是</option>
					        	<option>否</option>
					        </select>
						<input path="zyb_" name="zybsbgl_name" id="xdtj_sbjg" value="${data.xdtj.xdtj_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					 --%>
					
					
					
					
					
					
					
					<td class="width-15">
						<input path="zyb_pp" name="zybsbgl_name"  id="ccy_pp"  value="${data.ccy.ccy_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyb_xh" name="zybsbgl_name"  id="ccy_xh"  value="${data.ccy.ccy_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyb_sl" name="zybsbgl_name"  id="ccy_sl"  value="${data.ccy.ccy_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="zyb_sbjg" name="zybsbgl_name"  id="ccy_sbjg"  value="${data.ccy.ccy_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyb_trsynf" name="zybsbgl_name"  id="ccy_trsynf" value="${data.ccy.ccy_trsynf }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="ccy_id"  name="zybsbgl_name" value="${data.ccy.ccy_id}"  class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="zyb_sbmc" readOnly="true"  name="zybsbgl_name" id="dgnbc_sbmc" htmlEscape="false"   value="多功能病床"  class="form-control "/>
					</td>
					
					
				<%-- 	
					
						<td class="width-15">
					        <select class="width-15">
					        	<option>是</option>
					        	<option>否</option>
					        </select>
						<input path="zyb_" name="zybsbgl_name" id="xdtj_sbjg" value="${data.xdtj.xdtj_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td> --%>
					
					
					
					
					
					
					
					<td class="width-15">
						<input path="zyb_pp" name="zybsbgl_name" id="dgnbc_pp" value="${data.dgnbc.dgnbc_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyb_xh" name="zybsbgl_name" id="dgnbc_xh" value="${data.dgnbc.dgnbc_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyb_sl" name="zybsbgl_name" id="dgnbc_sl" value="${data.dgnbc.dgnbc_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="zyb_sbjg" name="zybsbgl_name" id="dgnbc_sbjg" value="${data.dgnbc.dgnbc_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyb_trsynf" name="zybsbgl_name" id="dgnbc_trsynf" value="${data.dgnbc.dgnbc_trsynf }"  htmlEscape="false"    class="form-control "/>
					<input type = "hidden" htmlEscape="false" id="dgnbc_id"  name="zybsbgl_name" value="${data.dgnbc.dgnbc_id}"  class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="zyb_sbmc" readOnly="true"  name="zybsbgl_name"  id="qtqzm_sbmc"  htmlEscape="false"   value="其它（请注明）"  class="form-control "/>
					</td>
					
					
					<%-- 
						<td class="width-15">
					        <select class="width-15">
					        	<option>是</option>
					        	<option>否</option>
					        </select>
						<input path="zyb_" name="zybsbgl_name" id="xdtj_sbjg" value="${data.xdtj.xdtj_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td> --%>
					
					
					
					
					
					
					<td class="width-15">
						<input path="zyb_pp" name="zybsbgl_name"  id="qtqzm_pp"  value="${data.qtqzm.qtqzm_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyb_xh" name="zybsbgl_name"  id="qtqzm_xh" value="${data.qtqzm.qtqzm_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyb_sl" name="zybsbgl_name"  id="qtqzm_sl" value="${data.qtqzm.qtqzm_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="zyb_sbjg" name="zybsbgl_name"  id="qtqzm_sbjg"  value="${data.qtqzm.qtqzm_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyb_trsynf" name="zybsbgl_name" id="qtqzm_trsynf" value="${data.qtqzm.qtqzm_trsynf }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="qtqzm_id"  name="zybsbgl_name" value="${data.qtqzm.qtqzm_id}"  class="form-control "/>
						 <input type = "hidden" htmlEscape="false" id="docId"   name="zybsbgl_name" value="${data.doc_id}"  class="form-control "/>
					
					</td>
				</tr>
				
		 	</tbody>
		</table>
	</form>
	
	
	
	
	<div style="text-align:right;">
		<input type="button" value="保存"  style="width:100px;height:50px;" onclick="subuimtinput();"/>
	</div>
	
	
	
	<script type="text/javascript">
	function subuimtinput(){
		
		var data = document.getElementsByName("zybsbgl_name");
	
		var datas="";
		
		
		for(i=0;i<data.length;i++){
			if(data[i].value==null||data[i].value==""){
				datas = datas +data[i].id+": ---- ;";	
			}else{
				datas = datas +data[i].id+":"+data[i].value+";";	
			}
			
			
		}
	 	
		 $.ajax({
		      url:"${ctx}/ironfozyb/ironfozyb/save",
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