package bruteForce;

import java.util.LinkedList;
import java.util.Queue;

public class DividePowerGrid {
  //망을 2차원 배열로
  //전력망 제외와 처리
  //제외된 전력망 노드를 기준으로 각 전력망의 개수의 차 구하기

  public int solution(int n, int[][] wires){
    int answer = n;

    boolean[][] map = new boolean[n+1][n+1];
    for(int[] wire: wires){
      map[wire[0]][wire[1]] = true;
      map[wire[1]][wire[0]] = true;
    }

    for(int[] exclude: wires){
      answer = Math.min(answer, getGap(n, map, exclude));
    }


    return answer;
  }

  public int getGap(int n, boolean[][] map, int[] exclude){
    map[exclude[0]][exclude[1]] = false;
    map[exclude[1]][exclude[0]] = false;

    int result = Math.abs(getNodeCnt(n, map, exclude[0]) - getNodeCnt(n, map, exclude[1]));

    map[exclude[0]][exclude[1]] = true;
    map[exclude[1]][exclude[0]] = true;

    return result;
  }

  //bfs 이용하여 카운트
  public int getNodeCnt(int n, boolean[][] map, int startNode){
    int result = 1;

    boolean[] visited = new boolean[n+1];
    Queue<Integer> queue = new LinkedList<>();
    queue.add(startNode);
    visited[startNode] = true;
    while(!queue.isEmpty()){
      int node = queue.poll();

      for (int i = 1; i <= n; i++) {
        if(!visited[i] && map[node][i]){
          queue.add(i);
          visited[i] = true;
          result++;
        }
      }
    }
    return result;
  }


  public static void main(String[] args) {
    DividePowerGrid dividePowerGrid = new DividePowerGrid();

    int[][] wires1 = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
    int[][] wires2 = {{1,2},{2,3},{3,4}};
    int[][] wires3 = {{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}};
    System.out.println(dividePowerGrid.solution(9,wires1));
    System.out.println(dividePowerGrid.solution(4,wires2));
    System.out.println(dividePowerGrid.solution(7,wires3));
  }

}
