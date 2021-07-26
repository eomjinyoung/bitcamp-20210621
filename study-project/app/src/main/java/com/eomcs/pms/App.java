package com.eomcs.pms;

import com.eomcs.pms.handler.BoardHandler;
import com.eomcs.pms.handler.MemberHandler;
import com.eomcs.pms.handler.ProjectHandler;
import com.eomcs.pms.handler.TaskHandler;
import com.eomcs.util.Prompt;

public class App {

  public static void main(String[] args) {

    BoardHandler boardHandler = new BoardHandler();
    MemberHandler memberHandler = new MemberHandler();

    ProjectHandler projectHandler = new ProjectHandler();
    // ProjectHandler의 메서드가 사용할 의존 객체는
    // 메서드를 호출할 때 마다 파라미터로 전달하는 것이 아니라, 
    // 다음과 같이 인스턴스 변수에 미리 주입한다.
    projectHandler.memberHandler = memberHandler;

    TaskHandler taskHandler = new TaskHandler();
    // TaskHandler의 메서드가 사용할 의존 객체는
    // 메서드를 호출할 때 마다 파라미터로 전달하는 것이 아니라, 
    // 다음과 같이 인스턴스 변수에 미리 주입한다.
    taskHandler.memberHandler = memberHandler;

    while (true) {
      String input = Prompt.inputString("명령> ");

      if (input.equals("exit") || input.equals("quit")) {
        System.out.println("안녕!");
        break;
      } else if (input.equals("/member/add")) {
        memberHandler.add();

      } else if (input.equals("/member/list")) {
        memberHandler.list();

      } else if (input.equals("/member/detail")) {
        memberHandler.detail();

      } else if (input.equals("/member/update")) {
        memberHandler.update();

      } else if (input.equals("/member/delete")) {
        memberHandler.delete();

      }  else if (input.equals("/project/add")) {
        // add() 메서드가 사용할 의존 객체를 미리 주입했기 때문에
        // 이제 파라미터로 전달할 필요가 없다.
        //        projectHandler.add(memberHandler); // 이전 코드 
        projectHandler.add();

      }  else if (input.equals("/project/list")) {
        projectHandler.list();

      }  else if (input.equals("/project/detail")) {
        projectHandler.detail();

      }  else if (input.equals("/project/update")) {
        // update() 메서드가 사용할 의존 객체를 미리 주입했기 때문에
        // 이제 파라미터로 전달할 필요가 없다.
        //        projectHandler.update(memberHandler); // 이전 코드
        projectHandler.update();

      }  else if (input.equals("/project/delete")) {
        projectHandler.delete();

      }  else if (input.equals("/task/add")) {
        // add() 메서드가 사용할 의존 객체를 미리 주입했기 때문에
        // 이제 파라미터로 전달할 필요가 없다.
        //        taskHandler.add(memberHandler); // 이전 코드
        taskHandler.add();

      }  else if (input.equals("/task/list")) {
        taskHandler.list();

      }  else if (input.equals("/task/detail")) {
        taskHandler.detail();

      }  else if (input.equals("/task/update")) {
        // update() 메서드가 사용할 의존 객체를 미리 주입했기 때문에
        // 이제 파라미터로 전달할 필요가 없다.
        //        taskHandler.update(memberHandler); // 이전 코드
        taskHandler.update();

      }  else if (input.equals("/task/delete")) {
        taskHandler.delete();

      }  else if (input.equals("/board/add")) {
        boardHandler.add();

      }  else if (input.equals("/board/list")) {
        boardHandler.list();

      }  else if (input.equals("/board/detail")) {
        boardHandler.detail();

      }  else if (input.equals("/board/update")) {
        boardHandler.update();

      }  else if (input.equals("/board/delete")) {
        boardHandler.delete();

      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      System.out.println();
    }

    // Prompt 가 소유하고 관리하고 있는 자원을 닫으라고 명령한다. 
    Prompt.close();
  }
}












