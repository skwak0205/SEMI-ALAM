[ALAM]: http://qclass.iptime.org:8585/SEMI-ALAM/

# ALAM (Anywhere Learn Anytime Meet)

#### 주제 

언택트 서비스를 중점으로 한 온/오프라인 강의 사이트

#### 이유

작품 구상당시 무엇을 만들어야될까 고민하고 있을 때 작년 초 갑자기 코로나가 전세계를 급습해서 엄청난 전염속도를 보여주었습니다. 그로인해 거리두기 단계가 한층 격상하면서 주위에 있는 많은 서비스들이없어지는 향상을 보였지만 배달과 같은 언택트 서비스들은 이전에 볼수 없는 성장세를 보여주고 현재도 급상승하고 있습니다. 이러한 현상들을 보고 저희도 배달이외에 다른 언택트 서비스들을  중심으로 조사해 보았습니다. 조사해본 결과 여러 언택트 서비스들중 실제로 사용자가 많이 이용하고 유용할것같은 주제를 토대로 ALAM프로젝트를 계획하게 되었습니다.

#### 개발 환경

 - 운영체제 : Windows OS
 - 개발도구 : Eclipse, VS Code
 - DBMS : Oracle DB - sqldeveloper
 - Server : Apache Tomcat 9.0
 - Language : Java, Jsp, Servlet, Html5, CSS3, JavaScript, jQuery, Node.js

#### 사용한 API, 라이브러리

- KAKAO LOGIN API
- KAKAO MAP API
- NAVER LOGIN API
- NAVER SENSE API
- 우편번호/도로명 주소 API
- Summernote
- fullCalendar
- 아임포트 / 카카오 페이
- Socket.io
- Peer.js

#### 구현 기능

- 전체 페이지
  1. 비 회원은 멘티가 요청한 강의 페이지, 온라인 강의 페이지, 고객센터 페이지 접근 가능
  2. 메인 페이지에서 카테고리 별 아이콘 클릭 시, 해당 카테고리 강의 요청 게시판으로 이동

- 회원 서비스
  1. 회원 가입 / SNS 로그인 / 아이디, 비밀번호 찾기 / 정보 수정 / 탈퇴 / 일정 관리 / 주변 카페 검색 / 채팅 / 화상 채팅 / 고객센터 게시판 글 작성, 수정 및 삭제 / 신고 게시판 검색 / 온라인 강의 결제
  2. Mybatis를 사용하여 DB연결 후 SQL문 활용
  3. Session 이용한 회원제 서비스
  4. 회원이 멘티 등급일 경우, 강의 요청 글 작성, 수정 및 삭제 가능
  5. 회원이 멘티 등급일 경우, 멘토로 등급 요청 가능
  6. 회원이 멘토 등급일 경우, 온라인 강의 업로드 가능

- 관리자 서비스
  1. 고객 센터 게시판 관리 및 답변 / 회원 정보 조회 및 제명 / 멘토 신청 수락





## 프로젝트 데모

- 메인 페이지

<img src="C:\Users\gsj24\Downloads\qclass.iptime.org_8585_SEMI-ALAM_.png" alt="메인페이지" style="zoom:50%;" />



- 회원 가입 페이지

<img src="C:\Users\gsj24\AppData\Roaming\Typora\typora-user-images\image-20210522170409914.png" alt="image-20210522170409914" style="zoom:80%;" />



- 로그인 페이지

<img src="C:\Users\gsj24\AppData\Roaming\Typora\typora-user-images\image-20210522170607619.png" alt="image-20210522170607619" style="zoom:80%;" />



- 아이디 / 비밀번호 찾기

  <img src="C:\Users\gsj24\AppData\Roaming\Typora\typora-user-images\image-20210522170642242.png" alt="image-20210522170642242" style="zoom:80%;" />



- 채팅 페이지

  ![image-20210522171310535](C:\Users\gsj24\AppData\Roaming\Typora\typora-user-images\image-20210522171310535.png)![image-20210522171357026](C:\Users\gsj24\AppData\Roaming\Typora\typora-user-images\image-20210522171357026.png)

  

- 화상채팅 페이지

  ![](C:\Users\gsj24\Downloads\localhost_8787_SEMI-ALAM_video.do.png)



- 일정관리 페이지

  ![image-20210522172129186](C:\Users\gsj24\AppData\Roaming\Typora\typora-user-images\image-20210522172129186.png)



- 결제 페이지

  ![image-20210522172232869](C:\Users\gsj24\AppData\Roaming\Typora\typora-user-images\image-20210522172232869.png)
