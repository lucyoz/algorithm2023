package etc.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayingAlone {
  //1.카드 조합 찾기(ex. 8,4,7,1 & 6,5,2 & 3)
  //2.조합 저장된 map의 value 꺼내서
  //3.내림차순으로 정렬
  //4.최댓값이 나오게 0번째 * 1번째

  int[] parents;
  public int solution(int[] cards){
    int answer = 0;
    parents = cards;

    Map<Integer, Integer> counts = new HashMap<>();
    for (int i = 0; i < cards.length; i++) {
      parents[i]--;
    }

    boolean[] visited = new boolean[cards.length];
    for (int i = 0; i < cards.length; i++) {
      int num = 0;
      if(!visited[i]){
        num = find(i, visited);
      } else {
        num = parents[i];
      }

      counts.put(num, counts.getOrDefault(num, 0)+1);
    }

    if(counts.size() < 2){
      answer = 0;
    } else {
      List<Integer> values = new ArrayList<>();
      for(int v: counts.values()){
        values.add(v);
      }

      values.sort((o1,o2) -> o2-o1);
      answer = values.get(0) * values.get(1);
    }


    return answer;
  }

  public int find(int a, boolean[] visited){
    if(a==parents[a] || visited[a]){
      return a;
    }
    visited[a] = true;

    return parents[a] = find(parents[a], visited);
  }

  public static void main(String[] args) {
    PlayingAlone playingAlone = new PlayingAlone();
    int[] cards = {8,6,3,7,2,5,1,4};
    System.out.println(playingAlone.solution(cards));
  }

}
