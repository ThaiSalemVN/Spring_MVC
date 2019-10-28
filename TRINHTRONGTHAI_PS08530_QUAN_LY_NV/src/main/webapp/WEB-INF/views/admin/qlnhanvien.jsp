<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script src="https://cdn.jsdelivr.net/npm/sweetalert2@8"></script>
<script src="resources/admin/editjs/validation.js"></script>
<script>
if(${message=='insertTrue'}){
		Swal.fire(
				  'Thêm nhân viên thành công!',
				  'You clicked the button!',
				  'success'
				)	
 }
 
 if(${message=='insertFalse'}){
		 Swal.fire({
			  type: 'error',
			  title: 'Thêm nhân viên thất bại!',
			  text: 'You clicked the button!'	
			})
}
  if(${message=='updateTrue'}){
				Swal.fire(
						  'Cập nhật nhân viên thành công!',
						  'You clicked the button!',
						  'success'
						)	
		 }
  if(${message=='updateFalse'}){
			Swal.fire({
				  type: 'error',
				  title: 'Cập nhật nhân viên thất bại!',
				  text: 'You clicked the button!'	
				})							
  }
  if(${message=='recordFalse'}){
		Swal.fire({
			  type: 'error',
			  title: 'Chưa chọn nhân viên!',
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
	<!-- form -->
	<div class="row">
		<!-- Column1 -->
		<div class="col-lg-4 col-xlg-3 col-md-5">
			<div class="card">
				<div class="card-body" style="height: 380px;">
				

					<div style="text-align: center;">
						<div class="img1" style="width: 200px; height: 200px; margin: auto;" >
							<img src="resources/images/${Staff.photo}" id="my_image"
							class="rounded-circle" width="180px"  alt=""/>
						</div>
						
						 <h4 class="card-title m-t-10"> 				   		
								<input type="text" id="inputHoTen" value="${Staff.name}" style="text-align: center;" />		
							</h4>
						<h6 class="classTenPB card-subtitle">${Staff.depart}</h6>
					</div>

					<div data-toggle="modal" data-target="#exampleModal" style="float:left; margin-left: 75px;" id="imgLike"  >
						<img alt="" src="resources/admin/images_admin/like.png"
							width="50px" height="50px">
					</div>
					<div data-toggle="modal" data-target="#exampleModal2" style="float:right;margin-right: 75px;" id="imgDisLike" >
						<img alt="" src="resources/admin/images_admin/dislike.png"
							width="50px" height="50px" >
					</div>
			
				
				
				
				<!-- modal1 -->
					<div class="modal fade" id="exampleModal" tabindex="-1"
						role="dialog" aria-labelledby="exampleModalLabel"
						aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Thưởng Nhân
										Viên</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">
									<form action="admin/staffs/record/like.htm">
										<div class="form-group">
											<label for="message-text" class="col-form-label">Lý
												do:</label>
											<textarea name="reason"  class="form-control" id="message-text"></textarea>
										</div>
										<input  id="inputIdLike" value="${Staff.id}" name="idStaffR" type="text" hidden="true">
										<button type="submit" class="btn btn-success" style="float:right; width: 100px;">Lưu</button>
									</form>
								</div>
							</div>
						</div>
					</div>
					<!-- modal2 -->
					<div class="modal fade" id="exampleModal2" tabindex="-1"
						role="dialog" aria-labelledby="exampleModalLabel"
						aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Phạt Nhân
										Viên.</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">
									<form action="admin/staffs/record/dislike.htm">
										<div class="form-group">
											<label for="message-text" class="col-form-label">Lý
												do:</label>
											<textarea name="reason" class="form-control" id="message-text"></textarea>
										</div>
										<input id="inputIdLikeDislike" value="${Staff.id}" name="idStaffR" type="text" hidden="true">
										<button type="submit"  class="btn btn-danger" style="float:right; width: 100px;">Lưu</button>
													
									</form>
								</div>
							</div>
						</div>
					</div>


				</div>
			</div>
		</div>

		<!-- Column2 -->
		<div class="col-lg-8 col-xlg-9 col-md-7">

			<div class="card-body">
				<form:form action="admin/staffs.htm" modelAttribute="Staff"
					method="post" enctype="multipart/form-data" id="formStaff">
					<!-- row 1 -->
					<div class="form-row">
						<div class="form-group col-md-6" style="height: 75px; margin:0;">
							<label>Họ & Tên</label>
							<form:input path="id" type="hidden" id="inputId" />
							<form:input path="name" class="form-control" id="inputName"
								placeholder="Name" />
						</div>
						<div class="form-group col-md-6" style="height: 75px; margin:0;">
							<label>Hình</label>
							<form:input path="photo" hidden="true" id="inputHinh" />
							<div class="custom-file">
								<input type="file" id="uploadInputFile" name="imageNew"
									accept="image/*" onchange="readURL(this);" />
							</div>
						</div>

					</div>

					<!-- row 2 -->
					<div class="form-row">
						<div class="form-group col-md-3" style="height: 75px; margin:0;" >
							<label>Giới Tính</label> <br>
							<form:radiobutton path="gender" value="True" label="Nam" checked="true"
								id="rdNam"  />
							<form:radiobutton path="gender" value="False" label="Nữ"
								id="rdNu" />
						</div>
						<div class="form-group col-md-3" style="height: 75px; margin:0;" >
							<label>Ngày Sinh</label> <br>
							<form:input path="birthday" type="date" class="form-control"
								id="inputDate" />
						</div>
						<div class="form-group col-md-3  " style="height: 75px; margin:0;">
							<label>Phòng Ban</label> <br>
							<form:select path="depart.id" items="${Departs}" itemLabel="name"
								itemValue="id" class="form-control " id="selectPB" />
						</div>
						<div class="form-group col-md-3" style="height: 75px; margin:0;" >
							<label>Lương(vnđ)</label> <br>
							<form:input path="salary" type="number"  pattern="([0-9]{1,3}).([0-9]{1,3})" class="form-control"
								id="inputLuong" placeholder="0.0" />
						</div>
					</div>

					<!-- row 3 -->
					<div class="form-row" >
						<div class="form-group col-md-6" style="height: 75px; margin:0;">
							<label for="inputCity">Số Điện Thoại</label>
							<form:input path="phone" type="text" class="form-control"
								id="inputSoDT" placeholder="Phone" />
							<br> <label for="inputEmail4">Email</label>
							<form:input path="email" class="form-control" id="inputEmail"
								placeholder="Email" />

						</div>
						<div class="form-group col-md-6" >
							<label for="inputCity">Ghi Chú</label>
							<form:textarea path="notes" rows="5" class="form-control"
								id="inputGhiChu" placeholder="......" />
						</div>
					</div>
					<div class="button-group" style="float: right;">
						<button type="button" class="btn btn-primary" id="moi" name="new">THÊM
							MỚI</button>
						<button type="submit" class="btn btn-primary" id="them"
							name="insert" disabled='true'>LƯU NV</button>
						<button type="submit" class="btn btn-primary" id="capnhat"
							name="update" >CẬP NHẬT</button>
					</div>

				</form:form>
			</div>
		</div>
	</div>



	<!-- Table -->

	<div class="row">
		<div class="col-12">
			<div class="card">
				<div class="card-body">

					<div>
						<div style="float: left;">
							<ul class="navbar-nav float-left mr-auto">
								<!-- ============================================================== -->
								<!-- Search -->
								<!-- ============================================================== -->
								<li class="nav-item search-box">Search <a
									class="nav-link waves-effect waves-dark"
									href="javascript:void()"><i class="ti-search"></i></a>
									<form class="app-search position-absolute"
										action="admin/staffs/search.htm">
										<input name="tenNV" type="text" class="form-control"
											placeholder="Search &amp; enter"> <a class="srh-btn"><i
											class="ti-close"></i></a>
									</form>
								</li>
							</ul>
						</div>
					</div>

					<br>
					<div class="table-responsive">
						<table class="table table-hover">
							<thead class="thead-light">
								<tr>
									<th scope="col">Id</th>
									<th scope="col">Họ & Tên</th>
									<th scope="col">Phòng Ban</th>
									<th scope="col" hidden="true">MaPB</th>
									<th scope="col">Ngày Sinh</th>
									<th scope="col">Giới Tính</th>
									<th scope="col">Email</th>
									<th scope="col">Số Điện Thoại</th>
									<th scope="col">Lương(vnđ)</th>
									<th scope="col">Ảnh</th>
									<th scope="col">Ghi Chú</th>
									<th scope="col"></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="s" items="${Staffs}">
									<tr class="edit">
										<td>${s.id}</td>
										<td>${s.name}</td>
										<td>${s.depart}</td>
										<td hidden="true">${s.depart.id}</td>
										<td><fmt:formatDate value="${s.birthday}"
												pattern="dd-MM-yyyy" /></td>
										<td>${s.gender?'Nam':'Nữ'}</td>
										<td>${s.email}</td>
										<td>${s.phone}</td>
										<td><fmt:formatNumber pattern="#,##0" value="${s.salary}" /></td>
										<td>${s.photo}</td>
										<td>${s.notes }</td>
										<th scope="col"><a
											href="admin/staffs/delete.htm?id=${s.id}"><button
													type="button" class="btn btn-danger">Delete</button></a></th>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<ul class="pagination" id="pagination"></ul>
						<input type="hidden" value="" id="page" name="page" />
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script src="resources/admin/editjs/qlnhanvien.js"></script>
<script type="text/javascript">
var contextPath = window.location.protocol + "/" + window.location.pathname.split('/')[1];
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: ${totalPage} ,
            startPage: ${startPage} ,
            visiblePages: 3,
            onPageClick: function (event, page) {
                console.info(page + ' (from options)');
            }
        }).on('page', function (event, page) {
            window.location.href= contextPath + "/admin/staffs/home.htm?page="+page;
        });
    });
	
	//Hiện hình sau khi chọn file ảnh.
        function readURL(input) {
    	  if (input.files && input.files[0]) {
    	    var reader = new FileReader();
    	    reader.onload = function (e) {
    	      $('#my_image')
    	        .attr('src', e.target.result)
    	         .width(200)
    	        .height(200); 
    	    };
    	    reader.readAsDataURL(input.files[0]);
    	  }
    	}
    
</script>
