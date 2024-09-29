package Chapter03;

import Chapter03.Solution01;

import java.util.Arrays;

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
