package greedy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LifeBoat {

  public int solution(int[] people, int limit){
    int answer = 0;

    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < people.length; i++) {
      list.add(people[i]);
    }
    Collections.sort(list);

    //사이즈 지정 -> ArrayDeque는 사이즈를 늘릴 때 오버헤드 발생하니까 미리 지정
    ArrayDeque<Integer> dq = new ArrayDeque<>(50001);
    for(int x: list){
      dq.add(x);
    }
    while(!dq.isEmpty()){
      int weight = dq.pollLast();
      if(!dq.isEmpty() && weight + dq.peekFirst() <= limit){
        dq.pollFirst();
      }
      answer++;
    }


    return answer;
  }

  public static void main(String[] args) {
    LifeBoat lifeBoat = new LifeBoat();
    int[] people = {70, 50, 80, 50};
    System.out.println(lifeBoat.solution(people, 100));

    int[] people2 = {70, 50, 80};
    System.out.println(lifeBoat.solution(people2, 100));
  }

}
