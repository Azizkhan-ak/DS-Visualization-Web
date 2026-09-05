package org.example.dsvisualizationweb.servicesimpls;

import org.example.dsvisualizationweb.dtos.general.AVLNode;
import org.example.dsvisualizationweb.dtos.response.TreeNodeResponse;
import org.example.dsvisualizationweb.dtos.response.TreeResponse;
import org.example.dsvisualizationweb.services.BinaryTreeService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Service("avlService")
@SessionScope
public class AVLServiceImpl implements BinaryTreeService {

    private AVLNode root;
    private int size;

    // -------------------------------------------------------------------------
    // INSERT
    // Same as BST insert, but after each recursive call: update height, check
    // balance factor, apply rotation if |balanceFactor| > 1.
    // -------------------------------------------------------------------------

    @Override
    public TreeResponse insert(int value) {
        // TODO
        return buildResponse("Inserted " + value);
    }

    private AVLNode insertNode(AVLNode node, int value) {
        // TODO: BST insert → update height → get balance → rotate if needed
        return node;
    }

    // -------------------------------------------------------------------------
    // ROTATIONS
    // Right rotation: used when left-heavy (balance factor > 1, left child is heavier)
    // Left rotation:  used when right-heavy (balance factor < -1, right child is heavier)
    // Left-Right:  left rotate left child, then right rotate node
    // Right-Left:  right rotate right child, then left rotate node
    // -------------------------------------------------------------------------

    private AVLNode rotateRight(AVLNode y) {
        // TODO
        return y;
    }

    private AVLNode rotateLeft(AVLNode x) {
        // TODO
        return x;
    }

    // -------------------------------------------------------------------------
    // HEIGHT & BALANCE
    // -------------------------------------------------------------------------

    private int height(AVLNode node) {
        return node == null ? 0 : node.height;
    }

    private int balanceFactor(AVLNode node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    private void updateHeight(AVLNode node) {
        // TODO: node.height = 1 + max(height(left), height(right))
    }

    // -------------------------------------------------------------------------
    // DELETE
    // -------------------------------------------------------------------------

    @Override
    public TreeResponse delete(int value) {
        // TODO
        return buildResponse("Deleted " + value);
    }

    private AVLNode deleteNode(AVLNode node, int value) {
        // TODO: BST delete → update height → rebalance
        return node;
    }

    private AVLNode findMin(AVLNode node) {
        // TODO
        return node;
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

    private void inorderTraversal(AVLNode node, List<Integer> result) {
        // TODO
    }

    @Override
    public TreeResponse preorder() {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(root, result);
        TreeResponse response = buildResponse("Preorder traversal");
        response.setPreorder(result);
        return response;
    }

    private void preorderTraversal(AVLNode node, List<Integer> result) {
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

    private void postorderTraversal(AVLNode node, List<Integer> result) {
        // TODO
    }

    @Override
    public TreeResponse levelorder() {
        // TODO: BFS with Queue
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
    // HELPER
    // -------------------------------------------------------------------------

    private TreeResponse buildResponse(String message) {
        TreeResponse response = new TreeResponse();
        response.setRoot(toResponseNode(root));
        response.setSize(size);
        response.setHeight(height(root));
        response.setMessage(message);
        return response;
    }

    private TreeNodeResponse toResponseNode(AVLNode node) {
        if (node == null) return null;
        TreeNodeResponse res = new TreeNodeResponse();
        res.setValue(node.value);
        res.setHeight(node.height);
        res.setBalanceFactor(balanceFactor(node));
        res.setLeft(toResponseNode(node.left));
        res.setRight(toResponseNode(node.right));
        return res;
    }
}
