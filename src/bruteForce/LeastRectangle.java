package bruteForce;

public class LeastRectangle {

  public int find(int[][] sizes){
    int max = 0;
    for (int i = 0; i < sizes.length; i++) {
      for (int j = 0; j < sizes[0].length; j++) {
        max = Math.max(max, sizes[i][j]);
      }
    }
    return max;
  }

  public int solution(int[][] sizes){
    int answer = 0;
    int firstMax=0, secondMax=0;

    for (int i = 0; i < sizes.length; i++) {
      for (int j = 0; j < sizes[0].length; j++) {
        firstMax = Math.max(firstMax, sizes[i][j]);
      }
      if(sizes[i][0]>sizes[i][1]){
        sizes[i][0] = 0;
      } else {
        sizes[i][1] = 0;
      }
    }

    secondMax = find(sizes);
    answer = firstMax * secondMax;

    return answer;
  }

  public static void main(String[] args) {

    LeastRectangle leastRectangle = new LeastRectangle();
    int[][] sizes1 = {{60,50},{30,70},{60,30},{80,40}};
    int[][] sizes2 = {{10,7},{12,3},{8,15},{14,7},{5,15}};
    int[][] sizes3 = {{14,4},{19,6},{6,16},{18,7},{7,11}};

    System.out.println(leastRectangle.solution(sizes1));
    System.out.println(leastRectangle.solution(sizes2));
    System.out.println(leastRectangle.solution(sizes3));

  }

}
