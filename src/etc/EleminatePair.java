package etc;

import java.util.Stack;

public class EleminatePair {
  //stack 이용

  public int solution(String s){
    char[] arr = s.toCharArray();
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < arr.length; i++) {
      char c = arr[i];
      if(stack.isEmpty()){
        stack.push(c);
      } else {
        if(stack.peek()==c){
          stack.pop();
        } else {
          stack.push(c);
        }
      }
    }

    return stack.isEmpty()? 1:0;
  }

  public static void main(String[] args) {

    EleminatePair pair = new EleminatePair();
    System.out.println(pair.solution("baabaa"));
    System.out.println(pair.solution("cdcd"));

  }

}
