<%@page import="models.Bean.Post" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Bài viết của tôi</title>
    <link href="../../public/css/grid.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/css/nice-select.min.css"
        integrity="sha512-CruCP+TD3yXzlvvijET8wV5WxxEh5H8P4cmz0RFbKK6FlZ2sYl3AEsKlLPHbniXKSrDdFewhbmBK5skbdsASbQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <style>
    	input {
		    width: 20rem;
		    border: 1px solid #E5E5E5;
		    outline: none;
		    transition: .5s;
		    border-radius: 100px;
		}
		
		input:focus {
		    border: 1px solid #2FB5FA;
		}
		
		.block-search {
		    position: absolute;
		    right: 0;
		    transform: translateY(-100%);
		    z-index: 10;
		}
		
		th {
			min-width: 100px;
		}
    </style>
</head>

<body>
	<jsp:include page="../shared/header.jsp" flush="true" />
	
    <div class="container pt-[100px]">
    	<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h1 class="modal-title fs-5" id="exampleModalLabel">Thông báo</h1>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		       	Bạn có chắc chắn muốn xóa bài viết này?
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-primary bg-primary" data-bs-dismiss="modal">Trở lại</button>
		        <button type="button" class="btn btn-danger bg-danger" id="btnSubmit">Xóa</button>
		      </div>
		    </div>
		  </div>
		</div>
        <div class="grid wide">
        	<div class="bg-light p-4 mt-5 rounded">
		            <table class="table table-bordered caption-top">
		                <caption class="main-color position-relative">
		                    <b>Danh sách bài viết</b>
		                    <a class="ms-3 text-decoration-none btn-add" href="/posts/insert">
		                        Thêm bài viết
		                    </a>
		                    <form class="block-search d-flex" action="/me/posts" method="GET">
		                        <div class="d-flex">
		                            <% String sortBy=(String)request.getParameter("sortBy"); %>
		                                <select id="select" name="sortBy">
		                                    <option value="" <% if (sortBy==null || sortBy.isEmpty()) { out.print("selected");
		                                        }%>>Sắp
		                                        xếp</option>
		                                    <option value="name" <% if (sortBy !=null && sortBy.equals("name")) {
		                                        out.print("selected"); }%>
		                                        >Tên bài viết</option>
		                                    <option value="view" <% if (sortBy !=null && sortBy.equals("view")) {
		                                        out.print("selected"); }%>
		                                        >Lượt xem</option>
		                                </select>
		                             <% String state=(String)request.getParameter("state"); %>
                                    <select id="select" class="ms-3" name="state">
                                        <option value="-1" <% if (state==null || state.isEmpty()) {
                                            out.print("selected"); }%>
                                            >Trạng thái</option>
                                        <option value="0" <% if (state !=null && state.equals("0")) {
                                            out.print("selected"); }%>
                                            >Đang chờ duyệt</option>
                                        <option value="1" <% if (state !=null && state.equals("1")) {
                                            out.print("selected"); } %>
                                            >Đang phát hành</option>
                                        <option value="2" <% if (state !=null && state.equals("2")) {
                                            out.print("selected"); } %>
                                            >Đã cấm</option>
                                    </select>
		                        </div>
		                        <% String keyword=request.getParameter("keyword")==null ? "" :
		                            (String)request.getParameter("keyword"); %>
		                            <input placeholder="Nhập từ khóa tìm kiếm" class="ms-3 p-2" value="<%= keyword %>"
		                                name="keyword" />
		                            <button class="ms-2 btn btn-primary">Tìm kiếm</button>
		                    </form>
		                </caption>
		                <thead class="table-white">
		                    <tr>
		                        <th scope="col">STT</th>
		                        <th scope="col">Mã bài viết</th>
		                        <th scope="col">Tên bài viết</th>
		                        <th scope="col">Thể loại</th>
		                        <th scope="col">Trạng thái</th>
		                        <th scope="col">Lượt xem</th>
		                        <th scope="col">Hành động</th>
		                    </tr>
		                </thead>
		                <tbody>
		                    <% ArrayList<Post> posts = (ArrayList<Post>)request.getAttribute("posts");
		                            for (int i = 0;i < posts.size();i++) { %>
		                                <tr>
		                                    <th scope="row">
		                                        <%= i + 1 %>
		                                    </th>
		                                    <td>
		                                        <%= posts.get(i).getID() %>
		                                    </td>
		                                    <td style="text-align: left">
		                                        <%= posts.get(i).getName() %>
		                                    </td>
		                                    <td>
		                                        <%= posts.get(i).getTag() %>
		                                    </td>
		                                    <td>
		                                        <%= posts.get(i).getState() %>
		                                    </td>
		                                    <td>
		                                        <%= posts.get(i).getViewCount() %>
		                                    </td>
		                                    <td class="d-flex justify-content-between">
		                                        <a href="/posts?id=<%= posts.get(i).getID() %>"
		                                            class="text-decoration-none text-white btn bg-success me-1">Xem</a>
		                                        <a href="/posts/update?id=<%= posts.get(i).getID() %>"
		                                            class="text-decoration-none text-white btn bg-warning me-1">Sửa</a>
		                                        <button class="text-decoration-none text-white btn bg-danger" data-bs-toggle="modal" data-bs-target="#deleteModal" data-id="<%= posts.get(i).getID() %>" onClick="onClickBtnDelete(this)">Xóa</button>
		                                    </td>
		                                </tr>
		                                <% } %>
		                </tbody>
		            </table>
		        </div>
		    </div>
        </div>
    </div>
   <form action="/posts/delete" method="POST" class="d-none" id="delete-form">
        	<input name="id" id="delete-id"/>
        	<input name="returnUrl" value="/me/posts"/>
    </form>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
        integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/js/jquery.nice-select.min.js"
        integrity="sha512-NqYds8su6jivy1/WLoW8x1tZMRD7/1ZfhWG/jcRQLOzV1k1rIODCpMgoBnar5QXshKJGV7vi0LXLNXPoFsM5Zg=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <script>
        $(document).ready(function () {
            $('select').niceSelect();
        });
		const btnSubmit = document.getElementById('btnSubmit');
		
		function onClickBtnDelete(e) {
			const id = e.dataset.id;
			const deleteIdInput = document.getElementById('delete-id');
			deleteIdInput.value = id;
		}
		
		btnSubmit.addEventListener('click', e => {
			const deleteForm = document.getElementById('delete-form');
			deleteForm.submit();
		});
    </script>
</body>

</html>