<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>Swansea Bay Golf Club</title>
    <link href="<c:url value="/resources/main.css" />" rel="stylesheet">
</head>

<body>

<form action="/viewnett">
    <input type="hidden" name="viewId" value="${viewId}">
    <input type="hidden" name="dateOfCompetition" value="${dateOfCompetition}">
    <input type="hidden" name="competitionTitle" value="${competitionTitle}">
    <input type="submit" value="View Nett Result">
</form>

<table class="w3-table-all w3-hoverable">
    <tr>
        <th>Position</th>
        <th>Name</th>
        <th>Gross</th>
        <th>Nett</th>
        <th>Pts</th>
        <th>Handicap</th>
    </tr>
    <c:forEach var="golfer" items="${golfers}">
        <tr>
            <td>${golfer.getPosition()}</td>
            <td>${golfer.getFullName()}</td>
            <td>${golfer.getGross()}</td>
            <td>${golfer.getNett()}</td>
            <td>${golfer.getPts()}</td>
            <td>${golfer.getHandicap()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
