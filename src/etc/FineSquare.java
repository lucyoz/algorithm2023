package etc;

import java.math.BigInteger;

public class FineSquare {
  //접근방법 *기울기 *최대공약수
  //(0,0)~(w,h)라고 생각해보자. 이를 잇는 것
  //1. 기울기 구하기(w,h를 각 gcd(최대공약수)로 나눴을 때 a,b)
  //2. 기울기에 의해 a*b개의 정사각형에서(단위정사각형)
  //3. 대각성이 반대쪽 코너에 도달하기 전 a-1 세로선과 b-1 가로선을 지나고 지날때마다 새 정사각형이 추가된다.(버려지는 사각형)
  //4. 첫 정사각형 포함 1 + (a-1) + (b-1) = a + b - 1 에서 아까 공약수gcd(단위정사각형의 횟수?)를 곱해야함
  //   a*gcd + b*gcd - gcd = w + h - gcd (선이 지나는, 버려지는 정사각형)
  //전체 w * h - (w + h - gcd)

  public long solution(int w, int h){
    long answer = 0;

    long gcd = getGcd(w, h);
    System.out.println(gcd);
    long a = w / gcd;
    long b = h / gcd;

    answer = (long)w * h - (w + h - gcd);


    return answer;
  }

  public long getGcd(int num1, int num2){
    BigInteger b1 = BigInteger.valueOf(num1);
    BigInteger b2 = BigInteger.valueOf(num2);
    return b1.gcd(b2).intValue();
  }

  public static void main(String[] args) {
    FineSquare fineSquare = new FineSquare();

    System.out.println(fineSquare.solution(8,12));
  }

}
