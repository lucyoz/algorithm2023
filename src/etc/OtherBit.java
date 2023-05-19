package etc;

import java.util.Arrays;

public class OtherBit {
  public long compare(String original, String num){
    long answer = 0;

    String original2 = "";
    if(original.charAt(0)=='1'){
        original2 = "0"+original;
    }
    original = original2;

    for (int i = 0; i < num.length(); i++) {
      if(original.charAt(i)!=num.charAt(i)){
        answer++;
      }
    }

    return answer;
  }

  public long f(long number){

    long minus = 100;
    long num = number;
    String original2Str = Long.toString(number, 2);
    System.out.println(original2Str);
    while(minus >=3){
      num += 1;

      String num2Str = Long.toString(num, 2);
      System.out.println(num+", "+num2Str);

      minus = compare(original2Str, num2Str);

    }

    return num;

  }

  public long[] solution(long[] numbers){
    long[] answer = new long[numbers.length];

    for (int i = 0; i < numbers.length; i++) {
      answer[i] = f(numbers[i]);
    }


    return answer;
  }

  public static void main(String[] args) {
    OtherBit bit = new OtherBit();
    long[] numbers = {2,7};
    System.out.println(Arrays.toString(bit.solution(numbers)));
  }

}
