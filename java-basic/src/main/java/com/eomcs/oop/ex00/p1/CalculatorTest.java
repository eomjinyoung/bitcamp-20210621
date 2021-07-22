package com.eomcs.oop.ex00.p1;

public class CalculatorTest {
  public static void main(String[] args) {
    // 2 + 3 + 4 - 7 * 3 = 6
    // 3 * 2 - 1 = 5

    int r1 = 0;
    int r2 = 0;

    r1 = Calculator.plus(r1, 2);
    r1 = Calculator.plus(r1, 3);
    r1 = Calculator.plus(r1, 4);
    r1 = Calculator.minus(r1, 7);
    r1 = Calculator.multiple(r1, 3);

    r2 = Calculator.plus(r2, 3);
    r2 = Calculator.multiple(r2, 2);
    r2 = Calculator.minus(r2, 1);

    System.out.println(r1);
    System.out.println(r2);
  }


}
