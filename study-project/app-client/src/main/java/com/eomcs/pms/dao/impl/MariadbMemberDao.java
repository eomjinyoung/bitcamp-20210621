package com.eomcs.pms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.pms.dao.MemberDao;
import com.eomcs.pms.domain.Member;

// 역할
// - 회원 데이터를 DBMS 서버를 통해 관리한다.
//
public class MariadbMemberDao implements MemberDao {

  Connection con;

  public MariadbMemberDao(Connection con) {
    this.con = con;
  }

  @Override
  public void insert(Member member) throws Exception {
    //    requestAgent.request("member.insert", member);
    //    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
    //      throw new Exception(requestAgent.getObject(String.class));
    //    }
  }

  @Override
  public List<Member> findAll() throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(
        "select member_no,name,email,tel,created_dt from pms_member order by name asc");
        ResultSet rs = stmt.executeQuery()) {

      ArrayList<Member> list = new ArrayList<>();

      while (rs.next()) {
        Member member = new Member();
        member.setNo(rs.getInt("member_no"));
        member.setName(rs.getString("name"));
        member.setEmail(rs.getString("email"));
        member.setTel(rs.getString("tel"));
        member.setRegisteredDate(rs.getDate("created_dt"));

        list.add(member);
      }

      return list;
    }
  }

  @Override
  public Member findByNo(int no) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(
        "select member_no,name,email,photo,tel,created_dt from pms_member where member_no=" + no);
        ResultSet rs = stmt.executeQuery()) {

      if (!rs.next()) {
        return null;
      }

      Member member = new Member();
      member.setNo(rs.getInt("member_no"));
      member.setName(rs.getString("name"));
      member.setEmail(rs.getString("email"));
      member.setPhoto(rs.getString("photo"));
      member.setTel(rs.getString("tel"));
      member.setRegisteredDate(rs.getDate("created_dt"));

      return member;
    }
  }

  @Override
  public Member findByName(String name) throws Exception {
    //    HashMap<String,String> params = new HashMap<>();
    //    params.put("name", name);
    //
    //    requestAgent.request("member.selectOneByName", params);
    //
    //    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
    //      return null;
    //    }
    //
    //    return requestAgent.getObject(Member.class);
    return null;
  }

  @Override
  public void update(Member member) throws Exception {
    //    requestAgent.request("member.update", member);
    //
    //    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
    //      throw new Exception(requestAgent.getObject(String.class));
    //    }
  }

  @Override
  public void delete(int no) throws Exception {
    //    HashMap<String,String> params = new HashMap<>();
    //    params.put("no", String.valueOf(no));
    //
    //    requestAgent.request("member.delete", params);
    //
    //    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
    //      throw new Exception(requestAgent.getObject(String.class));
    //    }
  }
}



