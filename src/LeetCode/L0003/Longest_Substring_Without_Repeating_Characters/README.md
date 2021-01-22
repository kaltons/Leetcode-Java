# [3. 无重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters)

<!-- 这里写题目描述 -->

## 题目描述

给定一个字符串，请你找出其中不含有重复字符的 **最长子串** 的长度。

**示例 1:**

```
输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
```

**示例 2:**

```
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
```

**示例 3:**

```
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
```

- ## 前置知识

  - 哈希表
  - [滑动窗口](https://github.com/azl397985856/leetcode/blob/master/thinkings/slide-window.md)

1. ## 思路

   题目要求连续， 我们考虑使用滑动窗口。 而这道题就是**窗口大小不固定**的滑动窗口题目，然后让我们求满足条件的窗口大小的最大值，这是一种非常常见的滑动窗口题目。

   算法：

   用一个 hashmap 来建立字符和其出现位置之间的映射。同时维护一个滑动窗口，窗口内的都是没有重复的字符，去尽可能的扩大窗口的大小，窗口不停的向右滑动。

   1. 如果当前遍历到的字符从未出现过，那么直接扩大右边界；

   2. 如果当前遍历到的字符出现过，则缩小窗口（左边索引向右移动），然后继续观察当前遍历到的字符；

   3. 重复（1）（2），直到窗口内无重复元素；

   4. 维护一个全局最大窗口 res，每次用出现过的窗口大小来更新结果 res，最后返回 res 获取结果;

   5. 最后返回 res 即可;

   ![3.longestSubstringWithoutRepeatingCharacters](https://tva1.sinaimg.cn/large/007S8ZIlly1ghlubou8hhg30no0dbjvw.gif)

   (图片来自： https://github.com/MisterBooo/LeetCodeAnimation)

   ## 关键点

   - mapper 记录出现过并且没有被删除的字符
   - 滑动窗口记录当前 index 开始的最大的不重复的字符序列

## 代码

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
/**
 * Longest Substring Without Repeating Characters —— 无重复字符的最长子串
 *
 * @author 衍方
 * @from String
 * @date 2021/1/21 - 20:07
 * @link https://github.com/kaltons/LeetCode-Java
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }
}
```

<!-- tabs:end -->
