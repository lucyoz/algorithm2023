package etc.kakao;

import java.util.Stack;

public class MakeNewBracketString {
  //목적: 균형잡힌 -> 올바른 괄호 문자열로 변환
  //0.이미 올바른 괄호 문자열인가? -> 맞으면 p 그대로 반환
  //아닐 시에
  //1.u와 v 분리
  //2.올바른 괄호 문자열?
    //문자열 v에 대해 1단계부터 다시 수행합니다.
  //3.아니면
    //빈 문자열에 첫 번째 문자로 '('를 붙입니다.
    //문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
    //')'를 다시 붙입니다.
    //u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
    //생성된 문자열을 반환합니다.


  public String solution(String p){
    String answer = go(p);

    return answer;
  }

  public String go(String p){
    if(p.equals("")){
      return "";
    }
    //올바른 괄호인가?
    if(isProper(p)){
      return p;
    }

    //아닐 시, u와 v 분리
    StringBuilder sb = new StringBuilder();
    String[] tmp = separate(p);
    String u = tmp[0];
    String v = tmp[1];

    if(isProper(u)){
      sb.append(u).append(go(v));
    } else {
      sb.append('(').append(go(v)).append(')').append(reverseBracket(u));
    }

    return sb.toString();
  }

  public String reverseBracket(String u){
    u = u.substring(1);
    u = u.substring(0,u.length()-1);

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < u.length(); i++) {
      if(u.charAt(i)=='('){
        sb.append(')');
      } else {
        sb.append('(');
      }
    }
    return sb.toString();
  }

  public String[] separate(String p){
    int openBracket = 0;
    int closedBracket = 0;

    int i = 0;
    for (i = 0; i < p.length(); i++) {
      if(p.charAt(i)=='('){
        openBracket += 1;
      } else {
        closedBracket += 1;
      }
      if(openBracket == closedBracket){
        String u = p.substring(0, i+1);
        String v = "";
        if(p.length() >= i+1){
          v = p.substring(i+1);
        }
        return new String[] {u,v};
      }
    }
    return new String[] {"",""};

  }

  public boolean isProper(String p){
    Stack<Character> stack = new Stack<>();
    boolean result = false;
    int count = 0;

    for (int i = 0; i < p.length(); i++) {
      if(p.charAt(i)=='('){
        count++;
        stack.push('(');
      } else {
        if(stack.isEmpty()){
          break;
        } else {
          count++;
          stack.pop();
        }
      }
    }

    if(count==p.length()){
      System.out.println("올바른 괄호임");
      result = true;
    }

    return result;
  }

  public static void main(String[] args) {
    MakeNewBracketString makeNewBracketString = new MakeNewBracketString();
    System.out.println(makeNewBracketString.solution("(()())()"));
    System.out.println();
    System.out.println(makeNewBracketString.solution(")("));
    System.out.println();
    System.out.println(makeNewBracketString.solution("()))((()"));
  }

}
