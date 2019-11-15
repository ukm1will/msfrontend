<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>SBGC</title>
    <link href="<c:url value="/resources/main.css" />" rel="stylesheet">
</head>
<body>

<div class="center" id="outer-div">
    <p id="comp-title">${competitionTitle}</p>
    <p id="comp-date">Competition played on ${dateOfCompetition} at Swansea Bay</p>
    <p id="comp-type">Full Net Result</p>
    <div class="center" id="inner-div">
        <div class="alt-score-div">
            <form action="/viewgross">
                <input type="hidden" name="viewId" value="${viewId}">
                <input type="hidden" name="dateOfCompetition" value="${dateOfCompetition}">
                <input type="hidden" name="competitionTitle" value="${competitionTitle}">
                <input type="submit" class="alt-score-button" value="View Gross Result">
            </form>
        </div>
        <table id="results-table">
            <tr>
                <th>Overall Position</th>
                <th>Player</th>
                <th>Score</th>
                <th>Placing</th>
                <th>Countback</th>
            </tr>
            <c:forEach var="golfer" items="${golfers}">
                <tr>
                    <td class="col-overall-position">${golfer.getPosition()}</td>
                    <td class="col-brown-bold">${golfer.getFullName()}</td>
                    <td class="col-brown-bold">${golfer.getPts()} pts (${golfer.getHandicap()})</td>
                    <td class="col-placing">${golfer.getPlacing()}</td>
                    <td class="col-countback">${golfer.getCountback()}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>

