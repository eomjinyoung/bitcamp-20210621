# 10-c. 상속 활용 : ArrayList, LinkedList를 직접 쓰기

이번 훈련에서는 서브 클래스들의 공통 필드와 메서드를 추출하여 수퍼 클래스로 정의하는 것을 연습한다.

## 훈련 목표

- 

## 훈련 내용

- 

## 실습

### 1단계 - `BoardList` 대신 `ArrayList`를 직접 사용한다.

- com.eomcs.pms.handler.BoardHandler 클래스 변경
  - BoardList 대신 ArrayList 를 직접 사용한다.
  - BoardList에 있던 findByNo() 를 이 클래스로 가져온다.
- com.eomcs.pms.handler.BoardList 클래스 삭제





, `MemberList`, `ProjectList2`, `TaskList2` 의 공통점을 뽑아 수퍼 클래스 `LinkedList`를 정의한다.
### 2단계 - `XxxHandler` 클래스는 `XxxList` 대신에 `XxxList2`를 사용한다.

- com.eomcs.pms.handler.BoardHandler 클래스 변경
- com.eomcs.pms.handler.MemberHandler 클래스 변경
- com.eomcs.pms.handler.ProjectHandler 클래스 변경
- com.eomcs.pms.handler.TaskHandler 클래스 변경

## 실습 결과

- src/main/java/com/eomcs/pms/handler/LinkedList.java 추가
- src/main/java/com/eomcs/pms/handler/BoardList2.java 변경
- src/main/java/com/eomcs/pms/handler/MemberList2.java 변경
- src/main/java/com/eomcs/pms/handler/ProjectList2.java 변경
- src/main/java/com/eomcs/pms/handler/TaskList2.java 변경
- src/main/java/com/eomcs/pms/handler/BoardHandler.java 변경
- src/main/java/com/eomcs/pms/handler/MemberHandler.java 변경
- src/main/java/com/eomcs/pms/handler/ProjectHandler.java 변경
- src/main/java/com/eomcs/pms/handler/TaskHandler.java 변경
