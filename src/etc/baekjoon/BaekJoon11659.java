//구간 합 구하기
//시간복잡도를 낮추기 위한 방법?
//매번 i부터 j까지를 합치는 것은 매우 오래걸림
//따라서 배열의 순차적인 합을 먼저 구하고,
//S[j] - S[i-1] 을 이용하여 구할 수 있음.
//이 때 S[i] = S[i-1] + arr[i]

package etc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon11659 {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    int suNo = Integer.parseInt(stringTokenizer.nextToken());
    int quizNo = Integer.parseInt(stringTokenizer.nextToken());
    long[] S = new long[suNo + 1];
    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    for (int i = 1; i <= suNo; i++) {
      S[i] = S[i - 1] + Integer.parseInt(stringTokenizer.nextToken());
    }
    for (int q = 0; q < quizNo; q++) {
      stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      int i = Integer.parseInt(stringTokenizer.nextToken());
      int j = Integer.parseInt(stringTokenizer.nextToken());

      System.out.println(S[j]-S[i-1]);
    }
  }
}
