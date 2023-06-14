package etc.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollatzConjecture {
  //1.k를 이용하여 콜라츠 추측(우박수열) 구하기
  //2.각 구간별 area 구하기 ex. 0~1 0~6
  //3.파라미터 ranges가 요구하는 구간별 넓이 반환

  List<Double> seq = new ArrayList<>();
  List<Double> area = new ArrayList<>();

  public double[] solution(int k, int[][] ranges){
    double[] answer = new double[ranges.length];

    collatz(k);

    area.add((double)0);
    for (int i = 0; i < seq.size()-1; i++) {
      double max = Math.max(seq.get(i+1), seq.get(i));
      double result = max - ((double)(Math.abs(seq.get(i+1)-seq.get(i)))/2);
      area.add(result);
    }

    for (int i = 1; i < area.size(); i++) {
      area.set(i, area.get(i-1)+area.get(i));
    }

    for (int i = 0; i < ranges.length; i++) {
      int start = ranges[i][0];
      int end = seq.size() - 1 + ranges[i][1];

      if(end > start){
        answer[i] = Double.parseDouble(String.format("%.1f",area.get(end)-area.get(start)));
      } else if (start > end){
        answer[i] = -1.0;
      }
    }

    return answer;
  }

  private void collatz(int k){

    while(k!=1){
      seq.add((double)k);
      if(k%2==0){
        k /= 2;
      } else {
        k = k*3 + 1;
      }
    }
    seq.add((double)1);
  }

  public static void main(String[] args) {
    CollatzConjecture collatzConjecture = new CollatzConjecture();

    int[][] ranges = {{0,0},{0,-1},{2,-3},{3,-3}};
    System.out.println(Arrays.toString(collatzConjecture.solution(5,ranges)));
  }

}
