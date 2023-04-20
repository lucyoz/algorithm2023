package sort;

//Comparator 오버라이드
//내림차순: (o2+o1).compareTo(o1+o2);
//오름차순: (o1+o2).compareTo(o1+o2);

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

  public static String solution(int[] numbers){
    String answer = "";
    String[] str = new String[numbers.length];

    //각 자릿수 String으로 비교 내림차순
    for (int i = 0; i < numbers.length; i++) {
      str[i] = String.valueOf(numbers[i]);
    }

    Arrays.sort(str,new Comparator<String>(){
      @Override
      public int compare(String s1, String s2){

        return (s2 + s1).compareTo(s1 + s2);
      }
    });

    if(str[0].equals("0")){
      return "0";
    }

    for(int i=0;i<str.length;i++){
      answer += str[i];
    }


    return answer;
  }

  public static void main(String[] args) {

    int[] numbers = {6, 10, 2};
    int[] numbers2 = {3, 30, 34, 5, 9};

    System.out.println(solution(numbers));
    System.out.println(solution(numbers2));

  }

}
