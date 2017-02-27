package leetcode;

import java.util.Arrays;

/**
 * 求两个矩形覆盖的面积
 * @author skywalker
 *
 */
public class RectangleArea {

	/**
	 * 注意第二个矩形不一定在第一个的右边 / 6ms
	 * @param (A, B) 第一个矩形的左下角的坐标
	 * @param (C, D) 第一个矩形右上角坐标
	 * @param (E, F) 第二个矩形的左下角的坐标
	 * @param (G, H) 第二个矩形的右上角的坐标
	 * @return
	 */
	private static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		//两个矩形的面积
		int areaF = (C - A) * (D - B);
		int areaS = (G - E) * (H - F);
		//两个矩形没有相交
		if (E > C || F > D || G < A || H < B) {
			return areaF + areaS;
		}
		//求交叉的面积
		//横纵坐标
		int[] xs = {A, C, E, G};
		int[] ys = {B, F, D, H};
		Arrays.sort(xs);
		Arrays.sort(ys);
		return areaF + areaS - (xs[2] - xs[1]) * (ys[2] - ys[1]);
	}
	
	public static void main(String[] args) {
		System.out.println(computeArea(-2, -2, 2, 2, 1, 1, 3, 3));
	}
	
}
