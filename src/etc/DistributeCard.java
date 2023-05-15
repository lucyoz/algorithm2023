package etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DistributeCard {
  List<Integer> divisors;

  public void findDivisors(int num){
    divisors = new ArrayList<>();

    for (int i = 2; i*i <= num; i++) {
      if(num%i==0){
        divisors.add(i);
        divisors.add(num / i);
      }
    }
    divisors.add(num);
  }

  public boolean canDivideAllElement(int divisor, int[] arr){
    for(int num: arr){
      if(num%divisor != 0){
        return false;
      }
    }
    return true;
  }

  public boolean cantDivideAllElement(int divisor, int[] arr){
    for(int num: arr){
      if(num%divisor == 0){
        return false;
      }
    }
    return true;
  }

  public int findNum(int[] divArr, int[] nonDivArr){
    Arrays.sort(divArr);
    findDivisors(divArr[0]);

    Collections.sort(divisors, Collections.reverseOrder());

    for(int divisor: divisors){
      if(canDivideAllElement(divisor, divArr) && cantDivideAllElement(divisor, nonDivArr)){
        return divisor;
      }
    }
    return 0;
  }

  public int solution(int[] arrayA, int[] arrayB){
    //array 정렬, 가장 작은 수 찾기
    //그 수의 약수 찾기
    //모든 수들을 나눌수 있는가? -> 조건에 맞는 수는 구한 약수들에 포함되어 있어야한다
    int answer = 0;
    int num;

    num = findNum(arrayA, arrayB);
    answer = (num > answer) ? num: answer;

    num = findNum(arrayB, arrayA);
    answer = (num > answer) ? num: answer;

    return answer;
  }

  public static void main(String[] args) {
    int[] arrayA = {14,35,119};
    int[] arrayB = {18,30, 102};

    DistributeCard distributeCard = new DistributeCard();

    System.out.println(distributeCard.solution(arrayA,arrayB));
  }

}
