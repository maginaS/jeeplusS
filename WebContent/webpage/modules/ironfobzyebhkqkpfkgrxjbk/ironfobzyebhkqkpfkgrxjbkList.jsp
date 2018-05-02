<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>2.7其它临床科室病种管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
			$(document).ready(function() {	
				queryjbbz("JBBZ");
			});
			
			
			
			function queryjbbz(type){

				
			
				
				 $.ajax({  
		                type:'GET',  
		                url:"${ctx}/ironfofamilies/ironfofamilies/query?type=JBBZ,TJBZ&bztype=3,6,7,1",  
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
			                	  
			                	  //眼、耳鼻咽喉科推荐病种
			                	  
			                	  var table = "<table>";
			                	  var i=1;
			                		table=table+"<tr>";
			                		for(var cd in datas.YEBYHK_TJBZ) {
			                			table=table+"<td>";
	              						 	table=table+"&nbsp&nbsp&nbsp<input type='checkbox' name='yebyhk_name' id='"+cd+"' value='"+cd+"' style='margin-top: -2px'>"+datas.YEBYHK_TJBZ[cd]+"</input>";
	              						table=table+"</td>";
	              						
	              					  if(i%3==0){
		                    		    	table=table+"</tr>";
		                    		    }
	  	                    		i++;	
			                			
			                		}
			                		/* value='${data.wkfcktjbztext}' */
			                		 table=table+"</table>";
			                    	 table=table+"<table><tr  style='width:100%;'>其它（请注明）:<input type='text' value='${data.yebhtjbztext}'  id='yebyhk_name_text'  name='yebyhk_name_text' /></tr></table>";
			                    	
			                    	 document.getElementById("ironfo_yebyhk_tjbzList").innerHTML=table;
			                    	 
			                    	 
			                    	 //眼、耳鼻咽喉科基本病种
			                    	 var yebyhkjbbz = "<table>";
			                    	 var j=1;
			                    	 yebyhkjbbz=yebyhkjbbz+"<tr>";
			                    	 for(var cd in datas.YEBYHK_JBBZ) {
			                    		 yebyhkjbbz=yebyhkjbbz+"<td>";
			                    			 yebyhkjbbz=yebyhkjbbz+"&nbsp&nbsp&nbsp<input type='checkbox' name='yebyhkjbbz_name' id='"+cd+"' value='"+cd+"' style='margin-top: -2px'>"+datas.YEBYHK_JBBZ[cd]+"</input>";
			                    		 yebyhkjbbz=yebyhkjbbz+"</td>";
			                    		 
			                    		    if(j%3==0){
			                    		    	yebyhkjbbz=yebyhkjbbz+"</tr>";
			                    		    }
			                    		 
			                    		j++;	
	                			
			                    		 
			                    	 }
			                    	 
			                    	 yebyhkjbbz=yebyhkjbbz+"</table>";
			                    	 yebyhkjbbz=yebyhkjbbz+"<table><tr  style='width:100%;'>其它（请注明）:<input type='text' value='${data.yebhtext}' id='yebyhkjbbz_name_text'   name='yebyhkjbbz_name_text' /></tr></table>";
			                    	
			                    	 document.getElementById("ironfo_yebyhk_jbbzList").innerHTML=yebyhkjbbz;
			                    	 
			                    	 
			                    	 
			                    	//口腔科基本病种
			                    	 var kqkjbbz = "<table>";
			                    	 var j=1;
			                    	 kqkjbbz=kqkjbbz+"<tr>";
			                    	 for(var cd in datas.KQK_JBBZ) {
			                    		 kqkjbbz=kqkjbbz+"<td>";
			                    			 kqkjbbz=kqkjbbz+"&nbsp&nbsp&nbsp<input type='checkbox' name='kqkjbbz_name' id='"+cd+"' value='"+cd+"' style='margin-top: -2px'>"+datas.KQK_JBBZ[cd]+"</input>";
			                    		 kqkjbbz=kqkjbbz+"</td>";
			                    		 
			                    		    if(j%3==0){
			                    		    	kqkjbbz=kqkjbbz+"</tr>";
			                    		    }
			                    		 
			                    		j++;	
	                			
			                    		 
			                    	 }
			                    	 
			                    	 kqkjbbz=kqkjbbz+"</table>";
			                    	 kqkjbbz=kqkjbbz+"<table><tr  style='width:100%;'>其它（请注明）:<input type='text' value='${data.kqktext}' id='kqkjbbz_name_text'   name='kqkjbbz_name_text' /></tr></table>";
			                    	
			                    	 document.getElementById("ironfo_kqk_jbbzList").innerHTML=kqkjbbz;
			                    	 
			                    	 
			                    	 
			                    	 
			                    	 
			                    	//口腔科推荐病种
				                	  var kqktjbz = "<table>";
				                	  var i=1;
				                	  kqktjbz=kqktjbz+"<tr>";
				                		for(var cd in datas.KQK_TJBZ) {
					                			kqktjbz=kqktjbz+"<td>";
					                				kqktjbz=kqktjbz+"&nbsp&nbsp&nbsp<input type='checkbox' name='kqktjbz_name' id='"+cd+"' value='"+cd+"' style='margin-top: -2px'>"+datas.KQK_TJBZ[cd]+"</input>";
					                			kqktjbz=kqktjbz+"</td>";
		              						
		              					  if(i%3==0){
		              						kqktjbz=kqktjbz+"</tr>";
			                    		    }
		  	                    		i++;	
				                			
				                		}
				                		
				                		 kqktjbz=kqktjbz+"</table>";
				                		 kqktjbz=kqktjbz+"<table><tr  style='width:100%;'>其它（请注明）:<input type='text' value='${data.kqktjbztext}'  id='kqktjbz_name_text'  name='kqktjbz_name_text' /></tr></table>";
				                    	
				                    	 document.getElementById("ironfo_kqk_tjbzList").innerHTML=kqktjbz;
				                    	 

				                    	

				                    	 
				                    	 
				                    	 
					                    	//皮肤科基本病种
					                    	 var pfkjbbz = "<table>";
					                    	 var j=1;
					                    	 pfkjbbz=pfkjbbz+"<tr>";
					                    	 for(var cd in datas.PFK_JBBZ) {
					                    		 pfkjbbz=pfkjbbz+"<td>";
					                    			 pfkjbbz=pfkjbbz+"&nbsp&nbsp&nbsp<input type='checkbox' name='pfkjbbz_name' id='"+cd+"' value='"+cd+"' style='margin-top: -2px'>"+datas.PFK_JBBZ[cd]+"</input>";
					                    		 pfkjbbz=pfkjbbz+"</td>";
					                    		 
					                    		    if(j%3==0){
					                    		    	pfkjbbz=pfkjbbz+"</tr>";
					                    		    }
					                    		 
					                    		j++;	
			                			
					                    		 
					                    	 }
					                    	 
					                    	 pfkjbbz=pfkjbbz+"</table>";
					                    	 pfkjbbz=pfkjbbz+"<table><tr  style='width:100%;'>其它（请注明）:<input type='text' value='${data.pfktext}' id='pfkjbbz_name_text'  name='pfkjbbz_name_text' /></tr></table>";
					                    	
					                    	 document.getElementById("ironfo_pfk_jbbzList").innerHTML=pfkjbbz;
					                    	 
				                    	 
				                    	 
				                    	 
					                    	 
					                    	 
					                    	 
						                    	//皮肤科推荐病种
							                	  var pfktjbz = "<table>";
							                	  var i=1;
							                	  pfktjbz=pfktjbz+"<tr>";
							                		for(var cd in datas.PFK_TJBZ) {
							                			pfktjbz=pfktjbz+"<td>";
							                				pfktjbz=pfktjbz+"&nbsp&nbsp&nbsp<input type='checkbox' name='pfktjbz_name' id='"+cd+"' value='"+cd+"' style='margin-top: -2px'>"+datas.PFK_TJBZ[cd]+"</input>";
							                			pfktjbz=pfktjbz+"</td>";
					              						
					              					  if(i%3==0){
					              						pfktjbz=pfktjbz+"</tr>";
						                    		    }
					  	                    		i++;	
							                			
							                		}
							                		
							                		pfktjbz=pfktjbz+"</table>";
							                		pfktjbz=pfktjbz+"<table><tr  style='width:100%;'>其它（请注明）:<input type='text' value='${data.pfktjbztext}' id='pfktjbz_name_text'  name='pfktjbz_name_text' /></tr></table>";
							                    	
							                    	document.getElementById("ironfo_pfk_tjbzList").innerHTML=pfktjbz;
							                    	 
					                    	 
					                    	
							                    	
							                    	
							                    	
							                    	
							                    	//感染性疾病科推荐病种
								                	  var grxjbktjbz = "<table>";
								                	  var i=1;
								                	  grxjbktjbz=grxjbktjbz+"<tr>";
								                		for(var cd in datas.GRXJBK_TJBZ) {
								                			grxjbktjbz=grxjbktjbz+"<td>";
								                			grxjbktjbz=grxjbktjbz+"&nbsp&nbsp&nbsp<input type='checkbox' name='grxjbktjbz_name' id='"+cd+"' value='"+cd+"' style='margin-top: -2px'>"+datas.GRXJBK_TJBZ[cd]+"</input>";
								                			grxjbktjbz=grxjbktjbz+"</td>";
						              						
						              					  if(i%3==0){
						              						grxjbktjbz=grxjbktjbz+"</tr>";
							                    		    }
						  	                    		i++;	
								                			
								                		}
								                		
								                		grxjbktjbz=grxjbktjbz+"</table>";
								                		grxjbktjbz=grxjbktjbz+"<table><tr  style='width:100%;'>其它（请注明）:<input type='text' value='${data.grxjbktjbztext}'  id='grxjbktjbz_name_text'  name='grxjbktjbz_name_text' /></tr></table>";
								                    	
								                    	document.getElementById("ironfo_grxjbk_tjbzList").innerHTML=grxjbktjbz;
								                    	
					                    	 
					                    	 
								                    	
								                    	

								                    	//感染性疾病科基本病种
								                    	 var grxjbkjbbz = "<table>";
								                    	 var j=1;
								                    	 grxjbkjbbz=grxjbkjbbz+"<tr>";
								                    	 for(var cd in datas.GRXJBK_JBBZ) {
								                    		 grxjbkjbbz=grxjbkjbbz+"<td>";
								                    		 grxjbkjbbz=grxjbkjbbz+"&nbsp&nbsp&nbsp<input type='checkbox' name='grxjbkjbbz_name' id='"+cd+"' value='"+cd+"' style='margin-top: -2px'>"+datas.GRXJBK_JBBZ[cd]+"</input>";
								                    		 grxjbkjbbz=grxjbkjbbz+"</td>";
								                    		 
								                    		    if(j%3==0){
								                    		    	grxjbkjbbz=grxjbkjbbz+"</tr>";
								                    		    }
								                    		 
								                    		j++;	
						                			
								                    		 
								                    	 }
								                    	 
								                    	 grxjbkjbbz=grxjbkjbbz+"</table>";
								                    	 grxjbkjbbz=grxjbkjbbz+"<table><tr  style='width:100%;'>其它（请注明）:<input type='text' value='${data.grxjbktext}' id='grxjbkjbbz_name_text'  name='grxjbkjbbz_name_text' /></tr></table>";
								                    	
								                    	 document.getElementById("ironfo_grxjbk_jbbzList").innerHTML=grxjbkjbbz;
								                    	 
				                    	 
				                    	 
				                    	 
				                    	 
			                    	 
			                  }
			                  
			                  
			                  
			            
			                	var yebhjbbz = <%=map.get("yebhjbbz")%>;
			                	var yebhtjbz = <%=map.get("yebhtjbz")%>; 
			                	var yebhjbbzcheckbox = document.getElementsByName("yebyhkjbbz_name");
			                	for(var a=0;a<yebhjbbz.length;a++){
			                		for(var i=0;i<yebhjbbzcheckbox.length;i++){
										if(yebhjbbz[a] == yebhjbbzcheckbox[i].value){
											yebhjbbzcheckbox[i].checked = "checked";
			                			}
			                		}
			                	} 
			                	
			                	
			                 	var yebhtjbzcheckbox = document.getElementsByName("yebyhk_name");
			                	for(var a=0;a<yebhtjbz.length;a++){
			                		for(var i=0;i<yebhtjbzcheckbox.length;i++){
										if(yebhtjbz[a] == yebhtjbzcheckbox[i].value){
											yebhtjbzcheckbox[i].checked = "checked";
			                				
			                			}
			                		}	
			                	}
			                	
			                	
								//口腔科基本病种
			                 	var kqkjbbz = <%=map.get("kqkjbbz")%>;
			                 	
			                 	var kqkjbbzcheckbox = document.getElementsByName("kqkjbbz_name");
			                	for(var a=0;a<kqkjbbz.length;a++){
			                		for(var i=0;i<kqkjbbzcheckbox.length;i++){
										if(kqkjbbz[a] == kqkjbbzcheckbox[i].value){
											kqkjbbzcheckbox[i].checked = "checked";
			                			}
			                		}
			                	} 
			                 	
			                	//口腔科推荐病种
			                	var kqktjbz = <%=map.get("kqktjbz")%>; 
			                	var kqktjbzcheckbox = document.getElementsByName("kqktjbz_name");
			                	for(var a=0;a<kqktjbz.length;a++){
			                		for(var i=0;i<kqktjbzcheckbox.length;i++){
										if(kqktjbz[a] == kqktjbzcheckbox[i].value){
											kqktjbzcheckbox[i].checked = "checked";
			                			}
			                		}
			                	} 
			                	
			                	//皮肤科基本病种
			                 	var pfkjbbz = <%=map.get("pfkjbbz")%>;
			                 	
			                 	var pfkjbbzcheckbox = document.getElementsByName("pfkjbbz_name");
			                	for(var a=0;a<pfkjbbz.length;a++){
			                		for(var i=0;i<pfkjbbzcheckbox.length;i++){
										if(pfkjbbz[a] == pfkjbbzcheckbox[i].value){
											pfkjbbzcheckbox[i].checked = "checked";
			                			}
			                		}
			                	} 
			                	//皮肤科推荐病种
			                	var pfktjbz = <%=map.get("pfktjbz")%>; 
			                	var pfktjbzcheckbox = document.getElementsByName("pfktjbz_name");
			                	for(var a=0;a<pfktjbz.length;a++){
			                		for(var i=0;i<pfktjbzcheckbox.length;i++){
										if(pfktjbz[a] == pfktjbzcheckbox[i].value){
											pfktjbzcheckbox[i].checked = "checked";
			                			}
			                		}
			                	} 
			                	//
			                 	var grxjbkjbbz = <%=map.get("grxjbkjbbz")%>;
			                 	var grxjbkjbbzcheckbox = document.getElementsByName("grxjbkjbbz_name");
			                	for(var a=0;a<grxjbkjbbz.length;a++){
			                		for(var i=0;i<grxjbkjbbzcheckbox.length;i++){
										if(grxjbkjbbz[a] == grxjbkjbbzcheckbox[i].value){
											grxjbkjbbzcheckbox[i].checked = "checked";
			                			}
			                		}
			                	} 
			                 	
			                 	
			                	
			                	var grxjbktjbz = <%=map.get("grxjbktjbz")%>; 
			                	var grxjbktjbzcheckbox = document.getElementsByName("grxjbktjbz_name");
			                	for(var a=0;a<grxjbktjbz.length;a++){
			                		for(var i=0;i<grxjbktjbzcheckbox.length;i++){
										if(grxjbktjbz[a] == grxjbktjbzcheckbox[i].value){
											grxjbktjbzcheckbox[i].checked = "checked";
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
		<form id="inputForm" modelAttribute="ironfobzyebhkqkpfkgrxjbk" action="${ctx}/ironfobzyebhkqkpfkgrxjbk/ironfobzyebhkqkpfkgrxjbk/save" method="post" class="form-horizontal">
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
					<td  style="width:10px">眼、耳鼻咽喉科</td>
					<td  style="width:180px">
						<table id="ironfo_yebyhk_jbbzList">
											
						</table>
					</td>
					 <td  style="width:180px">
						 <table id="ironfo_yebyhk_tjbzList">
				
						</table> 
					</td>
		  		</tr>
		  		
		  		
		  		<tr>
					<td  style="width:10px">口腔科</td>
					<td  style="width:180px">
						<table id="ironfo_kqk_jbbzList">
											
						</table>
					</td>
					 <td  style="width:180px">
						 <table id="ironfo_kqk_tjbzList">
				
						</table> 
					</td>
		  		</tr>
		  		
		  		<tr>
					<td  style="width:10px">皮肤科</td>
					<td  style="width:180px">
						<table id="ironfo_pfk_jbbzList">
											
						</table>
					</td>
					 <td  style="width:180px">
						 <table id="ironfo_pfk_tjbzList">
				
						</table> 
					</td>
		  		</tr>
		  		
		  		<tr>
					<td  style="width:10px">感染性疾病科</td>
					<td  style="width:180px">
						<table id="ironfo_grxjbk_jbbzList">
											
						</table>
					</td>
					 <td  style="width:180px">
						 <table id="ironfo_grxjbk_tjbzList">
				
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
		var yebhjbbzData;
		
		var yebyhkjbbzName = document.getElementsByName("yebyhkjbbz_name");
	    var yebyhkjbbz_text=document.getElementById("yebyhkjbbz_name_text").value; 
	    var yebyhkjbbz = [];
	    for(k in yebyhkjbbzName){
	        if(yebyhkjbbzName[k].checked){
	        	yebyhkjbbz.push(yebyhkjbbzName[k].value);
	        	}
	        
	    }
	    yebhjbbzData=yebyhkjbbz;
		
		
		 var yebhtjbzData;
		 var yebyhktjbzName = document.getElementsByName("yebyhk_name");
		 var yebyhktjbz_text=document.getElementById("yebyhk_name_text").value; 
		 var yebyhktjbz = [];
		    for(k in yebyhktjbzName){
		        if(yebyhktjbzName[k].checked)
		        	yebyhktjbz.push(yebyhktjbzName[k].value);
		        	
		        
		        	
		    }
		    yebhtjbzData=yebyhktjbz;

		    //口腔科基本病种
		 var kqkjbbzData;
		 var kqkjbbzName = document.getElementsByName("kqkjbbz_name");
		 var kqkjbbz_text=document.getElementById("kqkjbbz_name_text").value; 
		 var kqkjbbz = [];
		    for(k in kqkjbbzName){
		        if(kqkjbbzName[k].checked)
		        	kqkjbbz.push(kqkjbbzName[k].value);
		        	
		        
		        	
		    }
		    kqkjbbzData=kqkjbbz;
		
		    //口腔科推荐病种
		 var kqktjbzData;
		 var kqktjbzName = document.getElementsByName("kqktjbz_name");
		 var kqktjbz_text=document.getElementById("kqktjbz_name_text").value; 
		 var kqktjbz = [];
		    for(k in kqktjbzName){
		        if(kqktjbzName[k].checked)
		        	kqktjbz.push(kqktjbzName[k].value);
		        	
		        
		        	
		    }
		    kqktjbzData=kqktjbz;
		
		


		    
		    //皮肤科基本病种
		 var pfkjbbzData;
		 var pfkjbbzName = document.getElementsByName("pfkjbbz_name");
		 var pfkjbbz_text=document.getElementById("pfkjbbz_name_text").value; 
		 var pfkjbbz = [];
		    for(k in pfkjbbzName){
		        if(pfkjbbzName[k].checked)
		        	pfkjbbz.push(pfkjbbzName[k].value);
		        	
		        
		        	
		    }
		    pfkjbbzData=pfkjbbz;
		
		 //皮肤科推荐病种
		 var pfktjbzData;
		 var pfktjbzName = document.getElementsByName("pfktjbz_name");
		 var pfktjbz_text=document.getElementById("pfktjbz_name_text").value; 
		 var pfktjbz = [];
		    for(k in pfktjbzName){
		        if(pfktjbzName[k].checked)
		        	pfktjbz.push(pfktjbzName[k].value);
		        	
		        
		        	
		    }
		    pfktjbzData=pfktjbz;

		 var grxjbkjbbzData;
		 var grxjbkjbbzName = document.getElementsByName("grxjbkjbbz_name");
		 var grxjbkjbbz_text=document.getElementById("grxjbkjbbz_name_text").value; 
		 var grxjbkjbbz = [];
		    for(k in grxjbkjbbzName){
		        if(grxjbkjbbzName[k].checked)
		        	grxjbkjbbz.push(grxjbkjbbzName[k].value);
		        	
		        
		        	
		    }
		    grxjbkjbbzData=grxjbkjbbz;
		
		 var grxjbktjbzData;
		 var grxjbktjbzName = document.getElementsByName("grxjbktjbz_name");
		 var grxjbktjbz_text=document.getElementById("grxjbktjbz_name_text").value; 
		 var grxjbktjbz = [];
		    for(k in grxjbktjbzName){
		        if(grxjbktjbzName[k].checked)
		        	grxjbktjbz.push(grxjbktjbzName[k].value);
		        	
		        
		        	
		    }
		    grxjbktjbzData=grxjbktjbz;
	
		
		
		    
		    
		    
		    
		    
		
		
		   var docId = document.getElementById("wkfckjbbz__name_docid").value;
		   var id= document.getElementById("wkfckjbbz__name_id").value; 
		   var yebhtjbz_data = JSON.stringify(yebhtjbzData);
		   var yebhtjbbz_data = JSON.stringify(yebhjbbzData);
		   
		   var kqkjbbz_data = JSON.stringify(kqkjbbzData);
		   var kqktjbz_data = JSON.stringify(kqktjbzData);
		   
		   var pfkjbbz_data = JSON.stringify(pfkjbbzData);
		   var pfktjbz_data = JSON.stringify(pfktjbzData);
		   
		   
		   var grxjbkjbbz_data = JSON.stringify(grxjbkjbbzData);
		   var grxjbktjbz_data = JSON.stringify(grxjbktjbzData);
		 
		
		 $.ajax({
		      url:"${ctx}/ironfobzyebhkqkpfkgrxjbk/ironfobzyebhkqkpfkgrxjbk/save",
		      data:{
		    	  yebhtjbz_data:yebhtjbz_data,
		    	  yebyhktjbz_text:yebyhktjbz_text,
		    	  yebhtjbbz_data:yebhtjbbz_data,
		    	  yebyhkjbbz_text:yebyhkjbbz_text,
		    	  //口腔科基本病种
		    	  kqkjbbz_data:kqkjbbz_data,
		    	  kqkjbbz_text:kqkjbbz_text,
		    	  //口腔科推荐病种
		    	  kqktjbz_data:kqktjbz_data,
		    	  kqktjbz_text:kqktjbz_text,
		    	  //皮肤科基本病种
		    	  pfkjbbz_data:pfkjbbz_data,
		    	  pfkjbbz_text:pfkjbbz_text,
		    	  //皮肤科推荐病种
		    	  pfktjbz_data:pfktjbz_data,
		    	  pfktjbz_text:pfktjbz_text,
		    	  //感染性疾病科基本病种
		    	  grxjbkjbbz_data:grxjbkjbbz_data,
		    	  grxjbkjbbz_text:grxjbkjbbz_text,
		    	  //感染性疾病科推荐病种
		    	  grxjbktjbz_data:grxjbktjbz_data,
		    	  grxjbktjbz_text:grxjbktjbz_text,
		    	  
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