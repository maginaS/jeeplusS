<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>急诊室管理</title>
	<meta name="decorator" content="default"/>
</head>
<body class="hideScroll">
		<form id="inputForm" modelAttribute="ironfoemergencyroom" action="${ctx}/ironfoemergencyroom/ironfoemergencyroom/save" method="post" class="form-horizontal">
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
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
						<input path="sbmc"  readOnly="true"  name="jzsgl_name" id="dcsjhy_sbmc"  htmlEscape="false"  value="多参数监护仪"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="pp"  name="jzsgl_name"  id="dcsjhy_pp" value="${data.dcsjhy.dcsjhy_pp }" htmlEscape="false"     class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh" name="jzsgl_name" id="dcsjhy_xh" value="${data.dcsjhy.dcsjhy_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sl" name="jzsgl_name" id="dcsjhy_sl" value="${data.dcsjhy.dcsjhy_sl }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sbjg"  name="jzsgl_name"  htmlEscape="false" value="${data.dcsjhy.dcsjhy_sbjg }"   id="dcsjhy_sbjg"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="trsynf" name="jzsgl_name"  id="dcsjhy_trsynf" value="${data.dcsjhy.dcsjhy_trsynf }"  htmlEscape="false"    class="form-control "/>
 						<input type = "hidden" htmlEscape="false" id="dcsjhy_id"   name="jzsgl_name" value="${data.dcsjhy.dcsjhy_id}"  class="form-control "/>
 						<input type = "hidden" htmlEscape="false" id="docId"   name="jzsgl_name" value="${data.doc_id}"  class="form-control "/>
 						
					</td>
				</tr>
				
			
				 <tr>
					<td class="width-15">
						<input path="sbmc" readOnly="true" name="jzsgl_name"  id="cpxly_sbmc" htmlEscape="false"  value="床旁血滤仪"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="pp" name="jzsgl_name" id="cpxly_pp" value="${data.cpxly.cpxly_pp }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh" name="jzsgl_name" id="cpxly_xh" value="${data.cpxly.cpxly_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sl" name="jzsgl_name" id="cpxly_sl" value="${data.cpxly.cpxly_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sbjg" name="jzsgl_name" id="cpxly_sbjg" value="${data.cpxly.cpxly_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="trsynf" name="jzsgl_name" id="cpxly_trsynf" value="${data.cpxly.cpxly_trsynf }" htmlEscape="false"    class="form-control "/>
					 	<input type = "hidden" htmlEscape="false" id="cpxly_id"  name="jzsgl_name" value="${data.cpxly.cpxly_id}"  class="form-control "/>
					
					</td>
				
				
				</tr> 
				
				
				 	
				<tr>
					<td class="width-15">
						<input path="sbmc" readOnly="true" id="ychxj_sbmc" name="jzsgl_name"  htmlEscape="false"  value="有创呼吸机"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="pp"  id="ychxj_pp" value="${data.ychxj.ychxj_pp }"   name="jzsgl_name"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh"  id="ychxj_xh"  value="${data.ychxj.ychxj_xh }"  name="jzsgl_name"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sl"  id="ychxj_sl"  value="${data.ychxj.ychxj_sl }"  name="jzsgl_name"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sbjg"  id="ychxj_sbjg" value="${data.ychxj.ychxj_sbjg }"   name="jzsgl_name"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="trsynf"  id="ychxj_trsynf" value="${data.ychxj.ychxj_trsynf }"   name="jzsgl_name"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="ychxj_id" value="${data.ychxj.ychxj_id }"  name="jzsgl_name" value="${data.id}"  class="form-control "/>
					
					</td>
				
				
				</tr> 
				
			 	
				<tr>
					<td class="width-15">
						<input path="sbmc" name="jzsgl_name" id="yzhxj_sbmc" readOnly="true"  htmlEscape="false"  value="转运呼吸机"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="pp" name="jzsgl_name" id="yzhxj_pp"  value="${data.yzhxj.yzhxj_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh" name= "jzsgl_name" id="yzhxj_xh" value="${data.yzhxj.yzhxj_xh }"   htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sl" name="jzsgl_name" id="yzhxj_sl" value="${data.yzhxj.yzhxj_sl }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sbjg" name="jzsgl_name" id="yzhxj_sbjg" value="${data.yzhxj.yzhxj_sbjg }"   htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="trsynf" name="jzsgl_name" id="yzhxj_trsynf" value="${data.yzhxj.yzhxj_sbjg }"   htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="yzhxj_id"   name="jzsgl_name" value="${data.yzhxj.yzhxj_id}"  class="form-control "/>
					
					</td>
				
				
				</tr>
				 
			 	
				<tr>
					<td class="width-15">
						<input path="sbmc" name="jzsgl_name" id="wchxj_sbmc" readOnly="true"  htmlEscape="false"  value="无创呼吸机"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="pp" name="jzsgl_name" id="wchxj_pp" value="${data.wchxj.wchxj_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh" name="jzsgl_name" id="wchxj_xh" value="${data.wchxj.wchxj_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sl" name="jzsgl_name" id="wchxj_sl" value="${data.wchxj.wchxj_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sbjg" name="jzsgl_name" id="wchxj_sbjg" value="${data.wchxj.wchxj_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="trsynf" name="jzsgl_name" id="wchxj_trsynf"  value="${data.wchxj.wchxj_trsynf }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="wchxj_id"  name="jzsgl_name" value="${data.wchxj.wchxj_id}"  class="form-control "/>
					
					</td>
				
				
				</tr> 
				
				
				
				
				
				 <tr>
					<td class="width-15">
						<input path="sbmc" name="jzsgl_name" id="zdptj_sbmc" readOnly="true"  htmlEscape="false"  value="振动排痰机"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="pp" name="jzsgl_name"  id="zdptj_pp"   value="${data.zdptj.zdptj_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh" name="jzsgl_name"  id="zdptj_xh"  value="${data.zdptj.zdptj_xh }"   htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sl" name="jzsgl_name"  id="zdptj_sl"   value="${data.zdptj.zdptj_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sbjg" name="jzsgl_name"  id="zdptj_sbjg"  value="${data.zdptj.zdptj_sbjg }"   htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="trsynf" name="jzsgl_name"   id="zdptj_trsynf"   value="${data.zdptj.zdptj_trsynf }" htmlEscape="false"    class="form-control "/>
					  <input type = "hidden" htmlEscape="false" id="zdptj_id"   name="jzsgl_name" value="${data.zdptj.zdptj_id}"  class="form-control "/>
					</td>
				
				
				</tr> 
				
				
				
				 <tr>
					<td class="width-15">
						<input path="sbmc" name="jzsgl_name" id="xdtj_sbmc"  readOnly="true"  htmlEscape="false"  value="心电图机"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="pp" name="jzsgl_name"  id="xdtj_pp"  value="${data.xdtj.xdtj_pp }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh" name="jzsgl_name"   id="xdtj_xh"  value="${data.xdtj.xdtj_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sl" name="jzsgl_name"   id="xdtj_sl"  value="${data.xdtj.xdtj_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sbjg" name="jzsgl_name"  id="xdtj_sbjg"  value="${data.xdtj.xdtj_sbjg }"   htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="trsynf" name="jzsgl_name"  id="xdtj_trsynf"  value="${data.xdtj.xdtj_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="xdtj_id"  name="jzsgl_name" value="${data.xdtj.xdtj_id}"  class="form-control "/>
					
					</td>
				
				
				</tr> 
				
			
			 	<tr>
					<td class="width-15">
						<input path="sbmc" name="jzsgl_name" id="xffsj_sbmc"  readOnly="true"  htmlEscape="false"  value="心肺复苏机"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="pp" name="jzsgl_name" id="xffsj_pp"   value="${data.xffsj.xffsj_pp }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh" name="jzsgl_name" id="xffsj_xh"  value="${data.xffsj.xffsj_xh }"    htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sl" name="jzsgl_name" id="xffsj_sl"  value="${data.xffsj.xffsj_sl }"    htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sbjg" htmlEscape="false"  name="jzsgl_name"  value="${data.xffsj.xffsj_sbjg }"   id="xffsj_sbjg"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="trsynf" name="jzsgl_name" id="xffsj_trsynf"   value="${data.xffsj.xffsj_trsynf }"   htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="xffsj_id"  name="jzsgl_name" value="${data.xffsj.xffsj_id}"  class="form-control "/>
					
					</td>
				
				
				</tr> 
				
				
			 	
				<tr>
					<td class="width-15">
						<input path="sbmc" name="jzsgl_name" id="qcy_sbmc"  readOnly="true"  htmlEscape="false"  value="清创仪"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="pp" name="jzsgl_name"   id="qcy_pp" value="${data.qcy.qcy_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh" name="jzsgl_name"  id="qcy_xh"  value="${data.qcy.qcy_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sl" name="jzsgl_name"   id="qcy_sl" value="${data.qcy.qcy_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sbjg" name="jzsgl_name"  id="qcy_sbjg" value="${data.qcy.qcy_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="trsynf" name="jzsgl_name"   id="qcy_trsynf" value="${data.qcy.qcy_trsynf }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="qcy_id"  name="jzsgl_name" value="${data.qcy.qcy_id}"  class="form-control "/>
					
					</td>
				
				
				</tr> 
				
				
				
			  <tr>
					<td class="width-15">
						<input path="sbmc" name="jzsgl_name" id="xwzqgj_sbmc" readOnly="true"  htmlEscape="false"  value="纤维支气管镜"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="pp" name="jzsgl_name" id="xwzqgj_pp" value="${data.xwzqgj.xwzqgj_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh" name="jzsgl_name" id="xwzqgj_xh" value="${data.xwzqgj.xwzqgj_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sl" name="jzsgl_name" id="xwzqgj_sl" value="${data.xwzqgj.xwzqgj_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sbjg" name="jzsgl_name"  id="xwzqgj_sbjg" value="${data.xwzqgj.xwzqgj_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="trsynf" name="jzsgl_name" id="xwzqgj_trsynf"  value="${data.xwzqgj.xwzqgj_trsynf }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="xwzqgj_id"  name="jzsgl_name" value="${data.xwzqgj.xwzqgj_id}"  class="form-control "/>
					
					</td>
				
				
				</tr> 
				
				
					
				 <tr>
					<td class="width-15">
						<input path="sbmc" name="jzsgl_name" id="czy_sbmc"  readOnly="true"  htmlEscape="false"  value="除颤仪"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="pp" name="jzsgl_name" id="czy_pp"  value="${data.czy.czy_pp }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh" name="jzsgl_name"  id="czy_xh"  value="${data.czy.czy_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sl" name="jzsgl_name" id="czy_sl"   value="${data.czy.czy_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sbjg" name="jzsgl_name" id="czy_sbjg"  value="${data.czy.czy_sbjg }"   htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15"> 
						<input path="trsynf" name="jzsgl_name" id="czy_trsynf"  value="${data.czy.czy_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="czy_id"  name="jzsgl_name" value="${data.czy.czy_id}"  class="form-control "/>
					
					</td>
				
				
				</tr>
				
			
				 <tr>
					<td class="width-15">
						<input path="sbmc" name="jzsgl_name" id="lsqbq_sbmc" readOnly="true"  htmlEscape="false"  value="临时起搏器"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="pp" name="jzsgl_name" id="lsqbq_pp"  value="${data.lsqbq.lsqbq_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh" name="jzsgl_name" id="lsqbq_xh" value="${data.lsqbq.lsqbq_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sl" name="jzsgl_name"  id="lsqbq_sl" value="${data.lsqbq.lsqbq_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sbjg" name="jzsgl_name" id="lsqbq_sbjg" value="${data.lsqbq.lsqbq_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="trsynf" name="jzsgl_name"  id="lsqbq_trsynf" value="${data.lsqbq.lsqbq_trsynf }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="lsqbq_id"   name="jzsgl_name" value="${data.lsqbq.lsqbq_id}"  class="form-control "/>
					
					</td>
				
				
				</tr> 
				
				
				 <tr>
					<td class="width-15">
						<input path="sbmc" name="jzsgl_name" id="xwj_sbmc" readOnly="true"  htmlEscape="false"  value="洗胃机"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="pp" name="jzsgl_name"   id="xwj_pp" value="${data.xwj.xwj_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh" name="jzsgl_name"   id="xwj_xh" value="${data.xwj.xwj_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sl" name="jzsgl_name"   id="xwj_sl" value="${data.xwj.xwj_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sbjg" name="jzsgl_name"   id="xwj_sbjg"  value="${data.xwj.xwj_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="trsynf" name="jzsgl_name"   id="xwj_trsynf" value="${data.xwj.xwj_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="xwj_id"  name="jzsgl_name" value="${data.xwj.xwj_id}"  class="form-control "/>
					
					</td>
				
				
				</tr> 
				
			 	<tr>
					<td class="width-15">
						<input path="sbmc" name="jzsgl_name" id="qjjhxjhc_sbmc" readOnly="true"  htmlEscape="false"  value="抢救监护型救护车"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="pp" name="jzsgl_name" id="qjjhxjhc_pp" value="${data.qjjhxjhc.qjjhxjhc_pp }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh" name="jzsgl_name" id="qjjhxjhc_xh" value="${data.qjjhxjhc.qjjhxjhc_xh }"   htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sl" name="jzsgl_name" id="qjjhxjhc_sl"  value="${data.qjjhxjhc.qjjhxjhc_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sbjg" name="jzsgl_name" id="qjjhxjhc_sbjg" value="${data.qjjhxjhc.qjjhxjhc_sbjg }"   htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="trsynf" name="jzsgl_name" id="qjjhxjhc_trsynf" value="${data.qjjhxjhc.qjjhxjhc_trsynf }"   htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="qjjhxjhc_id"  name="jzsgl_name" value="${data.qjjhxjhc.qjjhxjhc_id}"  class="form-control "/>
					
					</td>
				
				
				</tr>
				
				
					
				 <tr>
					<td class="width-15">
						<input path="sbmc" name="jzsgl_name" id="kshj_sbmc"  readOnly="true"  htmlEscape="false"  value="可视喉镜"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="pp" name="jzsgl_name" id="kshj_pp"  value="${data.kshj.kshj_pp }"    htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh" name="jzsgl_name" id="kshj_xh"  value="${data.kshj.kshj_xh }"   htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sl" name="jzsgl_name" id="kshj_sl"   value="${data.kshj.kshj_sl }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sbjg" name="jzsgl_name"  id="kshj_sbjg"  value="${data.kshj.kshj_sbjg }"   htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="trsynf" name="jzsgl_name"  id="kshj_trsynf"  value="${data.kshj.kshj_trsynf }"   htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="kshj_id"  name="jzsgl_name" value="${data.kshj.kshj_id}"  class="form-control "/>
					
					</td>
				
				
				</tr> 
				
				
				 <tr>
					<td class="width-15">
						<input path="sbmc" name="jzsgl_name" id="qtqzm_sbmc" readOnly="true"  htmlEscape="false"  value="其它（请注明）"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="pp" name="jzsgl_name"  id="qtqzm_pp"  value="${data.qtqzm.qtqzm_pp }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh" name="jzsgl_name"  id="qtqzm_xh"  value="${data.qtqzm.qtqzm_xh }"   htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sl" name="jzsgl_name" id="qtqzm_sl"  value="${data.qtqzm.qtqzm_sl }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sbjg" name="jzsgl_name"  id="qtqzm_sbjg"  value="${data.qtqzm.qtqzm_sbjg }"   htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="trsynf" name="jzsgl_name" id="qtqzm_trsynf"  value="${data.qtqzm.qtqzm_trsynf }"    htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="qtqzm_id"  name="jzsgl_name" value="${data.qtqzm.qtqzm_id}"  class="form-control "/>
					
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
		
		var data = document.getElementsByName("jzsgl_name");
	
		var datas="";
		
		
		for(i=0;i<data.length;i++){
			if(data[i].value==null||data[i].value==""){
				datas = datas +data[i].id+": ---- ;";	
			}else{
				datas = datas +data[i].id+":"+data[i].value+";";	
			}
			
			
		}
	 	
		 $.ajax({
		      url:"${ctx}/ironfoemergencyroom/ironfoemergencyroom/save",
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