

$(document).ready(function(){
	

	/*bắt lỗi phòng ban*/
	$("#formDepart").validate({
		rules : {	
			id:{required : true,minlength : 3},
			name: "required",
			
		},
		 
		messages : {

			id:{
				required: "Nhập mã phòng ban.",
				minlength: "Tối thiểu ký tự."
			},
			name: "Nhập tên phòng."
		},
	});
	
	/*bắt lỗi record*/
	$('#formRecord').validate({
		rules : {
			date : "required",
			type: "required",
			reason: "required",
		},
		messages : {
			date : "Vui lòng chọn ngày.",
			type: "Vui lòng chọn thưởng hoặc phạt.",
			reason: "Không được bỏ trống.",
		},
	});
	
	/*bắt lỗi nhân viên*/
	$('#formStaff').validate({
		rules : {
			name : "required",
			gender : "required",
			birthday : "required",
			salary : {required : true, digits : true},
			phone : {required : true, digits : true, minlength : 9, maxlength : 11},
			email : {required : true,email : true},
		},
		messages : {
			name : "Chưa nhập tên.",
			gender: "Chưa chọn giới tính.",
			birthday : "Chưa chọn ngày.",
			salary:{
				required : "Chưa nhập lương.",
				digits : "Sai định dạng rồi."
			},
			phone : {
				required: "Chưa nhập số điện thoại",
				digits : "Sai định dạng rồi.",
				minlength : "Thiếu số rồi.",
				maxlength : "Thừa số rồi"
			},
			email:{
				required : "Chưa nhập email",
				email : "Chưa đúng định dạng" 
			}
		},
	});

	$('#formEmail').validate({
		rules : {
			from : "required",
			to: {required : true,email : true},
			subject : "required",
		},
		messages : {
			from : "Vui lòng nhập tên.",
			to : {
				required : "Chưa nhập người nhận email.",
				email : "Chưa đúng định dạng." 
			},
			subject : "Không được để trống.",
		},
	});
	
});

