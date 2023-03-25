package etc;

//이것이 코딩테스트다
//BFS) 간선의 비용이 같을 때, 최단거리를 탐색하기 위해 사용할 수 있다
//

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
  private int x;
  private int y;

  public Node(int x, int y){
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
}

public class EscapeMaze {

  public static int n;
  public static int m;
  public static int[][] graph = new int[201][201];

  //이동할 네 가지 방향 정의 (상,하,좌,우)
  public static int dx[] = {-1, 1, 0, 0};
  public static int dy[] = {0, 0, -1, 1};

  public static int bfs(int x, int y){
    Queue<Node> q = new LinkedList<>();
    q.offer(new Node(x, y));

    //큐가 빌 때까지 반복
    while(!q.isEmpty()){
      Node node = q.poll();
      x = node.getX();
      y = node.getY();

      //현재 위치에서 4방향으로의 위치 확인
      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        //미로 찾기 공간을 벗어나면 무시
        if (nx < 0 || nx >=n || ny < 0 || ny >=m )  continue;

        //괴물이 있다면 무시
        if (graph[nx][ny] == 0) continue;

        //해당 노드를 처음 방문하는 경우에만 최단 거리 기록
        if (graph[nx][ny] == 1){
          graph[nx][ny] = graph[x][y] + 1;
          q.offer(new Node(nx, ny));
        }

      }
    }

    return graph[n-1][m-1];
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    m = sc.nextInt();
    sc.nextLine();

    //맵 정보 입력
    for (int i = 0; i < n; i++) {
      String str = sc.nextLine();
      for (int j = 0; j < m; j++) {
        graph[i][j] = str.charAt(j)-'0';
      }
    }

    //BFS 결과
    System.out.println(bfs(0,0));
  }

}
