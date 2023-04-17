//Parametric Search
//가로등 높이가 될 수 있는 범위 내에서 이분탐색의 아이디어로 특정 높이를 정하고 mid = (left+right)/2 돌다리 전부 건널 수 있는지 판별
//된다면 최소인가? -> right = mid - 1 시도. 안되면, mid보다 높은 값 left = mid + 1 시도
//반복할 수 없는 상황까지 left > right
package etc;

import java.util.Scanner;

public class BeakJoon17266 {

  static int[] Arr;
  static int N, M;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();
    Arr = new int[M];

    for (int i = 0; i < M; i++) {
      Arr[i] = sc.nextInt();
    }

    int left = 1;
    int right = N;
    int result = 0;

    while (left <= right) {
      int mid = ( left + right ) / 2;

      //mid로 비출 수 있다면, result 갱신 후 높이를 줄여보자
      if(possible(mid)){
        result = mid;
        right = mid - 1;
      } else {      //없다면, 높이를 높여보자
        left = mid + 1;
      }

    }
    System.out.println(result);
  }

  static boolean possible(int target){
    int prev = 0; //이전 가로등이 비춘 지점

    for (int i = 0; i < Arr.length; i++) {
      if(Arr[i] - target <= prev){
        prev = Arr[i] + target;
      } else {
        return false;
      }
    }

    //마지막 지점도 비출 수 있는 가 확인
    //뻈을 때 0보다 크면 비추지 못한 것이 남아있다는 뜻
    return N - prev <= 0;
  }

}
