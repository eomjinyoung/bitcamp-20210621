package com.eomcs.pms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.pms.dao.ProjectDao;
import com.eomcs.pms.domain.Member;
import com.eomcs.pms.domain.Project;
import com.eomcs.pms.domain.Task;

// 역할
// - 프로젝트 데이터를 DBMS 서버를 통해 관리한다.
//
public class MariadbProjectDao implements ProjectDao {

  Connection con;

  public MariadbProjectDao(Connection con) {
    this.con = con;
  }

  @Override
  public void insert(Project project) throws Exception {

  }

  // 방법1: 프로젝트 목록을 가져올 때 멤버 목록도 함께 가져오기
  @Override
  public List<Project> findAll() throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(
        "select"
            + " p.project_no,"
            + " p.title,"
            + " p.start_dt,"
            + " p.end_dt,"
            + " m.member_no owner_no,"
            + " m.name owner_name,"
            + " m.email owner_email,"
            + " m2.member_no member_no,"
            + " m2.name member_name,"
            + " m2.email member_email"
            + " from" 
            + " pms_project p"
            + " inner join pms_member m on p.member_no=m.member_no"
            + " left outer join pms_project_member pm on p.project_no=pm.project_no"
            + " inner join pms_member m2 on pm.member_no=m2.member_no"
            + " order by" 
            + " project_no desc, m2.name asc");
        ResultSet rs = stmt.executeQuery()) {

      ArrayList<Project> list = new ArrayList<>();

      int projectNo = 0;
      Project project = null;

      while (rs.next()) {
        if (projectNo != rs.getInt("project_no")) {
          project = new Project();
          project.setNo(rs.getInt("project_no"));
          project.setTitle(rs.getString("title"));
          project.setStartDate(rs.getDate("start_dt"));
          project.setEndDate(rs.getDate("end_dt"));

          Member owner = new Member();
          owner.setNo(rs.getInt("owner_no"));
          owner.setName(rs.getString("owner_name"));
          owner.setEmail(rs.getString("owner_email"));

          project.setOwner(owner);

          list.add(project);
          projectNo = project.getNo();
        }

        // 프로젝트의 멤버가 있다면 기존 멤버 목록에 추가한다.
        if (rs.getString("member_name") != null) {
          Member member = new Member();
          member.setNo(rs.getInt("member_no"));
          member.setName(rs.getString("member_name"));
          member.setEmail(rs.getString("member_email"));
          project.getMembers().add(member);
        }
      }

      return list;
    }
  }

  // 방법2: 프로젝트 목록을 가져온 후 각 프로젝트에 대해 멤버 목록을 가져오기
  //  @Override
  //  public List<Project> findAll() throws Exception {
  //    try (PreparedStatement stmt = con.prepareStatement(
  //        "select" 
  //            + " p.project_no,"
  //            + " p.title,"
  //            + " p.start_dt,"
  //            + " p.end_dt,"
  //            + " m.member_no,"
  //            + " m.name,"
  //            + " m.email"
  //            + " from pms_project p"
  //            + " inner join pms_member m on p.member_no=m.member_no"
  //            + " order by project_no desc");
  //        PreparedStatement stmt2 = con.prepareStatement(
  //            "select" 
  //                + " pm.project_no, "
  //                + " m.member_no,"
  //                + " m.name,"
  //                + " m.email"
  //                + " from "
  //                + " pms_project_member pm"
  //                + " inner join pms_member m on pm.member_no=m.member_no"
  //                + " where"
  //                + " pm.project_no=?"
  //                + " order by "
  //                + " m.name asc");
  //        ResultSet rs = stmt.executeQuery()) {
  //
  //      ArrayList<Project> list = new ArrayList<>();
  //
  //      while (rs.next()) {
  //        Project project = new Project();
  //        project.setNo(rs.getInt("project_no"));
  //        project.setTitle(rs.getString("title"));
  //        project.setStartDate(rs.getDate("start_dt"));
  //        project.setEndDate(rs.getDate("end_dt"));
  //
  //        Member owner = new Member();
  //        owner.setNo(rs.getInt("member_no"));
  //        owner.setName(rs.getString("name"));
  //        owner.setEmail(rs.getString("email"));
  //
  //        project.setOwner(owner);
  //
  //        // 프로젝트의 멤버 목록 가져오기
  //        stmt2.setInt(1, project.getNo());
  //        try (ResultSet memberRs = stmt2.executeQuery()) {
  //          while (memberRs.next()) {
  //            Member member = new Member();
  //            member.setNo(memberRs.getInt("member_no"));
  //            member.setName(memberRs.getString("name"));
  //            member.setEmail(memberRs.getString("email"));
  //
  //            project.getMembers().add(member);
  //          }
  //        }
  //
  //        list.add(project);
  //      }
  //
  //      return list;
  //    }
  //  }

  @Override
  public Project findByNo(int no) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(
        "select"
            + " p.project_no,"
            + " p.title,"
            + " p.content,"
            + " p.start_dt,"
            + " p.end_dt,"
            + " m.member_no owner_no,"
            + " m.name owner_name,"
            + " m.email owner_email,"
            + " m2.member_no member_no,"
            + " m2.name member_name,"
            + " m2.email member_email"
            + " from" 
            + " pms_project p"
            + " inner join pms_member m on p.member_no=m.member_no"
            + " left outer join pms_project_member pm on p.project_no=pm.project_no"
            + " inner join pms_member m2 on pm.member_no=m2.member_no"
            + " where p.project_no=" + no
            + " order by m2.name asc");
        ResultSet rs = stmt.executeQuery()) {

      Project project = null;

      while (rs.next()) {
        if (project == null) {
          project = new Project();
          project.setNo(rs.getInt("project_no"));
          project.setTitle(rs.getString("title"));
          project.setContent(rs.getString("content"));
          project.setStartDate(rs.getDate("start_dt"));
          project.setEndDate(rs.getDate("end_dt"));

          Member owner = new Member();
          owner.setNo(rs.getInt("owner_no"));
          owner.setName(rs.getString("owner_name"));
          owner.setEmail(rs.getString("owner_email"));

          project.setOwner(owner);
        }

        // 프로젝트의 멤버가 있다면 기존 멤버 목록에 추가한다.
        if (rs.getString("member_name") != null) {
          Member member = new Member();
          member.setNo(rs.getInt("member_no"));
          member.setName(rs.getString("member_name"));
          member.setEmail(rs.getString("member_email"));
          project.getMembers().add(member);
        }
      }

      return project;
    }
  }

  @Override
  public void update(Project project) throws Exception {

  }

  @Override
  public void delete(int no) throws Exception {

  }

  @Override
  public void insertTask(Task task) throws Exception {

  }

  @Override
  public void deleteTask(int projectNo, int taskNo) throws Exception {

  }

  @Override
  public void updateTask(Task task) throws Exception {

  }

}



