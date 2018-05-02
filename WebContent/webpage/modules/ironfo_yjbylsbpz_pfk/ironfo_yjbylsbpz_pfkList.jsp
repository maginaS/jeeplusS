<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>皮肤科管理</title>
	<meta name="decorator" content="default"/>
	
</head>
<body class="hideScroll">
		<form id="inputForm" modelAttribute="ironfo_yjbylsbpz_pfk" action="${ctx}/ironfo_yjbylsbpz_pfk/ironfo_yjbylsbpz_pfk/save" method="post" class="form-horizontal">
		<%-- <form:hidden path="id"/>
		<sys:message content="${message}"/>	 --%>
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
		
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
						<input path="pfk_sbmc" id="jgzly_sbmc" name="pfkname" htmlEscape="false"  readOnly="true"  value="激光治疗仪"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pfk_pp"  value="${data.jgzly.jgzly_pp}"   id="jgzly_pp" name="pfkname"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="pfk_xh"  value="${data.jgzly.jgzly_xh}"    id="jgzly_xh" name="pfkname"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="pfk_sl"  value="${data.jgzly.jgzly_sl}"    id="jgzly_sl" name="pfkname"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pfk_sbjg"   value="${data.jgzly.jgzly_sbjg}"   id="jgzly_sbjg" name="pfkname"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="pfk_trsynf"  value="${data.jgzly.jgzly_trsynf}"    id="jgzly_trsynf" name="pfkname"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="jgzly_id"   name="pfkname" value="${data.jgzly.jgzly_id}"  class="form-control "/>
 						<input type = "hidden" htmlEscape="false" id="docId"   name="pfkname" value="${data.doc_id}"  class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="pfk_sbmc" id="hgzly_sbmc" name="pfkname"  htmlEscape="false"  readOnly="true"  value="红光治疗仪"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pfk_pp"   value="${data.hgzly.hgzly_pp}"  id="hgzly_pp"  name="pfkname"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="pfk_xh"  value="${data.hgzly.hgzly_xh}"   id="hgzly_xh" name="pfkname"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="pfk_sl"  value="${data.hgzly.hgzly_sl}"   id="hgzly_sl"  name="pfkname"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pfk_sbjg"  value="${data.hgzly.hgzly_sbjg}"   id="hgzly_sbjg"  name="pfkname"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="pfk_trsynf"   value="${data.hgzly.hgzly_trsynf}"  id="hgzly_trsynf"  name="pfkname"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="hgzly_id"   name="pfkname" value="${data.hgzly.hgzly_id}"  class="form-control "/>
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="pfk_sbmc" id="lgzly_sbmc"  name="pfkname"  htmlEscape="false"  readOnly="true"  value="蓝光治疗仪"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pfk_pp"  value="${data.lgzly.lgzly_pp}"   id="lgzly_pp" name="pfkname"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="pfk_xh" value="${data.lgzly.lgzly_xh}"   id="lgzly_xh"  name="pfkname"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="pfk_sl" value="${data.lgzly.lgzly_sl}"   id="lgzly_sl"  name="pfkname"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pfk_sbjg" value="${data.lgzly.lgzly_sbjg}"   id="lgzly_sbjg"  name="pfkname"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="pfk_trsynf" value="${data.lgzly.lgzly_trsynf}"   id="lgzly_trsynf"  name="pfkname"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="lgzly_id"   name="pfkname" value="${data.lgzly.lgzly_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="pfk_sbmc" id="zwzly_sbmc" name="pfkname"  htmlEscape="false"  readOnly="true"  value="紫外治疗仪"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pfk_pp" value="${data.zwzly.zwzly_pp}"   id="zwzly_pp" name="pfkname"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="pfk_xh" value="${data.zwzly.zwzly_xh}"  id="zwzly_xh"  name="pfkname"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="pfk_sl" value="${data.zwzly.zwzly_sl}"  id="zwzly_sl"  name="pfkname"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pfk_sbjg" value="${data.zwzly.zwzly_sbjg}"  id="zwzly_sbjg"  name="pfkname"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="pfk_trsynf" value="${data.zwzly.zwzly_trsynf}"  id="zwzly_trsynf" name="pfkname"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="zwzly_id"   name="pfkname" value="${data.zwzly.zwzly_id}"  class="form-control "/>
				
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="pfk_sbmc" id="ytzlq_sbmc"  name="pfkname"  htmlEscape="false"  readOnly="true"  value="液氮冷疗器"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pfk_pp" value="${data.ytzlq.ytzlq_pp}"  id="ytzlq_pp"    name="pfkname"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="pfk_xh" value="${data.ytzlq.ytzlq_xh}"  id="ytzlq_xh"    name="pfkname"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="pfk_sl" value="${data.ytzlq.ytzlq_sl}"  id="ytzlq_sl"    name="pfkname"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pfk_sbjg" value="${data.ytzlq.ytzlq_sbjg}"  id="ytzlq_sbjg"    name="pfkname"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="pfk_trsynf" value="${data.ytzlq.ytzlq_trsynf}"  id="ytzlq_trsynf"    name="pfkname"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="ytzlq_id"   name="pfkname" value="${data.ytzlq.ytzlq_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="pfk_sbmc"  id="qtqzm_sbmc"  name="pfkname"  htmlEscape="false"  readOnly="true"  value="其它（请注明）"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pfk_pp" value="${data.qtqzm.qtqzm_pp}"  id="qtqzm_pp" name="pfkname"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="pfk_xh" value="${data.qtqzm.qtqzm_xh}" id="qtqzm_xh"  name="pfkname"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="pfk_sl" value="${data.qtqzm.qtqzm_sl}" id="qtqzm_sl" name="pfkname"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pfk_sbjg" value="${data.qtqzm.qtqzm_sbjg}" id="qtqzm_sbjg"  name="pfkname"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="pfk_trsynf" value="${data.qtqzm.qtqzm_trsynf}" id="qtqzm_trsynf"  name="pfkname"  htmlEscape="false"    class="form-control "/>
					    <input type = "hidden" htmlEscape="false" id="qtqzm_id"   name="pfkname" value="${data.qtqzm.qtqzm_id}"  class="form-control "/>
					
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
		
		var data = document.getElementsByName("pfkname");
	
		var datas="";
		
		
		for(i=0;i<data.length;i++){
			if(data[i].value==null||data[i].value==""){
				datas = datas +data[i].id+": ---- ;";	
			}else{
				datas = datas +data[i].id+":"+data[i].value+";";	
			}
			
			
		}
	 	
		 $.ajax({
		      url:"${ctx}/ironfo_yjbylsbpz_pfk/ironfo_yjbylsbpz_pfk/save",
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