package chapter03.practice02;

/* [문제 풀이 흐름]
1. 2차원 배열 선언
2. 숫자를 채울 현재 위치를 (0,0)으로 설정
3. 방향에 따라 이동할 수 없을 때까지 반복하면서 숫자 채우기
    3-1. 아래로 이동하면서 숫자 채우기
    3-2. 오른쪽으로 이동하면서 숫자 채우기
    3-3. 왼쪽 위로 이동하면서 숫자 채우기
4. 채워진 숫자를 차례대로 1차원 배열에 옮겨서 반환
 */
public class Solution {
    private static final int[] dx = {0, 1, -1}; // 아래, 오른쪽, 위
    private static final int[] dy = {1, 0, -1}; // 아래, 오른쪽, 위

    public int[] solution(int n) {
        // 1. 2차원 배열 채워 넣을 숫자 선언
        int[][] triangle = new int[n][n];
        int v = 1;  // 2차원 배열에 숫자를 채워 넣을 때마다 1씩 증가

        // 2. 숫자를 채울 현재 위치를 (0,0)으로 설정
        int x = 0;
        int y = 0;
        int d = 0;

        // 3. 방향에 따라 이동할 수 없을 때까지 반복하면서 숫자 채우기
        while (true) {
            triangle[y][x] = v++;

            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) {
                d = (d + 1) % 3;
                nx = x + dx[d];
                ny = y + dy[d];
                if(nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) break;
            }
            x = nx;
            y = ny;
        }

        // 4. 채워진 숫자를 차례대로 1차원 배열에 옮겨서 반환
        int[] result = new int[v - 1];

        int index = 0;
        for (int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                result[index++] = triangle[i][j];
            }
        }

        return result;
    }
}
