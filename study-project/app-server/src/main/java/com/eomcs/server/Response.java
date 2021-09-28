package com.eomcs.server;

// 역할
// - 클라이언트에게 응답할 정보를 보관하는 일을 한다.
public class Response {

  public static final String SUCCESS = "success";
  public static final String FAIL = "fail";

  String status;
  Object value;

  public void setStatus(String status) {
    this.status = status;
  }
  public void setValue(Object value) {
    this.value = value;
  }
}
