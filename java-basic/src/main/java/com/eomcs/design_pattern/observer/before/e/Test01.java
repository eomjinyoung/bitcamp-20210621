package com.eomcs.design_pattern.observer.before.e;

public class Test01 {

  public static void main(String[] args) {
    Car car = new Car();

    car.start();

    car.run();

    car.stop();

    // 업그레이드를 수행한 다음 시간이 지난 후
    // 4) 시동 끌 때 자동차 전조등을 자동으로 끄는 기능을 추가한다.
    // => Car의 stop() 메서드에 해당 코드 추가
    //
    // 기존 코드를 변경할 때 나타날 수 있는 문제점
    // - 어떤 고객은 해당 기능이 필요 없을 수 있다.
    //   - 이런 경우, 조건문을 추가하여 기능의 동작 여부를 제어해야 한다.
    //   - 코드가 복잡해진다.
    // - 이미 디버깅과 테스트가 완료된 기존 코드를 변경하면 새 버그가 발생할 수 있다.
    // - 해결책?
    //   - 기존 코드를 손대지 않거나 최소한으로 손대는 것이 좋다.
    //   - 기존 코드를 손대지 않고 새 기능을 추가하는 방법 중에 하나가 
    //     Observer 패턴으로 설계하는 것이다. 
  }

}


