package etc;

//이것이 코딩테스트다
//DFS 혹은 BFS
//얼음을 얼릴 수 있는 공간은 그래프 형태로 모델링할 수 있다.

import java.util.Scanner;

public class Icecream {
  public static int n, m;
  public static int[][] graph = new int[1000][1000];

  public static boolean dfs(int x, int y){

    if (x<=-1 || x>=n || y<=-1 || y>=m){
      return false;
    }

    if(graph[x][y]==0){
      graph[x][y] = 1;

      //상,하,좌,우 위치를 모두 재귀적으로 호출
      dfs(x-1, y);
      dfs(x, y-1);
      dfs(x+1, y);
      dfs(x, y+1);
      return true;
    }

    return false;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    //입력받기
    n = sc.nextInt();
    m = sc.nextInt();
    sc.nextLine();

    for (int i = 0; i < n; i++) {
      String str = sc.nextLine();
      for (int j = 0; j < m; j++) {
        graph[i][j] = str.charAt(j) - '0';
      }
    }

    //음료수 채우기
    int result = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if(dfs(i,j)){
          result++;
        }
      }

    }
    System.out.println(result);
  }
}
