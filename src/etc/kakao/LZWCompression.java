package etc.kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LZWCompression {

  public int[] solution(String msg){

    List<Integer> answer = new ArrayList<>();
    String[] dictionary = new String[26+msg.length()];
    List<String> dicList = new ArrayList<>();

    for (int i = 0; i < 26; i++) {
      String str = Character.toString('A'+i);
      dictionary[i+1] = str;
      dicList.add(str);
    }


    for (int i = 0; i < msg.length(); i++) {
      StringBuilder w = new StringBuilder(String.valueOf(msg.charAt(i)));

      if(i==msg.length()-1){
        answer.add(dicList.indexOf(w.toString()));
        break;
      }

      String c = String.valueOf(msg.charAt(i+1));

      //사전에 w+c가 있을 때 w와 c 갱신
      while(dicList.contains(w+c)){
        w.append(c);
        i++;

        if(i==msg.length()-1 || c.equals("")){
          c = "";
          break;
        }

        c = String.valueOf(msg.charAt(i+1));
      }

      if(!dicList.contains(w+c)){
        dicList.add(w+c);
      }
      if(dicList.indexOf(w.toString())!=-1){
        answer.add(dicList.indexOf(w.toString()));
      }
      if (i == msg.length() - 1 && !c.equals("")) {
        answer.add(dicList.indexOf(c));
      }

    }



    return answer.stream().mapToInt(i->i+1).toArray();
  }


  public static void main(String[] args) {
    LZWCompression zip = new LZWCompression();

    System.out.println(Arrays.toString(zip.solution("KAKAO")));
    System.out.println(Arrays.toString(zip.solution("TOBEORNOTTOBEORTOBEORNOT")));
    System.out.println(Arrays.toString(zip.solution("ABABABABABABABAB")));
  }

}
