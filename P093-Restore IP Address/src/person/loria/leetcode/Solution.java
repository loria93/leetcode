package person.loria.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList();
		int strlen = s.length();
		if (strlen < 4 || strlen > 12)
			return result;
		String ipAddr = "";
		parseIp(result, ipAddr, 4, s);
		return result;
	}

	private void parseIp(List<String> result, String ip, int remainingNumber, String s) {
		int strlen = s.length();
		if (strlen < remainingNumber || strlen > 3 * remainingNumber)
			return;
		if (remainingNumber == 1) {
			if (strlen != 1 && s.charAt(0) == '0')
				return;
			if (Integer.parseInt(s) < 256)
				result.add(ip + s);
		} else {
			if (strlen > 1) {
				parseIp(result, ip + s.substring(0, 1) + ".", remainingNumber - 1, s.substring(1));
			}
			if (s.charAt(0) != '0') {
				if (strlen > 2) {
					parseIp(result, ip + s.substring(0, 2) + ".", remainingNumber - 1, s.substring(2));
				}
				if (strlen > 3) {
					if (Integer.parseInt(s.substring(0, 3)) < 256)
						parseIp(result, ip + s.substring(0, 3) + ".", remainingNumber - 1, s.substring(3));
				}
			}
		}
		return;
	}
}
