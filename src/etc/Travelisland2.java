package etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Travelisland2 {

  static List<Integer> answer = new ArrayList<>();
  static int width;
  static int height;
  static char[][] map;
  static int[][] visited;
  static int[] xdir = {0, 0, -1, 1};
  static int[] ydir = {-1, 1, 0, 0};

  static int bfs(int x, int y){
    int tmp = map[x][y] - '0';
    for(int k=0;k<4;k++){
      int dx = x + xdir[k];
      int dy = y + ydir[k];
      if(dx >=0 && dx < height && dy >= 0 && dy < width){
        if(visited[dx][dy] == 0 && map[dx][dy] != 'X'){
          visited[dx][dy] = 1;
          tmp += bfs(dx, dy);
        }
      }
    }
    return tmp;
  }

  public static int[] solution(String[] maps){
    width = maps[0].length();
    height = maps.length;

    map = new char[height][width];
    visited = new int[height][width];

    for (int i = 0; i < maps.length; i++) {
      map[i] = maps[i].toCharArray();
    }

    for (int i = 0; i < maps.length; i++) {
      for (int j = 0; j < map[i].length; j++) {
        if(map[i][j] != 'X' && visited[i][j] == 0){
          visited[i][j] = 1;
          int isLand = bfs(i,j);
          if(isLand!=0){
            answer.add(isLand);
          }
        }
      }

    }

    Collections.sort(answer);
    if (answer.isEmpty()) {
      answer.add(-1);
    }
    return answer.stream().mapToInt(i->i).toArray();

  }


  public static void main(String[] args) {
    String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};
    String[] maps2 = {"XXX","XXX","XXX"};
    //System.out.println(Arrays.toString(solution(maps)));
    System.out.println(Arrays.toString(solution(maps2)));
  }



}
