package hash;

import java.util.HashMap;
import java.util.Map;

public class Clothes {

  public static int solution(String[][] clothes){
    int answer = 1;

    Map<String, Integer> map = new HashMap<>();
    map.put(clothes[0][1],0);
    for (int i = 0; i < clothes.length; i++) {
      if(map.containsKey(clothes[i][1])){
        map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
      } else {
        map.put(clothes[i][1],1);
      }
    }

    for(String key: map.keySet()){
      answer *= (map.get(key)+1);
    }

    answer -= 1;

    return answer;
  }

  public static void main(String[] args) {
    String[][] clothes = {{"yellow_hat", "headgear"},{"blue_sunglasses", "eyewear"},{"green_turban", "headgear"}};
    String[][] clothes2 = {{"crow_mask", "face"},{"blue_sunglasses", "face"},{"smoky_makeup", "face"}};

    System.out.println(solution(clothes));
    System.out.println(solution(clothes2));
  }

}
