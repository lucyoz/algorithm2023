package etc.kakao;

public class FindPrimeInK {

  public static boolean isPrime(long num){
    if(num==1){
      return false;
    }

    for (int i = 2; i <= (int)Math.sqrt(num); i++) {
      if(num % i == 0){
        return false;
      }
    }

    return true;
  }

  public static int findPrime(String[] strNum){
    int result = 0;

    for (int i = 0; i < strNum.length; i++) {
      if(strNum[i].equals("")){
        continue;
      }

      long num = Long.parseLong(strNum[i]);
      System.out.println(num);

      if(isPrime(num)){
        result++;
      }

    }

    return result;
  }

  public static int solution(int n, int k){
    int answer = 0;

    String num = Integer.toString(n, k);
    System.out.println(num);

    String[] strNum = num.split("0");

    answer = findPrime(strNum);


    return answer;
  }

  public static void main(String[] args) {


    int n = 437674;
    int k = 3;
    System.out.println(solution(n, k));
  }

}
