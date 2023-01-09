package lv1.practice;


public class FoodFight {

    //문자열 뒤집기
    public static String reverse(String str){
        if (str == null || str.equals("")) {
            return str;
        }

        char[] temp = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            temp[str.length() - i - 1] = str.charAt(i);
        }
        return String.copyValueOf(temp);
    }

    public static String solution(int[] food) {
        String side = "";
        String answer = "";

        for (int i = 1; i < food.length; i++) {
            int count = food[i]/2;
            side += String.valueOf(i).repeat(count);
        }
        answer = side + "0" + reverse(side);

        return answer;
    }

    public static void main(String[] args) {
        int[] food1 = {1, 3, 4, 6};
        int[] food2 = {1, 7, 1, 2};

        System.out.println(solution2(food1));
        System.out.println(solution2(food2));
    }


    //간단한 방법 - 뒤집는 걸 따로 생각할 필요 없음.
    public static String solution2(int[] food){
        String answer = "0";

        for (int i = food.length-1; i >0 ; i--) {
            for (int j = 0; j < food[i]/2; j++) {
                answer = i + answer + i;
            }
        }
        return answer;
    }
}
