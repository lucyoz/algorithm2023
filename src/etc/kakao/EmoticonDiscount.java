package etc.kakao;

import java.util.Arrays;

public class EmoticonDiscount {
  //완전탐색(힐인율이 각 10,20,30,40% 일 때)
  //각 할인율 정하고(dfs, 백트래킹)
  //이에 따른 플러스 가입자, 판매액 구하기(1.가입자 최대 2.판매액 최대)

  static final int[] discount = {90, 80, 70, 60};
  static int ePlus = 0;
  static int eSales = 0;

  public int[] solution(int[][] users, int[] emoticons){

    getPrices(emoticons, users, 0, new int[emoticons.length]);

    return new int[]{ePlus, eSales};
  }

  private void getPrices(int[] emoticons, int[][] users, int cur, int[] rates){

    if(cur==emoticons.length){
      update(emoticons, users, rates);
      return;
    }

    for(int dis: discount){
      rates[cur] = dis;
      getPrices(emoticons, users, cur+1, rates);
    }
  }

  private void update(int[] emoticons, int[][] users, int[] rates){
    int plus = 0;
    int totalSum = 0;

    for(int[] user: users){
      int expense = 0;
      int rate = user[0];
      int price = user[1];

      for (int i = 0; i < rates.length; i++) {
        if(rate <= 100-rates[i]){
          expense += emoticons[i] * rates[i] / 100;
        }
        if(expense >= price){
          expense = 0;
          plus++;
          break;
        }
      }
      totalSum += expense;
    }

    if(plus > ePlus){
      ePlus = plus;
      eSales = totalSum;
    } else if (ePlus == plus){
      eSales = Math.max(totalSum, eSales);
    }
  }

  public static void main(String[] args) {
    EmoticonDiscount emoticonDiscount = new EmoticonDiscount();

    int[][] users1 = {{40,10000},{25,10_000}};
    int[][] users2 = {{40, 2_900},{23, 10_000},{11, 5_200},{5, 5900},{40, 3_100},{27, 9_200},{32, 6_900}};

    int[] emoticons1 = {7_000, 9_000};
    int[] emoticons2 = {1_300, 1_500, 1_600, 4_900};
    System.out.println(Arrays.toString(emoticonDiscount.solution(users1, emoticons1)));
    System.out.println(Arrays.toString(emoticonDiscount.solution(users2, emoticons2)));

  }

}
