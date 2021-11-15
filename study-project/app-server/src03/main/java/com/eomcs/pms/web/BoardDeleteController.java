package com.eomcs.pms.web;

import javax.servlet.http.HttpServletRequest;
import com.eomcs.pms.service.BoardService;

@Controller
@RequestMapping("/board/delete")
public class BoardDeleteController {

  BoardService boardService;

  public BoardDeleteController(BoardService boardService) {
    this.boardService = boardService;
  }

  @RequestMapping
  public String delete(HttpServletRequest request) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));
    if (boardService.delete(no) == 0) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    }
    return "redirect:list";
  }
}
