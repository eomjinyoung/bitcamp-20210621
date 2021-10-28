<%@page import="com.eomcs.pms.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>회원목록</title>
</head>
<body>
<h1>회원 목록</h1>
<a href='form'>새회원</a><br>
<table border='1'>
<thead>
  <tr>
    <th>번호</th>
    <th>이름</th>
    <th>이메일</th>
    <th>전화</th>
    <th>등록일</th>
  </tr>
</thead>
<tbody>
<tr>
    <td>24</td> 
    <td><a href='detail?no=24'>1x</a></td> 
    <td>1x</td> 
    <td>1x</td> 
    <td>2021-10-26</td>
</tr>
</tbody>
</table>
</body>
</html>
<%! 
// 자바 서블릿 클래스를 만들 때 그 클래스에 들어갈 변수와 메서드를 이 태그 안에 작성한다.
    MemberDao memberDao;

    public void jspInit() {
      ServletConfig config = getServletConfig();
      ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
      memberDao = (MemberDao) 웹애플리케이션공용저장소.getAttribute("memberDao");
    }
%>









