# spring1weekmyproject


	1. 아래의 요구사항을 기반으로 Use Case 그려보기 
	        ○ 손으로 그려도 됩니다.
	        ○ cf. https://narup.tistory.com/70
	2. 전체 게시글 목록 조회 API 
	        ○ 제목, 작성자명, 작성 날짜를 조회하기
	        ○ 작성 날짜 기준으로 내림차순 정렬하기
	3. 게시글 작성 API 
	        ○ 제목, 작성자명, 비밀번호, 작성 내용을 입력하기
	4. 게시글 조회 API 
	        ○ 제목, 작성자명, 작성 날짜, 작성 내용을 조회하기 (검색 기능이 아닙니다. 간단한 게시글 조회만 구현해주세요.)
	5. 게시글 비밀번호 확인 API 
	        ○ 비밀번호를 입력 받아 해당 게시글의 비밀번호와 일치여부 판단하기
	6. 게시글 수정 API 
	        ○ 제목, 작성자명, 비밀번호, 작성 내용을 수정되게 하기
	7. 게시글 삭제 API 
	        ○ 글이 삭제되게 하기

기능	METHOD	URL	REQUEST	RESPONSE
게시글 목록 조회	GET	API/bot		{ "createdAt": "날짜,시간”, "modifiedAt": "날짜,시간”, "id": 1, "title": "제목", "content": "글 내용", "author": "작성자" }, { "createdAt": "날짜,시간”, "modifiedAt": "날짜,시간”, "id": 2, "title": "제목", "content": "글 내용", "author": "작성자" }, 
게시글 작성	POST	API/bot	{ "title": "제목", "content": "글 내용","password" :"비밀번호", "author": "작성자" }	
게시글 조회	GET	API/bot/{id}		{ "createdAt": "날짜,시간”, "modifiedAt": "날짜,시간”, "id": 1, "title": "제목", "content": "글 내용", "author": "작성자" }
게시글 비밀번호 확인	POST	API/post/{id}	{"password" : "password"}	
게시글 수정	PUT	API/bot/{id}	{"title": "제목", "content": "글 내용", "password" :"비밀번호" , "author": "작성자" }	{"createdAt": "날짜,시간”, "modifiedAt": "날짜,시간”, "id": 1, "title": "제목", "content": "글 내용", "password" :"비밀번호" , "author": "작성자" }
게시글 삭제	DELETE	API/bot/{id}		성공!

3계층 설계 해보기

	1. Controller

BotController

	2. Service

BotService

	3. Repository

Bot : 게시글

BotRepository : 게시글 조회하기

BotRequestDto : 게시글 작성하기

BotCheckRequestDto : 패스워드 체크해보기

Timestamped : 시간 상속 하기




	1. 수정, 삭제 API의 request를 어떤 방식으로 사용하셨나요? (param, query, body) =>body로 제출하였습니다.
	2. 어떤 상황에 어떤 방식의 request를 써야하나요? => 작성할때 post로 request, 비번 확인할때 post로 request, 게시글 수정할때  put으로 request
	3. RESTful한 API를 설계했나요? 어떤 부분이 그런가요? 어떤 부분이 그렇지 않나요? =>비밀번호와 상세하게 한거 같은데 약간 분리되어있는 부분이 부족하다?라는 생각이 듭니다.
	4. 적절한 관심사 분리를 적용하였나요? (Controller, Repository, Service) =>그렇지만도 아닌거 같습니다.
	5. 작성한 코드에서 빈(Bean)을 모두 찾아보세요! =>controller, repository,service
	6. API 명세서 작성 가이드라인을 검색하여 직접 작성한 명세서와 비교해보세요! => 많이 좋지는 않네요
	
![image](https://user-images.githubusercontent.com/43533141/194229684-0f06202d-ab8d-40fa-b051-4d9c05b3bf2f.png)
