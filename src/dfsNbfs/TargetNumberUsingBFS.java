package dfsNbfs;

import java.util.LinkedList;
import java.util.Queue;

class Pair{
  int position;
  int sum;

  public Pair(int position, int sum){
    this.position = position;
    this.sum = sum;
  }
}

public class TargetNumberUsingBFS {

  public static int solution(int[] numbers, int target){
    int answer = 0;

    answer = bfs(numbers, target);

    return answer;
  }

  public static int bfs(int[] numbers, int target){
    Queue<Pair> queue = new LinkedList<>();
    queue.add(new Pair(0, numbers[0]));
    queue.add(new Pair(0, numbers[0] * (-1)));

    int answer = 0;
    while (!queue.isEmpty()) {
      Pair p = queue.poll();
      if(p.position == numbers.length-1){
        if(p.sum == target){
          answer++;
        }
        continue;
      }


      int nPosition = p.position + 1;
      if (nPosition >= numbers.length){
        continue;
      }

      queue.add(new Pair(nPosition, p.sum + numbers[nPosition]));
      queue.add(new Pair(nPosition, p.sum + numbers[nPosition] * (-1)));
    }

    return answer;
  }

  public static void main(String[] args) {
    int[] numbers = {1, 1, 1, 1, 1};
    int target = 3;

    System.out.println(solution(numbers, target));
  }

}
