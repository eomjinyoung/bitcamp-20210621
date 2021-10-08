// JDBC 프로그래밍 - DBMS에 연결하기
package com.eomcs.jdbc.ex1;

import java.sql.DriverManager;

public class Exam0210 {

  public static void main(String[] args) throws Exception {

    java.sql.Connection con = null;

    try {
      // JVM에서 jdbc driver 파일(.jar)을 뒤져서 java.sql.Driver 를 구현한 클래스를 
      // 자동으로 로딩하기 때문에,
      // 다음과 같이 명시적으로 로딩할 필요가 없다.
      // Class.forName("org.mariadb.jdbc.Driver");

      // DBMS에 연결하기
      // => DriverManager에게 DBMS와의 연결을 요청한다. 어느 서버에 접속할 것인지 정보를 제공해야 한다.
      // jdbc url : DBMS 서버 정보. 예) jdbc:DBMS://서버주소:포트/데이터베이스명
      // (포트번호를 지정하지 않으면 기본이 3306 이다.)
      // username : DBMS 사용자 아이디
      // password : DBMS 사용자 암호
      //
      con = DriverManager.getConnection( //
          "jdbc:mariadb://localhost:3306/studydb2", // jdbcURL
          "study", // username
          "1111" // password
          );
      // => DriverManager는 등록된 java.sql.Driver 구현체 중에서
      // jdbc url에 지정된 Driver 객체를 찾는다.
      // 예) MariaDB: org.mariadb.jdbc.Driver 클래스의 객체
      // => DB 연결을 Driver 구현체에게 위임한다.
      // 즉, Driver 객체의 connect()를 호출한다.
      // => Driver 구현체(org.mariadb.jdbc.Driver 객체)는 DBMS와 연결한 후
      // 소켓 정보를 갖고 있는 java.sql.Connection 구현체를 리턴한다.
      //
      // [App]...................[DriverManager].............[Driver 구현체]
      // ..| getConnection()............|............................|
      // ..|--------------------------->|............................|
      // ..|............................|......connect().............|
      // ..|............................|--------------------------->|
      // ..|............................|............................|-> new MariaDbConnection()
      // ..|............................|..........return............|
      // ..|........return..............|<---------------------------|
      // ..|<---------------------------|............................|
      //
      System.out.println("DBMS와 연결됨!");

      // MariaDB의 Driver 구현체가 리턴한 Connection 객체는
      // 어떤 클래스일까?
      System.out.println(con.getClass().getName());

    } finally {
      // 자원해제
      // => 파일과 마찬가지로 DBMS에 연결한 후 더이상 사용하지 않으면 연결을 해제해야 한다.
      try {
        con.close();
      } catch (Exception e) {
        // 연결 해제하다가 발생된 예외는 무시한다.
        // 왜? 이런 오류는 애플리케이션에서 처리할 방법이 없다.
        // 처리할 필요도 없다.
      }
      System.out.println("DBMS와 연결 해제됨!");
    }
  }
}


