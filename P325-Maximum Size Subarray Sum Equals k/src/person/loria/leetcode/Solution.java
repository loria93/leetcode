package person.loria.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int maxSubArrayLen(int[] nums, int k) {
		int sum = 0;
		int n = nums.length;
		int maxLength = 0;
		Map<Integer, Integer> accSum = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			sum += nums[i];
			if (sum == k)
				maxLength = Math.max(i + 1, maxLength);
			if (!accSum.containsKey(sum))
				accSum.put(sum, i);
			if (accSum.containsKey(sum - k))
				maxLength = Math.max(i - accSum.get(sum - k), maxLength);
		}
		return maxLength;
	}
}
