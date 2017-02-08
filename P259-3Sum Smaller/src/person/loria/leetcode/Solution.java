package person.loria.leetcode;

import java.util.Arrays;

public class Solution {
	public int threeSumSmaller(int[] nums, int target) {
		int n = nums.length, setNum = 0;
		if (n <= 2)
			return 0;
		Arrays.sort(nums);
		int front, middle, end, t;
		for (front = 0; front < n - 2; front++) {
			middle = front + 1;
			end = n - 1;
			t = target - nums[front];
			while (middle < end) {
				if (nums[middle] + nums[end] < t) {
					setNum += (end - middle);
					middle++;
				} else
					end--;
			}
		}
		return setNum;
	}
}