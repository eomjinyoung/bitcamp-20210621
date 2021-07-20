// 추상 클래스 레퍼런스와 메서드 호출
package com.eomcs.oop.ex07.a;

// 추상 메서드는 구현하지 않은 메서드이기 때문에
// 일반 클래스(=구현 클래스; concrete class)는 추상 메서드를 가질 수 없다.
// 오직 추상 클래스만이 추상 메서드를 가질 수 있다.
// 왜?
// - 일반 클래스는 인스턴스를 생성할 수 있다.
// - 인스턴스로 메서드를 호출하기 때문에
//   일반 클래스에 완전히 정의되지 않은 메서드가 있다면,
//   호출할 때 오류가 발생할 것이다.
// - 이런 문제를 발생시키지 않기 위해
//   일반 클래스는 추상 메서드를 갖지 않게 하였다.
//
abstract class A3 {
  public abstract void m1();
}

class A3Sub extends A3 {
  @Override // 이 애노테이션은 빼도 된다.
  public void m1() {
    System.out.println("A3Sub.m1() 호출됨!");
  }

  public void m2() {
    System.out.println("A3Sub.m2() 호출됨!");
  }
}

public class Exam03 {
  public static void main(String[] args) {
    A3 obj;

    // 추상 클래스의 인스턴스는 생성 불가!
    //    obj = new A3(); // Error!

    // 추상 메서드를 구현한 서브 클래스 만이 인스턴스 생성 가능!
    obj = new A3Sub();

    // 오버라이딩 규칙에 따라
    // - 레퍼런스가 실제 가리키는 객체의 클래스에서부터 메서드를 찾는다.
    obj.m1();

    // 참고!
    //
    // - 레퍼런스가 실제 가리키는 객체가 A3Sub 라 하더라도
    //   레퍼런스 타입의 범위를 넘어서 메서드를 호출할 수는 없다.
    //    obj.m2(); // 컴파일 오류!

    // - 물론 실제 인스턴스 타입으로 형벼환 후에는 가능한다.
    ((A3Sub)obj).m2();
  }
}
