	$('.table tbody').on('click','.edit',function(){
		var currow = $(this).closest('tr');
		var col1 = currow.find('td:eq(0)').text().trim();
		var col2 = currow.find('td:eq(1)').text().trim();
		
		idform.value = col1;
		nameform.value = col2;
	
		$('#someid').prop('hidden', true);
		$('#somename').prop('hidden', false);
		
		
		$("#idform").prop("readonly", true);
		/* them.prop('disable','true'); */
		
		
	});

	$('#abb').click(function(){
		idform.value = '';
		nameform.value = '';
		
		$('#someid').prop('hidden', false);
		$("#idform").prop("readonly", false);
		$('#somename').prop('hidden', true);
	});
	
	/*window.onload = function(){	
		idform.value = '';
		nameform.value = '';
		$('#someid').prop('hidden', false);
		$('#somename').prop('hidden', true);
	};*/