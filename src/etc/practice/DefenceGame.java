package etc.practice;

import java.util.PriorityQueue;

public class DefenceGame {
  //결론적으로 라운드 횟수만 구하면 됨
  //1.우선순위 큐에 값을 넣고,
  //2.무적권을 쓸 수 있는 k보다 횟수가 많아지면
  //3.그 때부터 n 감소시키기

  public int solution(int n, int k, int[] enemy){

    PriorityQueue<Integer> queue = new PriorityQueue<>();
    for (int i = 0; i < enemy.length; i++) {
      queue.add(enemy[i]);
      if(queue.size()>k){
        n -= queue.poll();

        if(n<0){
          return i;
        }
      }
    }

    return enemy.length;
  }

  public static void main(String[] args) {
    DefenceGame defenceGame = new DefenceGame();

    int[] enemy = {4, 2, 4, 5, 3, 3, 1};
    int[] enemy2 = {3, 3, 3, 3};
    System.out.println(defenceGame.solution(2, 5, enemy2));
  }

}
