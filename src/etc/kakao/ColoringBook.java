package etc.kakao;

import java.util.Arrays;

public class ColoringBook {
  static int numberOfArea;
  static int maxSizeOfOneArea;

  static int tmpCnt = 0;

  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  public int[] solution(int m, int n, int[][] picture){
    numberOfArea = 0;
    maxSizeOfOneArea = 0;
    int[] answer = new int[2];
    answer[0] = numberOfArea;
    answer[1] = maxSizeOfOneArea;

    boolean[][] check = new boolean[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if(picture[i][j]!=0 && !check[i][j]){
          numberOfArea++;
          dfs(i, j, picture, check);
        }

        if(tmpCnt > maxSizeOfOneArea){
          maxSizeOfOneArea = tmpCnt;
        }
        tmpCnt = 0;
      }

      answer[0] = numberOfArea;
      answer[1] = maxSizeOfOneArea;
    }
    return answer;
  }

  private void dfs(int x, int y, int[][] picture, boolean[][] check){
    if(check[x][y]){
      return;
    }
    check[x][y] = true;
    tmpCnt++;

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if(nx<0 || nx>=picture.length || ny<0 || ny>=picture[0].length){
        continue;
      }

      if(picture[x][y]==picture[nx][ny] && !check[nx][ny]){
        dfs(nx, ny, picture, check);
      }

    }
  }

  public static void main(String[] args) {

    ColoringBook coloringBook = new ColoringBook();
    int[][] picture = {{1,1,1,0},{1,2,2,0},{1,0,0,1},{0,0,0,1},{0,0,0,3},{0,0,0,3}};
    System.out.println(Arrays.toString(coloringBook.solution(6, 4, picture)));
  }

}
