package etc.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//A: line[i][0] B:line[i][1] E:line[i][2]
//C: line[j][0] D:line[j][1] F:line[j][2]
public class IntersactionStar {
  //1.교점 구하기(set에 넣기-중복방지)
  //  1-1.평행한 경우: AD-BC==0 : 교점 없음
  //  1-2.그 중 정수좌표만
  //2.max,min값을 이용하여 height, width 구하기
  //3.answer에 .으로 채운 좌표계
  //4.set의 교점 *로 표시

  //> 자료형 주의 <
  Set<long[]> coordinate;
  long minX = Long.MAX_VALUE, maxX = Long.MIN_VALUE;
  long minY = Long.MAX_VALUE, maxY = Long.MIN_VALUE;

  public String[] solution(int[][] line){
    coordinate = new HashSet<>();
    for (int i = 0; i < line.length; i++) {
      long a = line[i][0];
      long b = line[i][1];
      long e = line[i][2];
      for (int j = i+1; j < line.length; j++) {
        long c = line[j][0];
        long d = line[j][1];
        long f = line[j][2];

        long adbc = a*d-b*c;

        if(adbc==0){
          continue;
        }

        long xUp = b*f - e*d;
        long yUp = e*c - a*f;

        double x = xUp / (double)adbc;
        double y = yUp / (double)adbc;

        if(x==Math.ceil(x) && y==Math.ceil(y)){
          coordinate.add(new long[]{(long)x,(long)y});

          minX = Math.min(minX, (long)x);
          minY = Math.min(minY, (long)y);
          maxX = Math.max(maxX, (long)x);
          maxY = Math.max(maxY, (long)y);
        }
      }

    }

    Iterator iter = coordinate.iterator();
    while(iter.hasNext()){
      System.out.println(Arrays.toString((long[]) iter.next()));
    }
    long height = maxY - minY + 1;
    long width = maxX - minX + 1;

    boolean[][] tmp = new boolean[(int)height][(int)width];
    for(long[] point: coordinate){
      int x = (int)(point[0] - minX);
      int y = (int)(point[1] - maxY);

      tmp[Math.abs(y)][Math.abs(x)] = true;
    }

    String[] answer = new String[tmp.length];
    int i = 0;
    for(boolean[] bs: tmp) {
      StringBuilder sb = new StringBuilder();
      for (boolean b : bs) {
        if (b) {
          sb.append("*");
        } else {
          sb.append(".");
        }
      }
      answer[i] = sb.toString();
      i++;
    }

    return answer;
  }

  public static void main(String[] args) {
    IntersactionStar intersactionStar = new IntersactionStar();

    int[][] line1 = {{2, -1, 4},{-2,-1,4},{0,-1,1},{5,-8,-12},{5,8,12}};
    int[][] line2 = {{0,1,-1},{1,0,-1},{1,0,1}};
    int[][] line3 = {{1,-1,0},{2,-1,0}};
    int[][] line4 = {{1,-1,0},{2,-1,0},{4,-1,0}};

    System.out.println(Arrays.toString(intersactionStar.solution(line1)));
    System.out.println(Arrays.toString(intersactionStar.solution(line2)));
    System.out.println(Arrays.toString(intersactionStar.solution(line3)));
    System.out.println(Arrays.toString(intersactionStar.solution(line4)));
  }

}
