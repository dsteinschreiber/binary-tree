package org.example;

public class BinaryTree<T extends Comparable<T>> {

    private Node<T> topNode;

    @SafeVarargs
    public static <T extends Comparable<T>> BinaryTree<T> of(T... values) {
        BinaryTree<T> result = new BinaryTree<>();

        for (T value : values) {
            result.insert(value);
        }

        return result;
    }

    public void insert(T value) {
        Node<T> cursor = this.topNode;

        if (this.isEmpty()) {
            this.topNode = new Node<>();
            this.topNode.value = value;
            return;
        }

        while (true) {
            if (cursor.value.compareTo(value) < 0) {
                if (cursor.right == null) {
                    cursor.right = new Node<>();
                    cursor.right.value = value;
                    return;
                } else {
                    cursor = cursor.right;
                }
            } else if (cursor.value.compareTo(value) > 0) {
                if (cursor.left == null) {
                    cursor.left = new Node<>();
                    cursor.left.value = value;
                    return;
                } else {
                    cursor = cursor.left;
                }
            } else {
                return;
            }
        }
    }

    public boolean isEmpty() {
        return (this.topNode == null);
    }

    @Override
    public String toString() {
        return this.topNode.toString();
    }

    public boolean contains(T value) {

        Node<T> cursor = this.topNode;

        while (cursor != null) {
            if (cursor.value.compareTo(value) == 0) {
                return true;
            } else if (cursor.value.compareTo(value) > 0) {
                cursor = cursor.left;
            } else {
                cursor = cursor.right;
            }
        }

        return false;
    }
}

