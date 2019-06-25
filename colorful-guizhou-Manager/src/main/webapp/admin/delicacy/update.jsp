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
</head>
<body>
<div>
    <form action="<%=basePath%>/landscape/update" method="post">
        美食ID:&nbsp;<input type="text" name="delicacyId"><br>
        美食类型:&nbsp;<input type="text" name="delicacyType"><br>
        美食名称:&nbsp;<input type="text" name="delicacyName"><br>
        所属地区ID:&nbsp;<input type="text" name="regionId"><br>
        价格:&nbsp;<input type="text" name="price"><br>
        美食介绍:&nbsp;<input type="text" name="introduction"><br>
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
