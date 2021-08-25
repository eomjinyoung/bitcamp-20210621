public class StudentSelector {
  public static void main(String[] args) throws Exception {
    String[] names = {"배서연", "김주창", "박성준", "구백연",
        "이서은", "방우주", "전예린", "이지호", "조대희", "최보균",
        "반계령", "변민성", "김제이", "신현지", "윤수민", "홍지현",
        "조주리", "김진현", "김태호", "조솔", "위정욱", "이용진",
        "송다혜", "하선영", "우형민", "이혜연", "김은채", "문세철"};

    for (int i = 0; i < 1000; i++) {
      int a = (int)(Math.random() * names.length);
      int b = (int)(Math.random() * names.length);
      String temp = names[a];
      names[a] = names[b];
      names[b] = temp;
    }

    int selectedNo = -1;
    for (int i = 1; i > 0; i--) {
      selectedNo = (int)(Math.random() * names.length);
      System.out.println(i);
      Thread.sleep(1000);
    }
    System.out.printf("당첨: %s\n", names[selectedNo]);


  }
}
