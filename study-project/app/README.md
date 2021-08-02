# 08-a. 08-a. `Composite` 디자인 패턴 : 적용 전

사용자가 직접 명령어를 입력하는 대신에 메뉴를 통해 명령을 실행하도록 변경해 보자.

## 훈련 목표

- `Composite` 디자인 패턴의 용도와 실행 원리를 이해한다.

## 훈련 내용

- 메뉴를 출력하는 기능을 추가한다.
- 사용자로부터 긴 명령어를 입력받는 대신에 메뉴 번호를 입력 받는다.  
- 메뉴 번호에 따라 기능을 수행한다.

## 실습

### 1단계 - 직접 명령을 입력하는 대신에 메뉴에서 원하는 기능을 선택하도록 변경한다.

- `App`을 실행하면 다음과 같이 메인 메뉴를 출력한다.
- 메뉴 번호를 입력하면 해당 기능을 처리하는 객체에 실행을 위임한다.

```
[메인]
1. 게시판
2. 회원
3. 프로젝트
4. 작업
0. 종료
메인> 0     <--- 사용자가 메뉴 번호를 입력
안녕!       <--- 출력 후 프로그램 실행 종료
```

```
[메인]
1. 게시판
2. 회원
3. 프로젝트
4. 작업
0. 종료
메인> 1     <--- 사용자가 메뉴 번호를 입력

[메인/게시판]
1. 등록
2. 목록
3. 상세 보기
4. 변경
5. 삭제
0. 이전 메뉴
게시판> 0

[메인]
1. 게시판
2. 회원
3. 프로젝트
4. 작업
0. 종료
메인>
```

#### 작업 파일

- com.eomcs.pms.App 클래스 변경


### 2단계 - `BoardHandler`에 메뉴 출력 기능을 추가한다.

- 사용자가 메인 메뉴에서 게시판 메뉴를 선택하면 그 하위 메뉴를 출력한다.
- 다음과 같이 사용자가 입력한 메뉴 번호에 따라 기능을 수행한다.


```
메인 / 게시판 ---------------------------------
1. 등록
2. 목록
3. 상세 보기
4. 변경
5. 삭제
0. 이전 메뉴
게시판> 1   <--- 사용자가 메뉴 번호를 입력

[게시글 등록]
번호? 1
제목? aaa
내용? bbb
작성자? ok
게시글을 등록하였습니다.
```

#### 작업 파일

- com.eomcs.pms.handler.BoardHandler 클래스 변경
- com.eomcs.pms.App 클래스 변경


### 3단계 - `MemberHandler`, `ProjectHandler`, `TaskHandler` 에 메뉴 출력 기능을 추가한다.

- BoardHandler와 같이 사용자에게 하위 메뉴를 출력하도록 변경한다.
- 또한 사용자가 입력한 메뉴 번호에 따라 기능을 수행하도록 변경한다.

#### 작업 파일

- com.eomcs.pms.handler.BoardHandler 클래스 변경
- com.eomcs.pms.handler.MemberHandler 클래스 변경
- com.eomcs.pms.handler.ProjectHandler 클래스 변경
- com.eomcs.pms.handler.TaskHandler 클래스 변경
- com.eomcs.pms.App 클래스 변경

## 실습 결과

- src/main/java/com/eomcs/pms/handler/BoardHandler.java 변경
- src/main/java/com/eomcs/pms/handler/MemberHandler.java 변경
- src/main/java/com/eomcs/pms/handler/ProjectHandler.java 변경
- src/main/java/com/eomcs/pms/handler/TaskHandler.java 변경
- src/main/java/com/eomcs/pms/App.java 변경
