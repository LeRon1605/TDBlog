<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng kí</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link href="../../public/css/reset.css" rel="stylesheet">
	<link href="../../public/css/auth.css" rel="stylesheet">
</head>
<body>
    <div class="main d-flex flex-column align-items-center justify-content-center">
        <img class="mb-4" src="../../public/images/blogging.png"/>
        <% if (request.getAttribute("error") != null) { %>
	        <div class="alert alert-danger text-center" role="alert" style="width: 20rem">
			  	<%= request.getAttribute("error") %>
			</div>
		<% } %>
		<div class="alert alert-danger text-center d-none" role="alert" style="width: 20rem" id="message">
		  	
		</div>
        <form class="d-flex flex-column align-items-center justify-content-center has-validation" action="/auth/register" method="POST" id="form">
            <input class="mb-3 p-2" type="text" placeholder="Họ và tên" name="name"/>
            <input class="mb-3 p-2" type="text" placeholder="Tên đăng nhập" name="username"/>
            <input class="mb-3 p-2" type="password" placeholder="Mật khẩu" name="password" id="password"/>
            <input class="mb-3 p-2" type="password" placeholder="Xác nhận mật khẩu" id="confirm-password"/>
            <input class="mb-3 p-2 text-center" value="Đăng kí" type="submit"/>
        </form>
        <% if (request.getAttribute("validation-error") != null) { %>
			  	<% 
			  		String[] validationError = (String[])request.getAttribute("validation-error"); 
			  		for (String message: validationError) {
			  	%>
			  	<div class="alert alert-danger text-center" role="alert" style="width: 20rem">		
		  			<%= message %>
		  		</div>
		  		<%  } %>
		<% } %>
        <span>Đã có tài khoản? <a href="/auth/login"> Đăng nhập ngay</a></span>
    </div>
    <script type="text/javascript">
    	const form = document.getElementById('form');
    	const passwordField = document.getElementById('password');
    	const confirmPasswordField = document.getElementById('confirm-password');
    	const message = document.getElementById('message');
    	
    	form.addEventListener('submit', e => {
    		if (passwordField.value != confirmPasswordField.value) {
    			e.preventDefault();
    			message.innerText = 'Mật khẩu xác nhận không đúng';
    			message.classList.remove('d-none');
    			message.classList.add('d-block');
    		}
    	});
    </script>        
</body>
</html>