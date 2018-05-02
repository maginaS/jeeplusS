<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>5.2门急诊用房管理</title>
	<meta name="decorator" content="default"/>
</head>
<body class="hideScroll">
	<form id="inputForm" modelAttribute="ironfofivemjzyf" action="${ctx}/ironfofivemjzyf/ironfofivemjzyf/save" method="post" class="form-horizontal">
		<%-- <form:hidden path="id"/>
		<sys:message content="${message}"/>	 --%>
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
				
				
					注：<br/>
					功能单元建筑面积：该功能单元所有房间和场所的建筑面积之和。<br/>
					空间类型：乡镇卫生院设置有该类场所就算作有此种类型的空间，不需要名称一致。<br/>
					
				</tr> 
				<tr>
					<td class="width-15 active"><label class="pull-right">功能单元建筑面积（m2）</label></td>
					<td class="width-35">
						<input path="gndyjzmj" name="gndyjzmj_name_gndyjzmj"  id="gndyjzmj" value="${data.gndyjzmj }" htmlEscape="false"    class="form-control "/>
						<input   type="hidden" name="gndyjzmj_name_gndyjzmj"  id="docId"  value="${data.doc_id}" htmlEscape="false"    class="form-control "/>
						<input   type="hidden" name="gndyjzmj_name_gndyjzmj"  id="mjzyfid" value="${data.mjzyfid }"  htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 "></td>
		   			<td class="width-35" ></td>
		  		</tr>
		 	</tbody>
		</table>
		
		<div class="tabs-container">
            <ul class="nav nav-tabs">
				<li class="active"><a data-toggle="tab" href="#tab-1" aria-expanded="true">门急诊用房空间类型</a>
                </li>
            </ul>
            <div class="tab-content">
				<div id="tab-1" class="tab-pane active">
 				<table id="contentTable" class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td>
							<c:if test="${data.ghsfs=='1' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="ghsfs" id="ghsfs" style="margin-top: -2px;" checked="checked"/>&nbsp;挂号收费室
							</c:if>
							<c:if test="${data.ghsfs=='0' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="ghsfs" id="ghsfs" style="margin-top: -2px;" />&nbsp;挂号收费室
							</c:if>
						</td>
						<td>
							<c:if test="${data.fwzx=='1' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="fwzx" id="fwzx" style="margin-top: -2px;" checked="checked"/>&nbsp;服务中心
							</c:if>
							<c:if test="${data.fwzx=='0' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="fwzx" id="fwzx" style="margin-top: -2px;"/>&nbsp;服务中心
							</c:if>
						</td>
						<td>
							<c:if test="${data.fzt=='1' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="fzt" id="fzt" style="margin-top: -2px;" checked="checked"/>&nbsp;分诊台
							</c:if>
							<c:if test="${data.fzt=='0' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="fzt"  id="fzt" style="margin-top: -2px;"/>&nbsp;分诊台
							</c:if>
						
						</td>
						<td>
							<c:if test="${data.hzq=='1' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="hzq" id="hzq" style="margin-top: -2px;" checked="checked"/>&nbsp;候诊区
							</c:if>
							<c:if test="${data.hzq=='0' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="hzq"  id="hzq" style="margin-top: -2px;"/>&nbsp;候诊区
							</c:if>
						</td>
						<td>
							<c:if test="${data.qkylkzs=='1' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="qkylkzs" id="qkylkzs" style="margin-top: -2px;" checked="checked"/>&nbsp;全科医疗科诊室
							</c:if>
							<c:if test="${data.qkylkzs=='0' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="qkylkzs" id="qkylkzs" style="margin-top: -2px;"/>&nbsp;全科医疗科诊室
							</c:if>
						</td>
						<td>
							<c:if test="${data.ptnkzsnkyf=='1' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="ptnkzsnkyf" id="ptnkzsnkyf" style="margin-top: -2px;" checked="checked"/>&nbsp;普通内科诊室-内科用房
							</c:if>
							<c:if test="${data.ptnkzsnkyf=='0' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="ptnkzsnkyf" id="ptnkzsnkyf" style="margin-top: -2px;"/>&nbsp;普通内科诊室-内科用房
							</c:if>
						</td>
						<td>
						
							<c:if test="${data.cdjfrmzsnkyf=='1' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="cdjfrmzsnkyf" id="cdjfrmzsnkyf" style="margin-top: -2px;" checked="checked"/>&nbsp;肠道及发热门诊室-内科用房
							</c:if>
							<c:if test="${data.cdjfrmzsnkyf=='0' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="cdjfrmzsnkyf" id="cdjfrmzsnkyf" style="margin-top: -2px;"/>&nbsp;肠道及发热门诊室-内科用房
							</c:if>
						</td>
						
					</tr>
					
					
					<tr>
						<td>
						
							<c:if test="${data.ptwkzswkyf=='1' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="ptwkzswkyf" id="ptwkzswkyf" style="margin-top: -2px;" checked="checked"/>&nbsp;普通外科诊室-外科用房
							</c:if>
							<c:if test="${data.ptwkzswkyf=='0' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="ptwkzswkyf" id="ptwkzswkyf"  style="margin-top: -2px;"/>&nbsp;普通外科诊室-外科用房
							</c:if>
						</td>
						<td>
							<c:if test="${data.gkzswkyf=='1' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="gkzswkyf" id="gkzswkyf" style="margin-top: -2px;" checked="checked"/>&nbsp;骨科诊室-外科用房
							</c:if>
							<c:if test="${data.gkzswkyf=='0' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="gkzswkyf"  id="gkzswkyf"  style="margin-top: -2px;"/>&nbsp;骨科诊室-外科用房
							</c:if>
						</td>
						<td>
							<c:if test="${data.fckzsfckyf=='1' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="fckzsfckyf" id="fckzsfckyf" style="margin-top: -2px;" checked="checked"/>&nbsp;妇产科诊室-妇产科用房
							</c:if>
							<c:if test="${data.fckzsfckyf=='0' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="fckzsfckyf"  id="fckzsfckyf"  style="margin-top: -2px;"/>&nbsp;妇产科诊室-妇产科用房
							</c:if>
						</td>
						<td>
						
							<c:if test="${data.jcsfckyf=='1' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="jcsfckyf" id="jcsfckyf" style="margin-top: -2px;" checked="checked"/>&nbsp;检查室-妇产科用房
							</c:if>
							<c:if test="${data.jcsfckyf=='0' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="jcsfckyf"  id="jcsfckyf"  style="margin-top: -2px;"/>&nbsp;检查室-妇产科用房
							</c:if>
						</td>
						<td>
							<c:if test="${data.ekzs=='1' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="ekzs" id="ekzs" style="margin-top: -2px;" checked="checked"/>&nbsp;儿科诊室
							</c:if>
							<c:if test="${data.ekzs=='0' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="ekzs"  id="ekzs"  style="margin-top: -2px;"/>&nbsp;儿科诊室
							</c:if>
						</td>
						<td>
						
							<c:if test="${data.zykzszykyf=='1' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="zykzszykyf" id="zykzszykyf" style="margin-top: -2px;" checked="checked"/>&nbsp;中医科诊室-中医科用房
							</c:if>
							<c:if test="${data.zykzszykyf=='0' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="zykzszykyf"  id="zykzszykyf"  style="margin-top: -2px;"/>&nbsp;中医科诊室-中医科用房
							</c:if>
						</td>
						<td>
						
							<c:if test="${data.zyzlszykyf=='1' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="zyzlszykyf" id="zyzlszykyf" style="margin-top: -2px;" checked="checked"/>&nbsp;中医治疗室-中医科用房
							</c:if>
							<c:if test="${data.zyzlszykyf=='0' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="zyzlszykyf"  id="zyzlszykyf"  style="margin-top: -2px;"/>&nbsp;中医治疗室-中医科用房
							</c:if>
						</td>
					</tr>
					
					
					<tr>
						
						<td>
							<c:if test="${data.kqkzskqkyf=='1' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="kqkzskqkyf" id="kqkzskqkyf" style="margin-top: -2px;" checked="checked"/>&nbsp;口腔科诊室-口腔科用房
							</c:if>
							<c:if test="${data.kqkzskqkyf=='0' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="kqkzskqkyf" id="kqkzskqkyf"  style="margin-top: -2px;"/>&nbsp;口腔科诊室-口腔科用房
							</c:if>
						</td>
						<td>
							<c:if test="${data.kqzlskqkyf=='1' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="kqzlskqkyf" id="kqzlskqkyf" style="margin-top: -2px;" checked="checked"/>&nbsp;口腔治疗室-口腔科用房
							</c:if>
							<c:if test="${data.kqzlskqkyf=='0' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="kqzlskqkyf" id="kqzlskqkyf"  style="margin-top: -2px;"/>&nbsp;口腔治疗室-口腔科用房
							</c:if>
						
						</td>
						<td>
							<c:if test="${data.jgskqkyf=='1' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="jgskqkyf" id="jgskqkyf" style="margin-top: -2px;" checked="checked"/>&nbsp;技工室-口腔科用房
							</c:if>
							<c:if test="${data.jgskqkyf=='0' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="jgskqkyf" id="jgskqkyf"  style="margin-top: -2px;"/>&nbsp;技工室-口腔科用房
							</c:if>
						</td>
						<td>
							<c:if test="${data.ykzs=='1' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="ykzs" id="ykzs" style="margin-top: -2px;" checked="checked"/>&nbsp;眼科诊室
							</c:if>
							<c:if test="${data.ykzs=='0' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="ykzs"  id="ykzs"  style="margin-top: -2px;"/>&nbsp;眼科诊室
							</c:if>
						</td>
						<td>
							<c:if test="${data.ebhkzs=='1' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="ebhkzs" id="ebhkzs" style="margin-top: -2px;" checked="checked"/>&nbsp;耳鼻喉科诊室
							</c:if>
							<c:if test="${data.ebhkzs=='0' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="ebhkzs"  id="ebhkzs"  style="margin-top: -2px;"/>&nbsp;耳鼻喉科诊室
							</c:if>
						</td>
						<td>
							<c:if test="${data.pfkzs=='1' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="pfkzs" id="pfkzs" style="margin-top: -2px;" checked="checked"/>&nbsp;皮肤科诊室
							</c:if>
							<c:if test="${data.pfkzs=='0' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="pfkzs"  id="pfkzs"  style="margin-top: -2px;"/>&nbsp;皮肤科诊室
							</c:if>
						</td>
						<td>
							<c:if test="${data.grxjbkzsgrxjbkyf=='1' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="grxjbkzsgrxjbkyf" id="grxjbkzsgrxjbkyf" style="margin-top: -2px;" checked="checked"/>&nbsp;感染性疾病科诊室-感染性疾病科用房
							</c:if>
							<c:if test="${data.grxjbkzsgrxjbkyf=='0' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="grxjbkzsgrxjbkyf"  id="grxjbkzsgrxjbkyf"  style="margin-top: -2px;"/>&nbsp;感染性疾病科诊室-感染性疾病科用房
							</c:if>
						</td>
						
					</tr>
					
					<tr>
						
						<td>
						
							<c:if test="${data.glsgrxjbkyf=='1' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="glsgrxjbkyf" id="glsgrxjbkyf" style="margin-top: -2px;" checked="checked"/>&nbsp;隔离室-感染性疾病科用房
							</c:if>
							<c:if test="${data.glsgrxjbkyf=='0' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="glsgrxjbkyf"  id="glsgrxjbkyf" style="margin-top: -2px;"/>&nbsp;隔离室-感染性疾病科用房
							</c:if>
						</td>
						<td>
							<c:if test="${data.kfkzskfkyf=='1' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="kfkzskfkyf" id="kfkzskfkyf" style="margin-top: -2px;" checked="checked"/>&nbsp;康复科诊室-康复科用房
							</c:if>
							<c:if test="${data.kfkzskfkyf=='0' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="kfkzskfkyf"   id="kfkzskfkyf" style="margin-top: -2px;"/>&nbsp;康复科诊室-康复科用房
							</c:if>
						</td>
						<td>
							<c:if test="${data.xyllskfkyf=='1' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="xyllskfkyf" id="xyllskfkyf" style="margin-top: -2px;" checked="checked"/>&nbsp;西医理疗室-康复科用房
							</c:if>
							<c:if test="${data.xyllskfkyf=='0' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="xyllskfkyf"   id="xyllskfkyf" style="margin-top: -2px;"/>&nbsp;西医理疗室-康复科用房
							</c:if>
						</td>
						<td>
						
							<c:if test="${data.ydzlskfkyf=='1' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="ydzlskfkyf" id="ydzlskfkyf" style="margin-top: -2px;" checked="checked"/>&nbsp;运动治疗室-康复科用房
							</c:if>
							<c:if test="${data.ydzlskfkyf=='0' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="ydzlskfkyf"  id="ydzlskfkyf" style="margin-top: -2px;"/>&nbsp;运动治疗室-康复科用房
							</c:if>
						</td>
						<td>
							<c:if test="${data.yyzlskfkyf=='1' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="yyzlskfkyf" id="yyzlskfkyf" style="margin-top: -2px;" checked="checked"/>&nbsp;言语治疗室-康复科用房
							</c:if>
							<c:if test="${data.yyzlskfkyf=='0' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="yyzlskfkyf"   id="yyzlskfkyf" style="margin-top: -2px;"/>&nbsp;言语治疗室-康复科用房
							</c:if>
						</td>
						<td>
							<c:if test="${data.hszsyyf=='1' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="hszsyyf" id="hszsyyf" style="margin-top: -2px;" checked="checked"/>&nbsp;护士站-输液用房
							</c:if>
							<c:if test="${data.hszsyyf=='0' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="hszsyyf"   id="hszsyyf" style="margin-top: -2px;"/>&nbsp;护士站-输液用房
							</c:if>
						</td>
						<td>
							<c:if test="${data.zlzbssyyf=='1' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="zlzbssyyf" id="zlzbssyyf" style="margin-top: -2px;" checked="checked"/>&nbsp;治疗准备室-输液用房
							</c:if>
							<c:if test="${data.zlzbssyyf=='0' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="zlzbssyyf"  id="zlzbssyyf" style="margin-top: -2px;"/>&nbsp;治疗准备室-输液用房
							</c:if>
						</td>
					</tr>
					<tr>
						
						
						<td>
							<c:if test="${data.zsssyyf=='1' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="zsssyyf" id="zsssyyf" style="margin-top: -2px;" checked="checked"/>&nbsp;注射室-输液用房
							</c:if>
							<c:if test="${data.zsssyyf=='0' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="zsssyyf"  id="zsssyyf" style="margin-top: -2px;"/> &nbsp;注射室-输液用房
							</c:if>
						</td>
						<td>
							<c:if test="${data.syssyyf=='1' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="syssyyf" id="syssyyf" style="margin-top: -2px;" checked="checked"/>&nbsp;输液室-输液用房
							</c:if>
							<c:if test="${data.syssyyf=='0' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="syssyyf"  id="syssyyf" style="margin-top: -2px;"/>&nbsp;输液室-输液用房
							</c:if>
						</td>
						<td>
						
							<c:if test="${data.zsgcssyyf=='1' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="zsgcssyyf" id="zsgcssyyf" style="margin-top: -2px;" checked="checked"/>&nbsp;注射观察室-输液用房
							</c:if>
							<c:if test="${data.zsgcssyyf=='0' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="zsgcssyyf"  id="zsgcssyyf" style="margin-top: -2px;"/>&nbsp;注射观察室-输液用房
							</c:if>
						</td>
						<td>
							<c:if test="${data.jzkzsjzkyf=='1' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="jzkzsjzkyf" id="jzkzsjzkyf" style="margin-top: -2px;" checked="checked"/>&nbsp;急诊科诊室-急诊科用房
							</c:if>
							<c:if test="${data.jzkzsjzkyf=='0' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="jzkzsjzkyf"  id="jzkzsjzkyf" style="margin-top: -2px;"/>&nbsp;急诊科诊室-急诊科用房
							</c:if>
						</td>
						<td>
							<c:if test="${data.qjsjzkyf=='1' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="qjsjzkyf" id="qjsjzkyf" style="margin-top: -2px;" checked="checked"/>&nbsp;抢救室-急诊科用房
							</c:if>
							<c:if test="${data.qjsjzkyf=='0' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="qjsjzkyf" id="qjsjzkyf" style="margin-top: -2px;"/>&nbsp;抢救室-急诊科用房
							</c:if>
						</td>
						<td>
							<c:if test="${data.lgsjzkyf=='1' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="lgsjzkyf" id="lgsjzkyf" style="margin-top: -2px;" checked="checked"/>&nbsp;留观室-急诊科用房
							</c:if>
							<c:if test="${data.lgsjzkyf=='0' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="lgsjzkyf"  id="lgsjzkyf" style="margin-top: -2px;"/>&nbsp;留观室-急诊科用房
							</c:if>
						</td>
						<td>
							<c:if test="${data.yszbsjzkyf=='1' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="yszbsjzkyf" id="yszbsjzkyf" style="margin-top: -2px;" checked="checked"/>&nbsp;医生值班室-急诊科用房
							</c:if>
							<c:if test="${data.yszbsjzkyf=='0'||data.yszbsjzkyf=='' }">
								<input type="checkbox" name="mjzyfkjlx_name" value="yszbsjzkyf"  id="yszbsjzkyf" style="margin-top: -2px;"/>&nbsp;医生值班室-急诊科用房
							</c:if>
						</td>
						
					</tr>
					<tr>
						<td>其它（请注明）</td><td><input name="mjzyfkjlx_name_qtqzm" id="mjzyfkjlx_name_qtqzm" value="${data.qtqzm }"  type="text" id="qtqzm"/></td>
						<input type = "hidden" htmlEscape="false" id="mjzyf_name_id"   name="mjzyf_name_id" value="${data.id}"  class="form-control "/>
					
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
		
		var data = document.getElementsByName("mjzyfkjlx_name");
	 	var remarks = document.getElementById("mjzyfkjlx_name_qtqzm").value;
		var id= document.getElementById("mjzyf_name_id").value; 
		var title = document.getElementsByName("gndyjzmj_name_gndyjzmj");
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
		      url:"${ctx}/ironfofivemjzyf/ironfofivemjzyf/save",
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