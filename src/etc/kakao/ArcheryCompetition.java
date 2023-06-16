package etc.kakao;

import java.util.Arrays;

//완전탐색, 백트래킹
public class ArcheryCompetition {

  static int[] result = {-1};
  static int[] lion;
  static int max = -1000;

  public int[] solution(int n, int[] info){
    lion = new int[11];
    dfs(info, 1, n);
    return result;
  }

  private void dfs(int[] info, int cnt, int n){
    if(cnt == n+1){
      int aPoint = 0;
      int lPoint = 0;
      for (int i = 0; i <= 10; i++) {
        if (info[i] != 0 || lion[i] != 0) {
          if (info[i] < lion[i]) {
            lPoint += 10 - i;
          } else {
            aPoint += 10 - i;
          }
        }
      }
        if(lPoint > aPoint){
          if(lPoint - aPoint >= max){
            result = lion.clone();
            max = lPoint - aPoint;
          }
        }
        return;
    }

    for (int j = 0; j <= 10 && lion[j]<=info[j]; j++) {
      lion[j]++;
      dfs(info, cnt+1, n);
      lion[j]--;
    }
  }


  public static void main(String[] args) {
    ArcheryCompetition archeryCompetition = new ArcheryCompetition();

    int[] info1 = {2,1,1,1,0,0,0,0,0,0,0};
    int[] info2 = {1,0,0,0,0,0,0,0,0,0,0};
    int[] info3 = {0,0,1,2,0,1,1,1,1,1,1};
    int[] info4 = {0,0,0,0,0,0,0,0,3,4,3};
//    System.out.println(Arrays.toString(archeryCompetition.solution(5, info1)));
//    System.out.println(Arrays.toString(archeryCompetition.solution(1, info2)));
    System.out.println(Arrays.toString(archeryCompetition.solution(9, info3)));
//    System.out.println(Arrays.toString(archeryCompetition.solution(10, info4)));

  }

}
