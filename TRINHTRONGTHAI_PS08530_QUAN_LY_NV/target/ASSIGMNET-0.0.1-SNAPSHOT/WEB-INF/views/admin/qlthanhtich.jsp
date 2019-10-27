<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="container-fluid">
<form:form action="admin/records.htm" modelAttribute="Record">
	<div class="row">	
		<div class="col-lg-8 col-xlg-9 col-md-7">
			<div class="card">
				<div class="card-body" style="height: 310px;">
					<div class="card">
					<!-- id Records -->
							<form:input path="id" type="text" class="form-control" id="inputId" hidden="true"/>
							<div class="form-group">
								<label for="formGroupExampleInput">Họ Tên</label>
									 <form:input path="staff.id" type="text" value="${NhanVien.id }"  class="form-control" id="inputIdStaff"  hidden="true"/>													
									 <form:input path="staff.name" type="text" value="${NhanVien.name }"  class="form-control" id="inputNameStaff" placeholder="Name" readonly="true"/>
							</div>
							<div class="form-group">
								<label for="formGroupExampleInput2">Ngày</label>
								<form:input path="date" type ="date" id="inputDate"/>
							</div>
							<div class="form-group">
								<label for="formGroupExampleInput2">Đánh Giá :  </label> 
									<form:radiobutton path="type" value="True" label="Thưởng nhân viên" id="rdThuong" style="margin-left:30px;"/>
							        <form:radiobutton path="type" value="False" label="Phạt nhân viên"  id="rdPhat" style="margin-left:50px;"/> 
							</div>
							<div class="form-group">
								<label for="formGroupExampleInput2">Lý Do</label>
								<form:textarea path="reason"  rows="3" class="form-control" id="inputLydo" placeholder="......" />	
							</div>											
					</div>
				</div>
			</div>
		</div>


		<div class="col-lg-4 col-xlg-3 col-md-5">
			<div class="card">
				<div class="card-body" style="text-align: center; margin:150px 0px 30px 0px;">
				<button type="submit" class="btn btn-success" name="insert" id="btnInsert" style="width: 130px;height: 40px;" >THÊM MỚI</button>
				<button type="submit" class="btn btn-success" name="update" id="btnUpdate" style="width: 130px;height: 40px;" disabled>CẬP NHẬT</button>
					<div style="margin-top:10px;">
						<button type="button" class="btn btn-success"  id="btnNew" style="width: 130px;height: 40px;">LÀM MỚI</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</form:form>


	<div class="row">
		<div class="col-12">
			<div class="card">
				<div class="card-body">
					<div>						
						<div >
							<ul class="navbar-nav float-left mr-auto">
								<!-- ============================================================== -->
								<!-- Search -->
								<!-- ============================================================== -->
								<li class="nav-item search-box">Search <a
									class="nav-link waves-effect waves-dark"
									href="javascript:void()"><i class="ti-search"></i></a>
									<form class="app-search position-absolute"
										action="admin/records/search.htm">
										<input type="text" name="idStaff" class="form-control"
											placeholder="Nhập Id nhân viên &amp; enter"> <a class="srh-btn"><i
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
									<th hidden="true"></th>
									<th scope="col" width="130">Mã Nhân Viên</th>
									<th scope="col">Họ & Tên</th>
									<th scope="col">Loại</th>
									<th scope="col" width="300">Lý Do</th>
									<th scope="col">Ngày</th>
									<th scope="col"></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="R" items="${Records}">
									<tr class="edit">
										<td hidden="true">${R.id }</td>
										<td>${R.staff.id }</td>
										<td>${R.staff}</td>
										<td>${R.type?'1':'0'}</td>
										<td>${R.reason}</td>
										<td><fmt:formatDate value="${R.date }"
												pattern="dd-MM-yyyy" /></td>
										<th scope="col"><a href="admin/records/delete.htm?id=${R.id }"><button
													type="button" class="btn btn-danger" style="width: 100px;">Delete</button></a></th>
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

<script src="resources/admin/editjs/qldanhgia.js" ></script>

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
            window.location.href= contextPath + "/admin/records/home.htm?page="+page;
        });
    });       
</script>