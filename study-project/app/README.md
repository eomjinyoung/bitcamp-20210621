# 13-e. 사용자 인증 : 로그인 정보 활용

이번 훈련에서는 **로그인(login)/로그아웃(logout)** 을 구현해 보자.
 
## 훈련 목표

- 


## 훈련 내용

- 

## 실습


### 1단계 - 게시글을 관리할 때 로그인 정보를 사용한다.

- com.eomcs.pms.handler.Board 클래스 변경
  - writer 필드 변경: 회원 정보를 저장할 수 있도록 타입을 Member로 변경한다. 
- com.eomcs.pms.handler.BoardHandler 클래스 변경
  - add() 메서드 변경 : 작성자에 로그인 회원 정보를 저장한다.
  - list() 메서드 변경 : 작성자 이름 출력
  - detail() 메서드 변경 : 작성자 이름 출력
  - update() 메서드 변경 : 작성자 여부 검사
  - delete() 메서드 변경 : 작성자 여부 검사

### 2단계 - 프로젝트를 관리할 때 로그인 정보를 사용한다.

- com.eomcs.pms.handler.Project 클래스 변경
  - owner 필드 변경: 회원 정보를 저장할 수 있도록 타입을 Member로 변경한다. 
  - members 필드 변경: 여러 명의 회원 정보를 저장할 수 있도록 타입을 List<Member>로 변경한다. 
- com.eomcs.pms.handler.MemberHandler 클래스 변경
  - promptMembers() 메서드 변경 :  메서드의 리턴 타입을 List<Member> 로 변경
- com.eomcs.pms.handler.ProjectHandler 클래스 변경
  - add() 메서드 변경 : 작성자에 로그인 회원 정보를 저장한다.
  - list() 메서드 변경 : 작성자 이름 출력
  - detail() 메서드 변경 : 작성자 이름 출력
  - update() 메서드 변경 : 작성자 여부 검사
  - delete() 메서드 변경 : 작성자 여부 검사


### 3단계 - 작업을 관리할 때 로그인 정보를 사용한다.

- com.eomcs.pms.handler.Project 클래스 변경
  - owner 필드 변경: 회원 정보를 저장할 수 있도록 타입을 Member로 변경한다. 
  - members 필드 변경: 여러 명의 회원 정보를 저장할 수 있도록 타입을 List<Member>로 변경한다. 
- com.eomcs.pms.handler.MemberHandler 클래스 변경
  - promptMembers() 메서드 변경 :  메서드의 리턴 타입을 List<Member> 로 변경
- com.eomcs.pms.handler.ProjectHandler 클래스 변경
  - add() 메서드 변경 : 작성자에 로그인 회원 정보를 저장한다.
  - list() 메서드 변경 : 작성자 이름 출력
  - detail() 메서드 변경 : 작성자 이름 출력
  - update() 메서드 변경 : 작성자 여부 검사
  - delete() 메서드 변경 : 작성자 여부 검사


## 실습 결과

- src/main/java/com/eomcs/menu/App.java 변경
- src/main/java/com/eomcs/pms/handler/AuthHandler.java 변경
- src/main/java/com/eomcs/menu/MenuGroup.java 변경