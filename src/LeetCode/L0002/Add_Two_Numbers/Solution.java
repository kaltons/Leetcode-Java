package LeetCode.L0002.Add_Two_Numbers;

/**
 * Add Two Numbers —— 两数相加
 *
 * @author 衍方
 * @from LinkedList
 * @date 2021/1/20 - 19:54
 * @link https://github.com/kaltons/LeetCode-Java
 */
public class Solution {

    public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

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
