
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html >
<head>
	<title>Login Page</title>
   <!--Made with love by Mutiullah Samim -->
   
	<!--Bootsrap 4 CDN-->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    
    <!--Fontawesome CDN-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script src="jquery-3.7.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/app.js"></script>

	<!--Custom styles-->
	<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<header>
        <h1>Registration Form</h1>
    </header>
    <main>
        <form id="signup_form" class="form_class" action="" method="" modelAttribute="user">
            <div class="form_div">
                <label>Enter a Username:</label>
                <input class="field_class" name="userName" type="text" placeholder="Enter a username" autofocus>
                <label>Enter a Password:</label>
                <input id="pass" class="field_class" name="password" type="password" placeholder="Enter a password">
                <label>Choose a Role:</label>
                <select id="role_drop" name="role">
                <option value=""></option>
            		<option value="ROLE_USER">USER</option>
            		<option value="ROLE_ADMIN">ADMIN</option>
        		</select>
                <button class="submit_class" type="submit" form="login_form" id="register" onclick="registerUser()">Register</button>
            </div>
            <div class="info_div" id="info_div">
                <p>Already have an account? <a href="/login">Login In!</a></p>
            </div>
        </form>
        <div id="regis_success" class="form_class" style="display:None">
        <p><a href="/user/welcome">Login In!</a></p></div>
    </main>
    <footer>
        <p>Employee Management System </p>
 </footer>
</body>
</html>