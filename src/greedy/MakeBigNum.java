package greedy;

public class MakeBigNum {

  public String solution(String number, int k){
    StringBuilder sb = new StringBuilder();
    int index = 0;
    int max = 0;
    for (int i=0; i<number.length() - k; i++) {
      max = 0;
      for (int j = index; j <= k+i; j++) {
        if(max < number.charAt(j)-'0'){
          max = number.charAt(j)-'0';
          index = j + 1;
        }
      }
      sb.append(max);
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    MakeBigNum makeBigNum = new MakeBigNum();
    System.out.println(makeBigNum.solution("1924",2));
    System.out.println(makeBigNum.solution("1231234",3));
    System.out.println(makeBigNum.solution("4177252841",4));

  }

}
