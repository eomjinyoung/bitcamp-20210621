package com.eomcs.algorithm.data_structure.linkedlist;

public class MyLinkedListTest6 {
  public static void main(String[] args) throws Exception {
    MyLinkedList<String> list = new MyLinkedList<>();

    list.add("aaa"); // aaa
    list.add("bbb"); // aaa, bbb
    list.add("ccc"); // aaa, bbb, ccc
    list.add("ddd"); // aaa, bbb, ccc, ddd
    list.add("eee"); // aaa, bbb, ccc, ddd, eee
    
    print(list);
    
    list.reverseList();
    
    print(list);
  }

  static void print(MyLinkedList<String> list) {
    for (int i = 0; i < list.size(); i++) {
      System.out.print(list.get(i) + ",");
    }
    System.out.println();
  }
}
