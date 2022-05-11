package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinaryTreeTest {

    @Test
    public void createTreeTest(){
        BinaryTree<Integer> newTree = new BinaryTree<>();
    }

    @Test
    public void isEmptyTest() {
        BinaryTree<Integer> newTree = new BinaryTree<>();
        assertTrue(newTree.isEmpty());
    }

    @Test
    public void ofTest(){
        System.out.println(BinaryTree.of(7,3,9,1,5));
    }

}
