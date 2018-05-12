<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.admin.add.guestroom" var="addGuestroom"/>
    <fmt:message bundle="${loc}" key="local.button.name.en" var="en_button"/>
    <fmt:message bundle="${loc}" key="local.button.name.ru" var="ru_button"/>
    <fmt:message bundle="${loc}" key="local.title.hotel" var="hotel"/>
    <fmt:message bundle="${loc}" key="local.guestroom.description.ru" var="descriptionRu"/>
    <fmt:message bundle="${loc}" key="local.guestroom.description.en" var="descriptionEn"/>
    <fmt:message bundle="${loc}" key="local.search.shower" var="shower"/>
    <fmt:message bundle="${loc}" key="local.guestroom.night.price" var="nightPrice"/>
    <fmt:message bundle="${loc}" key="local.guestroom.capacity" var="capacity"/>
    <fmt:message bundle="${loc}" key="local.admin.add.image" var="addImg"/>
    <fmt:message bundle="${loc}" key="local.admin.save" var="save"/>

    <title>${addGuestroom}</title>

    <c:set scope="session" var="url" value="/admin/add_guestroom"/>
    
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
    <jsp:param name="command" value="get-hostels-names-command"/>
</jsp:include>
<div id="page-content-wrapper">
<c:import url="/WEB-INF/admin/admin_header.jsp"/>
<form role="form" action="${pageContext.request.contextPath}/controller" method="post" enctype="multipart/form-data">
    <input type="hidden" name="command" value="add-guestroom-command">
    ${hotel}:&#8195;
    <div>
        <select name="name">
            <option value="any"></option>
            <c:forEach var="name" items="${requestScope.names}">
                <option value="${name}">${name}</option>
            </c:forEach>
        </select>
    </div>
    <div>
    <table>
            <tr>
                <td>${descriptionRu}</td>
                <td><input type="text" name="descriptionRu"></td>
            </tr>
            <tr>
                <td>${descriptionEn}</td>
                <td><input type="text" name="descriptionEn"></td>
            </tr>
            <tr>
                <td>wifi</td>
                <td><input type="checkbox" value="true" name="wifi"/></td>
            </tr>
            <tr>
                <td>TV</td>
                <td><input type="checkbox" value="true" name="tv"/></td>
            </tr>
            <tr>
                <td>${shower}</td>
                <td><input type="checkbox" value="true" name="shower"/></td>
            </tr>
            <tr>
                <td>${capacity}</td>
                <td><input type="text" pattern="[1-9]*" name="capacity"></td>
            </tr>
            <tr>
                <td>${nightPrice}</td>
                <td><input type="text" pattern="[1-9],*" name="nightPrice"></td>
            </tr>
            
    </table>
    </div>
	<br>
    ${addImg}<input type="file" name="file" accept="image/jpeg">
    <input type="submit" value="${save}">
</form>
</div>
</body>
</html>
