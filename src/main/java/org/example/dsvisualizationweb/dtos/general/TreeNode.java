package org.example.dsvisualizationweb.dtos.general;

/**
 * Node for plain Binary Tree and Binary Search Tree.
 * No height, no color — just value + left + right.
 */
public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }
}
