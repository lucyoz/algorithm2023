package etc.kakao;

import java.util.Arrays;

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
      filesNUMBER[i] = files[i].substring(l,j);
      filesTAIL[i] = files[i].substring(j);
    }

    System.out.println(Arrays.toString(filesHEAD));
    System.out.println(Arrays.toString(filesNUMBER));
    System.out.println(Arrays.toString(filesTAIL));

    return answer;
  }

  public static void main(String[] args) {
    SortByFileName sortByFileName = new SortByFileName();

    String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
    System.out.println(sortByFileName.solution(files));
  }

}
