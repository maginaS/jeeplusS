<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>消毒供应室管理</title>
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
	</script>
</head>
<body class="hideScroll">
		<form id="inputForm" modelAttribute="ironfoyjbylsbpzxdgys" action="${ctx}/ironfoyjbylsbpzxdgys/ironfoyjbylsbpzxdgys/save" method="post" class="form-horizontal">
	<%-- 	<form:hidden path="id"/>
		<sys:message content="${message}"/>	 --%>
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<%-- <tr>
					<td class="width-15 active"><label class="pull-right">备注信息：</label></td>
					<td class="width-35">
						<form:textarea path="remarks" htmlEscape="false" rows="4"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">主表id：</label></td>
					<td class="width-35">
						<form:input path="doc_id" htmlEscape="false"    class="form-control "/>
					</td>
				</tr> --%>
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
						<input path="xdgys_sbmc" htmlEscape="false" id="hyywmjq_sbmc" readOnly="true" name="xdgys_name" value="环氧乙烷灭菌器"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="xdgys_pp" htmlEscape="false"  id="hyywmjq_pp" value="${data.hyywmjq.hyywmjq_pp}"   name="xdgys_name"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xdgys_xh" htmlEscape="false"  id="hyywmjq_xh" value="${data.hyywmjq.hyywmjq_xh}"   name="xdgys_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xdgys_sl" htmlEscape="false"  id="hyywmjq_sl" value="${data.hyywmjq.hyywmjq_sl}"   name="xdgys_name"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="xdgys_sbjg" htmlEscape="false"   id="hyywmjq_sbjg" value="${data.hyywmjq.hyywmjq_sbjg}"   name="xdgys_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xdgys_trsynf" htmlEscape="false"   id="hyywmjq_trsynf" value="${data.hyywmjq.hyywmjq_trsynf}"  name="xdgys_name"  class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="hyywmjq_id"  name="xdgys_name" value="${data.hyywmjq.hyywmjq_id}"  class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="docId"   name="xdgys_name" value="${data.doc_id}"  class="form-control "/>
					
					</td>
				</tr>
				<tr>
					<td class="width-15">
						<input path="xdgys_sbmc" htmlEscape="false" id="dwdlzmjq_sbmc" readOnly="true"  name="xdgys_name" value="低温等离子灭菌器"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="xdgys_pp" htmlEscape="false"   id="dwdlzmjq_pp" value="${data.dwdlzmjq.dwdlzmjq_pp }"   name="xdgys_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xdgys_xh" htmlEscape="false"   id="dwdlzmjq_xh"  value="${data.dwdlzmjq.dwdlzmjq_xh }"   name="xdgys_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xdgys_sl" htmlEscape="false"   id="dwdlzmjq_sl"  value="${data.dwdlzmjq.dwdlzmjq_sl }"   name="xdgys_name"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="xdgys_sbjg" htmlEscape="false"   id="dwdlzmjq_sbjg"   value="${data.dwdlzmjq.dwdlzmjq_sbjg }"  name="xdgys_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xdgys_trsynf" htmlEscape="false"  id="dwdlzmjq_trsynf"  value="${data.dwdlzmjq.dwdlzmjq_trsynf }"   name="xdgys_name"   class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="dwdlzmjq_id"  name="xdgys_name" value="${data.dwdlzmjq.dwdlzmjq_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="xdgys_sbmc" htmlEscape="false" id="ylzqmjq_sbmc" readOnly="true" name="xdgys_name" value="压力蒸汽灭菌器"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="xdgys_pp" htmlEscape="false"  id="ylzqmjq_pp"  value="${data.ylzqmjq.ylzqmjq_pp }"  name="xdgys_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xdgys_xh" htmlEscape="false"  id="ylzqmjq_xh" value="${data.ylzqmjq.ylzqmjq_xh }"    name="xdgys_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xdgys_sl" htmlEscape="false"    id="ylzqmjq_sl"  value="${data.ylzqmjq.ylzqmjq_sl }"   name="xdgys_name"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="xdgys_sbjg" htmlEscape="false"  id="ylzqmjq_sbjg" value="${data.ylzqmjq.ylzqmjq_sbjg }"   name="xdgys_name"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xdgys_trsynf" htmlEscape="false"   id="ylzqmjq_trsynf" value="${data.ylzqmjq.ylzqmjq_trsynf }"  name="xdgys_name"   class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="ylzqmjq_id"  name="xdgys_name" value="${data.ylzqmjq.ylzqmjq_id}"  class="form-control "/>
				
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="xdgys_sbmc" htmlEscape="false" id="qzdqxxdj_sbmc" readOnly="true"  name="xdgys_name" value="全自动清洗消毒机"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="xdgys_pp" htmlEscape="false" id="qzdqxxdj_pp" value="${data.qzdqxxdj.qzdqxxdj_pp }"  name="xdgys_name"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xdgys_xh" htmlEscape="false" id="qzdqxxdj_xh" value="${data.qzdqxxdj.qzdqxxdj_xh }"  name="xdgys_name"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xdgys_sl" htmlEscape="false"  id="qzdqxxdj_sl" value="${data.qzdqxxdj.qzdqxxdj_sl }"  name="xdgys_name"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="xdgys_sbjg" htmlEscape="false" id="qzdqxxdj_sbjg" value="${data.qzdqxxdj.qzdqxxdj_sbjg }"  name="xdgys_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xdgys_trsynf" htmlEscape="false"  id="qzdqxxdj_trsynf" value="${data.qzdqxxdj.qzdqxxdj_trsynf }" name="xdgys_name"   class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="qzdqxxdj_id"  name="xdgys_name" value="${data.qzdqxxdj.qzdqxxdj_id}"  class="form-control "/>
					
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="xdgys_sbmc" htmlEscape="false" id="csqxj_sbmc"  readOnly="true"  name="xdgys_name" value="超声清洗机"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="xdgys_pp" htmlEscape="false"   id="csqxj_pp" value="${data.csqxj.csqxj_pp }"  name="xdgys_name"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xdgys_xh" htmlEscape="false"   id="csqxj_xh" value="${data.csqxj.csqxj_xh }"   name="xdgys_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xdgys_sl" htmlEscape="false"   id="csqxj_sl" value="${data.csqxj.csqxj_sl }"   name="xdgys_name"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="xdgys_sbjg" htmlEscape="false"   id="csqxj_sbjg" value="${data.csqxj.csqxj_sbjg }"   name="xdgys_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xdgys_trsynf" htmlEscape="false"  id="csqxj_trsynf"  value="${data.csqxj.csqxj_trsynf }"  name="xdgys_name"   class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="csqxj_id"  name="xdgys_name" value="${data.csqxj.csqxj_id}"  class="form-control "/>
					
					
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="xdgys_sbmc" htmlEscape="false" id="sclzz_sbmc" readOnly="true"  name="xdgys_name"  value="水处理装置"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="xdgys_pp" htmlEscape="false"  id="sclzz_pp" value="${data.sclzz.sclzz_pp }" name="xdgys_name"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xdgys_xh" htmlEscape="false"  id="sclzz_xh" value="${data.sclzz.sclzz_xh }"  name="xdgys_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xdgys_sl" htmlEscape="false"  id="sclzz_sl" value="${data.sclzz.sclzz_sl }"   name="xdgys_name" class="form-control "/>
					</td>
					<td class="width-15">
						<input path="xdgys_sbjg" htmlEscape="false" id="sclzz_sbjg" value="${data.sclzz.sclzz_sbjg }"   name="xdgys_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xdgys_trsynf" htmlEscape="false"  id="sclzz_trsynf" value="${data.sclzz.sclzz_trsynf }"  name="xdgys_name"  class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="sclzz_id"  name="xdgys_name" value="${data.sclzz.sclzz_id}"  class="form-control "/>
				
				
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="xdgys_sbmc" htmlEscape="false" id="fkj_sbmc" readOnly="true"   name="xdgys_name" value="封口机"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="xdgys_pp" htmlEscape="false"  id="fkj_pp"  value="${data.fkj.fkj_pp }"   name="xdgys_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xdgys_xh" htmlEscape="false"  id="fkj_xh"   value="${data.fkj.fkj_xh }"   name="xdgys_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xdgys_sl" htmlEscape="false"  id="fkj_sl"   value="${data.fkj.fkj_sl }"   name="xdgys_name"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="xdgys_sbjg" htmlEscape="false" id="fkj_sbjg"   value="${data.fkj.fkj_sbjg }"   name="xdgys_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xdgys_trsynf" htmlEscape="false" id="fkj_trsynf"   value="${data.fkj.fkj_trsynf }"   name="xdgys_name"  class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="fkj_id"  name="xdgys_name" value="${data.fkj.fkj_id}"  class="form-control "/>
				
				
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="xdgys_sbmc" htmlEscape="false" id="ksydq_sbmc" readOnly="true"  name="xdgys_name"  value="快速阅读器"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="xdgys_pp" htmlEscape="false" id="ksydq_pp" value="${data.ksydq.ksydq_pp }"    name="xdgys_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xdgys_xh" htmlEscape="false" id="ksydq_xh" value="${data.ksydq.ksydq_xh }"   name="xdgys_name"   class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xdgys_sl" htmlEscape="false" id="ksydq_sl"   value="${data.ksydq.ksydq_sl }"   name="xdgys_name"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="xdgys_sbjg" htmlEscape="false"  id="ksydq_sbjg"  value="${data.ksydq.ksydq_sbjg }"   name="xdgys_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xdgys_trsynf" htmlEscape="false" id="ksydq_trsynf" value="${data.ksydq.ksydq_trsynf }"   name="xdgys_name"   class="form-control "/>
					   <input type = "hidden" htmlEscape="false" id="ksydq_id"  name="xdgys_name" value="${data.ksydq.ksydq_id}"  class="form-control "/>
					
					
					</td>
					
					
				</tr>
				<tr>
					<td class="width-15">
						<input path="xdgys_sbmc" htmlEscape="false" id="qtqzm_sbmc" readOnly="true"  name="xdgys_name"  value="其它（请注明）"   class="form-control "/>
					</td>
					<td class="width-15">
						<input path="xdgys_pp" htmlEscape="false" id="qtqzm_pp" value="${data.qtqzm.qtqzm_pp }"   name="xdgys_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xdgys_xh" htmlEscape="false" id="qtqzm_xh"  value="${data.qtqzm.qtqzm_xh }"   name="xdgys_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xdgys_sl" htmlEscape="false" id="qtqzm_sl"  value="${data.qtqzm.qtqzm_sl }"   name="xdgys_name"  class="form-control "/>
					</td>
					<td class="width-15">
						<input path="xdgys_sbjg" htmlEscape="false" id="qtqzm_sbjg"  value="${data.qtqzm.qtqzm_sbjg }"   name="xdgys_name"  class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="xdgys_trsynf" htmlEscape="false" id="qtqzm_trsynf" value="${data.qtqzm.qtqzm_trsynf }"    name="xdgys_name"  class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="qtqzm_id"  name="xdgys_name" value="${data.qtqzm.qtqzm_id}"  class="form-control "/>
					
					
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
		
		var data = document.getElementsByName("xdgys_name");
	
		var datas="";
		
		
		for(i=0;i<data.length;i++){
			if(data[i].value==null||data[i].value==""){
				datas = datas +data[i].id+": ---- ;";	
			}else{
				datas = datas +data[i].id+":"+data[i].value+";";	
			}
			
			
		}
	 	
		 $.ajax({
		      url:"${ctx}/ironfoyjbylsbpzxdgys/ironfoyjbylsbpzxdgys/save",
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