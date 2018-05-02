<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>眼科、耳鼻咽喉科管理</title>
	<meta name="decorator" content="default"/>
	
</head>
<body class="hideScroll">
		<form id="inputForm" modelAttribute="ironfoyjbylsbpzykebyhk" action="${ctx}/ironfoyjbylsbpzykebyhk/ironfoyjbylsbpzykebyhk/save" method="post" class="form-horizontal">
		
		
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
					<%-- <td class="width-15 active"><label class="pull-right">备注信息：</label></td>
					<td class="width-35">
						<form:textarea path="remarks" htmlEscape="false" rows="4"    class="form-control "/>
					</td> --%>
					<td class="width-15 active"><label class="pull-right">设备名称：</label></td>
					<td class="width-15 active"><label class="pull-right">品牌：</label></td>
					<td class="width-15 active"><label class="pull-right">型号：</label></td>
					<td class="width-15 active"><label class="pull-right">数量（台/个）：</label></td>
					<td class="width-15 active"><label class="pull-right">设备价格（元）：</label></td>
					<td class="width-15 active"><label class="pull-right">投入使用年份：</label></td>
					
				</tr>
				<tr>
					
					<td class="width-15">
						<input path="sbmc" readOnly="true"  name="ykebyhk_name" id="ydygzyy_sbmc" htmlEscape="false"  value="眼底荧光造影仪"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp" name="ykebyhk_name"   id="ydygzyy_pp" value="${data.ydygzyy.ydygzyy_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh" name="ykebyhk_name"  id="ydygzyy_xh" value="${data.ydygzyy.ydygzyy_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sl" name="ykebyhk_name"  id="ydygzyy_sl" value="${data.ydygzyy.ydygzyy_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sbjg" name="ykebyhk_name"  id="ydygzyy_sbjg" value="${data.ydygzyy.ydygzyy_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						
						<input path="trsynf" name="ykebyhk_name"  id="ydygzyy_trsynf" value="${data.ydygzyy.ydygzyy_trsynf }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="ydygzyy_id"  name="ykebyhk_name" value="${data.ydygzyy.ydygzyy_id}"  class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="docId"   name="ykebyhk_name" value="${data.doc_id}"  class="form-control "/>
					
					</td>
				</tr>
				<tr>
				
					<td class="width-15">
						<input path="sbmc" readOnly="true"  name="ykebyhk_name" id="ykssxwj_sbmc" htmlEscape="false"  value="眼科手术显微镜"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp" name="ykebyhk_name" id="ykssxwj_pp" value="${data.ykssxwj.ykssxwj_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh" name="ykebyhk_name" id="ykssxwj_xh" value="${data.ykssxwj.ykssxwj_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sl" name="ykebyhk_name" id="ykssxwj_sl" value="${data.ykssxwj.ykssxwj_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sbjg" name="ykebyhk_name" id="ykssxwj_sbjg" value="${data.ykssxwj.ykssxwj_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="trsynf" name="ykebyhk_name" id="ykssxwj_trsynf" value="${data.ykssxwj.ykssxwj_trsynf }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="ykssxwj_id"  name="ykebyhk_name" value="${data.ykssxwj.ykssxwj_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
				
					<td class="width-15">
						<input path="sbmc" readOnly="true"  name="ykebyhk_name" id="gxxgdcsmy_sbmc" htmlEscape="false"  value="光学相干断层扫描仪"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp" name="ykebyhk_name" id="gxxgdcsmy_pp" value="${data.gxxgdcsmy.gxxgdcsmy_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh" name="ykebyhk_name" id="gxxgdcsmy_xh" value="${data.gxxgdcsmy.gxxgdcsmy_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sl" name="ykebyhk_name" id="gxxgdcsmy_sl" value="${data.gxxgdcsmy.gxxgdcsmy_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sbjg" name="ykebyhk_name" id="gxxgdcsmy_sbjg" value="${data.gxxgdcsmy.gxxgdcsmy_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="trsynf" name="ykebyhk_name" id="gxxgdcsmy_trsynf" value="${data.gxxgdcsmy.gxxgdcsmy_trsynf }" htmlEscape="false"    class="form-control "/>
					<input type = "hidden" htmlEscape="false" id="gxxgdcsmy_id"  name="ykebyhk_name" value="${data.gxxgdcsmy.gxxgdcsmy_id}"  class="form-control "/>
					
					</td>
					
				</tr>
				<tr>
				
					<td class="width-15">
						<input path="sbmc" readOnly="true"  name="ykebyhk_name" id="ykabcszdy_sbmc" htmlEscape="false"  value="眼科A/B超声诊断仪"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp" name="ykebyhk_name" id="ykabcszdy_pp"  value="${data.ykabcszdy.ykabcszdy_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh" name="ykebyhk_name" id="ykabcszdy_xh" value="${data.ykabcszdy.ykabcszdy_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sl" name="ykebyhk_name" id="ykabcszdy_sl" value="${data.ykabcszdy.ykabcszdy_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sbjg" name="ykebyhk_name" id="ykabcszdy_sbjg" value="${data.ykabcszdy.ykabcszdy_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="trsynf" name="ykebyhk_name" id="ykabcszdy_trsynf" value="${data.ykabcszdy.ykabcszdy_trsynf }"  htmlEscape="false"    class="form-control "/>
					<input type = "hidden" htmlEscape="false" id="ykabcszdy_id"  name="ykebyhk_name" value="${data.ykabcszdy.ykabcszdy_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
				
					<td class="width-15">
						<input path="sbmc" readOnly="true"   name="ykebyhk_name" id="syj_sbmc"  htmlEscape="false"  value="视野计"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp" name="ykebyhk_name"  id="syj_pp" value="${data.syj.syj_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh" name="ykebyhk_name"  id="syj_xh" value="${data.syj.syj_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sl" name="ykebyhk_name"  id="syj_sl" value="${data.syj.syj_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sbjg" name="ykebyhk_name"  id="syj_sbjg" value="${data.syj.syj_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="trsynf" name="ykebyhk_name"  id="syj_trsynf" value="${data.syj.syj_trsynf }" htmlEscape="false"    class="form-control "/>
					<input type = "hidden" htmlEscape="false" id="syj_id"  name="ykebyhk_name" value="${data.syj.syj_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
				
					<td class="width-15">
						<input path="sbmc" readOnly="true"  name="ykebyhk_name" id="csrhy_sbmc" htmlEscape="false"  value="超声乳化仪"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp" name="ykebyhk_name" id="csrhy_pp"  value="${data.csrhy.csrhy_pp}" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh" name="ykebyhk_name" id="csrhy_xh"  value="${data.csrhy.csrhy_xh}" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sl" name="ykebyhk_name" id="csrhy_sl"  value="${data.csrhy.csrhy_sl}" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sbjg" name="ykebyhk_name" id="csrhy_sbjg"  value="${data.csrhy.csrhy_sbjg}" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="trsynf" name="ykebyhk_name" id="csrhy_trsynf"  value="${data.csrhy.csrhy_trsynf}" htmlEscape="false"    class="form-control "/>
					<input type = "hidden" htmlEscape="false" id="csrhy_id"  name="ykebyhk_name" value="${data.csrhy.csrhy_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
					<tr>
				
					<td class="width-15">
						<input path="sbmc" readOnly="true"  name="ykebyhk_name" id="ydzxj_sbmc" htmlEscape="false"  value="眼底照相机"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp" name="ykebyhk_name"  id="ydzxj_pp"  value="${data.ydzxj.ydzxj_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh" name="ykebyhk_name"  id="ydzxj_xh" value="${data.ydzxj.ydzxj_xh }"   htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sl" name="ykebyhk_name"  id="ydzxj_sl"  value="${data.ydzxj.ydzxj_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sbjg" name="ykebyhk_name"  id="ydzxj_sbjg" value="${data.ydzxj.ydzxj_sbjg }"   htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="trsynf" name="ykebyhk_name"  id="ydzxj_trsynf" value="${data.ydzxj.ydzxj_trsynf }"   htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="ydzxj_id"  name="ykebyhk_name" value="${data.ydzxj.ydzxj_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
				
					<td class="width-15">
						<input path="sbmc" readOnly="true"  name="ykebyhk_name" id="yqjzxxt_sbmc" htmlEscape="false"  value="眼前节照相系统"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp" name="ykebyhk_name" id="yqjzxxt_pp" value="${data.yqjzxxt.yqjzxxt_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh" name="ykebyhk_name" id="yqjzxxt_xh"  value="${data.yqjzxxt.yqjzxxt_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sl" name="ykebyhk_name" id="yqjzxxt_sl" value="${data.yqjzxxt.yqjzxxt_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sbjg" name="ykebyhk_name" id="yqjzxxt_sbjg" value="${data.yqjzxxt.yqjzxxt_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15"> 
						<input path="trsynf" name="ykebyhk_name" id="yqjzxxt_trsynf" value="${data.yqjzxxt.yqjzxxt_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="yqjzxxt_id"  name="ykebyhk_name" value="${data.yqjzxxt.yqjzxxt_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
				
					<td class="width-15">
						<input path="sbmc" readOnly="true"  name="ykebyhk_name" id="dnygy_sbmc" htmlEscape="false"  value="电脑验光仪"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp" name="ykebyhk_name"  id="dnygy_pp" value="${data.dnygy.dnygy_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh" name="ykebyhk_name"  id="dnygy_xh" value="${data.dnygy.dnygy_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sl" name="ykebyhk_name"  id="dnygy_sl" value="${data.dnygy.dnygy_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sbjg" name="ykebyhk_name"  id="dnygy_sbjg" value="${data.dnygy.dnygy_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15"> 
						<input path="trsynf" name="ykebyhk_name"  id="dnygy_trsynf" value="${data.dnygy.dnygy_trsynf }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="dnygy_id"  name="ykebyhk_name" value="${data.dnygy.dnygy_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
				
					<td class="width-15">
						<input path="sbmc" readOnly="true"  name="ykebyhk_name" id="fjcsyyj_sbmc" htmlEscape="false"  value="非接触式眼压计"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp" name="ykebyhk_name" id="fjcsyyj_pp" value="${data.fjcsyyj.fjcsyyj_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh" name="ykebyhk_name" id="fjcsyyj_xh" value="${data.fjcsyyj.fjcsyyj_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sl" name="ykebyhk_name" id="fjcsyyj_sl" value="${data.fjcsyyj.fjcsyyj_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sbjg" name="ykebyhk_name" id="fjcsyyj_sbjg" value="${data.fjcsyyj.fjcsyyj_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="trsynf" name="ykebyhk_name" id="fjcsyyj_trsynf" value="${data.fjcsyyj.fjcsyyj_trsynf }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="fjcsyyj_id"  name="ykebyhk_name" value="${data.fjcsyyj.fjcsyyj_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
				
					<td class="width-15">
						<input path="sbmc" readOnly="true"  name="ykebyhk_name" id="smjjydj_sbmc" htmlEscape="false"  value="双目间接眼底镜"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp" name="ykebyhk_name"  id="smjjydj_pp" value="${data.smjjydj.smjjydj_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh" name="ykebyhk_name"  id="smjjydj_xh" value="${data.smjjydj.smjjydj_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sl" name="ykebyhk_name"  id="smjjydj_sl" value="${data.smjjydj.smjjydj_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sbjg" name="ykebyhk_name"  id="smjjydj_sbjg" value="${data.smjjydj.smjjydj_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="trsynf" name="ykebyhk_name"  id="smjjydj_trsynf" value="${data.smjjydj.smjjydj_trsynf }" htmlEscape="false"    class="form-control "/>
					<input type = "hidden" htmlEscape="false" id="smjjydj_id"  name="ykebyhk_name" value="${data.smjjydj.smjjydj_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
				
					<td class="width-15">
						<input path="sbmc" readOnly="true"  name="ykebyhk_name" id="lhdxwj_sbmc" htmlEscape="false"  value="裂隙灯显微镜"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp" name="ykebyhk_name" id="lhdxwj_pp" value="${data.lhdxwj.lhdxwj_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh" name="ykebyhk_name" id="lhdxwj_xh" value="${data.lhdxwj.lhdxwj_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sl" name="ykebyhk_name" id="lhdxwj_sl" value="${data.lhdxwj.lhdxwj_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sbjg" name="ykebyhk_name" id="lhdxwj_sbjg" value="${data.lhdxwj.lhdxwj_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="trsynf" name="ykebyhk_name" id="lhdxwj_trsynf" value="${data.lhdxwj.lhdxwj_trsynf }"  htmlEscape="false"    class="form-control "/>
					<input type = "hidden" htmlEscape="false" id="lhdxwj_id"  name="ykebyhk_name" value="${data.lhdxwj.lhdxwj_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
				
					<td class="width-15">
						<input path="sbmc" readOnly="true"  name="ykebyhk_name" id="jmchy_sbmc" htmlEscape="false"  value="角膜测厚仪"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp" name="ykebyhk_name"  id="jmchy_pp" value="${data.jmchy.jmchy_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh" name="ykebyhk_name"  id="jmchy_xh" value="${data.jmchy.jmchy_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sl" name="ykebyhk_name"  id="jmchy_sl" value="${data.jmchy.jmchy_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sbjg" name="ykebyhk_name"  id="jmchy_sbjg" value="${data.jmchy.jmchy_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="trsynf" name="ykebyhk_name"  id="jmchy_trsynf" value="${data.jmchy.jmchy_trsynf }" htmlEscape="false"    class="form-control "/>
					<input type = "hidden" htmlEscape="false" id="jmchy_id"  name="ykebyhk_name" value="${data.jmchy.jmchy_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
				
					<td class="width-15">
						<input path="sbmc" readOnly="true"  name="ykebyhk_name" id="ebhnkjxt_sbmc"   htmlEscape="false"  value="耳鼻喉内窥镜系统"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp" name="ykebyhk_name"  id="ebhnkjxt_pp"  value="${data.ebhnkjxt.ebhnkjxt_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh" name="ykebyhk_name"  id="ebhnkjxt_xh" value="${data.ebhnkjxt.ebhnkjxt_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sl" name="ykebyhk_name"  id="ebhnkjxt_sl" value="${data.ebhnkjxt.ebhnkjxt_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sbjg" name="ykebyhk_name"  id="ebhnkjxt_sbjg" value="${data.ebhnkjxt.ebhnkjxt_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="trsynf" name="ykebyhk_name"  id="ebhnkjxt_trsynf" value="${data.ebhnkjxt.ebhnkjxt_trsynf }" htmlEscape="false"    class="form-control "/>
					<input type = "hidden" htmlEscape="false" id="ebhnkjxt_id"  name="ykebyhk_name" value="${data.ebhnkjxt.ebhnkjxt_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
					<tr>
				
					<td class="width-15">
						<input path="sbmc" readOnly="true"  name="ykebyhk_name" id="tjyfdwy_sbmc" htmlEscape="false"  value="听觉诱发电位仪"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp" name="ykebyhk_name" id="tjyfdwy_pp" value="${data.tjyfdwy.tjyfdwy_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh" name="ykebyhk_name" id="tjyfdwy_xh" value="${data.tjyfdwy.tjyfdwy_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sl" name="ykebyhk_name" id="tjyfdwy_sl" value="${data.tjyfdwy.tjyfdwy_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sbjg" name="ykebyhk_name" id="tjyfdwy_sbjg" value="${data.tjyfdwy.tjyfdwy_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="trsynf" name="ykebyhk_name" id="tjyfdwy_trsynf" value="${data.tjyfdwy.tjyfdwy_trsynf }" htmlEscape="false"    class="form-control "/>
					<input type = "hidden" htmlEscape="false" id="tjyfdwy_id"  name="ykebyhk_name" value="${data.tjyfdwy.tjyfdwy_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
				
					<td class="width-15">
						<input path="sbmc" readOnly="true"  name="ykebyhk_name" id="ebhzhzlt_sbmc" htmlEscape="false"  value="耳鼻喉综合治疗台"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp" name="ykebyhk_name" id="ebhzhzlt_pp" value="${data.ebhzhzlt.ebhzhzlt_pp }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh" name="ykebyhk_name" id="ebhzhzlt_xh"  value="${data.ebhzhzlt.ebhzhzlt_xh }"   htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sl" name="ykebyhk_name" id="ebhzhzlt_sl"  value="${data.ebhzhzlt.ebhzhzlt_sl }"   htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sbjg" name="ykebyhk_name" id="ebhzhzlt_sbjg"  value="${data.ebhzhzlt.ebhzhzlt_sbjg }"   htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="trsynf" name="ykebyhk_name" id="ebhzhzlt_trsynf"  value="${data.ebhzhzlt.ebhzhzlt_trsynf }"   htmlEscape="false"    class="form-control "/>
					<input type = "hidden" htmlEscape="false" id="ebhzhzlt_id"  name="ykebyhk_name" value="${data.ebhzhzlt.ebhzhzlt_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
				
					<td class="width-15">
						<input path="sbmc" readOnly="true"  name="ykebyhk_name" id="szkzefxy_sbmc" htmlEscape="false"  value="声阻抗中耳分析仪"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp" name="ykebyhk_name" id="szkzefxy_pp" value="${data.szkzefxy.szkzefxy_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh" name="ykebyhk_name"  id="szkzefxy_xh" value="${data.szkzefxy.szkzefxy_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sl" name="ykebyhk_name" id="szkzefxy_sl" value="${data.szkzefxy.szkzefxy_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sbjg" name="ykebyhk_name" id="szkzefxy_sbjg" value="${data.szkzefxy.szkzefxy_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="trsynf" name="ykebyhk_name" id="szkzefxy_trsynf" value="${data.szkzefxy.szkzefxy_trsynf }" htmlEscape="false"    class="form-control "/>
					<input type = "hidden" htmlEscape="false" id="szkzefxy_id"  name="ykebyhk_name" value="${data.szkzefxy.szkzefxy_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
				
					<td class="width-15">
						<input path="sbmc" readOnly="true"   name="ykebyhk_name" id="dcty_sbmc" htmlEscape="false"  value="电测听仪"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp" name="ykebyhk_name"  id="dcty_pp" value="${data.dcty.dcty_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh" name="ykebyhk_name"  id="dcty_xh" value="${data.dcty.dcty_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sl" name="ykebyhk_name"  id="dcty_sl" value="${data.dcty.dcty_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sbjg" name="ykebyhk_name"  id="dcty_sbjg" value="${data.dcty.dcty_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="trsynf" name="ykebyhk_name"  id="dcty_trsynf" value="${data.dcty.dcty_trsynf }"  htmlEscape="false"    class="form-control "/>
					<input type = "hidden" htmlEscape="false" id="dcty_id"  name="ykebyhk_name" value="${data.dcty.dcty_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
				
					<td class="width-15">
						<input path="sbmc" readOnly="true"  name="ykebyhk_name" id="kshj_sbmc" htmlEscape="false"  value="可视喉镜"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp" name="ykebyhk_name" id="kshj_pp"  value="${data.kshj.kshj_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh" name="ykebyhk_name" id="kshj_xh"  value="${data.kshj.kshj_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sl" name="ykebyhk_name" id="kshj_sl"  value="${data.kshj.kshj_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sbjg" name="ykebyhk_name" id="kshj_sbjg"  value="${data.kshj.kshj_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="trsynf" name="ykebyhk_name" id="kshj_trsynf"  value="${data.kshj.kshj_trsynf }"  htmlEscape="false"    class="form-control "/>
					   <input type = "hidden" htmlEscape="false" id="kshj_id"  name="ykebyhk_name" value="${data.kshj.kshj_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
				
					<td class="width-15">
						<input path="sbmc" readOnly="true"  name="ykebyhk_name" id="qtqzm_sbmc" htmlEscape="false"  value="其它（请注明）"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="pp" name="ykebyhk_name"  id="qtqzm_pp" value="${data.qtqzm.qtqzm_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xh" name="ykebyhk_name"  id="qtqzm_xh" value="${data.qtqzm.qtqzm_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="sl" name="ykebyhk_name"  id="qtqzm_sl" value="${data.qtqzm.qtqzm_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="sbjg" name="ykebyhk_name"  id="qtqzm_sbjg" value="${data.qtqzm.qtqzm_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="trsynf" name="ykebyhk_name"  id="qtqzm_trsynf" value="${data.qtqzm.qtqzm_trsynf }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="qtqzm_id"  name="ykebyhk_name" value="${data.qtqzm.qtqzm_id}"  class="form-control "/>
					
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
		
		var data = document.getElementsByName("ykebyhk_name");
	
		var datas="";
		
		
		for(i=0;i<data.length;i++){
			if(data[i].value==null||data[i].value==""){
				datas = datas +data[i].id+": ---- ;";	
			}else{
				datas = datas +data[i].id+":"+data[i].value+";";	
			}
			
			
		}
	 	
		 $.ajax({
		      url:"${ctx}/ironfoyjbylsbpzykebyhk/ironfoyjbylsbpzykebyhk/save",
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