<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>感染性疾病科管理</title>
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
		<form id="inputForm" modelAttribute="ironfoyjbylsbpzgrxjbk" action="${ctx}/ironfoyjbylsbpzgrxjbk/ironfoyjbylsbpzgrxjbk/save" method="post" class="form-horizontal">
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
						<input path="grxjbk_sbmc" name="grxjbk_name" readOnly="true"  id="yzjcnkj_sbmc" htmlEscape="false" value="乙状结肠内窥镜"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="grxjbk_pp" name="grxjbk_name" id="yzjcnkj_pp" value="${data.yzjcnkj.yzjcnkj_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="grxjbk_xh" name="grxjbk_name" id="yzjcnkj_xh" value="${data.yzjcnkj.yzjcnkj_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="grxjbk_sl" name="grxjbk_name" id="yzjcnkj_sl" value="${data.yzjcnkj.yzjcnkj_sl }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="grxjbk_sbjg" name="grxjbk_name" id="yzjcnkj_sbjg" value="${data.yzjcnkj.yzjcnkj_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="grxjbk_trsynf" name="grxjbk_name" id="yzjcnkj_trsynf" value="${data.yzjcnkj.yzjcnkj_trsynf }"  htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="yzjcnkj_id"  name="grxjbk_name" value="${data.yzjcnkj.yzjcnkj_id}"  class="form-control "/>
					    <input type = "hidden" htmlEscape="false" id="docId"   name="grxjbk_name" value="${data.doc_id}"  class="form-control "/>
					
					</td>
				</tr>
				<tr>
					
					<td class="width-15">
						<input path="grxjbk_sbmc" name="grxjbk_name" readOnly="true"  id="cdslj_sbmc" htmlEscape="false" value="肠道水疗机"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="grxjbk_pp" name="grxjbk_name"  id="cdslj_pp" value="${data.cdslj.cdslj_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="grxjbk_xh" name="grxjbk_name"  id="cdslj_xh"   value="${data.cdslj.cdslj_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="grxjbk_sl" name="grxjbk_name"  id="cdslj_sl"  value="${data.cdslj.cdslj_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="grxjbk_sbjg" name="grxjbk_name"  id="cdslj_sbjg"  value="${data.cdslj.cdslj_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="grxjbk_trsynf" name="grxjbk_name"  id="cdslj_trsynf"  value="${data.cdslj.cdslj_trsynf }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="cdslj_id"  name="grxjbk_name" value="${data.cdslj.cdslj_id}"  class="form-control "/>
					</td>
					
				</tr>
				<tr>
					
					<td class="width-15">
						<input path="grxjbk_sbmc" name="grxjbk_name" readOnly="true"  id="gbzly_sbmc" htmlEscape="false" value="肝病治疗仪"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="grxjbk_pp" name="grxjbk_name" id="gbzly_pp" value="${data.gbzly.gbzly_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="grxjbk_xh" name="grxjbk_name" id="gbzly_xh" value="${data.gbzly.gbzly_xh }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="grxjbk_sl" name="grxjbk_name" id="gbzly_sl" value="${data.gbzly.gbzly_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="grxjbk_sbjg" name="grxjbk_name" id="gbzly_sbjg" value="${data.gbzly.gbzly_sbjg }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="grxjbk_trsynf" name="grxjbk_name" id="gbzly_trsynf" value="${data.gbzly.gbzly_trsynf }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="gbzly_id"  name="grxjbk_name" value="${data.gbzly.gbzly_id}"  class="form-control "/>
				
					</td>
					
				</tr>
				<tr>
					
					<td class="width-15">
						<input path="grxjbk_sbmc" name="grxjbk_name" readOnly="true"  id="qtqzm_sbmc" htmlEscape="false" value="其它（请注明）"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="grxjbk_pp" name="grxjbk_name" id="qtqzm_pp"  value="${data.qtqzm.qtqzm_pp }" htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="grxjbk_xh" name="grxjbk_name" id="qtqzm_xh" value="${data.qtqzm.qtqzm_xh }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="grxjbk_sl" name="grxjbk_name" id="qtqzm_sl"  value="${data.qtqzm.qtqzm_sl }" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15">
						<input path="grxjbk_sbjg" name="grxjbk_name" id="qtqzm_sbjg" value="${data.qtqzm.qtqzm_sbjg }"  htmlEscape="false"    class="form-control "/>
					</td>
					
					<td class="width-15">
						<input path="grxjbk_trsynf" name="grxjbk_name" id="qtqzm_trsynf"  value="${data.qtqzm.qtqzm_trsynf }" htmlEscape="false"    class="form-control "/>
						<input type = "hidden" htmlEscape="false" id="qtqzm_id"  name="grxjbk_name" value="${data.qtqzm.qtqzm_id}"  class="form-control "/>
					
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
		
		var data = document.getElementsByName("grxjbk_name");
	
		var datas="";
		
		
		for(i=0;i<data.length;i++){
			if(data[i].value==null||data[i].value==""){
				datas = datas +data[i].id+": ---- ;";	
			}else{
				datas = datas +data[i].id+":"+data[i].value+";";	
			}
			
			
		}
	 	
		 $.ajax({
		      url:"${ctx}/ironfoyjbylsbpzgrxjbk/ironfoyjbylsbpzgrxjbk/save",
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