/**
 * 
 */

	$('.table tbody').on('click','.edit',function(){
			var currow = $(this).closest('tr');
			var id = currow.find('td:eq(0)').text().trim();
			var hoten = currow.find('td:eq(1)').text().trim();
			var phongban = currow.find('td:eq(2)').text().trim();
			var ngaysinh = currow.find('td:eq(3)').text();
			var gioitinh = currow.find('td:eq(4)').text().trim();
			var email = currow.find('td:eq(5)').text().trim();
			var sodt = currow.find('td:eq(6)').text().trim();
			var luongTB = currow.find('td:eq(7)').text().trim(); 
			var anh =  "resources/images/" + currow.find('td:eq(8)').text().trim();
			var ghichu = currow.find('td:eq(9)').text().trim(); 
		
			
			 /*set value cho form*/
			/* var  ngay = "1999-08-19";*/
		$("#my_image").attr("src",anh);	
		inputHoTen.value = hoten;
		$("h6.classTenPB").text("("+phongban+")");
		
		
		
		inputIdLike.value = id;
		inputIdLikeDislike.value = id;
		inputId.value = id;	
		inputName.value = hoten;
		inputHinh.value = currow.find('td:eq(8)').text().trim();
		
		
		
		$("#selectPB option").filter(function() {
		    return this.text == phongban; 
		}).attr('selected', true);			
				
		if(gioitinh=="Nam"){
				$('#rdNam').prop('checked', true);
				$('#rdNu').prop('checked', false);
		}
		else{
			$('#rdNam').prop('checked', false);
			$('#rdNu').prop('checked', true);
		}
		inputDate.value = formatDate(ngaysinh);
		
		var luong = luongTB.match(/\d/g);
			luong = luong.join("");
		inputLuong.value = luong;
		inputEmail.value = email;	
		
		inputSoDT.value = sodt;
		
		inputGhiChu.value = ghichu;
		
		/*set disable cho button*/
		
		
		$('#them').prop('disabled', true);	
		$('#capnhat').prop('disabled', false);	
	/*	$('#imgLike').prop('hidden', false );
		$('#imgDisLike').prop('hidden', false);
		$('#my_image').prop('hidden', false);	
		$('#inputHoTen').prop('hidden', false);*/
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
				$('#rdNam').prop('checked', false);
				$('#rdNu').prop('checked', false);	
		/*inputDate.value = new Date;*/
		inputSoDT.value = '';
		inputLuong.value = '';
		inputGhiChu.value = '';
		
		
		/*    */
		$('#them').prop('disabled', false);
		$('#capnhat').prop('disabled', true)
		/*$('#imgLike').prop('hidden', true );
		$('#imgDisLike').prop('hidden', true);*/
	});
		
	
	
	
	
	function formatDate(date) {
		/*17/08/1990*/
			var year= date.substring(6);
			var month = date.substring(3,5);
			var day = date.substring(0,2);	     
	     return [year, month, day].join('-');
	 }
	

	