package stackNqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DevelopmentFunctionUsingQueue {

  public int[] solution(int[] progresses, int[] speeds){
    Queue<Integer> q = new LinkedList<>();
    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < speeds.length; i++) {
      double remain = (100 - progresses[i]) / (double)speeds[i];
      int date = (int)Math.ceil(remain);

      if(!q.isEmpty() && q.peek()<date){
        list.add(q.size());
        q.clear();
      }
      q.offer(date);


    }
    list.add(q.size());
    int[] answer = new int[list.size()];
    for (int i = 0; i < answer.length; i++) {
      answer[i] = list.get(i);
    }
    return answer;
  }

  public static void main(String[] args) {
    DevelopmentFunction developmentFunction = new DevelopmentFunction();
    int[] progresses = {93, 30, 55};
    int[] speeds = {1, 30, 5};
    System.out.println(Arrays.toString(developmentFunction.solution(progresses, speeds)));
  }

}
