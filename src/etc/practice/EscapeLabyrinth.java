package etc.practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair{
  int y, x;
  public Pair(int y, int x){
    this.y = y;
    this.x = x;
  }
}

public class EscapeLabyrinth {
  //bfs 이용
  //S~L까지, L~E까지

  private static int[] dx = {0, 1, 0, -1};
  private static int[] dy = {-1, 0, 1, 0};
  public static int[][] visited;
  public static char[][] matrix;
  public static Pair start;
  public static Pair end;

  public int solution(String[] maps){
    int answer = 0;
    matrix = new char[maps.length][maps[0].length()];

    for (int i = 0; i < maps.length; i++) {
      for (int j = 0; j < maps[0].length(); j++) {
        matrix[i][j] = maps[i].charAt(j);
        if(matrix[i][j] == 'S'){
          start = new Pair(i, j);
          continue;
        }
        if (matrix[i][j] == 'E'){
          end = new Pair(i, j);
        }
      }
    }

    answer = bfs(matrix, new int[matrix.length][matrix[0].length]);
    return answer;
  }

  private int bfs(char[][] map, int[][] visited){
    Queue<Pair> q = new LinkedList<>();
    q.add(start);
    int ly = -1, lx = -1, lc = -1;

    while(!q.isEmpty()){
      Pair p = q.poll();
      for (int i = 0; i < 4; i++) {
        int ny = p.y + dy[i];
        int nx = p.x + dx[i];
        if(ny<0 || nx<0 || ny>=matrix.length || nx>=matrix[0].length || matrix[ny][nx]=='X' || visited[ny][nx]>0 ){
          continue;
        }
        q.add(new Pair(ny, nx));
        visited[ny][nx] = visited[p.y][p.x] + 1;
        if(map[ny][nx] == 'L'){
          ly = ny;
          lx = nx;
          lc = visited[ny][nx];
          break;
        }
      }
    }

    if(ly == -1 || lx == -1 || lc == -1){
      return -1;
    }

    visited = new int[matrix.length][matrix[0].length];
    visited[ly][lx] = lc;
    q = new LinkedList<>();
    q.add(new Pair(ly, lx));
    while(!q.isEmpty()){
      Pair p = q.poll();
      for (int i = 0; i < 4; i++) {
        int ny = p.y + dy[i];
        int nx = p.x + dx[i];
        if(ny<0 || nx<0 || ny>=matrix.length || nx>=matrix[0].length || matrix[ny][nx]=='X' || visited[ny][nx]>0 ){
          continue;
        }
        q.add(new Pair(ny, nx));
        visited[ny][nx] = visited[p.y][p.x] + 1;
      }
    }

    return visited[end.y][end.x]==0 ? -1:visited[end.y][end.x];
  }

  public static void main(String[] args) {
    EscapeLabyrinth escapeMaze = new EscapeLabyrinth();

    String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
    System.out.println(escapeMaze.solution(maps));

//    String[] maps2 = {"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"};
//    System.out.println(escapeMaze.solution(maps2));
  }

}
