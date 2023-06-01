package etc;

public class Delivery {
  static final int INF = 50001;

  public int solution(int N, int[][] road, int K){
    int answer = 0;

    int[][] map = new int[N+1][N+1];

    //무한대 초기화
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        if(i==j){
          continue;
        }
        map[i][j] = INF;
      }
    }

    for (int i = 0; i < road.length; i++) {
      int townA = road[i][0];
      int townB = road[i][1];
      int time = road[i][2];

      if(map[townA][townB] > time){
        map[townA][townB] = time;
        map[townB][townA] = time;
      }
    }

    int[] dist = new int[N+1];
    for (int i = 2; i <= N; i++) {
      dist[i] = (dist[i]==0) ? INF: map[1][i];
    }

    boolean[] visited = new boolean[N+1];
    visited[1] = true;

    for (int i = 1; i <= N-1; i++) {
      int minIdx = 1;
      int minValue = INF;

      //방문하지 않았고 가장 작은 값을 가지는 인덱스 찾기
      for (int j = 2; j <= N; j++) {
        if(!visited[j] && dist[j] < minValue){
          minValue = dist[j];
          minIdx = j;
        }
      }

      visited[minIdx] = true;

      //거쳐가는게 더 빠른지 확인
      for (int j = 2; j <= N; j++) {
        if(dist[j] > dist[minIdx]+map[minIdx][j]){
          dist[j] = dist[minIdx] + map[minIdx][j];
        }
      }

    }
    for (int i = 1; i <= N; i++) {
      if(dist[i]<=K){
        answer++;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    Delivery delivery = new Delivery();

    int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
    int[][] road2 = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
    System.out.println(delivery.solution(5, road, 3));
    System.out.println(delivery.solution(6, road2, 4));
  }

}
