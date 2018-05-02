<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>首页</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
		     WinMove();
		});
	</script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content">
   <div class="row  border-bottom white-bg dashboard-header">
        <div class="col-sm-12">
            <blockquote class="text-info" style="font-size:14px">
            本系统主要实现最为普遍的问卷调查，包含问卷管理、设计统计分析等。
            为需求者提供网络问卷，让需求者能够快速、方便的实施专业的问卷调研，调查问卷设计，快速回收，
            跨地域低成本，投入少量的资金即可获得丰富的反馈信息......
    			
               
            </blockquote>

            <hr>
        </div>
    </div>
      
    <div class="wrapper wrapper-content">
        <div class="row">
            <div class="col-sm-4">

               <!--  <div class="ibox float-e-margins">
                     <div class="ibox-title">
                        <h5>适用范围</h5> 
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="dropdown-toggle" data-toggle="dropdown" href="index.html#">
                                <i class="fa fa-wrench"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="index.html#">选项1</a>
                                </li>
                                <li><a href="index.html#">选项2</a>
                                </li>
                            </ul>
                            <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">
              			      此文档适用于国家卫生计下属所有医院的管理人员、技术人员及所有医护人员使用。
                        
                    </div>
                </div> -->
              
            </div>
            <div class="col-sm-4">
                <div class="ibox float-e-margins">
                     <!-- <div class="ibox-title">
                        <h5>读者对象</h5> <span class="label label-primary">K+</span>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="dropdown-toggle" data-toggle="dropdown" href="index.html#">
                                <i class="fa fa-wrench"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="index.html#">选项1</a>
                                </li>
                                <li><a href="index.html#">选项2</a>
                                </li>
                            </ul>
                            <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>
                    </div> -->
                   <!--  <div class="ibox-content">
                        <div class="panel-body">
                            <div class="panel-group" id="version"> -->
                            
                            	<!-- <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h5 class="panel-title">
                                                <a data-toggle="collapse" data-parent="#version" href="#v2.6">v2.6</a><code class="pull-right">2017.2.18更新</code>
                                            </h5>
                                    </div>
                                    <div id="v2.6" class="panel-collapse collapse in">
                                        <div class="panel-body">
                                            <ol>
                                            	系统使用者、使用者管理人员
                                            </ol>
                                        </div>
                                    </div>
                                </div> -->
                            
                            	<!-- <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h5 class="panel-title">
                                                <a data-toggle="collapse" data-parent="#version" href="#v2.5">v2.5</a><code class="pull-right">2016.10.8更新</code>
                                            </h5>
                                    </div>
                                    <div id="v2.5" class="panel-collapse collapse in">
                                        <div class="panel-body">
                                            <ol>
                                            	<li>升级代码生成器，生成的代码增加表单校验功能。</li>
                                            	<li>修复代码生成器v2.3版本的bug，修复乱码功能。</li>
                                            	<li>优化代码生成器体验，增加错误校验等。</li>
                                                <li>去除dialog的竖向滚动条</li>
                                                <li>修复升级layer2.3的bug。</li>
                                            	<li>升级layim1.0到layim2.0。</li>
                                            	<li>支持自定义签名。</li>
                                                <li>支持表情，文件，群聊，群聊聊天记录。</li>
                                                <li>支持自定义聊天群组，添加移除群组人员。</li>
                                                <li>支持离线消息。</li>
                                                <li>....</li>
                                                <li>layim1.0是免费插件，layim2.0是商业授权，你仍可选择免费使用layim1.0，如果需要使用layim2.0，你需要购买一个授权，价格不贵，希望大家尊重知识版权，给开源作者一点点鼓励，才能持续给大家提供优秀的开源软件,<a href="http://layim.layui.com/?from=layer" target="_blank">layIM官网</a>。</li>
                                            </ol>
                                        </div>
                                    </div>
                                </div> -->
                            
                            	<!-- <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h5 class="panel-title">
                                                <a data-toggle="collapse" data-parent="#version" href="#v2.4">v2.4</a><code class="pull-right">2016.06.27更新</code>
                                            </h5>
                                    </div>
                                    <div id="v2.4" class="panel-collapse collapse in">
                                        <div class="panel-body">
                                            <ol>
                                            	<li>升级layer到2.4版本。</li>
                                                <li>解决layer弹出窗无法自适应手机的问题，jeeplus以完美支持移动端。</li>
                                                <li>修复layer弹窗弹出时窗口闪动的bug。</li>
                                                <li>修复分页bug。</li>
                                                <li>....</li>
                                                <li>封装echarts标签，提供快捷开发报表的功能。</li>
                                                <li>感谢大家的持续关注，如果你有更好的建议，请直接联系我。</li>
                                            </ol>
                                        </div>
                                    </div>
                                </div> -->
                            	<!-- <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h5 class="panel-title">
                                                <a data-toggle="collapse" data-parent="#version" href="#v2.3">v2.3</a><code class="pull-right">2016.05.17更新</code>
                                            </h5>
                                    </div>
                                    <div id="v2.3" class="panel-collapse collapse in">
                                        <div class="panel-body">
                                            <ol>
                                            	<li>修复初次登录，菜单加载慢的问题,加载速度从10秒优化到2秒。</li>
                                                <li>修复list导入Excel文档为空的bug。</li>
                                                <li>修复360浏览器（7.1版本）提交表单失败的bug。</li>
                                                <li>修复短信发送bug。</li>
                                                <li>修复发送站内信时，无法添加图片的bug。</li>
                                                <li>增加我的日程功能。</li>
                                                <li>修复代码生成器生成的树结构，删除子节点时，会误删除父节点的bug。</li>
                                                <li>删除百度统计的代码</li>
                                                <li>修复oracle数据库脚本</li>
                                                <li>优化登录页的显示风格</li>
                                                <li>增加我的日程功能</li>
                                                <li>增加代码生成器支持生成富文本编辑框的功能</li>
                                                <li>增加代码生成器支持自定义grid选择框的功能。</li>
                                                <li>....</li>
                                                <li>下一个版本，主要关注功能是报表和activity工作流，至于数据权限，我暂时还没想到好的解决方案。</li>
                                                <li>感谢大家的持续关注，如果你有更好的建议，请直接联系我。</li>
                                            </ol>
                                        </div>
                                    </div>
                                </div> -->
                            		<!-- <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h5 class="panel-title">
                                                <a data-toggle="collapse" data-parent="#version" href="#v2.2">v2.2Beta版</a><code class="pull-right">2016.03.13更新</code>
                                            </h5>
                                    </div>
                                    <div id="v2.2" class="panel-collapse collapse in">
                                        <div class="panel-body">
                                            <ol>
                                            	<li>这是目前为止最重要的一次升级。</li>
                                                <li>新增功能：cpu，内存，jvm性能检测预警工具，短信群发功能，邮件群发功能，ace主题切换功能，表单构建器功能等功能。</li>
                                                <li>修正了大量2.1beta版本的bug，以及页面性能优化，具体参照网站的更新报告</li>
                                                <li>升级代码生成器功能，移除（可插入，可编辑）2个配置项，新增(表单）配置项，使代码生成器更加简单易懂，提高了代码生成器的实用性。</li>
                                                <li>....</li>
                                                <li>富文本编辑器，自定义java对象功能，表格的行权限和列权限，上下菜单风格，echarts图表生成器等功能预计在2.3版本推出。</li>
                                                <li>感谢大家的持续关注，如果你有更好的建议，请直接联系我。</li>
                                            </ol>
                                        </div>
                                    </div>
                                </div> -->
                                
                            	<!-- <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h5 class="panel-title">
                                                <a data-toggle="collapse" data-parent="#version" href="#v2.0">v2.1Beta版</a><code class="pull-right">2016.02.25更新</code>
                                            </h5>
                                    </div>
                                    <div id="v2.0" class="panel-collapse collapse in">
                                        <div class="panel-body">
                                            <ol>
                                            	<li>这个版本是一个bug修复版本</li>
                                                <li>修正zTree显示bug</li>
                                                <li>移除google的cdn依赖，解决加载慢的问题</li>
                                                <li>修正代码生成器拖拽bug</li>
                                                <li>修正站内信bug</li>
                                                <li>....</li>
                                                <li>仪表盘，定时任务，自定义表单，邮箱短信等等新功能，因为多个环境对应以及代码校验完善的原因将在2.2推出，所有正式用户均可免费升级。</li>
                                            </ol>
                                        </div>
                                    </div>
                                </div> -->
                               <!--  <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h5 class="panel-title">
                                                <a data-toggle="collapse" data-parent="#version" href="#v2.0">v2.0</a><code class="pull-right">2016.01.15更新</code>
                                            </h5>
                                    </div>
                                    <div id="v2.0" class="panel-collapse collapse in">
                                        <div class="panel-body">
                                            <ol>
                                                <li>修复IE不兼容，首页出现滚动条</li>
                                                <li>修复validate插件bug</li>
                                                <li>提供基于WebSocket的即时聊天系统</li>
                                                <li>增加注册忘记密码功能</li>
                                                <li>优化了主题的显示效果</li>
                                            </ol>
                                        </div>
                                    </div>
                                </div> -->
                                   <!-- <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h5 class="panel-title">
                                                <a data-toggle="collapse" data-parent="#version" href="#v1.0">v1.9</a><code class="pull-right"></code>
                                            </h5>
                                    </div>
                                </div>
                                   <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h5 class="panel-title">
                                                <a data-toggle="collapse" data-parent="#version" href="#v1.0">v1.8</a><code class="pull-right"></code>
                                            </h5>
                                    </div>
                                </div>
                           		<div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h5 class="panel-title">
                                                <a data-toggle="collapse" data-parent="#version" href="">********</a><code class="pull-right"></code>
                                            </h5>
                                    </div>
                                </div>
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h5 class="panel-title">
                                                <a data-toggle="collapse" data-parent="#version" href="#v1.1">v1.1</a><code class="pull-right"></code>
                                            </h5>
                                    </div>
                                </div>
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h5 class="panel-title">
                                                <a data-toggle="collapse" data-parent="#version" href="#v1.0">v1.0</a><code class="pull-right"></code>
                                            </h5>
                                    </div>
                                </div> -->
                               
            <!--     </div>
            </div>
            </div> -->
            </div>
            </div>
            <div class="col-sm-4">
                <div class="ibox float-e-margins">
                   <!--  <div class="ibox-title">
                        <h5>商业授权 </h5>
                    </div> -->
                   <!--  <div class="ibox-content">
                        <p>JeePlus是一款收费开源的快速开发平台，购买后您将获得以下内容</p>
                        <ol>
                            <li>源码(带注释)；</li>
                            <li>代码生成器；</li>
                            <li>开发者文档；</li>
                            <li>永久的免费升级服务；</li>
                            <li>授权许可；</li>
                            <li>付费二次开发服务；</li>
                            <li>……</li>
                        </ol>
                        <hr>
                    

                    </div> -->
                </div>
                  <div class="ibox float-e-margins">
                 <!--    <div class="ibox-title">
                        <h5>联系信息</h5>

                    </div> -->
                   <!--  <div class="ibox-content">
                        <p><i class="fa fa-send-o"></i> 网址：<a href="http://www.jeeplus.org" target="_blank">http://www.jeeplus.org</a>
                        </p>
                        <p><i class="fa fa-qq"></i> QQ：<a href="http://wpa.qq.com/msgrd?v=3&uin=117575171&site=qq&menu=yes" target="_blank">117575171</a>
                        </p>
                        <p><i class="fa fa-weixin"></i> 微信：<a href="javascript:;">117575171</a>
                        </p>
                        <p><i class="fa fa-credit-card"></i> 支付宝：<a href="javascript:;" class="支付宝信息">117575171@qq.com</a>
                        </p>
                    </div> -->
                </div>
            </div>
        </div>
    </div>
	</div>
</body>
</html>