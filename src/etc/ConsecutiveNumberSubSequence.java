package etc;

import java.util.HashSet;
import java.util.Set;

public class ConsecutiveNumberSubSequence {

  public static int solution(int[] elements){
    Set<Integer> set = new HashSet<>();

    for(int i=1;i<=elements.length;i++){
      for (int j = 0; j < elements.length; j++) {
        int sum = 0;
        for (int k = 0; k < i; k++) {
          if(j + k > elements.length-1){      //원순열 처리
            sum += elements[j + k - elements.length];
          } else {
            sum += elements[j+k];
          }
        }
        set.add(sum);
      }
    }

    return set.size();
  }


  public static void main(String[] args) {
    int[] elements = {7,9,1,1,4};
    System.out.println(solution(elements));
  }

}
