package etc;

public class JumpNTeleport {

  public int solution(int n){

    return Integer.bitCount(n);
  }

  public int solution2(int n){
    int answer = 1;

    while(n!=1){
      if(n%2==1){
        n--;
        answer++;
      } else {
        n /= 2;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    JumpNTeleport jump = new JumpNTeleport();

    System.out.println(jump.solution(5));
    System.out.println(jump.solution(6));
    System.out.println(jump.solution(5000));

    System.out.println();
    System.out.println(jump.solution2(5));
    System.out.println(jump.solution2(6));
    System.out.println(jump.solution2(5000));

  }

}
