import java.util.ArrayList;
import java.util.Scanner;

public class StudentSelector2 {
  public static void main(String[] args) throws Exception {
    String[] names = {"김주창", "박성준", "구백연",
        "이서은", "방우주", "이지호", "조대희", "최보균",
        "반계령", "변민성", "김제이", "신현지", "윤수민", "홍지현",
        "조주리", "김진현", "김태호", "조솔", "위정욱", "이용진",
        "송다혜", "하선영", "우형민", "이혜연", "김은채", "문세철"};

    //    String[] names = {"김태호","조주리","신현지","김진현",
    //        "최보균","이혜연","방우주","이서은","조대희",
    //        "김은채","송다혜","조솔","우형민"};
    //    String[] names = {
    //        "반계령","하선영","김제이","김주창",
    //        "변민성","위정욱","박성준","구백연","이지호",
    //        "윤수민","이용진","홍지현","문세철"
    //    };

    for (int i = 0; i < 1000; i++) {
      int a = (int)(Math.random() * names.length);
      int b = (int)(Math.random() * names.length);
      String temp = names[a];
      names[a] = names[b];
      names[b] = temp;
    }

    for (String name : names) {
      System.out.print(name + " ");
    }

    ArrayList<String> students = new ArrayList<>();
    for (String name : names) {
      students.add(name);
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
      System.out.println(students.remove(selectedNo));
      keyboardScan.nextLine();
    }

    keyboardScan.close();

  }
}
