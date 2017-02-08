package person.loria.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> missing = new LinkedList<String>();
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i - 1] == nums[i])
				continue;
			if (nums[i] > lower) {
				if (nums[i] == lower + 1) {
					missing.add("" + lower);

				} else {
					missing.add(lower + "->" + (nums[i] - 1));
				}
			}
			lower = nums[i] + 1;
		}
		if (nums.length != 0 && lower == Integer.MIN_VALUE)
			return missing;
		if (lower < upper)
			missing.add(lower + "->" + upper);
		if (lower == upper)
			missing.add("" + upper);
		return missing;
	}
}