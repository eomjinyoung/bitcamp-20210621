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

### 2단계 - 로그인 여부에 따라 메뉴 출력을 제어한다.

- com.eomcs.pms.handler.AuthHandler 클래스 변경
  - 다른 객체에서 로그인 여부를 조회할 수 있도록 기능을 추가한다.
  - loginUser 필드는 스태틱 멤버로 전환한다.
  - 로그인 멤버 정보를 리턴해주는 스태틱 메서드 getLoginUser()를 정의한다.
- com.eomcs.pms.handler.MenuGroup 클래스 변경
  - execute() 메서드 변경
  - 백업: MenuGroup.java.01
  - 리팩토링 수행

### 3단계 - 메뉴를 구성할 때 로그인 여부를 검사하는 메뉴는 따로 설정한다.

- com.eomcs.pms.App 클래스 변경
  - createMenu() 메서드 변경

## 실습 결과

- src/main/java/com/eomcs/menu/App.java 변경
- src/main/java/com/eomcs/pms/handler/AuthHandler.java 변경
- src/main/java/com/eomcs/menu/MenuGroup.java 변경