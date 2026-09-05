package org.example.dsvisualizationweb.controllers;

import org.example.dsvisualizationweb.dtos.request.TreeRequest;
import org.example.dsvisualizationweb.dtos.response.TreeResponse;
import org.example.dsvisualizationweb.services.BinaryTreeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bst")
public class BSTController {

    private final BinaryTreeService bstService;

    public BSTController(@Qualifier("bstService") BinaryTreeService bstService) {
        this.bstService = bstService;
    }

    @GetMapping("/state")
    public ResponseEntity<TreeResponse> getState() {
        return ResponseEntity.ok(bstService.getState());
    }

    @PostMapping("/insert")
    public ResponseEntity<TreeResponse> insert(@RequestBody TreeRequest request) {
        return ResponseEntity.ok(bstService.insert(request.getValue()));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<TreeResponse> delete(@RequestBody TreeRequest request) {
        return ResponseEntity.ok(bstService.delete(request.getValue()));
    }

    @GetMapping("/search/{value}")
    public ResponseEntity<TreeResponse> search(@PathVariable int value) {
        return ResponseEntity.ok(bstService.search(value));
    }

    @DeleteMapping("/clear")
    public ResponseEntity<TreeResponse> clear() {
        return ResponseEntity.ok(bstService.clear());
    }

    @GetMapping("/traversal/inorder")
    public ResponseEntity<TreeResponse> inorder() {
        return ResponseEntity.ok(bstService.inorder());
    }

    @GetMapping("/traversal/preorder")
    public ResponseEntity<TreeResponse> preorder() {
        return ResponseEntity.ok(bstService.preorder());
    }

    @GetMapping("/traversal/postorder")
    public ResponseEntity<TreeResponse> postorder() {
        return ResponseEntity.ok(bstService.postorder());
    }

    @GetMapping("/traversal/levelorder")
    public ResponseEntity<TreeResponse> levelorder() {
        return ResponseEntity.ok(bstService.levelorder());
    }
}
