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
        <div class="container__bg-sup absolute left-[250px] top-36 font-bold">
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
                    <div class="container__header-tilte my-5">
                        <span class="container__header-tilte-text text-xl">PHỔ BIẾN TRÊN SPIDERUM</span>
                    </div>
                    <div class="row">
                    <%
	                	ArrayList<Post> posts = (ArrayList<Post>)request.getAttribute("posts");
	                	for (int i = 0;i < posts.size();i++) {
	                %>	
                        <div class="col c-6">
                            <div class="container__header-part mb-10">
                                <div class="row">
                                    <div class="container_header-item flex w-full">
                                        <div class="col c-5">
                                            <div class="container__header-item-img  ">
                                                <img src="<%= posts.get(i).getImage() %>" alt="" class="w-full mr-5 rounded-md">
                                            </div>
                                        </div>
                                        <div class="col c-7">
                                            <div class="container__header-item-content w-full justify-between ">
                                                <a href="" class="container__header-item-heading inline-block text-xs"><%= posts.get(i).getTag() %></a>
                                                <a href="/posts?id=<%= posts.get(i).getID() %>" class="container__header-item-title inline-block text-base font-medium my-1"><%= posts.get(i).getName() %></a>
                                                <span class="container__header-item-desc text-xs max-h-5"><%= posts.get(i).getContent() %></span>
                                                <div class="container__header-item-bottom flex justify-between items-end mt-2">
                                                    <div class="container__header-item-owner flex items-end">
                                                        <img src="https://spiderum.com/banner_ipad.39cef009ae5fb6ad90c9.png" alt="" class="item__owner-img w-10 h-10 rounded-full mr-4 ">
                                                        <a href="" class="item__owner-name text-[16px]"><%= posts.get(i).getAuthor() %></a>
                                                    </div>
                                                    <div class="container__header-item-view">
                                                        <span class="container__header-item-view-amount text-[12px]"><%= posts.get(i).getViewCount() %></span>
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
                    <%
	                	for (int i = 0;i < posts.size();i++) {
	                %>	
                        <div class="col c-6">
                            <div class="container__body-part mb-10">
                                <div class="row">
                                    <div class="container__body-item flex w-full">
                                        <div class="col c-5">
                                            <div class="container__body-item-img  ">
                                                <img src="<%= posts.get(i).getImage() %>" alt="" class="w-full mr-5 rounded-md">
                                            </div>
                                        </div>
                                        <div class="col c-7">
                                            <div class="container__body-item-content w-full justify-between ">
                                                <a href="" class="container__body-item-heading inline-block text-xs"><%= posts.get(i).getTag() %></a>
                                                <a href="/posts?id=<%= posts.get(i).getID() %>" class="container__body-item-title inline-block text-base font-medium my-1"><%= posts.get(i).getName() %></a>
                                                <span class="container__body-item-desc text-xs max-h-5"><%= posts.get(i).getContent() %></span>
                                                <div class="container__body-item-bottom flex justify-between items-end mt-2">
                                                    <div class="container__body-item-owner flex items-end">
                                                        <img src="https://spiderum.com/banner_ipad.39cef009ae5fb6ad90c9.png" alt="" class="item__owner-img w-10 h-10 rounded-full mr-4 ">
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
                    <nav class="isolate inline-flex -space-x-px rounded-md shadow-sm flex justify-center w-full"
                        aria-label="Pagination">
                        <a href="#"
                            class="relative inline-flex items-center rounded-l-md border border-gray-300 bg-white px-2 py-2 text-sm font-medium text-gray-500 hover:bg-gray-50 focus:z-20">
                            <span class="sr-only">Previous</span>
                            <svg class="h-5 w-5" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20"
                                fill="currentColor" aria-hidden="true">
                                <path fill-rule="evenodd"
                                    d="M12.79 5.23a.75.75 0 01-.02 1.06L8.832 10l3.938 3.71a.75.75 0 11-1.04 1.08l-4.5-4.25a.75.75 0 010-1.08l4.5-4.25a.75.75 0 011.06.02z"
                                    clip-rule="evenodd" />
                            </svg>
                        </a>
                        <a href="#" aria-current="page"
                            class="relative z-10 inline-flex items-center border border-indigo-500 bg-indigo-50 px-4 py-2 text-sm font-medium text-indigo-600 focus:z-20">1</a>
                        <a href="#"
                            class="relative inline-flex items-center border border-gray-300 bg-white px-4 py-2 text-sm font-medium text-gray-500 hover:bg-gray-50 focus:z-20">2</a>
                        <a href="#"
                            class="relative hidden items-center border border-gray-300 bg-white px-4 py-2 text-sm font-medium text-gray-500 hover:bg-gray-50 focus:z-20 md:inline-flex">3</a>
                        <span
                            class="relative inline-flex items-center border border-gray-300 bg-white px-4 py-2 text-sm font-medium text-gray-700">...</span>
                        <a href="#"
                            class="relative hidden items-center border border-gray-300 bg-white px-4 py-2 text-sm font-medium text-gray-500 hover:bg-gray-50 focus:z-20 md:inline-flex">8</a>
                        <a href="#"
                            class="relative inline-flex items-center border border-gray-300 bg-white px-4 py-2 text-sm font-medium text-gray-500 hover:bg-gray-50 focus:z-20">9</a>
                        <a href="#"
                            class="relative inline-flex items-center border border-gray-300 bg-white px-4 py-2 text-sm font-medium text-gray-500 hover:bg-gray-50 focus:z-20">10</a>
                        <a href="#"
                            class="relative inline-flex items-center rounded-r-md border border-gray-300 bg-white px-2 py-2 text-sm font-medium text-gray-500 hover:bg-gray-50 focus:z-20">
                            <span class="sr-only">Next</span>
                            <svg class="h-5 w-5" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20"
                                fill="currentColor" aria-hidden="true">
                                <path fill-rule="evenodd"
                                    d="M7.21 14.77a.75.75 0 01.02-1.06L11.168 10 7.23 6.29a.75.75 0 111.04-1.08l4.5 4.25a.75.75 0 010 1.08l-4.5 4.25a.75.75 0 01-1.06-.02z"
                                    clip-rule="evenodd" />
                            </svg>
                        </a>
                    </nav>
                </div>
            </div>
        </div>
    <div id="footer" class="h-80">
    </div>

</body>

</html>