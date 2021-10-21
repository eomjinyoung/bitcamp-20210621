package com.eomcs.pms.dao.impl;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.eomcs.pms.dao.ProjectDao;
import com.eomcs.pms.domain.Member;
import com.eomcs.pms.domain.Project;

// 역할
// - 프로젝트 데이터를 DBMS 서버를 통해 관리한다.
//
public class MybatisProjectDao implements ProjectDao {

  SqlSession sqlSession;

  public MybatisProjectDao(SqlSession sqlSession) {
    this.sqlSession = sqlSession;
  }

  @Override
  public void insert(Project project) throws Exception {
    sqlSession.insert("ProjectMapper.insert", project);

    for (Member m : project.getMembers()) {
      HashMap<String,Object> params = new HashMap<>();
      params.put("projectNo", project.getNo());
      params.put("memberNo", m.getNo());

      sqlSession.insert("ProjectMapper.insertMember", params);
    }

    sqlSession.commit();

    //      // 프로젝트의 멤버를 입력하기
    //      try (PreparedStatement stmt2 = con.prepareStatement(
    //          "")) {
    //        for (Member member : project.getMembers()) {
    //          stmt2.setInt(1, projectNo);
    //          stmt2.setInt(2, member.getNo());
    //          stmt2.executeUpdate();
    //        }
    //      }
    //    }
  }

  @Override
  public List<Project> findAll() throws Exception {
    return sqlSession.selectList("ProjectMapper.findAll");
  }


  @Override
  public Project findByNo(int no) throws Exception {
    return sqlSession.selectOne("ProjectMapper.findByNo", no);
  }

  @Override
  public void update(Project project) throws Exception {
    //    try (PreparedStatement stmt = con.prepareStatement(
    //        "update pms_project set"
    //            + " title=?,"
    //            + " content=?,"
    //            + " start_dt=?,"
    //            + " end_dt=?"
    //            + " where project_no=?")) {
    //
    //      stmt.setString(1, project.getTitle());
    //      stmt.setString(2, project.getContent());
    //      stmt.setDate(3, project.getStartDate());
    //      stmt.setDate(4, project.getEndDate());
    //      stmt.setInt(5, project.getNo());
    //
    //      if (stmt.executeUpdate() == 0) {
    //        throw new Exception("프로젝트 데이터 변경 실패!");
    //      }
    //
    //      // 프로젝트 멤버 변경
    //      // => 기존 멤버 모두 제거
    //      try (PreparedStatement stmt2 = con.prepareStatement(
    //          "delete from pms_project_member where project_no=?")) {
    //        stmt2.setInt(1, project.getNo());
    //        stmt2.executeUpdate();
    //      }
    //
    //      // => 프로젝트 새 멤버 입력
    //      try (PreparedStatement stmt2 = con.prepareStatement(
    //          "insert into pms_project_member(project_no,member_no) values(?,?)")) {
    //        for (Member member : project.getMembers()) {
    //          stmt2.setInt(1, project.getNo());
    //          stmt2.setInt(2, member.getNo());
    //          stmt2.executeUpdate();
    //        }
    //      }
    //    }
  }

  @Override
  public void delete(int no) throws Exception {
    //    try (PreparedStatement stmt = con.prepareStatement(
    //        "delete from pms_project where project_no=?");
    //        PreparedStatement stmt2 = con.prepareStatement(
    //            "delete from pms_project_member where project_no=?")) {
    //
    //      // 프로젝트 멤버를 먼제 삭제한다.
    //      stmt2.setInt(1, no);
    //      stmt2.executeUpdate();
    //
    //      // 프로젝트를 삭제한다.
    //      stmt.setInt(1, no);
    //      if (stmt.executeUpdate() == 0) {
    //        throw new Exception("프로젝트 데이터 삭제 실패!");
    //      }
    //    }
  }
}



