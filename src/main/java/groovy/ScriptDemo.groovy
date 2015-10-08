package groovy

/**
 * 看看Groovy脚本怎么用
 * Created by skywalker on 2015/10/3.
 */
class ScriptDemo {

    public static void main(String[] args) {
        def s = new Script();
        s.repeat("script");//script script script

        //这个太有意思了
        s.a = 10;
        s.run();//10

        //等价于
        s.binding.a = 10;
        s.run();
    }

}
