package com.eomcs.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/member/form")
public class MemberFormHandler extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<html>");
    out.println("<head>");
    out.println("  <title>새회원</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>새회원</h1>");

    out.println("<form action='add'>");
    out.println("이름: <input type='text' name='name'><br>");
    out.println("이메일: <input type='text' name='email'><br>");
    out.println("암호: <input type='text' name='password'><br>");
    out.println("사진: <input type='text' name='photo'><br>");
    out.println("전화: <input type='text' name='tel'><br>");
    out.println("<button>등록</button><br>");
    out.println("</form>");

    out.println("</body>");
    out.println("</html>");
  }
}







