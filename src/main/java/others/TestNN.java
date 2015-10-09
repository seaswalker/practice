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
	 * 鍒嗗埆链変粈涔堥敊
	 * 
	 * answer: 绗竴涓湁阌欙紝s + 1镞?鏄酸nt
	 * 楠岃瘉:
	 * 鐚沧祴鏄纭殑锛屽苟涓攕 = s + (short) 1;涔熸槸阌欑殑锛屽洜涓鸿繍绠楁椂鐢╥nt绠楃殑
	 */
	public void two() {
		short s = 1;
		//s = s + (short) 1;
		s += 1;
		System.out.println(s);
	}
	
	/**
	 * 鏉ヨ嚜浜庨樋閲屽反宸?
	 * 璁捐涓€涓渶浼樼畻娉曟潵镆ユ垒涓€n涓厓绱犳暟缁勪腑镄勬渶澶у€煎拰链€灏忓€笺€傚凡鐭ヤ竴绉嶉渶瑕佹瘮杈?n娆＄殑鏂规硶锛岃缁欎竴涓洿浼樼殑绠楁硶銆傛儏鐗瑰埆娉ㄦ剰浼桦寲镞堕棿澶嶆潅搴︾殑甯告暟銆?
	 * 绛旀:鎶婃暟缁勪袱涓や竴瀵瑰垎缁勶紝濡傛灉鏁扮粍鍏幂礌涓暟涓哄鏁帮紝灏辨渶鍚庡崟镫垎涓€涓紝铹跺悗鍒嗗埆瀵规疮涓€缁勭殑涓や釜鏁版瘮
	 * 杈冿紝鎶婂皬镄勬斁鍦ㄥ乏杈癸紝澶х殑鏀惧湪鍙宠竟锛岃繖镙烽亶铡嗕笅鏉ワ紝镐诲叡姣旇缉镄勬鏁版槸 N/2 娆★绂鍦ㄥ墠闱㈠垎缁勭殑鍩虹涓?
	 * 闾ｄ箞鍙互寰楀埌缁撹锛屾渶灏忓€间竴瀹氩湪姣忎竴缁勭殑宸﹁竟閮ㄥ垎镓撅紝链€澶у€间竴瀹氩湪鏁扮粍镄勫彸杈归儴鍒嗘垒锛屾渶澶у€煎拰链€灏忓€肩殑镆ユ垒鍒嗗埆闇€瑕佹瘮杈僋/2 娆″拰N/2 娆★绂
	 * 杩欐牱灏卞彲浠ユ垒鍒版渶澶у€煎拰链€灏忓€间简锛屾瘮杈幂殑娆℃暟涓?
	 * N/2 * 3 = (3N)/2 娆?
	 * 锲剧ず:three.png
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
	 * 鍒汉镄勫啓娉曪紝濂藉睂锛屾湁镣瑰儚璐ｄ换阈?
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
	 * 鍗栭浮镄勯棶棰桡紝瑙ｇ瓟鍦ㄦ垜镄勬枃搴撶殑鏀惰棌
	 */
	
	//9涓偣10鏉＄嚎镄勯棶棰桡紝瑙?镣?0鐩寸嚎.jpg
	
}
