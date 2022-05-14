package org.example;

import org.junit.jupiter.api.Test;

import javax.annotation.processing.Generated;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinaryTreeTest {

    @Test
    public void isEmptyTest() {
        BinaryTree<Integer> newTree = new BinaryTree<>();
        assertTrue(newTree.isEmpty());
    }

    @Test
    public void ofTest() {
        System.out.println(BinaryTree.of(7, 3, 9, 1, 5));
    }

    @Test
    public void containsTest() {
        assertTrue(BinaryTree.of(7, 3, 9, 1, 4, 99, -99).contains(99));
        assertFalse(BinaryTree.of(7, 3, 9, 1, 4, 99, -99).contains(66));
        assertFalse(BinaryTree.<Integer>of().contains(1)); //REMEMBER THIS FOREVER
    }

    @Test
    public void toListTest() {
        BinaryTree<Integer> test1 = BinaryTree.of(9, 1, 8, 2, 7, 3, 6, 4, 5);
        BinaryTree<Integer> test2 = BinaryTree.of(20, 80, 60, 10, 30, 90, 70, 40, 50);

        System.out.println(test1.toList());
        System.out.println(test2.toList());
    }

    @Test
    public void walkTest() {
        BinaryTree<Integer> test1 = BinaryTree.of(9, 1, 8, 2, 7, 3, 6, 4, 5);

        int[] result = {0};

        test1.walk((value -> result[0] = result[0] + value));

        System.out.println(result[0]);

    }

    @Test
    public void reduceTest() {
        BinaryTree<Integer> test1 = BinaryTree.of(9, 1, 8, 2, 7, 3, 6, 4, 5);

        int thisResult = test1.reduce((result, value) -> result + value, 0);

        System.out.println(thisResult);
    }

    @Test
    public void visitorToList() {
        BinaryTree<Integer> test1 = BinaryTree.of(9, 1, 8, 2, 7, 3, 6, 4, 5);
        System.out.println(test1.visitorToList());
    }

    @Test
    public void reduceToListTest() {
        BinaryTree<Integer> test1 = BinaryTree.of(9, 1, 8, 2, 7, 3, 6, 4, 5);

        System.out.println(test1.reduceToList());
    }

    @Test
    public void mapTest() {
        BinaryTree<Integer> test1 = BinaryTree.of(9, 1, 8, 2, 7, 3, 6, 4, 5);

        System.out.println(test1.map(value -> value * 2).reduceToList());
        System.out.println(test1.map(value -> value * 10).reduceToList());
        System.out.println(test1.map(value -> value * 0).reduceToList());

        System.out.println(test1.map(value -> value % 2 == 0).reduceToList());
        System.out.println(test1.map(value -> value % 2 != 0).reduceToList());
    }
}
