<%--
  Created by IntelliJ IDEA.
  User: dage
  Date: 2019/6/25
  Time: 15:13
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
    <form action="<%=basePath%>/landscape/del" method="post" class="basic-grey">
        <h1>Contact Form
            <span>Please fill all the texts in the fields.</span>
        </h1>
        <label>
            <span>景点ID</span>
            <input id="landscapeId" type="text" name="landscapeId" placeholder="输入要删除的景点ID"/>
        </label>
        <label>
            <span>&nbsp;</span>
            <input type="submit" class="button" value="DELETE"/>
        </label>
    </form>
</div>
<script>
    var msg = '${msg}';
    if (msg != "") {
        alert(msg);
    }
</script>
</body>
</html>