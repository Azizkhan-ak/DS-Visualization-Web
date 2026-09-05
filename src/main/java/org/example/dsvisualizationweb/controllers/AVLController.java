package org.example.dsvisualizationweb.controllers;

import lombok.RequiredArgsConstructor;
import org.example.dsvisualizationweb.dtos.request.TreeRequest;
import org.example.dsvisualizationweb.dtos.response.TreeResponse;
import org.example.dsvisualizationweb.services.BinaryTreeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/avl")
public class AVLController {

    private final BinaryTreeService avlService;

    public AVLController(@Qualifier("avlService") BinaryTreeService avlService) {
        this.avlService = avlService;
    }

    @GetMapping("/state")
    public ResponseEntity<TreeResponse> getState() {
        return ResponseEntity.ok(avlService.getState());
    }

    @PostMapping("/insert")
    public ResponseEntity<TreeResponse> insert(@RequestBody TreeRequest request) {
        return ResponseEntity.ok(avlService.insert(request.getValue()));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<TreeResponse> delete(@RequestBody TreeRequest request) {
        return ResponseEntity.ok(avlService.delete(request.getValue()));
    }

    @GetMapping("/search/{value}")
    public ResponseEntity<TreeResponse> search(@PathVariable int value) {
        return ResponseEntity.ok(avlService.search(value));
    }

    @DeleteMapping("/clear")
    public ResponseEntity<TreeResponse> clear() {
        return ResponseEntity.ok(avlService.clear());
    }

    @GetMapping("/traversal/inorder")
    public ResponseEntity<TreeResponse> inorder() {
        return ResponseEntity.ok(avlService.inorder());
    }

    @GetMapping("/traversal/preorder")
    public ResponseEntity<TreeResponse> preorder() {
        return ResponseEntity.ok(avlService.preorder());
    }

    @GetMapping("/traversal/postorder")
    public ResponseEntity<TreeResponse> postorder() {
        return ResponseEntity.ok(avlService.postorder());
    }

    @GetMapping("/traversal/levelorder")
    public ResponseEntity<TreeResponse> levelorder() {
        return ResponseEntity.ok(avlService.levelorder());
    }
}
