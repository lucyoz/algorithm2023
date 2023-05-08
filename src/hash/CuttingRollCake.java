package hash;

import java.util.HashSet;
import java.util.Set;

public class CuttingRollCake {

  public int solution(int[] topping){
    int answer = 0;
    Set<Integer> cheolsu = new HashSet<>();
    Set<Integer> dongsaeng = new HashSet<>();

    int left = 0, right = topping.length-1;
    while(left < right){
      cheolsu.clear();
      dongsaeng.clear();

      for (int i = 0; i <= left; i++) {
        cheolsu.add(topping[i]);
      }
      for (int i = left+1; i <= right; i++) {
        dongsaeng.add(topping[i]);
      }
      if (cheolsu.size()==dongsaeng.size()){
        answer++;
      }
      left++;
    }
    return answer;
  }

  public static void main(String[] args) {
    CuttingRollCake cuttingRollCake = new CuttingRollCake();
    int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
    System.out.println(cuttingRollCake.solution(topping));

    int[] topping2 = {1, 2, 3, 1, 4};
    System.out.println(cuttingRollCake.solution(topping2));
  }

}
