package com.eomcs.oop.ex00.p4;

public class CalculatorTest {
  public static void main(String[] args) {
    // 2 + 3 + 4 - 7 * 3 = 6
    // 3 * 2 - 1 = 5

    Calculator c1 = new Calculator();
    Calculator c2 = new Calculator();

    c1.plus(2);
    c1.plus(3);
    c1.plus(4);
    c1.minus(7);
    c1.multiple(3);
    System.out.println(c1.result);

    c2.plus(3);
    c2.multiple(2);
    c2.minus(1);
    System.out.println(c2.result);

  }


}
