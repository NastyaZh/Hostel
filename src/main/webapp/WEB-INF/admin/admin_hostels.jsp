<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.admin.hostels" var="hostel"/>
    <fmt:message bundle="${loc}" key="local.button.name.en" var="en_button"/>
    <fmt:message bundle="${loc}" key="local.button.name.ru" var="ru_button"/>
    <fmt:message bundle="${loc}" key="local.hostel.name" var="nameHotel"/>
    <fmt:message bundle="${loc}" key="local.hostel.stars" var="stars"/>
    <fmt:message bundle="${loc}" key="local.admin.edit" var="edit"/>
    <fmt:message bundle="${loc}" key="local.admin.delete" var="delete"/>
    <fmt:message bundle="${loc}" key="local.admin.add.hostel" var="addHostel"/>
    <title>${hostel}</title>
    <c:set scope="session" var="url" value="/admin/admin_hostels"/>
    
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
    <jsp:param name="command" value="get-hotels-command"/>
</jsp:include>
<div id="page-content-wrapper">
<c:import url="/WEB-INF/admin/admin_header.jsp"/>
<a href="${pageContext.request.contextPath}/admin/add_hotel">${addHostel}</a>
<br>
<table>
    <thead>
    <tr>
        <td>ID</td>
        <th>${nameHotel}</th>
        <th>${stars}</th>
        <th>${edit}</th>
        <th>${delete}</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="hotel" items="${requestScope.hostels}">
        <tr>
            <td>${hotel.id}</td>
            <td>${hotel.name}</td>
            <td>${hotel.stars}</td>
            <td>
                <a style="color: blue;"
                href="${pageContext.request.contextPath}/admin/edit_hostel?id=${hotel.id}"> ${edit}</a>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/controller" method="post">
                    <input type="hidden" name="command" value="delete-hostel-by-id-command">
                    <input type="hidden" name="id" value="${hotel.id}">
                    <input type="submit" value="${delete}">
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>
