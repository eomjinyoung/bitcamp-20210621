package com.eomcs.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.Servlet;
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


@WebServlet("/member/list")
public class MemberListHandler implements Servlet {

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

    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();

    out.println("[회원 목록]");

    try {
      Collection<Member> memberList = memberDao.findAll();

      for (Member member : memberList) {
        out.printf("%d, %s, %s, %s, %s\n", 
            member.getNo(), 
            member.getName(), 
            member.getEmail(), 
            member.getTel(), 
            member.getRegisteredDate());
      }
    } catch (Exception e) {
      out.println("회원 목록 조회 오류!");
    }
  }

  @Override
  public void destroy() {
    sqlSession.close();
  }


  @Override
  public String getServletInfo() {
    return null;
  }

  @Override
  public ServletConfig getServletConfig() {
    return null;
  }
}







