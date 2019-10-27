<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="container-fluid">

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
										action="#">
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
									<th scope="col">Phòng Ban</th>
									<th scope="col">Thành Tích</th>
									<th scope="col">Kỷ Luật</th>
									<th scope="col">Diểm thưởng</th>
									<th scope="col"></th>
								</tr>
							</thead>
							<tbody>
						 	<c:forEach var="d" items="${tkDeparts}" >
									<tr >																	
										<td>${d[1]}</td>
										<td>${d[2]}</td>
										<td>${d[3]}</td>
										<td>${d[4]}</td>								
										<th scope="col"><a
											href="admin/statistic/depart/ct.htm?id=${d[0]}"><button
													type="button" class="btn btn-danger">Xem Chi Tiết</button></a></th>
									</tr>							
							</c:forEach>						 
							</tbody>
						</table>		
					</div>
				</div>
			</div>
		</div>
	</div>


