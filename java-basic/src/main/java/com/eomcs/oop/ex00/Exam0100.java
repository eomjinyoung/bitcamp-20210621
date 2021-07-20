package com.eomcs.oop.ex00;

public class Exam0100 {
  public static void main(String[] args) {
    // 스태틱 변수 테스트
    test1();
    System.out.println(Test.a);
    test2();
    System.out.println(Test.a);
  }

  static void test1() {
    // 스태틱 변수 사용
    // => 최초로 클래스를 사용하는 시점에 
    //    클래스가 로딩된다.
    // => 클래스가 로딩된 후 즉시 자동으로 스태틱 변수가 
    //    Method Area 영역에 생성된다.
    // => 클래스가 언로드 될 때 스태틱 변수가 제거된다.
    // => 클래스가 언로드 될 때는 JVM이 종료할 때다.
    Test.a = 100;
  }

  static void test2() {
    Test.a = 200;
  }
}
