package effectivejava;

import java.util.Arrays;
import java.util.List;

/**
 * 扯淡for循环
 * @author skywalker
 *
 */
public class ForLoop {

	enum Faces {One, Two, Three, Four, Five, Six}
	
	public static void main(String[] args) {
		List<Faces> facesA = Arrays.asList(Faces.values());
		List<Faces> facesB = Arrays.asList(Faces.values());
		
		/*for(Iterator<Faces> i = facesA.iterator();i.hasNext();) {
			for(Iterator<Faces> j = facesB.iterator();j.hasNext();) {
				System.out.println(i.next() + " " + j.next());
			}
		}*/
		
		for(Faces i : facesA) {
			for(Faces j : facesB) {
				System.out.println(i + " " + j);
			}
		}
	}
	
}
