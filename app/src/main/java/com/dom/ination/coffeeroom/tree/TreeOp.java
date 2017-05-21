package com.dom.ination.coffeeroom.tree;

/**
 * Created by huoxiaobo on 2017/3/23.
 */

class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int data) {
        this.data = data;
    }
}

public class TreeOp {

    Node root;

    public void init(int[] pre, int[] in) {
        root = this.init(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public Node init(int[] pre, int start_pre, int end_pre, int[] in, int start_in, int end_in) {
        if (start_pre > end_pre || start_in > end_in) {
            return null;
        }
        int data = pre[start_pre];
        int index = findIndexInInOrder(data, in);
        int offset = index - start_in;
        Node root = new Node(data);
        Node left = init(pre, start_pre + 1, start_pre + offset, in, start_in, start_in + offset - 1);
        Node right = init(pre, start_pre + offset + 1, end_pre, in, index + 1, end_in);
        root.left = left;
        root.right = right;
        return root;
    }

    public int findIndexInInOrder(int data, int[] in) {
        for (int i = 0; i < in.length; i++) {
            if (in[i] == data)
                return i;
        }
        return -1;
    }

    public void postOrder() {
        this.postOrder(root);
    }

    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }

    public static void main(String[] args) {
        TreeOp tree = new TreeOp();
        int[] pre = new int[]{1, 2, 4, 8, 9, 5, 10, 3, 6, 7};
        int[] in = new int[]{8, 4, 9, 2, 10, 5, 1, 6, 3, 7};
        tree.init(pre, in);
        tree.postOrder();
    }
}
