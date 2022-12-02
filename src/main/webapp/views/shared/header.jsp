<%@page import="core.Auth.AuthContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans:wght@200;300;400;500;600;700;800&family=Qwigley&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="../../public/css/grid.css">
    <link rel="stylesheet" href="../../public/css/action.css">
    <link rel="stylesheet" href="../../public/css/reset.css">
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
</head>
<body>	
	<div id="header" class="shadow-xl fixed w-screen bg-[#fff] z-20 mx-[-12px]">
        <div class="grid wide">
            <div class="header__news flex justify-between h-20 items-center ">
                <div class="header__news-info flex items-center">
                    <a href="/home" class="flex border-r border-solid pr-3 font-semibold text-[18px] hover:text-[#000]"><img src="../../public/images/TD.png" alt=""
                            class="header_news-logo w-12 pr-3 "> TDBlog</a>
                    <div class="header__news-network flex justify-between">
                        <a href="https://www.facebook.com/tn.9.3.02/" target="_blank"><i class="fa-brands fa-facebook-f text-xl text-[#606266] px-3 mt-1"></i></a>
                        <a href="https://www.facebook.com/le.ron.399" target="_blank"><i class="fa-brands fa-instagram text-xl text-[#606266] px-3 mt-1"></i></a>
                        <a href="https://www.facebook.com/duyquang.tran.50309" target="_blank"><i class="fa-brands fa-linkedin-in text-xl text-[#606266] px-3 mt-1"></i></a>
                    </div>
                </div>
                <div class="header__news-action flex items-center">
                    <form action="/home" class="container__body-form-search relative">
                        <input type="text"
                            class="container__body-form-input  border-2 border-solid w-60 rounded-3xl h-10 inline-block pl-4 pb-1"
                            placeholder="Tìm kiếm" name="keyword">
                        <button type="submit"><i class="fa-solid fa-magnifying-glass absolute right-5 top-3"></i></button>
                    </form>
                    
                    <div class="header__news-non-action flex relative ">
                        <a href="/posts/insert" class="px-6 py-2 border border-solid border-[#e3e3e3] rounded-3xl bg-[#fff] font-normal mx-5 flex items-center p">
                            <i class="fa-solid fa-pen-nib mr-1"></i>
                            <span>Viết bài</span>
                        </a>
                    </div>
					
					<% AuthContext context = new AuthContext(request); %>
					<% if (context.isAuthenticated()) { %>
						<div class="header__news-user relative">
                            <img src="<%= context.getClaim("Avatar").getValue() %>" alt="" class="w-12 h-12 rounded-full cursor-pointer">
                            
                            
                            <div class="header__news-subUser absolute bg-[#fff] w-[300px] right-0 top-16 shadow-lg shadow-gray-600 rounded-sm hidden">
                                <div class="header__news-subUser-heading flex items-center p-3">
                                    <img src="<%= context.getClaim("Avatar").getValue() %>" alt="" class="header__news-subUser-img h-12 w-12 mr-4 rounded-full">
                                    <div class="header__news-subUser-info w-48">
                                        <a href="" class="header__news-subUser-name block "><%= context.getClaim("Username").getValue() %></a>
                                        <a href="" class="header__news-subUser-email block"><%= context.getClaim("Fullname").getValue() %></a>
                                    </div>
                                </div>
                                <div class="header__news-subUser-container border-y border-solid border-gray-300 my-2">
                                    <% if (context.isInRole("ADMIN")) { %>
                                    	<div class="header__news-subUser-item p-3 hover:bg-gray-300 mx-2">
                                        	<i class="fa-regular fa-bookmark text-[#161616] w-5"></i>
                                        	<a href="/admin" class="header__news-subUser-text text-[#161616]">Quản lí</a>
                                   	 	</div>
                                    <% } %>
                                    <div class="header__news-subUser-item p-3 hover:bg-gray-300 mx-2 mt-2">
                                        <i class="fa-solid fa-pen-to-square text-[#161616] w-5"></i>
                                        <a href="/me/posts" class="header__news-subUser-text text-[#161616]">Bài viết của tôi</a>
                                    </div>
                                </div>
                                <div class="header__news-subUser-footing">
                                    <div class="header__news-subUser-item p-3 hover:bg-gray-300 mx-2 mb-2">
                                        <i class="fa-solid fa-arrow-right-from-bracket text-[#161616] w-5"></i>
                                        <a href="/auth/logout" class="header__news-subUser-text text-[#161616]">Đăng xuất</a>
                                    </div>
                                </div>
                            </div>
                        </div>
					<% } else { %>
						<div class="header__news-action flex">
	                        <div class="header__news-register mr-5">
	                            <a href="/auth/register" class="header__news-text px-6 py-2 text-base">Đăng ký</a>
	                        </div>
	                        <div class="header__news-login">
	                            <a href="/auth/login"
	                                class="header__news-text px-6 text-base py-2 text-[#fff] bg-[#3398d4] rounded-3xl hover:bg-[#2e89bf]">Đăng
	                                nhập</a>
	                        </div>
	                    </div>
					<% } %>
                </div>
            </div>
        </div>
    </div>
</body>
</html>