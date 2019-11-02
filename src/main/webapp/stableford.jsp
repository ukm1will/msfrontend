<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>Swansea Bay Golf Club</title>
</head>

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<body>


<h3>${competitionTitle}</h3>
<h3>${dateOfCompetition}</h3>

<form action="/viewalt">
    <input type="hidden" name="dateOfCompetition" value="${dateOfCompetition}">
    <input type="hidden" name="competitionTitle" value="${competitionTitle}">
    <input type="hidden" name="golfers" value="${golfers}">
    <input type="submit" value="Alternate Result">
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
