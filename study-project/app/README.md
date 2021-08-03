# 08-b. `Composite` 디자인 패턴 : 적용 후

사용자가 직접 명령어를 입력하는 대신에 메뉴를 통해 명령을 실행하도록 변경해 보자.

## 훈련 목표

- `Composite` 디자인 패턴의 용도와 실행 원리를 이해한다.

## 훈련 내용

- 메뉴를 출력하는 기능을 추가한다.
- 사용자로부터 긴 명령어를 입력받는 대신에 메뉴 번호를 입력 받는다.  
- 메뉴 번호에 따라 기능을 수행한다.

## 실습

### 1단계 - `Component` 역할을 정의한다.

- com.eomcs.pms.menu.Menu 클래스 추가
  - 직접 사용할 클래스가 아니기 때문에,  추상클래스로 정의한다.
  - execute(): 서브 클래스에서 재정의해야 하기 때문에, 추상메서드로 선언한다.

### 2단계 - `Composite` 역할을 정의한다.

- com.eomcs.pms.menu.MenuGroup 클래스 추가
  - execute() 구현 : 메뉴를 출력하고 사용자로부터 번호를 입력 받는 일을 한다.
  - 하위 메뉴를 다룰 수 있도록 add()/remove()/getMenu()/indexOf() 메서드를 추가한다.

### 3단계 - `Leaf` 역할을 정의한다.

- com.eomcs.pms.menu.MenuItem 클래스 추가
  - execute() 구현 : 메뉴 이름을 출력한다.

## 실습 결과

- src/main/java/com/eomcs/pms/App.java 변경
