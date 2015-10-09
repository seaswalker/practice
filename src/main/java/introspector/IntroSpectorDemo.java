package introspector;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

/**
 * java内省机制
 * @author skywalker
 *
 */
public class IntroSpectorDemo {
	
	public static void main(String[] args) throws Exception {
		Entity entity = new Entity(3, "小明");
		complex(entity, "name");
		simple(entity, "id");
		beanUtils(entity, "id");
	}

	/**
	 * 复杂内省
	 * @param property属性名称
	 */
	private static void complex(Object obj, String property) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		BeanInfo info = Introspector.getBeanInfo(Entity.class);
		PropertyDescriptor[] propertyDescriptors = info.getPropertyDescriptors();
		for(PropertyDescriptor pd : propertyDescriptors) {
			if(pd.getName().equals(property)) {
				Method method = pd.getReadMethod();
				System.out.println(method.invoke(obj, new Object[] {}));
			}
		}
	}
	
	/**
	 * 简单内省
	 */
	private static void simple(Object obj, String property) throws Exception {
		PropertyDescriptor pd = new PropertyDescriptor(property, Entity.class);
		Method method = pd.getReadMethod();
		//第二个参数null也可以，不过有一个编译警告
		System.out.println(method.invoke(obj, new Object[] {}));
	}
	
	/**
	 * 使用beanutils
	 * 有一个很大的问题，它只能处理public的类
	 * 其它的set属性以及把全部属性映射为map之类的到时候看吧
	 * 另外字段名称支持这样person.name，一层一层的找，叫做属性链?
	 */
	private static void beanUtils(Object obj, String property) throws Exception {
		//如果字段真正的类型是int，那么第一个返回Integer,第二个String，注意
		System.out.println(PropertyUtils.getProperty(obj, property).getClass().getCanonicalName());
		System.out.println(BeanUtils.getProperty(obj, property).getClass().getCanonicalName());
	}
	
}

