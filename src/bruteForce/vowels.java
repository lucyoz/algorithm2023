package bruteForce;

public class vowels {

  //마지막 자리 수는 바뀌려면 1씩 증가
  //4번째 자리 수는 1*5+1=6씩 증가
  //3번째 자리 수는 6*5+1 = 31씩 증가
  //2번째 자리 수는 31*5+1 = 156씩 증가
  //1번째 자리 수는 156*5+1 = 781씩 증가
  static final String MAPPING = "AEIOU";
  static final int[] RATE_OF_INCREASE = {781, 156, 31, 6, 1};


  public static int solution(String word){
    int answer = word.length();

    for (int i = 0; i < word.length(); i++) {
      answer += (RATE_OF_INCREASE[i] * MAPPING.indexOf(word.charAt(i)));
    }

    return answer;
  }
  public static void main(String[] args) {

    System.out.println(solution("AAAAE"));
    System.out.println(solution("AAAE"));
    System.out.println(solution("I"));
    System.out.println(solution("EIO"));

  }

}
