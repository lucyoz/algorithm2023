package etc;

import java.util.Arrays;

public class OtherBit {
// 규칙 참고: https://ilmiodiario.tistory.com/108

  public long[] solution(long[] numbers){
    long[] answer = new long[numbers.length];

    for (int i = 0; i < numbers.length; i++) {
      if(numbers[i]%2==0){
        answer[i] = numbers[i] + 1;
      } else {
        String s = Long.toString(numbers[i],2);
        int zeroIdx = s.lastIndexOf("0");
        if(zeroIdx != -1){
          s = s.substring(0, zeroIdx) + "10" + s.substring(zeroIdx+2, s.length());
        } else {
          s = "10" + s.substring(1, s.length());
        }
        answer[i] = Long.parseLong(s,2);
      }
    }


    return answer;
  }

  public static void main(String[] args) {
    OtherBit bit = new OtherBit();
    long[] numbers = {2,7};
    System.out.println(Arrays.toString(bit.solution(numbers)));
  }

}
