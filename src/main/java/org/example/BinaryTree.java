package org.example;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

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


    public MyList<T> toList() {
        // Depth first
        // https://en.wikipedia.org/wiki/Depth-first_search
        // Finite state machine
        // https://en.wikipedia.org/wiki/Finite-state_machine


        final MyList<T> result = new MyLinkedList<>();

        final MyList<Node<T>> cursorList = new MyLinkedList<>();
        final MyList<Character> downLeftOrRight = new MyLinkedList<>();

        Character dlr;
        downLeftOrRight.push('D');

        Node<T> cursor = this.topNode;

        while (true) {
            dlr = downLeftOrRight.pop();

            if (cursor.left != null && dlr == 'D') {
                cursorList.push(cursor);
                downLeftOrRight.push('L');
                cursor = cursor.left;
                downLeftOrRight.push('D');
                continue;
            }

            if (dlr != 'R') {
                result.append(cursor.value);
            }

            if (cursor.right != null && dlr != 'R') {
                cursorList.push(cursor);
                downLeftOrRight.push('R');
                cursor = cursor.right;
                downLeftOrRight.push('D');
                continue;
            }

            if (cursorList.isEmpty()) {
                break;
            }

            cursor = cursorList.pop();
        }

        return result;
    }


    // Consumer<T> is like Function<T, Void> ( uses 'accept' instead of 'apply' )
    public void walk(Consumer<T> visitor) {
        // this is called "visitor pattern"
        // https://en.wikipedia.org/wiki/Visitor_pattern
        if (this.topNode.left != null) {
            this.leftTree().walk(visitor);
        }
        visitor.accept(this.topNode.value);
        if (this.topNode.right != null) {
            this.rightTree().walk(visitor);
        }
    }

    public <V> V reduce (BiFunction<V, T, V> reducer, V initialResult) {
        V result = initialResult;

        if (this.topNode.left != null) {
            result = this.leftTree().reduce(reducer, result);
        }

        result = reducer.apply(result, this.topNode.value);

        if (this.topNode.right != null) {
           result = this.rightTree().reduce(reducer, result);
        }

        return result;
    }

    public BinaryTree<T> leftTree() {
        final BinaryTree<T> result = new BinaryTree<>();

        result.topNode = this.topNode.left;

        return result;
    }

    public BinaryTree<T> rightTree() {
        final BinaryTree<T> result = new BinaryTree<>();

        result.topNode = this.topNode.right;

        return result;
    }

    public MyList<T> visitorToList() {
        final MyList<T> result = new MyLinkedList<>();

        this.walk(value -> result.append(value));

        return result;
    }

    public MyList<T> reduceToList() {
        return this.reduce((result, value) -> result.append(value), (MyList<T>)(new MyLinkedList<T>()));
    }

}






















