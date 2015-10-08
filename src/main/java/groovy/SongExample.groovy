package groovy

/**
 * Groovy类的使用
 * Created by skywalker on 2015/10/3.
 */
class SongExample {

    public static void main(String[] args) {
        //自动生成构造器
        def song = new Song(name: "skywalker", age: 22);
        println song.name;
        //自动生成getter和setter
        println song.getAge();
        println song;
    }

}
