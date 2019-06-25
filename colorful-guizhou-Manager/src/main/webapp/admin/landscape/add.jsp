<%--
  Created by IntelliJ IDEA.
  User: dage
  Date: 2019/6/25
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<head>
    <title>多彩贵州后台管理系统</title>
    <link rel="stylesheet" href="../../style/build/css/form.css">
</head>
<body>
<div>
    <form action="<%=basePath%>/landscape/add" method="post" class="basic-grey">
        <h1>Contact Form
            <span>Please fill all the texts in the fields.</span>
        </h1>
        <label>
            <span>景点ID:</span>
            <input id="landscapeId" type="text" name="landscapeId" placeholder="景点ID"/>
        </label>

        <label>
            <span>景点类型:</span>
            <input id="landscapeType" type="text" name="landscapeType" placeholder="景点类型"/>
        </label>
        <label>
            <span>景点名称:</span>
            <textarea id="landscapeName" name="landscapeName" placeholder="景点名称"></textarea>
        </label>
        <label>
            <span>所属地区ID:</span>
            <input type="text" name="regionId" placeholder="输出入该景点所在地地区ID">
        </label>
        <label>
            <span>门票:</span>
            <input type="text" name="price" placeholder="景点门票价格">
        </label>
        <label>
            <span>景点介绍:&nbsp;</span>
            <textarea id="introduction" name="introduction" placeholder="景点简介"></textarea>
        </label>
        <label>
            <span>&nbsp;</span>
            <input type="submit" class="button" value="提交"/>
        </label>
    </form>
</div>
</body>
<script>
    var msg = '${msg}';
    if (msg != "") {
        alert(msg);
    }
</script>
</html>
