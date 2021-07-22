package com.eomcs.pms;

public class Test {

  static void deleteValue(int[] arr, int value) {

  }

  public static void main(String[] args) {
    int[] arr = {100, 200, 300};
    deleteValue(arr, 200);

    for (int value : arr) {
      System.out.println(value);
    }
  }
}
