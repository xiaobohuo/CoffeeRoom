package com.dom.ination.coffeeroom.list;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by huoxiaobo on 2017/3/11.
 */

public class CoffeeLinkedList {
    Node head;

    public int length() {
        if (head == null) return 0;
        Node tmp = head;
        int i = 1;
        while (tmp.next != null) {
            i++;
            tmp = tmp.next;
        }
        return i;
    }

    public void add(Node node) {
        if (head == null) {
            head = node;
            return;
        }
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = node;
    }

    public void printList() {
        if (length() == 0) {
            System.out.println("list empty");
            return;
        }
        Node tmp = head;
        while (tmp != null) {
            System.out.println(tmp.value);
            tmp = tmp.next;
        }
    }

    //删除第k个元素
    public void remove(int index) {
        if (index < 1 || index > length()) {
            System.out.println("index illegal, cannot remove");
            return;
        }
        if (index == 1) {
            head = head.next;
            return;
        }
        int i = 2;
        Node pre = head;
        Node curr = pre.next;
        while (curr != null) {
            if (i == index) {
                pre.next = curr.next;
                return;
            }
            pre = curr;
            curr = curr.next;
            i++;
        }
    }

    //排序 插入排序算法
    public void order() {
        if (length() == 0 || length() == 1) {
            print("no need to order");
            return;
        }
        Node outer = head;
        while (outer.next != null) {
            Node inner = outer.next;
            while (inner != null) {
                if (inner.value < outer.value) {
                    int tmp = outer.value;
                    outer.value = inner.value;
                    inner.value = tmp;
                }
                inner = inner.next;
            }
            outer = outer.next;
        }
    }

    //删除重复  o n
    public void deleteDuplicate() {
        if (length() == 0 || length() == 1) {
            print("no need to delete duplicate");
            return;
        }
        Set<Integer> set = new HashSet<>();
        Node pre = null;
        Node curr = head;
        while (curr != null) {
            if (!set.contains(curr.value)) {
                set.add(curr.value);
                pre = curr;
            } else {
                pre.next = curr.next;
            }
            curr = curr.next;
        }
    }

    //删除重复，o n*n
    public void deleteDuplicate_() {
        if (length() == 0 || length() == 1) {
            print("no need to delete duplicate");
            return;
        }
        Node p = head;
        while (p != null) {
            Node q = p;
            while (q.next != null) {
                if (p.value == q.next.value) {
                    q.next = q.next.next;
                } else {
                    q = q.next;
                }
            }
            p = p.next;
        }
    }

    //查找倒数第k个元素
    public int find(int k) {
        if (k < 1 || k > length()) {
            print("k illegal, return");
            return -1;
        }
        Node p1 = head;
        Node p2 = head;
        for (int i = 0; i < k - 1; i++) {
            p1 = p1.next;
        }
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2.value;
    }

    //链表反转
    public void reverse() {
        if (length() == 0 || length() == 1) {
            print("no need to reverse");
            return;
        }
        Node pre = null;
        Node curr = head;
        Node rHead = head;
        while (curr != null) {
            Node pNext = curr.next;
            if (pNext == null) rHead = curr;
            curr.next = pre;
            pre = curr;
            curr = pNext;
        }
        head = rHead;
    }

    public void reversePrint(Node head) {
        if (head != null) {
            reversePrint(head.next);
            print(head.value + "");
        }
    }

    public Node searchMiddle() {
        Node p1 = head;
        Node p2 = head;
        while (p2 != null && p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    public boolean isLoop() {
        Node fast = head;
        Node slow = head;
        if (fast == null) {
            return false;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public boolean removeWithoutHeadKnown(Node node) {
        if (node == null || node.next == null) {
            print("last node ,cannot remove");
            return false;
        }
        node.value = node.next.value;
        node.next = node.next.next;
        return true;
    }

    public static void main(String[] args) {
        CoffeeLinkedList list = new CoffeeLinkedList();
        Node node1 = new Node(1);
        list.add(node1);
        Node node2 = new Node(2);
        list.add(node2);
        Node node3 = new Node(3);
        list.add(node3);
        Node node4 = new Node(4);
        list.add(node4);
        list.printList();
        print("after remove");
        list.removeWithoutHeadKnown(node1);
        list.printList();
    }

    public static void print(String msg) {
        System.out.println(msg);
    }
}
