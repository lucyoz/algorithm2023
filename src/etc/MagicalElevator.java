package etc;

public class MagicalElevator {
  public long onesPlace(long num, long digit){
    if(digit==1){
      return num;
    }
    num = num % (int)(Math.pow(10, digit-1));

    if(num>5){
      return 10-num;
    } else {
      return -num;
    }
  }

  public int sumOfDigit(long num){
    int result = 0;
    String[] arr = String.valueOf(num).split("");

    for(String a: arr){
      result += Integer.parseInt(a);
    }
    return result;
  }

  public int solution(int storey){
    int answer = 0;

    long length = (int)(Math.log10(storey)+1);

    long num = storey % (long)(Math.pow(10,length-1));
    System.out.println(length);
    System.out.println(num);

    if (length==1){
      if(storey > 5){
        return 10-storey;
      } else {
        return storey;
      }
    } else if (length==2){
      long one = storey % 10;
      if(one > 5){
        answer += (10-one);
        storey += (10-one);
      } else {
        answer += one;
        storey -= one;
      }
      answer += storey / 10;
      return answer;
    }
    long one = onesPlace(num, length-2);
    num += one;
    storey += one;
    if(one > 0){
      answer += one;
    } else {
      answer -= one;
    }

    long newNum = (num < (Math.pow(10, length-1)-num)) ? num: (long)(Math.pow(10, length-1)-num);

    answer += sumOfDigit(newNum);
    answer += (storey + newNum) / (long)(Math.pow(10, length-1));

    return answer;
  }

  public static void main(String[] args) {
    MagicalElevator magicalElevator = new MagicalElevator();
    //System.out.println(magicalElevator.solution(2554));
    System.out.println(magicalElevator.solution(16));
  }

}
