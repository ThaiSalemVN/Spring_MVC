<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
 <script src="https://cdn.jsdelivr.net/npm/sweetalert2@8"></script>
 <script src="https://cdn.jsdelivr.net/npm/sweetalert2@8"></script>
<script src="resources/admin/editjs/validation.js"></script>
 <script>
 if(${mss=='true'}){
		Swal.fire(
				  'Gửi email thàng công!',
				  'You clicked the button!',
				  'success'
				)	
 }
 if(${mss=='false'}){
	Swal.fire({
		  type: 'error',
		  title: 'Gửi email thất bại!',
		  text: 'You clicked the button!'	
		})
}

</script> 
	
	
<div class="container-fluid" style="margin: auto;">
	<div class="row">
		<div class="col-3"></div>
		<div class="col-6" style="margin-bottom: 250px;">
			<div class="card">
				<div class="card-body">
					<form action="admin/email.htm" method="Post" id="formEmail">
					    <div style="float:right">
					   		 <img alt=""  src="resources/admin/images_admin/gmail-icon.ico" width="36px" height="36px">
					    </div><br>			
						<label>Name</label> <input type="text" class="form-control"
							value="ABCGROUP" name="from" id="from" placeholder="From"> 
						<br>
						<label>Send to</label> <input type="text" id="to" class="form-control" name="to"
							placeholder="To">
						<br>
						<label>Subject</label> <input
							type="text"  class="form-control" id="subject" name="subject" >
						<br>
						<label>Message</label>
						 <textarea class="form-control"  name="message" id="exampleFormControlTextarea1" rows="3"></textarea>
						<br>
						
						<button type="submit" class="btn btn-default"
							style="background-color: #4FC3F7; float: right;">Send
							Email</button>
					</form>
				</div>
			</div>
			<div class="col-3"></div>
		</div>
	</div>
</div>