package time;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

/**
 * JDK8 新的time API(java.time)
 * @author skywalker
 *
 */
public class JDK8 {

	/**
	 * 获取当前的日期(不含时间)
	 */
	@Test
	public void getDate() {
		LocalDate date = LocalDate.now();
		System.out.println(date);//2015-07-15
		//获取相应的年月日
		System.out.println("年:" + date.getYear());
		//这个的范围是1-12,比较好
		System.out.println("月:" + date.getMonthValue());
		System.out.println("日:" + date.getDayOfMonth());
	}
	
	/**
	 * 获取当前时间(不含日期)
	 */
	@Test
	public void getCurrentTime() {
		LocalTime time = LocalTime.now();
		//09:01:23.741
		System.out.println(time);
	}
	
	/**
	 * 获取指定时间的日期对象
	 * 一个很有用的工厂方法
	 */
	@Test
	public void getCustomDate() {
		LocalDate date = LocalDate.of(2012, 5, 25);
		System.out.println(date);
	}
	
	/**
	 * 检查重复事件,比如说生日
	 * 利用了MonthDay类,很有意思的类,还有YearMonth
	 */
	@Test
	public void check() {
		MonthDay birthDay = MonthDay.of(7, 15);
		MonthDay today = MonthDay.now();
		if (birthDay.equals(today)) {
			System.out.println("Happy Birthday");
		} else {
			System.out.println("Today isn't your birthday.");
		}
	}
	
	/**
	 * 修改小时数
	 * 新api都是不可变对象,所以返回的是一个新的对象,注意保存
	 */
	@Test
	public void modifyHour() {
		LocalTime time = LocalTime.now();
		LocalTime newTime = time.plusHours(2);
		System.out.println(newTime);
	}
	
	/**
	 * 修改日期,比如说获得一周后的日期
	 * 注意还是不可变对象
	 * 两种方式都可以,本代码是为了说明第二种方式
	 * chrono:计时
	 */
	@Test
	public void modifyWeek() {
		LocalDate tody = LocalDate.now();
		//LocalDate newDate = tody.plusWeeks(1);
		LocalDate newDate = tody.plus(1, ChronoUnit.WEEKS);
		System.out.println(newDate);
	}
	
	/**
	 * 新的时间api--Clock
	 */
	@Test
	public void clock() {
		Clock clock = Clock.systemUTC();
		System.out.println(clock.millis());
		System.out.println(System.currentTimeMillis());
	}
	
	/**
	 * 变换市时区
	 * 结果2015-07-15T09:35:02.369-07:00[America/Los_Angeles]
	 * 含义:重点在最后的-07:00意思是西7区,同理,正的就是东X区,不过洛杉矶是西8区,但是返回-7,原因是美国在3-11月是夏令时,早一个小时
	 */
	@Test
	public void transferZone() {
		LocalDateTime local = LocalDateTime.now();
		ZonedDateTime america = ZonedDateTime.of(local, ZoneId.of("America/Los_Angeles"));
		System.out.println(america);
	}
	
	/**
	 * 这下判断是否是闰年就简单了
	 */
	@Test
	public void isLeapYear() {
		LocalDate today = LocalDate.now();
		System.out.println(today.isLeapYear() ? "闰年" : "平年");
	}
	
	/**
	 * 判断两个日期之间有多少个月,日
	 */
	@Test
	public void period() {
		LocalDate start = LocalDate.of(2015, 7, 1);
		LocalDate end = LocalDate.of(2015, 7, 20);
		Period period = Period.between(start, end);
		System.out.println(period.getMonths() + "个月" + period.getDays() + "天");
	}
	
	/**
	 * 获取时间戳
	 * Instant类就是设计来替代Date的
	 * java.util.Date()在JDK*中加了两个方法Date.form(Instant)和Date.toInstant()
	 */
	@Test
	public void timestamp() {
		Instant instant = Instant.now();
		//2015-07-15T01:45:09.239Z
		System.out.println(instant);
	}
	
	/**
	 * 使用预定义格式格式化日期
	 * 以前喜闻乐见的SimpleDateFormat不是线程安全的,以后不要用了
	 */
	@Test
	public void parseBasic() {
		String str = "20150721";
		LocalDate date = LocalDate.parse(str, DateTimeFormatter.BASIC_ISO_DATE);
		System.out.println(date);
	}
	
	/**
	 * 使用自定义格式解析日期字符串
	 */
	@Test
	public void parseCustom() {
		String str = "21 07 2014";
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
			LocalDate date = LocalDate.parse(str, formatter);
			System.out.println(date);
		} catch (DateTimeParseException e) {
			System.out.println("您的格式有误");
		}
	}
	
	/**
	 * 使用自定义格式格式化为字符串
	 */
	@Test
	public void formatCustom() {
		LocalDateTime time = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 hh:mm");
		System.out.println(time.format(formatter));
	}
	
}
