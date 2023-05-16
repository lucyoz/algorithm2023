package bruteForce;


import java.util.HashSet;
import java.util.Set;

public class FindPrimeNumber {
  Set<Integer> set = new HashSet<>();

  public void makeNumber(char[] number, boolean[] used, String s){
    for (int i = 0; i < number.length; i++) {
      if(!used[i]){
        s += String.valueOf(number[i]);
        used[i] = true;
        makeNumber(number, used, s);
        s = s.substring(0, s.length()-1);
        used[i] = false;
      } else {
        set.add(Integer.parseInt(s));
      }
    }
  }

  public boolean isPrime(int num){
    if(num <= 1){
      return false;
    }
    for (int i = 2; i < num; i++) {
      if(num%i==0){
        return false;
      }

    }
    return true;
  }

  public int solution(String numbers){
    int answer = 0;

    char[] number = numbers.toCharArray();
    boolean[] used = new boolean[numbers.length()];
    makeNumber(number, used, "");

    System.out.println(set);
    for(Integer num: set){
      if(isPrime(num)){
        answer++;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    FindPrimeNumber findPrimeNumber = new FindPrimeNumber();
    //System.out.println(findPrimeNumber.solution("17"));
    System.out.println(findPrimeNumber.solution("011"));
  }

}
