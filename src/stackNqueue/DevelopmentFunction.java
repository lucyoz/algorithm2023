package stackNqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DevelopmentFunction {

  public int[] calDay(int[] progresses, int[] speeds){
    int[] days = new int[progresses.length];

    for (int i = 0; i < progresses.length; i++) {
      int day = 0;
      while(progresses[i]<100){
        day++;
        progresses[i] += speeds[i];
      }
      days[i] = day;
    }

    return days;
  }

  public int[] solution(int[] progresses, int[] speeds){
    int[] answer;
    boolean[] on = new boolean[progresses.length];
    int k = 0;
    List<Integer> list = new ArrayList<>();

    int[] days = calDay(progresses, speeds);
    System.out.println(Arrays.toString(days));

    for (int i = 0; i < days.length; i++) {
      if(i==days.length-1 && !on[i]){
        list.add(1);
        break;
      }
      if (!on[i]) {
        int deploy = 1;
        for (int j = i + 1; j < days.length; j++) {
          if (days[i] >= days[j]) {
            deploy++;
            on[j] = true;
          } else {
            break;
          }
        }
        list.add(deploy);
        //answer[k] = deploy;
        //k++;
        on[i] = true;
      }
    }

    answer = list.stream().mapToInt(Integer::intValue).toArray();

    return answer;
  }

  public static void main(String[] args) {
    DevelopmentFunction developmentFunction = new DevelopmentFunction();
    int[] progresses = {93, 30, 55};
    int[] speeds = {1, 30, 5};
    System.out.println(Arrays.toString(developmentFunction.solution(progresses, speeds)));
  }

}
