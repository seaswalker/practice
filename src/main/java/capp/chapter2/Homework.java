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
     * 2.63.
     */
    @Test
    public void p63() {
        int bits = 4;
        Assert.assertEquals((-10 >> bits), sra(-10, bits));
        Assert.assertEquals((-10 >>> bits), sr1(-10, bits));
    }

    /**
     * 用逻辑右移实现算数右移.
     * <p>参考: https://segmentfault.com/q/1010000004895277</p>
     *
     * @param i 被移动的数字
     * @param k 右移的位
     * @return 结果
     */
    private int sra(int i, int k) {
        int t = (i >>> k);
        int mask = 1 << (32 - k - 1);
        return (t ^ mask) - mask;
    }

    /**
     * 用算数右移实现逻辑右移.思路:
     * 假设有负数(正数的算数右移和逻辑右移结果是相同的)的二进制表示为:
     * <p>1100 0011 0000，那么右移4位的结果为:</p>
     * <p>1111 1100 0011</p>
     * 我们只要取到原(移位之前)的符号位，即1100的1最高位1，然后
     * 将其左移1位与算数右移的结果相加即可.
     *
     * @see #sra(int, int)
     */
    private int sr1(int i, int k) {
        int t = i >> k;
        int mask = (1 << (32 - k - 1)) & t;
        return t + (mask << 1);
    }

    /**
     * 如果一个数字(原题为无符号数)里面任何偶数位为1，那么返回1，反之返回0.
     */
    @Test
    public void p64() {
        Assert.assertEquals(anyEvenOne(8), 0);
    }

    /**
     * @param i 正数
     * @see #p64()
     */
    private int anyEvenOne(int i) {
        return (i & 0x55555555) > 0 ? 1 : 0;
    }

    /**
     * 2.65，判断给定的无符号数中是否有偶数个1.
     */
    @Test
    public void p65() {
        Assert.assertTrue(evenOnes(12));
        Assert.assertTrue(!evenOnes(2));
    }

    /**
     * 如果有偶数个1，那么必定有偶数个0，那么最终各位异或的结果应该是0.
     *
     * @see #p65()
     */
    private boolean evenOnes(int i) {
        i ^= (i >>> 16);
        i ^= (i >>> 8);
        i ^= (i >>> 4);
        i ^= (i >>> 2);
        i ^= (i >>> 1);
        return ((i & 1) == 0);
    }

}
