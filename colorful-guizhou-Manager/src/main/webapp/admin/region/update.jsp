<%--
  Created by IntelliJ IDEA.
  User: dage
  Date: 2019/6/25
  Time: 14:42
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
    <form action="<%=basePath%>/region/update" method="post">
        地区ID:&nbsp;<input type="text" name="regionId"><br>
        地区名称:&nbsp;<input type="text" name="regionName"><br>
        上级地区ID:&nbsp;<input type="text" name="superRegionId"><br>
        <input type="submit" value="修改">&nbsp;<input type="reset" value="取消">
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