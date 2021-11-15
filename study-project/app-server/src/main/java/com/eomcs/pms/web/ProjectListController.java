package com.eomcs.pms.web;

import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.pms.domain.Project;
import com.eomcs.pms.service.ProjectService;

@RequestMapping("/project/list")
public class ProjectListController implements Controller {

  ProjectService projectService;

  public ProjectListController(ProjectService projectService) {
    this.projectService = projectService;
  }

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    response.setContentType("text/html;charset=UTF-8");

    List<Project> list = null;

    String keyword = request.getParameter("keyword");
    String keywordTitle = request.getParameter("keywordTitle");
    String keywordOwner = request.getParameter("keywordOwner");
    String keywordMember = request.getParameter("keywordMember");

    if (keyword != null) {
      list = projectService.list(keyword);

    } else if (keywordTitle != null) {
      HashMap<String,Object> keywordMap = new HashMap<>();
      keywordMap.put("title", keywordTitle);
      keywordMap.put("owner", keywordOwner);
      keywordMap.put("member", keywordMember);

      list = projectService.list(keywordMap);

    } else {
      list = projectService.list();
    }

    request.setAttribute("list", list);
    return "/project/list.jsp";
  }
}
