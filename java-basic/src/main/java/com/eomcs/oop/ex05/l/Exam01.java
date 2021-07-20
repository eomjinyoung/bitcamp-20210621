// 상속 - Generalization 수행 후
package com.eomcs.oop.ex05.l;

// 여러 클래스에 공통으로 들어 가는 기능이나 필드가 있다면
// 유지보수가 쉽도록 별도의 클래스로 추출한다.
// 그리고 상속 관계를 맺는다.
// - Sedan과 Truck 사이에 공통 필드와 메서드가 있다.
//   공통 기능을 추출하여 별도의 클래스를 정의하는 것을 "일반화(generalization)"라 한다.
//
// Sedan과 Truck의 공통 기능인
// start(), shutdown(), run() 메서드를 추출하여
// Car 클래스를 만들고
// Sedan과 Truck은 이 클래스의 서브클래스가 된다.
//
// start()와 shutdown() 은
// Sedan이나 Truck 모두 같은 작업을 수행하기 때문에 상속 받은 것을 그대로 사용하며 되지만,
// run()은 Sedan과 Truck이 서로 다르게 작업하기 때문에 재정의(오버라이딩) 해야 한다.
public class Exam01 {

  public static void main(String[] args) {
    Sedan s = new Sedan();
    Truck t = new Truck();
    Car c = new Car();
  }

}
