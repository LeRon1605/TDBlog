<%@page import="models.Bean.Post"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<% Post post = (Post)request.getAttribute("post"); %>
<title><%= post.getName() %></title>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans:wght@200;300;400;500;600;700;800&family=Qwigley&display=swap" rel="stylesheet">
<link rel="stylesheet" href ="../../public/css/action.css">
<link rel="stylesheet" href ="../../public/css/grid.css">
<link rel="stylesheet" href ="../../public/css/reset.css">
<link rel="stylesheet" href ="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
<style>
   p {
	   margin: 20px 0 !important;
   }
</style>
</head>
<body>
	<jsp:include page="../shared/header.jsp" flush="true" />
	<div class="pt-28">
	<div class="container grid wide ">
		<div class="">
			<div class="row">
				<div class="col c-2">
					<div class="container_action fixed mx-[60px] mb-[60px] flex flex-col justify-center h-screen">
						<div
							class="container_action-item flex justify-center flex-col items-center">
							<i class="fa-solid fa-caret-up text-[30px] mb-[20px]"></i>
							<div class="container_action-owned ">
								<a href="" class="inline-block"> 
									<img src="https://spiderum.com/banner_ipad.39cef009ae5fb6ad90c9.png" alt="" class="container_action-owned-image w-16 h-16 rounded-full">
								</a>
							</div>
							<i class="fa-solid fa-caret-down text-[30px] mt-[20px]"></i>
						</div>
					</div>
				</div>

				<div class="col c-8">
					<div class="container__content">
						<div class="container__content-heading mb-10">
							<a href="#!" class="container__content-type text-[#888096] text-[16px] hover:underline decoration-1 mb-3 inline-block"><%=post.getTag() %></a>
							<h1
								class="container__content-title text-[42px] font-semibold leading-[64px] mb-2"><%= post.getName() %></h1>
							<div class="container__content-owned ">
								<img src="<%= post.getImage() %>" alt="" class="container_action-owned-image w-16 h-16">
							</div>
						</div>
						<div class="container__content-body">
							<div
								class="container__content-body-text text-[18px] leading-[28px]">
								<%= post.getContent()%>
							</div>
						</div>
					</div>
				</div>
				<div class="col c-2">
					<div class="container__disable"></div>
				</div>
			</div>
		</div>
	</div>
	</div>
</body>
</html>