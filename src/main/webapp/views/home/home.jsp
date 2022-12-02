<%@page import="models.Bean.Post"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link rel="stylesheet" href="../../public/css/grid.css">
    <link rel="stylesheet" href="../../public/css/action.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans:wght@200;300;400;500;600;700;800&family=Qwigley&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../../public/css/reset.css">
</head>

<body>
	<jsp:include page="../shared/header.jsp" flush="true" />
    <!-- Body -->
    <div class="container__background h-[600px] w-full-base bg-cover bg-right-top"
        style="background-image: url('https://spiderum.com/banner_ipad.39cef009ae5fb6ad90c9.png')">
        <div class="container__bg-sup absolute left-[160px] top-36 font-bold">
            <h1 class="container__bg-heading text-[56px] mb-4 max-w-2xl">Góc nhìn đa chiều của thế hệ trẻ Việt Nam</h1>
            <h2 class="container__bg-detail text-[30px] max-w-2xl font-medium mb-4 text-[#161616]">
            	Viết - Chia sẻ - Kết nối - Chiêm nghiệm - Tất cả tại Spiderum
           	</h2>
           	<a href="/posts/insert" class="px-6 py-2 border border-solid border-[#333] rounded-3xl bg-[#fff] font-normal hover:cursor-pointer">Đăng bài viết</a>
          
        </div>
    </div>

    <div class="container__content">
            <div class="grid wide">
                <div class="container__header">
                    <div class="container__header-tilte my-10">
                        <span class="container__header-tilte-text text-xl border-b-[3px] border-[#3398d4] py-2">BÀI VIẾT MỚI</span>
                    </div>
                    <div class="row">
                    <%
	                	ArrayList<Post> posts = (ArrayList<Post>)request.getAttribute("posts");
                    	ArrayList<Post> lastedPosts = (ArrayList<Post>)request.getAttribute("lastedPosts");
	                	for (int i = 0;i < lastedPosts.size();i++) {
	                %>	
                        <div class="col c-6">
                            <div class="container__header-part mb-10">
                                <div class="row">
                                    <div class="container_header-item flex w-full">
                                        <div class="col c-5">
                                            <div class="container__header-item-img  ">
                                                <img src="<%= lastedPosts.get(i).getImage() %>" alt="" class="w-full mr-5 rounded-md max-h-40 object-cover">
                                            </div>
                                        </div>
                                        <div class="col c-7">
                                            <div class="container__header-item-content w-full justify-between">
                                                <div class="container__header-item-heading flex justify-between">
                                                	<a href="#!" class="container__header-item-heading inline-block text-xs"><%= lastedPosts.get(i).getTag() %></a>
                                                	<p class="text-[12px]"><%= lastedPosts.get(i).getTotalTime()%> phút</p>
                                                </div>
                                                <a href="/posts?id=<%= lastedPosts.get(i).getID() %>" class="container__header-item-title inline-block text-base font-medium my-1"><%= lastedPosts.get(i).getName() %></a>
                                                <span class="container__header-item-desc text-xs max-h-5"><%= lastedPosts.get(i).getContent() %></span>
                                                <div class="container__header-item-bottom flex justify-between items-center mt-2">
                                                    <div class="container__header-item-owner flex items-center">
                                                        <img src="<%= lastedPosts.get(i).getAuthorAvatar() %>" alt="" class="item__owner-img w-10 h-10 rounded-full mr-4 ">
                                                        <a href="" class="item__owner-name text-[16px]"><%= lastedPosts.get(i).getAuthor() %></a>
                                                    </div>
                                                    <div class="container__header-item-view">
                                                        <span class="container__header-item-view-amount text-[12px]"><%= lastedPosts.get(i).getViewCount() %></span>
                                                        <span class="container__header-item-view-sup text-[12px]">lượt xem</span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    <%
	                	}
	               	%>
                    </div>
                </div>

                <div class="container__body">
                    <div class="container__body-tilte my-10">
                        <span class="container__body-tilte-text text-xl py-2 border-b-[3px] border-[#3398d4]">BÀI VIẾT</span>
                    </div>
                    <div class="row">
                    <% if (posts.size() == 0) { %>
                    	<h1 style="padding-left: 12px">Không có bài viết nào được tìm thấy</h1>
                    <% } %>
                    <%
	                	for (int i = 0;i < posts.size();i++) {
	                %>	
                        <div class="col c-6">
                            <div class="container__body-part mb-10">
                                <div class="row">
                                    <div class="container__body-item flex w-full">
                                        <div class="col c-5">
                                            <div class="container__body-item-img  ">
                                                <img src="<%= posts.get(i).getImage() %>" alt="" class="w-full mr-5 rounded-md max-h-40 object-cover">
                                            </div>
                                        </div>
                                        <div class="col c-7">
                                            <div class="container__body-item-content w-full justify-between ">
                                                <div class="container__body-item-heading flex justify-between">
                                                	<a href="" class="container__body-item-heading inline-block text-xs"><%= posts.get(i).getTag() %></a>
                                                	<p class="text-[12px]"><%= posts.get(i).getTotalTime()%> phút</p>
                                                </div>
                                                <a href="/posts?id=<%= posts.get(i).getID() %>" class="container__body-item-title inline-block text-base font-medium my-1"><%= posts.get(i).getName() %></a>
                                                <span class="container__body-item-desc text-xs max-h-5"><%= posts.get(i).getContent() %></span>
                                                <div class="container__body-item-bottom flex justify-between items-center mt-2">
                                                    <div class="container__body-item-owner flex items-center">
                                                        <img src="<%= posts.get(i).getAuthorAvatar() %>" alt="" class="item__owner-img w-10 h-10 rounded-full mr-4 ">
                                                        <a href="" class="item__owner-name text-[16px]"><%= posts.get(i).getAuthor() %></a>
                                                    </div>
                                                    <div class="container__body-item-view">
                                                        <span class="container__body-item-view-amount text-[12px]"><%= posts.get(i).getViewCount() %></span>
                                                        <span class="container__body-item-view-sup text-[12px]">lượt xem</span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    <%
	                	}
	                %>	             
                    </div>
                </div>
            </div>
        </div>
    <div id="footer" class="h-80">
    </div>

</body>

</html>