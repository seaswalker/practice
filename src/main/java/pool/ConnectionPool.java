package pool;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 连接池
 * @author skywalker
 *
 */
public class ConnectionPool {

	/**最大连接数**/
	private static final int MAXSIZE = 10;
	/**连接集合**/
	private static List<MyConnecton> cons = new ArrayList<MyConnecton>();
	
	/**
	 * 获取连接
	 */
	public static Connection getConnection() {
		for(MyConnecton connection : cons) {
			if(!connection.isBusy()) {
				connection.setBusy(true);
				connection.setUserdTime(new Date());
				return connection;
			}
		}
		//都被占用，如果没有达到最大连接数，new一个
		if(cons.size() < MAXSIZE) {
			MyConnecton con = new MyConnecton();
			con.setBusy(true);
			con.setUserdTime(new Date());
			cons.add(con);
			return con;
		}
		//都被占用且已经达到最大值，那么释放被使用了最长时间的那个
		return null;
	}
	
}
