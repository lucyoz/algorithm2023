package greedy;

//0 1 2 3 4 5 6 7 8 9 0 1 2 3
//a b c d e f g h i j k l m n
//  z y x w v u t s r q p o


public class JoyStick {
  //알파벳 움직이는 횟수는 결정되어있음
  //커서 왼,오 이동이 관건
  //둘 다 구해서 마지막 answer에 최솟값 합하기

  public int solution(String name) {
    int answer = 0;

    int idx = 0;
    int move = name.length() - 1;
    while(idx<name.length()){
      char ch = name.charAt(idx);

      if(ch <='N'){
        answer += ch -'A';
      } else {
        answer += 'Z' - ch + 1;
      }

      //어떤 방향으로 가는 것이 유리한가?
      if(idx < name.length() - 1 && name.charAt(idx+1) == 'A'){
        int endA = idx + 1;
        while(endA < name.length() && name.charAt(endA)=='A'){
          endA++;
        }
        move = Math.min(move, idx*2 + (name.length()-endA));    //오른쪽으로 갔다 다시 왼쪽으로
        move = Math.min(move, idx + (name.length()-endA)*2);    //왼쪽으로 갔다 다시 오른쪽으로

      }
      idx++;

    }

    answer += move;

    return answer;
  }


  public static void main(String[] args) {
    JoyStick joyStick = new JoyStick();
    System.out.println(joyStick.solution("JAN"));
    System.out.println(joyStick.solution("JEROEN"));

  }
}


