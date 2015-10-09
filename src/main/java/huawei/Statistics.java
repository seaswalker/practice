package huawei;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 统计
 * @author skywalker
 *
 */
public class Statistics {
	
	private static final String INPATH = "C:/Users/xsdwe_000/Desktop/in.txt";
	private static final String OUTPATH = "C:/Users/xsdwe_000/Desktop/out.txt";
	/**所有员工**/
	private static Map<Integer, Person> persons = new HashMap<Integer, Person>();

	/**
	 * 59毫秒
	 */
	public static void main(String[] args) {
		read();
		write();
	}
	
	/**
	 * 读取数据
	 */
	private static void read() {
		BufferedReader br = null;
		//统计记录的数量，应在1-50之间
		int count = 0;
		try {
			File in = new File(INPATH);
			//解决中文乱码
			br = new BufferedReader(new InputStreamReader(new FileInputStream(in), "UTF-8"));
			String temp = null;
			Person person = null;
			int id = 0;
			while((temp = br.readLine()) != null) {
				if(!StringUtil.isEmpty(temp)) {
					String[] result = temp.split(",");
					//员工的名字不得超过10
					if(result[1].length() > 10) {
						System.out.println("员工名字最长为10个英文字符!");
						return;
					}
					id = Integer.parseInt(result[0]);
					//id在1-1000之间
					if(id < 1 || id > 1000) {
						System.out.println("ID的范围是1~1000");
						return;
					}
					person = persons.get(id);
					if(person == null) {
						person = new Person(id, result[1]);
						person.getTimes().add(result[2]);
						persons.put(id, person);
					}else {
						//每个员工最多有5条记录
						if(person.getTimes().size() >= 5) {
							System.out.println("每个员工最多可能有5条记录");
							return;
						}
						person.getTimes().add(result[2]);
					}
					count ++;
				}
			}
			if(count == 0) {
				System.out.println("最少有一条记录！");
			}else if(count > 50) {
				System.out.println("最多有50条记录！");
			}else if(persons.size() > 10) {
				//最多有10个员工的记录
				System.out.println("最多有10个员工的刷卡记录!");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 输出统计结果
	 */
	private static void write() {
		File file = new File(OUTPATH);
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
			//转化为TreeMap实现按照key进行排序
			TreeMap<Integer, Person> sortedPersons = new TreeMap<Integer, Person>(persons);
			StringBuilder result = new StringBuilder();
			//统计个数，最后一个额外追加换行
			int count = 0;
			for(Integer key : sortedPersons.keySet()) {
				Person person = persons.get(key);
				person.calculate();
				//ID = 5
				result.append("ID = ").append(person.getId()).append("\r\n");
				//NAME = skywalker
				result.append("NAME = ").append(person.getUsername()).append("\r\n");
				//TYPE = WORK LATE
				result.append("TYPE = ").append(person.getType()).append("\r\n");
				//CHECK IN = 09:15 CHECK OUT = 19:15
				result.append("CHECK IN = ").append(person.getCheckIN()).append("\r\n")
				.append("CHECK OUT = ").append(person.getCheckOUT()).append("\r\n");
				//WORK TIME = 10H0M
				result.append("WORK TIME = ").append(person.getWorkTime());
				count ++;
				if(count != sortedPersons.size()) {
					result.append("\r\n").append("\r\n");
				}
			}
			bw.write(result.toString());
			bw.flush();
			System.out.println("保存成功！");
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}finally {
			if(bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
