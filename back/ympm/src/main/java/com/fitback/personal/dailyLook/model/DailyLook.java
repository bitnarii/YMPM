package com.fitback.personal.dailyLook.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fitback.personal.opinion.model.Opinion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
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
    private String style;          //1: 걸리시 2: 댄디 3: 베이직 4: 보이쉬 5: 아메카지 6: 캐주얼 7: 펑크
    private String filePath;
    private String fileName;
    private int category;       //1: 상의 2: 하의 3: 원피스 4: 아우터 5: 신발 6: 패션 잡화
    private String info;
    private String description;
    private int bookmark;


    @OrderBy("desc") //댓글 작성 시, 최근 순으로 볼 수 있도록
    @JsonIgnoreProperties({"dailyLook"}) //무한 참조 방지
    @OneToMany(mappedBy = "dailyLook", fetch = FetchType.EAGER)
    private List<Opinion> opinions;

    @JsonFormat(pattern = "YYYY-MM-dd")
    @CreationTimestamp
    private LocalDate createDate;

}
