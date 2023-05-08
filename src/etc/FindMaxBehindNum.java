package etc;

import java.util.Arrays;
import java.util.Stack;

public class FindMaxBehindNum {

  public int[] solution(int[] numbers){
    int[] answer = new int[numbers.length];
    Stack<Integer> stack = new Stack<>();

    for (int i = numbers.length-1; i >= 0; i--) {
      while(!stack.isEmpty()){
        if(stack.peek() > numbers[i]){
          answer[i] = stack.peek();
          break;
        }
        stack.pop();
      }
      if(stack.isEmpty()){
        answer[i] = -1;
      }
      stack.add(numbers[i]);
    }


    return answer;
  }

  public static void main(String[] args) {

    FindMaxBehindNum findMaxBehindNum = new FindMaxBehindNum();
    int[] numbers = {2, 3, 3, 5};
    System.out.println(Arrays.toString(findMaxBehindNum.solution(numbers)));

    int[] numbers2 = {9, 1, 5, 3, 6, 2};
    System.out.println(Arrays.toString(findMaxBehindNum.solution(numbers2)));

  }

}
