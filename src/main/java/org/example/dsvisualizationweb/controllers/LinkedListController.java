package org.example.dsvisualizationweb.controllers;

import lombok.RequiredArgsConstructor;
import org.example.dsvisualizationweb.dtos.request.LinkedListRequest;
import org.example.dsvisualizationweb.dtos.response.LinkedListResponse;
import org.example.dsvisualizationweb.services.LinkedListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/linkedlist")
@RequiredArgsConstructor
public class LinkedListController {

    private final LinkedListService linkedListService;

    // --- State ---
    @GetMapping("/state")
    public ResponseEntity<LinkedListResponse> getState() {
        return ResponseEntity.ok(linkedListService.getState());
    }

    // --- Insert ---
    @PostMapping("/insert/end")
    public ResponseEntity<LinkedListResponse> insertAtEnd(@RequestBody LinkedListRequest request) {
        return ResponseEntity.ok(linkedListService.insertAtEnd(request.getValue()));
    }

    @PostMapping("/insert/beginning")
    public ResponseEntity<LinkedListResponse> insertAtBeginning(@RequestBody LinkedListRequest request) {
        return ResponseEntity.ok(linkedListService.insertAtBeginning(request.getValue()));
    }

    @PostMapping("/insert/position")
    public ResponseEntity<LinkedListResponse> insertAtPosition(@RequestBody LinkedListRequest request) {
        return ResponseEntity.ok(linkedListService.insertAtPosition(request.getValue(), request.getPosition()));
    }

    // --- Delete ---
    @DeleteMapping("/delete/end")
    public ResponseEntity<LinkedListResponse> deleteAtEnd() {
        return ResponseEntity.ok(linkedListService.deleteAtEnd());
    }

    @DeleteMapping("/delete/beginning")
    public ResponseEntity<LinkedListResponse> deleteAtBeginning() {
        return ResponseEntity.ok(linkedListService.deleteAtBeginning());
    }

    @DeleteMapping("/delete/value")
    public ResponseEntity<LinkedListResponse> deleteByValue(@RequestBody LinkedListRequest request) {
        return ResponseEntity.ok(linkedListService.deleteByValue(request.getValue()));
    }

    @DeleteMapping("/delete/position")
    public ResponseEntity<LinkedListResponse> deleteAtPosition(@RequestBody LinkedListRequest request) {
        return ResponseEntity.ok(linkedListService.deleteAtPosition(request.getPosition()));
    }

    // --- Operations ---
    @PostMapping("/reverse")
    public ResponseEntity<LinkedListResponse> reverse() {
        return ResponseEntity.ok(linkedListService.reverse());
    }

    @DeleteMapping("/clear")
    public ResponseEntity<LinkedListResponse> clear() {
        return ResponseEntity.ok(linkedListService.clear());
    }

    // --- Search ---
    @GetMapping("/contains/{value}")
    public ResponseEntity<Boolean> contains(@PathVariable int value) {
        return ResponseEntity.ok(linkedListService.contains(value));
    }
}
