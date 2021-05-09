/**
 * 
 */
'use strict';


//const socket = io("http://localhost:5000");
const socket = io("https://semi-video.herokuapp.com/");

var text, time;

const {room_Id} = Qs.parse(location.search, {
	ignoreQueryPrefix: true
});

history.replaceState({}, null, location.pathname);

const member_Id = document.querySelector('#member_Id').value;
const guest_Id = document.querySelector('#guest_Id').value;
const chatList = document.querySelector('.chatting-list');
const displayContainer = document.querySelector('.display-container');
const chatInput = document.querySelector('.chatting-input');
const sendBtn = document.querySelector('.send-button');


socket.emit('joinChatRoom',  {member_Id, room_Id} );

socket.on('message', message => {	
	outputMessage(message);
	
	displayContainer.scrollTo(0, displayContainer.scrollHeight);
});

chatInput.addEventListener('keypress', (e) => {
  if (e.keyCode === 13) {
    send();
  }
});

sendBtn.addEventListener('click', () => {
  send();
});


function send(){
	text = chatInput.value;

	moment.tz.setDefault("Asia/Seoul"); 
	time = moment().format("YYYY-MM-DD h:mm:ss a");
	
	
	const msg = chatInput.value;
	
	socket.emit('chatMessage', msg, time);
	
	chatInput.value = '';
	chatInput.focus();
}


function outputMessage(message) {
	
	const li = document.createElement('li');
	
    li.classList.add(member_Id === message.member_Id ? 'sent' : 'received');

	li.innerHTML = 
	`<span class="profile">
        <span class="user">${message.member_Id}</span>
        <img
          class="image"
          src="https://placeimg.com/50/50/any"
          alt="any"
        />
      </span>

      <span class="message"> ${message.text} </span>

      <span class="time">${message.time}</span>`;
	
	chatList.appendChild(li);
	
};

function getParameterValues() {
	return "?command=sendMsg&room_Id="+room_Id+"&from_Id="+member_Id+"&to_Id="+guest_Id+"&text="+text+"&time="+time;
}

function saveMsg() {
	var queryString = getParameterValues();
		
	$.ajax({
		url: "chat.do"+queryString,
		
		success: function(){
			console.log("성공");
		},
		error: function(){
			console.log("실패");
		}
	});
}

$(function(){
	
	$(".send-button").click(function(){
		saveMsg();
	});
	
	

	$('.chatting-input').keypress(function(event){
     if ( event.which == 13 ) {
			saveMsg();
     }
	});

})

