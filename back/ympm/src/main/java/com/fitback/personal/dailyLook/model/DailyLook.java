package com.fitback.personal.dailyLook.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fitback.personal.opinion.model.Opinion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class DailyLook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dailyLookName;
    private String style;
    //private String orgFile;
    private String filePath;
    private String fileName;
    private String info;
    private String description;
    private int bookmark;


    @OrderBy("desc") //댓글 작성 시, 최근 순으로 볼 수 있도록
    @JsonIgnoreProperties({"dailyLook"}) //무한 참조 방지
    @OneToMany(mappedBy = "dailyLook", fetch = FetchType.EAGER)
    private List<Opinion> opinions;

    @CreationTimestamp
    private Timestamp createDate;
}
