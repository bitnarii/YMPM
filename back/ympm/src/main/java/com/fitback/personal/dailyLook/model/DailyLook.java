package com.fitback.personal.dailyLook.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fitback.personal.opinion.model.Opinion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

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
    private int style;          //1: 걸리시 2: 댄디 3: 베이직 4: 보이쉬 5: 아메카지 6: 캐주얼 7: 펑크
    private String filePath;
    private String fileName;
    private String fileOrigin;
    private int category;       //1: 상의 2: 하의 3: 원피스 4: 아우터 5: 신발 6: 패션 잡화
    private String description;
    private int bookmark;

    private String topBrand;
    private String topName;;
    private String bottomBrand;
    private String bottomName;
    private String dressBrand;
    private String dressName;
    private String outerBrand;
    private String outerName;
    private String shoesBrand;
    private String shoesName;
    private String etcBrand;
    private String etcName;

    @OrderBy("desc") //댓글 작성 시, 최근 순으로 볼 수 있도록
    @JsonIgnoreProperties({"dailyLook"}) //무한 참조 방지
    @OneToMany(mappedBy = "dailyLook", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Opinion> opinions;

    @JsonFormat(pattern = "YYYY-MM-dd")
    @CreatedDate
    @Column(nullable = false, updatable = false) //수정되었을 때 날짜 최신화 방지
    private LocalDate createDate;

}
