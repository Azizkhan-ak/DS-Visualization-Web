package org.example.dsvisualizationweb.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Recursive structure — mirrors the actual tree shape.
 * UI uses this to draw nodes and edges exactly as they are in memory.
 *
 * height and balanceFactor are populated by AVL only.
 * color is populated by Red-Black only.
 * BST leaves all three null.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreeNodeResponse {
    private Integer value;
    private TreeNodeResponse left;
    private TreeNodeResponse right;

    // AVL specific
    private Integer height;
    private Integer balanceFactor;

    // Red-Black specific
    private String color; // "RED" or "BLACK"
}
