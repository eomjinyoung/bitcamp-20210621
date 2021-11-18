package bitcamp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

  // 클라이언트의 요청 URL 예:
  // ==> http://localhost:8080/웹앱경로/프론트컨트롤러경로/hello
  // ==> http://localhost:8080/spring/app/hello
  //
  @RequestMapping("/hello") 
  @ResponseBody
  public String hello() {
    return "Hello!";
  }
}
