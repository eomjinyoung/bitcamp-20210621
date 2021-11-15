package com.eomcs.pms.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.pms.service.MemberService;

@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
@WebServlet(value = "/app/*", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  Map<String,Controller> controllerMap = new HashMap<>();

  @SuppressWarnings("unchecked")
  @Override
  public void init() throws ServletException {
    // 프론트 컨트롤러가 사용할 페이지 컨트롤러 객체를 준비한다.
    // 1) 페이지 컨트롤러가 의존하는 객체가 보관된 저장소를 꺼낸다.

    Map<String,Object> beanContainer = 
        (Map<String,Object>) getServletContext().getAttribute("beanContainer");

    MemberService memberService = (MemberService) beanContainer.get("memberService");
    //BoardService boardService = (BoardService)  beanContainer.get("boardService");

    controllerMap.put("/member/list", new MemberListController(memberService));
    controllerMap.put("/member/detail", new MemberDetailController(memberService));
    controllerMap.put("/member/add", new MemberAddController(memberService));
    controllerMap.put("/member/update", new MemberUpdateController(memberService));
    controllerMap.put("/member/delete", new MemberDeleteController(memberService));

  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // 예) 요청 URL => /app/board/list
    //String servletPath = request.getServletPath(); // => /app
    String controllerPath = request.getPathInfo(); // => /board/list

    // 페이지 컨트롤러에게 위임한다.
    // => 페이지 컨트롤러 맵에서 클라이언트의 요청을 처리할 객체를 꺼낸다.
    Controller controller = controllerMap.get(controllerPath);
    if (controller == null) {
      request.setAttribute("exception", new Exception("요청을 처리할 수 없습니다."));
      request.getRequestDispatcher("/error.jsp").forward(request, response);
      return;
    }

    // => 요청을 처리할 페이지 컨트롤러를 찾았으면 규칙에 따라 메서드를 호출한다.
    try {
      String viewName = controller.execute(request, response);
      if (viewName.startsWith("redirect:")) {
        response.sendRedirect(viewName.substring(9));
        return;
      }
      request.getRequestDispatcher(viewName).forward(request, response);

    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
  }

}
