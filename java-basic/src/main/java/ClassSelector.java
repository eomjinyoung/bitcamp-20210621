public class ClassSelector {
  public static void main(String[] args) throws Exception {
    String[] names = {"1팀", "2팀", "3팀"};

    for (int i = 0; i < 1000; i++) {
      int a = (int)(Math.random() * names.length);
      int b = (int)(Math.random() * names.length);
      String temp = names[a];
      names[a] = names[b];
      names[b] = temp;
    }

    int selectedNo = -1;
    for (int i = 10; i > 0; i--) {
      selectedNo = (int)(Math.random() * names.length);
      System.out.println(i);
      Thread.sleep(1000);
    }

    System.out.printf("당첨: %s\n", names[selectedNo]);


  }
}
