package others;

import java.util.LinkedList;

import org.junit.Test;

/**
 * 浠嶫ava鍚х湅鍒扮殑棰?
 * http://tieba.baidu.com/p/3959898468
 * @author skywalker
 *
 */
public class TestNN {

	/**
	 * 绗簩棰?
	 * short s = 1;
	 * s = s + 1;
	 * 鍜?
	 * short s = 1;
	 * s += 1;
	 * 鍒嗗埆鏈変粈涔堥敊
	 * 
	 * answer: 绗竴涓湁閿欙紝s + 1鏃?鏄痠nt
	 * 楠岃瘉:
	 * 鐚滄祴鏄纭殑锛屽苟涓攕 = s + (short) 1;涔熸槸閿欑殑锛屽洜涓鸿繍绠楁椂鐢╥nt绠楃殑
	 */
	public void two() {
		short s = 1;
		//s = s + (short) 1;
		s += 1;
		System.out.println(s);
	}
	
	/**
	 * 鏉ヨ嚜浜庨樋閲屽反宸?
	 * 璁捐涓€涓渶浼樼畻娉曟潵鏌ユ壘涓€n涓厓绱犳暟缁勪腑鐨勬渶澶у€煎拰鏈€灏忓€笺€傚凡鐭ヤ竴绉嶉渶瑕佹瘮杈?n娆＄殑鏂规硶锛岃缁欎竴涓洿浼樼殑绠楁硶銆傛儏鐗瑰埆娉ㄦ剰浼樺寲鏃堕棿澶嶆潅搴︾殑甯告暟銆?
	 * 绛旀:鎶婃暟缁勪袱涓や竴瀵瑰垎缁勶紝濡傛灉鏁扮粍鍏冪礌涓暟涓哄鏁帮紝灏辨渶鍚庡崟鐙垎涓€涓紝鐒跺悗鍒嗗埆瀵规瘡涓€缁勭殑涓や釜鏁版瘮
	 * 杈冿紝鎶婂皬鐨勬斁鍦ㄥ乏杈癸紝澶х殑鏀惧湪鍙宠竟锛岃繖鏍烽亶鍘嗕笅鏉ワ紝鎬诲叡姣旇緝鐨勬鏁版槸 N/2 娆★紱鍦ㄥ墠闈㈠垎缁勭殑鍩虹涓?
	 * 閭ｄ箞鍙互寰楀埌缁撹锛屾渶灏忓€间竴瀹氬湪姣忎竴缁勭殑宸﹁竟閮ㄥ垎鎵撅紝鏈€澶у€间竴瀹氬湪鏁扮粍鐨勫彸杈归儴鍒嗘壘锛屾渶澶у€煎拰鏈€灏忓€肩殑鏌ユ壘鍒嗗埆闇€瑕佹瘮杈僋/2 娆″拰N/2 娆★紱
	 * 杩欐牱灏卞彲浠ユ壘鍒版渶澶у€煎拰鏈€灏忓€间簡锛屾瘮杈冪殑娆℃暟涓?
	 * N/2 * 3 = (3N)/2 娆?
	 * 鍥剧ず:three.png
	 */
	
	/**
	 * 棰樼洰瑙佺綉椤?
	 */
	@Test
	public void four() {
		fourUtil(new LinkedList<Integer>(), 1234);
	}
	
	private void fourUtil(LinkedList<Integer> stack, int seed) {
		System.out.print(seed + " ");
		stack.push(seed);
		if (seed > 5000) {
			printStack(stack);
		} else {
			fourUtil(stack, seed << 1);
		}
	}
	
	private <E> void printStack(LinkedList<E> stack) {
		if (stack != null) {
			for (E e : stack) {
				System.out.print(e + " ");
			}
		}
	}
	
	/**
	 * 鍒汉鐨勫啓娉曪紝濂藉睂锛屾湁鐐瑰儚璐ｄ换閾?
	 */
	@Test
	public void fourOther() {
		fourOtherUtil(1234);
	}
	
	private void fourOtherUtil(int n) {
		System.out.print(n + " ");
		if (n < 5000) {
			fourOtherUtil(n << 1);
		}
		System.out.print(n + " ");
	}
	
	/**
	 * 鍗栭浮鐨勯棶棰橈紝瑙ｇ瓟鍦ㄦ垜鐨勬枃搴撶殑鏀惰棌
	 */
	
	//9涓偣10鏉＄嚎鐨勯棶棰橈紝瑙?鐐?0鐩寸嚎.jpg
	
}
