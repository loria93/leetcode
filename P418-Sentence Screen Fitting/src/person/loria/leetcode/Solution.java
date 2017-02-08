package person.loria.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public int wordsTyping(String[] sentence, int rows, int cols) {
		int i_sentence = 0, i_rows = 0, validChars = 0;
		String str = "";
		for(int i = 0 ; i < sentence.length; i++)
			str+=sentence[i];
		int l = str.length();
		for(int i = 0; i < rows; i++)
		{
			validChars += cols;
			if(str.charAt(validChars%l)==' '){
				validChars++;
				continue;
			}
			while(validChars > 0 && str.charAt((validChars - 1) % l) !=' ')
				validChars --;
		}
		return validChars/cols;
	}
}