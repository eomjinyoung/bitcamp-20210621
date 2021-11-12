package bitcamp;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

// WebApplicationInitializer 구현체를 통해 DispatcherServlet을 등록하는 세 번째 방법
// => 인터페이스를 직접 구현하는 대신에 그 인터페이스를 구현한
//    AbstractDispatcherServletInitializer 클래스를 상속 받기
//
//
public class WebApplicationInitializerImpl
extends AbstractDispatcherServletInitializer {

  @Override
  protected WebApplicationContext createRootApplicationContext() {
    // ContextLoaderListener 가 사용할 IoC 컨테이너를 리턴한다.
    // 만약 null을 리턴한다면,
    // 스프링 WebMVC 프레임워크는 ContextLoaderListener를 생성하지 않을 것이다.
    return null;
  }

  @Override
  protected WebApplicationContext createServletApplicationContext() {
    // DispatcherServlet이 사용할 IoC 컨테이너를 리턴한다.
    // 스프링 WebMVC 프레임워크는 DispatcherServlet을 만들 때
    // 이 메서드가 리턴한 IoC 컨테이너를 DispatcherServlet에 주입할 것이다.

    //1) XML 기반 IoC 컨테이너를 사용할 경우,
    //    XmlWebApplicationContext iocContainer = new XmlWebApplicationContext();
    //    iocContainer.setConfigLocation("/WEB-INF/app-servlet.xml");

    //2) Java Config 기반 IoC 컨테이너를 사용할 경우,
    AnnotationConfigWebApplicationContext iocContainer =
        new AnnotationConfigWebApplicationContext();
    iocContainer.register(AppConfig.class);
    return iocContainer;
  }

  @Override
  protected String[] getServletMappings() {
    return new String[] {"/app/*"};
  }

  @Override
  protected String getServletName() {
    return "app";
  }

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    // 이 메서드가 호출될 때 간단한 메시지를 출력하기 위해 오버라이딩 하였다.
    // 따라서 원래의 메서드를 반드시 호출해줘야 한다.
    System.out.println("WebApplicationInitializerImpl.onStartup()...호출됨!");
    super.onStartup(servletContext);
  }
}






