package com.eomcs.oop.ex00;

public class Test2 {
  static int a;
  int b;

  // 스태틱 메서드
  // => 클래스를 통해 사용할 수 있는 메서드
  // => 자신이 소속된 클래스의 인스턴스는 필요 없다.
  // => 자신이 소속된 클래스의 스태틱 멤버(변수,메서드)는 사용할 수 있다.
  static void x1() {
    System.out.println("x1() 호출됨!");
    a = 100;
    x2();
  }

  static void x2() {
    System.out.println("x2() 호출됨!");
  }

  // 인스턴스 메서드
  // => 인스턴스 주소를 가지고 호출하는 메서드
  // => 그래서 인스턴스 변수를 사용하는 메서드에 대해 인스턴스 메서드로 정의한다.
  // => 자신이 소속된 클래스의 인스턴스 멤버(변수,메서드)를 사용할 수 있다.
  //    물론 인스턴스 없이 사용하는 스태틱 멤버도 접근할 수 있다.
  void y1() {
    System.out.println("y1() 호출됨!");
  }


}
