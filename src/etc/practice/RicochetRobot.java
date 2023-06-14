package etc.practice;

import java.util.LinkedList;
import java.util.Queue;

class Moving{
  int x, y, depth;
  public Moving(int x, int y, int depth){
    this.x = x;
    this.y = y;
    this.depth = depth;
  }
}

public class RicochetRobot {
  //최소 구하기? -> bfs 이용
  //>한번만 움직이는 것이 아니라 벽, 장애물 끝까지 미끄러진다!<

  private final int[] dx = {-1, 1, 0, 0};
  private final int[] dy = {0, 0, -1, 1};
  private int n, m;

  public int solution(String[] board){
    int answer = 0;
    n = board.length;
    m = board[0].length();
    Moving robot = null;
    Moving goal = null;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        char ch = board[i].charAt(j);

        if (ch == 'R') {
          robot = new Moving(i, j, 0);
        } else if(ch=='G'){
          goal = new Moving(i, j, 0);
        }
      }
    }
    answer = bfs(board, robot, goal);

    return answer;
  }

  private int bfs(String[] board, Moving robot, Moving goal){
    Queue<Moving> q = new LinkedList<>();
    q.add(robot);
    boolean[][] visited = new boolean[n][m];
    visited[robot.x][robot.y] = true;

    while(!q.isEmpty()){
      Moving move = q.poll();

      if(move.x==goal.x && move.y == goal.y){
        return move.depth;
      }

      for (int i = 0; i < 4; i++) {
        int nx = move.x;
        int ny = move.y;

        while(nx>=0 && ny>=0 && nx<n && ny<m && board[nx].charAt(ny)!='D'){
          nx += dx[i];
          ny += dy[i];
        }

        nx -= dx[i];
        ny -= dy[i];

        if(visited[nx][ny] || (move.x==nx && move.y==ny)){
          continue;
        }

        visited[nx][ny] = true;
        q.add(new Moving(nx, ny, move.depth+1));
      }
    }
    return -1;
  }

  public static void main(String[] args) {

    RicochetRobot ricochetRobot = new RicochetRobot();
    String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
    String[] board1 = {".D.R", "....", ".G..", "...D"};
    System.out.println(ricochetRobot.solution(board));
    System.out.println(ricochetRobot.solution(board1));
  }

}
