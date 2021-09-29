package com.eomcs.pms;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.pms.domain.Board;

public class TestApp {

  static ArrayList<Board> list = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    list.add(new Board());
    list.add(new Board());
    list.add(new Board());

    test(list);
  }

  static <T> void test(List<T> list) throws Exception {
    System.out.println(list);
    System.out.println(list.getClass());
    System.out.println();
    Field field = TestApp.class.getDeclaredField("list");
    Type type = field.getGenericType();
    System.out.println("type: " + type);
    if (type instanceof ParameterizedType) {
      ParameterizedType pt = (ParameterizedType) type;
      System.out.println("raw type: " + pt.getRawType());
      System.out.println("owner type: " + pt.getOwnerType());
      System.out.println("actual type args:");
      for (Type t : pt.getActualTypeArguments()) {
        System.out.println("    " + t);
      }
    }
  }
}