package etc.practice;

public class Country124 {

  public String solution(int n){
    String answer = "";
    String[] numbers = {"4","1","2"};

    int num = n;
    while(num > 0){
      int remainder = num % 3;    //numbers의 인덱스가 됨 -> 0이면 4가
      num /= 3;

      if(remainder == 0){
        num--;
      }
      answer = numbers[remainder] + answer;
    }

    return answer;
  }

  public static void main(String[] args) {
    Country124 country124 = new Country124();

    System.out.println(country124.solution(1));
    System.out.println(country124.solution(2));
    System.out.println(country124.solution(3));
    System.out.println(country124.solution(4));
    System.out.println(country124.solution(5));
    System.out.println(country124.solution(6));
    System.out.println(country124.solution(7));
    System.out.println(country124.solution(9));
    System.out.println(country124.solution(10));
  }

}
