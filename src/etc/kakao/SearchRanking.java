package etc.kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchRanking {
  //조건따라 순차적으로
  //info 새 배열의 0,1,2,3,4번째에 각각 언어,직군,경력,소울푸드,점수 넣기
  //query도 마찬가지
  //for문 돌려 각 비교하기 -> 시간초과

  String[][] applicant;
  List<String> list;

  public int[] solution(String[] info, String[] query){
    int[] answer = new int[query.length];

    applicant = new String[info.length][5];
    for (int i = 0; i < info.length; i++) {
      applicant[i] = info[i].split(" ");
      System.out.println(Arrays.toString(applicant[i]));
    }

    for (int i = 0; i < query.length; i++) {
      int count = search(query[i]);
      answer[i] = count;
    }

    return answer;
  }

  private int search(String query){
    int result = 0;
    String[] strQ = query.split(" ");
    list = new ArrayList<>();
    for (int i = 0; i < strQ.length; i++) {
      if(strQ[i].equals("and")){
        continue;
      }
      list.add(strQ[i]);
    }

    for (int i = 0; i < applicant.length; i++) {
      int count = 0;
      if(Integer.parseInt(list.get(4))>Integer.parseInt(applicant[i][4])){
        continue;
      }
      for (int j = 0; j < list.size()-1; j++) {
        if(list.get(j).charAt(0)==applicant[i][j].charAt(0) || list.get(j).equals("-")){
          count++;
        } else {
          break;
        }
      }
      //모든 조건 충족
      if(count==4){
        result++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    SearchRanking searchRanking = new SearchRanking();
    String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
    String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

    System.out.println(Arrays.toString(searchRanking.solution(info, query)));
  }

}
