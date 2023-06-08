package etc.practice;

public class BiggestSquare {
  //행 또는 열이 길이 1이면 정사각형 넓이는 1
  //1.board의 위,왼,대각선위(외쪽위) 값들의 최솟값들을 구한뒤, 위치에 최솟값+1을 할당
  //2.board값 중 최댓값을 구하고 제곱하면 넓이 answer이다.

  public int solution(int[][] board){
    int answer = 0;

    int x = board.length;
    int y = board[0].length;
    int max = 0;

    if(x<=1 || y<=1){
      return 1;
    }
    for (int i = 1; i < x; i++) {
      for (int j = 1; j < y; j++) {
        if(board[i][j] >= 1){
          int up = board[i-1][j];
          int left = board[i][j-1];
          int upperLeft = board[i-1][j-1];
          int min = Math.min(up,left);
          min = Math.min(min, upperLeft);
          board[i][j] = min + 1;
          max = Math.max(max, min+1);
        }
      }
    }

    answer = max * max;
    return answer;
  }

  public static void main(String[] args) {
    BiggestSquare biggestSquare = new BiggestSquare();

    int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
    int[][] board2 = {{0,0,1,1},{1,1,1,1}};
    System.out.println(biggestSquare.solution(board));
    System.out.println(biggestSquare.solution(board2));
  }

}
