package hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CuttingRollCake2 {
  public int solution(int[] topping){
    int answer = 0;
    Set<Integer> set = new HashSet<>();   //동생 (하나씩 준다)
    Map<Integer, Integer> map = new HashMap<>();  //형 (하나씩 뺏김)

    for (int i = 0; i < topping.length; i++) {
      map.put(topping[i], map.getOrDefault(topping[i], 0) + 1);
    }

    for (int i = 0; i < topping.length; i++) {
      set.add(topping[i]);
      map.put(topping[i], map.get(topping[i])-1);
      if(map.get(topping[i])==0){
        map.remove(topping[i]);
      }
      if(set.size()==map.size()){
        answer++;
      }
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
