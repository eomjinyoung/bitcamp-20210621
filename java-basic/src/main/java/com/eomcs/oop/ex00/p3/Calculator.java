package com.eomcs.oop.ex00.p3;

public class Calculator {

  int result;

  static void plus(Calculator that, int value) {
    that.result += value;
  }

  static void minus(Calculator that, int value) {
    that.result -= value;
  }

  static void multiple(Calculator that, int value) {
    that.result *= value;
  }
}
