<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
     <link rel="stylesheet" href="./css/bootstrap.min.css">
     <script src="./js/bootstrap.min.js"></script>
     <script src="./js/jquery_3_2_1.js"></script>
    <title>E-Medcare</title>
</head>
<body>
    <div class="container">
        <table class="table">
            <tr>
                <td><h1>E-Medcare</h1></td>
                <td>
                    <h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/logout">Logout</a>
                    </h3>
                </td>
            </tr>
        </table>
        <center>

            <h2>
                <a href="/search_medicine">Search Medicines</a>
            </h2>
        </center>
        <div align="center">
            <table class="table table-bordered table-striped table-bordered table-hover">
                <caption><span><h2>List of Doctors</h2></span></caption>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Speciality</th>
                </tr>
                <c:forEach var="doctor" items="${listDoctors}">
                    <tr>
                        <td><c:out value="${doctor.name}" /></td>
                         <td><c:out value="${doctor.email}" /></td>
                        <td><c:out value="${doctor.specialist}" /></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>