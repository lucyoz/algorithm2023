package etc.practice;

import java.util.Arrays;
import java.util.Stack;

class Work{
  String name;
  int workingTime;

  public Work(String name, int workingTime){
    this.name = name;
    this.workingTime = workingTime;
  }
}

public class DoHW {
  //stack 이용
  //끝나는 시간, 다음것이 시작하는 시간 비교
  //먼저 끝나면 배열에 넣기

  public String[] solution(String[][] plans){
    String[] answer = new String[plans.length];

    Arrays.sort(plans, (o1, o2) -> {
      return o1[1].compareTo(o2[1]);
    });

    Stack<Work> stack = new Stack<>();
    int prevTime = 0;
    int idx = 0;
    for (int i = 0; i < plans.length; i++) {
      String subject = plans[i][0];
      int startTime = getMin(plans[i][1]);
      int workingTime = Integer.parseInt(plans[i][2]);

      while (!stack.isEmpty()){
        Work prevWork = stack.pop();
        int endTime = prevTime + prevWork.workingTime;
        //먼저 끝나면
        if(endTime <= startTime){
          answer[idx++] = prevWork.name;
          prevTime += prevWork.workingTime;
        } else {
          stack.push(new Work(prevWork.name, prevWork.workingTime-(startTime - prevTime)));
          break;
        }
      }
      stack.push(new Work(subject, workingTime));
      prevTime = startTime;
    }
    while(!stack.isEmpty()){
      answer[idx++] = stack.pop().name;
    }

    return answer;
  }

  private int getMin(String time){
    int hour = Integer.parseInt(time.split(":")[0]);
    int min = Integer.parseInt(time.split(":")[1]);

    return hour*60 + min;
  }

  public static void main(String[] args) {
    DoHW doHW = new DoHW();

    String[][] plans1 = {{"korean", "11:40", "30"},{"english", "12:10", "20"},{"math", "12:30", "40"}};
    String[][] plans2 = {{"science", "12:40", "50"},{"music", "12:20", "40"},{"history", "14:00", "30"},{"computer", "12:30", "100"}};
    String[][] plans3 = {{"aaa", "12:00", "20"},{"bbb", "12:10", "30"},{"ccc", "12:40", "10"}};
    System.out.println(Arrays.toString(doHW.solution(plans1)));
    System.out.println(Arrays.toString(doHW.solution(plans2)));
    System.out.println(Arrays.toString(doHW.solution(plans3)));
  }

}
