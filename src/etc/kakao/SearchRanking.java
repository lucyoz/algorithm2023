package etc.kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SearchRanking {
  //조건따라 순차적으로 하나씩 비교하게 되면 -> 시간초과
  //HashMap 이용
  //1.info가 포함될 수 있는 모든 경우의 수를 map에 key로 넣고 점수를 value로
  //2.query를 key로 하는 value를 가지고와 이분탐색

  static HashMap<String, List<Integer>> map;

  public int[] solution(String[] info, String[] query){
    int[] answer = new int[query.length];

    map = new HashMap<>();
    for (int i = 0; i < info.length; i++) {
      String[] p = info[i].split(" ");
      makeSentence(p, "", 0);
    }

    //오름차순 정렬
    for(String key: map.keySet()){
      Collections.sort(map.get(key));
    }

    for (int i = 0; i < query.length; i++) {
      query[i] = query[i].replaceAll(" and ","");
      String[] q = query[i].split(" ");     //q[0]은 언어,직군,경력,소울푸드 q[1]은 점수(String)
      answer[i] = map.containsKey(q[0]) ? binarySearch(q[0], Integer.parseInt(q[1])):0;
    }

    return answer;
  }

  //이분탐색
  private int binarySearch(String key, int score){
    List<Integer> list = map.get(key);
    int start = 0, end = list.size()-1;

    while(start<=end){
      int mid = (start + end) / 2;
      if(list.get(mid) < score){
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return list.size() - start;
  }

  //info가 포함될 수 있는 문항 ex. --, java-, javabackend 등
  private void makeSentence(String[] p, String str, int cnt){
    if(cnt==4){
      if(!map.containsKey(str)){
        List<Integer> list = new ArrayList<>();
        map.put(str, list);
      }
      map.get(str).add(Integer.parseInt(p[4]));
      return;
    }
    makeSentence(p, str+"-",cnt+1);
    makeSentence(p, str+p[cnt], cnt+1);
  }

  public static void main(String[] args) {
    SearchRanking searchRanking = new SearchRanking();
    String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
    String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

    System.out.println(Arrays.toString(searchRanking.solution(info, query)));
  }

}
