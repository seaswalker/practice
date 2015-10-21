##leetcode 算法记录:

###SingleNumber问题:
从给定的数组中找出唯一的一个只出现了一次的数字，使用XOR(异或)：
```java
    private static int better(int[] nums) {
        int result = nums[0];
        for (int i = 1, l = nums.length;i < l;++i) {
            result ^= nums[i];
        }
        return result;
    }
```

###Product of array except itself:
```java
    /**
     * 思路就是设置两个辅助数组(result数组当作一个，这样空间复杂度就是O(1)了)，其中一个数组保存:
     * 从前开始(1)迭代，保存当前位置(i)之前所有数的乘积
     * 另一个数组保存从后面开始迭代的结果
     * 这样两个数组同样位置的元素相乘就是所求结果，非常巧妙
     * @param nums
     * @return
     */
    private static int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        int[] result = new int[l];
        int[] left = new int[l];
        left[0] = 1;
        result[l - 1] = 1;
        //设置left数组，就是迭代原数组(从1开始)，每一个元素都是i之前元素的乘积
        for (int i = 1;i < l;++i) {
            left[i] = left[i - 1] * nums[i - 1];
            result[l - i - 1] = result[l - i] * nums[l - i];
        }
        //计算结果
        for (int i = 0;i < l;++i) {
            result[i] *= left[i];
        }
        return result;
    }
```
###判断链表有没有环:
不使用extra space的方案:
```java
     /**
     * 不使用额外空间的版本
     * 这个思路的脑洞实在是有点大，需要两个指针，一个每次走2步，另一个每次走1步，
     * 如果有环存在，那么走2步的会追上走1步的,只能是每次多1步，不然应该会出现超过的情况
     * 1ms
     * @see "https://leetcode.com/discuss/32906/o-1-space-solution"
     */
    private static boolean hasCycleWithoutExtraspace(ListNode head) {
        if (head != null) {
            ListNode slower = head;
            ListNode faster = head;
            while (faster.next != null && faster.next.next != null) {
                slower = slower.next;
                faster = faster.next.next;
                //追上
                if (slower == faster) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
```

###MissingNumber问题:
```java
    /**
     * 更好，也许是最好的算法，还是XOR，原理就是a^b^b = a,所以最后剩下的一定是缺失的
     * 此解法和SingleNumber相似，然而还是没有想到
     * 仅需1ms
     */
    private static int better(int[] nums) {
        int xor = 0, i, l;
        for (i = 0, l = nums.length;i < l;++i) {
            xor ^= i ^ nums[i];
        }
        /**
         * 最后再次异或i的原因，如果没有缺失，那么应该返回下一个，而i正是下一个
         * 如果有缺失，那么最后一个元素应该比不缺失大1，而1正好可以抵消最后一个，太巧妙了
         */
        return xor ^ i;
    }
```