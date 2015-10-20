/**
 * 寻找数组中出现次数大于一半的数字
 * js文件在cmd输入jjs XXX.js即可运行
 * Created by skywalker on 2015/10/20.
 */
/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
    var mapper = {}, n;
    for (var i = 0, l = nums.length;i < l;++i) {
        n = nums[i];
        if (!mapper[n]) {
            mapper[n] = 1;
        } else {
            ++ mapper[n];
        }
    }
    //一半
    var threshold = nums.length / 2;
    for (var p in mapper) {
        if (mapper.hasOwnProperty(p)) {
            if (mapper[p] > threshold) {
                //属性名是string，题目要求int
                return parseInt(p);
            }
        }
    }
    //题目中说了肯定有这样的元素，但还是保险起见
    return 0;
};

print(majorityElement([2, 3, 4, 2, 3, 3, 3]));