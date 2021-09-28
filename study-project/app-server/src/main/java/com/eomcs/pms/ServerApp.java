package com.eomcs.pms;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Date;
import java.util.HashMap;
import com.eomcs.pms.domain.Board;
import com.eomcs.pms.domain.Member;
import com.eomcs.server.RequestProcessor;
import com.google.gson.Gson;

public class ServerApp {

  public static void main(String[] args) throws Exception {
    System.out.println("[PMS 서버]");

    System.out.println("서버 실행중");
    ServerSocket serverSocket = new ServerSocket(8888);

    Socket socket = serverSocket.accept();
    System.out.println("클라이언트가 접속했음");

    RequestProcessor requestProcessor = new RequestProcessor(socket);
    requestProcessor.service();
    requestProcessor.close();

    System.out.println("서버 종료");
    serverSocket.close();
  }

  private static void addBoard(PrintWriter out, BufferedReader in) throws Exception {
    String jsonStr = in.readLine();

    Board board = new Gson().fromJson(jsonStr, Board.class);

    System.out.println(board);

    out.println("success");
    out.println();
    out.flush();
  }

  @SuppressWarnings("unchecked")
  private static void detailBoard(PrintWriter out, BufferedReader in) throws Exception {
    String jsonStr = in.readLine();

    HashMap<String,Object> map = new Gson().fromJson(jsonStr, HashMap.class);
    System.out.println(map);

    Board board = new Board();
    board.setNo(2);
    board.setTitle("제목1xx");
    board.setContent("내용1xx");
    board.setRegisteredDate(Date.valueOf("2021-1-1"));

    Member m = new Member();
    m.setNo(101);
    m.setName("aaax");
    m.setEmail("aaax@test.com");

    board.setWriter(m);

    out.println("success");
    out.println(new Gson().toJson(board));
    out.flush();
  }
}












