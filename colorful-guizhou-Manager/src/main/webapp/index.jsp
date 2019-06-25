<%--
  Created by IntelliJ IDEA.
  User: dage
  Date: 2019/6/24
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<jsp:include page="common/header.jsp" flush="true"> <jsp:param name="name" value="value"/> </jsp:include>--%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>多彩贵州后台管理系统</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="style/plugins/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="style/plugins/font-awesome/css/font-awesome.min.css" media="all">
    <link rel="stylesheet" href="style/build/css/app.css" media="all">

    <link rel="stylesheet" href="style/build/css/themes/green.css" media="all">
</head>
<body>
<div class="layui-layout layui-layout-admin kit-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">多彩贵州后台管理系统</div>
        <div class="layui-logo kit-logo-mobile">K</div>
        <ul class="layui-nav layui-layout-right kit-nav">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://m.zhengjinfan.cn/images/0.jpg" class="layui-nav-img"> Van
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;">基本资料</a></dd>
                    <dd><a href="javascript:;">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="javascript:;"><i class="fa fa-sign-out" aria-hidden="true"></i> 注销</a>
            </li>
        </ul>
    </div>
    <%--    导航栏--%>
    <div class="layui-side layui-bg-black kit-side">
        <div class="layui-side-scroll">
            <div class="kit-side-fold"><i class="fa fa-navicon" aria-hidden="true"></i></div>
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="kitNavbar" kit-navbar>
                <li class="layui-nav-item">
                    <a class="" href="javascript:;"><i class="fa fa-plug"
                                                       aria-hidden="true"></i><span> 地区信息管理</span></a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;" kit-target
                               data-options="{url:'admin/region/add.jsp',icon:'&#xe6c6;',title:'信息新增',id:'1'}">
                                <i class="layui-icon">&#xe6c6;</i><span> 地区信息新增</span></a>
                        </dd>
                        <dd>
                            <a href="javascript:;" data-url="admin/region/del.jsp" data-icon="fa-user"
                               data-title="信息删除"
                               kit-target
                               data-id='2'><i class="fa fa-user" aria-hidden="true"></i><span> 地区信息删除</span></a>
                        </dd>
                        <dd>
                            <a href="javascript:;" data-url="admin/region/list.jsp" data-icon="&#xe628;"
                               data-title="信息显示" kit-target
                               data-id='3'><i class="layui-icon">&#xe628;</i><span> 地区信息显示</span></a>
                        </dd>
                        <dd>
                            <a href="javascript:;" data-url="admin/region/update.jsp" data-icon="&#xe614;"
                               data-title="信息修改"
                               kit-target data-id='4'><i class="layui-icon">&#xe614;</i><span> 地区信息修改</span></a>
                        </dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a class="" href="javascript:;"><i class="fa fa-plug"
                                                       aria-hidden="true"></i><span> VIP信息管理</span></a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;" data-url="admin/user/list.jsp" data-ico="&#xe658;"
                               data-title="信息显示"
                               kit-target data-id="5"><i class="layui-icon">&#xe614;</i>VIP信息显示</a>
                        </dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;" data-url="/views/form.html" data-name="form" kit-loader><i class="fa fa-plug"
                                                                                                      aria-hidden="true"></i><span> 美食信息管理</span></a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;" kit-target
                               data-options="{url:'admin/delicacy/add.jsp',icon:'&#xe6c6;',title:'信息新增',id:'6'}">
                                <i class="layui-icon">&#xe6c6;</i><span> 美食信息新增</span></a>
                        </dd>
                        <dd>
                            <a href="javascript:;" data-url="admin/delicacy/del.jsp" data-icon="fa-user"
                               data-title="信息删除" kit-target
                               data-id='7'><i class="fa fa-user" aria-hidden="true"></i><span> 美食信息删除</span></a>
                        </dd>
                        <dd>
                            <a href="javascript:;" data-url="admin/delicacy/list.jsp" data-icon="&#xe628;"
                               data-title="信息查询" kit-target
                               data-id='8'><i class="layui-icon">&#xe628;</i><span> 美食信息显示</span></a>
                        </dd>
                        <dd>
                            <a href="javascript:;" data-url="admin/delicacy/update.jsp" data-icon="&#xe614;"
                               data-title="信息修改"
                               kit-target data-id='9'><i class="layui-icon">&#xe614;</i><span> 美食信息修改</span></a>
                        </dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;" data-url="/views/form.html" data-name="form" kit-loader><i class="fa fa-plug"
                                                                                                      aria-hidden="true"></i><span> 景点信息管理</span></a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;" kit-target
                               data-options="{url:'admin/landscape/add.jsp',icon:'&#xe6c6;',title:'信息新增',id:'10'}">
                                <i class="layui-icon">&#xe6c6;</i><span> 景点信息新增</span></a>
                        </dd>
                        <dd>
                            <a href="javascript:;" data-url="admin/landscape/del.jsp" data-icon="fa-user"
                               data-title="信息删除" kit-target
                               data-id='11'><i class="fa fa-user" aria-hidden="true"></i><span> 景点信息删除</span></a>
                        </dd>
                        <dd>
                            <a href="javascript:;" data-url="admin/landscape/list.jsp" data-icon="&#xe628;"
                               data-title="信息查询" kit-target
                               data-id='12'><i class="layui-icon">&#xe628;</i><span> 景点信息显示</span></a>
                        </dd>
                        <dd>
                            <a href="javascript:;" data-url="admin/landscape/update.jsp" data-icon="&#xe614;"
                               data-title="信息修改"
                               kit-target data-id='13'><i class="layui-icon">&#xe614;</i><span> 景点信息修改</span></a>
                        </dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>


    <%--    主题--%>
    <div class="layui-body" id="container">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">主体内容加载中,请稍等...</div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        2019 &copy;
        <!--        <a href="http://kit.zhengjinfan.cn/">kit.zhengjinfan.cn/</a> MIT license-->

    </div>
</div>
</body>
<script type="text/javascript" src="<%=basePath%>style/plugins/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src='<%=basePath%>style/plugins/layui/particles.js'></script>
<script type="text/javascript" src='<%=basePath%>style/plugins/layui/background.js'></script>
<script type="text/javascript" src="<%=basePath%>style/plugins/layui/gt.js"></script>
<script>
    layui.use(['jquery', 'layer'], function () {

        var msg = '${msg}';
        if (msg != "") {
            layui.layer.msg(msg, {offset: 70, shift: 0});
        }
    });
</script>
<script>
    var message;
    layui.config({
        base: 'style/build/js/'
    }).use(['app', 'message'], function () {
        var app = layui.app,
            $ = layui.jquery,
            layer = layui.layer;
        //将message设置为全局以便子页面调用
        message = layui.message;
        //主入口
        app.set({
            type: 'iframe'
        }).init();
        $('#pay').on('click', function () {
            layer.open({
                title: false,
                type: 1,
                content: '<img src="style/build/images/pay.png" />',
                area: ['500px', '250px'],
                shadeClose: true
            });
        });
    });
</script>
</html>
