/**
 * 
 */
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
	
	/*$("#loadDash").click(function(){
		$.post("/user/loadDashboard","test", function(data, status){
			if(status =="success"){
				
			}
		});
	});*/
	
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

function showAccountCard(){
	$(".acc_optn").show();
	
}

function loadDashboard(){
	$.get("/user/loadDashboard", function(data, status){
		if(status =="success"){
			
		}
	});
}