package others;

import java.util.Calendar;

/**
 * 计算日期
 * @author skywalker
 *
 */
public class CountCalendar {
	
	public static void main(String[] args) {
		/*System.out.println("请输入年月日，以空格分开：");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		//分割输入数据
		try {
			String []data = input.split(" ");
			int year = Integer.parseInt(data[0]);
			int month = Integer.parseInt(data[1]);
			int day = Integer.parseInt(data[2]);
			//计算总天数
			int days = 0;
			for(int i = 0;i < month;i ++) {
				//如果是二月并且是闰年
				if(i == 1 && isLeapYear(year)) {
					days += 29;
					monthDays[1] = 29;
					continue;
				}
				//当前月加当前的日期
				if(i == month - 1) {
					days += day;
					break;
				}
				days += monthDays[i];
			}
			System.out.println("总天数为 : " + days);
			//计算第几周
			System.out.println("第" + ((days + 7 - 1) / 7) + "周");
		}catch(Exception e) {
			System.out.println("您输入的数据有误");
		}finally {
			in.close();
		}*/
		
		Calendar c = Calendar.getInstance();
		c.set(2010, 2-1, 20); //月份从0开始
		System.out.println("第" + c.get(Calendar.DAY_OF_YEAR) + "天，第" + c.get(Calendar.WEEK_OF_YEAR)+"周");
		
	}
	
}
