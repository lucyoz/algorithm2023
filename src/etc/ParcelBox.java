package etc;

import java.util.Stack;

public class ParcelBox {

  public int solution(int[] order){
    int answer = 0;

    int[] container = new int[order.length];
    for (int i = 0; i < container.length; i++) {
      container[i] = i+1;
    }

    int oIdx = 0;
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < order.length; i++) {
      if(order[oIdx]==container[i]){
        answer++;
        oIdx++;
        continue;
      }
      while(!stack.isEmpty() && stack.peek()==order[oIdx]){
        stack.pop();
        answer++;
        oIdx++;
        continue;
      }
      stack.push(container[i]);

    }


    while(!stack.isEmpty()){
      if(stack.peek()==order[oIdx]){
        answer++;
        oIdx++;
        stack.pop();
      } else {
        break;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    ParcelBox parcelBox = new ParcelBox();
    int[] order1 = {4, 3, 1, 2, 5};
    System.out.println(parcelBox.solution(order1));


    int[] order2 = {5, 4, 3, 2, 1};
    System.out.println(parcelBox.solution(order2));
  }

}
