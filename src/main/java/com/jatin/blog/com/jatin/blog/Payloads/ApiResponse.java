package com.jatin.blog.com.jatin.blog.Payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiResponse  {
    private String message;
    private boolean success;
}
