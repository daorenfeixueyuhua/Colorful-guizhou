<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dage
  Date: 2019/6/25
  Time: 12:16
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
    <form action="<%=basePath%>/user/showAll" method="get">
        第<input type="text" name="currentPage" value="${data.currentPage}">页&nbsp;每页 <input type="text" name="pageSize"
                                                                                            value="${data.pageSize}">
        条数据&nbsp;<input
            type="submit" value="查询">
    </form>
</div>

<div class="showInfos">
    <table>
        <thead>
        <tr>
            <td>用户名</td>
            <td>密码</td>
            <td>昵称</td>
            <td>性别</td>
            <td>生日</td>
            <td>所属地区ID</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${data.datas}" var="data">
            <tr>
                <th>${data.userName}</th>
                <th>${data.passWord}</th>
                <th>${data.name}</th>
                <th>${data.gender}</th>
                <th>${data.birthday}</th>
                <th>${data.regionId}</th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
