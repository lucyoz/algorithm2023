package etc;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Stream;

public class RotateBracket {

  public boolean check(String[] s){
    Stack<String> stack = new Stack<>();

    for (int i = 0; i < s.length; i++) {
      if(s[i].equals("{") || s[i].equals("(") || s[i].equals("[")){
        stack.push(s[i]);
      } else {
        if(stack.isEmpty()){
          return false;
        }
        if((stack.peek().equals("{") && s[i].equals("}")) || (stack.peek().equals("[") && s[i].equals("]")) || (stack.peek().equals("(") && s[i].equals(")")) ){
          stack.pop();
        } else {
          return false;
        }
      }
    }

    if(stack.isEmpty()){
      return true;
    }
    return false;
  }

  public int solution(String s){
    int answer = 0;

    if(s.length()%2==1){
      return 0;
    }
    String[] str = new String[s.length()];
    for (int i = 0; i < s.length(); i++) {
      str = s.split("");
    }

    if(check(str)){
      answer++;
    }
    for (int i = 1; i < s.length(); i++) {
      String[] newStr1 = Arrays.copyOfRange(str, i, str.length);
      String[] newStr2 = Arrays.copyOf(str, i);

      String[] newArray = Stream.concat(Arrays.stream(newStr1),
          Arrays.stream(newStr2))
          .toArray(String[]::new);
      if(check(newArray)){
        answer++;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    RotateBracket rotateBracket = new RotateBracket();

    System.out.println(rotateBracket.solution("[](){}"));
    System.out.println(rotateBracket.solution("}]()[{"));
    System.out.println(rotateBracket.solution("[)(]"));
    System.out.println(rotateBracket.solution("}}}"));
  }

}
