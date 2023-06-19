package etc.practice;

public class TicTecToc {
  //>승자가 정해진 경우
  //  - 승자 두 명 잘못된경우
  //  - 승자 한 명인 경우 O와X의 개수 (O:승자인 경우, X:승자인 경우)
  //>승자가 정해지지 않은 경우
  //  - O와X의 개수 같거나 O의 개수(선공)이 더 많아야

  public int solution(String[] board){

    int o = 0;
    int x = 0;

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < 3; j++) {
        if(board[i].charAt(j)=='O'){
          o++;
        } else if (board[i].charAt(j)=='X'){
          x++;
        }
      }
    }

    if(x > o || o-x > 1){
      return 0;
    }

    if(win(board, 'O') > 0 && win(board, 'X')>0){
      return 0;
    }
    if(win(board, 'O') > 0){
      if(o == x){
        return 0;
      }
    }
    if(win(board, 'X') > 0){
      if(o > x){
        return 0;
      }
    }


    return 1;
  }

  private int win(String[] board, char sign){
    int game = 0;

    for (int i = 0; i < 3; i++) {
      if(board[i].charAt(0)==sign && board[i].charAt(1)==sign && board[i].charAt(2)==sign){
        game++;
      }
      if(board[0].charAt(i)==sign && board[1].charAt(i)==sign && board[2].charAt(i)==sign){
        game++;
      }
    }

    //대각선 체크
    if(board[0].charAt(0)==sign && board[1].charAt(1)==sign && board[2].charAt(2)==sign){
      game++;
    }
    if(board[0].charAt(2)==sign && board[1].charAt(1)==sign && board[2].charAt(0)==sign){
      game++;
    }

    return game;
  }

  public static void main(String[] args) {
    TicTecToc ticTecToc = new TicTecToc();
    String[] board1 = {"O.X", ".O.", "..X"};
    String[] board2 = {"OOO", "...", "XXX"};
    String[] board3 = {"...", ".X.", "..."};
    String[] board4 = {"...", "...", "..."};


    System.out.println(ticTecToc.solution(board1));
    System.out.println(ticTecToc.solution(board2));
    System.out.println(ticTecToc.solution(board3));
    System.out.println(ticTecToc.solution(board4));
  }

}
