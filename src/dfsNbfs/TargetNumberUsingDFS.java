package dfsNbfs;

public class TargetNumberUsingDFS {
  static int answer = 0;
  public static int solution(int[] numbers, int target){


    dfs(numbers, target, 0, 0);
    return answer;
  }

  public static void dfs(int[] numbers, int target, int idx, int sum){
    if(idx==numbers.length){
      if(sum == target){
        answer++;
      }
    } else{
      dfs(numbers, target, idx+1, sum + numbers[idx]);
      dfs(numbers, target, idx+1, sum - numbers[idx]);
    }

  }

  public static void main(String[] args) {
    int[] numbers = {1, 1, 1, 1, 1};
    int target = 3;

    System.out.println(solution(numbers, target));
  }

}
