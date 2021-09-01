package com.eomcs.pms.handler;

import java.sql.Date;
import java.util.List;
import com.eomcs.pms.domain.Board;
import com.eomcs.util.Prompt;

public class BoardAddHandler {

  List<Board> boardList;

  public BoardAddHandler(List<Board> boardList) {
    this.boardList = boardList;
  }

  public void add() {
    System.out.println("[새 게시글]");

    Board board = new Board();

    board.setNo(Prompt.inputInt("번호? "));
    board.setTitle(Prompt.inputString("제목? "));
    board.setContent(Prompt.inputString("내용? "));

    board.setWriter(AuthHandler.getLoginUser());
    board.setRegisteredDate(new Date(System.currentTimeMillis()));

    boardList.add(board);
  }
}







