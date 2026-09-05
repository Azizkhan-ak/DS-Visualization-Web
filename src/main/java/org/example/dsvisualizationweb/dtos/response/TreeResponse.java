package org.example.dsvisualizationweb.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreeResponse {
    private TreeNodeResponse root;   // full tree structure — UI renders this
    private int size;
    private int height;
    private String message;

    // Flat traversal lists — populated only when a traversal endpoint is called
    private List<Integer> inorder;
    private List<Integer> preorder;
    private List<Integer> postorder;
    private List<Integer> levelorder;
}
