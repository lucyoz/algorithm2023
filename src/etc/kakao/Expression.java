package etc.kakao;

import java.util.ArrayList;

public class Expression {

  public long solution(String expression){
    //숫자
    String[] longArr = expression.split("[^0-9]");
    ArrayList<Long> longList = new ArrayList<>();
    for (int i = 0; i < longArr.length; i++) {
      longList.add(Long.parseLong(longArr[i]));
    }

    //연산자
    String[] opsArr = expression.split("[0-9]+");
    ArrayList<String> opsList = new ArrayList<>();
    for (int i = 1; i < opsArr.length; i++) {
      opsList.add(opsArr[i]);
    }

    ArrayList<Long> longTemp;
    ArrayList<String> opsTemp;
    long max = 0;


    longTemp = new ArrayList<Long>(longList);
    opsTemp = new ArrayList<String>(opsList);
    calcProc(longTemp, opsTemp, "+","-","*");
    max = Math.max(max, Math.abs(longTemp.get(0)));

    longTemp = new ArrayList<Long>(longList);
    opsTemp = new ArrayList<String>(opsList);
    calcProc(longTemp, opsTemp, "+","*","-");
    max = Math.max(max, Math.abs(longTemp.get(0)));

    longTemp = new ArrayList<Long>(longList);
    opsTemp = new ArrayList<String>(opsList);
    calcProc(longTemp, opsTemp, "*","-","+");
    max = Math.max(max, Math.abs(longTemp.get(0)));

    longTemp = new ArrayList<Long>(longList);
    opsTemp = new ArrayList<String>(opsList);
    calcProc(longTemp, opsTemp, "*","+","-");
    max = Math.max(max, Math.abs(longTemp.get(0)));

    longTemp = new ArrayList<Long>(longList);
    opsTemp = new ArrayList<String>(opsList);
    calcProc(longTemp, opsTemp, "-","*","+");
    max = Math.max(max, Math.abs(longTemp.get(0)));

    longTemp = new ArrayList<Long>(longList);
    opsTemp = new ArrayList<String>(opsList);
    calcProc(longTemp, opsTemp, "-","+","*");
    max = Math.max(max, Math.abs(longTemp.get(0)));


    return max;
  }

  public void calcProc(ArrayList<Long> longList, ArrayList<String> opsList, String op1, String op2, String op3){
    calc(longList, opsList, op1);
    calc(longList, opsList, op2);
    calc(longList, opsList, op3);
  }

  public void calc(ArrayList<Long> longList, ArrayList<String> opsList, String op){
    int i = 0;
    int length = opsList.size();

    while(i<length){
      if(op.equals(opsList.get(i))){
        switch (op){
          case "+":
            longList.set(i, longList.get(i)+longList.get(i+1));
            break;
          case "-":
            longList.set(i, longList.get(i)-longList.get(i+1));
            break;
          case "*":
            longList.set(i, longList.get(i)*longList.get(i+1));
            break;

        }

        longList.remove(i+1);
        opsList.remove(i);
        i--;
        length--;
      }
      i++;
    }
  }

  public static void main(String[] args) {

    Expression expression = new Expression();

    System.out.println(expression.solution("100-200*300-500+20"));
    System.out.println(expression.solution("50*6-3*2"));
  }

}
