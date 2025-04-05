package org.example;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class LinkedListTest {

    /**
     * Tests the printList method when the list is empty.
     * This is an edge case where the head of the list is null.
     * The method should print an empty line in this case.
     */
    @Test
    public void testPrintListWithEmptyList() {
        LinkedList list = new LinkedList();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        list.printList();

        assertEquals(System.lineSeparator(), outContent.toString());
        System.setOut(System.out);
    }

    /**
     * Tests the constructor of LinkedList class.
     * Verifies that a newly created LinkedList has a null head.
     */
    @Test
    public void test_LinkedList_Constructor() {
        LinkedList list = new LinkedList();
        assertNull("Head should be null for a new LinkedList", list.head);
    }

    /**
     * Testcase 3 for void deleteNode(int data)
     * Tests deleting the head node of a circular doubly linked list with multiple nodes.
     * Path constraints: !((nodeToDelete == null)), !((nodeToDelete.next == nodeToDelete)), (nodeToDelete == head)
     */
    @Test
    public void test_deleteNode_3() {
        LinkedList list = new LinkedList();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);

        list.deleteNode(1);

        assertNotNull(list.head);
        assertEquals(2, list.head.data);
        assertEquals(2, list.head.next.next.data);
        assertEquals(3, list.head.prev.data);
        assertEquals(list.head, list.head.next.next);
    }

    /**
     * Test case for void deleteNode(int data) when deleting a non-head node in a list with multiple nodes.
     * Path constraints: !((nodeToDelete == null)), !((nodeToDelete.next == nodeToDelete)), !((nodeToDelete == head))
     */
    @Test
    public void test_deleteNode_4() {
        LinkedList list = new LinkedList();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);

        list.deleteNode(2);

        Node current = list.head;
        assertEquals(1, current.data);
        assertEquals(3, current.next.data);
        assertEquals(1, current.next.next.data);
        assertEquals(list.head, current.next.next);
    }

    /**
     * Test case for deleting the only node in a circular linked list.
     * This test verifies that when deleting the only node in the list,
     * the head becomes null, effectively emptying the list.
     */
    @Test
    public void test_deleteNode_single_node() {
        LinkedList list = new LinkedList();
        list.insertAtEnd(1);
        list.deleteNode(1);
        assertNull(list.head);
    }

    /**
     * Testcase 1 for void insertAtEnd(int data)
     * Tests inserting a node into an empty list
     */
    @Test
    public void test_insertAtEnd_EmptyList() {
        LinkedList list = new LinkedList();
        list.insertAtEnd(5);

        assertNotNull(list.head);
        assertEquals(5, list.head.data);
        assertEquals(list.head, list.head.next);
        assertEquals(list.head, list.head.prev);
    }

    /**
     * Testcase 2 for void insertAtEnd(int data)
     * Tests inserting a node at the end of a non-empty circular double linked list.
     */
    @Test
    public void test_insertAtEnd_nonEmptyList() {
        LinkedList list = new LinkedList();
        list.insertAtEnd(1);
        list.insertAtEnd(2);

        Node current = list.head;
        assertEquals(1, current.data);
        assertEquals(2, current.next.data);
        assertEquals(1, current.next.next.data);
        assertEquals(2, current.prev.data);
    }

    /**
     * Testcase 1 for void printListInverse()
     * Tests the printListInverse method when the list is not empty.
     * Verifies that the method correctly prints the list in reverse order.
     */
    @Test
    public void test_printListInverse_nonEmptyList() {
        LinkedList list = new LinkedList();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        list.printListInverse();

        assertEquals("3 2 1 \n", outContent.toString());

        System.setOut(System.out);
    }

    /**
     * Testcase 1 for void printList()
     * Tests the printList method when the list is not empty
     */
    @Test
    public void test_printList_nonEmptyList() {
        LinkedList list = new LinkedList();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        list.printList();

        assertEquals("1 2 3 " + System.lineSeparator(), outContent.toString());
    }

    /**
     * Testcase 2 for void printList()
     * Tests the printList method when the list is empty (head is null).
     * Expects an empty line to be printed.
     */
    @Test
    public void test_printList_whenListIsEmpty() {
        LinkedList list = new LinkedList();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        list.printList();

        assertEquals(System.lineSeparator(), outContent.toString());
    }

    /**
     * Testcase 1 for Node searchNode(int data)
     * Tests the scenario when the list is empty (head is null)
     * Expected behavior: Method should return null and print "List is empty"
     */
    @Test
    public void test_searchNode_emptyList() {
        LinkedList list = new LinkedList();
        Node result = list.searchNode(5);
        assertNull(result);
    }

    /**
     * Test the searchNode method when the requested node is not in the list.
     * This test verifies that the method correctly handles the case
     * where the requested data is not found in any node and returns null with appropriate message.
     */
    @Test
    public void test_searchNode_nodeNotFound() {
        LinkedList list = new LinkedList();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        Node result = list.searchNode(4);
        assertNull(result);
    }
}
