/*
문제는 다음과 같다:

6 6

  0   1   2   3   4   5
 19  20  21  22  23   6
 18  31  32  33  24   7
 17  30  35  34  25   8
 16  29  28  27  26   9
 15  14  13  12  11  10
위처럼 6 6이라는 입력을 주면 6 X 6 매트릭스에 나선형 회전을 한 값을 출력해야 한다.

풀이 V1
1. n*m 으로 값이 주어지면 그것을 길이로 하는 2차원 배열 생성
2. 각 좌표를 하나씩 지정하면서 숫자를 입력
0,0 -> 0,1 -> .... -> 0, m-1
3. 다음 좌표가 없거나 0이 아닌 값이 있으면 방향 바꾸기 (switch)
4. 검사 후 출력




 */

import java.util.Scanner;

public class Problem2 {

    enum Direction {
        Right, Down, Left, Up
    }

    public static void spiralArray(int a, int b) {

        int[][] temp = new int[a][b];
        int count = 0;
        int i=0, j=0;
        Direction currentD = Direction.Right;
        do {
            switch (currentD) {
                case Right -> {
                    temp[i][j++] = count++;
                    if (j == b || temp[i][j] != 0) {
                        j--;
                        i++;
                        currentD = Direction.Down;

                    }
                }
                case Down -> {
                    temp[i++][j] = count++;
                    if (i == a || temp[i][j] != 0) {
                        i--;
                        j--;
                        currentD = Direction.Left;

                    }
                }
                case Left -> {
                    temp[i][j--] = count++;
                    if (j == -1 || temp[i][j] != 0) {
                        j++;
                        i--;
                        currentD = Direction.Up;

                    }
                }
                case Up -> {
                    temp[i--][j] = count++;
                    if (i == 0 || temp[i][j] != 0) {
                        i++;
                        j++;
                        currentD = Direction.Right;
                    }
                }
            }
        } while (count != a * b);

        System.out.println("계산끝");

        for (int x = 0; x < a; x++) {
            for (int y = 0; y < b; y++) {
                System.out.print(temp[x][y] + "\t");
            }
            System.out.println();

        }
    }




    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();

        int num2 = sc.nextInt();
        System.out.println("처리시작");
        spiralArray(num1, num2);



        System.out.println("완료!");
    }
}
