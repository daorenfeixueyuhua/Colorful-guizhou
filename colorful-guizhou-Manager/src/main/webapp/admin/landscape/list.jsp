<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dage
  Date: 2019/6/25
  Time: 15:15
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
    <link rel="stylesheet" href="../../style/build/css/table.css" media="all">
</head>
<body>
<div align="center">
    <form name="pageForm" action="<%=basePath%>/landscape/showAll" method="get">&nbsp;
        <span>第</span>
        <input type="text" name="currentPage" value="${data.currentPage==null?1:data.currentPage}" style="width:40px;">
        <span>页</span>
        <input class="page-last" type="submit" value="上一页" onclick="lastPage()">
        <input class="page-next" type="submit" value="下一页" onclick="nextPage()">
        <span>当前页数：</span><input name="pageSize" value="10" style="width:30px;" readonly>
        <input type="submit" value="查询">&nbsp;&nbsp;&nbsp;
    </form>
</div>

<div class="showInfos">
    <table id="table-3">
        <thead>
        <tr>
            <td>景点ID</td>
            <td>景点类型</td>
            <td>景点名称</td>
            <td>所属地区ID</td>
            <td>门票</td>
            <td>景点介绍</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${data.datas}" var="data">
            <tr>
                <th>${data.landscapeId}</th>
                <th>${data.landscapeType}</th>
                <th>${data.landscapeName}</th>
                <th>${data.regionId}</th>
                <th>${data.price}</th>
                <th>${data.introduction}</th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
<script src="../../style/build/js/resach.js"></script>
</html>
