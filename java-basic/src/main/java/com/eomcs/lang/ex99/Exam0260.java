package com.eomcs.lang.ex99;

//# 키보드 입력 받기 - 토큰 단위로 문자열 읽기
//
public class Exam0260 {
  public static void main(String[] args) { 
    java.util.Scanner keyboard = new java.util.Scanner(System.in);
    
    // next()
    // - 토큰 단위로 입력 데이터를 잘라서 읽을 때 유용하다. 
    System.out.print("입력: ");
    String token1 = keyboard.next();
    String token2 = keyboard.next();
    String token3 = keyboard.next();
    
    keyboard.close();
    
    System.out.printf("%s, %s, %s\n", token1, token2, token3);
  }
}















