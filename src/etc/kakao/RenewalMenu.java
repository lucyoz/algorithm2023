package etc.kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RenewalMenu {
  //1. 각 order 알파벳 순으로 정렬하기
  //2. order 기준으로 course 각 길이만큼 조합 만들기
  //3. 가장 많은 조합 저장

  List<String> answerList = new ArrayList<>();
  Map<String, Integer> map = new HashMap<>();

  public String[] solution(String[] orders, int[] course){
    String[] answer = {};

    for (int i = 0; i < orders.length; i++) {
      char[] order = orders[i].toCharArray();
      Arrays.sort(order);
      orders[i] = String.valueOf(order);
    }

    for(int c: course){
      for(String order: orders){
        combination("", order, c);
      }
      System.out.println(c);
      System.out.println(map);
      System.out.println();

      //각 갯수 조합마다 max인 key 찾음. 후 map 초기화
      if(!map.isEmpty()){
        List<Integer> countList = new ArrayList<>(map.values());
        int max = Collections.max(countList);

        if(max > 1){
          for(String key: map.keySet()){
            if(map.get(key)==max){
              answerList.add(key);
            }
          }
        }
        map.clear();
      }
    }

    Collections.sort(answerList);
    return answerList.stream().toArray(String[]::new);
  }

  public void combination(String order, String others, int count){
    if(count==0){
      map.put(order, map.getOrDefault(order, 0) + 1);
      return;
    }

    for (int i = 0; i < others.length(); i++) {
      combination(order + others.charAt(i), others.substring(i+1), count - 1);
    }
  }

  public static void main(String[] args) {

    RenewalMenu menu = new RenewalMenu();

    String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
    int[] course = {2,3,4};
    System.out.println(Arrays.toString(menu.solution(orders, course)));
    System.out.println();

    String[] orders2 = {"XYZ", "XWY", "WXA"};
    int[] course2 = {2,3,4};
    System.out.println(Arrays.toString(menu.solution(orders2, course2)));
  }

}
