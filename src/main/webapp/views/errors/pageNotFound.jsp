<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang bạn đang tìm kiếm không tồn tại</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400&display=swap" rel="stylesheet">
    <script src="https://unpkg.com/@lottiefiles/lottie-player@latest/dist/lottie-player.js"></script>
    <style>
        * {
            border: 0;
            padding: 0;
            margin: 0
        }
        body {
            width: 100vw;
            height: 100vh;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            font-family: 'Roboto', sans-serif;
        }
        .heading__title {
            font-size: 50px;
        }
        .heading__description {
            font-size: 20px;
            margin-top: 10px;
            font-weight: 300;
            color: #918587;
        }
        .heading__direction {
            text-decoration: none;
            padding: 10px 15px;
            color: white;
            margin-top: 10px;
            background-color: #039D91;
            font-size: 20px;
            cursor: pointer;
            border-radius: 10px;
            display: flex;
            align-items: center;
            justify-content: space-around;
            box-shadow: rgba(0, 0, 0, 0.16) 0px 10px 36px 0px, rgba(0, 0, 0, 0.06) 0px 0px 0px 1px;
        }
        .heading__direction span {
            margin-left: 7px
        }
    </style>
</head>
<body>
    <lottie-player src="https://assets1.lottiefiles.com/packages/lf20_aN06YJCbME.json"  background="transparent"  speed="1"  style="width: 500px; height: 500px;"  loop autoplay></lottie-player>    
    <h1 class="heading__title">
        404 - PAGE NOT FOUND
    </h1>
    <p class="heading__description">
        Trang bạn đang tìm kiếm đã có thể bị xóa hoặc đang được bảo trì.
    </p>
    <a class="heading__direction" href="/home">
        <i class="fa-solid fa-arrow-left"></i>
        <span>Quay về trang chủ</span>
    </a>
</body>
</html>