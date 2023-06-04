package etc.kakao;

public class MusicInfos {
  //1. musicInfos에서 재생 시간 구하기 -> 악보 반복 횟수 구할 수 있음
  //2. 음악을 1번에서 구한 주기만큼 반복하는 String 만들기
  //3. 2번 안에 m인 포함되어 있는가?

  //만약. 음악 재생 시간 < m의 길이 => 그곡 아님!
  //고려해야할 것! C#, D# 등 반음도 한 음으로 봐야한다.
  public String solution(String m, String[] musicinfos){
    String answer = "";

    for (int i = 0; i < musicinfos.length; i++) {
      String[] music = musicinfos[i].split(",");
      int playTime = getPlayTime(music[0], music[1]);
      System.out.println(playTime);

      if(playTime < m.length()){
        continue;
      }

      music[3] = makeSemitone(music[3]);
      m = makeSemitone(m);

      String musicMelody = "";
      musicMelody += music[3].repeat(playTime/music[3].length());
      System.out.println("/"+playTime/m.length());
      System.out.println("playTime"+playTime);
      System.out.println("m.len"+m.length());
      System.out.println("%"+playTime%m.length());
      if(playTime%m.length()!=0){
        musicMelody += music[3].substring(0,playTime % music[3].length());
      }
      System.out.println(musicMelody);

      if(musicMelody.contains(m)){
        answer = music[2];
        break;
      }
    }

    if (answer.equals("")) {
      answer = "(None)";
    }

    return answer;
  }

  public String makeSemitone(String str){
//    str = str.replace("C#","P");
//    str = str.replace("D#","Q");
//    str = str.replace("F#","R");
//    str = str.replace("G#","S");
//    str = str.replace("A#","V");

    str = str.replace("C#","P").replace("D#","Q").replace("F#","R").replace("G#","S").replace("A#","V");

    return str;
  }

  public int getPlayTime(String startTime, String endTime){
    String[] start = startTime.split(":");
    String[] end = endTime.split(":");

    int hour = Integer.parseInt(end[0]) - Integer.parseInt(start[0]);
    int minute = Integer.parseInt(end[1]) - Integer.parseInt(start[1]);

    return hour * 60 + minute;
  }

  public static void main(String[] args) {
    MusicInfos musicInfos = new MusicInfos();

    String m = "ABCDEFG";
    String[] musicInfo = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
    System.out.println(musicInfos.solution(m, musicInfo));
    System.out.println();

    String m2 = "CC#BCC#BCC#BCC#B";
    String[] musicInfo2 = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
    System.out.println(musicInfos.solution(m2, musicInfo2));
    System.out.println();

    String m3 = "ABC";
    String[] musicInfo3 = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
    System.out.println(musicInfos.solution(m3, musicInfo3));
  }

}
