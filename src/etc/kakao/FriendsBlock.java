package etc.kakao;

import java.util.LinkedList;
import java.util.Queue;

public class FriendsBlock {
  //1.2*2블록이 같은지 체크하는 메서드
  //  1-1.>모든 블록 조사< 후 처리해야함
  //블록 제거 메서드
  //  2-1.큐 이용
  //  2-2.맨 아래부터 큐에 넣고 제거해야하면 개수만 세고 큐에 넣지x
  //  2-3.빈 블록은 #으로

  static boolean[][] visit;

  public int solution(int m, int n, String[] board){
    int answer = 0;
    char[][] game = new char[m][n];

    for (int i = 0; i < m; i++) {
      game[i] = board[i].toCharArray();
    }

    boolean flag = true;
    while(flag){
      visit = new boolean[m][n];
      flag = false;
      for (int i = 0; i < m-1; i++) {
        for (int j = 0; j < n-1; j++) {
          if(game[i][j]=='#'){        //#은 빈칸
            continue;
          }
          if(check(i, j, game)){
              visit[i][j] = true;
              visit[i+1][j] = true;
              visit[i][j+1] = true;
              visit[i+1][j+1] = true;
              flag = true;
            }
          }
        }

      answer += delete(m, n, game);
      visit = new boolean[m][n];
    }
    return answer;
  }

  private int delete(int m, int n, char[][] arr){
    int count = 0;

    //지울 블록 '.'으로
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if(visit[i][j]){
          arr[i][j] = '.';
        }
      }
    }

    //큐 이용, 세로 제거
    for (int i = 0; i < n; i++) {
      Queue<Character> q = new LinkedList<>();
      for (int j = m-1; j >= 0; j--) {
        if(arr[j][i] == '.'){
          count++;
        } else {
          q.add(arr[j][i]);
        }
      }
      int idx = m - 1;
      while(!q.isEmpty()){
        arr[idx--][i] = q.poll();
      }

      //빈칸
      for (int j = idx; j >= 0; j--) {
        arr[j][i] = '#';
      }
    }

    return count;
  }

  //2*2블록 체크하는 메서드
  private boolean check(int x, int y, char[][] arr){
    char ch = arr[x][y];
    if(ch==arr[x][y+1] && ch==arr[x+1][y] && ch==arr[x+1][y+1]){
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    FriendsBlock friendsBlock = new FriendsBlock();
    String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
    System.out.println(friendsBlock.solution(4,5,board));

    String[] board2 = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
    System.out.println(friendsBlock.solution(6,6,board2));
  }

}
