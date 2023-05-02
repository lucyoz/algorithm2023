package stackNqueue;

import java.util.LinkedList;
import java.util.Queue;

public class SumQueue {

  public static int solution(int[] queue1, int[] queue2){
    long sum1 = 0;
    long sum2 = 0;

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();


    //두 큐에 담긴 모든 원소의 합 구하기 total
    //큐에 값 넣기
    for (int i = 0; i < queue1.length; i++) {
      sum1 += queue1[i];
      q1.offer(queue1[i]);
      sum2 += queue2[i];
      q2.offer(queue2[i]);
    }

    int count = 0;
    while(sum1 != sum2){
      count++;
      if(sum1 > sum2){
        int value = q1.poll();
        sum1 -= value;
        sum2 += value;
        q2.offer(value);
      } else {
        int value = q2.poll();
        sum1 += value;
        sum2 -= value;
        q1.offer(value);
      }

      if(count > (queue1.length + queue2.length) * 2 ) {
        return -1;
      }
    }
    return count;



  }

  public static void main(String[] args) {
    int[] queue1 = new int[4];
    queue1[0] = 3;
    queue1[1] = 2;
    queue1[2] = 7;
    queue1[3] = 2;

    int[] queue2 = new int[4];
    queue2[0] = 4;
    queue2[1] = 6;
    queue2[2] = 5;
    queue2[3] = 1;

    System.out.println(solution(queue1, queue2));
  }

}
