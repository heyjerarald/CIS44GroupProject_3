/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis44groupproject;

/**
 *
 * @author chuongtruong
 */
public class Stack<T> implements StackInterface<T> {
    private Node topNode;

    @Override
    public void push(T item) {
        Node newNode = new Node(item, topNode);
        topNode = newNode;
    }

    @Override
    public T pop() {
        T item = null;
        if (topNode != null) {
            item = topNode.data;
            topNode = topNode.next;
        }
        return item;
    }

    @Override
    public T peek() {
        T item = null;
        item = topNode.data;

        return item;
    }

    @Override
    public boolean isEmpty() {
        if (topNode == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public  void display() {
        Node current = topNode;

        while (current != null) {
            System.out.print(current.data + "  ");
            current = current.next;
        }

        System.out.println();
    }

    class Node {
        private T data;
        private Node next;

        public Node(T item, Node n) {
            data = item;
            next = n;
        }
    }
}
