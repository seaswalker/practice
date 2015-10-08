package huawei;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 一个员工及其所有刷卡记录
 * @author skywalker
 *
 */
public class Person {

	private int id;
	private String username;
	/**刷卡的时间**/
	private List<String> times = new ArrayList<String>();
	/**考勤类型**/
	private Type type;
	/**上班事件**/
	private String checkIN;
	/**下班事件**/
	private String checkOUT;
	/**工作时长**/
	private String workTime;
	
	public Person(int id, String username) {
		this.id = id;
		this.username = username;
	}
	
	public Person(){};
	
	/**
	 * 计算相关数据
	 * @throws ParseException 
	 */
	public void calculate() throws ParseException {
		//刷卡时间排序
		Collections.sort(times);
		if(times.size() < 2) {
			//只有一次刷卡记录，刷卡异常
			type = Type.PUNCHABNORMAL;
			//工时为0
			workTime = "0";
			checkIN = times.get(0);
		}else {
			DateFormat df = new SimpleDateFormat("HH:mm");
			//第一个(最早的)刷卡记录
			String firstStr = times.get(0);
			Date first = df.parse(firstStr);
			//最后一个(最晚的)刷卡记录
			String lastStr = times.get(times.size() - 1);
			Date last = df.parse(lastStr);
			//上午的时间
			Date monring = df.parse("08:00");
			//下午的时间
			Date evening = df.parse("17:30");
			//正常
			if(first.compareTo(monring) < 0 && last.compareTo(evening) > 0) {
				type = Type.NORMAL;
				workTime = getSpace(first, last);
			}else if(first.compareTo(evening) >= 0 || last.compareTo(monring) <= 0) {
				//旷工
				type = Type.ABSENT;
				workTime = "0";
			}else if(first.compareTo(monring) >= 0 && last.compareTo(evening) > 0) {
				//迟到
				type = Type.WORKLATE;
				workTime = getSpace(first, last);
			}else if(first.compareTo(monring) < 0 && last.compareTo(evening) <= 0) {
				//早退
				type = Type.LEAVEEARLY;
				workTime = getSpace(first, last);
			}else if(first.compareTo(monring) >= 0 && last.compareTo(evening) <= 0) {
				//迟到同时早退
				type = Type.WORKLATEANDLEAVEEARLY;
				workTime = getSpace(first, last);
			}
			checkIN = firstStr;
			checkOUT = lastStr;
		}
	}
	
	/**
	 * 计算两个给定时间的间隔(一天之内)
	 */
	public String getSpace(Date first, Date last) {
		long mms = last.getTime() - first.getTime();
		long minutes = mms / (1000 * 60);
		long hours = minutes / 60;
		//减去小时的分钟数
		long leftMinutes = minutes - hours * 60;
		//小时和分钟格式化成二位数显示
		DecimalFormat df = new DecimalFormat("00");
		return df.format(hours) + ":" + df.format(leftMinutes);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<String> getTimes() {
		return times;
	}
	public void setTimes(List<String> times) {
		this.times = times;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public String getCheckIN() {
		return checkIN;
	}
	public void setCheckIN(String checkIN) {
		this.checkIN = checkIN;
	}
	public String getCheckOUT() {
		return checkOUT;
	}
	public void setCheckOUT(String checkOUT) {
		this.checkOUT = checkOUT;
	}
	public String getWorkTime() {
		return workTime;
	}
	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}
	
}
