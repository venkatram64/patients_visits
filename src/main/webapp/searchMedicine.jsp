<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <link rel="stylesheet" href="./css/bootstrap.min.css">
        <script src="./js/bootstrap.min.js"></script>
        <script src="./js/jquery_3_2_1.js"></script>
        <title>Search Medicines</title>
        <script type="text/javascript">
            function parseText(strType){
                var input = $("#input").val();
                var formData = {"input": strType};
                $.ajax({
                    type: 'POST',
                    url:'${pageContext.request.contextPath}/search_medicine_type',
                    dataType:'json',
                    data: formData,
                    success:function(response){
                        var jsonResponse = JSON.parse(JSON.stringify(response));

                        $('#dynatablesearch').empty();
                        $.each(jsonResponse, function(index, value){
                            var row = "<tr>" + "<td>" + value.illnessType + "</td>"+ "<td>" + value.medicine +"</td>"
                            $('#dynatablesearch').append(row);
                        });

                    }
                });
            }
        </script>
    </head>
    <body>
        <div class="container">
            <table class="table">
                <tr>
                    <td><h1>E-Hospital</h1></td>
                    <td>
                        <h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="/logout">Logout</a>
                        </h3>
                    </td>
                </tr>
            </table>
            <center>
                <h2>
                    <a href="/doctors_list">List Doctors</a>
                </h2>
            </center>
            <form>
                <div class="container">
                    <!--h3>Input:</h3>
                    <div class="form-group">
                        <label for="input">Enter your text here.</label>
                        <textarea id="input" class="form-control" rows="4"></textarea>
                    </div-->
                    <div class="form-group">
                        <label for="type">Select Type</label>
                        <select class="form-control" id="type" onchange="parseText(this.value)">
                            <option value="">Select Type</option>
                            <option value="FEVER">Fever</option>
                            <option value="HEAD_ACHE">Head ache</option>
                            <option value="STOMACH_ACHE">Stomach ache</option>
                            <option value="KNEE_PAIN">Knee pain</option>
                            <option value="BACK_PAIN">Back pain</option>
                        </select>
                    </div>
                    <h3>Output:</h3>

                    <div class="input-group" id="result">
                        <div class="table-responsive">
                            <table id="searchDataId"
                                class="table table-bordered table-striped table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>Illness Type</th>
                                        <th>Medicine</th>
                                    </tr>
                                </thead>
                                <tbody id="dynatablesearch"></tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>