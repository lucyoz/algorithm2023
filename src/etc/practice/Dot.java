package etc.practice;

public class Dot {

  public long solution(int k, int d){
    long answer = 0;

    for (int i = 0; i <= d; i += k) {
      long aa = (long) i * i;
      long dd = (long) d * d;
      int b = (int) Math.sqrt(dd - aa);
      answer += (b / k) + 1;
    }


    return answer;
  }

  public static void main(String[] args) {
    Dot dot = new Dot();

    System.out.println(dot.solution(2,4));
    System.out.println(dot.solution(1,5));
  }

}
