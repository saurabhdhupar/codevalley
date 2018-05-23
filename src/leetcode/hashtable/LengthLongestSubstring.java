package leetcode.hashtable;

public class LengthLongestSubstring {
        
        /*
         * Given a string, find the length of the longest substring without
         * repeating characters.
         * 
         * Examples:
         * 
         * Given "abcabcbb", the answer is "abc", which the length is 3.
         * Given "bbbbb", the answer is "b", with the length of 1.
         * Given "pwwkew", the answer is "wke", with the length of 3. Note that the
         *   answer must be a substring, "pwke" is a subsequence and not a substring.
         */
        
        int lengthOfLongestSubstring(String s) {
	    int maxLength = 0;
	    int j = 0;
	    char[] inputChars = s.toCharArray();
	    Map<Character, Integer> indexCharMap = new HashMap<>();
	    for(int i = 0; i < inputChars.length; i++) {
	      if(indexCharMap.containsKey(inputChars[i])) {
		j = Math.max(j, indexCharMap.get(inputChars[i]));
	      }
	      maxLength = Math.max(maxLength, i - j + 1);
	      indexCharMap.put(inputChars[i], i+1);
	    }
	    return maxLength;
	}
}
