package acm;

import beanchmark.BenchMark;
import beanchmark.TimeBenchMark;

/**
 * acm题目
 * Created by skywalker on 2015/10/10.
 */
public class Main {

    public static void main(String[] args) {
       /* Scanner in = new Scanner(System.in);
        int n;
        while (in.hasNextInt()) {
            n = in.nextInt();
            int[][] arr = new int[n][];
            int length = 0;
            for (int i = 0;i < n;i ++) {
                length = in.nextInt();
                arr[i] = new int[length + 1];
                arr[i][0] = length;
                for (int j = 1;j <= length;j ++) {
                    arr[i][j] = in.nextInt();
                }
            }
            cal(arr);
        }*/
        TimeBenchMark.run(Main.class);
    }

    @BenchMark(times = 50)
    public void test() {
        int[][] data = new int[1][];
        data[0] = new int[] {7, 0, 6, -1, 1, -6, 7, -5};
        cal(data);
    }

    private void cal(int[][] data) {
        int[] temp;
        for (int i = 0, l = data.length; i < l; i++) {
            temp = data[i];
            int max = temp[1], start = 1, end = 1;
            for (int j = 1, s = temp.length; j < s; j++) {
                for (int x = j + 1, y = temp.length; x < y; x++) {
                    if (temp[x] > 0) {
                        int b = j, e = x, result = 0;
                        while (b <= e) {
                            result += temp[b];
                            b++;
                        }
                        if (result > max) {
                            max = result;
                            start = j;
                            end = e;
                        }
                    }
                }
            }
            System.out.println("Case " + (i + 1) + ":");
            System.out.println(max + " " + start + " " + end);
            if (i < l - 1) {
                System.out.println();
            }
        }
    }
}
