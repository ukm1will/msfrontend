<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>SBGC</title>
    <link href="<c:url value="/resources/main.css" />" rel="stylesheet">
</head>

<body>
<div class="center" id="outer-div">
    <div class="center" id="sb-banner">Swansea Bay Golf Club Results</div>
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
                        <form action="/viewnet">
                            <input type="hidden" name="viewId" value="${url.getViewId()}">
                            <input type="hidden" name="dateOfCompetition" value="${url.getDateOfCompetition()}">
                            <input type="hidden" name="competitionTitle" value="${url.getCompetitionTitle()}">
                            <input type="submit" name="submitButton" value="View">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
</div>
</body>
</html>

