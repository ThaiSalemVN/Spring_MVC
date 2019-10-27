/**
 * 
 */

	$('.table tbody').on('click','.edit',function(){
			var currow = $(this).closest('tr');
			var id = currow.find('td:eq(0)').text().trim();
			var hoten = currow.find('td:eq(1)').text().trim();
			var phongban = currow.find('td:eq(2)').text().trim();
			var maphongban = currow.find('td:eq(3)').text().trim();
			var ngaysinh = currow.find('td:eq(4)').text();
			var gioitinh = currow.find('td:eq(5)').text().trim();
			var email = currow.find('td:eq(6)').text().trim();
			var sodt = currow.find('td:eq(7)').text().trim();
			var luongTB = currow.find('td:eq(8)').text().trim(); 
			var anh =   currow.find('td:eq(9)').text().trim();
			var ghichu = currow.find('td:eq(10)').text().trim(); 
		
		if(anh == ""){
			anh = "newuser.jpg"
		}		
		$("#my_image").attr("src","resources/images/" + anh);	
		inputHoTen.value = hoten;
		$("h6.classTenPB").text("("+phongban+")");

		
		inputIdLike.value = id;
		inputIdLikeDislike.value = id;
		inputId.value = id;	
		inputName.value = hoten;
		inputHinh.value = currow.find('td:eq(9)').text().trim();	
		$("select").val(maphongban);
						
		if(gioitinh=="Nam"){
				$('#rdNam').prop('checked', true);		
		}
		else{
	
			$('#rdNu').prop('checked', true);
		}
		inputDate.value = formatDate(ngaysinh);
		
		var luong = luongTB.match(/\d/g);
			luong = luong.join("");
		inputLuong.value = luong;
		
		inputEmail.value = email;		
		inputSoDT.value = sodt;
		inputGhiChu.value = ghichu;
					
		$('#them').prop('disabled', true);	
		$('#capnhat').prop('disabled', false);	
	
	});

	
	$('#moi').click(function(){
		/*Làm mới form*/
		$("#my_image").attr("src","resources/images/newuser.jpg");	
		inputHoTen.value = '';
		$("h6.classTenPB").text('(...)');
		inputId.value = '';	
		inputName.value = '';
		inputHinh.value = '';
		uploadInputFile.value='';
		inputEmail.value = '';	
				$('#rdNam').prop('checked', true);
		
		/*inputDate.value = new Date;*/
		inputSoDT.value = '';
		inputLuong.value = '';
		inputGhiChu.value = '';
		
		
		/*    */
		$('#them').prop('disabled', false);
		$('#capnhat').prop('disabled', true)
		
	/*	$('#imgDisLike').prop('hidden', true);*/
	});
		
	
	
	function formatDate(date) {
		/*17/08/1990*/
			var year= date.substring(6);
			var month = date.substring(3,5);
			var day = date.substring(0,2);	     
	     return [year, month, day].join('-');
	 }
	
	window.onload = function(){	
		var img =  $('.img1 img').attr('src');
			if(img=='resources/images/'){
			 $("#my_image").attr("src","resources/images/newuser.jpg");	
		}
		   
		var name = inputHoTen.value;
		if(name==''){
			$('#them').prop('disabled', true);	
			$('#capnhat').prop('disabled', true);	
		}
		else{
			$('#capnhat').prop('disabled', false);	
		}
		

/*	$('#someid').prop('hidden', false);
	$('#somename').prop('hidden', true);*/
  };
	