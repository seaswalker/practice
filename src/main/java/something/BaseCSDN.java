package something;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * 来自csdn的基础测试
 * 2015年5月28日 19:02:06
 * http://bbs.csdn.net/topics/390866437
 * @author skywalker
 *
 */
public class BaseCSDN {

	/**
	 * 数字转为16进制字符串
	 */
	@Test
	public void number2HexString() {
		//a
		System.out.println(Integer.toHexString(10));
	}
	
	/**
	 * 字节串转16进制字符串
	 */
	@Test
	public void bytes2HexString() {
		String str = "java";
		byte[] bytes = str.getBytes();
		//16进制字母
		char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
		StringBuilder sb = new StringBuilder();
		for(byte b : bytes) {
			sb.append(chars[(b & 0xf0) >> 4])
				.append(chars[b & 0x0f]);
		}
		System.out.println(sb.toString());
	}
	
	/**
	 * 打印出指定的小数位数
	 * 以及输出为指定维数的科学计数法
	 * C语言风格示例：
	 * %10.2f，意思是宽度为10，不足在前面补上空格,小数点精确到后2位，四舍五入
	 * 结果为：    100.55
	 */
	@Test
	public void floatWidth() {
		float f = 100.54674534f;
		/**
		 * JDK5加入的C语言风格格式化工具
		 * 命令必须以%开头
		 * 其实利用的是java.util.Formatter类
		 * 详见thingking in java 289页
		 */
		System.out.format("%10.2f\n", f);
		//科学计数法
		System.out.format("%.3e", f);
	}
	
	/**
	 * 12345678输出为12, 345, 678
	 */
	@Test
	public void numberLocale() {
		NumberFormat nf = DecimalFormat.getInstance(Locale.US);
		System.out.println(nf.format(12345678));
	}
	
	/**
	 * 字符串转为Boolean对象
	 */
	@Test
	public void str2Boolean() {
		//怎么实现的看一下文档或源码就懂了
		System.out.println(Boolean.parseBoolean("hello"));//false
	}
	
	/**
	 * 四字节和整数相互转换
	 */
	@Test
	public void fourbytes2Int() {
		byte[] bytes = "java".getBytes();
		//1784772193注意移位运算的优先级比加号低，加括号
		int result = (bytes[0] << 24) + (bytes[1] << 16) + (bytes[2] << 8) + bytes[3];
		System.out.println(result);
		
		//int==>> bytes
		byte b = (byte) ((result & 0xff000000) >> 24);
		StringBuilder sb = new StringBuilder();
		sb.append((char) b);
		b = (byte) ((result & 0x00ff0000) >> 16);
		sb.append((char) b);
		b = (byte) ((result & 0x0000ff00) >> 8);
		sb.append((char) b);
		b = (byte) (result & 0x000000ff);
		sb.append((char) b);
		System.out.println(sb.toString());//java
	}
	
	/**
	 * 如何获取指定日期所在的周从哪一天开始？
	 * 此题巨难
	 */
	@Test
	public void getFirstDayOfWeek() {
		//实践证明这个不能改变每周的开始
		//Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"), Locale.CHINA);
		Calendar calendar = Calendar.getInstance();
		/**
		 * 实践证明，这个也不能改变DAY_OF_WEEK的结果
		 * 实际上这个根本就不能改变，它这相当于一个对星期的编号，变不了
		 * System.out.println(calendar.getFirstDayOfWeek());返回的结果是2，还是Monday的编号
		 * 想要得到正确的星期编号，只能手动计算
		 */
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		//设为指定的日期,月份从0开始
		calendar.set(2015, (5 - 1), 29);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		/**
		 * 和本周第一天的差值，计算依据:
		 * 星期:                一      二      三      四      五      六      日
		 * 编号(DayOfWeek的值):  2   3  4  5   6  7  1
		 * 和所在周第一天的差值:     0   1  2  3   4  5  6
		 * ==>> 由此可得差值计算公式dif = (7 + (dayOfWeek - 2)) % 7
		 */
		int dif = (7 + (dayOfWeek - 2)) % 7;
		//计算所在周第一天的日期
		calendar.add(Calendar.DATE, (0 - dif));
		System.out.println((calendar.get(Calendar.MONTH) + 1) + "月" + calendar.get(Calendar.DATE) + "日");
	}
	
	/**
	 * 判断距离指定的时间还有多久
	 */
	@Test
	public void howLong() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2015 - 1900, 6, 6, 12, 40);
		/**
		 * 想到了两种方式：
		 * 1、逐字段作差
		 * 2、getTimeMills得到相差的毫秒，自己算
		 * 应该就只有这两种，没有更好的了
		 */
	}
	
	/**
	 * 如何知道两个时间段是否有重合的部分？
	 * 其实很简单
	 * 偷个懒，不用calendar了
	 */
	@Test
	@SuppressWarnings("deprecation")
	public void hasSame() {
		Date b1 = new Date(2015, 4, 23);
		Date e1 = new Date(2015, 5, 23);
		Date b2 = new Date(2015, 4, 29);
		Date e2 = new Date(2015, 6, 1);
		boolean hasSame = (b1.before(b2) && e1.after(b2)) || (b1.after(b2) && e2.after(e1));
		System.out.println(hasSame);
	}
	
	/**
	 * 合并两个数组，并且没有重复，想到几种方案
	 * 1、最简单粗暴的就是嵌套循环，不过时间复杂度为n * m，太高
	 * 2、稍微改进一下，对一个数组进行排序，遍历另一个数组，在这个排好序放入数组使用二分法查找重复值
	 * 3、比较另类的：
	 * 	转到两个set里面，你懂的
	 */
	
	/**
	 * 利用正则把前者转为后者
	 * 20150528 ==>> 2015-05-28
	 */
	@Test
	public void pattern() {
		Pattern pattern = Pattern.compile("^(\\d{4})(\\d{2})(\\d{2})$");
		String str = "20150528";
		Matcher matcher = pattern.matcher(str);
		StringBuilder sb = new StringBuilder();
		if(matcher.find()) {
			sb.append(matcher.group(1)).append("-")
				.append(matcher.group(2)).append("-")
				.append(matcher.group(3));
		}
		System.out.println(sb.toString());
	}
	
}
