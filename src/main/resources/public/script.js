$(document).ready(function(){
	$("#btn_continue").click(function(){

	if($("#PlayerName").val().length == 0) {
		alert("You must enter a player name!"); 		
	}
	else{
		window.location.href = 'menu.html';
		}
	});

	$("#show").click(function(){
		$(".playertwo").first().show();
	});

	$("#btn_playvsplay").click(function(){

	if($("#PlayerName2").val().length == 0) {
		$('.output').html('Please Enter Name').attr('class', 'alert alert-danger');		
	}
	else{
		window.location.href = 'game.html';
	}
	});

	$("#btn_playvscomp").click(function(){

	
		window.location.href = 'game.html';
	
	});

	$("#btn_compvscomp").click(function(){

		window.location.href = 'game.html';
	
	});

});
