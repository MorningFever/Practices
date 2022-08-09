/*
어떤 자연수 n이 있을 때, d(n)을 n의 각 자릿수 숫자들과 n 자신을 더한 숫자라고 정의하자.

예를 들어

d(91) = 9 + 1 + 91 = 101

이 때, n을 d(n)의 제네레이터(generator)라고 한다. 위의 예에서 91은 101의 제네레이터이다.

어떤 숫자들은 하나 이상의 제네레이터를 가지고 있는데, 101의 제네레이터는 91 뿐 아니라 100도 있다.
그런데 반대로, 제네레이터가 없는 숫자들도 있으며, 이런 숫자를 인도의 수학자 Kaprekar가 셀프 넘버(self-number)라 이름 붙였다.
예를 들어 1,3,5,7,9,20,31 은 셀프 넘버 들이다.

1 이상이고 5000 보다 작은 모든 셀프 넘버들의 합을 구하라.
* */

/*
풀이 v1
1. 1~5000 까지의 정수가 들어있는 목록을 생성
2. "abcde" 형태의 정수를 제네레이터로 넣는다고 하면, 결과는
10001a + 1001b + 101c + 11d + 2e 의 형태임.
abcde 각각에 0~9를 대입하면 not self-number를 구할 수 있음.
어떻게 각각의 숫자를 인식하게 하지? -> string으로 바꾸고 인덱싱
3. 구한 셀프 넘버를 1번의 목록에서 제거
4. 남은 정수를 합치기
 */

import java.util.ArrayList;
public class Problem1 {

    static int nSMaker (int n) {  // !Self-Number 생성기
        String nS = String.format("%04d", n);

        int a = Integer.parseInt(String.valueOf(nS.charAt(0)));
        int b = Integer.parseInt(String.valueOf(nS.charAt(1)));
        int c = Integer.parseInt(String.valueOf(nS.charAt(2)));
        int d = Integer.parseInt(String.valueOf(nS.charAt(3)));
        return 1001*a + 101*b + 11*c + 2*d;
    }


    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(); // 1~5000 리스트와 result 생성
        for (int i = 0; i<5000; i++) {
            list.add(i, i+1);
        }
        int result = 0;

        for (int i = 0; i<5000; i++) {  // 리스트에서 !Self-Number 찾아서 제거
            int temp = nSMaker(i);

            if (temp < 5001){
                int j = list.indexOf(temp);
                if (j>0) {
                    list.remove(j);
                }

            }
        }

        for (Integer i : list) { // 남은 수(Self-Number) 합계
            result += i;
        }

        System.out.println(result);
    }
}
