var date = new Date();

document.addEventListener('DOMContentLoaded', function() {
	var calendarEl = document.getElementById('calendar');

	var calendar = new FullCalendar.Calendar(calendarEl, {
		locale: 'ko',
		contentHeight: 600,
		headerToolbar: {
			left: 'prev,next today',
			center: 'title',
			right: 'dayGridMonth,timeGridWeek,timeGridDay'
		},
		initialDate: date,
		navLinks: true, // can click day/week names to navigate views
		selectable: true,
		selectMirror: true,
		select: function(arg) {
			var title = prompt('일정 추가:');
			if (title) {
				$.ajax({
					url: 'mypage.do',
					type: 'post',
					data: { command: 'insertCalendar', title: title, start: arg.startStr, end: arg.endStr, allDay: arg.allDay },
					success: function(response) {
						calendar.addEvent({
							title: title,
							start: arg.start,
							end: arg.end,
							allDay: arg.allDay,
							color: "#6937a1"
						})
					}
				});

			}
			calendar.unselect();
		},
		eventClick: function(arg) {

			if (confirm('일정을 삭제하시겠습니까?')) {

				$.ajax({
					url: 'mypage.do',
					type: 'post',
					data: { command: 'deleteCalendar', title: arg.event.title, start: arg.event.startStr, end: arg.event.endStr },
					success: function(response) {
						console.log("성공")
					}
				});

				arg.event.remove()
			}
		},
		editable: true,
		eventDrop: function(info) {
			console.log(info);

			if (!confirm("일정을 변경하시겠습니까?")) {
				info.revert();
			} else {
				$.ajax({
					url: 'mypage.do',
					type: 'post',
					data: { command: 'updateCalendar', title: info.event.title, start: info.event.startStr, end: info.event.endStr },
					success: function(response) {
						console.log("성공")
					}
				});
			}
		},

		eventResize: function(info) {
			console.log("info :", info);
			if (!confirm("일정을 변경하시겠습니까?")) {
				info.revert();
			} else {
				$.ajax({
					url: 'mypage.do',
					type: 'post',
					data: { command: 'updateCalendar', title: info.event.title, start: info.event.startStr, end: info.event.endStr },
					success: function(response) {
						console.log("성공")
					}
				});
			}
		},
		
		dayMaxEvents: true, // allow "more" link when too many events

		events: function(arg, successCallback, failureCallback) {
			$.ajax({
				type: 'post',
				url: 'mypage.do',
				data: { command: 'calendarList', start: arg.startStr, end: arg.endStr },
				dataType: 'json',
				success: function(result) {

					var events = [];

					if (result != null) {

						$.each(result, function(index, element) {
							events.push({
								title: element.title,
								start: element.start,
								end: element.end,
								allDay: element.allDay == 'Y' ? true : false,
								color: "#6937a1"
							}); //.push()

						});

					}
					successCallback(events);
				}
			});
		}
	});

	calendar.render();
});


