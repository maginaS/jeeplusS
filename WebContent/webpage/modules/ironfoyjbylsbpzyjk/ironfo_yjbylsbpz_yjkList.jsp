<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title> 药剂科管理</title>
	<meta name="decorator" content="default"/>
	
</head>
<body class="hideScroll">
		<form id="inputForm" modelAttribute="ironfo_yjbylsbpz_yjk" action="${ctx}/ironfoyjbylsbpzyjk/ironfo_yjbylsbpz_yjk/save" method="post" class="form-horizontal">
		<%-- <form:hidden path="id"/>
		<sys:message content="${message}"/>	 --%>
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
					<td class="width-15 active"><label class="pull-right">设备名称：</label></td>
					
					<td class="width-15 active"><label class="pull-right">品牌：</label></td>
					<td class="width-15 active"><label class="pull-right">型号：</label></td>
					<td class="width-15 active"><label class="pull-right">数量（台/个）：</label></td>
					<td class="width-15 active"><label class="pull-right">设备价格（元）：</label></td>
					<td class="width-15 active"><label class="pull-right">投入使用年份：</label></td>
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="yjk_sbmc" readOnly="true"  name="yjkgl_name" id="znfyj_sbmc" htmlEscape="false"  value="智能发药机"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="yjk_pp" name="yjkgl_name" id="znfyj_pp" value="${data.znfyj.znfyj_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="yjk_xh" name="yjkgl_name" id="znfyj_xh" value="${data.znfyj.znfyj_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="yjk_sl" name="yjkgl_name" id="znfyj_sl" value="${data.znfyj.znfyj_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="yjk_sbjg" name="yjkgl_name" id="znfyj_sbjg" value="${data.znfyj.znfyj_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="yjk_trsynf" name="yjkgl_name" id="znfyj_trsynf" value="${data.znfyj.znfyj_trsynf }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="znfyj_id"  name="yjkgl_name" value="${data.znfyj.znfyj_id}"  class="form-control "/>
						 <input type = "hidden" htmlEscape="false" id="docId"   name="kfkgl_name" value="${data.doc_id}"  class="form-control "/>
					
					</td>
				</tr>
				<tr>
					
					<td class="width-15">
						<input path="yjk_sbmc" readOnly="true"  name="yjkgl_name" id="zdxyj_sbmc" htmlEscape="false"  value="自动剥药机"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="yjk_pp" name="yjkgl_name" id="zdxyj_pp" value="${data.zdxyj.zdxyj_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="yjk_xh" name="yjkgl_name" id="zdxyj_xh"  value="${data.zdxyj.zdxyj_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="yjk_sl" name="yjkgl_name" id="zdxyj_sl"  value="${data.zdxyj.zdxyj_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="yjk_sbjg" name="yjkgl_name" id="zdxyj_sbjg"  value="${data.zdxyj.zdxyj_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="yjk_trsynf" name="yjkgl_name" id="zdxyj_trsynf"  value="${data.zdxyj.zdxyj_trsynf }" htmlEscape="false"    class="form-control "/>
					<input type = "hidden" htmlEscape="false" id="zdxyj_id"  name="yjkgl_name" value="${data.zdxyj.zdxyj_id}"  class="form-control "/>
					</td>
				</tr>
				<tr>
					
					<td class="width-15">
						<input path="yjk_sbmc" readOnly="true"  name="yjkgl_name" id="zdfbj_sbmc" htmlEscape="false"  value="自动分包机"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="yjk_pp" name="yjkgl_name" id="zdfbj_pp" value="${data.zdfbj.zdfbj_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="yjk_xh" name="yjkgl_name" id="zdfbj_xh" value="${data.zdfbj.zdfbj_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="yjk_sl" name="yjkgl_name" id="zdfbj_sl" value="${data.zdfbj.zdfbj_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="yjk_sbjg" name="yjkgl_name" id="zdfbj_sbjg" value="${data.zdfbj.zdfbj_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="yjk_trsynf" name="yjkgl_name" id="zdfbj_trsynf" value="${data.zdfbj.zdfbj_trsynf }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="zdfbj_id"  name="yjkgl_name" value="${data.zdfbj.zdfbj_id}"  class="form-control "/>
					</td>
				
				</tr>
				<tr>
					
					<td class="width-15">
						<input path="yjk_sbmc" readOnly="true"  name="yjkgl_name" id="zyjyj_sbmc" htmlEscape="false"  value="中药煎药机"   class="form-control "/>
					</td>
				<td class="width-15">
						<input path="yjk_pp" name="yjkgl_name" id="zyjyj_pp" value="${data.zyjyj.zyjyj_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="yjk_xh" name="yjkgl_name" id="zyjyj_xh" value="${data.zyjyj.zyjyj_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="yjk_sl" name="yjkgl_name" id="zyjyj_sl" value="${data.zyjyj.zyjyj_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="yjk_sbjg" name="yjkgl_name" id="zyjyj_sbjg" value="${data.zyjyj.zyjyj_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="yjk_trsynf" name="yjkgl_name" id="zyjyj_trsynf" value="${data.zyjyj.zyjyj_trsynf }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="zyjyj_id"  name="yjkgl_name" value="${data.zyjyj.zyjyj_id}"  class="form-control "/>
					</td>
				
				</tr>
				<tr>
					
					<td class="width-15">
						<input path="yjk_sbmc" readOnly="true"  name="yjkgl_name" id="zybzj_sbmc" htmlEscape="false"  value="中药包装机"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="yjk_pp" name="yjkgl_name" id="zybzj_pp" value="${data.zybzj.zybzj_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="yjk_xh" name="yjkgl_name" id="zybzj_xh" value="${data.zybzj.zybzj_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="yjk_sl" name="yjkgl_name" id="zybzj_sl" value="${data.zybzj.zybzj_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="yjk_sbjg" name="yjkgl_name" id="zybzj_sbjg" value="${data.zybzj.zybzj_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="yjk_trsynf" name="yjkgl_name" id="zybzj_trsynf" value="${data.zybzj.zybzj_trsynf }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="zybzj_id"  name="yjkgl_name" value="${data.zybzj.zybzj_id}"  class="form-control "/>
					</td>
				
				</tr>
					<tr>
					
					<td class="width-15">
						<input path="yjk_sbmc" readOnly="true"  name="yjkgl_name" id="zyqpj_sbmc"  htmlEscape="false"  value="中药切片机"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="yjk_pp" name="yjkgl_name" id="zyqpj_pp" value="${data.zyqpj.zyqpj_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="yjk_xh" name="yjkgl_name" id="zyqpj_xh" value="${data.zyqpj.zyqpj_xh }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="yjk_sl" name="yjkgl_name" id="zyqpj_sl" value="${data.zyqpj.zyqpj_sl }"   htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="yjk_sbjg" name="yjkgl_name" id="zyqpj_sbjg" value="${data.zyqpj.zyqpj_sbjg }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="yjk_trsynf" name="yjkgl_name" id="zyqpj_trsynf" value="${data.zyqpj.zyqpj_trsynf }"   htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="zyqpj_id"  name="yjkgl_name" value="${data.zyqpj.zyqpj_id}"  class="form-control "/>
					    <input type = "hidden" htmlEscape="false" id="docId"   name="yjkgl_name" value="${data.doc_id}"  class="form-control "/>
					
					</td>
				
				</tr>
					<tr>
					
					<td class="width-15">
						<input path="yjk_sbmc" readOnly="true"  name="yjkgl_name" id="zycyj_sbmc" htmlEscape="false"  value="中药炒药机"   class="form-control "/>
					</td>
					<td class="width-15"> 
						<input path="yjk_pp" name="yjkgl_name" id="zycyj_pp" value="${data.zycyj.zycyj_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="yjk_xh" name="yjkgl_name" id="zycyj_xh"  value="${data.zycyj.zycyj_xh }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="yjk_sl" name="yjkgl_name" id="zycyj_sl"  value="${data.zycyj.zycyj_sl }"   htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="yjk_sbjg" name="yjkgl_name" id="zycyj_sbjg"   value="${data.zycyj.zycyj_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="yjk_trsynf" name="yjkgl_name" id="zycyj_trsynf"  value="${data.zycyj.zycyj_trsynf }"   htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="zycyj_id"  name="yjkgl_name" value="${data.zycyj.zycyj_id}"  class="form-control "/>
					</td>
				
				</tr>
					<tr>
					
					<td class="width-15">
						<input path="yjk_sbmc" readOnly="true"  name="yjkgl_name" id="zyhgj_sbmc" htmlEscape="false"  value="中药烘干机"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="yjk_pp" name="yjkgl_name"  id="zyhgj_pp" value="${data.zyhgj.zyhgj_pp}" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="yjk_xh" name="yjkgl_name"  id="zyhgj_xh" value="${data.zyhgj.zyhgj_xh}" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="yjk_sl" name="yjkgl_name"  id="zyhgj_sl" value="${data.zyhgj.zyhgj_sl}" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="yjk_sbjg" name="yjkgl_name"  id="zyhgj_sbjg" value="${data.zyhgj.zyhgj_sbjg}" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="yjk_trsynf" name="yjkgl_name"  id="zyhgj_trsynf" value="${data.zyhgj.zyhgj_trsynf}" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="zyhgj_id"  name="yjkgl_name" value="${data.zyhgj.zyhgj_id}"  class="form-control "/>
					</td>
				
				</tr>
				<tr>
					
					<td class="width-15">
						<input path="yjk_sbmc" readOnly="true"  name="yjkgl_name" id="zyfsj_sbmc" htmlEscape="false"  value="中药粉碎机"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="yjk_pp" name="yjkgl_name"  id="zyfsj_pp"  value="${data.zyfsj.zyfsj_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="yjk_xh" name="yjkgl_name"  id="zyfsj_xh"  value="${data.zyfsj.zyfsj_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="yjk_sl" name="yjkgl_name"  id="zyfsj_sl"   value="${data.zyfsj.zyfsj_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="yjk_sbjg" name="yjkgl_name"  id="zyfsj_sbjg"  value="${data.zyfsj.zyfsj_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="yjk_trsynf" name="yjkgl_name"  id="zyfsj_trsynf"  value="${data.zyfsj.zyfsj_trsynf }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="zyfsj_id"  name="yjkgl_name" value="${data.zyfsj.zyfsj_id}"  class="form-control "/>
					</td>
				
				</tr>
				<tr>
					
					<td class="width-15">
						<input path="yjk_sbmc" readOnly="true"  name="yjkgl_name" id="yplcg_sbmc" htmlEscape="false"  value="药品冷藏柜"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="yjk_pp" name="yjkgl_name" id="yplcg_pp"  value="${data.yplcg.yplcg_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="yjk_xh" name="yjkgl_name" id="yplcg_xh" value="${data.yplcg.yplcg_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="yjk_sl" name="yjkgl_name" id="yplcg_sl" value="${data.yplcg.yplcg_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="yjk_sbjg" name="yjkgl_name" id="yplcg_sbjg" value="${data.yplcg.yplcg_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="yjk_trsynf" name="yjkgl_name" id="yplcg_trsynf" value="${data.yplcg.yplcg_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="yplcg_id"  name="yjkgl_name" value="${data.yplcg.yplcg_id}"  class="form-control "/>
					</td>
				
				</tr>
				<tr>
					
					<td class="width-15">
						<input path="yjk_sbmc" readOnly="true"  name="yjkgl_name" id="qtqzm_sbmc" htmlEscape="false"  value="其它（请注明）"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="yjk_pp" name="yjkgl_name" id="qtqzm_pp" value="${data.qtqzm.qtqzm_pp}" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="yjk_xh" name="yjkgl_name" id="qtqzm_xh" value="${data.qtqzm.qtqzm_xh}" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="yjk_sl" name="yjkgl_name" id="qtqzm_sl" value="${data.qtqzm.qtqzm_sl}" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="yjk_sbjg" name="yjkgl_name" id="qtqzm_sbjg" value="${data.qtqzm.qtqzm_sbjg}" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="yjk_trsynf" name="yjkgl_name" id="qtqzm_trsynf" value="${data.qtqzm.qtqzm_trsynf}" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="qtqzm_id"  name="yjkgl_name" value="${data.qtqzm.qtqzm_id}"  class="form-control "/>
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
		
		var data = document.getElementsByName("yjkgl_name");
	
		var datas="";
		
		
		for(i=0;i<data.length;i++){
			if(data[i].value==null||data[i].value==""){
				datas = datas +data[i].id+": ---- ;";	
			}else{
				datas = datas +data[i].id+":"+data[i].value+";";	
			}
			
			
		}
	 	
		 $.ajax({
		      url:"${ctx}/ironfoyjbylsbpzyjk/ironfo_yjbylsbpz_yjk/save",
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