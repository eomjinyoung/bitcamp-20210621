package com.eomcs.pms;

public class App {

  public static void main(String[] args) {
    java.util.Scanner keyboardScanner = new java.util.Scanner(System.in);

    System.out.println("[회원]");

    System.out.print("번호? ");
    int no = keyboardScanner.nextInt();
    keyboardScanner.nextLine(); // 키보드 메모리에 남아 있는 찌꺼기 엔터 코드 제거  

    System.out.print("이름? ");
    String name = keyboardScanner.nextLine();

    System.out.print("이메일? ");
    String email = keyboardScanner.nextLine();

    System.out.print("암호? ");
    String password = keyboardScanner.nextLine();

    System.out.print("사진? ");
    String photo = keyboardScanner.nextLine();

    System.out.print("전화? ");
    String tel = keyboardScanner.nextLine();

    java.sql.Date registeredDate = new java.sql.Date(System.currentTimeMillis());

    keyboardScanner.close();

    System.out.println("-----------------------------------");
    System.out.printf("번호: %d\n", no);
    System.out.printf("이름: %s\n", name);
    System.out.printf("이메일: %s\n", email);
    System.out.printf("암호: %s\n", password);
    System.out.printf("사진: %s\n", photo);
    System.out.printf("전화: %s\n", tel);
    System.out.printf("가입일: %s\n", registeredDate);


  }
}
