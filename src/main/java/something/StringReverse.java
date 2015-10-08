package something;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import beanchmark.BenchMark;
import beanchmark.TimeBenchMark;

/**
 * 字符串逆序
 * 完全保留原有空格以及其顺序
 * @author skywalker
 *
 */
public class StringReverse {
	
	/**
	 * 耗时(每次50次):
	 * 3 5 3 4 4
	 * 平均：3.5ms
	 */
	@BenchMark(times = 50)
	public static void reverseString() {
		//String str = "hello  world ";//结果"olleh  dlrow "
		//String str = "hello world i am ";//结果"olleh dlrow i ma "
		//String str = "hello   world shit   ";//结果"olleh   dlrow tihs   "
		String str = "  hello world ";//结果"  olleh dlrow "
		List<Integer> pos = new ArrayList<Integer>();
		char[] array = str.toCharArray();
		for(int i = 0;i < array.length;i ++) {
			if(array[i] == ' '){
				pos.add(i);
			}
		}
		pos.add(array.length);
		//逆序
		for(int i = 0;i < pos.size();i ++) {
			reverse(array, (i == 0 ? 0 : pos.get(i - 1) + 1), pos.get(i));
		}
		System.out.print(new String(array));
	}
	
	/**
	 * 逆序字符序列
	 * @param begin end起始位置格式[begin, end)
	 */
	private static void reverse(char[] chars, int begin, int end) {
		if(end > begin) {
			char temp = 0;
			int length = (end - begin) / 2;
			for(int i = 0;i < length;i ++) {
				temp = chars[i + begin];
				chars[i + begin] = chars[end - 1 - i];
				chars[end - 1 - i] = temp;
			}
		}
	}
	
	/**
	 * 耗时：每次50此(毫秒)
	 * 15 13 18 13 12
	 * 平均：14ms
	 */
	@Test
	@BenchMark(times = 50)
	public void stack() {
		String str = "  hello world ";
		LinkedList<Character> stack = new LinkedList<Character>();
		char[] array = str.toCharArray();
		char c = 0;
		for(int i = 0;i < array.length;i ++) {
			c = array[i];
			if(c != ' ') {
				stack.push(c);
			}else {
				printStack(stack);
			}
		}
	}
	
	/**
	 * 打印栈
	 */
	private void printStack(LinkedList<Character> stack) {
		while(stack.peek() != null) {
			System.out.print(stack.pop());
		}
		System.out.print(' ');
	}
	
	/**
	 * 时间测试
	 */
	public static void main(String[] args) {
		TimeBenchMark.run(StringReverse.class);
	}
	
}
