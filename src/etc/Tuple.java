package etc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Tuple {

  public int[] solution(String s){
    String[] nums = s.replaceAll("\\{", " ").replaceAll("}"," ").trim().split(" , ");
    Arrays.sort(nums, (a, b) ->{        //
      return a.length()-b.length();
    });

    Set<Integer> set = new HashSet<>();
    int[] answer = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      String[] num = nums[i].split(",");
      for(String str: num){
        int n = Integer.valueOf(str);
        if(!set.contains(n)){
          set.add(n);
          answer[i] = n;
          break;
        }
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    Tuple tuple = new Tuple();
    System.out.println(Arrays.toString(tuple.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
    System.out.println(Arrays.toString(tuple.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
    System.out.println(Arrays.toString(tuple.solution("{{20,111},{111}}")));
    System.out.println(Arrays.toString(tuple.solution("{{123}}")));
    System.out.println(Arrays.toString(tuple.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")));
  }


}
