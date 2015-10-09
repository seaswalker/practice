package others;

/**
 *  小球掉落
 *  299.60938
	0.1953125
 * @author skywalker
 *
 */
public class Ball {
	
	//记录走过的长度
	private static double distances = 0;
	//记录反弹的次数
	private static int total = 1;

	public static void main(String[] args) {
		double height = drop(100, 10);
		System.out.println("第10次共经过了" + distances + "米，反弹" + height + "米高。");
	}
	
	/**
	 * 掉落一次
	 * @param height 初始高度
	 * @param count 次数
	 * @return 此次掉落弹起的高度
	 */
	public static double drop(double height, int count) {
			if(total == 1) {
				total ++;
				distances += height;
				return drop(height / 2,  count);
			}else {
				distances += height * 2;
				if(total ++ == count) {
					return height;
				}else {
					return drop(height / 2,  count);
				}
			}
			//System.out.println("第" + (total - 1) + "次，高度" + height + "米，走了" + distances + "米");
	}
	
}
