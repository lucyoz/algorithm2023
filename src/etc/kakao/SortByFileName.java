package etc.kakao;

import java.util.Arrays;
import java.util.Locale;

public class SortByFileName {

  public String[] solution(String[] files){
    String[] answer = new String[files.length];
    String[] filesHEAD = new String[files.length];
    String[] filesNUMBER = new String[files.length];
    String[] filesTAIL = new String[files.length];
    String[][] answer2 = new String[files.length][3];

    for (int i = 0; i < files.length; i++) {
      int j, k=0, l=0;
      boolean state = false;
      for (j = 0; j < files[i].length(); j++) {

        if(files[i].charAt(j) >= 48 && files[i].charAt(j) <= 57){
          if(!state && files[i].charAt(j) > 48 && files[i].charAt(j) <= 57){
            l = j;
            state = true;
            continue;
          }
          if(!state && files[i].charAt(j) == 48){
            k++;
            continue;
          }

        }
        if(state && !(files[i].charAt(j) >= 48 && files[i].charAt(j) <= 57)){
          break;
        }
      }
      filesHEAD[i] = files[i].substring(0,l-k);
      filesNUMBER[i] = files[i].substring(l-k,j);
      filesTAIL[i] = files[i].substring(j);
      answer2[i][0] = files[i].substring(0,l-k);
      answer2[i][1] = files[i].substring(l-k,j);
      answer2[i][2] = files[i].substring(j);
    }

    System.out.println(Arrays.toString(filesHEAD));
    System.out.println(Arrays.toString(filesNUMBER));
    System.out.println(Arrays.toString(filesTAIL));

    Arrays.sort(answer2, (o1, o2) ->{
      if(o1[0].toLowerCase().compareTo(o2[0].toLowerCase(Locale.ROOT)) > 0){
        return 1;
      } else if (o1[0].toLowerCase().compareTo(o2[0].toLowerCase(Locale.ROOT)) < 0){
        return -1;
      } else {
        if (Integer.parseInt(o1[1]) > Integer.parseInt(o2[1])){
          return 1;
        } else if (Integer.parseInt(o1[1]) < Integer.parseInt(o2[1])){
          return -1;
        } else {
          return 0;
        }
      }
    });

    for (int i = 0; i < answer.length; i++) {
      answer[i] = answer2[i][0] + answer2[i][1] + answer2[i][2];
    }

    return answer;
  }

  public static void main(String[] args) {
    SortByFileName sortByFileName = new SortByFileName();

    String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
    System.out.println(Arrays.toString(sortByFileName.solution(files)));
  }

}
