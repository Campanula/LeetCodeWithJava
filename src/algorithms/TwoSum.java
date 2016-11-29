package algorithms;

import java.util.HashMap;
import java.util.Map;

/**
* Two Sum
* <p>Given an array of integers, return indices of the two numbers such that they add up to a specific target.
* You may assume that each input would have exactly one solution. Example:
* <pre>
* Given nums = [2, 7, 11, 15], target = 9,
* Because nums[0] + nums[1] = 2 + 7 = 9,
* return [0, 1].
* <pre/>
*/

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int diff = target - nums[i];
			if (map.containsKey(diff)) {
				return new int[] { map.get(diff), i };
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	public static void main(String args[]){
        int[] array = new int[] {3,2,3,4};
        TwoSum s = new TwoSum();
        int[] result = s.twoSum(array,6);
        System.out.println("["+result[0]+","+result[1]+"]");
    }
}