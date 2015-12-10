package spring.rmi.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.rmi.Business;

public class Client {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/rmi/client/beans.xml");
		Business business = (Business) context.getBean("businessService");
		System.out.println(business.echo("I am client"));
		context.close();
	}
	
}
