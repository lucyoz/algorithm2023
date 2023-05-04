package etc.kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ParkingFee4 {

  public static int[] solution(int[] fees, String[] records){
    int[] answer = {};
    int INF = 23 * 60 + 59;
    Map<Integer, Integer> startTime = new HashMap<>();
    Map<Integer, Integer> totalTime = new HashMap<>();
    Set<Integer> carSet = new HashSet<>();

    for(String s: records){
      String[] str = s.split(" ");

      String[] times = str[0].split(":");
      int min = (Integer.parseInt(times[0]) * 60) + Integer.parseInt(times[1]);
      int num = Integer.parseInt(str[1]);   //차 번호
      if(!startTime.containsKey(num)){
        carSet.add(num);
        startTime.put(num, min);
        if(!totalTime.containsKey(num)){
          totalTime.put(num, 0);
        }
      } else {
        totalTime.put(num, totalTime.get(num) + min - startTime.get(num));
        startTime.remove(num);
      }
    }

    for(Integer key: startTime.keySet()){
      totalTime.put(key, totalTime.get(key) + INF - startTime.get(key));
    }

    List<Integer> list = new ArrayList<>(carSet);
    Collections.sort(list);
    answer = new int[carSet.size()];
    int idx = 0;
    for(int num: list){
      int time = totalTime.get(num);
      if(time <= fees[0]){
        answer[idx] = fees[1];
      } else {
        answer[idx] = (int)(fees[1] + Math.ceil((double)(time - fees[0]) / fees[2]) * fees[3]);
      }
      idx++;
    }
    return answer;

  }

  public static void main(String[] args) {

    int[] fees = {180,5000,10,600};
    String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

    int[] fees2 = {120,0,60,591};
    String[] records2 = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};

    int[] fees3 = {1,461,1,10};
    String[] records3 = {"00:00 1234 IN"};


    System.out.println(Arrays.toString(solution(fees, records)));
    System.out.println(Arrays.toString(solution(fees2, records2)));
    System.out.println(Arrays.toString(solution(fees3, records3)));
  }

}
