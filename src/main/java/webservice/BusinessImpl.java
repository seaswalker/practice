package webservice;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * 可以参考此篇文章:
 * @see http://www.2cto.com/kf/201204/129138.html
 * @author skywalker
 *
 */
@WebService
public class BusinessImpl implements Business {

	@Override
	public String echo(String message) {
		return "From webservice: " + message;
	}
	
	//发布
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/test", new BusinessImpl());
	}
	
}
