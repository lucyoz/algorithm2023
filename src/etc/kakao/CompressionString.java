package etc.kakao;

public class CompressionString {
  //최대 length/2까지만 압축할 수 있다.
  //순차적으로 비교.
  //문자열 연산이 자주 일어나므로 String보다 StringBuilder를 사용.

  //1.for문 이용하여 1부터 length/2까지 i의 길이를 갖는 문자열 base 구하기
  //2.해당 base 문자열로 j+i까지 문자열 비교하기
  //3. 같으면 count 증가. 같지 않으면 base 붙이고 다음 base로 바꿔서 같은 부분 찾기
  //4. s.length()와 구한 문자열 sb의 length 비교. 최솟값 리턴

  public int solution(String s){
    int answer = s.length();
    int count = 1;

    for (int i = 1; i <= s.length()/2; i++) {

      StringBuilder sb = new StringBuilder();
      String base = s.substring(0,i);             //한 번 카운트(count==1)
      for (int j = i; j <= s.length(); j+=i) {

        int endIdx = Math.min(j+i, s.length());   //idx가 length 넘지 않게
        String compare = s.substring(j, endIdx);
        if(base.equals(compare)){
          count++;
        } else {
          if(count >= 2){
            sb.append(count);
          }
          sb.append(base);
          base = compare;
          count = 1;
        }
      }
      sb.append(base);    //마지막 문자 붙이기
      answer = Math.min(answer, sb.length()); //최솟값
    }

    return answer;
  }

  public static void main(String[] args) {

    CompressionString compressionString = new CompressionString();
    String s1 = "aabbaccc";
    String s2 = "ababcdcdababcdcd";
    String s3 = "abcabcdede";
    String s4 = "abcabcabcabcdededededede";
    String s5 = "xababcdcdababcdcd";

    System.out.println(compressionString.solution(s1));
    System.out.println(compressionString.solution(s2));
    System.out.println(compressionString.solution(s3));
    System.out.println(compressionString.solution(s4));
    System.out.println(compressionString.solution(s5));
  }

}
