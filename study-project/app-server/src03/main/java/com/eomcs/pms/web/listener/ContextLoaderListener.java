package com.eomcs.pms.web.listener;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.eomcs.pms.dao.BoardDao;
import com.eomcs.pms.dao.MemberDao;
import com.eomcs.pms.dao.ProjectDao;
import com.eomcs.pms.dao.TaskDao;
import com.eomcs.pms.dao.mariadb.BoardDaoImpl;
import com.eomcs.pms.dao.mariadb.MemberDaoImpl;
import com.eomcs.pms.dao.mariadb.ProjectDaoImpl;
import com.eomcs.pms.dao.mariadb.TaskDaoImpl;
import com.eomcs.pms.service.BoardService;
import com.eomcs.pms.service.DefaultBoardService;
import com.eomcs.pms.service.DefaultMemberService;
import com.eomcs.pms.service.DefaultProjectService;
import com.eomcs.pms.service.DefaultTaskService;
import com.eomcs.pms.service.MemberService;
import com.eomcs.pms.service.ProjectService;
import com.eomcs.pms.service.TaskService;
import com.eomcs.util.SqlSessionFactoryProxy;

@WebListener
public class ContextLoaderListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    // 시스템에서 사용할 객체를 준비한다.
    try {
      // Mybatis 객체 준비
      SqlSessionFactoryProxy sqlSessionFactory = new SqlSessionFactoryProxy(
          new SqlSessionFactoryBuilder().build(
              Resources.getResourceAsStream("com/eomcs/pms/conf/mybatis-config.xml")));

      // DAO 구현체 생성
      BoardDao boardDao = new BoardDaoImpl(sqlSessionFactory);
      MemberDao memberDao = new MemberDaoImpl(sqlSessionFactory);
      ProjectDao projectDao = new ProjectDaoImpl(sqlSessionFactory);
      TaskDao taskDao = new TaskDaoImpl(sqlSessionFactory);

      // Service 구현체 생성
      BoardService boardService = new DefaultBoardService(boardDao);
      MemberService memberService = new DefaultMemberService(memberDao);
      ProjectService projectService = new DefaultProjectService(taskDao, projectDao, sqlSessionFactory);
      TaskService taskService = new DefaultTaskService(taskDao);

      // 객체를 담아 두는 보관소
      // => bean?
      //    '자바' 이름은 자바 언어를 만든 팀에서 '자바'라는 커피 이름에서 따왔다고 한다.
      //    그래서 자바 객체를 '커피콩' 으로 비유하여
      //    종종 'bean' 이라는 애칭으로 부른다.
      //
      Map<String,Object> beanContainer = new HashMap<>();

      // 서비스 객체를 빈 컨테이너에 보관해 둔다.
      beanContainer.put("boardService", boardService);
      beanContainer.put("memberService", memberService);
      beanContainer.put("projectService", projectService);
      beanContainer.put("taskService", taskService);

      // 다른 객체가 사용할 수 있도록 context 맵 보관소에 저장해둔다.
      ServletContext ctx = sce.getServletContext();

      // 웹 컴포넌트(필터,리스너,서블릿/JSP)가 서비스 객체를 직접 사용할 수 있도록
      // ServletContext 보관소에 beanContainer를 저장해 둔다.
      ctx.setAttribute("beanContainer", beanContainer);

    } catch (Exception e) {
      System.out.println("Mybatis 및 DAO, 서비스 객체 중 오류 발생!");
      e.printStackTrace();
    }
  }
}
