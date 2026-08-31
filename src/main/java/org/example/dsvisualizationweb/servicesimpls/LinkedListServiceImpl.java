package org.example.dsvisualizationweb.servicesimpls;

import org.example.dsvisualizationweb.dtos.general.Node;
import org.example.dsvisualizationweb.dtos.response.LinkedListResponse;
import org.example.dsvisualizationweb.services.LinkedListService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@SessionScope // one linked list per user session — isolated state per browser tab
public class LinkedListServiceImpl implements LinkedListService {

    private Node head;
    private Node tail;
    private int size;

    // -------------------------------------------------------------------------
    // INSERT
    // -------------------------------------------------------------------------

    @Override
    public LinkedListResponse insertAtEnd(int value) {
        // TODO: create new node, attach to tail, update tail, increment size
        Node node = new Node(value);

        if(head == null) {
            head = node;
            tail = node;
        }
        else {
            tail.next = node;
            tail = node;
        }
        size++;
        return buildResponse("Element added!");
    }

    @Override
    public LinkedListResponse insertAtBeginning(int value) {
        // TODO: create new node, point its next to current head, update head, increment size
        return null;
    }

    @Override
    public LinkedListResponse insertAtPosition(int value, int position) {
        // TODO: validate position (0 to size), traverse to position-1, rewire pointers
        // edge cases: position 0 → insertAtBeginning, position == size → insertAtEnd
        return null;
    }

    // -------------------------------------------------------------------------
    // DELETE
    // -------------------------------------------------------------------------

    @Override
    public LinkedListResponse deleteAtEnd() {
        // TODO: handle empty list, single node, traverse to second-last node, update tail
        return null;
    }

    @Override
    public LinkedListResponse deleteAtBeginning() {
        // TODO: handle empty list, move head to head.next, decrement size
        return null;
    }

    @Override
    public LinkedListResponse deleteByValue(int value) {
        // TODO: traverse to find node with value, rewire prev.next = node.next
        // edge cases: not found, delete head, delete tail
        return null;
    }

    @Override
    public LinkedListResponse deleteAtPosition(int position) {
        // TODO: validate position (0 to size-1), traverse, rewire pointers
        // edge cases: position 0 → deleteAtBeginning, position == size-1 → deleteAtEnd
        return null;
    }

    // -------------------------------------------------------------------------
    // OPERATIONS
    // -------------------------------------------------------------------------

    @Override
    public LinkedListResponse reverse() {
        // TODO: three pointer approach — prev, curr, next
        // iterate: curr.next = prev, advance both, update head at end
        return null;
    }

    @Override
    public LinkedListResponse getState() {
        // TODO: traverse from head, collect values into list, return response
        return null;
    }

    @Override
    public LinkedListResponse clear() {
        // TODO: set head = null, tail = null, size = 0
        return null;
    }

    // -------------------------------------------------------------------------
    // SEARCH
    // -------------------------------------------------------------------------

    @Override
    public boolean contains(int value) {
        // TODO: traverse from head, return true if value found
        return false;
    }

    // -------------------------------------------------------------------------
    // HELPER
    // -------------------------------------------------------------------------

    /**
     * Traverses the list and collects all values in order.
     * Use this in every method to build the response — avoids code duplication.
     */
    private LinkedListResponse buildResponse(String message) {
        List<Integer> values = new ArrayList<>();
        Node current = head;
        while (current != null) {
            values.add(current.value);
            current = current.next;
        }
        return new LinkedListResponse(values, size, message);
    }
}
