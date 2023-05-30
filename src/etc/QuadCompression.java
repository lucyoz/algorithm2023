package etc;

import java.util.Arrays;

public class QuadCompression {
  private int zero = 0;
  private int one = 0;

  public void count(int y, int x, int[][] arr, int size){
    if(check(y,x,arr,size)){
      if(arr[y][x]==0){
        zero++;
      } else {
        one++;
      }
      return;
    }
    int nextSize = size/2;

    count(y,x, arr, nextSize);
    count(y,x+nextSize, arr, nextSize);
    count(y+nextSize,x, arr, nextSize);
    count(y+nextSize,x+nextSize, arr, nextSize);
  }

  public int[] solution(int[][] arr){
    int[] answer = new int[2];

    int length = arr.length;

    count(0,0,arr,length);
    answer[0] = zero;
    answer[1] = one;

    return answer;
  }

  private boolean check(int y, int x, int[][] arr, int size){
    int value = arr[y][x];

    for (int i = y; i < y+size; i++) {
      for (int j = x; j < x+size; j++) {
        if(arr[i][j]!=value){
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    QuadCompression quad = new QuadCompression();

    int[][] arr1 = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
    int[][] arr2 = {{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}};
    //System.out.println(Arrays.toString(quad.solution(arr1)));
    System.out.println(Arrays.toString(quad.solution(arr2)));
  }

}
