package etc.practice;

import java.util.Arrays;

public class InterceptSystem {

  public int solution(int[][] targets){

    //2번째 요소(end)를 기준으로 오름차순 정렬렬
   Arrays.sort(targets, (o1, o2) -> {
      if(o1[1]==o2[1]){
        return o1[0]-o2[0];
      }
      return o1[1]-o2[1];
    });

   int cut = -1;
   int answer = 0;

    for (int i = 0; i < targets.length; i++) {
      int left = targets[i][0];
      int right = targets[i][1];
      if(left >= cut){
        answer++;
        cut = right;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    InterceptSystem system = new InterceptSystem();
    int[][] targets = {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};
    System.out.println(system.solution(targets));
  }

}
