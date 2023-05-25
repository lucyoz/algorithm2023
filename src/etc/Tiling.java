package etc;

public class Tiling {

  public int solution(int n){
    //피보나치 숨어있음
    int[] dp = new int[n+1];

    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 3;
    for (int i = 4; i < n+1; i++) {
      dp[i] = (dp[i-1]+dp[i-2])%1000000007;
    }
    int answer = dp[n];
    return answer;
  }

  public static void main(String[] args) {
    Tiling tiling = new Tiling();

    System.out.println(tiling.solution(4));
  }

}
