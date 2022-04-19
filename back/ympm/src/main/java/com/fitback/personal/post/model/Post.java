package com.fitback.personal.post.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Getter
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String postName;
    private String postDesc;
    private String postScore;
    private String postImg;
    @CreatedDate
    private LocalDateTime createDate;
    @LastModifiedDate
    private LocalDateTime lastUpdatedDate;

//    @Builder
//    public Post(Long id, String postName, String postDesc, String postScore, String postImg) {
//        this.id = id;
//        this.postName = postName;
//        this.postDesc = postDesc;
//        this.postScore = postScore;
//        this.postImg = postImg;
//    }
}
