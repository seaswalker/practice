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
        int mask = 0;
        for (int i = 3; i>= 0; i--) {
            if (i != index) {
                mask |= 0xff;
                mask <<= (8 * i);
            }
        }
        System.out.println(mask);
        System.out.println(Integer.toBinaryString(mask));
        ori &= mask;
        ori |= (replacement << (8 * index));
        System.out.println(Integer.toHexString(ori));
    }

}
