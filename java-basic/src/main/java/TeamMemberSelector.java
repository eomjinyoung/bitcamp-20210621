import java.util.ArrayList;
import java.util.Scanner;

public class TeamMemberSelector {
  public static void main(String[] args) throws Exception {
    String[] names = {"배서연", "김주창", "박성준", "구백연",
        "이서은", "방우주", "전예린", "이지호", "조대희", "최보균",
        "반계령", "변민성", "김제이", "신현지", "윤수민", "홍지현",
        "조주리", "김진현", "김태호", "조솔", "위정욱", "이용진",
        "송다혜", "하선영", "우형민", "이혜연", "김은채", "문세철"};

    ArrayList<String> students = new ArrayList<>();
    for (String name : names) {
      students.add(name);
    }

    ArrayList[] teams = { 
        new ArrayList(),
        new ArrayList(),
        new ArrayList(),
        new ArrayList(),
        new ArrayList(),
        new ArrayList()
    };

    while (students.size() > 0) {
      System.out.println("팀원 선택 중...");

      Thread.sleep(1000);

      // 1) 남아 있는 학생 중에서 한 명의 학생을 꺼낸다.
      int selectedIndex = (int)(Math.random() * students.size());
      String name = students.remove(selectedIndex);
      System.out.println(name + " 님이 들어갈 팀을 선택 중...");

      Thread.sleep(1000);

      // 2) 선택된 학생이 들어 갈 팀을 결정한다.
      while (true) {
        int teamNo = (int)(Math.random() * teams.length);
        ArrayList team = teams[teamNo];
        if (team.size() < 5) {
          team.add(name);
          System.out.println(name + " 님이 들어갈 팀을 결정 하였음!");
          Thread.sleep(1000);
          break;
        }
      }
    }
    System.out.println("팀원들이 들어갈 팀 결정 완료!!!");

    Scanner keyboardScan = new Scanner(System.in);
    keyboardScan.nextLine();

    // 각 팀의 멤버를 출력한다.
    for (int i = 0; i < teams.length; i++) {
      ArrayList team = teams[i];
      System.out.print((i + 1) + " 팀 : ");
      for (Object name : team) {
        keyboardScan.nextLine();
        System.out.print(name + ",");
      }
      System.out.println();
    }

    keyboardScan.close();
  }
}
