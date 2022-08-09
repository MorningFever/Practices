/*
첫 번째 계산

아이들은 여러 자리 숫자들을 더하기 위해서 우에서 좌로 숫자를 하나씩 차례대로 더 하라고 배웠다.
1을 한 숫자 위치에서 다음 자리로 더하기위해 이동하는 "한자리올림"연산을 많이 발견하는 것은 중요한 도전이 된다.
당신의 일은 교육자가 그들의 어려움을 평가하기 위하여, 덧셈 문제들의 각 집합에 대해서 한자리올림 연산들의 수를 계산하는 것이다.

입력

입력의 각 라인은 10개의 숫자들보다 미만인 양의 정수들 두 개를 포함한다. 입력의 마지막 라인은 0 0 을 포함한다.

출력

마지막을 제외한 입력의 각 라인에 대해서 당신은 두 숫자들을 더한 결과에서 한자리올림 연산들의 수를 아래 처럼 보여지는 형식으로 계산하여 출력해야 한다.

입력 샘플

123 456
555 555
123 594
0 0

출력 샘플

No carry operation.
3 carry operations.
1 carry operation.

순서
1. 10 제곱수로 나누면서 낮은 자릿수부터 구한다.
1의 자리 -> 10으로 나눈 나머지
10의 자리 -> 100으로 나눈 나머지 - 10으로 나눈 나머지
100 -> 1000 - 100 - 10
string length 만큼 반복

2. 각 자릿수끼리 더해서 10이 넘으면 카운터 추가 + 다음 자릿수 계산에 +1
3. 결과 출력

1. String으로 변환 -> split -> 리스트에 역순으로 추가
2. 같은 인덱스 번호끼리 더해서 10이 넘으면 카운터 추가 + 다음 자릿수 계산에 +1
예외 발생시 (자릿수 차이) -> 3으로 직행
3. 결과 출력


 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PrimaryArithmetic {


    public static void main(String[] args) {

        int fCount = 0, sCount = 0;
        List<Integer> firstN = new ArrayList<>();
        List<Integer> secondN = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("형식에 맞춰 입력해 주세요:");
        while (true) {
            String input = sc.nextLine();
            try {
                if (!input.equals("0 0")) {
                    String[] temp = input.split(" ");  // 공백으로 구분해서 비교할 1열 2열 리스트에 각각 값 추가
                    firstN.add(fCount, Integer.parseInt(temp[0]));
                    secondN.add(sCount, Integer.parseInt(temp[1]));
                    System.out.print(firstN.get(fCount));
                    System.out.println(" " + secondN.get(sCount));
                    fCount++;
                    sCount++;

                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("정수만 입력해 주세요.");
            }
        }
        System.out.println("계산 시작");
        List<Integer> finResult = magicBox(firstN, secondN);
        System.out.println("결과 출력: ");
        if (finResult.size() > 1) {
            for (Integer i : finResult) {
                System.out.printf("%d행 -> 한자리 올림 %d회 시행\n", finResult.indexOf(i)+1, i);
            }

        } else {
            System.out.printf("한자리 올림 %d회 시행\n", finResult.get(0));
        }
    }

    public static List<Integer> magicBox(List<Integer> a, List<Integer> b) {

        List<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < a.size(); i++) {

            String aStr = String.valueOf(a.get(i));  //리스트 인덱스 1을 거꾸로된 숫자 배열로 만들기
            String[] aStrDiv = aStr.split("");
            String bStr = String.valueOf(b.get(i));
            String[] bStrDiv = bStr.split("");

            List<Integer> ailist = new ArrayList<>();
            List<Integer> bilist = new ArrayList<>();

            for (String s : aStrDiv) {
                ailist.add(Integer.parseInt(s));
                Collections.reverse(ailist);
            }
            for (String s : bStrDiv) {
                bilist.add(Integer.parseInt(s));
                Collections.reverse(bilist);
            }

            int counter = 0;
            int upped = 0;
            int aIdx = 0;
            int bIdx = 0;
            while (true) {  // 낮은 자리부터 a와 b의 각 숫자 더해서 카운터 쌓기
                int temp = ailist.get(aIdx) + bilist.get(bIdx) + upped;
                if (temp > 9) {
                    counter++;
                    aIdx++;
                    bIdx++;
                    upped = 1;
                } else {
                    aIdx++;
                    bIdx++;
                    upped = 0;
                }
                if (aIdx == ailist.size() || bIdx == bilist.size()) {
                    resultList.add(i, counter);
                    break;
                }
            }
            System.out.println("계산중: " + (i+1) +"번째 행");
        }
        return resultList;
    }
}

