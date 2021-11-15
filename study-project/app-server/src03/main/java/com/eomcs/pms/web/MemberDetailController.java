package com.eomcs.pms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.pms.domain.Member;
import com.eomcs.pms.service.MemberService;

@Controller
@RequestMapping("/member/detail")
public class MemberDetailController {

  MemberService memberService;

  public MemberDetailController(MemberService memberService) {
    this.memberService = memberService;
  }

  @RequestMapping
  public String detail(HttpServletRequest request, HttpServletResponse response) throws Exception {

    response.setContentType("text/html;charset=UTF-8");
    int no = Integer.parseInt(request.getParameter("no"));
    Member member = memberService.get(no);
    if (member == null) {
      throw new Exception("해당 회원이 없습니다!");
    }

    request.setAttribute("member", member);
    return "/member/detail.jsp";
  }
}
