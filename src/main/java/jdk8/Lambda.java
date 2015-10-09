package jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * 测试lambda表达式
 * @author skywalker
 *
 */
public class Lambda {

	/**
	 * 迭代方式 forEach方法位于Iterable接口，源码如下： 
	 * default void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        for (T t : this) {
            action.accept(t);
        }
      	参数是一个Consumer类型，此接口是jdk1.8为支持Lambda表达式加入的
      	位于java.util.function包
    }
	 */
	@Test
	public void iterate() {
		String[] array = {"fuck", "tom", "jack", "jim"};
		List<String> players = Arrays.asList(array);
		//players.forEach(((player) -> System.out.print(player + " ")));
		/**
		 * 还可以使用双冒号操作符，不过这样就不能控制格式了
		 * ::是指对静态方法的调用，后面是方法名
		 */
		players.forEach(System.out::print);
	}
	
	/**
	 * 建立线程
	 */
	@SuppressWarnings("unused")
	@Test
	public void thread() {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("running");
			}
		});
		/**
		 * ==>> 等同于
		 * 这就是个语法糖，反编译后的代码：
		 * class Lambda$1
			  implements Runnable
			{
			  Lambda$1(Lambda paramLambda) {}
			  
			  public void run()
			  {
			    System.out.println("running");
			  }
			}
		 */
		t1 = new Thread(() -> System.out.println("running"));
		Runnable r = () -> System.out.println("running");
	}
	
	/**
	 * 排序
	 */
	@Test
	public void sort() {
		String[] array = {"fuck", "tom", "jack", "jim"};
		Arrays.sort(array, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		
		//Lambda
		Arrays.sort(array, (String s1, String s2) -> s1.compareTo(s2));
		/**
		 * 也可以写为:
		 * 反编译后的代码：
		 * class Lambda$2
			  implements Comparator<String>
			{
			  Lambda$2(Lambda paramLambda) {}
			  
			  public int compare(String o1, String o2)
			  {
			    return o1.compareTo(o2);
			  }
			}
		 */
		Comparator<String> comparator = (String s1, String s2) -> s1.compareTo(s2);
		Arrays.sort(array, comparator);
	}
	
	/**
	 * 集合操作
	 */
	@Test
	public void collection() {
		/**
		 * 我去，第一次见这么吊的写法
		 * 第一层大括号代表是ArrayList的子类
		 * 第一层是一个代码快，吊
		 * 反编译后的代码：
		 * class Lambda$3
			  extends ArrayList<Person>
			{
			  Lambda$3(Lambda paramLambda)
			  {
			    add(new Person("Addison", "Pam", "Java programmer", "female", 34, 1300));
			    ...省略
			  }
			}
		 */
		@SuppressWarnings("serial")
		List<Person> persons = new ArrayList<Person>() {
			{
				add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 43, 2000));  
			    add(new Person("Tamsen", "Brittany", "Java programmer", "female", 23, 1500));  
			    add(new Person("Floyd", "Donny", "Java programmer", "male", 33, 1800));  
			    add(new Person("Sindy", "Jonie", "Java programmer", "female", 32, 1600));  
			    add(new Person("Vere", "Hervey", "Java programmer", "male", 22, 1200));  
			    add(new Person("Maude", "Jaimie", "Java programmer", "female", 27, 1900));  
			    add(new Person("Shawn", "Randall", "Java programmer", "male", 30, 2300));  
			    add(new Person("Jayden", "Corrina", "Java programmer", "female", 35, 1700));  
			    add(new Person("Palmer", "Dene", "Java programmer", "male", 33, 2000));  
			    add(new Person("Addison", "Pam", "Java programmer", "female", 34, 1300));  
			}
		};
		//Lambda表达式其实可以提出来
		Consumer<Person> printer = (e) -> System.out.print(e.getFirstName() + " ");
		//persons.forEach(printer);
		
		/**
		 * 下面是一个比较复杂的集合操作的例子
		 * Predicate(谓词)==>>过滤器
		 * 第一个的结果是Tamsen Vere Maude Shawn，一看就明白了吧
		 * stream定义在Collection接口
		 * 其它方法定义在Stream接口
		 * 还可以并行处理：persons.parallelStream()代替stream()
		 */
		Predicate<Person> agePredicate = (e) -> e.getAge() < 32;
		Predicate<Person> salaryPredicate = (e) -> e.getSalary() > 200;
		persons.stream()
			.filter(salaryPredicate)
			.filter(agePredicate)
			.limit(10)
			.forEach(printer);
		
		//获得最大/最小值
		Person person = persons.stream()
			.max((e1, e2) -> (e1.getAge() - e2.getAge()))
			.get();
		System.out.println(person.getFirstName());
		
		/**
		 * 还可以直接把结果存入到集合中
		 * collect方法接收一个Collector(接口，java.util.stream包)参数
		 * 千万不要把Collectors看成Collections
		 */
		List<Person> list = persons.parallelStream()
			.filter(salaryPredicate)
			.collect(Collectors.toList());
		System.out.println(list.size());
		
		/**
		 * map方法
		 * 作用是抽取出对象的部分作为stream返回，你懂的
		 */
		Set<String> set = persons.stream()
				.map(p->p.getFirstName())
				.collect(Collectors.toSet());
		System.out.println(set.size());
	}
	
}
