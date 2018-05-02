<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>2.6外科、妇（产）科病种	管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		
		$(document).ready(function() {	
			queryjbbz("JBBZ");
		});
		
		function queryjbbz(type){
			
			 $.ajax({  
	                type:'GET',  
	                url:"${ctx}/ironfofamilies/ironfofamilies/query?type=JBBZ,TJBZ&bztype=5",  
	                cache:false,  
	                dataType:'json',  
	                success:function(data){  
	                	
	                	<%
	                	Object data = request.getAttribute("data");
	                	java.util.Map map = (java.util.Map)data;
	                	System.out.println(map);
	                	%>
	                	
	                	
	                	  var code = data.code;
		                  var datas = data.data;
		                  if(data.code=="10001"){
		                	  
		                	  //外科妇产科推荐病种
		                	  
		                	  var table = "<table>";
		                	  var i=1;
		                		table=table+"<tr>";
		                		for(var cd in datas.WKFCK_TJBZ) {
		                			table=table+"<td>";
              						 	table=table+"&nbsp&nbsp&nbsp<input type='checkbox' name='wkfcktjbz_name' id='"+cd+"' value='"+cd+"' style='margin-top: -2px'>"+datas.WKFCK_TJBZ[cd]+"</input>";
              						table=table+"</td>";
              						
              					  if(i%3==0){
	                    		    	table=table+"</tr>";
	                    		    }
  	                    		i++;	
		                			
		                		}
		                		
		                		 table=table+"</table>";
		                    	 table=table+"<table><tr  style='width:100%;'>其它（请注明）:<input type='text' value='${data.wkfcktjbztext}' id='wkfcktjbz_name_text'  name='wkfcktjbz_name_text' /></tr></table>";
		                    	
		                    	 document.getElementById("ironfo_wkfck_tjbzList").innerHTML=table;
		                    	 
		                    	 
		                    	 var wkfckjbbz = "<table>";
		                    	 var j=1;
		                    	 wkfckjbbz=wkfckjbbz+"<tr>";
		                    	 for(var cd in datas.WKFCK_JBBZ) {
		                    		 wkfckjbbz=wkfckjbbz+"<td>";
		                    			 wkfckjbbz=wkfckjbbz+"&nbsp&nbsp&nbsp<input type='checkbox' name='wkfckjbbz_name' id='"+cd+"' value='"+cd+"' style='margin-top: -2px'>"+datas.WKFCK_JBBZ[cd]+"</input>";
		                    		 wkfckjbbz=wkfckjbbz+"</td>";
		                    		 
		                    		    if(j%3==0){
		                    		    	wkfckjbbz=wkfckjbbz+"</tr>";
		                    		    }
		                    		 
		                    		j++;	
                			
		                    		 
		                    	 }
		                    	 
		                    	 wkfckjbbz=wkfckjbbz+"</table>";
		                    	 wkfckjbbz=wkfckjbbz+"<table><tr  style='width:100%;'>其它（请注明）:<input type='text' id='wkfckjbbz_name_text' value='${data.wkfckjbbztext}'  name='wkfckjbbz_name_text' /></tr></table>";
		                    	
		                    	 document.getElementById("ironfo_wkfck_jbbzList").innerHTML=wkfckjbbz;
		                    	  
		                  }
		                  
		                  
		                	var wkfcktjbzcheckbox = <%=map.get("wkfcktjbz")%>;
		                	var wkfckjbbzcheckbox = <%=map.get("wkfckjbbz")%>;
		                	
		                	
		                	var wkfcktjbzbox = document.getElementsByName("wkfcktjbz_name");
		                	  
		                	for(var a=0;a<wkfcktjbzcheckbox.length;a++){
		                		for(var i=0;i<wkfcktjbzbox.length;i++){
									if(wkfcktjbzcheckbox[a] == wkfcktjbzbox[i].value){
										wkfcktjbzbox[i].checked = "checked";
		                				
		                			}
		                		}
		                			
		                	}
		                	
		                	
		                	var wkfckjbbzbox = document.getElementsByName("wkfckjbbz_name");
		                	for(var a=0;a<wkfckjbbzcheckbox.length;a++){
		                		for(var i=0;i<wkfckjbbzbox.length;i++){
									if(wkfckjbbzcheckbox[a] == wkfckjbbzbox[i].value){
										wkfckjbbzbox[i].checked = "checked";
		                				
		                			}
		                		}	
		                	}
	                	
	                },
	                error:function(e, s, t){  
						console.log("--------------->"+textStatus);
					}
			   });  
			
		}
	</script>
</head>
<body class="hideScroll">
		<form id="inputForm" modelAttribute="ironfobzwkfck" action="${ctx}/ironfobzwkfck/ironfobzwkfck/save" method="post" class="form-horizontal">
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
		   
		   		<tr>
					<td style="width:10px">科室</td>
					<td style="width:200px">基本病种</td>
					<td style="width:200px">推荐病种</td>
					
					<input type="hidden" htmlEscape="false" id="wkfckjbbz__name_id"   name="wkfckjbbz__name_id" value="${data.id}"  class="form-control "/>
					<input type="hidden" name="wkfckjbbz__name_docid"  id="wkfckjbbz__name_docid"  value="${data.doc_id}" htmlEscape="false"    class="form-control "/>
				</tr>
				
				<tr>
					<td  style="width:10px">外科、妇（产）科</td>
					<td  style="width:180px">
						<table id="ironfo_wkfck_jbbzList">
											
						</table>
					</td>
					 <td  style="width:180px">
						 <table id="ironfo_wkfck_tjbzList">
				
						</table> 
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
		
		
		var wkfcktjbzData;
		var wkfckjbbzData;
	
		
		 var wkfcktjbzName = document.getElementsByName("wkfcktjbz_name");
		 var wkfcktjbz_text=document.getElementById("wkfcktjbz_name_text").value; 
		 var wkfcktjbz = [];
		    for(k in wkfcktjbzName){
		        if(wkfcktjbzName[k].checked)
		        	wkfcktjbz.push(wkfcktjbzName[k].value);
		        	
		        
		        	
		    }
		    wkfcktjbzData=wkfcktjbz;
		    
		    
		    var wkfckjbbzName = document.getElementsByName("wkfckjbbz_name");
		    var wkfckjbbz_text=document.getElementById("wkfckjbbz_name_text").value; 
		    var wkfckjbbz = [];
		    for(k in wkfckjbbzName){
		        if(wkfckjbbzName[k].checked){
		        	wkfckjbbz.push(wkfckjbbzName[k].value);
		        	}
		        
		    }
		    wkfckjbbzData=wkfckjbbz;
		    
		    
		
		
		   var docId = document.getElementById("wkfckjbbz__name_docid").value;
		   var id= document.getElementById("wkfckjbbz__name_id").value; 
		   var jsonektjbz = JSON.stringify(wkfcktjbzData);
		   var jsonekjbbz = JSON.stringify(wkfckjbbzData);
		 
		
		 $.ajax({
		      url:"${ctx}/ironfobzwkfck/ironfobzwkfck/save",
		      data:{
		    	  jsonektjbz:jsonektjbz,
		    	  wkfckjbbz_text:wkfckjbbz_text,
		    	  jsonekjbbz:jsonekjbbz,
		    	  wkfcktjbz_text:wkfcktjbz_text,
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