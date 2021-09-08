// BufferedFileInputStream과 BufferedFileOutputStream을 사용하여 파일 복사 및 시간 측정
package com.eomcs.io.ex06;

public class Exam0330 {

  public static void main(String[] args) throws Exception {
    BufferedFileInputStream in = new BufferedFileInputStream("temp/jls11.pdf");
    BufferedFileOutputStream out = new BufferedFileOutputStream("temp/jls11_4.pdf");

    int b;

    long startTime = System.currentTimeMillis(); // 밀리초

    while ((b = in.read()) != -1)
      out.write(b);

    // 아직 파일로 출력되지 않고 버퍼 남아 있는 데이터를
    // 마무리로 출력한다.
    // out.flush();

    long endTime = System.currentTimeMillis();

    System.out.println(endTime - startTime);

    in.close();
    out.close();
  }

}
