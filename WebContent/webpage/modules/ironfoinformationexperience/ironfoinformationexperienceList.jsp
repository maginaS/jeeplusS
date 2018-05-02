<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>4.3信息化系统使用体验管理</title>
	<meta name="decorator" content="default"/>
</head>
<body class="hideScroll">
		<form id="inputForm" modelAttribute="ironfoinformationexperience" action="${ctx}/ironfoinformationexperience/ironfoinformationexperience/save" method="post" class="form-horizontal">
		<%-- <form:hidden path="id"/>
		<sys:message content="${message}"/>	 --%>
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				
				<tr>
					注： <br/>
					便捷性体验、功能性体验、观感性体验：①良好②好③一般④差⑤很差<br/>
					
				</tr>
				<tr>
					<td class="width-33 active"><label class="pull-right">便捷性体验</label></td>
					
					<td class="width-33 active"><label class="pull-right">功能性体验</label></td>
					
					<td class="width-33 active"><label class="pull-right">观感性体验</label></td>
					
					
					
				</tr>
				<tr>
					<td class="width-33">
 						<select  class="form-control " id="bjxty_select_id" >
 							<option  ${data.datas.bjxty eq '1'?'selected':''}  value="1">良好</option>
 							<option  ${data.datas.bjxty eq '2'?'selected':''}  value="2">好</option>
 							<option  ${data.datas.bjxty eq '3'?'selected':''}  value="3">一般</option>
 							<option  ${data.datas.bjxty eq '4'?'selected':''}  value="4">差</option>
 							<option  ${data.datas.bjxty eq '5'?'selected':''}  value="5">很差</option>
 						</select>
 
 					</td>
					<td class="width-33">
 
 						<select class="form-control " id="gnxty_select_id">
 							<option  ${data.datas.gnxty eq '1'?'selected':''} value="1">良好</option>
 							<option  ${data.datas.gnxty eq '2'?'selected':''} value="2">好</option>
 							<option  ${data.datas.gnxty eq '3'?'selected':''} value="3">一般</option>
 							<option  ${data.datas.gnxty eq '4'?'selected':''} value="4">差</option>
 							<option  ${data.datas.gnxty eq '5'?'selected':''} value="5">很差</option>
 						</select>
 
 
 					</td>
					<td class="width-33">
 
 						<select class="form-control " id="ggxty_select_id">
 							<option  ${data.datas.ggxty eq '1'?'selected':''} value="1">良好</option>
 							<option  ${data.datas.ggxty eq '2'?'selected':''} value="2">好</option>
 							<option  ${data.datas.ggxty eq '3'?'selected':''} value="3">一般</option>
 							<option  ${data.datas.ggxty eq '4'?'selected':''} value="4">差</option>
 							<option  ${data.datas.ggxty eq '5'?'selected':''} value="5">很差</option>
 						</select>
 
 
					<input type = "hidden" htmlEscape="false" id="id"  value="${data.datas.id }"  name="information_experience"   class="form-control "/>
 					<input type = "hidden" htmlEscape="false" id="docId" value="${data.doc_id }"   name="information_experience"   class="form-control "/>
					
					
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
	
		var bjxty = document.getElementById("bjxty_select_id").value;
		var gnxty = document.getElementById("gnxty_select_id").value;
		var ggxty = document.getElementById("ggxty_select_id").value;
		var data = document.getElementsByName("information_experience");
	
	
		
		var datas="";
		datas = datas+"bjxty:"+bjxty+";gnxty:"+gnxty+";ggxty:"+ggxty+";";
		
	
		if(data[0].value==null||data[0].value==""){
			datas = datas +data[0].id+": ---- ;";	
		}else{
			datas = datas +data[0].id+":"+data[0].value+";";	
		}
	
		if(data[1].value==null||data[1].value==""){
			datas = datas +data[1].id+": ---- ;";	
		}else{
			datas = datas +data[1].id+":"+data[1].value+";";	
		}

	 	 $.ajax({
		      url:"${ctx}/ironfoinformationexperience/ironfoinformationexperience/save",
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