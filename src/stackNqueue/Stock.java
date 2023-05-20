package stackNqueue;

import java.util.Arrays;
import java.util.Stack;

public class Stock {

  public int[] solution(int[] prices){
    int[] answer = new int[prices.length];
    Stack<Integer[]> stock = new Stack<>();

    for (int i = 0; i < prices.length; i++) {
      Integer[] tmp = {prices[i], i};     //가격, 들어간 시간

      if(stock.isEmpty()){
        stock.push(tmp);
        continue;
      } else {
        while(stock.peek()[0] > prices[i]){
          answer[stock.peek()[1]] = i - stock.peek()[1];
          stock.pop();
          if(stock.isEmpty()){
            break;
          }
        }
      }


      stock.push(tmp);

    }

    while(!stock.isEmpty()){
      answer[stock.peek()[1]] = (prices.length - 1) - stock.peek()[1];
      stock.pop();
    }



    return answer;
  }

  public static void main(String[] args) {
    Stock stock = new Stock();
    int[] prices = {1,2,3,2,3};
    System.out.println(Arrays.toString(stock.solution(prices)));
  }

}
