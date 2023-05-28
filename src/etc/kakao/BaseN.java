package etc.kakao;

public class BaseN {

  public String solution(int n, int t, int m, int p){
    String answer = "";

    int num = 0;
    int turn = 0;
    while(answer.length()<t){
      String strNum = Integer.toString(num, n);
      num++;
      for(char c: strNum.toCharArray()){
        turn++;
        if(turn==p){
          answer += c;
          if(answer.length()==t){
            break;
          }
        }
        if(turn == m){
          turn = 0;
        }
      }

    }


    return answer.toUpperCase();
  }

  public static void main(String[] args) {
    BaseN baseN = new BaseN();

    System.out.println(baseN.solution(2,4,2,1));
    System.out.println(baseN.solution(16,16,2,1));
    System.out.println(baseN.solution(16,16,2,2));
  }

}
