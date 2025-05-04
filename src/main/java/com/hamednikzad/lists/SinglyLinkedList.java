package com.hamednikzad.lists;

import java.util.Iterator;

public class SinglyLinkedList<T> implements Iterable<T> {

    public class Node {
        public Node next;
        public T data;

        public Node(T data) {
            this.data = data;
            next = null;
        }
    }

    private Node head;
    private Node tail;
    public int count;

    public boolean isEmpty() {
        return count == 0;
    }

    public T getHead() {
        return head == null ? null : head.data;
    }

    public void addFirst(T data) {
        if (data == null) {
            throw new NullPointerException();
        }

        var newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            count++;
            return;
        }

        newNode.next = head;
        head = newNode;
        count++;
    }

    public void addLast(T data) {
        if (data == null) {
            throw new NullPointerException();
        }

        var newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            count++;
            return;
        }

        tail.next = newNode;
        tail = newNode;
        count++;
    }

    private Node find(T data) {
        if (head == null) {
            return null;
        }

        var currentNode = head;
        while (currentNode != null) {
            if (currentNode.data.equals(data)) {
                return currentNode;
            }

            currentNode = currentNode.next;
        }

        return null;
    }

    public boolean contains(T data) {
        return find(data) != null;
    }

    public T removeByIndex(int index) {
        if (index < 0 || index >= count || head == null) {
            return null;
        }

        T node = null;
        if (index == 0) {
            node = head.data;
            head = head.next;

            if (count == 1) {
                tail = null;
            }
        } else {
            var currentNode = head;
            var previousNode = head;
            var i = 0;

            while (i < index && currentNode != null) {
                previousNode = currentNode;
                currentNode = currentNode.next;
                i++;
            }

            if (currentNode != null) {
                node = currentNode.data;
                previousNode.next = currentNode.next;
            }

            if (index == count - 1) {
                tail = previousNode;
            }
        }

        count--;
        return node;
    }

    public void removeLast() {
        removeByIndex(count - 1);
    }

    public void removeFirst() {
        removeByIndex(0);
    }

    public boolean removeData(T data) {
        if(head == null)
            return false;

        if(head.data.equals(data)){
            head = head.next;

            if(count == 1){
                tail = null;
            }

            count--;
            return true;
        }

        var currentNode = head;
        var previousNode = head;

        while (currentNode != null) {
            if (currentNode.data.equals(data)) {
                previousNode.next = currentNode.next;

                if(currentNode.next == null){
                    tail = previousNode;
                }

                count--;
                return true;
            }

            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {


            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                return null;
            }
        };
    }
}
