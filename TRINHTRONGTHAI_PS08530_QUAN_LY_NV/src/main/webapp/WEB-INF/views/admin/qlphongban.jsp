<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script src="https://cdn.jsdelivr.net/npm/sweetalert2@8"></script>
<script src="resources/admin/editjs/validation.js"></script>
<script>
if(${message=='insertTrue'}){
		Swal.fire(
				  'Thêm phòng ban thành công!',
				  'You clicked the button!',
				  'success'
				)	
 }
 
 if(${message=='insertFalse'}){
		 Swal.fire({
			  type: 'error',
			  title: 'Thêm phòng ban thất bại!',
			  text: 'You clicked the button!'	
			})
}
  if(${message=='updateTrue'}){
				Swal.fire(
						  'Cập nhật phòng ban thành công!',
						  'You clicked the button!',
						  'success'
						)	
		 }
  if(${message=='updateFalse'}){
			Swal.fire({
				  type: 'error',
				  title: 'Cập nhật phòng ban thất bại!',
				  text: 'You clicked the button!'	
				})
  }
  if(${message=='deleteTrue'}){
		Swal.fire(
				  'Xóa thành công!',
				  'You clicked the button!',
				  'success'
				)	
}
if(${message=='deleteFalse'}){
	Swal.fire({
		  type: 'error',
		  title: 'Xóa thất bại!',
		  text: 'You clicked the button!'	
		})
}
</script>
 
 
<div class="container-fluid">

	<div class="row">
		<div class="col-12">
			<div class="card">
				<div class="card-body">

					<div id="abb" style="margin-bottom: 10px;">
						<button type="button" class="btn btn-success">
							<i class="fa fa-plus-square"></i> Tạo Mới
						</button>
					</div>

					<div>
						<form:form action="admin/departs.htm" method="Post"
							modelAttribute="Depart" class="form-inline" id="formDepart" style="float: left;">

							<div class="form-group mx-sm-3 mb-2" style="width: 260px">
								<form:input path="id" type="text" class="form-control"
									id="idform" placeholder="Id" />
							</div>
							<div class="form-group mx-sm-3 mb-2" style="width: 260px">
								<form:input path="name" type="text" class="form-control"
									id="nameform" placeholder="Name" />

							</div>
							<button type="submit" class="btn btn-primary mb-2" id="someid"
								name="insert">Thêm Phòng Ban</button>
							<button type="submit" class="btn btn-primary mb-2" id="somename"
								hidden="true" name="update">Lưu Thay Đổi</button>

						</form:form>



						<div style="float: right;">
							<ul class="navbar-nav float-left mr-auto">
								<!-- ============================================================== -->
								<!-- Search -->
								<!-- ============================================================== -->
								<li class="nav-item search-box">Search <a
									class="nav-link waves-effect waves-dark"
									href="javascript:void()"><i class="ti-search"></i></a>
									<form class="app-search position-absolute"
										action="admin/departs/search.htm">
										<input type="text" class="form-control" name="tenPB"
											placeholder="Nhap ten &amp; enter"> <a
											class="srh-btn"><i class="ti-close"></i></a>
									</form>
								</li>
							</ul>
						</div>

					</div>

					<br>
					<div class="table-responsive">
						  <form action="" id="formTable">
							<table class="table table-hover">
								<thead class="thead-light">
									<tr>
										<th scope="col">Mã Phòng Ban</th>
										<th scope="col">Tên Phòng Ban</th>
										<th scope="col"></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="d" items="${Departs}" varStatus="i">
										<tr class="edit">
											<td>${d.id }</td>
											<td>${d.name}</td>
											<th scope="col"><a
												href="admin/departs/delete.htm?id=${d.id}"><button
														type="button" class="btn btn-danger" style="width: 100px;">Delete</button></a></th>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<ul class="pagination" id="pagination"></ul>
							<input type="hidden" value="" id="page" name="page" />		
						<!-- 	<input type="hidden" value="" id="item" name="maxItem" />	 -->		
						</form>
					</div>

				</div>
			</div>
		</div>
	</div>

</div>

<script src="resources/admin/editjs/qlphongban.js"></script>
<script type="text/javascript">
var contextPath = window.location.protocol + "/" + window.location.pathname.split('/')[1];
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: ${totalPage} ,
            startPage: ${startPage} ,
            visiblePages: 2,
            onPageClick: function (event, page) {
            	$('#page').val(page);
                console.info(page + ' (from options)');
            }
        }).on('page', function (event, page) {
            /* window.location.href= contextPath + "/admin/departs/home.htm?page="+page; */
            $('#formTable').submit();
        });
    });
</script>


