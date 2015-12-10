package spring.rmi;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 启动spring容器，发布rmi服务
 * @author skywalker
 *
 */
public class Server {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("spring/rmi/beans.xml");
		System.out.println("Spring RMI已启动");
	}
	
}
