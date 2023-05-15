package etc;

public class MagicalElevator {
  int[] cnt = {0,1,2,3,4,5,4,3,2,1};
  int answer = Integer.MAX_VALUE;

  public int solution(int current){
    helper(current, 0);
    return answer;
  }

  public void helper(int current, int value){
    if(current < 10){
      int p = current > 5 ? 1 : 0;
      answer = Math.min(cnt[current]+p+value, answer);
      return;
    }

    if(current % 10 <= 5){
      helper(current / 10, cnt[current % 10] + value);
    }
    if(current % 10 >= 5){
      helper(current / 10 + 1, cnt[current % 10] + value);
    }
  }

  public static void main(String[] args) {
    MagicalElevator magicalElevator = new MagicalElevator();
    //System.out.println(magicalElevator.solution(2554));
    System.out.println(magicalElevator.solution(16));
  }

}
