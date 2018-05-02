<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>4.5信息化系统配套硬件管理</title>
	<meta name="decorator" content="default"/>
<!-- 	<script type="text/javascript">
	//方法2
		$('inputp[name=checkbox]').click(function(){
		 $(this).attr('checked','checked').siblings().removeAttr('checked');
		});
	</script> -->
	
</head>
<body class="hideScroll">
		<form id="inputForm" modelAttribute="ironfoinformationhardware" action="${ctx}/ironfoinformationhardware/ironfoinformationhardware/save" method="post" class="form-horizontal">
	
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
					<td class="width-33 active"><label class="pull-right">信息系统机房</label></td>
					
					<td class="width-33 active"><label class="pull-right">信息系统机房面积（m2）</label></td>
					
					<td class="width-33 active"><label class="pull-right">服务器（台）</label></td>
					
				</tr>
				<tr>
					<td class="width-33" >
						<select  class="form-control"  id="xxxtjf">
							<option ${data.datas.xxxtjf eq '1'?'selected':''} value="1">有</option>
							<option ${data.datas.xxxtjf eq '2'?'selected':''} value="2">无</option>
						</select>
 					</td>
					<td class="width-33">
						<input path="xtjfmj" id="xtjfmj" name="ironfoinformationhardware_name" value="${data.datas.xtjfmj }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-33">
						<input path="fwq" id="fwq" name="ironfoinformationhardware_name" value="${data.datas.fwq }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="ironfoinformationhardware_name_id"   name="ironfoinformationhardware_name_id" value="${data.datas.id}"  class="form-control "/>
 						<input type = "hidden" htmlEscape="false" id="ironfoinformationhardware_name_docid"   name="ironfoinformationhardware_name_docid" value="${data.doc_id}"  class="form-control "/>
					
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
		
		var docId = document.getElementById("ironfoinformationhardware_name_docid").value;
		var id= document.getElementById("ironfoinformationhardware_name_id").value; 
		
		var xxxtjf = document.getElementById("xxxtjf").value;
		
		var datas="";
		if(xxxtjf==1){
			
			var data = document.getElementsByName("ironfoinformationhardware_name");
			
		
			
			for(i=0;i<data.length;i++){
				if(data[i].value==null||data[i].value==""){
					datas = datas +data[i].id+": ---- ;";	
				}else{
					datas = datas +data[i].id+":"+data[i].value+";";	
				}
				
				
			}
			
		}else{
			datas=datas+"xtjfmj:----;fwq:----;"
			
		}
		datas=datas+"xxxtjf:"+xxxtjf+";";
		
	 	
		 $.ajax({
		      url:"${ctx}/ironfoinformationhardware/ironfoinformationhardware/save",
		      data:{
		    	  datas:datas,
		    	  docId:docId,
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