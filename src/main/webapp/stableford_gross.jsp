<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>

<html>
<head>
    <title>SBGC</title>
    <link href="<c:url value="/resources/main.css" />" rel="stylesheet">
</head>
<body>

<div class="center" id="outer-div">
    <p id="comp-title">${competitionTitle}</p>
    <p id="comp-date">Competition played on ${dateOfCompetition} at Swansea Bay</p>
    <p id="comp-type">Gross Result</p>
    <div class="center" id="inner-div">
        <div class="alt-score-div">
            <form action="/viewnet">
                <input type="hidden" name="viewId" value="${viewId}">
                <input type="hidden" name="dateOfCompetition" value="${dateOfCompetition}">
                <input type="hidden" name="competitionTitle" value="${competitionTitle}">
                <input type="submit" class="alt-score-button" value="View Net Result">
            </form>
        </div>
        <table id="results-table">
            <tr>
                <th>Overall Position</th>
                <th>Player</th>
                <th>Gross Score</th>
                <th>Handicap</th>
                <th>Net</th>
                <th>Pts</th>
            </tr>
            <c:forEach var="golfer" items="${golfers}">
                <tr>
                    <td class="col-overall-position">${golfer.getPosition()}</td>
                    <td class="col-brown-bold">${golfer.getFullName()}</td>
                    <td class="col-brown-bold">${golfer.getGross()}</td>
                    <td class="col-handicap">${golfer.getHandicap()}</td>
                    <td class="col-lighter">${golfer.getNett()}</td>
                    <td class="col-lighter">${golfer.getPts()}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>

