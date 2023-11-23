/**
 * 
 */

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