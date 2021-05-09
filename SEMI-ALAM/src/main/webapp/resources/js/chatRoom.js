/**
 * 
 */
var $ul = $(".search-list");

$(function() {
	$("#search-btn").click(function() {		
		var input = $("#search").val();

		if (input != "") {
			if ($ul.has("li")) {
				$ul.children().remove()
			}

			search(input);
			$("#search").val("");
		} 
	});
	
		
});

function search(input) {
	$.ajax({
		url: "chat.do",
		method: "post",
		data: { "command": "searchId", "searchId": input },
		dataType: "json",
		success: function(result) {

			if(result.length == 0) {
				var $li = $("<li>");
				li.addClass("no-result");
				$li.text("검색 결과가 없습니다.");
				$ul.append($li);
			}

			for (var i = 0; i < result.length; i++) {
				outputSearch(result, i);
			}

		},
		error: function(msg) {
			console.log("실패", msg);
		}
	});
};

function outputSearch(result, i) {
	var $li = $("<li>");
	$li.addClass("list");
	
	var $id = $("<span>");
	$id.addClass("member-id");
	$id.text(result[i].member_id);

	var $name = $("<span>");
	$name.addClass("member-name");
	$name.text(result[i].member_name);

	var grade = result[i].member_grade == "B" ? "멘티" : "멘토";

	var $grade = $("<span>");
	$grade.addClass("member-grade");
	$grade.text(grade);

	$li.append($id);
	$li.append($name);
	$li.append($grade);
				
	$ul.append($li);	
	
	chat($li);		
};

function chat($li) {	
	$li.click(function(){
		var guest_Id = $(this).children(".member-id").text();
		
		$.ajax({
			url: "chat.do",
			method: "post",
			data: { "command": "checkRoom", "guest_Id": guest_Id },
			success: function(result) {
				console.log("성공")
				location.href = "chat.do?command=chatting&guest_Id="+guest_Id+"&room_Id=" + result;
	
			},
			error: function(msg) {
				console.log("실패", msg);
			}
		});
		
	})
};

function chatting(idx, room_Id) {
	var guest_Id = document.getElementsByClassName('username')[idx].innerText;
		
	location.href = "chat.do?command=chatting&guest_Id="+guest_Id+"&room_Id="+room_Id;
};

function deleteChatRoom(room_Id) {
	location.href="chat.do?command=deleteChatRoom&room_Id="+room_Id;
};






