<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>2.5内科、儿科病种管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
	
	
	$(document).ready(function() {
		
		
		queryjbbz("JBBZ");	
	});
	
	   /**
		*
		*	查询基本
		*/
		function queryjbbz(type){
			 $.ajax({  
	                type:'GET',  
	                url:"${ctx}/ironfofamilies/ironfofamilies/query?type=JBBZ,TJBZ&bztype=2,4",  
	                cache:false,  
	                dataType:'json',  
	                success:function(data){  
	                	
	                
	                	
	                
	                	
	                
	                    var code = data.code;
	                    var datas = data.data;
	                  	  
	                    if(data.code=="10001"){
	                    	
	                    	//儿科推荐病种
	                    	var table = "<table>";
	                    	var i=1;
	                    	table=table+"<tr>";
	                    	/* <input type='checkbox' value='gxyb' id='gxyb' style='margin-top: -2px'> */
	                    	for(var cd in datas.EK_TJBZ) {
	                    			table=table+"<td>";
                   						 table=table+"&nbsp&nbsp&nbsp<input type='checkbox' name='ektjbz_name' id='"+cd+"' value='"+cd+"' style='margin-top: -2px'>"+datas.EK_TJBZ[cd]+"</input>";

	                    		    table=table+"</td>";
	                    			
	                    		    if(i%3==0){
	                    		    	table=table+"</tr>";
	                    		    }
	                    		 
	                    		i++;		 
	                    		}
	                    	 table=table+"</table>";
	                    	 table=table+"<table><tr  style='width:100%;'>其它（请注明）:<input type='text' id='ektjbz_name_text' value='${data.ektjbzText}' name='ektjbz_name_text' /></tr></table>";
	                    	
	                    	 document.getElementById("ironfo_ek_tjbzList").innerHTML=table;
	                    	
	                    	 
	                    	 //儿科基本病种
	                    	 var ekjbbz = "<table>";
	                    	 var j=1;
	                    	 ekjbbz=ekjbbz+"<tr>";
	                    	 for(var cd in datas.EK_JBBZ) {
	                    		 	ekjbbz=ekjbbz+"<td>";
			                    		 		ekjbbz=ekjbbz+"&nbsp&nbsp&nbsp<input type='checkbox' name='ekjbbz_name' id='"+cd+"' value='"+cd+"' style='margin-top: -2px'>"+datas.EK_JBBZ[cd]+"</input>";

	                    		 	ekjbbz=ekjbbz+"</td>";
	                    			
	                    		    if(j%3==0){
	                    		    	ekjbbz=ekjbbz+"</tr>";
	                    		    }
	                    		 
	                    		j++;		 
	                    		}
	                    	 ekjbbz=ekjbbz+"</table>";
	                    	 ekjbbz=ekjbbz+"<table><tr  style='width:100%;'>其它（请注明）:<input type='text' id='ekjbbz_name_text' value='${data.ekjbbzText}' name='ekjbbz_name_text' /></tr></table>";
	                    	
	                    	 document.getElementById("ironfo_ek_jbbzList").innerHTML=ekjbbz;
	                    	
	                    	 
	                    	 //内科基本病种
	                    	 var nkjbbz= "<table>";
	                    	 var k=1;
	                    	 nkjbbz=nkjbbz+"<tr>";
	                    	 for(var cd in datas.NK_JBBZ) {
		                    		 nkjbbz=nkjbbz+"<td>";
		                    			 nkjbbz=nkjbbz+"&nbsp&nbsp&nbsp<input type='checkbox' name='nkjbbz_name' id='"+cd+"' value='"+cd+"' style='margin-top: -2px'>"+datas.NK_JBBZ[cd]+"</input>";
		                    		 nkjbbz=nkjbbz+"</td>";
	                    			
	                    		    if(k%3==0){
	                    		    	nkjbbz=nkjbbz+"</tr>";
	                    		    }
	                    		 
	                    		k++;		 
	                    		}
	                    	 nkjbbz=nkjbbz+"</table>";
	                    	 nkjbbz=nkjbbz+"<table><tr  style='width:100%;'>其它（请注明）:<input type='text' id='nkjbbz_name_text' value='${data.nkjbbzText}' name='nkjbbz_name_text'/></tr></table>";
	                    	
	                    	 document.getElementById("ironfo_nk_jbbzList").innerHTML=nkjbbz;
	                    	
	                    	 
	                    	 
	                    	 //内科推荐病种
	                    	 var nktjbz= "<table>";
	                    	 var l=1;
	                    	 nktjbz=nktjbz+"<tr>";
	                    		for(var cd in datas.NK_TJBZ) {		
	                    					nktjbz=nktjbz+"<td>";
		                    					 nktjbz=nktjbz+"&nbsp&nbsp&nbsp<input type='checkbox' name='nktjzbz_name' id='"+cd+"' value='"+cd+"' style='margin-top: -2px'>"+datas.NK_TJBZ[cd]+"</input>";
	                    				 	nktjbz=nktjbz+"</td>";
	                    			
	                    		    if(l%3==0){
	                    		    	nktjbz=nktjbz+"</tr>";
	                    		    }
	                    		 
	                    		l++;		 
	                    		}
	                    	 nktjbz=nktjbz+"</table>";
	                    	 nktjbz=nktjbz+"<table><tr  style='width:100%;'>其它（请注明）:<input type='text' id='nktjzbz_name_text' value='${data.nktjbzText}' name='nktjzbz_name_text'/></tr></table>";
	                    	
	                    	 document.getElementById("ironfo_nk_tjbzList").innerHTML=nktjbz; 
	                    }
	                    
	                    
	                	<%
	                	Object data = request.getAttribute("data");
	                	java.util.Map map = (java.util.Map)data;
	                	System.out.println(map);
	                	
	                	%>
	                    
	                    
	                	var ektjbzcheckbox = <%=map.get("ektjbz")%>;
	                	var ekjbbzcheckbox = <%=map.get("ekjbbz")%>;
	                	var nktjbzcheckbox = <%=map.get("nktjbz")%>;
	                	var nkjbbzcheckbox = <%=map.get("nkjbbz")%>;
	                	
	                	
	                	
	                	
	                	
	                	var nktjbzbox = document.getElementsByName("nktjzbz_name");
	                	  
	                	for(var a=0;a<nktjbzcheckbox.length;a++){
	                		for(var i=0;i<nktjbzbox.length;i++){
								if(nktjbzcheckbox[a] == nktjbzbox[i].value){
									nktjbzbox[i].checked = "checked";
	                				
	                			}
	                		}
	                			
	                	}
	                	
	                	var ektjbzbox = document.getElementsByName("ektjbz_name");
	                	for(var a=0;a<ektjbzcheckbox.length;a++){
	                		for(var i=0;i<ektjbzbox.length;i++){
								if(ektjbzcheckbox[a] == ektjbzbox[i].value){
									ektjbzbox[i].checked = "checked";
	                				
	                			}
	                		}	
	                	}
	                	
	                	var ekjbbzbox = document.getElementsByName("ekjbbz_name");
	                	for(var a=0;a<ekjbbzcheckbox.length;a++){
	                		for(var i=0;i<ekjbbzbox.length;i++){
								if(ekjbbzcheckbox[a] == ekjbbzbox[i].value){
									ekjbbzbox[i].checked = "checked";
	                				
	                			}
	                		}	
	                	}
	                	
	                	
	                	var nkjbbzbox = document.getElementsByName("nkjbbz_name");
	                	
	                	for(var a=0;a<nkjbbzcheckbox.length;a++){
	                		for(var i=0;i<nkjbbzbox.length;i++){
								if(nkjbbzcheckbox[a] == nkjbbzbox[i].value){
									nkjbbzbox[i].checked = "checked";
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
<body class="hideScroll"  onload='setTimeout("functioncheckbox()",1000)'>
		<form id="inputForm" modelAttribute="ironfobznkekbz" action="${ctx}/ironfobznkekbz/ironfobznkekbz/save" method="post" class="form-horizontal">
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
					<td style="width:10px">科室</td>
					<td style="width:200px">基本病种</td>
					<td style="width:200px">推荐病种</td>
					
					<input type="hidden" htmlEscape="false" id="nkjbbz__name_id"   name="nkjbbz__name_id" value="${data.id}"  class="form-control "/>
					<input type="hidden" name="nkjbbz__name_docid"  id="nkjbbz__name_docid"  value="${data.doc_id}" htmlEscape="false"    class="form-control "/>
						
					
				</tr>
				<tr>
					<td  style="width:10px">内科</td>
					<td  style="width:180px">
						<table id="ironfo_nk_jbbzList">
											
						</table>
					</td>
					 <td  style="width:180px">
						 <table id="ironfo_nk_tjbzList">
				
						</table> 
					</td>
					
					
		  		</tr>
		  		<tr>
					<td  style="width:10px">儿科</td>
					<td  style="width:180px">
						<table id="ironfo_ek_jbbzList">
											
						</table>
					</td>
					 <td  style="width:180px">
						 <table id="ironfo_ek_tjbzList">
				
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
		
		
		var ektjbzData;
		var ekjbbzData;
		var nkjbbzData;
		var nktjbzData;
		
		var	ektjbzName = document.getElementsByName("ektjbz_name");
		 var ektjbz_text=document.getElementById("ektjbz_name_text").value; 
		   var ektjbz = [];
		    for(k in ektjbzName){
		        if(ektjbzName[k].checked)
		        	ektjbz.push(ektjbzName[k].value);
		        	
		        
		        	
		    }
		    ektjbzData=ektjbz;
		    
		    
		 var   ekjbbzName = document.getElementsByName("ekjbbz_name");
		    var ekjbbz_text=document.getElementById("ekjbbz_name_text").value; 
		   var ekjbbz = [];
		    for(k in ekjbbzName){
		        if(ekjbbzName[k].checked){
		        		ekjbbz.push(ekjbbzName[k].value);
		        	}
		        
		    }
		    ekjbbzData=ekjbbz;
		    
		    
		  var  nkjbbzName = document.getElementsByName("nkjbbz_name");
		  var nkjbbz_text=document.getElementById("nkjbbz_name_text").value; 
		  var  nkjbbz = [];
		    for(k in nkjbbzName){
		        if(nkjbbzName[k].checked){
		        	nkjbbz.push(nkjbbzName[k].value);
		        }
		        	
		    }
		    nkjbbzData=nkjbbz;
		    
		    
		  var  nktjbzName = document.getElementsByName("nktjzbz_name");
		    var nktjzbz_text=document.getElementById("nktjzbz_name_text").value; 
		   var nktjbz = [];
		    for(k in nktjbzName){
		        if(nktjbzName[k].checked){
		        	nktjbz.push(nktjbzName[k].value);
		        	
		        }
		        	
		    }
		    nktjbzData=nktjbz;
		
		   var docId = document.getElementById("nkjbbz__name_docid").value;
		   var id= document.getElementById("nkjbbz__name_id").value; 
		   var jsonektjbz = JSON.stringify(ektjbzData);
		   var jsonekjbbz = JSON.stringify(ekjbbzData);
		   var jsonnkjbbz = JSON.stringify(nkjbbzData);
		   var jsonnktjbz = JSON.stringify(nktjbzData);
		
		 $.ajax({
		      url:"${ctx}/ironfobznkekbz/ironfobznkekbz/save",
		      data:{
		    	  jsonektjbz:jsonektjbz,
		    	  ektjbz_text:ektjbz_text,
		    	  jsonekjbbz:jsonekjbbz,
		    	  ekjbbz_text:ekjbbz_text,
		    	  jsonnkjbbz:jsonnkjbbz,
		    	  nkjbbz_text:nkjbbz_text,
		    	  jsonnktjbz:jsonnktjbz,
		    	  nktjzbz_text:nktjzbz_text,
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