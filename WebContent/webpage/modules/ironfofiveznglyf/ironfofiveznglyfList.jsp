<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>5.7职能管理用房管理</title>
	<meta name="decorator" content="default"/>
	
</head>
<body class="hideScroll">
		<form id="inputForm" modelAttribute="ironfofiveznglyf" action="${ctx}/ironfofiveznglyf/ironfofiveznglyf/save" method="post" class="form-horizontal">
		<%-- <form:hidden path="id"/>
		<sys:message content="${message}"/>	 --%>
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
				
					注：
					<br /> 功能单元建筑面积：该功能单元所有房间和场所的建筑面积之和。
					<br /> 空间类型：乡镇卫生院设置有该类场所就算作有此种类型的空间，不需要名称一致。
					<br />
				
					<%-- <td class="width-15 active"><label class="pull-right">备注信息：</label></td>
					<td class="width-35">
						<form:textarea path="remarks" htmlEscape="false" rows="4"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">主表id：</label></td>
					<td class="width-35">
						<form:input path="doc_id" htmlEscape="false"    class="form-control "/>
					</td> --%>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">功能单元建筑面积（m2）</label></td>
					<td class="width-35">
					<!-- 	<input path="gndyjzmj" htmlEscape="false"    class="form-control "/>
					</td> -->
					<input   name="gndyjzmj_name_gndyjzmj_znglyf"  id="gndyjzmj" value="${data.gndyjzmj }"   htmlEscape="false" class="form-control " /></td>
					<input   type="hidden" name="gndyjzmj_name_gndyjzmj_znglyf"  id="docId"  value="${data.doc_id}" htmlEscape="false"    class="form-control "/>
				
					
				</tr>
				
				
				
			</tbody>
		</table>

		<div class="tabs-container">
			<ul class="nav nav-tabs">
				<li class="active"><a data-toggle="tab" href="#tab-1"
					aria-expanded="true">职能管理用房空间类型</a></li>
			</ul>


			<div class="tab-content">
				<div id="tab-1" class="tab-pane active">
					<table id="contentTable"
						class="table table-striped table-bordered table-condensed">
						<thead>
				
				
				
				<tr>
					<td>
					
						<c:if test="${data.yzbgs=='1' }">
							<input type="checkbox" name="znglyf_name" path="yzbgs" id="yzbgs" value="yzbgs" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;院长办公室
						</c:if>
						<c:if test="${data.yzbgs=='0' }">
							<input type="checkbox" name="znglyf_name" id="yzbgs" value="yzbgs" path="yzbgs" style="margin-top: -2px;" />&nbsp;院长办公室
						</c:if>
						
					</td>
					<td>
						<c:if test="${data.djbgs=='1' }">
							<input type="checkbox" name="znglyf_name" path="djbgs" id="djbgs" value="djbgs" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;党建办公室
						</c:if>
						<c:if test="${data.djbgs=='0' }">
							<input type="checkbox" name="znglyf_name" id="djbgs" value="djbgs" path="djbgs" style="margin-top: -2px;" />&nbsp;党建办公室
						</c:if>
						
					</td>
					<td>
					
						<c:if test="${data.ywkbgs=='1' }">
							<input type="checkbox" name="znglyf_name" path="ywkbgs" id="ywkbgs" value="ywkbgs" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;医务科办公室
						</c:if>
						<c:if test="${data.ywkbgs=='0' }">
							<input type="checkbox" name="znglyf_name" id="ywkbgs" value="ywkbgs" path="ywkbgs" style="margin-top: -2px;" />&nbsp;医务科办公室
						</c:if>
						
					</td>
				
					<td>
					
						<c:if test="${data.hlkbgs=='1' }">
							<input type="checkbox" name="znglyf_name" path="hlkbgs" id="hlkbgs" value="hlkbgs" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;护理科办公室
						</c:if>
						<c:if test="${data.hlkbgs=='0' }">
							<input type="checkbox" name="znglyf_name" id="hlkbgs" value="hlkbgs" path="hlkbgs" style="margin-top: -2px;" />&nbsp;护理科办公室
						</c:if>
						
					</td>
					<td>
						<c:if test="${data.cwkbgs=='1' }">
							<input type="checkbox" name="znglyf_name" path="cwkbgs" id="cwkbgs" value="cwkbgs" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;财务科办公室
						</c:if>
						<c:if test="${data.cwkbgs=='0' }">
							<input type="checkbox" name="znglyf_name" id="cwkbgs" value="cwkbgs" path="cwkbgs" style="margin-top: -2px;" />&nbsp;财务科办公室
						</c:if>
						
					</td>
				
					<td>
						<c:if test="${data.daglkbgs=='1' }">
							<input type="checkbox" name="znglyf_name" path="daglkbgs" id="daglkbgs" value="daglkbgs" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;病案管理科办公室
						</c:if>
						<c:if test="${data.daglkbgs=='0' }">
							<input type="checkbox" name="znglyf_name" id="daglkbgs" value="daglkbgs" path="daglkbgs" style="margin-top: -2px;" />&nbsp;病案管理科办公室
						</c:if>
						
					</td>
					<td>
						<c:if test="${data.xxzx=='1' }">
							<input type="checkbox" name="znglyf_name" path="xxzx" id="xxzx" value="xxzx" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;信息中心
						</c:if>
						<c:if test="${data.xxzx=='0' }">
							<input type="checkbox" name="znglyf_name" id="xxzx" value="xxzx" path="xxzx" style="margin-top: -2px;" />&nbsp;信息中心
						</c:if>
						
					</td>
				</tr>
				<tr>
					<td>
					
						<c:if test="${data.ygkbgs=='1' }">
							<input type="checkbox" name="znglyf_name" path="ygkbgs" id="ygkbgs" value="ygkbgs" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;院感科办公室
						</c:if>
						<c:if test="${data.ygkbgs=='0' }">
							<input type="checkbox" name="znglyf_name" id="ygkbgs" value="ygkbgs" path="ygkbgs" style="margin-top: -2px;" />&nbsp;院感科办公室
						</c:if>
						
					</td>
					<td>
					
						<c:if test="${data.ybjskbgs=='1' }">
							<input type="checkbox" name="znglyf_name" path="ybjskbgs" id="ybjskbgs" value="ybjskbgs" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;医保结算科办公室
						</c:if>
						<c:if test="${data.ybjskbgs=='0' }">
							<input type="checkbox" name="znglyf_name" id="ybjskbgs" value="ybjskbgs" path="ybjskbgs" style="margin-top: -2px;" />&nbsp;医保结算科办公室
						</c:if>
						
					</td>
				
					<td>
					
						<c:if test="${data.hqglkbgs=='1' }">
							<input type="checkbox" name="znglyf_name" path="hqglkbgs" id="hqglkbgs" value="hqglkbgs" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;后勤管理科办公室
						</c:if>
						<c:if test="${data.hqglkbgs=='0' }">
							<input type="checkbox" name="znglyf_name" id="hqglkbgs" value="hqglkbgs" path="hqglkbgs" style="margin-top: -2px;" />&nbsp;后勤管理科办公室
						</c:if>
						
					</td>
					<td>
						<c:if test="${data.dgnhys=='1' }">
							<input type="checkbox" name="znglyf_name" path="dgnhys" id="dgnhys" value="dgnhys" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;多功能会议室
						</c:if>
						<c:if test="${data.dgnhys=='0' }">
							<input type="checkbox" name="znglyf_name" id="dgnhys" value="dgnhys" path="dgnhys" style="margin-top: -2px;" />&nbsp;多功能会议室
						</c:if>
						
					</td>
				
					<td>
						<c:if test="${data.xyf=='1' }">
							<input type="checkbox" name="znglyf_name" path="xyf" id="xyf" value="xyf" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;洗衣房
						</c:if>
						<c:if test="${data.xyf=='0' }">
							<input type="checkbox" name="znglyf_name" id="xyf" value="xyf" path="xyf" style="margin-top: -2px;" />&nbsp;洗衣房
						</c:if>
						
					</td>
					<td>
						<c:if test="${data.yycf=='1' }">
							<input type="checkbox" name="znglyf_name" path="yycf" id="yycf" value="yycf" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;营养厨房
						</c:if>
						<c:if test="${data.yycf=='0' }">
							<input type="checkbox" name="znglyf_name" id="yycf" value="yycf" path="yycf" style="margin-top: -2px;" />&nbsp;营养厨房
						</c:if>
						
					</td>
			
					<td>
						<c:if test="${data.ylljzcjljzcj=='1' }">
							<input type="checkbox" name="znglyf_name" path="ylljzcjljzcj" id="ylljzcjljzcj" value="ylljzcjljzcj" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;医疗垃圾暂存间-垃圾暂存间
						</c:if>
						<c:if test="${data.ylljzcjljzcj=='0' }">
							<input type="checkbox" name="znglyf_name" id="ylljzcjljzcj" value="ylljzcjljzcj" path="ylljzcjljzcj" style="margin-top: -2px;" />&nbsp;医疗垃圾暂存间-垃圾暂存间
						</c:if>
						
					</td>
				</tr>
				<tr>
					<td>
						<c:if test="${data.shljzcjljzcj=='1' }">
							<input type="checkbox" name="znglyf_name" path="shljzcjljzcj" id="shljzcjljzcj" value="shljzcjljzcj" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;生活垃圾暂存间-垃圾暂存间
						</c:if>
						<c:if test="${data.shljzcjljzcj=='0' }">
							<input type="checkbox" name="znglyf_name" id="shljzcjljzcj" value="shljzcjljzcj" path="shljzcjljzcj" style="margin-top: -2px;" />&nbsp;生活垃圾暂存间-垃圾暂存间
						</c:if>
						
					</td>
				
					<td>
					
						<c:if test="${data.tpj=='1' }">
							<input type="checkbox" name="znglyf_name" path="tpj" id="tpj" value="tpj" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;太平间
						</c:if>
						<c:if test="${data.tpj=='0' }">
							<input type="checkbox" name="znglyf_name" id="tpj" value="tpj" path="tpj" style="margin-top: -2px;" />&nbsp;太平间
						</c:if>
						
					</td>
					<td>
						<c:if test="${data.bpdsbpdyf=='1' }">
							<input type="checkbox" name="znglyf_name" path="bpdsbpdyf" id="bpdsbpdyf" value="bpdsbpdyf" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;变配电室-变配电用房
						</c:if>
						<c:if test="${data.bpdsbpdyf=='0' }">
							<input type="checkbox" name="znglyf_name" id="bpdsbpdyf" value="bpdsbpdyf" path="bpdsbpdyf" style="margin-top: -2px;" />&nbsp;变配电室-变配电用房
						</c:if>
						
					</td>
			
					<td>
					
						<c:if test="${data.bpdzbsbpdyf=='1' }">
							<input type="checkbox" name="znglyf_name" path="bpdzbsbpdyf" id="bpdzbsbpdyf" value="bpdzbsbpdyf" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;变配电值班室-变配电用房
						</c:if>
						<c:if test="${data.bpdzbsbpdyf=='0' }">
							<input type="checkbox" name="znglyf_name" id="bpdzbsbpdyf" value="bpdzbsbpdyf" path="bpdzbsbpdyf" style="margin-top: -2px;" />&nbsp;变配电值班室-变配电用房
						</c:if>
						
					</td>
					<td>
					
						<c:if test="${data.cyfdjfcyfdyf=='1' }">
							<input type="checkbox" name="znglyf_name" path="cyfdjfcyfdyf" id="cyfdjfcyfdyf" value="cyfdjfcyfdyf" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;柴油发电机房-柴油发电用房
						</c:if>
						<c:if test="${data.cyfdjfcyfdyf=='0' }">
							<input type="checkbox" name="znglyf_name" id="cyfdjfcyfdyf" value="cyfdjfcyfdyf" path="cyfdjfcyfdyf" style="margin-top: -2px;" />&nbsp;柴油发电机房-柴油发电用房
						</c:if>
						
					</td>
			
					<td>
						<c:if test="${data.ykcyfdyf=='1' }">
							<input type="checkbox" name="znglyf_name" path="ykcyfdyf" id="ykcyfdyf" value="ykcyfdyf" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;油库-柴油发电用房
						</c:if>
						<c:if test="${data.ykcyfdyf=='0' }">
							<input type="checkbox" name="znglyf_name" id="ykcyfdyf" value="ykcyfdyf" path="ykcyfdyf" style="margin-top: -2px;" />&nbsp;油库-柴油发电用房
						</c:if>
						
					</td>
					<td>
					
						<c:if test="${data.dtjf=='1' }">
							<input type="checkbox" name="znglyf_name" path="dtjf" id="dtjf" value="dtjf" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;电梯机房
						</c:if>
						<c:if test="${data.dtjf=='0' }">
							<input type="checkbox" name="znglyf_name"  id="dtjf" value="dtjf" path="dtjf" style="margin-top: -2px;" />&nbsp;电梯机房
						</c:if>
						
					</td>
				</tr>
				<tr>
					<td>
					
						<c:if test="${data.glfglyf=='1' }">
							<input type="checkbox" name="znglyf_name" path="glfglyf" id="glfglyf" value="glfglyf" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;锅炉房-锅炉用房
						</c:if>
						<c:if test="${data.glfglyf=='0' }">
							<input type="checkbox" name="znglyf_name" id="glfglyf" value="glfglyf" path="glfglyf" style="margin-top: -2px;" />&nbsp;锅炉房-锅炉用房
						</c:if>
						
					</td>
					<td>
						<c:if test="${data.glkzsglyf=='1' }">
							<input type="checkbox" name="znglyf_name" path="glkzsglyf" id="glkzsglyf" value="glkzsglyf" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;锅炉控制室-锅炉用房
						</c:if>
						<c:if test="${data.glkzsglyf=='0' }">
							<input type="checkbox" name="znglyf_name" id="glkzsglyf" value="glkzsglyf" path="glkzsglyf" style="margin-top: -2px;" />&nbsp;锅炉控制室-锅炉用房
						</c:if>
						
					</td>
				
					<td>
					
						<c:if test="${data.rqbjglyf=='1' }">
							<input type="checkbox" name="znglyf_name" path="rqbjglyf" id="rqbjglyf" value="rqbjglyf" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;燃气表间-锅炉用房
						</c:if>
						<c:if test="${data.rqbjglyf=='0' }">
							<input type="checkbox" name="znglyf_name" id="rqbjglyf" value="rqbjglyf" path="rqbjglyf" style="margin-top: -2px;" />&nbsp;燃气表间-锅炉用房
						</c:if>
						
					</td>
					<td>
					
						<c:if test="${data.lsjf=='1' }">
							<input type="checkbox" name="znglyf_name" path="lsjf" id="lsjf" value="lsjf" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;冷水机房
						</c:if>
						<c:if test="${data.lsjf=='0' }">
							<input type="checkbox" name="znglyf_name" id="lsjf" value="lsjf" path="lsjf" style="margin-top: -2px;" />&nbsp;冷水机房
						</c:if>
						
					</td>
				
					<td>
					
						<c:if test="${data.ktjf=='1' }">
							<input type="checkbox" name="znglyf_name" path="ktjf" id="ktjf" value="ktjf" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;空调机房
						</c:if>
						<c:if test="${data.ktjf=='0' }">
							<input type="checkbox" name="znglyf_name" id="ktjf" value="ktjf" path="ktjf" style="margin-top: -2px;" />&nbsp;空调机房
						</c:if>
						
					</td>
					<td>
					
						<c:if test="${data.tfjf=='1' }">
							<input type="checkbox" name="znglyf_name" path="tfjf" id="tfjf" value="tfjf" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;通风机房
						</c:if>
						<c:if test="${data.tfjf=='0' }">
							<input type="checkbox" name="znglyf_name" id="tfjf" value="tfjf" path="tfjf" style="margin-top: -2px;" />&nbsp;通风机房
						</c:if>
						
					</td>
				
					<td>
					
						<c:if test="${data.gsbf=='1' }">
							<input type="checkbox" name="znglyf_name" path="gsbf" id="gsbf" value="gsbf" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;给水泵房
						</c:if>
						<c:if test="${data.gsbf=='0' }">
							<input type="checkbox" name="znglyf_name" id="gsbf" value="gsbf" path="gsbf" style="margin-top: -2px;" />&nbsp;给水泵房
						</c:if>
						
					</td>
				</tr>
				<tr>
					<td>
						<c:if test="${data.xfbf=='1' }">
							<input type="checkbox" name="znglyf_name" path="xfbf" id="xfbf" value="xfbf" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;消防泵房
						</c:if>
						<c:if test="${data.xfbf=='0' }">
							<input type="checkbox" name="znglyf_name" id="xfbf" value="xfbf" path="xfbf" style="margin-top: -2px;" />&nbsp;消防泵房
						</c:if>
						
					</td>
				
					<td>
						<c:if test="${data.bjzs=='1' }">
							<input type="checkbox" name="znglyf_name" path="bjzs" id="bjzs" value="bjzs" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;报警阀室
						</c:if>
						<c:if test="${data.bjzs=='0' }">
							<input type="checkbox" name="znglyf_name" id="bjzs" value="bjzs" path="bjzs" style="margin-top: -2px;" />&nbsp;报警阀室
						</c:if>
						
					</td>
					<td>
						<c:if test="${data.xfsxj=='1' }">
							<input type="checkbox" name="znglyf_name" path="xfsxj" id="xfsxj" value="xfsxj" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;消防水箱间
						</c:if>
						<c:if test="${data.xfsxj=='0' }">
							<input type="checkbox" name="znglyf_name" id="xfsxj" value="xfsxj" path="xfsxj" style="margin-top: -2px;" />&nbsp;消防水箱间
						</c:if>
						
						
					</td>
				
					<td>
						<c:if test="${data.xfkzs=='1' }">
							<input type="checkbox" name="znglyf_name" path="xfkzs" id="xfkzs" value="xfkzs" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;消防控制室
						</c:if>
						<c:if test="${data.xfkzs=='0' }">
							<input type="checkbox" name="znglyf_name" id="xfkzs" value="xfkzs" path="xfkzs" style="margin-top: -2px;" />&nbsp;消防控制室
						</c:if>
						
					</td>
					<td>
					
						<c:if test="${data.afjks=='1' }">
							<input type="checkbox" name="znglyf_name" path="afjks" id="afjks" value="afjks" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;安防监控室
						</c:if>
						<c:if test="${data.afjks=='0' }">
							<input type="checkbox" name="znglyf_name" id="afjks" value="afjks" path="afjks" style="margin-top: -2px;" />&nbsp;安防监控室
						</c:if>
						
					</td>
				
					<td>
					
						<c:if test="${data.txwljf=='1' }">
							<input type="checkbox" name="znglyf_name" path="txwljf" id="txwljf" value="txwljf" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;通信网络机房
						</c:if>
						<c:if test="${data.txwljf=='0' }">
							<input type="checkbox" name="znglyf_name" id="txwljf" value="txwljf" path="txwljf" style="margin-top: -2px;" />&nbsp;通信网络机房
						</c:if>
						
					</td>
					<td>
					
						<c:if test="${data.xxhxtjf=='1' }">
							<input type="checkbox" name="znglyf_name" path="xxhxtjf" id="xxhxtjf" value="xxhxtjf" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;信息化系统机房
						</c:if>
						<c:if test="${data.xxhxtjf=='0' }">
							<input type="checkbox" name="znglyf_name" id="xxhxtjf" value="xxhxtjf" path="xxhxtjf" style="margin-top: -2px;" />&nbsp;信息化系统机房
						</c:if>
						
					</td>
				</tr>
				<tr>
					<td>
						<c:if test="${data.mws=='1' }">
							<input type="checkbox" name="znglyf_name" path="mws" id="mws" value="mws" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;门卫室
						</c:if>
						<c:if test="${data.mws=='0' }">
							<input type="checkbox" name="znglyf_name" id="mws" value="mws" path="mws" style="margin-top: -2px;" />&nbsp;门卫室
						</c:if>
						
					</td>
					<td>
					
						<c:if test="${data.sntcc=='1' }">
							<input type="checkbox" name="znglyf_name" path="sntcc" id="sntcc" value="sntcc" htmlEscape="false" style="margin-top: -2px;" checked="checked"/>&nbsp;室内停车场
						</c:if>
						<c:if test="${data.sntcc=='0' }">
							<input type="checkbox" name="znglyf_name" id="sntcc" value="sntcc" path="sntcc" style="margin-top: -2px;" />&nbsp;室内停车场
						</c:if>
						
					</td>
				</tr>
				<tr>
						<td>其它（请注明）</td><td><input name="znglyf_name_qtqzm" id="znglyf_name_qtqzm" value="${data.qtqzm }"  type="text" /></td>
							<input type = "hidden" htmlEscape="false" id="znglyf_name_id"   name="znglyf_name_id" value="${data.id}"  class="form-control "/>
					
								
				
				<!-- 	<td class="width-15 active"><label class="pull-right">其它（请注明）：</label></td>
					<td class="width-35">
						<input path="qtqzm" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"></td>
		   			<td class="width-35" ></td> -->
		  		</tr>
		 	</thead>
					</table>
				</div>
			</div>

		</div>
	</form>
	
	
	<div style="text-align:right;">
		<input type="button" value="保存"  style="width:100px;height:50px;margin-right: 20px;" onclick="subuimtinput();"/>
	</div>
	
	
	
	<script type="text/javascript">
	

	function subuimtinput(){
		var checkval="";
		var checkout="";
		
		var data = document.getElementsByName("znglyf_name");
	 	var remarks = document.getElementById("znglyf_name_qtqzm").value;
		var id= document.getElementById("znglyf_name_id").value; 
		var title = document.getElementsByName("gndyjzmj_name_gndyjzmj_znglyf");
		var titles="";
		for(var i=0;i<title.length;i++){
			if(title[i].value==null||title[i].value==""){
				titles = titles +title[i].id+": ---- ;";	
			}else{
				titles = titles +title[i].id+":"+title[i].value+";";	
			}
		}
		
		
	
	    check_val = [];
	    check_out = [];
	    for(a in data){
	        if(data[a].checked){
	        	  check_val.push(data[a].value);
	        }else{
	        	  check_out.push(data[a].value);
	        }  
	    } 
	    
	    checkval=checkval+check_val;
	    checkout=checkout+check_out;
		 $.ajax({
		      url:"${ctx}/ironfofiveznglyf/ironfofiveznglyf/save",
		      data:{
		    	  titles:titles,
		    	  checkval:checkval,
		    	  checkout:checkout,
		    	  qtqzm:remarks,
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