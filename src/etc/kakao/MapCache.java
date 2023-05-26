package etc.kakao;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapCache {

  public int solution(int cacheSize, String[] cities){
    int answer = 0;
    if(cacheSize==0){
      return cities.length * 5;
    }

    //도시 이름과 순서(i) 넣기
    Map<String, Integer> cityInCache = new HashMap<>();

    Comparator<Entry<String, Integer>> comparator = new Comparator<Entry<String, Integer>>() {
      @Override
      public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
        return o1.getValue().compareTo(o2.getValue());
      }
    };

    for (int i = 0; i < cities.length; i++) {
      cities[i] = cities[i].toUpperCase();
      if(cityInCache.size()<cacheSize){
        cityInCache.put(cities[i], i);
        answer += 5;
        continue;
      }

      if(cityInCache.containsKey(cities[i])){
        cityInCache.replace(cities[i],i);
        answer += 1;
      } else {
//        Integer minValue = Collections.min(cityInCache.values());
//        cityInCache.remove(minValue);

        Entry<String, Integer> minEntry = Collections.min(cityInCache.entrySet(), comparator);
        cityInCache.remove(minEntry.getKey());
        cityInCache.put(cities[i], i);
        answer += 5;
      }
      if(cityInCache.size()!=cacheSize){
        return -1;
      }

    }




    return answer;
  }

  public static void main(String[] args) {
    MapCache mapCache = new MapCache();

    String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
    String[] cities2 = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
    String[] cities3 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
    String[] cities4 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
    String[] cities5 = {"Jeju", "Pangyo", "NewYork", "newyork"};
    String[] cities6 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

    System.out.println(mapCache.solution(3, cities));
    System.out.println(mapCache.solution(3, cities2));
    System.out.println(mapCache.solution(2, cities3));
    System.out.println(mapCache.solution(5, cities4));
    System.out.println(mapCache.solution(2, cities5));
    System.out.println(mapCache.solution(0, cities6));

  }

}
