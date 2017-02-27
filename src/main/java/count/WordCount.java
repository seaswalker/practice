package count;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 统计英文单词数目
 * @author skywalker
 *
 */
public class WordCount {
	
	public static void main(String[] args) {
		String content = "hello world fuck you"
				+ "cou hao";
		Pattern pattern = Pattern.compile("\\B\\w+\\B");
		Matcher matcher = pattern.matcher(content);
		int count = 0;
		while(matcher.find()) {
			count ++;
		}
		
		System.out.println("共有英文单词：" + count + "个。");
	}
	
}
