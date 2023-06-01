package etc.practice;

public class AlterXtoY {
  private static final int MAX = Integer.MAX_VALUE;

  public static int solution(int x, int y, int n){
    int answer = 0;
    int[] dp = new int[y+1];

    for (int i = x + 1; i < y+1; i++) {
      int a = MAX, b=MAX, c=MAX;

      if(i%2==0 && i/2 > 0 && x <= (i/2)){
        a = dp[i/2];
      }
      if(i%3==0 && i/3 > 0 && x <= (i/3)){
        b = dp[i/3];
      }
      if(x <= (i-n)){
        c = dp[i-n];
      }

      int d = Math.min(a, b);
      d = Math.min(d, c);

      //만들 수 있으면 d+1 저장
      //없으면 MAX 저장
      dp[i] = ( d < MAX ) ? d+1 : MAX;
    }
    answer = (dp[y] < MAX) ? dp[y] : -1;

    return answer;

  }

  public static void main(String[] args) {
    System.out.println(solution(10, 40, 5));
    System.out.println(solution(10, 40, 30));
    System.out.println(solution(2, 5, 4));
  }

}
