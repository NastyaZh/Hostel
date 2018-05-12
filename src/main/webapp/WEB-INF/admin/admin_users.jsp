<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.admin.users" var="users"/>
    <fmt:message bundle="${loc}" key="local.user.login" var="login"/>
    <fmt:message bundle="${loc}" key="local.user.name" var="name"/>
    <fmt:message bundle="${loc}" key="local.user.admin" var="admin"/>
    <fmt:message bundle="${loc}" key="local.user.surname" var="surname"/>
    <fmt:message bundle="${loc}" key="local.user.number" var="number"/>
    <fmt:message bundle="${loc}" key="local.user.email" var="email"/>
    <fmt:message bundle="${loc}" key="local.user.banned" var="banned"/>
    <fmt:message bundle="${loc}" key="local.admin.edit" var="edit"/>
    <fmt:message bundle="${loc}" key="local.button.name.en" var="en_button"/>
    <fmt:message bundle="${loc}" key="local.button.name.ru" var="ru_button"/>
    <fmt:message bundle="${loc}" key="local.text.form" var="from"/>
    <title>${users}</title>
    <c:set scope="session" var="url" value="/admin/admin_users?page=${param.page}"/>
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/menu.css">
</head>
<body>
<c:import url="/menu.jsp"/>
<jsp:include page="${pageContext.request.contextPath}/controller">
    <jsp:param name="command" value="get-users-command"/>
    <jsp:param name="page" value="${param.page}"/>
</jsp:include>
<div id="page-content-wrapper">
<c:import url="/WEB-INF/admin/admin_header.jsp"/>
<br>
<table>
    <thead>
    <tr>
        <td>ID</td>
        <th>${name}</th>
        <th>${surname}</th>
        <th>${login}</th>
        <th>${email}</th>
        <th>${number}</th>
        <th>${admin}</th>
        <th>${banned}</th>
        <th>${edit}</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="hotel" items="${requestScope.page.entity}">
        <form action="${pageContext.request.contextPath}/controller" method="post">
            <input type="hidden" name="command" value="edit-role-ban-user-command">
            <input type="hidden" name="id" value="${hotel.id}">
            <tr>
                <td>${hotel.id}</td>
                <td>${hotel.name}</td>
                <td>${hotel.surname}</td>
                <td>${hotel.login}</td>
                <td>${hotel.email}</td>
                <td>${hotel.number}</td>
                <td>
                    <c:choose>
                        <c:when test="${hotel.role eq 'admin'}">
                            <input type="checkbox" name="role" value="admin" checked/>
                        </c:when>
                        <c:otherwise>
                            <input type="checkbox" name="role" value="admin"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${hotel.banned}">
                            <input type="checkbox" name="banned" value="1" checked/>
                        </c:when>
                        <c:otherwise>
                            <input type="checkbox" name="banned" value="1"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td><input type="submit" value="${edit}"/></td>
            </tr>
        </form>
    </c:forEach>
    </tbody>
</table>
<div class="pagination">
    <c:if test="${requestScope.page.currentPage gt 1}">
        <a href="${pageContext.request.contextPath}/admin/admin_users?page=1"><<</a>&#8195;
        <a href="${pageContext.request.contextPath}/admin/admin_users?page=${requestScope.page.currentPage - 1}"><</a>&#8195;
    </c:if>
    &#8195;${requestScope.page.currentPage} ${from} ${requestScope.page.numberOfPages}&#8195;
    <c:if test="${requestScope.page.currentPage lt requestScope.page.numberOfPages}">
        <a href="${pageContext.request.contextPath}/admin/admin_users?page=${requestScope.page.currentPage + 1}">></a>&#8195;
        <a href="${pageContext.request.contextPath}/admin/admin_users?page=${requestScope.page.numberOfPages}">>></a>
    </c:if>
</div>
</div>
</body>
</html>
