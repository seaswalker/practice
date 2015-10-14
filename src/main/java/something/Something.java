package something;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 一些不知道该叫什么的测试
 * Created by skywalker on 2015/10/14.
 */
public class Something {

    private static <T, S extends T> S foo(T t, S s) {
        return s;
    }

    public static void main(String[] args) {
        foo(1.0D, "string");
    }

     /**
     * 打印出所有1000以内的回文数字
     * 此题的关键在于得到倒过来的数字，有一种比较笨的方式，就是专为字符串然后使用reverse()，下面是一种较为高明的方式
     */
    @Test
    public void moslems() {
        //倒过来的数字
        int num, temp;
        for (int i = 1;i < 1000;i ++) {
            temp = i;
            num = 0;
            while (temp > 0) {
                num = num * 10 + temp % 10;
                temp /= 10;
            }
            if (i == num) {
                System.out.print(i + " ");
            }
        }
    }

    /**
     * 50人围城一个圈，数到3或3的个数时移除，最后剩下的是谁，原来的位置是什么
     */
    @Test
    public void cycle() {
        //初始化
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1;i < 51;i ++) {
            list.add(i);
        }
        //计算,-1的原因是链表从0开始
        int index = -1;
        while (list.size() > 1) {
            index = (index + 3) % list.size();
            //这个地方注意减一，因为移除了一个元素
            list.remove(index --);
        }
        //11
        System.out.println("最后的人在:" + list.get(0));
    }

    /**
     * 插入排序
     */
    @Test
    public void insertSort() {
        int[] arr = {3, -1, 0, -8, 2, 1};
        int temp, position;
        for (int i = 1, l = arr.length;i < l;i ++) {
            position = i;
            for (int j = i - 1;j >= 0;j --) {
                if (arr[j] > arr[position]) {
                    //交换
                    temp = arr[j];
                    arr[j] = arr[position];
                    arr[position] = temp;
                    -- position;
                } else {
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}
