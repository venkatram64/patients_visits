<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <script src="./js/bootstrap.min.js"></script>
   <script src="./js/jquery_3_2_1.js"></script>
   <title>Patient registration form</title>
</head>
<body>
    <div tabindex="-1"  id="loginModal" role="dialog" aria-hidden="true">
    	<div class="modal-dialog">
    		<div class="modal-content">
    		  <div class="modal-body">
    			<div class="container">
    			  <h2>Registration form</h2>
    			  <form method="post" action="registration">
    				<div class="form-group">
    				  <label for="firstName">First Name:</label>
    				  <input type="firstName" class="form-control" id="firstName" placeholder="Enter first name" name="firstName">
    				</div>
    				<div class="form-group">
    				  <label for="lastName">Last Name:</label>
    				  <input type="lastName" class="form-control" id="lastName" placeholder="Enter last name" name="lastName">
    				</div>
    				<div class="form-group">
    				  <label for="email">Email:</label>
    				  <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
    				</div>
    				<div class="form-group">
    				  <label for="password">Password:</label>
    				  <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password">
    				</div>
    				<button class="btn btn-primary btn-lg btn-block">Submit</button>
    				<a href="/cancel_registration" class="btn btn-primary btn-lg btn-block" role="button" aria-pressed="true">Cancel</a>
    			  </form>
    			</div>
    		  </div>
    		</div>
    	</div>
    </div>
</body>
</html>