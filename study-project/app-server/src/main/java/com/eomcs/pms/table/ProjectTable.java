package com.eomcs.pms.table;

import com.eomcs.pms.domain.Project;
import com.eomcs.server.DataProcessor;
import com.eomcs.server.Request;
import com.eomcs.server.Response;

// 역할
// - 프로젝트 데이터를 처리하는 일을 한다.
// 
public class ProjectTable extends JsonDataTable<Project> implements DataProcessor {

  public ProjectTable() {
    super("project.json", Project.class);
  }

  @Override
  public void execute(Request request, Response response) throws Exception {
    switch (request.getCommand()) {
      case "project.insert": insert(request, response); break;
      case "project.selectList": selectList(request, response); break;
      case "project.selectOne": selectOne(request, response); break;
      case "project.update": update(request, response); break;
      case "project.delete": delete(request, response); break;
      default:
        response.setStatus(Response.FAIL);
        response.setValue("해당 명령을 지원하지 않습니다.");
    }
  }

  private void insert(Request request, Response response) throws Exception {
    Project project = request.getObject(Project.class);
    list.add(project);
    response.setStatus(Response.SUCCESS);
  }

  private void selectList(Request request, Response response) throws Exception {
    response.setStatus(Response.SUCCESS);
    response.setValue(list);
  }

  private void selectOne(Request request, Response response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));
    Project m = findByNo(no);

    if (m != null) {
      response.setStatus(Response.SUCCESS);
      response.setValue(m);
    } else {
      response.setStatus(Response.FAIL);
      response.setValue("해당 번호의 프로젝트를 찾을 수 없습니다.");
    }
  }

  private void update(Request request, Response response) throws Exception {
    Project project = request.getObject(Project.class);

    int index = indexOf(project.getNo());
    if (index == -1) {
      response.setStatus(Response.FAIL);
      response.setValue("해당 번호의 프로젝트를 찾을 수 없습니다.");
      return;
    }

    list.set(index, project);
    response.setStatus(Response.SUCCESS);
  }

  private void delete(Request request, Response response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));
    int index = indexOf(no);

    if (index == -1) {
      response.setStatus(Response.FAIL);
      response.setValue("해당 번호의 프로젝트를 찾을 수 없습니다.");
      return;
    }

    list.remove(index);
    response.setStatus(Response.SUCCESS);
  }

  private Project findByNo(int no) {
    for (Project m : list) {
      if (m.getNo() == no) {
        return m;
      }
    }
    return null;
  }

  private int indexOf(int projectNo) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getNo() == projectNo) {
        return i;
      }
    }
    return -1;
  }

}













