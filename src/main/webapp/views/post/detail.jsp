<%@page import="models.Bean.Post"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.tailwindcss.com"></script>
<link rel="stylesheet" href ="../../public/css/action.css">
<link rel="stylesheet" href ="../../public/css/grid.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
        href="https://fonts.googleapis.com/css2?family=Noto+Sans:wght@200;300;400;500;600;700;800&family=Qwigley&display=swap"
        rel="stylesheet">
</head>
<body>
	<div id="header" class="shadow-xl fixed w-screen bg-[#fff] z-20">
		<div class="grid wide">
			<div class="header__news flex justify-between h-20 items-center ">
				<div class="header__news-info flex">
					<a href=""><img src="./assets/img/wideLogo.png" alt=""
						class="header_news-logo w-40 px-3 border-r border-solid"></a>
					<div class="header__news-network flex justify-between">
						<a href="#!"><i
							class="fa-brands fa-facebook-f text-xl text-[#606266] px-3 mt-1"></i></a>
						<a href="#!"><i
							class="fa-brands fa-instagram text-xl text-[#606266] px-3 mt-1"></i></a>
						<a href="#!"><i
							class="fa-brands fa-linkedin-in text-xl text-[#606266] px-3 mt-1"></i></a>
					</div>
				</div>
				<div class="header__news-action flex items-center">
					<form action="" class="container__body-form-search relative">
						<input type="text"
							class="container__body-form-input  border-2 border-solid w-60 rounded-3xl h-10 inline-block pl-4 pb-1 drop-shadow-lg"
							placeholder="Tìm kiếm"> <i
							class="fa-solid fa-magnifying-glass absolute right-5 top-3"></i>
					</form>

					<!-- <div class="header__news-action">
                        <div class="header__news-register mr-5">
                            <a href="" class="header__news-text px-6 py-2 text-base">Đăng ký</a>
                        </div>
                        <div class="header__news-login">
                            <a href=""
                                class="header__news-text px-6 text-base py-2 text-[#fff] bg-[#3398d4] rounded-3xl hover:bg-[#2e89bf]">Đăng
                                nhập</a>
                        </div>
                    </div> -->

					<div class="header__news-non-action flex relative">
						<button
							class="px-6 border border-solid border-[#e3e3e3] rounded-3xl bg-[#fff] font-normal mx-5">
							<i class="fa-solid fa-pen-nib"></i> <span>Viết bài</span>
						</button>
						<div class="header__news-user">
							<img src="./assets/img/banner_ipad.39cef009ae5fb6ad90c9.png"
								alt="" class="w-12 h-12 rounded-full cursor-pointer">
							<div
								class="header__news-subUser absolute bg-[#fff] w-[300px] right-0 top-16 shadow-lg shadow-gray-600 rounded-sm hidden">
								<div class="header__news-subUser-heading flex m-3 items-center">
									<img src="./assets/img/banner_ipad.39cef009ae5fb6ad90c9.png "
										alt=""
										class="header__news-subUser-img h-12 w-12 mr-4 rounded-full">
									<div class="header__news-subUser-info w-48">
										<a href="" class="header__news-subUser-name block ">Tấn
											Năng</a> <a href="" class="header__news-subUser-email block">tannang09032002@gmail</a>
									</div>
								</div>
								<div
									class="header__news-subUser-container border-y border-solid border-gray-300 my-2">
									<div
										class="header__news-subUser-item p-3 hover:bg-gray-300 border-2 mx-2 mt-2">
										<i class="fa-solid fa-pen-to-square text-[#161616] w-5"></i> <a
											href="" class="header__news-subUser-text text-[#161616]">Bài
											viết của tôi</a>
									</div>
									<div
										class="header__news-subUser-item p-3 hover:bg-gray-300 border-2 mx-2">
										<i class="fa-regular fa-bookmark text-[#161616] w-5"></i> <a
											href="" class="header__news-subUser-text text-[#161616]">Nháp
											của tôi</a>
									</div>
									<div
										class="header__news-subUser-item p-3 hover:bg-gray-300 border-2 mx-2 mb-2">
										<i class="fa-solid fa-gear text-[#161616] w-5"></i> <a href=""
											class="header__news-subUser-text text-[#161616]">Tùy
											chỉnh tài khoản</a>
									</div>
								</div>
								<div class="header__news-subUser-footing">
									<div
										class="header__news-subUser-item p-3 hover:bg-gray-300 border-2 mx-2 mb-2">
										<i
											class="fa-solid fa-arrow-right-from-bracket text-[#161616] w-5"></i>
										<a href="" class="header__news-subUser-text text-[#161616]">Đăng
											xuất</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<% Post post = (Post)request.getAttribute("post"); %>
	<div class="container pt-[200px] ">
		<div class="grid wide">
			<div class="row">
				<div class="col c-2">
					<div class="container_action fixed mx-[60px] mt-[60px]">
						<div
							class="container_action-item flex justify-center flex-col items-center">
							<div class="container_action-owned ">
								<a href="" class="inline-block"> <img
									src="https://scontent.fdad3-5.fna.fbcdn.net/v/t39.30808-6/298467402_1682444885468096_2322540793488187084_n.jpg?_nc_cat=106&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=qi8TvLyLlpwAX_YJE35&_nc_ht=scontent.fdad3-5.fna&oh=00_AfCIMmuAFWoV0tjLJTWv_ACFF0aiXmt8krtPs6V336yzCw&oe=638996FC" alt=""
									class="container_action-owned-image w-16 h-16 rounded-full">
								</a>
							</div>
							<i class="fa-regular fa-thumbs-up text-[30px] mt-[20px]"></i>
						</div>

					</div>
				</div>

				<div class="col c-8">
					<div class="container__content">
						<div class="container__content-heading mb-10">
							<a href="#"
								class="container__content-type text-[#888096] text-[16px] hover:underline decoration-1 mb-3 inline-block">Quan
								điểm - Tranh luận</a>
							<h1
								class="container__content-title text-[42px] font-semibold leading-[64px] mb-2"><%= post.getName() %></h1>
							<div class="container__content-owned ">
								<a href="" class="inline-block flex items-center"> <img
									src="https://scontent.fdad3-5.fna.fbcdn.net/v/t39.30808-6/298467402_1682444885468096_2322540793488187084_n.jpg?_nc_cat=106&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=qi8TvLyLlpwAX_YJE35&_nc_ht=scontent.fdad3-5.fna&oh=00_AfCIMmuAFWoV0tjLJTWv_ACFF0aiXmt8krtPs6V336yzCw&oe=638996FC" alt=""
									class="container__content-owned-image w-16 h-16 rounded-full mr-4">
									<p class="container__content-owned-name text-[18px]"><%= post.getAuthor() %></p>
								</a>
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

	<div id="footer" class="h-80"></div>
</body>
</html>