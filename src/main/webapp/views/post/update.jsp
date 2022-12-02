<%@page import="core.Auth.AuthContext"%>
<%@page import="models.Bean.Tag"%>
<%@page import="models.Bean.Post"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link rel="stylesheet" href="../../public/css/grid.css">
    <link rel="stylesheet" href="../../public/css/admin_insert_problem.css">
    <title>Thêm bài tập</title>
    <style>
    	input[type="file"] {
		    display: none !important;
		}
		
		.custom-file-upload {
		    border: 1px solid #ccc;
		    display: inline-block;
		    padding: 6px 12px;
		    cursor: pointer;
		}
		
		[type=submit], button{
			background-color: #2fe255 !important;
		}
    </style>
</head>

<body>
	<% Post post = (Post)request.getAttribute("post");  %>
	<jsp:include page="../shared/header.jsp" flush="true" />
	
    <div class="main pt-[120px]">
        <form action="/posts/update" method="POST" class="form" id="form_add-problem" enctype="multipart/form-data">
            <h1 class="heading">Cập nhật bài viết</h1>
            <div class="spacer"></div>
            <% if (request.getParameter("error") != null) { %>
	        	<div class="alert alert-danger text-center text-[16px]" role="alert">
			  		<%= request.getParameter("error") %>
				</div>
			<% } %>
			<% if (request.getAttribute("success") != null) { %>
	        	<div class="alert alert-success text-center text-[16px]" role="alert">
			  		<%= request.getAttribute("success") %>
				</div>
			<% } %>
			<% if (request.getParameter("success") != null) { %>
	        	<div class="alert alert-success text-center text-[16px]" role="alert">
			  		<%= request.getParameter("success") %>
				</div>
			<% } %>
			 <div class="form-group">
                <label for="id" class="form-label">ID bài viết</label>
                <input id="id" name="id" type="text" class="form-control" value="<%= post.getID()%>" readonly>
                <span class="form-message"></span>
            </div>
            
            <div class="form-group">
                <label for="title" class="form-label">Tiêu đề bài viết</label>
                <input id="title" name="title" type="text" placeholder="Nhập tên bài tập" class="form-control" value="<%= post.getName()%>">
                <span class="form-message"></span>
            </div>
            
            <div class="form-group">
                	<img src="<%= post.getImage() %>"
                         alt="" class="img-fluid rounded img-thumbnail" id="image">
                    <label class="custom-file-upload mt-3">
                    	<input id="inputImage" type="file" name="image" value = "<%= post.getImage() %>"/>
                    	Chọn hình ảnh
                    </label>
                    <span class="form-message"></span>
            </div>

            <div class="form-group">
                <label for="tag" class="form-label">Thể loại</label>
                <select id="tag" name="tag" class="form-control">
                	<% ArrayList<Tag> tags = (ArrayList<Tag>)request.getAttribute("tags"); %>
                    <option value="">Chọn thể loại</option>
                    <% for (Tag tag: tags) { %>
                    	<option value="<%=tag.getID()%>" <%= post.getTagID().equals(tag.getID()) ? "selected" : ""%> > <%= tag.getName() %></option>
                    <% } %>
                </select>
                <span class="form-message"></span>
            </div>

            <div class="form-group">
                <label for="content" class="form-label">Nội dung bài viết</label>
                <textarea name="content" id="editor1" cols="" rows="3" class="form-control-text"><%= post.getContent() %></textarea>
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
                <button class="form-submit" type="submit">Cập nhật bài viết</button>
                 <% AuthContext context = new AuthContext(request);
        	if (context.isInRole("ADMIN")) {
        %>
	        <% if (post.getState().equals("Đang chờ duyệt")) { %>
	        	<form method="POST" action="/posts/publish">
	         		<input type="hidden" value="<%= post.getID()%>" name="id"/>
	               	<button class="form-submit" type="submit">Duyệt bài viết</button>
	           	</form>
	           	<form method="POST" action="/posts/ban">
	         		<input type="hidden" value="<%= post.getID()%>" name="id"/>
	               	<button class="form-submit" type="submit">Cấm bài viết</button>
	           	</form>
	       	<% } else if (post.getState().equals("Đang phát hành")) {%>
				<form method="POST" action="/posts/ban">
	         		<input type="hidden" value="<%= post.getID()%>" name="id"/>
	               	<button class="form-submit" type="submit">Cấm bài viết</button>
	           	</form>
	        <% } else { %>
	            <form method="POST" action="/posts/publish">
	         		<input type="hidden" value="<%= post.getID()%>" name="id"/>
	               	<button class="form-submit" type="submit">Ngừng cấm bài viết</button>
	           	</form>
	        <% } %>
        <% } %>
    </div>
            </div>
        </form>
       
</body>
<script src="../../public/lib/ckeditor/ckeditor.js"></script>
<script src="../../public/js/validation.js"></script>
<script src="../../public/js/post_insert.js"></script>
<script>

</script>
</html>