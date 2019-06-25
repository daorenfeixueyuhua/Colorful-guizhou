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
</head>
<body>
<div>
    <form action="<%=basePath%>/region/showAll" method="get">
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
<script>
    <%--    使用该处信息提示 --%>
    var msg = '${msg}';
    if (msg != "") {
        alert(msg);
    }
</script>
</html>