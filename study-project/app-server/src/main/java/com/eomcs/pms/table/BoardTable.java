package com.eomcs.pms.table;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.eomcs.pms.domain.Board;
import com.eomcs.server.Request;
import com.eomcs.server.Response;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

// 역할
// - 게시글 데이터를 처리하는 일을 한다.
// 
public class BoardTable {

  List<Board> list = new ArrayList<>();

  String filename = "board.json";

  public BoardTable() {
    // 파일에서 JSON 데이터를 로딩한다.
    loadObjects(filename, list, Board.class);
  }

  public void save() {
    // 데이터를 JSON 형식으로 파일에 저장한다.
    saveObjects(filename, list);
  }

  // JSON 형식으로 저장된 데이터를 읽어서 객체로 만든다.
  private <E> void loadObjects(
      String filepath, // 데이터를 읽어 올 파일 경로 
      List<E> list, // 로딩한 데이터를 객체로 만든 후 저장할 목록 
      Class<E> domainType // 생성할 객체의 타입정보
      ) {

    try (BufferedReader in = new BufferedReader(
        new FileReader(filepath, Charset.forName("UTF-8")))) {

      StringBuilder strBuilder = new StringBuilder();
      String str;
      while ((str = in.readLine()) != null) { // 파일 전체를 읽는다.
        strBuilder.append(str);
      }

      // StringBuilder로 읽어 온 JSON 문자열을 객체로 바꾼다.
      Type type = TypeToken.getParameterized(Collection.class, domainType).getType(); 
      Collection<E> collection = new Gson().fromJson(strBuilder.toString(), type);

      // JSON 데이터로 읽어온 목록을 파라미터로 받은 List 에 저장한다.
      list.addAll(collection);

      System.out.printf("%s 데이터 로딩 완료!\n", filepath);

    } catch (Exception e) {
      System.out.printf("%s 데이터 로딩 오류!\n", filepath);
    }
  }

  // 객체를 JSON 형식으로 저장한다.
  private void saveObjects(String filepath, List<?> list) {
    try (PrintWriter out = new PrintWriter(
        new BufferedWriter(
            new FileWriter(filepath, Charset.forName("UTF-8"))))) {

      out.print(new Gson().toJson(list));

      System.out.printf("%s 데이터 출력 완료!\n", filepath);

    } catch (Exception e) {
      System.out.printf("%s 데이터 출력 오류!\n", filepath);
      e.printStackTrace();
    }
  }

  public void execute(Request request, Response response) throws Exception {
    switch (request.getCommand()) {
      case "board.insert": insert(request, response); break;
      case "board.selectList": selectList(request, response); break;
      case "board.selectListByKeyword": selectListByKeyword(request, response); break;
      case "board.selectOne": selectOne(request, response); break;
      case "board.update": update(request, response); break;
      case "board.delete": delete(request, response); break;
      default:
        response.setStatus(Response.FAIL);
        response.setValue("해당 명령을 지원하지 않습니다.");
    }
  }

  private void insert(Request request, Response response) throws Exception {
    Board board = request.getObject(Board.class);
    list.add(board);
    response.setStatus(Response.SUCCESS);
  }

  private void selectList(Request request, Response response) throws Exception {
    response.setStatus(Response.SUCCESS);
    response.setValue(list);
  }

  private void selectListByKeyword(Request request, Response response) throws Exception {
    String keyword = request.getParameter("keyword");

    ArrayList<Board> searchResult = new ArrayList<>();
    for (Board board : list) {
      if (!board.getTitle().contains(keyword) &&
          !board.getContent().contains(keyword) &&
          !board.getWriter().getName().contains(keyword)) {
        continue;
      }
      searchResult.add(board);
    }

    response.setStatus(Response.SUCCESS);
    response.setValue(searchResult);
  }

  private void selectOne(Request request, Response response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));
    Board b = findByNo(no);

    if (b != null) {
      response.setStatus(Response.SUCCESS);
      response.setValue(b);
    } else {
      response.setStatus(Response.FAIL);
      response.setValue("해당 번호의 게시글을 찾을 수 없습니다.");
    }
  }

  private void update(Request request, Response response) throws Exception {
    Board board = request.getObject(Board.class);

    int index = indexOf(board.getNo());
    if (index == -1) {
      response.setStatus(Response.FAIL);
      response.setValue("해당 번호의 게시글을 찾을 수 없습니다.");
      return;
    }

    list.set(index, board);
    response.setStatus(Response.SUCCESS);
  }

  private void delete(Request request, Response response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));
    int index = indexOf(no);

    if (index == -1) {
      response.setStatus(Response.FAIL);
      response.setValue("해당 번호의 게시글을 찾을 수 없습니다.");
      return;
    }

    list.remove(index);
    response.setStatus(Response.SUCCESS);
  }

  private Board findByNo(int no) {
    for (Board b : list) {
      if (b.getNo() == no) {
        return b;
      }
    }
    return null;
  }

  private int indexOf(int boardNo) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getNo() == boardNo) {
        return i;
      }
    }
    return -1;
  }

}













