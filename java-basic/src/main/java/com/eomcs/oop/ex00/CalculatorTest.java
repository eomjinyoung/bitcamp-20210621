package com.eomcs.oop.ex00;

public class CalculatorTest {
  public static void main(String[] args) {
    // 2 + 3 + 4 - 7 * 3 = 6
    // 3 * 2 - 1 = 5

    int r1 = 0;
    int r2 = 0;

    r1 = plus(r1, 2);
    r1 = plus(r1, 3);
    r1 = plus(r1, 4);
    r1 = minus(r1, 7);
    r1 = multiple(r1, 3);

    r2 = plus(r2, 3);
    r2 = multiple(r2, 2);
    r2 = minus(r2, 1);

    System.out.println(r1);
    System.out.println(r2);
  }

  static int plus(int result, int value) {
    return result + value;
  }

  static int minus(int result, int value) {
    return result - value;
  }

  static int multiple(int result, int value) {
    return result * value;
  }

}
