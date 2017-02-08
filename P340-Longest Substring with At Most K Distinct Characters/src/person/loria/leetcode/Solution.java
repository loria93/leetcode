package person.loria.leetcode;

public class Solution {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		if (k == 0) {
			return 0;
		}
		int[] occurence = new int[256];
		int left = 0, kind = 0, l = 0, maxLength = 0;
		for (int i = 0; i < 256; i++)
			occurence[i] = 0;
		for (int i = 0; i < s.length(); i++) {
			int c = s.charAt(i);
			if (occurence[c] != 0) {
				l = i - left + 1;
				occurence[c]++;
			} else {
				if (kind < k) {
					occurence[c]++;
					kind++;
					l = i - left + 1;
				} else {
					int x;
					do {
						x = s.charAt(left);
						occurence[x]--;
						left++;
					} while (occurence[x] != 0);
					occurence[c]++;
					l = i - left + 1;
				}
			}
			if (l > maxLength)
				maxLength = l;
		}
		return maxLength;
	}
}