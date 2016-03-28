package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * example:
 * Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
 * Return 16
 * The two words can be "abcw", "xtfn".
 * @author skywalker
 *
 */
public class MaximumProductofWordLengths {

	/**
	 * 此算法来自: https://segmentfault.com/a/1190000004186943
	 * @param words
	 * @return
	 */
	public static int maxProduct(String[] words) {
        if (words == null) throw new IllegalArgumentException("The param words can't be null.");
        int maxLength = 0;
        //把字符串按照从长到短的顺序排序
        Arrays.sort(words, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.length() - o1.length();
			}
		});
        int[] bitMap = new int[words.length];
        for (int i = 0, l = words.length;i < l; i++) {
        	char[] arr = words[i].toCharArray();
        	for (int j = 0, al = arr.length; j < al; j++) {
        		bitMap[i] |=  (1 << arr[j] - 'a');
        	}
        }
        
        for (int i = 0, l = words.length;i < l; i++) {
        	if (words[i].length() * words[i].length() < maxLength) return maxLength;
        	for (int j = i + 1;j < l; j++) {
        		//没有相同的字母
        		if ((bitMap[i] & bitMap[j]) == 0) {
        			maxLength = Math.max(maxLength, words[i].length() * words[j].length());
        			break;
        		}
        	}
        }
        return maxLength;
    }
	
	public static void main(String[] args) {
		System.out.println(maxProduct(new String[] {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
	}
	
}
