package stackNqueue;

import java.util.Arrays;

public class DevelopmentFunction2 {

  //100일을 가정한 길이 100짜리 배열,
  //해당 일자에 몇개가 끝나는지 넣어서
  public int[] solution(int[] progresses, int[] speeds){
    int[] dayOfend = new int[100];
    int day = -1;
    for (int i = 0; i < progresses.length; i++) {
      while(progresses[i] + (day*speeds[i]) < 100){
        day++;
      }
      dayOfend[day]++;
    }
    return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
  }

  public static void main(String[] args) {
    DevelopmentFunction developmentFunction = new DevelopmentFunction();
    int[] progresses = {93, 30, 55};
    int[] speeds = {1, 30, 5};
    System.out.println(Arrays.toString(developmentFunction.solution(progresses, speeds)));
  }

}
