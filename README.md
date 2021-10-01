# bitcamp-20210621

## 1일차(2021-06-28,월)
- 교육과정의 목표: 웹 개발자 역량 습득
- 웹 개발자의 진로: SI/SM, 스타트업, 서비스, 공사 등
- 소프트웨어 개요
	- System S/W, Application S/W
	- Standalone, Client/Server, Web Application
	- Web application 구성 요소: Java App, HTML/CSS/JavaScript
	- Back-end 개발: Java Application을 작성할 때 사용되는 기술 개요
	- Front-end 개발: HTML/CSS/JavaScript 기술 개요
- 프로그래밍 도구 준비
	- WebEx 온라인 화상 통신 설치
	- github.com 계정 생성
	- github.com에 개인 저장소 생성
	- 강사의 저장소 가져오기
	- 저장소에 추가된 파일 가져오기

## 2일차(2021-06-29,화)
- 프로그래밍 도구 준비(계속)
	- git 저장소 다루기
		- git 서버 저장소를 로컬로 복제
		- 작업 파일을 로컬 저장소에 백업
		- 로컬 저장소의 내용을 서버 저장소에 업로드
		- 서버 저장소의 변경 내용을 로컬 저장소로 가져오기
	- VSCode 편집기 설치
	- mingw64 윈도우 gcc 컴파일 설치
	- node.js 자바스크립트 인터프리터 설치
- 프로그램 만들고 실행하기
	- 컴파일 방식
		- C 언어로 "Hello, world!" 를 출력하는 프로그램 만들기 
		- 소스와 기계어, 컴파일, 컴파일러의 관계
		- 기계어란? 
			- CPU instruction set
			- 기계어와 CPU의 관계
			- 기계어와 OS의 관계
	- 인터프리터 방식
		- JavaScript 언어로 "Hello, world!" 를 출력하는 프로그램 만들기

## 3일차(2021-06-30,수)
- 프로그래밍 도구 준비(계속)
	- Java 11 JDK 설치
		- JAVA_HOME 환경 변수 설정
		- PATH 환경 변수 설정
- 프로그램 만들고 실행하기(계속)
	- 컴파일 방식과 인터프리터 방식 비교
		- 프로그래밍 언어와 컴파일, 컴파일러
	- 자바의 프로그래밍 방식 소개
		- 컴파일과 실행
- 자바 애플리케이션 프로젝트 폴더 준비
	- 애플리케이션과 프로젝트의 관계
	- git 저장소에서 프로젝트 관리하기
		- 1단계: 소스파일과 .class 파일을 구분하지 않는다.
		- 2단계: src 폴더와 bin 폴더를 사용하여 소스 파일과 .class 파일을 분리한다.
		- 3단계: Maven 프로젝트 표준 디렉토리 구조
		- 4단계: git 저장소에 여러 개의 프로젝트 두기
- 수업 자료 준비하기
	- 자바 프로그래밍 기본 문법 예제
		- https://github.com/eomcs/eomcs-java
	- 개발 도구 설정 및 사용 안내서 
		- https://github.com/eomcs/eomcs-docs
	- 서블릿/JSP 예제
		- https://github.com/eomcs/eomcs-java-web
	- Spring 프레임워크 예제
		- https://github.com/eomcs/eomcs-spring-webmvc
	- 미니 프로젝트 관리 시스템 단계별 구현 예제
		- https://github.com/eomcs/eomcs-java-project-2021

## 4일차(2021-07-01,목)
- 프로그래밍 도구 준비(계속)
	- Gradle 설치
		- PATH 환경 변수 등록
- 프로젝트 관리
	- 애플리케이션과 프로젝트
	- 루트 프로젝트와 서브 프로젝트
	- 프로젝트와 작업
	- 프로젝트 산출물을 보관하기 위한 디렉토리 구조
	- 팀 프로젝트와 깃 저장소
	- 깃 저장소로 프로젝트를 관리하는 다양한 유형
- 교육 과정 진행 
	- 이론과 실전 프로젝트를 병행하여 학습
	- 실전 프로젝트(study-project)의 로드맵
- 빌드 도구
	- 빌드 도구 개요
	- 다양한 빌드 도구: Ant, Maven, Gradle
	- Gradle 빌드 도구를 이용하여 프로젝트 폴더 준비
		- `gradle init`
	- Gradle 빌드 도구로 생성한 디렉토리의 구조 및 파일 설명
- Gradle 빌드 도구 사용법
	- 빌드 스크립트 파일의 용도
		- settings.gradle : 여러 프로젝트에 공통으로 적용할 설정 정보.
		- app/build.gradle : 서브 프로젝트에만 적용하는 빌드 설정 정보.
	- Gradle 기본 작업
		- init : 현재 폴더를 프로젝트 폴더로 구성
		- wrapper : Gradle 설치 및 실행 파일 생성
		- gradle에 플러그인을 장착하면 더 많은 작업을 수행할 수 있다.
	- 'java' gradle 플러그인  
		- compileJava
			- src/main/java 폴더에 있는 소스 파일을 모두 컴파일
			- build/classes/java/main 폴더에 .class 파일을 둔다.
		- compileTestJava
			- src/test/java 폴더에 있는 소스 파일을 모두 컴파일
			- build/classes/java/test 폴더에 .class 파일을 둔다.
		- processResources
			- src/main/resources 폴더에 있는 파일을 build/resources/main 폴더에 복사한다.
		- processTestResources
			- src/test/resources 폴더에 있는 파일을 build/resources/test 폴더에 복사한다.
		- clean
			- build 폴더를 삭제한다.
		- classes
			- compileJava와 processResources를 모두 수행
		- testClasses
			- classes + compileTestJava + processTestResources 수행
		- check
			- test + 단위 테스트 수행
		- javadoc
			- 소스 파일에서 javadoc 주석을 추출하여 HTML된 API 문서를 생성한다.
		- build
			- check + assemble(배포 파일 생성 작업) 수행
	- 'application' gradle 플러그인  	
		- run
			- 'java' 플러그인의 classes 작업을 먼저 실행한다.
			- 그런 후 application 설정에 지정한 클래스를 실행한다.
		- build
			- 이 플러그인을 장착한 상태에서 build 작업을 수행하면 고객에게 배포할 수 있는 파일을 build/distributions 폴더에 생성한다.
			- 자바 프로그램을 실행시킬 수 있는 스크립트 파일도 자동 생성된다.
	- 정리
		- 1) init 작업을 통해 프로젝트 폴더를 준비한다.
		- 2) build.script에 빌드 작업이 들어 있는 플러그인을 설정한다.		
		- 3) 각 플러그인의 작업을 실행할 때 필요한 정보를 등록한다.
		- 4) 프로젝트에서 사용할 외부 라이브러리 파일을 등록한다.
		- 5) 필요한 작업을 실행하여 애플리케이션을 빌드한다.
- 실전 프로젝트(eomcs-java-project)
	- 01-a. 프로젝트 준비하기 : Gradle 빌드 도구를 활용한 자바 프로젝트 구성

## 5일차(2021-07-01,금)
- 프로그래밍 도구 준비(계속)
	- eclipse.org 에서 개발 도구 다운로드 및 설치
	- eclipse IDE 환경 설정    
		- eomcs-docs/devtool/개발도구준비.md 파일 참조
- git 다루기
	- 로컬 저장소 만들기
		- `git init`
	- 서버 저장소 만들기 
		- `github.com`에서 new 버튼 클릭
	- 로컬 저장소에 서버 저장소의 위치를 등록하기
		- `git remote origin 서버저장소URL`
	- 로컬 저장소의 내용을 서버에 올리기
		- `git push`
- 자바 기초 문법(eomcs-java/com.eomcs.lang)
	- ex01
		- 패키지 다루기
		- 자바 소스 파일과 클래스 블록
		- 소스 파일의 인코딩
		- main() 메서드
	- ex02
		- 여러 줄 주석, 한 줄 주석
		- javadoc 주석
		- 애노테이션
- 실전 프로젝트(eomcs-java-project)
	- 01-b. 프로젝트 준비하기 : `이클립스 IDE`로 임포트

## 6일차(2021-07-05,월)
- 프로그래밍 도구 준비(계속)
	- VSCode Live 확장 팩 플러그인 추가
	- 라이브 코딩 작업 테스트
- 자바 기초 문법(eomcs-java/com.eomcs.lang)
	- ex99
		- 콘솔 출력 다루기: print(), println(), printf()
	- ex03
		- 리터럴 표기법 요약 정리
		- 값을 메모리에 저장하는 방법: RAM, HDD
		- 10진수, 8진수, 2진수, 16진수 표기법
		- 정수를 2진수로 저장하는 방법
		- 메모리 크기에 따른 값의 범위
- 실전 프로젝트(eomcs-java-project)
	- 02-a. 값 다루기 : 리터럴과 콘솔 출력

## 7일차(2021-07-06,화)
- 프로그래밍 도구 준비(계속)
	- VSCode Hex Editor 플러그인 추가
	- .class 파일을 16진수 값으로 보기 : 부동소수점이 2진수로 표현됐을 때의 2진수 값 확인
- 자바 기초 문법(eomcs-java/com.eomcs.lang)
	- ex03
		- 부동소수점을 2진수로 표현하는 방법: IEEE 754 명세
		- 문자를 2진수로 표현하는 방법: ASCII, ISO-8859-2, EUC-KR, 조합형, Unicode, UTF-8 문자 집합 소개
		- 이스케이프 문자를 다루는 방법
		- Raster 폰트(그림)과 Vector 폰트(그림) 비교 
		- 줄바꿈 코드: 0D(Carrage Return; CR), 0A(Line Feed; LF)

## 8일차(2021-07-07,수)
- 자바 기초 문법(eomcs-java/com.eomcs.lang)
	- ex04
		- 변수와 변수 선언: 데이터 타입과 변수명
		- primitive data type: byte, short, int, long, float, double, boolean
	- ex99
		- Scanner 를 이용하여 키보드 입력 다루기
- 실전 프로젝트(eomcs-java-project)
	- 02-b. 값 다루기 : 변수와 키보드 입력

## 9일차(2021-07-08,목)
- 자바 기초 문법(eomcs-java/com.eomcs.lang)
	- com.eomcs.lang.ex04
		- 배열 다루기
	- com.eomcs.lang.ex06
		- if, if ~ else 
		- while, for
- 자바 기본 클래스(eomcs-java/com.eomcs.basic)		
	- com.eomcs.basic.ex10
		- java.util.Date 클래스 사용법
		- java.sql.Date 클래스 사용법
- 실전 프로젝트(eomcs-java-project)
	- 02-c. 값 다루기 : 배열과 흐름 제어문 활용

## 10일차(2021-07-09,금)
- 자바 기초 문법(eomcs-java/com.eomcs.lang)
	- ex04: 배열 다루기(계속)
	- ex05: 연산자 사용법

## 10일차(2021-07-09,금)
- 자바 기초 문법(eomcs-java/com.eomcs.lang)
	- ex04: 배열 다루기(계속): 배열 레퍼런스와 오프셋 주소
	- ex05: 연산자 사용법

## 11일차(2021-07-12,월)
- 자바 기초 문법(eomcs-java/com.eomcs.lang)
	- ex05: 연산자 사용법(계속) : 비트 이동 연산자
	- ex06: 조건문, 반복문
- 실전 프로젝트(eomcs-java-project)
	- 03-a. 메서드 사용법 : 프로그램의 시작점(entry point), `main()`, 조건문, 반복문

## 12일차(2021-07-13,화)
- 실전 프로젝트(eomcs-java-project)
	- 03-b. 메서드 사용법 : 메서드 활용

## 13일차(2021-07-14,수)
- 자바 기초 문법(eomcs-java/com.eomcs.lang)
	- ex07
		- 메서드 활용
		- call by value 와 call by reference
		- JVM의 메모리 영역: Method Area, JVM Stack, Heap
		- 클래스의 인스턴스 메모리
		
## 14일차(2021-07-15,목)
- 자바 기초 문법(eomcs-java/com.eomcs.lang)
	- ex07
		- 메서드에서 new 연산자를 사용하여 변수를 만들기: Heap 영역
		- 재귀호출과 스택 오버플로우
		- main() 메서드와 프로그램 아규먼트
		- JVM 아규먼트
- 알고리즘 (com.eomcs.algorithm)
	- quiz: Test001 ~ Test004

## 15일차(2021-07-16,금)
- 실전 프로젝트(eomcs-java-project)
	- 04-a. 클래스 사용법 : 메서드 분류
	- 04-b. 클래스 사용법 : 새 데이터 타입 정의 
	- 04-c. 클래스 사용법 : 패키지로 클래스 분류

## 16일차(2021-07-19,월)
- 실전 프로젝트(eomcs-java-project)
	- 04-d. 클래스 사용법 : 의존 관계
	- 05-a. 인스턴스 사용법 : 클래스 필드와 클래스 메서드의 한계
	- 05-b. 인스턴스 사용법 : 인스턴스 필드가 필요한 이유와 사용법

## 17일차(2021-07-20,화)
- 자바 객체지향 문법(eomcs-java/com.eomcs.oop)
	- ex02
		- 스태틱 필드, 인스턴스 필드, 로컬 변수 비교와 활용
		- 스태틱 메서드, 인스턴스 메서드 비교와 활용

## 18일차(2021-07-21,수)
- 자바 객체지향 문법(eomcs-java/com.eomcs.oop)
	- ex00: 스태틱 필드/인스턴스 필드, 스태틱 메서드/인스턴스 메서드
- 실전 프로젝트(eomcs-java-project)
	- 05-c. 인스턴스 사용법 : 인스턴스 메서드가 필요한 이유와 사용법
	- 06-a. CRUD 구현하기 : 게시글 상세보기/변경

## 19일차(2021-07-22,목)
- 자바 객체지향 문법(eomcs-java/com.eomcs.oop)
	- ex00: 스태틱 필드/인스턴스 필드, 스태틱 메서드/인스턴스 메서드 활용 연습
- 실전 프로젝트(eomcs-java-project)
	- 06-a. CRUD 구현하기(계속) : 게시글 삭제

## 20일차(2021-07-23,금)
- 실전 프로젝트(eomcs-java-project)
	- 06-a. CRUD 구현하기(계속) : 회원/프로젝트/작업 CRUD 완성
	- 06-b. CRUD 구현하기 : 리팩토링

## 21일차(2021-07-26,월)
- 자바 객체지향 문법(eomcs-java/com.eomcs.oop)
	- ex01: 객체지향 문법 개요
- 실전 프로젝트(eomcs-java-project)
	- 07-a. 의존 객체 다루기 : 인스턴스 필드에 직접 주입
	- 07-b. 의존 객체 다루기 : 생성자로 주입

## 22일차(2021-07-27,화)
- 자바 객체지향 문법(eomcs-java/com.eomcs.oop)
	- ex03: 인스턴스 멤버와 스태틱 멤버 사용법

## 23일차(2021-07-28,수)
- 자바 객체지향 문법(eomcs-java/com.eomcs.oop)
	- ex04: 인스턴스 멤버와 스태틱 멤버 활용예
	- ex05.a ~ g : 상속 문법

## 24일차(2021-07-29,목)
- 자바 객체지향 문법(eomcs-java/com.eomcs.oop)
	- ex05: h ~ * : 상속 문법(계속)
	- ex06: a ~ c : 다형성(다형적 변수, 오버로딩, 오버라이딩)

## 25일차(2021-07-30,금)
- 자바 객체지향 문법(eomcs-java/com.eomcs.oop)
	- ex06: c ~ * : 다형성(다형적 변수, 오버로딩, 오버라이딩)(계속)
	- ex08: a ~ b : 캡슐화(private, (default), protected, public)
- 실전 프로젝트(eomcs-java-project)
	- 07-a. 의존 객체 다루기 : 인스턴스 필드에 직접 주입
	- 07-b. 의존 객체 다루기 : 생성자로 주입

## 26일차(2021-08-02,월)
- 실전 프로젝트(eomcs-java-project)
	- 08-a. `Composite` 디자인 패턴 : 적용 전
	- 08-b. `Composite` 디자인 패턴 : 적용 후

## 27일차(2021-08-03,화)
- 실전 프로젝트(eomcs-java-project)
	- 08-b. `Composite` 디자인 패턴 : 적용 후(계속)
	- 08-c. `Composite` 디자인 패턴 : 익명 클래스 활용
	- 08-d. `Composite` 디자인 패턴 : 스태틱 멤버를 인스턴스 멤버로 전환

## 28일차(2021-08-04,수)
- 자바 객체지향 문법(eomcs-java/com.eomcs.oop)
	- 상속 관계가 있는 클래스의 레퍼런스와 인스턴스
- 실전 프로젝트(eomcs-java-project)
	- 09-a. 데이터 처리 코드를 캡슐화 : 캡슐화 전 - 배열 크기 변경
	- 09-b. 데이터 처리 코드를 캡슐화 : 캡슐화 전 - 연결리스트 적용

## 29일차(2021-08-05,목)
- 실전 프로젝트(eomcs-java-project)
	- 09-c. 데이터 처리 코드를 캡슐화 : 캡슐화 수행
	- 09-d. 데이터 처리 코드를 캡슐화 : 캡슐화 후 -  배열 크기 변경
	- 09-e. 데이터 처리 코드를 캡슐화 : 캡슐화 후 -  연결리스트 적용
	- 10-a. 리팩토링 : Generalization
	- 10-b. 리팩토링 : Generalization II

## 30일차(2021-08-06,금)
- 실전 프로젝트(eomcs-java-project)
	- 10-c. 리팩토링 : ArrayList를 직접 사용하기
	- 10-d. 리팩토링 : LinkedList를 직접 사용하기
	- 10-e. 리팩토링 : Generalization + 다형성 + 의존 객체 주입(Dependecy Injection)
	- 10-f. 리팩토링 : 메서드 이동
	- 10-g. 리팩토링 : 인터페이스 적용
	- 10-h. 리팩토링 : 세터(setter), 게터(getter) 적용

## 31일차(2021-08-09,월)
- 자바 객체지향 문법(eomcs-java/com.eomcs.oop)
	- ex07: 추상 클래스와 추상 메서드
- 자바 기본 클래스 사용법(eomcs-java/com.eomcs.basic)
	- ex01: Object 클래스 사용법

## 32일차(2021-08-10,화)
- 자바 기본 클래스 사용법(eomcs-java/com.eomcs.basic)
	- ex01: Object 클래스 사용법(계속)
	- ex02: String 클래스 사용법
- 프로젝트 팀 결정 및 A/B 반 결정
	- 1 팀(A반) : 김태호,조주리,신현지,김진현
	- 2 팀(A반) : 김은채,전예린,송다혜,조솔,우형민
	- 3 팀(A반) : 반계령,배서연,하선영,김제이,김주창
	- 4 팀(B반) : 변민성,위정욱,박성준,구백연,이지호
	- 5 팀(B반) : 최보균,이혜연,방우주,이서은,조대희
	- 6 팀(B반) : 윤수민,이용진,홍지현,문세철
- 팀원 자리 배치 결정
- 팀 프로젝트 절차 소개
	- 프로젝트 주제 선정
		- 1차: 두 개 주제를 선정해서 소개
			- 프로젝트 설명(PPT)
				- 프로젝트명
				- 현황 및 문제점: 현재 해당 업무나 일을 처리하는 상황과 그에 따른 불편한 점
				- 해결방안 및 이점: 어떻게 해결할 것인지에 대한 목표와 그에 따른 사용자의 이점
			- UI 프로토타입 작성
				- 무료 웹 서비스를 이용하여 UI 프로토타입 작성
				- 프로젝트로 만들려는 서비스를 분명하게 공유하기 위함
		- 2차: 한 개 주제를 선정해서 상세하게 소개
			- 프로젝트 설명 개정
				- 기존 설명 보완
			- UI 프로토타입 상세화 
				- 기존 UI 프로토타입 보완
	- 요구사항 정의
		- 액터 식별 및 정의
		- 유스케이스 식별 및 정의
		- 유스케이스 명세서 작성
	- DB 모델링
		- ER 다이어그램 작성
		- 데이터베이스 생성 및 테이블 생성
	- 구현 
		- 애플리케이션 구현
	- 발표

## 33일차(2021-08-11,수)
- 자바 기본 클래스 사용법(eomcs-java/com.eomcs.basic)
	- ex02: Wrapper, Date, Calendar 클래스 사용법
- 자바 객체지향 문법(eomcs-java/com.eomcs.oop)
	- ex09(a1 ~ c): 인터페이스 문법

## 34일차(2021-08-12,목)
- 자바 객체지향 문법(eomcs-java/com.eomcs.oop)
	- ex09(d ~ h): 인터페이스와 추상 클래스의 협업, 인터페이스 활용

## 35일차(2021-08-13,금)
- 자바 객체지향 문법(eomcs-java/com.eomcs.oop)
	- ex09(i ~ j): 인터페이스 활용
	- ex11(a ~ c:Exam0240): 중첩 클래스 사용법
	
## 36일차(2021-08-17,화)
- 자바 객체지향 문법(eomcs-java/com.eomcs.oop)
	- ex11(c:Exam0310 ~ e): 중첩 클래스, 로컬 클래스 사용법

## 37일차(2021-08-18,수)
- 팀 프로젝트 
	- 1차: 프로젝트 주제 발표
		- 반계령,배서연,하선영,김제이,김주창(2개)
			- 당근마켓, 스터디위더스
		- 김태호,조주리,신현지,김진현(1개)
			- 멘탈케어
		- 변민성,위정욱,박성준,구백연,이지호(1개)
			- 봉사와 기부
		- 윤수민,이용진,홍지현,문세철(2개)
			- 그룹웨어, 주류파인더
		- 김은채,송다혜,조솔,우형민(2개)
			- 1인레시피, 나만의스터디
		- 최보균,이혜연,방우주,이서은,조대희(2개)
			- IN-APT, 오늘의손
- 프로젝트 개발 방법론
	- 요구사항 식별 방법
		- 액터와 유스케이스 식별 방법

## 38일차(2021-08-19,목)

- 프로젝트 개발 방법론
	- 요구사항 식별 방법
		- 액터와 유스케이스 식별 방법(계속)
- 실전 프로젝트(eomcs-java-project)
	- 10-i. 리팩토링 : 추상 클래스 적용
	- 11-a. 자료 구조 다루기 : 스택 구현과 사용

## 39일차(2021-08-20,금)

- 실전 프로젝트(eomcs-java-project)
	- 11-b. 자료 구조 다루기 : 리팩토링 - 클래스 및 패키지 이동
	- 11-c. 자료 구조 다루기 : 제네릭이 필요한 이유와 사용법
	- 11-d. 자료 구조 다루기 : 자바 컬렉션 API 사용하기
- 프로젝트 개발 방법론
	- 요구사항 식별 방법
		- 액터와 유스케이스 식별 방법(계속)
- 과제
	- com.eomcs.algorithm.data_structure 패키지의 예제를 학습
	- 각 스텝의 예제 파일을 따라하면서 학습할 것.
- 팀 프로젝트
	- 요구사항 정의: Usecase Model
		- 액터 다이어그램
		- 유스케이스 다이어그램
		- 핵심 유스케이스의 UI 프로토타입

## 40일차(2021-08-23,월)

- 제네릭 문법(eomcs-java/com.eomcs.generic)
	- ex01 ~ ex02: 제네릭 사용법
- 자바 컬렉션 API(eomcs-java/com.eomcs.basic)
	- ex03: ArrayList 사용법
- 자바 객체지향 문법(eomcs-java/com.eomcs.oop)
	- ex12(Exam0110 ~ Exam0160): 람다(lambda) 기본 사용법
- 팀 프로젝트
	- 요구사항 정의: Usecase Model(계속)

## 41일차(2021-08-24,화)

- 자바 객체지향 문법(eomcs-java/com.eomcs.oop)
	- ex12(Exam0210 ~ ): 람다(lambda) 기본 사용법
- 자바 컬렉션 API(eomcs-java/com.eomcs.basic)
	- ex03: ArrayList 사용법(계속)

## 42일차(2021-08-25,수)

- 자바 컬렉션 API(eomcs-java/com.eomcs.basic)
	- ex04 ~ ex06: LinkedList, Stack, Queue, Deque
- 팀 프로젝트 
	- 2차: 최종 프로젝트 주제 선정 발표 및 요구사항 모델 발표
		- 내용
			- 액터 다이어그램
			- 유스케이스 다이어그램
			- UI 프로토타입
		- 발표 순서
			- 윤수민,이용진,홍지현,문세철
				- 주류파인더
			- 최보균,이혜연,방우주,이서은,조대희
				- MySeoul
			- 반계령,배서연,하선영,김제이,김주창
				- 스터디위더스
			- 변민성,위정욱,박성준,구백연,이지호
				- 행복하share
			- 김은채,송다혜,조솔,우형민
				- 오늘의 공부
			- 김태호,조주리,신현지,김진현
				- APUJIMA

## 43일차(2021-08-26,목)

- 자바 컬렉션 API(eomcs-java/com.eomcs.basic)
	- ex07 ~ ex08: HashSet, HashMap, Hashtable

## 44일차(2021-08-27,금)

- 팀 프로젝트 
	- 3차: 중간 구현 점검
		- 발표 순서
			- 최보균,이혜연,방우주,이서은,조대희
				- MySeoul
			- 반계령,배서연,하선영,김제이,김주창
				- 스터디위더스
			- 변민성,위정욱,박성준,구백연,이지호
				- 행복하share
			- 김은채,송다혜,조솔,우형민
				- 오늘의 공부
			- 김태호,조주리,신현지,김진현
				- APUJIMA
			- 윤수민,이용진,홍지현,문세철
				- 주류파인더
- 실전 프로젝트(eomcs-java-project)
	- 12. 예외가 발생했을 때 시스템을 멈추지 않게 하는 방법

## 45일차(2021-08-30,월)

- 예외처리(eomcs-java/com.eomcs.exception)
- 실전 프로젝트(eomcs-java-project)
	- 13-a. 사용자 인증 : 로그인
	- 13-b. 사용자 인증 : 내 정보 보기 
	- 13-c. 사용자 인증 : 로그아웃
	- 13-d. 사용자 인증 : 로그인 여부에 따라 메뉴 출력 제어

## 46일차(2021-08-31,화)

- 예외처리(eomcs-java/com.eomcs.exception)(계속)
- 실전 프로젝트(eomcs-java-project)
	- 13-d. 사용자 인증 : 로그인 여부에 따라 메뉴 출력 제어(계속)
	- 13-e. 사용자 인증 : 로그인 정보 활용

## 47일차(2021-09-01,수)

- 실전 프로젝트(eomcs-java-project)
	- 14-a. `Command` 디자인 패턴 : 적용 전 문제점 확인
	- 14-b. `Command` 디자인 패턴 : 메서드를 객체로 분리
	- 14-c. `Command` 디자인 패턴 : 리팩토링
	- 14-d. `Command` 디자인 패턴 : 기능 추가를 통해 커맨드 패턴의 유용성 확인 

## 48일차(2021-09-02,목)

- 실전 프로젝트(eomcs-java-project)
	- 14-e. `Command` 디자인 패턴 : 인터페이스로 객체의 사용 규칙 통일
	- 14-f. `Command` 디자인 패턴 : `Map`으로 커맨드 객체 관리

## 49일차(2021-09-03,금)

- 실전 프로젝트(eomcs-java-project)
	- 15. 비트 연산자 활용: 메뉴 권한 관리
- 팀 프로젝트 
	- 4차: 중간 구현 점검
		- 발표 순서
			- 반계령,배서연,하선영,김제이,김주창
				- 스터디위더스
			- 변민성,위정욱,박성준,구백연,이지호
				- 행복하share
			- 김은채,송다혜,조솔,우형민
				- 오늘의 공부
			- 김태호,조주리,신현지,김진현
				- APUJIMA
			- 윤수민,이용진,홍지현,문세철
				- 주류파인더
			- 최보균,이혜연,방우주,이서은,조대희
				- MySeoul

## 50일차(2021-09-06,월)

- 팀 프로젝트 
	- 팀별 프로젝트 구현

## 51일차(2021-09-07,화)

- 실전 프로젝트(eomcs-java-project)
	- 16-a. 파일 입출력 다루기 : 바이너리 형식으로 데이터 입출력

## 52일차(2021-09-08,수)

- 자바 스트림 API(eomcs-java/com.eomcs.io)
	- ex01: File 클래스 사용법
	- ex02: FileInputStream/FileOutputStream 클래스 사용법
- 팀 프로젝트 
	- 팀별 프로젝트 구현

## 53일차(2021-09-09,목)

- 자바 스트림 API(eomcs-java/com.eomcs.io)
	- ex02: FileInputStream/FileOutputStream 클래스 사용법(계속)
	- ex03: FileReader/FileWriter 클래스 사용법
- 팀 프로젝트 
	- 팀별 프로젝트 구현

## 54일차(2021-09-10,금)

- 팀 프로젝트 
	- 팀별 프로젝트 구현
	- 5차: 중간 구현 점검
		- 발표 순서
			- 변민성,위정욱,박성준,구백연,이지호
				- 행복하share
			- 김은채,송다혜,조솔,우형민
				- 오늘의 공부
			- 김태호,조주리,신현지,김진현
				- APUJIMA
			- 윤수민,이용진,홍지현,문세철
				- 주류파인더
			- 최보균,이혜연,방우주,이서은,조대희
				- MySeoul
			- 반계령,배서연,하선영,김제이,김주창
				- 스터디위더스
- 디자인 패턴(eomcs-java/com.eomcs.design_pattern)
	- decorator: 데코레이터 패턴 소개
- 자바 스트림 API(eomcs-java/com.eomcs.io)
	- ex04: FileInputStream/FileOutputStream 을 이용하여 객체의 필드 값 출력하기
	- ex05: FileInputStream/FileOutputStream 을 상속 받아서 기능을 확장하기

## 55일차(2021-09-13,월)

- 자바 스트림 API(eomcs-java/com.eomcs.io)
	- ex06: 버퍼를 활용하는 이유
	- ex07: 상속으로 기능을 확장하는 방식의 한계점 이해하기
	- ex08: 포함관계로 기능을 확장하기
	- ex09: 데코레이터 설계 패턴을 적용하기
	- ex10: 자바에서 제공하는 스트림 클래스 사용하기
	- ex11: 객체를 serialize/deserialize 하기
- 팀 프로젝트 
	- 팀별 프로젝트 구현

## 56일차(2021-09-14,화)

- 자바 스트림 API(eomcs-java/com.eomcs.io)
	- ex11: 객체를 serialize/deserialize 하기(계속)
	- ex12: 연습
	- ex13: 스트림 API를 사용하여 바이트 배열이나 스트링 버퍼에 출력하기
	- ex14: 입출력 예외처리
- 실전 프로젝트(eomcs-java-project)
	- 16-a. 파일 입출력 다루기 : 바이너리 형식으로 데이터 입출력(계속)
		- BufferedInputStream/BufferedOutputStream 클래스 사용하기
		- 제네릭 문법 활용하기
	- 16-b. 파일 입출력 다루기 : 텍스트 형식으로 데이터 입출력
		- FileReader/FileWriter 클래스 사용하기
		- BufferedReader/PrintWriter 데코레이터 클래스 사용하기
- 팀 프로젝트 
	- 팀별 프로젝트 구현

## 57일차(2021-09-15,수)

- 실전 프로젝트(eomcs-java-project)
	- 16-b. 파일 입출력 다루기 : 텍스트 형식으로 데이터 입출력(계속)
		- BufferedReader/BufferedWriter 데코레이터 클래스 사용하기
		- 리팩토링 : 'Information Expert' GRASP 적용
		- 리팩토링 : '메서드 추출'
		- 리팩토링 : 제네릭 적용

## 58일차(2021-09-16,목)

- JSON Open API 사용법(eomcs-java/com.eomcs.openapi.json)
	- Gson 라이브러리를 사용하여 JSON 문자열을 다루는 방법
- 실전 프로젝트(eomcs-java-project)
	- 16-b. 파일 입출력 다루기 : 텍스트 형식으로 데이터 입출력(계속)
		- 리팩토링 : Task 도메인 클래스에 CsvValue 인터페이스 적용
		- JSON 형식으로 데이터를 입출력하기

## 59일차(2021-09-17,금)

- 실전 프로젝트(eomcs-java-project)
	- 17-a. 메뉴 리팩토링: 상세보기에서 변경, 삭제 기능 수행하기
	- 17-b. 메뉴 리팩토링: Command 인터페이스의 execute()에 파라미터 넘기기
	- 17-c. 메뉴 리팩토링: Command 객체 간에 종속성 제거하기
- 반 배치
	- A반
		- 김태호,조주리,신현지,김진현
		- 최보균,이혜연,방우주,이서은,조대희
		- 김은채,송다혜,조솔,우형민
	- B반
		- 반계령,하선영,김제이,김주창
		- 변민성,위정욱,박성준,구백연,이지호
		- 윤수민,이용진,홍지현,문세철
- 자리배치
	- A반(금요일)
		- [           칠    판         ]
		- [송다혜][XXXXXX][신현지][XXXXXX]
		- [XXXXXX][김태호][XXXXXX][우형민][XXXXXX]
		- [김진현][XXXXXX][이서은][XXXXXX][방우주]
		- [XXXXXX][조주리][XXXXXX][......][XXXXXX]
		- [최보균][XXXXXX][조대희][XXXXXX][이혜연]
		- [XXXXXX][조  솔][XXXXXX][김은채][XXX][에어콘]
	- B반(목요일)
		- [           칠    판         ]
		- [XXXXXX][......][XXXXXX][반계령]
		- [......][XXXXXX][변민성][XXXXXX][위정욱]
		- [XXXXXX][이용진][XXXXXX][하선영][XXXXXX]
		- [윤수민][XXXXXX][김주창][XXXXXX][문세철]
		- [XXXXXX][이지호][XXXXXX][김제이][XXXXXX]
		- [박성준][XXXXXX][홍지현][XXXXXX][구백연][에어콘]

## 60일차(2021-09-23,목)

- 실전 프로젝트(eomcs-java-project)
	- 18-a. `Observer` 디자인 패턴 : 옵저버 패턴이 필요한 이유
	- 18-b. `Observer` 디자인 패턴 : 옵저버 패턴으로 구조를 바꾸기
	- 18-c. `Observer` 디자인 패턴 : 옵저버로 파일 입출력 처리하기
- 팀 프로젝트 
	- 팀별 프로젝트 구현

## 61일차(2021-09-24,금)

- 실전 프로젝트(eomcs-java-project)
	- 19-a. 데이터 관리 서버 만들기 : 클라이언트/서버 프로젝트 준비
- 팀 프로젝트 
	- 팀별 프로젝트 구현
	- 6차: 중간 구현 점검
		- 발표 순서
			- 김은채,송다혜,조솔,우형민
				- 오늘의 공부
			- 김태호,조주리,신현지,김진현
				- APUJIMA
			- 윤수민,이용진,홍지현,문세철
				- 주류파인더
			- 최보균,이혜연,방우주,이서은,조대희
				- MySeoul
			- 반계령,배서연,하선영,김제이,김주창
				- 스터디위더스
			- 변민성,위정욱,박성준,구백연,이지호
				- 행복하share

## 62일차(2021-09-27,월)

- 실전 프로젝트(eomcs-java-project)
	- 19-b. 데이터 관리 서버 만들기 : 간단한 메시지 송수신
	- 19-c. 데이터 관리 서버 만들기 : 사용자가 입력한 명령처리
	- 19-d. 데이터 관리 서버 만들기 : 프로토콜 정의 및 적용
- 팀 프로젝트 
	- 팀별 프로젝트 구현

## 63일차(2021-09-28,화)

- 실전 프로젝트(eomcs-java-project)
	- 19-e. 데이터 관리 서버 만들기 : 통신 기능을 캡슐화
	- 19-f. 데이터 관리 서버 만들기 : 파일 및 데이터 처리 기능을 서버로 이전
- 팀 프로젝트 
	- 팀별 프로젝트 구현

## 64일차(2021-09-29,수)

- 실전 프로젝트(eomcs-java-project)
	- 19-f. 데이터 관리 서버 만들기 : 파일 및 데이터 처리 기능을 서버로 이전(계속)
- 팀 프로젝트 
	- 팀별 프로젝트 구현

## 65일차(2021-09-30,목)

- 실전 프로젝트(eomcs-java-project)
	- 19-f. 데이터 관리 서버 만들기 : 파일 및 데이터 처리 기능을 서버로 이전(계속)
	- 19-g. 데이터 관리 서버 만들기 : 다중 클라이언트의 접속 처리(Stateful)
	- 19-h. 데이터 관리 서버 만들기 : 다중 클라이언트의 접속 처리(Stateless)
- 팀 프로젝트 
	- 팀별 프로젝트 구현

## 66일차(2021-10-01,금)

- 팀 프로젝트 
	- 팀별 프로젝트 구현
- 팀 프로젝트 
	- 팀별 프로젝트 구현
	- 7차: 중간 구현 점검
		- 발표 순서
			- 김태호,조주리,신현지,김진현
				- APUJIMA
			- 윤수민,이용진,홍지현,문세철
				- 주류파인더
			- 최보균,이혜연,방우주,이서은,조대희
				- MySeoul
			- 반계령,배서연,하선영,김제이,김주창
				- 스터디위더스
			- 변민성,위정욱,박성준,구백연,이지호
				- 행복하share
			- 김은채,송다혜,조솔,우형민
				- 오늘의 공부

