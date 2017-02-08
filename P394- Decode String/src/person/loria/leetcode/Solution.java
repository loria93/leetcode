package person.loria.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public String decodeString(String s) {
		int n = s.length();
		if (n == 0)
			return "";
		char[] chars = new char[n];
		s.getChars(0, n, chars, 0);
		List<String> list = new ArrayList<String>();
		List<Integer> repeats = new ArrayList<Integer>();
		int depth = 0, repeat = 0;
		String current = "";
		for (int i = 0; i < n; i++) {
			if (depth < list.size()) {
				repeat = repeats.get(depth).intValue();
				if (chars[i - 1] == ']') {
					current = list.get(depth);
					String inner = list.get(depth + 1);
					for (int j = 0; j < repeat; j++) {
						current += inner;
					}
				} else
					current = "";
			} else
				current = "";
			while (i < n && chars[i] <= 'z' && chars[i] >= 'a') {
				current += chars[i];
				i++;
			}
			repeat = 0;
			while (i < n && chars[i] <= '9' && chars[i] >= '0') {
				repeat = repeat * 10;
				repeat += (chars[i] - '0');
				i++;
			}
			if (depth < list.size()) {
				repeats.set(depth, Integer.valueOf(repeat));
				list.set(depth, current);
			} else{
				repeats.add(Integer.valueOf(repeat));
				list.add(current);
			}
			if (i < n) {
				if (chars[i] == '[') {
					depth++;
				}
				if (chars[i] == ']') {
					depth--;
				}
			}
		}
		if (chars[n - 1] == ']') {
			current = list.get(0);
			repeat = repeats.get(0).intValue();
			String inner = list.get(1);
			for (int j = 0; j < repeat; j++) {
				current += inner;
			}
		}
		return current;
	}
}