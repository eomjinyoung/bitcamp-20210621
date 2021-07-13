package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

//1) 회원 데이터를 입력 받는 코드를 별도의 메서드로 분리한다.
//   => addMember() 메서드 정의 및 회원 등록 코드를 가져오기
//   => main()과 addMember()가 서로 공유하는 변수는 클래스 변수로 만든다.
//2) 입력된 회원 데이터의 목록을 출력하는 코드를 별도의 메서드로 분리한다.
//   => listMembers() 메서드 정의 및 관련된 코드를 가져오기
//3) 프로젝트 데이터를 입력 받는 코드를 별도의 메서드로 분리한다.
//   => addProject() 메서드 정의 및 관련 코드를 가져오기
//   => main()과 addProject()가 서로 공유하는 변수는 클래스 변수로 만든다.
//4) 입력된 프로젝트 데이터의 목록을 출력하는 코드를 별도의 메서드로 분리한다.
//   => listProjects() 메서드 정의 및 관련된 코드를 가져오기
//5) 작업 데이터를 입력 받는 코드를 별도의 메서드로 분리한다.
//   => addTask() 메서드 정의 및 관련 코드를 가져오기
//   => main()과 addTask()가 서로 공유하는 변수는 클래스 변수로 만든다.
//6) 입력된 작업 데이터의 목록을 출력하는 코드를 별도의 메서드로 분리한다.
//   => listTasks() 메서드 정의 및 관련된 코드를 가져오기
//7) 사용자로부터 명령어를 입력 받는 코드를 별도의 메서드로 분리한다.
//   => prompt() 메서드를 정의하고 관련된 코드를 가져오기
//8) 명령어 뿐만 아니라 사용자로부터 입력을 받는 기능을 모두 prompt()를 사용하여 처리한다.
//   => prompt()를 호출할 때 사용자에게 출력할 프롬프트 메시지를 아규먼트로 넘긴다.
//   => prompt()는 호출할 때 넘어온 프롬프트 메시지 값을 파라미터로 받는다.
//9) prompt() 가 작업한 결과를 클래스 변수에 담지 말고 호출자에게 리턴한다.
//   => prompt()를 실행한 후 사용자가 입력한 문자열을 리턴한다.
//10) prompt()의 기능을 더 세분화한다.
//   => promptString() : 사용자로부터 문자열을 입력 받아 리턴한다.
//   => promptInt() : 사용자로부터 숫자를 입력 받아 리턴한다.
//   => promptDate() : 사용자로부터 날짜를 입력 받아 리턴한다.
//11) promtString(), promptInt(), promptDate() 메서드의 코드를 정리한다.
public class App {

  public static void main(String[] args) {
    Scanner keyboardScan = new Scanner(System.in);

    // 회원 정보
    final int LENGTH = 100;
    int[] no = new int[LENGTH];
    String[] name = new String[LENGTH];
    String[] email = new String[LENGTH];
    String[] password = new String[LENGTH];
    String[] photo = new String[LENGTH];
    String[] tel = new String[LENGTH];
    Date[] registeredDate = new Date[LENGTH];
    int size = 0;

    // 프로젝트 정보
    final int PROJECT_LENGTH = 1000;
    int[] pNo = new int[PROJECT_LENGTH];
    String[] pTitle = new String[PROJECT_LENGTH];
    String[] pContent = new String[PROJECT_LENGTH];
    Date[] pStartDate = new Date[PROJECT_LENGTH];
    Date[] pEndDate = new Date[PROJECT_LENGTH];
    String[] pOwner = new String[PROJECT_LENGTH];
    String[] pMembers = new String[PROJECT_LENGTH];
    int pSize = 0;

    // 작업 정보
    final int TASK_LENGTH = 100;
    int[] tNo = new int[TASK_LENGTH];
    String[] tContent = new String[TASK_LENGTH];
    Date[] tDeadline = new Date[TASK_LENGTH];
    String[] tOwner = new String[TASK_LENGTH];
    int[] tStatus = new int[TASK_LENGTH];
    int tSize = 0;

    while (true) {
      System.out.print("명령> ");
      String input = keyboardScan.nextLine();
      if (input.equals("exit") || input.equals("quit")) {
        System.out.println("안녕!");
        break;
      } else if (input.equals("/member/add")) {
        System.out.println("[회원 등록]");
        System.out.print("번호? ");
        no[size] = Integer.parseInt(keyboardScan.nextLine());

        System.out.print("이름? ");
        name[size] = keyboardScan.nextLine();

        System.out.print("이메일? ");
        email[size] = keyboardScan.nextLine();

        System.out.print("암호? ");
        password[size] = keyboardScan.nextLine();

        System.out.print("사진? ");
        photo[size] = keyboardScan.nextLine();

        System.out.print("전화? ");
        tel[size] = keyboardScan.nextLine();

        registeredDate[size] = new Date(System.currentTimeMillis());

        size++;

      } else if (input.equals("/member/list")) {
        System.out.println("[회원 목록]");
        for (int i = 0; i < size; i++) {
          // 번호, 이름, 이메일, 전화, 가입일
          System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
              no[i], name[i], email[i], tel[i], registeredDate[i]);
        }

      }  else if (input.equals("/project/add")) {
        System.out.println("[프로젝트 등록]");

        System.out.print("번호? ");
        pNo[pSize] = Integer.valueOf(keyboardScan.nextLine());

        System.out.print("프로젝트명? ");
        pTitle[pSize] = keyboardScan.nextLine();

        System.out.print("내용? ");
        pContent[pSize] = keyboardScan.nextLine();

        System.out.print("시작일? ");
        pStartDate[pSize] = Date.valueOf(keyboardScan.nextLine());

        System.out.print("종료일? ");
        pEndDate[pSize] = Date.valueOf(keyboardScan.nextLine());

        System.out.print("만든이? ");
        pOwner[pSize] = keyboardScan.nextLine();

        System.out.print("팀원? ");
        pMembers[pSize] = keyboardScan.nextLine();

        pSize++;

      }  else if (input.equals("/project/list")) {
        System.out.println("[프로젝트 목록]");
        for (int i = 0; i < pSize; i++) {
          // 번호, 프로젝트명, 시작일, 종료일, 만든이
          System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
              pNo[i], pTitle[i], pStartDate[i], pEndDate[i], pOwner[i]);
        }

      }  else if (input.equals("/task/add")) {
        System.out.println("[작업 등록]");

        System.out.print("번호? ");
        tNo[tSize] = Integer.parseInt(keyboardScan.nextLine());

        System.out.print("내용? ");
        tContent[tSize] = keyboardScan.nextLine();

        System.out.print("마감일? ");
        tDeadline[tSize] = Date.valueOf(keyboardScan.nextLine());

        System.out.println("상태?");
        System.out.println("0: 신규");
        System.out.println("1: 진행중");
        System.out.println("2: 완료");
        System.out.print("> ");
        tStatus[tSize] = Integer.valueOf(keyboardScan.nextLine());

        System.out.print("담당자? ");
        tOwner[tSize] = keyboardScan.nextLine();

        tSize++;

      }  else if (input.equals("/task/list")) {
        System.out.println("[작업 목록]");

        for (int i = 0; i < tSize; i++) {
          String stateLabel = null;
          switch (tStatus[i]) {
            case 1:
              stateLabel = "진행중";
              break;
            case 2:
              stateLabel = "완료";
              break;
            default:
              stateLabel = "신규";
          }
          // 번호, 작업명, 마감일, 프로젝트, 상태, 담당자
          System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
              tNo[i], tContent[i], tDeadline[i], stateLabel, tOwner[i]);
        }

      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      System.out.println();
    }

    keyboardScan.close();
  }
}

