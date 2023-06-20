package etc.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumBlock {
  //소수인 경우 1이 나오고
  //그 외에는 약수의 (본인을 제외한) 최댓값
  //end의 최댓값과(>) 숫자블록의 최댓값이 다름! 주의

  public int[] solution(long begin, long end){
    List<Integer> list = new ArrayList<>();
    for (long i = begin; i <= end; i++) {
      if(i==1){
        list.add(0);
        continue;
      }
      list.add(findSecondMax(i));

    }

    return list.stream().mapToInt(Integer::intValue).toArray();
  }

  //약수 중 본인을 제외한 최대값 찾기
  private int findSecondMax(long num){
    List<Integer> list = new ArrayList<>();
    int i;
    for (i = 2; i <= Math.sqrt(num); i++) {
      if(num%i==0){
        list.add(i);
        if(num/i <= 10_000_000){
          return (int)num/i;
        }
      }
    }
    if(list.size()>0){
      return list.get(list.size()-1);
    }
    return 1;
  }

  public static void main(String[] args) {
    NumBlock numBlock = new NumBlock();
    System.out.println(Arrays.toString(numBlock.solution(1, 10)));
  }
}
