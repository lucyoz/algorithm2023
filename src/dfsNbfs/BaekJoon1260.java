package dfsNbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//DFS와 BFS
public class BaekJoon1260 {

  static StringBuilder sb = new StringBuilder();

  static int N = 0;
  static int M = 0;
  static int V = 0;
  static int[][] arr;
  static int[] visited;

  public static void solution(int start){
    dfs(start);
    sb.append("\n");
    bfs(start);
    System.out.println(sb);
  }

  public static void dfs(int start){
    visited[start] = 1;                             //start는 이미 방문함.
    sb.append(start+" ");
    for (int i = 0; i <= N ; i++) {
      if(arr[start][i]==1 && visited[i]==0){    //start와 i 두 노드가 이어져있고, 아직 방문한 적이 없다면
        dfs(i);                                     //i를 방문함.
      }
    }

  }

  public static void bfs(int start){
    Queue<Integer> q = new LinkedList<>();
    q.add(start);
    visited[start] = 1;

    while (!q.isEmpty()) {
      start = q.poll();
      sb.append(start+" ");
      for (int i = 1; i <= N; i++) {
        if(arr[start][i] == 1 && visited[i] == 0){
          q.add(i);
          visited[i] = 1;
        }
      }

    }

  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();
    V = sc.nextInt();


    arr = new int[N+1][N+1];
    for (int i = 0; i <= N; i++) {
      arr[i][i] = 1;
    }

    for (int i = 0; i < M; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();

      arr[a][b] = 1;
      arr[b][a] = 1;
    }

    visited = new int[N+1];
    dfs(V);
    sb.append("\n");
    visited = new int[N+1];
    bfs(V);
    System.out.println(sb);
  }
}
