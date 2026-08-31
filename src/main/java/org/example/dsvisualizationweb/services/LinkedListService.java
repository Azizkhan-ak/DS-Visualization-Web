package org.example.dsvisualizationweb.services;

import org.example.dsvisualizationweb.dtos.response.LinkedListResponse;

public interface LinkedListService {

    // --- Insert ---
    LinkedListResponse insertAtEnd(int value);
    LinkedListResponse insertAtBeginning(int value);
    LinkedListResponse insertAtPosition(int value, int position); // 0-based

    // --- Delete ---
    LinkedListResponse deleteAtEnd();
    LinkedListResponse deleteAtBeginning();
    LinkedListResponse deleteByValue(int value);
    LinkedListResponse deleteAtPosition(int position); // 0-based

    // --- Operations ---
    LinkedListResponse reverse();
    LinkedListResponse getState();  // returns current list without modifying it
    LinkedListResponse clear();

    // --- Search ---
    boolean contains(int value);
}
