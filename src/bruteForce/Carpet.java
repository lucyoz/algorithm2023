package bruteForce;

import java.util.Arrays;

public class Carpet {
  public int[] findCarpet(int yellow, int sum){
    int y = 0, x = 0;

    for (int i = 1; i <= yellow; i++) {
      if(yellow%i==0){
        y = Math.min(i, yellow/i);
        x = Math.max(i, yellow/i);
        if((y+2)*(x+2)==sum){
          break;
        }
      }
    }
    return new int[]{x+2, y+2};
  }

  public int[] solution(int brown, int yellow){
    int sum = brown + yellow;
    return findCarpet(yellow, sum);
  }

  public static void main(String[] args) {
    Carpet carpet = new Carpet();
    System.out.println(Arrays.toString(carpet.solution(10,2)));
    System.out.println(Arrays.toString(carpet.solution(8,1)));
    System.out.println(Arrays.toString(carpet.solution(24,24)));

  }

}
