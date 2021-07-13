package com.eomcs.lang.ex05;

//# 증감 연산자 : 전위(pre-fix) 감소 연산자
//
public class Exam0660 {
  public static void main(String[] args) {
    int i = 7;

    --i;
    // i 메모리의 값을 먼저 감소시킨다.
    // 그리고 i 메모리의 값을 그 자리에 놓는다.

    --i;

    System.out.println(i); // 5

    System.out.println(--i); 
    // i = i - 1
    // System.out.println(4)

    System.out.println(i); // 4

  }
}
