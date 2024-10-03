package chapter03.practice02;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s1 = new Solution();

        for (int n = 3; n <= 6; n++) {
            System.out.printf("n: %d", n);
            System.out.println(Arrays.toString(s1.solution(n)));

            System.out.println();
        }
    }
}
