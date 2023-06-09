package etc.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TableHashFunction {

  public int solution(int[][] data, int col, int row_begin, int row_end){
    int answer = 0;
    List<Integer> modRes = new ArrayList<>();

    sort(data, col);

    for (int i = row_begin; i <= row_end; i++) {
      int S = 0;
      for (int j = 0; j < data[0].length; j++) {
        S += data[i-1][j] % i;
      }
      modRes.add(S);
    }

    answer = getXOR(modRes);
    return answer;
  }

  public void sort(int[][] data, int col){
    Arrays.sort(data, (o1,o2)->{
      if(o1[col-1] == o2[col-1]){
        return o2[0]-o1[0];
      }
      return o1[col-1]-o2[col-1];
    });
  }

  public int getXOR(List<Integer> modResult){
    int result = modResult.get(0);
    for (int i = 1; i < modResult.size(); i++) {
      result ^= modResult.get(i);
    }
    return result;
  }

  public static void main(String[] args) {
    TableHashFunction tableHashFunction = new TableHashFunction();

    int[][] data = {{2,2,6},{1,5,10},{4,2,9},{3,8,3}};
    System.out.println(tableHashFunction.solution(data,2,2,3));
  }

}
