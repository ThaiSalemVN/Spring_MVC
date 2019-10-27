/**
 * 
 */

	$('.table tbody').on('click','.edit',function(){
		
			var currow = $(this).closest('tr');
			var id = currow.find('td:eq(0)').text().trim();
			var maNV = currow.find('td:eq(1)').text().trim();
			var tenNV = currow.find('td:eq(2)').text().trim();
			var danhGia = currow.find('td:eq(3)').text().trim();
			var lyDo = currow.find('td:eq(4)').text().trim();
			var ngay = currow.find('td:eq(5)').text().trim();
			
			 /*set value cho form*/
			/* var  ngay = "1999-08-19";*/
		
		inputId.value = id;
		inputIdStaff.value= maNV;
		inputNameStaff.value = tenNV;
		inputDate.value = formatDate(ngay);
				
		if(danhGia=="1"){
				$('#rdThuong').prop('checked', true);
			
		}
		else{
		
			$('#rdPhat').prop('checked', true);
		}
		inputLydo.value = lyDo;
		$('#btnInsert').prop('disabled', true);	
		$('#btnUpdate').prop('disabled', false);
			
	});


	$('#btnNew').click(function(){
	
		inputId.value = '';
		inputIdStaff.value= '';
		inputNameStaff.value = '';
					
		$('#rdThuong').prop('checked', false);
		$('#rdPhat').prop('checked', false);
			
	    inputLydo.value = '';
			
		$('#btnInsert').prop('disabled', false);	
		$('#btnUpdate').prop('disabled', true);
	});
	
	
	
	function formatDate(date) {
		/*17/08/1990*/
			var year= date.substring(6);
			var month = date.substring(3,5);
			var day = date.substring(0,2);	     
	     return [year, month, day].join('-');
	 }
	

	