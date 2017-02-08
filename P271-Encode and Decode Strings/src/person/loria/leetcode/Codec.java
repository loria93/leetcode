package person.loria.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Codec {

	// Encodes a list of strings to a single string.
	public String encode(List<String> strs) {
		int n = strs.size();
		String emptyString = "202";
		String separator = "101";
		String encodedString = "";
		for (int i = 0; i < n; i++) {
			String str = strs.get(i);
			if (str.equals("")) {
				encodedString += emptyString;
				encodedString += separator;
			} else {
				encodedString += str.replaceAll("0", "00");
				encodedString += separator;
			}
		}
		return encodedString;
	}

	// Decodes a single string to a list of strings.
	public List<String> decode(String s) {
		List<String> result = new ArrayList<String>();
		if("".equals(s))
			return result;
		String emptyString = "202";
		String separator = "101";
		String[] strs = s.split(separator);
		int n = strs.length;
		for (int i = 0; i < n; i++) {
			if (strs[i].equals(emptyString))
				strs[i] = "";
			else
				strs[i] = strs[i].replaceAll("00", "0");
			result.add(strs[i]);
		}
		return result;
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));