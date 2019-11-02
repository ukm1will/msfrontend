<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>Swansea Bay Golf Club</title>
    <link href="<c:url value="/resources/main.css" />" rel="stylesheet">
</head>

<body>
<div class="center" id="outer-div">
    <div class="center" id="sb-banner">Swansea Bay - Gross Scores</div>
    <form action="/view">
        <table class="w3-table-all w3-hoverable">
            <tr>
                <th>Date</th>
                <th>Competition</th>
                <th></th>
            </tr>
            <c:forEach var="url" items="${urls}">
                <tr>
                    <td>${url.getDateOfCompetition()}</td>
                    <td>${url.getCompetitionTitle()}</td>
                    <td>
                        <form action="/view">
                            <input type="hidden" name="viewId" value="${url.getViewId()}">
                            <input type="hidden" name="dateOfCompetition" value="${url.getDateOfCompetition()}">
                            <input type="hidden" name="competitionTitle" value="${url.getCompetitionTitle()}">
                            <input type="submit" value="Gross Result">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>
</body>
</html>

