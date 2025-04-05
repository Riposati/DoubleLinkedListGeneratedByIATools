package org.example;

// create a class for a circular double linked list with a head and tail
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

// create a method to insert a node at the end of the linked list
class LinkedList {
    Node head;

    LinkedList() {
        this.head = null;
    }

    // insert a node at the end of the linked list
    void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            Node temp = head.prev;
            temp.next = newNode;
            newNode.prev = temp;
            newNode.next = head;
            head.prev = newNode;
        }
    }

    // create method to delete a node from the linked list
    // Search for a node with given data and return it
    Node searchNode(int data) {
        if (head == null) {
            System.out.println("List is empty");
            return null;
        }

        Node current = head;
        do {
            if (current.data == data) {
                return current;
            }
            current = current.next;
        } while (current != head);

        System.out.println("Node not found");
        return null;
    }

    // Delete the given node from the list
    void deleteNode(int data) {
        Node nodeToDelete = searchNode(data);
        if (nodeToDelete == null) {
            return;
        }

        // delete single node
        if (nodeToDelete.next == nodeToDelete) {
            head = null;
            return;
        }

        if (nodeToDelete == head) {
            Node prev = head.prev;
            head = head.next;
            prev.next = head;
            head.prev = prev;
        } else {
            nodeToDelete.prev.next = nodeToDelete.next;
            nodeToDelete.next.prev = nodeToDelete.prev;
        }
    }

    // create method to print the linked list
    void printList() {
        Node temp = head;
        if (head != null) {
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != head);
        }
        System.out.println();
    }

    // create method to show list in inverse order
    void printListInverse() {
        if (head != null) {
            Node temp = head.prev;
            do {
                System.out.print(temp.data + " ");
                temp = temp.prev;
            } while (temp != head.prev);
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        // create 10 random values and insert them into the linked list
        for (int i = 1; i <= 10; i++) {
            list.insertAtEnd(i);
        }

        list.printList();
        list.printListInverse();

        // delete 10 random values from the list and print the list
        for (int i = 1; i <= 7; i++) {
            list.deleteNode(i);
        }

        list.printList();
        list.printListInverse();
    }
}