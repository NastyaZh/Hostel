<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.button.name.en" var="en_button"/>
    <fmt:message bundle="${loc}" key="local.button.name.ru" var="ru_button"/>
    <fmt:message bundle="${loc}" key="local.admin.edit" var="edit"/>
    <fmt:message bundle="${loc}" key="local.hostel.name" var="name"/>
    <fmt:message bundle="${loc}" key="local.hostel.stars" var="stars"/>
    <fmt:message bundle="${loc}" key="local.russian" var="russian"/>
    <fmt:message bundle="${loc}" key="local.englich" var="english"/>
    <fmt:message bundle="${loc}" key="local.hostel.country" var="country"/>
    <fmt:message bundle="${loc}" key="local.hostel.city" var="city"/>
    <fmt:message bundle="${loc}" key="local.hostel.address" var="address"/>
    <fmt:message bundle="${loc}" key="local.hostel.description" var="description"/>
    <fmt:message bundle="${loc}" key="local.hostel.update.image" var="updateImage"/>
    <fmt:message bundle="${loc}" key="local.admin.save" var="save"/>
    <title></title>
    <c:set scope="session" var="url" value="/admin/add_hotel"/>
    
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
<div id="page-content-wrapper">
<c:import url="/WEB-INF/admin/admin_header.jsp"/>
<form action="${pageContext.request.contextPath}/controller" method="post" enctype="multipart/form-data">
    <input type="hidden" name="command" value="add-hostel-command">
    <table>
            <tr>
                <td>${name}</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>${stars}</td>
                <td><input type="text" name="stars"></td>
            </tr>
            <tr><td>${russian}</td><tr>
            <tr>
                <td>${country}</td>
                <td><input type="text" name="countryRu"></td>
            </tr>
            <tr>
                <td>${city}</td>
                <td><input type="text" name="cityRu"></td>
            </tr>
            <tr>
                <td>${address}</td>
                <td><input type="text" name="addressRu"></td>
            </tr>
            <tr>
                <td>${description}</td>
                <td><input type="text" name="descriptionRu"></td>
            </tr>
            
            <tr><td>${english}</td><tr>
            <tr>
                <td>${country}</td>
                <td><input type="text" name="countryEn"></td>
            </tr>
            <tr>
                <td>${city}</td>
                <td><input type="text" name="cityEn"></td>
            </tr>
            <tr>
                <td>${address}</td>
                <td><input type="text" name="addressEn"></td>
            </tr>
            <tr>
                <td>${description}</td>
                <td><input type="text" name="descriptionEn"></td>
            </tr>
    </table>
    <img src="${requestScope.hostelEn.imgPath}">
    <input type="file" name="file" accept="image/jpeg">
    <input type="submit" value="${save}">
</form>
</div>
</body>
</html>
