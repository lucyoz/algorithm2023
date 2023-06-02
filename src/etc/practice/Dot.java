package etc.practice;

public class Dot {

  public long solution(int k, int d){
    long answer = 0;

    for (int i = 0; i <= d/k; i++) {
      int a = i * k;
      int b = 0;
      for (int j = 0; j <= d/k; j++) {
        b = j * k;
        if(Math.pow(a,2) + Math.pow(b,2) <= Math.pow(d,2)){
          answer++;
        } else {
          break;
        }
      }
    }


    return answer;
  }

  public static void main(String[] args) {
    Dot dot = new Dot();

    System.out.println(dot.solution(2,4));
    System.out.println(dot.solution(1,5));
  }

}
