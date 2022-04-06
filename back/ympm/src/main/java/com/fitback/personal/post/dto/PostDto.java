package com.fitback.personal.post.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PostDto {
    private Long id;
    private String postName;
    private String postDesc;
    private String postScore;
    private String postImg;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdatedDate;

    @Builder
    public PostDto(Long id, String postName, String postDesc, String postScore, String postImg, LocalDateTime createDate, LocalDateTime lastUpdatedDate) {
        this.id = id;
        this.postName = postName;
        this.postDesc = postDesc;
        this.postScore = postScore;
        this.postImg = postImg;
        this.createDate = createDate;
        this.lastUpdatedDate = lastUpdatedDate;
    }
}

