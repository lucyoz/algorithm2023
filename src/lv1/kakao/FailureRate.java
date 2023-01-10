package lv1.kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//주의: 0 / 0 은 Nan이 됨 -> 테스트케이스에서 실패함.
//ex. N=5, stages = {3, 3, 3, 3} 이면 [0, 0, 0, NaN, NaN]이 되어 실패
public class FailureRate {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int fail, total;
        double[] rate = new double[N];
        List<Double> rateList = new ArrayList<>();

        //스테이지 N개
        for (int i = 1; i <= N; i++) {
            //stage 2의 실패율: 2번 수행중인 사람 / 2번을 통과한 사람 (2를 통과한 사람은 2보다 번호가 크거나 같은 사람
            fail = 0;
            total = 0;
            for (int j = 0; j < stages.length; j++) {
                //현재 스테이지에 머물러 있는 사람만 해당 스테이지 실패로 간주하므로 fail[스테이지번호]안에 넣기
                if(stages[j]==i){
                    fail++;
                }

                //2번 스테이지를 지나간 사람(total). 즉, stages[i]가 2보다 크거나 같은 사람의 수
                if(stages[j]>=i){
                    total++;
                }
            }
            System.out.println(i + "번째 "+"fail:" + fail+" total: "+total);
            double rateDouble = (double) fail / total;
            rateList.add(Double.isNaN(rateDouble) ? 0.0 : rateDouble) ;
        }

        System.out.println(rateList.size());
        for (int i = 0; i < N; i++) {
            double max = Collections.max(rateList);
            answer[i]=rateList.indexOf(max)+1;
            rateList.set(rateList.indexOf(max), (double)-1);
        }

        return answer;
    }

    public static void main(String[] args) {
        FailureRate rate = new FailureRate();
        int[] stages = {3, 3, 3, 3};
        int[] answer = rate.solution(5, stages);

        System.out.println("결과 : "+Arrays.toString(answer));


    }
}
