package spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class BFPP implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory factory)
			throws BeansException {
		System.out.println("postProcessBeanFactory接口被调用");
		BeanDefinition bean = factory.getBeanDefinition("MyBean");
		//拿到这个bean的所有属性
		MutablePropertyValues pv =  bean.getPropertyValues();
		if(pv.contains("name")) {
			pv.addPropertyValue("name", "被修改了");
		}
	}

}
