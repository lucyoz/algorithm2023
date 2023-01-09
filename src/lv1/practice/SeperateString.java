package lv1.practice;

//문자열 나누기
// https://school.programmers.co.kr/learn/courses/30/lessons/140108
public class SeperateString {
    public static int solution(String s){
        int answer = 0;


        char x = s.charAt(0);
        int difference = 0;     //x의 개수 - x가 아닌 글자의 개수

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==x){
                difference++;
            } else {
                difference--;
            }

            if (i==s.length()-1){
                answer++;
            } else if (difference == 0){
                answer++;
                x = s.charAt(i+1);
            }
        }




        return answer;
    }

    public static void main(String[] args) {

        String s1 = "banana";
        System.out.println("banana : "+solution(s1));

        String s2 = "abracadabra";
        System.out.println("abracadabra : "+solution(s2));

        String s3 = "aaabbaccccabba";
        System.out.println("aaabbaccccabba : "+solution(s3));
    }
}
