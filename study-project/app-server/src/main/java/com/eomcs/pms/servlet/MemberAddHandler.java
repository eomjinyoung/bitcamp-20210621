package com.eomcs.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.eomcs.pms.dao.MemberDao;
import com.eomcs.pms.domain.Member;


@WebServlet("/member/add")
public class MemberAddHandler extends HttpServlet {
  private static final long serialVersionUID = 1L;

  SqlSession sqlSession;
  MemberDao memberDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    try {
      // Mybatis의 SqlSession 객체 준비
      sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
          "com/eomcs/pms/conf/mybatis-config.xml")).openSession();

      // SqlSession 객체를 통해 MemberDao 구현체를 자동 생성한다.
      memberDao = sqlSession.getMapper(MemberDao.class);

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<html>");
    out.println("<head>");
    out.println("  <title>회원등록</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원등록결과</h1>");

    Member member = new Member();

    member.setName(request.getParameter("name"));
    member.setEmail(request.getParameter("email"));
    member.setPassword(request.getParameter("password"));
    member.setPhoto(request.getParameter("photo"));
    member.setTel(request.getParameter("tel"));

    try {
      memberDao.insert(member);
      sqlSession.commit();

      out.println("회원을 등록했습니다.");

    } catch (Exception e) {
      throw new ServletException(e);
    }

    out.println("</body>");
    out.println("</html>");
  }

  @Override
  public void destroy() {
    sqlSession.close();
  }
}







