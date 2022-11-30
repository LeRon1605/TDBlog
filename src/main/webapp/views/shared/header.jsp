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
</head>
<body>
	<div id="header" class="shadow-xl fixed w-screen bg-[#fff] z-20">
        <div class="grid wide">
            <div class="header__news flex justify-between h-20 items-center ">
                <div class="header__news-info flex">
                    <a href=""><img src="https://spiderum.com/assets/icons/wideLogo.png" alt=""
                            class="header_news-logo w-40 px-3 border-r border-solid"></a>
                    <div class="header__news-network flex justify-between">
                        <a href="https://www.facebook.com/tn.9.3.02/" target="_blank"><i class="fa-brands fa-facebook-f text-xl text-[#606266] px-3 mt-1"></i></a>
                        <a href="https://www.facebook.com/le.ron.399" target="_blank"><i class="fa-brands fa-instagram text-xl text-[#606266] px-3 mt-1"></i></a>
                        <a href="https://www.facebook.com/duyquang.tran.50309" target="_blank"><i class="fa-brands fa-linkedin-in text-xl text-[#606266] px-3 mt-1"></i></a>
                    </div>
                </div>
                <div class="header__news-action flex items-center">
                    <form action="" class="container__body-form-search relative">
                        <input type="text"
                            class="container__body-form-input  border-2 border-solid w-60 rounded-3xl h-10 inline-block pl-4 pb-1 drop-shadow-lg"
                            placeholder="Tìm kiếm">
                        <button type="submit"><i class="fa-solid fa-magnifying-glass absolute right-5 top-3"></i></button>
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

                    <div class="header__news-non-action flex relative ">
                        <a href="/posts/insert" class="px-6 border border-solid border-[#e3e3e3] rounded-3xl bg-[#fff] font-normal mx-5 flex items-center">
                            <i class="fa-solid fa-pen-nib mr-1"></i>
                            <span>Viết bài</span>
                        </a>
                        <div class="header__news-user">
                            <img src="https://spiderum.com/banner_ipad.39cef009ae5fb6ad90c9.png" alt="" class="w-12 h-12 rounded-full cursor-pointer">
                            <div
                                class="header__news-subUser absolute bg-[#fff] w-[300px] right-0 top-16 shadow-lg shadow-gray-600 rounded-sm hidden">
                                <div class="header__news-subUser-heading flex items-center p-3">
                                    <img src="https://spiderum.com/banner_ipad.39cef009ae5fb6ad90c9.png" alt="" class="header__news-subUser-img h-12 w-12 mr-4 rounded-full">
                                    <div class="header__news-subUser-info w-48">
                                        <a href="" class="header__news-subUser-name block ">Tấn Năng</a>
                                        <a href="" class="header__news-subUser-email block">tannang09032002@gmail</a>
                                    </div>
                                </div>
                                <div class="header__news-subUser-container border-y border-solid border-gray-300 my-2">
                                    <div class="header__news-subUser-item p-3 hover:bg-gray-300 mx-2 mt-2">
                                        <i class="fa-solid fa-pen-to-square text-[#161616] w-5"></i>
                                        <a href="" class="header__news-subUser-text text-[#161616]">Bài viết của tôi</a>
                                    </div>
                                    <div class="header__news-subUser-item p-3 hover:bg-gray-300 mx-2">
                                        <i class="fa-regular fa-bookmark text-[#161616] w-5"></i>
                                        <a href="" class="header__news-subUser-text text-[#161616]">Nháp của tôi</a>
                                    </div>
                                    <div class="header__news-subUser-item p-3 hover:bg-gray-300 mx-2 mb-2">
                                        <i class="fa-solid fa-gear text-[#161616] w-5"></i>
                                        <a href="" class="header__news-subUser-text text-[#161616]">Tùy chỉnh tài
                                            khoản</a>
                                    </div>
                                </div>
                                <div class="header__news-subUser-footing">
                                    <div class="header__news-subUser-item p-3 hover:bg-gray-300 mx-2 mb-2">
                                        <i class="fa-solid fa-arrow-right-from-bracket text-[#161616] w-5"></i>
                                        <a href="" class="header__news-subUser-text text-[#161616]">Đăng xuất</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>