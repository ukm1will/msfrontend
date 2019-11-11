<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>SBGC</title>
    <link href="<c:url value="/resources/main.css" />" rel="stylesheet">
</head>

<body>

<form action="/viewgross">
    <input type="hidden" name="viewId" value="${viewId}">
    <input type="hidden" name="dateOfCompetition" value="${dateOfCompetition}">
    <input type="hidden" name="competitionTitle" value="${competitionTitle}">
    <input type="submit" value="View Gross Result">
</form>

<h3 id="comp-title">${competitionTitle}</h3>

<h3 id="comp-date">Competition played on ${dateOfCompetition} at Swansea Bay.</h3>

<table class="w3-table-all w3-hoverable">
    <tr>
        <th>Overall Position</th>
        <th>Player</th>
        <th>Score</th>
        <th>Placing</th>
        <th>Countback</th>
    </tr>
    <c:forEach var="golfer" items="${golfers}">
        <tr>
            <td>${golfer.getPosition()}</td>
            <td>${golfer.getFullName()}</td>
            <td>${golfer.getPts()} pts (${golfer.getHandicap()})</td>
            <td>${golfer.getPlacing()}</td>
            <td>${golfer.getCountback()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
