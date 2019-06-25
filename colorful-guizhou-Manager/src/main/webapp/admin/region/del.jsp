<%--
  Created by IntelliJ IDEA.
  User: dage
  Date: 2019/6/25
  Time: 14:48
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
</head>
<body>
<div>
    <form action="<%=basePath%>/region/del">
        地区ID:&nbsp;<input type="text" name="regionID">&nbsp;<input type="submit" value="删除">
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
