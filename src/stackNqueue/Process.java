package stackNqueue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Process {

  public static int solution(int[] priorities, int location){
    int answer = 0;

    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    Queue<Integer> q = new LinkedList<>();
    for(int priority : priorities){
      pq.add(priority);
      q.add(priority);
    }

    while(true){
      int qPr = q.poll();
      int pqPr = pq.poll();

      //둘이 같다면 (즉, 우선순위가 맞다면)
      if(qPr == pqPr){
        answer++;
        if(location == 0){
          break;
        }
      }  else {
        q.add(qPr);
        pq.add(pqPr);
        if(location == 0){
          location = q.size();
          System.out.println(location);
        } //else {
          //location--;
        //}
      }
      location--;
    }



    return answer;
  }

  public static void main(String[] args) {

    int[] priorities1 = {2,1,3,2};

    int[] priorities2 = {1,1,9,1,1,1};

    System.out.println("테케1: "+solution(priorities1, 2));
    System.out.println("테케2: "+solution(priorities2, 0));


  }

}
