package others;

/**
 * 99乘法表
 * @author skywalker
 *
 */
public class Nine_Nine {

	public static void main(String[] args) {
		StringBuilder result = new StringBuilder();
		for(int i = 1;i <= 9;i ++) {
			for(int j = 1;j <= i;j ++) {
				result.append(j).append(" X ").append(i).append(" = ").append(j * i).append(" ");
			}
			result.append("\r\n");
		}
		System.out.println(result.toString());
	}

    /**
     * 使用一个for循环实现
     */
    @Test
    public void one() {
        for (int i = 1, j = 1;j < 10;i ++) {
            System.out.print(i + " X " + j + " = " + (i * j) + " ");
            if (i == j) {
                ++ j;
                i = 0;
                System.out.println();
            }
        }
    }

}
