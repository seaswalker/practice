package something;

import java.util.Arrays;

/**
 * 测试数组
 * @author skywalker
 *
 */
public class ArrayTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int[] a1 = new int[2];
		int[] a2 = new int[3];
		int[][] a3 = new int[2][3];
		String[] a4 = new String[4];
		System.out.println(a1.getClass().getCanonicalName());//int[]
		System.out.println(a1.getClass() == a2.getClass());//true
		
		System.out.println(Arrays.toString(a1));
		//因为基本类型不可以作为泛型的参数
		System.out.println(Arrays.asList(a2));//[[I@15db9742]
		System.out.println(Arrays.asList(a4));//可以实现
		System.out.println(a4);
		
		Object o1 = a1;
		//Object[] o2 = a1;编译不通过，因为int不是Object，但是为什么没有自动装箱
		Object o3 = a3;
		Object[] o4 = a3;
	}
	
}
