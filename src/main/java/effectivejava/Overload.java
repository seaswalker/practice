package effectivejava;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 一个重载问题
 * @author skywalker
 *
 */
public class Overload {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		Set<Integer> set = new HashSet<Integer>();
		
		for(int i = -3;i < 3;i ++) {
			list.add(i);
			set.add(i);
		}
		
		for(int i = 0;i < 3;i ++) {
			set.remove(i);
			//list.remove(i);
			list.remove((Integer) i);
		}
		System.out.println(set + " " + list);
	}
	
}
