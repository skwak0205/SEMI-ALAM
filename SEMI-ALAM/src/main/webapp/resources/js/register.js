/**
 * 
 */
var confirmNum;

$(function() {
	$("#phone_btn").click(function() {
		var phoneNum = $("#member_phone").val();
		
		if(phoneNum == "") {
			$("#errorPhone").html("핸드폰 번호를 입력해 주세요.");
		
		} else {
			$.ajax({
				url: "member.do",
				method: "post",
				data: { "command": "phoneConfirm", "phoneNum": phoneNum },
				success: function(msg) {
					console.log("성공");
					console.log("인증번호 : ", msg);
					confirmNum = msg.trim();
				},
				error: function() {
					console.log("실패");
				}
			});	
		}
	});
});

function idCheckConfirm() {
	var chk = document.getElementsByName("member_id")[0].title;
	if (chk == "n") {
		alert("id 중복체크를 먼저 해주세요.");
		document.getElementsByName("member_id")[0].focus();
	}
};

function idCheck() {
	var doc = document.getElementsByName("member_id")[0];
	
	if (doc.value.trim() == "" || doc.value == null) {
		alert("id를 입력해주세요.");
	} else {
		open("member.do?command=idchk&member_id=" + doc.value, "", "width=200, height=200");
	}
};

function confirmPhone(){
	var confirm = document.getElementById("member_phoneConfirm").title;
	if(confirm == "n") {
		alert("핸드폰 본인 인증을 먼저 해주세요.");
		document.getElementById("member_phoneConfirm").focus();
	}
}

function checkPhone() {
	var input = document.getElementById("member_phoneConfirm").value;
	
	if(input == "") {
		$("#error").html("<p>인증번호를 입력해주세요.</p>");
	
	} else {
		if(input == confirmNum) {
			$("#error").html("인증되었습니다.");
			$("#sample6_postcode").focus();
			
			document.getElementById("member_phoneConfirm").title = "y";
		} else {
			$("#error").html("<p>인증번호가 다릅니다. 다시 시도해 주세요.</p>");
			$("#member_phoneConfirm").val("");
			$("#member_phoneConfirm").focus();
		}
	}
}


























