package person.loria.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ValidWordAbbr {
	Map<String, String> map = new HashMap<String, String>();

	public ValidWordAbbr(String[] dictionary) {
		int n = dictionary.length;
		for (int i = 0; i < n; i++) {
			String str = dictionary[i];
			String key;
			int length = str.length();
			if (length <= 2) {
				continue;
			} else {
				key = "" + str.charAt(0) + (length - 2) + str.charAt(length - 1);
			}
			if (map.containsKey(key))
				map.put(key,"");
			else {
				map.put(key, str);
			}
		}
	}

	public boolean isUnique(String word) {
		String key;
		int length = word.length();
		if (length < 3) {
			return true;
		} else {
			key = "" + word.charAt(0) + (length - 2) + word.charAt(length - 1);
		}
		if (map.containsKey(key)) {
			if(map.get(key).equals(word))
				return true;
			else
				return false;
		}
		return true;
	}
}
