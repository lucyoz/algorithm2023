package etc;

public class Hotel {
  private static final int MAX_TIME = 1450;   //24 * 60 + 10

  public int calTime(String time){
    String[] str = time.split(":");
    int hour = Integer.parseInt(str[0]);
    int min = Integer.parseInt(str[1]);
    return hour * 60 + min;
  }

  public int solution(String[][] book_time){
    int answer = 0;

    int[] rooms = new int[MAX_TIME];

    for(String[] time: book_time){
      String inTime = time[0];
      String outTime = time[1];

      rooms[calTime(inTime)] += 1;          //inTime에는 이용 중 -> 사용중인 방 +1

      rooms[calTime(outTime) + 10] += -1;   //퇴실하고 청소한 후에는 방 이용 가능
    }

    //누적합
    for (int i = 1; i < MAX_TIME; i++) {
      rooms[i] += rooms[i-1];
      answer = Math.max(answer, rooms[i]);
    }

    return answer;
  }

  public static void main(String[] args) {
    Hotel hotel = new Hotel();
    String[][] book_time = {{"15:00", "17:00"},{"16:40", "18:20"},{"14:20", "15:20"},{"14:10", "19:20"},{"18:20", "21:20"}};
    System.out.println(hotel.solution(book_time));
  }

}
