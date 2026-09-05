package org.example.dsvisualizationweb.servicesimpls;

import org.example.dsvisualizationweb.dtos.general.TreeNode;
import org.example.dsvisualizationweb.dtos.response.TreeNodeResponse;
import org.example.dsvisualizationweb.dtos.response.TreeResponse;
import org.example.dsvisualizationweb.services.BinaryTreeService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Service("bstService")
@SessionScope
public class BSTServiceImpl implements BinaryTreeService {

    private TreeNode root;
    private int size;

    // -------------------------------------------------------------------------
    // INSERT
    // Rule: value < node → go left. value > node → go right. Equal → ignore (no duplicates).
    // -------------------------------------------------------------------------

    @Override
    public TreeResponse insert(int value) {
        // TODO: recursively find correct position and insert
        return buildResponse("Inserted " + value);
    }

    // Recursive helper — returns the (possibly new) root of the subtree
    private TreeNode insertNode(TreeNode node, int value) {
        // TODO
        return node;
    }

    // -------------------------------------------------------------------------
    // DELETE
    // Three cases:
    //   1. Node has no children  → just remove it
    //   2. Node has one child    → replace node with its child
    //   3. Node has two children → replace value with inorder successor (smallest in right subtree), delete successor
    // -------------------------------------------------------------------------

    @Override
    public TreeResponse delete(int value) {
        // TODO
        return buildResponse("Deleted " + value);
    }

    private TreeNode deleteNode(TreeNode node, int value) {
        // TODO
        return node;
    }

    // Find the minimum node in a subtree (used for inorder successor)
    private TreeNode findMin(TreeNode node) {
        // TODO
        return node;
    }

    // -------------------------------------------------------------------------
    // SEARCH
    // -------------------------------------------------------------------------

    @Override
    public TreeResponse search(int value) {
        // TODO: traverse left/right based on comparison, return found/not found
        return buildResponse("Search: " + value);
    }

    private boolean searchNode(TreeNode node, int value) {
        // TODO
        return false;
    }

    // -------------------------------------------------------------------------
    // TRAVERSALS
    // -------------------------------------------------------------------------

    @Override
    public TreeResponse inorder() {
        // TODO: Left → Root → Right (produces sorted output for BST)
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        TreeResponse response = buildResponse("Inorder traversal");
        response.setInorder(result);
        return response;
    }

    private void inorderTraversal(TreeNode node, List<Integer> result) {
        // TODO
    }

    @Override
    public TreeResponse preorder() {
        // TODO: Root → Left → Right
        List<Integer> result = new ArrayList<>();
        preorderTraversal(root, result);
        TreeResponse response = buildResponse("Preorder traversal");
        response.setPreorder(result);
        return response;
    }

    private void preorderTraversal(TreeNode node, List<Integer> result) {
        // TODO
    }

    @Override
    public TreeResponse postorder() {
        // TODO: Left → Right → Root
        List<Integer> result = new ArrayList<>();
        postorderTraversal(root, result);
        TreeResponse response = buildResponse("Postorder traversal");
        response.setPostorder(result);
        return response;
    }

    private void postorderTraversal(TreeNode node, List<Integer> result) {
        // TODO
    }

    @Override
    public TreeResponse levelorder() {
        // TODO: BFS — use a Queue. Poll node, add value, enqueue left and right children.
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
        root = null;
        size = 0;
        return buildResponse("Tree cleared");
    }

    // -------------------------------------------------------------------------
    // HELPER — builds TreeResponse from current tree state
    // -------------------------------------------------------------------------

    private TreeResponse buildResponse(String message) {
        TreeResponse response = new TreeResponse();
        response.setRoot(toResponseNode(root));
        response.setSize(size);
        response.setHeight(computeHeight(root));
        response.setMessage(message);
        return response;
    }

    // Converts the internal TreeNode tree into a TreeNodeResponse tree (for UI)
    private TreeNodeResponse toResponseNode(TreeNode node) {
        if (node == null) return null;
        TreeNodeResponse res = new TreeNodeResponse();
        res.setValue(node.value);
        res.setLeft(toResponseNode(node.left));
        res.setRight(toResponseNode(node.right));
        return res;
    }

    private int computeHeight(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(computeHeight(node.left), computeHeight(node.right));
    }
}
