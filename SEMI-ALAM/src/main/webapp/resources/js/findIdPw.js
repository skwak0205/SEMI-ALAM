/**
 * 
 */

var confirmNum = "";
var member_id = "";
var id_pw = "";

function checkUser() {
	var member = "";
	var phoneNum = "";
	
	if($("#name").val() == "" && $("#id_phoneNum").val() == "") {
		if($("#member_id").val() != "" && $("#pw_phoneNum").val() != "") {
			id_pw = "pw";
			member = $("#member_id").val();
			phoneNum = $("#pw_phoneNum").val();			
		}
	
	} else if($("#member_id").val() == "" && $("#pw_phoneNum").val() == "") {
		if($("#name").val() != "" && $("#id_phoneNum").val() != "") {
			id_pw = "id";
			member = $("#name").val();
			phoneNum = $("#id_phoneNum").val();
		}
	} 
	
	$("#showId").text("");
	$("#showPw").text("");
	
	if(member == "" && phoneNum == "") {
		$("#error").text("입력창에 입력해주세요");
		$("#error").css("color", "red");
	} else {
		
		$.ajax({
			url: "member.do",
			method: "post",
			data: { "command": "checkUser", "member": member, "phoneNum":phoneNum, "id_pw": id_pw  },
			dataType: "json",
			success: function(result) {

				var num = result.confirm.trim().length;
				if(num == 4) {
					
					confirmNum = result.confirm;
					member_id = result.member_id;				
					
					console.log("인증번호 : ",confirmNum)
				
				} else {
					if(id_pw == "id") {
						$("#showId").text(result.confirm);
						$("#showId").css("color", "red");
					} else if(id_pw == "pw") {
						$("#showPw").text(result.confirm);
						$("#showPw").css("color", "red");
					}
				}
			},
			error: function(msg) {
				console.log("실패", msg);
			}
		});
	}
	
	$("#name").val("");
	$("#id_phoneNum").val("");
	$("#member_id").val("");
	$("#pw_phoneNum").val("");
}

function confirm() {
	
	if (id_pw == "id") {
		var confirm_num = $("#confirmNum").val();
		$("#showId").text("");
			
		if(confirm_num == confirmNum) {
			$("#showId").text("아이디는 " + member_id + " 입니다.");
		
		} else {
			$("#showId").text("인증번호가 틀렸습니다.");
		}
		
		$("#confirmNum").val("");
	
	} else if (id_pw == "pw") {
		var confirm_num = $("#pw_confirmNum").val();
		$("#showPw").text("");
			
		if(confirm_num != "" && confirm_num == confirmNum) {
			$("#changePw").css("display", "inline");
		
		} else {
			$("#showPw").text("인증번호가 틀렸습니다.");
			$("#showPw").css("color", "red");
		}
		
		$("#pw_confirmNum").val("");
	}
	
	
}

function updatePw(){
	var newPw = $("#newPw").val();
	var checkNewPw = $("checkNewPw").val();
		
	if(newPw != "" && checkNewPw != "") {
		
		if($("#newPw").val() == $("#checkNewPw").val()) {
			location.href="member.do?command=updatePw&member="+member_id+"&newPw="+newPw;	
		} else {
			$("#showPw").text("비밀번호가 서로 다릅니다.");
			$("#showPw").css("color", "red");
			$("#newPw").val("");
			$("#checkNewPw").val("");
		}
	
	}
	
}