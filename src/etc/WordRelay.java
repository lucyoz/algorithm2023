package etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordRelay {

  public int[] solution(int n, String[] words){
    int[] answer = new int[2];
    int result = -1;
    char first;

    List<String> list = new ArrayList<>();
    for (int i = 0; i < words.length; i++) {
      first = words[i].charAt(0);
      if(list.isEmpty()){
        list.add(words[i]);
        continue;
      }
      if(list.contains(words[i])){
        result = i + 1;
        break;
      }
      if(first!= list.get(i-1).charAt(list.get(i-1).length()-1)){
        result = i+1;
        break;
      }
      list.add(words[i]);
    }

    if(result==-1){
      return new int[]{0, 0};
    }

    if(result%n==0){    //한 턴이 무사히 돌아가고! 마지막 사람이 걸린 것
      answer[0] = n;
      answer[1] = result / n;
    } else {
      answer[0] = result % n;
      answer[1] = result / n + 1;
    }


    return answer;
  }


  public static void main(String[] args) {
    WordRelay wordRelay = new WordRelay();

    String[] words1 = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
    String[] words2 = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
    String[] words3 = {"hello", "one", "even", "never", "now", "world", "draw"};

    System.out.println(Arrays.toString(wordRelay.solution(3, words1)));
    System.out.println(Arrays.toString(wordRelay.solution(5, words2)));
    System.out.println(Arrays.toString(wordRelay.solution(2, words3)));
  }

}
