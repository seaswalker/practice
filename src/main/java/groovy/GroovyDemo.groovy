package groovy

import org.junit.Test

/**Groovy测试
 * Created by skywalker on 2015/10/3.
 */
class GroovyDemo {

    @Test
    public void hello() {
        println "hello world";
    }

    /**
     * 测试groovy的类型
     * 从数字的类型可以看出，Groovy里面一切都是对象
     */
    @Test
    public void type() {
        def var = "hello world";
        println var.class;//class java.lang.String

        def num = 123;
        println num.class;//class java.lang.Integer
    }

    /**
     * 这东西不能定义在方法里面
     * @param val 被迭代的东西
     */
    def each(val) {
        for (def i = 0;i < 5;i ++) {
            println val;
        }
    }

    /**
     * 很像JavaScript那样的写法，for循环，函数
     */
    @Test
    public void method() {
        each("hello world");
    }

    /**
     * Groovy可以设置范围
     */
    @Test
    public void range() {
        //1 2 3 4 5 6 7 8 9 10
       /* for (def i in 1..10) {
            print i + " ";
        }*/

        //abcde
        for (def c in 'a'..'e') {
            print c;
        }

        //这样写的范围是[]的关系，如果不包含右边界，可以(示例):1..<4，那么就是1，2,3
    }

    def repeat(message, times = 2) {
        for (def i = 0;i < times;i ++) {
            println message;
        }
    }

    /**
     * Groovy支持为参数设置默认值
     */
    @Test
    public void args() {
        repeat("一次", 1);
        repeat("二次");
    }

    /**
     * Groovy"内置了"集合
     */
    @Test
    public void collection() {
        //注意此种写法不支持元素的修改
        def list = 1..4;
        println list.class;//class groovy.lang.IntRange
        println list instanceof List;//true

        //这么写才支持元素添加
        list = [1, 2, 3, 4];
        //添加元素,三种方式(<<是因为Groovy支持运算符重载)
        list.add(5);
        list << 6;
        list[6] = 7;
        println list;//[1, 2, 3, 4, 5, 6, 7]

        //下面的集合加减有点吊,注意每次返回的都是一个新的对象
        list = [1, 2, 3, 4];
        list += 5;
        list -= [2, 3];
        println list;//[1, 4, 5]

        //还支持这样的方法
        list = [1, 2, 3, 4];
        assert  list.join(",") == "1,2,3,4";
        assert list.count(3) == 1;
        //*相当于把每个元素取出来依次执行后面的方法，注意println后面的括号如果去掉会报错
        println (["a", "b", "c"]*.toUpperCase());//[A, B, C]
    }

    /**
     * 对Map的操作
     */
    @Test
    public void map() {
        def map = ["name": "skywalker", address: "山东"];
        println map.getClass();//class java.util.LinkedHashMap 实现方式也清楚了

        //groovy也支持java的get()、put()

        //这是有特色的
        map.age = 20;
        println map.age;//20

        //也可以像数组那样,不过此时传入的必须是String
        println map["name"];//skywalker
    }

    /**
     * 闭包
     */
    @Test
    public void closure() {
        def list = ["中国", "美帝", "棒子"];
        /*list.each {
            println it;//当然可以直接迭代出来
            //it指向的东西你懂的，it是默认的名字(each方法)，其实可以自己取，其实很像Lambda
        }*/

        list.each { val ->
            print val + " ";
        }

        //迭代map
        def map = ["name": "skywalker", address: "山东"];
        map.each {key, value ->
            println "$key: $value";//运行时$后的东西被替换
        }

        //闭包可以被执行，注意闭包定义时有=，函数没有
        def excite =  {word ->
            return word.toUpperCase();
        }
        println excite("java");//JAVA
        println excite.call("groovy");//GROOVY
    }

    /**
     * 这就可以避免一堆if了
     */
    @Test
    public void nullPointer() {
        def person;
        //println person.toUpperCase();//这样就会出现空指针

        //Groovy有一个很好的解决空指针的方式
        println person?.toUpperCase();//直接打印null出来
    }

}
