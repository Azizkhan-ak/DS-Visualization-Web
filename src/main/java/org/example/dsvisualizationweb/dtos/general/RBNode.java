package org.example.dsvisualizationweb.dtos.general;

/**
 * Node for Red-Black Tree.
 * Adds color and parent pointer — both are essential for RB rotations and fixups.
 * Kept separate from TreeNode so all three fields are typed as RBNode (no casting).
 */
public class RBNode {

    public enum Color { RED, BLACK }

    public int value;
    public RBNode left;
    public RBNode right;
    public RBNode parent;
    public Color color;

    public RBNode(int value) {
        this.value = value;
        this.color = Color.RED; // new nodes are always inserted as RED
    }
}
