<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>3.6其他科室医疗设备配置管理</title>
	<meta name="decorator" content="default"/>
</head>
<body class="hideScroll">
		<form id="inputForm" modelAttribute="ironfoqtkspz" action="${ctx}/ironfoqtkspz/ironfoqtkspz/save" method="post" class="form-horizontal">
	
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
						<input path="qtkspz_sbmc" readOnly="true"  htmlEscape="false" name="qtkssz_name" id="qtqzm_sbmc"  value="其它（请注明）"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="qtkspz_pp" htmlEscape="false"  name="qtkssz_name"  id="qtqzm_pp"  value="${data.qtqzm.qtqzm_pp }"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="qtkspz_xh" htmlEscape="false"  name="qtkssz_name"   id="qtqzm_xh"   value="${data.qtqzm.qtqzm_xh }"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="qtkspz_sl" htmlEscape="false"   name="qtkssz_name"  id="qtqzm_sl"    value="${data.qtqzm.qtqzm_sl }" class="form-control "/>
					</td>
					<td class="width-15">
						<input path="qtkspz_sbjg" htmlEscape="false"  name="qtkssz_name"  id="qtqzm_sbjg"    value="${data.qtqzm.qtqzm_sbjg }"  class="form-control "/>
					</td>
					
					<td class="width-15">
					
<!-- 							<input type="text" name="qtkssz_name" id="qtqzm_trsynf" onclick="WdatePicker({dateFmt:'yyyy-MM'})"/>
 --> 						<input path="qtkspz_trsynf" htmlEscape="false"   name="qtkssz_name"  id="qtqzm_trsynf"    value="${data.qtqzm.qtqzm_trsynf }" class="form-control "/>
 						<input type = "hidden" htmlEscape="false" id="qtqzm_id"  name="qtkssz_name" value="${data.qtqzm.qtqzm_id}"  class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="docId"   name="qtkssz_name" value="${data.doc_id}"  class="form-control "/>
					
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
		
		var data = document.getElementsByName("qtkssz_name");
		/* document */
	
		var datas="";
		
		
		for(i=0;i<data.length;i++){
			if(data[i].value==null||data[i].value==""){
				datas = datas +data[i].id+": ---- ;";	
			}else{
				datas = datas +data[i].id+":"+data[i].value+";";	
			}
			
			
		}
	 	
		 $.ajax({
		      url:"${ctx}/ironfoqtkspz/ironfoqtkspz/save",
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