package etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CuttingArray2 {
  //max(1,1)max(1,2)max(1,3)
  //max(2,1)max(2,2)max(2,3)
  //max(3,1)max(3,2)max(3,3)

  //idx / n = 2/3 = 0 + 1 = 1
  //idx % n = 2%3 = 1 + 1 = 2

  //1차원 배열 2번 idx는 2차원 배열(1,2)와 같다



  public int[] solution(int n, long left, long right){
    int[] answer = new int[(int)(right-left)+1];
    for (int i = 0; i < answer.length; i++) {
      int y = (int)(left / n + 1);
      int x = (int)(left % n + 1);
      left++;
      answer[i] = Math.max(y, x);
    }




    return answer;
  }

  public static void main(String[] args) {

    CuttingArray2 cuttingArray = new CuttingArray2();
    System.out.println(Arrays.toString(cuttingArray.solution(3, 2, 5)));

    System.out.println(Arrays.toString(cuttingArray.solution(4,7,14)));
  }

}
