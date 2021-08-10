import java.util.ArrayList;
import java.util.Scanner;

public class StudentSelector2 {
  public static void main(String[] args) throws Exception {
    //    String[] names = {"배서연", "김주창", "박성준", "구백연",
    //        "이서은", "방우주", "전예린", "이지호", "조대희", "최보균",
    //        "반계령", "변민성", "김제이", "신현지", "윤수민", "홍지현",
    //        "조주리", "김진현", "김태호", "조솔", "위정욱", "이용진",
    //        "송다혜", "하선영", "우형민", "이혜연", "김은채", "문세철"};

    //    String[] names = {"배서연", "김주창", 
    //        "전예린", 
    //        "반계령", "김제이", "신현지", 
    //        "조주리", "김진현", "김태호", "조솔",
    //        "송다혜", "하선영", "우형민", "김은채"};

    String[] names = {"박성준", "구백연",
        "이서은", "방우주", "이지호", "조대희", "최보균",
        "변민성", "윤수민", "홍지현",
        "위정욱", "이용진",
        "이혜연", "문세철"};

    ArrayList<String> students = new ArrayList<>();
    for (String name : names) {
      students.add(name);
    }

    for (int i = 0; i < 1000; i++) {
      int a = (int)(Math.random() * names.length);
      int b = (int)(Math.random() * names.length);
      String temp = students.get(a);
      students.set(a, students.get(b));
      students.set(b, temp);
    }

    Scanner keyboardScan = new Scanner(System.in);

    for (int i = 0; i < 10; i++) {
      System.out.print(".");
      Thread.sleep(500);
    }
    System.out.println("시작!");
    keyboardScan.nextLine();

    while (students.size() > 0) {
      int selectedNo = (int)(Math.random() * students.size());
      //      for (int i = 0; i < 5; i++) {
      //        System.out.print(".");
      //        Thread.sleep(1000);
      //      }
      System.out.println(students.remove(selectedNo));
      keyboardScan.nextLine();
    }

    keyboardScan.close();

  }
}
