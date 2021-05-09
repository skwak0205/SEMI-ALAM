	var markers = [
	    {
	        position: new kakao.maps.LatLng(37.49852075745237, 127.03261719800095),
			text: 'ALAM 본사 2관'
	    },
	    {	 
	        position: new kakao.maps.LatLng(37.49899870915999, 127.03284644146959), 
	        text: 'ALAM 본사 1관' // text 옵션을 설정하면 마커 위에 텍스트를 함께 표시할 수 있습니다     
	    }
	];
	
	var staticMapContainer  = document.getElementById('staticMap'), // 이미지 지도를 표시할 div  
	    staticMapOption = { 
	        center: new kakao.maps.LatLng(37.49899870915999, 127.03284644146959), // 이미지 지도의 중심좌표
	        level: 3, // 이미지 지도의 확대 레벨
	        marker: markers // 이미지 지도에 표시할 마커 
	    };    
	
	// 이미지 지도를 생성합니다
	var staticMap = new kakao.maps.StaticMap(staticMapContainer, staticMapOption);