# [2. 两数相加](https://leetcode-cn.com/problems/add-two-numbers)

<!-- 这里写题目描述 -->

## 题目描述

```
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
```

## 前置知识

- 链表

## 思路

设立一个表示进位的变量 carried，建立一个新链表，把输入的两个链表从头往后同时处理，每两个相加，将结果加上 carried 后的值作为一个新节点到新链表后面，并更新 carried 值即可。

[![2.addTwoNumbers](https://camo.githubusercontent.com/62f4e064be70fa6592eda63a4b51f5974913d20d5d3f3ab1d30e85ccfaa147f2/68747470733a2f2f747661312e73696e61696d672e636e2f6c617267652f30303753385a496c6c793167686c753675386a7779673330716830656f6e35632e676966)](https://camo.githubusercontent.com/62f4e064be70fa6592eda63a4b51f5974913d20d5d3f3ab1d30e85ccfaa147f2/68747470733a2f2f747661312e73696e61696d672e636e2f6c617267652f30303753385a496c6c793167686c753675386a7779673330716830656f6e35632e676966)

(图片来自： https://github.com/MisterBooo/LeetCodeAnimation)

实际上两个大数相加也是一样的思路， 只不过具体的操作 API 不一样而已。这种题目思维难度不大，难点在于心细，因此大家一定要自己写一遍，确保 bug free。

## 关键点解析

1. 链表这种数据结构的特点和使用
2. 用一个 carried 变量来实现进位的功能，每次相加之后计算 carried，并用于下一位的计算

## 代码

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
/**
 * Add Two Numbers —— 两数相加
 *
 * @author 衍方
 * @from LinkedList
 * @date 2021/1/20 - 19:54
 * @link https://github.com/kaltons/LeetCode-Java
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 定义虚拟头结点
        ListNode virtual = new ListNode(-1);
        ListNode cur = virtual;
        // 进位保存
        int carry = 0;

        while (l1 != null || l2 != null){
            int sum = carry;
            if (l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            // 创建新节点
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }
        if (carry > 0){
            cur.next = new ListNode(carry);
        }
        return virtual.next;
    }
}
```

<!-- tabs:end -->
