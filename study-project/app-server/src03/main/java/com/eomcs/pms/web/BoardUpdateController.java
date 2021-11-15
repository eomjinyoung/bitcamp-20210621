package com.eomcs.pms.web;

import javax.servlet.http.HttpServletRequest;
import com.eomcs.pms.domain.Board;
import com.eomcs.pms.service.BoardService;

@Controller
@RequestMapping("/board/update")
public class BoardUpdateController {

  BoardService boardService;

  public BoardUpdateController(BoardService boardService) {
    this.boardService = boardService;
  }

  @RequestMapping
  public String update(HttpServletRequest request) throws Exception {

    Board board = new Board();
    board.setNo(Integer.parseInt(request.getParameter("no")));
    board.setTitle(request.getParameter("title"));
    board.setContent(request.getParameter("content"));
    int count = boardService.update(board);

    if (count == 0) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    }
    return "redirect:list";
  }
}
