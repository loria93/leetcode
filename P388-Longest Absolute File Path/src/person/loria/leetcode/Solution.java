package person.loria.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public int lengthLongestPath(String input) {
		int n = input.length();
		List<Integer> lengths = new ArrayList<Integer>();
		char[] chars = new char[n];
		input.getChars(0, n, chars, 0);
		int depth = 0, maxLength = 0, length = 0;
		boolean isFile;
		for (int i = 0; i < n; i++) {
			depth = 0;
			isFile = false;
			while (i < n && chars[i] == '\t') {
				depth++;
				i++;
			}
			if (depth > 0) {
				// +1 because of "/"
				length = lengths.get(depth - 1).intValue() + 1;
			} else {
				length = 0;
			}
			while (i < n && chars[i] != '\n') {
				if (chars[i] == '.')
					isFile = true;
				length++;
				i++;
			}
			if (isFile)
				maxLength = Math.max(maxLength, length);
			else {
				if (depth >= lengths.size())
					lengths.add(Integer.valueOf(length));
				else
					lengths.set(depth, Integer.valueOf(length));
			}
		}
		return maxLength;
	}
}