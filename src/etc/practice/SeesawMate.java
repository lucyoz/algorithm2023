package etc.practice;

import java.util.Arrays;

public class SeesawMate {
  //1.weights 정령(오름차순)
  //2.2중 for문 돌기 -> j의 최대 범위 이분탐색으로 (시간초과 해결을 위하여, 값이 2배이상이 일 때가 j의 최대범위임)
  //3.문제의 조건과 맞으면 카운트+1 <- 정렬을 했기 때문에 무조건 weights[i]<=weights[j]
  //4.>중복처리!< : 위 문제의 조건에 맞을 때 (둘이 같은 값일 때 중복으로 count되는 것 방지)

  public long solution(int[] weights){
    long answer = 0;

    Arrays.sort(weights);

    int prev = 0;
    for (int i = 0; i < weights.length-1; i++) {
      if(i>0 && weights[i]==weights[i-1]){
        prev--;
        answer += prev;
        continue;
      }
      int j = find(weights, weights[i], i+1);
      prev = 0;
      for (;j>i;j--) {
        if(weights[i]==weights[j] || weights[i]*2==weights[j] || weights[i]*3==weights[j]*2 || weights[i]*4==weights[j]*3){
          prev++;
        }
      }
      answer += prev;
    }
    return answer;
  }

  private int find(int[] weights, int num, int i){
    int left = i;
    int right = weights.length - 1;

    while(left < right){
      int mid = left + (right - left)/2;
      if(weights[mid] > num*2){
        return mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  public static void main(String[] args) {
    SeesawMate seesawMate = new SeesawMate();
    int[] weights = {100,180,360,100,270};
    System.out.println(seesawMate.solution(weights));
  }

}
