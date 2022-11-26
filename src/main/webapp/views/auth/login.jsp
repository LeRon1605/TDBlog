<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
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
        <form class="d-flex flex-column align-items-center justify-content-center" action="/auth/login" method="POST">
            <input class="mb-3 p-2" placeholder="Tên đăng nhập" name="username"/>
            <input class="mb-3 p-2" placeholder="Mật khẩu" name="password"/>
            <input class="mb-3 p-2 text-center" value="Đăng nhập" type="submit"/>
        </form>
        <span>Không có tài khoản? <a href="/auth/register"> Đăng kí ngay</a></span>
    </div>    
</body>
</html>