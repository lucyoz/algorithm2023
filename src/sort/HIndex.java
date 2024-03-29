package sort;

import java.util.Arrays;

public class HIndex {

  public static int solution(int[] citations){
    int answer = 0;

    Arrays.sort(citations);

    for (int i = 0; i < citations.length; i++) {
      int smaller = Math.min(citations[i], citations.length-i);

      if(smaller >= answer){
        answer = Math.max(answer, smaller);
      } else {
        break;
      }


    }


    return answer;
  }

  public static void main(String[] args) {


    int[] citations = {3,0,6,1,5};
    System.out.println(solution(citations));
  }
}
