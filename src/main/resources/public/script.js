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

	$("#btn_continue2").click(function(){

	if($("#PlayerName2").val().length == 0) {
		alert("You must enter name of player 2"); 		
	}
	else{
		window.location.href = 'game.html';
	}
	});


});
