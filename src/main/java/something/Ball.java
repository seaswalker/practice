package something;

public class Ball {

	public static void main(String[] args) {
		double sum = 0, height = 100;
		for (int i = 0;i < 10; ++i) {
			sum += height;
			height /= 2;
			sum += height;
		}
		sum -= height;
		System.out.println("共经过:" + sum);
		System.out.println("第10此弹起:" + height);
	}
	
}
