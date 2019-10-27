<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div class="container-fluid" style="margin:auto;">
	<div class="row" >
		<div class="col-4" style="margin-bottom: 250px;">
			<div class="card">
				<div class="card-body">
				<form action="admin/change.htm" method="Post">
					
					<label for="inputPassword5">Mật khẩu</label> <input type="password"
						id="inputPassword5" class="form-control" name="pw"
						aria-describedby="passwordHelpBlock"> 
						
						<label for="inputPassword5">Mật khẩu mới</label> <input type="password"
						id="inputPassword5" class="form-control" name="newpw"
						aria-describedby="passwordHelpBlock"> 

						<label for="inputPassword5">Nhập lại mật khẩu</label> <input type="password"
						id="inputPassword5" class="form-control" name="confirmpw"
						aria-describedby="passwordHelpBlock"> <small
						id="passwordHelpBlock" class="form-text text-muted">Mật khẩu chỉ từ 8 - 10 ký tự
						bao gồm cả chữ và số, không chứa khoảng trắng và các ký tự đặc biệt.
						 </small>
						 <p style="color: red;">${message}</p>
						 <button type="submit" class="btn btn-default" style="background-color: #4FC3F7; float:right;">Xác Nhận</button>
				 </form>
				</div>
			</div>
		</div>
	</div>
</div>