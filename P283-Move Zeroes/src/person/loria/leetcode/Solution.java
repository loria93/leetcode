package person.loria.leetcode;

public class Solution {
	public void moveZeroes(int[] nums) {
		int n = nums.length;
		int zero = 0, nonZero = 0;
		while (zero < n) {
			while (zero < n && nums[zero] != 0) {
				zero++;
			}
			if (nonZero < zero)
				nonZero = zero;
			while (nonZero < n && nums[nonZero] == 0) {
				nonZero++;
			}
			if (nonZero < n) {
				nums[zero] = nums[nonZero];
				nums[nonZero] = 0;
				zero++;
				nonZero++;
			} else
				break;
		}
	}
}
