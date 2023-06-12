package etc.practice;

import java.util.Arrays;
import java.util.Comparator;

public class MineralMining {
  //1.광물 5개씩 묶어서 각 곡괭이에 따른 피로도 구하기
  //2.피로도 내림차순 정렬
  //3.다이아-철-돌 순의 갯수로 올바른 피로도(중 낮은 것) 리턴
  //>곡괭이가 충분치 않은 경우 고려<

  String[] type = {"diamond","iron","stone"};
  int numOfUses = 5;

  public int solution(int[] picks, String[] minerals){
    int answer = 0;

    int numOfPicks = 0;
    for (int i = 0; i < picks.length; i++) {
      numOfPicks += picks[i];
    }

    int[][] section = new int[minerals.length/5+1][picks.length];
    int i, pick;

    for (i = 0; i < minerals.length&&numOfPicks>0; i++) {
      if(minerals[i].equals(type[0])){
        section[i/5][0] += 1;
        section[i/5][1] += 5;
        section[i/5][2] += 25;
      } else if(minerals[i].equals(type[1])){
        section[i/5][0] += 1;
        section[i/5][1] += 1;
        section[i/5][2] += 5;
      } else {
        section[i/5][0] += 1;
        section[i/5][1] += 1;
        section[i/5][2] += 1;
      }

      if(i%5 == 4){
        numOfPicks--;
      }
    }
    Arrays.sort(section, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if(o1[2]<o2[2]){
          return 1;
        } else {
          return -1;
        }
      }
    });
    for (i = 0,pick = 0; i < section.length; i++) {
      while(pick<3 && picks[pick] == 0){
        pick++;
      }
      if(pick==3){
        break;
      }
      picks[pick]--;
      answer += section[i][pick];
    }
    return answer;
  }

  public int getFatigue(String[] minerals, String pick, int i){
    int fatigue = 0;
    int k = 0;
    int limit = numOfUses;

    int[] use;
    if(pick.equals(type[0])){
      use = new int[]{1, 1, 1};
    } else if (pick.equals(type[1])){
      use = new int[]{5, 1, 1};
    } else {
      use = new int[]{25, 5, 1};
    }
    if(minerals.length<i+numOfUses){
      limit = minerals.length - i;
    }

    while(k<limit){
      if(minerals[i+k].equals(type[0])){
        fatigue += use[0];
      } else if (minerals[i+k].equals(type[1])){
        fatigue += use[1];
      } else {
        fatigue += use[2];
      }
      k++;
    }

    return fatigue;
  }

  public static void main(String[] args) {
    MineralMining mineralMining = new MineralMining();

    int[] picks = {1, 3, 2};
    String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
    System.out.println(mineralMining.solution(picks, minerals));

    int[] picks2 = {0, 1, 1};
    String[] minerals2 = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};
    System.out.println(mineralMining.solution(picks2, minerals2));
  }

}
