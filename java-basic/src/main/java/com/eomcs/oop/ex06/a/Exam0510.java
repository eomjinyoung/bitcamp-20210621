// 다형성 - 다형적 변수와 instanceof 연산자
package com.eomcs.oop.ex06.a;

public class Exam0510 {

  public static void main(String[] args) {
    Vehicle v = new Sedan();
    
    // instanceof 연산자?
    // => 레퍼런스에 들어있는 주소가 특정 클래스의 인스턴스인지 검사한다.
    // => 또는 그 하위 클래스의 인스턴스인지 검사한다.
    //
    System.out.println(v instanceof Sedan);
    System.out.println(v instanceof Car);
    System.out.println(v instanceof Vehicle);
    System.out.println(v instanceof Object);
    
    System.out.println(v instanceof Truck);
    System.out.println(v instanceof Bike);
  }

}




