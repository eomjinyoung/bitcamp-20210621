package com.eomcs.pms.handler;

import java.util.List;
import com.eomcs.pms.domain.Board;

public class BoardListHandler {

  List<Board> boardList;

  public BoardListHandler(List<Board> boardList) {
    this.boardList = boardList;
  }

  public void list() {
    System.out.println("[게시글 목록]");

    for (Board board : boardList) {
      System.out.printf("%d, %s, %s, %s, %d, %d\n", 
          board.getNo(), 
          board.getTitle(), 
          board.getWriter().getName(),
          board.getRegisteredDate(),
          board.getViewCount(), 
          board.getLike());
    }
  }
}







