<%--
  Created by IntelliJ IDEA.
  User: dage
  Date: 2019/6/25
  Time: 14:33
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
    <form action="<%=basePath%>/region/add" method="post" class="basic-grey">
        <h1>Contact Form
            <span>Please fill all the texts in the fields.</span>
        </h1>
        <label>
            <span>地区ID:</span>
            <input id="regionId" type="text" name="regionId" placeholder="输入地区ID"/>
        </label>

        <label>
            <span>地区名称:&nbsp;</span>
            <input id="regionName" type="text" name="regionName" placeholder="输入地区名称"/>
        </label>
        <label>
            <span>上级地区ID:</span>
            <input id="superRegionId" type="text" name="superRegionId" placeholder="输出入上级地区ID">
        </label>
        <label>
            <span>&nbsp;</span>
            <input type="submit" class="button" value="提交"/>
        </label>
    </form>
</div>
</body>
<script src="../../style/build/js/resach.js"></script>
<script>
    var msg = '${msg}';
    if (msg != "") {
        alert(msg);
    }
</script>
</html>
