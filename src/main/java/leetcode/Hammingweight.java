package leetcode;

/**
 * 它的意义(摘自维基百科):
 * For the most typical case, a string of bits, this is the number of 1's in the string.
 * 也就是二进制码里面1的个数
 * 比如说11的二进制(32位)表示:00000000000000000000000000001011，结果就是3
 * java提供了相关的API支持，摘自维基:
 * In Java, the growable bit-array data structure BitSet has a BitSet.cardinality() method that counts the number of bits that are set.
 * In addition, there are Integer.bitCount(int) and Long.bitCount(long) functions to count bits in primitive 32-bit and 64-bit integers,
 * respectively. Also, the BigInteger arbitrary-precision integer class also has a BigInteger.bitCount() method that counts bits.
 * Created by skywalker on 2015/10/19.
 */
public class Hammingweight {

    public static void main(String[] args) {
        System.out.println(hammingWeight(11));
    }

    private static int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

}
