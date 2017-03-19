package algorithms.test;

import algorithms.TwoSum;

public class TwoSumTest {
    public static void main(String args[]) {
        int[] array = new int[] { 3, 2, 3, 4 };
        TwoSum test = new TwoSum();
        int[] result = test.twoSum(array, 6);
        System.out.println("[" + result[0] + "," + result[1] + "]");
    }
}
