package others;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * 一些不知道该取什么名字的，杂七杂八的测试
 */
public class Something {

    private int i = getJ();
    private int j = 10;

    public int getJ() {
        return j;
    }

    /**
     * 一个看似坑爹的问题--j = j ++并不会改变j的值
     */
    @Test
    public void j() {
        int j = 0;
        System.out.println(j);
        for(int i = 0;i < 100;i ++) {
            j = j ++;
        }
    }

    @Test
    public void order() {
        //0
        System.out.println(new Something().i);
    }

    /**
     * BigDecimal此类可以实现准确计算的原因是底层存储的是正数
     * 正式因为double构造器的不准确所以jdk推荐使用string构造器，如果实在是要使用double那么可以这样
     * new BigDecimal(Double.toString(100.91))
     * 另外是不可变对象，注意保存计算的结果
     */
    @Test
    public void t1() {
        BigDecimal a = new BigDecimal(100.91);
        BigDecimal b = new BigDecimal(5);
        //运行结果504.549999999999982946974341757595539093017578125
        //这是因为在计算机里面100.91是不能精确表示的
        System.out.println(a.multiply(b).toString());

        //但是可以这样
        a = new BigDecimal("100.91");
        //这个是精确的
        System.out.println(a.multiply(b).toString());
    }

}
