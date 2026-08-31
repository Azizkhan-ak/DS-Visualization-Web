package org.example.dsvisualizationweb.dtos.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkedListRequest {
    private Integer value;    // value to insert or delete
    private Integer position; // used for insert/delete at position (0-based)
}
