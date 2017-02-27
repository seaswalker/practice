package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BullsandCows {
	
	/**
	 * 更好的算法(O(n))
	 * 5ms
	 * @see https://leetcode.com/discuss/67031/one-pass-java-solution
	 */
	private static String better(String secret, String guess) {
		int bulls = 0, cows = 0;
		//记录secret中和guess中出现的次数
		int[] nums = new int[10];
		int si, gi;
		for (int i = 0, l = secret.length();i < l; ++i) {
			si = secret.charAt(i) - '0';
			gi = guess.charAt(i) - '0';
			if (si == gi) {
				++bulls;
			} else {
				if (nums[si] < 0) {
					++cows;
				}
				if (nums[gi] > 0) {
					++cows;
				}
				++nums[si];
				--nums[gi];
			}
		}
		return bulls + "A" + cows + "B";
	}

	/**
	 * 返回提示/20ms, 时间复杂度约为O(n2)
	 * 注意这个测试，输入1234, 0111 ==>> 0A1B而不是0A3B
	 * @param secret 
	 * @param guess 可以保证guess仅含数字并且位数是一样的
	 * @return
	 */
	@SuppressWarnings("unused")
	private static String getHint(String secret, String guess) {
		int bulls = 0, cows = 0, length = secret.length(), index;
		List<Character> secretList = new ArrayList<Character>(length);
		List<Character> guessList = new ArrayList<Character>(length);
		char sc, gc;
		for (int i = 0;i < length; ++i) {
			sc = secret.charAt(i);
			gc = guess.charAt(i);
			if (gc == sc) {
				++bulls;
			} else {
				secretList.add(sc);
				guessList.add(gc);
			}
		}
		//寻找cows
		for (int i = 0, s = secretList.size();i < s; ++i) {
			index = secretList.indexOf(guessList.get(i));
			if (index != -1) {
				++cows;
				guessList.set(i, null);
				secretList.set(index, null);
			}
		}
		return bulls + "A" + cows + "B";
	}
	
	public static void main(String[] args) {
		System.out.println(better("1234", "0111"));
	}
	
}
