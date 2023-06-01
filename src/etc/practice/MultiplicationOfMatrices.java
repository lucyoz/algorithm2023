package etc.practice;

import java.util.Arrays;

public class MultiplicationOfMatrices {

  public int[][] solution(int[][] arr1, int[][] arr2){
    int[][] answer = new int[arr1.length][arr2[0].length];

    for (int i = 0; i < arr1.length; i++) {
      for (int j = 0; j < arr2[0].length; j++) {
        for (int k = 0; k < arr1[0].length; k++) {
          answer[i][j] += arr1[i][k] * arr2[k][j];
          System.out.println("arr1["+i+"]["+k+"]="+arr1[i][k]+" arr2["+k+"]["+j+"]="+arr2[k][j]);
        }
      }
    }
    
    
    return answer;
  }

  public static void main(String[] args) {
    MultiplicationOfMatrices multiplicationOfMatrices = new MultiplicationOfMatrices();

    int[][] arr1 = {{2,3,2},{4,2,4},{3,1,4}};
    int[][] arr2 = {{5,4,3},{2,4,1},{3,1,1}};
    int[][] answer = multiplicationOfMatrices.solution(arr1, arr2);
    System.out.println(Arrays.toString(answer[0]));
    System.out.println(Arrays.toString(answer[1]));
    System.out.println(Arrays.toString(answer[2]));

  }

}
