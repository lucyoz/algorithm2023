package etc.kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SocialDistancing {
  //1.places로 matrix 5개 각각 만들기, P 위치
  //2.각각의 거리두기 확인
    //2-1.dfs 이용
    //2-2.거리가 2이하인 곳을 탐색 -> P나 0있으면 위치에서 다시 탐색
    //2-3.행렬의 끝과 끝까지 탐색 후 2이하인 곳에 여전히 P가 있으면 false 반환

  private static char[][] matrix;
  private static List<int[]> person;
  private static boolean[][] visited;
  private static int[] dx = {-1, 1, 0, 0};
  private static int[] dy = {0, 0, 1, -1};
  private static boolean flag;
  private static final int size = 5;
  public int[] solution(String[][] places){
    int[] answer = new int[places.length];
    List<Integer> answer1 = new ArrayList<>();

    matrix = new char[size][size];

    for (int i = 0; i < places.length; i++) {
      person = new ArrayList<>();
      visited = new boolean[size][size];
      flag = true;

      //matrix로 분리, P의 좌표 저장
      makeMatrix(places[i]);

      for (int j = 0; j < person.size(); j++) {
        int[] p = person.get(j);
        dfs(p[0], p[1], p[0], p[1]);
      }

      if(flag) {
        answer[i] = 1;
      } else {
        answer[i] = 0;
      }
    }



    return answer;
  }

  //ax: P의 가로위치
  //ay: P의 세로위치
  public static void dfs(int x, int y, int ax, int ay){
    visited[x][y] = true;

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if(nx<0 || ny<0 || nx>=size || ny>=size || visited[nx][ny]){
        continue;
      }

      //거리 2 이하이면
      if(inDistance(ax, ay, nx, ny)){
        if(matrix[nx][ny]=='P' || matrix[nx][ny]=='O'){
          dfs(nx, ny, ax, ay);

          if(matrix[nx][ny]=='P'){
            flag = false;
          }
        }
      }
    }

  }

  public static boolean inDistance(int x1, int y1, int x2, int y2){
    int xd = Math.abs(x2-x1);
    int yd = Math.abs(y2-y1);

    return (xd + yd) <= 2 ? true:false;
  }

  public void makeMatrix(String[] place){

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        matrix[i][j] = place[i].charAt(j);
        if(matrix[i][j] == 'P'){
          person.add(new int[]{i,j});
        }
      }
      System.out.println(Arrays.toString(matrix[i]));
    }
  }

  public static void main(String[] args) {
    SocialDistancing social = new SocialDistancing();

    String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
    System.out.println(Arrays.toString(social.solution(places)));
  }

}
