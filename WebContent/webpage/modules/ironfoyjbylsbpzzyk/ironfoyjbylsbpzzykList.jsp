<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>中医科管理</title>
	<meta name="decorator" content="default"/>
	
</head>
<body class="hideScroll">
		<form id="inputForm" modelAttribute="ironfoyjbylsbpzzyk" action="${ctx}/ironfoyjbylsbpzzyk/ironfoyjbylsbpzzyk/save" method="post" class="form-horizontal">
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
						<input path="zyk_sbmc" readOnly="true"   name="zykgl_name" id="mzy_sbmc"  htmlEscape="false" value="脉诊仪"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="zyk_pp" name="zykgl_name" id="mzy_pp" value="${data.mzy.mzy_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyk_xh" name="zykgl_name" id="mzy_xh"  value="${data.mzy.mzy_xh }" htmlEscape="false"    class="form-control "/>
					</td>
				
					<td class="width-15">
						<input path="zyk_sl" name="zykgl_name" id="mzy_sl"  value="${data.mzy.mzy_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="zyk_sbjg" name="zykgl_name" id="mzy_sbjg"  value="${data.mzy.mzy_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyk_rusynf" name="zykgl_name" id="mzy_rusynf"  value="${data.mzy.mzy_rusynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="mzy_id"  name="zykgl_name" value="${data.mzy.mzy_id}"  class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="docId"   name="zykgl_name" value="${data.docId}"  class="form-control "/>
					
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="zyk_sbmc" readOnly="true"  name="zykgl_name" id="szy_sbmc" htmlEscape="false" value="舌诊仪"   class="form-control "/>
					</td>
				<td class="width-15">
						<input path="zyk_pp" name="zykgl_name" id="szy_pp" value="${data.szy.szy_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyk_xh" name="zykgl_name" id="szy_xh" value="${data.szy.szy_xh }" htmlEscape="false"    class="form-control "/>
					</td>
				
					<td class="width-15">
						<input path="zyk_sl" name="zykgl_name" id="szy_sl" value="${data.szy.szy_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="zyk_sbjg" name="zykgl_name" id="szy_sbjg" value="${data.szy.szy_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyk_rusynf" name="zykgl_name" id="szy_rusynf"  value="${data.szy.szy_rusynf }" htmlEscape="false"    class="form-control "/>
					<input type = "hidden" htmlEscape="false" id="szy_id"  name="zykgl_name" value="${data.szy.szy_id}"  class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="zyk_sbmc" readOnly="true"  name="zykgl_name" id="zykmzy_sbmc" htmlEscape="false" value="面诊仪"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="zyk_pp" name="zykgl_name" id="zykmzy_pp" value="${data.zykmzy.zykmzy_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyk_xh" name="zykgl_name" id="zykmzy_xh" value="${data.zykmzy.zykmzy_xh }" htmlEscape="false"    class="form-control "/>
					</td>
				
					<td class="width-15">
						<input path="zyk_sl" name="zykgl_name" id="zykmzy_sl" value="${data.zykmzy.zykmzy_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="zyk_sbjg" name="zykgl_name" id="zykmzy_sbjg" value="${data.zykmzy.zykmzy_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyk_rusynf" name="zykgl_name" id="zykmzy_rusynf" value="${data.zykmzy.zykmzy_rusynf }"  htmlEscape="false"    class="form-control "/>
					<input type = "hidden" htmlEscape="false" id="zykmzy_id"  name="zykgl_name" value="${data.zykmzy.zykmzy_id}"  class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="zyk_sbmc" readOnly="true"  name="zykgl_name" id="jljcy_sbmc" htmlEscape="false" value="经络检测仪"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="zyk_pp" name="zykgl_name" id="jljcy_pp" value="${data.jljcy.jljcy_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyk_xh" name="zykgl_name" id="jljcy_xh" value="${data.jljcy.jljcy_xh }" htmlEscape="false"    class="form-control "/>
					</td>
				
					<td class="width-15">
						<input path="zyk_sl" name="zykgl_name" id="jljcy_sl" value="${data.jljcy.jljcy_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="zyk_sbjg" name="zykgl_name" id="jljcy_sbjg" value="${data.jljcy.jljcy_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyk_rusynf" name="zykgl_name"  id="jljcy_rusynf" value="${data.jljcy.jljcy_rusynf }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="jljcy_id"  name="zykgl_name" value="${data.jljcy.jljcy_id}"  class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="zyk_sbmc" readOnly="true"  name="zykgl_name" id="jlcjy_sbmc" htmlEscape="false" value="经络刺激仪"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="zyk_pp" name="zykgl_name" id="jlcjy_pp" value="${data.jlcjy.jlcjy_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyk_xh" name="zykgl_name" id="jlcjy_xh" value="${data.jlcjy.jlcjy_xh }" htmlEscape="false"    class="form-control "/>
					</td>
				
					<td class="width-15">
						<input path="zyk_sl" name="zykgl_name" id="jlcjy_sl" value="${data.jlcjy.jlcjy_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="zyk_sbjg" name="zykgl_name" id="jlcjy_sbjg" value="${data.jlcjy.jlcjy_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyk_rusynf" name="zykgl_name" id="jlcjy_rusynf" value="${data.jlcjy.jlcjy_rusynf }"  htmlEscape="false"    class="form-control "/>
					<input type = "hidden" htmlEscape="false" id="jlcjy_id"  name="zykgl_name" value="${data.jlcjy.jlcjy_id}"  class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="zyk_sbmc" readOnly="true"  name="zykgl_name" id="zykwzy_sbmc" htmlEscape="false" value="温针仪"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="zyk_pp" name="zykgl_name" id="zykwzy_pp" value="${data.zykwzy.zykwzy_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyk_xh" name="zykgl_name" id="zykwzy_xh" value="${data.zykwzy.zykwzy_xh }" htmlEscape="false"    class="form-control "/>
					</td>
				
					<td class="width-15">
						<input path="zyk_sl" name="zykgl_name" id="zykwzy_sl" value="${data.zykwzy.zykwzy_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="zyk_sbjg" name="zykgl_name" id="zykwzy_sbjg" value="${data.zykwzy.zykwzy_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyk_rusynf" name="zykgl_name" id="zykwzy_rusynf"  value="${data.zykwzy.zykwzy_rusynf }"  htmlEscape="false"    class="form-control "/>
					<input type = "hidden" htmlEscape="false" id="zykwzy_id"  name="zykgl_name" value="${data.zykwzy.zykwzy_id}"  class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="zyk_sbmc" readOnly="true"  name="zykgl_name" id="zykzlj_sbmc" htmlEscape="false" value="灸疗机"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="zyk_pp" name="zykgl_name" id="zykzlj_pp" value="${data.zykzlj.zykzlj_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyk_xh" name="zykgl_name" id="zykzlj_xh" value="${data.zykzlj.zykzlj_xh }"   htmlEscape="false"    class="form-control "/>
					</td>
				
					<td class="width-15">
						<input path="zyk_sl" name="zykgl_name" id="zykzlj_sl"  value="${data.zykzlj.zykzlj_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="zyk_sbjg" name="zykgl_name" id="zykzlj_sbjg"  value="${data.zykzlj.zykzlj_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyk_rusynf" name="zykgl_name" id="zykzlj_rusynf"  value="${data.zykzlj.zykzlj_rusynf }"  htmlEscape="false"    class="form-control "/>
					<input type = "hidden" htmlEscape="false" id="zykzlj_id"  name="zykgl_name" value="${data.zykzlj.zykzlj_id}"  class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="zyk_sbmc" readOnly="true"  name="zykgl_name" id="zykgly_sbmc" htmlEscape="false" value="罐疗仪"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="zyk_pp" name="zykgl_name" id="zykgly_pp"  value="${data.zykgly.zykgly_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyk_xh" name="zykgl_name" id="zykgly_xh" value="${data.zykgly.zykgly_xh }" htmlEscape="false"    class="form-control "/>
					</td>
				
					<td class="width-15">
						<input path="zyk_sl" name="zykgl_name" id="zykgly_sl" value="${data.zykgly.zykgly_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="zyk_sbjg" name="zykgl_name" id="zykgly_sbjg" value="${data.zykgly.zykgly_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyk_rusynf" name="zykgl_name" id="zykgly_rusynf"  value="${data.zykgly.zykgly_rusynf }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="zykgly_id"  name="zykgl_name" value="${data.zykgly.zykgly_id}"  class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="zyk_sbmc" readOnly="true"  name="zykgl_name" id="xzzly_sbmc" htmlEscape="false" value="熏蒸治疗仪"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="zyk_pp" name="zykgl_name" id="xzzly_pp" value="${data.xzzly.xzzly_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyk_xh" name="zykgl_name" id="xzzly_xh"   value="${data.xzzly.xzzly_xh }" htmlEscape="false"    class="form-control "/>
					</td>
				
					<td class="width-15">
						<input path="zyk_sl" name="zykgl_name" id="xzzly_sl"  value="${data.xzzly.xzzly_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="zyk_sbjg" name="zykgl_name" id="xzzly_sbjg"  value="${data.xzzly.xzzly_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyk_rusynf" name="zykgl_name" id="xzzly_rusynf"  value="${data.xzzly.xzzly_rusynf }"  htmlEscape="false"    class="form-control "/>
					<input type = "hidden" htmlEscape="false" id="xzzly_id"  name="zykgl_name" value="${data.xzzly.xzzly_id}"  class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="zyk_sbmc" readOnly="true"  name="zykgl_name" id="wbzjzly_sbmc" htmlEscape="false" value="微波针灸治疗仪"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="zyk_pp" name="zykgl_name" id="wbzjzly_pp"  value="${data.wbzjzly.wbzjzly_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyk_xh" name="zykgl_name" id="wbzjzly_xh"  value="${data.wbzjzly.wbzjzly_xh }" htmlEscape="false"    class="form-control "/>
					</td>
				
					<td class="width-15">
						<input path="zyk_sl" name="zykgl_name" id="wbzjzly_sl" value="${data.wbzjzly.wbzjzly_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="zyk_sbjg" name="zykgl_name" id="wbzjzly_sbjg" value="${data.wbzjzly.wbzjzly_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyk_rusynf" name="zykgl_name" id="wbzjzly_rusynf" value="${data.wbzjzly.wbzjzly_rusynf }"  htmlEscape="false"    class="form-control "/>
					<input type = "hidden" htmlEscape="false" id="wbzjzly_id"  name="zykgl_name" value="${data.wbzjzly.wbzjzly_id}"  class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="zyk_sbmc" readOnly="true"  name="zykgl_name" id="jgxwzly_sbmc" htmlEscape="false" value="激光穴位治疗仪"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="zyk_pp" name="zykgl_name" id="jgxwzly_pp" value="${data.jgxwzly.jgxwzly_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyk_xh" name="zykgl_name" id="jgxwzly_xh" value="${data.jgxwzly.jgxwzly_xh }" htmlEscape="false"    class="form-control "/>
					</td>
				
					<td class="width-15">
						<input path="zyk_sl" name="zykgl_name" id="jgxwzly_sl" value="${data.jgxwzly.jgxwzly_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="zyk_sbjg" name="zykgl_name" id="jgxwzly_sbjg" value="${data.jgxwzly.jgxwzly_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyk_rusynf"  name="zykgl_name" id="jgxwzly_rusynf" value="${data.jgxwzly.jgxwzly_rusynf }"  htmlEscape="false"    class="form-control "/>
					<input type = "hidden" htmlEscape="false" id="jgxwzly_id"  name="zykgl_name" value="${data.jgxwzly.jgxwzly_id}"  class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="zyk_sbmc" readOnly="true"  name="zykgl_name" id="qtqzm_sbmc" htmlEscape="false" value="其它（请注明）"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="zyk_pp" name="zykgl_name" id="qtqzm_pp" value="${data.qtqzm.qtqzm_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyk_xh" name="zykgl_name" id="qtqzm_xh" value="${data.qtqzm.qtqzm_xh }" htmlEscape="false"    class="form-control "/>
					</td>
				
					<td class="width-15">
						<input path="zyk_sl" name="zykgl_name" id="qtqzm_sl" value="${data.qtqzm.qtqzm_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="zyk_sbjg" name="zykgl_name" id="qtqzm_sbjg" value="${data.qtqzm.qtqzm_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="zyk_rusynf" name="zykgl_name" id="qtqzm_rusynf" value="${data.qtqzm.qtqzm_rusynf }"  htmlEscape="false"    class="form-control "/>
					<input type = "hidden" htmlEscape="false" id="qtqzm_id"  name="zykgl_name" value="${data.qtqzm.qtqzm_id}"  class="form-control "/>
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
		
		var data = document.getElementsByName("zykgl_name");
	
		var datas="";
		
		
		for(i=0;i<data.length;i++){
			if(data[i].value==null||data[i].value==""){
				datas = datas +data[i].id+": ---- ;";	
			}else{
				datas = datas +data[i].id+":"+data[i].value+";";	
			}
			
			
		}
	 	
		 $.ajax({
		      url:"${ctx}/ironfoyjbylsbpzzyk/ironfoyjbylsbpzzyk/save",
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