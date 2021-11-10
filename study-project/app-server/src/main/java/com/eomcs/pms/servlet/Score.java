package com.eomcs.pms.servlet;

public class Score {
  String name;
  int kor;
  int eng;
  int math;
  public String getName() {
    return name;
  }
  public Score setName(String name) {
    this.name = name;
    return this;
  }
  public int getKor() {
    return kor;
  }
  public Score setKor(int kor) {
    this.kor = kor;
    return this;
  }
  public int getEng() {
    return eng;
  }
  public Score setEng(int eng) {
    this.eng = eng;
    return this;
  }
  public int getMath() {
    return math;
  }
  public Score setMath(int math) {
    this.math = math;
    return this;
  }
  @Override
  public String toString() {
    return "Score [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + "]";
  }


}
