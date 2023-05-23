package etc.kakao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OpenKakaoTalk {

  public String[] solution(String[] record){

    Map<String, String> user = new HashMap<>();
    int count = 0;

    for (int i = 0; i < record.length; i++) {
      String[] rec = record[i].split(" ");

      if(rec[0].equals("Leave")){
        continue;
      } else if (rec[0].equals("Change")){
        count++;
      }
      user.put(rec[1],rec[2]);
    }


    String[] answer = new String[record.length-count];
    int idx = 0;

    for (int i = 0; i < record.length; i++) {
      if(record[i].charAt(0)=='E'){
        answer[idx++] = user.get(record[i].split(" ")[1])+"님이 들어왔습니다.";
      } else if (record[i].charAt(0)=='L'){
        answer[idx++] = user.get(record[i].split(" ")[1])+"님이 나갔습니다.";
      }
    }



    return answer;
  }

  public static void main(String[] args) {
    OpenKakaoTalk openKakaoTalk = new OpenKakaoTalk();
    String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

    System.out.println(Arrays.toString(openKakaoTalk.solution(record)));

  }

}
