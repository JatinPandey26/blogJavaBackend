package com.jatin.blog.com.jatin.blog.Payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostResponse {

    List<PostDTO> content;
    Integer pageSize;
    Integer pageNumber;
    String sortByProperty;
    String sortOrder;

}
