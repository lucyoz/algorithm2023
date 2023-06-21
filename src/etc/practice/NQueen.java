package etc.practice;

public class NQueen {
  //백트래킹 연습

  private static int[] board;
  private static int answer;

  public int solution(int n){
    board = new int[n];

    backTracking(0, n);
    return answer;
  }

  private void backTracking(int depth, int n){
    if(depth==n){
      answer++;
      return;
    }
    for (int i = 0; i < n; i++) {
      board[depth] = i;
      if(valid(depth)){
        backTracking(depth+1,n);
      }
    }
  }

  private boolean valid(int i) {
    for (int j = 0; j < i; j++) {
      if (board[i] == board[j]) {
        return false;
      }
      if (Math.abs(i - j) == Math.abs(board[i] - board[j])) {
        return false;
      }
    }
    return true;

  }

  public static void main(String[] args) {
    NQueen nQueen = new NQueen();
    System.out.println(nQueen.solution(4));
  }

}
