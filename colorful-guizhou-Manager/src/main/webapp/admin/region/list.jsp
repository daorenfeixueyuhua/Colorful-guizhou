<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dage
  Date: 2019/6/25
  Time: 14:39
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
    <form name="pageForm" action="<%=basePath%>/region/showAll" method="get">&nbsp;
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
            <td>地区ID</td>
            <td>地区名称</td>
            <td>上级地区ID</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${data.datas}" var="data">
            <tr>
                <th>${data.regionId}</th>
                <th>${data.regionName}</th>
                <th>${data.superRegionId}</th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
<script src="../../style/build/js/resach.js"></script>
<script>
    <%--    使用该处信息提示 --%>
    var msg = '${msg}';
    if (msg != "") {
        alert(msg);
    }
</script>
</html>
