package com.eomcs.pms.handler;

import java.util.List;
import com.eomcs.pms.domain.Board;
import com.eomcs.pms.domain.Member;
import com.eomcs.util.Prompt;

public class BoardDetailHandler extends AbstractBoardHandler {

  BoardUpdateHandler boardUpdateHandler;

  public BoardDetailHandler(List<Board> boardList, BoardUpdateHandler boardUpdateHandler) {
    super(boardList);
    this.boardUpdateHandler = boardUpdateHandler;
  }

  @Override
  public void execute() {
    System.out.println("[게시글 상세보기]");
    int no = Prompt.inputInt("번호? ");

    Board board = findByNo(no);

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    System.out.printf("제목: %s\n", board.getTitle());
    System.out.printf("내용: %s\n", board.getContent());
    System.out.printf("작성자: %s\n", board.getWriter().getName());
    System.out.printf("등록일: %s\n", board.getRegisteredDate());

    board.setViewCount(board.getViewCount() + 1);
    System.out.printf("조회수: %d\n", board.getViewCount());
    System.out.println();

    Member loginUser = AuthLoginHandler.getLoginUser(); 
    if (loginUser == null || board.getWriter().getNo() != loginUser.getNo()) {
      return;
    }

    while (true) {
      String input = Prompt.inputString("변경(U), 삭제(D), 이전(0)>");
      switch (input) {
        case "U":
        case "u":
          boardUpdateHandler.execute();
          return;
        case "D":
        case "d":
          System.out.println("게시글 삭제 수행!");
          return;
        case "0":
          return;
        default:
          System.out.println("명령어가 올바르지 않습니다!");
      }
    }
  }
}







