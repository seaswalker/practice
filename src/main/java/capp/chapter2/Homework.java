package capp.chapter2;

import org.junit.Assert;
import org.junit.Test;

/**
 * 第二章家庭作业.
 *
 * @author skywalker
 */
public class Homework {

    /**
     * 判断机器的大小端.
     */
    @Test
    public void isLittleEndian() {
        boolean isLittile = (1 & 0xff) == 1;
        System.out.println(isLittile ? "小端" : "大端");
    }

    /**
     * 2.59.
     */
    @Test
    public void p59() {
        int x = 0x89ABCDEF, y = 0x76543210, result = 0;
        boolean found = false;
        for (int i = 0; i < 4; i++) {
            int offset = (8 * i);
            int b = (x >> offset) & 0xff;
            //无效字节
            if (found || b == 0) {
                result |= (((y >> offset) & 0xff) << offset);
            } else {
                result |= (b << offset);
                found = true;
            }
        }
        Assert.assertTrue(Integer.toHexString(result).equals("765432ef"));
    }

    /**
     * 2.60.
     */
    @Test
    public void p60() {
        int ori = 0x12345678;
        int replacement = 0xAB;
        int index = 2;
        //以替换第二个字节为例
        int result = 0;
        for (int i = 0; i < 4; i++) {
            int offset = (8 * i);
            if (i == index) {
                result |= (replacement << offset);
            } else {
                int b = (ori >> offset) & 0xff;
                result |= (b << offset);
            }
        }
        System.out.println(Integer.toHexString(result));
    }

    /**
     * 2.62.
     * <p>
     * 右移一个负数，如果得到正数，便是逻辑右移.
     */
    @Test
    public void p62() {
        boolean isLogic = (Integer.MIN_VALUE >>> 8) > 0;
        System.out.println(isLogic ? "逻辑右移" : "算数右移");
    }

    /**
     * 用逻辑右移实现算数右移.
     *
     * @param i 被移动的数字
     * @param k 右移的位
     * @return 结果
     */
    private int sra(int i, int k) {
        int t = (i >>> k);
        if (i < 0) {
            
        }
        return t;
    }

}
