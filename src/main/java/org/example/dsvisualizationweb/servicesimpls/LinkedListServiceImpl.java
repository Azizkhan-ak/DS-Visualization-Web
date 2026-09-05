package org.example.dsvisualizationweb.servicesimpls;

import org.example.dsvisualizationweb.dtos.general.Node;
import org.example.dsvisualizationweb.dtos.response.LinkedListResponse;
import org.example.dsvisualizationweb.services.LinkedListService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
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

        Node n = new Node(value);
        if(head == null){
            head = tail = n;
        }
        else{
            n.next = head;
            head = n;
        }
        size++;
        return buildResponse("Element added at the beginning!");
    }

    @Override
    public LinkedListResponse insertAtPosition(int value, int position) {
        // TODO: validate position (1 to size), traverse to position, rewire pointers
        // edge cases: position 1 → insertAtBeginning, position == size → insertAtEnd

        if(position == 0 || position > size+1){
            return buildResponse("Invalid position!");
        }

        if(position == 1){
           return insertAtBeginning(value);
        }

        if(position == size+1){
            return insertAtEnd(value);
        }

        int pointer = 1;
        Node temp = head;

        while (pointer<position-1){
            temp = temp.next;
            pointer++;
        }

        Node n = new Node(value);
        n.next = temp.next;
        temp.next = n;
        size++;

        return buildResponse("Element inserted at Position: "+position );
    }

    // -------------------------------------------------------------------------
    // DELETE
    // -------------------------------------------------------------------------

    @Override
    public LinkedListResponse deleteAtEnd() {
        // TODO: handle empty list, single node, traverse to second-last node, update tail

        if(head == null){
            return buildResponse("List is empty!");
        }

        if(size == 1){
            head = tail = null;
            size--;
            return buildResponse("Only one element in list - Element deleted!");
        }

        Node temp = head;
        while (temp.next.next!=null){
            temp = temp.next;
        }

        tail = temp;
        temp.next = null;
        size--;

        return buildResponse("Last element deleted!");
    }

    @Override
    public LinkedListResponse deleteAtBeginning() {
        // TODO: handle empty list, move head to head.next, decrement size

        if(head == null){
            return buildResponse("Empty List!");
        }

        if(size == 1){
            head = null;
            tail = null;
            size--;
            return buildResponse("Element Deleted, List is Emopty Now");
        }

        head = head.next;
        size--;

        return buildResponse("Element deleted at the beginning!");
    }

    @Override
    public LinkedListResponse deleteByValue(int value) {
        // TODO: traverse to find node with value, rewire prev.next = node.next
        // edge cases: not found, delete head, delete tail

        if(head == null){
            return buildResponse("List is empty!");
        }

        if(size == 1){
            if(head.value == value){
                head = null;
                tail = null;
                size--;
                return buildResponse("Element deleted!");
            }
            else{
                return buildResponse("No element found with given value!");
            }
        }

        if(head.value == value){
            head = head.next;
            size--;
            return buildResponse("Element deleted!");
        }

        Node temp = head;
        Node pre = null;

        while (temp!=null){
           if(temp.value == value){
               pre.next = temp.next;
               size--;
               if(temp.next == null){
                   tail = pre;
               }
               return buildResponse("Element deleted!");
           }
           pre = temp;
           temp = temp.next;
        }

        return buildResponse("Element not found!");
    }

    @Override
    public LinkedListResponse deleteAtPosition(int position) {
        // TODO: validate position (1 to size), traverse, rewire pointers
        // edge cases: position 1 → deleteAtBeginning, position == size → deleteAtEnd

        if(position == 0 || position>size){
            return buildResponse("InValid Position!");
        }

        if(position == 1){
            head = head.next;
            if(size == 1){
                tail = head;
            }
            size--;
            return buildResponse("Element deleted!");
        }

        int pointer = 1;
        Node temp = head;

        while (pointer<position-1){
            temp = temp.next;
            pointer++;
        }

        if(temp.next.next == null){
            tail = temp;
        }
        temp.next = temp.next.next;
        size--;

        return buildResponse("Deleted Element!");
    }

    // -------------------------------------------------------------------------
    // OPERATIONS
    // -------------------------------------------------------------------------

    @Override
    public LinkedListResponse reverse() {
        // TODO: three pointer approach — prev, curr, next
        // iterate: curr.next = prev, advance both, update head at end

        Node current = head;
        Node next = null;
        Node pre = null;

        if(head == null || size == 1){
            return buildResponse("Operation not applicable!");
        }

        while (current!=null){
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }

        tail = head;
        head = pre;
        
        return buildResponse("LinkedList revereed!");
    }

    @Override
    public LinkedListResponse getState() {
        // TODO: traverse from head, collect values into list, return response
        return buildResponse("Current state of List!");
    }

    @Override
    public LinkedListResponse clear() {
        // TODO: set head = null, tail = null, size = 0
       head = tail = null;
       size = 0;
       return buildResponse("List cleared!");
    }

    // -------------------------------------------------------------------------
    // SEARCH
    // -------------------------------------------------------------------------

    @Override
    public boolean contains(int value) {
        // TODO: traverse from head, return true if value found

        if(head == null){
            return false;
        }

        if(size == 1){
            return head.value == value;
        }

        Node temp = head;

        while (temp!=null){
            if(temp.value == value){
                return true;
            }
            temp = temp.next;
        }

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
