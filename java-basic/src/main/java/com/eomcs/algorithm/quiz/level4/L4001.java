package com.eomcs.algorithm.quiz.level4;
//copyright by codefights.com
//한 줄에 버그가 있다. 고쳐라!
/*
Define partial sort of array as follows: first k elements 
of the result should be exactly the same 
as they will be in the sorted array and 
the rest elements should go in the same order as they occur 
in the original array.

Apply a partial sort to a given array.

Example

partialSort([4, 3, 1, 2], 2) = [1, 2, 4, 3]

[input] array.integer input

unsorted array of distinct positive integers (each less than 109)
[input] integer k

non-negative integer
[output] array.integer

partially sorted input (for a given k)
 */
public class L4001 {
  static int[] partialSort(int[] input, int k) {
    int[] answer = new int[input.length];
    int m = 0;
    int infinity = (int) 1e9;

    for (int i = 0; i < k; i++) {
      int index = 0;
      for (int j = 0; j < input.length; j++) {
        if (input[j] > input[index]) {
          index = j;
        }
      }
      answer[m++] = input[index];
      input[index] = infinity;
    }
    for (int i = 0; i < input.length; i++) {
      if (input[i] != infinity) {
        answer[m++] = input[i];
      }
    }

    return answer;
  }


  public static void main(String[] args) {
    int[] answer = partialSort(new int[]{4,3,1,2}, 2);
  }
  
  static void printResult(int[] list) {
    for (int v : list) {
      System.out.print(v + ",");
    }
  }
  

}
