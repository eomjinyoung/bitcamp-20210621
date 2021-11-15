package com.eomcs.pms.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.io.Resources;
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

    //    controllerMap.put("/member/list", new MemberListController(memberService));
    //    controllerMap.put("/member/detail", new MemberDetailController(memberService));
    //    controllerMap.put("/member/add", new MemberAddController(memberService));
    //    controllerMap.put("/member/update", new MemberUpdateController(memberService));
    //    controllerMap.put("/member/delete", new MemberDeleteController(memberService));

    try {
      // 페이지 컨트롤러가 있는 패키지의 파일 시스템 경로를 알아낸다.
      String controllerPackageName = "com.eomcs.pms.web";
      System.out.println(controllerPackageName.replace(".", "/"));

      File controllerFilePath = Resources.getResourceAsFile(controllerPackageName.replace(".", "/"));
      System.out.println(controllerFilePath.getCanonicalPath());

      // 해당 디렉토리에서 .class 파일을 찾는다.
      File[] controllerFiles = controllerFilePath.listFiles(
          pathname -> pathname.isFile() &&  // 조건1) 파일이어야 한다.
          pathname.getName().endsWith(".class") && // 조건2) 클래스 파일이어야 한다.
          pathname.getName().indexOf("$") == -1); // 조건3) 중첩 클래스가 아니어야 한다.

      for (File f : controllerFiles) {
        System.out.println(controllerPackageName + "." + f.getName().replace(".class", "")); // FQName(패키지 이름을 포함한 클래스명) 
        // 패키지 폴더에서 찾아낸 클래스 이름을 가지고 파일을 메모리에 로딩한다.
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

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
