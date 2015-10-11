package others;

import org.junit.Test;

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

}
