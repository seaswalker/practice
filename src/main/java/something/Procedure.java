package something;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 来自csdn的面试题:对工序进行排序
 * 链接:
 * http://bbs.csdn.net/topics/391840259
 *
 * Created by skywalker on 2015/10/13.
 */
public class Procedure {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //行数
        int lines = Integer.parseInt(scanner.nextLine());
        //需要保持顺序
        Map<String, String> map = new LinkedHashMap<>();
        String[] line;
        String seed = null;
        for (int i = 0;i < lines;i ++) {
            line = scanner.nextLine().split(" ");
            if (i == 0) {
                seed = line[0];
            }
            map.put(line[0], line[1]);
        }
        order(map, seed, lines);
        scanner.close();
    }

    /**
     * 按照顺序输出
     * @param map
     * @param seed 第一行第一个工序
     * @param lines 行数
     */
    private static void order(Map<String, String> map, String seed, int lines) {
        String value;
        System.out.print(seed + " ");
        for (int i = 0;i < lines;i ++) {
            value = map.get(seed);
            System.out.print(value + " ");
            seed = value;
        }
    }

}
