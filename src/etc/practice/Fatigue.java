package etc.practice;

public class Fatigue {
  int max = Integer.MIN_VALUE;

  public void dfs(int k, int[][] dungeons, boolean[] visited){
    int count = 0;
    for(int i=0;i<visited.length;i++){
      if(visited[i]){
        count++;
      }
    }
    if(count > max){
      max = count;
    }

    for (int i = 0; i < dungeons.length;i++) {
      if(!visited[i]){
        if(dungeons[i][0]<=k){
          visited[i] = true;
          k -= dungeons[i][1];
          dfs(k, dungeons, visited);
          k+=dungeons[i][1];
          visited[i] = false;
        }
      }
    }

  }

  public int solution(int k, int[][] dungeons){
    boolean[] visited = new boolean[dungeons.length];
    dfs(k, dungeons, visited);

    return max;
  }

  public static void main(String[] args) {
    Fatigue fatigue = new Fatigue();
    int[][] dungeons= {{80,20},{50,40},{30,10}};
    System.out.println(fatigue.solution(80, dungeons));
  }

}
