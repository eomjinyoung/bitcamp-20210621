package com.eomcs.oop.ex00.p3;

public class CalculatorTest {
  public static void main(String[] args) {
    // 2 + 3 + 4 - 7 * 3 = 6
    // 3 * 2 - 1 = 5

    Calculator c1 = new Calculator();
    Calculator c2 = new Calculator();

    Calculator.plus(c1, 2);
    Calculator.plus(c1, 3);
    Calculator.plus(c1, 4);
    Calculator.minus(c1, 7);
    Calculator.multiple(c1, 3);
    System.out.println(c1.result);

    Calculator.plus(c2, 3);
    Calculator.multiple(c2, 2);
    Calculator.minus(c2, 1);
    System.out.println(c2.result);

  }


}
