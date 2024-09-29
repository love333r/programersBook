package Chapter03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*<문제 풀이 흐름>
* 1. 모든 직선 쌍에 대한 반복
*   1-1. 교점 좌표 구하기
*   1-2. 정수 좌표 저장하기
* 2. 저장된 정수들에 대해 x, y좌표의 최댓값, 최솟값 구하기 -> 정확히 별을 표시할 수 있을 정도로 작게 잡아야 함
* 3. 구한 최댓값, 최솟값을 이용하여 2차원 배열의 크기 결정
* 4. 2차원 배열에 별 표시
* 5. 문자열 배열로 변환 후 반환*/
//Todo. sout -> logger 변경
public class Solution01 {

    private static class Point {// 좌표 표현
        public final long x, y;
        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    private Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {// 두 직선의 교점을 구하여 정수 좌표 구하기
        double x = (double) (b1 * c2 - b2 * c1)/(a1 * b2 - a2 * b1);
        double y = (double) (a2 * c1 - a1 * c2)/(a1 * b2 - a2 * b1);

        System.out.println("1. 두 직선의 교점을 구하여 정수 좌표 구하기");
        System.out.println("a1 = " + a1 + ", b1 = " + b1 + ", c1 = " + c1 + ", a2 = " + a2 + ", b2 = " + b2 + ", c2 = " + c2);
        System.out.printf("(%f, %f)%n", x, y);

        if(x % 1 != 0 || y % 1 != 0) return null;   // 교점이 정수가 아니면 null 반환

        return new Point((long) x, (long) y);
    }

    public Point getMinimumPoint(List<Point> points) {// 가장 작은 좌표 찾기
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;

        for(Point p : points) {
            if(p.x < x) x = p.x;
            if(p.y < y) y = p.y;
        }
        System.out.printf("%n%n2-1. 가장 작은 좌표: (%d, %d)%n", x, y);
        return new Point(x, y);
    }

    public Point getMaxiimumPoint(List<Point> points) {// 가장 큰 좌표 찾기
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;

        for(Point p : points) {
            if(p.x > x) x = p.x;
            if(p.y > y) y = p.y;
        }
        System.out.printf("2-2. 가장 큰 좌표: (%d, %d)%n%n", x, y);
        return new Point(x, y);
    }

    public String[] solution(int[][] line) {// 정수 좌표만 저장
        List<Point> points = new ArrayList<>();
        for(int i = 0; i < line.length; i++) {
            System.out.printf("직선 i[%d]:", i);
            System.out.printf("%d, %d, %d%n", line[i][0], line[i][1], line[i][2]);
            for(int j = i + 1; j < line.length; j++) {
                System.out.printf("직선 j[%d]:", j);
                System.out.printf("%d, %d, %d%n", line[j][0], line[j][1], line[j][2]);
                Point intersection = intersection(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);

                if(intersection != null) {
                    System.out.printf("(%d, %d)%n%n", intersection.x, intersection.y);
                    points.add(intersection);
                }
            }
        }

        Point minimum = getMinimumPoint(points);
        Point maximum = getMaxiimumPoint(points);

        int width = (int) (maximum.x - minimum.x + 1);
        int height = (int) (maximum.y - minimum.y + 1);
        System.out.println("3. 2차원 배열 면적 구하기");
        System.out.printf("width = (int) (%d - %d + 1) = %d%n", maximum.x, minimum.x, width);
        System.out.printf("height = (int) (%d - %d + 1) = %d%n", maximum.y, minimum.y, height);
        System.out.printf("char[%d][%d]%n%n",height, width);
        char[][] arr = new char[height][width];
        for (char[] row: arr) {
            Arrays.fill(row, '.');
        }

        for(Point p : points) {
            int x = (int) (p.x - minimum.x);
            int y = (int) (maximum.y - p.y);
            System.out.println("4. 이거 뭐하는거지");
            System.out.printf("x = (int) (%d - %d) = %d%n", p.x, minimum.x, x);
            System.out.printf("y = (int) (%d - %d) = %d%n", maximum.y, p.y, y);
            System.out.printf("arr[%d][%d] = '*'%n%n", y, x);
            arr[y][x] = '*';
        }

        String[] result = new String[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new String(arr[i]);
        }
        System.out.println(Arrays.toString(result));
        return result;
    }
}
