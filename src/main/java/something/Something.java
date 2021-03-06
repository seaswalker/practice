package something;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    
    @Test
    public void loop() {
    	int k = 0;
    	for (int i = 0;i < 10;i ++) {
    		k += --i;
    	}
    	System.out.println(k);
    }
    
    @Test
    public void hashMap() {
    	Map<String, String> map = new HashMap<String, String>();
    	map.put("A", "abc");
    	map.put("C", "CBD");
    	for (Entry<String, String> entry : map.entrySet()) {
    		System.out.println(entry.getKey());
    	}
    }
    
    /*
     * 提取出网络 公司 目标 市值 公司 
     * @see http://bbs.csdn.net/topics/391861568
     */
    @Test
    public void extract() {
    	String str = " 一/m 家/q 刚刚/d 成立/vi 两/m 年/qt 的/ude1 网络/n 支付/vn 公司/n ，/wd 它/rr 的/ude1 目标/n 是/vshi 成为/v 市值/n 100亿/m 美元/q 的/ude1 上市/vn 公司/n ";
    	Pattern pattern = Pattern.compile(" ([\u4e00-\u9fa5]+)/n");
    	Matcher matcher = pattern.matcher(str);
    	while (matcher.find()) {
    		System.out.print(matcher.group(1) + " ");
    	}
    }
  
}
