package org.example.dsvisualizationweb.dtos.general;

/**
 * Internal linked list node. Not exposed via API.
 * Supports both singly (next only) and doubly (next + prev) linked list.
 */
public class Node {

    public int value;
    public Node next;
    public Node prev; // null for singly linked list usage

    public Node(int value) {
        this.value = value;
    }
}
