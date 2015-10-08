package rxjava;

import org.junit.Test;

import rx.Observable;
import rx.Subscriber;

public class Demo1 {

	/**
	 * 创建被观察者对象
	 */
	public static Observable<String> createObservable() {
		Observable<String> observable = Observable.create(
				new Observable.OnSubscribe<String>() {
					@Override
					public void call(Subscriber<? super String> sub) {
						sub.onNext("Hello Subscriber");
						sub.onCompleted();
					}
				});
		//等同于直接使用Lambda
		/*Observable.create(sub -> {
			sub.onNext("Hello Subscriber");
			sub.onCompleted();
		});*/
		return observable;
	}
	
	/**
	 * 创建订阅者
	 */
	public static Subscriber<String> createSubscriber() {
		Subscriber<String> subscriber = new Subscriber<String>() {
			@Override
			public void onCompleted() {
				System.out.println("subscriber completes");
			}

			@Override
			public void onError(Throwable e) {
				System.out.println("subscriber encounters a error");
			}

			@Override
			public void onNext(String t) {
				System.out.println(t);
			}
		};
		return subscriber;
	}
	
	/**
	 * 简单的创建被观察者的方法
	 * subscribe方法可以接受三个参数，第一个对应OnNext()函数，第二个对应OnError()，第三个对应OnComplete()
	 * 是一个Action1(这名字实在是蛋疼)类型,是一个函数接口，只有一个void call(T t)方法
	 * t就是Obserable传来的参数
	 */
	@Test
	public void simple() {
		//结果:Hello Subscriber, from simple
		Observable.just("Hello Subscriber, from simple")
				.subscribe(t -> System.out.println(t));
	}
	
	/**
	 * 可以在中间使用类似java Stream那样的API变换Obserable发出的值
	 */
	@Test
	public void change() {
		Observable.just("Hello Subscriber, from change")
			.map(t -> "changed")
			.subscribe(System.out::println);
	}
	
	public static void main(String[] args) {
		Observable<String> observable = createObservable();
		Subscriber<String> subscriber = createSubscriber();
		/**
		 * 执行结果
		 * Hello Subscriber
		 * subscriber completes
		 */
		observable.subscribe(subscriber);
	}
	
}
