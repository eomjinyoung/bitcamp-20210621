package com.eomcs.pms.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.csv.CsvValue;

public class Project implements CsvValue {
  private int no;
  private String title;
  private String content;
  private Date startDate;
  private Date endDate;
  private Member owner;
  private List<Member> members;
  private List<Task> tasks = new ArrayList<>();

  @Override
  public String toString() {
    return "Project [no=" + no + ", title=" + title + ", content=" + content + ", startDate="
        + startDate + ", endDate=" + endDate + ", owner=" + owner + ", members=" + members
        + ", tasks=" + tasks + "]";
  }

  // 다음 메서드는 CsvValue 규칙에 따라 정의한 메서드다.
  @Override
  public String toCsvString() {
    // 프로젝트 정보를 CSV로 출력할 때 3줄로 표현한다.
    StringBuilder strBuilder = new StringBuilder();

    // 
    //    strBuilder.append(String.format("%d,%s,%s,%s,%s,%s,%s",
    //        this.getNo(),
    //        this.getName(),
    //        this.getEmail(),
    //        this.getPassword(),
    //        this.getPhoto(),
    //        this.getTel(),
    //        this.getRegisteredDate());

    return strBuilder.toString();
  }

  // 다음 메서드는 파라미터로 받은 CSV 문자열에서 값을 추출하여 
  // Board 객체의 각 필드에 저장한다.
  @Override
  public void loadCsv(String csv) {
    String[] values = csv.split(",");

    // CSV 문자열에서 추출한 값을 객체의 필드에 저장한다.
    //    this.setNo(Integer.valueOf(values[0]));
    //    this.setName(values[1]);
    //    this.setEmail(values[2]);
    //    this.setPassword(values[3]);
    //    this.setPhoto(values[4]);
    //    this.setTel(values[5]);
    //    this.setRegisteredDate(Date.valueOf(values[6]));
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public Date getStartDate() {
    return startDate;
  }
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }
  public Date getEndDate() {
    return endDate;
  }
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }
  public Member getOwner() {
    return owner;
  }
  public void setOwner(Member owner) {
    this.owner = owner;
  }
  public List<Member> getMembers() {
    return members;
  }
  public void setMembers(List<Member> members) {
    this.members = members;
  }
  public List<Task> getTasks() {
    return tasks;
  }
  public void setTasks(List<Task> tasks) {
    this.tasks = tasks;
  }

  public String getMemberNames() {
    if (this.members == null) {
      return "";
    }

    StringBuilder names = new StringBuilder();
    for (Member member : this.members) {
      if (names.length() > 0) {
        names.append(",");
      }
      names.append(member.getName());
    }
    return names.toString();
  }

  public Task findTaskByNo(int taskNo) {
    for (Task task : this.tasks) {
      if (task.getNo() == taskNo) {
        return task;
      }
    }
    return null;
  }
}
