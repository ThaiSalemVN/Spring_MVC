<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>


<div class="container">
	<h1>Vinh Danh!</h1>
	<p class="lead">Đánh giá dựa trên Tổng điểm tích cực của nhân viên - Tổng điểm vi phạm kỷ luật 
	của nhân viên.</p>
	<p>Muốn đi nhanh thì hãy đi một mình, muốn đi xa thì hãy đi cùng nhau.
	   Một người lãnh đạo tài năng không chỉ cần là một người giỏi dẫn dắt mà còn cần là một người biết
	   truyền cảm hứng cho nhân viên của mình. Chỉ khi lãnh đạo và nhân viên có chung tầm nhìn, 
	   một công ty mới có thể phát triển mạnh mẽ.</p>
</div>

<div class="container-fluid text-center bg-grey">
	
	<h4>Top 10 gương mặt tiêu biểu.</h4>
	
	<div class="row text-center">
		<div class="col-sm-1"></div>
		<c:forEach var="staff" items="${top10 }" begin="0" end="4">
			<div class="col-sm-2">
				<div class="thumbnail">
					<img src="resources/images/${staff.photo }"  alt="">
					<p>
						<strong>${staff.name }</strong>
					</p>
					<p>${staff.depart.name}</p>
				</div>
			</div>
		</c:forEach>
		<div class="col-sm-1"></div>
		
	    <div class="col-sm-1"></div>
		<c:forEach var="staff" items="${top10 }" begin="5" end="9">
			<div class="col-sm-2">
				<div class="thumbnail">
					<img src="resources/images/${staff.photo }"  alt="">
					<p>
						<strong>${staff.name }</strong>
					</p>
					<p>${staff.depart.name}</p>
				</div>
			</div>
		</c:forEach>
		<div class="col-sm-1"></div>
	</div>
</div>