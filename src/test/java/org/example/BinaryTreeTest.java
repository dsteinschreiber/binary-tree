package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinaryTreeTest {

    @Test
    public void isEmptyTest() {
        BinaryTree<Integer> newTree = new BinaryTree<>();
        assertTrue(newTree.isEmpty());
    }

    @Test
    public void ofTest(){
        System.out.println(BinaryTree.of(7,3,9,1,5));
    }

    @Test
    public void containsTest(){
        assertTrue(BinaryTree.of(7,3,9,1,4,99,-99).contains(99));
        assertFalse(BinaryTree.of(7,3,9,1,4,99,-99).contains(66));
        assertFalse(BinaryTree.<Integer>of().contains(1)); //REMEMBER THIS FOREVER
    }

    @Test
    public void toListTest(){
        BinaryTree<Integer> test = BinaryTree.of(9,1,8,2,7,3,6,4,5);

        System.out.println(test.toList());
    }
}
