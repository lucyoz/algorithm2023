package etc.practice;

import java.util.Arrays;

public class SumOfConsecutiveNumberSubSequence {

  public static int[] solution(int[] sequence, int k){
    int[] answer = new int[2];

    int left = 0, right = sequence.length;
    int sum = 0;

    for(int L=0,R=0;L<sequence.length;L++){
      while(R<sequence.length && sum < k){
        sum += sequence[R++];
      }

      if(sum==k){
        int range = R - L - 1;
        if((right - left) > range){
          left = L;
          right = R - 1;
        }
      }
      sum -= sequence[L];
    }
    answer[0] = left;
    answer[1] = right;

    return answer;
  }

  public static void main(String[] args) {
    int[] sequence = {1, 2, 3, 4, 5};
    int[] sequence2 = {1, 1, 1, 2, 3, 4, 5};
    int[] sequence3 = {2, 2, 2, 2, 2};
    System.out.println(Arrays.toString(solution(sequence, 7)));
    System.out.println(Arrays.toString(solution(sequence2, 5)));

    System.out.println(Arrays.toString(solution(sequence3, 6)));

  }

}
