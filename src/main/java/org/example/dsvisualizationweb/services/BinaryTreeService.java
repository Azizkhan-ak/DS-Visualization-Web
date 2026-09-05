package org.example.dsvisualizationweb.services;

import org.example.dsvisualizationweb.dtos.response.TreeResponse;

public interface BinaryTreeService {

    // --- Modify ---
    TreeResponse insert(int value);
    TreeResponse delete(int value);
    TreeResponse clear();

    // --- Query ---
    TreeResponse search(int value);
    TreeResponse getState();

    // --- Traversals ---
    TreeResponse inorder();
    TreeResponse preorder();
    TreeResponse postorder();
    TreeResponse levelorder();
}
