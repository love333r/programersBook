package chapter03.practice01;

public class Main01 {
    public static void main(String[] args) {
        int[][] line = {
                {0, 1, -1},
                {1, 0, -1},
                {1, 0, 1}
        };

        Solution01 s1 = new Solution01();
        s1.solution(line);
    }
}
