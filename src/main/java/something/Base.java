package something;

/**
 * 一道携程面试题
 * Created by skywalker on 2015/10/20.
 */
@SuppressWarnings("unused")
public class Base {

    private String baseName = "base";

    public Base() {
        callName();
    }

    public void callName() {
        System.out.println("Base callName");
        System.out.println(baseName);
    }

    static class Sub extends Base {
        private String baseName = "sub";

        public void callName() {
            System.out.println("Sub callName");
            System.out.println(baseName);
        }
    }

    public static void main(String[] args) {
        //null
        //可以看出，调用的是子类(Sub)的callName()
        Base b = new Sub();
        //这是一个解释:
       /* 1. Base b = new Sub();
        2. Base b = 直接忽略，从 new Sub();开始
        3. 类加载器加载 Base，Sub 类到jvm;
        4. 为Base，Sub 类中的两个属性baseName 分配存储空间，但是不初始化；
        注意:属性的初始化时放在构造器中，按照代码顺序执行的。
        5. new Sub会调用Sub的无参构造器，而在这个构造器中会隐式调用父类Base的无参构造器；
        6. 父类Base的构造器中代码本质是
        public Base()
        {
            baseName = "base";
            callName();
        }
        即父类的属性baseName 的值为base。但为何输出null，骚年别急。
        7. 因为父类构造器方法是在子类中调用的，即大环境是子类。此时，调用的方法callName()当然是指子类的方法。而这个方法打印的属性baseName当然也是子类的。那现在子类的属性baseName的值是多少呢？答案是null.因为此时子类Sub的构造器内代码本质是:
        super();
        baseName="sub";
        此时baseName="sub"还没执行。

        因此，左后的值当然是null.*/
    }

}
