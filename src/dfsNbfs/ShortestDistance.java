package dfsNbfs;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistance {
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};

  public static int solution(int[][] maps){
    int answer = 0;

    int[][] visited = new int[maps.length][maps[0].length];

    bfs(maps, visited);
    answer = visited[maps.length-1][maps[0].length-1];

    if(answer == 0){
      return -1;
    }
    return answer;
  }

  public static void bfs(int[][] maps, int[][] visited){
    int x = 0;
    int y = 0;
    visited[x][y] = 1;
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{x, y});

    while (!queue.isEmpty()) {
      int[] current = queue.remove();
      int cX = current[0];
      int cY = current[1];

      for (int i = 0; i < 4; i++) {       //4가지 방향(상,하,좌,우)
        int nX = cX + dx[i];
        int nY = cY + dy[i];

        if(nX < 0 || nX > maps.length-1 || nY < 0 || nY > maps[0].length-1){
          continue;
        }

        if(visited[nX][nY] == 0 && maps[nX][nY] == 1){
          visited[nX][nY] = visited[cX][cY] + 1;
          queue.add(new int[]{nX, nY});
        }
      }
    }
  }


  public static void main(String[] args) {
    int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};

    System.out.println(solution(maps));

  }

}
