package etc.kakao;

import java.util.ArrayList;

public class NewsClustering {

  public int solution(String str1, String str2){
    int answer = 0;

    if(str1.length()==0 && str2.length()==0){
      return 65536;
    }

    str1 = str1.toLowerCase();
    str2 = str2.toLowerCase();

    String[] str1Arr = new String[str1.length()-1];
    String[] str2Arr = new String[str2.length()-1];

    ArrayList<String> str1List = new ArrayList<>();
    ArrayList<String> str2List = new ArrayList<>();

    for (int i = 0; i < str1.length()-1; i++) {
      str1Arr[i] = str1.substring(i, i+2);
      str1List.add(str1.substring(i, i+2));
    }

    for (int i = 0; i < str2.length()-1; i++) {
      str2Arr[i] = str2.substring(i, i+2);
      str2List.add(str2.substring(i, i+2));
    }

    int unionSize = getUnion(str1List, str2List).size();
    int interSize = getIntersection(str1List, str2List).size();

    System.out.println(unionSize);
    System.out.println(interSize);
    answer = (int) ((double) interSize / (double) unionSize * (double) 65536);

    return answer;
  }

  public ArrayList<String> getUnion(ArrayList<String> str1, ArrayList<String> str2){
    str1 = (ArrayList<String>) str1.clone();
    str2 = (ArrayList<String>) str2.clone();

    ArrayList<String> union = new ArrayList<>();
    for(String str: str1){
      if(str2.contains(str)){
        str2.remove(str2.indexOf(str));
      }
      union.add(str);
    }

    union.addAll(str2);
    return union;
  }

  public ArrayList<String> getIntersection(ArrayList<String> str1, ArrayList<String> str2){
    str1 = (ArrayList<String>) str1.clone();
    str2= (ArrayList<String>) str2.clone();

    ArrayList<String> intersection = new ArrayList<>();
    for(String str: str1){
      if(str2.contains(str)){
        intersection.add(str);
        str2.remove(str);
      }
    }
    return intersection;
  }

  public static void main(String[] args) {

    NewsClustering clustering = new NewsClustering();

    System.out.println(clustering.solution("FRANCE","french"));
    System.out.println(clustering.solution("handshake","shake hands"));
    System.out.println(clustering.solution("aa1+aa2","AAAA12"));
    System.out.println(clustering.solution("E=M*C^2","e=m*c^2"));
  }

}
