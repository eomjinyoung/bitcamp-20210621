// 인터페이스와 추상 클래스
// - 추상 클래스를 이용하여 인터페이스의 일부 규칙을 미리 구현하면
//   서브 클래스를 만들 때
//   인터페이스의 모든 메서드를 정의해야 하는 부담을 줄일 수 있다.
// - 인터페이스에 메서드가 많을 때는 특히 이런 방식을 사용한다.
// - 즉 인터페이스를 직접 구현하기 보다는 추상 클래스를 상속 받아
//   간접적으로 구현하는 기법을 사용한다.
package com.eomcs.oop.ex09.g;

public abstract class AbstractCar implements CarSpec {

  // 추상 클래스의 목적은 서브 클래스에게 공통 필드와 공통 메서드를 상속해주는 것이다.
  String model;
  int cc;

  // => 그 중에서 인터페이스에 선언된 메서드의 일부를 미리 구현해 주면
  //    서브 클래스를 만들기가 매우 편리하다.
  @Override
  public void on() {
    System.out.println("시동을 켠다.");
  }

  @Override
  public void off() {
    System.out.println("시동을 끈다.");
  }

  // => 즉 인터페이스의 메서드 중에서 서브 클래스가 구현해야만 의미가 있는 메서드의 경우
  //    추상 클래스에서 미리 구현할 필요가 없다.
  // => 서브 클래스가 구현하도록 강제하기 위해 추상 메서드로 내비 둔다.
  @Override
  public abstract void run();
}







