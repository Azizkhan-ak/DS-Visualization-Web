package org.example.dsvisualizationweb.dtos.general;

/**
 * Node for AVL Tree.
 * Adds height field — needed to compute balance factor and trigger rotations.
 * Kept separate from TreeNode so left/right are typed as AVLNode (no casting).
 */
public class AVLNode {
    public int value;
    public AVLNode left;
    public AVLNode right;
    public int height; // height of subtree rooted at this node

    public AVLNode(int value) {
        this.value = value;
        this.height = 1; // new node is a leaf — height starts at 1
    }
}
