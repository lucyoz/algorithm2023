package stackNqueue;

import java.util.LinkedList;

public class TruckOnBridge {

  public int solution(int bridge_length, int weight, int[] truck_weights){
    int answer = 1;
    int weightSum = truck_weights[0];
    LinkedList<int[]> bridge = new LinkedList<>();

    int idx = 0;
    bridge.offer(new int[]{truck_weights[idx],1});

    while(!bridge.isEmpty()){

      if(bridge.get(0)[1]==bridge_length){
        int[] first = bridge.removeFirst();
        weightSum -= first[0];
      }
      int length = bridge.size();
      for (int i = 0; i < length; i++) {
        bridge.get(i)[1]++;
      }

      if(idx + 1 < truck_weights.length && bridge.size() + 1 <= bridge_length && weightSum + truck_weights[idx+1] <= weight){
        idx++;
        weightSum += truck_weights[idx];
        bridge.add(new int[]{truck_weights[idx],1});
      }
      answer++;

    }



    return answer;
  }

  public static void main(String[] args) {
    TruckOnBridge truckOnBridge = new TruckOnBridge();

    int[] truck_weights1 = {7,4,5,6};
    int[] truck_weights2 = {10};
    int[] truck_weights3 = {10,10,10,10,10,10,10,10,10,10};
    System.out.println(truckOnBridge.solution(2,100,truck_weights1));
    System.out.println(truckOnBridge.solution(100,100,truck_weights2));
    System.out.println(truckOnBridge.solution(100,100,truck_weights3));
  }

}
