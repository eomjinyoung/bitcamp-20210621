import java.util.ArrayList;

public class ClassSelector {
  public static void main(String[] args) throws Exception {
    String[] names = {
        "변민성,위정욱,박성준,구백연,이지호", 
        "김은채,송다혜,조솔,우형민", 
        "김태호,조주리,신현지,김진현", 
        "윤수민,이용진,홍지현,문세철", 
        "최보균,이혜연,방우주,이서은,조대희", 
        "반계령,하선영,김제이,김주창"
    };

    for (int i = 0; i < 1000; i++) {
      int a = (int)(Math.random() * names.length);
      int b = (int)(Math.random() * names.length);
      String temp = names[a];
      names[a] = names[b];
      names[b] = temp;
    }

    ArrayList<String> list = new ArrayList<>();
    for (String name : names) {
      list.add(name);
    }

    while (list.size() > 0) {
      Thread.sleep(2000);
      int selectedNo = (int)(Math.random() * list.size());
      System.out.println(list.remove(selectedNo));
    }

    //    int selectedNo = -1;
    //    for (int i = 10; i > 0; i--) {
    //      selectedNo = (int)(Math.random() * names.length);
    //      System.out.println(i);
    //      Thread.sleep(1000);
    //    }
    //
    //    System.out.printf("당첨: %s\n", names[selectedNo]);



  }
}
