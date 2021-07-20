// 캡슐화(encapsulation) 응용 - 생성자를 private 으로 막기
package com.eomcs.oop.ex08.b;

import com.eomcs.oop.ex08.b.sub.C;

class Car {
  String model;
  String maker;
  int cc;
  int valve;

  // 외부에서 직접 인스턴스를 생성하는 것을 막기 위해 생성자를 private으로 선언
  private Car() {}

  // 대신 객체를 생성해주는 static 메서드를 준비한다.
  //
  // 어떨 때 이렇게 인스턴스를 직접 생성하지 않고 스태틱 메서드를 통해 인스턴스를 생성하는가?
  // => 다음의 경우처럼 인스턴스 생성과정이 복잡할 경우에
  //    직접 인스턴스를 생성하기 보다는
  //    인스턴스를 생성해주는 메서드를 사용하여
  //    인스턴스를 만든다.
  // => singletone 패턴에서 getInstance() 메서드는 오직 한 개의 인스턴스만 생성한다.
  //    즉 메서드의 목적은 단지 인스턴스를 한 개만 만들어 사용하기 위함이다.
  // => 그러나 다음 create() 메서드는 호출할 때 마다 인스턴스를 만들어 주기 때문에
  //    singleton 하고 구조가 비슷하지만 singleton 은 아니다.
  //    이 메서드의 목적은 복잡한 인스턴스 생성을 대신 해주는 것이다.
  //
  // 다시! 언제 이런 방식으로 설계하는가?
  // => 인스턴스 생성과정이 복잡할 경우에 이용하는 방법이다.
  // => 즉 인스턴스를 생성해 주는 메서드를 통해
  //    인스턴스를 생성하면 인스턴스를 사용하고픈 개발자는 코드가 간결해진다
  // 이런 설계 방식에 대해 이름을 붙였으니 그 이름도 유명한 "factory method" 설계 패턴이다.
  //
  public static Car create(String name) {

    Car c = new Car(); // private은 클래스 안에서 사용할 수 있다.

    switch (name) {
      case "티코":
        c.model = "티코";
        c.maker = "대우";
        c.cc = 800;
        c.valve = 16;
        break;
      case "소나타":
        c.model = "소나타";
        c.maker = "현대자동차";
        c.cc = 1980;
        c.valve = 16;
        break;
      default:
        c.model = "모델S";
        c.maker = "테슬라";
        c.cc = 0;
        c.valve = 0;
    }
    return c;
  }
}

public class Exam0220 extends C {

  public static void main(String[] args) {

    //    Car c1 = new Car(); // 컴파일 오류!
    // 생성자가 private이기 때문에 다른 클래스에서 호출할 수 없다.
    // 따라서 인스턴스를 생성할 수 없다.
    //
    // 그럼 왜 생성자를 private으로 만들었는가?
    // => 개발자가 직접 인스턴스를 생성하면 너무 복잡하니,
    //    다른 메서드를 통해 인스턴스를 생성하라는 의미다!
    //
    Car c2 = Car.create("티코");

    System.out.printf("%s,%s,%d,%d\n",
        c2.model, c2.maker, c2.cc, c2.valve);

  }
}







