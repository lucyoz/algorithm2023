package etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CuttingArray {

  public int[] solution(int n, long left, long right){
    int[] answer = new int[(int)right-(int)left+1];

    int[][] array = new int[n][n];
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j <= i; j++) {
        if(array[i][j] == 0){
          array[j][i] = i+1;
          array[i][j] = i+1;
        }
      }
    }

    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[0].length; j++) {
        list.add(array[i][j]);
      }

    }
    int k = 0;
    for (int i = (int) left; i <= (int)right; i++) {
      answer[k++] = list.get(i);
    }

    return answer;
  }

  public static void main(String[] args) {

    CuttingArray cuttingArray = new CuttingArray();
    System.out.println(Arrays.toString(cuttingArray.solution(3, 2, 5)));

    System.out.println(Arrays.toString(cuttingArray.solution(4,7,14)));
  }

}
