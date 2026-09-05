package org.example.dsvisualizationweb.servicesimpls;

import org.example.dsvisualizationweb.dtos.general.RBNode;
import org.example.dsvisualizationweb.dtos.general.RBNode.Color;
import org.example.dsvisualizationweb.dtos.response.TreeNodeResponse;
import org.example.dsvisualizationweb.dtos.response.TreeResponse;
import org.example.dsvisualizationweb.services.BinaryTreeService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Service("rbService")
@SessionScope
public class RedBlackServiceImpl implements BinaryTreeService {

    // NIL sentinel — all leaf pointers point here instead of null.
    // Color is always BLACK. Simplifies boundary checks.
    private final RBNode NIL = new RBNode(0);

    private RBNode root;
    private int size;

    public RedBlackServiceImpl() {
        NIL.color = Color.BLACK;
        root = NIL;
    }

    // -------------------------------------------------------------------------
    // INSERT
    // Red-Black rules:
    //   1. Every node is RED or BLACK
    //   2. Root is always BLACK
    //   3. No two consecutive RED nodes (RED node's parent must be BLACK)
    //   4. Every path from root to NIL has the same number of BLACK nodes
    //
    // Insert as BST (new node = RED), then fix violations via fixInsert()
    // -------------------------------------------------------------------------

    @Override
    public TreeResponse insert(int value) {
        // TODO
        return buildResponse("Inserted " + value);
    }

    private void fixInsert(RBNode node) {
        // TODO: handle uncle RED (recolor) vs uncle BLACK (rotate + recolor)
        // Three cases depending on uncle's color and node's position (left/right child)
    }

    // -------------------------------------------------------------------------
    // ROTATIONS (same logic as AVL, but parent pointer must be updated too)
    // -------------------------------------------------------------------------

    private void rotateLeft(RBNode x) {
        // TODO
    }

    private void rotateRight(RBNode y) {
        // TODO
    }

    // Transplant: replaces subtree rooted at u with subtree rooted at v
    private void transplant(RBNode u, RBNode v) {
        // TODO
    }

    // -------------------------------------------------------------------------
    // DELETE
    // Most complex tree operation. Use the "double-black" fixup approach.
    // -------------------------------------------------------------------------

    @Override
    public TreeResponse delete(int value) {
        // TODO
        return buildResponse("Deleted " + value);
    }

    private void fixDelete(RBNode node) {
        // TODO: handle double-black node via sibling cases (4 cases)
    }

    // -------------------------------------------------------------------------
    // SEARCH
    // -------------------------------------------------------------------------

    @Override
    public TreeResponse search(int value) {
        // TODO
        return buildResponse("Search: " + value);
    }

    // -------------------------------------------------------------------------
    // TRAVERSALS
    // -------------------------------------------------------------------------

    @Override
    public TreeResponse inorder() {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        TreeResponse response = buildResponse("Inorder traversal");
        response.setInorder(result);
        return response;
    }

    private void inorderTraversal(RBNode node, List<Integer> result) {
        // TODO: skip NIL nodes
    }

    @Override
    public TreeResponse preorder() {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(root, result);
        TreeResponse response = buildResponse("Preorder traversal");
        response.setPreorder(result);
        return response;
    }

    private void preorderTraversal(RBNode node, List<Integer> result) {
        // TODO
    }

    @Override
    public TreeResponse postorder() {
        List<Integer> result = new ArrayList<>();
        postorderTraversal(root, result);
        TreeResponse response = buildResponse("Postorder traversal");
        response.setPostorder(result);
        return response;
    }

    private void postorderTraversal(RBNode node, List<Integer> result) {
        // TODO
    }

    @Override
    public TreeResponse levelorder() {
        // TODO: BFS — skip NIL nodes when adding to result
        List<Integer> result = new ArrayList<>();
        TreeResponse response = buildResponse("Level-order traversal");
        response.setLevelorder(result);
        return response;
    }

    // -------------------------------------------------------------------------
    // STATE & CLEAR
    // -------------------------------------------------------------------------

    @Override
    public TreeResponse getState() {
        return buildResponse("Current state");
    }

    @Override
    public TreeResponse clear() {
        root = NIL;
        size = 0;
        return buildResponse("Tree cleared");
    }

    // -------------------------------------------------------------------------
    // HELPER
    // -------------------------------------------------------------------------

    private TreeResponse buildResponse(String message) {
        TreeResponse response = new TreeResponse();
        response.setRoot(toResponseNode(root));
        response.setSize(size);
        response.setHeight(computeHeight(root));
        response.setMessage(message);
        return response;
    }

    private TreeNodeResponse toResponseNode(RBNode node) {
        if (node == NIL || node == null) return null;
        TreeNodeResponse res = new TreeNodeResponse();
        res.setValue(node.value);
        res.setColor(node.color.name()); // "RED" or "BLACK"
        res.setLeft(toResponseNode(node.left));
        res.setRight(toResponseNode(node.right));
        return res;
    }

    private int computeHeight(RBNode node) {
        if (node == NIL || node == null) return 0;
        return 1 + Math.max(computeHeight(node.left), computeHeight(node.right));
    }
}
