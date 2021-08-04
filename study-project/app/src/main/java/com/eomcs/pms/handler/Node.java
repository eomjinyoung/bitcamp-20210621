package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Board;

public class Node {
  Board board;
  Node next;

  public Node(Board board) {
    this.board = board;
  }
}
