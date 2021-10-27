# 23-a. 웹 애플리케이션 서버 아키텍처로 전환하기 : Servlet 기술 도입


이번 훈련에서는,
- **JavaEE** 의 **Servlet/JSP** 기술을 이용하여 기존의 애플리케이션 서버 아키텍처를 웹 애플리케이션 서버(Web Application Server: WAS) 아키텍처로 전환할 것이다.  

## 훈련 목표
-

## 훈련 내용
-

## 실습

### 1단계 - 클라이언트를 웹 브라우저로 교체하기 위해 통신 프로토콜을 HTTP 로 변경한다.

- com.eomcs.pms.ServerApp 클래스 변경
  - HTTP 프로토콜에 따라 요청을 받고 응답할 수 있도록 변경한다.
  - 임시적으로 세션 관리 기능을 제거한다.
  - 클라이언트에서 서버 종료를 요청한 경우 처리해주는 코드를 제거한다.
    - `terminate()` 메서드 제거
- 테스트:
  - `ClientApp` 대신에 웹 브라우저를 실행한 후 주소창에 다음과 같이 주소를 입력한다.
    - localhost:8888/board/list
    - localhost:8888/member/list
    - localhost:8888/project/list
  - 단 입력이 필요한 명령은 HTTP 프로토콜에 맞추지 않았기 때문에 지금은 실행할 수 없다.

## 실습 결과
- src/main/java/com/eomcs/pms/ServerApp.java 변경