package etc;

import java.util.Arrays;

public class TriangleSnails {

  public int[] solution(int n){
    int[] answer = new int[n*(n+1)/2];
    int[][] matrix = new int[n][n];

    int x = -1, y = 0;
    int num = 1;


    //연산 방향이 3개(아래, 오른, 대각선 위)가 반복된다
    //i가 증가할 때마다 방향이 바뀌어야한다! -> i를 3으로 나눈 나머지로 방향을 바꾼다
    for (int i = 0; i < n; i++) {
      for (int j = i; j <n ; j++) {
        if(i%3==0){   //아래 방향
          x++;
        } else if (i%3==1){ //오른쪽으로
          y++;
        } else if (i%3==2){ //대각선 위로
          x--;
          y--;
        }
        matrix[x][y] = num++;
      }
    }
    int k=0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if(matrix[i][j] == 0){
          break;
        }
        answer[k++] = matrix[i][j];
      }

    }

    return answer;
  }

  public static void main(String[] args) {
    TriangleSnails snail = new TriangleSnails();
    System.out.println(Arrays.toString(snail.solution(4)));
    System.out.println(Arrays.toString(snail.solution(5)));
    System.out.println(Arrays.toString(snail.solution(6)));
  }

}
