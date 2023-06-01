package etc.practice;

public class StandingLongJump {

  public long solution(int n){
    long answer = 0;

    long[] dp = new long[n+1];
    //피보나치
    if(n==1){
      return 1;
    }
    if(n==2){
      return 2;
    }
    dp[0] = 0;
    dp[1] = 1l;
    dp[2] = 2l;
    for (int i = 3; i <= n; i++) {
      dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
    }

    answer = dp[n];
    return answer;
  }

  public static void main(String[] args) {
    StandingLongJump jump = new StandingLongJump();

    System.out.println(jump.solution(4));
    System.out.println(jump.solution(3));
  }

}
