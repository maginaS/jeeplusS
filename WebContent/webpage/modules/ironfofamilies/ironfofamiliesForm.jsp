<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>2.5病种管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		var validateForm;
		function doSubmit(){//回调函数，在编辑和保存动作时，供openDialog调用提交表单。
			
		  if(validateForm.form()){
			  $("#inputForm").submit();
			  return true;
		  }
	
		  return false;
		}
		$(document).ready(function() {
			
			validateForm = $("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
			
		});
	
		
		
		
	   /**
		*
		*	查询基本
		*/
		function queryjbbz(type){
			 var url = location.search;
			 var remark = url.split("&")[1].split("=")[1];
			 $.ajax({  
	                type:'GET',  
	                url:"${ctx}/ironfofamilies/ironfofamilies/query?type="+type+"&bztype="+remark,  
	                cache:false,  
	                dataType:'json',  
	                success:function(data){  
	                	/* alert("success---->"+data); */
	                	console.log(data);
	                	
	                    var code = data.code;
	                    var datas = data.data;
	                  /*   console.log('--code-->'+code);
	                    console.log('--datas-->'+datas); */
	                  	  
	                    if(data.code=="10001"){
	                    	var table = "<table>";
	                    	var i=1;
	                    	table=table+"<tr style='width:100%;'>";
	                    	for(var cd in datas) {
	                    			table=table+"<td style='width:30%;'>";
	                    				 table=table+"&nbsp&nbsp&nbsp<input type='checkbox' value='"+cd+"'>"+datas[cd]+"</input>";
	                    		    table=table+"</td>";
	                    			
	                    		    if(i%3==0){
	                    		    	table=table+"</tr>";
	                    		    }
	                    		 
	                    		i++;		 
	                    		}
	                    	table=table+"</table>";
	                    	table=table+"<table><tr  style='width:100%;'>其它（请注明）:<input type='text'/></tr></table>";
	                    	
	                    	
	                    }else{
	                    	var	table="<table><tr  style='width:100%;'>其它（请注明）:<input type='text'/></tr></table>";
	                    }
	                    
	                    if(type=="JBBZ"){
                   			document.getElementById("ironfo_jbbzList").innerHTML=table;
	                   	}else if(type=="TJBZ"){
	                   		document.getElementById("ironfo_tjbzList").innerHTML=table;
	                   	}
                  	
	                	
	                },  
					error:function(e, s, t){  
/* 						 alert("请求出错。--->e.status--->"+e.status+"|--->e.readyState--->"+e.readyState+"|--->e.responseText--->"+e.responseText+"|--->s--->"+s+"|--->t--->"+t);
 */						console.log("--------------->"+textStatus);
					}
	            });  
			
			
			
		}
		
		
		
		
		
	</script>
</head>
<body class="hideScroll">
	<form:form id="inputForm" modelAttribute="ironfofamilies" action="${ctx}/ironfofamilies/ironfofamilies/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>	
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
					<td class="width-15 active"><label class="pull-right">科室</label></td>
					<td class="width-35">
						<form:input path="dep" readonly="true" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"></td>
		   			<td class="width-35" ></td>
		  		</tr>
		 	</tbody>
		</table>
		
		<div class="tabs-container">
            <ul class="nav nav-tabs">
				<li class="active"><a data-toggle="tab" href="#tab-1" aria-expanded="true" onclick="queryjbbz('JBBZ');">基本病种选项</a>
                </li>
				<li class=""><a data-toggle="tab" href="#tab-2" aria-expanded="false"  onclick="queryjbbz('TJBZ');">推荐病种选项</a>
                </li>
            </ul>
            <div class="tab-content">
				<div id="tab-1" class="tab-pane active">
			<table id="contentTable" class="table table-striped table-bordered table-condensed">
				<thead>
					
				</thead>
				<tbody id="ironfo_jbbzList">
				
				</tbody>
			</table>
			</div>
				<div id="tab-2" class="tab-pane">
				 <table id="contentTable" class="table table-striped table-bordered table-condensed">
				<thead>
					
				</thead>
				<tbody id="ironfo_tjbzList">
				
				</tbody>
			</table>
			</div>
		</div>
		</div>
	</form:form>
</body>
</html>