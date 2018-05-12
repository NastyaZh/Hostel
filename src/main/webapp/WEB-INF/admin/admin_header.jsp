<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.admin.hostels" var="hostel"/>
    <fmt:message bundle="${loc}" key="local.admin.users" var="users"/>
    <fmt:message bundle="${loc}" key="local.admin.guestrooms" var="rooms"/>
    <fmt:message bundle="${loc}" key="local.admin.booking" var="bookings"/>
    <fmt:message bundle="${loc}" key="local.admin.logout" var="logout"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        <%@include file="/css/style.css"%>
    </style>

</head>
<body>
<div class="head-navbar">
    <li><a href="${pageContext.request.contextPath}/admin/admin_users">${users}</a></li>
    <li><a href="${pageContext.request.contextPath}/admin/admin_hostels">${hostel}</a></li>
    <li><a href="${pageContext.request.contextPath}/admin/admin_guestrooms">${rooms}</a></li>
    <li><a href="${pageContext.request.contextPath}/admin/admin_users_bookings">${bookings}</a></li>
    <li><a href="${pageContext.request.contextPath}/controller?command=logout-command">${logout}</a></li>

</div>
</body>
</html>