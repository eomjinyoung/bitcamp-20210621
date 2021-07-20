// anonymous class - 익명 클래스가 놓이는 장소: 파라미터
package com.eomcs.oop.ex11.e;

public class Exam0440 {
  // 인터페이스의 경우 static으로 선언하지 않아도 스태틱 멤버에서 사용할 수 있다.
  interface A {
    void print();
  }

  void m1(A obj) {
    obj.print();
  }

  public static void main(String[] args) {
    Exam0440 r = new Exam0440();

    // 1) 로컬 클래스 만들기
    class X implements A {
      @Override
      public void print() {
        System.out.println("XXXXX");
      }
    }
    r.m1(new X());

    // 2) 익명 클래스 만들기
    A obj = new A() {
      @Override
      public void print() {
        System.out.println("익명 클래스!!!");
      }
    };
    r.m1(obj);

    // 3) 익명 클래스를 파라미터 자리에 바로 삽입
    r.m1(new A() {
      @Override
      public void print() {
        System.out.println("안녕!!!");
      }
    });

  }
}
