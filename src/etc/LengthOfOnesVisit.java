package etc;

public class LengthOfOnesVisit {
  //2차원 배열이 아니라 3차원 배열!
  //해당 지점에서 왼, 아래, 위, 오른

  public int solution(String dirs){
    int answer = 0;
    int[] dx = {-1, 0, 0, 1};
    int[] dy = {0, -1, 1, 0};
    int x = 5, y = 5;

    boolean[][][] visited = new boolean[11][11][4];
    for (int i = 0; i < dirs.length(); i++) {
      char input = dirs.charAt(i);
      int dir = 0;

      switch(input){
        case 'L':
          dir = 0;
          break;
        case 'U':
          dir = 1;
          break;
        case 'D':
          dir = 2;
          break;
        case 'R':
          dir = 3;
          break;
        default:
          break;
      }

      int nx = x + dx[dir];
      int ny = y + dy[dir];

      if(nx < 0 || nx >= 11 || ny < 0 || ny >= 11){
        continue;
      }
      if(!visited[nx][ny][3-dir] && !visited[x][y][dir]){
        answer++;
        visited[nx][ny][3-dir] = true;
        visited[x][y][dir] = true;
      }

      x = nx;
      y = ny;
    }



    return answer;
  }

  public static void main(String[] args) {
    LengthOfOnesVisit lengthOfOnesVisit = new LengthOfOnesVisit();
    System.out.println(lengthOfOnesVisit.solution("ULURRDLLU"));
    System.out.println(lengthOfOnesVisit.solution("LULLLLLLU"));
  }

}
