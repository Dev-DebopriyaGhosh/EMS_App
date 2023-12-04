/**
 * 
 */
// Initialization for ES Users

// Initialization for ES Users


$(document).ready(function() {
    // jQuery code
	$("#signUp").click(function(){
		$.get("/signup",function(data, status){
			$(".container").remove();
			$('body').css('background-image', 'none');
			$("#registrationDiv").html(data);
		});
	});
	
	
});

function registerUser(){
	var formData= $("#signup_form").serialize();
	$.post("/register",formData,function(data, status){
		if(status =="success"){
			$(".form_class").hide();
			$("#regis_success").show();
			$("#regis_success").append(data);
			
			
		}
	});
}

function showOptions(e){
		let eleId=e.id;
		let eleNum=eleId.charAt(eleId.length-1);
		var eleToShow='#drop_'+eleNum;
		var displayValue = $(eleToShow).css('display');
		if(displayValue=="none"){
			$(eleToShow).show();
		}else{
			$(eleToShow).hide();
		}
}

function sortAscending(fieldName){
	$.post("/user/sortDashDataAscending",{fieldName:fieldName},function(data, status){
		alert(fieldName);
		if(status =="success"){
			$('#searchContainer').empty();
	        $('#searchContainer').append(data);
		}
	});
}

