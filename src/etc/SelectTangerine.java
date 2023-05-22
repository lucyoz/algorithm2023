package etc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectTangerine {

  public int solution(int k, int[] tangerine){
    int answer = 0;
    int box = 0;
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < tangerine.length; i++) {
      if(map.isEmpty() || !map.containsKey(tangerine[i])){
        map.put(tangerine[i],1);
        continue;
      }

      map.put(tangerine[i], map.get(tangerine[i])+1);
    }

    List<Integer> list = new ArrayList<>(map.values());
    Collections.sort(list, Collections.reverseOrder());


    while(box < k){
      box += list.get(0);
      answer++;
      list.remove(0);
    }

    return answer;
  }

  public static void main(String[] args) {
    SelectTangerine selectTangerine = new SelectTangerine();

    int[] tangerine = {1,3,2,5,4,5,2,3};
    System.out.println(selectTangerine.solution(6, tangerine));

    int[] tangerine2 = {1, 3, 2, 5, 4, 5, 2, 3};
    System.out.println(selectTangerine.solution(4, tangerine2));

    int[] tangerine3 = {1, 1, 1, 1, 2, 2, 2, 3};
    System.out.println(selectTangerine.solution(2, tangerine3));
  }

}
