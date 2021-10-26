package com.eomcs.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.eomcs.pms.dao.MemberDao;
import com.eomcs.pms.domain.Member;

@WebServlet("/member/detail")
public class MemberDetailHandler extends GenericServlet {
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
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {

    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();

    out.println("<html>");
    out.println("<head>");
    out.println("  <title>회원상세</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원 상세</h1>");

    int no = Integer.parseInt(req.getParameter("no"));

    try {
      Member member = memberDao.findByNo(no);

      if (member == null) {
        System.out.println("해당 번호의 회원이 없습니다.");

      } else {
        out.printf("이름: %s<br>", member.getName());
        out.printf("이메일: %s<br>", member.getEmail());
        out.printf("사진: %s<br>", member.getPhoto());
        out.printf("전화: %s<br>", member.getTel());
        out.printf("등록일: %s<br>", member.getRegisteredDate());
        out.println();

        out.println("변경(U), 삭제(D), 이전(0) <br>");
      }
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }

  @Override
  public void destroy() {
    sqlSession.close();
  }
}







