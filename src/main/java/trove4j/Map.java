package trove4j;

import gnu.trove.map.hash.TLongObjectHashMap;

import java.util.HashMap;

/**
 * 测试原生类型Map
 * Created by skywalker on 2016/8/13.
 */
public class Map {

    private static HashMap<Long, Object> map;
    private static TLongObjectHashMap tmap;

    //26毫秒
    /*public static void main(String[] args) {
        initHashMap();
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 100; i++)
            testHashMap();
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }*/

    public static void main(String[] args) {
        initTMap();
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 100; i++)
            testTMap();
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }

    /**
     * 初始化HashMap
     */
    private static void initHashMap() {
        map = new HashMap<>();
        for (long i = 0; i < 10000; i++) {
            map.put(i, String.valueOf(i));
        }
    }

    private static void initTMap() {
        tmap = new TLongObjectHashMap();
        for (long i = 0; i < 10000; i++) {
            tmap.put(i, String.valueOf(i));
        }
    }

    private static void testHashMap() {
        for (long i = 0; i < 10000; i++) {
            map.get(i);
        }
    }

    private static void testTMap() {
        for (long i = 0; i < 10000; i++) {
            tmap.get(i);
        }
    }

}
