<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <script src="./js/bootstrap.min.js"></script>
    <title>Galaxy Hospital</title>
</head>
<body>
    <div class="container">
    <center>
        <h1>Galaxy Hospital</h1>
        <h2>
            <a href="/search_medicine">Search Medicens</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/doctors_list">List Doctors</a>

        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><span><h2>List of Doctors</h2></span></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Speciality</th>
            </tr>
            <c:forEach var="doctor" items="${listDoctors}">
                <tr>
                    <td><c:out value="${doctor.id}" /></td>
                    <td><c:out value="${doctor.name}" /></td>
                    <td><c:out value="${doctor.speciality}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    </div>
</body>
</html>