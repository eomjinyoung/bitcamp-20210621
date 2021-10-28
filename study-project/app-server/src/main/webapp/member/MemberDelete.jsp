<%@page import="com.eomcs.pms.domain.Member"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.eomcs.pms.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
  <title>회원삭제</title>
</head>
<body>
<h1>회원삭제결과</h1>
<%
int no = Integer.parseInt(request.getParameter("no"));

Member member = memberDao.findByNo(no);

if (member == null) {%>
  해당 번호의 회원이 없습니다.<br>
<%
} else {
  memberDao.delete(no);
  sqlSession.commit();
%>
  회원을 삭제하였습니다.<br>     
    <a href='MemberList.jsp'>[목록]<a><br>
<%} %>
</body>
</html>
    
<%! // <== declaration element(tag)
// 자바 서블릿 클래스를 만들 때 그 클래스에 들어갈 변수와 메서드를 이 태그 안에 작성한다.
    SqlSession sqlSession;
    MemberDao memberDao;
    
    public void jspInit() {
      ServletConfig config = getServletConfig();
      ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
      sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");
      memberDao = (MemberDao) 웹애플리케이션공용저장소.getAttribute("memberDao");
    }
%>









