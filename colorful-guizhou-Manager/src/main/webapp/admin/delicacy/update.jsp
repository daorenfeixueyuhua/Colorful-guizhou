<%--
  Created by IntelliJ IDEA.
  User: dage
  Date: 2019/6/25
  Time: 15:18
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
    <form action="<%=basePath%>/delicacy/update" method="post" class="basic-grey">
        <h1>Contact Form
            <span>Please fill all the texts in the fields.</span>
        </h1>
        <label>
            <span>美食ID:</span>
            <input id="delicacyId" type="text" name="delicacyId" placeholder="美食ID"/>
        </label>

        <label>
            <span>美食类型:</span>
            <input id="delicacyType" type="text" name="delicacyType" placeholder="美食类型"/>
        </label>
        <label>
            <span>美食名称:</span>
            <textarea id="delicacyName" name="delicacyName" placeholder="美食名称"></textarea>
        </label>
        <label>
            <span>所属地区ID:</span>
            <input type="text" name="regionId" placeholder="输出入该美食所在地地区ID">
        </label>
        <label>
            <span>价格:</span>
            <input type="text" name="price" placeholder="美食售卖价格">
        </label>
        <label>
            <span>美食介绍:</span>
            <textarea id="introduction" name="introduction" placeholder="美食简介"></textarea>
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
