package etc.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumBlock {
  //소수인 경우 1이 나오고
  //그 외에는 약수의 (본인을 제외한) 최댓값

  public int[] solution(long begin, long end){
    List<Integer> list = new ArrayList<>();
    for (long i = begin; i <= end; i++) {
      if(i==1){
        list.add(0);
        continue;
      }
      if(isPrime(i)){
        list.add(1);
      } else {
        list.add(findSecondMax(i));
      }
    }

    return list.stream().mapToInt(Integer::intValue).toArray();
  }

  //소수인가?
  private boolean isPrime(long num){
    for (int i = 2; i <= Math.sqrt(num); i++) {
      if(num%i==0){
        return false;
      }
    }
    return true;
  }

  //약수 중 본인을 제외한 최대값 찾기
  private int findSecondMax(long num){
    int i;
    for (i = 2; i <= Math.sqrt(num); i++) {
      if(num%i==0){
        break;
      }
    }
    return (int)num/i;
  }

  public static void main(String[] args) {
    NumBlock numBlock = new NumBlock();
    System.out.println(Arrays.toString(numBlock.solution(1, 10)));
  }
}
