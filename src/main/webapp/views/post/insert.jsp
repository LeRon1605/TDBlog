<%@page import="models.Bean.Tag"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link rel="stylesheet" href="../../public/css/base.css">
    <link rel="stylesheet" href="../../public/css/grid.css">
    <link rel="stylesheet" href="../../public/css/admin_insert_problem.css">
    <title>Thêm bài tập</title>
</head>

<body>
    <div class="main">
        <form action="/posts/insert" method="POST" class="form" id="form_add-problem">
            <h1 class="heading">Thêm bài viết</h1>
            <div class="spacer"></div>
            <% if (request.getAttribute("error") != null) { %>
	        	<div class="alert alert-danger text-center" role="alert">
			  		<%= request.getAttribute("error") %>
				</div>
			<% } %>
			<% if (request.getAttribute("success") != null) { %>
	        	<div class="alert alert-success text-center" role="alert">
			  		Thêm bài viết thành công
				</div>
			<% } %>
            <div class="form-group">
                <label for="title" class="form-label">Tiêu đề bài viết</label>
                <input id="title" name="title" type="text" placeholder="Nhập tên bài tập" class="form-control">
                <span class="form-message"></span>
            </div>

            <div class="form-group">
                <label for="tag" class="form-label">Thể loại</label>
                <select id="tag" name="tag" class="form-control">
                	<% ArrayList<Tag> tags = (ArrayList<Tag>)request.getAttribute("tags"); %>
                    <option value="">Chọn thể loại</option>
                    <% for (Tag tag: tags) { %>
                    	<option value="<%=tag.getID()%>"><%= tag.getName() %></option>
                    <% } %>
                </select>
                <span class="form-message"></span>
            </div>

            <div class="form-group">
                <label for="content" class="form-label">Nội dung bài viết</label>
                <textarea name="content" id="editor1" cols="" rows="3" class="form-control-text"></textarea>
                <span class="form-message"></span>
            </div>
            <% if (request.getAttribute("validation-error") != null) { %>
			  	<% 
			  		String[] validationError = (String[])request.getAttribute("validation-error"); 
			  		for (String message: validationError) {
			  	%>
			  	<div class="alert alert-danger text-center" role="alert">		
		  			<%= message %>
		  		</div>
		  		<%  } %>
			<% } %>

            <div class="form-btn">
                <button class="form-submit">Thêm bài viết</button>
            </div>
        </form>
    </div>
</body>
<script src="../../public/lib/ckeditor/ckeditor.js"></script>
<script src="../../public/js/validation.js"></script>
<script src="../../public/js/post_insert.js"></script>
</html>