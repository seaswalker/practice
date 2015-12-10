package cxf;

import javax.jws.WebService;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;


/**
 * CXF
 * @author skywalker
 *
 */
@WebService(serviceName = "Business", endpointInterface = "cxf.Business")
public class BusinessImpl implements Business {

	@Override
	public String echo(String message) {
		return "From webservice: " + message;
	}
	
	//发布
	public static void main(String[] args) {
		Business service = new BusinessImpl();
		JaxWsServerFactoryBean factoryBean = new JaxWsServerFactoryBean();
		factoryBean.setServiceClass(Business.class);
		factoryBean.setAddress("http://localhost:8080/business");
		factoryBean.setServiceBean(service);
		factoryBean.create();
	}
	
}
