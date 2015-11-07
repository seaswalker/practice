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

###ugly number:
```java
	/**
	 * 这个是从别人那里看来的思路
	 * @see http://segmentfault.com/a/1190000003480992
	 * 如果是ugly number，那么对此数不停地除以2/3/5那么最后应该得到1
	 * 仅需2ms
	 */
	private static boolean better(int num) {
		if (num < 1) {
			return false;
		}
		if (num == 1) {
			return true;
		}
		int r2 = num % 2, r3 = num % 3, r5 = num % 5;
		while (r2 == 0 || r3 == 0 || r5 == 0) {
			if (r2 == 0) {
				num /= 2;
			} else if (r3 == 0) {
				num /= 3;
			} else {
				num /= 5;
			}
			r2 = num % 2;
			r3 = num % 3;
			r5 = num % 5;
		}
		return num == 1;
	}
```

###SymmetricTree递归算法:
```java
	/**
	 * 更好的算法 1ms
	 * @see https://leetcode.com/discuss/63463/java-self-explanatory-1ms-recursive-solution
	 */
	private static boolean improve(TreeNode root) {
		if (root == null)
			return true;
		return isSymSubTree(root.left, root.right);
	}
	private static boolean isSymSubTree(TreeNode left, TreeNode right) {
		if (left == null)
			return (right == null);
		if (right == null)
			return false;
		return (left.val == right.val) && isSymSubTree(left.left, right.right)
				&& isSymSubTree(left.right, right.left);
	}
```

###动态规划问题(House Robber):
```java
	/**
	 * 从别人那里看到的
	 * @see http://www.cnblogs.com/ganganloveu/p/4417485.html
	 * 这其实是一个动态规划的问题，关于动态规划，这有一个简洁的解释:
	 * @see http://www.bubuko.com/infodetail-1015504.html
	 * 0ms
	 */
	private static int solution(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		int l = nums.length;
		int[] max = new int[l];
		max[0] = nums[0];
		max[1] = Math.max(nums[0], nums[1]);
		for (int i = 2;i < l;++i) {
			max[i] = Math.max(max[i - 2] + nums[i], max[i - 1]);
		}
		return max[l - 1];
	}
```

###Bulls and Cows问题:
```java
	/**
	 * 更好的算法(O(n))
	 * 5ms
	 * @see https://leetcode.com/discuss/67031/one-pass-java-solution
	 */
	private static String better(String secret, String guess) {
		int bulls = 0, cows = 0;
		//记录secret中和guess中出现的次数
		int[] nums = new int[10];
		int si, gi;
		for (int i = 0, l = secret.length();i < l; ++i) {
			si = secret.charAt(i) - '0';
			gi = guess.charAt(i) - '0';
			if (si == gi) {
				++bulls;
			} else {
				if (nums[si] < 0) {
					++cows;
				}
				if (nums[gi] > 0) {
					++cows;
				}
				++nums[si];
				--nums[gi];
			}
		}
		return bulls + "A" + cows + "B";
	}
```

###计算二叉搜索树的种数:
```java
	/**
	 * 这道题的思路是这样的(以n = 3为例):
	 * 1，2, 3都可以作为根节点，种数就是左子树的种数乘以右子树的种数，比如，2作为根节点，左子树只可以取1，所以只有一种，右子树只可以
	 * 取3，也是一种
	 * 此算法比递归要好，递归包含大量的重复计算
	 */
	private static int numTrees(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		int[] nums = new int[n + 1];
		nums[0] = nums[1] = 1;
		nums[2] = 2;
		for (int i = 3;i <= n; ++i) {
			int temp = 0;
			for (int j = 0;j < i; ++j) {
				temp += nums[j] * nums[i - 1 - j];
			}
			nums[i] = temp;
		}
		return nums[n];
	}
```

###最大子串问题:
```java
	/**
	 * 1ms
	 * 时间复杂度O(n)，参考:
	 * @see http://www.tuicool.com/articles/IbiMjaI(动态规划)
	 * @param nums 最少有一个元素
	 */
	private static int maxSubArray(int[] nums) {
		int sum, max;
		sum = max = nums[0];
		for (int i = 1, l = nums.length;i < l; ++i) {
			if (sum < 0) {
				sum = 0;
			}
			sum += nums[i];
			max = Math.max(sum, max);
		}
		return max;
	}
```

###排好序的数组生成平衡二叉树:
```java
	/**
	 * 1ms / O(n)
	 * 非原创，思路类似于二分查找，中点为根节点，中点左侧为左子树，右侧为右子树
	 * @see https://leetcode.com/discuss/10484/my-accepted-java-solution
	 */
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		return helper(nums, 0, nums.length - 1);
	}
	
	private TreeNode helper(int[] nums, int low, int high) {
		if (low > high) {
			return null;
		}
		int mid = low + ((high - low) >> 1);
		TreeNode node = new TreeNode(nums[mid]);
		node.left = helper(nums, low, mid - 1);
		node.right = helper(nums, mid + 1, high);
		return node;
	}
```