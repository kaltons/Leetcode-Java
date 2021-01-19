package LeetCode.L0001.Two_Sum;

import java.util.HashMap;
import java.util.Map;

/**
 * Two Sum —— 两数之和
 *
 * @author 衍方
 * @from Array
 * @date 2021/1/19 - 17:36
 * @link https://github.com/kaltons/LeetCode-Java
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;++i){
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]),i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
