package org.example.dsvisualizationweb.controllers;

import org.example.dsvisualizationweb.dtos.request.TreeRequest;
import org.example.dsvisualizationweb.dtos.response.TreeResponse;
import org.example.dsvisualizationweb.services.BinaryTreeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rbtree")
public class RedBlackController {

    private final BinaryTreeService rbService;

    public RedBlackController(@Qualifier("rbService") BinaryTreeService rbService) {
        this.rbService = rbService;
    }

    @GetMapping("/state")
    public ResponseEntity<TreeResponse> getState() {
        return ResponseEntity.ok(rbService.getState());
    }

    @PostMapping("/insert")
    public ResponseEntity<TreeResponse> insert(@RequestBody TreeRequest request) {
        return ResponseEntity.ok(rbService.insert(request.getValue()));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<TreeResponse> delete(@RequestBody TreeRequest request) {
        return ResponseEntity.ok(rbService.delete(request.getValue()));
    }

    @GetMapping("/search/{value}")
    public ResponseEntity<TreeResponse> search(@PathVariable int value) {
        return ResponseEntity.ok(rbService.search(value));
    }

    @DeleteMapping("/clear")
    public ResponseEntity<TreeResponse> clear() {
        return ResponseEntity.ok(rbService.clear());
    }

    @GetMapping("/traversal/inorder")
    public ResponseEntity<TreeResponse> inorder() {
        return ResponseEntity.ok(rbService.inorder());
    }

    @GetMapping("/traversal/preorder")
    public ResponseEntity<TreeResponse> preorder() {
        return ResponseEntity.ok(rbService.preorder());
    }

    @GetMapping("/traversal/postorder")
    public ResponseEntity<TreeResponse> postorder() {
        return ResponseEntity.ok(rbService.postorder());
    }

    @GetMapping("/traversal/levelorder")
    public ResponseEntity<TreeResponse> levelorder() {
        return ResponseEntity.ok(rbService.levelorder());
    }
}
