package etc.practice;

import java.util.Arrays;

public class TableHashFunction {

  public int solution(int[][] data, int col, int row_begin, int row_end){
    int answer = 0;

    sort(data, col);

    int[] S = new int[row_end-row_begin+1];
    for (int i = row_begin; i <= row_end; i++) {
      for (int j = 0; j < data[i].length; j++) {
        S[i-row_begin] += data[i-1][j] % i;
      }
    }

    answer = getXOR(S);
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

  public int getXOR(int[] S){
    int result = S[0];
    for (int i = 1; i < S.length; i++) {
      result ^= S[i];
    }
    return result;
  }

  public static void main(String[] args) {
    TableHashFunction tableHashFunction = new TableHashFunction();

    int[][] data = {{2,2,6},{1,5,10},{4,2,9},{3,8,3}};
    System.out.println(tableHashFunction.solution(data,2,2,3));
  }

}
