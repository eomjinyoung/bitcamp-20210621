package com.eomcs.pms.web;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
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
        // 패키지 폴더에서 찾아낸 클래스 이름을 가지고 파일을 메모리에 로딩한다.
        String className = controllerPackageName + "." + f.getName().replace(".class", "");
        System.out.println(className); // FQName(패키지 이름을 포함한 클래스명) 

        Class<?> cls = Class.forName(className);
        System.out.println("===> " + cls.getSimpleName());

        // 클래스가 Controller 인터페이스를 구현했는지 검사한다.
        Class<?>[] interfaces = cls.getInterfaces();
        for (Class<?> type : interfaces) {
          if (type == Controller.class) {
            System.out.println("컨트롤러 맞아요!");

            // Controller 구현체가 맞다면 즉시 인스턴스를 생성한다.
            // 1) 클래스의 생성자를 알아낸다.
            Constructor<?> constructor = cls.getConstructors()[0];

            // 2) 생성자의 파라미터 정보를 알아낸다.
            Parameter[] parameters = constructor.getParameters();

            // 3) 생성자를 호출하기 전에 파라미터 타입에 해당하는 아규먼트를 준비한다.
            // - 아규먼트를 담을 배열 준비
            Object[] arguments = new Object[parameters.length];

            // - 각 파라미터 타입에 일치하는 값을 beanContainer에서 찾아서 아규먼트 배열에 담는다.
            outer: for (int i = 0; i < parameters.length; i++) {
              System.out.println(parameters[i].getType().getSimpleName());
              for (Object value : beanContainer.values()) {
                if (parameters[i].getType().isInstance(value)) {
                  // beanContainer에 들어 있는 값 중에서 파라미터 타입과 일치하는 값을 찾았으면
                  // 아규먼트 배열에 저장한다.
                  arguments[i] = value;
                  continue outer;
                }
              }

              // beanContainer에 들어 있는 값 중에서 파라미터 타입과 일치하는 값이 없으면,
              // 아규먼트 배열에 그냥 null을 저장한다.
              arguments[i] = null;
            }

            // 4) 준비된 아규먼트들을 이용하여 생성자를 호출한다.
            Controller controller = (Controller) constructor.newInstance(arguments);

            System.out.println(controller);
            break;
          }
        }
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
