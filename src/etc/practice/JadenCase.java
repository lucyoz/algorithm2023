package etc.practice;

import java.util.StringTokenizer;

public class JadenCase {

  public String solution(String s){
    StringTokenizer st = new StringTokenizer(s, " ", true);
    StringBuilder sb = new StringBuilder();

    while(st.hasMoreTokens()){
      String str = st.nextToken();
      if(str.startsWith(" ")){
        sb.append(str);
        continue;
      }
      if(isStartWithNumber(str)){
        sb.append(str.charAt(0));
      } else if (isStartWithLowerAlpha(str)){
        sb.append((char)(str.charAt(0) - 32));
      } else {
        sb.append(str.charAt(0));
      }
      sb.append(str.substring(1).toLowerCase());
    }
    return sb.toString();
  }

  public boolean isStartWithLowerAlpha(String str){
    return str.charAt(0) >= 'a' && str.charAt(0) <= 'z';
  }

  public boolean isStartWithNumber(String str){
    return str.charAt(0) >= '0' && str.charAt(0) <= '9';
  }

  public static void main(String[] args) {
    JadenCase jadenCase = new JadenCase();
    String s1 = "3people unFollowed me";
    String s2 = "for the last week";

    System.out.println(jadenCase.solution(s1));
    System.out.println(jadenCase.solution(s2));
  }

}
