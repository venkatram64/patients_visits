<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>E-Hospital Application</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <script src="./js/bootstrap.min.js"></script>
    <script src="./js/jquery_3_2_1.js"></script>
</head>
<body>

    <div>
        <div tabindex="-1"  id="loginModal" role="dialog" aria-hidden="true">
          <div class="modal-dialog">
          <div class="modal-content">
              <div class="modal-body">
                  <form class="form col-md-12 center-block" method="post" action="login_check">
                    <div class="form-group">
                      <input class="form-control input-lg" type="text" name="email" placeholder="Email">
                    </div>
                    <div class="form-group">
                      <input class="form-control input-lg" type="password" name="password" placeholder="Password">
                    </div>
                    <div class="form-group">
                      <button class="btn btn-primary btn-lg btn-block">Login</button>
                    </div>
                    <div class="form-group">
                      <a href="/registration_form" class="btn btn-primary btn-lg btn-block" role="button" aria-pressed="true">Registration</a>
                    </div>
                  </form>
              </div>
          </div>
          </div>
        </div>
    </div>

</body>
</html>