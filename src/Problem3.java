/*
1부터 10,000까지 8이라는 숫자가 총 몇번 나오는가?

8이 포함되어 있는 숫자의 갯수를 카운팅 하는 것이 아니라 8이라는 숫자를 모두 카운팅 해야 한다.
(※ 예를들어 8808은 3, 8888은 4로 카운팅 해야 함)

풀이
1. 1부터 10,000까지의 숫자를 한 줄로 이어붙인다.
2. 오름차순으로 정렬한다.
3. 9가 시작되는 위치 번호에서 4가 시작되는 위치 번호를 뺀다?
4. 그러면 그게 답.

2. 배열로 만든 다음 8만 뽑아서 새 배열을 만든다.
3. 배열 길이가 답.

*/

import java.util.Scanner;

public class Problem3 {

    static void numberCounter(int n, int m) {
        StringBuilder line_has_m = new StringBuilder();
        StringBuilder line_nhas_m = new StringBuilder();

        for (int i=1; i<n+1; i++) {
            line_has_m.append(i);
        }
        String x = line_has_m.toString();  //세고자 하는 숫자 m이 표함된 숫자열


        String[] temp = x.split(String.valueOf(m));
        for (String s : temp) {
            line_nhas_m.append(s);
        }
        String y = line_nhas_m.toString(); //세고자 하는 숫자 m이 제거된 숫자열

        System.out.println("정답: "+(x.length()-y.length())+" 개 입니다.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("1부터 몇까지? -> ");
        int num1 = sc.nextInt();
        System.out.print("세고 싶은 숫자는? -> ");
        int num2 = sc.nextInt();

        numberCounter(num1, num2);
    }

}
