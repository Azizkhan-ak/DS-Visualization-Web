package org.example.dsvisualizationweb.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkedListResponse {
    private List<Integer> values;  // ordered values for UI to render
    private int size;
    private String message;        // optional: "Inserted 40", "Value not found", etc.
}
