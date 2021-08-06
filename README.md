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