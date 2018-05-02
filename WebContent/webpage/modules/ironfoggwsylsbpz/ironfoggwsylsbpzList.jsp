<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>3.4公共卫生部医疗设备配置管理</title>
	<meta name="decorator" content="default"/>
	
</head>
<body class="hideScroll">
		<form id="inputForm" modelAttribute="ironfoggwsylsbpz" action="${ctx}/ironfoggwsylsbpz/ironfoggwsylsbpz/save" method="post" class="form-horizontal">
		<%-- <form:hidden path="id"/>
		<sys:message content="${message}"/>	 --%>
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
						<input path="ggwsylsbpz_sbmc" readOnly="true"  name="ggwsylsbpz_name" id="sctzj_sbmc" htmlEscape="false"  value="身长体重计"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="ggwsylsbpz_pp" name="ggwsylsbpz_name"  id="sctzj_pp" value="${data.sctzj.sctzj_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="ggwsylsbpz_xh" name="ggwsylsbpz_name"  id="sctzj_xh" value="${data.sctzj.sctzj_xh }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="ggwsylsbpz_sl" name="ggwsylsbpz_name"  id="sctzj_sl" value="${data.sctzj.sctzj_sl }"   htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="ggwsylsbpz_sbjg" name="ggwsylsbpz_name"  id="sctzj_sbjg"  value="${data.sctzj.sctzj_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="ggwsylsbpz_trsynf" name="ggwsylsbpz_name"  id="sctzj_trsynf"  value="${data.sctzj.sctzj_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="sctzj_id"  name="ggwsylsbpz_name" value="${data.sctzj.sctzj_id}"  class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="docId"   name="ggwsylsbpz_name" value="${data.doc_id}"  class="form-control "/>
					
					
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="ggwsylsbpz_sbmc" readOnly="true"  name="ggwsylsbpz_name" id="ettzc_sbmc" htmlEscape="false"  value="儿童体重秤"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="ggwsylsbpz_pp" name="ggwsylsbpz_name" id="ettzc_pp" value="${data.ettzc.ettzc_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="ggwsylsbpz_xh" name="ggwsylsbpz_name" id="ettzc_xh" value="${data.ettzc.ettzc_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="ggwsylsbpz_sl" name="ggwsylsbpz_name" id="ettzc_sl" value="${data.ettzc.ettzc_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="ggwsylsbpz_sbjg" name="ggwsylsbpz_name" id="ettzc_sbjg" value="${data.ettzc.ettzc_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="ggwsylsbpz_trsynf" name="ggwsylsbpz_name" id="ettzc_trsynf" value="${data.ettzc.ettzc_trsynf }" htmlEscape="false"    class="form-control "/>
					<input type = "hidden" htmlEscape="false" id="ettzc_id"  name="ggwsylsbpz_name" value="${data.ettzc.ettzc_id}"  class="form-control "/>
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="ggwsylsbpz_sbmc" readOnly="true"  name="ggwsylsbpz_name" id="scxesfsy_sbmc" htmlEscape="false"  value="筛查型耳声发射仪"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="ggwsylsbpz_pp" name="ggwsylsbpz_name" id="scxesfsy_pp" value="${data.scxesfsy.scxesfsy_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="ggwsylsbpz_xh" name="ggwsylsbpz_name" id="scxesfsy_xh" value="${data.scxesfsy.scxesfsy_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="ggwsylsbpz_sl" name="ggwsylsbpz_name" id="scxesfsy_sl" value="${data.scxesfsy.scxesfsy_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="ggwsylsbpz_sbjg" name="ggwsylsbpz_name" id="scxesfsy_sbjg" value="${data.scxesfsy.scxesfsy_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="ggwsylsbpz_trsynf" name="ggwsylsbpz_name" id="scxesfsy_trsynf" value="${data.scxesfsy.scxesfsy_trsynf }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="scxesfsy_id"  name="ggwsylsbpz_name" value="${data.scxesfsy.scxesfsy_id}"  class="form-control "/>
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="ggwsylsbpz_sbmc" readOnly="true"  name="ggwsylsbpz_name" id="tljcy_sbmc" htmlEscape="false"  value="听力监测仪"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="ggwsylsbpz_pp" name="ggwsylsbpz_name" id="tljcy_pp" value="${data.tljcy.tljcy_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="ggwsylsbpz_xh" name="ggwsylsbpz_name" id="tljcy_xh" value="${data.tljcy.tljcy_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="ggwsylsbpz_sl" name="ggwsylsbpz_name" id="tljcy_sl" value="${data.tljcy.tljcy_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="ggwsylsbpz_sbjg" name="ggwsylsbpz_name" id="tljcy_sbjg" value="${data.tljcy.tljcy_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="ggwsylsbpz_trsynf" name="ggwsylsbpz_name" id="tljcy_trsynf" value="${data.tljcy.tljcy_trsynf }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="tljcy_id"  name="ggwsylsbpz_name" value="${data.tljcy.tljcy_id}"  class="form-control "/>
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="ggwsylsbpz_sbmc" readOnly="true"  name="ggwsylsbpz_name" id="fgny_sbmc" htmlEscape="false"  value="肺功能仪"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="ggwsylsbpz_pp" name="ggwsylsbpz_name" id="fgny_pp" value="${data.fgny.fgny_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="ggwsylsbpz_xh" name="ggwsylsbpz_name" id="fgny_xh"  value="${data.fgny.fgny_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="ggwsylsbpz_sl" name="ggwsylsbpz_name" id="fgny_sl" value="${data.fgny.fgny_sl }"   htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="ggwsylsbpz_sbjg" name="ggwsylsbpz_name" id="fgny_sbjg" value="${data.fgny.fgny_sbjg }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="ggwsylsbpz_trsynf" name="ggwsylsbpz_name" id="fgny_trsynf" value="${data.fgny.fgny_trsynf }"   htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="fgny_id"  name="ggwsylsbpz_name" value="${data.fgny.fgny_id}"  class="form-control "/>
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="ggwsylsbpz_sbmc" readOnly="true"  name="ggwsylsbpz_name" id="rtcffxy_sbmc" htmlEscape="false"  value="人体成分分析仪"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="ggwsylsbpz_pp" name="ggwsylsbpz_name" id="rtcffxy_pp" value="${data.rtcffxy.rtcffxy_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="ggwsylsbpz_xh" name="ggwsylsbpz_name" id="rtcffxy_xh"  value="${data.rtcffxy.rtcffxy_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="ggwsylsbpz_sl" name="ggwsylsbpz_name" id="rtcffxy_sl"  value="${data.rtcffxy.rtcffxy_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="ggwsylsbpz_sbjg" name="ggwsylsbpz_name" id="rtcffxy_sbjg"  value="${data.rtcffxy.rtcffxy_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="ggwsylsbpz_trsynf" name="ggwsylsbpz_name" id="rtcffxy_trsynf"  value="${data.rtcffxy.rtcffxy_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="rtcffxy_id"  name="ggwsylsbpz_name" value="${data.rtcffxy.rtcffxy_id}"  class="form-control "/>
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="ggwsylsbpz_sbmc" readOnly="true"  name="ggwsylsbpz_name" id="slb_sbmc" htmlEscape="false"  value="视力表"  class="form-control "/>
					</td>
				<td class="width-15">
						<input path="ggwsylsbpz_pp" name="ggwsylsbpz_name" id="slb_pp" value="${data.slb.slb_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="ggwsylsbpz_xh" name="ggwsylsbpz_name" id="slb_xh" value="${data.slb.slb_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="ggwsylsbpz_sl" name="ggwsylsbpz_name" id="slb_sl" value="${data.slb.slb_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15"> 
						<input path="ggwsylsbpz_sbjg" name="ggwsylsbpz_name" id="slb_sbjg" value="${data.slb.slb_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="ggwsylsbpz_trsynf" name="ggwsylsbpz_name" id="slb_trsynf" value="${data.slb.slb_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="slb_id"  name="ggwsylsbpz_name" value="${data.slb.slb_id}"  class="form-control "/>
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="ggwsylsbpz_sbmc" readOnly="true"  name="ggwsylsbpz_name" id="yylcldx_sbmc" htmlEscape="false"  value="医用冷藏冷冻箱"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="ggwsylsbpz_pp" name="ggwsylsbpz_name"  id="yylcldx_pp" value="${data.yylcldx.yylcldx_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="ggwsylsbpz_xh" name="ggwsylsbpz_name"  id="yylcldx_xh" value="${data.yylcldx.yylcldx_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="ggwsylsbpz_sl" name="ggwsylsbpz_name"  id="yylcldx_sl" value="${data.yylcldx.yylcldx_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="ggwsylsbpz_sbjg" name="ggwsylsbpz_name"  id="yylcldx_sbjg" value="${data.yylcldx.yylcldx_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="ggwsylsbpz_trsynf" name="ggwsylsbpz_name"  id="yylcldx_trsynf" value="${data.yylcldx.yylcldx_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="yylcldx_id"  name="ggwsylsbpz_name" value="${data.yylcldx.yylcldx_id}"  class="form-control "/>
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="ggwsylsbpz_sbmc" readOnly="true"  name="ggwsylsbpz_name" id="lcb_sbmc" htmlEscape="false"  value="冷藏包"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="ggwsylsbpz_pp" name="ggwsylsbpz_name" id="lcb_pp" value="${data.lcb.lcb_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="ggwsylsbpz_xh" name="ggwsylsbpz_name" id="lcb_xh"  value="${data.lcb.lcb_xh }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="ggwsylsbpz_sl" name="ggwsylsbpz_name" id="lcb_sl"  value="${data.lcb.lcb_sl }"   htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="ggwsylsbpz_sbjg" name="ggwsylsbpz_name" id="lcb_sbjg"   value="${data.lcb.lcb_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="ggwsylsbpz_trsynf" name="ggwsylsbpz_name" id="lcb_trsynf"  value="${data.lcb.lcb_trsynf }"   htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="lcb_id"  name="ggwsylsbpz_name" value="${data.lcb.lcb_id}"  class="form-control "/>
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="ggwsylsbpz_sbmc" readOnly="true"  name="ggwsylsbpz_name" id="hxq_sbmc" htmlEscape="false"  value="毁形器"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="ggwsylsbpz_pp" name="ggwsylsbpz_name" id="hxq_pp" value="${data.hxq.hxq_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="ggwsylsbpz_xh" name="ggwsylsbpz_name" id="hxq_xh"  value="${data.hxq.hxq_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="ggwsylsbpz_sl" name="ggwsylsbpz_name" id="hxq_sl"  value="${data.hxq.hxq_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="ggwsylsbpz_sbjg" name="ggwsylsbpz_name" id="hxq_sbjg"  value="${data.hxq.hxq_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="ggwsylsbpz_trsynf" name="ggwsylsbpz_name" id="hxq_trsynf"  value="${data.hxq.hxq_trsynf }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="hxq_id"  name="ggwsylsbpz_name" value="${data.hxq.hxq_id}"  class="form-control "/>
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="ggwsylsbpz_sbmc" readOnly="true"  name="ggwsylsbpz_name" id="fkzlc_sbmc" htmlEscape="false"  value="妇科诊疗床"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="ggwsylsbpz_pp" name="ggwsylsbpz_name" id="fkzlc_pp"  value="${data.fkzlc.fkzlc_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="ggwsylsbpz_xh" name="ggwsylsbpz_name" id="fkzlc_xh" value="${data.fkzlc.fkzlc_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="ggwsylsbpz_sl" name="ggwsylsbpz_name" id="fkzlc_sl"  value="${data.fkzlc.fkzlc_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="ggwsylsbpz_sbjg" name="ggwsylsbpz_name" id="fkzlc_sbjg"  value="${data.fkzlc.fkzlc_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="ggwsylsbpz_trsynf" name="ggwsylsbpz_name" id="fkzlc_trsynf"  value="${data.fkzlc.fkzlc_trsynf }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="fkzlc_id"  name="ggwsylsbpz_name" value="${data.fkzlc.fkzlc_id}"  class="form-control "/>
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="ggwsylsbpz_sbmc" readOnly="true"  name="ggwsylsbpz_name" id="qtqzm_sbmc" htmlEscape="false"  value="其它（请注明）"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="ggwsylsbpz_pp" name="ggwsylsbpz_name" id="qtqzm_pp" value="${data.qtqzm.qtqzm_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="ggwsylsbpz_xh" name="ggwsylsbpz_name" id="qtqzm_xh"  value="${data.qtqzm.qtqzm_xh }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="ggwsylsbpz_sl" name="ggwsylsbpz_name" id="qtqzm_sl"   value="${data.qtqzm.qtqzm_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="ggwsylsbpz_sbjg" name="ggwsylsbpz_name" id="qtqzm_sbjg"  value="${data.qtqzm.qtqzm_sbjg }"    value="${data.qtqzm.qtqzm_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="ggwsylsbpz_trsynf" name="ggwsylsbpz_name" id="qtqzm_trsynf"   value="${data.qtqzm.qtqzm_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="qtqzm_id"  name="ggwsylsbpz_name" value="${data.qtqzm.qtqzm_id}"  class="form-control "/>
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
		
		var data = document.getElementsByName("ggwsylsbpz_name");
	
		var datas="";
		
		
		for(i=0;i<data.length;i++){
			if(data[i].value==null||data[i].value==""){
				datas = datas +data[i].id+": ---- ;";	
			}else{
				datas = datas +data[i].id+":"+data[i].value+";";	
			}
			
			
		}
	 	
		 $.ajax({
		      url:"${ctx}/ironfoggwsylsbpz/ironfoggwsylsbpz/save",
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