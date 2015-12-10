package cxf;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 * 客户端的调用相较于原生的简单多了，实际上cxf只是原生API的封装
 * @author skywalker
 *
 */
public class Client {

	public static void main(String[] args) {
		JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
		factoryBean.setAddress("http://localhost:8080/business");
		factoryBean.setServiceClass(Business.class);
		Business business = (Business) factoryBean.create();
		System.out.println(business.echo("I am client"));
	}
	
}
