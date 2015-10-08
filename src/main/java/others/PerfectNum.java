package others;

/**
 * 寻找完数
 * 指自身等于除自身之外的因子之和
 * @author skywalker
 *
 */
public class PerfectNum {

	public static void main(String[] args) {
		
		long beginTtime = System.nanoTime();
		
		int begin = 1;
		int end = 30;
		StringBuilder result = new StringBuilder("结果如下:\r\n");
		for(int i = begin; i <= end;i ++) {
			testNum(i, result);
		}
		
		long enTime = System.nanoTime();
		
		System.out.println(result.toString());
		System.out.println("花费时间:" + (enTime - beginTtime) + "纳秒");
	}
	
	/**
	 * 测试是否是完数
	 * 如果是返回其结果字符串
	 * 如：28 = 1 + 2 + 4 + 7 + 14
	 */
	private static void testNum(int num, StringBuilder result) {
		int sum = 1;
		//拼揍算式
		StringBuilder sb = new StringBuilder(String.valueOf(num));
		sb.append(" = 1 +");
		for(int i = 2;i <= num / 2;i ++) {
			if(num % i == 0) {
				sum += i;
				sb.append(" ").append(i).append(" +");
			}
		}
		if(sum == num) {
			result.append(sb.deleteCharAt(sb.length() - 1)).append("\r\n");
		}
	}
	
}
