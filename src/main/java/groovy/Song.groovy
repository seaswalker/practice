package groovy

/**
 * Groovy格式的javabean
 * Created by skywalker on 2015/10/3.
 */
class Song {

    def name;
    def age;

    /**
     * 覆盖toString
     */
    @Override
    String toString() {
        //groovy最后一行其实就是return
        //"$name, $age";
        "${name}, ${age}";//{}可加可不加
    }
}
