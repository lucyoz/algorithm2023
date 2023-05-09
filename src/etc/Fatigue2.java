package etc;

public class Fatigue2 {

  int dfs(int k, int[][] dungeons){
    int cnt = 0;
    for(int[] d: dungeons){
      int a = d[0], b = d[1];
      if(a <= k){
        d[0] = 9999;
        cnt = Math.max(1 + dfs(k-b, dungeons), cnt);
        d[0] = a;
      }
    }
    return cnt;
  }

  public int solution(int k, int[][] dungeons){
    return dfs(k, dungeons);
  }

  public static void main(String[] args) {
    Fatigue fatigue = new Fatigue();
    int[][] dungeons= {{80,20},{50,40},{30,10}};
    System.out.println(fatigue.solution(80, dungeons));
  }

}
