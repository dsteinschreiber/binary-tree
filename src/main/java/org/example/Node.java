package org.example;

public class Node<T> {
    T value;
    Node<T> right;
    Node<T> left;

    @Override
    public String toString(){

        // Maybe make this StringBuffer down the line

        String result = "Node {";

        result = result + "Value: " + this.value + ", ";
        result = result + "Left: ";
        if (this.left == null){
            result = result + "null, ";
        } else {
            result = result + this.left.toString() + ", ";
        }


        result = result + "Right: ";
        if (this.right == null){
            result = result + "null";
        } else {
            result = result + this.right.toString();
        }

        result = result + "}";


        return result;
    }
}
